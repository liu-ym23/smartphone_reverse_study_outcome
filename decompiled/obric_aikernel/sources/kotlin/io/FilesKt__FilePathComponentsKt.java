package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1549#2:149\n1620#2,3:150\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n133#1:149\n133#1:150,3\n*E\n"})
class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
    }

    public static final File getRoot(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new File(getRootName(r10));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String r10) {
        int r11 = StringsKt.indexOf$default(r10, File.separatorChar, 0, false, 4, null);
        if (r11 != 0) goto L18;
        if (r10.length() <= 1) goto L16;
        char r12 = r10.charAt(1);
        char r13 = File.separatorChar;
        if (r12 != r13) goto L16;
        int r14 = StringsKt.indexOf$default(r10, r13, 2, false, 4, null);
        if (r14 < 0) goto L16;
        int r15 = StringsKt.indexOf$default(r10, File.separatorChar, r14 + 1, false, 4, null);
        if (r15 < 0) goto L15;
        return r15 + 1;
    L15:
        return r10.length();
    L16:
        return 1;
    L18:
        if (r11 <= 0) goto L24;
        if (r10.charAt(r11 - 1) != ':') goto L24;
        return r11 + 1;
    L24:
        if (r11 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (StringsKt.endsWith$default(r10, ':', false, 2, null) == false) goto L29;
        return r10.length();
    }

    public static final String getRootName(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "path");
        String r12 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r12, "path");
        String r13 = r11.substring(0, getRootLength$FilesKt__FilePathComponentsKt(r12));
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        return r13;
    }

    public static final boolean isRooted(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "path");
        if (getRootLength$FilesKt__FilePathComponentsKt(r11) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final File subPath(File r10, int r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return toComponents(r10).subPath(r11, r12);
    }

    public static final FilePathComponents toComponents(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "path");
        int r12 = getRootLength$FilesKt__FilePathComponentsKt(r11);
        String r13 = r11.substring(0, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "this as java.lang.String…ing(startIndex, endIndex)");
        String r14 = r11.substring(r12);
        Intrinsics.checkNotNullExpressionValue(r14, "this as java.lang.String).substring(startIndex)");
        if (r14.length() != 0) goto L5;
        boolean r15 = true;
    L6:
        if (r15 == false) goto L8;
        List r16 = CollectionsKt.emptyList();
    L14:
        return new FilePathComponents(new File(r13), r16);
    L8:
        List r17 = StringsKt.split$default(r14, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r18 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r17, 10));
        Iterator r19 = r17.iterator();
    L10:
        if (r19.hasNext() == false) goto L12;
        r18.add(new File((String) r19.next()));
        goto L10
    L12:
        r16 = r18;
        goto L14
    L5:
        r15 = false;
        goto L6
    }
}
