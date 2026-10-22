package com.larus.suggest.impl.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemSuggestPromptEntryHolderBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemSuggestPromptEntryHolderBinding(LinearLayout r1, SimpleDraweeView r2, TextView r3) {
        this.a = r1;
        this.b = r3;
    }
}
