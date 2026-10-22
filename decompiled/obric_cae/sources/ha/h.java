package ha;

import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class h extends c0<AtomicLong> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c0 f7966a;

    public h(c0 r8) {
        this.f7966a = r8;
    }

    @Override // ha.c0
    public final AtomicLong a(pa.a r8) {
        return new AtomicLong(((Number) this.f7966a.a(r8)).longValue());
    }

    @Override // ha.c0
    public final void b(pa.c r8, AtomicLong r10) {
        Long r11 = Long.valueOf(r10.get());
        this.f7966a.b(r8, r11);
    }
}
