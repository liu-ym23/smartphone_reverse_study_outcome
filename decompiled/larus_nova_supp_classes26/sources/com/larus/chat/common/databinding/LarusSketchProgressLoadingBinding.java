package com.larus.chat.common.databinding;

import android.view.View;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import com.larus.bmhome.chat.layout.holder.progressloading.ImageWebpLoadingBgView;
import com.larus.bmhome.chat.layout.holder.progressloading.RadiusCardView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusSketchProgressLoadingBinding implements ViewBinding {
    public final RadiusCardView a;
    public final TextView b;
    public final TextView c;
    public final ImageWebpLoadingBgView d;
    public final LottieAdapterView e;

    public final View getRoot() {
        return this.a;
    }

    public LarusSketchProgressLoadingBinding(RadiusCardView r1, TextView r2, TextView r3, ImageWebpLoadingBgView r4, LottieAdapterView r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }
}
