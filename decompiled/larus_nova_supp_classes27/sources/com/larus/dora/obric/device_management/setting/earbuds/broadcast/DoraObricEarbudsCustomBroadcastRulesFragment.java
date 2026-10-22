package com.larus.dora.obric.device_management.setting.earbuds.broadcast;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.oui.button.OButton;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.sectiontitlebar.OSectionSupportiveText;
import com.obric.oui.status.OPageStatus;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u0007\n\u0002\b\u0002\u0018\u0000 A2\u00020\u0001:\u0001AB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00182\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\"\u001a\u00020 H\u0016J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020%H\u0016J\n\u0010&\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010'\u001a\u00020 H\u0002J\u0016\u0010(\u001a\u00020 2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*H\u0002J\u0018\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u000200H\u0002J\u0014\u00101\u001a\u00020 *\u00020-2\u0006\u0010.\u001a\u00020+H\u0002J\u0018\u00102\u001a\u0002002\u0006\u00103\u001a\u0002002\u0006\u00104\u001a\u000200H\u0002J\f\u00105\u001a\u00020 *\u00020-H\u0002J\f\u00106\u001a\u00020 *\u00020-H\u0002J\b\u00107\u001a\u00020\u000fH\u0002J\b\u00108\u001a\u00020\u0011H\u0002J\b\u00109\u001a\u00020\u0013H\u0002J\b\u0010:\u001a\u00020 H\u0002J\u0010\u0010;\u001a\u00020 2\u0006\u0010.\u001a\u00020+H\u0002J\u0010\u0010<\u001a\u00020 2\u0006\u0010.\u001a\u00020+H\u0002J\b\u0010=\u001a\u00020 H\u0002J\f\u0010>\u001a\u000200*\u000200H\u0002J\f\u0010?\u001a\u000200*\u00020@H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/broadcast/DoraObricEarbudsCustomBroadcastRulesFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "getViewModel", "()Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "page", "Lcom/larus/dora/obric/device_management/setting/earbuds/ui/DoraObricEarbudsOuiPage;", "listContainer", "Landroid/widget/LinearLayout;", "emptyView", "Lcom/obric/oui/status/OPageStatus;", "bottomDesc", "Lcom/obric/oui/sectiontitlebar/OSectionSupportiveText;", "addButton", "Lcom/obric/oui/button/OButton;", "canAddRule", "", "enterPageReported", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onResume", "onDestroyView", "getCurrentPageName", "", "getPageMaskView", "observeViewModel", "renderList", "rules", "", "Lcom/larus/dora/api/entity/NotificationRule;", "buildRuleCard", "Lcom/obric/oui/lisitem/OCardListItem;", "rule", "position", "", "toggleRuleSelectionWithDebounce", "resolveCardPosition", "index", "size", "applyCardStyle", "resetCardContainerMargins", "buildEmptyView", "buildSectionSupportiveText", "buildAddButton", "onAddRuleClicked", "showEditDeleteDialog", "showDeleteConfirmDialog", "traceEnterPage", "dp", "sp", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsCustomBroadcastRulesFragment extends DoraBaseFragment {
    public static final /* synthetic */ int n = 0;
    public final Lazy f;
    public b79.d g;
    public LinearLayout h;
    public OPageStatus i;
    public OSectionSupportiveText j;
    public OButton k;
    public boolean l;
    public boolean m;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "";
    }

    public final void onDestroyView() {
        this.g = null;
        this.h = null;
        this.i = null;
        this.j = null;
        this.k = null;
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final View U90() {
        b79.d r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.e;
    }

    public final CustomBroadcastRulesViewModel Y90() {
        return (CustomBroadcastRulesViewModel) this.f.getValue();
    }

    public DoraObricEarbudsCustomBroadcastRulesFragment() {
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CustomBroadcastRulesViewModel.class), new DoraObricEarbudsCustomBroadcastRulesFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsCustomBroadcastRulesFragment$special$$inlined$activityViewModels$default$2(this));
        this.l = true;
    }

    public final void onResume() {
        super.onResume();
        if (this.m == true) goto L25;
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L8;
        String r2 = r0.getString("extra_current_page");
    L10:
        if (r2 != null) goto L12;
    L15:
        boolean r4 = true;
    L16:
        if (r4 == true) goto L26;
        this.m = true;
        DoraBuryPointManager r5 = DoraBuryPointManager.a;
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("current_page", r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L21;
        r1 = r3.getString("extra_previous_page");
    L21:
        if (r1 != null) goto L23;
        r1 = "";
    L23:
        r6[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1);
        r5.L("enter_page", MapsKt.mapOf(r6));
        return;
    L26:
        return;
    L12:
        if (r2.length() == 0) goto L15;
        r4 = false;
        goto L16
    L8:
        r2 = null;
        goto L10
    }

    public final int X90(int r3) {
        Resources r0 = getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public static void W90(DoraObricEarbudsAddRuleInputSheet r2, FragmentManager r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r2, "DoraObricEarbudsAddRuleInputSheet", r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r2, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r2.show(r3, "DoraObricEarbudsAddRuleInputSheet");
    }

    public final void Z90(OCardListItem r1, NotificationRule r2) {
        if (com.larus.dora.obric.device_management.setting.earbuds.k.a(r1) == true) goto L6;
        Y90().toggleRuleSelection(r2);
        return;
    }

    public final void onViewCreated(View r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r14, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r14, r15);
        Lifecycle.State r16 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r16, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r16, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsCustomBroadcastRulesFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r16, null, this), 3, null);
        Y90().loadRules();
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Context r10 = requireContext();
        int r11 = com.larus.utils.j0.a;
        b79.d r12 = new b79.d(r10, com.larus.utils.j0.d(2131902251), new o1(this));
        this.g = r12;
        OPageStatus r13 = new OPageStatus(requireContext(), null, 6, 0);
        r13.setType(0);
        r13.setPadding(0, X90(48), 0, 0);
        r13.setTitle(getString(2131902214));
        r13.setMessage(null);
        r13.a(false);
        r12.a(r13, 0);
        this.i = r13;
        LinearLayout r14 = new LinearLayout(requireContext());
        r14.setOrientation(1);
        r14.setClipChildren(false);
        r14.setClipToPadding(false);
        r14.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        r12.a(r14, 0);
        this.h = r14;
        View r15 = new OSectionSupportiveText(requireContext(), null, 6, 0);
        r15.setSectionDes(getString(2131902267));
        LinearLayout r0 = r12.c;
        LinearLayout.LayoutParams r1 = new LinearLayout.LayoutParams(-1, -2);
        r1.setMarginStart(X90(20));
        r1.setMarginEnd(X90(20));
        r1.topMargin = X90(8);
        Unit r2 = Unit.INSTANCE;
        r0.addView(r15, r1);
        this.j = r15;
        View r16 = new View(r12.a);
        r16.setLayoutParams(new LinearLayout.LayoutParams(-1, r12.b(88)));
        r12.c.addView(r16);
        FrameLayout r17 = new FrameLayout(requireContext());
        r17.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r17.addView(r12.f, new FrameLayout.LayoutParams(-1, -1));
        View r18 = (OButton) vma.e.a(requireContext(), 2131952832, new w1(this));
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, X90(48), 80);
        r3.setMarginStart(X90(24));
        r3.setMarginEnd(X90(24));
        r3.bottomMargin = X90(24);
        r17.addView(r18, r3);
        this.k = r18;
        return r17;
    }
}
