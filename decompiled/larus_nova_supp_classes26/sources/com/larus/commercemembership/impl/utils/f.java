package com.larus.commercemembership.impl.utils;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.router.SmartRouter;
import com.larus.commercemembership.api.ICommerceMembershipService;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.larus.utils.y0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(Uri r4) {
        FLogger.a.i("CommerceMembershipRouterUtils", "srcUri=" + r4);
        if (r4 == null) goto L5;
        String r5 = UriProtector.getQueryParameter(r4, "target_url");
    L7:
        if (r5 != null) goto L9;
    L12:
        boolean r3 = true;
    L13:
        if (r3 == true) goto L21;
        AppHost.Companion r2 = AppHost.a;
        Context r6 = r2.a().getCurrentActivity();
        if (r6 != null) goto L18;
        r6 = r2.getApplication().getApplicationContext();
    L18:
        if (r6 == null) goto L20;
        SmartRouter.buildRoute(r6, r5).d();
        b(r5, null);
    L20:
        return true;
    L21:
        return false;
    L9:
        if (r5.length() == 0) goto L12;
        r3 = false;
        goto L13
    L5:
        r5 = null;
        goto L7
    }

    public static String c(String r2) {
        String r1 = "";
        if (o0.d(r2) == false) goto L7;
        if (r2 == null) goto L6;
        return r2;
    L6:
        return "";
    L7:
        FlowCommonAppCompatActivity r3 = AppHost.a.a().getTopActivity();
        if ((r3 instanceof FlowCommonAppCompatActivity) == false) goto L11;
        r1 = r3.k();
    L11:
        if ((!StringsKt.isBlank(r1)) == true) goto L14;
        r1 = null;
    L14:
        if (r1 != null) goto L18;
        return "chat";
    L18:
        return r1;
    }

    public static void b(String r19, String r20) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        Object r1 = Result.constructor-impl(y0.j(r19));     // Catch: Throwable -> L4
    L6:
        String r2 = null;
        if (Result.isFailure-impl(r1) == false) goto L9;
        r1 = null;
    L9:
        Uri r3 = (Uri) r1;
        if (r3 != null) goto L12;
        return;
    L12:
        String r4 = UriProtector.getQueryParameter(r3, "enter_method");
        String r5 = UriProtector.getQueryParameter(r3, "current_page");
        if (r4 == null) goto L45;
        String r6 = "setting";
        switch(r4.hashCode()) {
            case -649911245: goto L37;
            case -311699068: goto L34;
            case -162773265: goto L30;
            case 1415264338: goto L27;
            case 1535397397: goto L24;
            case 1931825336: goto L21;
            case 1985941072: goto L18;
            default: goto L45;
        };
    L18:
        if (r4.equals("setting") == false) goto L45;
    L47:
        ICommerceMembershipService.a.getClass();
        ICommerceMembershipService r7 = ICommerceMembershipService.a.a();
        if (r7 == null) goto L50;
        uz8.c r8 = r7.z(r19);
    L51:
        int r9 = e.a;
        if (r8 == null) goto L54;
        String r10 = r8.b;
    L55:
        if (r8 == null) goto L57;
        String r11 = r8.c;
    L58:
        if (r8 == null) goto L60;
        String r12 = r8.d;
    L61:
        if (r8 == null) goto L63;
        String r13 = r8.e;
    L64:
        if (r8 == null) goto L66;
        String r14 = r8.f;
    L67:
        if (r8 == null) goto L69;
        String r15 = r8.g;
    L70:
        if (r8 == null) goto L72;
        String r16 = r8.h;
    L73:
        if (r8 == null) goto L75;
        String r17 = r8.i;
    L76:
        if (r8 == null) goto L78;
        String r18 = r8.j;
    L79:
        if (r8 == null) goto L81;
        String r110 = r8.k;
    L82:
        if (r8 == null) goto L84;
        String r111 = r8.l;
    L85:
        if (r8 == null) goto L87;
        r2 = r8.m;
    L87:
        e.a(r4, r6, r10, r11, r12, r13, r14, r15, r16, r17, r18, r110, r111, r2, r20, 212992);
        return;
    L84:
        r111 = null;
        goto L85
    L81:
        r110 = null;
        goto L82
    L78:
        r18 = null;
        goto L79
    L75:
        r17 = null;
        goto L76
    L72:
        r16 = null;
        goto L73
    L69:
        r15 = null;
        goto L70
    L66:
        r14 = null;
        goto L67
    L63:
        r13 = null;
        goto L64
    L60:
        r12 = null;
        goto L61
    L57:
        r11 = null;
        goto L58
    L54:
        r10 = null;
        goto L55
    L50:
        r8 = null;
        goto L51
    L21:
        if (r4.equals("creation_chat") == false) goto L45;
    L44:
        r5 = "chat";
    L46:
        r6 = r5;
        goto L47
    L24:
        if (r4.equals("setting_answer_mode") == true) goto L47;
    L27:
        if (r4.equals("in_app_push") == false) goto L45;
    L40:
        if (o0.d(r5) == true) goto L43;
        r5 = null;
    L43:
        if (r5 != null) goto L46;
    L30:
        if (r4.equals("in_app_push_advance_remind") == false) goto L45;
        r5 = c(r5);
        goto L46
    L34:
        if (r4.equals("answer_mode") == true) goto L44;
    L37:
        if (r4.equals("answer_quota_limit") == true) goto L40;
    L45:
        r5 = c(r5);
    L4:
        th = move-exception;
        Result.Companion r21 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }
}
