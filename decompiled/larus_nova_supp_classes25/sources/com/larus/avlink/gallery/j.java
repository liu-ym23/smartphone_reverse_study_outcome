package com.larus.avlink.gallery;

import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static boolean a(String r4) {
        return StringsKt.contains$default(d(r4), "image", false, 2, null);
    }

    public static boolean b(String r4) {
        return StringsKt.contains$default(d(r4), "pack", false, 2, null);
    }

    public static boolean c(String r4) {
        return StringsKt.contains$default(d(r4), "video", false, 2, null);
    }

    public static String d(String r1) {
        if (r1 == null) goto L6;
        String r2 = StringsKt.trim(r1).toString();
        if (r2 == null) goto L6;
        String r3 = r2.toLowerCase(Locale.ROOT);
    L7:
        if (r3 != null) goto L10;
        return "";
    L10:
        return r3;
    L6:
        r3 = null;
        goto L7
    }

    public static String e(String r2) {
        if (Intrinsics.areEqual(d(r2), "live_photo") == false) goto L6;
    L7:
        return "image";
    L6:
        if (a(r2) == true) goto L7;
        if (c(r2) == false) goto L12;
    L13:
        return "video";
    L12:
        if (Intrinsics.areEqual(d(r2), "video_mp4") == true) goto L13;
        return "unknown";
    }
}
