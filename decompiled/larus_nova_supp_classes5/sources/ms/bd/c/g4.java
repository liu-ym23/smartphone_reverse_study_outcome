package ms.bd.c;

import com.bytedance.frameworks.baselib.network.http.NetworkParams;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class g4 extends f2 {
    public long a;

    public final void finalize() {
        p2.a(50331650, 0, this.a, null, null);
        p2.a(100663298, 0, this.a, null, null);
        this.a = -1;
        super.finalize();
    }

    public g4() {
    }

    @Override // ms.bd.c.f2
    public final void a(long r1) {
        this.a = r1;
        f4 r2 = new f4(this);
        monitor-enter(this);
        NetworkParams.setAddSecurityFactorProcessCallback(r2);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
