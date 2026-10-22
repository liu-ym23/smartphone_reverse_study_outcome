package com.bytedance.android.live.componentsmarket.impl.components.anchorinfo;

import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.common.utility.UIUtils;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e<T> implements Observer {
    public final /* synthetic */ CommonMergeAnchorInfoWidget a;

    public e(CommonMergeAnchorInfoWidget r1) {
        this.a = r1;
    }

    public final void onChanged(Object r3) {
        py.k r4 = (py.k) r3;
        CommonMergeAnchorInfoWidget r0 = this.a;
        if (r4 == null) goto L5;
        ImageLoader.bindImage(r0.f, r4);
        UIUtils.setViewVisibility(r0.f, 0);
        return;
    L5:
        int r5 = CommonMergeAnchorInfoWidget.x;
        r0.getClass();
    }
}
