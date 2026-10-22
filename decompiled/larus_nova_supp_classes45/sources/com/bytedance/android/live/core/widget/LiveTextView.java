package com.bytedance.android.live.core.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;
import com.bytedance.android.live.core.utils.j0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class LiveTextView extends AppCompatTextView {
    public static j0 a;
    public static boolean b;

    public LiveTextView(Context r2) {
        this(r2, null);
    }

    public static void setEnableHostTypeface(boolean r0) {
        b = r0;
    }

    public static void setFontManager(j0 r0) {
        a = r0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x(AttributeSet r4) {
        if (b == true) goto L5;
        return;
    L5:
        if (r4 != null) goto L7;
        return;
    L7:
        int r5 = r4.getAttributeIntValue("https://schemas.android.com/apk/res/android", "textStyle", 0);
        j0 r0 = a;
        if (r0 == null) goto L13;
        Typeface r6 = r0.getHostTypeface(r5);
        if (r6 == null) goto L14;
        setTypeface(r6);
        return;
    L14:
        return;
    }

    public LiveTextView(Context r1, AttributeSet r2) {
        super(r1, r2);
        x(r2);
    }

    public LiveTextView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        x(r2);
    }
}
