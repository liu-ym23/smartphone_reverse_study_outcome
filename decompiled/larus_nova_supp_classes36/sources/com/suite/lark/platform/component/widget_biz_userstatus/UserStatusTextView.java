package com.suite.lark.platform.component.widget_biz_userstatus;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.linked_emojicon.widget.LinkEmojiTextView;
import com.ss.android.lark.widget.span.AtInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class UserStatusTextView extends LinkEmojiTextView {
    public final List<a> G1;
    public boolean x1;
    public boolean y1;

    public interface a {
        void b();
    }

    public UserStatusTextView(Context r2) {
        super(r2);
        this.x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onConfigurationChanged(Configuration r2) {
        super/*android.widget.TextView*/.onConfigurationChanged(r2);
        Iterator r3 = ((ArrayList) this.G1).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((a) r3.next()).b();
        goto L4
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setMaxLines(int r2) {
        this.x1 = false;
        super/*android.widget.TextView*/.setMaxLines(r2);
    }

    public void setShowArrow(boolean r1) {
        this.y1 = r1;
    }

    public UserStatusTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void I(int r9, int r10) {
        if (((LinkEmojiTextView) this).u == true) goto L5;
        return;
    L5:
        if (((LinkEmojiTextView) this).t == true) goto L44;
        int r0 = getLineCount();
        Layout r1 = getLayout();
        int r2 = getMaxLines();
        if (r2 == 0) goto L33;
        if (r0 <= r2) goto L33;
        if (TextUtils.isEmpty(getText()) == true) goto L33;
        int r3 = r2 - 1;
        int r4 = r1.getLineEnd(r3);
        int r5 = r1.getLineStart(r3);
        if (r4 >= getText().length()) goto L16;
    L18:
        CharSequence r6 = getText().subSequence(0, r5);
        if ("\n".equals(String.valueOf(getText().charAt(getText().length() - 1))) == false) goto L21;
        CharSequence r7 = getText().subSequence(r5, getText().length() - 1);
    L22:
        CharSequence r8 = TextUtils.ellipsize(r7, getPaint(), getMeasuredWidth(), TextUtils.TruncateAt.END);
        SpannableStringBuilder r11 = new SpannableStringBuilder(r6);
        if (this.y1 == true) goto L26;
        r11.append(r8);
    L30:
        setText(r11);
        ((LinkEmojiTextView) this).t = true;
        measure(r9, r10);
        return;
    L26:
        if (r8.length() <= 3) goto L28;
        r11.append(r8.subSequence(0, r8.length() - 3));
        r11.append(r8.charAt(r8.length() - 1));
    L29:
        r11.append(" ");
        U(2131233664, r11);
        goto L30
    L28:
        r11.append(r8);
        goto L29
    L21:
        r7 = getText().subSequence(r5, getText().length());
        goto L22
    L16:
        if (this.y1 == true) goto L18;
        return;
    L33:
        if (this.y1 == true) goto L36;
        setText(new SpannableStringBuilder(getText()));
        ((LinkEmojiTextView) this).t = true;
        return;
    L36:
        if (r0 > 1) goto L39;
        return;
    L39:
        if (this.x1 == true) goto L45;
        this.x1 = true;
        Log.d("showTextEndWithCloseImage", ((LinkEmojiTextView) this).t + " -->" + getText());
        SpannableStringBuilder r12 = new SpannableStringBuilder(getText());
        r12.append(" ");
        U(2131233663, r12);
        setText(r12);
        ((LinkEmojiTextView) this).t = true;
        return;
    L45:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void U(int r4, SpannableStringBuilder r5) {
        r5.append(" ");
        Drawable r6 = getResources().getDrawable(r4);
        r6.setBounds(0, 0, r6.getIntrinsicWidth(), r6.getIntrinsicHeight());
        ImageSpan r0 = new ImageSpan(r6, 1);
        int r7 = r5.length();
        r5.setSpan(r0, r7 - 1, r7, 33);
    }

    public UserStatusTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.x1 = false;
        this.G1 = new ArrayList();
        setShowTail(true);
        setNeedToRecognize(false);
        setShouldEllipsized(true);
    }

    public final Map<String, Object> J(Context r1, String r2, AtInfo r3) {
        return new HashMap();
    }
}
