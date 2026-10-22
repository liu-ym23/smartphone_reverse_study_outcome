package qq8;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d implements pq8.a {
    public final oq8.b a;
    public nq8.a b;
    public uq8.a c;
    public final rq8.a d;
    public final qq8.a e;

    public static final class a {
    }

    static {
    }

    public final void b() {
        FLogger.a.d("LarkInputController", "unbind");
        nq8.a r0 = this.b;
        if (r0 != null) goto L5;
        return;
    L5:
        uq8.a r1 = this.c;
        if (r1 == null) goto L8;
        r0.f(r1);
    L8:
        r0.a(this.e);
        this.c = null;
        this.b = null;
    }

    @Override // pq8.a
    public final void onDestroy() {
        FLogger.a.i("LarkInputController", "onDestroy");
        b();
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [qq8.a] */
    public d(oq8.b r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        this.a = r2;
        this.d = new rq8.a();
        this.e = new qq8.a(this);
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [qq8.b] */
    /* JADX WARN: Type inference failed for: r3v0, types: [qq8.c] */
    @Override // pq8.a
    public final void a(final nq8.a r5) {
        Intrinsics.checkNotNullParameter(r5, "editor");
        FLogger.a.i("LarkInputController", "bindEditor");
        b();
        this.b = r5;
        uq8.a r0 = new uq8.a(this.a, new b(r5), new c(this));
        this.c = r0;
        r5.d(r0);
        r5.e(this.e);
    }
}
