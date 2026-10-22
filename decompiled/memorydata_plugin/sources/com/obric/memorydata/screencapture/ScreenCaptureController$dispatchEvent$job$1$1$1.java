package com.obric.memorydata.screencapture;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.ViewTreeNode;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.obric.memorydata.sdk.screencapture.rule.ViewTreeOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.screencapture.ScreenCaptureController$dispatchEvent$job$1$1$1", f = "ScreenCaptureController.kt", i = {}, l = {519}, m = "invokeSuspend", n = {}, s = {})
final class ScreenCaptureController$dispatchEvent$job$1$1$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> $relativeReactions;
    final /* synthetic */ Object $screenshot;
    final /* synthetic */ Ref.ObjectRef<Map<ScreenshotOption, Object>> $screenshotOptionMap;
    final /* synthetic */ Map<ViewTreeOption, List<ViewTreeNode>> $viewTreeMap;
    int label;
    final /* synthetic */ d this$0;

    ScreenCaptureController$dispatchEvent$job$1$1$1(d r3, Map<ScreenEventReaction, ? extends com.obric.memorydata.sdk.screencapture.d> r4, Object r5, Ref.ObjectRef<Map<ScreenshotOption, Object>> r6, Map<ViewTreeOption, ? extends List<ViewTreeNode>> r7, Continuation<? super ScreenCaptureController$dispatchEvent$job$1$1$1> r8) {
        Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Map<ViewTreeOption, List<ViewTreeNode>> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        this.$relativeReactions = r9;
        this.$screenshot = r5;
        this.$screenshotOptionMap = r6;
        this.$viewTreeMap = r10;
        super(1, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r10) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ScreenCaptureController$dispatchEvent$job$1$1$1(this.this$0, this.$relativeReactions, this.$screenshot, this.$screenshotOptionMap, this.$viewTreeMap, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((ScreenCaptureController$dispatchEvent$job$1$1$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), ScreenCaptureController$dispatchEvent$job$1$1$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L13:
        d.a(this.this$0, null);
    L15:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "onTimeout " + d.d(this.this$0), false, 4, null);
        d.a(this.this$0, null);
        d.a(this.this$0, null);
        if (d.d(this.this$0) == null) goto L15;
        d r5 = this.this$0;
        ScreenTouchEvent r14 = d.d(r5);
        Intrinsics.checkNotNull(r14);
        ScreenEvent r6 = (ScreenEvent) ZeusTransformUtils.preCheckCast(r14, ScreenEvent.class, "com.obric.memorydata.plugin");
        Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> r7 = this.$relativeReactions;
        Object r8 = this.$screenshot;
        Map r9 = (Map) ZeusTransformUtils.preCheckCast(this.$screenshotOptionMap.element, Map.class, "com.obric.memorydata.plugin");
        Map<ViewTreeOption, List<ViewTreeNode>> r10 = this.$viewTreeMap;
        Continuation r11 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (d.a(r5, r6, r7, r8, r9, r10, r11) != r0) goto L13;
        return r0;
    }
}
