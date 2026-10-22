package nr1;

import com.bytedance.android.livesdk.chatroom.helper.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements wr1.c {
    public final f a;

    @Override // wr1.c
    public final void b() {
        f r0 = this.a;
        r0.n = r0.toString();
    }

    @Override // wr1.c
    public final void c() {
        this.a.i();
    }

    @Override // wr1.c
    public final void d() {
        this.a.e();
    }

    @Override // wr1.c
    public final void reset() {
        f r0 = this.a;
        r0.t = false;
        r0.u = false;
        r0.x = false;
    }

    public a(f r2) {
        Intrinsics.checkNotNullParameter(r2, "enterRoomMonitor");
        this.a = r2;
    }

    @Override // wr1.c
    public final void a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "type");
        this.a.c(r3, true);
    }

    @Override // wr1.c
    public final void e(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        this.a.d(r2);
    }

    @Override // wr1.c
    public final void f(boolean r9) {
        f r0 = this.a;
        r0.u = true;
        long r1 = System.currentTimeMillis();
        r0.q = r1;
        if (r0.r != 0) goto L6;
        r0.r = r1;
    L6:
        if (r0.x == true) goto L9;
        r0.x = r9;
        return;
    }
}
