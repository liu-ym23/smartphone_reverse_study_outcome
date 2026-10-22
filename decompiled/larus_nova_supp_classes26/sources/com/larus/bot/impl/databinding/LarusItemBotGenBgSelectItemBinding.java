package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemBotGenBgSelectItemBinding implements ViewBinding {
    public final FrameLayout a;
    public final LarusLayoutBotEditErrorLayBinding b;
    public final SimpleDraweeView c;
    public final LinearLayout d;
    public final LottieAdapterView e;
    public final TextView f;
    public final ImageView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemBotGenBgSelectItemBinding(FrameLayout r1, LarusLayoutBotEditErrorLayBinding r2, SimpleDraweeView r3, LinearLayout r4, LottieAdapterView r5, TextView r6, ImageView r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
