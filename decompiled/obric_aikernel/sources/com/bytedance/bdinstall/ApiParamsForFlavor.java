package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.AliYunUUIDHandler;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.SensitiveUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ApiParamsForFlavor {
    ApiParamsForFlavor() {
    }

    static void addActiveParams(Context r10, InstallOptions r11, StringBuilder r12) {
        if (r11.isTouristMode() == true) goto L15;
        Api.addParams(r12, "build_serial", SensitiveUtils.getSerialNumber(r10, r11));
        if (r11.reportPhoneDetailInfo() == false) goto L15;
        String[] r13 = SensitiveUtils.getSimSerialNumbers(r10, r11);
        if (r13 == null) goto L15;
        if (r13.length <= 0) goto L15;
        String r14 = r13[0];
        int r15 = 1;
    L12:
        if (r15 >= r13.length) goto L14;
        r14 = r14 + "," + r13[r15];
        r15 = r15 + 1;
        goto L12
    L14:
        Api.addParams(r12, "sim_serial_number", r14);
    L15:
        Oaid.instance(r10).getOaidId();
    }

    public static void addCommonParams(boolean r10, Context r11, InstallOptions r12) {
        if (r12 != null) goto L4;
        return;
    L4:
        IBDInstallApi r13 = BDInstall.getInstance(r12.getAidString());
        if (r13 == null) goto L11;
        boolean r14 = r13.getAdIdConfig().enablePrefetchAdId();
        if (r10 == false) goto L12;
        if (r14 == false) goto L13;
        Oaid.instance(r11).init();
        return;
    L13:
        return;
    L12:
        return;
    }

    static void addSstParams(Context r10, Map<String, String> r11, boolean r12, InstallOptions r13) {
        if (r13 != null) goto L4;
    L11:
        String r14 = AliYunUUIDHandler.inst().getCloudUUID();
        if (TextUtils.isEmpty(r14) == true) goto L14;
        r11.put(Api.KEY_ALIYUN_UUID, r14);
    L14:
        if (r12 == false) goto L24;
        String r15 = Oaid.instance(r10).getOaidId();     // Catch: Throwable -> L19
        if (TextUtils.isEmpty(r15) == true) goto L25;
        r11.put(Oaid.KEY_OAID_ID, r15);     // Catch: Throwable -> L19
        return;
    L25:
        return;
    L19:
        th = move-exception;
        th.printStackTrace();
        return;
    L24:
        return;
    L4:
        if (r13.isTouristMode() == true) goto L11;
        String r16 = SensitiveUtils.getMacAddress(r10, r13);
        if (TextUtils.isEmpty(r16) == true) goto L8;
        r11.put(Api.KEY_MAC_ADDRESS, r16);
    L8:
        String r17 = SensitiveUtils.getDeviceIdWithCache(r10, r13);
        if (Utils.isBadId(r17) == true) goto L11;
        r11.put(Api.KEY_UUID, r17);
        goto L11
    }
}
