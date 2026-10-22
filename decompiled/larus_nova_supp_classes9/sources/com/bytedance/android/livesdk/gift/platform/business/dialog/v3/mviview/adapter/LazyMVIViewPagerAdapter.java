package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.anya.MVIState;
import com.bytedance.android.anya.MVIViewPagerAdapter;
import com.bytedance.android.anya.p;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.GiftMVIVerticalListView;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\f\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0005:\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/dialog/v3/mviview/adapter/LazyMVIViewPagerAdapter;", "Lcom/bytedance/android/anya/MVIState;", "STATE", "Lcom/bytedance/android/anya/p;", "ACTION", "Lcom/bytedance/android/anya/MVIViewPagerAdapter;", "a", "b", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class LazyMVIViewPagerAdapter<STATE extends MVIState<?>, ACTION extends com.bytedance.android.anya.p> extends MVIViewPagerAdapter<STATE, ACTION> {
    public static final /* synthetic */ int m = 0;
    public int e;
    public boolean f;
    public final Map<Integer, Object> g;
    public final Map<Integer, b> h;
    public final Set<Integer> i;
    public final Set<Integer> j;
    public b0 k;
    public final Handler l;

    public static final class a {
    }

    public static final class b {
        public final int a;
        public final View b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof b) == false) goto L10;
            b r4 = (b) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            View r1 = this.b;
            if (r1 == null) goto L5;
            int r2 = r1.hashCode();
        L7:
            return r0 + r2;
        L5:
            r2 = 0;
            goto L7
        }

        public final String toString() {
            return "PlaceholderPage(position=" + this.a + ", view=" + this.b + ")";
        }

        public b(int r2, View r3) {
            Intrinsics.checkNotNullParameter(r3, "view");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public final int getItemPosition(Object r6) {
        Intrinsics.checkNotNullParameter(r6, "object");
        int r0 = getCount();
        if ((r6 instanceof b) == false) goto L19;
        int r7 = ((b) r6).a;
        if (r7 < 0) goto L50;
        if (r7 < r0) goto L9;
        return -2;
    L9:
        if (this.f == true) goto L14;
        if (this.j.contains(Integer.valueOf(r7)) == false) goto L14;
        return -2;
    L14:
        if (this.f == false) goto L51;
        if (r7 != this.e) goto L51;
        return -2;
    L51:
        return r7;
    L50:
        return -2;
    L19:
        Iterator r1 = ((LinkedHashMap) this.g).entrySet().iterator();
    L21:
        if (r1.hasNext() == false) goto L28;
        Object r3 = r1.next();
        if (((Map.Entry) r3).getValue() != r6) goto L25;
        boolean r4 = true;
    L26:
        if (r4 == false) goto L21;
    L29:
        Map.Entry r5 = (Map.Entry) r3;
        if (r5 == null) goto L32;
        int r2 = ((Number) r5.getKey()).intValue();
        if (r2 < 0) goto L52;
        if (r2 < r0) goto L38;
        return -2;
    L38:
        if (this.f == true) goto L41;
        return super.getItemPosition(r6);
    L41:
        if (r2 == this.e) goto L44;
        return -2;
    L44:
        return super.getItemPosition(r6);
    L52:
        return -2;
    L32:
        return super.getItemPosition(r6);
    L25:
        r4 = false;
        goto L26
    L28:
        r3 = null;
        goto L29
    }

    public final void h(int r3) {
        int r0 = getCount();
        if (r3 < 0) goto L20;
        if (r3 < r0) goto L7;
        return;
    L7:
        if (this.f == false) goto L13;
        if (r3 != this.e) goto L11;
        return;
    L11:
        this.e = r3;
        notifyDataSetChanged();
        return;
    L13:
        if (this.h.containsKey(Integer.valueOf(r3)) == true) goto L16;
        return;
    L16:
        if (this.j.add(Integer.valueOf(r3)) == true) goto L18;
        return;
    L18:
        notifyDataSetChanged();
        return;
    }

    public LazyMVIViewPagerAdapter(GiftMVIVerticalListView r2, Function3 r3) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        Intrinsics.checkNotNullParameter(r3, "createPage");
        super(r2, r3);
        this.f = true;
        this.g = new LinkedHashMap();
        this.h = new LinkedHashMap();
        this.i = new LinkedHashSet();
        this.j = new LinkedHashSet();
        this.l = new Handler(Looper.getMainLooper());
    }

    public final Object instantiateItem(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        if (this.f == true) goto L10;
        Object r0 = super.instantiateItem(r4, r5);
        this.g.put(Integer.valueOf(r5), r0);
        b r1 = this.h.remove(Integer.valueOf(r5));
        if (r1 == null) goto L7;
        r4.removeView(r1.b);
    L7:
        this.j.remove(Integer.valueOf(r5));
        return r0;
    L10:
        if (r5 != this.e) goto L14;
        Object r2 = super.instantiateItem(r4, r5);
        this.g.put(Integer.valueOf(r5), r2);
        b r6 = this.h.remove(Integer.valueOf(r5));
        if (r6 == null) goto L16;
        r4.removeView(r6.b);
        return r2;
    L16:
        return r2;
    L14:
        FrameLayout r3 = new FrameLayout(r4.getContext());
        r3.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        r4.addView(r3);
        b r7 = new b(r5, r3);
        this.h.put(Integer.valueOf(r5), r7);
        this.g.remove(Integer.valueOf(r5));
        this.i.add(Integer.valueOf(r5));
        return r7;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "object");
        if ((r3 instanceof b) == false) goto L9;
        if (r2 != ((b) r3).b) goto L7;
        return true;
    L7:
        return false;
    L9:
        return super.isViewFromObject(r2, r3);
    }

    public final void destroyItem(ViewGroup r4, int r5, Object r6) {
        Intrinsics.checkNotNullParameter(r4, "container");
        Intrinsics.checkNotNullParameter(r6, "object");
        if ((r6 instanceof b) == false) goto L5;
        b r7 = (b) r6;
        this.h.remove(Integer.valueOf(r7.a));
        r4.removeView(r7.b);
        return;
    L5:
        Iterator r0 = ((LinkedHashMap) this.g).entrySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L14;
        Object r1 = r0.next();
        if (((Map.Entry) r1).getValue() != r6) goto L11;
        boolean r2 = true;
    L12:
        if (r2 == false) goto L7;
    L15:
        Map.Entry r3 = (Map.Entry) r1;
        if (r3 == null) goto L18;
        this.g.remove(r3.getKey());
    L18:
        super.destroyItem(r4, r5, r6);
        return;
    L11:
        r2 = false;
        goto L12
    L14:
        r1 = null;
        goto L15
    }
}
