package com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isPlaying", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.recording.ainote.MmAINoteFragment$subscribeState$4", f = "MmAINoteFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmAINoteFragment$subscribeState$4 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmAINoteFragment this$0;

    public MmAINoteFragment$subscribeState$4(MmAINoteFragment r1, Continuation<? super MmAINoteFragment$subscribeState$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmAINoteFragment$subscribeState$4 r0 = new MmAINoteFragment$subscribeState$4(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r4);
        boolean r5 = this.Z$0;
        MmAINotePanelAnimator r0 = this.this$0.q;
        if (r0 == null) goto L25;
        if (r5 == false) goto L23;
        MmAINoteWaveBarView r6 = r0.a.j;
        if (r6.i == true) goto L15;
        r6.i = true;
        if (r6.getVisibility() != 0) goto L15;
        if (r6.isShown() == false) goto L15;
        r6.j.start();
    L15:
        MmAINoteWaveBarView r7 = r0.a.o;
        if (r7.i == true) goto L25;
        r7.i = true;
        if (r7.getVisibility() != 0) goto L25;
        if (r7.isShown() == false) goto L25;
        r7.j.start();
        goto L25
    L23:
        r0.a.j.a();
        r0.a.o.a();
    L25:
        return Unit.INSTANCE;
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
