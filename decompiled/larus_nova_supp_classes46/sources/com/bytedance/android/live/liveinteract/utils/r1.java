package com.bytedance.android.live.liveinteract.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class r1 {
    public static void b(SimpleDraweeView r1, String r2) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        Uri r3 = UriProtector.parse(r2);
        r1.setController(Fresco.newDraweeControllerBuilder().setUri(r3).setAutoPlayAnimations(true).build());
        return;
    }

    public static void a(HSImageView r1, String r2, Boolean r3) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L9;
        Uri r4 = UriProtector.parse(r2);
        r1.setController(Fresco.newDraweeControllerBuilder().setUri(r4).setAutoPlayAnimations(r3.booleanValue()).build());
        return;
    }
}
