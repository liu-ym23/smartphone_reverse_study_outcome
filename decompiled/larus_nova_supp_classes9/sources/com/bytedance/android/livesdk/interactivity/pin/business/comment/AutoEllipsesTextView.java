package com.bytedance.android.livesdk.interactivity.pin.business.comment;

import android.content.Context;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.ReplacementSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.bdlocation.BuildConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\n\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/pin/business/comment/AutoEllipsesTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", BuildConfig.FLAVOR, "content", BuildConfig.FLAVOR, "setContentText", BuildConfig.FLAVOR, "maxLines", "setMaxLines", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AutoEllipsesTextView extends AppCompatTextView {
    public static final /* synthetic */ int f = 0;
    public CharSequence a;
    public boolean b;
    public final String c;
    public final String d;
    public final a e;

    public static final class a implements Runnable {
        public final /* synthetic */ AutoEllipsesTextView a;

        public a(AutoEllipsesTextView r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            AutoEllipsesTextView r0 = this.a;     // Catch: Throwable -> L4
            int r1 = AutoEllipsesTextView.f;     // Catch: Throwable -> L4
            r0.x();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AutoEllipsesTextView(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public AutoEllipsesTextView(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        if (this.a != null) goto L6;
        return;
    L6:
        if (getMaxLines() > 0) goto L8;
        return;
    L8:
        if (getLayout() != null) goto L10;
        return;
    L10:
        if (getLayout().getWidth() > 0) goto L13;
        return;
    L13:
        if (getLayout().getLineCount() > getMaxLines()) goto L16;
        return;
    L16:
        if ((this.a instanceof SpannableString) == true) goto L18;
        return;
    L18:
        int r1 = getLayout().getWidth();
        CharSequence r2 = this.a;
        if (r2 == null) goto L78;
        SpannableString r10 = (SpannableString) r2;
        Object[] r3 = r10.getSpans(r10.length() - 1, r10.length(), Object.class);
        int r4 = r3.length;
        int r5 = 0;
    L22:
        if (r5 >= r4) goto L27;
        Object r6 = r3[r5];
        if ((r6 instanceof ClickableSpan) == true) goto L25;
        r5 = r5 + 1;
        goto L22
    L25:
        ClickableSpan r13 = (ClickableSpan) r6;
    L29:
        if (r13 != null) goto L35;
        int r7 = getLayout().getLineStart(getMaxLines() - 1);
        CharSequence r8 = TextUtils.ellipsize(r10.subSequence(r7, r10.length()), getPaint(), r1, TextUtils.TruncateAt.END);
        int r9 = this.d.length();
        int r11 = r7 + r8.length();
        if (StringsKt.endsWith$default(r8, this.d, false, 2, null) == false) goto L33;
        r11 = r11 - r9;
    L33:
        setText(new SpannableStringBuilder(r10.subSequence(0, r11)).append(this.d));
        return;
    L35:
        SpannableStringBuilder r14 = new SpannableStringBuilder(this.a);
        if (Build.VERSION.SDK_INT < 23) goto L38;
        StaticLayout r15 = StaticLayout.Builder.obtain(r14, 0, r14.length(), getPaint(), r1).setIncludePad(getIncludeFontPadding()).setAlignment(Layout.Alignment.ALIGN_NORMAL).setLineSpacing(getLineSpacingExtra(), getLineSpacingMultiplier()).build();
    L40:
        if (r15.getLineCount() <= getMaxLines()) goto L90;
        int r16 = r15.getLineStart(getMaxLines() - 1);
        int r17 = r10.getSpanStart(r13);
        int r18 = r10.getSpanEnd(r13);
        int r19 = r10.getSpanFlags(r13);
        CharSequence r20 = r10.subSequence(r17, r18);
        int r21 = r18 - r17;
        if ((r20 instanceof Spannable) == false) goto L53;
        ReplacementSpan[] r23 = (ReplacementSpan[]) ((Spannable) r20).getSpans(0, r20.length(), ReplacementSpan.class);
        int r24 = r23.length;
        int r25 = 0;
        int r26 = 0;
    L44:
        if (r25 >= r24) goto L55;
        ReplacementSpan r110 = r23[r25];
        Spannable r111 = (Spannable) r20;
        int r112 = r111.getSpanStart(r110) - r17;
        int r113 = r111.getSpanEnd(r110) - r17;
        if (r112 >= 0) goto L48;
        int r114 = r17;
    L49:
        if (r113 <= r21) goto L51;
        int r115 = r21;
    L52:
        r26 = r26 + r110.getSize(getPaint(), r20, r114, r115, getPaint().getFontMetricsInt());
        r25 = r25 + 1;
        goto L44
    L51:
        r115 = r113;
        goto L52
    L48:
        r114 = r112;
    L55:
        if (this.b == false) goto L57;
        int r27 = (int) (getPaint().measureText(this.c) + 0.5f);
    L58:
        CharSequence r28 = TextUtils.ellipsize(r10.subSequence(r16, r17 + 1), getPaint(), (r1 - r26) - r27, TextUtils.TruncateAt.END);
        int r29 = this.d.length();
        int r30 = r16 + r28.length();
        if (StringsKt.endsWith$default(r28, this.d, false, 2, null) == false) goto L61;
        r30 = r30 - r29;
    L61:
        SpannableStringBuilder r31 = new SpannableStringBuilder(r10.subSequence(0, r30)).append(this.d);
        Object[] r33 = r10.getSpans(0, r30, Object.class);
        int r34 = r33.length;
        int r116 = 0;
    L62:
        if (r116 >= r34) goto L73;
        Object r35 = r33[r116];
        int r36 = r10.getSpanStart(r35);
        int r117 = r10.getSpanEnd(r35);
        int r118 = r30 - 1;
        if (r36 > r118) goto L71;
        if (r117 <= r118) goto L71;
        int r119 = r10.getSpanFlags(r35);
        r31.removeSpan(r35);
        if ((r35 instanceof ReplacementSpan) == false) goto L70;
        r31.setSpan(r35, r36, r30, r119);
        goto L71
    L70:
        r31.setSpan(r35, r36, r30 + r29, r119);
    L71:
        r116 = r116 + 1;
        goto L62
    L73:
        if (this.b == false) goto L75;
        r31.append(this.c);
    L75:
        int r37 = r31.length();
        r31.append(r20);
        r31.setSpan(r13, r37, r20.length() + r37, r19);
        setText(r31);
        return;
    L57:
        r27 = 0;
        goto L58
    L53:
        r26 = (int) getPaint().measureText(r20.toString());
        goto L55
    L90:
        return;
    L38:
        r15 = new StaticLayout(r14, getPaint(), r1, Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), getIncludeFontPadding());
        goto L40
    L27:
        r13 = null;
        goto L29
    L78:
        throw new NullPointerException("null cannot be cast to non-null type android.text.SpannableString");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void y() {
        if (getLayout() != null) goto L5;
        removeCallbacks(this.e);
        post(this.e);
        return;
    L5:
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setContentText(CharSequence r1) {
        this.a = r1;
        setText(r1);
        if (TextUtils.isEmpty(this.a) == true) goto L6;
        y();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxLines(int r2) {
        int r0 = getMaxLines();
        super/*android.widget.TextView*/.setMaxLines(r2);
        if (r0 == r2) goto L6;
        setText(this.a);
        y();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setTextSize(int r2, float r3) {
        float r0 = getTextSize();
        super.setTextSize(r2, r3);
        if (r0 == getTextSize()) goto L6;
        setText(this.a);
        y();
        return;
    }

    public AutoEllipsesTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = " ";
        this.d = "…";
        this.e = new a(this);
    }

    public /* synthetic */ AutoEllipsesTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onSizeChanged(int r1, int r2, int r3, int r4) {
        super/*android.widget.TextView*/.onSizeChanged(r1, r2, r3, r4);
        if (r1 == r3) goto L14;
        if (r1 > 0) goto L6;
        return;
    L6:
        if (getVisibility() != 0) goto L12;
        if (r3 == 0) goto L12;
        if (r4 == 0) goto L12;
        if ((!Intrinsics.areEqual(this.a, getText())) == false) goto L12;
        setText(this.a);
    L12:
        y();
        return;
    }
}
