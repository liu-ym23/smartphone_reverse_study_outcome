package com.ss.android.lark.contact.customized.search.view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.ui.layout.LKUIRoundLinearLayout;
import com.larksuite.framework.utils.ICUUtils;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.chameleon.container.webcontainer.report.ChameleonOpenTracker;
import com.ss.android.lark.contact.base.common_ui.InvBaseFragment;
import com.ss.android.lark.contact.customized.common.OfficeContactUtils;
import com.ss.android.lark.contact.customized.common.view.ContactOfficeLoadingView;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchActionItemLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchEmptyLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchLoadingLayoutBinding;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.profile.dto.ProfileFinishResult;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.q;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.suite.lark.emm.design.edittext.SCEditText;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import com.tencent.qqmusic.third.api.contract.Keys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import mtb.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u0000 02\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u0019H\u0002J\b\u0010\u001e\u001a\u00020\u0019H\u0002J\"\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0019H\u0002J\u0016\u0010'\u001a\u00020\u00192\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J\u0010\u0010.\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchFragment;", "Lcom/ss/android/lark/contact/base/common_ui/InvBaseFragment;", "<init>", "()V", "viewBinding", "Lcom/ss/android/lark/contact/customized/databinding/ContactDbInviteSearchViewLayoutBinding;", "adapter", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchAdapter;", "viewModel", "Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchViewModel;", "getViewModel", "()Lcom/ss/android/lark/contact/customized/search/view/OfficeInviteExternalSearchViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "hasHandledInitialKeyword", BuildConfig.FLAVOR, "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", BuildConfig.FLAVOR, "view", "initBackPressed", "initView", "handleInitialKeyword", "initObservers", "onActivityResult", "requestCode", BuildConfig.FLAVOR, "resultCode", Keys.API_RETURN_KEY_DATA, "Landroid/content/Intent;", "showTypingState", "showLoadingState", "showResultsState", "items", BuildConfig.FLAVOR, "Lcom/ss/android/lark/officesdk/contact/api/model/OfficeContactItemModel;", "showEmptyState", "query", BuildConfig.FLAVOR, "showActionState", "updateTypingState", "Companion", "contact-doubao_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeInviteExternalSearchFragment extends InvBaseFragment {
    public static final /* synthetic */ int h = 0;
    public ContactDbInviteSearchViewLayoutBinding d;
    public OfficeInviteExternalSearchAdapter e;
    public final Lazy f;
    public boolean g;

    public static final class a {
    }

    static {
    }

    public final OfficeInviteExternalSearchViewModel S90() {
        return (OfficeInviteExternalSearchViewModel) this.f.getValue();
    }

    public final void U90() {
        ContactDbInviteSearchViewLayoutBinding r0 = this.d;
        ContactDbInviteSearchViewLayoutBinding r1 = null;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        r0.e.c.a();
        ContactDbInviteSearchViewLayoutBinding r2 = this.d;
        if (r2 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L8:
        r2.d.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r3 = this.d;
        if (r3 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L11:
        r3.e.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r4 = this.d;
        if (r4 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L14:
        r4.f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r5 = this.d;
        if (r5 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        r1.h.a.setVisibility(8);
        return;
    L17:
        r1 = r5;
        goto L18
    }

    public OfficeInviteExternalSearchFragment() {
        final Function0<Fragment> r0 = new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(OfficeInviteExternalSearchViewModel.class), new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$2(r0), new OfficeInviteExternalSearchFragment$special$$inlined$viewModels$default$3(r0, this));
    }

    public final void T90(String r5) {
        ContactDbInviteSearchViewLayoutBinding r0 = this.d;
        ContactDbInviteSearchViewLayoutBinding r1 = null;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L6:
        if (r0.h.a.getVisibility() == 0) goto L23;
        ContactDbInviteSearchViewLayoutBinding r2 = this.d;
        if (r2 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L10:
        r2.e.c.a();
        ContactDbInviteSearchViewLayoutBinding r3 = this.d;
        if (r3 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L13:
        r3.d.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r4 = this.d;
        if (r4 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L16:
        r4.e.a.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r6 = this.d;
        if (r6 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L19:
        r6.f.setVisibility(8);
        ContactDbInviteSearchViewLayoutBinding r7 = this.d;
        if (r7 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L22:
        r7.h.a.setVisibility(0);
    L23:
        ICUUtils.FormatArgsBuilder r8 = new ICUUtils.FormatArgsBuilder();
        r8.b("account", r5);
        List r9 = r8.a;
        ContactDbInviteSearchViewLayoutBinding r10 = this.d;
        if (r10 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L27:
        r1.h.b.setText(ICUUtils.icuFormat(UIHelper.getString(2131890075), r9));
        return;
    L26:
        r1 = r10;
        goto L27
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        Context r13 = getContext();
        if (r13 == null) goto L5;
        Lazy r14 = OfficeContactUtils.a;
        OfficeContactUtils.e(this, UIUtils.getColor(r13, 2131102022));
    L5:
        S90().init();
        ContactDbInviteSearchViewLayoutBinding r15 = this.d;
        ContactDbInviteSearchViewLayoutBinding r16 = null;
        if (r15 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r15 = null;
    L8:
        ViewCompat.setTransitionName(r15.k, "contact_db_transition_invite_search_bar");
        ContactDbInviteSearchViewLayoutBinding r17 = this.d;
        if (r17 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r17 = null;
    L11:
        r17.b.setOnClickListener(new d(this));
        ICUUtils.FormatArgsBuilder r18 = new ICUUtils.FormatArgsBuilder();
        r18.b("brandName", UIHelper.getAppName());
        String r19 = ICUUtils.icuFormat(UIHelper.getString(2131890076), r18.a);
        ContactDbInviteSearchViewLayoutBinding r1 = this.d;
        if (r1 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r1 = null;
    L14:
        r1.j.setHint(r19);
        ContactDbInviteSearchViewLayoutBinding r2 = this.d;
        if (r2 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L17:
        r2.j.addOnLayoutChangeListener(new e(r19));
        ContactDbInviteSearchViewLayoutBinding r110 = this.d;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r110 = null;
    L20:
        r110.j.post(new f(this));
        ContactDbInviteSearchViewLayoutBinding r111 = this.d;
        if (r111 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r111 = null;
    L23:
        r111.j.addTextChangedListener(new g(this));
        ContactDbInviteSearchViewLayoutBinding r112 = this.d;
        if (r112 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r112 = null;
    L26:
        r112.j.setOnEditorActionListener(new h(this));
        View[] r3 = new View[1];
        ContactDbInviteSearchViewLayoutBinding r4 = this.d;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r4 = null;
    L29:
        boolean r5 = false;
        r3[0] = r4.i;
        q.b(r3);
        ContactDbInviteSearchViewLayoutBinding r6 = this.d;
        if (r6 != null) goto L32;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L32:
        r6.i.setOnClickListener(new i(this));
        ContactDbInviteSearchViewLayoutBinding r7 = this.d;
        if (r7 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r7 = null;
    L35:
        r7.g.setOnClickListener(new j(this));
        ContactDbInviteSearchViewLayoutBinding r8 = this.d;
        if (r8 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r8 = null;
    L38:
        r8.h.a.setOnClickListener(new k(this));
        this.e = new OfficeInviteExternalSearchAdapter(this);
        ContactDbInviteSearchViewLayoutBinding r9 = this.d;
        if (r9 != null) goto L41;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r9 = null;
    L41:
        r9.f.setLayoutManager(new LinearLayoutManager(requireContext()));
        ContactDbInviteSearchViewLayoutBinding r10 = this.d;
        if (r10 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r10 = null;
    L44:
        RecyclerView r20 = r10.f;
        OfficeInviteExternalSearchAdapter r21 = this.e;
        if (r21 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r21 = null;
    L47:
        r20.setAdapter(r21);
        ContactDbInviteSearchViewLayoutBinding r22 = this.d;
        if (r22 != null) goto L50;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r22 = null;
    L50:
        LinearLayout r23 = r22.a;
        r23.getViewTreeObserver().addOnPreDrawListener(new c(r23, this));
        S90().getUiState().observe(getViewLifecycleOwner(), new b(this));
        FragmentActivity r24 = getActivity();
        if (r24 == null) goto L56;
        OnBackPressedDispatcher r25 = r24.getOnBackPressedDispatcher();
        if (r25 == null) goto L56;
        r25.addCallback(getViewLifecycleOwner(), new OfficeInviteExternalSearchFragment$initBackPressed$1(this));
    L56:
        if (this.g == true) goto L89;
        Bundle r26 = getArguments();
        if (r26 == null) goto L61;
        String r27 = r26.getString("contact_db_initial_keyword");
    L62:
        StringBuilder r28 = new StringBuilder("hasInitialKeyword=");
        if (r27 != null) goto L65;
    L68:
        boolean r29 = true;
    L69:
        r28.append(!r29);
        Log.i("Contact_InvExternalSearch", r28.toString());
        if (r27 == null) goto L72;
        String r30 = StringsKt.replace$default(r27, " ", BuildConfig.FLAVOR, false, 4, null);
    L73:
        if (r30 != null) goto L76;
        r30 = BuildConfig.FLAVOR;
    L76:
        if (r30.length() != 0) goto L78;
        r5 = true;
    L78:
        if (r5 == true) goto L90;
        this.g = true;
        ContactDbInviteSearchViewLayoutBinding r113 = this.d;
        if (r113 != null) goto L83;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r113 = null;
    L83:
        r113.j.setText(r30);
        ContactDbInviteSearchViewLayoutBinding r114 = this.d;
        if (r114 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L87:
        r16.j.setSelection(r30.length());
        S90().onSearch();
        return;
    L86:
        r16 = r114;
        goto L87
    L90:
        return;
    L72:
        r30 = null;
        goto L73
    L65:
        if (r27.length() == 0) goto L68;
        r29 = false;
        goto L69
    L61:
        r27 = null;
        goto L62
    }

    public final void onActivityResult(int r22, int r23, Intent r24) {
        super/*androidx.fragment.app.Fragment*/.onActivityResult(r22, r23, r24);
        Log.i("Contact_InvExternalSearch", "onActivityResult: requestCode = " + r22 + ", resultCode = " + r23);
        int r3 = -1;
        if (r23 != (-1)) goto L42;
        if (r24 != null) goto L7;
        return;
    L7:
        if (r22 != 273) goto L43;
        ProfileFinishResult r0 = r24.getSerializableExtra("params_key_profile");
        if ((r0 instanceof ProfileFinishResult) == false) goto L44;
        OfficeInviteExternalSearchAdapter r2 = this.e;
        String r4 = null;
        if (r2 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r2 = null;
    L13:
        ProfileFinishResult r1 = r0;
        r2.getClass();
        Intrinsics.checkNotNullParameter(r1, ChameleonOpenTracker.ParamKey.RESULT);
        String r5 = r1.userId;
        if (r5 == null) goto L45;
        Long r6 = StringsKt.toLongOrNull(r5);
        if (r6 == null) goto L46;
        long r7 = r6.longValue();
        Iterator r8 = ((ArrayList) r2.b).iterator();
        int r9 = 0;
    L19:
        if (r8.hasNext() == false) goto L27;
        if (((mtb.d) r8.next()).a != r7) goto L23;
        boolean r10 = true;
    L24:
        if (r10 == true) goto L25;
        r9 = r9 + 1;
        goto L19
    L25:
        r3 = r9;
        goto L27
    L23:
        r10 = false;
    L27:
        Log.i("Contact_InvExternalSearchAdapter", "updateStatus index=" + r3 + " friend=" + r1.isFriend + " reqApplied=" + r1.isRequestUserApplied + " targetApplied=" + r1.isTargetUserApplied);
        if (r3 < 0) goto L48;
        mtb.d r11 = (mtb.d) ListProtector.get(r2.b, r3);
        n r12 = r11.k;
        boolean r13 = r1.isFriend;
        boolean r14 = r1.isRequestUserApplied;
        if (r12 == null) goto L33;
        long r15 = r12.c;
    L34:
        if (r12 == null) goto L36;
        r4 = r12.d;
    L36:
        if (r4 != null) goto L38;
        r4 = BuildConfig.FLAVOR;
    L38:
        n r20 = new n(r13, r14, r15, r4, r1.isTargetUserApplied);
        List<mtb.d> r16 = r2.b;
        long r17 = r11.a;
        long r18 = r11.b;
        String r19 = r11.c;
        String r110 = r11.d;
        String r111 = r11.e;
        String r112 = r11.f;
        String r21 = r11.g;
        String r25 = r11.h;
        boolean r26 = r11.i;
        boolean r27 = r11.j;
        Intrinsics.checkNotNullParameter(r19, IPortraitService.NAME);
        Intrinsics.checkNotNullParameter(r110, "alias");
        Intrinsics.checkNotNullParameter(r111, "displayName");
        Intrinsics.checkNotNullParameter(r112, "displayNamePinyin");
        Intrinsics.checkNotNullParameter(r21, "avatarKey");
        Intrinsics.checkNotNullParameter(r25, "doubaoKey");
        ListProtector.set(r16, r3, new mtb.d(r17, r18, r19, r110, r111, r112, r21, r25, r26, r27, r20));
        r2.notifyItemChanged(r3);
        return;
    L33:
        r15 = 0;
        goto L34
    L48:
        return;
    L46:
        return;
    L45:
        return;
    L44:
        return;
    L43:
        return;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r19) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        View r0 = r17.inflate(2131559919, r18, false);
        int r1 = 2131375639;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r0, 2131375639);
        if (r5 == null) goto L40;
        r1 = 2131375640;
        FrameLayout r6 = (FrameLayout) ViewBindings.findChildViewById(r0, 2131375640);
        if (r6 == null) goto L40;
        r1 = 2131375641;
        View r3 = ViewBindings.findChildViewById(r0, 2131375641);
        if (r3 == null) goto L40;
        ContactDbInviteSearchEmptyLayoutBinding r7 = new ContactDbInviteSearchEmptyLayoutBinding((TextView) r3);
        r1 = 2131375643;
        View r4 = ViewBindings.findChildViewById(r0, 2131375643);
        if (r4 == null) goto L40;
        FrameLayout r2 = (FrameLayout) r4;
        ContactOfficeLoadingView r8 = (ContactOfficeLoadingView) ViewBindings.findChildViewById(r4, 2131375645);
        if (r8 == null) goto L37;
        ContactDbInviteSearchLoadingLayoutBinding r9 = new ContactDbInviteSearchLoadingLayoutBinding(r2, r2, r8);
        r1 = 2131375646;
        RecyclerView r10 = ViewBindings.findChildViewById(r0, 2131375646);
        if (r10 == null) goto L40;
        LinearLayout r11 = (LinearLayout) r0;
        View r12 = ViewBindings.findChildViewById(r0, 2131375648);
        if (r12 == null) goto L35;
        int r13 = 2131375636;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131375636)) == null) goto L34;
        LinearLayout r14 = (LinearLayout) r12;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r12, 2131375638);
        if (r15 == null) goto L31;
        ContactDbInviteSearchActionItemLayoutBinding r16 = new ContactDbInviteSearchActionItemLayoutBinding(r14, r15);
        ImageView r110 = (ImageView) ViewBindings.findChildViewById(r0, 2131375649);
        if (r110 == null) goto L30;
        SCEditText r111 = ViewBindings.findChildViewById(r0, 2131375650);
        if (r111 == null) goto L29;
        LKUIRoundLinearLayout r112 = ViewBindings.findChildViewById(r0, 2131375651);
        if (r112 == null) goto L28;
        this.d = new ContactDbInviteSearchViewLayoutBinding(r11, r5, r6, r7, r9, r10, r11, r16, r110, r111, r112);
        return r11;
    L28:
        r1 = 2131375651;
        goto L40
    L29:
        r1 = 2131375650;
        goto L40
    L30:
        r1 = 2131375649;
        goto L40
    L31:
        r13 = 2131375638;
    L34:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    L35:
        r1 = 2131375648;
        goto L40
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131375645)));
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
