package com.obric.assistant.util;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.common.apphost.AppHost;
import com.obric.assistant.interaction.api.IAssistantChatWindow;
import com.obric.assistant.interaction.api.IAssistantChatWindowKt;
import kotlin.Result;
import kotlin.ResultKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class r2 {
    public static final t1a.b a() {
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L25
        IAssistantChatWindow r2 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L25
        boolean r3 = false;
        if (r2 != null) goto L6;
    L8:
        if (r3 == true) goto L19;
        FragmentActivity r4 = AppHost.a.a().getCurrentActivity();     // Catch: Throwable -> L25
        if ((r4 instanceof FragmentActivity) == false) goto L12;
        FragmentActivity r5 = r4;     // Catch: Throwable -> L25
    L13:
        if (r5 == null) goto L22;
        FragmentManager r6 = r5.getSupportFragmentManager();     // Catch: Throwable -> L25
        if (r6 == null) goto L22;
        Fragment r7 = r6.findFragmentById(2131373275);     // Catch: Throwable -> L25
        if (r7 == null) goto L22;
        t1a.b r8 = s1a.a.g(r7);     // Catch: Throwable -> L25
    L23:
        Object r9 = Result.constructor-impl(r8);     // Catch: Throwable -> L25
    L28:
        if (Result.isFailure-impl(r9) == true) goto L32;
        r0 = r9;
    L32:
        return (t1a.b) r0;
    L22:
        r8 = null;
        goto L23
    L12:
        r5 = null;
        goto L13
    L19:
        IAssistantChatWindow r10 = IAssistantChatWindowKt.getAssistantChatWindow();     // Catch: Throwable -> L25
        if (r10 == null) goto L22;
        r8 = r10.provideWindowVContext();     // Catch: Throwable -> L25
        goto L23
    L6:
        if (r2.isShowing() != true) goto L8;
        r3 = true;
    L25:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L28
    }
}
