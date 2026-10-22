package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusWidgetCreationBlockVideoItemBinding implements ViewBinding {
    public final ConstraintLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusWidgetCreationBlockVideoItemBinding(ConstraintLayout r1) {
        this.a = r1;
    }

    public static LarusWidgetCreationBlockVideoItemBinding a(LayoutInflater r2, ViewGroup r3) {
        ConstraintLayout r4 = r2.inflate(2131563247, r3, false);
        if (r4 == null) goto L7;
        return new LarusWidgetCreationBlockVideoItemBinding(r4);
    L7:
        throw new NullPointerException("rootView");
    }
}
