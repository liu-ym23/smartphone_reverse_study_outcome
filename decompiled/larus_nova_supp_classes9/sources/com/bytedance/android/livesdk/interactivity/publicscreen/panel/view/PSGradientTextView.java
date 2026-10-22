package com.bytedance.android.livesdk.interactivity.publicscreen.panel.view;

import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class PSGradientTextView extends AppCompatTextView {
    public PSGradientTextView(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PSGradientTextView(Context r10, AttributeSet r11) {
        super(r10, r11);
        int[] r13 = {-33881, -57461};
        getPaint().setShader(new LinearGradient(0.0f, 0.0f, 0.0f, getHeight(), r13[0], r13[1], Shader.TileMode.CLAMP));
    }
}
