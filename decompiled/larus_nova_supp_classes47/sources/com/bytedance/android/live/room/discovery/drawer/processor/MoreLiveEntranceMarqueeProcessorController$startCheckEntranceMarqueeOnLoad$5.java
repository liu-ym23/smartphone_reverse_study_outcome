package com.bytedance.android.live.room.discovery.drawer.processor;

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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
@DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {0, 1, 2}, l = {173, 175, 179, 181}, m = "invokeSuspend", n = {"entranceInfo", "entranceInfo", "cancelDelayTime"}, s = {"L$0", "L$0", "J$0"})
public final class MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.LongRef $gapTime;
    long J$0;
    Object L$0;
    int label;
    final /* synthetic */ MoreLiveEntranceMarqueeProcessorController this$0;

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5$1", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef $entranceInfo;
        int label;
        final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5 this$0;

        public AnonymousClass1(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5 r1, Ref.ObjectRef r2, Continuation r3) {
            this.this$0 = r1;
            this.$entranceInfo = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            Intrinsics.checkNotNullParameter(r4, "completion");
            return new AnonymousClass1(this.this$0, this.$entranceInfo, r4);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MoreLiveEntranceMarqueeProcessorController.d(this.this$0.this$0, (com.bytedance.android.live.base.model.moreliveentrance.b) this.$entranceInfo.element);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5$2, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 3})
    @DebugMetadata(c = "com.bytedance.android.live.room.discovery.drawer.processor.MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5$2", f = "MoreLiveEntranceMarqueeProcessorController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5 this$0;

        public AnonymousClass2(MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5 r1, Continuation r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            Intrinsics.checkNotNullParameter(r3, "completion");
            return new AnonymousClass2(this.this$0, r3);
        }

        public final Object invoke(Object r1, Object r2) {
            return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r2) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r2);
            MoreLiveEntranceMarqueeProcessorController.c(this.this$0.this$0);
            d.a("checkEntranceMarqueeOnLoad useLocalShowMarquee forwardToDefaultStyle");
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5(MoreLiveEntranceMarqueeProcessorController r1, Ref.LongRef r2, Continuation r3) {
        this.this$0 = r1;
        this.$gapTime = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Intrinsics.checkNotNullParameter(r4, "completion");
        return new MoreLiveEntranceMarqueeProcessorController$startCheckEntranceMarqueeOnLoad$5(this.this$0, this.$gapTime, r4);
    }

    public final Object invoke(Object r1, Object r2) {
        return create(r1, (Continuation) r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L12;
        if (r1 == 3) goto L11;
        if (r1 != 4) goto L10;
        ResultKt.throwOnFailure(r10);
    L35:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        long r3 = this.J$0;
        ResultKt.throwOnFailure(r10);
    L31:
        d.a("checkEntranceMarqueeOnLoad useLocalShowMarquee delay cancelDelayTime:" + r3);
        MainCoroutineDispatcher r12 = Dispatchers.getMain();
        AnonymousClass2 r2 = new AnonymousClass2(this, null);
        this.label = 4;
        if (BuildersKt.withContext(r12, r2, this) != r0) goto L35;
        return r0;
    L12:
        Ref.ObjectRef r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r10);
    L23:
        com.bytedance.android.live.base.model.moreliveentrance.b r13 = (com.bytedance.android.live.base.model.moreliveentrance.b) r4.element;
        if (r13 == null) goto L26;
        Long r14 = Boxing.boxLong(r13.o());
    L27:
        long r5 = r14.longValue();
        this.L$0 = null;
        this.J$0 = r5;
        this.label = 3;
        if (DelayKt.delay(r5, this) != r0) goto L30;
        return r0;
    L30:
        r3 = r5;
        goto L31
    L26:
        r14 = null;
        goto L27
    L13:
        r4 = (Ref.ObjectRef) this.L$0;
        ResultKt.throwOnFailure(r10);
    L20:
        d.a("checkEntranceMarqueeOnLoad useLocalShowMarquee delay gapTime:" + this.$gapTime.element);
        MainCoroutineDispatcher r15 = Dispatchers.getMain();
        AnonymousClass1 r6 = new AnonymousClass1(this, r4, null);
        this.L$0 = r4;
        this.label = 2;
        if (BuildersKt.withContext(r15, r6, this) != r0) goto L23;
        return r0;
    L14:
        ResultKt.throwOnFailure(r10);
        Ref.ObjectRef r16 = new Ref.ObjectRef();
        MoreLiveMarqueeProcessorContext r7 = this.this$0.f;
        Intrinsics.checkNotNullParameter(r7, "$this$tryGetCurrentValidLiveEntranceInfo");
        com.bytedance.android.live.base.model.moreliveentrance.b r8 = r7.m;
        r16.element = r8;
        if (r8 == null) goto L35;
        long r9 = this.$gapTime.element;
        this.L$0 = r16;
        this.label = 1;
        if (DelayKt.delay(r9, this) != r0) goto L19;
        return r0;
    L19:
        r4 = r16;
        goto L20
    }
}
