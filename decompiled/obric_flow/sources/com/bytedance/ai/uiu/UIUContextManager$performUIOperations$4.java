package com.bytedance.ai.uiu;

import android.webkit.WebView;
import java.util.List;
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
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$performUIOperations$4", f = "UIUContextManager.kt", i = {}, l = {261}, m = "invokeSuspend", n = {}, s = {})
final class UIUContextManager$performUIOperations$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ WebView f2819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ List f2820c;

    public UIUContextManager$performUIOperations$4(WebView r5, List r10, Continuation r11) {
        this.f2819b = r5;
        this.f2820c = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UIUContextManager$performUIOperations$4(this.f2819b, this.f2820c, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Boolean> r10) {
        WebView r11 = this.f2819b;
        List r12 = this.f2820c;
        return new UIUContextManager$performUIOperations$4(r11, r12, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2818a;
        if (r10 == 0) goto L9;
        if (r10 != 1) goto L8;
        ResultKt.throwOnFailure(r11);
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
        WebView r12 = this.f2819b;
        List r13 = this.f2820c;
        this.f2818a = 1;
        SafeContinuation r14 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        if (r12 != null) goto L30;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r15 = com.bytedance.ai.utils.c.f2846a;
        if (r15 == null) goto L14;
        r15.d("com.bytedance.ai.uiu.c", "Target WebView is null when perform ui operations");
    L14:
        Result.Companion r16 = Result.Companion;
        r14.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
    L30:
        g3.b r17 = new g3.b(r13);     // Catch: Exception -> L19
        Intrinsics.checkNotNullParameter(r17, "value");     // Catch: Exception -> L19
        String r18 = z0.a.a().toJson(r17);     // Catch: Exception -> L19
        if (r12 == null) goto L24;
        r12.evaluateJavascript("performUiOperations('" + r18 + "');", new b(r14, 1));     // Catch: Exception -> L19
    L24:
        Object r19 = r14.getOrThrow();
        if (r19 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        DebugProbesKt.probeCoroutineSuspended(this);
    L27:
        if (r19 != r5) goto L29;
        return r5;
    L29:
        return r19;
    L19:
        e = move-exception;
        String r110 = "Evaluate js for uiOperations:" + r13 + ", e:" + e;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r20 = com.bytedance.ai.utils.c.f2846a;
        if (r20 == null) goto L23;
        r20.d("com.bytedance.ai.uiu.c", r110);
    L23:
        Result.Companion r111 = Result.Companion;
        r14.resumeWith(Result.m124constructorimpl(Boxing.boxBoolean(false)));
        goto L24
    }
}
