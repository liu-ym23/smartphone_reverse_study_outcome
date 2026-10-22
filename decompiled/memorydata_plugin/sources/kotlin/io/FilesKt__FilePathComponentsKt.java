package kotlin.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u0011\u0010\u000b\u001a\u00020\f*\u00020\bH\u0002¢\u0006\u0002\b\r\u001a\u001c\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0002*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\"\u0018\u0010\u0007\u001a\u00020\b*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0013"}, d2 = {"isRooted", "", "Ljava/io/File;", "(Ljava/io/File;)Z", "root", "getRoot", "(Ljava/io/File;)Ljava/io/File;", "rootName", "", "getRootName", "(Ljava/io/File;)Ljava/lang/String;", "getRootLength", "", "getRootLength$FilesKt__FilePathComponentsKt", "subPath", "beginIndex", "endIndex", "toComponents", "Lkotlin/io/FilePathComponents;", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__FilePathComponentsKt {
    public FilesKt__FilePathComponentsKt() {
    }

    public static final File getRoot(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return new File(FilesKt.getRootName(r1));
    }

    private static final int getRootLength$FilesKt__FilePathComponentsKt(String r9) {
        int r0 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), File.separatorChar, 0, false, 4, null);
        if (r0 != 0) goto L18;
        if (r9.length() > 1) goto L7;
    L16:
        return 1;
    L7:
        if (r9.charAt(1) != File.separatorChar) goto L16;
        int r1 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), File.separatorChar, 2, false, 4, null);
        if (r1 < 0) goto L16;
        int r2 = StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), File.separatorChar, r1 + 1, false, 4, null);
        if (r2 < 0) goto L15;
        return r2 + 1;
    L15:
        return r9.length();
    L18:
        if (r0 <= 0) goto L24;
        if (r9.charAt(r0 - 1) != ':') goto L24;
        return r0 + 1;
    L24:
        if (r0 == (-1)) goto L26;
    L29:
        return 0;
    L26:
        if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), ':', false, 2, null) == false) goto L29;
        return r9.length();
    }

    public static final String getRootName(File r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r0 = r2.getPath();
        Intrinsics.checkNotNullExpressionValue(r0, "getPath(...)");
        String r3 = r2.getPath();
        Intrinsics.checkNotNullExpressionValue(r3, "getPath(...)");
        String r4 = r0.substring(0, getRootLength$FilesKt__FilePathComponentsKt(r3));
        Intrinsics.checkNotNullExpressionValue(r4, "substring(...)");
        return r4;
    }

    public static final boolean isRooted(File r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        String r2 = r1.getPath();
        Intrinsics.checkNotNullExpressionValue(r2, "getPath(...)");
        if (getRootLength$FilesKt__FilePathComponentsKt(r2) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final File subPath(File r1, int r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        return FilesKt.toComponents(r1).subPath(r2, r3);
    }

    public static final FilePathComponents toComponents(File r11) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        String r12 = r11.getPath();
        Intrinsics.checkNotNull(r12);
        int r0 = getRootLength$FilesKt__FilePathComponentsKt(r12);
        String r2 = r12.substring(0, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "substring(...)");
        String r13 = r12.substring(r0);
        Intrinsics.checkNotNullExpressionValue(r13, "substring(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L8;
        List r14 = CollectionsKt.emptyList();
    L14:
        return new FilePathComponents(new File(r2), r14);
    L8:
        Iterable r15 = (Iterable) ZeusTransformUtils.preCheckCast(StringsKt.split$default((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.memorydata.plugin"), new char[]{File.separatorChar}, false, 0, 6, null), Iterable.class, "com.obric.memorydata.plugin");
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r15, 10)), Collection.class, "com.obric.memorydata.plugin");
        Iterator r16 = r15.iterator();
    L10:
        if (r16.hasNext() == false) goto L12;
        r3.add(new File((String) ZeusTransformUtils.preCheckCast(r16.next(), String.class, "com.obric.memorydata.plugin")));
        goto L10
    L12:
        r14 = (List) ZeusTransformUtils.preCheckCast(r3, List.class, "com.obric.memorydata.plugin");
        goto L14
    L5:
        r1 = false;
        goto L6
    }
}
