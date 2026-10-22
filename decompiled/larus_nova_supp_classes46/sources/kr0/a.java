package kr0;

import com.bytedance.android.live.openplatform.api.utils.e;
import kotlin.jvm.internal.Intrinsics;
import tb1.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class a {
    public static final String a = null;

    static {
        if (c.c == false) goto L5;
        String r0 = "ad_28001_live";
    L6:
        a = r0;
        return;
    L5:
        r0 = "ad_40001_live";
        goto L6
    }

    public static String a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "from");
        int r0 = r2.hashCode();
        if (r0 == 993236629) goto L27;
        if (r0 == 993512319) goto L19;
        if (r0 == 1050044054) goto L10;
    L35:
        return "live_mg_link";
    L10:
        if (r2.equals("mg_detail") == false) goto L35;
        if (e.b() == false) goto L15;
        return a + "_detail_dou+";
    L15:
        if (e.a() == true) goto L38;
        return "live_mg_detail";
    L38:
        return a + "_detail";
    L19:
        if (r2.equals("mg_link") == false) goto L35;
        if (e.b() == false) goto L24;
        return a + "_link_dou+";
    L24:
        if (e.a() == false) goto L35;
        return a + "_link";
    L27:
        if (r2.equals("mg_card") == false) goto L35;
        if (e.b() == false) goto L32;
        return a + "_card_dou+";
    L32:
        if (e.a() == true) goto L43;
        return "live_mg_card";
    L43:
        return a + "_card";
    }
}
