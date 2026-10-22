package com.ss.android.lark.flow.feed.component.badge;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.utils.UIHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u000eJ\u000e\u0010\u0016\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\b\u0010\u0017\u001a\u00020\u0012H\u0002J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\nH\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u001fH\u0014R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/ss/android/lark/flow/feed/component/badge/FlowRedDotTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "badgeSize", "badgeTextSize", "", "glyphBounds", "Landroid/graphics/Rect;", "setRedDotText", "", "displayStr", "", "setBadgeSize", "setBadgeTextSize", "setRedDotBackground", "createOvalDrawable", "Landroid/graphics/drawable/Drawable;", "width", "height", "color", "onDraw", "canvas", "Landroid/graphics/Canvas;", "flow-feed_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FlowRedDotTextView extends AppCompatTextView {
    public int a;
    public float b;
    public final Rect c;

    public FlowRedDotTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.a = UIHelper.dp2px(22.0f);
        this.b = 12.0f;
        this.c = new Rect();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r7) {
        Intrinsics.checkNotNullParameter(r7, "canvas");
        Drawable r0 = getBackground();
        if (r0 == null) goto L5;
        r0.draw(r7);
    L5:
        CharSequence r1 = getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
    L9:
        if (r2 != null) goto L12;
        r2 = "";
    L12:
        if (r2.length() != 0) goto L14;
        boolean r3 = true;
    L15:
        if (r3 == false) goto L17;
        return;
    L17:
        TextPaint r4 = getPaint();
        r4.setColor(getCurrentTextColor());
        r4.getTextBounds(r2, 0, r2.length(), this.c);
        r7.drawText(r2, (getWidth() - r4.measureText(r2)) / 2.0f, ((getHeight() + this.c.height()) / 2.0f) - this.c.bottom, r4);
        return;
    L14:
        r3 = false;
        goto L15
    L8:
        r2 = null;
        goto L9
    }

    public final void setBadgeSize(float r1) {
        this.a = UIHelper.dp2px(r1);
    }

    public final void setBadgeTextSize(float r1) {
        this.b = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setRedDotText(String r4) {
        Intrinsics.checkNotNullParameter(r4, "displayStr");
        setText(r4);
        setTextColor(ContextCompat.getColor(getContext(), 2131101995));
        setTextSize(this.b);
        setTypeface(Typeface.defaultFromStyle(1));
        setGravity(17);
        setIncludeFontPadding(false);
        int r0 = this.a;
        int r1 = ContextCompat.getColor(getContext(), 2131101994);
        GradientDrawable r2 = new GradientDrawable();
        r2.setShape(1);
        r2.setColor(r1);
        r2.setSize(r0, r0);
        setBackground(r2);
    }

    public FlowRedDotTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3);
        this.a = UIHelper.dp2px(22.0f);
        this.b = 12.0f;
        this.c = new Rect();
    }

    public FlowRedDotTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "attrs");
        super(r2, r3, r4);
        this.a = UIHelper.dp2px(22.0f);
        this.b = 12.0f;
        this.c = new Rect();
    }
}
