package lfc;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.newmedia.redbadge.RedBadgerException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.IntCompanionObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class m extends kfc.b {
    public int a;

    @Override // kfc.a
    public final List<String> b() {
        String r0 = Build.MANUFACTURER;
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.opporom")) == false) goto L7;
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.oplusrom")) == true) goto L8;
    L7:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L19;
        if (TextUtils.isEmpty(r0) == true) goto L17;
        if (r0.contains("realme") == true) goto L19;
    L17:
        return Collections.singletonList("com.oppo.launcher");
    L19:
        return Arrays.asList(new String[]{"com.oppo.launcher", "com.android.launcher"});
    L8:
        r1 = false;
        goto L10
    }

    public m() {
        this.a = IntCompanionObject.MIN_VALUE;
    }

    @Override // kfc.b
    public final int d(Context r5, ComponentName r6) {
        if (r5 == null) goto L11;
        if (r6 == null) goto L11;
        Bundle r7 = new Bundle();
        r7.putString("app_badge_packageName", r5.getPackageName());
        Bundle r8 = r5.getContentResolver().call(UriProtector.parse("content://com.android.badge/badge"), "getAppBadgeCount", null, r7);
        if (r8 != null) goto L9;
        return -1;
    L9:
        return r8.getInt("app_badge_count");
    L11:
        com.bytedance.push.utils.f.b("OPPOHomeBader", "args is null");
        return -1;
    }

    @Override // kfc.a
    public final void a(Context r10, ComponentName r11, int r12) throws RedBadgerException {
        if (r10 == null) goto L29;
        if (r11 != null) goto L7;
        return;
    L7:
        if (this.a <= 99) goto L10;
        if (r12 <= 99) goto L10;
        return;
    L10:
        this.a = r12;
        Intent r3 = new Intent("com.oppo.unsettledevent");
        r3.putExtra("pakeageName", r11.getPackageName());
        r3.putExtra("number", r12);
        r3.putExtra("upgradeNumber", r12);
        if (nfc.a.a(r10, r3) == true) goto L32;
        Bundle r13 = new Bundle();     // Catch: Throwable -> L27
        r13.putInt("app_badge_count", r12);     // Catch: Throwable -> L27
        r10.getContentResolver().call(UriProtector.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, r13);     // Catch: Throwable -> L27
        if (r12 <= 0) goto L24;
        return;
    L24:
        if (Build.VERSION.SDK_INT >= 23) goto L37;
        Bundle r14 = (Bundle) r13.clone();     // Catch: Throwable -> L27
        r14.putInt("app_badge_count", -1);     // Catch: Throwable -> L27
        r10.getContentResolver().call(UriProtector.parse("content://com.android.badge/badge"), "setAppBadgeCount", null, r14);     // Catch: Throwable -> L27
        return;
    L37:
        return;
    L28:
        throw new RedBadgerException("unable to resolve intent: " + r3.toString());
    L32:
        r10.sendBroadcast(r3);     // Catch: Throwable -> L18
        if (r12 <= 0) goto L15;
        return;
    L15:
        if (Build.VERSION.SDK_INT >= 23) goto L35;
        Intent r15 = (Intent) r3.clone();     // Catch: Throwable -> L18
        r15.putExtra("number", -1);     // Catch: Throwable -> L18
        r15.putExtra("upgradeNumber", -1);     // Catch: Throwable -> L18
        r10.sendBroadcast(r15);     // Catch: Throwable -> L18
        return;
    L35:
        return;
    L18:
        th = move-exception;
        th.printStackTrace();
        throw new RedBadgerException(th.getMessage());
    }
}
