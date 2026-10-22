package com.obric.assistant.card.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.obric.assistant.card.layout.viewholder.MusicCircularProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ObricCardItemMusicBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final SimpleDraweeView b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final AppCompatImageView e;
    public final FrameLayout f;
    public final MusicCircularProgressView g;
    public final TextView h;
    public final TextView i;

    public final View getRoot() {
        return this.a;
    }

    public ObricCardItemMusicBinding(ConstraintLayout r1, SimpleDraweeView r2, FrameLayout r3, AppCompatImageView r4, AppCompatImageView r5, FrameLayout r6, MusicCircularProgressView r7, TextView r8, TextView r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
    }
}
