package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

import android.widget.TextView;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "duration", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment$subscribeState$2", f = "MmAINoteFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmAINoteFragment$subscribeState$2 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {
    /* synthetic */ long J$0;
    int label;
    final /* synthetic */ MmAINoteFragment this$0;

    public MmAINoteFragment$subscribeState$2(MmAINoteFragment r1, Continuation<? super MmAINoteFragment$subscribeState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmAINoteFragment$subscribeState$2 r0 = new MmAINoteFragment$subscribeState$2(this.this$0, r4);
        r0.J$0 = ((Number) r3).longValue();
        return r0;
    }

    public final Object invoke(long r1, Continuation<? super Unit> r3) {
        return create(Long.valueOf(r1), r3).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r3, Object r4) {
        return invoke(((Number) r3).longValue(), (Continuation) r4);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r3);
        String r4 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.c.a(this.J$0);
        mwb.b r0 = this.this$0.p;
        if (r0 == null) goto L9;
        TextView r1 = r0.k;
        if (r1 == null) goto L9;
        r1.setText(r4);
    L9:
        mwb.b r2 = this.this$0.p;
        if (r2 == null) goto L15;
        TextView r5 = r2.p;
        if (r5 == null) goto L15;
        r5.setText(r4);
    L15:
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
