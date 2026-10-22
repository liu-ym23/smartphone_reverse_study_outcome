package com.larus.photopicker.v2.impl.data;

import com.larus.photopicker.v2.impl.data.model.MediaType;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c {
    public static final /* synthetic */ int c = 0;
    public final MediaType a;
    public final Long b;

    public static final class a {
    }

    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[MediaType.values().length];
            r0[MediaType.IMAGE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[MediaType.VIDEO.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            a = r0;
        }
    }

    static {
    }

    public final Pair<String, String[]> a() {
        if (this.a == null) goto L9;
        Long r0 = this.b;
        if (r0 == null) goto L9;
        if (r0.longValue() != (-1)) goto L9;
        return b(this.a);
    L9:
        MediaType r1 = this.a;
        if (r1 == null) goto L14;
        Long r3 = this.b;
        if (r3 == null) goto L14;
        return c(r1, r3.toString());
    L14:
        if (r1 != null) goto L28;
        Long r2 = this.b;
        if (r2 != null) goto L19;
    L21:
        Long r4 = this.b;
        if (r4 == null) goto L25;
        return c(null, r4.toString());
    L25:
        return b(null);
    L19:
        if (r2.longValue() != (-1)) goto L21;
        return b(null);
    L28:
        return b(r1);
    }

    public static Pair b(MediaType r9) {
        if (r9 != null) goto L4;
        int r10 = -1;
    L6:
        if (r10 != 1) goto L8;
        List r11 = CollectionsKt.listOf("1");
    L13:
        return new Pair(CollectionsKt.joinToString$default(r11, " OR ", null, null, 0, null, new com.larus.photopicker.v2.impl.data.b(), 30, null), r11.toArray(new String[0]));
    L8:
        if (r10 == 2) goto L10;
        r11 = CollectionsKt.listOf(new String[]{"1", "3"});
        goto L13
    L10:
        r11 = CollectionsKt.listOf("3");
        goto L13
    L4:
        r10 = b.a[r9.ordinal()];
        goto L6
    }

    public c(MediaType r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }

    public static Pair c(MediaType r4, String r5) {
        Pair r6 = b(r4);
        return new Pair("(" + ((String) r6.component1()) + ") AND bucket_id = ?", ArraysKt.plus((String[]) r6.component2(), new String[]{r5}));
    }
}
