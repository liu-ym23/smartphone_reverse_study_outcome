package com.larksuite.component.universe_design.datepicker.impl.infinite;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.account.saas.core.internal.network.CommonResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import o08.a;
import o08.b;
import o08.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001:\u0001-B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J\u000e\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000fJ\u0016\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0016J\u0010\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\f2\u0006\u0010$\u001a\u00020%H\u0016J\u0010\u0010'\u001a\u00020\f2\u0006\u0010(\u001a\u00020\nH\u0016J\u0010\u0010)\u001a\u00020\f2\u0006\u0010(\u001a\u00020\nH\u0016J\u0012\u0010*\u001a\u00020\u001c2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006."}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;", "Landroidx/viewpager/widget/ViewPager;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "mSelectedPosition", "", "mIsNeedNotifyRotateListener", "", "mListeners", "", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/OnViewPagerChange;", "isPageEnabled", "()Z", "setPageEnabled", "(Z)V", "mIsSmoothScroll", "mOnSmoothScrollFinishListener", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/OnSmoothScrollFinishListener;", "value", "scrollState", "getScrollState", "()I", "init", "", "addListener", "listener", "smoothScrollToPage", "pageIndex", "needNotifyRotateListener", "setOnSmoothScrollFinishListener", "onInterceptTouchEvent", "ev", "Landroid/view/MotionEvent;", "onTouchEvent", "canScrollHorizontally", "direction", "canScrollVertically", "setAdapter", "adapter", "Landroidx/viewpager/widget/PagerAdapter;", "OnPageChange", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class InfiniteViewPager extends ViewPager {
    public int a;
    public boolean b;
    public List<c> c;
    public boolean d;
    public boolean e;
    public b f;
    public int g;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\bH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0006¨\u0006\u0017"}, d2 = {"Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager$OnPageChange;", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "<init>", "(Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfiniteViewPager;)V", "isNeedNotifyRotatedListener", "", "()Z", "onPageScrolled", "", "position", "", "positionOffset", "", "positionOffsetPixels", "onPageSelected", "notifySmoothScrollIfNeed", "notifyWillMoveToCenterPageIfNeed", "notifyWillMoveToFollowingPageIfNeed", "adapter", "Lcom/larksuite/component/universe_design/datepicker/impl/infinite/InfinitePagerAdapter;", "notifyWillMoveToPreviousPageIfNeed", "onPageScrollStateChanged", "state", "universe-ui-datepicker_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
    public final class OnPageChange implements ViewPager.OnPageChangeListener {
        public final /* synthetic */ InfiniteViewPager a;

        public final void onPageScrolled(int r1, float r2, int r3) {
        }

        public final boolean a() {
            InfiniteViewPager r0 = this.a;
            if (r0.c != null) goto L5;
        L7:
            return false;
        L5:
            if (r0.b == false) goto L7;
            return true;
        }

        public OnPageChange(InfiniteViewPager r1) {
            this.a = r1;
        }

        public final void onPageScrollStateChanged(int r10) {
            InfiniteViewPager r0 = this.a;
            r0.g = r10;
            if (r10 == 0) goto L5;
            return;
        L5:
            int r11 = r0.a;
            if (r11 == 0) goto L12;
            if (r11 == 1) goto L11;
            if (r11 != 2) goto L11;
            int r12 = 0;
        L14:
            if (a() == false) goto L21;
            List<c> r3 = this.a.c;
            if (r3 == null) goto L21;
            Iterator r4 = ((ArrayList) r3).iterator();
        L19:
            if (r4.hasNext() == false) goto L21;
            ((c) r4.next()).c();
        L21:
            InfinitePagerAdapter r5 = (InfinitePagerAdapter) this.a.getAdapter();
            a[] r6 = null;
            if (r12 == 0) goto L55;
            if (r12 != 1) goto L86;
            if (r5 == null) goto L86;
            a[] r7 = r5.b;
            if (r7 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r7 = null;
        L29:
            r7[2].b();
            a[] r8 = r5.b;
            if (r8 != null) goto L32;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r8 = null;
        L32:
            View r9 = r8[2].b;
            a[] r13 = r5.b;
            if (r13 != null) goto L35;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r13 = null;
        L35:
            r13[1].b();
            a[] r14 = r5.b;
            if (r14 != null) goto L38;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r14 = null;
        L38:
            a r2 = r14[2];
            a[] r15 = r5.b;
            if (r15 != null) goto L41;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r15 = null;
        L41:
            r2.a(r15[1].b);
            a[] r16 = r5.b;
            if (r16 != null) goto L44;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r16 = null;
        L44:
            r16[0].b();
            a[] r17 = r5.b;
            if (r17 != null) goto L47;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r17 = null;
        L47:
            a r19 = r17[1];
            a[] r20 = r5.b;
            if (r20 != null) goto L50;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r20 = null;
        L50:
            r19.a(r20[0].b);
            a[] r21 = r5.b;
            if (r21 != null) goto L53;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        L54:
            r6[0].a(r9);
            goto L86
        L53:
            r6 = r21;
        L86:
            if (a() == false) goto L93;
            List<c> r22 = this.a.c;
            if (r22 == null) goto L93;
            Iterator r23 = ((ArrayList) r22).iterator();
        L91:
            if (r23.hasNext() == false) goto L93;
            ((c) r23.next()).b(r12);
        L93:
            this.a.setCurrentItem(1, false);
            return;
        L55:
            if (r5 == null) goto L86;
            a[] r24 = r5.b;
            if (r24 != null) goto L59;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r24 = null;
        L59:
            r24[0].b();
            a[] r25 = r5.b;
            if (r25 != null) goto L62;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r25 = null;
        L62:
            View r26 = r25[0].b;
            a[] r27 = r5.b;
            if (r27 != null) goto L65;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r27 = null;
        L65:
            r27[1].b();
            a[] r29 = r5.b;
            if (r29 != null) goto L68;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r29 = null;
        L68:
            a r30 = r29[0];
            a[] r31 = r5.b;
            if (r31 != null) goto L71;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r31 = null;
        L71:
            r30.a(r31[1].b);
            a[] r32 = r5.b;
            if (r32 != null) goto L74;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r32 = null;
        L74:
            r32[2].b();
            a[] r33 = r5.b;
            if (r33 != null) goto L77;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r33 = null;
        L77:
            a r34 = r33[1];
            a[] r35 = r5.b;
            if (r35 != null) goto L80;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
            r35 = null;
        L80:
            r34.a(r35[2].b);
            a[] r36 = r5.b;
            if (r36 != null) goto L83;
            Intrinsics.throwUninitializedPropertyAccessException("mPageViews");
        L84:
            r6[2].a(r26);
            goto L86
        L83:
            r6 = r36;
        L11:
            r12 = CommonResponse.CODE_UNKNOWN;
            goto L14
        L12:
            r12 = 1;
            goto L14
        }

        public final void onPageSelected(int r5) {
            InfiniteViewPager r0 = this.a;
            r0.a = r5;
            PagerAdapter r6 = r0.getAdapter();
            if ((r6 instanceof InfinitePagerAdapter) == false) goto L5;
            InfinitePagerAdapter r7 = (InfinitePagerAdapter) r6;
        L6:
            if (r7 != null) goto L8;
            return;
        L8:
            int r1 = this.a.a;
            if (r1 == 0) goto L43;
            if (r1 == 2) goto L28;
            if (a() == false) goto L21;
            List<c> r8 = this.a.c;
            if (r8 == null) goto L21;
            Iterator r9 = ((ArrayList) r8).iterator();
        L19:
            if (r9.hasNext() == false) goto L21;
            ((c) r9.next()).a();
        L21:
            InfiniteViewPager r10 = this.a;
            if (r10.e == false) goto L26;
            b r11 = r10.f;
            if (r11 == null) goto L26;
            r11.a();
            this.a.e = false;
        L26:
            this.a.b = true;
            return;
        L28:
            if (a() == false) goto L63;
            View r2 = r7.g(1);
            if (r2 == null) goto L64;
            View r12 = r7.g(2);
            if (r12 == null) goto L65;
            List<c> r3 = this.a.c;
            if (r3 == null) goto L61;
            Iterator r4 = ((ArrayList) r3).iterator();
        L40:
            if (r4.hasNext() == false) goto L69;
            ((c) r4.next()).e(r2, r12);
            goto L40
        L69:
            return;
        L61:
            return;
        L65:
            return;
        L64:
            return;
        L63:
            return;
        L43:
            if (a() == false) goto L66;
            View r13 = r7.g(1);
            if (r13 == null) goto L67;
            View r14 = r7.g(0);
            if (r14 == null) goto L68;
            List<c> r15 = this.a.c;
            if (r15 == null) goto L62;
            Iterator r16 = ((ArrayList) r15).iterator();
        L55:
            if (r16.hasNext() == false) goto L70;
            ((c) r16.next()).d(r13, r14);
            goto L55
        L70:
            return;
        L62:
            return;
        L68:
            return;
        L67:
            return;
        L66:
            return;
        L5:
            r7 = null;
            goto L6
        }
    }

    public final int getScrollState() {
        return this.g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InfiniteViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.b = true;
        addOnPageChangeListener(new OnPageChange(this));
        this.d = true;
        setOverScrollMode(2);
    }

    public final boolean canScrollHorizontally(int r2) {
        if (this.d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.canScrollHorizontally(r2) == false) goto L7;
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean canScrollVertically(int r2) {
        if (this.d == true) goto L5;
    L7:
        return false;
    L5:
        if (super/*android.view.ViewGroup*/.canScrollVertically(r2) == false) goto L7;
        return true;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (this.d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onInterceptTouchEvent(r2) == false) goto L7;
        return true;
    }

    public final boolean onTouchEvent(MotionEvent r2) {
        Intrinsics.checkNotNullParameter(r2, "ev");
        if (this.d == true) goto L5;
    L7:
        return false;
    L5:
        if (super.onTouchEvent(r2) == false) goto L7;
        return true;
    }

    public void setAdapter(PagerAdapter r2) {
        super.setAdapter(r2);
        setCurrentItem(1, false);
    }

    public final void setOnSmoothScrollFinishListener(b r1) {
        this.f = r1;
    }

    public final void setPageEnabled(boolean r1) {
        this.d = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public InfiniteViewPager(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.b = true;
        addOnPageChangeListener(new OnPageChange(this));
        this.d = true;
        setOverScrollMode(2);
    }
}
