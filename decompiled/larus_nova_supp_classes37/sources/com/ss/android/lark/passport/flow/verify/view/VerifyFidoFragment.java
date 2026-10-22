package com.ss.android.lark.passport.flow.verify.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.SwitchButton;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import uzb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00132\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u0014\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyFidoFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "authListViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getAuthListViewModel", "authListViewModel$delegate", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "currSessionId", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroy", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyFidoFragment extends FlowBaseFragment {
    public static final /* synthetic */ int i = 0;
    public final Lazy f;
    public final Lazy g;
    public CommonUiContainer h;

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r1) {
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ SwitchButton a;
        public final /* synthetic */ VerifyFidoFragment b;

        public c(SwitchButton r1, VerifyFidoFragment r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r4) {
            if (this.a.getActionType() != ButtonType.SWITCH_AUTH.getValue()) goto L5;
            ((AuthListViewModel) ((Lazy) this.b.g.getValue()).getValue()).reduce(AuthListViewModel.a.C0086a.a);
            return;
        L5:
            VerifyFidoFragment r5 = this.b;
            int r0 = VerifyFidoFragment.i;
            if (r5.U90().d(this.a.getActionType()) == false) goto L11;
            String r6 = this.b.U90().a(this.a.getActionType());
            if (r6 == null) goto L15;
            UDToast.show(this.b.requireContext(), r6);
            return;
        L15:
            return;
        L11:
            AuthMethod r7 = this.b.U90().b(this.a.getActionType());
            if (r7 == null) goto L17;
            VerifyFidoFragment r1 = this.b;
            ((AuthListViewModel) ((Lazy) r1.g.getValue()).getValue()).reduce(new AuthListViewModel.a.b(r1.requireActivity(), r7));
            return;
        }
    }

    static {
    }

    public final xyb.a U90() {
        return (xyb.a) ((VerifyCommonViewModel) ((Lazy) this.f.getValue()).getValue()).getRepo().getValue();
    }

    public VerifyFidoFragment() {
        this.f = LazyKt.lazy(new VerifyFidoFragment$commonViewModel$2(this));
        this.g = LazyKt.lazy(new VerifyFidoFragment$authListViewModel$2(this));
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        S90();
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        PassportLog.d("VerifyFidoFragment", "onViewCreated start");
        VerifyBean r7 = U90().e;
        CommonUiContainer r8 = this.h;
        if (r8 == null) goto L5;
        r8.b(r7.getTitle());
    L5:
        CommonUiContainer r9 = this.h;
        if (r9 == null) goto L8;
        r9.a(r7.getSubTitle());
    L8:
        CommonUiContainer r10 = this.h;
        BaseContainerLayout r0 = null;
        if (r10 == null) goto L11;
        BaseContainerLayout r11 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r10).b;
    L13:
        if (r11 == null) goto L20;
        TextView r12 = (TextView) r11.findViewById(2131390989);
        if (r12 == null) goto L20;
        if (r7.getNextButton() == null) goto L19;
        r12.setVisibility(0);
        r12.setText(r7.getNextButton().getText());
        m.a(r12, b.a);
        goto L20
    L19:
        r12.setVisibility(8);
    L20:
        CommonUiContainer r13 = this.h;
        if (r13 == null) goto L23;
        r0 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r13).b;
    L23:
        if (r0 == null) goto L31;
        TextView r14 = (TextView) r0.findViewById(2131391539);
        if (r14 == null) goto L32;
        SwitchButton r15 = r7.getSwitchButton();
        if (r15 == null) goto L29;
        r14.setVisibility(0);
        r14.setText(r15.getText());
        m.a(r14, new c(r15, this));
        return;
    L29:
        r14.setVisibility(8);
        return;
    L32:
        return;
    L31:
        return;
    L11:
        r11 = null;
        goto L13
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.h != null) goto L5;
        int r4 = CommonUiContainer.j;
        this.h = CommonUiContainer.b.a(requireActivity(), 2131564876, r2);
    L5:
        CommonUiContainer r5 = this.h;
        if (r5 != null) goto L10;
        return null;
    L10:
        return ((com.ss.android.lark.flow.passport.ui.widget.common.a) r5).b;
    }
}
