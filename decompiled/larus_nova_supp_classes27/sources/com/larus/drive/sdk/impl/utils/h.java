package com.larus.drive.sdk.impl.utils;

import com.larus.drive.biz.api.model.DriveFileType;
import com.larus.platform.api.FlowDriveFileType;
import com.larus.platform.model.OfficeAskDoubaoType;
import com.larus.platform.service.z2;
import com.ss.android.lark.picker.doubao.entity.condition.DoubaoDocType;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class h {
    public static a89.a a;
    public static final Lazy b = null;
    public static final List<Integer> c = null;
    public static final Set<DoubaoDocType> d = null;
    public static final Set<DoubaoDocType> e = null;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;
        public static final /* synthetic */ int[] b = null;

        static {
            int[] r0 = new int[OfficeAskDoubaoType.values().length];
            r0[OfficeAskDoubaoType.FILE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L28
        L64:
            r0[OfficeAskDoubaoType.DOC.ordinal()] = 2;     // Catch: NoSuchFieldError -> L29
        L74:
            r0[OfficeAskDoubaoType.PPT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L30
        L46:
            r0[OfficeAskDoubaoType.SHEET.ordinal()] = 4;     // Catch: NoSuchFieldError -> L31
        L48:
            r0[OfficeAskDoubaoType.BITABLE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L32
        L58:
            r0[OfficeAskDoubaoType.MINDNOTE.ordinal()] = 6;     // Catch: NoSuchFieldError -> L33
        L68:
            r0[OfficeAskDoubaoType.WIKI.ordinal()] = 7;     // Catch: NoSuchFieldError -> L34
        L16:
            a = r0;
            int[] r1 = new int[DriveFileType.values().length];
            r1[DriveFileType.AI_DOC.ordinal()] = 1;     // Catch: NoSuchFieldError -> L35
        L62:
            r1[DriveFileType.AI_SLIDES.ordinal()] = 2;     // Catch: NoSuchFieldError -> L36
        L72:
            r1[DriveFileType.AI_SHEET.ordinal()] = 3;     // Catch: NoSuchFieldError -> L37
        L44:
            r1[DriveFileType.BITABLE.ordinal()] = 4;     // Catch: NoSuchFieldError -> L38
        L50:
            r1[DriveFileType.MINDNOTE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L39
        L60:
            r1[DriveFileType.FOLDER.ordinal()] = 6;     // Catch: NoSuchFieldError -> L40
        L70:
            r1[DriveFileType.IMAGE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L41
        L56:
            r1[DriveFileType.AUDIO.ordinal()] = 8;     // Catch: NoSuchFieldError -> L42
        L66:
            r1[DriveFileType.VIDEO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L43
        L26:
            b = r1;
        }
    }

    static {
        a = new a89.a(false);
        b = LazyKt.lazy(new g());
        c = CollectionsKt.listOf(new Integer[]{0, 12, 22, 30, 3});
        d = SetsKt.setOf(new DoubaoDocType[]{DoubaoDocType.DOCX, DoubaoDocType.FILE, DoubaoDocType.SLIDES, DoubaoDocType.SHEET, DoubaoDocType.WIKI});
        e = SetsKt.setOf(new DoubaoDocType[]{DoubaoDocType.BITABLE, DoubaoDocType.MINDNOTE});
    }

    public static List a() {
        if (com.larus.platform.exp.i.a.a() == true) goto L5;
    L7:
        boolean r0 = false;
    L8:
        if (r0 == false) goto L11;
        return CollectionsKt.plus(c, CollectionsKt.listOf(new Integer[]{8, 113, 114}));
    L11:
        return c;
    L5:
        if (z2.a.getLarkBitableConfig().a() == false) goto L7;
        r0 = true;
        goto L8
    }

    public static FlowDriveFileType b(DriveFileType r1) {
        Intrinsics.checkNotNullParameter(r1, "fileType");
        int r2 = a.b[r1.ordinal()];
        if (r2 == 7) goto L12;
        if (r2 == 8) goto L15;
        if (r2 == 9) goto L14;
        return FlowDriveFileType.FILE;
    L14:
        return FlowDriveFileType.VIDEO;
    L15:
        return FlowDriveFileType.AUDIO;
    L12:
        return FlowDriveFileType.IMAGE;
    }
}
