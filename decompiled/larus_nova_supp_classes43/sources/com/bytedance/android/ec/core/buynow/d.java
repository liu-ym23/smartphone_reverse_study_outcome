package com.bytedance.android.ec.core.buynow;

import android.net.Uri;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String a(Uri r10) {
        if (r10 == null) goto L7;
        String r1 = UriProtector.getQueryParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r1 == null) goto L7;
        Boolean r11 = Boolean.valueOf(StringsKt.contains$default(r1, "ecommerce_buynow_yata/html/index.html", false, 2, null));
    L9:
        if (k.i(r11) == false) goto L12;
        return "yata_h5";
    L12:
        if (r10 == null) goto L14;
        String r12 = r10.getHost();
    L16:
        if (Intrinsics.areEqual(r12, "buy_now") == false) goto L19;
        return "yata_android";
    L19:
        return null;
    L14:
        r12 = null;
    L7:
        r11 = null;
        goto L9
    }

    public static void b(IOrderSchema r10) {
        Boolean r0 = null;
        if (r10 == null) goto L5;
        Boolean r1 = Boolean.valueOf(r10.Q0());
    L7:
        if (k.i(r1) == true) goto L13;
        if (r10 == null) goto L11;
        r0 = Boolean.valueOf(r10.u());
    L11:
        k.i(r0);
        return;
    L13:
        return;
    L5:
        r1 = null;
        goto L7
    }
}
