package kotlin.io.path;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
final class ExceptionsCollector {
    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        this(0, 1, null);
    }

    public ExceptionsCollector(int r10) {
        this.limit = r10;
        this.collectedExceptions = new ArrayList();
    }

    public /* synthetic */ ExceptionsCollector(int r10, int r11, DefaultConstructorMarker r12) {
        if ((r11 & 1) == 0) goto L5;
        r10 = 64;
    L5:
        this(r10);
    }

    public final void collect(Exception r10) {
        Intrinsics.checkNotNullParameter(r10, CommonConsts.LOG_REPORT_TYPE_EXCEPTION);
        boolean r11 = true;
        this.totalExceptions++;
        if (this.collectedExceptions.size() < this.limit) goto L6;
        r11 = false;
    L6:
        if (r11 == true) goto L8;
        return;
    L8:
        if (this.path == null) goto L10;
        Throwable r12 = new FileSystemException(String.valueOf(this.path)).initCause(r10);
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type java.nio.file.FileSystemException");
        r10 = (FileSystemException) r12;
    L10:
        this.collectedExceptions.add(r10);
    }

    public final void enterEntry(Path r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Path r11 = this.path;
        if (r11 == null) goto L5;
        Path r12 = r11.resolve(r10);
    L6:
        this.path = r12;
        return;
    L5:
        r12 = null;
        goto L6
    }

    public final void exitEntry(Path r10) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Path r11 = this.path;
        Path r12 = null;
        if (r11 == null) goto L5;
        Path r13 = r11.getFileName();
    L7:
        if (Intrinsics.areEqual(r10, r13) == false) goto L14;
        Path r14 = this.path;
        if (r14 == null) goto L11;
        r12 = r14.getParent();
    L11:
        this.path = r12;
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.".toString());
    L5:
        r13 = null;
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

    public final void setPath(Path r10) {
        this.path = r10;
    }
}
