package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.zhpan.bannerview.indicator.DrawableIndicator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusDialogBotEditBgImageChooseBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final LarusLayoutBotEditErrorLayBinding c;
    public final DrawableIndicator d;
    public final ViewPager2 e;

    public final View getRoot() {
        return this.a;
    }

    public LarusDialogBotEditBgImageChooseBinding(LinearLayout r1, TextView r2, LarusLayoutBotEditErrorLayBinding r3, DrawableIndicator r4, ViewPager2 r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
