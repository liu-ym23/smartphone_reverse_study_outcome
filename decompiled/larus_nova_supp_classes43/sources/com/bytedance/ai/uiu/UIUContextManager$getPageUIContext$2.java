package com.bytedance.ai.uiu;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.bytedance.ai.uiu.objects.ContextSetting;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.uiu.UIUContextManager$getPageUIContext$2", f = "UIUContextManager.kt", i = {}, l = {232}, m = "invokeSuspend", n = {}, s = {})
final class UIUContextManager$getPageUIContext$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ k2.i $aiContainer;
    Object L$0;
    int label;

    public static final class a<T> implements ValueCallback {
        public final /* synthetic */ Continuation<String> a;

        public a(SafeContinuation r1) {
            this.a = r1;
        }

        @Override // android.webkit.ValueCallback
        public final void onReceiveValue(Object r10) {
            this.a.resumeWith(Result.constructor-impl((String) r10));
        }
    }

    public UIUContextManager$getPageUIContext$2(k2.i r1, Continuation<? super UIUContextManager$getPageUIContext$2> r10) {
        this.$aiContainer = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UIUContextManager$getPageUIContext$2(this.$aiContainer, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super String> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        k2.i r0 = (k2.i) this.L$0;
        ResultKt.throwOnFailure(r10);
    L25:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        k2.i r12 = this.$aiContainer;
        this.L$0 = r12;
        this.label = 1;
        SafeContinuation r13 = new SafeContinuation(IntrinsicsKt.intercepted(this));
        WebView r14 = com.bytedance.ai.uiu.a.c(r12);
        if (r14 == null) goto L19;
        ContextSetting r15 = ContextSetting.AUTO_DEFAULT_ALL;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L13
        r14.evaluateJavascript("guiContext('" + r15.ordinal() + "');", new a(r13));     // Catch: Throwable -> L13
        Object r17 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r18 = Result.exceptionOrNull-impl(r17);
        if (r18 == null) goto L18;
        com.bytedance.ai.utils.g.a.d(com.bytedance.ai.uiu.a.b, "Evaluate js for ui context e:" + r18);
        r13.resumeWith(Result.constructor-impl(""));
    L18:
        Result.box-impl(r17);
    L20:
        r10 = r13.getOrThrow();
        if (r10 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L23;
        DebugProbesKt.probeCoroutineSuspended(this);
    L23:
        if (r10 != r1) goto L25;
        return r1;
    L13:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L19:
        r13.resumeWith(Result.constructor-impl(""));
        goto L20
    }
}
