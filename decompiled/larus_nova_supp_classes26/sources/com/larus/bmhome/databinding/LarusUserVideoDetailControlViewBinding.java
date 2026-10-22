package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.video.progress.PlayerProgressView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusUserVideoDetailControlViewBinding implements ViewBinding {
    public final View a;
    public final ProgressBar b;
    public final FrameLayout c;
    public final AppCompatImageView d;
    public final PlayerProgressView e;
    public final FrameLayout f;

    public final View getRoot() {
        return this.a;
    }

    public LarusUserVideoDetailControlViewBinding(View r1, ProgressBar r2, FrameLayout r3, AppCompatImageView r4, PlayerProgressView r5, FrameLayout r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
