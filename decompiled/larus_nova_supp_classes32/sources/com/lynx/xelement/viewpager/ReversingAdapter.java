package com.lynx.xelement.viewpager;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/lynx/xelement/viewpager/ReversingAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "a", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public final class ReversingAdapter extends PagerAdapter {
    public final PagerAdapter a;
    public boolean b;

    public static final class a extends DataSetObserver {
        public final ReversingAdapter a;

        @Override // android.database.DataSetObserver
        public final void onChanged() {
            ReversingAdapter r0 = this.a;
            if (r0 == null) goto L6;
            ReversingAdapter.f(r0);
            return;
        }

        @Override // android.database.DataSetObserver
        public final void onInvalidated() {
            onChanged();
        }

        public a(ReversingAdapter r2) {
            Intrinsics.checkNotNullParameter(r2, "mParent");
            this.a = r2;
        }
    }

    public final int getCount() {
        return this.a.getCount();
    }

    public ReversingAdapter(PagerAdapter r2) {
        Intrinsics.checkNotNullParameter(r2, "mDelegete");
        this.a = r2;
        r2.registerDataSetObserver(new a(this));
    }

    public static final void f(ReversingAdapter r0) {
        super.notifyDataSetChanged();
    }

    public final int getItemPosition(Object r3) {
        Intrinsics.checkNotNullParameter(r3, "object");
        int r4 = this.a.getItemPosition(r3);
        if (this.b == true) goto L5;
        return r4;
    L5:
        if (r4 != (-2)) goto L7;
    L9:
        return -2;
    L7:
        if (r4 == (-1)) goto L9;
        return (getCount() - r4) - 1;
    }

    public final CharSequence getPageTitle(int r2) {
        if (this.b == false) goto L6;
        r2 = (getCount() - r2) - 1;
    L6:
        return this.a.getPageTitle(r2);
    }

    public final float getPageWidth(int r2) {
        if (this.b == false) goto L6;
        r2 = (getCount() - r2) - 1;
    L6:
        return this.a.getPageWidth(r2);
    }

    @Deprecated(message = NameKeys.UnloadStrategy_No_Strategy)
    public final Object instantiateItem(View r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (this.b == false) goto L6;
        r3 = (getCount() - r3) - 1;
    L6:
        return this.a.instantiateItem(r2, r3);
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "o");
        return this.a.isViewFromObject(r2, r3);
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        if (this.b == false) goto L6;
        r3 = (getCount() - r3) - 1;
    L6:
        return this.a.instantiateItem(r2, r3);
    }

    @Deprecated(message = NameKeys.UnloadStrategy_No_Strategy)
    public final void destroyItem(View r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        if (this.b == false) goto L5;
        r3 = (getCount() - r3) - 1;
    L5:
        this.a.destroyItem(r2, r3, r4);
    }

    @Deprecated(message = NameKeys.UnloadStrategy_No_Strategy)
    public final void setPrimaryItem(View r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        if (this.b == false) goto L5;
        r3 = (getCount() - r3) - 1;
    L5:
        this.a.setPrimaryItem(r2, r3, r4);
    }

    public final void destroyItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        if (this.b == false) goto L5;
        r3 = (getCount() - r3) - 1;
    L5:
        this.a.destroyItem(r2, r3, r4);
    }

    public final void setPrimaryItem(ViewGroup r2, int r3, Object r4) {
        Intrinsics.checkNotNullParameter(r2, "container");
        Intrinsics.checkNotNullParameter(r4, "object");
        if (this.b == false) goto L5;
        r3 = (getCount() - r3) - 1;
    L5:
        this.a.setPrimaryItem(r2, r3, r4);
    }
}
