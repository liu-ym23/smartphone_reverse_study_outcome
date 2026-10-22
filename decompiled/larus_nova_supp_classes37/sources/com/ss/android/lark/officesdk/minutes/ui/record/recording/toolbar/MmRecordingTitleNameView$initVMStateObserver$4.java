package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.content.Context;
import android.widget.TextView;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.time.format.entity.DatePreciseness;
import com.ss.android.lark.time.format.entity.DisplayPattern;
import com.ss.android.lark.time.format.entity.LengthType;
import com.ss.android.lark.time.format.entity.TimePreciseness;
import java.util.Date;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import mwb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "startTime", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView$initVMStateObserver$4", f = "MmRecordingTitleNameView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTitleNameView$initVMStateObserver$4 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ MmRecordingTitleNameView this$0;

    public MmRecordingTitleNameView$initVMStateObserver$4(MmRecordingTitleNameView r1, Continuation<? super MmRecordingTitleNameView$initVMStateObserver$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTitleNameView$initVMStateObserver$4 r0 = new MmRecordingTitleNameView$initVMStateObserver$4(this.this$0, r4);
        r0.J$0 = ((Number) r3).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L18;
        ResultKt.throwOnFailure(r20);
        long r1 = this.J$0;
        if (r1 <= 0) goto L7;
        f r3 = this.this$0.a;
        f r4 = null;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L11:
        TextView r5 = r3.f;
        int r6 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a;
        Context r7 = this.this$0.getContext();
        Intrinsics.checkNotNullParameter(r7, "context");
        c7c.a r8 = new c7c.a(null, null, null, null, null, false, false, false, false, 2047);
        r8.b(DisplayPattern.ABSOLUTE);
        r8.c(LengthType.SHORT);
        r8.h = false;
        r8.a(DatePreciseness.DAY);
        r8.d(TimePreciseness.MINUTE);
        r5.setText(c7c.b.c(r7, new Date(r1), r8));
        f r2 = this.this$0.a;
        if (r2 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r4.e.setVisibility(0);
        return Unit.INSTANCE;
    L14:
        r4 = r2;
        goto L15
    L7:
        return Unit.INSTANCE;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
