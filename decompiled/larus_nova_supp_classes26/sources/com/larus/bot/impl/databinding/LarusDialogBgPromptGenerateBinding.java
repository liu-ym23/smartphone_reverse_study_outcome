package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.widget.PromptInputButtonView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogBgPromptGenerateBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatEditText b;
    public final PromptInputButtonView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogBgPromptGenerateBinding(ConstraintLayout r1, AppCompatEditText r2, PromptInputButtonView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
