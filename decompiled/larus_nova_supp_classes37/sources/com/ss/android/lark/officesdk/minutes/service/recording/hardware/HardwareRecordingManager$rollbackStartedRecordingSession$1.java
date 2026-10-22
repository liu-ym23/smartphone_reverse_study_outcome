package com.ss.android.lark.officesdk.minutes.service.recording.hardware;

import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.service.recording.hardware.HardwareRecordingManager", f = "HardwareRecordingManager.kt", i = {}, l = {572}, m = "rollbackStartedRecordingSession", n = {}, s = {})
final class HardwareRecordingManager$rollbackStartedRecordingSession$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ d this$0;

    public HardwareRecordingManager$rollbackStartedRecordingSession$1(d r1, Continuation<? super HardwareRecordingManager$rollbackStartedRecordingSession$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r4) {
        this.result = r4;
        this.label |= Integer.MIN_VALUE;
        d r5 = this.this$0;
        r5.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        HardwareRecordingManager$rollbackStartedRecordingSession$1 r0 = this;
    L6:
        Object r6 = r0.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 != 0) goto L9;
        ResultKt.throwOnFailure(r6);
        lvb.a.e(null, "[rollbackStartedRecordingSession] session=null");
        throw null;
    L9:
        if (r2 != 1) goto L25;
        ResultKt.throwOnFailure(r6);
        a r7 = (a) r6;
        if (Intrinsics.areEqual(r7, a.c.a) == true) goto L23;
        if ((r7 instanceof a.b) == false) goto L15;
        lvb.a.h(null, "[rollbackStartedRecordingSession] ignored, reason=" + ((a.b) r7).a);
        throw null;
    L15:
        if ((r7 instanceof a.C0052a) == false) goto L19;
        StringBuilder r3 = new StringBuilder("[rollbackStartedRecordingSession] failed, code=");
        a.C0052a r8 = (a.C0052a) r7;
        r3.append(r8.a);
        r3.append(", message=");
        r3.append(r8.b);
        lvb.a.b(null, r3.toString());
        throw null;
    L19:
        throw new NoWhenBranchMatchedException();
    L23:
        return Unit.INSTANCE;
    L25:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L5:
        r0 = new HardwareRecordingManager$rollbackStartedRecordingSession$1(r5, this);
        goto L6
    }
}
