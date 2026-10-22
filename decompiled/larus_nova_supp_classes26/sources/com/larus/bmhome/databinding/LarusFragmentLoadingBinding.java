package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFragmentLoadingBinding implements ViewBinding {
    public final FrameLayout a;
    public final ProgressBar b;
    public final ProgressBar c;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentLoadingBinding(FrameLayout r1, ProgressBar r2, ProgressBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
