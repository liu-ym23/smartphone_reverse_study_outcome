package com.obric.aiproactive.ui.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.aiproactive.ui.databinding.ActivityProactiveSettingsPlaceholderBinding;
import com.obric.memorydata.plugin.R;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveSettingsPlaceholderFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/obric/aiproactive/ui/databinding/ActivityProactiveSettingsPlaceholderBinding;", "binding", "getBinding", "()Lcom/obric/aiproactive/ui/databinding/ActivityProactiveSettingsPlaceholderBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "Companion", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ProactiveSettingsPlaceholderFragment extends Fragment {
    private static final String ARG_TITLE = "proactive_settings_placeholder_title";
    private static final String BACK_STACK_NAME = "proactive_settings_placeholder";
    public static final a Companion = null;
    private ActivityProactiveSettingsPlaceholderBinding _binding;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/aiproactive/ui/settings/ProactiveSettingsPlaceholderFragment$Companion;", "", "<init>", "()V", "ARG_TITLE", "", "BACK_STACK_NAME", "show", "", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "title", "ai_proactive_ui_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a(FragmentManager r9, String r10) {
            Intrinsics.checkNotNullParameter(r9, "fragmentManager");
            Intrinsics.checkNotNullParameter(r10, "title");
            Fragment r8 = r9.findFragmentById(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"));
            ProactiveSettingsPlaceholderFragment r2 = new ProactiveSettingsPlaceholderFragment();
            r2.setArguments(BundleKt.bundleOf(new Pair[]{TuplesKt.to(ProactiveSettingsPlaceholderFragment.ARG_TITLE, r10)}));
            FragmentTransaction r11 = r9.beginTransaction().setReorderingAllowed(true).setCustomAnimations(ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_enter, "anim", "proactive_activity_open_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_open_exit, "anim", "proactive_activity_open_exit"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_enter, "anim", "proactive_activity_close_enter"), ZeusTransformUtils.mapRes(R.anim.proactive_activity_close_exit, "anim", "proactive_activity_close_exit"));
            Intrinsics.checkNotNullExpressionValue(r11, "setCustomAnimations(...)");
            if (r8 == null) goto L5;
            r11.hide(r8);
            r11.setMaxLifecycle(r8, Lifecycle.State.STARTED);
        L5:
            r11.add(ZeusTransformUtils.mapRes(R.id.fragment_container, OaidModel.KEY_ID, "fragment_container"), (Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).setPrimaryNavigationFragment((Fragment) ZeusTransformUtils.preCheckCast(r2, Fragment.class, "com.obric.memorydata.plugin")).addToBackStack(ProactiveSettingsPlaceholderFragment.BACK_STACK_NAME).commit();
        }
    }

    static {
        Companion = new a(null);
    }

    public ProactiveSettingsPlaceholderFragment() {
    }

    private final ActivityProactiveSettingsPlaceholderBinding getBinding() {
        ActivityProactiveSettingsPlaceholderBinding r1 = this._binding;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        ActivityProactiveSettingsPlaceholderBinding r4 = ActivityProactiveSettingsPlaceholderBinding.inflate(r1, r2, false);
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
    public void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super.onViewCreated(r9, r10);
        FragmentActivity r11 = (FragmentActivity) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(requireActivity(), "com.obric.memorydata.plugin"), FragmentActivity.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r11, "null cannot be cast to non-null type androidx.appcompat.app.AppCompatActivity");
        AppCompatActivity r0 = (AppCompatActivity) ZeusTransformUtils.preCheckCast(r11, AppCompatActivity.class, "com.obric.memorydata.plugin");
        FrameLayout r12 = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(r12, "getRoot(...)");
        View r1 = (View) ZeusTransformUtils.preCheckCast(r12, View.class, "com.obric.memorydata.plugin");
        OFloatingTitleBar r2 = getBinding().titleBar;
        Intrinsics.checkNotNullExpressionValue(r2, "titleBar");
        FrameLayout r13 = getBinding().contentHost;
        Intrinsics.checkNotNullExpressionValue(r13, "contentHost");
        View r3 = (View) ZeusTransformUtils.preCheckCast(r13, View.class, "com.obric.memorydata.plugin");
        String r14 = requireArguments().getString(ARG_TITLE);
        if (r14 != null) goto L5;
        r14 = "";
    L5:
        CharSequence r15 = (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin");
        if (StringsKt.isBlank(r15) == false) goto L8;
        r15 = getString(ZeusTransformUtils.mapRes(R.string.proactive_settings_title, TypedValues.Custom.S_STRING, "proactive_settings_title"));
        Intrinsics.checkNotNullExpressionValue(r15, "getString(...)");
    L8:
        c.a(r0, r1, r2, r3, (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin"), 8.0f, getBinding().cutOff, 0);
    }
}
