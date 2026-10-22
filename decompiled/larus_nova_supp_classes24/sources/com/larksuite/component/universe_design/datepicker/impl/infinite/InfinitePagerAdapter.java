package com.larksuite.component.universe_design.datepicker.impl.infinite;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.PagerAdapter;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\b \u0018\u0000 $2\u00020\u0001:\u0001$B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0010\u001a\u00020\u0011J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u001f\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u000b¢\u0006\u0002\u0010\u001aJ \u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0016\u001a\u00020\u000bH&J\u0010\u0010\u001e\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u000bH&J\b\u0010\u001f\u001a\u00020\u000bH\u0016J\u0018\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u0013H\u0016J\u0006\u0010\"\u001a\u00020\u0011J\u0006\u0010#\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082.¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006%"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", "Landroidx/viewpager/widget/PagerAdapter;", "mContext", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "mPageViews", "", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePageView;", "[Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePageView;", "mInflatedPageCount", "", "value", "", "isAllPagesInflated", "()Z", "initAdapterViews", "", "instantiateItem", "", "container", "Landroid/view/ViewGroup;", "position", "getPageView", "T", "Landroid/view/View;", "(I)Landroid/view/View;", "destroyItem", "item", "onInstantiateItem", "afterInstantiateItem", "getCount", "isViewFromObject", "view", "rotateLeft2Right", "rotateRight2Left", "Companion", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public abstract class InfinitePagerAdapter extends PagerAdapter {
    public final Context a;
    public o08.a[] b;

    public static final class a {
    }

    static {
    }

    public abstract void f();

    public final int getCount() {
        return 3;
    }

    public InfinitePagerAdapter(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "mContext");
        this.a = r2;
    }

    public final <T extends View> T g(int r3) {
        o08.a[] r0 = null;
        if (r3 >= 0) goto L5;
        return null;
    L5:
        if (r3 > 2) goto L14;
        o08.a[] r1 = this.b;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
    L12:
        return (T) r0[r3].b;
    L10:
        r0 = r1;
        goto L12
    L14:
        return null;
    }

    public final Object instantiateItem(ViewGroup r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "container");
        o08.a[] r0 = this.b;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        r0 = null;
    L5:
        o08.a r4 = r0[r3];
        r2.addView(r4.a);
        f();
        return r4;
    }

    public final boolean isViewFromObject(View r2, Object r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        Intrinsics.checkNotNullParameter(r3, "item");
        if (r2 != ((o08.a) r3).a) goto L5;
        return true;
    L5:
        return false;
    }

    public final void destroyItem(ViewGroup r1, int r2, Object r3) {
        Intrinsics.checkNotNullParameter(r1, "container");
        Intrinsics.checkNotNullParameter(r3, "item");
        if ((r3 instanceof o08.a) == false) goto L5;
        o08.a r4 = (o08.a) r3;
    L6:
        if (r4 != null) goto L8;
        return;
    L8:
        r1.removeView(r4.a);
        return;
    L5:
        r4 = null;
        goto L6
    }
}
