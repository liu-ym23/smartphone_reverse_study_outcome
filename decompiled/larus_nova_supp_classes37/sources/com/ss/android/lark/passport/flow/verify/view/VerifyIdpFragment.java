package com.ss.android.lark.passport.flow.verify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.network.handler.h;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.SwitchButton;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyIdpViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
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
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u00172\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u001d2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyIdpFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "authListViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getAuthListViewModel", "authListViewModel$delegate", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyIdpViewModel;", "getViewModel", "viewModel$delegate", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyIdpFragment extends FlowBaseFragment {
    public static final /* synthetic */ int j = 0;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public CommonUiContainer i;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyIdpViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$1", f = "VerifyIdpFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<VerifyIdpViewModel.d, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyIdpFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$1$a */
        public static final class a implements View.OnClickListener {
            public final /* synthetic */ VerifyIdpFragment a;

            public a(VerifyIdpFragment r1) {
                this.a = r1;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                VerifyIdpFragment r3 = this.a;
                int r0 = VerifyIdpFragment.j;
                ((VerifyIdpViewModel) ((Lazy) r3.h.getValue()).getValue()).reduce(VerifyIdpViewModel.a.C0089a.a);
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$1$b */
        public static final class b implements View.OnClickListener {
            public final /* synthetic */ SwitchButton a;
            public final /* synthetic */ VerifyIdpFragment b;

            public b(SwitchButton r1, VerifyIdpFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                if (this.a.getActionType() != ButtonType.SWITCH_AUTH.getValue()) goto L6;
                ((AuthListViewModel) ((Lazy) this.b.g.getValue()).getValue()).reduce(AuthListViewModel.a.C0086a.a);
                return;
            L6:
                if (VerifyIdpFragment.U90(this.b).d(this.a.getActionType()) == false) goto L11;
                String r5 = VerifyIdpFragment.U90(this.b).a(this.a.getActionType());
                if (r5 == null) goto L15;
                UDToast.show(this.b.requireContext(), r5);
                return;
            L15:
                return;
            L11:
                AuthMethod r6 = VerifyIdpFragment.U90(this.b).b(this.a.getActionType());
                if (r6 == null) goto L17;
                VerifyIdpFragment r0 = this.b;
                ((AuthListViewModel) ((Lazy) r0.g.getValue()).getValue()).reduce(new AuthListViewModel.a.b(r0.requireContext(), r6));
                return;
            }
        }

        public AnonymousClass1(VerifyIdpFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyIdpViewModel.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyIdpViewModel.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r7) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r7);
            VerifyIdpViewModel.d r8 = (VerifyIdpViewModel.d) this.L$0;
            if ((r8 instanceof VerifyIdpViewModel.d.b) == false) goto L35;
            CommonUiContainer r0 = this.this$0.i;
            if (r0 == null) goto L9;
            r0.b(((VerifyIdpViewModel.d.b) r8).a.getTitle());
        L9:
            CommonUiContainer r1 = this.this$0.i;
            if (r1 == null) goto L12;
            r1.a(((VerifyIdpViewModel.d.b) r8).a.getSubTitle());
        L12:
            CommonUiContainer r2 = this.this$0.i;
            BaseContainerLayout r3 = null;
            if (r2 == null) goto L15;
            BaseContainerLayout r4 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r2).b;
        L17:
            if (r4 == null) goto L24;
            TextView r5 = (TextView) r4.findViewById(2131390989);
            if (r5 == null) goto L24;
            VerifyIdpFragment r6 = this.this$0;
            ButtonBean r9 = ((VerifyIdpViewModel.d.b) r8).a.getNextButton();
            if (r9 == null) goto L23;
            r5.setVisibility(0);
            r5.setText(r9.getText());
            m.a(r5, new a(r6));
            goto L24
        L23:
            r5.setVisibility(8);
        L24:
            CommonUiContainer r10 = this.this$0.i;
            if (r10 == null) goto L27;
            r3 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r10).b;
        L27:
            if (r3 == null) goto L35;
            TextView r11 = (TextView) r3.findViewById(2131391539);
            if (r11 == null) goto L35;
            VerifyIdpFragment r12 = this.this$0;
            SwitchButton r13 = ((VerifyIdpViewModel.d.b) r8).a.getSwitchButton();
            if (r13 == null) goto L33;
            r11.setVisibility(0);
            r11.setText(r13.getText());
            m.a(r11, new b(r13, r12));
            goto L35
        L33:
            r11.setVisibility(8);
            goto L35
        L15:
            r4 = null;
        L35:
            return Unit.INSTANCE;
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyIdpViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyIdpFragment$onViewCreated$2", f = "VerifyIdpFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<VerifyIdpViewModel.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyIdpFragment this$0;

        public AnonymousClass2(VerifyIdpFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyIdpViewModel.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyIdpViewModel.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L39;
            ResultKt.throwOnFailure(r4);
            VerifyIdpViewModel.c r5 = (VerifyIdpViewModel.c) this.L$0;
            if ((r5 instanceof VerifyIdpViewModel.c.e) == false) goto L8;
            this.this$0.T90();
        L35:
            return Unit.INSTANCE;
        L8:
            if ((r5 instanceof VerifyIdpViewModel.c.a) == false) goto L11;
            this.this$0.S90();
            goto L35
        L11:
            if ((r5 instanceof VerifyIdpViewModel.c.d) == false) goto L27;
            AtomicReference<syb.b> r0 = com.ss.android.lark.passport.flow.core.router.a.c;
            VerifyIdpViewModel.c.d r6 = (VerifyIdpViewModel.c.d) r5;
            PassportRouterResult r1 = com.ss.android.lark.passport.flow.core.router.a.C0085a.a(this.this$0.requireContext(), r6.a.getNextStep(), r6.a.getStepInfo());
            if (r1.a() == true) goto L15;
        L17:
            boolean r7 = false;
        L18:
            if (r7 == true) goto L21;
            this.this$0.S90();
        L21:
            if (r1.a() == false) goto L35;
            if (r7 == true) goto L35;
            FragmentActivity r8 = this.this$0.getActivity();
            if (r8 == null) goto L35;
            r8.finish();
            goto L35
        L15:
            if (Intrinsics.areEqual(r6.a.getNextStep(), "get_auth_url") == false) goto L17;
            r7 = true;
            goto L18
        L27:
            if ((r5 instanceof VerifyIdpViewModel.c.b) == false) goto L32;
            this.this$0.S90();
            FragmentActivity r9 = this.this$0.getActivity();
            if (r9 == null) goto L35;
            r9.finish();
            goto L35
        L32:
            if ((r5 instanceof VerifyIdpViewModel.c.C0090c) == false) goto L37;
            int r2 = h.a;
            Boxing.boxBoolean(h.b(this.this$0.getContext(), ((VerifyIdpViewModel.c.C0090c) r5).a));
            goto L35
        L37:
            throw new NoWhenBranchMatchedException();
        L39:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public VerifyIdpFragment() {
        this.f = LazyKt.lazy(new VerifyIdpFragment$commonViewModel$2(this));
        this.g = LazyKt.lazy(new VerifyIdpFragment$authListViewModel$2(this));
        this.h = LazyKt.lazy(new VerifyIdpFragment$viewModel$2(this));
    }

    public static final xyb.a U90(VerifyIdpFragment r0) {
        return (xyb.a) ((VerifyCommonViewModel) ((Lazy) r0.f.getValue()).getValue()).getRepo().getValue();
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        PassportLog.d("VerifyIdpFragment", "onViewCreated start");
        FlowUtilKt.c(this, ((VerifyIdpViewModel) ((Lazy) this.h.getValue()).getValue()).getViewState(), new AnonymousClass1(this, null));
        FlowUtilKt.c(this, ((VerifyIdpViewModel) ((Lazy) this.h.getValue()).getValue()).getEventState(), new AnonymousClass2(this, null));
        ((VerifyIdpViewModel) ((Lazy) this.h.getValue()).getValue()).init();
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.i != null) goto L5;
        int r4 = CommonUiContainer.j;
        this.i = CommonUiContainer.b.a(requireActivity(), 2131564876, r2);
    L5:
        CommonUiContainer r5 = this.i;
        if (r5 != null) goto L10;
        return null;
    L10:
        return ((com.ss.android.lark.flow.passport.ui.widget.common.a) r5).b;
    }
}
