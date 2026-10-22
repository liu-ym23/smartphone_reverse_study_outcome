package com.larus.voice_setting.impl.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class LarusItemVoiceListCreateBinding implements ViewBinding {
    public final LinearLayout a;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemVoiceListCreateBinding(LinearLayout r1) {
        this.a = r1;
    }

    public static LarusItemVoiceListCreateBinding a(LayoutInflater r2, ViewGroup r3) {
        View r4 = r2.inflate(2131562699, r3, false);
        if (((TextView) ViewBindings.findChildViewById(r4, 2131368221)) == null) goto L7;
        return new LarusItemVoiceListCreateBinding((LinearLayout) r4);
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r4.getResources().getResourceName(2131368221)));
    }
}
