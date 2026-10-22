package tia;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class k implements com.larus.audio.call.record.j {
    public final hga.c a;

    public final int a() {
        return this.a.a();
    }

    public final void release() {
        this.a.release();
    }

    public final boolean start() {
        this.a.start();
        return true;
    }

    public final void stop() {
        this.a.stop();
    }

    public k(e r2) {
        Intrinsics.checkNotNullParameter(r2, "origin");
        this.a = r2;
    }

    public final int read(byte[] r2) {
        Intrinsics.checkNotNullParameter(r2, "buffer");
        return this.a.read(r2);
    }
}
