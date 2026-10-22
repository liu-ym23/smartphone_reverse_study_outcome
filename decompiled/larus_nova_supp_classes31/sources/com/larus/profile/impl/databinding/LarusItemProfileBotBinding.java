package com.larus.profile.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.larus.profile.impl.view.BotProfileView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class LarusItemProfileBotBinding implements ViewBinding {
    public final FrameLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemProfileBotBinding(FrameLayout r1) {
        this.a = r1;
    }

    public static LarusItemProfileBotBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562619, r3, false);
        if (((BotProfileView) ViewBindings.findChildViewById(r4, 2131364380)) == null) goto L7;
        return new LarusItemProfileBotBinding((FrameLayout) r4);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131364380)));
    }
}
