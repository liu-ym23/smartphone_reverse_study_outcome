package uvc;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public abstract class b {
    public b a;
    public b b;
    public b c;
    public b d;
    public b e;
    public String f;
    public final Map<String, Object> g;

    public abstract void a(c r1);

    public String f() {
        return "";
    }

    public final void g() {
        b r0 = this.d;
        if (r0 == null) goto L5;
        r0.e = this.e;
    L8:
        b r1 = this.e;
        if (r1 == null) goto L11;
        r1.d = r0;
    L14:
        this.a = null;
        this.e = null;
        this.d = null;
        return;
    L11:
        b r2 = this.a;
        if (r2 == null) goto L14;
        r2.c = r0;
        goto L14
    L5:
        b r3 = this.a;
        if (r3 == null) goto L8;
        r3.b = this.e;
        goto L8
    }

    public String toString() {
        return getClass().getSimpleName() + "{" + f() + "}";
    }

    public b() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = new HashMap();
    }

    public b c() {
        return this.a;
    }

    public final void b(b r2) {
        r2.g();
        r2.e(this);
        b r0 = this.c;
        if (r0 == null) goto L5;
        r0.e = r2;
        r2.d = r0;
        this.c = r2;
        return;
    L5:
        this.b = r2;
        this.c = r2;
    }

    public final void d(b r3) {
        r3.g();
        b r0 = this.e;
        r3.e = r0;
        if (r0 == null) goto L5;
        r0.d = r3;
    L5:
        r3.d = this;
        this.e = r3;
        b r1 = this.a;
        r3.a = r1;
        if (r3.e != null) goto L9;
        r1.c = r3;
        return;
    }

    public void e(b r1) {
        this.a = r1;
    }
}
