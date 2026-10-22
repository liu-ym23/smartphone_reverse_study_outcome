package com.ss.android.lark.flow.feed.databinding;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.viewbinding.ViewBinding;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class FlowFeedBackgroundStatusBinding implements ViewBinding {
    public final RelativeLayout a;
    public final LinearLayout b;
    public final LinearLayout c;
    public final AppCompatImageView d;

    public final View getRoot() {
        return this.a;
    }

    public FlowFeedBackgroundStatusBinding(RelativeLayout r1, AppCompatButton r2, LinearLayout r3, LinearLayout r4, AppCompatImageView r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
