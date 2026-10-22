package com.bytedance.bdinstall.loader;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.BDInstall;
import com.bytedance.bdinstall.DrLog;
import com.bytedance.bdinstall.InstallOptions;
import com.bytedance.bdinstall.Utils;
import com.bytedance.bdinstall.intf.IAdIdConfig;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdinstall.oaid.OaidMonitor;
import com.bytedance.bdinstall.service.IInstallParameters;
import com.bytedance.bdinstall.service.ServiceManager;
import com.bytedance.bdinstall.storage.CNDeviceParamsProvider;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class SstLoader extends BaseLoader {
    private static final String KEY_ALIYUN_UUID = "aliyun_uuid";
    public static final String KEY_BUILD_SERIAL = "build_serial";
    public static final String KEY_IPV6_LIST = "ipv6_list";
    public static final String KEY_IPV6_TYPE_ANPI = "client_anpi";
    public static final String KEY_IPV6_TYPE_TUN = "client_tun";
    public static final String KEY_MC = "mc";
    public static final String KEY_MEDIA_ID = "miid";
    public static final String KEY_OAID_SUPPORT = "oaid_may_support";
    public static final String KEY_SIM_SERIAL_NUMBER = "sim_serial_number";
    public static final String KEY_UDID = "udid";
    public static final String KEY_UDID_LIST = "udid_list";
    private final Context mApp;
    private final InstallOptions mOptions;

    SstLoader(Context r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        super(true, false);
        this.mApp = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.mOptions = r5;
    }

    private static boolean validMultiIm(JSONArray r5) {
        if (r5 == null) goto L14;
        int r1 = r5.length();
        if (r1 <= 0) goto L19;
        int r2 = 0;
    L7:
        if (r2 >= r1) goto L21;
        JSONObject r3 = r5.optJSONObject(r2);
        if (r3 == null) goto L13;
        if (TextUtils.isEmpty(r3.optString(OaidModel.KEY_ID)) == true) goto L13;
        return true;
    L13:
        r2 = r2 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    public boolean doLoad(JSONObject r8) {
        if (this.mOptions.isTouristMode() == true) goto L36;
        IInstallParameters r0 = (IInstallParameters) ZeusTransformUtils.preCheckCast(ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid())), IInstallParameters.class, "com.obric.memorydata.plugin");
        String[] r1 = null;
        if (ZeusTransformUtils.instanceOf(r0, CNDeviceParamsProvider.class) == false) goto L9;
        String r3 = ((CNDeviceParamsProvider) ZeusTransformUtils.preCheckCast(r0, CNDeviceParamsProvider.class, "com.obric.memorydata.plugin")).getSerialNumber();
        JSONArray r4 = ((CNDeviceParamsProvider) ZeusTransformUtils.preCheckCast(r0, CNDeviceParamsProvider.class, "com.obric.memorydata.plugin")).getUdIdList();
        String r5 = ((CNDeviceParamsProvider) ZeusTransformUtils.preCheckCast(r0, CNDeviceParamsProvider.class, "com.obric.memorydata.plugin")).getUdId();
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r1 = ((CNDeviceParamsProvider) ZeusTransformUtils.preCheckCast(r0, CNDeviceParamsProvider.class, "com.obric.memorydata.plugin")).getSimSerialNumbers();
    L12:
        Utils.putStringIfNotEmpty(r8, "build_serial", r3);
        Utils.putStringIfNotEmpty(r8, "aliyun_uuid", AliYunUUIDHandler.inst().getCloudUUID());
        if (validMultiIm(r4) == false) goto L15;
        r8.put(KEY_UDID_LIST, r4);
    L15:
        String r2 = SensitiveUtils.getMacAddress(this.mApp, this.mOptions);
        if (TextUtils.isEmpty(r2) == true) goto L19;
        r8.put(KEY_MC, r2);
    L19:
        if (this.mOptions.isEnableGetIPV6() == false) goto L25;
        JSONArray r6 = SensitiveUtils.getIPV6Address(this.mApp, this.mOptions);
        if (r6 == null) goto L25;
        if (r6.length() == 0) goto L25;
        r8.put("ipv6_list", r6);
    L25:
        Utils.putStringIfNotEmpty(r8, KEY_UDID, r5);
        Utils.putStringIfNotEmpty(r8, "serial_number", r3);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L34;
        if (r1 == null) goto L34;
        JSONArray r7 = new JSONArray();
        int r9 = r1.length;
        int r10 = 0;
    L30:
        if (r10 >= r9) goto L32;
        r7.put(new JSONObject().put("sim_serial_number", r1[r10]));
        r10 = r10 + 1;
        goto L30
    L32:
        r8.put("sim_serial_number", r7);
    L34:
        if (BDInstall.getBDInstallConfig().isEnableMediaID() == false) goto L36;
        Utils.putStringIfNotEmpty(r8, KEY_MEDIA_ID, SensitiveUtils.getMediaId(this.mOptions));
        goto L36
    L9:
        r3 = SensitiveUtils.getSerialNumber(this.mApp, this.mOptions);
        r4 = SensitiveUtils.getMultiImei(this.mApp, this.mOptions);
        r5 = SensitiveUtils.getDeviceIdWithCache(this.mApp, this.mOptions);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r1 = SensitiveUtils.getSimSerialNumbers(this.mApp, this.mOptions);
    L36:
        OaidMonitor.registerWaitOaid();
        if (this.mOptions.isMainInstance() == false) goto L39;
        IAdIdConfig r11 = BDInstall.getAdIdConfig();
    L40:
        Map<String, String> r12 = Oaid.instance(this.mApp).getOaid(r11.getAdIdWaitTime());
        OaidMonitor.registerWaitFinish();
        DrLog.d("getOaid: returned=" + r12);
        r8.put(KEY_OAID_SUPPORT, Oaid.instance(this.mApp).maySupport());
        if (r12 == null) goto L46;
        r8.put(Oaid.KEY_OAID_ID, new JSONObject(r12));
        return true;
    L46:
        return true;
    L39:
        r11 = BDInstall.getInstance(String.valueOf(this.mOptions.getAid())).getAdIdConfig();
        goto L40
    }
}
