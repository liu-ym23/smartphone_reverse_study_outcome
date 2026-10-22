package com.bytedance.map.api.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.obric.launcher.widget.R$styleable;

/* JADX INFO: loaded from: classes2.dex */
public class StrokeTextView extends TextView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f6944a;

    public StrokeTextView(Context r5) {
        this(r5, null);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onDraw(Canvas r5) {
        this.f6944a.draw(r5);
        super.onDraw(r5);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean r5, int r10, int r11, int r12, int r13) {
        super.onLayout(r5, r10, r11, r12, r13);
        this.f6944a.layout(r10, r11, r12, r13);
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int r5, int r10) {
        super.onMeasure(r5, r10);
        CharSequence r11 = this.f6944a.getText();
        if (r11 != null) goto L5;
    L6:
        this.f6944a.setText(getText());
        postInvalidate();
    L7:
        this.f6944a.measure(r5, r10);
        return;
    L5:
        if (r11.equals(getText()) == true) goto L7;
        goto L6
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt r5) {
        super.setEllipsize(r5);
        TextView r10 = this.f6944a;
        if (r10 == null) goto L6;
        r10.setEllipsize(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setGravity(int r5) {
        super.setGravity(r5);
        TextView r10 = this.f6944a;
        if (r10 == null) goto L6;
        r10.setGravity(r5);
        return;
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams r5) {
        super.setLayoutParams(r5);
        this.f6944a.setLayoutParams(r5);
    }

    @Override // android.widget.TextView
    public void setLines(int r5) {
        super.setLines(r5);
        TextView r10 = this.f6944a;
        if (r10 == null) goto L6;
        r10.setLines(r5);
        return;
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int r5) {
        super.setMaxWidth(r5);
        TextView r10 = this.f6944a;
        if (r10 == null) goto L6;
        r10.setMaxWidth(r5);
        return;
    }

    @Override // android.widget.TextView
    public final void setShadowLayer(float r5, float r10, float r11, int r12) {
        super.setShadowLayer(r5, r10, r11, r12);
        this.f6944a.setShadowLayer(r5, r10, r11, r12);
    }

    public void setStrokeColor(int r5) {
        this.f6944a.setTextColor(r5);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int r5, float r10) {
        super.setTextSize(r5, r10);
        TextView r11 = this.f6944a;
        if (r11 == null) goto L6;
        r11.setTextSize(r5, r10);
        return;
    }

    @Override // android.widget.TextView
    public void setTypeface(@Nullable Typeface r5) {
        super.setTypeface(r5);
        TextView r10 = this.f6944a;
        if (r10 == null) goto L6;
        r10.setTypeface(r5);
        return;
    }

    public StrokeTextView(Context r5, @Nullable AttributeSet r10) {
        this(r5, r10, 0);
    }

    public StrokeTextView(Context r5, @Nullable AttributeSet r10, int r11) {
        super(r5, r10, r11);
        this.f6944a = null;
        TextView r12 = new TextView(r5, r10, r11);
        this.f6944a = r12;
        TypedArray r13 = getContext().obtainStyledAttributes(r10, R$styleable.StrokeTextView);
        int r14 = r13.getColor(R$styleable.StrokeTextView_stroke_color, -1);
        float r15 = r13.getDimension(R$styleable.StrokeTextView_stroke_width, 2.0f);
        TextPaint r16 = r12.getPaint();
        r16.setStrokeWidth(r15);
        r16.setStyle(Paint.Style.STROKE);
        r12.setTextColor(r14);
        r12.setGravity(getGravity());
    }
}
