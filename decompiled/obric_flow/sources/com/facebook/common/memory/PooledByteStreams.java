package com.facebook.common.memory;

import com.facebook.imagepipeline.memory.BasePool;
import java.io.InputStream;
import java.io.OutputStream;

/* JADX INFO: loaded from: classes2.dex */
public class PooledByteStreams {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ByteArrayPool f7669a;

    public PooledByteStreams(ByteArrayPool r5) {
        this.f7669a = r5;
    }

    public final void a(InputStream r10, OutputStream r11) {
        byte[] r5 = (byte[]) ((BasePool) this.f7669a).get(16384);
    L14:
        int r12 = r10.read(r5, 0, 16384);     // Catch: Throwable -> L11
        if (r12 == (-1)) goto L7;
        r11.write(r5, 0, r12);     // Catch: Throwable -> L11
        goto L14
    L7:
        ((BasePool) this.f7669a).release(r5);
        return;
    L11:
        th = move-exception;
        ((BasePool) this.f7669a).release(r5);
        throw th;
    }
}
