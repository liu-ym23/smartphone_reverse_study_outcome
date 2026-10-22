package com.ss.android.cert.aliyun;

import android.content.Context;
import android.text.TextUtils;
import com.alipay.face.api.ZIMFacade;
import com.alipay.face.api.ZIMFacadeBuilder;
import com.alipay.face.api.ZIMResponse;
import com.dtf.face.api.DTResponse;
import com.ss.android.cert.manager.CertManager;
import com.ss.android.cert.manager.api.IAliyunCert;
import com.ss.android.cert.manager.callback.CertCallback;
import com.ss.android.cert.manager.constants.ErrorConstant;
import com.ss.android.cert.manager.utils.net.CertResponse;
import face.security.device.api.FaceSecDevice;
import face.security.device.api.FaceSecSession;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public class AliyunCertImpl implements IAliyunCert {
    protected static final String CERT_ID_KEY = "certifyId";
    protected static final String USE_MSG_BOX_KEY = "useMsgBox";
    private volatile boolean setup;
    private boolean startup;

    public static /* synthetic */ boolean a(AliyunCertImpl r0, CertCallback r1, ZIMResponse r2) {
        return r0.lambda$doFaceLiveness$0(r1, r2);
    }

    @Override // com.ss.android.cert.manager.api.IPlugin
    public boolean installPlugin(Context r1) {
        return true;
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public JSONObject getSession() {
        JSONObject r0 = new JSONObject();
        FaceSecSession r1 = FaceSecDevice.a.a();
        if (r1 != null) goto L7;
    L5:
        return r0;
    L7:
        r0.put("code", r1.a);     // Catch: JSONException -> L6
        r0.put("session", r1.b);     // Catch: JSONException -> L6
        goto L5
    }

    public AliyunCertImpl() {
        CertManager.getInstance().registerAliyunCert(this);
    }

    private JSONObject parseResponse(ZIMResponse r4) {
        JSONObject r0 = new JSONObject();
        if (r4 != null) goto L7;
    L5:
        return r0;
    L7:
        r0.put("code", ((DTResponse) r4).code);     // Catch: JSONException -> L6
        r0.put("reason", ((DTResponse) r4).reason);     // Catch: JSONException -> L6
        r0.put("msg", ((DTResponse) r4).msg);     // Catch: JSONException -> L6
        r0.put("deviceToken", ((DTResponse) r4).deviceToken);     // Catch: JSONException -> L6
        r0.put("videoFilePath", ((DTResponse) r4).videoFilePath);     // Catch: JSONException -> L6
        goto L5
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public String getMetaInfos(Context r1) {
        init(r1);
        return ZIMFacade.getMetaInfos(r1);
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public void init(Context r2) {
        if (this.setup == false) goto L5;
        return;
    L5:
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.setup == false) goto L10;
        monitor-exit(this);     // Catch: Throwable -> L13
        return;
    L10:
        ZIMFacade.install(r2);     // Catch: Throwable -> L13
        this.setup = true;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    }

    private /* synthetic */ boolean lambda$doFaceLiveness$0(CertCallback r6, ZIMResponse r7) {
        boolean r0 = false;
        this.startup = false;
        JSONObject r1 = parseResponse(r7);
        if (r7 != null) goto L5;
    L7:
        if (r0 == false) goto L9;
        CertResponse r8 = new CertResponse(true, r1);
    L13:
        r6.callback(r8);
        return true;
    L9:
        CertResponse r2 = new CertResponse(ErrorConstant.Client.ERROR_FACE_LIVE_FAIL);
        if (r7 == null) goto L12;
        r2.detailErrorCode = ((DTResponse) r7).code;
        r2.detailErrorMsg = ((DTResponse) r7).reason;
    L12:
        r8 = r2;
        goto L13
    L5:
        if (((DTResponse) r7).code != 1000) goto L7;
        r0 = true;
        goto L7
    }

    @Override // com.ss.android.cert.manager.api.IAliyunCert
    public void doFaceLiveness(Context r5, Map<String, String> r6, CertCallback r7) {
        if (r6 != null) goto L6;
        r7.callback(new CertResponse(ErrorConstant.Client.ERROR_UNKNOWN));
        return;
    L6:
        if (this.startup == false) goto L9;
        r7.callback(new CertResponse(ErrorConstant.Client.ERROR_CERT_IS_START));
        return;
    L9:
        String r0 = r6.remove(CERT_ID_KEY);
        boolean r1 = TextUtils.equals(r6.remove(USE_MSG_BOX_KEY), "true");
        HashMap r2 = new HashMap();
        if (r6.size() <= 0) goto L12;
        r2.putAll(r6);
    L12:
        ZIMFacade r8 = ZIMFacadeBuilder.create(r5);
        r8.setCustomUIConfig(0, "{\"guideConfig\": {\"loadingPageColor\": \"#00ffffff\"}}");
        r8.verify(r0, r1, r2, new a(this, r7));
        this.startup = true;
    }
}
