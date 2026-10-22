package of6;

import com.bytedance.live.artist.render.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public class c<T> extends e {
    public a c;
    public final T d;
    public final b<T> e;

    @Override // com.bytedance.live.artist.render.e
    public void d() {
        a r0 = this.c;
        if (r0 == null) goto L6;
        r0.d();
        return;
    }

    @Override // com.bytedance.live.artist.render.e
    public void e() {
        T r0 = this.d;
        if (r0 == null) goto L13;
        this.e.b(r0, c());
        a r1 = this.c;
        if (r1 == null) goto L7;
        r1.d();
    L7:
        a r2 = this.e.a();
        if (r2 == null) goto L10;
        r2.a = c();
        r2.e();
    L11:
        this.c = r2;
        return;
    L10:
        r2 = null;
        goto L11
    }

    @Override // com.bytedance.live.artist.render.e
    public void f() {
        a r0 = this.c;
        if (r0 == null) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == false) goto L10;
        if (r0 == null) goto L11;
        r0.f();
        return;
    L11:
        return;
    L10:
        return;
    L5:
        r1 = false;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(Object r1, tk6.e r2) {
        this.d = r1;
        this.e = r2;
    }
}
