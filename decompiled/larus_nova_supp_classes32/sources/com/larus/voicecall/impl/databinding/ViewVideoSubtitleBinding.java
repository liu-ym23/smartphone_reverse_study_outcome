package com.larus.voicecall.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.larus.voicecall.impl.component.videosubtitle.VideoSubtitleContainer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class ViewVideoSubtitleBinding implements ViewBinding {
    public final View a;
    public final VideoSubtitleContainer b;
    public final AppCompatTextView c;
    public final AppCompatTextView d;

    public final View getRoot() {
        return this.a;
    }

    public ViewVideoSubtitleBinding(View r1, VideoSubtitleContainer r2, AppCompatTextView r3, AppCompatTextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
