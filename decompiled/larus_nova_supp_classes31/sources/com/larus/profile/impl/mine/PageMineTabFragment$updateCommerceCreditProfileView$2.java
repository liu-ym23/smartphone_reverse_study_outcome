package com.larus.profile.impl.mine;

import android.view.View;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.profile.impl.databinding.LarusFragmentMineTabPageBinding;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.utils.e1;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.profile.impl.mine.PageMineTabFragment$updateCommerceCreditProfileView$2", f = "PageMineTabFragment.kt", i = {}, l = {634}, m = "invokeSuspend", n = {}, s = {})
final class PageMineTabFragment$updateCommerceCreditProfileView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleDraweeView $commerceCreditImageView;
    final /* synthetic */ View $commerceCreditProfileView;
    final /* synthetic */ TextView $commerceCreditTextView;
    int label;
    final /* synthetic */ PageMineTabFragment this$0;

    public PageMineTabFragment$updateCommerceCreditProfileView$2(View r1, PageMineTabFragment r2, TextView r3, SimpleDraweeView r4, Continuation<? super PageMineTabFragment$updateCommerceCreditProfileView$2> r5) {
        this.$commerceCreditProfileView = r1;
        this.this$0 = r2;
        this.$commerceCreditTextView = r3;
        this.$commerceCreditImageView = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new PageMineTabFragment$updateCommerceCreditProfileView$2(this.$commerceCreditProfileView, this.this$0, this.$commerceCreditTextView, this.$commerceCreditImageView, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L35:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        View r9 = this.$commerceCreditProfileView;
        if (r9 == null) goto L11;
        e1.o(r9);
    L11:
        PageMineTabFragment r10 = this.this$0;
        int r2 = PageMineTabFragment.R;
        if (r10.ca0() == false) goto L21;
        CreditInfoScene r11 = CreditInfoScene.COMMERCE_CREDIT_SIDEBAR_PROFILE;
        LarusFragmentMineTabPageBinding r3 = this.this$0.k;
        if (r3 == null) goto L29;
        MineTabTitleBar r4 = r3.m;
        if (r4 == null) goto L29;
        View r5 = this.$commerceCreditProfileView;
        int r6 = MineTabTitleBar.b;
        if (r5 == null) goto L29;
        r4.getBinding().c.removeAllViews();
        r4.getBinding().c.addView(r5);
        e1.x(r4.getBinding().c);
    L29:
        ICommerceCreditService.a.getClass();
        ICommerceCreditService r7 = ICommerceCreditService.a.a();
        if (r7 == null) goto L35;
        final View r12 = this.$commerceCreditProfileView;
        final TextView r13 = this.$commerceCreditTextView;
        final SimpleDraweeView r14 = this.$commerceCreditImageView;
        Function2 r15 = new t0(r12, r13, r14);
        this.label = 1;
        if (r7.m(r11, true, r15, this) != r0) goto L35;
        return r0;
    L21:
        r11 = CreditInfoScene.COMMERCE_CREDIT_DEFAULT_PROFILE;
        LarusFragmentMineTabPageBinding r16 = this.this$0.k;
        if (r16 == null) goto L29;
        MineTabTitleBar r17 = r16.m;
        if (r17 == null) goto L29;
        View r18 = this.$commerceCreditProfileView;
        int r19 = MineTabTitleBar.b;
        if (r18 == null) goto L29;
        r17.getBinding().b.removeAllViews();
        r17.getBinding().b.addView(r18);
        e1.x(r17.getBinding().b);
        goto L29
    }
}
