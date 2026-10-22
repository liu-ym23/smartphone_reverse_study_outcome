package com.larus.avlink.gallery.processor;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class j {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static i a(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "fileName");
        Intrinsics.checkNotNullParameter(r3, "mediaType");
        boolean r4 = StringsKt.endsWith(r2, ".pack", true);
        if (r4 == true) goto L5;
    L7:
        if (r4 == false) goto L11;
        if (com.larus.avlink.gallery.j.c(r3) == false) goto L11;
    L16:
        return new VideoPackProcessor();
    L11:
        if (Intrinsics.areEqual(com.larus.avlink.gallery.j.d(r3), "video_mp4") == true) goto L16;
        return new DefaultProcessor();
    L5:
        if (com.larus.avlink.gallery.j.a(r3) == false) goto L7;
        return new ImagePackProcessor();
    }
}
