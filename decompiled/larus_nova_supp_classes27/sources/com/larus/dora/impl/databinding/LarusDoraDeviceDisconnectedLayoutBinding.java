package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraDeviceDisconnectedLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ConstraintLayout b;
    public final DoraTextView c;
    public final SimpleDraweeView d;
    public final ProgressBar e;
    public final DoraTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraDeviceDisconnectedLayoutBinding(ConstraintLayout r1, ConstraintLayout r2, DoraTextView r3, SimpleDraweeView r4, ProgressBar r5, DoraTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
