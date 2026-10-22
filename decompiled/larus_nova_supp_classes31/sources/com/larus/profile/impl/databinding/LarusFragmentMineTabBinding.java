package com.larus.profile.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.CreateBotButton;
import com.larus.profile.impl.view.MineTabTitleBar;
import com.larus.profile.impl.view.ProfileInfoView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentMineTabBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final CreateBotButton b;
    public final FrameLayout c;
    public final ProfileInfoView d;
    public final MineTabTitleBar e;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMineTabBinding(ConstraintLayout r1, CreateBotButton r2, FrameLayout r3, ProfileInfoView r4, MineTabTitleBar r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
