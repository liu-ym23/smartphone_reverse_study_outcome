package com.ss.android.lark.flow.passport.ui.widget.common;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.component.universe_design.color.UDColorUtils;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CodeView extends RelativeLayout {
    public TextView a;
    public View b;
    public ValueAnimator c;
    public a d;
    public final h e;

    public static class a {
        public boolean a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public a(Context r3) {
            this.a = true;
            this.d = 17;
            this.i = 18;
            this.e = UDColorUtils.getColor(r3, 2131106622);
            this.f = UDColorUtils.getColor(r3, 2131103351);
            this.g = UDColorUtils.getColor(r3, 2131105548);
            this.h = UDColorUtils.getColor(r3, 2131102093);
            this.c = UDColorUtils.getColor(r3, 2131105548);
        }
    }

    public final void b() {
        h r0 = this.e;
        r0.getClass();
        g.c r1 = g.a;
        Intrinsics.checkNotNullParameter(r1, "state");
        r0.c(r1);
        View r2 = this.b;
        if (r2 == null) goto L6;
        r2.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void c() {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText("");
    L5:
        h r1 = this.e;
        r1.getClass();
        g.c r2 = g.a;
        Intrinsics.checkNotNullParameter(r2, "state");
        r1.c(r2);
        View r3 = this.b;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void d() {
        View r0 = this.b;
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public final void e() {
        if (this.d.a == false) goto L7;
        View r0 = this.b;
        if (r0 == null) goto L7;
        r0.setVisibility(0);
        setCursorFlicker(this.d.b);
    L7:
        TextView r1 = this.a;
        if (r1 == null) goto L10;
        r1.setText("");
    L10:
        h r2 = this.e;
        r2.getClass();
        g.b r3 = g.b;
        Intrinsics.checkNotNullParameter(r3, "state");
        r2.c(r3);
    }

    public final void f() {
        if (this.d.a == false) goto L8;
        View r0 = this.b;
        if (r0 == null) goto L9;
        r0.setVisibility(0);
        setCursorFlicker(this.d.b);
        return;
    L9:
        return;
    }

    public String getText() {
        TextView r0 = this.a;
        if (r0 != null) goto L5;
        return "";
    L5:
        return r0.getText().toString();
    }

    public CodeView(Context r2) {
        this(r2, null);
    }

    private void setCursorFlicker(boolean r1) {
        if (r1 == false) goto L4;
        this.c.start();
        return;
    L4:
        this.c.cancel();
    }

    public final int a(float r3) {
        Resources r0 = getContext().getResources();
        return (int) ((r3 * WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density) + 0.5f);
    }

    public void setText(String r3) {
        TextView r0 = this.a;
        if (r0 == null) goto L5;
        r0.setText(r3);
    L5:
        h r4 = this.e;
        r4.getClass();
        g.b r1 = g.b;
        Intrinsics.checkNotNullParameter(r1, "state");
        r4.c(r1);
        View r5 = this.b;
        if (r5 == null) goto L9;
        r5.setVisibility(8);
        setCursorFlicker(false);
        return;
    }

    public CodeView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public final void onMeasure(int r3, int r4) {
        int r5 = View.MeasureSpec.getSize(r3);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(r5, 1073741824), View.MeasureSpec.makeMeasureSpec((int) (r5 * 1.05f), 1073741824));
    }

    public CodeView(Context r2, AttributeSet r3, int r4) {
        super(r2, r3, r4);
        Context r5 = getContext();
        Intrinsics.checkNotNullParameter(r5, "context");
        this.e = new h(r5, 6.0f, 4);
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        this.c = r6;
        r6.setRepeatCount(-1);
        this.c.setRepeatMode(2);
        this.c.setDuration(600);
        this.c.setInterpolator(new LinearInterpolator());
        this.c.addUpdateListener(new b(this));
        setClipChildren(false);
    }
}
