package com.obric.memorydata.database.util.file_utils;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/memorydata/database/util/file_utils/PptxStableSnapshot;", "", "<init>", "()V", "BUFFER_SIZE", "", "FILE_PREFIX", "", "create", "Lcom/obric/memorydata/database/util/file_utils/PptxSnapshotResult;", "inputStream", "Ljava/io/InputStream;", "directory", "Ljava/io/File;", "maxBytes", "", "database_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f9676a = null;

    static {
        f9676a = new z();
    }

    private z() {
    }

    public static /* synthetic */ y a(z r0, InputStream r1, File r2, long r3, int r5, Object r6) {
        if ((r5 & 4) == 0) goto L6;
        r3 = 15728640;
    L6:
        return r0.a(r1, r2, r3);
    }

    public final y a(InputStream r11, File r12, long r13) {
        Intrinsics.checkNotNullParameter(r11, "inputStream");
        Intrinsics.checkNotNullParameter(r12, "directory");
        long r0 = 0;
        if (r13 <= 0) goto L5;
        boolean r2 = true;
    L6:
        if (r2 == false) goto L38;
        if (r12.exists() == false) goto L10;
    L14:
        File r14 = File.createTempFile("pptx_preflight_", ".pptx", r12);
        byte[] r3 = new byte[8192];     // Catch: Throwable -> L34
        Closeable r4 = (Closeable) ZeusTransformUtils.preCheckCast(new FileOutputStream(r14), Closeable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L34
        FileOutputStream r6 = (FileOutputStream) ZeusTransformUtils.preCheckCast(r4, FileOutputStream.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
    L18:
        int r7 = r11.read(r3);     // Catch: Throwable -> L29
        if (r7 < 0) goto L26;
        r0 = r0 + ((long) r7);     // Catch: Throwable -> L29
        if (r0 >= r13) goto L22;
        r6.write(r3, 0, r7);     // Catch: Throwable -> L29
        goto L18
    L22:
        r14.delete();     // Catch: Throwable -> L29
        y r10 = (y) ZeusTransformUtils.preCheckCast(new y.b(r0), y.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L34
        return r10;
    L26:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L29
        CloseableKt.closeFinally(r4, null);     // Catch: Throwable -> L34
        r14.setReadOnly();     // Catch: Throwable -> L34
        Intrinsics.checkNotNull(r14);     // Catch: Throwable -> L34
        return (y) ZeusTransformUtils.preCheckCast(new y.a(r14), y.class, "com.obric.memorydata.plugin");
    L29:
        th = move-exception;
        throw th;     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        CloseableKt.closeFinally(r4, th);     // Catch: Throwable -> L34
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r14.delete();
        throw th;
    L10:
        if (r12.mkdirs() == true) goto L14;
        throw new IOException("Unable to create PPTX snapshot directory");
    L38:
        throw new IllegalArgumentException("maxBytes must be positive".toString());
    L5:
        r2 = false;
        goto L6
    }
}
