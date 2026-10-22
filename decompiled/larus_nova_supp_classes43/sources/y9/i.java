package y9;

import java.lang.reflect.Type;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i<T> {
    public final String a;
    public T b;
    public final T c;
    public final Type d;

    public i() {
        throw null;
    }

    public final T a() {
        T r0 = (T) h.c(this.a, this.d, this.c);
        this.b = r0;
        if (r0 == null) goto L5;
        return r0;
    L5:
        return this.c;
    }

    public Type getType() {
        return this.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public i(String r1, Object r10, int r11) {
        Class<?> r12 = r10.getClass();
        this.a = r1;
        this.c = r10;
        this.d = r12;
    }
}
