package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceMixedView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusLayoutVoiceEditAreaBinding implements ViewBinding {
    public final View a;
    public final ConstraintLayout b;
    public final SeekBar c;
    public final AppCompatTextView d;
    public final TextView e;
    public final FrameLayout f;
    public final AppCompatImageView g;
    public final LottieAdapterView h;
    public final SeekBar i;
    public final AppCompatTextView j;
    public final TextView k;
    public final View l;
    public final LinearLayout m;
    public final VoiceMixedView n;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LarusLayoutVoiceEditAreaBinding(VoiceEditArea r1, ConstraintLayout r2, SeekBar r3, AppCompatTextView r4, TextView r5, FrameLayout r6, AppCompatImageView r7, LottieAdapterView r8, SeekBar r9, AppCompatTextView r10, TextView r11, View r12, LinearLayout r13, VoiceMixedView r14) {
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
        this.k = r11;
        this.l = r12;
        this.m = r13;
        this.n = r14;
    }
}
