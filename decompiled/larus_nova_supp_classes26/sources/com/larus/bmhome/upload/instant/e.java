package com.larus.bmhome.upload.instant;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.platform.model.upload.UploadDataType;
import java.security.MessageDigest;
import java.util.Map;
import java.util.SortedMap;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import mr9.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class e {

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[UploadDataType.values().length];
            r0[UploadDataType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UploadDataType.IMAGE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UploadDataType.VIDEO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UploadDataType.UNCLEAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            a = r0;
        }
    }

    static {
    }

    public static c a(j r17) {
        Intrinsics.checkNotNullParameter(r17, "param");
        String r1 = r17.p;
        boolean r2 = false;
        int r3 = 1;
        Integer r4 = null;
        if (r1 != null) goto L5;
    L17:
        boolean r5 = false;
    L18:
        if (r5 == false) goto L20;
        return null;
    L20:
        mr9.c r6 = r17.r;
        if (r6 != null) goto L38;
        int r7 = a.a[r17.c.ordinal()];
        if (r7 == 1) goto L34;
        if (r7 != 2) goto L26;
        String r8 = "image_identity";
    L35:
        r6 = new mr9.c(r8, MapsKt.mapOf(new Pair[]{TuplesKt.to("data_type", r17.c.getType()), TuplesKt.to("transform", "identity")}), 2);
    L36:
        if (r6 != null) goto L38;
        return null;
    L26:
        if (r7 != 3) goto L28;
        r8 = "video_identity";
        goto L35
    L28:
        if (r7 != 4) goto L31;
        r6 = null;
        goto L36
    L31:
        throw new NoWhenBranchMatchedException();
    L34:
        r8 = "file_identity";
    L38:
        String r0 = r6.a;
        if (r0 != null) goto L41;
    L60:
        return null;
    L41:
        if ((!StringsKt.isBlank(r0)) == true) goto L44;
        r0 = null;
    L44:
        if (r0 == null) goto L60;
        Map r9 = r6.c;
        if (r9 != null) goto L49;
        r9 = MapsKt.emptyMap();
    L49:
        SortedMap r10 = MapsKt.toSortedMap(r9);
        ImageInstantUploadHash r11 = ImageInstantUploadHash.a;
        String r12 = CollectionsKt.joinToString$default(r10.entrySet(), ";", null, null, 0, null, new d(), 30, null);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, ShareType.TEXT);
        String r13 = StringsKt.take(ArraysKt.joinToString$default(MessageDigest.getInstance("SHA-256").digest(r12.getBytes(Charsets.UTF_8)), "", null, null, 0, null, new com.larus.bmhome.upload.instant.a(), 30, null), 16);
        Integer r14 = r6.b;
        if (r14 == null) goto L59;
        if (r14.intValue() <= 0) goto L54;
        r2 = true;
    L54:
        if (r2 == false) goto L56;
        r4 = r14;
    L56:
        if (r4 == null) goto L59;
        r3 = r4.intValue();
    L59:
        return new c(r0, r13, Integer.valueOf(r3), r10);
    L5:
        if ((!StringsKt.isBlank(r1)) == true) goto L8;
        r1 = null;
    L8:
        if (r1 == null) goto L17;
        if (r17.c != UploadDataType.IMAGE) goto L17;
        if (r17.r != null) goto L17;
        if (Intrinsics.areEqual(r1, r17.a) == true) goto L17;
        r5 = true;
        goto L18
    }
}
