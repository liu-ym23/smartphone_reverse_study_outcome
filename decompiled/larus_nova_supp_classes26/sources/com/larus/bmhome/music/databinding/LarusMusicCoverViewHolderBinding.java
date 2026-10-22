package com.larus.bmhome.music.databinding;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;
import com.lynx.lottieadapter.LottieAdapterView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusMusicCoverViewHolderBinding implements ViewBinding {
    public final ConstraintLayout a;
    public final LottieAdapterView b;
    public final SimpleDraweeView c;

    public final View getRoot() {
        return this.a;
    }

    public LarusMusicCoverViewHolderBinding(ConstraintLayout r1, LottieAdapterView r2, SimpleDraweeView r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
