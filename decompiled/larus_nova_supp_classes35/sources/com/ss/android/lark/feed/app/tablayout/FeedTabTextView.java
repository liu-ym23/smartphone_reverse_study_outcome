package com.ss.android.lark.feed.app.tablayout;

import android.content.Context;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.larksuite.component.ui.display.manager.zoom.LarkFont;
import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.log.Log;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0016\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\tH\u0014J\b\u0010\u001c\u001a\u00020\u0019H\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u0011@DX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/ss/android/lark/feed/app/tablayout/FeedTabTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "requestedPaddingLeft", BuildConfig.FLAVOR, "requestedPaddingRight", "value", "minPadding", "getMinPadding", "()I", "setMinPadding", "(I)V", BuildConfig.FLAVOR, "omit", "getOmit", "()Ljava/lang/String;", "setOmit", "(Ljava/lang/String;)V", "currentPadding", "onMeasure", BuildConfig.FLAVOR, "widthMeasureSpec", "heightMeasureSpec", "reduceGroupContent", "percentOfPaddingLeft", BuildConfig.FLAVOR, "percentOfPaddingRight", "Companion", "feed-tab-layout_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class FeedTabTextView extends AppCompatTextView {
    public final int a;
    public final int b;
    public int c;
    public String d;

    public static final class a {
    }

    static {
    }

    public final int getMinPadding() {
        return this.c;
    }

    public final String getOmit() {
        return this.d;
    }

    public FeedTabTextView(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setMinPadding(int r2) {
        if (this.c == r2) goto L6;
        this.c = r2;
        requestLayout();
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void setOmit(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (Intrinsics.areEqual(this.d, r2) == true) goto L6;
        this.d = r2;
        requestLayout();
        return;
    }

    public FeedTabTextView(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3);
        int r4 = UIUtils.dp2px(r2, 20.0f);
        this.a = r4;
        this.b = r4;
        this.c = UIUtils.dp2px(r2, 4.0f);
        this.d = "...";
        setTextSize(0, zz7.b.i(r2, LarkFont.BODY2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r16, int r17) {
        boolean r2 = getPaint().isFakeBoldText();
        boolean r0 = true;
        if (r2 == true) goto L5;
        getPaint().setFakeBoldText(true);
    L5:
        getPaddingLeft();
        setPadding(this.a, getPaddingTop(), this.b, getPaddingBottom());
        super.onMeasure(r16, r17);
        CharSequence r3 = getText();
        if (r3 != null) goto L8;
    L11:
        boolean r4 = true;
    L13:
        if (r4 == false) goto L16;
        Log.i("FeedTabTextView", "text is null or empty");
        return;
    L16:
        int r5 = getMeasuredWidth();
        int r6 = MathKt.roundToInt(getPaint().measureText(getText().toString()));
        int r7 = this.a;
        int r8 = (r6 + r7) + this.b;
        if (r5 >= r8) goto L34;
        int r9 = this.c;
        float r10 = r8 - r5;
        float r11 = 0.0f;
        if (getPaddingRight() != 0) goto L22;
        float r12 = 1.0f;
    L25:
        int r13 = Math.max(r9, r7 - MathKt.roundToInt(r12 * r10));
        int r14 = this.c;
        int r15 = this.b;
        if (getPaddingLeft() != 0) goto L29;
        r11 = 1.0f;
    L32:
        setPadding(r13, getPaddingTop(), Math.max(r14, r15 - MathKt.roundToInt(r10 * r11)), getPaddingBottom());
        goto L34
    L29:
        if (getPaddingRight() == 0) goto L32;
        r11 = this.b / (Math.abs(this.a) + Math.abs(this.b));
        goto L32
    L22:
        if (getPaddingLeft() != 0) goto L24;
        r12 = 0.0f;
        goto L25
    L24:
        int r18 = this.a;
        r12 = r18 / (Math.abs(r18) + Math.abs(this.b));
    L34:
        if (getPaddingLeft() == this.c) goto L36;
    L65:
        super.onMeasure(r16, r17);
        if (r2 == true) goto L73;
        getPaint().setFakeBoldText(false);
        return;
    L73:
        return;
    L36:
        if (StringsKt.contains$default(getText(), this.d, false, 2, null) == true) goto L65;
    L63:
        e = move-exception;
        Log.i("FeedTabTextView", "reduceGroupContent failed!, " + e);
        goto L65
    L38:
        if (StringsKt.split$default(getText(), new String[]{" "}, false, 0, 6, null).size() < 2) goto L65;
        int r19 = StringsKt.lastIndexOf$default(getText(), " ", 0, false, 6, null);     // Catch: Exception -> L63
        if (r19 == (-1)) goto L65;
        String r20 = StringsKt.substring(getText(), RangesKt.until(0, r19));     // Catch: Exception -> L63
        String r21 = StringsKt.substring(getText(), new IntRange(r19 + 1, StringsKt.getLastIndex(getText())));     // Catch: Exception -> L63
        if (r20.length() != 0) goto L45;
        boolean r22 = true;
    L46:
        if (r22 == true) goto L65;
        if (r21.length() == 0) goto L51;
        r0 = false;
    L51:
        if (r0 == true) goto L65;
        String r1 = this.d + r21;     // Catch: Exception -> L63
        float r23 = getPaint().measureText(r20);     // Catch: Exception -> L63
        float r24 = getPaint().measureText(r1);     // Catch: Exception -> L63
        if (r24 >= getMeasuredWidth()) goto L65;
    L56:
        if (((getMaxWidth() - r23) - (getPaddingLeft() + getPaddingRight())) > r24) goto L61;
        if (StringsKt.getLastIndex(r20) == 0) goto L65;
        r20 = r20.substring(0, StringsKt.getLastIndex(r20));     // Catch: Exception -> L63
        r23 = getPaint().measureText(r20);     // Catch: Exception -> L63
        goto L56
    L61:
        setText(r20 + r1);     // Catch: Exception -> L63
        goto L65
    L45:
        r22 = false;
        goto L46
    L8:
        if (r3.length() == 0) goto L11;
        r4 = false;
        goto L13
    }
}
