package com.bytedance.ai.uiu;

import android.view.View;
import android.webkit.WebView;
import com.bytedance.ai.uiu.objects.ContextSetting;
import com.bytedance.ai.widget.contianer.WidgetContainer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import w0.f;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getPageUIContext$2", f = "UIUContextManager.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
final class UIUContextManager$getPageUIContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w0.e f2797b;

    public UIUContextManager$getPageUIContext$2(w0.e r5, Continuation r10) {
        this.f2797b = r5;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r5, Continuation r10) {
        return new UIUContextManager$getPageUIContext$2(this.f2797b, r10);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super String> r10) {
        w0.e r11 = this.f2797b;
        return new UIUContextManager$getPageUIContext$2(r11, r10).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.f2796a;
        if (r11 == 0) goto L9;
        if (r11 != 1) goto L8;
        ResultKt.throwOnFailure(r10);
        return r10;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        w0.e r12 = this.f2797b;
        this.f2796a = 1;
        SafeContinuation r13 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        if ((r12 instanceof WidgetContainer) == false) goto L15;
        View r14 = ((WidgetContainer) r12).d();
        if ((r14 instanceof WebView) == false) goto L19;
        WebView r15 = (WebView) r14;
    L21:
        if (r15 == null) goto L33;
        ContextSetting[] r16 = ContextSetting.f2831a;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L25
        r15.evaluateJavascript("guiContext('0');", new b(r13, 0));     // Catch: Throwable -> L25
        Object r18 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
    L27:
        Throwable r19 = Result.m127exceptionOrNullimpl(r18);
        if (r19 == null) goto L34;
        String r20 = "Evaluate js for ui context e:" + r19;
        Intrinsics.checkNotNullParameter("com.bytedance.ai.uiu.c", "tag");
        t0.d r21 = com.bytedance.ai.utils.c.f2846a;
        if (r21 == null) goto L32;
        r21.d("com.bytedance.ai.uiu.c", r20);
    L32:
        r13.resumeWith(Result.m124constructorimpl(""));
    L34:
        Object r22 = r13.getOrThrow();
        if (r22 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L37;
        DebugProbesKt.probeCoroutineSuspended(this);
    L37:
        if (r22 != r5) goto L39;
        return r5;
    L39:
        return r22;
    L25:
        th = move-exception;
        Result.Companion r23 = Result.Companion;
        r18 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L27
    L33:
        r13.resumeWith(Result.m124constructorimpl(""));
    L19:
        r15 = null;
        goto L21
    L15:
        if ((r12 instanceof f) == false) goto L19;
        View r24 = r12.d();
        if ((r24 instanceof WebView) == false) goto L19;
        r15 = (WebView) r24;
        goto L21
    }
}
