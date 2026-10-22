package com.larus.uaigc.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import com.larus.uaigc.chat.markdown.placeholder.ShimmerTextPlaceHolderView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusWidgetMarkdownCreationTextPlaceholderBinding implements ViewBinding {
    public final ShimmerTextPlaceHolderView a;
    public final ShimmerTextPlaceHolderView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusWidgetMarkdownCreationTextPlaceholderBinding(ShimmerTextPlaceHolderView r1, ShimmerTextPlaceHolderView r2) {
        this.a = r1;
        this.b = r2;
    }

    public static LarusWidgetMarkdownCreationTextPlaceholderBinding a(LayoutInflater r2, ViewGroup r3, boolean r4) {
        View r5 = r2.inflate(2131563258, r3, false);
        if (r4 == false) goto L5;
        r3.addView(r5);
    L5:
        if (r5 == null) goto L9;
        ShimmerTextPlaceHolderView r6 = (ShimmerTextPlaceHolderView) r5;
        return new LarusWidgetMarkdownCreationTextPlaceholderBinding(r6, r6);
    L9:
        throw new NullPointerException("rootView");
    }
}
