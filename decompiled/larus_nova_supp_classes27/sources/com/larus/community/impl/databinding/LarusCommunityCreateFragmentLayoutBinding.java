package com.larus.community.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.community.impl.view.CommunityCreateButton;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusCommunityCreateFragmentLayoutBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CommunityCreateButton b;
    public final FrameLayout c;
    public final NovaTitleBarEx d;

    public final View getRoot() {
        return this.a;
    }

    public LarusCommunityCreateFragmentLayoutBinding(ConstraintLayout r1, CommunityCreateButton r2, FrameLayout r3, NovaTitleBarEx r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
