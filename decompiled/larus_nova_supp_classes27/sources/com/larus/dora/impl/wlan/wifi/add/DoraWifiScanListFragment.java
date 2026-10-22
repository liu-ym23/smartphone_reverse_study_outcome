package com.larus.dora.impl.wlan.wifi.add;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.impl.databinding.LarusDoraPageWifiScanListBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.wlan.wifi.DoraWifiAdapter;
import com.larus.dora.impl.wlan.wifi.DoraWifiEntity;
import com.larus.dora.impl.wlan.wifi.DoraWifiOpt;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageWifiScanListBinding;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListViewModel;", "getModel", "()Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiScanListViewModel;", "model$delegate", "Lkotlin/Lazy;", "wifiListAdapter", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiAdapter;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "handleUiState", "", "state", "Lcom/larus/dora/impl/wlan/wifi/add/DoraWifiAddState;", "getCurrentPageName", "", "showAddWifiDialog", "wifiEntity", "Lcom/larus/dora/impl/wlan/wifi/DoraWifiEntity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraWifiScanListFragment extends DoraBaseFragment {
    public static final /* synthetic */ int i = 0;
    public LarusDoraPageWifiScanListBinding f;
    public final Lazy g;
    public DoraWifiAdapter h;

    public static final class a {
    }

    public static final class b<T> implements FlowCollector {
        public final /* synthetic */ DoraWifiScanListFragment a;

        public b(DoraWifiScanListFragment r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            g r6 = (g) r4;
            final DoraWifiScanListFragment r7 = this.a;
            LarusDoraPageWifiScanListBinding r0 = r7.f;
            if (r0 == null) goto L22;
            g49.d.d("DoraWifiScanListFragment", "handleUiState: " + r6);
            if ((r6 instanceof g.a) == false) goto L8;
            e1.o(r0.g);
            e1.o(r0.c);
            Unit r8 = Unit.INSTANCE;
            goto L22
        L8:
            if ((r6 instanceof g.d) == false) goto L11;
            e1.o(r0.g);
            e1.x(r0.c);
            e1.d(r0.c, new k());
            e1.x(r0.d);
            e1.o(r0.e);
            TextView r9 = r0.f;
            int r10 = j0.a;
            r9.setText(j0.d(2131904084));
            Unit r11 = Unit.INSTANCE;
            goto L22
        L11:
            if ((r6 instanceof g.b) == false) goto L14;
            e1.o(r0.g);
            e1.x(r0.c);
            e1.d(r0.c, new l(r7));
            e1.o(r0.d);
            e1.x(r0.e);
            TextView r12 = r0.f;
            int r13 = j0.a;
            r12.setText(j0.d(2131904083));
            Unit r14 = Unit.INSTANCE;
            goto L22
        L14:
            if ((r6 instanceof g.c) == false) goto L20;
            e1.x(r0.g);
            e1.o(r0.c);
            DoraWifiAdapter r15 = r7.h;
            if (r15 == null) goto L18;
            List<DoraWifiEntity> r16 = ((g.c) r6).a;
            Intrinsics.checkNotNullParameter(r16, "list");
            ((ArrayList) r15.e).clear();
            ((ArrayList) r15.e).addAll(r16);
            r15.notifyDataSetChanged();
        L18:
            final RecyclerView r17 = r0.g;
            r17.post(new m(r17));
            goto L22
        L20:
            throw new NoWhenBranchMatchedException();
        L22:
            return Unit.INSTANCE;
        }
    }

    static {
    }

    public final String k() {
        return "wifi_scan_list";
    }

    public DoraWifiScanListFragment() {
        this.g = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(DoraWifiScanListViewModel.class), new DoraWifiScanListFragment$special$$inlined$activityViewModels$default$1(this), new DoraWifiScanListFragment$special$$inlined$activityViewModels$default$2(this));
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageWifiScanListBinding r10 = this.f;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.h;
        int r1 = j0.a;
        NovaTitleBarEx.Y5(r0, j0.d(2131904071), null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new i(this), 14);
        DoraWifiAdapter r2 = new DoraWifiAdapter(j0.d(2131904082), DoraWifiOpt.ADD, new j(this));
        this.h = r2;
        RecyclerView r11 = r10.g;
        r11.setAdapter(r2);
        r11.setLayoutManager(new LinearLayoutManager(r11.getContext()));
    L5:
        Lifecycle.State r12 = Lifecycle.State.STARTED;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new DoraWifiScanListFragment$onViewCreated$$inlined$launchAndRepeatWithViewLifecycle$default$1(this, r12, null, this), 3, null);
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562295, r11, false);
        int r14 = 2131369962;
        View r2 = ViewBindings.findChildViewById(r13, 2131369962);
        if (r2 == null) goto L19;
        r14 = 2131370059;
        LinearLayoutCompat r3 = ViewBindings.findChildViewById(r13, 2131370059);
        if (r3 == null) goto L19;
        r14 = 2131370060;
        ProgressBar r4 = (ProgressBar) ViewBindings.findChildViewById(r13, 2131370060);
        if (r4 == null) goto L19;
        r14 = 2131370061;
        ImageView r5 = (ImageView) ViewBindings.findChildViewById(r13, 2131370061);
        if (r5 == null) goto L19;
        r14 = 2131370062;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, 2131370062);
        if (r6 == null) goto L19;
        r14 = 2131370069;
        RecyclerView r7 = ViewBindings.findChildViewById(r13, 2131370069);
        if (r7 == null) goto L19;
        r14 = 2131388772;
        NovaTitleBarEx r8 = ViewBindings.findChildViewById(r13, 2131388772);
        if (r8 == null) goto L19;
        ConstraintLayout r15 = r13;
        this.f = new LarusDoraPageWifiScanListBinding(r15, r2, r3, r4, r5, r6, r7, r8);
        return r15;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
