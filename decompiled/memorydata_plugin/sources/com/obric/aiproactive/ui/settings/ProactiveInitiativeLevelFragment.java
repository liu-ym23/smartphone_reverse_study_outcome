package com.obric.aiproactive.ui.settings;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.databinding.FragmentProactiveInitiativeLevelBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.bouncelayout.ONestedScrollView;
import com.obric.oui.checkbox.OCheckMark;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import com.xiphias.browser.scanner.BuildConfig;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0014\u0010\u001d\u001a\u00020\u0018*\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010\"\u001a\u00020\u0018H\u0002J\u0014\u0010#\u001a\u00020\u0018*\u00020\u001e2\u0006\u0010$\u001a\u00020%H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006'"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveInitiativeLevelFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/obric/aiproactive/ui/databinding/FragmentProactiveInitiativeLevelBinding;", "binding", "getBinding", "()Lcom/obric/aiproactive/ui/databinding/FragmentProactiveInitiativeLevelBinding;", "viewModel", "Lcom/obric/aiproactive/ui/settings/ProactiveSettingsViewModel;", "getViewModel", "()Lcom/obric/aiproactive/ui/settings/ProactiveSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "bindOptions", "setOptionClickListener", "Lcom/obric/oui/lisitem/OCardListItem;", "level", "Lcom/obric/aiproactive/ui/settings/InitiativeLevel;", "selectLevel", "refreshSelection", "updateMark", BuildConfig.FLAVOR, "", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveInitiativeLevelFragment extends Fragment {
    private static final String BACK_STACK_NAME = "proactive_initiative_level";
    public static final a Companion = null;
    private FragmentProactiveInitiativeLevelBinding _binding;
    private final Lazy viewModel$delegate;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveInitiativeLevelFragment$Companion;", "", "<init>", "()V", "BACK_STACK_NAME", "", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(FragmentManager r10) {
            Intrinsics.checkNotNullParameter(r10, "fragmentManager");
            Fragment r9 = r10.findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
            ProactiveInitiativeLevelFragment r2 = new ProactiveInitiativeLevelFragment();
            FragmentTransaction r11 = r10.beginTransaction().setReorderingAllowed(true).setCustomAnimations(ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_enter, "anim", "proactive_activity_open_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_exit, "anim", "proactive_activity_open_exit"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_enter, "anim", "proactive_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_exit, "anim", "proactive_activity_close_exit"));
            Intrinsics.checkNotNullExpressionValue(r11, "setCustomAnimations(...)");
            if (r9 == null) goto L5;
            r11.hide(r9);
            r11.setMaxLifecycle(r9, Lifecycle.State.STARTED);
        L5:
            r11.add(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"), (Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).setPrimaryNavigationFragment((Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).addToBackStack(ProactiveInitiativeLevelFragment.BACK_STACK_NAME).commit();
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveInitiativeLevelFragment() {
        this.viewModel$delegate = LazyKt.lazy(new $$Lambda$ProactiveInitiativeLevelFragment$LXpSZMaDvl8cYrLENCmuu7zs7Ac(this));
    }

    private final void bindOptions() {
        OCardListItem r0 = getBinding().restrained;
        Intrinsics.checkNotNullExpressionValue(r0, "restrained");
        setOptionClickListener(r0, InitiativeLevel.RESTRAINED);
        OCardListItem r1 = getBinding().balanced;
        Intrinsics.checkNotNullExpressionValue(r1, "balanced");
        setOptionClickListener(r1, InitiativeLevel.BALANCED);
        OCardListItem r2 = getBinding().aggressive;
        Intrinsics.checkNotNullExpressionValue(r2, "aggressive");
        setOptionClickListener(r2, InitiativeLevel.AGGRESSIVE);
    }

    private final FragmentProactiveInitiativeLevelBinding getBinding() {
        FragmentProactiveInitiativeLevelBinding r1 = this._binding;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    private final ProactiveSettingsViewModel getViewModel() {
        return (ProactiveSettingsViewModel) ZeusTransformUtils.preCheckCast(this.viewModel$delegate.getValue(), ProactiveSettingsViewModel.class, "com.obric.memorydata.plugin");
    }

    public static /* synthetic */ void lambda$ITzMipjzbto3MoCb5f_lniIvQ7Q(ProactiveInitiativeLevelFragment r0, InitiativeLevel r1, View r2) {
        setOptionClickListener$lambda$3(r0, r1, r2);
    }

    public static /* synthetic */ ProactiveSettingsViewModel lambda$LXpSZMaDvl8cYrLENCmuu7zs7Ac(ProactiveInitiativeLevelFragment r0) {
        return viewModel_delegate$lambda$1(r0);
    }

    public static /* synthetic */ void lambda$xdZb71Lr6t0gx8Tke3H4NtshGBo(ProactiveInitiativeLevelFragment r0, InitiativeLevel r1, View r2) {
        setOptionClickListener$lambda$4(r0, r1, r2);
    }

    private final void refreshSelection() {
        InitiativeLevel r0 = (InitiativeLevel) ZeusTransformUtils.preCheckCast(getViewModel().getInitiativeLevel().c(), InitiativeLevel.class, "com.obric.memorydata.plugin");
        OCardListItem r1 = getBinding().restrained;
        Intrinsics.checkNotNullExpressionValue(r1, "restrained");
        boolean r3 = true;
        if (r0 != InitiativeLevel.RESTRAINED) goto L5;
        boolean r2 = true;
    L6:
        updateMark(r1, r2);
        OCardListItem r4 = getBinding().balanced;
        Intrinsics.checkNotNullExpressionValue(r4, "balanced");
        if (r0 != InitiativeLevel.BALANCED) goto L9;
        boolean r5 = true;
    L10:
        updateMark(r4, r5);
        OCardListItem r6 = getBinding().aggressive;
        Intrinsics.checkNotNullExpressionValue(r6, "aggressive");
        if (r0 == InitiativeLevel.AGGRESSIVE) goto L14;
        r3 = false;
    L14:
        updateMark(r6, r3);
        return;
    L9:
        r5 = false;
        goto L10
    L5:
        r2 = false;
        goto L6
    }

    private final void selectLevel(InitiativeLevel r2) {
        getViewModel().select(r2);
        refreshSelection();
    }

    private final void setOptionClickListener(OCardListItem r2, final InitiativeLevel r3) {
        r2.setOnClickListener(new $$Lambda$ProactiveInitiativeLevelFragment$ITzMipjzbto3MoCb5f_lniIvQ7Q(this, r3));
        r2.getContentContainer().setOnClickListener(new $$Lambda$ProactiveInitiativeLevelFragment$xdZb71Lr6t0gx8Tke3H4NtshGBo(this, r3));
    }

    private static final void setOptionClickListener$lambda$3(ProactiveInitiativeLevelFragment r0, InitiativeLevel r1, View r2) {
        r0.selectLevel(r1);
    }

    private static final void setOptionClickListener$lambda$4(ProactiveInitiativeLevelFragment r0, InitiativeLevel r1, View r2) {
        r0.selectLevel(r1);
    }

    private final void updateMark(OCardListItem r2, boolean r3) {
        OCheckMark r1 = r2.getEndMark();
        if (r1 == null) goto L14;
        int r4 = 0;
        r1.setClickable(false);
        r1.setFocusable(false);
        r1.setChecked(true);
        if (r3 == true) goto L8;
        r4 = 4;
    L8:
        r1.setVisibility(r4);
        if (r3 == false) goto L11;
        float r5 = 1.0f;
    L12:
        r1.setAlpha(r5);
        return;
    L11:
        r5 = 0.0f;
        goto L12
    }

    private static final ProactiveSettingsViewModel viewModel_delegate$lambda$1(ProactiveInitiativeLevelFragment r4) {
        ProactiveSettingsViewModel r0 = new ProactiveSettingsViewModel();
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.requireContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullExpressionValue(r5, "requireContext(...)");
        ProactiveSettingsViewModel.bind$default(r0, (com.obric.aiproactive.ui.settings.a) ZeusTransformUtils.preCheckCast(new b(r5), com.obric.aiproactive.ui.settings.a.class, "com.obric.memorydata.plugin"), null, 2, null);
        return r0;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        FragmentProactiveInitiativeLevelBinding r4 = FragmentProactiveInitiativeLevelBinding.inflate(r1, r2, false);
        this._binding = r4;
        FrameLayout r0 = r4.getRoot();
        Intrinsics.checkNotNullExpressionValue(r0, "getRoot(...)");
        return (View) ZeusTransformUtils.preCheckCast(r0, View.class, "com.obric.memorydata.plugin");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        this._binding = null;
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().refresh();
        refreshSelection();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r11, "view");
        super.onViewCreated(r11, r12);
        FragmentActivity r13 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity r0 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r13, AppCompatActivity.class, "com.obric.memorydata.plugin");
        FrameLayout r14 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(r14, "getRoot(...)");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
        OFloatingTitleBar r2 = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar");
        ONestedScrollView r15 = getBinding().contentScroll;
        Intrinsics.checkNotNullExpressionValue(r15, "contentScroll");
        c.a(r0, r1, r2, (View) ZeusTransformUtils.preCheckCast(r15, View.class, "com.obric.memorydata.plugin"), getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_initiative_level, TypedValues.Custom.S_STRING, "proactive_settings_initiative_level")), 8.0f, null, 0, 32, null);
        bindOptions();
        refreshSelection();
    }
}
