package com.ss.android.lark.officesdk.minutes.ui.record.endwindow;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web.MmEndWindowWebHelper;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "url", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.record.endwindow.MmEndWindowFragment$observeState$4", f = "MmEndWindowFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MmEndWindowFragment$observeState$4 extends SuspendLambda implements Function2<String, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ MmEndWindowFragment this$0;

    public MmEndWindowFragment$observeState$4(MmEndWindowFragment r1, Continuation<? super MmEndWindowFragment$observeState$4> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        MmEndWindowFragment$observeState$4 r0 = new MmEndWindowFragment$observeState$4(this.this$0, r4);
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
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r5);
        String r6 = (String) this.L$0;
        if (r6.length() <= 0) goto L7;
        boolean r0 = true;
    L8:
        if (r0 == false) goto L13;
        int r1 = bwb.b.a;
        MmUiLogScene r2 = MmUiLogScene.END_WINDOW;
        String r3 = "url: ".concat(r6);
        MmEndWindowFragment r4 = this.this$0;
        int r7 = MmEndWindowFragment.D;
        bwb.b.f(r2, "observeState", r3, r4.U90());
        MmEndWindowWebHelper r8 = this.this$0.s;
        if (r8 == null) goto L13;
        r8.i(r6);
    L13:
        return Unit.INSTANCE;
    L7:
        r0 = false;
        goto L8
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
