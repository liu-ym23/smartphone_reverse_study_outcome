package com.bytedance.forest.utils.io;

import com.bytedance.forest.model.q;
import com.bytedance.forest.model.w;
import com.lynx.tasm.ui.image.f0;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Lazy;
import kotlin.UByte;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends InputStream {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f4637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f4638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f4639c;
    public final w d;
    public final q e;

    public c(q r5, w r10) {
        this.d = r10;
        this.e = r5;
        this.f4639c = -1;
    }

    @Override // java.io.InputStream
    public final int available() {
        q r5 = this.e;
        if (this.f4638b == true) goto L15;
    L8:
        th = move-exception;
        b(th, "available");
        throw null;
    L5:
        if (r5.isCacheProvided$forest_release() == false) goto L11;
        return r5.size() - this.f4637a;
    L11:
        return r5.size();
    L15:
        throw new IOException("input stream closed");
    }

    public final void b(Throwable r5, String r10) {
        f0.g(112, "ForestInputStream", "error happens when executing ".concat(r10), r5);
        q r11 = this.e;
        if (r11.isCacheClear$forest_release() == false) goto L6;
        w r12 = this.d;
        r12.f4441q.getForest().getMemoryManager$forest_release().a(r12.f4441q.getCacheKey$forest_release());
        r11.getContext$forest_release().f4619a.getClass();
        com.bytedance.forest.b.d(r12, r5);
        throw r5;
    L6:
        throw r5;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        q r5 = this.e;
        com.bytedance.forest.b r10 = r5.getContext$forest_release().f4619a;
        Lazy r11 = com.bytedance.forest.b.f4230b;
        r10.getClass();
        com.bytedance.forest.b.d(this.d, null);
        this.f4638b = true;
        r5.close();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        b(th, "close");
        throw null;
    }

    @Override // java.io.InputStream
    public final int read() {
        if (this.f4638b == true) goto L10;
        byte[] r5 = new byte[1];
        if (read(r5, 0, 1) != (-1)) goto L8;
        return -1;
    L8:
        return r5[0] & UByte.MAX_VALUE;
    L10:
        throw new IOException("input stream closed");
    }

    @Override // java.io.InputStream
    public final long skip(long r10) {
        if (this.f4638b == true) goto L22;
        if (r10 > 0) goto L23;
        return 0;
    L23:
        int r5 = (int) RangesKt.coerceAtMost(2048, r10);     // Catch: Throwable -> L15
        byte[] r11 = new byte[r5];     // Catch: Throwable -> L15
        long r12 = r10;
    L10:
        if (r12 <= 0) goto L18;
        int r13 = read(r11, 0, (int) RangesKt.coerceAtMost(r5, r12));     // Catch: Throwable -> L15
        if (r13 < 0) goto L18;
        r12 = r12 - ((long) r13);
    L18:
        return r10 - r12;
    L15:
        th = move-exception;
        b(th, "skip");
        throw null;
    L22:
        throw new IOException("input stream closed");
    }

    @Override // java.io.InputStream
    public final int read(byte[] r10, int r11, int r12) {
        w r5 = this.d;
        if (this.f4638b == true) goto L23;
        r10.getClass();
        int r13 = this.e.getBytesAtRange$forest_release(this.f4637a, r10, r11, r12, this.d);     // Catch: Throwable -> L8
        if (this.e.isCacheClear$forest_release() == false) goto L11;
        r5.f4441q.getForest().getMemoryManager$forest_release().a(r5.f4441q.getCacheKey$forest_release());     // Catch: Throwable -> L8
    L11:
        if (r13 != (-1)) goto L13;
        return -1;
    L13:
        if (r13 == 0) goto L15;
    L18:
        this.f4639c = r13;     // Catch: Throwable -> L8
        this.f4637a += r13;     // Catch: Throwable -> L8
        return r13;
    L15:
        if (this.f4639c != 0) goto L18;
        f0.g(112, "ForestInputStream", "unexpected code reached, repeating read 0 byte", null);     // Catch: Throwable -> L8
        return -1;
    L8:
        th = move-exception;
        b(th, "read");
        throw null;
    L23:
        throw new IOException("input stream closed");
    }
}
