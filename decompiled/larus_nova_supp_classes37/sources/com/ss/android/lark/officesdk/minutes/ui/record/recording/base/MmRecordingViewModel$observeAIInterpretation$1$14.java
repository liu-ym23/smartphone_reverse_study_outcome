package com.ss.android.lark.officesdk.minutes.ui.record.recording.base;

import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, d2 = {"<anonymous>", "", "errorMessage", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.base.MmRecordingViewModel$observeAIInterpretation$1$14", f = "MmRecordingViewModel.kt", i = {}, l = {1022}, m = "invokeSuspend", n = {}, s = {})
public final class MmRecordingViewModel$observeAIInterpretation$1$14 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmRecordingViewModel this$0;

    public MmRecordingViewModel$observeAIInterpretation$1$14(MmRecordingViewModel r1, Continuation<? super MmRecordingViewModel$observeAIInterpretation$1$14> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmRecordingViewModel$observeAIInterpretation$1$14 r0 = new MmRecordingViewModel$observeAIInterpretation$1$14(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((String) r1, (Continuation) r2);
    }

    public final Object invoke(String r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        final String r7 = (String) this.L$0;
        this.this$0.setState(new AnonymousClass1(r7));
        if (r7 == null) goto L14;
        MmRecordingViewModel r8 = this.this$0;
        h.g r2 = new h.g(new svb.a.C0191a(UIHelper.getString(2131893523)));
        this.label = 1;
        if (r8.sendVMEvent(r2, this) != r0) goto L14;
        return r0;
    }
}
