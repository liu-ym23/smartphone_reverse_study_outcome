package com.ss.android.lark.officesdk.minutes.assembly.recording.common;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingError;
import com.ss.android.lark.officesdk.minutes.api.recording.common.orchestrator.RecordingPriorityStartMode;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingDeviceType;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingSessionState;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.i;
import com.ss.android.lark.picker.base.view.ItemViewType;
import iub.j;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.assembly.recording.common.MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1", f = "MmRecordingCapacityImpl.kt", i = {0, 0, 1}, l = {1307, 1308}, m = "invokeSuspend", n = {"$this$launch", "hardwareRecordingManager", "$this$launch"}, s = {"L$0", "L$1", "L$0"})
final class MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $endedMeetingId;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MmRecordingCapacityImpl this$0;

    public static final class a implements iub.a<j, MmRecordingError> {
        public final /* synthetic */ MmRecordingCapacityImpl a;
        public final /* synthetic */ String b;

        @Override // iub.a
        public final void a(MmRecordingError r4) {
            Intrinsics.checkNotNullParameter(r4, "error");
            lvb.a.b(this.a.d, "[retryOfflineHardwareOnVcEnd] failed, recordingId=" + this.b + ", error=" + r4);
        }

        @Override // iub.a
        public final void onSuccess(j r4) {
            j r5 = r4;
            Intrinsics.checkNotNullParameter(r5, "data");
            lvb.a.e(this.a.d, "[retryOfflineHardwareOnVcEnd] success, recordingId=" + r5.a);
        }

        public a(MmRecordingCapacityImpl r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1(MmRecordingCapacityImpl r1, String r2, Continuation<? super MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1> r3) {
        this.this$0 = r1;
        this.$endedMeetingId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1 r0 = new MmRecordingCapacityImpl$retryOfflineHardwareOnVcEnd$1(this.this$0, this.$endedMeetingId, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        int r5 = 0;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        CoroutineScope r2 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L30:
        com.ss.android.lark.officesdk.minutes.service.recording.hardware.e r15 = (com.ss.android.lark.officesdk.minutes.service.recording.hardware.e) r14;
        if (r15 != null) goto L38;
        String r16 = this.this$0.d;
        StringBuilder r3 = new StringBuilder("[retryOfflineHardwareOnVcEnd] skip, no active hardware session, endedMeetingIdLen=");
        String r4 = this.$endedMeetingId;
        if (r4 == null) goto L35;
        r5 = r4.length();
    L35:
        r3.append(r5);
        lvb.a.e(r16, r3.toString());
        return Unit.INSTANCE;
    L38:
        if (r15.g == RecordingPriorityStartMode.BACKGROUND) goto L42;
        lvb.a.e(this.this$0.d, "[retryOfflineHardwareOnVcEnd] skip, startMode=" + r15.g + ", session=" + r15);
        return Unit.INSTANCE;
    L42:
        if (r15.c == HardwareRecordingDeviceType.LIBERTY_D1204) goto L46;
        lvb.a.e(this.this$0.d, "[retryOfflineHardwareOnVcEnd] skip, deviceType=" + r15.c + ", session=" + r15);
        return Unit.INSTANCE;
    L46:
        if (r15.e == HardwareRecordingSessionState.RECORDING) goto L49;
        lvb.a.e(this.this$0.d, "[retryOfflineHardwareOnVcEnd] skip, state=" + r15.e + ", session=" + r15);
        return Unit.INSTANCE;
    L49:
        String r6 = r15.f;
        if ((!StringsKt.isBlank(r6)) == true) goto L53;
        r6 = null;
    L53:
        if (r6 != null) goto L56;
        lvb.a.h(this.this$0.d, "[retryOfflineHardwareOnVcEnd] skip, recordingId is empty, session=" + r15);
        return Unit.INSTANCE;
    L56:
        String r17 = this.this$0.d;
        StringBuilder r7 = new StringBuilder("[retryOfflineHardwareOnVcEnd] retryCreateRecording, recordingId=");
        r7.append(r6);
        r7.append(", endedMeetingIdLen=");
        String r8 = this.$endedMeetingId;
        if (r8 == null) goto L59;
        r5 = r8.length();
    L59:
        r7.append(r5);
        lvb.a.e(r17, r7.toString());
        MmRecordingCapacityImpl r18 = this.this$0;
        r18.ud(r6, null, new a(r18, r6));
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        i r9 = (i) this.L$1;
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L27:
        this.L$0 = r10;
        this.L$1 = null;
        this.label = 2;
        r14 = r9.a(this);
        if (r14 != r0) goto L30;
        return r0;
    L10:
        ResultKt.throwOnFailure(r14);
        r10 = (CoroutineScope) this.L$0;
        r9 = this.this$0.i().L();
        Long r19 = Long.valueOf(this.this$0.i().L().i());
        if (r19.longValue() <= 0) goto L13;
        boolean r11 = true;
    L14:
        if (r11 == true) goto L17;
        r19 = null;
    L17:
        if (r19 == null) goto L19;
        long r12 = r19.longValue();
    L20:
        long r13 = r12 + 500;
        String r110 = this.this$0.d;
        StringBuilder r111 = new StringBuilder("[retryOfflineHardwareOnVcEnd] delay retry, delayMs=");
        r111.append(r13);
        r111.append(", endedMeetingIdLen=");
        String r112 = this.$endedMeetingId;
        if (r112 == null) goto L23;
        int r113 = r112.length();
    L24:
        r111.append(r113);
        lvb.a.e(r110, r111.toString());
        this.L$0 = r10;
        this.L$1 = r9;
        this.label = 1;
        if (DelayKt.delay(r13, this) != r0) goto L27;
        return r0;
    L23:
        r113 = 0;
        goto L24
    L19:
        r12 = 2000;
        goto L20
    L13:
        r11 = false;
        goto L14
    }
}
