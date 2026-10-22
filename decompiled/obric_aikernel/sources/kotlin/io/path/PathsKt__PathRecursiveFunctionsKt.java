package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathRecursiveFunctions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,420:1\n336#1,2:424\n344#1:426\n344#1:427\n338#1,4:428\n336#1,2:432\n344#1:434\n338#1,4:435\n344#1:439\n336#1,6:440\n336#1,2:446\n344#1:448\n338#1,4:449\n1#2:421\n1855#3,2:422\n*S KotlinDebug\n*F\n+ 1 PathRecursiveFunctions.kt\nkotlin/io/path/PathsKt__PathRecursiveFunctionsKt\n*L\n352#1:424,2\n361#1:426\n364#1:427\n352#1:428,4\n372#1:432,2\n373#1:434\n372#1:435,4\n384#1:439\n392#1:440,6\n410#1:446,2\n411#1:448\n410#1:449,4\n274#1:422,2\n*E\n"})
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r10 = new int[CopyActionResult.values().length];
            r10[CopyActionResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r10[CopyActionResult.TERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r10[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            $EnumSwitchMapping$0 = r10;
            int[] r11 = new int[OnErrorResult.values().length];
            r11[OnErrorResult.TERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r11[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r11;
        }
    }

    public PathsKt__PathRecursiveFunctionsKt() {
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$copy(Function3 r10, Path r11, Path r12, Function3 r13, Path r14, BasicFileAttributes r15) {
        return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(r10, r11, r12, r13, r14, r15);
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$error(Function3 r10, Path r11, Path r12, Path r13, Exception r14) {
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r10, r11, r12, r13, r14);
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector r10, Function0<Unit> r11) {
        r11.invoke();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        r10.collect(e);
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final Path copyToRecursively(final Path r10, final Path r11, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r12, boolean r13, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r12, "onError");
        Intrinsics.checkNotNullParameter(r14, "copyAction");
        LinkOption[] r15 = LinkFollowing.INSTANCE.toLinkOptions(r13);
        LinkOption[] r16 = (LinkOption[]) Arrays.copyOf(r15, r15.length);
        if (Files.exists(r10, (LinkOption[]) Arrays.copyOf(r16, r16.length)) == false) goto L37;
        boolean r17 = false;
        if (Files.exists(r10, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L34;
        if (r13 == true) goto L10;
        if (Files.isSymbolicLink(r10) == true) goto L34;
    L10:
        if (Files.exists(r11, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L12;
    L14:
        boolean r18 = false;
    L15:
        if (r18 == false) goto L19;
        if (Files.isSameFile(r10, r11) == true) goto L34;
    L19:
        if (Intrinsics.areEqual(r10.getFileSystem(), r11.getFileSystem()) == false) goto L30;
        if (r18 == false) goto L23;
        r17 = r11.toRealPath(new LinkOption[0]).startsWith(r10.toRealPath(new LinkOption[0]));
        goto L30
    L23:
        Path r19 = r11.getParent();
        if (r19 == null) goto L30;
        if (Files.exists(r19, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == false) goto L30;
        if (r19.toRealPath(new LinkOption[0]).startsWith(r10.toRealPath(new LinkOption[0])) == false) goto L30;
        r17 = true;
    L30:
        if (r17 == false) goto L34;
        throw new FileSystemException(r10.toString(), r11.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
    L12:
        if (Files.isSymbolicLink(r11) == true) goto L14;
        r18 = true;
    L34:
        PathsKt__PathUtilsKt.visitFileTree$default(r10, 0, r13, new AnonymousClass5(r14, r10, r11, r12), 1, null);
        return r11;
    L37:
        throw new NoSuchFileException(r10.toString(), r11.toString(), "The source file doesn't exist.");
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final Path copyToRecursively(Path r10, Path r11, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r12, final boolean r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r12, "onError");
        if (r14 == false) goto L6;
        return copyToRecursively(r10, r11, r12, r13, new AnonymousClass2(r13));
    L6:
        return copyToRecursively$default(r10, r11, r12, r13, null, 8, null);
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r10, Path r11, Path r12, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r13, Path r14, BasicFileAttributes r15) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r10.invoke(DefaultCopyActionContext.INSTANCE, r14, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r11, r12, r14)));
    L4:
        e = move-exception;
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r13, r11, r12, r14, e);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r10, Path r11, Function3 r12, final boolean r13, Function3 r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = AnonymousClass3.INSTANCE;
    L6:
        if ((r15 & 8) == 0) goto L9;
        r14 = new AnonymousClass4(r13);
    L9:
        return copyToRecursively(r10, r11, r12, r13, r14);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r10, Path r11, Function3 r12, boolean r13, boolean r14, int r15, Object r16) {
        if ((r15 & 2) == 0) goto L6;
        r12 = AnonymousClass1.INSTANCE;
    L6:
        return copyToRecursively(r10, r11, r12, r13, r14);
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path r10, Path r11, Path r12) {
        Path r13 = r11.resolve(PathsKt__PathUtilsKt.relativeTo(r12, r10).toString());
        Intrinsics.checkNotNullExpressionValue(r13, "target.resolve(relativePath.pathString)");
        return r13;
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r10, Path r11, Path r12, Path r13, Exception r14) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(r10.invoke(r13, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r11, r12, r13), r14));
    }

    @SinceKotlin(version = "1.8")
    @ExperimentalPathApi
    public static final void deleteRecursively(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        List<Exception> r11 = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(r10);
        if ((!r11.isEmpty()) == false) goto L9;
        FileSystemException r12 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator<T> r13 = r11.iterator();
    L6:
        if (r13.hasNext() == false) goto L8;
        ExceptionsKt.addSuppressed(r12, (Exception) r13.next());
        goto L6
    L8:
        throw r12;
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path r10) {
        boolean r11 = false;
        boolean r12 = true;
        ExceptionsCollector r13 = new ExceptionsCollector(0, 1, null);
        Path r14 = r10.getParent();
        if (r14 != null) goto L23;
    L19:
        if (r12 == false) goto L22;
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r10, r13);
    L22:
        return r13.getCollectedExceptions();
    L23:
        DirectoryStream<Path> r15 = Files.newDirectoryStream(r14);     // Catch: Throwable -> L6
    L7:
        if (r15 == null) goto L19;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        CloseableKt.closeFinally(r15, th);
        throw th;
    L9:
        if ((r15 instanceof SecureDirectoryStream) == false) goto L11;
        r13.setPath(r14);     // Catch: Throwable -> L14
        Path r16 = r10.getFileName();     // Catch: Throwable -> L14
        Intrinsics.checkNotNullExpressionValue(r16, "this.fileName");     // Catch: Throwable -> L14
        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) r15, r16, r13);     // Catch: Throwable -> L14
    L12:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L14
        CloseableKt.closeFinally(r15, null);
        r12 = r11;
        goto L19
    L11:
        r11 = true;
    L6:
        r15 = null;
        goto L7
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r10, Path r11, ExceptionsCollector r12) {
        SecureDirectoryStream<Path> r13 = r10.newDirectoryStream(r11, new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r13 == null) goto L30;
        Iterator<Path> r14 = r13.iterator();     // Catch: Throwable -> L16
    L11:
        if (r14.hasNext() == false) goto L13;
        Path r15 = r14.next().getFileName();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r15, "entry.fileName");     // Catch: Throwable -> L16
        handleEntry$PathsKt__PathRecursiveFunctionsKt(r13, r15, r12);     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r13, null);     // Catch: Exception -> L5
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r13, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L30:
        return;
    L5:
        e = move-exception;
        r12.collect(e);
        return;
    L7:
        r13 = null;
        goto L8
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r10, Path r11, ExceptionsCollector r12) {
        r12.enterEntry(r11);
    L11:
        e = move-exception;
        r12.collect(e);
    L13:
        r12.exitEntry(r11);
        return;
    L18:
        if (isDirectory$PathsKt__PathRecursiveFunctionsKt(r10, r11, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L9;
        int r13 = r12.getTotalExceptions();     // Catch: Exception -> L11
        enterDirectory$PathsKt__PathRecursiveFunctionsKt(r10, r11, r12);     // Catch: Exception -> L11
        if (r13 != r12.getTotalExceptions()) goto L13;
        r10.deleteDirectory(r11);     // Catch: Exception -> L11 NoSuchFileException -> L15
    L8:
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L11 NoSuchFileException -> L15
        goto L13
    L9:
        r10.deleteFile(r11);     // Catch: Exception -> L11 NoSuchFileException -> L15
        goto L8
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path r10, ExceptionsCollector r11) {
        DirectoryStream<Path> r12 = Files.newDirectoryStream(r10);     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r12 == null) goto L30;
        Iterator<Path> r13 = r12.iterator();     // Catch: Throwable -> L16
    L11:
        if (r13.hasNext() == false) goto L13;
        Path r14 = r13.next();     // Catch: Throwable -> L16
        Intrinsics.checkNotNullExpressionValue(r14, "entry");     // Catch: Throwable -> L16
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r14, r11);     // Catch: Throwable -> L16
        goto L11
    L13:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L16
        CloseableKt.closeFinally(r12, null);     // Catch: Exception -> L5
        return;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L30:
        return;
    L5:
        e = move-exception;
        r11.collect(e);
        return;
    L7:
        r12 = null;
        goto L8
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path r10, ExceptionsCollector r11) {
    L9:
        e = move-exception;
        r11.collect(e);
        return;
    L4:
        if (Files.isDirectory(r10, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1)) == false) goto L7;
        int r12 = r11.getTotalExceptions();     // Catch: Exception -> L9
        insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(r10, r11);     // Catch: Exception -> L9
        if (r12 == r11.getTotalExceptions()) goto L7;
        return;
    L7:
        Files.deleteIfExists(r10);     // Catch: Exception -> L9
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r10, Path r11, LinkOption... r12) {
        Boolean r13 = Boolean.valueOf(((BasicFileAttributeView) r10.getFileAttributeView(r11, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(r12, r12.length))).readAttributes().isDirectory());     // Catch: NoSuchFileException -> L4
    L5:
        if (r13 != null) goto L11;
        return false;
    L11:
        return r13.booleanValue();
    L4:
        r13 = null;
        goto L5
    }

    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult r10) {
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        if (r11 == 1) goto L13;
        if (r11 == 2) goto L15;
        if (r11 != 3) goto L10;
        return FileVisitResult.SKIP_SUBTREE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return FileVisitResult.TERMINATE;
    L13:
        return FileVisitResult.CONTINUE;
    }

    @ExperimentalPathApi
    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult r10) {
        int r11 = WhenMappings.$EnumSwitchMapping$1[r10.ordinal()];
        if (r11 == 1) goto L10;
        if (r11 != 2) goto L8;
        return FileVisitResult.SKIP_SUBTREE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FileVisitResult.TERMINATE;
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> r10) {
        return r10.invoke();
    L4:
        return null;
    }
}
