package com.larus.drive.sdk.impl.utils;

import com.larus.bmhome.auth.LaunchInfo;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.api.e0;
import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.drive.sdk.api.file.DriveFileItem;
import java.util.Locale;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[DriveFileType.values().length];
            r0[DriveFileType.AI_SHEET.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L49:
            r0[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L59:
            r0[DriveFileType.AI_DOC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L21
        L37:
            r0[DriveFileType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L22
        L39:
            r0[DriveFileType.MINDNOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L23
        L45:
            r0[DriveFileType.PPT.ordinal()] = 6;     // Catch: NoSuchFieldError -> L24
        L55:
            r0[DriveFileType.DOC.ordinal()] = 7;     // Catch: NoSuchFieldError -> L25
        L41:
            r0[DriveFileType.XLS.ordinal()] = 8;     // Catch: NoSuchFieldError -> L26
        L51:
            r0[DriveFileType.IMAGE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L27
        L53:
            r0[DriveFileType.AUDIO.ordinal()] = 10;     // Catch: NoSuchFieldError -> L28
        L35:
            r0[DriveFileType.VIDEO.ordinal()] = 11;     // Catch: NoSuchFieldError -> L29
        L47:
            r0[DriveFileType.CODE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L30
        L57:
            r0[DriveFileType.ZIP.ordinal()] = 13;     // Catch: NoSuchFieldError -> L31
        L33:
            r0[DriveFileType.FOLDER.ordinal()] = 14;     // Catch: NoSuchFieldError -> L32
        L17:
            a = r0;
        }
    }

    static {
    }

    public static String f() {
        e0 r0 = (e0) AuthModelDelegate.b.e().getValue();
        if (r0 == null) goto L7;
        LaunchInfo r1 = r0.a;
        if (r1 == null) goto L7;
        return r1.W();
    L7:
        return null;
    }

    public static String d(DriveFileItem r2) {
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
        if (r1 != 4) goto L11;
        return "base";
    L11:
        if (r1 != 5) goto L13;
        return "mindnote";
    L13:
        if (r1 != 14) goto L22;
        return "folder";
    L22:
        return r2.d(false).toLowerCase(Locale.ROOT);
    }

    public static String e(DriveFileType r1) {
        Intrinsics.checkNotNullParameter(r1, "fileType");
        switch(a.a[r1.ordinal()]) {
            case 1: goto L17;
            case 2: goto L16;
            case 3: goto L15;
            case 4: goto L14;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L11;
            case 8: goto L10;
            case 9: goto L9;
            case 10: goto L8;
            case 11: goto L8;
            case 12: goto L7;
            case 13: goto L6;
            case 14: goto L5;
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
        return "mindnote";
    L14:
        return "base";
    L15:
        return "aidoc";
    L16:
        return "aippt_new";
    L17:
        return "aisheet";
    }

    public static DriveFileType a(Integer r2, String r3) {
        if (r2 != null) goto L5;
    L7:
        if (r2 != null) goto L10;
    L12:
        if (r2 != null) goto L15;
    L17:
        if (r2 != null) goto L20;
    L22:
        if (r2 != null) goto L25;
    L27:
        DriveFileType.Companion.getClass();
        return DriveFileType.a.b(r3);
    L25:
        if (r2.intValue() != 11) goto L27;
        return DriveFileType.MINDNOTE;
    L20:
        if (r2.intValue() != 8) goto L22;
        return DriveFileType.BITABLE;
    L15:
        if (r2.intValue() != 3) goto L17;
        return DriveFileType.AI_SHEET;
    L10:
        if (r2.intValue() != 30) goto L12;
        return DriveFileType.AI_SLIDES;
    L5:
        if (r2.intValue() != 22) goto L7;
        return DriveFileType.AI_DOC;
    }

    public static DriveFileType b(Long r5, String r6) {
        if (r5 != null) goto L5;
    L7:
        if (r5 != null) goto L10;
    L12:
        if (r5 != null) goto L15;
    L17:
        if (r5 != null) goto L20;
    L22:
        if (r5 != null) goto L25;
    L27:
        DriveFileType.Companion.getClass();
        return DriveFileType.a.b(r6);
    L25:
        if (r5.longValue() != 11) goto L27;
        return DriveFileType.MINDNOTE;
    L20:
        if (r5.longValue() != 8) goto L22;
        return DriveFileType.BITABLE;
    L15:
        if (r5.longValue() != 3) goto L17;
        return DriveFileType.AI_SHEET;
    L10:
        if (r5.longValue() != 30) goto L12;
        return DriveFileType.AI_SLIDES;
    L5:
        if (r5.longValue() != 22) goto L7;
        return DriveFileType.AI_DOC;
    }

    public static String c(DriveFileType r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "fileType");
        Intrinsics.checkNotNullParameter(r9, "fileName");
        int r10 = a.a[r8.ordinal()];
        if (r10 != 1) goto L5;
        return "aisheet";
    L5:
        if (r10 != 2) goto L7;
        return "aippt_new";
    L7:
        if (r10 != 3) goto L9;
        return "aidoc";
    L9:
        if (r10 != 4) goto L11;
        return "base";
    L11:
        if (r10 != 5) goto L13;
        return "mindnote";
    L13:
        if (r10 == 14) goto L21;
        int r11 = StringsKt.lastIndexOf$default(r9, '.', 0, false, 6, null);
        if (r11 > 0) goto L17;
    L19:
        String r12 = "";
    L28:
        return r12.toLowerCase(Locale.ROOT);
    L17:
        if (r11 >= (r9.length() - 1)) goto L19;
        r12 = r9.substring(r11 + 1);
        goto L28
    L21:
        return "folder";
    }
}
