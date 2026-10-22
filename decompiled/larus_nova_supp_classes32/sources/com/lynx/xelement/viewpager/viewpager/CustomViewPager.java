package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import androidx.viewpager.widget.PagerAdapter;
import com.lynx.xelement.viewpager.Pager;
import com.obric.aivoice.core.data.NameKeys;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\r\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\u0015\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\u0019\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\b\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\f¨\u0006\u001f"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/BaseCustomViewPager;", NameKeys.UnloadStrategy_No_Strategy, "item", NameKeys.UnloadStrategy_No_Strategy, "setCurrentItem", NameKeys.UnloadStrategy_No_Strategy, "i", "Z", "getMPagerChangeAnimation", "()Z", "setMPagerChangeAnimation", "(Z)V", "mPagerChangeAnimation", "Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager$a;", "j", "Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager$a;", "getMTouchHandler", "()Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager$a;", "setMTouchHandler", "(Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager$a;)V", "mTouchHandler", "k", "getMForceCanScroll", "setMForceCanScroll", "mForceCanScroll", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public class CustomViewPager extends BaseCustomViewPager {
    public boolean i;
    public a j;
    public boolean k;

    public interface a {
        void onTouch(MotionEvent r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean performClick() {
        return super/*android.view.ViewGroup*/.performClick();
    }

    public final boolean getMForceCanScroll() {
        return this.k;
    }

    public final boolean getMPagerChangeAnimation() {
        return this.i;
    }

    public final a getMTouchHandler() {
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CustomViewPager(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        new LinkedHashMap();
        super(r2);
        this.i = true;
        setOverScrollMode(2);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseCustomViewPager
    public final boolean canScrollHorizontally(int r2) {
        if (this.k == false) goto L7;
        return true;
    L7:
        return super.canScrollHorizontally(r2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent r2) {
        if (getMAllowHorizontalGesture() == true) goto L7;
        return false;
    L7:
        return super.onInterceptTouchEvent(r2);
    }

    public final boolean onTouchEvent(MotionEvent r3) {
        if (r3 == null) goto L4;
        Integer r0 = Integer.valueOf(r3.getActionMasked());
    L5:
        if (r0 == null) goto L11;
        if (r0.intValue() != 1) goto L11;
        performClick();
    L11:
        if (getMAllowHorizontalGesture() == false) goto L15;
        boolean r1 = super.onTouchEvent(r3);
        a r2 = this.j;
        if (r2 == null) goto L20;
        r2.onTouch(r3);
        return r1;
    L20:
        return r1;
    L15:
        Pager.b r4 = getMInterceptTouchEventListener();
        if (r4 == null) goto L18;
        r4.a();
    L18:
        return false;
    L4:
        r0 = null;
        goto L5
    }

    public void setCurrentItem(int r3) {
        PagerAdapter r0 = super.getAdapter();
        if (r0 != null) goto L5;
    L7:
        super.setCurrentItem(r3, this.i);
        return;
    L5:
        if (this.g == false) goto L7;
        r3 = (r0.getCount() - r3) - 1;
        goto L7
    }

    public final void setMForceCanScroll(boolean r1) {
        this.k = r1;
    }

    public final void setMPagerChangeAnimation(boolean r1) {
        this.i = r1;
    }

    public final void setMTouchHandler(a r1) {
        this.j = r1;
    }

    public final void setCurrentItem(int r3, boolean r4) {
        PagerAdapter r0 = super.getAdapter();
        if (r0 != null) goto L5;
    L7:
        super.setCurrentItem(r3, r4);
        return;
    L5:
        if (this.g == false) goto L7;
        r3 = (r0.getCount() - r3) - 1;
        goto L7
    }
}
