package androidx.activity;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import com.ss.bduploader.BDObjectUploader;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.u;
import kotlinx.coroutines.channels.w;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/channels/ProducerScope;", "Landroid/graphics/Rect;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1", f = "PipHintTracker.kt", i = {}, l = {BDObjectUploader.KeyIsEnableGatewayForObject}, m = "invokeSuspend", n = {}, s = {})
final class PipHintTrackerKt$trackPipAnimationHintView$flow$1 extends SuspendLambda implements Function2<w<? super Rect>, Continuation<? super Unit>, Object> {
    final /* synthetic */ View $view;
    private /* synthetic */ Object L$0;
    int label;

    PipHintTrackerKt$trackPipAnimationHintView$flow$1(View r3, Continuation<? super PipHintTrackerKt$trackPipAnimationHintView$flow$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$view = r3;
        super(2, r5);
    }

    /* JADX INFO: renamed from: invokeSuspend$lambda-0, reason: not valid java name */
    private static final void m3invokeSuspend$lambda0(w r2, View r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        w r12 = (w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin");
        if (r4 != r8) goto L7;
        if (r6 != r10) goto L7;
        if (r5 != r9) goto L7;
        if (r7 != r11) goto L7;
        return;
    L7:
        Intrinsics.checkNotNullExpressionValue(r3, BaseSwitches.V);
        r12.mo54trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r3));
    }

    /* JADX INFO: renamed from: invokeSuspend$lambda-1, reason: not valid java name */
    private static final void m4invokeSuspend$lambda1(w r2, View r3) {
        ((w) ZeusTransformUtils.wrapperContextForParams(r2, w.class, "com.obric.memorydata.plugin")).mo54trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(r3));
    }

    /* JADX INFO: renamed from: lambda$llcu4UW9RQF567oBpQ8w-xtBEzE, reason: not valid java name */
    public static /* synthetic */ void m5lambda$llcu4UW9RQF567oBpQ8wxtBEzE(w r0, View r1) {
        m4invokeSuspend$lambda1(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$vDyKVOPn5wDz5cFq-bcnWonShMw, reason: not valid java name */
    public static /* synthetic */ void m6lambda$vDyKVOPn5wDz5cFqbcnWonShMw(w r0, View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        m3invokeSuspend$lambda0(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        PipHintTrackerKt$trackPipAnimationHintView$flow$1 r0 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1(this.$view, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(w<? super Rect> r3, Continuation<? super Unit> r4) {
        return invoke2((w) ZeusTransformUtils.preCheckCast(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(w<? super Rect> r3, Continuation<? super Unit> r4) {
        return ((PipHintTrackerKt$trackPipAnimationHintView$flow$1) ZeusTransformUtils.preCheckCast(create((w) ZeusTransformUtils.wrapperContextForParams(r3, w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PipHintTrackerKt$trackPipAnimationHintView$flow$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.activity.PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1, java.lang.Object] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r9);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        final w r10 = (w) ZeusTransformUtils.preCheckCast(this.L$0, w.class, "com.obric.memorydata.plugin");
        final View.OnLayoutChangeListener r2 = new $$Lambda$PipHintTrackerKt$trackPipAnimationHintView$flow$1$vDyKVOPn5wDz5cFqbcnWonShMw(r10);
        final View r4 = this.$view;
        final ViewTreeObserver.OnScrollChangedListener r5 = new $$Lambda$PipHintTrackerKt$trackPipAnimationHintView$flow$1$llcu4UW9RQF567oBpQ8wxtBEzE(r10, r4);
        final View r6 = this.$view;
        final ?? r7 = new PipHintTrackerKt$trackPipAnimationHintView$flow$1$attachStateChangeListener$1(r10, r6, r5, r2);
        if (Api19Impl.INSTANCE.isAttachedToWindow(this.$view) == false) goto L11;
        r10.mo54trySendJP2dKIU(PipHintTrackerKt.access$trackPipAnimationHintView$positionInWindow(this.$view));
        this.$view.getViewTreeObserver().addOnScrollChangedListener(r5);
        this.$view.addOnLayoutChangeListener(r2);
    L11:
        this.$view.addOnAttachStateChangeListener((View.OnAttachStateChangeListener) ZeusTransformUtils.preCheckCast(r7, View.OnAttachStateChangeListener.class, "com.obric.memorydata.plugin"));
        final View r8 = this.$view;
        Function0 r3 = (Function0) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r8, r5, r2, r7), Function0.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (u.a(r10, r3, r11) != r0) goto L15;
        return r0;
    }
}
