package b0;

import kotlin.UByte;
import q0.i;

/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.lynx.animax.player.e f818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0.d f819b;

    public h() {
        this.f818a = new com.lynx.animax.player.e(1000);
        this.f819b = r0.g.a(10, new uj.a());
    }

    public final String a(z.c r10) {
        com.lynx.animax.player.e r5 = this.f818a;
        monitor-enter(r5);
        String r11 = (String) this.f818a.a(r10);     // Catch: Throwable -> L31
        monitor-exit(r5);     // Catch: Throwable -> L31
        if (r11 != null) goto L23;
        g r12 = (g) this.f819b.acquire();
        r10.b(r12.f816a);     // Catch: Throwable -> L20
        byte[] r13 = r12.f816a.digest();     // Catch: Throwable -> L20
        char[] r14 = i.f21460b;     // Catch: Throwable -> L20
        monitor-enter(r14);     // Catch: Throwable -> L20
        int r15 = 0;
    L39:
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L20
    L12:
        if (r15 >= r13.length) goto L14;
        byte r16 = r13[r15];     // Catch: Throwable -> L17
        int r17 = r15 * 2;     // Catch: Throwable -> L17
        int r18 = (r16 & UByte.MAX_VALUE) >>> 4;     // Catch: Throwable -> L17
        char[] r19 = i.f21459a;     // Catch: Throwable -> L17
        r14[r17] = r19[r18];     // Catch: Throwable -> L17
        r14[r17 + 1] = r19[r16 & 15];     // Catch: Throwable -> L17
        r15 = r15 + 1;     // Catch: Throwable -> L17
        goto L39
    L14:
        r11 = new String(r14);     // Catch: Throwable -> L17
        monitor-exit(r14);     // Catch: Throwable -> L17
        this.f819b.release(r12);
        goto L23
    L20:
        th = move-exception;
        this.f819b.release(r12);
        throw th;
    L23:
        com.lynx.animax.player.e r20 = this.f818a;
        monitor-enter(r20);
        this.f818a.e(r10, r11);     // Catch: Throwable -> L28
        monitor-exit(r20);     // Catch: Throwable -> L28
        return r11;
    L28:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    }
}
