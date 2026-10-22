package com.larus.chat.gallery.impl.preview.datasource;

import com.larus.chat.gallery.api.PreviewMediaType;
import com.larus.chat.gallery.impl.preview.data.LocalMediaType;
import com.larus.chat.gallery.impl.preview.data.SourceType;
import com.larus.gallery.api.GalleryType;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class m {
    public static final xy8.d a(com.larus.chat.gallery.api.o r30, SourceType r31) {
        Intrinsics.checkNotNullParameter(r30, "<this>");
        Intrinsics.checkNotNullParameter(r31, "sourceType");
        boolean r4 = false;
        if (r30.getType() != PreviewMediaType.VIDEO) goto L5;
        boolean r1 = true;
    L6:
        n r2 = n.a;
        String r6 = r30.b;
        r2.getClass();
        String r10 = n.a(r6);
        String r3 = n.b(r30.d);
        String r7 = n.c(r30.b);
        if (r7 == null) goto L9;
    L10:
        r4 = true;
    L12:
        if (r4 == false) goto L14;
        String r5 = r10;
    L16:
        if (StringsKt.startsWith(r10, "content://", true) == false) goto L18;
        String r27 = r10;
    L19:
        String r8 = r30.a;
        if (r1 == false) goto L22;
        xy8.b r9 = null;
    L23:
        if (r1 == false) goto L25;
        xy8.g r12 = new xy8.g(r8, n.d(r30.b), null, r3, null, r7, null, null, null, r30.e, r30.f, r30.g / 1000.0d, null, null, r27, 29140);
    L26:
        if (r1 == false) goto L28;
        GalleryType r11 = GalleryType.Video;
    L29:
        GalleryType r13 = r11;
        Map r0 = MapsKt.mapOf(TuplesKt.to("preview_media_uri", r30.b));
        if (r5 != null) goto L32;
        xy8.c r19 = null;
    L38:
        return new xy8.d(r31, r8, r9, r12, r13, null, null, 0, r8, r0, null, null, null, null, null, r19, 0, 97504);
    L32:
        if (r1 == false) goto L34;
        LocalMediaType r14 = LocalMediaType.VIDEO;
    L35:
        r19 = new xy8.c(r14, r5, r7);
        goto L38
    L34:
        r14 = LocalMediaType.IMAGE;
        goto L35
    L28:
        r11 = GalleryType.Image;
        goto L29
    L25:
        r12 = null;
        goto L26
    L22:
        r9 = new xy8.b(r10, r3, r10, null, null, false, null, r30.e, r30.f, 248);
        goto L23
    L18:
        r27 = null;
        goto L19
    L14:
        r5 = null;
        goto L16
    L9:
        if (StringsKt.startsWith(r10, "content://", true) == false) goto L12;
    L5:
        r1 = false;
        goto L6
    }
}
