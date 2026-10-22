package com.larus.dora.impl.wlan;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.dora.wlan.direct.WifiDirectOwnerProxy;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.dora.impl.databinding.LarusDoraPageWlanBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.platform.api.g1;
import com.larus.platform.service.i2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.larus.utils.y;
import g49.d;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import pk4.i;
import pk4.n;
import s69.c;
import s69.e;
import s69.f;
import s69.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 (2\u00020\u00012\u00020\u0002:\u0001(B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0014\u001a\u00020\u0012H\u0002J\u0012\u0010\u0015\u001a\u00020\u00122\b\b\u0002\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0012H\u0002J\b\u0010\u0019\u001a\u00020\u0012H\u0016J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0012H\u0016J\b\u0010\u001c\u001a\u00020\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\u0017H\u0016J\n\u0010!\u001a\u0004\u0018\u00010\"H\u0002J \u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020%H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/larus/dora/impl/wlan/WlanFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "Lcom/bytedance/dora/wlan/direct/IWifiDirect$IWifiDirectStateCallback;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageWlanBinding;", "ioScope", "Lkotlinx/coroutines/CoroutineScope;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setPrefer", "checkPerm", "request", "", "updateWlanUI", "onStart", "onDestroy", "onResume", "onDestroyView", "getCurrentPageName", "", "onDoraConnectStateChanged", "isConnected", "setupTitle", "Lcom/larus/bmhome/view/NovaTitleBarEx;", "onStateChanged", "p0", "", "p1", "reason", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WlanFragment extends DoraBaseFragment implements com.bytedance.dora.wlan.direct.a.a {
    public static final /* synthetic */ int h = 0;
    public LarusDoraPageWlanBinding f;
    public final CoroutineScope g;

    public static final class a {
    }

    public static final class b implements g1.c {
        public final /* synthetic */ WlanFragment a;

        public final void onSettingPageReturn() {
        }

        public final void onGoSettingsDialogShow() {
            d.d("WlanFragment", "checkReady: permission onGoSettingsDialogShow");
        }

        public b(WlanFragment r1) {
            this.a = r1;
        }

        public final void onGoSettingsDialogDismiss(boolean r3) {
            d.d("WlanFragment", "checkReady: permission onGoSettingsDialogDismiss, " + r3);
            if (r3 == true) goto L8;
            FragmentActivity r4 = this.a.getActivity();
            if (r4 == null) goto L9;
            r4.finish();
            return;
        L9:
            return;
        }

        public final void onResult(boolean r1, List<String> r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "grantedList");
            Intrinsics.checkNotNullParameter(r3, "deniedList");
            d.d("WlanFragment", "checkReady: request permission, isGranted = " + r1);
            if (r1 == true) goto L6;
            d.d("WlanFragment", "checkReady: request permission failed,");
            return;
        }
    }

    static {
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void V90(boolean r1) {
    }

    public final String k() {
        return "nl";
    }

    public final void X90() {
        LarusDoraPageWlanBinding r0 = this.f;
        if (r0 == null) goto L11;
        TextView r1 = r0.e;
        if (r1 == null) goto L11;
        int r2 = wk4.a.a;
        int r3 = WifiDirectOwnerProxy.k;
        if (WifiDirectOwnerProxy.a.a.t() != 1) goto L9;
        String r4 = "当前状态: 已连接";
    L10:
        r1.setText(r4);
        goto L11
    L9:
        r4 = "当前状态: 未连接";
    L11:
        W90(false);
        LarusDoraPageWlanBinding r5 = this.f;
        if (r5 == null) goto L24;
        int r6 = wk4.a.a;
        int r7 = WifiDirectOwnerProxy.k;
        int r8 = WifiDirectOwnerProxy.a.a.t();
        if (r8 != 2) goto L16;
        r5.i.setTextColor(ContextCompat.getColor(r5.l.getContext(), 2131101066));
        return;
    L16:
        if (r8 != 3) goto L18;
        r5.f.setTextColor(ContextCompat.getColor(r5.l.getContext(), 2131101066));
        return;
    L18:
        if (r8 != 4) goto L27;
        r5.g.setTextColor(ContextCompat.getColor(r5.l.getContext(), 2131101066));
        return;
    L27:
        return;
    }

    public final void Xb() {
        y.c(new g(this));
    }

    public WlanFragment() {
        this.g = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        int r0 = wk4.a.a;
        int r1 = WifiDirectOwnerProxy.k;
        WifiDirectOwnerProxy.a.a.getClass();
        ((CopyOnWriteArraySet) com.bytedance.dora.wlan.direct.a.q1).remove(this);
    }

    public final void onResume() {
        super.onResume();
        X90();
    }

    @Override // com.larus.dora.impl.device.DoraBaseFragment
    public final void onStart() {
        super.onStart();
        int r0 = wk4.a.a;
        int r1 = WifiDirectOwnerProxy.k;
        WifiDirectOwnerProxy.a.a.getClass();
        ((CopyOnWriteArraySet) com.bytedance.dora.wlan.direct.a.q1).add(this);
        W90(true);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
    }

    public final void W90(boolean r12) {
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 33) goto L6;
        int r5 = ContextCompat.checkSelfPermission(n.c, "android.permission.NEARBY_WIFI_DEVICES");
        d.a("WlanFragment", "onWlanStateChanged: NEARBY_WIFI_DEVICES " + r5);
        if (r5 == 0) goto L6;
    L8:
        LarusDoraPageWlanBinding r2 = this.f;
        if (r2 == null) goto L11;
        r2.h.setTextColor(ContextCompat.getColor(r2.l.getContext(), 2131101066));
    L11:
        if (r12 == false) goto L25;
        i2 r13 = i2.b;
        ArrayList r6 = new ArrayList();
        if (r0 < 33) goto L15;
        r6.add("android.permission.NEARBY_WIFI_DEVICES");
        r6.add("android.permission.ACCESS_FINE_LOCATION");
    L16:
        Unit r14 = Unit.INSTANCE;
        b r7 = new b(this);
        if (r0 < 31) goto L19;
        int r15 = j0.a;
        Map r16 = MapsKt.mapOf(TuplesKt.to("android.permission.BLUETOOTH_SCAN", j0.d(2131898485)));
    L20:
        g1.a.a(this, r6, r7, r16, null, 16);
        return;
    L19:
        int r1 = j0.a;
        r16 = MapsKt.mapOf(new Pair[]{TuplesKt.to("android.permission.BLUETOOTH", j0.d(2131898485)), TuplesKt.to("android.permission.ACCESS_FINE_LOCATION", j0.d(2131898489)), TuplesKt.to("android.permission.ACCESS_COARSE_LOCATION", j0.d(2131898489))});
        goto L20
    L15:
        r6.add("android.permission.ACCESS_FINE_LOCATION");
        goto L16
    L25:
        return;
    L6:
        int r8 = ContextCompat.checkSelfPermission(n.c, "android.permission.ACCESS_FINE_LOCATION");
        d.a("WlanFragment", "onWlanStateChanged: ACCESS_FINE_LOCATION " + r8);
        if (r8 != 0) goto L8;
        LarusDoraPageWlanBinding r17 = this.f;
        if (r17 == null) goto L27;
        r17.h.setTextColor(ContextCompat.getColor(r17.l.getContext(), 2131103136));
        return;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDoraPageWlanBinding r10 = this.f;
        if (r10 == null) goto L5;
        NovaTitleBarEx r0 = r10.k;
        NovaTitleBarEx.Y5(r0, "眼镜连接状态", null, null, 6);
        NovaTitleBarEx.b6(r0, 2131240517, false, null, null, new c(this), 14);
    L5:
        X90();
        LarusDoraPageWlanBinding r11 = this.f;
        if (r11 == null) goto L12;
        CustomSwitchCompat r12 = r11.j.getToggleView();
        int r1 = wk4.a.a;
        int r2 = WifiDirectOwnerProxy.k;
        WifiDirectOwnerProxy.a.a.getClass();
        boolean r3 = false;
        if (i.a.a.a.getInt("wlan_switch_state", 0) != 1) goto L10;
        r3 = true;
    L10:
        r12.setChecked(r3);
        r11.j.getToggleView().setOnCheckedChangeListener(new s69.d());
        e1.d(r11.b, new e());
        e1.d(r11.c, new f());
        return;
    }

    public final View onCreateView(LayoutInflater r17, ViewGroup r18, Bundle r110) {
        Intrinsics.checkNotNullParameter(r17, "inflater");
        ConstraintLayout r0 = r17.inflate(2131562297, r18, false);
        int r1 = 2131369958;
        ItemTextArrow r5 = ViewBindings.findChildViewById(r0, 2131369958);
        if (r5 == null) goto L31;
        r1 = 2131369959;
        ItemTextArrow r6 = ViewBindings.findChildViewById(r0, 2131369959);
        if (r6 == null) goto L31;
        r1 = 2131369962;
        View r7 = ViewBindings.findChildViewById(r0, 2131369962);
        if (r7 == null) goto L31;
        r1 = 2131370072;
        if (ViewBindings.findChildViewById(r0, 2131370072) == null) goto L31;
        r1 = 2131370073;
        TextView r8 = (TextView) ViewBindings.findChildViewById(r0, 2131370073);
        if (r8 == null) goto L31;
        r1 = 2131370074;
        AppCompatTextView r9 = ViewBindings.findChildViewById(r0, 2131370074);
        if (r9 == null) goto L31;
        r1 = 2131370075;
        AppCompatTextView r10 = ViewBindings.findChildViewById(r0, 2131370075);
        if (r10 == null) goto L31;
        r1 = 2131370076;
        AppCompatTextView r11 = ViewBindings.findChildViewById(r0, 2131370076);
        if (r11 == null) goto L31;
        r1 = 2131370077;
        AppCompatTextView r12 = ViewBindings.findChildViewById(r0, 2131370077);
        if (r12 == null) goto L31;
        r1 = 2131370078;
        ItemTextToggle r13 = ViewBindings.findChildViewById(r0, 2131370078);
        if (r13 == null) goto L31;
        r1 = 2131385238;
        if (((ScrollView) ViewBindings.findChildViewById(r0, 2131385238)) == null) goto L31;
        r1 = 2131388772;
        NovaTitleBarEx r14 = ViewBindings.findChildViewById(r0, 2131388772);
        if (r14 == null) goto L31;
        r1 = 2131393310;
        TextView r15 = (TextView) ViewBindings.findChildViewById(r0, 2131393310);
        if (r15 == null) goto L31;
        ConstraintLayout r2 = r0;
        this.f = new LarusDoraPageWlanBinding(r2, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15);
        return r2;
    L31:
        throw new NullPointerException("Missing required view with ID: ".concat(r0.getResources().getResourceName(r1)));
    }
}
