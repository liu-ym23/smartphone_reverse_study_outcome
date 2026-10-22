package com.larus.dora.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextSelector;
import com.larus.bmhome.view.item.ItemTextSelectorSubTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraPageChatSettingsBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final ItemTextSelector b;
    public final ItemTextSelectorSubTitle c;
    public final ItemTextSelectorSubTitle d;
    public final ItemGroup e;
    public final View f;
    public final NovaTitleBarEx g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraPageChatSettingsBinding(ConstraintLayout r1, ItemTextSelector r2, ItemTextSelectorSubTitle r3, ItemTextSelectorSubTitle r4, ItemGroup r5, View r6, NovaTitleBarEx r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
