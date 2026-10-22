package com.ss.android.lark.message.card.view.richtext;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.utils.UIUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MsgCardRoundedYogaLayout extends YogaLayout {
    public final Context a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public boolean l;
    public boolean m;
    public ImageView n;
    public int o;
    public int p;
    public YogaNode q;
    public final int r;

    public static final class a {
        public Integer a;
        public Integer b;
        public Integer c;
        public Integer d;
        public Integer e;
        public Float f;

        public a() {
        }
    }

    public class b extends ViewOutlineProvider {
        public final int a;
        public final int b;
        public final /* synthetic */ MsgCardRoundedYogaLayout c;

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            float r5 = this.c.g;
            if (r5 != 0.0f) goto L5;
            r8.setRect(0, 10, this.a, this.b);
            return;
        L5:
            r8.setRoundRect(0, 10, this.a, this.b, r5);
        }

        public b(MsgCardRoundedYogaLayout r1, int r2, int r3) {
            this.c = r1;
            this.a = r2;
            this.b = r3;
        }
    }

    private int getDefaultBgColor() {
        if (this.m == false) goto L7;
        return 0;
    L7:
        if (this.l == false) goto L10;
        return this.b;
    L10:
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b() {
        if (this.b == 0) goto L5;
    L14:
        boolean r0 = true;
    L15:
        if (r0 == true) goto L17;
        return;
    L17:
        GradientDrawable r1 = a(getDefaultBgColor(), this.f, this.e);
        GradientDrawable r3 = a(this.c, this.f, this.e);
        GradientDrawable r4 = a(this.d, this.f, this.e);
        StateListDrawable r5 = new StateListDrawable();
        if (this.m == false) goto L21;
        r3.setColor(getResources().getColor(R.color.transparent));
    L21:
        if (this.c == 0) goto L23;
        r5.addState(new int[]{R.attr.state_pressed}, r3);
        r5.addState(new int[]{R.attr.state_focused}, r3);
        r5.addState(new int[]{-16842910}, r4);
    L23:
        r5.addState(new int[0], r1);
        setBackground(r5);
        return;
    L5:
        if (this.c != 0) goto L14;
        if (this.d != 0) goto L14;
        if (this.e != 0) goto L11;
    L13:
        r0 = false;
        goto L15
    L11:
        if (this.f <= 0) goto L13;
        goto L13
    }

    public void c() {
        this.q.setMargin(YogaEdge.RIGHT, UIUtils.dp2px(this.a, 6.0f));
        this.q.setWidth(this.o);
        this.q.setHeight(this.p);
        this.n.setVisibility(0);
        RotateAnimation r0 = new RotateAnimation(0.0f, 360.0f, 0, this.o / 2.0f, 0, this.p / 2.0f);
        r0.setDuration(1000);
        r0.setFillAfter(true);
        r0.setInterpolator(new LinearInterpolator());
        r0.setRepeatMode(1);
        r0.setRepeatCount(-1);
        this.n.setAnimation(r0);
    }

    public MsgCardRoundedYogaLayout(Context r2) {
        this(r2, null);
    }

    public void setBackgroundColor(int r1) {
        this.b = r1;
        b();
    }

    public void setCustomizations(a r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        Integer r0 = r2.a;
        if (r0 == null) goto L7;
        this.b = r0.intValue();
    L7:
        Integer r1 = r2.b;
        if (r1 == null) goto L10;
        this.c = r1.intValue();
    L10:
        Integer r3 = r2.c;
        if (r3 == null) goto L13;
        this.d = r3.intValue();
    L13:
        Integer r4 = r2.e;
        if (r4 == null) goto L16;
        this.f = r4.intValue();
    L16:
        Integer r5 = r2.d;
        if (r5 == null) goto L19;
        this.e = r5.intValue();
    L19:
        Float r6 = r2.f;
        if (r6 == null) goto L22;
        this.g = r6.floatValue();
    L22:
        b();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setEnabled(boolean r1) {
        super/*android.view.ViewGroup*/.setEnabled(r1);
        this.l = r1;
    }

    public void setLoadingIcon(int r2) {
        this.n.setImageResource(r2);
    }

    public void setTintColorForLoadingIcon(int r3) {
        int r4 = UDColorUtils.getColor(this.a, r3);
        Drawable r5 = UDIconUtils.getIconDrawable(this.a, 2131255040, r4);
        this.n.setImageDrawable(r5);
    }

    public MsgCardRoundedYogaLayout(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MsgCardRoundedYogaLayout(Context r6, AttributeSet r7, int r8) {
        super(r6, r7, r8);
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0.0f;
        this.h = 0.0f;
        this.i = 0.0f;
        this.j = 0.0f;
        this.k = 0.0f;
        this.l = true;
        this.m = false;
        this.a = r6;
        this.r = UIUtils.dp2px(r6, 13.0f);
        TypedArray r9 = r6.obtainStyledAttributes(r7, new int[]{R.attr.enabled, 2130970043, 2130970044, 2130970045, 2130970046, 2130970047, 2130970048, 2130970049, 2130970050, 2130970051, 2130970052, 2130970053}, r8, 0);
        this.b = r9.getColor(3, this.b);
        this.c = r9.getColor(6, this.c);
        this.d = r9.getColor(4, this.d);
        boolean r10 = r9.getBoolean(0, isEnabled());
        this.l = r10;
        super/*android.view.ViewGroup*/.setEnabled(r10);
        this.e = r9.getColor(1, this.e);
        this.f = (int) r9.getDimension(2, this.f);
        float r11 = r9.getDimension(7, this.g);
        this.g = r11;
        this.h = r9.getDimension(10, r11);
        this.i = r9.getDimension(11, this.g);
        this.j = r9.getDimension(8, this.g);
        this.k = r9.getDimension(9, this.g);
        this.m = r9.getBoolean(5, this.m);
        r9.recycle();
        this.n = new ImageView(r6);
        this.n.setImageDrawable(UDIconUtils.getIconDrawable(r6, 2131255040, UDColorUtils.getColor(r6, 2131105548)));
        addView(this.n);
        this.q = getYogaNodeForView(this.n);
        int r12 = UIUtils.dp2px(r6, 13.0f);
        this.p = r12;
        this.o = r12;
        this.q.setMargin(YogaEdge.RIGHT, 0.0f);
        this.q.setWidth(0.0f);
        this.q.setHeight(0.0f);
        this.n.setVisibility(8);
        b();
    }

    public final GradientDrawable a(int r2, int r3, int r4) {
        GradientDrawable r0 = new GradientDrawable();
        r0.setColor(r2);
        if (r3 <= 0) goto L6;
        if (r4 == 0) goto L6;
        r0.setStroke(r3, r4);
    L6:
        float r5 = this.g;
        if (r5 <= 0.0f) goto L9;
        r0.setCornerRadius(r5);
    L10:
        return r0;
    L9:
        float r6 = this.h;
        float r7 = this.i;
        float r8 = this.k;
        float r9 = this.j;
        r0.setCornerRadii(new float[]{r6, r6, r7, r7, r8, r8, r9, r9});
        goto L10
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.view.ViewGroup*/.onSizeChanged(r1, r2, r3, r4);
        setOutlineProvider(new b(this, r1, r2));
    }
}
