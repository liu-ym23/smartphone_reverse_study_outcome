package com.larus.profile.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusFragmentMineBotListBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LarusItemProfileBotListEmptyBinding b;
    public final RecyclerView c;
    public final LarusItemProfileUserBannedBinding d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentMineBotListBinding(ConstraintLayout r1, LarusItemProfileBotListEmptyBinding r2, RecyclerView r3, LarusItemProfileUserBannedBinding r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
