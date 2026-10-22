package com.bytedance.android.live.liveinteract.interactivesong.panel;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/live/liveinteract/interactivesong/panel/MvSelectPagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "()V", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MvSelectPagerAdapter extends PagerAdapter {
    public List<String> a;
    public final ArrayList<MvSelectListView> b;
    public f c;

    public final int getCount() {
        List<String> r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.size();
    }

    public MvSelectPagerAdapter() {
        this.b = new ArrayList();
        this.c = new f(null, 3);
    }

    public final Object instantiateItem(ViewGroup r5, int r6) {
        Intrinsics.checkNotNullParameter(r5, "container");
        if (r6 < 0) goto L15;
        if (r6 >= this.b.size()) goto L15;
        MvSelectListView r0 = (MvSelectListView) ListProtector.get(this.b, r6);
        int r1 = this.b.size();
        if (r6 < 0) goto L12;
        if (r1 <= r6) goto L12;
        f r7 = this.c;
        r0.a(r7.b, r7.a.getName(), false, null);
    L12:
        r5.addView(r0);
        return r0;
    L15:
        return new Object();
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "obj");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "obj");
        if ((r3 instanceof View) == false) goto L8;
        View r4 = (View) r3;
        if (r1.indexOfChild(r4) < 0) goto L9;
        r1.removeView(r4);
        return;
    L9:
        return;
    }

    public final void f(f r3, int r4, boolean r5, Function0<Unit> r6) {
        Intrinsics.checkNotNullParameter(r3, "tabBean");
        Intrinsics.checkNotNullParameter(r6, "refreshCB");
        if (r4 >= 0) goto L5;
        return;
    L5:
        if (r4 > (this.b.size() - 1)) goto L18;
        this.c = r3;
        MvSelectListView r0 = (MvSelectListView) ListProtector.get(this.b, r4);
        int r1 = this.b.size();
        if (r4 < 0) goto L19;
        if (r1 > r4) goto L12;
        return;
    L12:
        if (this.b.isEmpty() == true) goto L20;
        r0.a(r3.b, r3.a.getName(), r5, r6);
        return;
    L20:
        return;
    L19:
        return;
    }
}
