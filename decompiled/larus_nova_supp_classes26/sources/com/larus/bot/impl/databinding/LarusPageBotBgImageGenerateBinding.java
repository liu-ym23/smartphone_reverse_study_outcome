package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.ReferenceImageContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBotBgImageGenerateBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final PromptInputButtonView c;
    public final TextView d;
    public final RecyclerView e;
    public final ReferenceImageContainer f;
    public final NovaTitleBarEx g;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBotBgImageGenerateBinding(ConstraintLayout r1, TextView r2, PromptInputButtonView r3, TextView r4, RecyclerView r5, ReferenceImageContainer r6, NovaTitleBarEx r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
