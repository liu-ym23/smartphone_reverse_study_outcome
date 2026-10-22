package e6;

import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public final class b implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.b f8641c;

    private static final class a<E> extends q<Collection<E>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q<E> f8642a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.google.gson.internal.f<? extends Collection<E>> f8643b;

        public a(com.google.gson.d r10, Type r11, q<E> r12, com.google.gson.internal.f<? extends Collection<E>> r13) {
            this.f8642a = new n(r10, r12, r11);
            this.f8643b = r13;
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Object b(i6.a r10) {
            return e(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Object r11) {
            f(r10, (Collection) r11);
        }

        public Collection<E> e(i6.a r10) {
            if (r10.Q() != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            Collection<E> r11 = this.f8643b.a();
            r10.a();
        L8:
            if (r10.u() == false) goto L10;
            r11.add(this.f8642a.b(r10));
            goto L8
        L10:
            r10.l();
            return r11;
        }

        public void f(com.google.gson.stream.a r10, Collection<E> r11) {
            if (r11 != null) goto L5;
            r10.B();
            return;
        L5:
            r10.f();
            Iterator<E> r12 = r11.iterator();
        L7:
            if (r12.hasNext() == false) goto L9;
            E r13 = r12.next();
            this.f8642a.d(r10, r13);
            goto L7
        L9:
            r10.l();
        }
    }

    public b(com.google.gson.internal.b r10) {
        this.f8641c = r10;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.d r10, TypeToken<T> r11) {
        Type r12 = r11.getType();
        Class<? super T> r13 = r11.getRawType();
        if (Collection.class.isAssignableFrom(r13) == true) goto L6;
        return null;
    L6:
        Type r14 = C$Gson$Types.h(r12, r13);
        return new a(r10, r14, r10.m(TypeToken.get(r14)), this.f8641c.b(r11));
    }
}
