package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraItemServiceNotificationBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final View b;
    public final SimpleDraweeView c;
    public final AppCompatImageView d;
    public final DoraTextView e;
    public final DoraTextView f;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraItemServiceNotificationBinding(ConstraintLayout r1, View r2, SimpleDraweeView r3, AppCompatImageView r4, DoraTextView r5, DoraTextView r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
