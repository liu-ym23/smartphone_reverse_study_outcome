package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "mmPOIAddress", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeLocationInfo$1$2", f = "MmRecordingViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeLocationInfo$1$2 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    public MmRecordingViewModel$observeLocationInfo$1$2(MmRecordingViewModel r1, Continuation<? super MmRecordingViewModel$observeLocationInfo$1$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingViewModel$observeLocationInfo$1$2 r0 = new MmRecordingViewModel$observeLocationInfo$1$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r5);
        final String r6 = (String) this.L$0;
        boolean r0 = false;
        if (r6 != null) goto L7;
    L12:
        if (r0 == false) goto L15;
        int r1 = bwb.b.a;
        bwb.b.f(MmUiLogScene.RECORDING, "observeLocationInfo", "mmPOIAddress=" + r6, MmRecordingViewModel.access$getLogDetail(this.this$0));
        this.this$0.setState(new AnonymousClass1(r6));
    L15:
        return Unit.INSTANCE;
    L7:
        if (r6.length() <= 0) goto L9;
        boolean r2 = true;
    L10:
        if (r2 != true) goto L12;
        r0 = true;
        goto L12
    L9:
        r2 = false;
        goto L10
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
