package kotlin.io.path;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0007j\u0002`\bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fR\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", "limit", "", "(I)V", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", "path", "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "<set-?>", "totalExceptions", "getTotalExceptions", "()I", "collect", "", CommonConsts.LOG_REPORT_TYPE_EXCEPTION, "enterEntry", ActivityLifecycle.NAME, "exitEntry", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ExceptionsCollector {
    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        this(0, 1, null);
    }

    public ExceptionsCollector(int r3) {
        this.limit = r3;
        this.collectedExceptions = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    public /* synthetic */ ExceptionsCollector(int r1, int r2, DefaultConstructorMarker r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = 64;
    L5:
        this(r1);
    }

    public final void collect(Exception r4) {
        Intrinsics.checkNotNullParameter(r4, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        boolean r1 = true;
        this.totalExceptions++;
        if (this.collectedExceptions.size() < this.limit) goto L6;
        r1 = false;
    L6:
        if (r1 == true) goto L8;
        return;
    L8:
        if (this.path == null) goto L10;
        Throwable r5 = new FileSystemException(String.valueOf(this.path)).initCause((Throwable) ZeusTransformUtils.preCheckCast(r4, Throwable.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type java.nio.file.FileSystemException");
        r4 = (Exception) ZeusTransformUtils.preCheckCast((FileSystemException) ZeusTransformUtils.preCheckCast(r5, FileSystemException.class, "com.obric.memorydata.plugin"), Exception.class, "com.obric.memorydata.plugin");
    L10:
        this.collectedExceptions.add(r4);
    }

    public final void enterEntry(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Path r0 = this.path;
        if (r0 == null) goto L5;
        Path r5 = r0.resolve(r4);
    L6:
        this.path = r5;
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final void exitEntry(Path r3) {
        Path r4 = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, ActivityLifecycle.NAME);
        Path r0 = this.path;
        Path r1 = null;
        if (r0 == null) goto L5;
        Path r2 = r0.getFileName();
    L7:
        if (Intrinsics.areEqual(r4, r2) == false) goto L14;
        Path r5 = this.path;
        if (r5 == null) goto L11;
        r1 = r5.getParent();
    L11:
        this.path = r1;
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r2 = null;
        goto L7
    }

    public final List<Exception> getCollectedExceptions() {
        return this.collectedExceptions;
    }

    public final Path getPath() {
        return this.path;
    }

    public final int getTotalExceptions() {
        return this.totalExceptions;
    }

    public final void setPath(Path r3) {
        this.path = (Path) ZeusTransformUtils.wrapperContextForParams(r3, Path.class, "com.obric.memorydata.plugin");
    }
}
