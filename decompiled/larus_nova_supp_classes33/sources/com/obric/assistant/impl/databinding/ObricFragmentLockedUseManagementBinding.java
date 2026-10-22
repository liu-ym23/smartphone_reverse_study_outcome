package com.obric.assistant.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFragmentLockedUseManagementBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final OFloatingTitleBar c;

    public final View getRoot() {
        return this.a;
    }

    public ObricFragmentLockedUseManagementBinding(ConstraintLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
