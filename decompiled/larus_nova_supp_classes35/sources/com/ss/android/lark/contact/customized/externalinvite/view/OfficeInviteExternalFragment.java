package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.supervisor.token.Token;
import com.bytedance.supervisor.wrapper.common.SensitiveAPIException;
import com.larksuite.component.ui.imageview.LKUIRoundedImageView2;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.compose.foundation.toast.FlowToast;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeEmptyStateView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeTitleBar;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.statistics.Statistics;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.widget.recyclerview.item.BaseItemAdapter;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u001a\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010 \u001a\u00020\u001eH\u0002J\b\u0010!\u001a\u00020\u001eH\u0002J\b\u0010\"\u001a\u00020\u001eH\u0002J\b\u0010#\u001a\u00020\u001eH\u0002J\b\u0010$\u001a\u00020\u001eH\u0002J\b\u0010%\u001a\u00020\u001eH\u0002J\b\u0010&\u001a\u00020\u001eH\u0002J\u000e\u0010'\u001a\b\u0012\u0004\u0012\u00020)0(H\u0002J\u0010\u0010*\u001a\u00020\u001e2\u0006\u0010+\u001a\u00020,H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\r\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "from", BuildConfig.FLAVOR, "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteExternalViewFeishuBinding;", "viewModel", "Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "qrCodeHandler", "Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "getQrCodeHandler", "()Lcom/ss/android/lark/officesdk/qrcode/api/IOpenFeishuQRCodeSDKProtocal;", "qrCodeHandler$delegate", "showLoadingRunnable", "Ljava/lang/Runnable;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initData", "initView", "copyDoubaoId", "showLoading", "dismissLoading", "cancelDelayedLoading", "showError", "getExternalItems", BuildConfig.FLAVOR, "Lcom/ss/android/lark/contact/customized/externalinvite/view/OfficeInviteExternalItem;", "bindQrCard", "info", "Lcom/ss/android/lark/contact/base/entity/bean/InvitationInfo;", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalFragment extends InvBaseFragment {
    public static final /* synthetic */ int i = 0;
    public String d;
    public ContactDbInviteExternalViewFeishuBinding e;
    public final Lazy f;
    public final Lazy g;
    public j h;

    public static final class a {
    }

    static {
    }

    public final OfficeInviteExternalViewModel U90() {
        return (OfficeInviteExternalViewModel) this.f.getValue();
    }

    public OfficeInviteExternalFragment() {
        final Function0<Fragment> r0 = new OfficeInviteExternalFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeInviteExternalViewModel.class), new OfficeInviteExternalFragment$special$$inlined$viewModels$default$2(r0), new OfficeInviteExternalFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = LazyKt.lazy(OfficeInviteExternalFragment$qrCodeHandler$2.INSTANCE);
    }

    public static final void S90(OfficeInviteExternalFragment r7) {
        r7.getClass();
        String r0 = ((x1c.d) OfficeContactUtils.a.getValue()).y1().b;
        Intrinsics.checkNotNullParameter("LARK-PSDA-ug-invite-external", "psdaToken");
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == false) goto L23;
    L15:
        r1 = false;
    L16:
        if (r1 == false) goto L25;
        ContactDbInviteExternalViewFeishuBinding r8 = r7.e;
        if (r8 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L21:
        FlowToast.a r9 = FlowToast.a(r8.a.getContext());
        String r2 = UIHelper.getString(2131890029);
        Intrinsics.checkNotNullParameter(r2, "value");
        r9.b = r2;
        r9.c = UDIconUtils.getIconDrawable(r9.a, 2131233642);
        r9.c(49, 0, UIHelper.dp2px(44.0f));
        r9.a().show();
        return;
    L25:
        return;
    L23:
        Token r5 = new Token("LARK-PSDA-ug-invite-external");     // Catch: SensitiveAPIException -> L13
        qf7.a r3 = qf7.a.a;     // Catch: SensitiveAPIException -> L13
        Object r6 = LarkContext.getApplication().getSystemService("clipboard");     // Catch: SensitiveAPIException -> L13
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: SensitiveAPIException -> L13
        r3.a((ClipboardManager) r6, ClipData.newPlainText("text", r0), r5);     // Catch: SensitiveAPIException -> L13
    L13:
        e = move-exception;
        Log.e("Contact_Utils", "copyText error", e);
        goto L15
    L5:
        if (r0.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    public static final void T90(OfficeInviteExternalFragment r4) {
        j r0 = r4.h;
        ContactDbInviteExternalViewFeishuBinding r2 = null;
        if (r0 == null) goto L9;
        ContactDbInviteExternalViewFeishuBinding r3 = r4.e;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L8:
        r3.a.removeCallbacks(r0);
        r4.h = null;
    L9:
        ContactDbInviteExternalViewFeishuBinding r1 = r4.e;
        if (r1 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L12:
        r1.d.a();
        ContactDbInviteExternalViewFeishuBinding r5 = r4.e;
        if (r5 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L15:
        r5.c.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r6 = r4.e;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L19:
        if (r6.b.getVisibility() == 0) goto L26;
        ContactDbInviteExternalViewFeishuBinding r7 = r4.e;
        if (r7 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L24:
        r2.o.setVisibility(0);
        return;
    L23:
        r2 = r7;
        goto L24
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super.onViewCreated(r8, r9);
        Context r10 = getContext();
        if (r10 == null) goto L5;
        Lazy r11 = OfficeContactUtils.a;
        OfficeContactUtils.e(this, UIUtils.getColor(r10, 2131102022));
    L5:
        Bundle r12 = getArguments();
        ContactDbInviteExternalViewFeishuBinding r13 = null;
        if (r12 == null) goto L8;
        String r14 = r12.getString("from_scenes");
    L9:
        this.d = r14;
        ContactDbInviteExternalViewFeishuBinding r15 = this.e;
        if (r15 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L12:
        r15.l.setVisibility(0);
        if (OfficeContactUtils.f() == false) goto L18;
        ContactDbInviteExternalViewFeishuBinding r16 = this.e;
        if (r16 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r16 = null;
    L17:
        r16.q.setTitle(UIHelper.getString(2131892414));
    L18:
        ContactDbInviteExternalViewFeishuBinding r17 = this.e;
        if (r17 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L21:
        r17.q.setLeftIconClickListener(new c(this));
        ICUUtils.FormatArgsBuilder r18 = new ICUUtils.FormatArgsBuilder();
        r18.b("brandName", UIHelper.getAppName());
        List r19 = r18.a;
        ContactDbInviteExternalViewFeishuBinding r2 = this.e;
        if (r2 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L24:
        r2.p.setText(ICUUtils.icuFormat(UIHelper.getString(2131890076), r19));
        ContactDbInviteExternalViewFeishuBinding r20 = this.e;
        if (r20 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r20 = null;
    L27:
        ViewCompat.setTransitionName(r20.n, "contact_db_transition_invite_search_bar");
        ContactDbInviteExternalViewFeishuBinding r21 = this.e;
        if (r21 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r21 = null;
    L30:
        r21.n.setOnClickListener(new d(this));
        ContactDbInviteExternalViewFeishuBinding r22 = this.e;
        if (r22 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L33:
        r22.n.setOnLongClickListener(new e(this));
        BaseItemAdapter r23 = new BaseItemAdapter();
        ArrayList r3 = new ArrayList();
        r3.add(new k(UIHelper.getString(2131890074), UIHelper.getString(2131890073), new com.ss.android.lark.contact.customized.externalinvite.view.a(this)));
        r23.a = r3;
        ContactDbInviteExternalViewFeishuBinding r4 = this.e;
        if (r4 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L36:
        r4.m.setAdapter(r23);
        ContactDbInviteExternalViewFeishuBinding r24 = this.e;
        if (r24 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r24 = null;
    L39:
        r24.m.setLayoutManager(new LinearLayoutManager(getActivity()));
        if (OfficeContactUtils.f() == false) goto L45;
        ContactDbInviteExternalViewFeishuBinding r25 = this.e;
        if (r25 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r25 = null;
    L44:
        r25.i.setVisibility(8);
    L55:
        ContactDbInviteExternalViewFeishuBinding r26 = this.e;
        if (r26 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L59:
        r13.e.setOnClickListener(h.a);
        int r27 = com.ss.android.lark.contact.customized.common.b.a;
        String r28 = this.d;
        String r29 = BuildConfig.FLAVOR;
        if (r28 != null) goto L62;
        r28 = BuildConfig.FLAVOR;
    L62:
        Intrinsics.checkNotNullParameter(r28, "previousPage");
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Statistics.sendEvent("enter_add_friend_page", new JSONObject().put("previous_page", r28).put("current_page", "profile_add_friend"));
        String r30 = this.d;
        if (r30 == null) goto L66;
        r29 = r30;
    L66:
        Intrinsics.checkNotNullParameter("contact", "functionType");
        Intrinsics.checkNotNullParameter("profile_add_friend", "currentPage");
        Intrinsics.checkNotNullParameter(r29, "enterFrom");
        Statistics.sendEvent("search_bar_show", new JSONObject().put("function_type", "contact").put("current_page", "profile_add_friend").put("enter_from", r29));
        U90().getInvitationInfoGroupLiveData().observe(getViewLifecycleOwner(), new b(this));
        U90().onPageViewCreated(SystemClock.elapsedRealtime());
        U90().fetchContactToken();
        return;
    L58:
        r13 = r26;
        goto L59
    L45:
        ContactDbInviteExternalViewFeishuBinding r31 = this.e;
        if (r31 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r31 = null;
    L48:
        r31.i.setVisibility(0);
        ContactDbInviteExternalViewFeishuBinding r32 = this.e;
        if (r32 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r32 = null;
    L51:
        r32.i.setOnClickListener(new f(this));
        ContactDbInviteExternalViewFeishuBinding r33 = this.e;
        if (r33 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r33 = null;
    L54:
        r33.j.setOnLongClickListener(new g(this));
        goto L55
    L8:
        r14 = null;
        goto L9
    }

    public final View onCreateView(LayoutInflater r22, ViewGroup r23, Bundle r24) {
        Intrinsics.checkNotNullParameter(r22, "inflater");
        View r0 = r22.inflate(2131559915, r23, false);
        int r1 = 2131374873;
        ContactOfficeEmptyStateView r5 = (ContactOfficeEmptyStateView) ViewBindings.findChildViewById(r0, 2131374873);
        if (r5 == null) goto L43;
        r1 = 2131374874;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131374874);
        if (r6 == null) goto L43;
        r1 = 2131374875;
        ContactOfficeLoadingView r7 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r0, 2131374875);
        if (r7 == null) goto L43;
        r1 = 2131374876;
        if (ViewBindings.findChildViewById(r0, 2131374876) == null) goto L43;
        r1 = 2131374877;
        LKUIRoundableLayout r8 = ViewBindings.findChildViewById(r0, 2131374877);
        if (r8 == null) goto L43;
        r1 = 2131374878;
        LKUIRoundedImageView2 r9 = ViewBindings.findChildViewById(r0, 2131374878);
        if (r9 == null) goto L43;
        r1 = 2131374879;
        LKUIRoundedImageView2 r10 = ViewBindings.findChildViewById(r0, 2131374879);
        if (r10 == null) goto L43;
        r1 = 2131374880;
        TextView r11 = (TextView) ViewBindings.findChildViewById(r0, 2131374880);
        if (r11 == null) goto L43;
        r1 = 2131374881;
        ImageView r12 = (ImageView) ViewBindings.findChildViewById(r0, 2131374881);
        if (r12 == null) goto L43;
        r1 = 2131374882;
        LinearLayout r13 = (LinearLayout) ViewBindings.findChildViewById(r0, 2131374882);
        if (r13 == null) goto L43;
        r1 = 2131374883;
        TextView r14 = (TextView) ViewBindings.findChildViewById(r0, 2131374883);
        if (r14 == null) goto L43;
        LinearLayout r2 = (LinearLayout) r0;
        RecyclerView r16 = ViewBindings.findChildViewById(r0, 2131374885);
        if (r16 == null) goto L40;
        LKUIRoundLinearLayout r17 = ViewBindings.findChildViewById(r0, 2131374886);
        if (r17 == null) goto L39;
        ScrollView r18 = (ScrollView) ViewBindings.findChildViewById(r0, 2131374887);
        if (r18 == null) goto L38;
        TextView r19 = (TextView) ViewBindings.findChildViewById(r0, 2131374888);
        if (r19 == null) goto L37;
        ContactOfficeTitleBar r20 = (ContactOfficeTitleBar) ViewBindings.findChildViewById(r0, 2131374889);
        if (r20 == null) goto L36;
        this.e = new ContactDbInviteExternalViewFeishuBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r2, r16, r17, r18, r19, r20);
        return r2;
    L36:
        r1 = 2131374889;
        goto L43
    L37:
        r1 = 2131374888;
        goto L43
    L38:
        r1 = 2131374887;
        goto L43
    L39:
        r1 = 2131374886;
        goto L43
    L40:
        r1 = 2131374885;
    L43:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
