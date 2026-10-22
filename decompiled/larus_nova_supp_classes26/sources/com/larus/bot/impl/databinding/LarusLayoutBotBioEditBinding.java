package com.larus.bot.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusLayoutBotBioEditBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final AppCompatEditText b;
    public final LarusBotCreateDescSkeletonBinding c;
    public final AppCompatTextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutBotBioEditBinding(ConstraintLayout r1, AppCompatEditText r2, LarusBotCreateDescSkeletonBinding r3, AppCompatTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
