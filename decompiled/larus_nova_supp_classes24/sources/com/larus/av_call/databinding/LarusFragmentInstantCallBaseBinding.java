package com.larus.av_call.databinding;

import android.view.View;
import android.view.ViewStub;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusFragmentInstantCallBaseBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ViewStub b;
    public final ViewStub c;
    public final ViewStub d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentInstantCallBaseBinding(ConstraintLayout r1, ViewStub r2, ViewStub r3, ViewStub r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
