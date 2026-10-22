package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.common_ui.view.ImageCardNestedScrollableHost;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusLayoutCreationHorizontalScrollViewBinding implements ViewBinding {
    public final ImageCardNestedScrollableHost a;
    public final RecyclerView b;

    public final View getRoot() {
        return this.a;
    }

    public static LarusLayoutCreationHorizontalScrollViewBinding a(LayoutInflater r3) {
        ImageCardNestedScrollableHost r4 = r3.inflate(2131562791, null, false);
        ImageCardNestedScrollableHost r0 = r4;
        RecyclerView r2 = ViewBindings.findChildViewById(r4, 2131384076);
        if (r2 == null) goto L7;
        return new LarusLayoutCreationHorizontalScrollViewBinding(r0, r2);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131384076)));
    }

    public LarusLayoutCreationHorizontalScrollViewBinding(ImageCardNestedScrollableHost r1, RecyclerView r2) {
        this.a = r1;
        this.b = r2;
    }
}
