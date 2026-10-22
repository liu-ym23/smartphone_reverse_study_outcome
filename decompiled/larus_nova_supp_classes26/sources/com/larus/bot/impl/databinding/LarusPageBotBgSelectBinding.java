package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.IndefinitePagerIndicator;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.widget.BgSelectViewPagerContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusPageBotBgSelectBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final TextView b;
    public final IndefinitePagerIndicator c;
    public final TextView d;
    public final NovaTitleBarEx e;
    public final BgSelectViewPagerContainer f;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageBotBgSelectBinding(ConstraintLayout r1, TextView r2, IndefinitePagerIndicator r3, TextView r4, NovaTitleBarEx r5, BgSelectViewPagerContainer r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
