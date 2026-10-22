package com.larus.drive.biz.impl.utils;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class e {
    public static String a;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.AI_SHEET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L35:
            r0[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L51:
            r0[DriveFileType.AI_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L39:
            r0[DriveFileType.PPT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L43:
            r0[DriveFileType.DOC.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L29:
            r0[DriveFileType.XLS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L45:
            r0[DriveFileType.IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L47:
            r0[DriveFileType.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L37:
            r0[DriveFileType.VIDEO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[DriveFileType.CODE.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L31:
            r0[DriveFileType.ZIP.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L33:
            r0[DriveFileType.FOLDER.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L15:
            a = r0;
        }
    }

    static {
        a = "other";
    }

    public static String a(com.larus.drive.biz.api.model.a r9) {
        Intrinsics.checkNotNullParameter(r9, "file");
        int r0 = a.a[r9.d.ordinal()];
        if (r0 != 1) goto L5;
        return "aisheet";
    L5:
        if (r0 != 2) goto L7;
        return "aippt_new";
    L7:
        if (r0 != 3) goto L9;
        return "aidoc";
    L9:
        if (r0 == 12) goto L17;
        int r1 = StringsKt.lastIndexOf$default(r9.c, '.', 0, false, 6, null);
        if (r1 > 0) goto L13;
    L15:
        String r10 = "";
    L22:
        return r10.toLowerCase(Locale.ROOT);
    L13:
        if (r1 >= (r9.c.length() - 1)) goto L15;
        r10 = r9.c.substring(r1 + 1);
        goto L22
    L17:
        return "folder";
    }

    public static String b(DriveFileItem r2) {
        Intrinsics.checkNotNullParameter(r2, "file");
        DriveFileType r0 = r2.j;
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L5;
        return "aisheet";
    L5:
        if (r1 != 2) goto L7;
        return "aippt_new";
    L7:
        if (r1 != 3) goto L9;
        return "aidoc";
    L9:
        if (r1 != 12) goto L16;
        return "folder";
    L16:
        return r2.d(false).toLowerCase(Locale.ROOT);
    }

    public static String c(DriveFileType r1) {
        Intrinsics.checkNotNullParameter(r1, "fileType");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L15;
            case 2: goto L14;
            case 3: goto L13;
            case 4: goto L12;
            case 5: goto L11;
            case 6: goto L10;
            case 7: goto L9;
            case 8: goto L8;
            case 9: goto L8;
            case 10: goto L7;
            case 11: goto L6;
            case 12: goto L5;
            default: goto L4;
        };
    L4:
        return "other_file";
    L5:
        return "folder";
    L6:
        return "zip";
    L7:
        return "code";
    L8:
        return "media";
    L9:
        return "image";
    L10:
        return "sheet";
    L11:
        return "writing_doc";
    L12:
        return "ppt";
    L13:
        return "aidoc";
    L14:
        return "aippt_new";
    L15:
        return "aisheet";
    }
}
