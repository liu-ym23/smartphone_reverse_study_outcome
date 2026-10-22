package com.bytedance.android.livesdk.gift.platform.core.giftlist;

import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class RevenueImageUrlService implements dy0.c, com.bytedance.android.scope.o {
    public static final /* synthetic */ int c = 0;
    public final Set<String> a;
    public final Lazy b;

    public static final class a {
        public a() {
        }

        public static final String a(String r10) {
            int r0 = RevenueImageUrlService.c;
            if (StringsKt.startsWith$default(r10, "https://p", false, 2, null) == true) goto L5;
            return null;
        L5:
            if (StringsKt.endsWith$default(r10, "~tplv-obj.image", false, 2, null) == false) goto L15;
            int r1 = (StringsKt.indexOf$default(r10, "-webcast.douyinpic.com/img/webcast/", 0, false, 6, null) + 35) - 8;
            int r2 = r10.length() - 15;
            if (r1 < 0) goto L14;
            if (r1 < r2) goto L12;
            return null;
        L12:
            return r10.substring(r1, r2);
        L14:
            return null;
        L15:
            return null;
        }

        public static String b(String r3, String r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r4, "imageSuffix");
            if (r3 != null) goto L5;
            return r3;
        L5:
            if (StringsKt.endsWith$default(r3, r4, false, 2, null) == true) goto L7;
            return r3;
        L7:
            if (((q) RevenueImageUrlServiceKt.c.getValue()).e() == false) goto L13;
            if (r5 == false) goto L12;
            return r3.substring(0, r3.length() - r4.length()) + "~tplv-dy-vqe2-live-gift-v1:156:q80.heic?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_wall";
        L12:
            return r3.substring(0, r3.length() - r4.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_rich";
        L13:
            if (r5 == false) goto L17;
            return r3.substring(0, r3.length() - r4.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_wall";
        L17:
            return r3.substring(0, r3.length() - r4.length()) + "~tplv-obj.webp?&biz_tag=aweme_webcast&sc=gift_icon&s=gift_rich";
        }

        public static /* synthetic */ String c(String r0, String r1, int r2) {
            if ((r2 & 2) == 0) goto L6;
            r1 = "~tplv-obj.image";
        L6:
            return b(r0, r1, false);
        }
    }

    static {
        new a();
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public RevenueImageUrlService() {
        this.a = new LinkedHashSet();
        this.b = LazyKt.lazy(new RevenueImageUrlService$urlConverters$2(this));
    }
}
