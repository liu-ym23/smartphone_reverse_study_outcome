package ka;

import ha.c0;
import ha.d0;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class a<E> extends c0<Object> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final C0107a f8983c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<E> f8984a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q f8985b;

    /* JADX INFO: renamed from: ka.a$a, reason: collision with other inner class name */
    public class C0107a implements d0 {
        @Override // ha.d0
        public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
            Type r11 = r10.getType();
            boolean r12 = r11 instanceof GenericArrayType;
            if (r12 == false) goto L5;
        L10:
            if (r12 == false) goto L12;
            Type r13 = ((GenericArrayType) r11).getGenericComponentType();
        L14:
            return new a(r8, r8.f(oa.a.get(r13)), ja.a.e(r13));
        L12:
            r13 = ((Class) r11).getComponentType();
            goto L14
        L5:
            if ((r11 instanceof Class) == true) goto L7;
            return null;
        L7:
            if (((Class) r11).isArray() == true) goto L10;
            return null;
        }
    }

    static {
        f8983c = new C0107a();
    }

    public a(ha.j r8, c0<E> r10, Class<E> r11) {
        this.f8985b = new q(r8, r10, r11);
        this.f8984a = r11;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // ha.c0
    public final Object a(pa.a r8) {
        if (r8.h0() != pa.b.f9974s) goto L6;
        r8.V();
        return null;
    L6:
        ArrayList r10 = new ArrayList();
        r8.a();
    L8:
        if (r8.B() == false) goto L10;
        r10.add(this.f8985b.a(r8));
        goto L8
    L10:
        r8.r();
        int r11 = r10.size();
        Class<E> r12 = this.f8984a;
        boolean r13 = r12.isPrimitive();
        Object r14 = Array.newInstance(r12, r11);
        if (r13 == false) goto L17;
        int r15 = 0;
    L13:
        if (r15 >= r11) goto L15;
        Array.set(r14, r15, r10.get(r15));
        r15 = r15 + 1;
        goto L13
    L15:
        return r14;
    L17:
        return r10.toArray((Object[]) r14);
    }

    @Override // ha.c0
    public final void b(pa.c r8, Object r10) {
        if (r10 != null) goto L5;
        r8.z();
        return;
    L5:
        r8.i();
        int r11 = Array.getLength(r10);
        int r12 = 0;
    L6:
        if (r12 >= r11) goto L8;
        Object r13 = Array.get(r10, r12);
        this.f8985b.b(r8, r13);
        r12 = r12 + 1;
        goto L6
    L8:
        r8.r();
    }
}
