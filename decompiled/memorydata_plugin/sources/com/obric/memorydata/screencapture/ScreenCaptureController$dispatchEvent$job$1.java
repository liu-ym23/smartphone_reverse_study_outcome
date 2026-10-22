package com.obric.memorydata.screencapture;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.sdk.screencapture.ScreenEventReaction;
import com.obric.memorydata.sdk.screencapture.event.ScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.selects.l;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.screencapture.ScreenCaptureController$dispatchEvent$job$1", f = "ScreenCaptureController.kt", i = {0, 1, 2, 3, 4}, l = {488, 493, 501, TypedValues.PositionType.TYPE_PERCENT_HEIGHT, TypedValues.PositionType.TYPE_PERCENT_Y, 624, 541}, m = "invokeSuspend", n = {"screenshotOptionMap", "screenshotOptionMap", "screenshotOptionMap", "screenshotOptionMap", "screenshotOptionMap"}, s = {"L$0", "L$0", "L$0", "L$0", "L$0"})
final class ScreenCaptureController$dispatchEvent$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ ScreenEvent $event;
    final /* synthetic */ boolean $isTapEvent;
    final /* synthetic */ Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> $relativeReactions;
    final /* synthetic */ Object $screenshot;
    final /* synthetic */ Ref.ObjectRef<List<ScreenEventReaction>> $scrollReactions;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ d this$0;

    ScreenCaptureController$dispatchEvent$job$1(Object r3, Ref.ObjectRef<List<ScreenEventReaction>> r4, ScreenEvent r5, d r6, boolean r7, Map<ScreenEventReaction, ? extends com.obric.memorydata.sdk.screencapture.d> r8, Continuation<? super ScreenCaptureController$dispatchEvent$job$1> r9) {
        Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> r10 = (Map) ZeusTransformUtils.wrapperContextForParams(r8, Map.class, "com.obric.memorydata.plugin");
        Continuation r11 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r9, Continuation.class, "com.obric.memorydata.plugin");
        this.$screenshot = r3;
        this.$scrollReactions = r4;
        this.$event = r5;
        this.this$0 = r6;
        this.$isTapEvent = r7;
        this.$relativeReactions = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ScreenCaptureController$dispatchEvent$job$1(this.$screenshot, this.$scrollReactions, this.$event, this.this$0, this.$isTapEvent, this.$relativeReactions, r8), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ScreenCaptureController$dispatchEvent$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ScreenCaptureController$dispatchEvent$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [T, java.util.Map] */
    /* JADX WARN: Type inference failed for: r5v43, types: [T, java.util.Map] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r23) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L12;
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r23);
    L68:
        return Unit.INSTANCE;
    L7:
        Ref.ObjectRef r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        Object r5 = r23;
    L59:
        Map r6 = (Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin");
        if (d.b(this.this$0, this.$event) == false) goto L64;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "pending event " + this.$event, false, 4, null);
        d r13 = this.this$0;
        Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> r14 = this.$relativeReactions;
        Object r15 = this.$screenshot;
        ScreenEvent r12 = this.$event;
        l r11 = new l(getContext());
        kotlinx.coroutines.selects.c r10 = (kotlinx.coroutines.selects.c) ZeusTransformUtils.preCheckCast(r11, kotlinx.coroutines.selects.c.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.selects.b.a(r10, d.c(r13), (Function1) ZeusTransformUtils.preCheckCast(new ScreenCaptureController$dispatchEvent$job$1$1$1(r13, r14, r15, r2, r6, null), Function1.class, "com.obric.memorydata.plugin"));
        r10.a(d.e(r13).j(), (Function2) ZeusTransformUtils.preCheckCast(new ScreenCaptureController$dispatchEvent$job$1$1$2(r13, r12, r14, r15, r2, r6, null), Function2.class, "com.obric.memorydata.plugin"));
        this.L$0 = null;
        this.label = 6;
        if (r11.a(this) != r1) goto L68;
        return r1;
    L64:
        d r7 = this.this$0;
        ScreenEvent r8 = this.$event;
        Map<ScreenEventReaction, com.obric.memorydata.sdk.screencapture.d> r9 = this.$relativeReactions;
        Object r16 = this.$screenshot;
        Map r17 = (Map) ZeusTransformUtils.preCheckCast(r2.element, Map.class, "com.obric.memorydata.plugin");
        Continuation r18 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = null;
        this.label = 7;
        if (d.a(r7, r8, r9, r16, r17, r6, r18) != r1) goto L68;
        return r1;
    L8:
        r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r19 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        Ref.ObjectRef r20 = r19;
        T r21 = r23;
    L55:
        r2.element = r21;
    L23:
        r2 = r20;
    L56:
        d r22 = this.this$0;
        Collection r24 = (Collection) ZeusTransformUtils.preCheckCast(this.$relativeReactions.keySet(), Collection.class, "com.obric.memorydata.plugin");
        ScreenEvent r25 = this.$event;
        Continuation r26 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.L$1 = null;
        this.label = 5;
        r5 = d.a(r22, r24, r25, r26);
        if (r5 != r1) goto L59;
        return r1;
    L9:
        r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r27 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        r20 = r27;
        Object r28 = r23;
    L49:
        T r29 = (Map) ZeusTransformUtils.preCheckCast(r28, Map.class, "com.obric.memorydata.plugin");
    L50:
        r2.element = r29;
        d.a(this.this$0, null);
        goto L23
    L10:
        r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r30 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        r20 = r30;
        T r31 = r23;
    L30:
        r2.element = r31;
        d r3 = this.this$0;
        WeakReference r32 = new WeakReference(r20.element);
    L22:
        d.a(r3, r32);
        goto L23
    L11:
        r2 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$1, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        Ref.ObjectRef r33 = (Ref.ObjectRef) ZeusTransformUtils.preCheckCast(this.L$0, Ref.ObjectRef.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r23);
        r20 = r33;
        T r34 = r23;
    L21:
        r2.element = r34;
        r3 = this.this$0;
        r32 = new WeakReference(r20.element);
        goto L22
    L12:
        ResultKt.throwOnFailure(r23);
        r2 = new Ref.ObjectRef();
        r2.element = MapsKt.emptyMap();
        if (this.$screenshot == null) goto L16;
        r2.element = MapsKt.emptyMap();
        goto L56
    L16:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(this.$scrollReactions.element, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L25;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "generate screenshot cache for event " + this.$event, false, 4, null);
        d r35 = this.this$0;
        Collection r36 = (Collection) ZeusTransformUtils.preCheckCast(this.$scrollReactions.element, Collection.class, "com.obric.memorydata.plugin");
        String r37 = this.$event.getPackageName();
        Continuation r38 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 1;
        Object r39 = d.a(r35, r36, r37, r38);
        if (r39 != r1) goto L20;
        return r1;
    L20:
        r20 = r2;
        r34 = r39;
        goto L21
    L25:
        if (this.$isTapEvent == false) goto L32;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "generate screenshot cache for event " + this.$event, false, 4, null);
        d r40 = this.this$0;
        Collection r41 = (Collection) ZeusTransformUtils.preCheckCast(this.$relativeReactions.keySet(), Collection.class, "com.obric.memorydata.plugin");
        String r42 = this.$event.getPackageName();
        Continuation r43 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 2;
        Object r44 = d.a(r40, r41, r42, r43);
        if (r44 != r1) goto L29;
        return r1;
    L29:
        r20 = r2;
        r31 = r44;
        goto L30
    L32:
        if (d.a(this.this$0, this.$event) == false) goto L51;
        WeakReference r45 = d.b(this.this$0);
        if (r45 == null) goto L36;
        Map r46 = (Map) ZeusTransformUtils.preCheckCast(r45.get(), Map.class, "com.obric.memorydata.plugin");
    L37:
        if (r46 == null) goto L39;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "ScreenCaptureController", "use cache screenshot", false, 4, null);
    L39:
        WeakReference r47 = d.b(this.this$0);
        if (r47 == null) goto L45;
        Map r48 = (Map) ZeusTransformUtils.preCheckCast(r47.get(), Map.class, "com.obric.memorydata.plugin");
        if (r48 == null) goto L45;
        r20 = r2;
        r29 = r48;
    L45:
        d r49 = this.this$0;
        Collection r50 = (Collection) ZeusTransformUtils.preCheckCast(this.$relativeReactions.keySet(), Collection.class, "com.obric.memorydata.plugin");
        String r51 = this.$event.getPackageName();
        Continuation r52 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 3;
        r28 = d.a(r49, r50, r51, r52);
        if (r28 != r1) goto L48;
        return r1;
    L48:
        r20 = r2;
        goto L49
    L36:
        r46 = null;
        goto L37
    L51:
        d r53 = this.this$0;
        Collection r54 = (Collection) ZeusTransformUtils.preCheckCast(this.$relativeReactions.keySet(), Collection.class, "com.obric.memorydata.plugin");
        String r55 = this.$event.getPackageName();
        Continuation r56 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r2;
        this.L$1 = r2;
        this.label = 4;
        Object r57 = d.a(r53, r54, r55, r56);
        if (r57 != r1) goto L54;
        return r1;
    L54:
        r20 = r2;
        r21 = r57;
        goto L55
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
