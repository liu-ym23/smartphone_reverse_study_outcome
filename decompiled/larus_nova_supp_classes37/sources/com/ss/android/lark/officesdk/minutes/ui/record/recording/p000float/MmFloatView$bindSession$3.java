package com.ss.android.lark.officesdk.minutes.ui.record.recording.p000float;

import com.ss.android.lark.officesdk.minutes.service.recording.common.core.MmRecordingSession;
import com.ss.android.lark.officesdk.minutes.service.recording.hardware.e;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "hardwareSession", "Lcom/ss/android/lark/officesdk/minutes/service/recording/hardware/HardwareRecordingSession;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.float.MmFloatView$bindSession$3", f = "MmFloatView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmFloatView$bindSession$3 extends SuspendLambda implements Function2<e, Continuation<? super Unit>, Object> {
    final /* synthetic */ MmRecordingSession $session;
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmFloatView this$0;

    public MmFloatView$bindSession$3(MmFloatView r1, MmRecordingSession r2, Continuation<? super MmFloatView$bindSession$3> r3) {
        this.this$0 = r1;
        this.$session = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MmFloatView$bindSession$3 r0 = new MmFloatView$bindSession$3(this.this$0, this.$session, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(e r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((e) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r5);
        e r6 = (e) this.L$0;
        MmFloatView r0 = this.this$0;
        if (r6 != null) goto L7;
    L9:
        r6 = null;
    L10:
        r0.d = r6;
        return Unit.INSTANCE;
    L7:
        if (Intrinsics.areEqual(r6.f, this.$session.e()) == false) goto L9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
