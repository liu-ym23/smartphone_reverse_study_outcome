package com.bytedance.android.livesdk.gift.banner;

import android.content.Context;
import com.bytedance.android.live.revenue.core.util.f;
import com.bytedance.android.livesdk.gift.model.b1;
import com.bytedance.android.livesdkapi.util.url.UrlBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import zg1.i2;
import zz0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class BannerGiftHelperKt {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Context r9, final b1 r10, Map r11) {
        Intrinsics.checkNotNullParameter(r10, "banner");
        if (r9 != null) goto L5;
        return;
    L5:
        int r0 = r10.getActionType();
        int r2 = 1;
        if (r0 != 1) goto L8;
        UrlBuilder r13 = new UrlBuilder(r10.getSchemaUrl());
        r13.addParam("title", r10.getTitle());
        f.a(g.class).S2(r9, r13.build());
        return;
    L8:
        if (r0 != 2) goto L10;
        UrlBuilder r14 = new UrlBuilder(r10.getSchemaUrl());
        py.d r1 = f.a(l01.d.class).b().getUserHonor();
        if (r1 != null) goto L16;
    L18:
        r2 = 0;
    L19:
        r14.addParam("is_first_consume", String.valueOf(r2));
        if (r11 == null) goto L27;
        HashMap r15 = (HashMap) r11;
        if (r15.size() <= 0) goto L27;
        Iterator r16 = r15.entrySet().iterator();
    L25:
        if (r16.hasNext() == false) goto L27;
        Map.Entry r3 = (Map.Entry) r16.next();
        r14.addParam((String) r3.getKey(), r3.getValue().toString());
    L27:
        int r6 = r10.getWidth();
        int r7 = r10.getHeight();
        xs2.b.a().post(new i2(r14.build(), "banner", 17, r6, r7, 2));
        return;
    L16:
        if (r1.getLevel() <= 0) goto L18;
    L10:
        if (r0 == 3) goto L12;
        UrlBuilder r17 = new UrlBuilder(r10.getSchemaUrl());
        r17.addParam("title", r10.getTitle());
        f.a(g.class).S2(r9, r17.build());
        return;
    L12:
        f.a(vy0.c.class).x6(r9, r10.getSchemaUrl(), new BannerGiftHelperKt$bannerClick$1(r10));
    }
}
