package com.larus.extension.chat_extension.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.common_ui.widget.UrlSpanTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class LarusItemLtmTitleBinding implements ViewBinding {
    public final LinearLayout a;
    public final ItemTextToggle b;
    public final UrlSpanTextView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemLtmTitleBinding(LinearLayout r1, ItemTextToggle r2, UrlSpanTextView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
