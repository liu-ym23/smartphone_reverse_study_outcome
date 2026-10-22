package com.ss.android.lark.passport.flow.verify.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.larksuite.component.universe_design.toast.UDToast;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.flow.passport.ui.widget.common.CodeView;
import com.ss.android.lark.flow.passport.ui.widget.common.CommonUiContainer;
import com.ss.android.lark.flow.passport.ui.widget.common.FlowBaseFragment;
import com.ss.android.lark.flow.passport.ui.widget.common.g;
import com.ss.android.lark.flow.passport.ui.widget.layout.MaxWidthLinerLayout;
import com.ss.android.lark.flow.passport.ui.widget.utils.FlowUtilKt;
import com.ss.android.lark.flow.passport.ui.widget.verifycode.VerifyCodeEditText;
import com.ss.android.lark.passport.base.core.log.PassportLog;
import com.ss.android.lark.passport.flow.core.model.ButtonType;
import com.ss.android.lark.passport.flow.core.network.handler.h;
import com.ss.android.lark.passport.flow.core.router.PassportRouterResult;
import com.ss.android.lark.passport.flow.verify.entity.AuthMethod;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.SwitchButton;
import com.ss.android.lark.passport.flow.verify.viewmodel.AuthListViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCodeViewModel;
import com.ss.android.lark.passport.flow.verify.viewmodel.VerifyCommonViewModel;
import com.ss.android.lark.picker.base.view.ItemViewType;
import com.suite.lark.emm.design.edittext.SCEditText;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import uzb.l;
import uzb.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\"\u001a\u0004\u0018\u00010#2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020*H\u0002J\u0018\u00100\u001a\u00020*2\u0006\u0010-\u001a\u00020.2\u0006\u00101\u001a\u000202H\u0002R\u001f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\t\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\r\u001a\u0004\b\f\u0010\bR\u001f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00058BX\u0082\u0084\u0002¢\u0006\n\n\u0002\b\u0011\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/ss/android/lark/passport/flow/verify/view/VerifyCodeFragment;", "Lcom/ss/android/lark/flow/passport/ui/widget/common/FlowBaseFragment;", "<init>", "()V", "commonViewModel", "Lkotlin/Lazy;", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCommonViewModel;", "getCommonViewModel", "()Lkotlin/Lazy;", "commonViewModel$delegate", "authListViewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/AuthListViewModel;", "getAuthListViewModel", "authListViewModel$delegate", "viewModel", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel;", "getViewModel", "viewModel$delegate", "repo", "Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "getRepo", "()Lcom/ss/android/lark/passport/flow/verify/model/StepInfoRepository;", "rootView", "Landroid/view/ViewGroup;", "getRootView", "()Landroid/view/ViewGroup;", "uiContainer", "Lcom/ss/android/lark/flow/passport/ui/widget/common/CommonUiContainer;", "verifyEditText", "Lcom/ss/android/lark/flow/passport/ui/widget/verifycode/VerifyCodeEditText;", "preCode", "", "mOnTextChangeListener", "Lcom/ss/android/lark/flow/passport/ui/widget/verifycode/VerifyCodeEditText$OnTextChangeListener;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setApplyCodeText", "tvCountDown", "Landroid/widget/TextView;", "initVerifyEditText", "countDownViewUpdate", "time", "", "Companion", "flow-passport-mfa_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class VerifyCodeFragment extends FlowBaseFragment {
    public static final /* synthetic */ int m = 0;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public CommonUiContainer i;
    public VerifyCodeEditText j;
    public String k;
    public final b l;

    public static final class a {
    }

    public static final class b implements VerifyCodeEditText.e {
        public final /* synthetic */ VerifyCodeFragment a;

        public b(VerifyCodeFragment r1) {
            this.a = r1;
        }

        public final void a(String r4) {
            if (TextUtils.equals(this.a.k, r4) == false) goto L5;
            return;
        L5:
            VerifyCodeFragment r0 = this.a;
            Intrinsics.checkNotNull(r4);
            r0.k = r4;
            if (TextUtils.isEmpty(r4) == false) goto L8;
            return;
        L8:
            if (r4.length() != 6) goto L12;
            uzb.f.b(this.a.getContext());
            int r1 = VerifyCodeFragment.V90(this.a).a;
            ((VerifyCodeViewModel) this.a.W90().getValue()).reduce(new VerifyCodeViewModel.a.c(r1, r4));
            return;
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$ViewState;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<VerifyCodeViewModel.d, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1$a */
        public static final class a implements View.OnClickListener {
            public final /* synthetic */ VerifyCodeFragment a;
            public final /* synthetic */ LinearLayout b;

            public a(VerifyCodeFragment r1, LinearLayout r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r2) {
                PassportLog.d("VerifyCodeFragment", "Recover account clicked");
                VerifyCodeFragment r3 = this.a;
                int r0 = VerifyCodeFragment.m;
                ((VerifyCodeViewModel) r3.W90().getValue()).reduce(VerifyCodeViewModel.a.b.a);
                uzb.f.b(this.b.getContext());
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$1$b */
        public static final class b implements View.OnClickListener {
            public final /* synthetic */ SwitchButton a;
            public final /* synthetic */ VerifyCodeFragment b;

            public b(SwitchButton r1, VerifyCodeFragment r2) {
                this.a = r1;
                this.b = r2;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View r4) {
                if (this.a.getActionType() != ButtonType.SWITCH_AUTH.getValue()) goto L6;
                ((AuthListViewModel) ((Lazy) this.b.g.getValue()).getValue()).reduce(AuthListViewModel.a.C0086a.a);
                return;
            L6:
                if (VerifyCodeFragment.V90(this.b).d(this.a.getActionType()) == false) goto L11;
                String r5 = VerifyCodeFragment.V90(this.b).a(this.a.getActionType());
                if (r5 == null) goto L15;
                UDToast.show(this.b.requireContext(), r5);
                return;
            L15:
                return;
            L11:
                AuthMethod r6 = VerifyCodeFragment.V90(this.b).b(this.a.getActionType());
                if (r6 == null) goto L17;
                VerifyCodeFragment r0 = this.b;
                ((AuthListViewModel) ((Lazy) r0.g.getValue()).getValue()).reduce(new AuthListViewModel.a.b(r0.requireContext(), r6));
                return;
            }
        }

        public AnonymousClass1(VerifyCodeFragment r1, TextView r2, Continuation<? super AnonymousClass1> r3) {
            this.this$0 = r1;
            this.$tvCountDown = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass1 r0 = new AnonymousClass1(this.this$0, this.$tvCountDown, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(VerifyCodeViewModel.d r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyCodeViewModel.d) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r11) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L49;
            ResultKt.throwOnFailure(r11);
            VerifyCodeViewModel.d r12 = (VerifyCodeViewModel.d) this.L$0;
            if ((r12 instanceof VerifyCodeViewModel.d.b) == false) goto L45;
            PassportLog.d("VerifyCodeFragment", "collect viewState: " + r12);
            CommonUiContainer r0 = this.this$0.i;
            if (r0 == null) goto L9;
            r0.b(((VerifyCodeViewModel.d.b) r12).a.getTitle());
        L9:
            CommonUiContainer r1 = this.this$0.i;
            if (r1 == null) goto L12;
            r1.a(((VerifyCodeViewModel.d.b) r12).a.getSubTitle());
        L12:
            ViewGroup r2 = this.this$0.getRootView();
            if (r2 == null) goto L25;
            TextView r3 = (TextView) r2.findViewById(2131390414);
            if (r3 == null) goto L25;
            VerifyCodeFragment r4 = this.this$0;
            TextView r5 = this.$tvCountDown;
            xyb.a r6 = VerifyCodeFragment.V90(r4);
            r6.getClass();
            boolean r7 = CollectionsKt.listOf(new Integer[]{Integer.valueOf(ButtonType.VERIFY_PHONE.getValue()), Integer.valueOf(ButtonType.VERIFY_EMAIL.getValue())}).contains(Integer.valueOf(r6.a));
            PassportLog.d("VerifyCodeFragment", "needCountDown: " + r7);
            if (r7 == false) goto L19;
            int r8 = 0;
        L20:
            r3.setVisibility(r8);
            if (r7 == false) goto L25;
            if (r5 == null) goto L24;
            VerifyCodeFragment.U90(r4, r5, ((VerifyCodeViewModel) r4.W90().getValue()).getCurTime());
        L24:
            ((VerifyCodeViewModel) r4.W90().getValue()).reduce(VerifyCodeViewModel.a.C0087a.a);
            goto L25
        L19:
            r8 = 8;
        L25:
            ViewGroup r9 = this.this$0.getRootView();
            if (r9 == null) goto L37;
            LinearLayout r10 = (LinearLayout) r9.findViewById(2131378818);
            if (r10 == null) goto L37;
            VerifyCodeFragment r13 = this.this$0;
            ButtonBean r14 = ((VerifyCodeViewModel.d.b) r12).a.getRetrieveButton();
            if (r14 == null) goto L36;
            r10.setVisibility(0);
            ((TextView) r10.findViewById(2131391259)).setText(r14.getText());
            TextView r15 = (TextView) r10.findViewById(2131391260);
            if (VerifyCodeFragment.V90(r13).a != ButtonType.VERIFY_OTP.getValue()) goto L34;
            r15.setText(2131892505);
        L35:
            m.a(r15, new a(r13, r10));
            goto L37
        L34:
            r15.setText(2131892341);
            goto L35
        L36:
            r10.setVisibility(8);
        L37:
            ViewGroup r16 = this.this$0.getRootView();
            if (r16 == null) goto L47;
            TextView r17 = (TextView) r16.findViewById(2131391539);
            if (r17 == null) goto L47;
            VerifyCodeFragment r18 = this.this$0;
            SwitchButton r19 = ((VerifyCodeViewModel.d.b) r12).a.getSwitchButton();
            if (r19 == null) goto L44;
            r17.setVisibility(0);
            r17.setText(r19.getText());
            m.a(r17, new b(r19, r18));
            goto L47
        L44:
            r17.setVisibility(8);
        L47:
            return Unit.INSTANCE;
        L45:
            PassportLog.b("VerifyCodeFragment", "collect viewState missed");
            goto L47
        L49:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u00012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lkotlin/Triple;", ""}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$2", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<Triple<? extends Integer, ? extends Integer, ? extends Integer>, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        public AnonymousClass2(TextView r1, VerifyCodeFragment r2, Continuation<? super AnonymousClass2> r3) {
            this.$tvCountDown = r1;
            this.this$0 = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass2 r0 = new AnonymousClass2(this.$tvCountDown, this.this$0, r5);
            r0.L$0 = r4;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((Triple) r1, (Continuation) r2);
        }

        public final Object invoke(Triple<Integer, Integer, Integer> r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r3) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L23;
            ResultKt.throwOnFailure(r3);
            Triple r4 = (Triple) this.L$0;
            TextView r0 = this.$tvCountDown;
            if (r0 == null) goto L21;
            if (r0.getVisibility() != 0) goto L21;
            int r1 = VerifyCodeFragment.V90(this.this$0).a;
            if (r1 != ButtonType.VERIFY_PHONE.getValue()) goto L13;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r4.getFirst()).intValue());
        L19:
            return Unit.INSTANCE;
        L13:
            if (r1 != ButtonType.VERIFY_SPARE.getValue()) goto L16;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r4.getSecond()).intValue());
            goto L19
        L16:
            if (r1 != ButtonType.VERIFY_EMAIL.getValue()) goto L19;
            VerifyCodeFragment.U90(this.this$0, this.$tvCountDown, ((Number) r4.getThird()).intValue());
        L21:
            return Unit.INSTANCE;
        L23:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/passport/flow/verify/viewmodel/VerifyCodeViewModel$UIEvent;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
    @DebugMetadata(c = "com.ss.android.lark.passport.flow.verify.view.VerifyCodeFragment$onViewCreated$3", f = "VerifyCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<VerifyCodeViewModel.c, Continuation<? super Unit>, Object> {
        final /* synthetic */ TextView $tvCountDown;
        /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ VerifyCodeFragment this$0;

        public AnonymousClass3(VerifyCodeFragment r1, TextView r2, Continuation<? super AnonymousClass3> r3) {
            this.this$0 = r1;
            this.$tvCountDown = r2;
            super(2, r3);
        }

        public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
            AnonymousClass3 r0 = new AnonymousClass3(this.this$0, this.$tvCountDown, r5);
            r0.L$0 = r4;
            return r0;
        }

        public final Object invoke(VerifyCodeViewModel.c r1, Continuation<? super Unit> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((VerifyCodeViewModel.c) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L60;
            ResultKt.throwOnFailure(r4);
            VerifyCodeViewModel.c r5 = (VerifyCodeViewModel.c) this.L$0;
            if ((r5 instanceof VerifyCodeViewModel.c.a) == false) goto L20;
            VerifyCodeEditText r6 = this.this$0.j;
            if (r6 == null) goto L15;
            r6.a.setText("");
            int r1 = 0;
        L10:
            if (r1 >= r6.e) goto L15;
            r6.d[r1].c();
            if (r1 != 0) goto L14;
            r6.d[r1].e();
        L14:
            r1 = r1 + 1;
        L15:
            VerifyCodeEditText r7 = this.this$0.j;
            if (r7 == null) goto L18;
            r7.b();
        L18:
            this.this$0.k = "";
        L56:
            return Unit.INSTANCE;
        L20:
            if ((r5 instanceof VerifyCodeViewModel.c.i) == false) goto L23;
            this.this$0.T90();
            goto L56
        L23:
            if ((r5 instanceof VerifyCodeViewModel.c.b) == false) goto L26;
            this.this$0.S90();
            goto L56
        L26:
            if ((r5 instanceof VerifyCodeViewModel.c.d) == false) goto L31;
            VerifyCodeEditText r8 = this.this$0.j;
            if (r8 == null) goto L56;
            r8.b();
            goto L56
        L31:
            if ((r5 instanceof VerifyCodeViewModel.c.g) == false) goto L38;
            AtomicReference<syb.b> r0 = com.ss.android.lark.passport.flow.core.router.a.c;
            VerifyCodeViewModel.c.g r9 = (VerifyCodeViewModel.c.g) r5;
            PassportRouterResult r10 = com.ss.android.lark.passport.flow.core.router.a.C0085a.a(this.this$0.requireContext(), r9.a.getNextStep(), r9.a.getStepInfo());
            this.this$0.S90();
            if (r10.a() == false) goto L56;
            FragmentActivity r11 = this.this$0.getActivity();
            if (r11 == null) goto L56;
            r11.finish();
            goto L56
        L38:
            if ((r5 instanceof VerifyCodeViewModel.c.e) == false) goto L43;
            this.this$0.S90();
            FragmentActivity r12 = this.this$0.getActivity();
            if (r12 == null) goto L56;
            r12.finish();
            goto L56
        L43:
            if ((r5 instanceof VerifyCodeViewModel.c.h) == false) goto L48;
            Context r2 = this.this$0.getContext();
            if (r2 == null) goto L56;
            UDToast.show(r2, ((VerifyCodeViewModel.c.h) r5).a);
            goto L56
        L48:
            if ((r5 instanceof VerifyCodeViewModel.c.f) == false) goto L51;
            int r3 = h.a;
            Boxing.boxBoolean(h.b(this.this$0.getContext(), ((VerifyCodeViewModel.c.f) r5).a));
            goto L56
        L51:
            if ((r5 instanceof VerifyCodeViewModel.c.C0088c) == false) goto L58;
            TextView r13 = this.$tvCountDown;
            if (r13 == null) goto L56;
            VerifyCodeFragment r14 = this.this$0;
            int r15 = VerifyCodeFragment.m;
            r13.setText(l.getResources(r14.getContext()).getString(2131892345));
            r13.setTextColor(l.b(r14.getContext(), 2131105548));
            r13.setEnabled(true);
            m.a(r13, new com.ss.android.lark.passport.flow.verify.view.b(r14));
            goto L56
        L58:
            throw new NoWhenBranchMatchedException();
        L60:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    public final Lazy<VerifyCodeViewModel> W90() {
        return (Lazy) this.h.getValue();
    }

    public final ViewGroup getRootView() {
        CommonUiContainer r0 = this.i;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((com.ss.android.lark.flow.passport.ui.widget.common.a) r0).b;
    }

    public VerifyCodeFragment() {
        this.f = LazyKt.lazy(new VerifyCodeFragment$commonViewModel$2(this));
        this.g = LazyKt.lazy(new VerifyCodeFragment$authListViewModel$2(this));
        this.h = LazyKt.lazy(new VerifyCodeFragment$viewModel$2(this));
        this.k = "";
        this.l = new b(this);
    }

    public static final xyb.a V90(VerifyCodeFragment r0) {
        return (xyb.a) ((VerifyCommonViewModel) ((Lazy) r0.f.getValue()).getValue()).getRepo().getValue();
    }

    public final void onViewCreated(View r17, Bundle r18) {
        Intrinsics.checkNotNullParameter(r17, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r17, r18);
        PassportLog.d("VerifyCodeFragment", "VerifyCodeFragment onViewCreated start");
        ViewGroup r0 = getRootView();
        if (r0 == null) goto L5;
        VerifyCodeEditText r1 = (VerifyCodeEditText) r0.findViewById(2131392865);
    L6:
        this.j = r1;
        int r3 = 0;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        VerifyCodeEditText r4 = this.j;
        if (r4 == null) goto L30;
        Context r2 = getContext();
        Color.rgb(51, 119, 255);
        Color.rgb(20, 31, 51);
        Color.rgb(237, 237, 240);
        Color.rgb(51, 119, 255);
        Color.rgb(255, 91, 76);
        int r6 = l.b(r2, 2131105548);
        int r8 = l.b(r2, 2131106622);
        int r9 = l.b(r2, 2131103352);
        int r5 = l.b(r2, 2131105548);
        int r10 = l.b(r2, 2131102189);
        r4.e = 6;
        SCEditText r7 = new SCEditText(r4.b);
        r4.a = r7;
        r7.setId(2131386489);
        Field r11 = TextView.class.getDeclaredField("mCursorDrawableRes");     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        r11.setAccessible(true);     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
        r11.set(r4.a, 2131248227);     // Catch: IllegalAccessException -> L14 NoSuchFieldException -> L16
    L18:
        r4.a.setCursorVisible(false);
        r4.a.setBackgroundColor(0);
        r4.a.setTextSize(0.0f);
        r4.a.setInputType(2);
        r4.a.setImeOptions(6);
        r4.a.addTextChangedListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.a(r4));
        r4.a.setOnEditorActionListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.b(r4));
        r4.addView(r4.a, new RelativeLayout.LayoutParams(-1, -1));
        r4.a.setOnLongClickListener(new uhb.a(r4));
        r4.a.setOnClickListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.c(r4));
        r4.a.setOnFocusChangeListener(new com.ss.android.lark.flow.passport.ui.widget.verifycode.d(r4));
        MaxWidthLinerLayout r12 = new MaxWidthLinerLayout(r4.b);
        r4.c = r12;
        r12.setBackgroundColor(0);
        r4.c.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        r4.c.setOrientation(0);
        r4.c.setClipChildren(false);
        r4.setClipChildren(false);
        r4.addView(r4.c);
        r4.d = new CodeView[r4.e];
        CodeView.a r13 = new CodeView.a(r4.getContext());
        r13.c = r6;
        r13.b = true;
        r13.g = r5;
        r13.f = r9;
        r13.a = true;
        r13.d = 22;
        r13.e = r8;
        r13.i = 2;
        r13.h = r10;
        LinearLayout.LayoutParams r14 = new LinearLayout.LayoutParams(0, -2);
        r14.weight = 1.0f;
        int r15 = 17;
        r14.gravity = 17;
        float r16 = 10;
        Resources r19 = r4.b.getResources();
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams((int) ((WindowDisplayMetricsOverride.apply(r19, r19.getDisplayMetrics()).density * r16) + 0.5f), -1);
        int r21 = r4.d.length;
        int r110 = 0;
    L19:
        if (r110 >= r21) goto L29;
        r4.d[r110] = new CodeView(r4.b);
        CodeView r22 = r4.d[r110];
        r22.removeAllViews();
        r22.d = r13;
        r22.e.a(g.a, r13.f);
        r22.e.a(g.b, r22.d.g);
        r22.e.a(g.c, r22.d.h);
        r22.a = new TextView(r22.getContext());
        RelativeLayout.LayoutParams r23 = new RelativeLayout.LayoutParams(-2, -1);
        r23.addRule(14, -1);
        r22.a.setTextColor(r13.e);
        r22.a.setTextSize(r13.d);
        TextView r24 = r22.a;
        int r111 = h18.e.a;
        r24.setTypeface(h18.e.b(r22.getContext(), 1));
        r22.a.setGravity(r15);
        r22.a.setId(2131386487);
        r22.a.setInputType(r13.i);
        r22.addView(r22.a, r23);
        r22.b = new View(r22.getContext());
        RelativeLayout.LayoutParams r25 = new RelativeLayout.LayoutParams(r22.a(1.5f), -1);
        r25.addRule(1, 2131386487);
        r25.bottomMargin = r22.a(10.0f);
        r25.topMargin = r22.a(10.0f);
        r22.b.setBackgroundColor(r13.c);
        r22.addView(r22.b, r25);
        r22.setBackground(r22.e);
        r22.c();
        if ((r21 / 2) != r110) goto L24;
        View r26 = new View(r4.b);
        LinearLayout.LayoutParams r27 = new LinearLayout.LayoutParams(l.a(r4.b, 10.0f), l.a(r4.b, 2.0f));
        r27.gravity = 16;
        r26.setBackgroundColor(r4.b.getResources().getColor(2131106622));
        r4.c.addView(r26, r27);
        Resources r28 = r4.b.getResources();
        LinearLayout.LayoutParams r29 = new LinearLayout.LayoutParams((int) ((WindowDisplayMetricsOverride.apply(r28, r28.getDisplayMetrics()).density * r16) + 0.5f), -1);
        View r30 = new View(r4.b);
        r30.setBackgroundColor(0);
        r4.c.addView(r30, r29);
    L24:
        r4.c.addView(r4.d[r110], r14);
        if (r110 >= (r4.d.length - 1)) goto L27;
        View r31 = new View(r4.b);
        r3 = 0;
        r31.setBackgroundColor(0);
        r4.c.addView(r31, r20);
    L28:
        r110 = r110 + 1;
        r15 = 17;
        goto L19
    L27:
        r3 = 0;
        goto L28
    L29:
        r4.a(r4.a.getText());
        r4.a.post(new uhb.b(r4));
        goto L30
    L14:
        e = move-exception;
        e.printStackTrace();
    L16:
        e = move-exception;
        e.printStackTrace();
    L30:
        VerifyCodeEditText r32 = this.j;
        if (r32 == null) goto L33;
        r32.setOnTextFinishListener(new com.ss.android.lark.passport.flow.verify.view.a(this));
    L33:
        VerifyCodeEditText r33 = this.j;
        if (r33 == null) goto L36;
        r33.setOnTextChangeListener(this.l);
    L36:
        VerifyCodeEditText r34 = this.j;
        if (r34 == null) goto L39;
        r34.b();
    L39:
        VerifyCodeEditText r35 = this.j;
        if (r35 == null) goto L51;
        CodeView[] r36 = r35.d;
        if (r36 == null) goto L51;
        int r37 = r36.length;
    L45:
        if (r3 >= r37) goto L51;
        r36[r3].d();
        int r38 = r35.a.getText().length();
        int r39 = r35.e;
        if (r38 < r39) goto L49;
        r35.d[r39 - 1].f();
    L50:
        r3 = r3 + 1;
        goto L45
    L49:
        r35.d[r38].f();
    L51:
        ViewGroup r40 = getRootView();
        if (r40 == null) goto L54;
        TextView r41 = (TextView) r40.findViewById(2131390414);
    L55:
        FlowUtilKt.c(this, ((VerifyCodeViewModel) W90().getValue()).getViewState(), new AnonymousClass1(this, r41, null));
        FlowUtilKt.c(this, ((VerifyCodeViewModel) W90().getValue()).getCountDownTime(), new AnonymousClass2(r41, this, null));
        FlowUtilKt.c(this, ((VerifyCodeViewModel) W90().getValue()).getEventState(), new AnonymousClass3(this, r41, null));
        ((VerifyCodeViewModel) W90().getValue()).init();
        return;
    L54:
        r41 = null;
        goto L55
    L5:
        r1 = null;
        goto L6
    }

    public static final void U90(VerifyCodeFragment r3, TextView r4, int r5) {
        Context r0 = r3.getContext();
        String r6 = String.valueOf(r5);
        String r1 = l.getResources(r0).getString(2131892338);
        if (r6 == null) goto L10;
        HashMap r2 = new HashMap(1);
        r2.put("time", r6);
        r1 = com.samskivert.mustache.e.a().b().a(r1).b(r2);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        PassportLog.c("UIUtils", "mustacheFormat error", e);
    L10:
        r4.setText(r1);
        r4.setTextColor(l.b(r3.getContext(), 2131106620));
        r4.setEnabled(false);
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
