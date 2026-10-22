package com.bytedance.android.live.componentsmarket.impl.components.titledetail;

import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Consumer {
    public final /* synthetic */ LiveTitleDetailWidget a;

    public e(LiveTitleDetailWidget r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        sh6.b r4 = (sh6.b) r3;
        FrameLayout.LayoutParams r5 = new FrameLayout.LayoutParams(s1.y(), s1.w());
        ((Widget) this.a).contentView.setLayoutParams(r5);
        ((Widget) this.a).contentView.post(new d(this));
    }
}
