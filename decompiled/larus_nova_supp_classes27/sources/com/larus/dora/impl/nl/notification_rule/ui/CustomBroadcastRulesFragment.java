package com.larus.dora.impl.nl.notification_rule.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.p0;
import com.larus.dora.api.entity.NotificationRule;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.databinding.LarusDoraFragmentCustomBroadcastRulesBinding;
import com.larus.dora.impl.nl.notification_rule.viewmodel.CustomBroadcastRulesViewModel;
import com.larus.dora.impl.view.DoraTextView;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\b\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\u0018H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0018\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\b\u0010#\u001a\u00020\u0018H\u0016J\b\u0010$\u001a\u00020\u0018H\u0016J\b\u0010%\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/dora/impl/nl/notification_rule/ui/CustomBroadcastRulesFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "_binding", "Lcom/larus/dora/impl/databinding/LarusDoraFragmentCustomBroadcastRulesBinding;", "binding", "getBinding", "()Lcom/larus/dora/impl/databinding/LarusDoraFragmentCustomBroadcastRulesBinding;", "viewModel", "Lcom/larus/dora/impl/nl/notification_rule/viewmodel/CustomBroadcastRulesViewModel;", "adapter", "Lcom/larus/dora/impl/nl/notification_rule/ui/NotificationRuleAdapter;", "enterPageTraced", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initUI", "initData", "showAddRuleBottomSheet", "showEditRuleDialog", "rule", "Lcom/larus/dora/api/entity/NotificationRule;", "showDeleteConfirmDialog", "showLongClickMenu", "anchor", "onDestroyView", "onResume", "traceEnterPage", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomBroadcastRulesFragment extends Fragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraFragmentCustomBroadcastRulesBinding d;
    public CustomBroadcastRulesViewModel e;
    public NotificationRuleAdapter f;
    public boolean g;

    public static final class a implements p0 {
        public final /* synthetic */ CustomBroadcastRulesFragment a;
        public final /* synthetic */ NotificationRule b;

        @Override // com.larus.common_ui.dialog.p0
        public final void confirm() {
            CustomBroadcastRulesViewModel r0 = this.a.e;
            if (r0 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r0 = null;
        L5:
            String r1 = this.b.getId();
            if (r1 != null) goto L8;
            r1 = "";
        L8:
            r0.deleteRule(r1);
        }

        public a(CustomBroadcastRulesFragment r1, NotificationRule r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b implements com.larus.common_ui.dialog.u {
        public b() {
        }

        @Override // com.larus.common_ui.dialog.u
        public final void cancel() {
        }
    }

    public final void onDestroyView() {
        super.onDestroyView();
        this.d = null;
    }

    public final void onResume() {
        super.onResume();
        if (this.g == true) goto L25;
        Bundle r0 = getArguments();
        String r1 = null;
        if (r0 == null) goto L7;
        String r2 = r0.getString("extra_current_page");
    L9:
        if (r2 != null) goto L11;
    L14:
        boolean r4 = true;
    L15:
        if (r4 == true) goto L23;
        DoraBuryPointManager r5 = DoraBuryPointManager.a;
        Pair[] r6 = new Pair[2];
        r6[0] = TuplesKt.to("current_page", r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L20;
        r1 = r3.getString("extra_previous_page");
    L20:
        if (r1 != null) goto L22;
        r1 = "";
    L22:
        r6[1] = TuplesKt.to(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, r1);
        r5.L("enter_page", MapsKt.mapOf(r6));
    L23:
        this.g = true;
        return;
    L11:
        if (r2.length() == 0) goto L14;
        r4 = false;
        goto L15
    L7:
        r2 = null;
        goto L9
    }

    public CustomBroadcastRulesFragment() {
    }

    public final void T90(NotificationRule r6) {
        Context r0 = getContext();
        if (r0 != null) goto L5;
        return;
    L5:
        CommonDialog.a r1 = new CommonDialog.a();
        r1.i(r0.getString(2131902218));
        r1.g(r0.getString(2131902217));
        CommonDialog.a.f(r1, new a(this, r6), r0.getString(2131902216), false, 12);
        CommonDialog.a.e(r1, new b(), r0.getString(2131902213), 4);
        CommonDialog r7 = r1.a();
        FragmentManager r2 = getChildFragmentManager();
        LandscapeRestrictionOperation r3 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r7, "DeleteNotificationRuleDialog", r3);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r7, r3) == true) goto L14;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
    L9:
        r7.show(r2, "DeleteNotificationRuleDialog");
        return;
    }

    /* JADX WARN: Type inference failed for: r3v4, types: [com.larus.dora.impl.nl.notification_rule.ui.n] */
    /* JADX WARN: Type inference failed for: r4v2, types: [com.larus.dora.impl.nl.notification_rule.ui.p] */
    /* JADX WARN: Type inference failed for: r5v1, types: [com.larus.dora.impl.nl.notification_rule.ui.q] */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.larus.dora.impl.nl.notification_rule.ui.r] */
    public final void onViewCreated(View r20, Bundle r21) {
        Intrinsics.checkNotNullParameter(r20, "view");
        super.onViewCreated(r20, r21);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L17;
        this.e = (CustomBroadcastRulesViewModel) new ViewModelProvider(r1).get(CustomBroadcastRulesViewModel.class);
        this.f = new NotificationRuleAdapter(new n(this), new p(this), new q(this), new r(this));
        LarusDoraFragmentCustomBroadcastRulesBinding r2 = this.d;
        if (r2 == null) goto L13;
        RecyclerView r3 = r2.f;
        if (r3 == null) goto L13;
        r3.setLayoutManager(new LinearLayoutManager(r3.getContext()));
        NotificationRuleAdapter r4 = this.f;
        if (r4 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r4 = null;
    L12:
        r3.setAdapter(r4);
        r3.addOnScrollListener(new CustomBroadcastRulesFragment$initData$5$1(this));
    L13:
        Lifecycle.State r5 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r5, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new CustomBroadcastRulesFragment$initData$$inlined$launchAndRepeatWithViewLifecycle$default$3(this, r5, null, this), 3, null);
        CustomBroadcastRulesViewModel r6 = this.e;
        if (r6 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r6 = null;
    L16:
        r6.loadRules();
    L17:
        LarusDoraFragmentCustomBroadcastRulesBinding r7 = this.d;
        if (r7 == null) goto L22;
        Group r8 = r7.e;
        if (r8 == null) goto L22;
        r8.setReferencedIds(new int[]{2131376209, 2131390564, 2131390558});
    L22:
        LarusDoraFragmentCustomBroadcastRulesBinding r9 = this.d;
        if (r9 == null) goto L27;
        NovaTitleBarEx r10 = r9.g;
        if (r10 == null) goto L27;
        NovaTitleBarEx.Y5(r10, getString(2131902251), null, null, 6);
        NovaTitleBarEx.b6(r10, 2131240517, false, null, null, new s(this), 14);
    L27:
        LarusDoraFragmentCustomBroadcastRulesBinding r11 = this.d;
        if (r11 == null) goto L32;
        LinearLayout r12 = r11.b;
        if (r12 == null) goto L32;
        e1.d(r12, new t(this));
    L32:
        LarusDoraFragmentCustomBroadcastRulesBinding r13 = this.d;
        if (r13 == null) goto L38;
        ConstraintLayout r14 = r13.a;
        if (r14 == null) goto L39;
        ViewCompat.setOnApplyWindowInsetsListener(r14, new u(this));
        return;
    L39:
        return;
    }

    public static void S90(NotificationRuleBottomSheet r1, FragmentManager r2, String r3) {
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, r1, r0) == false) goto L9;
        return;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        r1.show(r2, r3);
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131562182, r10, false);
        int r13 = 2131362263;
        LinearLayout r2 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131362263);
        if (r2 == null) goto L23;
        r13 = 2131364447;
        DoraTextView r3 = (DoraTextView) ViewBindings.findChildViewById(r12, 2131364447);
        if (r3 == null) goto L23;
        r13 = 2131364465;
        View r4 = ViewBindings.findChildViewById(r12, 2131364465);
        if (r4 == null) goto L23;
        r13 = 2131373955;
        Group r5 = ViewBindings.findChildViewById(r12, 2131373955);
        if (r5 == null) goto L23;
        r13 = 2131376209;
        if (((ImageView) ViewBindings.findChildViewById(r12, 2131376209)) == null) goto L23;
        r13 = 2131384903;
        RecyclerView r6 = ViewBindings.findChildViewById(r12, 2131384903);
        if (r6 == null) goto L23;
        r13 = 2131388807;
        NovaTitleBarEx r7 = ViewBindings.findChildViewById(r12, 2131388807);
        if (r7 == null) goto L23;
        r13 = 2131390558;
        if (((DoraTextView) ViewBindings.findChildViewById(r12, 2131390558)) == null) goto L23;
        r13 = 2131390564;
        if (((DoraTextView) ViewBindings.findChildViewById(r12, 2131390564)) == null) goto L23;
        ConstraintLayout r14 = r12;
        this.d = new LarusDoraFragmentCustomBroadcastRulesBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
