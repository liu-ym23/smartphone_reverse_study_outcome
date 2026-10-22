package com.larus.setting.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusPageSettingAccountInfoBinding implements ViewBinding {
    public final LinearLayout a;
    public final ItemGroup b;
    public final ItemTextArrow c;
    public final ItemTextArrow d;
    public final ItemTextView e;
    public final ItemTextView f;
    public final CardView g;

    public final View getRoot() {
        return this.a;
    }

    public LarusPageSettingAccountInfoBinding(LinearLayout r1, ItemGroup r2, NovaTitleBarEx r3, ItemTextArrow r4, ItemTextArrow r5, ItemTextView r6, ItemTextView r7, CardView r8) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
