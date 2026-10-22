package com.ss.android.lark.officesdk.minutes.ui.foundation.mvi;

import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.officesdk.minutes.ui.foundation.mvi.MmBaseFragment$handleDarkModeChange$1", f = "MmBaseFragment.kt", i = {}, l = {143}, m = "invokeSuspend", n = {}, s = {})
public final class MmBaseFragment$handleDarkModeChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MmBaseFragment this$0;

    public MmBaseFragment$handleDarkModeChange$1(MmBaseFragment r1, Continuation<? super MmBaseFragment$handleDarkModeChange$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new MmBaseFragment$handleDarkModeChange$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        if (this.this$0.isAdded() == true) goto L16;
        int r6 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, fragment detached after debounce, skip", MmBaseFragment.S90(this.this$0));
        return Unit.INSTANCE;
    L16:
        if (this.this$0.getParentFragmentManager().isStateSaved() == false) goto L19;
        int r7 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, state already saved, skip", MmBaseFragment.S90(this.this$0));
        return Unit.INSTANCE;
    L19:
        boolean r8 = this.this$0.W90();
        if (Intrinsics.areEqual(this.this$0.h, Boxing.boxBoolean(r8)) == false) goto L23;
        int r9 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, stable darkMode not changed, skip", MmBaseFragment.S90(this.this$0));
        return Unit.INSTANCE;
    L23:
        int r2 = bwb.b.a;
        bwb.b.f(MmUiLogScene.FOUNDATION, "handleDarkModeChange", "handleDarkModeChange, darkMode changed: " + this.this$0.h + " -> " + r8, MmBaseFragment.S90(this.this$0));
        this.this$0.h = Boxing.boxBoolean(r8);
        this.this$0.X90(r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        this.label = 1;
        if (DelayKt.delay(100, this) != r0) goto L12;
        return r0;
    }
}
