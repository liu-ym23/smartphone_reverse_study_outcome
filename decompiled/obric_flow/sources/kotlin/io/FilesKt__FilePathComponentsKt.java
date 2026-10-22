package kotlin.io;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nFilePathComponents.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,148:1\n1557#2:149\n1628#2,3:150\n*S KotlinDebug\n*F\n+ 1 FilePathComponents.kt\nkotlin/io/FilesKt__FilePathComponentsKt\n*L\n133#1:149\n133#1:150,3\n*E\n"})
class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
    }

    public static final File getRoot(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return new File(getRootName(r5));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String r5) {
        char r10 = File.separatorChar;
        int r11 = StringsKt.q(r5, r10, 0, 4);
        if (r11 != 0) goto L18;
        if (r5.length() > 1) goto L7;
    L16:
        return 1;
    L7:
        if (r5.charAt(1) != r10) goto L16;
        int r12 = StringsKt.q(r5, r10, 2, 4);
        if (r12 < 0) goto L16;
        int r13 = StringsKt.q(r5, r10, r12 + 1, 4);
        if (r13 < 0) goto L15;
        return r13 + 1;
    L15:
        return r5.length();
    L18:
        if (r11 <= 0) goto L24;
        if (r5.charAt(r11 - 1) != ':') goto L24;
        return r11 + 1;
    L24:
        if (r11 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (StringsKt.j(r5, ':') == false) goto L29;
        return r5.length();
    }

    public static final String getRootName(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return r5.getPath().substring(0, getRootLength$FilesKt__FilePathComponentsKt(r5.getPath()));
    }

    public static final boolean isRooted(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        if (getRootLength$FilesKt__FilePathComponentsKt(r5.getPath()) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final File subPath(File r5, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return toComponents(r5).subPath(r10, r11);
    }

    public static final FilePathComponents toComponents(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = r5.getPath();
        Intrinsics.checkNotNull(r10);
        int r11 = getRootLength$FilesKt__FilePathComponentsKt(r10);
        String r12 = r10.substring(0, r11);
        String r13 = r10.substring(r11);
        if (r13.length() != 0) goto L5;
        List r14 = CollectionsKt.emptyList();
    L11:
        return new FilePathComponents(new File(r12), r14);
    L5:
        List r15 = StringsKt.J(r13, new char[]{File.separatorChar}, 0, 6);
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator r17 = r15.iterator();
    L7:
        if (r17.hasNext() == false) goto L9;
        r16.add(new File((String) r17.next()));
        goto L7
    L9:
        r14 = r16;
        goto L11
    }
}
