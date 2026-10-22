package com.larus.bmhome.music.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.larus.bmhome.music.widget.MusicPlayerLyricView;
import com.larus.bmhome.music.widget.MusicPlayerSlidingInfoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusViewMusicPlayerSlidingInfoBinding implements ViewBinding {
    public final View a;
    public final TextView b;
    public final ImageView c;
    public final View d;
    public final MusicPlayerLyricView e;
    public final FrameLayout f;
    public final AppCompatImageView g;
    public final AppCompatImageView h;
    public final ViewPager2 i;
    public final TextView j;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LarusViewMusicPlayerSlidingInfoBinding(MusicPlayerSlidingInfoView r1, TextView r2, ImageView r3, View r4, MusicPlayerLyricView r5, FrameLayout r6, AppCompatImageView r7, AppCompatImageView r8, ViewPager2 r9, TextView r10) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
        this.h = r8;
        this.i = r9;
        this.j = r10;
    }
}
