package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class d4 {
    public static boolean a(Context r3) {
        if (r3 != null) goto L6;
        return false;
    L6:
        if ((r3 instanceof Activity) == false) goto L8;
        Activity r4 = (Activity) r3;
        if (r4.isDestroyed() == false) goto L18;
        return false;
    L18:
        return !r4.isFinishing();
    L8:
        if ((r3 instanceof Application) == false) goto L10;
    L13:
        return true;
    L10:
        if ((r3 instanceof ContextWrapper) == false) goto L13;
        return a(((ContextWrapper) r3).getBaseContext());
    }

    public static void b(SmartImageView r3, ImageModel r4) {
        if (a(r3.getContext()) == true) goto L6;
        return;
    L6:
        if (r4 != null) goto L8;
        ef6.a r1 = null;
    L9:
        df6.u r5 = df6.q.c(r1);
        r5.c = r3.getContext();
        r5.n = ScaleType.CENTER_CROP;
        CircleOptions.a r2 = new CircleOptions.a();
        r2.a = true;
        r5.o = new CircleOptions(r2);
        r5.b("SmartImageLoadUtils");
        r5.i = 2131250965;
        r5.u = r3;
        r5.d(null);
        return;
    L8:
        r1 = new ef6.a(r4.getUrls());
        goto L9
    }
}
