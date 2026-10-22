package com.bytedance.geckox.buffer.impl;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.d;
import com.lynx.serval.svg.SVGRenderEngine;
import java.io.File;
import kotlin.Metadata;
import la.a;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0013\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u0016\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0010H\u0082 ¢\u0006\u0004\b\u0016\u0010\u0014J(\u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MemoryBuffer;", "Lla/a;", "", "nPtr", "length", "", "nRelease", "(JJ)V", "", SVGRenderEngine.PATH, "nCreate", "(Ljava/lang/String;J)J", "ptr", "offset", "", "bytes", "", "off", "len", "nWrite", "(JJ[BII)V", "cursor", "nRead", "nFlush", "(JLjava/lang/String;J)V", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MemoryBuffer implements a {
    static {
        d.h("buffer");
    }

    private final native long nCreate(String r5, long r10);

    private final native void nFlush(long r5, String r10, long r11);

    private final native void nRead(long r5, long r10, byte[] r11, int r12, int r13);

    private final native void nRelease(long r5, long r10);

    private final native void nWrite(long r5, long r10, byte[] r11, int r12, int r13);

    @Override // la.a
    public final synchronized long a(long r5) {
        monitor-enter(this);
        throw null;     // Catch: Throwable -> L5
    L5:
        th = move-exception;
        throw th;
    }

    @Override // la.a
    public final File b() {
        return null;
    }

    @Override // la.a
    public final long c() {
        throw null;
    }

    @Override // la.a
    public final void d() {
        throw null;
    }

    @Override // la.a
    public final void e() {
        throw null;
    }

    public final void finalize() {
        throw null;     // Catch: Exception -> L4
    L4:
        e = move-exception;
        GeckoLogger.a("finalize:", e);
    }

    @Override // la.a
    /* JADX INFO: renamed from: finish */
    public final void mo119finish() {
    }

    @Override // la.a
    public final void g(long r5) {
        throw null;
    }

    @Override // la.a
    public final long length() {
        return 0;
    }

    @Override // la.a
    public final void release() {
        throw null;
    }

    @Override // la.a
    public final void write(int r5) {
        throw null;
    }

    @Override // la.a
    public final int a() {
        throw null;
    }

    @Override // la.a
    public final int b(byte[] r5) {
        int r10 = r5.length;
        throw null;
    }

    @Override // la.a
    public final int c(byte[] r5, int r10, int r11) {
        throw null;
    }

    @Override // la.a
    public final void write(byte[] r5) {
        int r10 = r5.length;
        throw null;
    }

    @Override // la.a
    public final int write(byte[] r5, int r10, int r11) {
        throw null;
    }
}
