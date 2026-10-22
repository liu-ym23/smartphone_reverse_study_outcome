package kotlin.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1284#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public FilesKt__UtilsKt() {
    }

    public static final boolean copyRecursively(File r11, File r12, boolean r13, final Function2<? super File, ? super IOException, ? extends OnErrorAction> r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r14, "onError");
        if (r11.exists() == false) goto L5;
        Iterator<File> r10 = FilesKt.walkTopDown(r11).onFail(new AnonymousClass2(r14)).iterator();     // Catch: TerminateException -> L47
    L10:
        if (r10.hasNext() == false) goto L46;
        File r15 = r10.next();     // Catch: TerminateException -> L47
        if (r15.exists() == false) goto L15;
        File r16 = new File(r12, toRelativeString(r15, r11));     // Catch: TerminateException -> L47
        if (r16.exists() == false) goto L39;
        if (r15.isDirectory() == true) goto L22;
    L23:
        if (r13 == true) goto L26;
    L24:
        boolean r17 = true;
    L34:
        if (r17 == false) goto L39;
        if (r14.invoke(r16, new FileAlreadyExistsException(r15, r16, "The destination file already exists.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L26:
        if (r16.isDirectory() == false) goto L31;
        if (FilesKt.deleteRecursively(r16) == false) goto L24;
    L33:
        r17 = false;
        goto L34
    L31:
        if (r16.delete() == true) goto L33;
    L22:
        if (r16.isDirectory() == false) goto L23;
    L39:
        if (r15.isDirectory() == true) goto L40;
        if (copyTo$default(r15, r16, r13, 0, 4, null).length() == r15.length()) goto L10;
        if (r14.invoke(r15, new IOException("Source file wasn't copied completely, length of destination file differs.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L40:
        r16.mkdirs();     // Catch: TerminateException -> L47
        goto L10
    L15:
        if (r14.invoke(r15, new NoSuchFileException(r15, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L46:
        return true;
    L47:
        return false;
    L5:
        if (r14.invoke(r11, new NoSuchFileException(r11, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) goto L8;
        return true;
    L8:
        return false;
    }

    public static /* synthetic */ boolean copyRecursively$default(File r10, File r11, boolean r12, Function2 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = AnonymousClass1.INSTANCE;
    L9:
        return copyRecursively(r10, r11, r12, r13);
    }

    public static final File copyTo(File r10, File r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r10.exists() == false) goto L42;
        if (r11.exists() == false) goto L15;
        if (r12 == false) goto L13;
        if (r11.delete() == true) goto L15;
        throw new FileAlreadyExistsException(r10, r11, "Tried to overwrite the destination, but failed to delete it.");
    L13:
        throw new FileAlreadyExistsException(r10, r11, "The destination file already exists.");
    L15:
        if (r10.isDirectory() == true) goto L17;
        File r14 = r11.getParentFile();
        if (r14 == null) goto L24;
        r14.mkdirs();
    L24:
        FileInputStream r15 = new FileInputStream(r10);
        FileOutputStream r16 = new FileOutputStream(r11);     // Catch: Throwable -> L36
        ByteStreamsKt.copyTo(r15, r16, r13);     // Catch: Throwable -> L31
    L28:
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r15, null);
    L30:
        return r11;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L17:
        if (r11.mkdirs() == true) goto L30;
        throw new FileSystemException(r10, r11, "Failed to create target directory.");
    L42:
        throw new NoSuchFileException(r10, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File copyTo$default(File r10, File r11, boolean r12, int r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = false;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r13 = 8192;
    L9:
        return copyTo(r10, r11, r12, r13);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String r10, String r11, File r12) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        File r13 = File.createTempFile(r10, r11, r12);
        r13.delete();
        if (r13.mkdir() == false) goto L7;
        Intrinsics.checkNotNullExpressionValue(r13, "dir");
        return r13;
    L7:
        throw new IOException("Unable to create temporary directory " + r13 + '.');
    }

    public static /* synthetic */ File createTempDir$default(String r10, String r11, File r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "tmp";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return createTempDir(r10, r11, r12);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String r10, String r11, File r12) {
        Intrinsics.checkNotNullParameter(r10, "prefix");
        File r13 = File.createTempFile(r10, r11, r12);
        Intrinsics.checkNotNullExpressionValue(r13, "createTempFile(prefix, suffix, directory)");
        return r13;
    }

    public static /* synthetic */ File createTempFile$default(String r10, String r11, File r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = "tmp";
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = null;
    L12:
        return createTempFile(r10, r11, r12);
    }

    public static boolean deleteRecursively(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Iterator<File> r11 = FilesKt__FileTreeWalkKt.walkBottomUp(r10).iterator();
    L3:
        boolean r12 = true;
    L5:
        if (r11.hasNext() == false) goto L13;
        File r13 = r11.next();
        if (r13.delete() == true) goto L10;
        if (r13.exists() == false) goto L10;
    L12:
        r12 = false;
    L10:
        if (r12 == false) goto L12;
    L13:
        return r12;
    }

    public static final boolean endsWith(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        FilePathComponents r12 = FilesKt__FilePathComponentsKt.toComponents(r10);
        FilePathComponents r13 = FilesKt__FilePathComponentsKt.toComponents(r11);
        if (r13.isRooted() == true) goto L5;
        int r14 = r12.getSize() - r13.getSize();
        if (r14 >= 0) goto L10;
        return false;
    L10:
        return r12.getSegments().subList(r14, r12.getSize()).equals(r13.getSegments());
    L5:
        return Intrinsics.areEqual(r10, r11);
    }

    public static final boolean endsWith(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return endsWith(r10, new File(r11));
    }

    public static final String getExtension(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
        return StringsKt.substringAfterLast(r11, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (File.separatorChar == '/') goto L5;
        String r11 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r11, "path");
        return StringsKt.replace$default(r11, File.separatorChar, '/', false, 4, null);
    L5:
        String r12 = r10.getPath();
        Intrinsics.checkNotNullExpressionValue(r12, "path");
        return r12;
    }

    public static final String getNameWithoutExtension(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getName();
        Intrinsics.checkNotNullExpressionValue(r11, ActivityLifecycle.NAME);
        return StringsKt.substringBeforeLast$default(r11, ".", null, 2, null);
    }

    public static final File normalize(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FilePathComponents r11 = FilesKt__FilePathComponentsKt.toComponents(r10);
        File r12 = r11.getRoot();
        List<File> r13 = normalize$FilesKt__UtilsKt(r11.getSegments());
        String r14 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r14, "separator");
        return resolve(r12, CollectionsKt.joinToString$default(r13, r14, null, null, 0, null, null, 62, null));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> r10) {
        ArrayList r11 = new ArrayList(r10.size());
        Iterator<? extends File> r12 = r10.iterator();
    L4:
        if (r12.hasNext() == false) goto L15;
        File r13 = r12.next();
        String r14 = r13.getName();
        if (Intrinsics.areEqual(r14, ".") == true) goto L4;
        if (Intrinsics.areEqual(r14, "..") == false) goto L14;
        if (r11.isEmpty() == true) goto L14;
        if (Intrinsics.areEqual(((File) CollectionsKt.last(r11)).getName(), "..") == true) goto L14;
        r11.remove(r11.size() - 1);
    L14:
        r11.add(r13);
        goto L4
    L15:
        return r11;
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents r10) {
        return new FilePathComponents(r10.getRoot(), normalize$FilesKt__UtilsKt(r10.getSegments()));
    }

    public static File relativeTo(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        return new File(toRelativeString(r10, r11));
    }

    public static final File relativeToOrNull(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        String r12 = toRelativeStringOrNull$FilesKt__UtilsKt(r10, r11);
        if (r12 != null) goto L7;
        return null;
    L7:
        return new File(r12);
    }

    public static final File relativeToOrSelf(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        String r12 = toRelativeStringOrNull$FilesKt__UtilsKt(r10, r11);
        if (r12 != null) goto L5;
        return r10;
    L5:
        return new File(r12);
    }

    public static final File resolve(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(r11) == false) goto L5;
        return r11;
    L5:
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "this.toString()");
        if (r12.length() != 0) goto L8;
        boolean r13 = true;
    L9:
        if (r13 == true) goto L15;
        if (StringsKt.endsWith$default(r12, File.separatorChar, false, 2, null) == true) goto L15;
        return new File(r12 + File.separatorChar + r11);
    L15:
        return new File(r12 + r11);
    L8:
        r13 = false;
        goto L9
    }

    public static final File resolve(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "relative");
        return resolve(r10, new File(r11));
    }

    public static final File resolveSibling(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "relative");
        FilePathComponents r12 = FilesKt__FilePathComponentsKt.toComponents(r10);
        if (r12.getSize() != 0) goto L5;
        File r13 = new File("..");
    L7:
        return resolve(resolve(r12.getRoot(), r13), r11);
    L5:
        r13 = r12.subPath(0, r12.getSize() - 1);
        goto L7
    }

    public static final File resolveSibling(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "relative");
        return resolveSibling(r10, new File(r11));
    }

    public static final boolean startsWith(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        FilePathComponents r12 = FilesKt__FilePathComponentsKt.toComponents(r10);
        FilePathComponents r13 = FilesKt__FilePathComponentsKt.toComponents(r11);
        if (Intrinsics.areEqual(r12.getRoot(), r13.getRoot()) == true) goto L6;
        return false;
    L6:
        if (r12.getSize() >= r13.getSize()) goto L9;
        return false;
    L9:
        return r12.getSegments().subList(0, r13.getSize()).equals(r13.getSegments());
    }

    public static final boolean startsWith(File r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return startsWith(r10, new File(r11));
    }

    public static final String toRelativeString(File r10, File r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        String r12 = toRelativeStringOrNull$FilesKt__UtilsKt(r10, r11);
        if (r12 == null) goto L6;
        return r12;
    L6:
        throw new IllegalArgumentException("this and base files have different roots: " + r10 + " and " + r11 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File r17, File r18) {
        FilePathComponents r10 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(r17));
        FilePathComponents r11 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(r18));
        if (Intrinsics.areEqual(r10.getRoot(), r11.getRoot()) == true) goto L5;
        return null;
    L5:
        int r12 = r11.getSize();
        int r13 = r10.getSize();
        int r14 = 0;
        int r15 = Math.min(r13, r12);
    L6:
        if (r14 >= r15) goto L10;
        if (Intrinsics.areEqual(r10.getSegments().get(r14), r11.getSegments().get(r14)) == false) goto L10;
        r14 = r14 + 1;
    L10:
        StringBuilder r16 = new StringBuilder();
        int r19 = r12 - 1;
        if (r14 <= r19) goto L13;
    L20:
        if (r14 >= r13) goto L25;
        if (r14 >= r12) goto L23;
        r16.append(File.separatorChar);
    L23:
        List r20 = CollectionsKt.drop(r10.getSegments(), r14);
        String r21 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r21, "separator");
        CollectionsKt.joinTo$default(r20, r16, r21, null, null, 0, null, null, 124, null);
    L25:
        return r16.toString();
    L13:
        if (Intrinsics.areEqual(r11.getSegments().get(r19).getName(), "..") == true) goto L14;
        r16.append("..");
        if (r19 == r14) goto L18;
        r16.append(File.separatorChar);
    L18:
        if (r19 == r14) goto L20;
        r19 = r19 - 1;
        goto L13
    L14:
        return null;
    }
}
