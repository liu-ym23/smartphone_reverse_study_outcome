package com.larus.discover.impl.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.larus.bmhome.BaseHomeTabFragment;
import com.larus.discover.impl.databinding.LarusDiscoverMainLayoutBinding;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import s19.a;
import tx9.a1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u0012\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u0014H\u0016J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\f\u0010\u001c\u001a\u00020\u0017*\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\u0017H\u0002J\u0017\u0010!\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u001f\u001a\u00020\bH\u0002¢\u0006\u0002\u0010\"J\b\u0010#\u001a\u00020$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\bH\u0016J\n\u0010'\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010)\u001a\u00020\u00172\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J \u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020$2\u000e\u0010-\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010.H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/discover/impl/view/DiscoverMainFragment;", "Lcom/larus/bmhome/BaseHomeTabFragment;", "Lcom/larus/common_ui/tab/TabChildFragment;", "<init>", "()V", "binding", "Lcom/larus/discover/impl/databinding/LarusDiscoverMainLayoutBinding;", "lastSelectedIndex", "", "tabNameTrackMap", "", "", "tabNameEnterPageTrackMap", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "previousPage", "onViewCreated", "", "view", "onNewIntent", "bundle", "initView", "debounceSlip", "Landroidx/viewpager2/widget/ViewPager2;", "reportEnterPage", "position", "setupTabLayout", "reportClickTab", "(I)Lkotlin/Unit;", "autoLogEnterPage", "", "getCurrentPageName", "tabIndex", "getCurrentFragment", "Landroidx/fragment/app/Fragment;", "onEnterTab", "onLeaveTab", "onTabClick", "doubleClick", "callback", "Lkotlin/Function0;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DiscoverMainFragment extends BaseHomeTabFragment implements a {
    public LarusDiscoverMainLayoutBinding j;
    public int k;
    public final Map<Integer, String> l;
    public final Map<Integer, String> m;
    public String n;

    public DiscoverMainFragment() {
        super(false);
        this.k = -1;
        this.l = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "bot"), TuplesKt.to(1, "creation")});
        this.m = MapsKt.mapOf(new Pair[]{TuplesKt.to(0, "bot_list_discover"), TuplesKt.to(1, "creation_list_discover")});
        this.n = "";
    }

    public final boolean S90() {
        return false;
    }

    @Override // s19.a
    public final void a2(Bundle r1) {
    }

    public final String k() {
        return "discover_page";
    }

    @Override // s19.a
    public final int sb() {
        return BaseHomeTabFragment.MainTab.DISCOVERY.getIndex();
    }

    public final Fragment getCurrentFragment() {
        FragmentManager r0 = getChildFragmentManager();
        StringBuilder r1 = new StringBuilder("f");
        LarusDiscoverMainLayoutBinding r2 = this.j;
        if (r2 == null) goto L7;
        ViewPager2 r3 = r2.c;
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getCurrentItem());
    L8:
        r1.append(r4);
        return r0.findFragmentByTag(r1.toString());
    L7:
        r4 = null;
        goto L8
    }

    @Override // s19.a
    public final void t1() {
        a r0 = getCurrentFragment();
        if ((r0 instanceof a) == false) goto L5;
        a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.t1();
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // s19.a
    public final void y2(String r57) {
        LarusDiscoverMainLayoutBinding r1 = this.j;
        if (r1 == null) goto L7;
        ViewPager2 r2 = r1.c;
        if (r2 == null) goto L7;
        int r3 = r2.getCurrentItem();
    L8:
        if (r57 != null) goto L10;
        String r4 = "";
    L11:
        this.n = r4;
        a r5 = getCurrentFragment();
        if ((r5 instanceof a) == false) goto L14;
        a r6 = r5;
    L15:
        if (r6 == null) goto L17;
        r6.y2(r57);
    L17:
        a1.c(null, null, null, null, null, this.m.get(Integer.valueOf(r3)), null, null, "click_tab", null, null, null, null, null, null, null, r57, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, -1049729, -1, 7);
        return;
    L14:
        r6 = null;
        goto L15
    L10:
        r4 = r57;
    L7:
        r3 = 0;
        goto L8
    }

    @Override // s19.a
    public final void KC(boolean r3, Function0<Unit> r4) {
        a r0 = getCurrentFragment();
        if ((r0 instanceof a) == false) goto L5;
        a r1 = r0;
    L6:
        if (r1 == null) goto L9;
        r1.KC(r3, r4);
        return;
    L9:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        final LarusDiscoverMainLayoutBinding r9 = this.j;
        if (r9 == null) goto L23;
        TabLayout r10 = r9.b;
        if (r10 == null) goto L22;
        String[] r2 = new String[2];
        Context r3 = getContext();
        String r4 = "";
        if (r3 == null) goto L11;
        String r5 = r3.getString(2131901660);
        if (r5 == null) goto L11;
    L12:
        r2[0] = r5;
        Context r6 = getContext();
        if (r6 == null) goto L18;
        String r11 = r6.getString(2131901657);
        if (r11 == null) goto L18;
        r4 = r11;
    L18:
        r2[1] = r4;
        Iterator r12 = CollectionsKt.listOf(r2).iterator();
    L20:
        if (r12.hasNext() == false) goto L22;
        String r13 = (String) r12.next();
        r10.addTab(r10.newTab().setText(r13));
    L11:
        r5 = "";
    L22:
        r9.c.setAdapter(new DiscoverMainAdapter(this));
        r9.c.setOffscreenPageLimit(-1);
        r9.b.addOnTabSelectedListener(new c39.a(r9));
        r9.c.registerOnPageChangeCallback(new DiscoverMainFragment$initView$1$2(this, r9));
        ViewPager2 r14 = r9.c;
        Field r15 = ViewPager2.class.getDeclaredField("mRecyclerView");
        r15.setAccessible(true);
        Object r16 = r15.get(r14);
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView");
        RecyclerView r17 = (RecyclerView) r16;
        Field r18 = RecyclerView.class.getDeclaredField("mTouchSlop");
        r18.setAccessible(true);
        Object r1 = r18.get(r17);
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type kotlin.Int");
        r18.set(r17, Integer.valueOf(((Integer) r1).intValue() * 2));
    L23:
        FLogger.a.d("BaseHomeTabFragment", "initView");
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = getLayoutInflater().inflate(2131562120, r3, false);
        int r6 = 2131387992;
        TabLayout r7 = ViewBindings.findChildViewById(r5, 2131387992);
        if (r7 == null) goto L9;
        r6 = 2131392623;
        ViewPager2 r0 = ViewBindings.findChildViewById(r5, 2131392623);
        if (r0 == null) goto L9;
        FrameLayout r8 = (FrameLayout) r5;
        this.j = new LarusDiscoverMainLayoutBinding(r8, r7, r0);
        return r8;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
