package com.larus.uaigc.createpage.component.sendmessage;

import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.chat.model.repo.u1;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.platform.spi.IAIChatUgcAIGCService;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: renamed from: com.larus.uaigc.createpage.component.sendmessage.a$a, reason: collision with other inner class name */
    public static final class C0043a {
    }

    static {
    }

    public a() {
    }

    public static void a(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "conversationId");
        Intrinsics.checkNotNullParameter(r5, "breakReason");
        if (StringsKt.isBlank(r4) == false) goto L6;
        FLogger.a.e("CreationMessageSender", "[breakAllMsg] conversationId is empty");
        return;
    L6:
        FLogger.a.i("CreationMessageSender", "[breakAllMsg] breakReason:" + r5);
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L9
        IAIChatUgcAIGCService.a.n4();     // Catch: Throwable -> L9
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L9
    L11:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L14;
        FLogger.a.e("CreationMessageSender", "[breakAllMsg] tryBreakMusic failed", r8);
    L14:
        b(r4, OmniBreakReason.OmniBreakReason_SEND_NEW_MSG);
        return;
    L9:
        th = move-exception;
        Result.Companion r0 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    }

    public static void b(String r3, OmniBreakReason r4) {
        FLogger.a.i("CreationMessageSender", "[breakAnswer] conversationId:" + r3);
        RepoDispatcherDelegate.b.e().u1().n1(r3, r4);
    }

    public static boolean c(a r13, wc9.e r14, String r15, List r16, String r17, String r18, int r19) {
        if ((r19 & 64) == 0) goto L5;
        String r0 = "creation_send_file_and_txt";
    L6:
        r13.getClass();
        Intrinsics.checkNotNullParameter(r15, "txtScene");
        Intrinsics.checkNotNullParameter(r16, "strategyList");
        Intrinsics.checkNotNullParameter(r0, "breakReason");
        if (((ArrayList) r16).isEmpty() == false) goto L9;
        FLogger.a.e("CreationMessageSender", "[sendFileAndText] strategyList is empty");
    L12:
        return false;
    L9:
        String r5 = r14.a;
        if (StringsKt.isBlank(r5) == false) goto L13;
        FLogger.a.e("CreationMessageSender", "[sendFileAndText] conversationId is empty");
        goto L12
    L13:
        FLogger.a.i("CreationMessageSender", "[sendFileAndText] txtScene:" + r15 + ", fromScene:" + r17);
        a(r5, r0);
        u1.a.e(RepoDispatcherDelegate.b.e().u1(), r14, r5, r15, r16, r17, null, false, com.larus.platform.exp.s.c ^ true, null, 256);
        return true;
    L5:
        r0 = r18;
        goto L6
    }
}
