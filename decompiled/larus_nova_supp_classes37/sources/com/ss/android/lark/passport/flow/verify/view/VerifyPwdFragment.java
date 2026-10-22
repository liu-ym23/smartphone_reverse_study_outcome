package com.ss.android.lark.passport.flow.verify.view;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.component.universe_design.toast.UDToast;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.common.g;
import com.ss.android.lark.flow.passport.ui.widget.common.h;
import com.ss.android.lark.flow.passport.ui.widget.layout.BaseContainerLayout;
import com.ss.android.lark.flow.passport.ui.widget.password.PasswordEditText;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.InputBean;
import com.ss.android.lark.passport.flow.verify.entity.SwitchButton;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyPwdViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.ViewUtils;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
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
import kotlin.text.StringsKt;
import uzb.l;
import uzb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 *2\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u00192\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u001a\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010(\u001a\u00020&H\u0002J\b\u0010)\u001a\u00020&H\u0016R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyPwdFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "authListViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getAuthListViewModel", "authListViewModel$delegate", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel;", "getViewModel", "viewModel$delegate", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "pwdEditText", "Lcom/ss/android/lark/flow/passport/ui/widget/password/PasswordEditText;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initEditText", "onDestroy", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyPwdFragment extends FlowBaseFragment {
    public static final /* synthetic */ int k = 0;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public PasswordEditText i;
    public CommonUiContainer j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$1", f = "VerifyPwdFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<VerifyPwdViewModel.d, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyPwdFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$1$a */
        public static final class a implements View.OnClickListener {
            public final /* synthetic */ VerifyPwdFragment a;
            public final /* synthetic */ LinearLayout b;

            public a(VerifyPwdFragment r1, LinearLayout r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                PassportLog.d("VerifyPwdFragment", "Recover account clicked");
                PasswordEditText r3 = this.a.i;
                if (r3 == null) goto L5;
                r3.a.clearFocus();
            L5:
                ((VerifyPwdViewModel) this.a.V90().getValue()).reduce(VerifyPwdViewModel.a.C0093a.a);
                uzb.f.b(this.b.getContext());
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$1$b */
        public static final class b implements View.OnClickListener {
            public final /* synthetic */ SwitchButton a;
            public final /* synthetic */ VerifyPwdFragment b;

            public b(SwitchButton r1, VerifyPwdFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                if (this.a.getActionType() != ButtonType.SWITCH_AUTH.getValue()) goto L5;
                ((AuthListViewModel) ((Lazy) this.b.g.getValue()).getValue()).reduce(AuthListViewModel.a.C0086a.a);
                return;
            L5:
                VerifyPwdFragment r5 = this.b;
                int r0 = VerifyPwdFragment.k;
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
                VerifyPwdFragment r1 = this.b;
                ((AuthListViewModel) ((Lazy) r1.g.getValue()).getValue()).reduce(new AuthListViewModel.a.b(r1.requireContext(), r7));
                return;
            }
        }

        public AnonymousClass1(VerifyPwdFragment r1, Continuation<? super AnonymousClass1> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyPwdViewModel.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyPwdViewModel.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r9) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L69;
            ResultKt.throwOnFailure(r9);
            VerifyPwdViewModel.d r10 = (VerifyPwdViewModel.d) this.L$0;
            if ((r10 instanceof VerifyPwdViewModel.d.b) == false) goto L65;
            CommonUiContainer r0 = this.this$0.j;
            if (r0 == null) goto L9;
            r0.b(((VerifyPwdViewModel.d.b) r10).a.getTitle());
        L9:
            CommonUiContainer r1 = this.this$0.j;
            if (r1 == null) goto L12;
            r1.a(((VerifyPwdViewModel.d.b) r10).a.getSubTitle());
        L12:
            CommonUiContainer r2 = this.this$0.j;
            BaseContainerLayout r3 = null;
            if (r2 == null) goto L44;
            ButtonBean r4 = ((VerifyPwdViewModel.d.b) r10).a.getNextButton();
            if (r4 == null) goto L17;
            String r5 = r4.getText();
        L18:
            Button r6 = (Button) r2.h.getValue();
            boolean r7 = true;
            if (r5 != null) goto L21;
        L24:
            boolean r8 = true;
        L26:
            if ((!r8) == false) goto L28;
            int r11 = 0;
        L29:
            r6.setVisibility(r11);
            ((Button) r2.h.getValue()).setText(r5);
            LinearLayout r12 = r2.e;
            Intrinsics.checkNotNullParameter(r12, "<this>");
            Intrinsics.checkNotNullParameter(r12, "<this>");
            qyb.b r13 = new qyb.b(r12);
        L31:
            if (r13.hasNext() == false) goto L39;
            if (((View) r13.next()).getVisibility() != 8) goto L35;
            boolean r14 = true;
        L37:
            if ((!r14) == false) goto L31;
        L40:
            if (r7 == false) goto L42;
            int r15 = 0;
        L43:
            r12.setVisibility(r15);
            goto L44
        L42:
            r15 = 8;
            goto L43
        L35:
            r14 = false;
            goto L37
        L39:
            r7 = false;
            goto L40
        L28:
            r11 = 8;
            goto L29
        L21:
            if (StringsKt.isBlank(r5) == true) goto L24;
            r8 = false;
            goto L26
        L17:
            r5 = null;
        L44:
            CommonUiContainer r16 = this.this$0.j;
            if (r16 == null) goto L47;
            BaseContainerLayout r17 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r16).b;
        L48:
            if (r17 == null) goto L55;
            LinearLayout r18 = (LinearLayout) r17.findViewById(2131378829);
            if (r18 == null) goto L55;
            VerifyPwdFragment r19 = this.this$0;
            ButtonBean r20 = ((VerifyPwdViewModel.d.b) r10).a.getRetrieveButton();
            if (r20 == null) goto L54;
            r18.setVisibility(0);
            ((TextView) r18.findViewById(2131391299)).setText(r20.getText());
            TextView r21 = (TextView) r18.findViewById(2131391300);
            r21.setText(2131892346);
            m.a(r21, new a(r19, r18));
            goto L55
        L54:
            r18.setVisibility(8);
        L55:
            CommonUiContainer r22 = this.this$0.j;
            if (r22 == null) goto L58;
            r3 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r22).b;
        L58:
            if (r3 == null) goto L67;
            TextView r23 = (TextView) r3.findViewById(2131391539);
            if (r23 == null) goto L67;
            VerifyPwdFragment r24 = this.this$0;
            SwitchButton r25 = ((VerifyPwdViewModel.d.b) r10).a.getSwitchButton();
            if (r25 == null) goto L64;
            r23.setVisibility(0);
            r23.setText(r25.getText());
            m.a(r23, new b(r25, r24));
            goto L67
        L64:
            r23.setVisibility(8);
        L67:
            return Unit.INSTANCE;
        L47:
            r17 = null;
            goto L48
        L65:
            PassportLog.b("VerifyPwdFragment", "collect viewState missed");
            goto L67
        L69:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyPwdViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyPwdFragment$onViewCreated$2", f = "VerifyPwdFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<VerifyPwdViewModel.c, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyPwdFragment this$0;

        public AnonymousClass2(VerifyPwdFragment r1, Continuation<? super AnonymousClass2> r2) {
            this.this$0 = r1;
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass2 r0 = new AnonymousClass2(this.this$0, r4);
            r0.L$0 = r3;
            return r0;
        }

        public final Object invoke(VerifyPwdViewModel.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyPwdViewModel.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L49;
            ResultKt.throwOnFailure(r4);
            VerifyPwdViewModel.c r5 = (VerifyPwdViewModel.c) this.L$0;
            if ((r5 instanceof VerifyPwdViewModel.c.a) == false) goto L19;
            PasswordEditText r6 = this.this$0.i;
            if (r6 != null) goto L9;
        L15:
            PasswordEditText r7 = this.this$0.i;
            if (r7 == null) goto L45;
            r7.b();
        L45:
            return Unit.INSTANCE;
        L9:
            if (r6.d == null) goto L15;
            SCEditText r0 = r6.a;
            if (r0 == null) goto L14;
            r0.setText("");
            r6.a.setTextColor(r6.d.e);
        L14:
            h r1 = r6.j;
            int r8 = r6.d.a;
            r1.getClass();
            r1.b(l.a(LarkContext.getApplication(), 1.0f), r8);
            goto L15
        L19:
            if ((r5 instanceof VerifyPwdViewModel.c.g) == false) goto L22;
            this.this$0.T90();
            goto L45
        L22:
            if ((r5 instanceof VerifyPwdViewModel.c.b) == false) goto L25;
            this.this$0.S90();
            goto L45
        L25:
            if ((r5 instanceof VerifyPwdViewModel.c.e) == false) goto L32;
            AtomicReference<syb.b> r2 = com.ss.android.lark.passport.flow.core.router.a.c;
            VerifyPwdViewModel.c.e r9 = (VerifyPwdViewModel.c.e) r5;
            PassportRouterResult r10 = com.ss.android.lark.passport.flow.core.router.a.C0085a.a(this.this$0.requireContext(), r9.a.getNextStep(), r9.a.getStepInfo());
            this.this$0.S90();
            if (r10.a() == false) goto L45;
            FragmentActivity r11 = this.this$0.getActivity();
            if (r11 == null) goto L45;
            r11.finish();
            goto L45
        L32:
            if ((r5 instanceof VerifyPwdViewModel.c.C0094c) == false) goto L37;
            this.this$0.S90();
            FragmentActivity r12 = this.this$0.getActivity();
            if (r12 == null) goto L45;
            r12.finish();
            goto L45
        L37:
            if ((r5 instanceof VerifyPwdViewModel.c.f) == false) goto L42;
            Context r3 = this.this$0.getContext();
            if (r3 == null) goto L45;
            UDToast.show(r3, ((VerifyPwdViewModel.c.f) r5).a);
            goto L45
        L42:
            if ((r5 instanceof VerifyPwdViewModel.c.d) == false) goto L47;
            int r13 = com.ss.android.lark.passport.flow.core.network.handler.h.a;
            Boxing.boxBoolean(com.ss.android.lark.passport.flow.core.network.handler.h.b(this.this$0.getContext(), ((VerifyPwdViewModel.c.d) r5).a));
            goto L45
        L47:
            throw new NoWhenBranchMatchedException();
        L49:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final xyb.a U90() {
        return (xyb.a) ((VerifyCommonViewModel) ((Lazy) this.f.getValue()).getValue()).getRepo().getValue();
    }

    public final Lazy<VerifyPwdViewModel> V90() {
        return (Lazy) this.h.getValue();
    }

    public VerifyPwdFragment() {
        this.f = LazyKt.lazy(new VerifyPwdFragment$commonViewModel$2(this));
        this.g = LazyKt.lazy(new VerifyPwdFragment$authListViewModel$2(this));
        this.h = LazyKt.lazy(new VerifyPwdFragment$viewModel$2(this));
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        PasswordEditText r0 = this.i;
        if (r0 == null) goto L10;
        Iterator r1 = ((ArrayList) r0.i).iterator();
    L6:
        if (r1.hasNext() == false) goto L16;
        Animator r2 = (Animator) r1.next();
        if (r2.isRunning() == false) goto L6;
        r2.cancel();
        goto L6
    L16:
        return;
    }

    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        PassportLog.d("VerifyPwdFragment", "onViewCreated start");
        CommonUiContainer r14 = this.j;
        if (r14 == null) goto L5;
        BaseContainerLayout r15 = ((com.ss.android.lark.flow.passport.ui.widget.common.a) r14).b;
    L6:
        if (r15 == null) goto L8;
        PasswordEditText r16 = (PasswordEditText) r15.findViewById(2131371786);
    L9:
        this.i = r16;
        CommonUiContainer r17 = this.j;
        if (r17 == null) goto L15;
        Button r18 = (Button) r17.h.getValue();
        if (r18 == null) goto L15;
        r18.setEnabled(false);
    L15:
        FragmentActivity r19 = getActivity();
        if (r19 == null) goto L53;
        InputBean r1 = U90().e.getInputBox();
        if (r1 == null) goto L21;
        String r2 = r1.getPlaceholder();
        if (r2 == null) goto L21;
    L22:
        int r3 = r19.getResources().getInteger(2131427402);
        PasswordEditText.f r4 = new PasswordEditText.f();
        r4.d = r3;
        l.b(r19, 2131102093);
        r4.c = l.b(r19, 2131102093);
        r4.a = l.b(r19, 2131103352);
        r4.b = l.b(r19, 2131105548);
        r4.g = r2;
        r4.f = l.b(r19, 2131103352);
        r4.e = l.b(r19, 2131106622);
        r4.h = 2131248225;
        PasswordEditText r110 = this.i;
        if (r110 == null) goto L25;
        r110.setVisibility(0);
    L25:
        PasswordEditText r111 = this.i;
        if (r111 == null) goto L35;
        r111.setBackground(r111.j);
        r111.removeAllViews();
        r111.d = r4;
        r111.j.a(g.a, r4.a);
        r111.j.a(g.b, r111.d.b);
        r111.j.a(g.c, r111.d.c);
        LinearLayout r5 = new LinearLayout(r111.e);
        r5.setOrientation(0);
        ViewGroup.LayoutParams r6 = new RelativeLayout.LayoutParams(-1, -1);
        r5.setId(2131386490);
        r111.addView(r5, r6);
        LinearLayout.LayoutParams r7 = new LinearLayout.LayoutParams(0, -1);
        r7.weight = 1.0f;
        r7.leftMargin = l.a(r111.getContext(), 12.0f);
        r111.a = new SCEditText(r111.e);
        Field r8 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: IllegalAccessException -> L30 NoSuchFieldException -> L32
        r8.setAccessible(true);     // Catch: IllegalAccessException -> L30 NoSuchFieldException -> L32
        r8.set(r111.a, Integer.valueOf(r4.h));     // Catch: IllegalAccessException -> L30 NoSuchFieldException -> L32
    L34:
        r111.a.setId(2131386488);
        r111.a.setCursorVisible(true);
        r111.a.setTextSize(r4.d);
        r111.a.setTextColor(r4.e);
        r111.a.setHintTextColor(r4.f);
        r111.a.setHint(r4.g);
        r111.a.setInputType(129);
        r111.a.setBackgroundColor(0);
        r111.a.setImeOptions(268435462);
        SCEditText r9 = r111.a;
        int r10 = h18.e.a;
        r9.setTypeface(h18.e.a(r111.getContext()));
        r111.a.addTextChangedListener(new com.ss.android.lark.flow.passport.ui.widget.password.a(r111));
        r111.a.setOnFocusChangeListener(new com.ss.android.lark.flow.passport.ui.widget.password.b(r111));
        r111.a.setOnClickListener(new com.ss.android.lark.flow.passport.ui.widget.password.c(r111));
        r111.a.setOnEditorActionListener(new com.ss.android.lark.flow.passport.ui.widget.password.d(r111));
        r5.addView(r111.a, r7);
        LinearLayout.LayoutParams r11 = new LinearLayout.LayoutParams(-2, -1);
        r11.gravity = 16;
        r111.c = new ImageView(r111.getContext());
        int r20 = UDColorUtils.getColor(r111.e, 2131102420);
        r111.c.setImageDrawable(UDIconUtils.getIconDrawable(r111.e, 2131248220, r20));
        r111.c.setPadding(r111.a(4.0f), 0, r111.a(10.0f), 0);
        r111.c.setScaleType(ImageView.ScaleType.CENTER);
        r111.c.setOnClickListener(new com.ss.android.lark.flow.passport.ui.widget.password.e(r111));
        r111.c.setVisibility(8);
        r5.addView(r111.c, r11);
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-2, -1);
        r21.gravity = 16;
        CheckBox r22 = new CheckBox(r111.e);
        r111.b = r22;
        r22.setChecked(false);
        r111.b.setButtonDrawable(UDIconUtils.getIconDrawable(r111.e, 2131248224, r20));
        r111.b.setPadding(r111.a(2.0f), 0, r111.a(12.0f), 0);
        r111.b.setOnCheckedChangeListener(new com.ss.android.lark.flow.passport.ui.widget.password.f(r111));
        r5.addView(r111.b, r21);
        goto L35
    L30:
        e = move-exception;
        e.printStackTrace();
    L32:
        e = move-exception;
        e.printStackTrace();
    L35:
        PasswordEditText r112 = this.i;
        if (r112 == null) goto L38;
        r112.b();
    L38:
        PasswordEditText r113 = this.i;
        if (r113 == null) goto L41;
        r113.setTextChangeListener(new c(this));
    L41:
        PasswordEditText r114 = this.i;
        if (r114 == null) goto L44;
        r114.setOnInputCompleteListener(new d(this));
    L44:
        PasswordEditText r115 = this.i;
        if (r115 == null) goto L47;
        r115.setOnKeyboardDetectorListener(new e());
    L47:
        CommonUiContainer r116 = this.j;
        if (r116 == null) goto L53;
        f r23 = new f(this);
        Button r117 = (Button) r116.h.getValue();
        if (r117 == null) goto L53;
        m.a(r117, r23);
    L21:
        r2 = r19.getString(2131892343);
    L53:
        Activity r118 = ViewUtils.getActivityByContext(getActivity());
        if (r118 == null) goto L57;
        ((InputMethodManager) r118.getSystemService("input_method")).toggleSoftInput(2, 0);
    L57:
        FlowUtilKt.c(this, ((VerifyPwdViewModel) V90().getValue()).getViewState(), new AnonymousClass1(this, null));
        FlowUtilKt.c(this, ((VerifyPwdViewModel) V90().getValue()).getEventState(), new AnonymousClass2(this, null));
        ((VerifyPwdViewModel) V90().getValue()).init();
        return;
    L8:
        r16 = null;
        goto L9
    L5:
        r15 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        if (this.j != null) goto L5;
        int r4 = CommonUiContainer.j;
        this.j = CommonUiContainer.b.a(requireActivity(), 2131564876, r2);
    L5:
        CommonUiContainer r5 = this.j;
        if (r5 != null) goto L10;
        return null;
    L10:
        return ((com.ss.android.lark.flow.passport.ui.widget.common.a) r5).b;
    }
}
