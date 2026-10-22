package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFragmentSettingBinding implements ViewBinding {
    public final FrameLayout a;
    public final RecyclerView b;
    public final OFloatingTitleBar c;

    public final View getRoot() {
        return this.a;
    }

    public ObricFragmentSettingBinding(FrameLayout r1, RecyclerView r2, OFloatingTitleBar r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
