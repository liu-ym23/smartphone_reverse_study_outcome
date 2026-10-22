package com.larksuite.component.blockit.props;

import android.content.Context;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000fJ\u001c\u0010\u0019\u001a\u00020\u00172\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0014J\u0018\u0010!\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\n2\u0006\u0010 \u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/larksuite/component/blockit/props/SpannableTailTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mWidthMeasureSpec", "mHeightMeasureSpec", "mTailContent", "", "mEllipsizeFinal", "", "getMEllipsizeFinal", "()Z", "setMEllipsizeFinal", "(Z)V", "setTailContent", "", "tailContent", "setText", "text", "", "type", "Landroid/widget/TextView$BufferType;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "doMeasure", "Companion", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class SpannableTailTextView extends AppCompatTextView {
    public int a;
    public int b;
    public String c;
    public boolean d;

    public static final class a {
    }

    static {
    }

    public final boolean getMEllipsizeFinal() {
        return this.d;
    }

    public SpannableTailTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2);
        this.c = "…";
    }

    public final void setMEllipsizeFinal(boolean r1) {
        this.d = r1;
    }

    public final void setTailContent(String r2) {
        Intrinsics.checkNotNullParameter(r2, "tailContent");
        this.c = r2;
        this.d = false;
    }

    public SpannableTailTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        this.c = "…";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r6, int r7) {
        super.onMeasure(r6, r7);
        if (this.a == r6) goto L5;
    L7:
        boolean r0 = false;
    L9:
        if (this.d == false) goto L12;
        if (r0 == false) goto L12;
        return;
    L12:
        this.a = r6;
        this.b = r7;
        int r1 = getLineCount();
        Layout r3 = getLayout();
        int r4 = getMaxLines();
        if (r4 == 0) goto L23;
        if (r1 >= r4) goto L16;
        return;
    L16:
        if (TextUtils.isEmpty(getText()) == true) goto L26;
        int r2 = r3.getLineEnd(r4 - 1);
        if (r2 >= getText().length()) goto L27;
        setText(new SpannableStringBuilder(getText().subSequence(0, r2 - 1)).append(this.c));
        this.d = true;
        measure(r6, r7);
        return;
    L27:
        return;
    L26:
        return;
    L23:
        return;
    L5:
        if (this.b != r7) goto L7;
        r0 = true;
        goto L9
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setText(CharSequence r2, TextView.BufferType r3) {
        this.d = false;
        super/*android.widget.TextView*/.setText(r2, r3);
    }

    public SpannableTailTextView(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        this.c = "…";
    }
}
