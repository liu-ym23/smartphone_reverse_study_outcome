package androidx.activity;

import android.view.View;
import android.view.ViewTreeObserver;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.j;
import kotlinx.coroutines.channels.s;
import kotlinx.coroutines.channels.u;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\u00020\u0002*\b\u0012\u0004\u0012\u00020\u00010\u0000H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/channels/u;", "Landroid/graphics/Rect;", "", "<anonymous>", "(Lkotlinx/coroutines/channels/u;)V"}, k = 3, mv = {1, 8, 0})
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
public final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<u, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    public PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r5, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r10) {
        this.$view = r5;
        super(2, r10);
    }

    public static /* synthetic */ void b(u r5, View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        invokeSuspend$lambda$0(r5, r10, r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public static /* synthetic */ void f(u r5, View r10) {
        invokeSuspend$lambda$1(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void invokeSuspend$lambda$0(u r5, View r10, int r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18) {
        if (r11 != r15) goto L6;
        if (r13 != r17) goto L6;
        if (r12 != r16) goto L6;
        if (r14 != r18) goto L6;
        return;
    L6:
        j r19 = (j) r5;
        r19.g(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r10));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void invokeSuspend$lambda$1(u r5, View r10) {
        j r11 = (j) r5;
        r11.g(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r10));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r11 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(u r5, Continuation<? super Unit> r10) {
        return invoke2(r5, r10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.view.View$OnAttachStateChangeListener, androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L8;
        if (r11 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        final u r12 = (u) this.L$0;
        final View.OnLayoutChangeListener r13 = new g(r12);
        final View r14 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r15 = new h(r12, r14);
        final ?? r16 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r12, r14, r15, r13);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        j r17 = (j) r12;
        r17.g(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r15);
        this.$view.addOnLayoutChangeListener(r13);
    L11:
        this.$view.addOnAttachStateChangeListener(r16);
        final View r18 = this.$view;
        Function0<Unit> r19 = new AnonymousClass1(r18, r15, r13, r16);
        this.label = 1;
        if (s.a(r12, r19, this) != r5) goto L15;
        return r5;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(u r5, Continuation<? super Unit> r10) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
