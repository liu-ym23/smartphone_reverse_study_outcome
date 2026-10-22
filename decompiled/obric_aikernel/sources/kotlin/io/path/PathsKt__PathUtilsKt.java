package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.crash.entity.EventBody;
import java.net.URI;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileStore;
import java.nio.file.FileVisitOption;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.UserPrincipal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.WasExperimental;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.internal.InlineOnly;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlin.sequences.Sequence;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
@SourceDebugExtension({"SMAP\nPathUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n+ 2 ArrayIntrinsics.kt\nkotlin/ArrayIntrinsicsKt\n+ 3 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,1174:1\n26#2:1175\n26#2:1179\n1#3:1176\n1855#4,2:1177\n*S KotlinDebug\n*F\n+ 1 PathUtils.kt\nkotlin/io/path/PathsKt__PathUtilsKt\n*L\n221#1:1175\n616#1:1179\n440#1:1177,2\n*E\n"})
class PathsKt__PathUtilsKt extends PathsKt__PathRecursiveFunctionsKt {
    public PathsKt__PathUtilsKt() {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Path(String r10) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Path r11 = Paths.get(r10, new String[0]);
        Intrinsics.checkNotNullExpressionValue(r11, "get(path)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path Path(String r10, String... r11) {
        Intrinsics.checkNotNullParameter(r10, "base");
        Intrinsics.checkNotNullParameter(r11, "subpaths");
        Path r12 = Paths.get(r10, (String[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "get(base, *subpaths)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path absolute(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = r10.toAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(r11, "toAbsolutePath()");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final String absolutePathString(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.toAbsolutePath().toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path copyTo(Path r10, Path r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r12 == false) goto L5;
        CopyOption[] r13 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r14 = Files.copy(r10, r11, (CopyOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "copy(this, target, *options)");
        return r14;
    L5:
        r13 = new CopyOption[0];
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path copyTo(Path r10, Path r11, CopyOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r12, "options");
        Path r13 = Files.copy(r10, r11, (CopyOption[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "copy(this, target, *options)");
        return r13;
    }

    static /* synthetic */ Path copyTo$default(Path r10, Path r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r12 == false) goto L8;
        CopyOption[] r15 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r16 = Files.copy(r10, r11, (CopyOption[]) Arrays.copyOf(r15, r15.length));
        Intrinsics.checkNotNullExpressionValue(r16, "copy(this, target, *options)");
        return r16;
    L8:
        r15 = new CopyOption[0];
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createDirectories(Path r10, FileAttribute<?>... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r12 = Files.createDirectories(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "createDirectories(this, *attributes)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createDirectory(Path r10, FileAttribute<?>... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r12 = Files.createDirectory(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "createDirectory(this, *attributes)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createFile(Path r10, FileAttribute<?>... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r12 = Files.createFile(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "createFile(this, *attributes)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createLinkPointingTo(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Path r12 = Files.createLink(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "createLink(this, target)");
        return r12;
    }

    @SinceKotlin(version = "1.9")
    public static final Path createParentDirectories(Path r10, FileAttribute<?>... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r12 = r10.getParent();
        if (r12 != null) goto L5;
    L13:
        return r10;
    L5:
        if (Files.isDirectory(r12, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        FileAttribute[] r13 = (FileAttribute[]) Arrays.copyOf(r11, r11.length);     // Catch: FileAlreadyExistsException -> L8
        Intrinsics.checkNotNullExpressionValue(Files.createDirectories(r12, (FileAttribute[]) Arrays.copyOf(r13, r13.length)), "createDirectories(this, *attributes)");     // Catch: FileAlreadyExistsException -> L8
    L8:
        e = move-exception;
        if (Files.isDirectory(r12, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) == true) goto L13;
        throw e;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createSymbolicLinkPointingTo(Path r10, Path r11, FileAttribute<?>... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r12, "attributes");
        Path r13 = Files.createSymbolicLink(r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "createSymbolicLink(this, target, *attributes)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createTempDirectory(String r10, FileAttribute<?>... r11) {
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r12 = Files.createTempDirectory(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "createTempDirectory(prefix, *attributes)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempDirectory(Path r10, String r11, FileAttribute<?>... r12) {
        Intrinsics.checkNotNullParameter(r12, "attributes");
        if (r10 == null) goto L5;
        Path r13 = Files.createTempDirectory(r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
        String r14 = "createTempDirectory(dire…ory, prefix, *attributes)";
    L6:
        Intrinsics.checkNotNullExpressionValue(r13, r14);
        return r13;
    L5:
        r13 = Files.createTempDirectory(r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
        r14 = "createTempDirectory(prefix, *attributes)";
        goto L6
    }

    static /* synthetic */ Path createTempDirectory$default(String r10, FileAttribute[] r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L5;
        r10 = null;
    L5:
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Path r14 = Files.createTempDirectory(r10, (FileAttribute[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r14, "createTempDirectory(prefix, *attributes)");
        return r14;
    }

    public static /* synthetic */ Path createTempDirectory$default(Path r10, String r11, FileAttribute[] r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        return createTempDirectory(r10, r11, r12);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path createTempFile(String r10, String r11, FileAttribute<?>... r12) {
        Intrinsics.checkNotNullParameter(r12, "attributes");
        Path r13 = Files.createTempFile(r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "createTempFile(prefix, suffix, *attributes)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path createTempFile(Path r10, String r11, String r12, FileAttribute<?>... r13) {
        Intrinsics.checkNotNullParameter(r13, "attributes");
        if (r10 == null) goto L5;
        Path r14 = Files.createTempFile(r10, r11, r12, (FileAttribute[]) Arrays.copyOf(r13, r13.length));
        String r15 = "createTempFile(directory…fix, suffix, *attributes)";
    L6:
        Intrinsics.checkNotNullExpressionValue(r14, r15);
        return r14;
    L5:
        r14 = Files.createTempFile(r11, r12, (FileAttribute[]) Arrays.copyOf(r13, r13.length));
        r15 = "createTempFile(prefix, suffix, *attributes)";
        goto L6
    }

    static /* synthetic */ Path createTempFile$default(String r10, String r11, FileAttribute[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r13 & 2) == 0) goto L8;
        r11 = null;
    L8:
        Intrinsics.checkNotNullParameter(r12, "attributes");
        Path r15 = Files.createTempFile(r10, r11, (FileAttribute[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r15, "createTempFile(prefix, suffix, *attributes)");
        return r15;
    }

    public static /* synthetic */ Path createTempFile$default(Path r10, String r11, String r12, FileAttribute[] r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = null;
    L9:
        return createTempFile(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void deleteExisting(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Files.delete(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean deleteIfExists(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.deleteIfExists(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path div(Path r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Path r12 = r10.resolve(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.resolve(other)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path div(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        Path r12 = r10.resolve(r11);
        Intrinsics.checkNotNullExpressionValue(r12, "this.resolve(other)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean exists(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.exists(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    @PublishedApi
    public static final Void fileAttributeViewNotAvailable(Path r10, Class<?> r11) {
        Intrinsics.checkNotNullParameter(r10, "path");
        Intrinsics.checkNotNullParameter(r11, "attributeViewClass");
        throw new UnsupportedOperationException("The desired attribute view type " + r11 + " is not available for the file " + r10 + '.');
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesView(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        V r12 = (V) Files.getFileAttributeView(r10, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r11, r11.length));
        if (r12 == null) goto L5;
        return r12;
    L5:
        Intrinsics.reifiedOperationMarker(4, "V");
        fileAttributeViewNotAvailable(r10, FileAttributeView.class);
        throw new KotlinNothingValueException();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <V extends FileAttributeView> V fileAttributesViewOrNull(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        Intrinsics.reifiedOperationMarker(4, "V");
        return (V) Files.getFileAttributeView(r10, FileAttributeView.class, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final long fileSize(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.size(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileStore fileStore(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        FileStore r11 = Files.getFileStore(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "getFileStore(this)");
        return r11;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final FileVisitor<Path> fileVisitor(Function1<? super FileVisitorBuilder, Unit> r10) {
        Intrinsics.checkNotNullParameter(r10, "builderAction");
        FileVisitorBuilderImpl r11 = new FileVisitorBuilderImpl();
        r10.invoke(r11);
        return r11.build();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final void forEachDirectoryEntry(Path r10, String r11, Function1<? super Path, Unit> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "glob");
        Intrinsics.checkNotNullParameter(r12, "action");
        DirectoryStream<Path> r13 = Files.newDirectoryStream(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "it");     // Catch: Throwable -> L10
        Iterator<Path> r14 = r13.iterator();     // Catch: Throwable -> L10
    L5:
        if (r14.hasNext() == false) goto L7;
        r12.invoke(r14.next());     // Catch: Throwable -> L10
        goto L5
    L7:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L10
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, null);
        InlineMarker.finallyEnd(1);
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static /* synthetic */ void forEachDirectoryEntry$default(Path r10, String r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "glob");
        Intrinsics.checkNotNullParameter(r12, "action");
        DirectoryStream<Path> r15 = Files.newDirectoryStream(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r15, "it");     // Catch: Throwable -> L13
        Iterator<Path> r16 = r15.iterator();     // Catch: Throwable -> L13
    L8:
        if (r16.hasNext() == false) goto L10;
        r12.invoke(r16.next());     // Catch: Throwable -> L13
        goto L8
    L10:
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L13
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, null);
        InlineMarker.finallyEnd(1);
        return;
    L13:
        th = move-exception;
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Object getAttribute(Path r10, String r11, LinkOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attribute");
        Intrinsics.checkNotNullParameter(r12, "options");
        return Files.getAttribute(r10, r11, (LinkOption[]) Arrays.copyOf(r12, r12.length));
    }

    public static final String getExtension(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = r10.getFileName();
        if (r11 == null) goto L11;
        String r12 = r11.toString();
        if (r12 == null) goto L12;
        String r13 = StringsKt.substringAfterLast(r12, '.', "");
        if (r13 != null) goto L10;
        return "";
    L10:
        return r13;
    L12:
        return "";
    L11:
        return "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getExtension$annotations(Path r10) {
    }

    private static final String getInvariantSeparatorsPath(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return getInvariantSeparatorsPathString(r10);
    }

    @SinceKotlin(version = "1.4")
    @InlineOnly
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use invariantSeparatorsPathString property instead.", replaceWith = @ReplaceWith(expression = "invariantSeparatorsPathString", imports = {}))
    @ExperimentalPathApi
    public static /* synthetic */ void getInvariantSeparatorsPath$annotations(Path r10) {
    }

    public static final String getInvariantSeparatorsPathString(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        String r11 = r10.getFileSystem().getSeparator();
        if (Intrinsics.areEqual(r11, "/") == true) goto L6;
        String r12 = r10.toString();
        Intrinsics.checkNotNullExpressionValue(r11, "separator");
        return StringsKt.replace$default(r12, r11, "/", false, 4, null);
    L6:
        return r10.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getInvariantSeparatorsPathString$annotations(Path r10) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final FileTime getLastModifiedTime(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        FileTime r12 = Files.getLastModifiedTime(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "getLastModifiedTime(this, *options)");
        return r12;
    }

    public static final String getName(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = r10.getFileName();
        if (r11 == null) goto L5;
        String r12 = r11.toString();
    L6:
        if (r12 != null) goto L9;
        return "";
    L9:
        return r12;
    L5:
        r12 = null;
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getName$annotations(Path r10) {
    }

    public static final String getNameWithoutExtension(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = r10.getFileName();
        if (r11 == null) goto L8;
        String r12 = r11.toString();
        if (r12 == null) goto L8;
        String r13 = StringsKt.substringBeforeLast$default(r12, ".", null, 2, null);
        if (r13 == null) goto L8;
        return r13;
    L8:
        return "";
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static /* synthetic */ void getNameWithoutExtension$annotations(Path r10) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final UserPrincipal getOwner(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.getOwner(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    private static final String getPathString(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return r10.toString();
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    public static /* synthetic */ void getPathString$annotations(Path r10) {
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Set<PosixFilePermission> getPosixFilePermissions(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        Set<PosixFilePermission> r12 = Files.getPosixFilePermissions(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "getPosixFilePermissions(this, *options)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isDirectory(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.isDirectory(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isExecutable(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.isExecutable(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isHidden(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.isHidden(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isReadable(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.isReadable(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isRegularFile(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.isRegularFile(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isSameFileAs(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "other");
        return Files.isSameFile(r10, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isSymbolicLink(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.isSymbolicLink(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean isWritable(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return Files.isWritable(r10);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final List<Path> listDirectoryEntries(Path r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "glob");
        DirectoryStream<Path> r12 = Files.newDirectoryStream(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "it");     // Catch: Throwable -> L6
        List<Path> r13 = CollectionsKt.toList(r12);     // Catch: Throwable -> L6
        CloseableKt.closeFinally(r12, null);
        return r13;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        CloseableKt.closeFinally(r12, th);
        throw th;
    }

    public static /* synthetic */ List listDirectoryEntries$default(Path r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r11 = "*";
    L6:
        return listDirectoryEntries(r10, r11);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path moveTo(Path r10, Path r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r12 == false) goto L5;
        CopyOption[] r13 = {StandardCopyOption.REPLACE_EXISTING};
    L6:
        Path r14 = Files.move(r10, r11, (CopyOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "move(this, target, *options)");
        return r14;
    L5:
        r13 = new CopyOption[0];
        goto L6
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path moveTo(Path r10, Path r11, CopyOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r12, "options");
        Path r13 = Files.move(r10, r11, (CopyOption[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "move(this, target, *options)");
        return r13;
    }

    static /* synthetic */ Path moveTo$default(Path r10, Path r11, boolean r12, int r13, Object r14) {
        if ((r13 & 2) == 0) goto L5;
        r12 = false;
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, TypedValues.AttributesType.S_TARGET);
        if (r12 == false) goto L8;
        CopyOption[] r15 = {StandardCopyOption.REPLACE_EXISTING};
    L9:
        Path r16 = Files.move(r10, r11, (CopyOption[]) Arrays.copyOf(r15, r15.length));
        Intrinsics.checkNotNullExpressionValue(r16, "move(this, target, *options)");
        return r16;
    L8:
        r15 = new CopyOption[0];
        goto L9
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final boolean notExists(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return Files.notExists(r10, (LinkOption[]) Arrays.copyOf(r11, r11.length));
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final /* synthetic */ <A extends BasicFileAttributes> A readAttributes(Path r10, LinkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        Intrinsics.reifiedOperationMarker(4, "A");
        A r12 = (A) Files.readAttributes(r10, BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(r11, r11.length));
        Intrinsics.checkNotNullExpressionValue(r12, "readAttributes(this, A::class.java, *options)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Map<String, Object> readAttributes(Path r10, String r11, LinkOption... r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attributes");
        Intrinsics.checkNotNullParameter(r12, "options");
        Map<String, Object> r13 = Files.readAttributes(r10, r11, (LinkOption[]) Arrays.copyOf(r12, r12.length));
        Intrinsics.checkNotNullExpressionValue(r13, "readAttributes(this, attributes, *options)");
        return r13;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path readSymbolicLink(Path r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = Files.readSymbolicLink(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "readSymbolicLink(this)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeTo(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r10, r11);
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e.getMessage() + "\nthis path: " + r10 + "\nbase path: " + r11, e);
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrNull(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        return PathRelativizer.INSTANCE.tryRelativeTo(r10, r11);
    L5:
        return null;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    public static final Path relativeToOrSelf(Path r10, Path r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "base");
        Path r12 = relativeToOrNull(r10, r11);
        if (r12 != null) goto L6;
        return r10;
    L6:
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setAttribute(Path r10, String r11, Object r12, LinkOption... r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "attribute");
        Intrinsics.checkNotNullParameter(r13, "options");
        Path r14 = Files.setAttribute(r10, r11, r12, (LinkOption[]) Arrays.copyOf(r13, r13.length));
        Intrinsics.checkNotNullExpressionValue(r14, "setAttribute(this, attribute, value, *options)");
        return r14;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setLastModifiedTime(Path r10, FileTime r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Path r12 = Files.setLastModifiedTime(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "setLastModifiedTime(this, value)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setOwner(Path r10, UserPrincipal r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Path r12 = Files.setOwner(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "setOwner(this, value)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path setPosixFilePermissions(Path r10, Set<? extends PosixFilePermission> r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        Path r12 = Files.setPosixFilePermissions(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r12, "setPosixFilePermissions(this, value)");
        return r12;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final Path toPath(URI r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Path r11 = Paths.get(r10);
        Intrinsics.checkNotNullExpressionValue(r11, "get(this)");
        return r11;
    }

    @SinceKotlin(version = "1.5")
    @WasExperimental(markerClass = {ExperimentalPathApi.class})
    @InlineOnly
    private static final <T> T useDirectoryEntries(Path r10, String r11, Function1<? super Sequence<? extends Path>, ? extends T> r12) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "glob");
        Intrinsics.checkNotNullParameter(r12, "block");
        DirectoryStream<Path> r13 = Files.newDirectoryStream(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r13, "it");     // Catch: Throwable -> L6
        T r14 = r12.invoke(CollectionsKt.asSequence(r13));     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, null);
        InlineMarker.finallyEnd(1);
        return r14;
    L6:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r13, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    static /* synthetic */ Object useDirectoryEntries$default(Path r10, String r11, Function1 r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L5;
        r11 = "*";
    L5:
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "glob");
        Intrinsics.checkNotNullParameter(r12, "block");
        DirectoryStream<Path> r15 = Files.newDirectoryStream(r10, r11);
        Intrinsics.checkNotNullExpressionValue(r15, "it");     // Catch: Throwable -> L9
        Object r16 = r12.invoke(CollectionsKt.asSequence(r15));     // Catch: Throwable -> L9
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, null);
        InlineMarker.finallyEnd(1);
        return r16;
    L9:
        th = move-exception;
        throw th;     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        InlineMarker.finallyStart(1);
        CloseableKt.closeFinally(r15, th);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(Path r10, int r11, boolean r12, Function1<? super FileVisitorBuilder, Unit> r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r13, "builderAction");
        visitFileTree(r10, fileVisitor(r13), r11, r12);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final void visitFileTree(Path r10, FileVisitor<Path> r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "visitor");
        if (r13 == false) goto L5;
        Set r14 = SetsKt.setOf(FileVisitOption.FOLLOW_LINKS);
    L6:
        Files.walkFileTree(r10, r14, r12, r11);
        return;
    L5:
        r14 = SetsKt.emptySet();
        goto L6
    }

    public static /* synthetic */ void visitFileTree$default(Path r10, int r11, boolean r12, Function1 r13, int r14, Object r15) {
        if ((r14 & 1) == 0) goto L6;
        r11 = Integer.MAX_VALUE;
    L6:
        if ((r14 & 2) == 0) goto L8;
        r12 = false;
    L8:
        visitFileTree(r10, r11, r12, r13);
    }

    public static /* synthetic */ void visitFileTree$default(Path r10, FileVisitor r11, int r12, boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = Integer.MAX_VALUE;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = false;
    L8:
        visitFileTree(r10, r11, r12, r13);
    }

    @SinceKotlin(version = "1.7")
    @ExperimentalPathApi
    public static final Sequence<Path> walk(Path r10, PathWalkOption... r11) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        Intrinsics.checkNotNullParameter(r11, "options");
        return new PathTreeWalk(r10, r11);
    }
}
