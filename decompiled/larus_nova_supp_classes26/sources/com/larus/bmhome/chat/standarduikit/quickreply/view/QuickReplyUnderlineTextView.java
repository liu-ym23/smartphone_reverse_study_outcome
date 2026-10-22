package com.larus.bmhome.chat.standarduikit.quickreply.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.bmhome.share.panel.ShareType;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j19.c;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0002\"#B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J,\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\b\u0001\u0010\u001b\u001a\u00020\r2\b\b\u0001\u0010\u0014\u001a\u00020\rJ\u0010\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0014J\u0012\u0010\u001f\u001a\u00020\u001a2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010 \u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/standarduikit/quickreply/view/QuickReplyUnderlineTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "underlinePaint", "Landroid/graphics/Paint;", "underlineWidth", "", "iconSize", "", "title", "", "iconUrl", "iconBitmap", "Landroid/graphics/Bitmap;", "value", "underlineColor", "getUnderlineColor", "()I", "setUnderlineColor", "(I)V", "bind", "", "textColor", "onDraw", "canvas", "Landroid/graphics/Canvas;", "loadIconIfNeeded", "updateText", "drawSoftlinkUnderline", "CenterImageSpan", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class QuickReplyUnderlineTextView extends AppCompatTextView {
    public final Paint a;
    public final float b;
    public final int c;
    public String d;
    public String e;
    public Bitmap f;
    public int g;

    public static final class a extends ImageSpan {
        public a(Drawable r2) {
            Intrinsics.checkNotNullParameter(r2, "drawable");
            super(r2);
        }

        @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
        public final void draw(Canvas r1, CharSequence r2, int r3, int r4, float r5, int r6, int r7, int r8, Paint r9) {
            Intrinsics.checkNotNullParameter(r1, "canvas");
            Intrinsics.checkNotNullParameter(r2, ShareType.TEXT);
            Intrinsics.checkNotNullParameter(r9, "paint");
            Drawable r10 = getDrawable();
            Paint.FontMetricsInt r11 = r9.getFontMetricsInt();
            int r12 = ((((r11.descent + r7) + r7) + r11.ascent) / 2) - (r10.getBounds().height() / 2);
            r1.save();
            r1.translate(r5, r12);
            r10.draw(r1);
            r1.restore();
        }
    }

    public static final class b {
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        Bitmap r0 = this.f;
        if (this.d.length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L13;
        if (r0 == null) goto L13;
        if (r0.isRecycled() == true) goto L13;
        SpannableStringBuilder r2 = new SpannableStringBuilder(this.d);
        r2.append(" ");
        int r3 = r2.length();
        r2.append("￼");
        BitmapDrawable r4 = new BitmapDrawable(getResources(), r0);
        int r5 = this.c;
        r4.setBounds(0, 0, r5, r5);
        r2.setSpan(new a(r4), r3, r2.length(), 33);
        setText(r2);
        return;
    L13:
        setText(this.d);
        return;
    L5:
        r1 = false;
        goto L6
    }

    public final int getUnderlineColor() {
        return this.g;
    }

    public QuickReplyUnderlineTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r9) {
        Intrinsics.checkNotNullParameter(r9, "canvas");
        super/*android.widget.TextView*/.onDraw(r9);
        CharSequence r0 = getText();
        if (r0 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L11;
        return;
    L11:
        if (this.g == 0) goto L22;
        Layout r2 = getLayout();
        if (r2 == null) goto L23;
        float r5 = RangesKt.coerceAtMost(r2.getLineWidth(0), getWidth());
        if (r5 <= 0.0f) goto L24;
        this.a.setColor(this.g);
        float r6 = getHeight() - (this.b / 2.0f);
        r9.drawLine(0.0f, r6, r5, r6, this.a);
        return;
    L24:
        return;
    L23:
        return;
    L22:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUnderlineColor(int r1) {
        this.g = r1;
        invalidate();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public QuickReplyUnderlineTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        Paint r4 = new Paint(1);
        this.a = r4;
        Resources r5 = getResources();
        float r6 = WindowDisplayMetricsOverride.apply(r5, r5.getDisplayMetrics()).density;
        this.b = r6;
        this.c = c.c(17);
        this.d = "";
        r4.setStrokeWidth(r6);
    }
}
