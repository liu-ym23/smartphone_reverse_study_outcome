package com.larus.chat.gallery.impl.preview.toolbar;

import com.larus.chat.gallery.impl.preview.data.SourceType;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import sq9.a0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class f {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[SourceType.values().length];
            r0[SourceType.ALBUM.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[SourceType.ATTACHMENT.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r0[SourceType.CAMERA_RESULT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r0[SourceType.CLOUD_DRIVE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r0[SourceType.USER_SEND.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r0[SourceType.BOT_RESP.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r0[SourceType.CREATION_CARD.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r0[SourceType.CREATION_RECORD.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            a = r0;
        }
    }

    static {
    }

    public static e a(xy8.d r2, a0 r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "data");
        List r0 = null;
        if (r4 == false) goto L5;
    L22:
        int r5 = b.a;
        if (r3 == null) goto L27;
        List r6 = r3.c();
        if (r6 == null) goto L27;
        List r7 = CollectionsKt.filterNotNull(r6);
    L28:
        if (r7 != null) goto L30;
        r7 = CollectionsKt.emptyList();
    L30:
        if (r3 == null) goto L34;
        List r1 = r3.b();
        if (r1 == null) goto L34;
        List r8 = CollectionsKt.filterNotNull(r1);
    L35:
        if (r8 != null) goto L37;
        r8 = CollectionsKt.emptyList();
    L37:
        if (r3 == null) goto L41;
        List r9 = r3.a();
        if (r9 == null) goto L41;
        r0 = CollectionsKt.filterNotNull(r9);
    L41:
        if (r0 != null) goto L43;
        r0 = CollectionsKt.emptyList();
    L43:
        e r10 = new e(r7, r8, r0);
    L44:
        return r10;
    L34:
        r8 = null;
    L27:
        r7 = null;
        goto L28
    L5:
        if (r2.p == null) goto L22;
        switch(c.a[r2.a.ordinal()]) {
            case 1: goto L11;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L10;
            case 7: goto L10;
            case 8: goto L10;
            default: goto L9;
        };
    L10:
        boolean r11 = false;
    L12:
        if (r11 == true) goto L22;
        int r12 = a.a;
        List r13 = CollectionsKt.listOf(ToolbarButtonType.SHARE.getKey());
        List r14 = CollectionsKt.emptyList();
        if (r3 == null) goto L19;
        List r15 = r3.a();
        if (r15 == null) goto L19;
        r0 = CollectionsKt.filterNotNull(r15);
    L19:
        if (r0 != null) goto L21;
        r0 = CollectionsKt.emptyList();
    L21:
        r10 = new e(r13, r14, r0);
        goto L44
    L11:
        r11 = true;
        goto L12
    L9:
        throw new NoWhenBranchMatchedException();
    }
}
