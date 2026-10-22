package ai;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class b extends h {
    @Override // ai.h
    public final i a(Type r5) {
        if (r5 == bi.c.class) goto L5;
        return null;
    L5:
        return a.f173c;
    }

    @Override // ai.h
    public final i b(Type r5) {
        if (r5 == Object.class) goto L5;
        return null;
    L5:
        return a.d;
    }

    @Override // ai.h
    public final i c(Type r5) {
        if (fi.j.class.isAssignableFrom(w0.g(r5)) == true) goto L5;
        return null;
    L5:
        return a.e;
    }

    @Override // ai.h
    public final i d(Type r5, Annotation[] r10) {
        if (r5 != fi.i.class) goto L14;
        int r11 = r10.length;
        int r12 = 0;
    L5:
        if (r12 >= r11) goto L12;
        if (ci.e0.class.isInstance(r10[r12]) == true) goto L9;
        r12 = r12 + 1;
        goto L5
    L9:
        return a.f;
    L12:
        return a.f172b;
    L14:
        if (r5 != String.class) goto L18;
        return a.f174h;
    L18:
        if (r5 == Void.class) goto L20;
        return null;
    L20:
        return a.f176j;
    }

    @Override // ai.h
    public final i e(Type r5) {
        if (r5 == String.class) goto L5;
        return null;
    L5:
        return a.g;
    }
}
