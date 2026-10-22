package com.obric.assistant.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextArrow;
import com.larus.bmhome.view.item.ItemTextView;
import com.obric.assistant.common.ui.item.ObricItemTextArrowSubTitle;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class ObricFragmentChatSettingBinding implements ViewBinding {
    public final LinearLayout a;
    public final ItemGroup b;
    public final ItemGroup c;
    public final ItemTextArrow d;
    public final ItemTextView e;
    public final ObricItemTextArrowSubTitle f;

    public final View getRoot() {
        return this.a;
    }

    public ObricFragmentChatSettingBinding(LinearLayout r1, ItemGroup r2, ItemGroup r3, ItemTextArrow r4, ItemTextView r5, ObricItemTextArrowSubTitle r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }
}
