package com.obric.assistant.onelogin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemClock;
import com.bytedance.router.c;
import com.bytedance.sdk.account.utils.d;
import com.larus.utils.k0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.reporter.IObricReporter;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.jvm.internal.Intrinsics;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a implements q97.a {
    public static volatile long a;

    static {
    }

    public a() {
    }

    public final boolean b(c r2) {
        if (b.a().b() == true) goto L6;
        return false;
    L6:
        int r0 = k0.a;
        if (r2 == null) goto L11;
        Uri r3 = r2.d;
        if (r3 == null) goto L11;
        String r4 = r3.toString();
    L13:
        return Intrinsics.areEqual(k0.a(r4), "//flow/account_login");
    L11:
        r4 = null;
        goto L13
    }

    public final boolean a(Context r13, c r14) {
        FLogger r0 = FLogger.a;
        r0.i("ObricLoginRouterInterceptor", "onInterceptRoute");
        Activity r2 = d.b();
        if ((r2 instanceof ObricOneLoginActivity) == false) goto L5;
    L58:
        r0.i("ObricLoginRouterInterceptor", "onInterceptRoute, login is in progress, skip start login activity");
        return true;
    L5:
        if ((r2 instanceof ObricOneLoginTransparentActivity) == true) goto L58;
        IObricReporter r3 = (IObricReporter) ServiceManager.get().getService(IObricReporter.class);
        Integer r4 = null;
        if (r3 == null) goto L10;
        String r5 = r3.a();
    L11:
        boolean r6 = Intrinsics.areEqual(r5, "click_desktop_icon");
        if (r6 == true) goto L18;
        long r7 = SystemClock.elapsedRealtime();
        if ((r7 - a) >= 2000) goto L17;
        r0.i("ObricLoginRouterInterceptor", "onInterceptRoute, login is triggered too frequently, skip");
        return true;
    L17:
        a = r7;
    L18:
        if (r13 != null) goto L20;
    L57:
        return true;
    L20:
        if ((r13 instanceof Activity) == false) goto L22;
        Activity r1 = (Activity) r13;
    L24:
        if (r14 != null) goto L26;
    L34:
        if (r1 == null) goto L37;
        if (r4 == null) goto L37;
        boolean r8 = true;
    L38:
        if (r8 == true) goto L44;
        if (r6 == false) goto L41;
    L43:
        Class<ObricOneLoginActivity> r9 = ObricOneLoginActivity.class;
    L45:
        Intent r10 = new Intent(r13, r9);
        if (r14 == null) goto L50;
        Intent r15 = r14.b;
        if (r15 == null) goto L50;
        r10.addFlags(r15.getFlags());
        r10.putExtras(r15);
    L50:
        if (r8 == false) goto L52;
        r10.putExtra("return_login_result", true);
        r10.putExtra("launch_dou_bao_main_bot", false);
    L53:
        if (r1 == null) goto L56;
        if (r4 == null) goto L56;
        r1.startActivityForResult(r10, r4.intValue());
    L56:
        r13.startActivity(r10);
        goto L57
    L52:
        r10.addFlags(276889600);
        goto L53
    L41:
        if (c0.d() == true) goto L43;
    L44:
        r9 = ObricOneLoginTransparentActivity.class;
    L37:
        r8 = false;
        goto L38
    L26:
        if (r14.j == Integer.MIN_VALUE) goto L28;
        boolean r11 = true;
    L29:
        if (r11 == false) goto L31;
        c r12 = r14;
    L32:
        if (r12 == null) goto L34;
        r4 = Integer.valueOf(r12.j);
        goto L34
    L31:
        r12 = null;
        goto L32
    L28:
        r11 = false;
        goto L29
    L22:
        r1 = null;
        goto L24
    L10:
        r5 = null;
        goto L11
    }
}
