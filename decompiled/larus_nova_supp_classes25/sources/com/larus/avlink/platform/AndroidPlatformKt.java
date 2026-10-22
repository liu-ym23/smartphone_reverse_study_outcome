package com.larus.avlink.platform;

import com.larus.avlink.plugins.b5;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.IConversationRepoService$a;
import com.larus.im.internal.audio.u;
import com.larus.im.internal.d;
import com.larus.im.internal.utils.x;
import com.larus.voicecall.api.bean.SessionConfResponse;
import com.larus.voicecall.api.bean.TtsParams;
import gd9.o;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import ouc.v;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class AndroidPlatformKt {
    public static final void a() {
        int r0 = com.larus.im.a.a;
        o r1 = d.a;
        u.c.getClass();
        x r2 = x.a;
    }

    public static final b5 c(String r4) {
        String r0 = "";
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L8
        v r2 = xt7.d.b;     // Catch: Throwable -> L8
        if (r4 != null) goto L6;
        r4 = "";
    L6:
        Object r5 = Result.constructor-impl(r2.c(juc.v.a(((ouc.a) r2).b, Reflection.getOrCreateKotlinClass(SessionConfResponse.class)), r4));     // Catch: Throwable -> L8
    L10:
        b5 r3 = null;
        if (Result.isFailure-impl(r5) == false) goto L13;
        r5 = null;
    L13:
        SessionConfResponse r6 = (SessionConfResponse) r5;
        if (r6 == null) goto L33;
        r3 = new b5();
        String r7 = r6.getConversationId();
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r3.b = r7;
        String r8 = r6.getBotId();
        if (r8 != null) goto L21;
        r8 = "";
    L21:
        Intrinsics.checkNotNullParameter(r8, "<set-?>");
        r3.a = r8;
        TtsParams r9 = r6.getTtsParams();
        if (r9 == null) goto L25;
        String r10 = r9.getStyleId();
        if (r10 == null) goto L25;
    L26:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r3.c = r10;
        TtsParams r11 = r6.getTtsParams();
        if (r11 == null) goto L32;
        String r12 = r11.getAudioMetrics();
        if (r12 == null) goto L32;
        r0 = r12;
    L32:
        Intrinsics.checkNotNullParameter(r0, "<set-?>");
        r3.d = r0;
    L25:
        r10 = "";
    L33:
        return r3;
    L8:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L10
    }

    public static final Object b(String r9, Continuation<? super e> r10) {
        if ((r10 instanceof AndroidPlatformKt$getConversation$1) == false) goto L7;
        AndroidPlatformKt$getConversation$1 r0 = (AndroidPlatformKt$getConversation$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        AndroidPlatformKt$getConversation$1 r5 = r0;
        Object r11 = r5.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r5.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        ResultKt.throwOnFailure(r11);
    L36:
        return r11;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        IConversationRepoService r12 = (IConversationRepoService) r5.L$1;
        String r6 = (String) r5.L$0;
        ResultKt.throwOnFailure(r11);
        IConversationRepoService r7 = r12;
        r9 = r6;
    L20:
        e r13 = (e) r11;
        if (r13 == null) goto L28;
        Integer r8 = r13.f;
        if (r8 == null) goto L28;
        if (r8.intValue() != 1) goto L28;
    L30:
        if (r4 == false) goto L32;
        String r14 = r13.a;
    L33:
        r5.L$0 = null;
        r5.L$1 = null;
        r5.label = 2;
        r11 = IConversationRepoService$a.c(r7, r9, false, r14, r5, 2);
        if (r11 != r2) goto L36;
        return r2;
    L32:
        r14 = null;
    L28:
        r4 = false;
        goto L30
    L16:
        ResultKt.throwOnFailure(r11);
        IConversationRepoService r15 = zh8.a.b;
        r5.L$0 = r9;
        r5.L$1 = r15;
        r5.label = 1;
        Object r16 = r15.a(r9, r5);
        if (r16 != r2) goto L19;
        return r2;
    L19:
        r7 = r15;
        r11 = r16;
    L7:
        r0 = new AndroidPlatformKt$getConversation$1(r10);
        goto L8
    }
}
