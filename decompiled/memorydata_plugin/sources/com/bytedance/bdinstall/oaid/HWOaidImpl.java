package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.bdinstall.util.Singleton;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes.dex */
final class HWOaidImpl implements OaidApi {
    private static final String ACTION = "com.uodis.opendevice.OPENIDS_SERVICE";
    private static final String HWID = "com.huawei.hwid";
    private static final Singleton<Boolean> support = null;

    static class HWOaid extends OaidApi.Result {
        long versionCode;

        HWOaid() {
            this.versionCode = 0;
        }
    }

    static {
        support = new AnonymousClass1();
    }

    HWOaidImpl() {
    }

    private static int getHwIdVersionCode(Context r2) {
        PackageInfo r3 = ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin")).getPackageManager().getPackageInfo(HWID, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r3 == null) goto L12;
        return r3.versionCode;
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    static boolean isSupport(Context r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return false;
    L6:
        return ((Boolean) ZeusTransformUtils.preCheckCast(support.get(new Object[]{r5}), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    private static Pair<String, Boolean> tryFetchResult(Context r4) {
        return (Pair) ZeusTransformUtils.preCheckCast(new ServiceBlockBinder((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), new Intent(ACTION).setPackage(HWID), new AnonymousClass2()).blockFetchResult(), Pair.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public HWOaid getOaid(Context r5) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        HWOaid r6 = new HWOaid();
        if (Build.VERSION.SDK_INT >= 24) goto L14;
    L10:
        Pair<String, Boolean> r1 = tryFetchResult(r4);
        if (r1 == null) goto L13;
        r6.oaid = (String) ZeusTransformUtils.preCheckCast(r1.first, String.class, "com.obric.memorydata.plugin");
        r6.isTrackLimit = ((Boolean) ZeusTransformUtils.preCheckCast(r1.second, Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
        r6.versionCode = getHwIdVersionCode(r4);
    L13:
        return r6;
    L14:
        String r2 = Settings.Global.getString(r4.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r3 = Settings.Global.getString(r4.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r2) == true) goto L10;
        r6.oaid = r2;     // Catch: Throwable -> L8
        r6.isTrackLimit = Boolean.parseBoolean(r3);     // Catch: Throwable -> L8
        r6.versionCode = 202003021704L;     // Catch: Throwable -> L8
        return r6;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public /* synthetic */ OaidApi.Result getOaid(Context r3) {
        return getOaid((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"));
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r2) {
        return isSupport((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin"));
    }
}
