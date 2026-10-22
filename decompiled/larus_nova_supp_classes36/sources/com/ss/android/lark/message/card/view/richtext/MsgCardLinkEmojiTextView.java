package com.ss.android.lark.message.card.view.richtext;

import android.content.Context;
import android.os.Build;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.larksuite.framework.utils.Reflect;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class MsgCardLinkEmojiTextView extends LinkEmojiTextView {
    public static final String y1 = null;
    public int x1;

    static {
        y1 = "&";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void V() {
        int r1 = this.x1;
        CharSequence r2 = getText();
        if (r1 > 1) goto L5;
        return;
    L5:
        if (r1 < Integer.MAX_VALUE) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r2) == false) goto L9;
        return;
    L9:
        if ((r2 instanceof Spanned) == true) goto L11;
        return;
    L11:
        if (getLineCount() <= r1) goto L26;
        Spanned r4 = (Spanned) r2;
        CharSequence r3 = TextUtils.ellipsize(r2, getPaint(), ((getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight()) * r1, TextUtils.TruncateAt.END);
        int r5 = (r3.length() - 1) - 1;
        if (U(r3).getLineCount() <= r1) goto L19;
        long r11 = System.currentTimeMillis();
        int r6 = 0;
    L15:
        int r14 = r6 + 1;
        int r15 = r5 - 1;
        SpannableString r10 = new SpannableString(r3.subSequence(0, r15) + y1);
        TextUtils.copySpansFrom(r4, 0, r10.length(), Object.class, r10, 0);
        if (U(r10).getLineCount() <= r1) goto L17;
        r6 = r14;
        r5 = r15;
        goto L15
    L17:
        Log.d("MsgCardLinkEmojiTextView", "count: " + r14 + ", duration: " + (System.currentTimeMillis() - r11));
        r3 = r10;
    L19:
        setText(r3);
        return;
    }

    public MsgCardLinkEmojiTextView(Context r1) {
        super(r1);
        this.x1 = Integer.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final StaticLayout U(CharSequence r10) {
        return new StaticLayout(r10, getPaint(), (getWidth() - getCompoundPaddingLeft()) - getCompoundPaddingRight(), Layout.Alignment.ALIGN_NORMAL, getLineSpacingMultiplier(), getLineSpacingExtra(), false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxLines(int r1) {
        this.x1 = r1;
        super/*android.widget.TextView*/.setMaxLines(r1);
    }

    public MsgCardLinkEmojiTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.x1 = Integer.MAX_VALUE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onMeasure(int r4, int r5) {
        Layout r0 = getLayout();
        if (Build.VERSION.SDK_INT != 26) goto L12;
        if (r0 == null) goto L12;
        if ((r0 instanceof DynamicLayout) == false) goto L12;
        new Reflect((DynamicLayout) r0).i("sStaticLayout", null);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
    L12:
        super.onMeasure(r4, r5);
    }

    public MsgCardLinkEmojiTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.x1 = Integer.MAX_VALUE;
    }

    public final void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        super.onLayout(r1, r2, r3, r4, r5);
        V();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Log.e("emoji-text", th);
    }
}
