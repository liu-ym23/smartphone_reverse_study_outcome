package e6;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes2.dex */
public final class a<E> extends q<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r f8638c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<E> f8639a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q<E> f8640b;

    /* JADX INFO: renamed from: e6.a$a, reason: collision with other inner class name */
    class C0162a implements r {
        C0162a() {
        }

        @Override // com.google.gson.r
        public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
            Type r12 = r11.getType();
            if ((r12 instanceof GenericArrayType) == false) goto L5;
        L10:
            Type r13 = C$Gson$Types.g(r12);
            return new a(r10, r10.m(TypeToken.get(r13)), C$Gson$Types.k(r13));
        L5:
            if ((r12 instanceof Class) == true) goto L7;
            return null;
        L7:
            if (((Class) r12).isArray() == true) goto L10;
            return null;
        }
    }

    static {
        f8638c = new C0162a();
    }

    public a(com.google.gson.d r10, q<E> r11, Class<E> r12) {
        this.f8640b = new n(r10, r11, r12);
        this.f8639a = r12;
    }

    @Override // com.google.gson.q
    public Object b(i6.a r10) {
        if (r10.Q() != JsonToken.NULL) goto L6;
        r10.K();
        return null;
    L6:
        ArrayList r11 = new ArrayList();
        r10.a();
    L8:
        if (r10.u() == false) goto L10;
        r11.add(this.f8640b.b(r10));
        goto L8
    L10:
        r10.l();
        int r12 = r11.size();
        boolean r13 = this.f8639a.isPrimitive();
        Object r14 = Array.newInstance(this.f8639a, r12);
        if (r13 == false) goto L17;
        int r15 = 0;
    L13:
        if (r15 >= r12) goto L15;
        Array.set(r14, r15, r11.get(r15));
        r15 = r15 + 1;
        goto L13
    L15:
        return r14;
    L17:
        return r11.toArray((Object[]) r14);
    }

    @Override // com.google.gson.q
    public void d(com.google.gson.stream.a r10, Object r11) {
        if (r11 != null) goto L5;
        r10.B();
        return;
    L5:
        r10.f();
        int r12 = 0;
        int r13 = Array.getLength(r11);
    L6:
        if (r12 >= r13) goto L8;
        Object r14 = Array.get(r11, r12);
        this.f8640b.d(r10, (E) r14);
        r12 = r12 + 1;
        goto L6
    L8:
        r10.l();
    }
}
