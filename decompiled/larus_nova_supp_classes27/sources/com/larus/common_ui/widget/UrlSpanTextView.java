package com.larus.common_ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.SpannedString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.text.HtmlCompat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\"#B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0011J\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u0013J\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u000fJ\u000e\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u001dJ\u0010\u0010\u001e\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0013H\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/larus/common_ui/widget/UrlSpanTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "getAttrs", "()Landroid/util/AttributeSet;", "mOnClickListener", "Lcom/larus/common_ui/widget/UrlSpanTextView$OnClickListener;", "linkColor", "Landroid/content/res/ColorStateList;", "linkUnderLine", "", "linkText", "", "linkFakeBold", "setLinkFakeBold", "", "enabled", "setUrlText", "text", "setUrlTextColor", "setUrlSpannedText", "spannedText", "", "wrapText", "charSequence", "setOnClickListener", "listener", "OnClickListener", "UrlClickSpan", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrlSpanTextView extends AppCompatTextView {
    public final AttributeSet a;
    public a b;
    public ColorStateList c;
    public final boolean d;
    public CharSequence e;
    public boolean f;

    public interface a {
        void a(String r1);
    }

    public final class b extends ClickableSpan {
        public final String a;
        public final boolean b;
        public final /* synthetic */ UrlSpanTextView c;

        @Override // android.text.style.ClickableSpan
        public final void onClick(View r2) {
            Intrinsics.checkNotNullParameter(r2, "widget");
            a r3 = this.c.b;
            if (r3 == null) goto L6;
            r3.a(this.a);
            return;
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(TextPaint r2) {
            Intrinsics.checkNotNullParameter(r2, "ds");
            r2.setUnderlineText(this.b);
            r2.setColor(r2.linkColor);
            r2.setFakeBoldText(this.c.f);
        }

        public b(UrlSpanTextView r2, String r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "url");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public UrlSpanTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public UrlSpanTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    public final AttributeSet getAttrs() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setLinkFakeBold(boolean r1) {
        this.f = r1;
        setText(x(this.e));
    }

    public final void setOnClickListener(a r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.b = r2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUrlSpannedText(String r8) {
        Intrinsics.checkNotNullParameter(r8, "spannedText");
        Spanned r9 = HtmlCompat.fromHtml(StringsKt.replace$default(r8, "\n", "<br/>", false, 4, null), 0);
        if ((r9 instanceof SpannableStringBuilder) == false) goto L5;
        SpannableStringBuilder r10 = (SpannableStringBuilder) r9;
    L6:
        SpannedString r11 = SpannedString.valueOf(r10);
        Intrinsics.checkNotNull(r11);
        this.e = r11;
        setText(x(r11));
        return;
    L5:
        r10 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUrlText(CharSequence r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        this.e = r2;
        setText(x(r2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setUrlTextColor(ColorStateList r2) {
        Intrinsics.checkNotNullParameter(r2, "linkColor");
        this.c = r2;
        setLinkTextColor(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final CharSequence x(CharSequence r10) {
        if ((r10 instanceof SpannedString) == false) goto L10;
        SpannableString r0 = SpannableString.valueOf(r10);
        SpannedString r11 = (SpannedString) r10;
        Iterator r1 = ArrayIteratorKt.iterator((URLSpan[]) r11.getSpans(0, r0.length() - 1, URLSpan.class));
    L6:
        if (r1.hasNext() == false) goto L8;
        URLSpan r3 = (URLSpan) r1.next();
        int r5 = r11.getSpanStart(r3);
        int r6 = r11.getSpanEnd(r3);
        r0.removeSpan(r3);
        b r7 = new b(this, r3.getURL(), this.d);
        StyleSpan r4 = new StyleSpan(1);
        r0.setSpan(r7, r5, r6, 33);
        r0.setSpan(r4, r5, r6, 33);
        goto L6
    L8:
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(0);
        setAutoLinkMask(1);
        Intrinsics.checkNotNull(r0);
        return r0;
    L10:
        return r10;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UrlSpanTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = r4;
        this.d = true;
        CharSequence r0 = "";
        this.e = "";
        TypedArray r6 = r3.obtainStyledAttributes(r4, new int[]{2130972032, 2130972033, 2130972034, 2130972035});
        this.c = r6.getColorStateList(0);     // Catch: Throwable -> L13
        this.d = r6.getBoolean(3, true);     // Catch: Throwable -> L13
        CharSequence r1 = r6.getText(2);     // Catch: Throwable -> L13
        if (r1 == null) goto L7;
        r0 = r1;
    L7:
        this.e = r0;     // Catch: Throwable -> L13
        this.f = r6.getBoolean(1, false);     // Catch: Throwable -> L13
        ColorStateList r7 = this.c;     // Catch: Throwable -> L13
        if (r7 == null) goto L10;
        setLinkTextColor(r7);     // Catch: Throwable -> L13
    L10:
        setUrlText(this.e);     // Catch: Throwable -> L13
        r6.recycle();
        return;
    L13:
        th = move-exception;
        r6.recycle();
        throw th;
    }

    public /* synthetic */ UrlSpanTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
