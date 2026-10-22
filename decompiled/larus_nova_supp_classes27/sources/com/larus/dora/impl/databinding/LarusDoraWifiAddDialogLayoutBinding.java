package com.larus.dora.impl.databinding;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.view.item.ItemGroupTitle;
import com.larus.dora.impl.view.DoraTextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class LarusDoraWifiAddDialogLayoutBinding implements ViewBinding {
    public final LinearLayout a;
    public final DoraTextView b;
    public final DoraTextView c;
    public final ProgressBar d;
    public final AppCompatEditText e;
    public final ImageView f;
    public final ItemGroupTitle g;

    public final View getRoot() {
        return this.a;
    }

    public LarusDoraWifiAddDialogLayoutBinding(LinearLayout r1, DoraTextView r2, DoraTextView r3, ProgressBar r4, AppCompatEditText r5, ImageView r6, ItemGroupTitle r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
