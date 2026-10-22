package ha;

import java.io.IOException;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    @Deprecated
    public p() {
    }

    public abstract p a();

    public boolean b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public double c() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final m e() {
        if ((this instanceof m) == false) goto L7;
        return (m) this;
    L7:
        throw new IllegalStateException("Not a JSON Array: " + this);
    }

    public final s f() {
        if ((this instanceof s) == false) goto L7;
        return (s) this;
    L7:
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    public final u g() {
        if ((this instanceof u) == false) goto L7;
        return (u) this;
    L7:
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public long h() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public Number i() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public String j() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public final String toString() {
        StringWriter r8 = new StringWriter();     // Catch: IOException -> L4
        pa.c r10 = new pa.c(r8);     // Catch: IOException -> L4
        r10.f9985p = true;     // Catch: IOException -> L4
        ka.r.f9079z.b(r10, this);     // Catch: IOException -> L4
        return r8.toString();
    L4:
        e = move-exception;
        throw new AssertionError(e);
    }
}
