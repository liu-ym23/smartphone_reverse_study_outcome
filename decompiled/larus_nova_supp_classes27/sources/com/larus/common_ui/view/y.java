package com.larus.common_ui.view;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.view.View;
import com.larus.common_res.common_ui.databinding.LarusItemSuggestedActionBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class y implements View.OnLayoutChangeListener {
    public final /* synthetic */ LarusItemSuggestedActionBinding a;
    public final /* synthetic */ SuggestedActionBar b;

    public y(LarusItemSuggestedActionBinding r1, SuggestedActionBar r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        r1.removeOnLayoutChangeListener(this);
        float r10 = this.a.c.getMeasuredWidth();
        SuggestedActionBar r11 = this.b;
        this.a.c.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r10, 0.0f, r11.a, r11.b, Shader.TileMode.CLAMP));
        this.a.b.setImageResource(2131242159);
    }
}
