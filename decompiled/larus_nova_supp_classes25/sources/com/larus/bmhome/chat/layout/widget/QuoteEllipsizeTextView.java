package com.larus.bmhome.chat.layout.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.model.ChatDraftItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001c\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0018\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0007H\u0014R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/larus/bmhome/chat/layout/widget/QuoteEllipsizeTextView;", "Lcom/larus/bmhome/chat/layout/widget/ShimmerTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "originalText", "", "hasQuote", "", "lastMaxWidth", "lastSource", "lastEllipsized", "setText", "", ChatDraftItem.TYPE_TEXT, "type", "Landroid/widget/TextView$BufferType;", "sb", "Landroid/text/SpannableStringBuilder;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "Companion", "chat-common_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class QuoteEllipsizeTextView extends ShimmerTextView {
    public CharSequence i;
    public boolean j;
    public int k;
    public CharSequence l;
    public CharSequence m;
    public final SpannableStringBuilder n;

    public static final class a {
    }

    static {
    }

    public QuoteEllipsizeTextView(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public QuoteEllipsizeTextView(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 4, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r8, int r9) {
        if (this.j == true) goto L5;
    L30:
        super.onMeasure(r8, r9);
        return;
    L5:
        if (getMaxLines() != 1) goto L30;
        View.MeasureSpec.getMode(r8);
        int r0 = View.MeasureSpec.getSize(r8);
        CharSequence r1 = this.i;
        if (r1 == null) goto L28;
        if (r0 <= 0) goto L28;
        if (r0 == this.k) goto L13;
    L14:
        this.k = r0;
        this.l = r1;
        float r2 = (((r0 - getPaddingLeft()) - getPaddingRight()) - getCompoundPaddingLeft()) - getCompoundPaddingRight();
        float r3 = getPaint().measureText(r1.toString());
        CharSequence r4 = r1;
        if (r3 <= r2) goto L22;
        CharSequence r5 = TextUtils.ellipsize(r1, getPaint(), r2 - getPaint().measureText("”"), TextUtils.TruncateAt.END);
        SpannableStringBuilder r6 = this.n;
        r6.clear();
        r6.append(r5);
        Intrinsics.checkNotNull(r5);
        r4 = r6;
        if (StringsKt.contains$default(r5, "“", false, 2, null) == false) goto L22;
        r4 = r6;
        if (StringsKt.contains$default(r5, "”", false, 2, null) == true) goto L22;
        r6.append("”");
        r4 = r6;
    L22:
        this.m = r4;
    L23:
        CharSequence r7 = this.m;
        if (r7 == null) goto L28;
        if (Intrinsics.areEqual(String.valueOf(r7), getText().toString()) == true) goto L28;
        super/*android.widget.TextView*/.setText(this.m, TextView.BufferType.SPANNABLE);
        goto L28
    L13:
        if (Intrinsics.areEqual(r1, this.l) == true) goto L23;
    L28:
        super.onMeasure(r8, r9);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r6, TextView.BufferType r7) {
        this.i = r6;
        boolean r2 = true;
        if (r6 != null) goto L5;
    L7:
        boolean r4 = false;
    L8:
        if (r4 == false) goto L16;
        if (r6 != null) goto L11;
    L13:
        boolean r0 = false;
    L14:
        if (r0 == false) goto L16;
    L17:
        this.j = r2;
        super/*android.widget.TextView*/.setText(r6, r7);
        return;
    L11:
        if (StringsKt.contains$default(r6, "“", false, 2, null) != true) goto L13;
        r0 = true;
    L16:
        r2 = false;
        goto L17
    L5:
        if (StringsKt.contains$default(r6, "”", false, 2, null) != true) goto L7;
        r4 = true;
        goto L8
    }

    public QuoteEllipsizeTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.n = new SpannableStringBuilder();
    }

    public /* synthetic */ QuoteEllipsizeTextView(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
