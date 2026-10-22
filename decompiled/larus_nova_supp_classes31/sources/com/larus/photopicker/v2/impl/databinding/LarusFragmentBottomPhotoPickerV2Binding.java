package com.larus.photopicker.v2.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentBottomPhotoPickerV2Binding implements ViewBinding {
    public final FrameLayout a;
    public final FrameLayout b;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentBottomPhotoPickerV2Binding(FrameLayout r1, FrameLayout r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusFragmentBottomPhotoPickerV2Binding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562352, r3, false);
        if (r4 == null) goto L7;
        FrameLayout r5 = (FrameLayout) r4;
        return new LarusFragmentBottomPhotoPickerV2Binding(r5, r5);
    L7:
        throw new NullPointerException("rootView");
    }
}
