package com.bytedance.gkfs.io;

import com.bytedance.gkfs.UtilsKt$traceTime$1$1;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.UByte;
import kotlin.UInt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements Closeable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayInputStream f4870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f4871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f4872c;
    public volatile int d;
    public long e;
    public final byte[] f;
    public final int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.gkfs.d f4873h;

    public h(byte[] r5, int r10, com.bytedance.gkfs.d r11) {
        this.f = r5;
        this.g = r10;
        this.f4873h = r11;
        this.f4870a = new ByteArrayInputStream(r5);
        this.f4871b = new AtomicBoolean(false);
        this.f4872c = new ConcurrentHashMap();
        this.d = -1;
    }

    public final f b() {
        if (this.f4871b.get() == true) goto L13;
        this.d++;
        f r5 = (f) this.f4872c.get(Integer.valueOf(this.d));
        if (r5 == null) goto L7;
        return r5;
    L7:
        UtilsKt$traceTime$1$1 r10 = new UtilsKt$traceTime$1$1(System.currentTimeMillis());
        ByteArrayInputStream r11 = this.f4870a;
        StringBuilder r12 = new StringBuilder(40);
        int r13 = 0;
    L8:
        if (r13 >= 40) goto L10;
        r12.append((char) r11.read());
        r13 = r13 + 1;
        goto L8
    L10:
        c r14 = new c(r12.toString());
        ByteArrayInputStream r15 = this.f4870a;
        long r16 = ((long) androidx.room.jarjarred.org.antlr.runtime.a.b(UByte.m142constructorimpl((byte) r15.read()) & UByte.MAX_VALUE, androidx.room.jarjarred.org.antlr.runtime.a.b(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) r15.read()) & UByte.MAX_VALUE) << 8, androidx.room.jarjarred.org.antlr.runtime.a.b(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) r15.read()) & UByte.MAX_VALUE) << 16, UInt.m219constructorimpl(UInt.m219constructorimpl(UByte.m142constructorimpl((byte) r15.read()) & UByte.MAX_VALUE) << 24))))) & 4294967295L;
        this.e = ((Number) r10.invoke()).longValue() + this.e;
        f r17 = new f(r14, r16);
        this.f4872c.put(Integer.valueOf(this.d), r17);
        return r17;
    L13:
        throw new IOException("decoder has been closed!");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f4871b.compareAndSet(false, true) == false) goto L11;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L6
        this.f4870a.close();     // Catch: Throwable -> L6
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
        return;
    L6:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
        return;
    }
}
