package com.larus.agents.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusFragmentOfficeTaskSettingsBinding implements ViewBinding {
    public final LinearLayout a;
    public final ItemTextArrow b;
    public final ItemGroup c;
    public final NovaTitleBarEx d;
    public final ItemTextArrow e;

    public final View getRoot() {
        return this.a;
    }

    public LarusFragmentOfficeTaskSettingsBinding(LinearLayout r1, ItemTextArrow r2, ItemGroup r3, NovaTitleBarEx r4, ItemTextArrow r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
