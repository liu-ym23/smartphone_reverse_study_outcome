package com.larus.dora.impl.wlan.wifi;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.databinding.LarusDoraPageWifiSettingsBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import com.larus.utils.e1;
import com.larus.utils.j0;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.flow.FlowCollector;
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00132\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u001bH\u0016J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020'H\u0002J\b\u0010)\u001a\u00020*H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageWifiSettingsBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsViewModel;", "getModel", "()Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsViewModel;", "model$delegate", "Lkotlin/Lazy;", "wifiListAdapter", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiAdapter;", "wifiAddResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/content/Intent;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onStart", "handleUiState", "", "state", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsState;", "handleEvent", "event", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiSettingsEvent;", "deleteWifi", "entity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "showDeleteWifiConfirmDialog", "getCurrentPageName", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiSettingsFragment extends DoraBaseFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDoraPageWifiSettingsBinding f;
    public final Lazy g;
    public DoraWifiAdapter h;
    public final ActivityResultLauncher<Intent> i;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraWifiSettingsFragment a;

        public b(DoraWifiSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            k r6 = (k) r4;
            DoraWifiSettingsFragment r7 = this.a;
            LarusDoraPageWifiSettingsBinding r0 = r7.f;
            if (r0 == null) goto L16;
            g49.d.d("DoraWifiSettingsFragment", "handleUiState: " + r6);
            if ((r6 instanceof k.a) == false) goto L8;
            Unit r8 = Unit.INSTANCE;
            goto L16
        L8:
            if ((r6 instanceof k.b) == false) goto L14;
            DoraWifiAdapter r9 = r7.h;
            if (r9 == null) goto L12;
            List<DoraWifiEntity> r10 = ((k.b) r6).a;
            Intrinsics.checkNotNullParameter(r10, "list");
            ((ArrayList) r9.e).clear();
            ((ArrayList) r9.e).addAll(r10);
            r9.notifyDataSetChanged();
        L12:
            final RecyclerView r11 = r0.e;
            r11.post(new h(r11));
            goto L16
        L14:
            throw new NoWhenBranchMatchedException();
        L16:
            return Unit.INSTANCE;
        }
    }

    public static final class c<T> implements FlowCollector {
        public final /* synthetic */ DoraWifiSettingsFragment a;

        public c(DoraWifiSettingsFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r2, Continuation r3) {
            DoraWifiSettingsFragment r4 = this.a;
            int r0 = DoraWifiSettingsFragment.j;
            r4.getClass();
            if ((((com.larus.dora.impl.wlan.wifi.c) r2) instanceof com.larus.dora.impl.wlan.wifi.c.a) == false) goto L7;
            s r5 = s.a;
            Application r6 = AppHost.a.getApplication();
            r5.getClass();
            s.s(r6, 2131904086);
            return Unit.INSTANCE;
        L7:
            throw new NoWhenBranchMatchedException();
        }
    }

    static {
    }

    public final String k() {
        return "wifi_settings";
    }

    public final DoraWifiSettingsViewModel W90() {
        return (DoraWifiSettingsViewModel) this.g.getValue();
    }

    public DoraWifiSettingsFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraWifiSettingsViewModel.class), new DoraWifiSettingsFragment$special$$inlined$activityViewModels$default$1(this), new DoraWifiSettingsFragment$special$$inlined$activityViewModels$default$2(this));
        this.i = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new g());
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        W90().loadSavedWifiList();
    }

    public final void onViewCreated(View r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r10, r11);
        LarusDoraPageWifiSettingsBinding r12 = this.f;
        if (r12 == null) goto L5;
        NovaTitleBarEx r0 = r12.f;
        int r1 = j0.a;
        NovaTitleBarEx.Y5(r0, j0.d(2131904085), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new d(this), 14);
        this.h = new DoraWifiAdapter(j0.d(2131904072), DoraWifiOpt.DELETE, new e(this));
        RecyclerView r2 = r12.e;
        r2.setAdapter(new ConcatAdapter(new RecyclerView.Adapter[]{new DoraWifiHeaderAdapter(), this.h}));
        r2.setLayoutManager(new LinearLayoutManager(r2.getContext()));
        e1.d(r12.d, new f(this));
    L5:
        Lifecycle.State r13 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraWifiSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r13, null, this), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraWifiSettingsFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$2(this, r13, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r1, ViewGroup r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r1, "inflater");
        LarusDoraPageWifiSettingsBinding r4 = LarusDoraPageWifiSettingsBinding.a(r1, r2);
        this.f = r4;
        return r4.a;
    }
}
