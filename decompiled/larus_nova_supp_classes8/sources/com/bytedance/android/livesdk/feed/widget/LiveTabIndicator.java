package com.bytedance.android.livesdk.feed.widget;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.bytedance.android.livesdk.feed.feed.e;
import com.bytedance.android.livesdkapi.view.ISupportNestedScrollViewPager;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LiveTabIndicator extends HorizontalScrollView {
    public static final /* synthetic */ int g = 0;
    public LinearLayout a;
    public a b;
    public boolean c;
    public final Map<Long, Boolean> d;
    public List<e> e;
    public b f;

    public interface a {
        void a(e r1);
    }

    public class b implements View.OnLayoutChangeListener {
        public List<e> a;
        public final /* synthetic */ LiveTabIndicator b;

        public b(LiveTabIndicator r1, List<e> r2) {
            this.b = r1;
            this.a = r2;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
            LiveTabIndicator r10 = this.b;
            List<e> r11 = this.a;
            int r12 = LiveTabIndicator.g;
            r10.b(r11);
            this.b.removeOnLayoutChangeListener(this);
        }
    }

    private ISupportNestedScrollViewPager getParentViewPager() {
        ViewParent r0 = this;
    L3:
        if (r0 == null) goto L8;
        if ((r0 instanceof ISupportNestedScrollViewPager) == true) goto L8;
        r0 = r0.getParent();
    L8:
        return (ISupportNestedScrollViewPager) r0;
    }

    public int getLayoutId() {
        return 2131567760;
    }

    public int getItemGap() {
        if (this.e.size() > 5) goto L21;
        if (this.e.size() <= 1) goto L21;
        TextPaint r0 = new TextPaint();
        Resources r3 = getResources();
        r0.setTextSize(WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).scaledDensity * 16.0f);
        Context r4 = getContext();
        if (this.e.size() > 5) goto L9;
        float r1 = (375 / this.e.size()) - 32;
    L10:
        float r2 = UIUtils.dip2Px(r4, r1);
        Iterator<e> r5 = this.e.iterator();
        int r6 = 0;
    L12:
        if (r5.hasNext() == false) goto L18;
        float r7 = r0.measureText(r5.next().i());
        float r8 = r6;
        if (r7 > r2) goto L17;
        r7 = r2;
    L17:
        r6 = (int) (r8 + r7);
        goto L12
    L18:
        int r9 = getWidth();
        int[] r10 = getLeftAndRightPadding();
        return (((r9 - r10[0]) - r10[1]) - r6) / (this.e.size() - 1);
    L9:
        r1 = 48.0f;
    L21:
        return (int) UIUtils.dip2Px(getContext(), 30.0f);
    }

    public int[] getLeftAndRightPadding() {
        if (this.e.size() != 1) goto L6;
        TextPaint r0 = new TextPaint();
        Resources r5 = getResources();
        r0.setTextSize(WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density * 16.0f);
        int r1 = (int) ((UIUtils.getScreenWidth(getContext()) - r0.measureText(((e) ListProtector.get(this.e, 0)).i())) / 2.0f);
        return new int[]{r1, r1};
    L6:
        int r2 = (int) UIUtils.dip2Px(getContext(), 16.0f);
        return new int[]{r2, r2};
    }

    public final void a() {
        HorizontalScrollView.inflate(getContext(), getLayoutId(), this);
        setHorizontalScrollBarEnabled(false);
        this.a = (LinearLayout) findViewById(2131367782);
    }

    public LiveTabIndicator(Context r1) {
        super(r1);
        this.c = true;
        this.d = new HashMap();
        a();
    }

    public final void b(List<e> r14) {
        LinearLayout r0 = this.a;
        if (r0 == null) goto L43;
        r0.removeAllViews();
        if (CollectionUtils.isEmpty(r14) == true) goto L44;
        this.e = r14;
        final int r1 = 0;
    L8:
        if (r1 >= r14.size()) goto L37;
        final e r2 = (e) ListProtector.get(r14, r1);
        if (r1 == 0) goto L12;
    L14:
        final yw1.a r4 = new yw1.a(getContext());
        Context r5 = getContext();
        float r7 = 48.0f;
        if (this.e.size() > 5) goto L17;
        float r6 = (375 / this.e.size()) - 32;
    L18:
        float r8 = UIUtils.dip2Px(r5, r6);
        TextPaint r9 = new TextPaint();
        float r10 = r9.measureText(r2.i());
        Resources r11 = getResources();
        r9.setTextSize(WindowDisplayMetricsOverride.apply(r11, r11.getDisplayMetrics()).density * 16.0f);
        if (r8 > r10) goto L22;
        r8 = r10;
    L22:
        LinearLayout.LayoutParams r12 = new LinearLayout.LayoutParams((int) r8, -1);
        int[] r13 = getLeftAndRightPadding();
        int r15 = getItemGap();
        if (r1 != 0) goto L26;
        r12.setMargins(r13[0], 0, 0, 0);
        r12.setMarginStart(r13[0]);
        r12.setMarginEnd(0);
    L29:
        r4.setLayoutParams(r12);
        r4.setGravity(17);
        r4.setTextAlignment(4);
        r4.setTextColor(getResources().getColorStateList(2131107811));
        r4.setText(r2.i());
        Context r16 = getContext();
        if (this.e.size() > 5) goto L32;
        r7 = (375 / this.e.size()) - 32;
    L32:
        r4.setIndicatorWidth((int) UIUtils.dip2Px(r16, r7));
        if (((HashMap) this.d).containsKey(Long.valueOf(r2.f())) == false) goto L35;
        r4.setChecked(((Boolean) ((HashMap) this.d).get(Long.valueOf(r2.f()))).booleanValue());
    L35:
        r4.a.setTextSize(1, 16.0f);
        r4.setOnClickListener(new cx1.a(this, r1, r2, r4));
        this.a.addView(r4);
        r1 = r1 + 1;
        goto L8
    L26:
        if (r1 != (this.e.size() - 1)) goto L28;
        r12.setMargins(r15, 0, r13[1], 0);
        r12.setMarginStart(r15);
        r12.setMarginEnd(r13[1]);
        goto L29
    L28:
        r12.setMargins(r15, 0, 0, 0);
        r12.setMarginStart(r15);
        r12.setMarginEnd(0);
        goto L29
    L17:
        r6 = 48.0f;
        goto L18
    L12:
        if (this.c == false) goto L14;
        ((HashMap) this.d).put(Long.valueOf(r2.f()), Boolean.TRUE);
        this.c = false;
        goto L14
    L37:
        if (r14.size() != 1) goto L45;
        setVisibility(8);
        return;
    L45:
        return;
    L44:
        return;
    }

    public final void c(e r10) {
        int r0 = this.a.getChildCount();
        int r2 = 0;
    L3:
        if (r2 >= r0) goto L9;
        yw1.a r3 = (yw1.a) this.a.getChildAt(r2);
        long r4 = ((e) ListProtector.get(this.e, r2)).f();
        if (r4 != r10.f()) goto L7;
        r3.setChecked(true);
        Map<Long, Boolean> r5 = this.d;
        HashMap r6 = (HashMap) r5;
        r6.put(Long.valueOf(r4), Boolean.TRUE);
        ((e) ListProtector.get(this.e, r2)).a = true;
    L8:
        r2 = r2 + 1;
        goto L3
    L7:
        r3.setChecked(false);
        Map<Long, Boolean> r7 = this.d;
        HashMap r8 = (HashMap) r7;
        r8.put(Long.valueOf(r4), Boolean.FALSE);
        ((e) ListProtector.get(this.e, r2)).a = false;
        goto L8
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r4) {
        boolean r0 = super.onInterceptTouchEvent(r4);
        if (r4.getAction() != 0) goto L8;
        ISupportNestedScrollViewPager r5 = getParentViewPager();
        if (r5 == null) goto L16;
        r5.supportNestViewPagerNoScroll(false);
    L16:
        return r0;
    L8:
        if (r4.getAction() != 2) goto L13;
        if (r0 == false) goto L16;
        ISupportNestedScrollViewPager r6 = getParentViewPager();
        if (r6 == null) goto L16;
        r6.supportNestViewPagerNoScroll(false);
        goto L16
    L13:
        ISupportNestedScrollViewPager r7 = getParentViewPager();
        if (r7 == null) goto L16;
        r7.supportNestViewPagerNoScroll(true);
        goto L16
    }

    public void setOnTabClickListener(a r1) {
        this.b = r1;
    }

    public void setTitles(List<e> r2) {
        if (getWidth() == 0) goto L6;
        b(r2);
        return;
    L6:
        if (this.f != null) goto L8;
        this.f = new b(this, r2);
    L8:
        b r0 = this.f;
        r0.a = r2;
        removeOnLayoutChangeListener(r0);
        addOnLayoutChangeListener(this.f);
    }

    public LiveTabIndicator(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.c = true;
        this.d = new HashMap();
        a();
    }

    public LiveTabIndicator(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.c = true;
        this.d = new HashMap();
        a();
    }
}
