package com.bytedance.ai.uiu;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$performUIOperations$4", f = "UIUContextManager.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
final class UIUContextManager$performUIOperations$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ WebView $targetWebView;
    final /* synthetic */ List<u5.a> $uiOperations;
    Object L$0;
    Object L$1;
    int label;

    public static final class a<T> implements ValueCallback {
        public final /* synthetic */ Continuation<Boolean> a;

        public a(SafeContinuation r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            String r11 = (String) r10;
            Continuation<Boolean> r0 = this.a;
            Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L5
            Object r12 = Result.constructor-impl(Boolean.valueOf(Boolean.parseBoolean(r11)));     // Catch: Throwable -> L5
        L7:
            Boolean r13 = Boolean.FALSE;
            if (Result.isFailure-impl(r12) == false) goto L10;
            r12 = r13;
        L10:
            r0.resumeWith(Result.constructor-impl(r12));
            return;
        L5:
            th = move-exception;
            Result.Companion r14 = Result.Companion;
            r12 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public UIUContextManager$performUIOperations$4(WebView r1, List<u5.a> r10, Continuation<? super UIUContextManager$performUIOperations$4> r11) {
        this.$targetWebView = r1;
        this.$uiOperations = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UIUContextManager$performUIOperations$4(this.$targetWebView, this.$uiOperations, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        List r0 = (List) this.L$1;
        WebView r12 = (WebView) this.L$0;
        ResultKt.throwOnFailure(r10);
    L22:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        WebView r13 = this.$targetWebView;
        List<u5.a> r14 = this.$uiOperations;
        this.L$0 = r13;
        this.L$1 = r14;
        this.label = 1;
        SafeContinuation r15 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        if (r13 != null) goto L23;
        com.bytedance.ai.utils.g.a.d(com.bytedance.ai.uiu.a.b, "Target WebView is null when perform ui operations");
        Result.Companion r16 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
    L23:
        Lazy r17 = com.bytedance.ai.applet.base.gson.e.a;     // Catch: Exception -> L15
        String r18 = com.bytedance.ai.applet.base.gson.e.c(new u5.b(r14));     // Catch: Exception -> L15
        if (r13 == null) goto L17;
        r13.evaluateJavascript("performUiOperations('" + r18 + "');", new a(r15));     // Catch: Exception -> L15
    L17:
        r10 = r15.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L20;
        DebugProbesKt.probeCoroutineSuspended(this);
    L20:
        if (r10 != r1) goto L22;
        return r1;
    L15:
        e = move-exception;
        com.bytedance.ai.utils.g.a.d(com.bytedance.ai.uiu.a.b, "Evaluate js for uiOperations:" + r14 + ", e:" + e);
        Result.Companion r19 = Result.Companion;
        r15.resumeWith(Result.constructor-impl(Boxing.boxBoolean(false)));
        goto L17
    }
}
