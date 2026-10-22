package com.ss.android.lark.chat.chatwindow.chat.perload;

import com.larksuite.framework.callback.UIGetDataCallback;
import com.ss.android.lark.chameleon.pluginsystem.plugin.PluginList;
import com.ss.android.lark.chat.core.model.entity.ChatMessageResponse;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class ExtensionKt {
    public static final Object a(c r4, fxa.b r5, Continuation<? super Result<? extends i7b.a>> r6) {
        if ((r6 instanceof ExtensionKt$fetchChatData$1) == false) goto L7;
        ExtensionKt$fetchChatData$1 r0 = (ExtensionKt$fetchChatData$1) r6;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r7 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        ExtensionKt$fetchChatData$1 r8 = (ExtensionKt$fetchChatData$1) r0.L$2;
        c r9 = (c) r0.L$1;
        fxa.b r10 = (fxa.b) r0.L$0;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L24
    L22:
        return Result.constructor-impl((i7b.a) r7);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r7);
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L24
        r0.L$0 = r5;     // Catch: Throwable -> L24
        r0.L$1 = r4;     // Catch: Throwable -> L24
        r0.L$2 = r0;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        final j r12 = new j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L24
        r12.C();     // Catch: Throwable -> L24
        final UIGetDataCallback r13 = new UIGetDataCallback(new ExtensionKt$fetchChatData$2$1$callback$1(r12));     // Catch: Throwable -> L24
        r12.i(new ExtensionKt$fetchChatData$2$1$1(r13));     // Catch: Throwable -> L24
        r4.a(new u3b.b(r5), r13);     // Catch: Throwable -> L24
        r7 = r12.B();     // Catch: Throwable -> L24
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L24
    L20:
        if (r7 != r2) goto L22;
        return r2;
    L24:
        th = move-exception;
        Result.Companion r14 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ExtensionKt$fetchChatData$1(r6);
        goto L8
    }

    public static final Object b(c r4, String r5, int r6, Continuation<? super Result<? extends ChatMessageResponse>> r7) {
        if ((r7 instanceof ExtensionKt$fetchChatWindowData$1) == false) goto L7;
        ExtensionKt$fetchChatWindowData$1 r0 = (ExtensionKt$fetchChatWindowData$1) r7;
        int r1 = r0.label;
        if ((r1 & PluginList.LEVEL_NOT_SET) == 0) goto L7;
        r0.label = r1 - PluginList.LEVEL_NOT_SET;
    L8:
        Object r8 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        ExtensionKt$fetchChatWindowData$1 r9 = (ExtensionKt$fetchChatWindowData$1) r0.L$2;
        c r10 = (c) r0.L$1;
        String r11 = (String) r0.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L24
    L22:
        return Result.constructor-impl((ChatMessageResponse) r8);
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r8);
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L24
        r0.L$0 = r5;     // Catch: Throwable -> L24
        r0.L$1 = r4;     // Catch: Throwable -> L24
        r0.L$2 = r0;     // Catch: Throwable -> L24
        r0.I$0 = r6;     // Catch: Throwable -> L24
        r0.label = 1;     // Catch: Throwable -> L24
        final j r13 = new j(IntrinsicsKt.intercepted(r0), 1);     // Catch: Throwable -> L24
        r13.C();     // Catch: Throwable -> L24
        final UIGetDataCallback r14 = new UIGetDataCallback(new ExtensionKt$fetchChatWindowData$2$1$callback$1(r13));     // Catch: Throwable -> L24
        r13.i(new ExtensionKt$fetchChatWindowData$2$1$1(r14));     // Catch: Throwable -> L24
        r4.a(new u3b.c(r5, r6), r14);     // Catch: Throwable -> L24
        r8 = r13.B();     // Catch: Throwable -> L24
        if (r8 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(r0);     // Catch: Throwable -> L24
    L20:
        if (r8 != r2) goto L22;
        return r2;
    L24:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        return Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        r0 = new ExtensionKt$fetchChatWindowData$1(r7);
        goto L8
    }
}
