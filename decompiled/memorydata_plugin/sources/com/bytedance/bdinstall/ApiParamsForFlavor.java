package com.bytedance.bdinstall;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.bdinstall.loader.AliYunUUIDHandler;
import com.bytedance.bdinstall.oaid.Oaid;
import com.bytedance.bdinstall.util.SensitiveUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
final class ApiParamsForFlavor {
    ApiParamsForFlavor() {
    }

    static void addActiveParams(Context r3, InstallOptions r4, StringBuilder r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4.isTouristMode() == true) goto L15;
        Api.addParams(r5, "build_serial", SensitiveUtils.getSerialNumber(r6, r4));
        if (r4.reportPhoneDetailInfo() == false) goto L15;
        String[] r7 = SensitiveUtils.getSimSerialNumbers(r6, r4);
        if (r7 == null) goto L15;
        if (r7.length <= 0) goto L15;
        String r0 = r7[0];
        int r1 = 1;
    L12:
        if (r1 >= r7.length) goto L14;
        r0 = r0 + "," + r7[r1];
        r1 = r1 + 1;
        goto L12
    L14:
        Api.addParams(r5, "sim_serial_number", r0);
    L15:
        Oaid.instance(r6).getOaidId();
    }

    public static void addCommonParams(boolean r2, Context r3, InstallOptions r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        IBDInstallApi r6 = BDInstall.getInstance(r4.getAidString());
        if (r6 == null) goto L12;
        boolean r7 = r6.getAdIdConfig().enablePrefetchAdId();
        if (r2 == false) goto L13;
        if (r7 == false) goto L14;
        Oaid.instance(r5).init();
        return;
    L14:
        return;
    L13:
        return;
    }

    static void addSstParams(Context r2, Map<String, String> r3, boolean r4, InstallOptions r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
    L12:
        String r8 = AliYunUUIDHandler.inst().getCloudUUID();
        if (TextUtils.isEmpty(r8) == true) goto L15;
        r7.put(Api.KEY_ALIYUN_UUID, r8);
    L15:
        if (r4 == false) goto L25;
        String r9 = Oaid.instance(r6).getOaidId();     // Catch: Throwable -> L20
        if (TextUtils.isEmpty(r9) == true) goto L26;
        r7.put(Oaid.KEY_OAID_ID, r9);     // Catch: Throwable -> L20
        return;
    L26:
        return;
    L20:
        th = move-exception;
        th.printStackTrace();
        return;
    L25:
        return;
    L5:
        if (r5.isTouristMode() == true) goto L12;
        String r0 = SensitiveUtils.getMacAddress(r6, r5);
        if (TextUtils.isEmpty(r0) == true) goto L9;
        r7.put(Api.KEY_MAC_ADDRESS, r0);
    L9:
        String r10 = SensitiveUtils.getDeviceIdWithCache(r6, r5);
        if (Utils.isBadId(r10) == true) goto L12;
        r7.put(Api.KEY_UUID, r10);
        goto L12
    }
}
