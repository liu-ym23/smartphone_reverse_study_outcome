package xr9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class j implements wr9.i {
    public final wr9.j a;

    @Override // wr9.i
    public final void G8(com.larus.avlink.gallery.power.monitor.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // wr9.i
    public final void Gb(com.larus.avlink.gallery.power.monitor.e r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
    }

    @Override // wr9.i, java.lang.AutoCloseable
    public final void close() {
    }

    @Override // wr9.i
    public final void start() {
    }

    @Override // wr9.i
    public final wr9.j o() {
        return this.a;
    }

    public j(wr9.j r2) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        this.a = r2;
    }
}
