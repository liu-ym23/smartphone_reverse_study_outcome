package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter;

import a20.e;
import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import c20.d;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.f;
import com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.g;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.ft0;
import com.bytedance.android.livesdk.config.k81;
import com.bytedance.android.livesdk.widget.LivePagerSlidingTabStrip;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.live.datacontext.m;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/OpenFeatureTabPageAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "Lcom/bytedance/android/livesdk/widget/LivePagerSlidingTabStrip$b;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureTabPageAdapter extends PagerAdapter implements LivePagerSlidingTabStrip.b {
    public final ArrayList<c20.a> a;
    public final ArrayList<d> b;
    public final Map<Integer, WeakReference<RecyclerView>> c;
    public Function3<? super RecyclerView, ? super LinearLayoutManager, ? super Integer, Unit> d;
    public View.OnClickListener e;
    public final e f;
    public final LivePagerSlidingTabStrip g;
    public final ViewPager h;
    public final List<b20.e> i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ OpenFeatureTabPageAdapter a;

        public a(OpenFeatureTabPageAdapter r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            View.OnClickListener r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.onClick(r2);
            return;
        }
    }

    public final int getCount() {
        return this.b.size();
    }

    public final int getItemPosition(Object r9) {
        Intrinsics.checkNotNullParameter(r9, "obj");
        if (((k81) ft0.a.getValue()).b() == false) goto L32;
        Object r1 = null;
        if ((r9 instanceof RecyclerView) == true) goto L7;
        r9 = null;
    L7:
        RecyclerView r11 = (RecyclerView) r9;
        if (r11 == null) goto L10;
        RecyclerView.Adapter r12 = r11.getAdapter();
    L12:
        if ((r12 instanceof OpenFeatureTabListAdapter) == true) goto L14;
        r12 = null;
    L14:
        OpenFeatureTabListAdapter r13 = (OpenFeatureTabListAdapter) r12;
        if (r13 == null) goto L39;
        Iterator<T> r0 = this.a.iterator();
    L18:
        if (r0.hasNext() == false) goto L28;
        Object r2 = r0.next();
        long r3 = ((c20.a) r2).a;
        Long r5 = r13.c;
        if (r5 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L18;
        r1 = r2;
        goto L28
    L23:
        if (r3 != r5.longValue()) goto L25;
        r4 = true;
    L28:
        c20.a r6 = (c20.a) r1;
        if (r6 == null) goto L40;
        r13.setData(h(Long.valueOf(r6.a), r6.b));
        return -1;
    L40:
        return -2;
    L39:
        return -2;
    L10:
        r12 = null;
        goto L12
    L32:
        return -2;
    }

    public final CharSequence getPageTitle(int r2) {
        return ((d) ListProtector.get(this.b, r2)).b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View, com.bytedance.android.live.broadcastgame.openplatform.feature_panel.view.tab.e] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    /* JADX WARN: Type inference failed for: r7v9 */
    public final View c(Context r7, int r8) {
        CharSequence r0 = getPageTitle(r8);
        if (r0 != null) goto L6;
        r0 = "";
    L6:
        if (Intrinsics.areEqual(s1.B(2131920955), r0) == false) goto L8;
        TextView r1 = new TextView(r7);
        r1.setText(r0);
        r1.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        r1.setTextSize(13.0f);
        r1.setTypeface(Typeface.DEFAULT_BOLD);
        ImageView r2 = new ImageView(r7);
        r2.setOnClickListener(new a(this));
        r2.setLayoutParams(new ViewGroup.LayoutParams(s1.f(22.0f), s1.f(22.0f)));
        r2.setImageDrawable(s1.m(2131250558));
        Intrinsics.checkNotNull(r7);
        ?? r3 = new g(r7, r2, r1);
    L9:
        Room r5 = null;
        RoomContext r9 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r9 == null) goto L14;
        m r11 = r9.getRoom();
        if (r11 == null) goto L14;
        r5 = (Room) r11.getValue();
    L14:
        boolean r12 = false;
        if (r5 == null) goto L17;
        boolean r4 = true;
    L18:
        if (r8 != 0) goto L20;
        boolean r6 = true;
    L22:
        if (((k81) ft0.a.getValue()).c() == false) goto L29;
        ViewPager r13 = this.h;
        if (r13 != null) goto L26;
    L28:
        r6 = r12;
        goto L29
    L26:
        if (r8 != r13.getCurrentItem()) goto L28;
        r12 = true;
    L29:
        if (r4 == false) goto L33;
        if (r6 == false) goto L32;
        int r14 = 2131107976;
    L36:
        r3.setColor(s1.h(r14));
        if (r4 == false) goto L39;
    L44:
        return r3;
    L39:
        if ((r3 instanceof f) == false) goto L44;
        f r15 = (f) r3;
        if (r6 == false) goto L43;
        r15.setTextSize(15.0f);
        goto L44
    L43:
        r15.setTextSize(13.0f);
        goto L44
    L32:
        r14 = 2131107979;
        goto L36
    L33:
        if (r6 == false) goto L35;
        r14 = 2131107977;
        goto L36
    L35:
        r14 = 2131107980;
        goto L36
    L20:
        r6 = false;
        goto L22
    L17:
        r4 = false;
        goto L18
    L8:
        Intrinsics.checkNotNull(r7);
        r3 = new f(r7, r0);
        goto L9
    }

    public final void f(List<c20.a> r11, List<d> r12) {
        Intrinsics.checkNotNullParameter(r11, "items");
        Intrinsics.checkNotNullParameter(r12, "tabNameList");
        this.a.clear();
        Object r4 = null;
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L9;
        m r1 = r0.getRoom();
        if (r1 == null) goto L9;
        Room r2 = (Room) r1.getValue();
        if (r2 == null) goto L9;
        int r3 = r2.getVisibilityRange();
    L11:
        if (r3 == 11) goto L26;
        Iterator<T> r5 = r11.iterator();
    L14:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if (((c20.a) r6).a != 6) goto L18;
        boolean r7 = true;
    L19:
        if (r7 == false) goto L14;
        r4 = r6;
        goto L21
    L18:
        r7 = false;
    L21:
        c20.a r8 = (c20.a) r4;
        if (r8 == null) goto L26;
        List<f10.f> r9 = r8.b;
        if (r9 == null) goto L26;
        CollectionsKt.removeAll(r9, OpenFeatureTabPageAdapter$setData$2.INSTANCE);
    L26:
        this.a.addAll(r11);
        this.b.clear();
        this.b.addAll(r12);
        notifyDataSetChanged();
        return;
    L9:
        r3 = 0;
        goto L11
    }

    public final List<f10.f> h(Long r5, List<f10.f> r6) {
        if (r5 != null) goto L5;
    L20:
        return r6;
    L5:
        if (r5.longValue() != 6) goto L20;
        List<f10.f> r7 = r6;
        ArrayList r8 = new ArrayList();
        Iterator<T> r0 = r7.iterator();
    L8:
        if (r0.hasNext() == false) goto L12;
        Object r1 = r0.next();
        if (((f10.f) r1).u == false) goto L8;
        r8.add(r1);
        goto L8
    L12:
        ArrayList r2 = new ArrayList();
        Iterator<T> r9 = r7.iterator();
    L14:
        if (r9.hasNext() == false) goto L19;
        Object r3 = r9.next();
        if (((f10.f) r3).u == true) goto L14;
        r2.add(r3);
        goto L14
    L19:
        return CollectionsKt.plus(r8, r2);
    }

    public final Object instantiateItem(ViewGroup r7, int r8) {
        Intrinsics.checkNotNullParameter(r7, KtvSubElement.CONTAINER);
        RecyclerView r0 = LayoutInflater.from(r7.getContext()).inflate(2131567070, r7, false);
        if ((r0 instanceof RecyclerView) == true) goto L5;
        RecyclerView r1 = null;
    L6:
        RecyclerView r2 = r1;
        if (r2 != null) goto L9;
        return r0;
    L9:
        r2.setOverScrollMode(2);
        r2.setLayoutManager(new LinearLayoutManager(r7.getContext()));
        List<f10.f> r3 = ((c20.a) ListProtector.get(this.a, r8)).b;
        ArrayList r4 = new ArrayList();
        if (((k81) ft0.a.getValue()).b() == false) goto L12;
        r3 = h(Long.valueOf(((c20.a) ListProtector.get(this.a, r8)).a), r3);
        r4.add(new f20.d(this.f));
    L12:
        r4.add(new f20.e(this.f));
        r2.setAdapter(new OpenFeatureTabListAdapter(r3, r4, Long.valueOf(((c20.a) ListProtector.get(this.a, r8)).a)));
        RecyclerView.Adapter r5 = r2.getAdapter();
        if (r5 == null) goto L29;
        ((OpenFeatureTabListAdapter) r5).notifyDataSetChanged();
        LivePagerSlidingTabStrip r6 = this.g;
        if (r6 == null) goto L19;
        ViewPager r9 = this.h;
        if (r9 == null) goto L19;
        r6.setViewPager(r9);
    L19:
        Function3<? super RecyclerView, ? super LinearLayoutManager, ? super Integer, Unit> r11 = this.d;
        if (r11 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rvInitCallback");
    L22:
        LinearLayoutManager r12 = r2.getLayoutManager();
        if (r12 == null) goto L27;
        r11.invoke(r2, r12, Integer.valueOf(r8));
        r7.addView(r2);
        this.c.put(Integer.valueOf(r8), new WeakReference(r2));
        return r2;
    L27:
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
    L29:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.OpenFeatureTabListAdapter");
    L5:
        r1 = r0;
        goto L6
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "p0");
        Intrinsics.checkNotNullParameter(r3, "p1");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r3, "object");
        r1.removeView((View) r3);
    }

    public final void g(List<d> r8, ViewPager r9, Map<String, ? extends Object> r11) {
        Intrinsics.checkNotNullParameter(r8, "data");
        List<b20.e> r0 = this.i;
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        Iterator<b20.e> r2 = this.i.iterator();
    L13:
        if (r2.hasNext() == false) goto L23;
        b20.e r3 = r2.next();
        Iterator<T> r4 = r8.iterator();
        int r5 = 0;
    L16:
        if (r4.hasNext() == false) goto L13;
        if (r3.a(((d) r4.next()).a, r11) == false) goto L22;
        if (r3.b(r8, r9, r5) == false) goto L22;
        return;
    L22:
        r5 = r5 + 1;
        goto L16
    L23:
        return;
    L5:
        if (r0.isEmpty() == true) goto L8;
        r1 = false;
        goto L9
    }

    public OpenFeatureTabPageAdapter(a20.d r1, LivePagerSlidingTabStrip r2, ViewPager r3, List r4) {
        this.f = r1;
        this.g = r2;
        this.h = r3;
        this.i = r4;
        this.a = new ArrayList();
        this.b = new ArrayList();
        this.c = new LinkedHashMap();
    }
}
