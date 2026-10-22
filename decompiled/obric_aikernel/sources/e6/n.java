package e6;

import com.google.gson.q;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes2.dex */
final class n<T> extends q<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.google.gson.d f8705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<T> f8706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Type f8707c;

    n(com.google.gson.d r10, q<T> r11, Type r12) {
        this.f8705a = r10;
        this.f8706b = r11;
        this.f8707c = r12;
    }

    private static Type e(Type r10, Object r11) {
        if (r11 != null) goto L4;
        return r10;
    L4:
        if ((r10 instanceof Class) == true) goto L8;
        if ((r10 instanceof TypeVariable) == true) goto L8;
        return r10;
    L8:
        return r11.getClass();
    }

    private static boolean f(q<?> r10) {
    L3:
        if ((r10 instanceof l) == false) goto L9;
        q<?> r11 = ((l) r10).e();
        if (r11 == r10) goto L9;
        r10 = r11;
    L9:
        return r10 instanceof k.b;
    }

    @Override // com.google.gson.q
    public T b(i6.a r10) {
        return this.f8706b.b(r10);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.a r10, T r11) {
        q<T> r12 = this.f8706b;
        Type r13 = e(this.f8707c, r11);
        if (r13 == this.f8707c) goto L10;
        r12 = this.f8705a.m(TypeToken.get(r13));
        if ((r12 instanceof k.b) == false) goto L10;
        if (f(this.f8706b) == true) goto L10;
        r12 = this.f8706b;
    L10:
        r12.d(r10, r11);
    }
}
