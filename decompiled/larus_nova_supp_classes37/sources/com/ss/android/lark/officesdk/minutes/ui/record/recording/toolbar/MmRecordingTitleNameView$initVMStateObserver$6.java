package com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar;

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
import kotlin.text.StringsKt;
import mwb.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "mmPOIAddress", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTitleNameView$initVMStateObserver$6", f = "MmRecordingTitleNameView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTitleNameView$initVMStateObserver$6 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingTitleNameView this$0;

    public MmRecordingTitleNameView$initVMStateObserver$6(MmRecordingTitleNameView r1, Continuation<? super MmRecordingTitleNameView$initVMStateObserver$6> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTitleNameView$initVMStateObserver$6 r0 = new MmRecordingTitleNameView$initVMStateObserver$6(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r4);
        String r5 = (String) this.L$0;
        if (StringsKt.isBlank(r5) == true) goto L7;
        f r0 = this.this$0.a;
        f r1 = null;
        if (r0 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L11:
        r0.h.setText(r5);
        f r6 = this.this$0.a;
        if (r6 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L14:
        r6.h.setVisibility(0);
        f r7 = this.this$0.a;
        if (r7 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L17:
        r7.g.setVisibility(0);
        f r8 = this.this$0.a;
        if (r8 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        r1.i.setVisibility(0);
        return Unit.INSTANCE;
    L20:
        r1 = r8;
        goto L21
    L7:
        return Unit.INSTANCE;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
