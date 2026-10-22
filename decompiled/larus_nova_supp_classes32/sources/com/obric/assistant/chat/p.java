package com.obric.assistant.chat;

import android.app.Activity;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.chat.d4;
import com.larus.bmhome.chat.h4;
import com.larus.bmhome.chat.j4;
import com.larus.common.apphost.AppHost;
import com.larus.home.api.main.HomeService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import xe8.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class p {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static t1a.b b() {
        if (HomeService.a.o() == true) goto L13;
        d4 r0 = AppHost.a.a().getCurrentActivity();
        if ((r0 instanceof d4) == false) goto L8;
        d4 r1 = r0;
    L9:
        if (r1 == null) goto L12;
        return r1.getVContext();
    L12:
        return null;
    L8:
        r1 = null;
        goto L9
    L13:
        return c();
    }

    public static t1a.b c() {
        IAssistantChatWindow r0 = IAssistantChatWindowKt.getAssistantChatWindow();
        if (r0 == null) goto L7;
        boolean r2 = true;
        if (r0.isShowing() != true) goto L7;
    L8:
        if (r2 == false) goto L12;
        return r0.provideWindowVContext();
    L12:
        return a(AppHost.a.a().getCurrentActivity());
    L7:
        r2 = false;
        goto L8
    }

    public static t1a.b a(Activity r6) {
        Object r1 = null;
        if (r6 != null) goto L33;
        return null;
    L33:
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L25
        HomeService r3 = HomeService.a;     // Catch: Throwable -> L25
        if (r3.o() == false) goto L8;
        a r4 = r3.v(r6);     // Catch: Throwable -> L25
        if (r4 == null) goto L17;
        t1a.b r5 = r4.WF();     // Catch: Throwable -> L25
    L18:
        if (r5 == null) goto L20;
    L22:
        t1a.b r7 = r5;
    L23:
        Object r8 = Result.constructor-impl(r7);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r8) == true) goto L32;
        r1 = r8;
    L32:
        return (t1a.b) r1;
    L20:
        if (e(r6) == false) goto L22;
        FLogger.a.i("ObricChatPageCompat", "query chat context: no selected chat, host=".concat(r6.getClass().getSimpleName()));     // Catch: Throwable -> L25
        goto L22
    L17:
        r5 = null;
        goto L18
    L8:
        if ((r6 instanceof d4) == false) goto L10;
        d4 r9 = (d4) r6;     // Catch: Throwable -> L25
    L11:
        if (r9 == null) goto L13;
        r7 = r9.getVContext();     // Catch: Throwable -> L25
        goto L23
    L13:
        r7 = null;
        goto L23
    L10:
        r9 = null;
    L25:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }

    public static boolean d(Activity r1) {
        if ((r1 instanceof d4) == false) goto L5;
    L10:
        return true;
    L5:
        if (HomeService.a.o() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r1 instanceof j4) == false) goto L9;
        goto L9
    }

    public static boolean e(Activity r1) {
        if ((r1 instanceof h4) == false) goto L5;
    L10:
        return true;
    L5:
        if (HomeService.a.o() == true) goto L7;
    L9:
        return false;
    L7:
        if ((r1 instanceof j4) == false) goto L9;
        goto L9
    }

    public static boolean f(FragmentActivity r3, com.larus.bmhome.chat.component.cvs.y r4) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        if (AppHost.a.a().getCurrentActivity() == r3) goto L5;
        return false;
    L5:
        HomeService r0 = HomeService.a;
        if (r0.o() == false) goto L8;
        a r5 = r0.v(r3);
        if (r4 == null) goto L19;
        if (r5 == null) goto L15;
        t1a.b r6 = r5.WF();
        if (r6 == null) goto L15;
        com.larus.bmhome.chat.component.cvs.y r7 = (com.larus.bmhome.chat.component.cvs.y) r6.getAbility(com.larus.bmhome.chat.component.cvs.y.class);
    L16:
        if (r7 != r4) goto L20;
        return true;
    L20:
        return false;
    L15:
        r7 = null;
        goto L16
    L19:
        return false;
    L8:
        return r3 instanceof h4;
    }
}
