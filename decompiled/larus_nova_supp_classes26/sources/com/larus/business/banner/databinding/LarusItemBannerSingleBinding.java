package com.larus.business.banner.databinding;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.viewbinding.ViewBinding;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class LarusItemBannerSingleBinding implements ViewBinding {
    public final RelativeLayout a;
    public final SimpleDraweeView b;

    public final View getRoot() {
        return this.a;
    }

    public LarusItemBannerSingleBinding(RelativeLayout r1, SimpleDraweeView r2) {
        this.a = r1;
        this.b = r2;
    }
}
