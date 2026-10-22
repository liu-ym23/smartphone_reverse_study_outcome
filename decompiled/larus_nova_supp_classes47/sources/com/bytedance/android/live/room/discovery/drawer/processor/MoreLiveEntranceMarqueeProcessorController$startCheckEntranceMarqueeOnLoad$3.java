package com.bytedance.android.live.room.discovery.drawer.processor;

import android.os.SystemClock;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {0, 1, 2, 2, 3, 3, 4, 5}, l = {135, 141, 142, 150, 152, 156, 158}, m = "invokeSuspend", n = {"$this$launch", "startTime", "result", "startTime", "result", "remainedTime", "result", "cancelDelayTime"}, s = {"L$0", "J$0", "L$0", "J$0", "L$0", "J$0", "L$0", "J$0"})
public final class MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map $extraQueryMap;
    final /* synthetic */ Ref.LongRef $gapTime;
    final /* synthetic */ long $marqueeDelayTime;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MoreLiveEntranceMarqueeProcessorController this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$1", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $result;
        int label;
        final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 this$0;

        public AnonymousClass1(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass1(this.this$0, this.$result, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r4);
            d.a("checkEntranceMarqueeOnLoad onGetLiveEntranceInfo");
            MoreLiveMarqueeProcessorContext r5 = this.this$0.this$0.f;
            com.bytedance.android.live.base.model.moreliveentrance.b r0 = (com.bytedance.android.live.base.model.moreliveentrance.b) this.$result.element;
            if (r0 == null) goto L7;
            Intrinsics.checkNotNullParameter(r5.g, "<set-?>");
            Unit r1 = Unit.INSTANCE;
        L8:
            r5.m = r0;
            return Unit.INSTANCE;
        L7:
            r0 = null;
            goto L8
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$2", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $result;
        int label;
        final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 this$0;

        public AnonymousClass2(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$result = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass2(this.this$0, this.$result, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MoreLiveEntranceMarqueeProcessorController.d(this.this$0.this$0, (com.bytedance.android.live.base.model.moreliveentrance.b) this.$result.element);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$3, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$3", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 this$0;

        public AnonymousClass3(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass3(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MoreLiveEntranceMarqueeProcessorController.c(this.this$0.this$0);
            d.a("checkEntranceMarqueeOnLoad forwardToDefaultStyle");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3(MoreLiveEntranceMarqueeProcessorController r1, long r2, Ref.LongRef r4, Map r5, Continuation r6) {
        this.this$0 = r1;
        this.$marqueeDelayTime = r2;
        this.$gapTime = r4;
        this.$extraQueryMap = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Intrinsics.checkNotNullParameter(r10, "completion");
        MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3 r0 = new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3(this.this$0, this.$marqueeDelayTime, this.$gapTime, this.$extraQueryMap, r10);
        r0.L$0 = r9;
        return r0;
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch(this.label) {
            case 0: goto L13;
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        ResultKt.throwOnFailure(r12);
    L45:
        return Unit.INSTANCE;
    L7:
        long r3 = this.J$0;
        ResultKt.throwOnFailure(r12);
    L41:
        d.a("checkEntranceMarqueeOnLoad delay cancelDelayTime: " + r3);
        MainCoroutineDispatcher r13 = Dispatchers.getMain();
        AnonymousClass3 r1 = new AnonymousClass3(this, null);
        this.label = 7;
        if (BuildersKt.withContext(r13, r1, this) != r0) goto L45;
        return r0;
    L8:
        Ref.ObjectRef r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
    L34:
        com.bytedance.android.live.base.model.moreliveentrance.b r14 = (com.bytedance.android.live.base.model.moreliveentrance.b) r2.element;
        if (r14 == null) goto L37;
        Long r15 = Boxing.boxLong(r14.o());
    L38:
        r3 = r15.longValue();
        this.L$0 = null;
        this.J$0 = r3;
        this.label = 6;
        if (DelayKt.delay(r3, this) != r0) goto L41;
        return r0;
    L37:
        r15 = null;
        goto L38
    L9:
        long r4 = this.J$0;
        r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
    L31:
        d.a("checkEntranceMarqueeOnLoad delay remainedTime " + r4);
        MainCoroutineDispatcher r16 = Dispatchers.getMain();
        AnonymousClass2 r5 = new AnonymousClass2(this, r2, null);
        this.L$0 = r2;
        this.label = 5;
        if (BuildersKt.withContext(r16, r5, this) != r0) goto L34;
        return r0;
    L10:
        long r6 = this.J$0;
        r2 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
    L25:
        if (this.this$0.k() == true) goto L45;
        if (((com.bytedance.android.live.base.model.moreliveentrance.b) r2.element) == null) goto L45;
        r4 = this.$gapTime.element - (SystemClock.elapsedRealtime() - r6);
        this.L$0 = r2;
        this.J$0 = r4;
        this.label = 4;
        if (DelayKt.delay(r4, this) != r0) goto L31;
        return r0;
    L11:
        r6 = this.J$0;
        Ref.ObjectRef r7 = (Ref.ObjectRef) this.L$1;
        Ref.ObjectRef r8 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r12);
    L20:
        r7.element = (com.bytedance.android.live.base.model.moreliveentrance.b) r12;
        MainCoroutineDispatcher r17 = Dispatchers.getMain();
        AnonymousClass1 r9 = new AnonymousClass1(this, r8, null);
        this.L$0 = r8;
        this.L$1 = null;
        this.J$0 = r6;
        this.label = 3;
        if (BuildersKt.withContext(r17, r9, this) != r0) goto L23;
        return r0;
    L23:
        r2 = r8;
        goto L25
    L12:
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r12);
    L16:
        d.a("checkEntranceMarqueeOnLoad delay " + (this.$marqueeDelayTime - this.$gapTime.element));
        long r18 = SystemClock.elapsedRealtime();
        Deferred r19 = BuildersKt.async$default(r10, null, null, new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$3$deferredTask$1(this, null), 3, null);
        r7 = new Ref.ObjectRef();
        this.L$0 = r7;
        this.L$1 = r7;
        this.J$0 = r18;
        this.label = 2;
        r12 = r19.await(this);
        if (r12 != r0) goto L19;
        return r0;
    L19:
        r8 = r7;
        r6 = r18;
        goto L20
    L13:
        ResultKt.throwOnFailure(r12);
        r10 = (CoroutineScope) this.L$0;
        d.a("checkEntranceMarqueeOnLoad start");
        long r20 = this.$marqueeDelayTime - this.$gapTime.element;
        this.L$0 = r10;
        this.label = 1;
        if (DelayKt.delay(r20, this) != r0) goto L16;
        return r0;
    L5:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
