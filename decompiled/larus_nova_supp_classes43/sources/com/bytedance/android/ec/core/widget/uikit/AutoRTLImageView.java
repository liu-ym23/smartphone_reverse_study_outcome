package com.bytedance.android.ec.core.widget.uikit;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class AutoRTLImageView extends AppCompatImageView {
    public AutoRTLImageView(Context r10) {
        this(r10, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setBackground(Drawable r10) {
        super/*android.widget.ImageView*/.setBackground(r10);
        if (r10 == null) goto L6;
        r10.setAutoMirrored(true);
        return;
    }

    public void setImageDrawable(Drawable r10) {
        super.setImageDrawable(r10);
        if (r10 == null) goto L6;
        r10.setAutoMirrored(true);
        return;
    }

    public AutoRTLImageView(Context r10, AttributeSet r11) {
        this(r10, r11, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutoRTLImageView(Context r10, AttributeSet r11, int r12) {
        super(r10, r11, r12);
        int r13 = Build.VERSION.SDK_INT;
        Drawable r14 = getDrawable();
        Drawable r15 = getBackground();
        if (r13 < 23) goto L5;
        Drawable r16 = getForeground();
    L7:
        if (r14 == null) goto L9;
        r14.setAutoMirrored(true);
    L9:
        if (r15 == null) goto L11;
        r15.setAutoMirrored(true);
    L11:
        if (r16 == null) goto L14;
        r16.setAutoMirrored(true);
        return;
    L14:
        return;
    L5:
        r16 = null;
        goto L7
    }
}
