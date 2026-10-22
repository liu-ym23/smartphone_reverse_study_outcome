package com.ss.android.lark.chatwindow.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larksuite.component.ui.imageview.LKUIBadgeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public class TitleBarRedDotView extends ConstraintLayout {
    public LKUIBadgeView a;
    public ImageView b;
    public int c;

    public View getIconView() {
        return this.b;
    }

    public TitleBarRedDotView(Context r2) {
        super(r2);
        R5(r2, null);
    }

    public void setBadgeDrawable(int r2) {
        LKUIBadgeView r0 = this.a;
        r0.b(r2);
        r0.a();
    }

    public void setBadgeSize(int r2) {
        this.c = r2;
        ConstraintLayout.LayoutParams r3 = this.a.getLayoutParams();
        int r0 = this.c;
        if (r0 <= 0) goto L5;
        ((ViewGroup.MarginLayoutParams) r3).width = r0;
        ((ViewGroup.MarginLayoutParams) r3).height = r0;
    L5:
        this.a.setLayoutParams(r3);
    }

    public void setIconDrawable(Drawable r2) {
        this.b.setImageDrawable(r2);
    }

    public TitleBarRedDotView(Context r1, AttributeSet r2) {
        super(r1, r2);
        R5(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void R5(Context r2, AttributeSet r3) {
        if (r3 == null) goto L4;
        TypedArray r4 = r2.obtainStyledAttributes(r3, new int[]{2130968917, 2130968918, 2130968919});
        this.c = r4.getDimensionPixelSize(1, 0);
        r4.recycle();
    L4:
        ViewGroup.inflate(getContext(), 2131559310, this);
        this.a = findViewById(2131376036);
        this.b = (ImageView) findViewById(2131376297);
        ConstraintLayout.LayoutParams r5 = this.a.getLayoutParams();
        int r6 = this.c;
        if (r6 <= 0) goto L8;
        ((ViewGroup.MarginLayoutParams) r5).width = r6;
        ((ViewGroup.MarginLayoutParams) r5).height = r6;
        return;
    }

    public TitleBarRedDotView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        R5(r1, r2);
    }
}
