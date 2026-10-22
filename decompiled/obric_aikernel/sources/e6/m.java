package e6;

import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;

/* JADX INFO: loaded from: classes2.dex */
public final class m<T> extends l<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.o<T> f8697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.google.gson.h<T> f8698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final com.google.gson.d f8699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TypeToken<T> f8700d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final r f8701e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final m<T>.b f8702f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final boolean f8703g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile q<T> f8704h;

    static /* synthetic */ class a {
    }

    private final class b implements com.google.gson.n, com.google.gson.g {
        private b(m r10) {
        }

        /* synthetic */ b(m r10, a r11) {
            this(r10);
        }
    }

    public m(com.google.gson.o<T> r10, com.google.gson.h<T> r11, com.google.gson.d r12, TypeToken<T> r13, r r14, boolean r15) {
        this.f8702f = new b(this, null);
        this.f8697a = r10;
        this.f8698b = r11;
        this.f8699c = r12;
        this.f8700d = r13;
        this.f8701e = r14;
        this.f8703g = r15;
    }

    private q<T> f() {
        q<T> r10 = this.f8704h;
        if (r10 != null) goto L7;
        q<T> r11 = this.f8699c.o(this.f8701e, this.f8700d);
        this.f8704h = r11;
        return r11;
    L7:
        return r10;
    }

    @Override // com.google.gson.q
    public T b(i6.a r10) {
        if (this.f8698b == null) goto L5;
        com.google.gson.i r11 = com.google.gson.internal.j.a(r10);
        if (this.f8703g == false) goto L13;
        if (r11.j() == false) goto L13;
        return null;
    L13:
        return this.f8698b.a(r11, this.f8700d.getType(), this.f8702f);
    L5:
        return f().b(r10);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.a r10, T r11) {
        com.google.gson.o<T> r12 = this.f8697a;
        if (r12 != null) goto L7;
        f().d(r10, r11);
        return;
    L7:
        if (this.f8703g == false) goto L11;
        if (r11 != null) goto L11;
        r10.B();
        return;
    L11:
        com.google.gson.internal.j.b(r12.a(r11, this.f8700d.getType(), this.f8702f), r10);
    }

    @Override // e6.l
    public q<T> e() {
        if (this.f8697a == null) goto L6;
        return this;
    L6:
        return f();
    }
}
