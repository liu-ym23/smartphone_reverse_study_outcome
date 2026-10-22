package ai;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f238a = null;

    static {
        f238a = new j();
    }

    @Override // ai.d
    public final e a(Type r5) {
        if (w0.g(r5) == c.class) goto L7;
        return null;
    L7:
        if ((r5 instanceof ParameterizedType) == false) goto L11;
        return new k6.a(w0.f(0, (ParameterizedType) r5));
    L11:
        throw new IllegalArgumentException("Call return type must be parameterized as Call<Foo> or Call<? extends Foo>");
    }
}
