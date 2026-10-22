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
import mwb.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "showAudioSaveEntry", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$2", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$2(MmRecordingTopBarView r1, Continuation<? super MmRecordingTopBarView$subscribeData$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTopBarView$subscribeData$2 r0 = new MmRecordingTopBarView$subscribeData$2(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r3);
        h r0 = null;
        if (this.Z$0 == false) goto L11;
        h r4 = this.this$0.a;
        if (r4 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L10:
        r0.f.setVisibility(0);
    L17:
        return Unit.INSTANCE;
    L9:
        r0 = r4;
        goto L10
    L11:
        h r5 = this.this$0.a;
        if (r5 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r0.f.setVisibility(8);
        goto L17
    L14:
        r0 = r5;
        goto L15
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
