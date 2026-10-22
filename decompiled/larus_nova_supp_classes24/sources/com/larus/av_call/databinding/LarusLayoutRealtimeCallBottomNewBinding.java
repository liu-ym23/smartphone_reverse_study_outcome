package com.larus.av_call.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.av_call.view.RealtimeCallSuggestView;
import com.larus.common_ui.view.ChatContinuousAudioVisualizerOpt;
import com.larus.common_ui.view.CustomBarCountAudioVisualizer;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusLayoutRealtimeCallBottomNewBinding implements ViewBinding {
    public final View a;
    public final ChatContinuousAudioVisualizerOpt b;
    public final TextView c;
    public final AppCompatImageView d;
    public final ProgressBar e;
    public final View f;
    public final CustomBarCountAudioVisualizer g;
    public final RealtimeCallSuggestView h;
    public final LinearLayout i;
    public final View j;
    public final ConstraintLayout k;
    public final UrlSpanTextView l;

    public final View getRoot() {
        return this.a;
    }

    public LarusLayoutRealtimeCallBottomNewBinding(View r1, ChatContinuousAudioVisualizerOpt r2, TextView r3, AppCompatImageView r4, ProgressBar r5, View r6, CustomBarCountAudioVisualizer r7, RealtimeCallSuggestView r8, LinearLayout r9, View r10, ConstraintLayout r11, UrlSpanTextView r12) {
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
    }
}
