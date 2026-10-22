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
public final class l implements kfc.a {
    public int a;

    public l() {
        this.a = IntCompanionObject.MIN_VALUE;
    }

    @Override // kfc.a
    public final List<String> b() {
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.opporom")) == false) goto L6;
        if (TextUtils.isEmpty(com.bytedance.push.utils.j.e("ro.build.version.oplusrom")) == true) goto L7;
    L6:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        return Arrays.asList(new String[]{"com.oppo.launcher", "com.android.launcher"});
    L13:
        return Collections.singletonList("com.oppo.launcher");
    L7:
        r0 = false;
        goto L9
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
