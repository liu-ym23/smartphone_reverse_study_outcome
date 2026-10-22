package com.larus.dora.obric.device_management.setting.earbuds;

import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.viewmodel.DoraDynamicViewModelV2;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.titlebar.OFloatingTitleBar;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0016\u0018\u0000 F2\u00020\u0001:\u0001FB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010#\u001a\u00020!H\u0016J\b\u0010$\u001a\u00020!H\u0016J\b\u0010%\u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020!H\u0016J\b\u0010+\u001a\u00020\u0019H\u0002J\b\u0010,\u001a\u00020\u0019H\u0002J\b\u0010-\u001a\u00020!H\u0002J\b\u0010.\u001a\u00020!H\u0002J\b\u0010/\u001a\u00020!H\u0002J\b\u00100\u001a\u00020!H\u0002J\u0010\u00101\u001a\u00020(2\u0006\u00102\u001a\u000203H\u0002J\u0010\u00104\u001a\u00020!2\u0006\u00105\u001a\u000206H\u0002J2\u00107\u001a\u00020!2\u0010\u00108\u001a\f\u0012\b\u0012\u00060:j\u0002`;092\u000e\u0010<\u001a\n\u0018\u00010=j\u0004\u0018\u0001`>2\u0006\u0010?\u001a\u000203H\u0002J\b\u0010@\u001a\u00020!H\u0002J\b\u0010A\u001a\u00020BH\u0002J\u0010\u0010C\u001a\u00020!2\u0006\u0010D\u001a\u00020\u0019H\u0002J\f\u0010E\u001a\u00020B*\u00020BH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006G"}, d2 = {"Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "viewModel", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsViewModel;", "getViewModel", "()Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "actionModel", "Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "getActionModel", "()Lcom/larus/dora/impl/dynamic/viewmodel/DoraDynamicViewModelV2;", "actionModel$delegate", "adapter", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDslCardAdapter;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "pageKey", "", "localReceiver", "com/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment$localReceiver$1", "Lcom/larus/dora/obric/device_management/setting/earbuds/DoraObricEarbudsDSLSettingsFragment$localReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "onResume", "onStop", "onDoraConnectStateChanged", "isConnected", "", "getCurrentPageName", "logEnterPage", "buildContentView", "buildTitleBar", "setupAdapter", "refreshRenderedCards", "observeViewModel", "observeSettingActions", "shouldHandleConnectionState", "state", "Lcom/larus/dora/impl/dynamic/event/DeviceConnectionState;", "showUnbindConfirmDialog", "event", "Lcom/larus/dora/impl/dynamic/event/DialogEvent$ShowUnbindConfirm;", "updateAdapter", "cards", "", "Lcom/larus/dora/impl/dynamic/dsl/DslCard;", "Lcom/larus/dora/obric/device_management/setting/earbuds/DslCard;", "cardContext", "Lcom/larus/dora/impl/dynamic/entity/CardContext;", "Lcom/larus/dora/obric/device_management/setting/earbuds/CardContext;", "connectionState", "loadData", "resolveBackgroundColor", "", "relaxClipForShadow", "target", "dp", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraObricEarbudsDSLSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public final Lazy f;
    public final Lazy g;
    public DoraObricEarbudsDslCardAdapter h;
    public RecyclerView i;
    public String j;
    public final DoraObricEarbudsDSLSettingsFragment$localReceiver$1 k;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "settings_home";
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void T90() {
        int r0 = y69.a.a;
        String r1 = y69.b.a(this, getArguments());
        Bundle r2 = getArguments();
        if (r2 == null) goto L5;
        String r3 = r2.getString(DoraObricDeviceHomeViewModel.PARAM_ENTER_METHOD);
    L6:
        y69.a.a("settings_home", r1, r3);
        return;
    L5:
        r3 = null;
        goto L6
    }

    public final DoraDynamicViewModelV2 W90() {
        return (DoraDynamicViewModelV2) this.g.getValue();
    }

    public final DoraObricEarbudsDSLSettingsViewModel X90() {
        return (DoraObricEarbudsDSLSettingsViewModel) this.f.getValue();
    }

    public final void Y90() {
        final DoraObricEarbudsDslCardAdapter r0 = this.h;
        if (r0 == null) goto L9;
        o r1 = o.a;
        Intrinsics.checkNotNullParameter(r1, "event");
        if (Intrinsics.areEqual(r1, r1) == false) goto L8;
        r0.e.post(new l(r0));
        return;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStop() {
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).unregisterReceiver(this.k);
        super.onStop();
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.larus.dora.obric.device_management.setting.earbuds.DoraObricEarbudsDSLSettingsFragment$localReceiver$1] */
    public DoraObricEarbudsDSLSettingsFragment() {
        final Function0<Fragment> r0 = new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$1(this);
        this.f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraObricEarbudsDSLSettingsViewModel.class), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$2(r0), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$viewModels$default$3(r0, this));
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraDynamicViewModelV2.class), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraObricEarbudsDSLSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.k = new DoraObricEarbudsDSLSettingsFragment$localReceiver$1(this);
    }

    public final void onResume() {
        super.onResume();
        X90().refreshConnectionState();
        Y90();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        LocalBroadcastManager.getInstance(AppHost.a.getApplication()).registerReceiver(this.k, new IntentFilter("action.DEVICE_UPDATE_NAME"));
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
        super.V90(r1);
        X90().refreshConnectionState();
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        RecyclerView r12 = this.i;
        if (r12 == null) goto L6;
        DoraObricEarbudsDslCardAdapter r13 = new DoraObricEarbudsDslCardAdapter(W90());
        this.h = r13;
        r12.setAdapter(r13);
    L6:
        Bundle r14 = getArguments();
        if (r14 == null) goto L26;
        boolean r1 = false;
        int r0 = r14.getInt("product_id", 0);
        String r6 = r14.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        String r8 = r14.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MAC);
        String r2 = r14.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        this.j = r2;
        Integer r15 = Integer.valueOf(r14.getInt(DoraObricDeviceHomeViewModel.PARAM_VENDOR_ID, 0));
        if (r15.intValue() == 0) goto L15;
        boolean r3 = true;
    L16:
        if (r3 == false) goto L18;
        Integer r4 = r15;
    L19:
        DoraObricEarbudsDSLSettingsViewModel r16 = X90();
        Integer r5 = Integer.valueOf(r0);
        if (r5.intValue() == 0) goto L22;
        r1 = true;
    L22:
        if (r1 == false) goto L24;
        Integer r7 = r5;
    L25:
        r16.loadData(r4, r7, r6, this.j, r8);
        goto L26
    L24:
        r7 = null;
        goto L25
    L18:
        r4 = null;
        goto L19
    L15:
        r3 = false;
    L26:
        Lifecycle.State r17 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeViewModel$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r17, null, this), 3, null);
        W90().getConnectionState().observe(getViewLifecycleOwner(), new j(new c(this)));
        W90().getDialogEvent().observe(getViewLifecycleOwner(), new j(new d(this)));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeSettingActions$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r17, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraObricEarbudsDSLSettingsFragment$observeSettingActions$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r17, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Context r10 = requireContext();
        LinearLayout r11 = new LinearLayout(r10);
        r11.setOrientation(1);
        r11.setClipChildren(true);
        r11.setClipToPadding(true);
        r11.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        OFloatingTitleBar r12 = new OFloatingTitleBar(requireContext(), null, 6, 0);
        com.larus.dora.obric.utils.c.a(r12);
        r12.setBackgroundColor(v19.c.a(2130970531, requireContext(), 2131102535));
        r12.setCenterTitle(getString(2131903496));
        r12.R(false);
        final View r0 = OFloatingTitleBar.k(r12, null, 6);
        r0.setOnClickListener(new com.larus.dora.obric.device_management.setting.earbuds.a(this));
        r12.post(new b(this, r0));
        r11.addView(r12, new LinearLayout.LayoutParams(-1, -2));
        RecyclerView r13 = new RecyclerView(r10);
        r13.setLayoutManager(new LinearLayoutManager(r10));
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setOverScrollMode(2);
        Resources r1 = getResources();
        int r14 = (int) ((8 * WindowDisplayMetricsOverride.apply(r1, r1.getDisplayMetrics()).density) + 0.5f);
        Resources r3 = getResources();
        r13.setPadding(0, r14, 0, (int) ((24 * WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).density) + 0.5f));
        this.i = r13;
        r11.addView(r13, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        return r11;
    }
}
