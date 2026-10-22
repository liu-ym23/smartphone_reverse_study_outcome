package kotlin.io.path;

import com.lynx.serval.svg.SVGRenderEngine;
import java.nio.file.FileSystemException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u00060\u0007j\u0002`\bJ\u000e\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fJ\u000e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\fR\u001b\u0010\u0005\u001a\f\u0012\b\u0012\u00060\u0007j\u0002`\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u0003@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001b"}, d2 = {"Lkotlin/io/path/ExceptionsCollector;", "", "limit", "", "(I)V", "collectedExceptions", "", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getCollectedExceptions", "()Ljava/util/List;", SVGRenderEngine.PATH, "Ljava/nio/file/Path;", "getPath", "()Ljava/nio/file/Path;", "setPath", "(Ljava/nio/file/Path;)V", "<set-?>", "totalExceptions", "getTotalExceptions", "()I", "collect", "", "exception", "enterEntry", "name", "exitEntry", "kotlin-stdlib-jdk7"}, k = 1, mv = {1, 9, 0}, xi = 48)
final class ExceptionsCollector {
    private final List<Exception> collectedExceptions;
    private final int limit;
    private Path path;
    private int totalExceptions;

    public ExceptionsCollector() {
        int r5 = 0;
        this(r5, 1, null);
    }

    public final void collect(Exception r5) {
        Intrinsics.checkNotNullParameter(r5, "exception");
        this.totalExceptions++;
        if (this.collectedExceptions.size() < this.limit) goto L5;
        return;
    L5:
        if (this.path == null) goto L7;
        Throwable r10 = new FileSystemException(String.valueOf(this.path)).initCause(r5);
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type java.nio.file.FileSystemException");
        r5 = (FileSystemException) r10;
    L7:
        this.collectedExceptions.add(r5);
    }

    public final void enterEntry(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Path r10 = this.path;
        if (r10 == null) goto L5;
        Path r11 = r10.resolve(r5);
    L6:
        this.path = r11;
        return;
    L5:
        r11 = null;
        goto L6
    }

    public final void exitEntry(Path r5) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Path r10 = this.path;
        Path r11 = null;
        if (r10 == null) goto L5;
        Path r12 = r10.getFileName();
    L7:
        if (Intrinsics.areEqual(r5, r12) == false) goto L14;
        Path r13 = this.path;
        if (r13 == null) goto L11;
        r11 = r13.getParent();
    L11:
        this.path = r11;
        return;
    L14:
        throw new IllegalArgumentException("Failed requirement.");
    L5:
        r12 = null;
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

    public final void setPath(Path r5) {
        this.path = r5;
    }

    public ExceptionsCollector(int r5) {
        this.limit = r5;
        this.collectedExceptions = new ArrayList();
    }

    public /* synthetic */ ExceptionsCollector(int r5, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        r5 = 64;
    L5:
        this(r5);
    }
}
