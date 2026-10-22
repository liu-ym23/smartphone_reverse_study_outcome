package com.bytedance.android.live.revlink.impl.pk.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class w {
    public static void a(SimpleDraweeView r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        Uri r3 = UriProtector.parse(r2);
        r1.setController(Fresco.newDraweeControllerBuilder().setUri(r3).setAutoPlayAnimations(true).build());
        return;
    }
}
