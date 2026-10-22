package com.larus.bmhome.utils;

import ewc.b;
import kotlin.jvm.internal.Intrinsics;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t2 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static String b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "htmlString");
        Document r3 = dwc.a.a(r2);
        r3.getClass();
        b.b("data-block");
        Element r4 = new org.jsoup.select.a(org.jsoup.select.e.j("data-block")).a(r3, r3);
        if (r4 != null) goto L5;
        return null;
    L5:
        return r4.d("type");
    }

    public static String a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "htmlString");
        Document r4 = dwc.a.a(r3);
        r4.getClass();
        b.b("data-block");
        Element r5 = new org.jsoup.select.a(org.jsoup.select.e.j("data-block")).a(r4, r4);
        if (r5 == null) goto L14;
        String r0 = r5.d("value_id");
        if (com.larus.utils.o0.d(r0) == false) goto L13;
        if (r2 == null) goto L10;
        wc8.b r1 = wc8.b.a;
        Intrinsics.checkNotNull(r0);
        String r6 = r1.c(r2, r0, "MarkdownWidgetUtil");
        if (r6 == null) goto L10;
        return r6;
    L10:
        wc8.b r7 = wc8.b.a;
        Intrinsics.checkNotNull(r0);
        return r7.b(r0, "MarkdownWidgetUtil");
    L13:
        return r5.d("value");
    L14:
        return null;
    }
}
