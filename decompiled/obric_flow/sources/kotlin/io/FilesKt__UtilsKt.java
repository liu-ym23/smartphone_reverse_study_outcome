package kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", "target", "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
@SourceDebugExtension({"SMAP\nUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n*L\n1#1,473:1\n1#2:474\n1288#3,3:475\n*S KotlinDebug\n*F\n+ 1 Utils.kt\nkotlin/io/FilesKt__UtilsKt\n*L\n347#1:475,3\n*E\n"})
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public FilesKt__UtilsKt() {
    }

    public static final boolean copyRecursively(File r11, File r12, boolean r13, final Function2<? super File, ? super IOException, ? extends OnErrorAction> r14) {
        Intrinsics.checkNotNullParameter(r11, "<this>");
        Intrinsics.checkNotNullParameter(r12, "target");
        Intrinsics.checkNotNullParameter(r14, "onError");
        if (r11.exists() == false) goto L5;
        Iterator<File> r5 = FilesKt__FileTreeWalkKt.walkTopDown(r11).onFail(new AnonymousClass2(r14)).iterator();     // Catch: TerminateException -> L44
    L10:
        if (r5.hasNext() == false) goto L43;
        File r10 = r5.next();     // Catch: TerminateException -> L44
        if (r10.exists() == false) goto L15;
        File r15 = new File(r12, toRelativeString(r10, r11));     // Catch: TerminateException -> L44
        if (r15.exists() == false) goto L36;
        if (r10.isDirectory() == true) goto L22;
    L23:
        if (r13 == false) goto L33;
        if (r15.isDirectory() == false) goto L31;
        if (deleteRecursively(r15) == true) goto L36;
    L31:
        if (r15.delete() == true) goto L36;
    L33:
        if (r14.mo2invoke(r15, new FileAlreadyExistsException(r10, r15, "The destination file already exists.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L22:
        if (r15.isDirectory() == false) goto L23;
    L36:
        if (r10.isDirectory() == true) goto L37;
        if (copyTo$default(r10, r15, r13, 0, 4, null).length() == r10.length()) goto L10;
        if (r14.mo2invoke(r10, new IOException("Source file wasn't copied completely, length of destination file differs.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L37:
        r15.mkdirs();     // Catch: TerminateException -> L44
        goto L10
    L15:
        if (r14.mo2invoke(r10, new NoSuchFileException(r10, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L43:
        return true;
    L44:
        return false;
    L5:
        if (r14.mo2invoke(r11, new NoSuchFileException(r11, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) goto L8;
        return true;
    L8:
        return false;
    }

    public static /* synthetic */ boolean copyRecursively$default(File r5, File r10, boolean r11, Function2 r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = AnonymousClass1.INSTANCE;
    L9:
        return copyRecursively(r5, r10, r11, r12);
    }

    public static final File copyTo(File r10, File r11, boolean r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "target");
        if (r10.exists() == false) goto L43;
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
        FileOutputStream r16 = new FileOutputStream(r11);     // Catch: Throwable -> L31
        ByteStreamsKt.copyTo(r15, r16, r13);     // Catch: Throwable -> L33
    L28:
        CloseableKt.closeFinally(r16, null);     // Catch: Throwable -> L31
        CloseableKt.closeFinally(r15, null);
    L30:
        return r11;
    L33:
        th = move-exception;
        throw th;     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        CloseableKt.closeFinally(r16, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L17:
        if (r11.mkdirs() == true) goto L30;
        throw new FileSystemException(r10, r11, "Failed to create target directory.");
    L43:
        throw new NoSuchFileException(r10, null, "The source file doesn't exist.", 2, null);
    }

    public static /* synthetic */ File copyTo$default(File r5, File r10, boolean r11, int r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = false;
    L6:
        if ((r13 & 4) == 0) goto L9;
        r12 = 8192;
    L9:
        return copyTo(r5, r10, r11, r12);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String r5, String r10, File r11) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        File r12 = File.createTempFile(r5, r10, r11);
        r12.delete();
        if (r12.mkdir() == false) goto L7;
        Intrinsics.checkNotNull(r12);
        return r12;
    L7:
        throw new IOException("Unable to create temporary directory " + r12 + '.');
    }

    public static /* synthetic */ File createTempDir$default(String r5, String r10, File r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "tmp";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = null;
    L12:
        return createTempDir(r5, r10, r11);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String r5, String r10, File r11) {
        Intrinsics.checkNotNullParameter(r5, "prefix");
        return File.createTempFile(r5, r10, r11);
    }

    public static /* synthetic */ File createTempFile$default(String r5, String r10, File r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r5 = "tmp";
    L6:
        if ((r12 & 2) == 0) goto L9;
        r10 = null;
    L9:
        if ((r12 & 4) == 0) goto L12;
        r11 = null;
    L12:
        return createTempFile(r5, r10, r11);
    }

    public static boolean deleteRecursively(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator<File> r10 = FilesKt__FileTreeWalkKt.walkBottomUp(r5).iterator();
    L3:
        boolean r11 = true;
    L5:
        if (r10.hasNext() == false) goto L13;
        File r12 = r10.next();
        if (r12.delete() == true) goto L10;
        if (r12.exists() == false) goto L10;
    L12:
        r11 = false;
    L10:
        if (r11 == false) goto L12;
    L13:
        return r11;
    }

    public static final boolean endsWith(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        FilePathComponents r11 = FilesKt__FilePathComponentsKt.toComponents(r5);
        FilePathComponents r12 = FilesKt__FilePathComponentsKt.toComponents(r10);
        if (r12.isRooted() == true) goto L5;
        int r13 = r11.getSize() - r12.getSize();
        if (r13 >= 0) goto L10;
        return false;
    L10:
        return r11.getSegments().subList(r13, r11.getSize()).equals(r12.getSegments());
    L5:
        return Intrinsics.areEqual(r5, r10);
    }

    public static String getExtension(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return StringsKt.T(r5.getName());
    }

    public static final String getInvariantSeparatorsPath(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        char r10 = File.separatorChar;
        String r11 = r5.getPath();
        if (r10 != '/') goto L5;
        return r11;
    L5:
        return StringsKt.E(r11, r10, '/');
    }

    public static final String getNameWithoutExtension(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        return StringsKt.a0(r5.getName(), ".");
    }

    public static final File normalize(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FilePathComponents r11 = FilesKt__FilePathComponentsKt.toComponents(r10);
        return resolve(r11.getRoot(), CollectionsKt.q(normalize$FilesKt__UtilsKt(r11.getSegments()), File.separator, null, null, 0, null, null, 62));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents r5) {
        return new FilePathComponents(r5.getRoot(), normalize$FilesKt__UtilsKt(r5.getSegments()));
    }

    public static final File relativeTo(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        return new File(toRelativeString(r5, r10));
    }

    public static final File relativeToOrNull(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        String r11 = toRelativeStringOrNull$FilesKt__UtilsKt(r5, r10);
        if (r11 != null) goto L7;
        return null;
    L7:
        return new File(r11);
    }

    public static final File relativeToOrSelf(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        String r11 = toRelativeStringOrNull$FilesKt__UtilsKt(r5, r10);
        if (r11 != null) goto L5;
        return r5;
    L5:
        return new File(r11);
    }

    public static final File resolve(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "relative");
        if (FilesKt__FilePathComponentsKt.isRooted(r10) == false) goto L5;
        return r10;
    L5:
        String r11 = r5.toString();
        if (r11.length() == 0) goto L13;
        char r12 = File.separatorChar;
        if (StringsKt.j(r11, r12) == true) goto L13;
        return new File(r11 + r12 + r10);
    L13:
        return new File(r11 + r10);
    }

    public static final File resolveSibling(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "relative");
        FilePathComponents r11 = FilesKt__FilePathComponentsKt.toComponents(r5);
        if (r11.getSize() != 0) goto L5;
        File r12 = new File("..");
    L7:
        return resolve(resolve(r11.getRoot(), r12), r10);
    L5:
        r12 = r11.subPath(0, r11.getSize() - 1);
        goto L7
    }

    public static final boolean startsWith(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        FilePathComponents r11 = FilesKt__FilePathComponentsKt.toComponents(r5);
        FilePathComponents r12 = FilesKt__FilePathComponentsKt.toComponents(r10);
        if (Intrinsics.areEqual(r11.getRoot(), r12.getRoot()) == true) goto L6;
        return false;
    L6:
        if (r11.getSize() >= r12.getSize()) goto L9;
        return false;
    L9:
        return r11.getSegments().subList(0, r12.getSize()).equals(r12.getSegments());
    }

    public static final String toRelativeString(File r5, File r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "base");
        String r11 = toRelativeStringOrNull$FilesKt__UtilsKt(r5, r10);
        if (r11 == null) goto L6;
        return r11;
    L6:
        throw new IllegalArgumentException("this and base files have different roots: " + r5 + " and " + r10 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File r12, File r13) {
        FilePathComponents r14 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(r12));
        FilePathComponents r15 = normalize$FilesKt__UtilsKt(FilesKt__FilePathComponentsKt.toComponents(r13));
        if (Intrinsics.areEqual(r14.getRoot(), r15.getRoot()) == true) goto L5;
        return null;
    L5:
        int r5 = r15.getSize();
        int r10 = r14.getSize();
        int r11 = Math.min(r10, r5);
        int r16 = 0;
    L6:
        if (r16 >= r11) goto L10;
        if (Intrinsics.areEqual(r14.getSegments().get(r16), r15.getSegments().get(r16)) == false) goto L10;
        r16 = r16 + 1;
    L10:
        StringBuilder r17 = new StringBuilder();
        int r18 = r5 - 1;
        if (r16 <= r18) goto L13;
    L20:
        if (r16 >= r10) goto L25;
        if (r16 >= r5) goto L23;
        r17.append(File.separatorChar);
    L23:
        CollectionsKt.p(CollectionsKt.i(r14.getSegments(), r16), r17, File.separator, null, null, null, 124);
    L25:
        return r17.toString();
    L13:
        if (Intrinsics.areEqual(r15.getSegments().get(r18).getName(), "..") == true) goto L14;
        r17.append("..");
        if (r18 == r16) goto L18;
        r17.append(File.separatorChar);
    L18:
        if (r18 == r16) goto L20;
        r18 = r18 - 1;
        goto L13
    L14:
        return null;
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> r5) {
        ArrayList r10 = new ArrayList(r5.size());
        Iterator<? extends File> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L16;
        File r12 = r11.next();
        String r13 = r12.getName();
        if (Intrinsics.areEqual(r13, ".") == true) goto L4;
        if (Intrinsics.areEqual(r13, "..") == true) goto L10;
        r10.add(r12);
        goto L4
    L10:
        if (r10.isEmpty() == true) goto L14;
        if (Intrinsics.areEqual(((File) CollectionsKt.last(r10)).getName(), "..") == true) goto L14;
        r10.remove(r10.size() - 1);
    L14:
        r10.add(r12);
        goto L4
    L16:
        return r10;
    }

    public static File resolve(File r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "relative");
        return resolve(r5, new File(r10));
    }

    public static final File resolveSibling(File r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "relative");
        return resolveSibling(r5, new File(r10));
    }

    public static final boolean startsWith(File r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return startsWith(r5, new File(r10));
    }

    public static final boolean endsWith(File r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r10, "other");
        return endsWith(r5, new File(r10));
    }
}
