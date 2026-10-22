package com.bytedance.android.livesdk.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u00002\u00020\u0001B#\b\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0019\u0010\u001aB\u001b\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0019\u0010\u001bB\u0011\b\u0016\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u0019\u0010\u001cJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\tH\u0016R$\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/StrokeTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "", "size", "", "setTextSize", "Landroid/graphics/Typeface;", "tf", "setTypeface", "Landroid/view/ViewGroup$LayoutParams;", "params", "setLayoutParams", "a", "Landroidx/appcompat/widget/AppCompatTextView;", "getOutlineTextView", "()Landroidx/appcompat/widget/AppCompatTextView;", "setOutlineTextView", "(Landroidx/appcompat/widget/AppCompatTextView;)V", "outlineTextView", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyle", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "livecommonui_saasRelease"}, k = 1, mv = {1, 4, 3})
public class StrokeTextView extends AppCompatTextView {
    public AppCompatTextView a;
    public float b;
    public int c;
    public boolean d;
    public boolean e;

    /* JADX WARN: Multi-variable type inference failed */
    public final void init() {
        if (this.b <= 0) goto L18;
        this.d = true;
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L7;
        TextPaint r1 = r0.getPaint();
    L8:
        if (r1 == null) goto L10;
        r1.setStrokeWidth(this.b);
    L10:
        if (r1 == null) goto L12;
        r1.setStyle(Paint.Style.STROKE);
    L12:
        AppCompatTextView r2 = getOutlineTextView();
        if (r2 == null) goto L15;
        r2.setTextColor(this.c);
    L15:
        AppCompatTextView r3 = getOutlineTextView();
        if (r3 == null) goto L20;
        r3.setGravity(getGravity());
        return;
    L20:
        return;
    L7:
        r1 = null;
        goto L8
    L18:
        this.d = false;
    }

    public AppCompatTextView getOutlineTextView() {
        return this.a;
    }

    public StrokeTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onDraw(Canvas r2) {
        Intrinsics.checkNotNullParameter(r2, "canvas");
        if (this.d == false) goto L7;
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L7;
        r0.draw(r2);
    L7:
        super/*android.widget.TextView*/.onDraw(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        super/*android.widget.TextView*/.setLayoutParams(r2);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L6;
        r0.setLayoutParams(r2);
        return;
    }

    public void setOutlineTextView(AppCompatTextView r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextSize(float r3) {
        super/*android.widget.TextView*/.setTextSize(r3);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L5;
        r0.setTextSize(1, r3);
    L5:
        this.e = true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTypeface(Typeface r2) {
        super/*android.widget.TextView*/.setTypeface(r2);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L6;
        r0.setTypeface(r2);
        return;
    }

    public StrokeTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r3, int r4) {
        super.onMeasure(r3, r4);
        if (this.d == false) goto L17;
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L7;
        CharSequence r1 = r0.getText();
    L9:
        if ((!Intrinsics.areEqual(r1, getText())) == false) goto L17;
        AppCompatTextView r2 = getOutlineTextView();
        if (r2 == null) goto L13;
        r2.setText(getText());
    L13:
        postInvalidate();
        AppCompatTextView r5 = getOutlineTextView();
        if (r5 == null) goto L22;
        r5.measure(r3, r4);
        return;
    L22:
        return;
    L7:
        r1 = null;
    L17:
        if (this.e == false) goto L24;
        AppCompatTextView r6 = getOutlineTextView();
        if (r6 == null) goto L25;
        r6.measure(r3, r4);
        return;
    L25:
        return;
    }

    public final void setTextSize(int r2, float r3) {
        super.setTextSize(r2, r3);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L5;
        r0.setTextSize(r2, r3);
    L5:
        this.e = true;
    }

    public final void setTypeface(Typeface r2, int r3) {
        super.setTypeface(r2, r3);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L6;
        r0.setTypeface(r2, r3);
        return;
    }

    public final void x(float r1, int r2) {
        this.b = r1;
        this.c = r2;
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StrokeTextView(Context r4, AttributeSet r5, int r6) {
        Intrinsics.checkNotNullParameter(r4, "context");
        super(r4, r5, r6);
        if (r5 == null) goto L8;
        TypedArray r0 = r4.obtainStyledAttributes(r5, new int[]{2130974312, 2130974313, 2130974793, 2130974794}, r6, 0);
        if (r0 != null) goto L7;
        return;
    L7:
        this.b = r0.getFloat(3, 0.0f);
        this.c = r0.getColor(2, getResources().getColor(2131108569));
    L8:
        setOutlineTextView(new AppCompatTextView(r4, r5, r6));
        init();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setPadding(int r2, int r3, int r4, int r5) {
        super/*android.widget.TextView*/.setPadding(r2, r3, r4, r5);
        AppCompatTextView r0 = getOutlineTextView();
        if (r0 == null) goto L6;
        r0.setPadding(r2, r3, r4, r5);
        return;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        if (this.d == false) goto L8;
        AppCompatTextView r6 = getOutlineTextView();
        if (r6 == null) goto L9;
        r6.layout(r2, r3, r4, r5);
        return;
    L9:
        return;
    }
}
