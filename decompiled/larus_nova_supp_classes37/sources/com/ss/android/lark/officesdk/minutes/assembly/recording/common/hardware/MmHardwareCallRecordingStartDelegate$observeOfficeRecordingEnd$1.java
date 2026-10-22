package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.EndRecordingReason;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.statemachine.c;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow.g;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt__LimitKt$take$;
import kotlinx.coroutines.flow.d1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware.MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1", f = "MmHardwareCallRecordingStartDelegate.kt", i = {}, l = {193}, m = "invokeSuspend", n = {}, s = {})
final class MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $recordingId;
    final /* synthetic */ MmRecordingSession $recordingSession;
    final /* synthetic */ d1<Object> $repoEventFlow;
    int label;
    final /* synthetic */ MmHardwareCallRecordingStartDelegate this$0;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ MmHardwareCallRecordingStartDelegate a;
        public final /* synthetic */ String b;
        public final /* synthetic */ MmRecordingSession c;

        public a(MmHardwareCallRecordingStartDelegate r1, String r2, MmRecordingSession r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final Object a(Continuation r7) {
            if ((r7 instanceof MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1) == false) goto L7;
            MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1 r0 = (MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1) r7;
            int r1 = r0.label;
            if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
            r0.label = r1 - Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            EndRecordingReason r4 = (EndRecordingReason) r0.L$0;
            ResultKt.throwOnFailure(r8);
        L29:
            lvb.a.e(this.a.d, "[observeOfficeRecordingEnd] recordingId=" + this.b + ", endReason=" + r4 + ", result=" + ((com.ss.android.lark.officesdk.minutes.service.recording.hardware.a) r8));
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            MmHardwareCallRecordingStartDelegate r9 = this.a;
            int r5 = MmHardwareCallRecordingStartDelegate.g;
            ((MmHardwareOfflineRecordingForegroundRetryController) r9.f.getValue()).b(this.b);
            c r10 = this.c.g();
            if ((r10 instanceof c.b) == false) goto L17;
            c.b r11 = (c.b) r10;
        L18:
            if (r11 == null) goto L20;
            EndRecordingReason r12 = r11.c;
        L22:
            if (r12 != EndRecordingReason.HARDWARE_STOP_RECORD) goto L25;
            lvb.a.e(this.a.d, "[observeOfficeRecordingEnd] skip hardware-origin stop, recordingId=" + this.b);
            return Unit.INSTANCE;
        L25:
            i r6 = this.a.c.L();
            String r13 = this.b;
            r0.L$0 = r12;
            r0.label = 1;
            Object r14 = r6.g(r13, r0);
            if (r14 != r2) goto L28;
            return r2;
        L28:
            r4 = r12;
            r8 = r14;
            goto L29
        L20:
            r12 = null;
            goto L22
        L17:
            r11 = null;
        L7:
            r0 = new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$1$emit$1(this, r7);
            goto L8
        }

        public final /* bridge */ /* synthetic */ Object emit(Object r1, Continuation r2) {
            g r3 = (g) r1;
            return a(r2);
        }
    }

    public MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1(d1<Object> r1, MmHardwareCallRecordingStartDelegate r2, String r3, MmRecordingSession r4, Continuation<? super MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1> r5) {
        this.$repoEventFlow = r1;
        this.this$0 = r2;
        this.$recordingId = r3;
        this.$recordingSession = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1(this.$repoEventFlow, this.this$0, this.$recordingId, this.$recordingSession, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r7);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r7);
        final d1<Object> r8 = this.$repoEventFlow;
        FlowKt__LimitKt$take$.inlined.unsafeFlow.1 r9 = new FlowKt__LimitKt$take$.inlined.unsafeFlow.1(new MmHardwareCallRecordingStartDelegate$observeOfficeRecordingEnd$1$invokeSuspend$$inlined$filterIsInstance$1(r8));
        a r2 = new a(this.this$0, this.$recordingId, this.$recordingSession);
        this.label = 1;
        if (r9.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
