package com.bytedance.android.live.ktv.common.karaokestation.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/karaokestation/view/ScrollControlViewPager;", "Landroidx/viewpager/widget/ViewPager;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ScrollControlViewPager extends ViewPager {
    public boolean a;

    public final boolean canScrollHorizontally(int r2) {
        boolean r0 = this.a;
        if (r0 == true) goto L5;
        return r0;
    L5:
        return super.canScrollHorizontally(r2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
        return false;
    L5:
        return super.onInterceptTouchEvent(r2);
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        if (this.a == true) goto L5;
        return true;
    L5:
        return super.onTouchEvent(r2);
    }

    public ScrollControlViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.a = true;
    }

    public final void h(int r2, Function0<Unit> r3) {
        Intrinsics.checkNotNullParameter(r3, "postHandle");
        setCurrentItem(r2);
        if (r2 != 0) goto L6;
        r3.invoke();
        return;
    }
}
