package com.obric.assistant.settings.autogui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.trace.tracknode.TraceFragment;
import com.obric.assistant.impl.databinding.ObricFragmentAutoGuiSettingsBinding;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.special_input.OSkillExtensionSettingRepository;
import com.obric.assistant.t1;
import com.obric.oui.coachmark.OCoachmarkTipView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000g\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004*\u0001\u0014\u0018\u0000 22\u00020\u00012\u00020\u0002:\u00012B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u001b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\"\u001a\u00020\u0017H\u0016J\u000f\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010$J\n\u0010%\u001a\u0004\u0018\u00010&H\u0002J&\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\u00062\b\b\u0002\u0010)\u001a\u00020\u00062\b\b\u0002\u0010*\u001a\u00020\u0006H\u0002J\b\u0010+\u001a\u00020\u0017H\u0002J\u000f\u0010,\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010$J\u0010\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0002J\u000f\u00100\u001a\u0004\u0018\u00010\u0017H\u0002¢\u0006\u0002\u0010$J\b\u00101\u001a\u00020\u0017H\u0016R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u00063"}, d2 = {"Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/obric/assistant/settings/ObricFloatingTitleBarProvider;", "<init>", "()V", "autoLogEnterPage", "", "getCurrentPageName", "", "getFloatingTitleBar", "Lcom/obric/oui/titlebar/OFloatingTitleBar;", "binding", "Lcom/obric/assistant/impl/databinding/ObricFragmentAutoGuiSettingsBinding;", "viewModel", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiViewModel;", "getViewModel", "()Lcom/obric/assistant/settings/autogui/ObricAutoGuiViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "settingsChangedListener", "com/obric/assistant/settings/autogui/ObricAutoGuiSettingsFragment$settingsChangedListener$1", "Lcom/obric/assistant/settings/autogui/ObricAutoGuiSettingsFragment$settingsChangedListener$1;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "setTopBar", "()Lkotlin/Unit;", "setupAutoAppList", "Lkotlinx/coroutines/Job;", "checkGetInstalledAppPermission", "isFromViewCreated", "shouldRequestPermission", "shouldSetupAvailableAppList", "syncAutoGuiSettingUI", "setupAvailableAppListInternel", "changeRecycleViewPaddingTop", "paddingTop", "", "setupRouterToSystemPermissionSettings", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoGuiSettingsFragment extends TraceFragment implements com.obric.assistant.settings.t {
    public static final /* synthetic */ int h = 0;
    public ObricFragmentAutoGuiSettingsBinding e;
    public final Lazy f;
    public final ObricAutoGuiSettingsFragment$settingsChangedListener$1 g;

    public static final class a {
    }

    static {
    }

    public final boolean S90() {
        return true;
    }

    public final String k() {
        return "obric_autogui_settings_fragment";
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.obric.assistant.settings.autogui.ObricAutoGuiSettingsFragment$settingsChangedListener$1] */
    public ObricAutoGuiSettingsFragment() {
        final Function0<Fragment> r0 = new ObricAutoGuiSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(ObricAutoGuiViewModel.class), new ObricAutoGuiSettingsFragment$special$$inlined$viewModels$default$2(r0), new ObricAutoGuiSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = new ObricAutoGuiSettingsFragment$settingsChangedListener$1(this);
    }

    @Override // com.obric.assistant.settings.t
    public final OFloatingTitleBar gW() {
        if (t9a.b.a().b() == true) goto L5;
        return null;
    L5:
        ObricFragmentAutoGuiSettingsBinding r0 = this.e;
        if (r0 != null) goto L8;
        return null;
    L8:
        return r0.d;
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        t1.a.S0(this.g);
        this.e = null;
    }

    public final void onResume() {
        super.onResume();
        kotlinx.coroutines.flow.b1 r0 = com.obric.assistant.special_input.j.a;
        Intrinsics.checkNotNullParameter("auto_gui_settings_resume", WindowEvent.Params.REASON);
        OSkillExtensionSettingRepository.a.getClass();
        Intrinsics.checkNotNullParameter("auto_gui_settings_resume", WindowEvent.Params.REASON);
        if (OSkillExtensionSettingRepository.c() == true) goto L5;
        OSkillExtensionSettingRepository.e();
    L6:
        W90(this, false);
        return;
    L5:
        OSkillExtensionSettingRepository.a();
        OSkillExtensionSettingRepository.d("auto_gui_settings_resume", true);
        goto L6
    }

    public static final void U90(final ObricAutoGuiSettingsFragment r3) {
        final ObricFragmentAutoGuiSettingsBinding r0 = r3.e;
        if (r0 == null) goto L6;
        r0.b.setVisibility(0);
        r3.V90(0);
        r0.b.setOnDismissClickListener(new f0(r0, r3));
        r0.b.setOnActionClickListener(new g0(r3));
        Unit r4 = Unit.INSTANCE;
        return;
    }

    public final void V90(int r5) {
        ObricFragmentAutoGuiSettingsBinding r0 = this.e;
        if (r0 == null) goto L6;
        RecyclerView r1 = r0.c;
        r1.setPadding(r1.getPaddingLeft(), r5, r0.c.getPaddingRight(), r0.c.getPaddingBottom());
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
    }

    public static void W90(ObricAutoGuiSettingsFragment r11, boolean r12) {
        r11.getClass();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r11), Dispatchers.getMain(), null, new ObricAutoGuiSettingsFragment$checkGetInstalledAppPermission$1(r12, r12, r11, !r12, null), 2, null);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.obric.assistant.settings.autogui.c0] */
    public final void onViewCreated(View r12, Bundle r13) {
        Intrinsics.checkNotNullParameter(r12, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r12, r13);
        t1.a.B0(this.g);
        ObricFragmentAutoGuiSettingsBinding r14 = this.e;
        if (r14 != null) goto L5;
    L9:
        ObricFragmentAutoGuiSettingsBinding r15 = this.e;
        if (r15 == null) goto L14;
        final Context r1 = getContext();
        if (r1 == null) goto L14;
        r15.c.setLayoutManager(new ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$1(r1));
        r15.c.setAdapter(new ObricAutoGuiItemAdapter(getActivity(), new c0(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new ObricAutoGuiSettingsFragment$setupAutoAppList$1$1$3(this, r15, null), 3, null);
    L14:
        W90(this, true);
        return;
    L5:
        if (t9a.b.a().b() == true) goto L7;
        int r2 = rda.a.a;
        NovaTitleBarEx r4 = rda.a.b(r14.d);
        r4.setVisibility(0);
        NovaTitleBarEx.Y5(r4, getString(2131912430), null, null, 6);
        NovaTitleBarEx.b6(r4, 2131241477, false, null, null, new d0(this), 14);
    L8:
        Unit r16 = Unit.INSTANCE;
        goto L9
    L7:
        OFloatingTitleBar r17 = r14.d;
        r17.setFloatingTransitionEnabled(true);
        r17.setVisibility(0);
        r17.setCenterTitle(2131912430);
        OFloatingTitleBar.k(r17, new e0(this), 2);
        goto L8
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131563996, r4, false);
        int r7 = 2131373994;
        OCoachmarkTipView r8 = (OCoachmarkTipView) ViewBindings.findChildViewById(r6, 2131373994);
        if (r8 == null) goto L14;
        r7 = 2131384916;
        RecyclerView r0 = ViewBindings.findChildViewById(r6, 2131384916);
        if (r0 == null) goto L14;
        r7 = 2131389118;
        OFloatingTitleBar r1 = ViewBindings.findChildViewById(r6, 2131389118);
        if (r1 == null) goto L14;
        ConstraintLayout r9 = r6;
        this.e = new ObricFragmentAutoGuiSettingsBinding(r9, r8, r0, r1);
        if (r9 == null) goto L11;
        r9.setTag(2131377847, this);
        return r9;
    L11:
        return null;
    L14:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
