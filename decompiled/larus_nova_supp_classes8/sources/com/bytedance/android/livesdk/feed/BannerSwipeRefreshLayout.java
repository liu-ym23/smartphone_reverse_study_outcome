package com.bytedance.android.livesdk.feed;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import com.bytedance.android.live.uikit.refresh.I18nSwipeRefreshLayout;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class BannerSwipeRefreshLayout extends I18nSwipeRefreshLayout {
    public ViewPager E;
    public View F;
    public RecyclerView G;
    public int H;
    public boolean I;
    public float J;
    public float K;
    public float L;
    public int M;

    public interface a {
        void a(ViewPager r1, View r2);

        void b(RecyclerView r1);
    }

    public BannerSwipeRefreshLayout(Context r2) {
        super(r2);
        new ArrayList();
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r2));
        this.I = false;
    }

    public final boolean onInterceptTouchEvent(MotionEvent r12) {
    L77:
        return false;
    L4:
        if (this.E == null) goto L8;
        if (this.F == null) goto L8;
    L9:
        int r1 = r12.getAction();     // Catch: IllegalArgumentException -> L77
        if (r1 != 0) goto L12;
        float r2 = r12.getX();     // Catch: IllegalArgumentException -> L77
        this.J = r2;     // Catch: IllegalArgumentException -> L77
        this.K = r2;     // Catch: IllegalArgumentException -> L77
        this.L = r12.getY();     // Catch: IllegalArgumentException -> L77
        this.I = false;     // Catch: IllegalArgumentException -> L77
        this.M = MotionEventCompat.getPointerId(r12, 0);     // Catch: IllegalArgumentException -> L77
    L76:
        return super.onInterceptTouchEvent(r12);
    L12:
        if (r1 != 2) goto L76;
        if (this.I == true) goto L73;
        int r3 = MotionEventCompat.findPointerIndex(r12, this.M);     // Catch: IllegalArgumentException -> L77
        float r4 = MotionEventCompat.getX(r12, r3);     // Catch: IllegalArgumentException -> L77
        float r5 = Math.abs(r4 - this.K);     // Catch: IllegalArgumentException -> L77
        float r6 = MotionEventCompat.getY(r12, r3);     // Catch: IllegalArgumentException -> L77
        float r7 = Math.abs(r6 - this.L);     // Catch: IllegalArgumentException -> L77
        float r8 = r6 - this.L;     // Catch: IllegalArgumentException -> L77
        ViewPager r9 = this.E;     // Catch: IllegalArgumentException -> L77
        if (r9 != null) goto L19;
    L41:
        RecyclerView r10 = this.G;     // Catch: IllegalArgumentException -> L77
        if (r10 == null) goto L76;
        r10.canScrollVertically(-1);     // Catch: IllegalArgumentException -> L77
        if ((r4 - this.K) <= 0.0f) goto L51;
        if (r5 <= r7) goto L51;
        if (this.G.getScrollX() != 0) goto L51;
    L65:
        int r11 = this.H;     // Catch: IllegalArgumentException -> L77
        if (r7 >= (r11 + 100)) goto L68;
        return false;
    L68:
        float r13 = this.J;     // Catch: IllegalArgumentException -> L77
        if ((r4 - r13) <= 0.0f) goto L71;
        float r14 = r13 + r11;     // Catch: IllegalArgumentException -> L77
    L72:
        this.K = r14;     // Catch: IllegalArgumentException -> L77
        this.L = r6;     // Catch: IllegalArgumentException -> L77
        goto L76
    L71:
        r14 = r13 - r11;     // Catch: IllegalArgumentException -> L77
    L51:
        if (r5 <= this.H) goto L59;
        if ((0.5f * r5) <= r7) goto L59;
        if (this.G.getBottom() <= r6) goto L59;
        this.I = true;     // Catch: IllegalArgumentException -> L77
        return false;
    L59:
        if (r7 <= r5) goto L65;
        if (r8 <= 0.0f) goto L65;
        if (this.G.canScrollVertically(-1) == false) goto L65;
        return false;
    L19:
        if (this.F == null) goto L41;
        if ((r4 - this.K) <= 0.0f) goto L26;
        if (r9.getCurrentItem() != 0) goto L26;
    L33:
        int r15 = this.H;     // Catch: IllegalArgumentException -> L77
        if (r7 >= (r15 + 100)) goto L36;
        return false;
    L36:
        float r16 = this.J;     // Catch: IllegalArgumentException -> L77
        if ((r4 - r16) <= 0.0f) goto L39;
        float r17 = r16 + r15;     // Catch: IllegalArgumentException -> L77
    L40:
        this.K = r17;     // Catch: IllegalArgumentException -> L77
        this.L = r6;     // Catch: IllegalArgumentException -> L77
        goto L76
    L39:
        r17 = r16 - r15;     // Catch: IllegalArgumentException -> L77
    L26:
        if (r5 <= this.H) goto L33;
        if ((r5 * 0.5f) <= r7) goto L33;
        if (this.F.getBottom() <= r6) goto L33;
        this.I = true;     // Catch: IllegalArgumentException -> L77
        return false;
    L73:
        return false;
    L8:
        if (this.G == null) goto L76;
        goto L9
    }

    public BannerSwipeRefreshLayout(Context r1, AttributeSet r2) {
        super(r1, r2);
        new ArrayList();
        this.H = ViewConfigurationCompat.getScaledPagingTouchSlop(ViewConfiguration.get(r1));
        this.I = false;
    }
}
