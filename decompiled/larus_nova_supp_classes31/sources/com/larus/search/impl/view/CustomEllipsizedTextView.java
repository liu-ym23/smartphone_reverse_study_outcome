package com.larus.search.impl.view;

import android.content.Context;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000  2\u00020\u0001:\u0001 B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010\u001b\u001a\u00020\u0007H\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/search/impl/view/CustomEllipsizedTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ellipsis", "", "getEllipsis", "()Ljava/lang/String;", "setEllipsis", "(Ljava/lang/String;)V", "ellipsisColor", "getEllipsisColor", "()I", "setEllipsisColor", "(I)V", "ellipsisSpannable", "Landroid/text/SpannableString;", "spannableStringBuilder", "Landroid/text/SpannableStringBuilder;", "getDefaultEllipsis", "", "getDefaultEllipsisColor", "resetEllipsize", "", "onPreDraw", "", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CustomEllipsizedTextView extends AppCompatTextView {
    public String a;
    public int b;
    public final SpannableString c;

    public static final class a {
    }

    static {
    }

    public CustomEllipsizedTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public CustomEllipsizedTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    private final char getDefaultEllipsis() {
        return 8230;
    }

    private final int getDefaultEllipsisColor() {
        int r0 = j0.a;
        return j0.a(2131103203);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean onPreDraw() {
        if (getLayout() == null) goto L25;
        if (getLayout().getText() == null) goto L25;
        if (getText() == null) goto L25;
        if (Intrinsics.areEqual(getLayout().getText(), getText()) == true) goto L12;
        FLogger r0 = FLogger.a;
        r0.i("CustomEllipsizedTextVie", "onPreDraw:layout.text: " + getLayout().getText());
        int r1 = getLayout().getEllipsisStart(0);
        if (r1 <= 0) goto L17;
        r0.w("CustomEllipsizedTextVie", "onPreDraw:ellipsisIndex: " + r1);
    L20:
        if (r1 <= 0) goto L23;
        r0.e("CustomEllipsizedTextVie", "onPreDraw:Span.Replace");
        setText(new SpannableStringBuilder(getLayout().getText()).replace(r1, r1 + 1, this.c));
        getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
    L23:
        return super/*android.widget.TextView*/.onPreDraw();
    L17:
        if (StringsKt.last(getLayout().getText()) != getDefaultEllipsis()) goto L19;
        r1 = getLayout().getText().length() - 1;
        r0.w("CustomEllipsizedTextVie", "onPreDraw:layout.last: " + r1);
        goto L20
    L19:
        r1 = -1;
        goto L20
    L12:
        return super/*android.widget.TextView*/.onPreDraw();
    L25:
        return super/*android.widget.TextView*/.onPreDraw();
    }

    public final String getEllipsis() {
        return this.a;
    }

    public final int getEllipsisColor() {
        return this.b;
    }

    public final void setEllipsis(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.a = r2;
    }

    public final void setEllipsisColor(int r1) {
        this.b = r1;
    }

    public CustomEllipsizedTextView(Context r3, AttributeSet r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, r4, r5);
        this.a = String.valueOf(getDefaultEllipsis());
        this.b = getDefaultEllipsisColor();
        SpannableString r6 = new SpannableString(this.a);
        this.c = r6;
        new SpannableStringBuilder();
        r6.setSpan(new ForegroundColorSpan(this.b), 0, this.a.length(), 33);
    }

    public /* synthetic */ CustomEllipsizedTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
