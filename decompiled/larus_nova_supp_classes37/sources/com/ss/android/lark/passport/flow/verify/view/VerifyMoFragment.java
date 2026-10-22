package com.ss.android.lark.passport.flow.verify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.network.handler.h;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.MoTextBean;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyMoViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import uzb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00152\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyMoFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel;", "getViewModel", "viewModel$delegate", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyMoFragment extends FlowBaseFragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy f;
    public final Lazy g;
    public CommonUiContainer h;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$1", f = "VerifyMoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<VerifyMoViewModel.d, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyMoFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$1$a */
        public static final class a implements View.OnClickListener {
            public final /* synthetic */ VerifyMoFragment a;

            public a(VerifyMoFragment r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                VerifyMoFragment r3 = this.a;
                int r0 = VerifyMoFragment.i;
                ((VerifyMoViewModel) ((Lazy) r3.g.getValue()).getValue()).reduce(VerifyMoViewModel.a.C0091a.a);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$1$b */
        public static final class b implements View.OnClickListener {
            public final /* synthetic */ VerifyMoViewModel.d a;

            public b(VerifyMoViewModel.d r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                ArrayList<MoTextBean> r3 = ((VerifyMoViewModel.d.b) this.a).a.getMoTextList();
                if (r3 == null) goto L7;
                MoTextBean r4 = (MoTextBean) ListProtector.get(r3, 0);
                if (r4 == null) goto L7;
                r4.getContent();
            L7:
                ArrayList<MoTextBean> r5 = ((VerifyMoViewModel.d.b) this.a).a.getMoTextList();
                if (r5 == null) goto L13;
                MoTextBean r6 = (MoTextBean) ListProtector.get(r5, 1);
                if (r6 == null) goto L14;
                r6.getContent();
                return;
            L14:
                return;
            }
        }

        public AnonymousClass1(VerifyMoFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyMoViewModel.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyMoViewModel.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r8) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L47;
            ResultKt.throwOnFailure(r8);
            VerifyMoViewModel.d r9 = (VerifyMoViewModel.d) this.L$0;
            if ((r9 instanceof VerifyMoViewModel.d.b) == false) goto L45;
            CommonUiContainer r0 = this.this$0.h;
            if (r0 == null) goto L9;
            r0.b(((VerifyMoViewModel.d.b) r9).a.getTitle());
        L9:
            CommonUiContainer r1 = this.this$0.h;
            if (r1 == null) goto L12;
            r1.a(((VerifyMoViewModel.d.b) r9).a.getSubTitle());
        L12:
            CommonUiContainer r2 = this.this$0.h;
            TextView r3 = null;
            if (r2 == null) goto L15;
            BaseContainerLayout r4 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r2).b;
        L16:
            if (r4 == null) goto L18;
            TextView r5 = (TextView) r4.findViewById(2131385926);
        L19:
            CommonUiContainer r6 = this.this$0.h;
            if (r6 == null) goto L22;
            BaseContainerLayout r7 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r6).b;
        L23:
            if (r7 == null) goto L25;
            r3 = (TextView) r7.findViewById(2131385925);
        L25:
            VerifyMoViewModel.d.b r10 = (VerifyMoViewModel.d.b) r9;
            ButtonBean r11 = r10.a.getNextButton();
            if (r11 == null) goto L33;
            VerifyMoFragment r12 = this.this$0;
            if (r5 == null) goto L30;
            r5.setVisibility(0);
        L30:
            if (r5 == null) goto L32;
            r5.setText(r11.getText());
        L32:
            m.a(r5, new a(r12));
        L36:
            if (r10.a.getSendMoButton() == null) goto L42;
            if (r3 == null) goto L39;
            r3.setVisibility(0);
        L39:
            if (r3 == null) goto L41;
            r3.setText(r10.a.getSendMoButton().getText());
        L41:
            m.a(r3, new b(r9));
            goto L45
        L42:
            if (r3 == null) goto L45;
            r3.setVisibility(8);
            goto L45
        L33:
            if (r5 == null) goto L36;
            r5.setVisibility(8);
            goto L36
        L22:
            r7 = null;
            goto L23
        L18:
            r5 = null;
            goto L19
        L15:
            r4 = null;
        L45:
            return Unit.INSTANCE;
        L47:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyMoViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyMoFragment$onViewCreated$2", f = "VerifyMoFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<VerifyMoViewModel.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyMoFragment this$0;

        public AnonymousClass2(VerifyMoFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyMoViewModel.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyMoViewModel.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L30;
            ResultKt.throwOnFailure(r3);
            VerifyMoViewModel.c r4 = (VerifyMoViewModel.c) this.L$0;
            if ((r4 instanceof VerifyMoViewModel.c.e) == false) goto L8;
            this.this$0.T90();
        L26:
            return Unit.INSTANCE;
        L8:
            if ((r4 instanceof VerifyMoViewModel.c.a) == false) goto L11;
            this.this$0.S90();
            goto L26
        L11:
            if ((r4 instanceof VerifyMoViewModel.c.d) == false) goto L18;
            AtomicReference<syb.b> r0 = com.ss.android.lark.passport.flow.core.router.a.c;
            VerifyMoViewModel.c.d r5 = (VerifyMoViewModel.c.d) r4;
            PassportRouterResult r6 = com.ss.android.lark.passport.flow.core.router.a.C0085a.a(this.this$0.requireContext(), r5.a.getNextStep(), r5.a.getStepInfo());
            this.this$0.S90();
            if (r6.a() == false) goto L26;
            FragmentActivity r7 = this.this$0.getActivity();
            if (r7 == null) goto L26;
            r7.finish();
            goto L26
        L18:
            if ((r4 instanceof VerifyMoViewModel.c.b) == false) goto L23;
            this.this$0.S90();
            FragmentActivity r8 = this.this$0.getActivity();
            if (r8 == null) goto L26;
            r8.finish();
            goto L26
        L23:
            if ((r4 instanceof VerifyMoViewModel.c.C0092c) == false) goto L28;
            int r1 = h.a;
            Boxing.boxBoolean(h.b(this.this$0.getContext(), ((VerifyMoViewModel.c.C0092c) r4).a));
            goto L26
        L28:
            throw new NoWhenBranchMatchedException();
        L30:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public VerifyMoFragment() {
        this.f = LazyKt.lazy(new VerifyMoFragment$commonViewModel$2(this));
        this.g = LazyKt.lazy(new VerifyMoFragment$viewModel$2(this));
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        PassportLog.d("VerifyMoFragment", "onViewCreated start");
        FlowUtilKt.c(this, ((VerifyMoViewModel) ((Lazy) this.g.getValue()).getValue()).getViewState(), new AnonymousClass1(this, null));
        FlowUtilKt.c(this, ((VerifyMoViewModel) ((Lazy) this.g.getValue()).getValue()).getEventState(), new AnonymousClass2(this, null));
        ((VerifyMoViewModel) ((Lazy) this.g.getValue()).getValue()).init();
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.h != null) goto L5;
        int r4 = CommonUiContainer.j;
        this.h = CommonUiContainer.b.a(requireActivity(), 2131564872, r2);
    L5:
        CommonUiContainer r5 = this.h;
        if (r5 != null) goto L10;
        return null;
    L10:
        return ((com.ss.android.lark.flow.passport.ui.widget.common.a) r5).b;
    }
}
