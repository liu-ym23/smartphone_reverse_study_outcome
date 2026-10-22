package com.larus.business.debug.base.adapter;

import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.business.debug.base.register.EntrancePage;
import cw8.a;
import cw8.b;
import cw8.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zv8.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\rH\u0016J\u0018\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\rH\u0016J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/business/debug/base/adapter/EntranceTabAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "<init>", "()V", "tabList", "", "Lcom/larus/business/debug/base/register/EntrancePage;", "getTabList", "()Ljava/util/List;", "pageList", "", "Lcom/larus/business/debug/base/view/DebugEntrancePage;", "getCount", "", "isViewFromObject", "", "view", "Landroid/view/View;", "object", "", "getPageTitle", "", "position", "instantiateItem", "container", "Landroid/view/ViewGroup;", "destroyItem", "", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EntranceTabAdapter extends PagerAdapter {
    public final List<b> a;

    public final int getCount() {
        k.a.getClass();
        return k.d.size();
    }

    public EntranceTabAdapter() {
        this.a = new ArrayList();
    }

    public final CharSequence getPageTitle(int r2) {
        k.a.getClass();
        return ((EntrancePage) ListProtector.get(k.d, r2)).getDes();
    }

    public final Object instantiateItem(ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r4, "container");
        EntrancePage r0 = EntrancePage.ALL;
        if (r5 != r0.getIndex()) goto L5;
        k.a.getClass();
        b r1 = new b(r0, r4, k.c(r0));
    L9:
        r1.c();
        View r2 = r1.d;
        r4.addView(r2);
        ListProtector.add(this.a, r5, r1);
        return r2;
    L5:
        EntrancePage r3 = EntrancePage.RECENTLY;
        if (r5 != r3.getIndex()) goto L8;
        k.a.getClass();
        r1 = new d(r3, r4, k.c(r3));
        goto L9
    L8:
        EntrancePage r6 = EntrancePage.FAVORITE;
        k.a.getClass();
        r1 = new a(r6, r4, k.c(r6));
        goto L9
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "object");
        return Intrinsics.areEqual(r2, r3);
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        if ((r4 instanceof View) == false) goto L5;
        View r5 = (View) r4;
    L6:
        if (r5 == null) goto L9;
        r2.removeView(r5);
        ((b) ListProtector.remove(this.a, r3)).d();
        return;
    L9:
        return;
    L5:
        r5 = null;
        goto L6
    }
}
