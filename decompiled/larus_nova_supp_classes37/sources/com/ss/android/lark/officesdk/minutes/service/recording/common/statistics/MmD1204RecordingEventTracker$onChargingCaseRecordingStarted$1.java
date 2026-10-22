package com.ss.android.lark.officesdk.minutes.service.recording.common.statistics;

import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.core.MmRecordingCommonParam;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.common.statistics.MmD1204RecordingEventTracker", f = "MmD1204RecordingEventTracker.kt", i = {0, 0, 0}, l = {417}, m = "onChargingCaseRecordingStarted", n = {"hardwareUniqueId", "hardwareDeviceId", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$2"})
final class MmD1204RecordingEventTracker$onChargingCaseRecordingStarted$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ MmD1204RecordingEventTracker this$0;

    public MmD1204RecordingEventTracker$onChargingCaseRecordingStarted$1(MmD1204RecordingEventTracker r1, Continuation<? super MmD1204RecordingEventTracker$onChargingCaseRecordingStarted$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r24) {
        this.result = r24;
        this.label |= Integer.MIN_VALUE;
        MmD1204RecordingEventTracker r0 = this.this$0;
        r0.getClass();
        int r4 = this.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r4 - Integer.MIN_VALUE;
        MmD1204RecordingEventTracker$onChargingCaseRecordingStarted$1 r2 = this;
    L6:
        Object r5 = r2.result;
        Object r6 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r7 = r2.label;
        boolean r8 = true;
        if (r7 == 0) goto L12;
        if (r7 != 1) goto L11;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) r2.L$2;
        String r10 = (String) r2.L$1;
        String r3 = (String) r2.L$0;
        ResultKt.throwOnFailure(r5);
    L26:
        boolean r1 = MmD1204RecordingEventTracker.g(new MmRecordingCommonParam("", r3, true, "FEISHU_HARDWARE_D1204_CASE", "", r0.a.getCurrentUserId(), null, MmRecordingSource.FEISHU_HARDWARE_D1204_CASE, r0.a.getTenantId(), null, null, 1600, null), r3, r10, "offline", "box", false);     // Catch: Throwable -> L23
        StringBuilder r11 = new StringBuilder("[onChargingCaseRecordingStarted] report finished, keyHash=");     // Catch: Throwable -> L23
        r11.append(r3.hashCode());     // Catch: Throwable -> L23
        r11.append(", reported=");     // Catch: Throwable -> L23
        if (r1 == true) goto L20;
        r8 = false;
    L20:
        r11.append(r8);     // Catch: Throwable -> L23
        lvb.a.e("MmD1204RecordingEventTracker", r11.toString());     // Catch: Throwable -> L23
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r9.unlock(null);
        return Unit.INSTANCE;
    L23:
        th = move-exception;
        r9.unlock(null);
        throw th;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r5);
        kotlinx.coroutines.sync.a r13 = r0.b;
        r2.L$0 = null;
        r2.L$1 = null;
        r2.L$2 = r13;
        r2.label = 1;
        if (r13.a(null, r2) == r6) goto L28;
        r9 = r13;
        r3 = null;
        r10 = null;
        goto L26
    L28:
        return r6;
    L5:
        r2 = new MmD1204RecordingEventTracker$onChargingCaseRecordingStarted$1(r0, this);
        goto L6
    }
}
