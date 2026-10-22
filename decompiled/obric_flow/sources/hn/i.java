package hn;

import android.content.Context;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.lynx.tasm.behavior.ui.scroll.LynxUIScrollViewInternal;
import com.lynx.tasm.behavior.ui.scroll.base.LynxBaseScrollView;
import java.util.HashMap;
import sj.k;

/* JADX INFO: loaded from: classes2.dex */
public abstract class i extends FrameLayout implements a, d, j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g f17349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f17350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f17351c;
    public int d;
    public int e;
    public boolean f;
    public final int[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f17352h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public h f17353i;

    public i(Context r5) {
        super(r5, null, 0);
        this.f17350b = true;
        this.f17351c = true;
        this.d = 0;
        this.e = 0;
        this.f = true;
        this.g = new int[2];
        this.f17352h = 0;
        this.f17349a = new g(r5);
    }

    public final void a(int r5) {
        int r10 = this.f17352h;
        if (r10 == r5) goto L19;
        this.f17352h = r5;
        h r11 = this.f17353i;
        if (r11 == null) goto L20;
        LynxUIScrollViewInternal r12 = (LynxUIScrollViewInternal) r11;
        if (r5 != 0) goto L9;
        r12.c("scrollend", null);
    L17:
        HashMap r13 = new HashMap();
        td.e.f(r10, r13, "previousState", r5, "currentState");
        r12.c("scrollstatechange", r13);
        return;
    L9:
        if (r5 != 1) goto L11;
        r12.c("scrollstart", null);
        goto L17
    L11:
        if (r5 != 2) goto L17;
        if (r10 != 0) goto L17;
        r12.c("scrollstart", null);
        goto L17
    L20:
        return;
    }

    public final void b(int[] r13) {
        boolean r5 = this.f17351c;
        g r10 = this.f17349a;
        if (r5 == false) goto L6;
        int r14 = r13[1];
        int[] r11 = getScrollRangeVertically();
        int r15 = Math.min(Math.max(r14, r11[0]), r11[1]);
        int r12 = getScrollX();
        ug.e r16 = new ug.e((LynxBaseScrollView) this, 8);
        r10.c(false);
        int r17 = r10.f.getScrollX();
        int r18 = r10.f.getScrollY();
        int r19 = r12 - r10.f.getScrollX();
        int r110 = r15 - r10.f.getScrollY();
        r10.f17346a.b(r17, r18, r19, r110, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        r10.f17347b = r16;
        r10.f17348c = 1;
        r10.f.getView().removeCallbacks(r10);
        ViewCompat.postOnAnimation(r10.f.getView(), r10);
        a(2);
        return;
    L6:
        int r111 = r13[0];
        int[] r20 = getScrollRangeHorizontally();
        int r112 = Math.min(Math.max(r111, r20[0]), r20[1]);
        int r21 = getScrollY();
        k r22 = new k((LynxBaseScrollView) this, false);
        r10.c(false);
        int r23 = r10.f.getScrollX();
        int r24 = r10.f.getScrollY();
        int r25 = r112 - r10.f.getScrollX();
        int r113 = r21 - r10.f.getScrollY();
        r10.f17346a.b(r23, r24, r25, r113, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        r10.f17347b = r22;
        r10.f17348c = 1;
        r10.f.getView().removeCallbacks(r10);
        ViewCompat.postOnAnimation(r10.f.getView(), r10);
        a(2);
    }

    @Override // hn.a
    public int[] getScrollOffset() {
        return new int[]{getScrollX(), getScrollY()};
    }

    @Override // hn.d
    public int getScrollOffsetHorizontally() {
        return getScrollX();
    }

    @Override // hn.j
    public int getScrollOffsetVertically() {
        return getScrollY();
    }

    @Override // hn.a
    public int[] getScrollRange() {
        int[] r5 = getScrollRangeHorizontally();
        int[] r10 = getScrollRangeVertically();
        return new int[]{r5[0], r5[1], r10[0], r10[1]};
    }

    @Override // hn.d
    public int[] getScrollRangeHorizontally() {
        return new int[]{0, Math.max(0, this.g[0] - this.d)};
    }

    @Override // hn.j
    public int[] getScrollRangeVertically() {
        return new int[]{0, Math.max(0, this.g[1] - this.e)};
    }

    public void setScrollContentSize(int[] r5) {
        if (this.f17351c == false) goto L6;
        setScrollContentSizeVertically(r5[1]);
        return;
    L6:
        setScrollContentSizeHorizontally(r5[0]);
    }

    public void setScrollContentSizeHorizontally(int r5) {
        int[] r10 = this.g;
        r10[0] = r5;
        r10[1] = this.e;
    }

    public void setScrollContentSizeVertically(int r5) {
        int r10 = this.d;
        int[] r11 = this.g;
        r11[0] = r10;
        r11[1] = r5;
    }

    public void setScrollDelegate(h r5) {
        this.f17353i = r5;
    }
}
