package kotlin.io.path;

import com.lynx.serval.svg.SVGRenderEngine;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u000e\u001a&\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\tH\u0000\u001a\u0019\u0010\u0014\u001a\u00020\u0001*\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0002\b\u0015\u001aw\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\b\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0007\u001a´\u0001\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\b\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2C\b\u0002\u0010$\u001a=\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020&0\u0019¢\u0006\u0002\b'H\u0007\u001a\f\u0010(\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010)\u001a\f\u0012\b\u0012\u00060\u001dj\u0002`\u001e0**\u00020\tH\u0002¢\u0006\u0002\b+\u001a'\u0010,\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b.\u001a1\u0010/\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b0\u001a5\u00101\u001a\u00020\"*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u00102\u001a\u00020\t2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a\u0011\u00108\u001a\u000209*\u00020&H\u0003¢\u0006\u0002\b:\u001a\u0011\u00108\u001a\u000209*\u00020 H\u0003¢\u0006\u0002\b:¨\u0006;"}, d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", SVGRenderEngine.PATH, "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "parent", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "copyToRecursively", "target", "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "Lkotlin/Exception;", "exception", "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
@SourceDebugExtension({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,530:1\n376#1,2:534\n384#1:536\n384#1:537\n378#1,4:538\n376#1,2:542\n384#1:544\n378#1,4:545\n384#1:549\n376#1,6:550\n376#1,2:556\n384#1:558\n378#1,4:559\n1#2:531\n1863#3,2:532\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n392#1:534,2\n407#1:536\n410#1:537\n392#1:538,4\n418#1:542,2\n419#1:544\n418#1:545,4\n430#1:549\n438#1:550,6\n461#1:556,2\n462#1:558\n461#1:559,4\n314#1:532,2\n*E\n"})
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r5 = new int[CopyActionResult.values().length];
            r5[CopyActionResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r5[CopyActionResult.TERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r5[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            $EnumSwitchMapping$0 = r5;
            int[] r10 = new int[OnErrorResult.values().length];
            r10[OnErrorResult.TERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r10[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r10;
        }
    }

    public PathsKt__PathRecursiveFunctionsKt() {
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$copy(ArrayList r5, Function3 r10, Path r11, Path r12, Path r13, Function3 r14, Path r15, BasicFileAttributes r16) {
        return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(r5, r10, r11, r12, r13, r14, r15, r16);
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$error(Function3 r5, Path r10, Path r11, Path r12, Path r13, Exception r14) {
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r5, r10, r11, r12, r13, r14);
    }

    public static final void checkFileName(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        String r10 = PathsKt__PathUtilsKt.getName(r5);
        int r11 = r10.hashCode();
        if (r11 == 46) goto L31;
        if (r11 == 1518) goto L28;
        if (r11 == 45679) goto L25;
        if (r11 == 45724) goto L22;
        if (r11 == 1472) goto L19;
        if (r11 == 1473) goto L16;
        return;
    L16:
        if (r10.equals("./") == true) goto L34;
        return;
    L34:
        throw new IllegalFileNameException(r5);
    L19:
        if (r10.equals("..") == true) goto L34;
        return;
    L22:
        if (r10.equals("..\\") == true) goto L34;
        return;
    L25:
        if (r10.equals("../") == true) goto L34;
        return;
    L28:
        if (r10.equals(".\\") == true) goto L34;
        return;
    L31:
        if (r10.equals(".") == true) goto L34;
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path r5, Path r10) {
        if (Files.isSymbolicLink(r5) == false) goto L5;
        return;
    L5:
        if (Files.isSameFile(r5, r10) == true) goto L8;
        return;
    L8:
        throw new FileSystemLoopException(r5.toString());
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector r5, Function0<Unit> r10) {
        r10.invoke();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r5.collect(e);
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final Path copyToRecursively(Path r10, Path r11, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r12, final boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "target");
        Intrinsics.checkNotNullParameter(r12, "onError");
        if (r14 == false) goto L6;
        return copyToRecursively(r10, r11, r12, r13, new AnonymousClass2(r13));
    L6:
        return copyToRecursively$default(r10, r11, r12, r13, null, 8, null);
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> r10, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r11, Path r12, Path r13, Path r14, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r15, Path r16, BasicFileAttributes r17) {
    L5:
        e = move-exception;
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r15, r12, r13, r14, r16, e);
    L3:
        if (r10.isEmpty() == true) goto L7;
        checkFileName(r16);     // Catch: Exception -> L5
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r16, (Path) CollectionsKt.last(r10));     // Catch: Exception -> L5
    L7:
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r11.invoke(DefaultCopyActionContext.INSTANCE, r16, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r12, r13, r14, r16)));
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r5, Path r10, Function3 r11, boolean r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = AnonymousClass1.INSTANCE;
    L6:
        return copyToRecursively(r5, r10, r11, r12, r13);
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path r5, Path r10, Path r11, Path r12) {
        Path r13 = r10.resolve(PathsKt__PathUtilsKt.relativeTo(r12, r5).toString());
        if (r13.normalize().startsWith(r11) == false) goto L7;
        Intrinsics.checkNotNull(r13);
        return r13;
    L7:
        throw new IllegalFileNameException(r12, r13, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r5, Path r10, Path r11, Path r12, Path r13, Exception r14) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r5.invoke(r13, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r10, r11, r12, r13), r14));
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final void deleteRecursively(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "<this>");
        List<Exception> r10 = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(r5);
        if (r10.isEmpty() == true) goto L9;
        FileSystemException r11 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L8;
        ExceptionsKt.addSuppressed(r11, (Exception) r12.next());
        goto L6
    L8:
        throw r11;
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path r10) {
        boolean r5 = false;
        boolean r11 = true;
        ExceptionsCollector r12 = new ExceptionsCollector(0, 1, null);
        Path r13 = r10.getParent();
        if (r13 != null) goto L26;
    L20:
        if (r11 == false) goto L23;
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r10, null, r12);
    L23:
        return r12.getCollectedExceptions();
    L26:
        DirectoryStream<Path> r14 = Files.newDirectoryStream(r13);     // Catch: Throwable -> L6
    L7:
        if (r14 == null) goto L20;
    L11:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r14, th);
        throw th;
    L9:
        if ((r14 instanceof SecureDirectoryStream) == false) goto L13;
        r12.setPath(r13);     // Catch: Throwable -> L11
        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) r14, r10.getFileName(), null, r12);     // Catch: Throwable -> L11
    L14:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L11
        CloseableKt.closeFinally(r14, null);
        r11 = r5;
        goto L20
    L13:
        r5 = true;
    L6:
        r14 = null;
        goto L7
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r5, Path r10, ExceptionsCollector r11) {
        SecureDirectoryStream<Path> r12 = r5.newDirectoryStream(r10, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r12 == null) goto L31;
        Iterator<Path> r13 = r12.iterator();     // Catch: Throwable -> L13
    L11:
        if (r13.hasNext() == false) goto L15;
        handleEntry$PathsKt__PathRecursiveFunctionsKt(r12, r13.next().getFileName(), r11.getPath(), r11);     // Catch: Throwable -> L13
        goto L11
    L15:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L5
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r11.collect(e);
        return;
    L7:
        r12 = null;
        goto L8
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r5, Path r10, Path r11, ExceptionsCollector r12) {
        r12.enterEntry(r10);
        if (r11 == null) goto L19;
        Path r13 = r12.getPath();     // Catch: Exception -> L5
        Intrinsics.checkNotNull(r13);     // Catch: Exception -> L5
        checkFileName(r13);     // Catch: Exception -> L5
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r13, r11);     // Catch: Exception -> L5
    L5:
        e = move-exception;
        r12.collect(e);
    L15:
        r12.exitEntry(r10);
        return;
    L19:
        if (isDirectory$PathsKt__PathRecursiveFunctionsKt(r5, r10, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L12;
        int r14 = r12.getTotalExceptions();     // Catch: Exception -> L5
        enterDirectory$PathsKt__PathRecursiveFunctionsKt(r5, r10, r12);     // Catch: Exception -> L5
        if (r14 != r12.getTotalExceptions()) goto L15;
        r5.deleteDirectory(r10);     // Catch: Exception -> L5 NoSuchFileException -> L17
        Unit r15 = Unit.INSTANCE;     // Catch: Exception -> L5 NoSuchFileException -> L17
    L18:
        goto L15
    L12:
        r5.deleteFile(r10);     // Catch: Exception -> L5 NoSuchFileException -> L17
        Unit r16 = Unit.INSTANCE;     // Catch: Exception -> L5 NoSuchFileException -> L17
        goto L18
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path r5, ExceptionsCollector r10) {
        DirectoryStream<Path> r11 = Files.newDirectoryStream(r5);     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r11 == null) goto L31;
        Iterator<Path> r12 = r11.iterator();     // Catch: Throwable -> L13
    L11:
        if (r12.hasNext() == false) goto L15;
        Path r13 = r12.next();     // Catch: Throwable -> L13
        Intrinsics.checkNotNull(r13);     // Catch: Throwable -> L13
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r13, r5, r10);     // Catch: Throwable -> L13
        goto L11
    L15:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L13
        CloseableKt.closeFinally(r11, null);     // Catch: Exception -> L5
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r10.collect(e);
        return;
    L7:
        r11 = null;
        goto L8
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path r5, Path r10, ExceptionsCollector r11) {
        if (r10 == null) goto L7;
        checkFileName(r5);     // Catch: Exception -> L4
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r5, r10);     // Catch: Exception -> L4
    L4:
        e = move-exception;
        r11.collect(e);
        return;
    L7:
        if (Files.isDirectory(r5, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L11;
        int r12 = r11.getTotalExceptions();     // Catch: Exception -> L4
        insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(r5, r11);     // Catch: Exception -> L4
        if (r12 != r11.getTotalExceptions()) goto L16;
        Files.deleteIfExists(r5);     // Catch: Exception -> L4
        return;
    L16:
        return;
    L11:
        Files.deleteIfExists(r5);     // Catch: Exception -> L4
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r5, Path r10, LinkOption... r11) {
        Boolean r12 = Boolean.valueOf(((BasicFileAttributeView) r5.getFileAttributeView(r10, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(r11, r11.length))).readAttributes().isDirectory());     // Catch: NoSuchFileException -> L4
    L5:
        if (r12 != null) goto L11;
        return false;
    L11:
        return r12.booleanValue();
    L4:
        r12 = null;
        goto L5
    }

    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult r5) {
        int r10 = WhenMappings.$EnumSwitchMapping$0[r5.ordinal()];
        if (r10 == 1) goto L13;
        if (r10 == 2) goto L15;
        if (r10 != 3) goto L10;
        return FileVisitResult.SKIP_SUBTREE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return FileVisitResult.TERMINATE;
    L13:
        return FileVisitResult.CONTINUE;
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> r5) {
        return r5.invoke();
    L4:
        return null;
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final Path copyToRecursively(final Path r10, final Path r11, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r12, boolean r13, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "target");
        Intrinsics.checkNotNullParameter(r12, "onError");
        Intrinsics.checkNotNullParameter(r14, "copyAction");
        LinkOption[] r5 = LinkFollowing.INSTANCE.toLinkOptions(r13);
        LinkOption[] r15 = (LinkOption[]) Arrays.copyOf(r5, r5.length);
        if (Files.exists(r10, (LinkOption[]) Arrays.copyOf(r15, r15.length)) == false) goto L37;
        boolean r16 = false;
        if (Files.exists(r10, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L34;
        if (r13 == true) goto L10;
        if (Files.isSymbolicLink(r10) == true) goto L34;
    L10:
        if (Files.exists(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L12;
    L14:
        boolean r17 = false;
    L15:
        if (r17 == false) goto L19;
        if (Files.isSameFile(r10, r11) == true) goto L34;
    L19:
        if (Intrinsics.areEqual(r10.getFileSystem(), r11.getFileSystem()) == false) goto L30;
        if (r17 == false) goto L23;
        r16 = r11.toRealPath(new LinkOption[0]).startsWith(r10.toRealPath(new LinkOption[0]));
        goto L30
    L23:
        Path r18 = r11.getParent();
        if (r18 == null) goto L30;
        if (Files.exists(r18, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L30;
        if (r18.toRealPath(new LinkOption[0]).startsWith(r10.toRealPath(new LinkOption[0])) == false) goto L30;
        r16 = true;
    L30:
        if (r16 == false) goto L34;
        throw new FileSystemException(r10.toString(), r11.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
    L12:
        if (Files.isSymbolicLink(r11) == true) goto L14;
        r17 = true;
    L34:
        final Path r19 = r11.normalize();
        final ArrayList r20 = new ArrayList();
        PathsKt__PathUtilsKt.visitFileTree$default(r10, 0, r13, new AnonymousClass5(r20, r14, r10, r11, r19, r12), 1, null);
        return r11;
    L37:
        throw new NoSuchFileException(r10.toString(), r11.toString(), "The source file doesn't exist.");
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r5, Path r10, Function3 r11, final boolean r12, Function3 r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = AnonymousClass3.INSTANCE;
    L6:
        if ((r14 & 8) == 0) goto L9;
        r13 = new AnonymousClass4(r12);
    L9:
        return copyToRecursively(r5, r10, r11, r12, r13);
    }

    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult r5) {
        int r10 = WhenMappings.$EnumSwitchMapping$1[r5.ordinal()];
        if (r10 == 1) goto L10;
        if (r10 != 2) goto L8;
        return FileVisitResult.SKIP_SUBTREE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FileVisitResult.TERMINATE;
    }
}
