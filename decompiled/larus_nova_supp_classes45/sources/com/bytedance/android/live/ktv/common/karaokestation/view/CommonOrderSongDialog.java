package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.UpdateTabType;
import com.bytedance.android.live.ktv.common.karaokestation.model.u;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.livesdk.utils.w0;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.google.android.material.tabs.TabLayout;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/CommonOrderSongDialog;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "a", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class CommonOrderSongDialog extends Fragment {
    public static final /* synthetic */ int u = 0;
    public final List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a> d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public View i;
    public FrameLayout j;
    public LinearLayout k;
    public View l;
    public ViewPager m;
    public TabLayout n;
    public FrameLayout o;
    public FrameLayout p;
    public ImageView q;
    public HSImageView r;
    public Function0<Unit> s;
    public final com.bytedance.android.live.ktv.common.karaokestation.model.a t;

    public static final class a {
    }

    static {
    }

    public CommonOrderSongDialog() {
        this(new com.bytedance.android.live.ktv.common.karaokestation.model.a(0));
    }

    public final int S90() {
        Integer r0 = this.t.b.i;
        if (r0 == null) goto L11;
        if (r0 == null) goto L12;
        if (r0.intValue() == 0) goto L11;
    L12:
        return this.t.b.i.intValue();
    L11:
        return s1.f(481.0f);
    }

    public final void onDestroy() {
        super.onDestroy();
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r0 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.h.getValue();
        if (r0 == null) goto L6;
        r0.clearData();
        return;
    }

    public CommonOrderSongDialog(com.bytedance.android.live.ktv.common.karaokestation.model.a r2) {
        Intrinsics.checkNotNullParameter(r2, "commonOrderSongConfig");
        this.t = r2;
        this.d = new ArrayList();
        this.e = LazyKt.lazy(new CommonOrderSongDialog$firstLevelTabPagerAdapter$2(this));
        this.f = LazyKt.lazy(new CommonOrderSongDialog$firstLevelTabViewPagerListener$2(this));
        this.g = LazyKt.lazy(CommonOrderSongDialog$firstLevelTabSelectedListener$2.INSTANCE);
        this.h = LazyKt.lazy(new CommonOrderSongDialog$commonOrderSongViewModel$2(this));
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super.onViewCreated(r7, r8);
        u r9 = this.t.b;
        if (r9.j == false) goto L7;
        Function1<FrameLayout, Unit> r11 = r9.k;
        if (r11 == null) goto L7;
        Unit r12 = (Unit) r11.invoke(this.j);
    L7:
        ViewPager r13 = this.m;
        if (r13 == null) goto L10;
        r13.addOnPageChangeListener((CommonOrderSongDialog$firstLevelTabViewPagerListener$2.AnonymousClass1) this.f.getValue());
    L10:
        TabLayout r14 = this.n;
        if (r14 == null) goto L13;
        r14.addOnTabSelectedListener((CommonOrderSongDialog$firstLevelTabSelectedListener$2.a) this.g.getValue());
    L13:
        ViewPager r15 = this.m;
        if (r15 == null) goto L16;
        r15.setOffscreenPageLimit(((ArrayList) this.d).size());
    L16:
        ViewPager r16 = this.m;
        if (r16 == null) goto L19;
        r16.setAdapter((KtvCommonPagerAdapter) this.e.getValue());
    L19:
        this.t.b.c.invoke();
        this.t.b.d.invoke();
        TabLayout r17 = this.n;
        if (r17 == null) goto L22;
        r17.setupWithViewPager(this.m);
    L22:
        TabLayout r18 = this.n;
        if (r18 == null) goto L25;
        r18.removeAllTabs();
    L25:
        Iterator r19 = ((ArrayList) this.d).iterator();
    L27:
        if (r19.hasNext() == false) goto L29;
        this.t.a.b.invoke(((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r19.next()).aK(), this.n, getContext());
        goto L27
    L29:
        Function3<View, TabLayout, List<com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a>, Unit> r21 = this.t.b.b;
        if (r21 == null) goto L32;
        Unit r22 = (Unit) r21.invoke(this.i, this.n, this.d);
    L32:
        this.t.b.g.invoke(this.r, this.s, getActivity(), this.d, this.n);
        this.t.b.a.invoke();
        Function3<TabLayout, FrameLayout, FrameLayout, Unit> r23 = this.t.b.l;
        if (r23 == null) goto L35;
        Unit r24 = (Unit) r23.invoke(this.n, this.p, this.j);
    L35:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r25 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.h.getValue();
        TabLayout.Tab r26 = null;
        if (r25 == null) goto L40;
        Pair<Integer, UpdateTabType> r27 = r25.getSelectedFirstLevelTabValue();
        if (r27 == null) goto L40;
        Integer r28 = (Integer) r27.getFirst();
    L41:
        Iterator r0 = ((ArrayList) this.d).iterator();
        int r2 = 0;
    L43:
        if (r0.hasNext() == false) goto L54;
        int r3 = ((com.bytedance.android.live.ktv.common.karaokestation.view.firstleveltab.a) r0.next()).VL().getValue();
        if (r28 != null) goto L48;
    L50:
        boolean r4 = false;
    L51:
        if (r4 == true) goto L55;
        r2 = r2 + 1;
    L55:
        ViewPager r29 = this.m;
        if (r29 == null) goto L58;
        r29.setCurrentItem(r2, false);
    L58:
        if (r2 != 0) goto L63;
        CommonOrderSongDialog$firstLevelTabSelectedListener$2.a r31 = (CommonOrderSongDialog$firstLevelTabSelectedListener$2.a) this.g.getValue();
        TabLayout r1 = this.n;
        if (r1 == null) goto L62;
        r26 = r1.getTabAt(r2);
    L62:
        r31.onTabSelected(r26);
        ((CommonOrderSongDialog$firstLevelTabViewPagerListener$2.AnonymousClass1) this.f.getValue()).onPageSelected(0);
    L63:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r32 = (com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b) this.h.getValue();
        if (r32 == null) goto L70;
        r32.observeSelectedFirstLevelTabValueChange(this, new b(this));
        return;
    L70:
        return;
    L48:
        if (r3 != r28.intValue()) goto L50;
        r4 = true;
        goto L51
    L54:
        r2 = -1;
    L40:
        r28 = null;
        goto L41
    }

    public final View onCreateView(LayoutInflater r7, ViewGroup r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r7, "inflater");
        Integer r11 = this.t.b.h;
        if (r11 != null) goto L5;
    L8:
        int r12 = 2131566458;
    L9:
        View r13 = r7.inflate(r12, r8, false);
        this.i = r13;
        if (r13 == null) goto L12;
        FrameLayout r14 = (FrameLayout) r13.findViewById(2131376922);
    L13:
        this.j = r14;
        View r15 = this.i;
        if (r15 == null) goto L16;
        LinearLayout r16 = (LinearLayout) r15.findViewById(2131379436);
    L17:
        this.k = r16;
        View r17 = this.i;
        if (r17 == null) goto L20;
        TabLayout r18 = (TabLayout) r17.findViewById(2131372595);
    L21:
        this.n = r18;
        View r19 = this.i;
        if (r19 == null) goto L24;
        FrameLayout r21 = (FrameLayout) r19.findViewById(2131389111);
    L25:
        this.o = r21;
        View r22 = this.i;
        if (r22 == null) goto L28;
        FrameLayout r23 = (FrameLayout) r22.findViewById(2131381544);
    L29:
        this.p = r23;
        View r24 = this.i;
        if (r24 == null) goto L32;
        ImageView r25 = (ImageView) r24.findViewById(2131363781);
    L33:
        this.q = r25;
        if (((Boolean) this.t.b.m.invoke()).booleanValue() != true) goto L38;
        ImageView r26 = this.q;
        if (r26 == null) goto L41;
        r26.setVisibility(0);
    L41:
        ImageView r27 = this.q;
        if (r27 == null) goto L44;
        r27.setOnClickListener(new w0(new CommonOrderSongDialog$initView$1(this), 500));
    L44:
        View r28 = this.i;
        if (r28 == null) goto L47;
        View r29 = r28.findViewById(2131369184);
    L48:
        this.l = r29;
        if (((Boolean) this.t.b.n.invoke()).booleanValue() != true) goto L53;
        View r31 = this.l;
        if (r31 == null) goto L56;
        r31.setVisibility(0);
    L56:
        View r32 = this.i;
        if (r32 == null) goto L59;
        HSImageView r33 = (HSImageView) r32.findViewById(2131364962);
    L60:
        this.r = r33;
        View r34 = this.i;
        if (r34 == null) goto L63;
        ViewPager r35 = (ViewPager) r34.findViewById(2131372596);
    L64:
        this.m = r35;
        View r36 = this.l;
        if (r36 == null) goto L67;
        r36.setBackgroundColor(ColorProtector.parseColor("#F2F2F2"));
        r36.setAlpha(1.0f);
    L67:
        View r37 = this.i;
        if (r37 == null) goto L73;
        ViewGroup.LayoutParams r38 = r37.getLayoutParams();
        if (r38 != null) goto L72;
        r38 = new ViewGroup.LayoutParams(-1, S90());
    L72:
        r38.height = S90();
        Unit r2 = Unit.INSTANCE;
        r37.setLayoutParams(r38);
    L73:
        LinearLayout r39 = this.k;
        if (r39 == null) goto L76;
        KtvOrderSongThemeManager.c(r39, 7);
    L76:
        TabLayout r41 = this.n;
        if (r41 == null) goto L81;
        r41.setTabMode(1);
        r41.setTabGravity(0);
        r41.setTabIndicatorFullWidth(false);
        r41.setSelectedTabIndicatorColor(KtvOrderSongThemeManager.a(2));
        KtvOrderSongThemeManager.c(r41, 7);
        r41.setTabTextColors(ColorProtector.parseColor("#96989C"), ColorProtector.parseColor("#000000"));
        r41.setTabRippleColor(null);
        if (((Boolean) this.t.b.o.invoke()).booleanValue() == true) goto L81;
        r41.setSelectedTabIndicatorHeight(0);
    L81:
        this.t.a.c.invoke();
        ((ArrayList) this.d).clear();
        this.t.a.d.invoke(this.d);
        KtvCommonPagerAdapter r42 = (KtvCommonPagerAdapter) this.e.getValue();
        if (r42 == null) goto L85;
        ArrayList r43 = new ArrayList();
        r43.addAll(this.d);
        Unit r44 = Unit.INSTANCE;
        r42.f(r43);
    L85:
        return this.i;
    L63:
        r35 = null;
        goto L64
    L59:
        r33 = null;
        goto L60
    L53:
        View r45 = this.l;
        if (r45 == null) goto L56;
        r45.setVisibility(8);
        goto L56
    L47:
        r29 = null;
        goto L48
    L38:
        ImageView r46 = this.q;
        if (r46 == null) goto L41;
        r46.setVisibility(8);
        goto L41
    L32:
        r25 = null;
        goto L33
    L28:
        r23 = null;
        goto L29
    L24:
        r21 = null;
        goto L25
    L20:
        r18 = null;
        goto L21
    L16:
        r16 = null;
        goto L17
    L12:
        r14 = null;
        goto L13
    L5:
        if (r11.intValue() == 0) goto L8;
        r12 = this.t.b.h.intValue();
        goto L9
    }
}
