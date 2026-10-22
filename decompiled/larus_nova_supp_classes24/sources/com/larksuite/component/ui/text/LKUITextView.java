package com.larksuite.component.ui.text;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import j08.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class LKUITextView extends AppCompatTextView {
    public static final float[][] a = null;

    static {
        a = new float[][]{new float[]{26.0f, 10.0f}, new float[]{20.0f, 8.0f}, new float[]{17.0f, 7.0f}, new float[]{16.0f, 8.0f}, new float[]{14.0f, 8.0f}, new float[]{12.0f, 4.0f}, new float[]{11.0f, 3.0f}};
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x() {
        float r1 = 0.0f;
        if (getLineSpacingExtra() == 0.0f) goto L5;
        return;
    L5:
        if (getLineSpacingMultiplier() != 1.0f) goto L30;
        int r0 = getLineHeight();
        float r3 = getTextSize();
        float r2 = r0 - r3;
        Resources r4 = getContext().getResources();
        float r5 = (int) ((r3 / WindowDisplayMetricsOverride.apply(r4, r4.getDisplayMetrics()).density) + 0.5f);
        float[][] r6 = a;
        float[] r7 = r6[0];
        if (r5 < r7[0]) goto L10;
        r1 = r7[1];
    L20:
        setLineSpacing(b.a(getContext(), r1) - r2, 1.0f);
        return;
    L10:
        float[] r8 = r6[6];
        if (r5 > r8[0]) goto L13;
        r1 = r8[1];
        goto L20
    L13:
        int r9 = 0;
    L14:
        if (r9 >= 6) goto L20;
        float[] r10 = r6[r9];
        r9 = r9 + 1;
        float[] r11 = r6[r9];
        float r12 = r10[0];
        if (r12 < r5) goto L14;
        float r13 = r11[0];
        if (r13 > r5) goto L14;
        float r14 = r10[1];
        float r15 = r11[1];
        r1 = (((r14 - r15) / (r12 - r13)) * (r5 - r13)) + r15;
        goto L14
    }

    public LKUITextView(Context r1) {
        super(r1);
        x();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setTextSize(float r1) {
        super/*android.widget.TextView*/.setTextSize(r1);
        x();
    }

    public LKUITextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        x();
    }

    public LKUITextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        x();
    }
}
