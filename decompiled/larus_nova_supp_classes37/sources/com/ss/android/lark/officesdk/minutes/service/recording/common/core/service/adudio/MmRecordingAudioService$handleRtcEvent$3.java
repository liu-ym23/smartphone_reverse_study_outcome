package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.nio.ByteBuffer;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$handleRtcEvent$3", f = "MmRecordingAudioService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingAudioService$handleRtcEvent$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ byte[] $data;
    int label;
    final /* synthetic */ MmRecordingAudioService this$0;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$handleRtcEvent$3$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio.MmRecordingAudioService$handleRtcEvent$3$1", f = "MmRecordingAudioService.kt", i = {}, l = {617}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ MmRecordingAudioService this$0;

        public AnonymousClass1(MmRecordingAudioService r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            return new AnonymousClass1(this.this$0, r3);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            MmRecordingSession r5 = this.this$0.a;
            com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.a r2 = com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.b.a.a;
            this.label = 1;
            if (r5.t(r2, this) != r0) goto L12;
            return r0;
        }
    }

    public MmRecordingAudioService$handleRtcEvent$3(MmRecordingAudioService r1, byte[] r2, Continuation<? super MmRecordingAudioService$handleRtcEvent$3> r3) {
        this.this$0 = r1;
        this.$data = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MmRecordingAudioService$handleRtcEvent$3(this.this$0, this.$data, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L37;
        ResultKt.throwOnFailure(r13);
        MmRecordingAudioService r14 = this.this$0;
        int r0 = MmRecordingAudioService.G;
        MmRecordingAudioProcessor r15 = (MmRecordingAudioProcessor) r14.v.getValue();
        ByteBuffer r1 = ByteBuffer.wrap(this.$data);
        r15.getClass();
        Intrinsics.checkNotNullParameter(r1, "audioDataBuffer");
        int r2 = r1.remaining();
        long r3 = 0;
        if (r2 != 0) goto L10;
        if (r15.d() <= 0) goto L23;
        r3 = (r15.j * ((long) 1000)) / ((long) r15.d());
    L23:
        if (r3 < 14340000) goto L26;
        lvb.a.h(this.this$0.e, "exceed max duration, duration:" + r3);
        Boxing.boxBoolean(this.this$0.a.u(new com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.a.k(EndRecordingReason.MAX_LIMIT_TIME)));
    L35:
        return Unit.INSTANCE;
    L26:
        if (r3 < 12540000) goto L30;
        MmRecordingAudioService r4 = this.this$0;
        if (r4.q == true) goto L30;
        r4.q = true;
        BuildersKt.launch$default(r4.g, null, null, new AnonymousClass1(r4, null), 3, null);
    L30:
        MmRecordingAudioService r5 = this.this$0;
        r5.getClass();
        long r6 = r3 / 1000;
        if (r6 == r5.p) goto L35;
        r5.p = r6;
        BuildersKt.launch$default(r5.g, null, null, new MmRecordingAudioService$emitAudioDurationIfNeeded$1(r5, r6, null), 3, null);
        goto L35
    L10:
        if (r2 <= r15.i.remaining()) goto L13;
        lvb.a.h(r15.e, "processAudioFrameData buffer full, force flush. dataSize:" + r2 + ", remaining:" + r15.i.remaining());
        r15.c();
    L13:
        if (r2 > r15.i.remaining()) goto L15;
        r15.i.put(r1);
    L17:
        if (r15.i.position() < r15.d()) goto L19;
        r15.c();
    L19:
        r15.j += (long) r2;
        if (r15.d() <= 0) goto L23;
        r3 = (r15.j * ((long) 1000)) / ((long) r15.d());
        goto L23
    L15:
        lvb.a.b(r15.e, "processAudioFrameData buffer overflow even after flush! Drop frame. dataSize:" + r2 + ", capacity:" + r15.i.capacity());
        goto L17
    L37:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
