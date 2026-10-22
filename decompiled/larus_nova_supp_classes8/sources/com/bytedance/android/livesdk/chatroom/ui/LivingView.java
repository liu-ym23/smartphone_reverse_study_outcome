package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class LivingView extends FrameLayout {
    public static final int c = 0;
    public static final int d = 0;
    public static final int e = 0;
    public static final int f = 0;
    public static final int g = 0;
    public static final int h = 0;
    public static final int i = 0;
    public static final int j = 0;
    public static final int k = 0;
    public static final int l = 0;
    public static final int m = 0;
    public static final int n = 0;
    public static final int o = 0;
    public static final int p = 0;
    public TextView a;
    public RotateHeadView b;

    static {
        c = com.bytedance.android.live.core.utils.s1.f(32.0f);
        d = com.bytedance.android.live.core.utils.s1.f(40.0f);
        e = com.bytedance.android.live.core.utils.s1.f(48.0f);
        f = com.bytedance.android.live.core.utils.s1.f(56.0f);
        g = com.bytedance.android.live.core.utils.s1.f(68.0f);
        h = com.bytedance.android.live.core.utils.s1.f(72.0f);
        i = com.bytedance.android.live.core.utils.s1.f(80.0f);
        j = com.bytedance.android.live.core.utils.s1.f(13.0f);
        k = com.bytedance.android.live.core.utils.s1.f(33.0f);
        l = com.bytedance.android.live.core.utils.s1.f(14.0f);
        m = com.bytedance.android.live.core.utils.s1.f(50.0f);
        n = com.bytedance.android.live.core.utils.s1.f(20.0f);
        o = com.bytedance.android.live.core.utils.s1.f(49.5f);
        p = com.bytedance.android.live.core.utils.s1.f(21.0f);
    }

    public LivingView(Context r2) {
        this(r2, null);
    }

    public LivingView(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int r7, int r8) {
        this.a.setTextColor(com.bytedance.android.live.core.utils.s1.h(2131107632));
        this.a.setBackgroundResource(2131249767);
        this.a.setText(2131915971);
        this.a.setGravity(17);
        ViewGroup.LayoutParams r9 = getLayoutParams();
        int r10 = r9.width;
        int r11 = r9.height;
        float r1 = 8.0f;
        if (r10 != c) goto L6;
        int r0 = com.bytedance.android.live.core.utils.s1.f(5.0f);
        int r2 = r10 - (r0 * 2);
        int r3 = j;
    L25:
        this.b.getLayoutParams().width = r10;
        this.b.getLayoutParams().height = r11;
        this.a.setTextSize(1, r1);
        this.a.getLayoutParams().width = r2;
        this.a.getLayoutParams().height = r3;
        if ((this.a.getLayoutParams() instanceof FrameLayout.LayoutParams) == false) goto L28;
        int r4 = r11 - r3;
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).topMargin = r4;
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).leftMargin = r0;
        ((FrameLayout.LayoutParams) this.a.getLayoutParams()).rightMargin = r0;
    L28:
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r10, 1073741824), View.MeasureSpec.makeMeasureSpec(r11, 1073741824));
        return;
    L6:
        if (r10 != d) goto L10;
        int r5 = k;
        r3 = l;
        int r6 = (r10 - r5) / 2;
    L8:
        r2 = r5;
        r0 = r6;
        r1 = 9.0f;
        goto L25
    L10:
        if (r10 != e) goto L13;
        r0 = com.bytedance.android.live.core.utils.s1.f(8.0f);
        int r12 = com.bytedance.android.live.core.utils.s1.f(6.0f);
        r3 = com.bytedance.android.live.core.utils.s1.f(10.0f) + r12;
        r2 = r10 - (r0 * 2);
        r1 = 10.0f;
        goto L25
    L13:
        if (r10 != f) goto L15;
        r5 = k;
        r3 = l;
        r6 = (r10 - r5) / 2;
        goto L8
    L15:
        r3 = 0;
        if (r10 != g) goto L20;
        r10 = r10 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r11 = r11 + com.bytedance.android.live.core.utils.s1.f(8.0f);
    L18:
        r0 = 0;
        r1 = 0.0f;
        r2 = 0;
        goto L25
    L20:
        if (r10 != h) goto L23;
        r2 = m;
        r3 = n;
        r0 = (r10 - r2) / 2;
        r1 = 12.0f;
        goto L25
    L23:
        if (r10 != i) goto L18;
        r10 = r10 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r11 = r11 + com.bytedance.android.live.core.utils.s1.f(8.0f);
        r2 = o;
        r3 = p;
        r0 = (r10 - r2) / 2;
        r1 = 13.5f;
        goto L25
    }

    public LivingView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new TextView(r1);
        RotateHeadView r4 = new RotateHeadView(r1);
        this.b = r4;
        addView(r4);
        addView(this.a);
        this.a.setVisibility(8);
        this.b.setVisibility(8);
    }
}
