package com.ss.android.lark.router;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.mt.protector.impl.UriProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.di.core.DependencyContainer;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ntb.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static com.ss.android.lark.officesdk.applink.a a() {
        OfficeSDKUserComponent r3 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Exception -> L9
        if (r3 == null) goto L6;
        com.ss.android.lark.officesdk.applink.a r4 = (com.ss.android.lark.officesdk.applink.a) OfficeSDKSPIKtxKt.spiByDwarf(r3, com.ss.android.lark.officesdk.applink.a.class);     // Catch: Exception -> L9
    L7:
        Log.i("OpenUrlUtil", "spi IOfficeSDKAppLinkService, instance: " + r4);     // Catch: Exception -> L9
        return r4;
    L6:
        r4 = null;
    L9:
        e = move-exception;
        Log.w("OpenUrlUtil", "get IOfficeSDKAppLinkService failed", e);
        return null;
    }

    public static boolean b(Context r7, String r8) {
        boolean r0 = false;
        if (r7 == null) goto L66;
        if (r8 == null) goto L66;
        Set<String> r1 = com.ss.android.lark.officesdk.applink.b.a;
        Intrinsics.checkNotNullParameter(r8, "url");
        if (com.ss.android.lark.officesdk.applink.b.a(r8) == null) goto L9;
        boolean r2 = true;
    L11:
        if (r2 == true) goto L67;
        boolean r3 = false;
    L24:
        if (r3 == false) goto L26;
        return true;
    L26:
        Log.i("OpenUrlUtil", "openUrl url:".concat(r8));
        String r4 = UriProtector.parse(r8).getPath();
        if (r4 != null) goto L31;
    L35:
        boolean r5 = false;
    L36:
        if (r5 == false) goto L48;
        com.ss.android.lark.officesdk.applink.a r6 = a();
        if (r6 == null) goto L48;
        if (r6.d9(r7, r8) == true) goto L69;
        Log.i("OpenUrlUtil", "todo appLink canOpen false");
        goto L48
    L69:
        r6.q6(r7, r8);     // Catch: Exception -> L46
        boolean r9 = true;
    L49:
        if (r9 == false) goto L52;
        Log.i("OpenUrlUtil", "appLink intercept");
        return true;
    L52:
        int r10 = d.a;
        a r11 = (a) OfficeSDKManager.getHostGlobalService(a.class);
        if (r11 == null) goto L55;
        r0 = Intrinsics.areEqual(r11.openUrl(r7, r8), Boolean.TRUE);
    L55:
        if (r0 == false) goto L58;
        Log.i("OpenUrlUtil", "inject intercept");
        return true;
    L58:
        UrlDependencyHelper r12 = (UrlDependencyHelper) UrlDependencyHelper.b.getValue();
        r12.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "url");
        Boolean r13 = null;
        if (r12.a != null) goto L61;
        DependencyContainer r14 = DependencyContainer.a;
        r12.a = (p) DependencyContainer.a(p.class, null);
    L61:
        p r15 = r12.a;
        if (r15 == null) goto L65;
        r13 = r15.a();
    L65:
        return Intrinsics.areEqual(r13, Boolean.TRUE);
    L46:
        e = move-exception;
        Log.w("OpenUrlUtil", "open todo appLink failed", e);
    L48:
        r9 = false;
        goto L49
    L31:
        if (StringsKt.startsWith(r4, "/client/todo/", true) != true) goto L35;
        r5 = true;
    L33:
        e = move-exception;
        Log.w("OpenUrlUtil", "parse todo appLink failed", e);
        goto L35
    L67:
        com.ss.android.lark.officesdk.applink.a r16 = a();     // Catch: Exception -> L18
        if (r16 == null) goto L19;
        if (r16.u7(r7, r8) != true) goto L19;
        boolean r17 = true;
    L20:
        Log.i("OpenUrlUtil", "group invite link intercepted, accepted=" + r17);
        if (r17 == true) goto L23;
        new Handler(Looper.getMainLooper()).post(new b(r7));
    L23:
        r3 = true;
    L19:
        r17 = false;
    L18:
        Log.w("OpenUrlUtil", "open group invite link failed");
        goto L19
    L9:
        r2 = false;
    L66:
        return false;
    }
}
