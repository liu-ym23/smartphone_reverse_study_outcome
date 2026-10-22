package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "isLoading", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowFragment$observeState$2", f = "MmEndWindowFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowFragment$observeState$2 extends SuspendLambda implements Function2<Boolean, Continuation<? super Unit>, Object> {
    /* synthetic */ boolean Z$0;
    int label;
    final /* synthetic */ MmEndWindowFragment this$0;

    public MmEndWindowFragment$observeState$2(MmEndWindowFragment r1, Continuation<? super MmEndWindowFragment$observeState$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmEndWindowFragment$observeState$2 r0 = new MmEndWindowFragment$observeState$2(this.this$0, r4);
        r0.Z$0 = ((Boolean) r3).booleanValue();
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke(((Boolean) r1).booleanValue(), (Continuation) r2);
    }

    public final Object invoke(boolean r1, Continuation<? super Unit> r2) {
        return create(Boolean.valueOf(r1), r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [android.view.ViewGroup, com.ss.android.lark.officesdk.minutes.ui.foundation.widget.MmEndWindowLoadingLayout] */
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r5);
        boolean r6 = this.Z$0;
        int r0 = bwb.b.a;
        MmEndWindowFragment r2 = this.this$0;
        int r3 = MmEndWindowFragment.D;
        bwb.b.f(MmUiLogScene.END_WINDOW, "observeState", "Loading state: " + r6, r2.U90());
        if (r6 == false) goto L7;
        this.this$0.fa0().d.setVisibility(0);
    L9:
        return Unit.INSTANCE;
    L7:
        ?? r7 = this.this$0.fa0().d;
        r7.R5();
        r7.setVisibility(8);
        goto L9
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
