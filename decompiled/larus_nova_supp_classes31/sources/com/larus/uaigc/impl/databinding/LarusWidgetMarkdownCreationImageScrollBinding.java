package com.larus.uaigc.impl.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusWidgetMarkdownCreationImageScrollBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final RecyclerView b;
    public final ImageCardNestedScrollableHost c;

    public final View getRoot() {
        return this.a;
    }

    public LarusWidgetMarkdownCreationImageScrollBinding(ConstraintLayout r1, RecyclerView r2, ImageCardNestedScrollableHost r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
