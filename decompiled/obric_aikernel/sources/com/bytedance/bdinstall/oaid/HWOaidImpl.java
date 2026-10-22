package com.bytedance.bdinstall.oaid;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.bdinstall.util.Singleton;

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

    private static int getHwIdVersionCode(Context r10) {
        PackageInfo r11 = r10.getPackageManager().getPackageInfo(HWID, 0);     // Catch: PackageManager.NameNotFoundException -> L7
        if (r11 == null) goto L12;
        return r11.versionCode;
    L12:
        return 0;
    L7:
        e = move-exception;
        e.printStackTrace();
        return 0;
    }

    static boolean isSupport(Context r10) {
        if (r10 != null) goto L6;
        return false;
    L6:
        return support.get(new Object[]{r10}).booleanValue();
    }

    @Nullable
    private static Pair<String, Boolean> tryFetchResult(Context r10) {
        return (Pair) new ServiceBlockBinder(r10, new Intent(ACTION).setPackage(HWID), new AnonymousClass2()).blockFetchResult();
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public String getName() {
        return "Huawei";
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    @WorkerThread
    public HWOaid getOaid(Context r10) {
        HWOaid r11 = new HWOaid();
        if (Build.VERSION.SDK_INT >= 24) goto L14;
    L10:
        Pair<String, Boolean> r12 = tryFetchResult(r10);
        if (r12 == null) goto L13;
        r11.oaid = (String) r12.first;
        r11.isTrackLimit = ((Boolean) r12.second).booleanValue();
        r11.versionCode = getHwIdVersionCode(r10);
    L13:
        return r11;
    L14:
        String r13 = Settings.Global.getString(r10.getContentResolver(), "pps_oaid");     // Catch: Throwable -> L8
        String r14 = Settings.Global.getString(r10.getContentResolver(), "pps_track_limit");     // Catch: Throwable -> L8
        if (TextUtils.isEmpty(r13) == true) goto L10;
        r11.oaid = r13;     // Catch: Throwable -> L8
        r11.isTrackLimit = Boolean.parseBoolean(r14);     // Catch: Throwable -> L8
        r11.versionCode = 202003021704L;     // Catch: Throwable -> L8
        return r11;
    L8:
        th = move-exception;
        th.printStackTrace();
        goto L10
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    @WorkerThread
    public /* bridge */ /* synthetic */ OaidApi.Result getOaid(Context r10) {
        return getOaid(r10);
    }

    @Override // com.bytedance.bdinstall.oaid.OaidApi
    public boolean support(Context r10) {
        return isSupport(r10);
    }
}
