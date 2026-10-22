package com.larus.dora.impl.device.settings.lab.env.wifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.databinding.LarusDoraGEnvObserveWifiBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/env/wifi/EnvObserveWiFiFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraGEnvObserveWifiBinding;", "viewModel", "Lcom/larus/dora/impl/device/settings/lab/env/wifi/EnvObserveWiFiViewModel;", "getViewModel", "()Lcom/larus/dora/impl/device/settings/lab/env/wifi/EnvObserveWiFiViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnvObserveWiFiFragment extends DoraBaseFragment {
    public static final /* synthetic */ int h = 0;
    public LarusDoraGEnvObserveWifiBinding f;
    public final Lazy g;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "env_observe_wifi";
    }

    public EnvObserveWiFiFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(EnvObserveWiFiViewModel.class), new EnvObserveWiFiFragment$special$$inlined$activityViewModels$default$1(this), new EnvObserveWiFiFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraGEnvObserveWifiBinding r10 = this.f;
        CustomSwitchCompat r11 = null;
        if (r10 == null) goto L7;
        NovaTitleBarEx r0 = r10.c;
        if (r0 == null) goto L7;
        NovaTitleBarEx.Y5(r0, "连接指定 WiFi", null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new com.larus.dora.impl.device.settings.lab.env.wifi.a(this), 14);
    L7:
        LarusDoraGEnvObserveWifiBinding r12 = this.f;
        if (r12 == null) goto L12;
        ItemTextToggle r13 = r12.b;
        if (r13 == null) goto L12;
        r11 = r13.getToggleView();
    L12:
        if (r11 == null) goto L15;
        r11.setOnCheckedChangeListener(new b(this));
        return;
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ConstraintLayout r5 = r2.inflate(2131562191, r3, false);
        int r6 = 2131369579;
        ItemTextToggle r7 = ViewBindings.findChildViewById(r5, 2131369579);
        if (r7 == null) goto L9;
        r6 = 2131388772;
        NovaTitleBarEx r0 = ViewBindings.findChildViewById(r5, 2131388772);
        if (r0 == null) goto L9;
        ConstraintLayout r8 = r5;
        this.f = new LarusDoraGEnvObserveWifiBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
