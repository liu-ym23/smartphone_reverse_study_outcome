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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "degraded", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.toolbar.MmRecordingTopBarView$subscribeData$10", f = "MmRecordingTopBarView.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmRecordingTopBarView$subscribeData$10 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmRecordingTopBarView this$0;

    public MmRecordingTopBarView$subscribeData$10(MmRecordingTopBarView r1, Continuation<? super MmRecordingTopBarView$subscribeData$10> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingTopBarView$subscribeData$10 r0 = new MmRecordingTopBarView$subscribeData$10(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L38;
        ResultKt.throwOnFailure(r7);
        boolean r8 = this.Z$0;
        h r0 = this.this$0.a;
        h r1 = null;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r0 = null;
    L7:
        r0.d.setEnabled(!r8);
        h r2 = this.this$0.a;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L10:
        ImageView r3 = r2.d;
        float r4 = 0.4f;
        if (r8 == false) goto L13;
        float r5 = 0.4f;
    L14:
        r3.setAlpha(r5);
        h r6 = this.this$0.a;
        if (r6 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L17:
        r6.e.setEnabled(!r8);
        h r9 = this.this$0.a;
        if (r9 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L20:
        ImageView r10 = r9.e;
        if (r8 == false) goto L23;
        float r11 = 0.4f;
    L24:
        r10.setAlpha(r11);
        h r12 = this.this$0.a;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L27:
        r12.f.setEnabled(!r8);
        h r13 = this.this$0.a;
        if (r13 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L31:
        ImageView r14 = r1.f;
        if (r8 == true) goto L35;
        r4 = 1.0f;
    L35:
        r14.setAlpha(r4);
        return Unit.INSTANCE;
    L30:
        r1 = r13;
        goto L31
    L23:
        r11 = 1.0f;
        goto L24
    L13:
        r5 = 1.0f;
        goto L14
    L38:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
