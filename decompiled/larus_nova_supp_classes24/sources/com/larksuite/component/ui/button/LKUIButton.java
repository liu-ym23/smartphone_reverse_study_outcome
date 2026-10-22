package com.larksuite.component.ui.button;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUIButton extends AppCompatButton {
    public LKUIButton(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setCommonButtonStyle(Context r3) {
        setHeight((int) j08.b.a(r3, 28.0f));
        setMinWidth((int) j08.b.a(r3, 60.0f));
        setPadding((int) j08.b.a(r3, 12.0f), 0, (int) j08.b.a(r3, 12.0f), 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setCustomStyle(TypedArray r11) {
        int r0 = r11.getColor(2, getResources().getColor(2131101111));
        int r2 = r11.getColor(3, getResources().getColor(2131101111));
        int r3 = r11.getColor(1, getResources().getColor(2131108614));
        int r6 = r11.getDimensionPixelSize(0, 0);
        int r1 = r11.getColor(4, getResources().getColor(2131101111));
        int r12 = r11.getDimensionPixelSize(5, 0);
        StateListDrawable r7 = new StateListDrawable();
        r7.addState(new int[]{R.attr.state_pressed}, b.a(r2, r6, r1, r12));
        r7.addState(new int[]{-16842910}, b.a(r3, r6, r1, r12));
        r7.addState(new int[0], b.a(r0, r6, r1, r12));
        setBackground(r7);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void setLargeButtonStyle(Context r2) {
        setHeight((int) j08.b.a(r2, 48.0f));
    }

    public LKUIButton(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LKUIButton(Context r4, AttributeSet r5, int r6) {
        super(r4, r5, r6);
        TypedArray r7 = r4.obtainStyledAttributes(r5, new int[]{2130969112, 2130969113, 2130969116, 2130969118, 2130969120, 2130969122, 2130969123}, r6, 0);
        switch(r7.getInt(6, 0)) {
            case 1: goto L11;
            case 2: goto L10;
            case 3: goto L9;
            case 4: goto L8;
            case 5: goto L7;
            case 6: goto L6;
            case 7: goto L5;
            default: goto L4;
        };
    L4:
        setCustomStyle(r7);
    L12:
        r7.recycle();
        setGravity(17);
        setMaxLines(1);
        setEllipsize(TextUtils.TruncateAt.END);
        return;
    L5:
        setTextAppearance(r4, 2131952394);
        setBackground(getResources().getDrawable(2131243832));
        setCommonButtonStyle(r4);
        goto L12
    L6:
        setTextAppearance(r4, 2131952478);
        setBackground(getResources().getDrawable(2131243832));
        setCommonButtonStyle(r4);
        goto L12
    L7:
        setTextAppearance(r4, 2131952478);
        setBackground(getResources().getDrawable(2131243829));
        setCommonButtonStyle(r4);
        goto L12
    L8:
        setTextAppearance(r4, 2131951908);
        setBackground(getResources().getDrawable(2131243820));
        setCommonButtonStyle(r4);
        goto L12
    L9:
        setTextAppearance(r4, 2131952427);
        setBackground(getResources().getDrawable(2131243824));
        setLargeButtonStyle(r4);
        goto L12
    L10:
        setTextAppearance(r4, 2131952428);
        setBackground(getResources().getDrawable(2131243825));
        setLargeButtonStyle(r4);
        goto L12
    L11:
        setTextAppearance(r4, 2131952426);
        setBackground(getResources().getDrawable(2131243820));
        setLargeButtonStyle(r4);
        goto L12
    }
}
