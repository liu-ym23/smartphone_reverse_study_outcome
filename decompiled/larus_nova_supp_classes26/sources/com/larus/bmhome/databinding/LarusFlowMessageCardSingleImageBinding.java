package com.larus.bmhome.databinding;

import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.plugin.image4.view.ImageViewWithLastMotion;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusFlowMessageCardSingleImageBinding implements ViewBinding {
    public final LinearLayout a;
    public final TextView b;
    public final ImageViewWithLastMotion c;
    public final FrameLayout d;

    public final View getRoot() {
        return this.a;
    }

    public LarusFlowMessageCardSingleImageBinding(LinearLayout r1, ViewStub r2, TextView r3, ImageViewWithLastMotion r4, FrameLayout r5) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
