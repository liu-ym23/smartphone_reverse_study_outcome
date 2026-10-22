package kotlin.io.path;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
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
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0082\b¢\u0006\u0002\b\u0006\u001a\u001d\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\n\u001a'\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b\u000e\u001a&\u0010\u000f\u001a\u0004\u0018\u0001H\u0010\"\u0004\b\u0000\u0010\u00102\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0005H\u0082\b¢\u0006\u0004\b\u0011\u0010\u0012\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\tH\u0000\u001a\u0019\u0010\u0014\u001a\u00020\u0001*\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002¢\u0006\u0002\b\u0015\u001aw\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\b\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0007\u001a´\u0001\u0010\u0016\u001a\u00020\t*\u00020\t2\u0006\u0010\u0017\u001a\u00020\t2Q\b\u0002\u0010\u0018\u001aK\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0017\u0012\u00150\u001dj\u0002`\u001e¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020 0\u00192\u0006\u0010!\u001a\u00020\"2C\b\u0002\u0010$\u001a=\u0012\u0004\u0012\u00020%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020&0\u0019¢\u0006\u0002\b'H\u0007\u001a\f\u0010(\u001a\u00020\u0001*\u00020\tH\u0007\u001a\u001b\u0010)\u001a\f\u0012\b\u0012\u00060\u001dj\u0002`\u001e0**\u00020\tH\u0002¢\u0006\u0002\b+\u001a'\u0010,\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b.\u001a1\u0010/\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u0010\u001b\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\b0\u001a5\u00101\u001a\u00020\"*\b\u0012\u0004\u0012\u00020\t0-2\u0006\u00102\u001a\u00020\t2\u0012\u00103\u001a\n\u0012\u0006\b\u0001\u0012\u00020504\"\u000205H\u0002¢\u0006\u0004\b6\u00107\u001a\u0011\u00108\u001a\u000209*\u00020&H\u0003¢\u0006\u0002\b:\u001a\u0011\u00108\u001a\u000209*\u00020 H\u0003¢\u0006\u0002\b:¨\u0006;"}, d2 = {"collectIfThrows", "", "collector", "Lkotlin/io/path/ExceptionsCollector;", "function", "Lkotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "Ljava/nio/file/Path;", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "insecureHandleEntry", "entry", "parent", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "copyToRecursively", TypedValues.AttributesType.S_TARGET, "onError", "Lkotlin/Function3;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, AILabCheckPermissionTask.KEY_SOURCE, "Ljava/lang/Exception;", "Lkotlin/Exception;", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "Lkotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lkotlin/io/path/CopyActionContext;", "Lkotlin/io/path/CopyActionResult;", "Lkotlin/ExtensionFunctionType;", "deleteRecursively", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "Ljava/nio/file/SecureDirectoryStream;", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "handleEntry", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "kotlin-stdlib-jdk7"}, k = 5, mv = {1, 9, 0}, xi = 49, xs = "kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r0 = new int[CopyActionResult.values().length];
            r0[CopyActionResult.CONTINUE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[CopyActionResult.TERMINATE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L23:
            r0[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L7:
            $EnumSwitchMapping$0 = r0;
            int[] r1 = new int[OnErrorResult.values().length];
            r1[OnErrorResult.TERMINATE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L15
        L19:
            r1[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L16
        L10:
            $EnumSwitchMapping$1 = r1;
        }
    }

    public PathsKt__PathRecursiveFunctionsKt() {
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$copy(ArrayList r9, Function3 r10, Path r11, Path r12, Path r13, Function3 r14, Path r15, BasicFileAttributes r16) {
        return copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(r9, (Function3) ZeusTransformUtils.wrapperContextForParams(r10, Function3.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r11, Path.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r12, Path.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r13, Path.class, "com.obric.memorydata.plugin"), (Function3) ZeusTransformUtils.wrapperContextForParams(r14, Function3.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r15, Path.class, "com.obric.memorydata.plugin"), (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r16, BasicFileAttributes.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ FileVisitResult access$copyToRecursively$error(Function3 r8, Path r9, Path r10, Path r11, Path r12, Exception r13) {
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt((Function3) ZeusTransformUtils.wrapperContextForParams(r8, Function3.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r11, Path.class, "com.obric.memorydata.plugin"), (Path) ZeusTransformUtils.wrapperContextForParams(r12, Path.class, "com.obric.memorydata.plugin"), r13);
    }

    public static final void checkFileName(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<this>");
        String r0 = PathsKt.getName(r4);
        int r1 = r0.hashCode();
        if (r1 == 46) goto L31;
        if (r1 == 1518) goto L28;
        if (r1 == 45679) goto L25;
        if (r1 == 45724) goto L22;
        if (r1 == 1472) goto L19;
        if (r1 == 1473) goto L16;
        return;
    L16:
        if (r0.equals("./") == true) goto L34;
        return;
    L34:
        throw new IllegalFileNameException(r4);
    L19:
        if (r0.equals("..") == true) goto L34;
        return;
    L22:
        if (r0.equals("..\\") == true) goto L34;
        return;
    L25:
        if (r0.equals("../") == true) goto L34;
        return;
    L28:
        if (r0.equals(".\\") == true) goto L34;
        return;
    L31:
        if (r0.equals(".") == true) goto L34;
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path r2, Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        if (Files.isSymbolicLink(r4) == false) goto L5;
        return;
    L5:
        if (Files.isSameFile(r4, r5) == true) goto L8;
        return;
    L8:
        throw new FileSystemLoopException(r4.toString());
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector r2, Function0<Unit> r3) {
        ((Function0) ZeusTransformUtils.wrapperContextForParams(r3, Function0.class, "com.obric.memorydata.plugin")).invoke();     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        r2.collect(e);
    }

    public static final Path copyToRecursively(Path r9, Path r10, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r11, boolean r12, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r13) {
        final Path r14 = (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.memorydata.plugin");
        final Path r15 = (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.memorydata.plugin");
        final Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r11, Function3.class, "com.obric.memorydata.plugin");
        final Function3 r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r13, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, "<this>");
        Intrinsics.checkNotNullParameter(r15, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r8, "onError");
        Intrinsics.checkNotNullParameter(r4, "copyAction");
        LinkOption[] r16 = LinkFollowing.INSTANCE.toLinkOptions(r12);
        LinkOption[] r17 = (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r16, r16.length), LinkOption[].class, "com.obric.memorydata.plugin");
        if (Files.exists(r14, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r17, r17.length), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L37;
        boolean r18 = false;
        if (Files.exists(r14, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[0], 0), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L34;
        if (r12 == true) goto L10;
        if (Files.isSymbolicLink(r14) == true) goto L34;
    L10:
        if (Files.exists(r15, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[0], 0), LinkOption[].class, "com.obric.memorydata.plugin")) == true) goto L12;
    L14:
        boolean r19 = false;
    L15:
        if (r19 == false) goto L19;
        if (Files.isSameFile(r14, r15) == true) goto L34;
    L19:
        if (Intrinsics.areEqual(r14.getFileSystem(), r15.getFileSystem()) == false) goto L30;
        if (r19 == false) goto L23;
        r18 = r15.toRealPath(new LinkOption[0]).startsWith(r14.toRealPath(new LinkOption[0]));
        goto L30
    L23:
        Path r110 = r15.getParent();
        if (r110 == null) goto L30;
        if (Files.exists(r110, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[0], 0), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L30;
        if (r110.toRealPath(new LinkOption[0]).startsWith(r14.toRealPath(new LinkOption[0])) == false) goto L30;
        r18 = true;
    L30:
        if (r18 == false) goto L34;
        throw new FileSystemException(r14.toString(), r15.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
    L12:
        if (Files.isSymbolicLink(r15) == true) goto L14;
        r19 = true;
    L34:
        final Path r7 = r15.normalize();
        final ArrayList r3 = new ArrayList();
        PathsKt.visitFileTree$default(r14, 0, r12, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass5(r3, r4, r14, r15, r7, r8), Function1.class, "com.obric.memorydata.plugin"), 1, null);
        return r15;
    L37:
        throw new NoSuchFileException(r14.toString(), r15.toString(), "The source file doesn't exist.");
    }

    public static final Path copyToRecursively(Path r9, Path r10, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r11, final boolean r12, boolean r13) {
        Path r2 = (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.memorydata.plugin");
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.memorydata.plugin");
        Function3 r4 = (Function3) ZeusTransformUtils.wrapperContextForParams(r11, Function3.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Intrinsics.checkNotNullParameter(r3, TypedValues.AttributesType.S_TARGET);
        Intrinsics.checkNotNullParameter(r4, "onError");
        if (r13 == false) goto L6;
        return PathsKt.copyToRecursively(r2, r3, r4, r12, (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r12), Function3.class, "com.obric.memorydata.plugin"));
    L6:
        return PathsKt.copyToRecursively$default(r2, r3, r4, r12, null, 8, null);
    }

    private static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> r8, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> r9, Path r10, Path r11, Path r12, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r13, Path r14, BasicFileAttributes r15) {
        Function3 r16 = (Function3) ZeusTransformUtils.wrapperContextForParams(r9, Function3.class, "com.obric.memorydata.plugin");
        Path r3 = (Path) ZeusTransformUtils.wrapperContextForParams(r10, Path.class, "com.obric.memorydata.plugin");
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r11, Path.class, "com.obric.memorydata.plugin");
        Path r5 = (Path) ZeusTransformUtils.wrapperContextForParams(r12, Path.class, "com.obric.memorydata.plugin");
        Function3 r2 = (Function3) ZeusTransformUtils.wrapperContextForParams(r13, Function3.class, "com.obric.memorydata.plugin");
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r14, Path.class, "com.obric.memorydata.plugin");
        BasicFileAttributes r17 = (BasicFileAttributes) ZeusTransformUtils.wrapperContextForParams(r15, BasicFileAttributes.class, "com.obric.memorydata.plugin");
    L8:
        e = move-exception;
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(r2, r3, r4, r5, r6, e);
    L4:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L6;
        PathsKt.checkFileName(r6);     // Catch: Exception -> L8
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r6, (Path) ZeusTransformUtils.preCheckCast(CollectionsKt.last((List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.memorydata.plugin")), Path.class, "com.obric.memorydata.plugin"));     // Catch: Exception -> L8
    L6:
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((CopyActionResult) ZeusTransformUtils.preCheckCast(r16.invoke(DefaultCopyActionContext.INSTANCE, r6, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r3, r4, r5, r6)), CopyActionResult.class, "com.obric.memorydata.plugin"));
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r1, Path r2, Function3 r3, final boolean r4, Function3 r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Path r9 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Function3 r11 = (Function3) ZeusTransformUtils.wrapperContextForParams(r5, Function3.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r10 = (Function3) ZeusTransformUtils.preCheckCast(AnonymousClass3.INSTANCE, Function3.class, "com.obric.memorydata.plugin");
    L6:
        if ((r6 & 8) == 0) goto L9;
        r11 = (Function3) ZeusTransformUtils.preCheckCast(new AnonymousClass4(r4), Function3.class, "com.obric.memorydata.plugin");
    L9:
        return PathsKt.copyToRecursively(r8, r9, r10, r4, r11);
    }

    public static /* synthetic */ Path copyToRecursively$default(Path r1, Path r2, Function3 r3, boolean r4, boolean r5, int r6, Object r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r1, Path.class, "com.obric.memorydata.plugin");
        Path r9 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Function3 r10 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r10 = (Function3) ZeusTransformUtils.preCheckCast(AnonymousClass1.INSTANCE, Function3.class, "com.obric.memorydata.plugin");
    L6:
        return PathsKt.copyToRecursively(r8, r9, r10, r4, r5);
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path r2, Path r3, Path r4, Path r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r2, Path.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Path r9 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Path r10 = r7.resolve(PathsKt.relativeTo(r9, r6).toString());
        if (r10.normalize().startsWith(r8) == false) goto L7;
        Intrinsics.checkNotNull(r10);
        return r10;
    L7:
        throw new IllegalFileNameException(r9, r10, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
    }

    private static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> r2, Path r3, Path r4, Path r5, Path r6, Exception r7) {
        Function3 r8 = (Function3) ZeusTransformUtils.wrapperContextForParams(r2, Function3.class, "com.obric.memorydata.plugin");
        Path r9 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r10 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Path r11 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Path r12 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin");
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt((OnErrorResult) ZeusTransformUtils.preCheckCast(r8.invoke(r12, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(r9, r10, r11, r12), r7), OnErrorResult.class, "com.obric.memorydata.plugin"));
    }

    public static final void deleteRecursively(Path r5) {
        Path r6 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "<this>");
        List<Exception> r7 = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(r6);
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r7, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L10;
        FileSystemException r0 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L6:
        if (r8.hasNext() == false) goto L9;
        ExceptionsKt.addSuppressed((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"), (Throwable) ZeusTransformUtils.preCheckCast((Exception) ZeusTransformUtils.preCheckCast(r8.next(), Exception.class, "com.obric.memorydata.plugin"), Throwable.class, "com.obric.memorydata.plugin"));
        goto L6
    L9:
        throw ((Throwable) ZeusTransformUtils.preCheckCast(r0, Throwable.class, "com.obric.memorydata.plugin"));
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path r9) {
        Path r10 = (Path) ZeusTransformUtils.wrapperContextForParams(r9, Path.class, "com.obric.memorydata.plugin");
        boolean r2 = false;
        boolean r3 = true;
        ExceptionsCollector r0 = new ExceptionsCollector(0, 1, null);
        Path r5 = r10.getParent();
        if (r5 != null) goto L28;
    L20:
        if (r3 == false) goto L23;
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r10, null, r0);
    L23:
        return r0.getCollectedExceptions();
    L28:
        DirectoryStream<Path> r6 = Files.newDirectoryStream(r5);     // Catch: Throwable -> L6
    L7:
        if (r6 == null) goto L20;
        Closeable r7 = (Closeable) ZeusTransformUtils.preCheckCast(r6, Closeable.class, "com.obric.memorydata.plugin");
        DirectoryStream r8 = (DirectoryStream) ZeusTransformUtils.preCheckCast(r7, DirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (ZeusTransformUtils.instanceOf(r8, SecureDirectoryStream.class) == false) goto L12;
        r0.setPath(r5);     // Catch: Throwable -> L15
        SecureDirectoryStream r1 = (SecureDirectoryStream) ZeusTransformUtils.preCheckCast(r8, SecureDirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        Path r4 = r10.getFileName();     // Catch: Throwable -> L15
        Intrinsics.checkNotNullExpressionValue(r4, "getFileName(...)");     // Catch: Throwable -> L15
        handleEntry$PathsKt__PathRecursiveFunctionsKt(r1, r4, null, r0);     // Catch: Throwable -> L15
    L13:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L15
        CloseableKt.closeFinally(r7, null);
        r3 = r2;
        goto L20
    L12:
        r2 = true;
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        CloseableKt.closeFinally(r7, th);
        throw th;
    L6:
        r6 = null;
        goto L7
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r5, Path r6, ExceptionsCollector r7) {
        SecureDirectoryStream r8 = ((SecureDirectoryStream) ZeusTransformUtils.wrapperContextForParams(r5, SecureDirectoryStream.class, "com.obric.memorydata.plugin")).newDirectoryStream((Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin"), new LinkOption[]{LinkOption.NOFOLLOW_LINKS});     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r8 == null) goto L31;
        Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        SecureDirectoryStream r10 = (SecureDirectoryStream) ZeusTransformUtils.preCheckCast(r9, SecureDirectoryStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Iterator r0 = r10.iterator();     // Catch: Throwable -> L17
    L12:
        if (r0.hasNext() == false) goto L14;
        Path r3 = ((Path) ZeusTransformUtils.preCheckCast(r0.next(), Path.class, "com.obric.memorydata.plugin")).getFileName();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r3, "getFileName(...)");     // Catch: Throwable -> L17
        handleEntry$PathsKt__PathRecursiveFunctionsKt(r10, r3, r7.getPath(), r7);     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r9, null);     // Catch: Exception -> L5
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r9, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r7.collect(e);
        return;
    L7:
        r8 = null;
        goto L8
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r2, Path r3, Path r4, ExceptionsCollector r5) {
        SecureDirectoryStream r6 = (SecureDirectoryStream) ZeusTransformUtils.wrapperContextForParams(r2, SecureDirectoryStream.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        r5.enterEntry(r7);
        if (r8 == null) goto L18;
        Path r0 = r5.getPath();     // Catch: Exception -> L13
        Intrinsics.checkNotNull(r0);     // Catch: Exception -> L13
        PathsKt.checkFileName(r0);     // Catch: Exception -> L13
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r0, r8);     // Catch: Exception -> L13
    L13:
        e = move-exception;
        r5.collect(e);
    L15:
        r5.exitEntry(r7);
        return;
    L18:
        if (isDirectory$PathsKt__PathRecursiveFunctionsKt(r6, r7, new LinkOption[]{LinkOption.NOFOLLOW_LINKS}) == false) goto L11;
        int r9 = r5.getTotalExceptions();     // Catch: Exception -> L13
        enterDirectory$PathsKt__PathRecursiveFunctionsKt(r6, r7, r5);     // Catch: Exception -> L13
        if (r9 != r5.getTotalExceptions()) goto L15;
        r6.deleteDirectory(r7);     // Catch: Exception -> L13 NoSuchFileException -> L17
    L10:
        Unit r10 = Unit.INSTANCE;     // Catch: Exception -> L13 NoSuchFileException -> L17
        goto L15
    L11:
        r6.deleteFile(r7);     // Catch: Exception -> L13 NoSuchFileException -> L17
        goto L10
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path r6, ExceptionsCollector r7) {
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r6, Path.class, "com.obric.memorydata.plugin");
        DirectoryStream<Path> r2 = Files.newDirectoryStream(r8);     // Catch: Exception -> L5 NoSuchFileException -> L7
    L8:
        if (r2 == null) goto L31;
        Closeable r3 = (Closeable) ZeusTransformUtils.preCheckCast(r2, Closeable.class, "com.obric.memorydata.plugin");     // Catch: Exception -> L5
        Iterator r4 = ((DirectoryStream) ZeusTransformUtils.preCheckCast(r3, DirectoryStream.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
    L12:
        if (r4.hasNext() == false) goto L14;
        Path r5 = (Path) ZeusTransformUtils.preCheckCast(r4.next(), Path.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        Intrinsics.checkNotNull(r5);     // Catch: Throwable -> L17
        insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(r5, r8, r7);     // Catch: Throwable -> L17
        goto L12
    L14:
        Unit r9 = Unit.INSTANCE;     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r3, null);     // Catch: Exception -> L5
        return;
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r3, th);     // Catch: Exception -> L5
        throw th;     // Catch: Exception -> L5
    L31:
        return;
    L5:
        e = move-exception;
        r7.collect(e);
        return;
    L7:
        r2 = null;
        goto L8
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path r4, Path r5, ExceptionsCollector r6) {
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Path r8 = (Path) ZeusTransformUtils.wrapperContextForParams(r5, Path.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        PathsKt.checkFileName(r7);     // Catch: Exception -> L11
        checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(r7, r8);     // Catch: Exception -> L11
    L11:
        e = move-exception;
        r6.collect(e);
        return;
    L6:
        if (Files.isDirectory(r7, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1), LinkOption[].class, "com.obric.memorydata.plugin")) == false) goto L9;
        int r9 = r6.getTotalExceptions();     // Catch: Exception -> L11
        insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(r7, r6);     // Catch: Exception -> L11
        if (r9 == r6.getTotalExceptions()) goto L9;
        return;
    L9:
        Files.deleteIfExists(r7);     // Catch: Exception -> L11
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> r3, Path r4, LinkOption... r5) {
        SecureDirectoryStream r6 = (SecureDirectoryStream) ZeusTransformUtils.wrapperContextForParams(r3, SecureDirectoryStream.class, "com.obric.memorydata.plugin");
        Path r7 = (Path) ZeusTransformUtils.wrapperContextForParams(r4, Path.class, "com.obric.memorydata.plugin");
        Boolean r8 = Boolean.valueOf(((BasicFileAttributeView) ZeusTransformUtils.preCheckCast(r6.getFileAttributeView(r7, BasicFileAttributeView.class, (LinkOption[]) ZeusTransformUtils.preCheckCast(Arrays.copyOf(r5, r5.length), LinkOption[].class, "com.obric.memorydata.plugin")), BasicFileAttributeView.class, "com.obric.memorydata.plugin")).readAttributes().isDirectory());     // Catch: NoSuchFileException -> L5
    L6:
        if (r8 != null) goto L12;
        return false;
    L12:
        return r8.booleanValue();
    L5:
        r8 = null;
        goto L6
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$0[r1.ordinal()];
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L15;
        if (r2 != 3) goto L10;
        return FileVisitResult.SKIP_SUBTREE;
    L10:
        throw new NoWhenBranchMatchedException();
    L15:
        return FileVisitResult.TERMINATE;
    L13:
        return FileVisitResult.CONTINUE;
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult r1) {
        int r2 = WhenMappings.$EnumSwitchMapping$1[r1.ordinal()];
        if (r2 == 1) goto L10;
        if (r2 != 2) goto L8;
        return FileVisitResult.SKIP_SUBTREE;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return FileVisitResult.TERMINATE;
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> r2) {
        return (R) ((Function0) ZeusTransformUtils.wrapperContextForParams(r2, Function0.class, "com.obric.memorydata.plugin")).invoke();
    L5:
        return null;
    }
}
