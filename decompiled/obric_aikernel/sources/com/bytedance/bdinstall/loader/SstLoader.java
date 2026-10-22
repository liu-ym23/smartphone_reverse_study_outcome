package com.bytedance.bdinstall.loader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.Nullable;
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

    SstLoader(Context r10, InstallOptions r11) {
        super(true, false);
        this.mApp = r10;
        this.mOptions = r11;
    }

    private static boolean validMultiIm(@Nullable JSONArray r10) {
        if (r10 == null) goto L14;
        int r11 = r10.length();
        if (r11 <= 0) goto L19;
        int r12 = 0;
    L7:
        if (r12 >= r11) goto L21;
        JSONObject r13 = r10.optJSONObject(r12);
        if (r13 == null) goto L13;
        if (TextUtils.isEmpty(r13.optString(OaidModel.KEY_ID)) == true) goto L13;
        return true;
    L13:
        r12 = r12 + 1;
        goto L7
    L21:
        return false;
    L19:
        return false;
    L14:
        return false;
    }

    @Override // com.bytedance.bdinstall.loader.BaseLoader
    @SuppressLint({"HardwareIds"})
    protected boolean doLoad(JSONObject r10) {
        if (this.mOptions.isTouristMode() == true) goto L36;
        IInstallParameters r11 = (IInstallParameters) ServiceManager.getService(IInstallParameters.class, String.valueOf(this.mOptions.getAid()));
        String[] r12 = null;
        if ((r11 instanceof CNDeviceParamsProvider) == false) goto L9;
        CNDeviceParamsProvider r13 = (CNDeviceParamsProvider) r11;
        String r14 = r13.getSerialNumber();
        JSONArray r15 = r13.getUdIdList();
        String r16 = r13.getUdId();
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r12 = r13.getSimSerialNumbers();
    L12:
        Utils.putStringIfNotEmpty(r10, "build_serial", r14);
        Utils.putStringIfNotEmpty(r10, "aliyun_uuid", AliYunUUIDHandler.inst().getCloudUUID());
        if (validMultiIm(r15) == false) goto L15;
        r10.put(KEY_UDID_LIST, r15);
    L15:
        String r17 = SensitiveUtils.getMacAddress(this.mApp, this.mOptions);
        if (TextUtils.isEmpty(r17) == true) goto L19;
        r10.put(KEY_MC, r17);
    L19:
        if (this.mOptions.isEnableGetIPV6() == false) goto L25;
        JSONArray r18 = SensitiveUtils.getIPV6Address(this.mApp, this.mOptions);
        if (r18 == null) goto L25;
        if (r18.length() == 0) goto L25;
        r10.put(KEY_IPV6_LIST, r18);
    L25:
        Utils.putStringIfNotEmpty(r10, KEY_UDID, r16);
        Utils.putStringIfNotEmpty(r10, "serial_number", r14);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L34;
        if (r12 == null) goto L34;
        JSONArray r19 = new JSONArray();
        int r20 = r12.length;
        int r21 = 0;
    L30:
        if (r21 >= r20) goto L32;
        r19.put(new JSONObject().put("sim_serial_number", r12[r21]));
        r21 = r21 + 1;
        goto L30
    L32:
        r10.put("sim_serial_number", r19);
    L34:
        if (this.mOptions.isEnableGetMediaId() == false) goto L36;
        Utils.putStringIfNotEmpty(r10, KEY_MEDIA_ID, SensitiveUtils.getMediaId(this.mOptions));
        goto L36
    L9:
        r14 = SensitiveUtils.getSerialNumber(this.mApp, this.mOptions);
        r15 = SensitiveUtils.getMultiImei(this.mApp, this.mOptions);
        r16 = SensitiveUtils.getDeviceIdWithCache(this.mApp, this.mOptions);
        if (this.mOptions.reportPhoneDetailInfo() == false) goto L12;
        r12 = SensitiveUtils.getSimSerialNumbers(this.mApp, this.mOptions);
    L36:
        OaidMonitor.registerWaitOaid();
        if (this.mOptions.isMainInstance() == false) goto L39;
        IAdIdConfig r22 = BDInstall.getAdIdConfig();
    L40:
        Map<String, String> r23 = Oaid.instance(this.mApp).getOaid(r22.getAdIdWaitTime());
        OaidMonitor.registerWaitFinish();
        DrLog.d("getOaid: returned=" + r23);
        r10.put(KEY_OAID_SUPPORT, Oaid.instance(this.mApp).maySupport());
        if (r23 == null) goto L46;
        r10.put(Oaid.KEY_OAID_ID, new JSONObject(r23));
        return true;
    L46:
        return true;
    L39:
        r22 = BDInstall.getInstance(String.valueOf(this.mOptions.getAid())).getAdIdConfig();
        goto L40
    }
}
