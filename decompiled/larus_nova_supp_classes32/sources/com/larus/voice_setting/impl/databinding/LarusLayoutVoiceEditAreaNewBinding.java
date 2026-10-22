package com.larus.voice_setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.voice_setting.voice.mix.VoiceEditArea;
import com.larus.voice_setting.voice.mix.VoiceSingleView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusLayoutVoiceEditAreaNewBinding implements ViewBinding {
    public final View a;
    public final ConstraintLayout b;
    public final SeekBar c;
    public final AppCompatTextView d;
    public final TextView e;
    public final SeekBar f;
    public final AppCompatTextView g;
    public final TextView h;
    public final LinearLayout i;
    public final VoiceSingleView j;

    public final View getRoot() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LarusLayoutVoiceEditAreaNewBinding(VoiceEditArea r1, ConstraintLayout r2, SeekBar r3, AppCompatTextView r4, TextView r5, SeekBar r6, AppCompatTextView r7, TextView r8, LinearLayout r9, VoiceSingleView r10) {
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
