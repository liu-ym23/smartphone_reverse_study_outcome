package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

import android.widget.ImageView;
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
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "showAIInterpretationEntry", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$4", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$4(MmRecordingTopBarView r1, Continuation<? super MmRecordingTopBarView$subscribeData$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTopBarView$subscribeData$4 r0 = new MmRecordingTopBarView$subscribeData$4(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r2);
        boolean r3 = this.Z$0;
        h r0 = this.this$0.a;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        ImageView r1 = r0.e;
        if (r3 == false) goto L10;
        int r4 = 0;
    L11:
        r1.setVisibility(r4);
        return Unit.INSTANCE;
    L10:
        r4 = 8;
        goto L11
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
