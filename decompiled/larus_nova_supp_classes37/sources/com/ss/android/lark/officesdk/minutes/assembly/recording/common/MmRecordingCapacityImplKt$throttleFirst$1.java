package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.channels.k;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/channels/ProducerScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImplKt$throttleFirst$1", f = "MmRecordingCapacityImpl.kt", i = {0, 0, 1, 1}, l = {1549, 1444}, m = "invokeSuspend", n = {"$this$channelFlow", "$this$consume$iv$iv", "$this$channelFlow", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$0", "L$1"})
final class MmRecordingCapacityImplKt$throttleFirst$1 extends SuspendLambda implements Function2<k<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Flow<Object> $this_throttleFirst;
    final /* synthetic */ long $windowDuration;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImplKt$throttleFirst$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImplKt$throttleFirst$1$1", f = "MmRecordingCapacityImpl.kt", i = {}, l = {1434}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Channel<Object> $channel;
        final /* synthetic */ Ref.LongRef $lastEmitTime;
        final /* synthetic */ Flow<Object> $this_throttleFirst;
        final /* synthetic */ long $windowDuration;
        int label;

        /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImplKt$throttleFirst$1$1$a */
        public static final class a<T> implements FlowCollector {
            public final /* synthetic */ Ref.LongRef a;
            public final /* synthetic */ long b;
            public final /* synthetic */ Channel<T> c;

            public a(Ref.LongRef r1, long r2, Channel<T> r4) {
                this.a = r1;
                this.b = r2;
                this.c = r4;
            }

            public final Object emit(T r9, Continuation<? super Unit> r10) {
                long r0 = System.currentTimeMillis();
                Ref.LongRef r2 = this.a;
                if ((r0 - r2.element) < this.b) goto L10;
                r2.element = r0;
                Object r11 = this.c.send(r9, r10);
                if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
                return r11;
            L8:
                return Unit.INSTANCE;
            L10:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(Flow<Object> r1, Channel<Object> r2, Ref.LongRef r3, long r4, Continuation<? super AnonymousClass1> r6) {
            this.$this_throttleFirst = r1;
            this.$channel = r2;
            this.$lastEmitTime = r3;
            this.$windowDuration = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            return new AnonymousClass1(this.$this_throttleFirst, this.$channel, this.$lastEmitTime, this.$windowDuration, r9);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r8) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r8);
        L11:
            SendChannel.a.a(this.$channel);
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r8);
            Flow<Object> r9 = this.$this_throttleFirst;
            a r2 = new a(this.$lastEmitTime, this.$windowDuration, this.$channel);
            this.label = 1;
            if (r9.collect(r2, this) != r0) goto L11;
            return r0;
        }
    }

    public MmRecordingCapacityImplKt$throttleFirst$1(Flow<Object> r1, long r2, Continuation<? super MmRecordingCapacityImplKt$throttleFirst$1> r4) {
        this.$this_throttleFirst = r1;
        this.$windowDuration = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        MmRecordingCapacityImplKt$throttleFirst$1 r0 = new MmRecordingCapacityImplKt$throttleFirst$1(this.$this_throttleFirst, this.$windowDuration, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((k) r1, (Continuation) r2);
    }

    public final Object invoke(k<Object> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a2 -> B:19:0x0074). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r19) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        ChannelIterator r3 = (ChannelIterator) this.L$2;
        Channel r6 = (ReceiveChannel) this.L$1;
        k r7 = (k) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L14
        Channel r15 = r6;
        ChannelIterator r8 = r3;
        k r4 = r7;
    L18:
        MmRecordingCapacityImplKt$throttleFirst$1 r9 = this;
    L19:
        r9.L$0 = r4;     // Catch: Throwable -> L32
        r9.L$1 = r15;     // Catch: Throwable -> L32
        r9.L$2 = r8;     // Catch: Throwable -> L32
        r9.label = 1;     // Catch: Throwable -> L32
        Object r10 = r8.hasNext(r9);     // Catch: Throwable -> L32
        if (r10 != r0) goto L22;
        return r0;
    L22:
        MmRecordingCapacityImplKt$throttleFirst$1 r11 = r9;
        k r12 = r4;
        ChannelIterator r5 = r8;
        Channel r13 = r15;
    L24:
        if (((Boolean) r10).booleanValue() == false) goto L29;
        Object r14 = r5.next();     // Catch: Throwable -> L14
        r11.L$0 = r12;     // Catch: Throwable -> L14
        r11.L$1 = r13;     // Catch: Throwable -> L14
        r11.L$2 = r5;     // Catch: Throwable -> L14
        r11.label = 2;     // Catch: Throwable -> L14
        if (r12.send(r14, r11) != r0) goto L28;
        return r0;
    L28:
        r15 = r13;
        r8 = r5;
        r4 = r12;
        r9 = r11;
        goto L19
    L29:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L14
        ChannelsKt.cancelConsumed(r13, null);
        return Unit.INSTANCE;
    L32:
        th = move-exception;
        Throwable r16 = th;
        r13 = r15;
    L38:
        throw r16;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        ChannelsKt.cancelConsumed(r13, r16);
        throw th;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r5 = (ChannelIterator) this.L$2;
        r13 = (ReceiveChannel) this.L$1;
        r12 = (k) this.L$0;
        ResultKt.throwOnFailure(r19);     // Catch: Throwable -> L14
        r10 = r19;
        r11 = this;
        goto L24
    L16:
        ResultKt.throwOnFailure(r19);
        r4 = (k) this.L$0;
        r15 = ChannelKt.Channel$default(-1, null, null, 6, null);
        Ref.LongRef r17 = new Ref.LongRef();
        BuildersKt.launch$default(r4, null, null, new AnonymousClass1(this.$this_throttleFirst, r15, r17, this.$windowDuration, null), 3, null);
        r8 = r15.iterator();     // Catch: Throwable -> L32
    L14:
        th = move-exception;
        r16 = th;
        goto L38
    }
}
