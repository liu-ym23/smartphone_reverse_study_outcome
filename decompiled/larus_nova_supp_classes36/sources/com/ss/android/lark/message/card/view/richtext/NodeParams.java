package com.ss.android.lark.message.card.view.richtext;

import com.ss.android.lark.widget.richtext.RichTextElement;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class NodeParams implements Serializable {
    private static final long serialVersionUID = 3325780907521169105L;
    public int cardVersion;
    public int mBgColor;
    public List<NodeParams> mChildParams;
    public float mDefaultTextSize;
    public Map<String, String> mExtraProperties;
    public int mFontStyleAndWeight;
    public NodeParams mParents;
    public RichTextElement.RichTextProperty mRichTextProperty;
    public RichTextElement.RichTextTag mRichTextTag;
    public transient CharSequence mSpannableString;
    public List<String> mStyleKeys;
    public int mTextColor;
    public float mTextSize;
    public YogaProperty mYogaProperty;

    public int hashCode() {
        YogaProperty r0 = this.mYogaProperty;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        RichTextElement.RichTextTag r4 = this.mRichTextTag;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        RichTextElement.RichTextProperty r7 = this.mRichTextProperty;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        NodeParams r10 = this.mParents;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        List<NodeParams> r13 = this.mChildParams;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (((((((r12 + r14) * 31) + this.mBgColor) * 31) + this.mTextColor) * 31) + this.mFontStyleAndWeight) * 31;
        float r16 = this.mTextSize;
        if (r16 == 0.0f) goto L26;
        r1 = Float.floatToIntBits(r16);
    L26:
        return r15 + r1;
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public NodeParams(int r2) {
        this.mYogaProperty = new YogaProperty();
        this.mChildParams = new ArrayList();
        this.mFontStyleAndWeight = 0;
        this.mTextSize = -1.0f;
        this.mDefaultTextSize = -1.0f;
        this.mStyleKeys = new ArrayList();
        this.cardVersion = r2;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L58:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L58;
        NodeParams r6 = (NodeParams) r5;
        if (this.mBgColor == r6.mBgColor) goto L14;
        return false;
    L14:
        if (this.mTextColor == r6.mTextColor) goto L17;
        return false;
    L17:
        if (this.mFontStyleAndWeight == r6.mFontStyleAndWeight) goto L20;
        return false;
    L20:
        if (Float.compare(r6.mTextSize, this.mTextSize) == 0) goto L22;
        return false;
    L22:
        YogaProperty r2 = this.mYogaProperty;
        if (r2 == null) goto L28;
        if (r2.equals(r6.mYogaProperty) == true) goto L31;
    L29:
        return false;
    L31:
        if (this.mRichTextTag == r6.mRichTextTag) goto L33;
        return false;
    L33:
        RichTextElement.RichTextProperty r3 = this.mRichTextProperty;
        if (r3 == null) goto L39;
        if (r3.equals(r6.mRichTextProperty) == false) goto L40;
    L41:
        NodeParams r4 = this.mParents;
        if (r4 == null) goto L47;
        if (r4.equals(r6.mParents) == false) goto L48;
    L49:
        List<NodeParams> r7 = this.mChildParams;
        if (r7 == null) goto L55;
        if (r7.hashCode() != r6.mChildParams.hashCode()) goto L56;
    L57:
        return true;
    L56:
        return false;
    L55:
        if (r6.mChildParams == null) goto L57;
    L48:
        return false;
    L47:
        if (r6.mParents == null) goto L49;
    L40:
        return false;
    L39:
        if (r6.mRichTextProperty == null) goto L41;
    L28:
        if (r6.mYogaProperty == null) goto L31;
        goto L29
    }
}
