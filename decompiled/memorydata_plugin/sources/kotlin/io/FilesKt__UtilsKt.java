package kotlin.io;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u001a*\u0010\t\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a*\u0010\r\u001a\u00020\u00022\b\b\u0002\u0010\n\u001a\u00020\u00012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0002H\u0007\u001a8\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\u001a\b\u0002\u0010\u0012\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00150\u0013\u001a&\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u001a\n\u0010\u0019\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010\u001a\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0002*\u00020\u0002\u001a\u001d\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001d*\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0002¢\u0006\u0002\b\u001e\u001a\u0011\u0010\u001c\u001a\u00020\u001f*\u00020\u001fH\u0002¢\u0006\u0002\b\u001e\u001a\u0012\u0010 \u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0014\u0010\"\u001a\u0004\u0018\u00010\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010#\u001a\u00020\u0002*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010$\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0002\u001a\u0012\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010%\u001a\u00020\u0001\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0002\u001a\u0012\u0010'\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0001\u001a\u0012\u0010(\u001a\u00020\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002\u001a\u001b\u0010)\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010!\u001a\u00020\u0002H\u0002¢\u0006\u0002\b*\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0004\"\u0015\u0010\u0007\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0004¨\u0006+"}, d2 = {"extension", "", "Ljava/io/File;", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "createTempDir", "prefix", "suffix", "directory", "createTempFile", "copyRecursively", "", TypedValues.AttributesType.S_TARGET, "overwrite", "onError", "Lkotlin/Function2;", "Ljava/io/IOException;", "Lkotlin/io/OnErrorAction;", "copyTo", "bufferSize", "", "deleteRecursively", "endsWith", "other", "normalize", "", "normalize$FilesKt__UtilsKt", "Lkotlin/io/FilePathComponents;", "relativeTo", "base", "relativeToOrNull", "relativeToOrSelf", "resolve", "relative", "resolveSibling", "startsWith", "toRelativeString", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "kotlin-stdlib"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public FilesKt__UtilsKt() {
    }

    public static final boolean copyRecursively(File r12, File r13, boolean r14, Function2<? super File, ? super IOException, ? extends OnErrorAction> r15) {
        final Function2 r16 = (Function2) ZeusTransformUtils.wrapperContextForParams(r15, Function2.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r12, "<this>");
        Intrinsics.checkNotNullParameter(r13, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r16, "onError");
        if (r12.exists() == false) goto L5;
        Iterator<File> r0 = FilesKt.walkTopDown(r12).onFail((Function2) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r16), Function2.class, "com.obric.memorydata.plugin")).iterator();     // Catch: TerminateException -> L47
    L10:
        if (r0.hasNext() == false) goto L46;
        File r4 = (File) ZeusTransformUtils.preCheckCast(r0.next(), File.class, "com.obric.memorydata.plugin");     // Catch: TerminateException -> L47
        if (r4.exists() == false) goto L15;
        File r6 = new File(r13, FilesKt.toRelativeString(r4, r12));     // Catch: TerminateException -> L47
        if (r6.exists() == false) goto L39;
        if (r4.isDirectory() == true) goto L22;
    L23:
        if (r14 == true) goto L26;
    L24:
        boolean r5 = true;
    L34:
        if (r5 == false) goto L39;
        if (r16.invoke(r6, new FileAlreadyExistsException(r4, r6, "The destination file already exists.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L26:
        if (r6.isDirectory() == false) goto L31;
        if (FilesKt.deleteRecursively(r6) == false) goto L24;
    L33:
        r5 = false;
        goto L34
    L31:
        if (r6.delete() == true) goto L33;
    L22:
        if (r6.isDirectory() == false) goto L23;
    L39:
        if (r4.isDirectory() == true) goto L40;
        if (FilesKt.copyTo$default(r4, r6, r14, 0, 4, null).length() == r4.length()) goto L10;
        if (r16.invoke(r4, new IOException("Source file wasn't copied completely, length of destination file differs.")) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L40:
        r6.mkdirs();     // Catch: TerminateException -> L47
        goto L10
    L15:
        if (r16.invoke(r4, new NoSuchFileException(r4, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE) goto L10;
        return false;
    L46:
        return true;
    L47:
        return false;
    L5:
        if (r16.invoke(r12, new NoSuchFileException(r12, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) goto L8;
        return true;
    L8:
        return false;
    }

    public static /* synthetic */ boolean copyRecursively$default(File r1, File r2, boolean r3, Function2 r4, int r5, Object r6) {
        Function2 r7 = (Function2) ZeusTransformUtils.wrapperContextForParams(r4, Function2.class, "com.obric.memorydata.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r7 = (Function2) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function2.class, "com.obric.memorydata.plugin");
    L9:
        return FilesKt.copyRecursively(r1, r2, r3, r7);
    }

    public static final File copyTo(File r6, File r7, boolean r8, int r9) {
        Intrinsics.checkNotNullParameter(r6, "<this>");
        Intrinsics.checkNotNullParameter(r7, TypedValues.AttributesType.S_TARGET);
        if (r6.exists() == true) goto L5;
        String r3 = "The source file doesn't exist.";
        throw new NoSuchFileException(r6, null, r3, 2, null);
    L5:
        if (r7.exists() == false) goto L15;
        if (r8 == false) goto L13;
        if (r7.delete() == true) goto L15;
        throw new FileAlreadyExistsException(r6, r7, "Tried to overwrite the destination, but failed to delete it.");
    L13:
        throw new FileAlreadyExistsException(r6, r7, "The destination file already exists.");
    L15:
        if (r6.isDirectory() == true) goto L17;
        File r10 = r7.getParentFile();
        if (r10 == null) goto L24;
        r10.mkdirs();
    L24:
        Closeable r11 = (Closeable) ZeusTransformUtils.preCheckCast(new FileInputStream(r6), Closeable.class, "com.obric.memorydata.plugin");
        FileInputStream r12 = (FileInputStream) ZeusTransformUtils.preCheckCast(r11, FileInputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        Closeable r1 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r7), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L36
        FileOutputStream r2 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r1, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L31
        ByteStreamsKt.copyTo((InputStream) ZeusTransformUtils.preCheckCast(r12, InputStream.class, "com.obric.memorydata.plugin"), (OutputStream) ZeusTransformUtils.preCheckCast(r2, OutputStream.class, "com.obric.memorydata.plugin"), r9);     // Catch: Throwable -> L31
    L28:
        CloseableKt.closeFinally(r1, null);     // Catch: Throwable -> L36
        CloseableKt.closeFinally(r11, null);
    L30:
        return r7;
    L31:
        th = move-exception;
        throw th;     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        CloseableKt.closeFinally(r1, th);     // Catch: Throwable -> L36
        throw th;     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);
        throw th;
    L17:
        if (r7.mkdirs() == true) goto L30;
        throw new FileSystemException(r6, r7, "Failed to create target directory.");
    }

    public static /* synthetic */ File copyTo$default(File r0, File r1, boolean r2, int r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = false;
    L6:
        if ((r4 & 4) == 0) goto L9;
        r3 = 8192;
    L9:
        return FilesKt.copyTo(r0, r1, r2, r3);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    public static final File createTempDir(String r1, String r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        File r4 = File.createTempFile(r1, r2, r3);
        r4.delete();
        if (r4.mkdir() == false) goto L7;
        Intrinsics.checkNotNull(r4);
        return r4;
    L7:
        throw new IOException("Unable to create temporary directory " + r4 + '.');
    }

    public static /* synthetic */ File createTempDir$default(String r1, String r2, File r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "tmp";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return FilesKt.createTempDir(r1, r2, r3);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    public static final File createTempFile(String r1, String r2, File r3) {
        Intrinsics.checkNotNullParameter(r1, "prefix");
        File r4 = File.createTempFile(r1, r2, r3);
        Intrinsics.checkNotNullExpressionValue(r4, "createTempFile(...)");
        return r4;
    }

    public static /* synthetic */ File createTempFile$default(String r1, String r2, File r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = "tmp";
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = null;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = null;
    L12:
        return FilesKt.createTempFile(r1, r2, r3);
    }

    public static final boolean deleteRecursively(File r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Iterator r6 = ((Sequence) ZeusTransformUtils.preCheckCast(FilesKt.walkBottomUp(r5), Sequence.class, "com.obric.memorydata.plugin")).iterator();
    L3:
        boolean r2 = true;
    L5:
        if (r6.hasNext() == false) goto L13;
        File r3 = (File) ZeusTransformUtils.preCheckCast(r6.next(), File.class, "com.obric.memorydata.plugin");
        if (r3.delete() == true) goto L10;
        if (r3.exists() == false) goto L10;
    L12:
        r2 = false;
    L10:
        if (r2 == false) goto L12;
    L13:
        return r2;
    }

    public static final boolean endsWith(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        FilePathComponents r0 = FilesKt.toComponents(r3);
        FilePathComponents r1 = FilesKt.toComponents(r4);
        if (r1.isRooted() == true) goto L5;
        int r5 = r0.getSize() - r1.getSize();
        if (r5 >= 0) goto L10;
        return false;
    L10:
        return r0.getSegments().subList(r5, r0.getSize()).equals(r1.getSegments());
    L5:
        return Intrinsics.areEqual(r3, r4);
    }

    public static final boolean endsWith(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        return FilesKt.endsWith(r1, new File(r2));
    }

    public static final String getExtension(File r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        String r3 = r2.getName();
        Intrinsics.checkNotNullExpressionValue(r3, "getName(...)");
        return StringsKt.substringAfterLast(r3, '.', "");
    }

    public static final String getInvariantSeparatorsPath(File r9) {
        Intrinsics.checkNotNullParameter(r9, "<this>");
        if (File.separatorChar == '/') goto L5;
        String r3 = r9.getPath();
        Intrinsics.checkNotNullExpressionValue(r3, "getPath(...)");
        return StringsKt.replace$default(r3, File.separatorChar, '/', false, 4, null);
    L5:
        String r10 = r9.getPath();
        Intrinsics.checkNotNullExpressionValue(r10, "getPath(...)");
        return r10;
    }

    public static final String getNameWithoutExtension(File r3) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        String r4 = r3.getName();
        Intrinsics.checkNotNullExpressionValue(r4, "getName(...)");
        return StringsKt.substringBeforeLast$default(r4, ".", null, 2, null);
    }

    public static final File normalize(File r12) {
        Intrinsics.checkNotNullParameter(r12, "<this>");
        FilePathComponents r13 = FilesKt.toComponents(r12);
        File r0 = r13.getRoot();
        Iterable r3 = (Iterable) ZeusTransformUtils.preCheckCast(normalize$FilesKt__UtilsKt(r13.getSegments()), Iterable.class, "com.obric.memorydata.plugin");
        String r14 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r14, "separator");
        return FilesKt.resolve(r0, CollectionsKt.joinToString$default(r3, (CharSequence) ZeusTransformUtils.preCheckCast(r14, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 62, null));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> r6) {
        List r7 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
        List<File> r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(r7.size()), List.class, "com.obric.memorydata.plugin");
        Iterator r8 = r7.iterator();
    L4:
        if (r8.hasNext() == false) goto L15;
        File r2 = (File) ZeusTransformUtils.preCheckCast(r8.next(), File.class, "com.obric.memorydata.plugin");
        String r3 = r2.getName();
        if (Intrinsics.areEqual(r3, ".") == true) goto L4;
        if (Intrinsics.areEqual(r3, "..") == false) goto L14;
        if (r0.isEmpty() == true) goto L14;
        if (Intrinsics.areEqual(((File) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r0), File.class, "com.obric.memorydata.plugin")).getName(), "..") == true) goto L14;
        r0.remove(r0.size() - 1);
    L14:
        r0.add(r2);
        goto L4
    L15:
        return r0;
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents r2) {
        return new FilePathComponents(r2.getRoot(), normalize$FilesKt__UtilsKt(r2.getSegments()));
    }

    public static final File relativeTo(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "base");
        return new File(FilesKt.toRelativeString(r1, r2));
    }

    public static final File relativeToOrNull(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "base");
        String r3 = toRelativeStringOrNull$FilesKt__UtilsKt(r1, r2);
        if (r3 != null) goto L7;
        return null;
    L7:
        return new File(r3);
    }

    public static final File relativeToOrSelf(File r1, File r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "base");
        String r3 = toRelativeStringOrNull$FilesKt__UtilsKt(r1, r2);
        if (r3 != null) goto L5;
        return r1;
    L5:
        return new File(r3);
    }

    public static final File resolve(File r5, File r6) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        Intrinsics.checkNotNullParameter(r6, "relative");
        if (FilesKt.isRooted(r6) == false) goto L5;
        return r6;
    L5:
        String r7 = r5.toString();
        Intrinsics.checkNotNullExpressionValue(r7, "toString(...)");
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L8;
        boolean r0 = true;
    L9:
        if (r0 == true) goto L15;
        if (StringsKt.endsWith$default((CharSequence) ZeusTransformUtils.preCheckCast(r7, CharSequence.class, "com.obric.memorydata.plugin"), File.separatorChar, false, 2, null) == true) goto L15;
        return new File(r7 + File.separatorChar + r6);
    L15:
        return new File(r7 + r6);
    L8:
        r0 = false;
        goto L9
    }

    public static final File resolve(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "relative");
        return FilesKt.resolve(r1, new File(r2));
    }

    public static final File resolveSibling(File r2, File r3) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, "relative");
        FilePathComponents r4 = FilesKt.toComponents(r2);
        if (r4.getSize() != 0) goto L5;
        File r0 = new File("..");
    L7:
        return FilesKt.resolve(FilesKt.resolve(r4.getRoot(), r0), r3);
    L5:
        r0 = r4.subPath(0, r4.getSize() - 1);
        goto L7
    }

    public static final File resolveSibling(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "relative");
        return FilesKt.resolveSibling(r1, new File(r2));
    }

    public static final boolean startsWith(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "other");
        FilePathComponents r5 = FilesKt.toComponents(r3);
        FilePathComponents r6 = FilesKt.toComponents(r4);
        if (Intrinsics.areEqual(r5.getRoot(), r6.getRoot()) == true) goto L6;
        return false;
    L6:
        if (r5.getSize() >= r6.getSize()) goto L9;
        return false;
    L9:
        return r5.getSegments().subList(0, r6.getSize()).equals(r6.getSegments());
    }

    public static final boolean startsWith(File r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "other");
        return FilesKt.startsWith(r1, new File(r2));
    }

    public static final String toRelativeString(File r3, File r4) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        Intrinsics.checkNotNullParameter(r4, "base");
        String r0 = toRelativeStringOrNull$FilesKt__UtilsKt(r3, r4);
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new IllegalArgumentException("this and base files have different roots: " + r3 + " and " + r4 + '.');
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File r19, File r20) {
        FilePathComponents r0 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(r19));
        FilePathComponents r1 = normalize$FilesKt__UtilsKt(FilesKt.toComponents(r20));
        if (Intrinsics.areEqual(r0.getRoot(), r1.getRoot()) == true) goto L5;
        return null;
    L5:
        int r2 = r1.getSize();
        int r4 = r0.getSize();
        int r5 = 0;
        int r6 = Math.min(r4, r2);
    L6:
        if (r5 >= r6) goto L10;
        if (Intrinsics.areEqual(r0.getSegments().get(r5), r1.getSegments().get(r5)) == false) goto L10;
        r5 = r5 + 1;
    L10:
        StringBuilder r7 = new StringBuilder();
        int r8 = r2 - 1;
        if (r5 <= r8) goto L13;
    L20:
        if (r5 >= r4) goto L25;
        if (r5 >= r2) goto L23;
        r7.append(File.separatorChar);
    L23:
        Iterable r9 = (Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.drop((Iterable) ZeusTransformUtils.preCheckCast(r0.getSegments(), Iterable.class, "com.obric.memorydata.plugin"), r5), Iterable.class, "com.obric.memorydata.plugin");
        Appendable r10 = (Appendable) ZeusTransformUtils.preCheckCast(r7, Appendable.class, "com.obric.memorydata.plugin");
        String r3 = File.separator;
        Intrinsics.checkNotNullExpressionValue(r3, "separator");
        CollectionsKt.joinTo$default(r9, r10, (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, null, 124, null);
    L25:
        return r7.toString();
    L13:
        if (Intrinsics.areEqual(((File) ZeusTransformUtils.preCheckCast(r1.getSegments().get(r8), File.class, "com.obric.memorydata.plugin")).getName(), "..") == true) goto L14;
        r7.append("..");
        if (r8 == r5) goto L18;
        r7.append(File.separatorChar);
    L18:
        if (r8 == r5) goto L20;
        r8 = r8 - 1;
        goto L13
    L14:
        return null;
    }
}
