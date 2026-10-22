package com.larus.bot.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemBotAvatarPaintStyleBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final View c;
    public final FrameLayout d;
    public final TextView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemBotAvatarPaintStyleBinding(ConstraintLayout r1, SimpleDraweeView r2, View r3, FrameLayout r4, TextView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
