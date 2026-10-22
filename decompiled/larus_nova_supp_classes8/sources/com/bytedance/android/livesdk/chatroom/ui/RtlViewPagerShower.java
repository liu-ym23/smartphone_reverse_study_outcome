package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public class RtlViewPagerShower extends LinearLayout {
    public final ArrayList<ImageView> a;
    public int b;
    public Drawable c;
    public Drawable d;
    public final LinearLayout.LayoutParams e;
    public int f;

    public final void b(int r3) {
        ArrayList<ImageView> r0 = this.a;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.isEmpty() == true) goto L27;
        int r1 = this.b;
        if (r1 >= 0) goto L10;
    L15:
        if (r3 >= 0) goto L17;
        return;
    L17:
        if (r3 < this.a.size()) goto L19;
        return;
    L19:
        if (this.d == null) goto L21;
        ((ImageView) ListProtector.get(this.a, r3)).setImageDrawable(this.d);
    L22:
        this.b = r3;
        return;
    L21:
        ((ImageView) ListProtector.get(this.a, r3)).setImageResource(2131250357);
        goto L22
    L10:
        if (r1 >= this.a.size()) goto L15;
        if (this.c == null) goto L14;
        ((ImageView) ListProtector.get(this.a, this.b)).setImageDrawable(this.c);
        goto L15
    L14:
        ((ImageView) ListProtector.get(this.a, this.b)).setImageResource(2131250358);
        goto L15
    }

    public void setMargin(int r1) {
        this.f = r1;
    }

    public RtlViewPagerShower(Context r2, AttributeSet r3) {
        super(r2, r3);
        this.a = new ArrayList();
        this.b = -1;
        this.e = new LinearLayout.LayoutParams(-2, -2);
        this.f = -1;
    }

    public final void a(int r6, int r7) {
        removeAllViews();
        this.a.clear();
        int r1 = 0;
    L3:
        if (r1 >= r6) goto L16;
        ImageView r2 = new ImageView(getContext());
        Drawable r3 = this.c;
        if (r3 == null) goto L7;
        r2.setImageDrawable(r3);
    L9:
        if (r1 >= (r6 - 1)) goto L14;
        int r4 = this.f;
        if (r4 != (-1)) goto L13;
        r4 = (int) getContext().getResources().getDimension(2131168739);
    L13:
        this.e.setMargins(0, 0, r4, 0);
        this.e.setMarginStart(0);
        this.e.setMarginEnd(r4);
        addView(r2, this.e);
    L15:
        this.a.add(r2);
        r1 = r1 + 1;
        goto L3
    L14:
        addView(r2);
        goto L15
    L7:
        r2.setImageResource(2131250358);
        goto L9
    L16:
        b(r7);
    }

    public RtlViewPagerShower(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = new ArrayList();
        this.b = -1;
        this.e = new LinearLayout.LayoutParams(-2, -2);
        this.f = -1;
    }
}
