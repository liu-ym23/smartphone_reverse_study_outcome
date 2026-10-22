package com.obric.oui.calendar;

import android.R;
import android.content.Context;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.View;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class u extends AppCompatCheckedTextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12298a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f12299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f12300c;
    public int d;
    public int e;

    public u(Context r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5);
        this.f12298a = r10;
        this.f12299b = r11;
    }

    public static ShapeDrawable a(int r5) {
        ShapeDrawable r10 = new ShapeDrawable(new OvalShape());
        r10.getPaint().setColor(r5);
        return r10;
    }

    public final void b() {
        StateListDrawable r5 = new StateListDrawable();
        r5.addState(new int[]{R.attr.state_checked}, a(this.f12300c));
        r5.addState(new int[]{R.attr.state_pressed}, a(this.f12300c));
        r5.addState(new int[0], a(this.d));
        setBackground(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        setMeasuredDimension(View.resolveSize(this.e, r5), View.resolveSize(this.e, r10));
    }

    @Override // android.widget.CheckedTextView, android.widget.Checkable
    public final void setChecked(boolean r5) {
        if (isChecked() == r5) goto L5;
        boolean r10 = true;
    L6:
        super.setChecked(r5);
        if (r10 == true) goto L9;
        return;
    L9:
        if (isChecked() == false) goto L11;
        int r11 = this.f12298a;
    L12:
        ym.m.m(this, r11);
        return;
    L11:
        r11 = this.f12299b;
        goto L12
    L5:
        r10 = false;
        goto L6
    }
}
