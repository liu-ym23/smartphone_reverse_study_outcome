package com.larus.uaigc.createpage.component.stylelist;

import com.bytedance.keva.Keva;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import zd9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final Keva a = null;

    static {
        a = Keva.getRepo("ImageStyleListCache", 0);
    }

    public static void a(ImageStyleRecommendApi.ImageStyleRecommendResponse r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "languageCode");
        if (r4 == null) goto L17;
        List<ImageStyleRecommendApi.ImageStyle> r1 = r4.getStyleList();
        if (r1 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == true) goto L17;
        FLogger.a.i("ImageStyleListCache", "saveImageStyleList");
        Keva r3 = a;
        String r6 = "image_style_list_resp_" + r5;
        h.a.getClass();
        String r7 = h.c(r4);
        if (r7 != null) goto L16;
        r7 = "";
    L16:
        r3.storeString(r6, r7);
        return;
    L7:
        if (r1.isEmpty() == true) goto L10;
        r2 = false;
    L17:
        a.erase("image_style_list_resp_" + r5);
    }
}
