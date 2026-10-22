package com.bytedance.geckox.buffer.impl;

import com.bytedance.geckox.logger.GeckoLogger;
import com.bytedance.geckox.utils.d;
import com.bytedance.iesgurd.core.EventSubType;
import com.lynx.serval.svg.SVGRenderEngine;
import com.lynx.tasm.utils.j;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import la.a;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001J \u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\n\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\n\u0010\u000bJ8\u0010\u0013\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0082 ¢\u0006\u0004\b\u0013\u0010\u0014J8\u0010\u0016\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0005H\u0082 ¢\u0006\u0004\b\u0016\u0010\u0014J \u0010\u0017\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0082 ¢\u0006\u0004\b\u0017\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/bytedance/geckox/buffer/impl/MMapBuffer;", "Lla/a;", "", "nPtr", "length", "", "nRelease", "(JJ)I", "", SVGRenderEngine.PATH, "nCreate", "(Ljava/lang/String;J)J", "ptr", "offset", "", "bytes", "off", "len", "", "nWrite", "(JJ[BII)V", "cursor", "nRead", "nFlush", "geckox_noasanRelease"}, k = 1, mv = {1, 4, 0})
public final class MMapBuffer implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f4737a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f4738b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f4739c;
    public final AtomicBoolean d;
    public final long e;
    public final File f;

    static {
        d.h("buffer");
    }

    public MMapBuffer(long r5, File r10) {
        this.e = r5;
        this.f = r10;
        this.f4739c = new AtomicBoolean(false);
        this.d = new AtomicBoolean(false);
        r10.getParentFile().mkdirs();
        this.f4737a = nCreate(r10.getAbsolutePath(), r5);
    }

    private final native long nCreate(String r5, long r10);

    private final native int nFlush(long r5, long r10);

    private final native void nRead(long r5, long r10, byte[] r11, int r12, int r13);

    private final native int nRelease(long r5, long r10);

    private final native void nWrite(long r5, long r10, byte[] r11, int r12, int r13);

    @Override // la.a
    public final synchronized long a(long r10) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L4:
        if (this.f4739c.get() == true) goto L22;
        if (r10 > 0) goto L9;
        monitor-exit(this);
        return 0;
    L9:
        long r5 = this.f4738b;     // Catch: Throwable -> L12
        long r11 = r10 + r5;     // Catch: Throwable -> L12
        this.f4738b = r11;     // Catch: Throwable -> L12
        if (r11 >= 0) goto L14;
        this.f4738b = 0;     // Catch: Throwable -> L12
    L18:
        long r12 = this.f4738b - r5;
        monitor-exit(this);
        return r12;
    L14:
        long r13 = this.e;     // Catch: Throwable -> L12
        if (r11 <= r13) goto L18;
        this.f4738b = r13;     // Catch: Throwable -> L12
        goto L18
    L22:
        throw new IOException("released!");     // Catch: Throwable -> L12
    }

    @Override // la.a
    public final File b() {
        return this.f;
    }

    @Override // la.a
    public final long c() {
        if (this.f4739c.get() == true) goto L7;
        return this.f4738b;
    L7:
        throw new IOException("released!");
    }

    @Override // la.a
    public final void d() {
        if (this.f4739c.get() == true) goto L7;
        nFlush(this.f4737a, this.e);
        return;
    L7:
        throw new IOException("released!");
    }

    @Override // la.a
    public final void e() {
        release();
        this.f.delete();
    }

    public final void finalize() {
        release();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        GeckoLogger.a("finalize:", e);
    }

    @Override // la.a
    /* JADX INFO: renamed from: finish */
    public final void mo119finish() {
        this.d.set(true);
    }

    @Override // la.a
    public final void g(long r5) {
        if (this.f4739c.get() == true) goto L13;
        long r10 = 0;
        if (r5 >= 0) goto L7;
    L6:
        r5 = r10;
    L10:
        this.f4738b = r5;
        return;
    L7:
        r10 = this.e;
        if (r5 <= r10) goto L10;
    L13:
        throw new IOException("released!");
    }

    @Override // la.a
    public final long length() {
        return this.e;
    }

    @Override // la.a
    public final void release() {
        if (this.f4739c.getAndSet(true) == false) goto L5;
        return;
    L5:
        nRelease(this.f4737a, this.e);
        this.f4737a = 0;
    }

    @Override // la.a
    public final void write(int r5) {
        write(new byte[]{(byte) r5}, 0, 1);
    }

    @Override // la.a
    public final int b(byte[] r5) {
        return c(r5, 0, r5.length);
    }

    @Override // la.a
    public final void write(byte[] r5) {
        write(r5, 0, r5.length);
    }

    @Override // la.a
    public final int c(byte[] r10, int r11, int r12) {
        if (this.f4739c.get() == true) goto L32;
        if (r12 < 1) goto L29;
        if (r11 >= 0) goto L8;
        return 0;
    L8:
        if (r11 < r10.length) goto L11;
        return 0;
    L11:
        if ((r11 + r12) <= r10.length) goto L13;
        r12 = r10.length - r11;
    L13:
        monitor-enter(this);
        long r5 = this.f4738b;     // Catch: Throwable -> L26
        long r13 = this.e;     // Catch: Throwable -> L26
        if (r5 != r13) goto L21;
        monitor-exit(this);
        return -1;
    L21:
        if ((((long) r12) + r5) <= r13) goto L23;
        r12 = (int) (r13 - r5);
    L23:
        nRead(this.f4737a, r5, r10, r11, r12);     // Catch: Throwable -> L26
        this.f4738b += (long) r12;     // Catch: Throwable -> L26
        monitor-exit(this);
        return r12;
    L26:
        th = move-exception;
        throw th;
    L29:
        return 0;
    L32:
        throw new IOException("released!");
    }

    @Override // la.a
    public final int write(byte[] r13, int r14, int r15) {
        if (r13.length != 0) goto L5;
    L52:
        return 0;
    L5:
        if (r15 < 1) goto L52;
        if (r14 < 0) goto L52;
        if (r14 >= r13.length) goto L52;
        if ((r14 + r15) <= r13.length) goto L14;
        r15 = r13.length - r14;
    L14:
        monitor-enter(this);
        long r5 = this.f4738b;     // Catch: Throwable -> L34
        long r10 = this.e;     // Catch: Throwable -> L34
        if (r5 != r10) goto L21;
        monitor-exit(this);
        return 0;
    L21:
        if ((((long) r15) + r5) <= r10) goto L24;
        r15 = (int) (r10 - r5);
    L24:
        if (this.f4739c.get() == false) goto L37;
        String r16 = "MMapBuffer write after release: " + this + '-' + this.e + '-' + this.f.getAbsolutePath();     // Catch: Throwable -> L34
        GeckoLogger.b(r16);     // Catch: Throwable -> L34
        EventSubType r17 = EventSubType.f6613u;     // Catch: Throwable -> L34
        JSONObject r18 = new JSONObject();     // Catch: Throwable -> L34
        r18.put("sub_type", r17.f6615a);     // Catch: Throwable -> L34
        if (r16 == null) goto L29;
        r18.put("err_msg", r16);     // Catch: Throwable -> L34
    L29:
        if (0 == 0) goto L31;
        r18.put("duration", 0);     // Catch: Throwable -> L34
    L31:
        j.g("geckosdk_event_message", r18);     // Catch: Throwable -> L34
        monitor-exit(this);
        return 0;
    L37:
        if (this.d.get() == false) goto L47;
        String r19 = "MMapBuffer write after finish: " + this + '-' + this.e + '-' + this.f.getAbsolutePath();     // Catch: Throwable -> L34
        GeckoLogger.b(r19);     // Catch: Throwable -> L34
        EventSubType r110 = EventSubType.f6612t;     // Catch: Throwable -> L34
        JSONObject r111 = new JSONObject();     // Catch: Throwable -> L34
        r111.put("sub_type", r110.f6615a);     // Catch: Throwable -> L34
        if (r19 == null) goto L42;
        r111.put("err_msg", r19);     // Catch: Throwable -> L34
    L42:
        if (0 == 0) goto L44;
        r111.put("duration", 0);     // Catch: Throwable -> L34
    L44:
        j.g("geckosdk_event_message", r111);     // Catch: Throwable -> L34
        monitor-exit(this);
        return 0;
    L47:
        nWrite(this.f4737a, this.f4738b, r13, r14, r15);     // Catch: Throwable -> L34
        this.f4738b += (long) r15;     // Catch: Throwable -> L34
        Unit r112 = Unit.INSTANCE;     // Catch: Throwable -> L34
        monitor-exit(this);
        return r15;
    L34:
        th = move-exception;
        throw th;
    }

    @Override // la.a
    public final int a() {
        byte[] r5 = new byte[1];
        if (c(r5, 0, 1) > 0) goto L7;
        return -1;
    L7:
        return r5[0];
    }
}
