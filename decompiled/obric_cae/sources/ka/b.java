package ka;

import ha.c0;
import ha.d0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public final class b implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.i f8986a;

    public static final class a<E> extends c0<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f8987a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ja.t<? extends Collection<E>> f8988b;

        public a(ha.j r8, Type r10, c0<E> r11, ja.t<? extends Collection<E>> r12) {
            this.f8987a = new q(r8, r11, r10);
            this.f8988b = r12;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ha.c0
        public final Object a(pa.a r8) {
            if (r8.h0() != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            Collection<E> r10 = this.f8988b.b();
            r8.a();
        L7:
            if (r8.B() == false) goto L9;
            r10.add(this.f8987a.a(r8));
            goto L7
        L9:
            r8.r();
            return r10;
        }

        @Override // ha.c0
        public final void b(pa.c r8, Object r10) {
            Collection r11 = (Collection) r10;
            if (r11 != null) goto L5;
            r8.z();
            return;
        L5:
            r8.i();
            Iterator<E> r12 = r11.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            E r13 = r12.next();
            this.f8987a.b(r8, r13);
            goto L7
        L9:
            r8.r();
        }
    }

    public b(ja.i r8) {
        this.f8986a = r8;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r8, oa.a<T> r10) {
        Type r11 = r10.getType();
        Class<? super T> r12 = r10.getRawType();
        if (Collection.class.isAssignableFrom(r12) == true) goto L6;
        return null;
    L6:
        Type r13 = ja.a.f(r11, r12, Collection.class);
        if ((r13 instanceof ParameterizedType) == false) goto L9;
        Type r14 = ((ParameterizedType) r13).getActualTypeArguments()[0];
    L11:
        return new a(r8, r14, r8.f(oa.a.get(r14)), this.f8986a.b(r10));
    L9:
        r14 = Object.class;
        goto L11
    }
}
