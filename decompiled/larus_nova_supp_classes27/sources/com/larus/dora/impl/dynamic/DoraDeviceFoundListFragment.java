package com.larus.dora.impl.dynamic;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.larus.dora.impl.databinding.LarusDoraPageDeviceListBinding;
import com.larus.dora.impl.device.DoraBaseFragment;
import com.larus.dora.impl.dynamic.loader.DslLocalCache;
import com.larus.dora.impl.dynamic.widget.HistoryDeviceNavigationBar;
import com.larus.dora.impl.dynamic.widget.VerticalSpaceItemDecoration;
import com.larus.dora.impl.settings.DoraSetting;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000u\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005*\u0001\u0011\u0018\u0000 32\u00020\u0001:\u00013B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\rH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u001cH\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020'H\u0002J\u0019\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J.\u0010-\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0018\u00010/2\u0006\u00100\u001a\u00020'H\u0002J\b\u00101\u001a\u00020\u001cH\u0016J\b\u00102\u001a\u00020\rH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0012¨\u00064"}, d2 = {"Lcom/larus/dora/impl/dynamic/DoraDeviceFoundListFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "binding", "Lcom/larus/dora/impl/databinding/LarusDoraPageDeviceListBinding;", "adapter", "Lcom/larus/dora/impl/dynamic/DslCardAdapter;", "dataLoader", "Lcom/larus/dora/impl/dynamic/loader/DslDynamicDataLoader;", "dslLocalCache", "Lcom/larus/dora/impl/dynamic/loader/DslLocalCache;", "pageKey", "", "productModel", "prePage", "broadcastReceiver", "com/larus/dora/impl/dynamic/DoraDeviceFoundListFragment$broadcastReceiver$1", "Lcom/larus/dora/impl/dynamic/DoraDeviceFoundListFragment$broadcastReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupAdapter", "pageTitle", "setupRecyclerView", "setupAdapterWithLocalDsl", "setupAdapterWithDynamicDsl", "filterUnsupportedHCard", "pageInfo", "Lcom/larus/dora/impl/dynamic/dsl/DslDeviceListPage;", "isDoraGEnabled", "", "resolveGDeviceType", "Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "productId", "", "(Ljava/lang/Integer;)Lcom/larus/dora/impl/resource/DoraResourceDeviceType;", "setupPage", "starling", "", "hasContent", "onDestroyView", "getCurrentPageName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraDeviceFoundListFragment extends DoraBaseFragment {
    public static final /* synthetic */ int l = 0;
    public LarusDoraPageDeviceListBinding f;
    public DslCardAdapter g;
    public com.larus.dora.impl.dynamic.loader.d h;
    public DslLocalCache i;
    public String j;
    public final DoraDeviceFoundListFragment$broadcastReceiver$1 k;

    public static final class a {
    }

    static {
    }

    public final String k() {
        return "DoraDynamicActivity";
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.dynamic.DoraDeviceFoundListFragment$broadcastReceiver$1] */
    public DoraDeviceFoundListFragment() {
        this.k = new DoraDeviceFoundListFragment$broadcastReceiver$1(this);
    }

    public final void onDestroyView() {
        super/*androidx.fragment.app.Fragment*/.onDestroyView();
        Context r0 = getContext();
        if (r0 == null) goto L6;
        LocalBroadcastManager.getInstance(r0).unregisterReceiver(this.k);
        return;
    }

    public static final void W90(DoraDeviceFoundListFragment r4, c59.l r5) {
        r4.getClass();
        DoraSetting.a.getClass();
        if (DoraSetting.l() == true) goto L21;
        ArrayList r6 = new ArrayList();
        Iterator<T> r0 = r5.b.iterator();
    L6:
        if (r0.hasNext() == false) goto L14;
        c59.i r1 = (c59.i) r0.next();
        Map<String, Object> r2 = r1.b;
        if (r2 == null) goto L10;
        Object r3 = r2.get("device_type");
    L12:
        if (Intrinsics.areEqual(r3, "other") == true) goto L6;
        r6.add(r1);
        goto L6
    L10:
        r3 = null;
        goto L12
    L14:
        r5.b.clear();
        r5.b.addAll(r6);
        return;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        Bundle r9 = getArguments();
        if (r9 == null) goto L5;
        r9.getString("page_title");
    L5:
        Bundle r10 = getArguments();
        if (r10 == null) goto L8;
        r10.getString(DoraObricDeviceHomeViewModel.PARAM_PREVIOUS_PAGE, "");
    L8:
        Bundle r11 = getArguments();
        if (r11 == null) goto L11;
        r11.getString(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
    L11:
        Bundle r12 = getArguments();
        if (r12 == null) goto L15;
        String r13 = r12.getString(DoraObricDeviceHomeViewModel.PARAM_PAGE_KEY);
        if (r13 == null) goto L15;
    L16:
        this.j = r13;
        this.g = new DslCardAdapter(null);
        LarusDoraPageDeviceListBinding r14 = this.f;
        if (r14 == null) goto L20;
        com.larus.utils.e1.x(r14.c);
        r14.c.setLeftClickListener(new l(this));
        r14.b.setAdapter(this.g);
        r14.b.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        r14.b.addItemDecoration(new VerticalSpaceItemDecoration(i5.h()));
    L20:
        if (com.larus.dora.impl.util.s.a() == false) goto L22;
        this.i = new DslLocalCache();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraDeviceFoundListFragment$setupAdapterWithLocalDsl$1(this, null), 2, null);
        return;
    L22:
        this.h = new com.larus.dora.impl.dynamic.loader.d();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new DoraDeviceFoundListFragment$setupAdapterWithDynamicDsl$1(this, null), 2, null);
        return;
    L15:
        r13 = "device_list_v2";
        goto L16
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562260, r3, false);
        int r6 = 2131368923;
        RecyclerView r7 = ViewBindings.findChildViewById(r5, 2131368923);
        if (r7 == null) goto L15;
        r6 = 2131368926;
        HistoryDeviceNavigationBar r0 = (HistoryDeviceNavigationBar) ViewBindings.findChildViewById(r5, 2131368926);
        if (r0 == null) goto L15;
        this.f = new LarusDoraPageDeviceListBinding((LinearLayout) r5, r7, r0);
        Context r8 = getContext();
        if (r8 == null) goto L9;
        IntentFilter r9 = new IntentFilter("action.ONBOARDING_ACTIVITY_DESTROY");
        r9.addAction("action.ONBOARDING_ACTIVITY_CREATE");
        LocalBroadcastManager.getInstance(r8).registerReceiver(this.k, r9);
    L9:
        LarusDoraPageDeviceListBinding r10 = this.f;
        if (r10 != null) goto L16;
        return null;
    L16:
        return r10.a;
    L15:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }

    public static final void X90(final DoraDeviceFoundListFragment r2, final c59.l r3, final Map r4, final boolean r5) {
        r2.getClass();
        g49.d.d("DoraDeviceFoundListFragment", "setupPage: " + r3 + ", hasContent: " + r5);
        LarusDoraPageDeviceListBinding r0 = r2.f;
        if (r0 == null) goto L8;
        LinearLayout r1 = r0.a;
        if (r1 == null) goto L9;
        r1.post(new m(r2, r3, r5, r4));
        return;
    L9:
        return;
    }
}
