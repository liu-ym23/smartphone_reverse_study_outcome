package com.suite.lark.platform.component.widget_biz_fileview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Region;
import android.os.Build;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\tJ\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0014R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/suite/lark/platform/component/widget_biz_fileview/FileNameView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "tailText", "", "setTailContent", "", "tail", "onDraw", "canvas", "Landroid/graphics/Canvas;", "Companion", "widget-biz-fileview_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class FileNameView extends AppCompatTextView {
    public String a;

    public static final class a {
    }

    static {
    }

    public FileNameView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDraw(Canvas r18) {
        Intrinsics.checkNotNullParameter(r18, "canvas");
        String r0 = this.a;
        int r1 = getMaxLines();
        CharSequence r9 = getText();
        if (r0 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L54;
        if (r1 <= 0) goto L54;
        if (r9 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L54;
        if (getLayout() == null) goto L26;
        if (r1 < getLayout().getLineCount()) goto L26;
        super/*android.widget.TextView*/.onDraw(r18);
        return;
    L26:
        if (getLayout() != null) goto L33;
        int r6 = r18.save();
        r18.clipRect(0, 0, 0, 0);
        super/*android.widget.TextView*/.onDraw(r18);     // Catch: Throwable -> L30
        r18.restoreToCount(r6);
    L30:
        th = move-exception;
        r18.restoreToCount(r6);
        throw th;
    L33:
        Layout r10 = getLayout();
        if (r10 != null) goto L36;
    L52:
        super/*android.widget.TextView*/.onDraw(r18);
        return;
    L36:
        if (r1 >= r10.getLineCount()) goto L52;
        int r11 = r1 - 1;
        float r12 = r10.getLineLeft(r11);
        float r13 = r10.getLineRight(r11);
        int r14 = r10.getLineStart(r11);
        int r15 = r10.getLineEnd(r11);
        if (r15 >= r14) goto L42;
        super/*android.widget.TextView*/.onDraw(r18);
        return;
    L42:
        float r3 = r10.getLineTop(r11);
        float r7 = r10.getLineBottom(r11);
        int r8 = r18.save();
        if (Build.VERSION.SDK_INT < 26) goto L45;
        r18.clipOutRect(r12, r3, r13, r7);
    L56:
        super/*android.widget.TextView*/.onDraw(r18);     // Catch: Throwable -> L49
        r18.restoreToCount(r8);
        TextPaint r2 = getPaint();
        r18.drawText(TextUtils.ellipsize(r9.subSequence(r14, r15), r2, (r13 - r12) - r2.measureText(r0), TextUtils.TruncateAt.END) + r0, r12, r10.getLineBaseline(r11), r2);
        return;
    L49:
        th = move-exception;
        r18.restoreToCount(r8);
        throw th;
    L45:
        r18.clipRect(r12, r3, r13, r7, Region.Op.DIFFERENCE);
        goto L56
    L13:
        if (r9.length() == 0) goto L16;
        r5 = false;
    L54:
        super/*android.widget.TextView*/.onDraw(r18);
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r4 = false;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTailContent(String r1) {
        this.a = r1;
        invalidate();
    }

    public FileNameView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
    }
}
