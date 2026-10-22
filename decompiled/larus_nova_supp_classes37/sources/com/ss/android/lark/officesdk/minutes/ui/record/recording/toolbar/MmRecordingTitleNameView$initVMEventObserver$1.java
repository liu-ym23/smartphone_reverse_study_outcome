package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import com.ss.android.lark.officesdk.minutes.ui.record.recording.base.h;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "event", "Lcom/ss/android/lark/officesdk/minutes/ui/record/recording/base/MmRecordingVMEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView$initVMEventObserver$1", f = "MmRecordingTitleNameView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTitleNameView$initVMEventObserver$1 extends SuspendLambda implements Function2<h, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingTitleNameView this$0;

    public MmRecordingTitleNameView$initVMEventObserver$1(MmRecordingTitleNameView r1, Continuation<? super MmRecordingTitleNameView$initVMEventObserver$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTitleNameView$initVMEventObserver$1 r0 = new MmRecordingTitleNameView$initVMEventObserver$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(h r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((h) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r3);
        h r4 = (h) this.L$0;
        if ((r4 instanceof h.C0063h) == false) goto L12;
        h.C0063h r5 = (h.C0063h) r4;
        if (r5.b == false) goto L9;
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.f(2131892864);
    L10:
        MmRecordingTitleNameView r0 = this.this$0;
        String r6 = r5.a;
        int r1 = MmRecordingTitleNameView.e;
        r0.U5(r6, "UpdateTitleFailed");
        goto L12
    L9:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.a(2131892883);
    L12:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
