package com.bytedance.bdinstall;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.bdinstall.event.VerifyMonitor;
import com.bytedance.bdinstall.loader.DeviceManager;
import com.bytedance.bdinstall.util.EventUtils;
import com.bytedance.bdinstall.util.RequestIdGenerator;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
class VerifyTicketWorker extends BaseWorker {
    private final InstallOptions mConfig;
    private final Env mEnv;
    private final DeviceManager mManager;
    private final Map<String, String> mTicketData;
    private final VerifyMonitor verifyMonitor;

    VerifyTicketWorker(InstallOptions r4, Env r5, DeviceManager r6, Map<String, String> r7) {
        Map<String, String> r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        super((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
        this.mConfig = r4;
        this.mEnv = r5;
        this.mManager = r6;
        this.mTicketData = r8;
        this.verifyMonitor = EventUtils.getInstance().getVerifyMonitor(r4.getAid());
    }

    private JSONObject buildBody() {
        JSONObject r5 = new JSONObject();
        JSONObject r6 = new JSONObject();
        JSONObject r7 = new JSONObject();
        JSONObject r9 = this.mManager.getConstHeader();     // Catch: JSONException -> L6
        r6.put("device_id", r9.optString("device_id"));     // Catch: JSONException -> L6
        r6.put(Api.KEY_TICKET_INSTALL_ID, r9.optString("install_id"));     // Catch: JSONException -> L6
        r6.put("app_id", r9.optString("aid"));     // Catch: JSONException -> L6
        r6.put("app_version", r9.optString("app_version"));     // Catch: JSONException -> L6
        r6.put("sdk_version", r9.optString("sdk_version"));     // Catch: JSONException -> L6
        r7.put(Api.KEY_ENCRYPT_DID, r9.optString(Api.KEY_ENCRYPT_DID));     // Catch: JSONException -> L6
        r7.put(Api.KEY_ENCRYPT_IID, r9.optString(Api.KEY_ENCRYPT_IID));     // Catch: JSONException -> L6
        r5.put(Api.KEY_BASIC_CONTEXT, r6);     // Catch: JSONException -> L6
        r5.put(Api.KEY_SECURITY_CONTEXT, r7);     // Catch: JSONException -> L6
        DrLog.d("TicketGuard# [before verify] doVerify request body is " + r5);
        return r5;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void doEventTrack() {
        Map<String, Long> r0 = this.mManager.getTicketGuardHelper().getTimestamp();
        if (r0.size() <= 0) goto L5;
        this.verifyMonitor.setTimestampMap(r0);
    L5:
        EventUtils.onVerifyResult(this.mConfig);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean doWork() {
        boolean r0 = false;
        JSONObject r4 = buildBody();     // Catch: Exception -> L14
        String r3 = Uri.parse(this.mEnv.getConfig().getVerifyUri()).buildUpon().appendQueryParameter("req_id", RequestIdGenerator.getRequestId()).build().toString();     // Catch: Exception -> L14
        if (TextUtils.isEmpty(r4.optString("device_id")) == false) goto L6;
    L8:
        boolean r7 = false;
    L9:
        r0 = Api.verify(this.mConfig.getNetworkClient(), BDInstall.getBDInstallConfig().getNetworkClientWrapper(), r3, r4, this.mConfig.encryptAndCompress(), this.mConfig.getEncryptor(), r7, this.mManager.getTicketGuardHelper().consumerTicketDataHeader(r3, (String) ZeusTransformUtils.preCheckCast(this.mTicketData.get(Api.KEY_TS_SIGN), String.class, "com.obric.memorydata.plugin"), this.mManager.getConstHeader().optString(Api.KEY_ENCRYPT_IID), false));     // Catch: Exception -> L14
        if (r0 == false) goto L12;
        stop();     // Catch: Exception -> L14
    L12:
        DrLog.d("TicketGuard# [after verify] response result " + r0);     // Catch: Exception -> L14
    L16:
        return r0;
    L6:
        if (TextUtils.isEmpty(r4.optString("install_id")) == true) goto L8;
        r7 = true;
    L14:
        e = move-exception;
        e.printStackTrace();
        goto L16
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public String getName() {
        return "ticketGuard";
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public long[] getRetryIntervals() {
        return Register.RETRY_DIFF;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needListenNetChange() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public boolean needNet() {
        return true;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public long nextInterval() {
        return 0;
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void onResult(boolean r1) {
        this.verifyMonitor.setSuccess(!r1 ? 1 : 0);
    }

    @Override // com.bytedance.bdinstall.BaseWorker
    public void updateFailCount(int r1) {
        this.verifyMonitor.setFailCount(r1);
    }
}
