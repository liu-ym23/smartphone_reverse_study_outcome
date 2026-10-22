package com.larus.bmhome.chat.layout.item;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class z2 implements View.OnLayoutChangeListener {
    public final /* synthetic */ TextView a;

    public z2(TextView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r11, int r12, int r13, int r14, int r15, int r16, int r17, int r18, int r19) {
        r11.removeOnLayoutChangeListener(this);
        this.a.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r11.getMeasuredWidth(), 0.0f, PromptSpan.T, PromptSpan.V, Shader.TileMode.CLAMP));
    }
}
