package com.obric.oui.sectiontitlebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.obric.cae.R;
import com.obric.oui.text.OTextView;
import he.i;
import nb.a;

/* JADX INFO: loaded from: classes2.dex */
public final class OSectionTitleBar extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f6508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f6509b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final ImageView f6510m;

    public OSectionTitleBar(Context r8, AttributeSet r10) {
        i.f(r8, "context");
        super(r8, r10, 0);
        setOrientation(0);
        LayoutInflater.from(r8).inflate(R.layout.o_section_title_bar, this, true);
        View r11 = findViewById(R.id.container);
        i.e(r11, "findViewById(R.id.container)");
        LinearLayout r12 = (LinearLayout) r11;
        View r13 = findViewById(R.id.titleTextView);
        i.e(r13, "findViewById(R.id.titleTextView)");
        this.f6508a = (TextView) r13;
        View r14 = findViewById(R.id.custom_end_container);
        i.e(r14, "findViewById(R.id.custom_end_container)");
        this.f6509b = (FrameLayout) r14;
        View r15 = findViewById(R.id.tail_icon);
        i.e(r15, "findViewById(R.id.tail_icon)");
        this.f6510m = (ImageView) r15;
        TypedArray r16 = r8.getTheme().obtainStyledAttributes(r10, a.A, 0, 0);
        i.e(r16, "context.theme.obtainStyl…           0, 0\n        )");
    L32:
        th = move-exception;
        r16.recycle();
        throw th;
    L4:
        if (r16.hasValue(8) == false) goto L7;
        setTitleText(r16.getString(8));     // Catch: Throwable -> L32
    L7:
        if (r16.hasValue(7) == false) goto L10;
        setTitleStyle(r16.getResourceId(7, R.style.OSectionTitleBar_S));     // Catch: Throwable -> L32
    L10:
        if (r16.hasValue(0) == false) goto L13;
        setCustomEndView(r16.getResourceId(0, 0));     // Catch: Throwable -> L32
    L13:
        if (r16.hasValue(1) == false) goto L16;
        setDefaultCustomEndView(r16.getInt(1, 0));     // Catch: Throwable -> L32
    L16:
        if (r16.hasValue(3) == false) goto L19;
        setDetailEndText(r16.getString(3));     // Catch: Throwable -> L32
    L19:
        if (r16.hasValue(4) == false) goto L22;
        a(r16.getBoolean(4, false));     // Catch: Throwable -> L32
    L22:
        if (r16.hasValue(6) == false) goto L25;
        setTailIcon(r16.getResourceId(6, 0));     // Catch: Throwable -> L32
    L25:
        if (r16.hasValue(2) == false) goto L28;
        setDefaultTailIcon(r16.getInt(2, 0));     // Catch: Throwable -> L32
    L28:
        if (r16.hasValue(5) == false) goto L30;
        b(r16.getBoolean(5, false));     // Catch: Throwable -> L32
    L30:
        r16.recycle();
    }

    public final void a(boolean r8) {
        FrameLayout r10 = this.f6509b;
        int r11 = 8;
        if (r10.getChildCount() == 0) goto L6;
        if (r8 == false) goto L6;
        r11 = 0;
    L6:
        r10.setVisibility(r11);
    }

    public final void b(boolean r8) {
        ImageView r10 = this.f6510m;
        int r11 = 8;
        if (r10.getDrawable() == null) goto L6;
        if (r8 == false) goto L6;
        r11 = 0;
    L6:
        r10.setVisibility(r11);
    }

    public final View getCustomEndView() {
        FrameLayout r8 = this.f6509b;
        if (r8.getChildCount() != 0) goto L5;
        return null;
    L5:
        return r8.getChildAt(0);
    }

    public final OTextView getEndDetail() {
        if ((getCustomEndView() instanceof OTextView) == false) goto L10;
        View r8 = getCustomEndView();
        if (r8 == null) goto L9;
        return (OTextView) r8;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    L10:
        return null;
    }

    public final void setCustomEndView(int r8) {
        FrameLayout r10 = this.f6509b;
        r10.removeAllViews();
        if (r8 != 0) goto L9;
    L6:
        a(false);
        return;
    L9:
        LinearLayout.inflate(getContext(), r8, r10);     // Catch: Exception -> L8
    }

    public final void setDefaultCustomEndView(int r8) {
        this.f6509b.removeAllViews();
        if (r8 != 0) goto L5;
        setCustomEndView(R.layout.o_section_titlebar_custom_end_detail);
        return;
    L5:
        a(false);
    }

    public final void setDefaultTailIcon(int r8) {
        if (r8 != 0) goto L4;
        setTailIcon(getResources().getDrawable(R.drawable.o_section_titlebar_tail_icon_arrow));
        return;
    L4:
        b(false);
    }

    public final void setDetailEndText(CharSequence r8) {
        setDefaultCustomEndView(0);
        if ((getCustomEndView() instanceof OTextView) == false) goto L9;
        View r10 = getCustomEndView();
        if (r10 == null) goto L8;
        ((OTextView) r10).setText(r8);
        return;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.obric.oui.text.OTextView");
    }

    public final void setTailIcon(int r8) {
        ImageView r10 = this.f6510m;
        if (r8 == 0) goto L5;
        r10.setImageResource(r8);
        return;
    L5:
        r10.setImageDrawable(null);
        b(false);
    }

    public final void setTitleStyle(int r8) {
        this.f6508a.setTextAppearance(r8);
    }

    public final void setTitleText(CharSequence r8) {
        this.f6508a.setText(r8);
    }

    public final void setTitleTextColor(int r8) {
        this.f6508a.setTextColor(r8);
    }

    public final void setTitleTextSize(float r8) {
        this.f6508a.setTextSize(r8);
    }

    public final void setCustomEndView(View r8) {
        FrameLayout r10 = this.f6509b;
        r10.removeAllViews();
        if (r8 == null) goto L5;
        r10.addView(r8);
        return;
    L5:
        a(false);
    }

    public final void setTailIcon(Drawable r8) {
        if (r8 == null) goto L4;
        this.f6510m.setImageDrawable(r8);
        return;
    L4:
        b(false);
    }
}
