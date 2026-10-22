package com.ss.android.lark.myai.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.LineHeightSpan;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0005\b\u0016\u0018\u0000 )2\u00020\u0001:\u0003'()B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u000bJ\b\u0010\"\u001a\u00020\u0007H\u0016J\u001a\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020\rH\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0016\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0018\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0017R\u0011\u0010\u0019\u001a\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006*"}, d2 = {"Lcom/ss/android/lark/myai/view/LineHeightTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyle", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mLineHeight", "", "mBuffer", "Landroid/widget/TextView$BufferType;", "builder", "Lcom/ss/android/lark/myai/view/LineHeightTextView$LineHeightSpannableStringBuilder;", "getBuilder", "()Lcom/ss/android/lark/myai/view/LineHeightTextView$LineHeightSpannableStringBuilder;", "builder$delegate", "Lkotlin/Lazy;", "isSingleLine", "", "isMaxLine", "()Z", "isEllipsized", "lastLineText", "", "getLastLineText", "()Ljava/lang/String;", "setUXLineHeight", "", "lineHeight", "setUXLineHeightInDp", "dpLineHeight", "getLineHeight", "setText", "text", "", "type", "LineHeightSpannableStringBuilder", "VCLineHeightSpan", "Companion", "myai-export-officesdk_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public class LineHeightTextView extends AppCompatTextView {
    public static final SparseIntArray d = null;
    public float a;
    public TextView.BufferType b;
    public final Lazy c;

    public static final class a {
    }

    public static final class b extends SpannableStringBuilder {
        public c a;

        @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
        public final /* bridge */ int length() {
            return super.length();
        }

        public b() {
        }

        @Override // android.text.SpannableStringBuilder, java.lang.CharSequence
        public final /* bridge */ char charAt(int r1) {
            return super.charAt(r1);
        }
    }

    public static final class c implements LineHeightSpan {
        public int a;

        public c(float r3) {
            this.a = (int) Math.ceil(r3);
        }

        @Override // android.text.style.LineHeightSpan
        public final void chooseHeight(CharSequence r1, int r2, int r3, int r4, int r5, Paint.FontMetricsInt r6) {
            Intrinsics.checkNotNullParameter(r1, "text");
            Intrinsics.checkNotNullParameter(r6, "fm");
            int r7 = r6.descent;
            int r8 = this.a;
            if (r7 <= r8) goto L5;
            int r9 = (int) Math.min(r8, r7);
            r6.descent = r9;
            r6.bottom = r9;
            r6.ascent = 0;
            r6.top = 0;
            return;
        L5:
            int r10 = r6.ascent;
            if (((-r10) + r7) <= r8) goto L8;
            r6.bottom = r7;
            int r11 = (-r8) + r7;
            r6.ascent = r11;
            r6.top = r11;
            return;
        L8:
            int r12 = r6.bottom;
            if (((-r10) + r12) <= r8) goto L11;
            r6.top = r10;
            r6.bottom = r10 + r8;
            return;
        L11:
            int r13 = r6.top;
            if (((-r13) + r12) <= r8) goto L14;
            r6.top = r12 - r8;
            return;
        L14:
            double r14 = (r8 - ((-r13) + r12)) / 2.0f;
            r6.top = r13 - ((int) Math.ceil(r14));
            int r15 = r6.bottom + ((int) Math.floor(r14));
            r6.bottom = r15;
            r6.ascent = r6.top;
            r6.descent = r15;
        }
    }

    public LineHeightTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LineHeightTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    static {
        SparseIntArray r0 = new SparseIntArray();
        r0.put(26, 34);
        r0.put(25, 33);
        r0.put(24, 32);
        r0.put(23, 31);
        r0.put(22, 30);
        r0.put(21, 29);
        r0.put(20, 28);
        r0.put(19, 27);
        r0.put(18, 26);
        r0.put(17, 24);
        r0.put(16, 22);
        r0.put(15, 21);
        r0.put(14, 20);
        r0.put(13, 19);
        r0.put(12, 18);
        r0.put(11, 16);
        r0.put(10, 14);
        d = r0;
    }

    private final b getBuilder() {
        return (b) this.c.getValue();
    }

    public int getLineHeight() {
        return (int) this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String getLastLineText() {
        Layout r0 = getLayout();
        if (r0 != null) goto L7;
        return "";
    L7:
        return getText().toString().substring(r0.getLineStart(r0.getLineCount() - 1));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isSingleLine() {
        Layout r0 = getLayout();
        if (r0 != null) goto L5;
        return false;
    L5:
        if (r0.getLineCount() != 1) goto L9;
        return true;
    L9:
        return false;
    }

    public final void setUXLineHeight(float r2) {
        this.a = r2;
        setText(getText(), this.b);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUXLineHeightInDp(float r3) {
        Resources r0 = getContext().getResources();
        setUXLineHeight(WindowDisplayMetricsOverride.apply(r0, r0.getDisplayMetrics()).density * r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r6, TextView.BufferType r7) {
        Intrinsics.checkNotNullParameter(r7, "type");
        if (r6 != null) goto L5;
        r6 = "";
    L5:
        this.b = r7;
        if (this.a > 1.0f) goto L8;
        super/*android.widget.TextView*/.setText(r6, r7);
        return;
    L8:
        b r0 = getBuilder();
        float r1 = this.a;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r6, "sequence");
        r0.clear();
        r0.clearSpans();
        c r2 = r0.a;
        if (r2 == null) goto L11;
        r2.a = (int) Math.ceil(r1);
    L12:
        r0.append(r6);
        r0.setSpan(r2, 0, r6.length(), 17);
        super/*android.widget.TextView*/.setText(r0, r7);
        return;
    L11:
        r2 = new c(r1);
        r0.a = r2;
        goto L12
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LineHeightTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = -1.0f;
        this.b = TextView.BufferType.NORMAL;
        this.c = LazyKt.lazy(LazyThreadSafetyMode.NONE, LineHeightTextView$builder$2.INSTANCE);
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130975013});
        int r7 = r6.getDimensionPixelSize(0, -1);
        r6.recycle();
        if (r7 >= 0) goto L5;
        Resources r8 = getResources();
        float r9 = WindowDisplayMetricsOverride.apply(r8, r8.getDisplayMetrics()).density;
        r7 = (int) (d.get((int) (getTextSize() / r9), -1) * r9);
    L5:
        setUXLineHeight(r7);
    }

    public /* synthetic */ LineHeightTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
