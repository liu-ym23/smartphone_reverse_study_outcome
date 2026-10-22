package com.bytedance.android.livesdk.interactivity.comment.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.bytedance.android.livesdk.r3;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BarrageView extends RelativeLayout {
    public View a;
    public View b;
    public View c;
    public View d;
    public Animation e;
    public boolean f;

    public class a extends AccessibilityDelegateCompat {
        public final /* synthetic */ BarrageView a;

        public a(BarrageView r1) {
            this.a = r1;
        }

        public final void onInitializeAccessibilityNodeInfo(View r2, AccessibilityNodeInfoCompat r3) {
            super.onInitializeAccessibilityNodeInfo(r2, r3);
            r3.setCheckable(true);
            r3.setChecked(this.a.b.isSelected());
            if (this.a.b.isSelected() == false) goto L5;
            String r4 = "开";
        L6:
            r3.setContentDescription("弹幕已".concat(r4));
            r3.setClassName(ToggleButton.class.getName());
            return;
        L5:
            r4 = "关";
            goto L6
        }
    }

    private int getLayoutId() {
        return 2131567621;
    }

    public final void a() {
        RelativeLayout.inflate(getContext(), getLayoutId(), this);
        this.a = findViewById(2131368522);
        this.b = findViewById(2131368520);
        this.c = findViewById(2131368523);
        this.d = findViewById(2131368524);
        r3.e(this, new a(this));
    }

    public View getDanmuContainer() {
        return this.a;
    }

    public View getDanmuInput() {
        return this.b;
    }

    public BarrageView(Context r1) {
        super(r1);
        this.f = false;
        a();
    }

    public final void b(boolean r11) {
        View r0 = this.c;
        int r1 = 8;
        int r2 = 0;
        if (r11 == false) goto L5;
        int r3 = 0;
    L6:
        r0.setVisibility(r3);
        View r4 = this.d;
        if (r11 == false) goto L9;
        r1 = 0;
    L9:
        r4.setVisibility(r1);
        View r5 = this.b;
        if (r11 == false) goto L12;
        r2 = 4;
    L12:
        r5.setVisibility(r2);
        if (r11 == false) goto L15;
        RotateAnimation r13 = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.e = r13;
        r13.setRepeatCount(-1);
        this.e.setDuration(400);
        this.c.startAnimation(this.e);
        return;
    L15:
        this.c.clearAnimation();
        this.e = null;
        return;
    L5:
        r3 = 8;
        goto L6
    }

    public BarrageView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.f = false;
        a();
    }

    public BarrageView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.f = false;
        a();
    }
}
