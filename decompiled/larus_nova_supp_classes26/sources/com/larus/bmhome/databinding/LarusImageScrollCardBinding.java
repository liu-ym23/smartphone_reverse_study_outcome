package com.larus.bmhome.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusImageScrollCardBinding implements ViewBinding {
    public final LinearLayout a;
    public final RecyclerView b;
    public final ImageCardNestedScrollableHost c;
    public final TextView d;

    public final View getRoot() {
        return this.a;
    }

    public LarusImageScrollCardBinding(LinearLayout r1, RecyclerView r2, ImageCardNestedScrollableHost r3, TextView r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
