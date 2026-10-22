package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
    }

    public static final File getRoot(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new File(getRootName(r1));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String r8) {
        int r0 = StringsKt.indexOf$default(r8, File.separatorChar, 0, false, 4, null);
        if (r0 != 0) goto L18;
        if (r8.length() <= 1) goto L16;
        char r1 = r8.charAt(1);
        char r3 = File.separatorChar;
        if (r1 != r3) goto L16;
        int r2 = StringsKt.indexOf$default(r8, r3, 2, false, 4, null);
        if (r2 < 0) goto L16;
        int r4 = StringsKt.indexOf$default(r8, File.separatorChar, r2 + 1, false, 4, null);
        if (r4 < 0) goto L15;
        return r4 + 1;
    L15:
        return r8.length();
    L16:
        return 1;
    L18:
        if (r0 <= 0) goto L24;
        if (r8.charAt(r0 - 1) != ':') goto L24;
        return r0 + 1;
    L24:
        if (r0 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (StringsKt.endsWith$default(r8, ':', false, 2, null) == false) goto L29;
        return r8.length();
    }

    public static final String getRootName(File r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        return r2.getPath().substring(0, getRootLength$FilesKt__FilePathComponentsKt(r2.getPath()));
    }

    public static final boolean isRooted(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (getRootLength$FilesKt__FilePathComponentsKt(r1.getPath()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final FilePathComponents toComponents(File r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        String r10 = r9.getPath();
        Intrinsics.checkNotNull(r10);
        int r0 = getRootLength$FilesKt__FilePathComponentsKt(r10);
        String r2 = r10.substring(0, r0);
        String r3 = r10.substring(r0);
        if (r3.length() != 0) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L8;
        List r12 = CollectionsKt.emptyList();
    L14:
        return new FilePathComponents(new File(r2), r12);
    L8:
        List r13 = StringsKt.split$default(r3, new char[]{File.separatorChar}, false, 0, 6, null);
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r13, 10));
        Iterator r14 = r13.iterator();
    L10:
        if (r14.hasNext() == false) goto L12;
        r1.add(new File((String) r14.next()));
        goto L10
    L12:
        r12 = r1;
        goto L14
    L5:
        r11 = false;
        goto L6
    }

    public static final File subPath(File r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return toComponents(r1).subPath(r2, r3);
    }
}
