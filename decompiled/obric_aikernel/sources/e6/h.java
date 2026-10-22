package e6;

import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.C$Gson$Types;
import com.google.gson.q;
import com.google.gson.r;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class h implements r {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final com.google.gson.internal.b f8658c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final boolean f8659g;

    private final class a<K, V> extends q<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final q<K> f8660a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final q<V> f8661b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final com.google.gson.internal.f<? extends Map<K, V>> f8662c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ h f8663d;

        public a(h r10, com.google.gson.d r11, Type r12, q<K> r13, Type r14, q<V> r15, com.google.gson.internal.f<? extends Map<K, V>> r16) {
            this.f8663d = r10;
            this.f8660a = new n(r11, r13, r12);
            this.f8661b = new n(r11, r15, r14);
            this.f8662c = r16;
        }

        private String e(com.google.gson.i r10) {
            if (r10.l() == false) goto L19;
            com.google.gson.m r11 = r10.f();
            if (r11.p() == false) goto L9;
            return String.valueOf(r11.m());
        L9:
            if (r11.n() == false) goto L13;
            return Boolean.toString(r11.a());
        L13:
            if (r11.q() == false) goto L17;
            return r11.h();
        L17:
            throw new AssertionError();
        L19:
            if (r10.j() == false) goto L23;
            return "null";
        L23:
            throw new AssertionError();
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ Object b(i6.a r10) {
            return f(r10);
        }

        @Override // com.google.gson.q
        public /* bridge */ /* synthetic */ void d(com.google.gson.stream.a r10, Object r11) {
            g(r10, (Map) r11);
        }

        public Map<K, V> f(i6.a r10) {
            JsonToken r11 = r10.Q();
            if (r11 != JsonToken.NULL) goto L6;
            r10.K();
            return null;
        L6:
            Map<K, V> r12 = this.f8662c.a();
            if (r11 != JsonToken.BEGIN_ARRAY) goto L17;
            r10.a();
        L10:
            if (r10.u() == false) goto L16;
            r10.a();
            K r13 = this.f8660a.b(r10);
            if (r12.put(r13, this.f8661b.b(r10)) != null) goto L15;
            r10.l();
            goto L10
        L15:
            throw new JsonSyntaxException("duplicate key: " + r13);
        L16:
            r10.l();
        L26:
            return r12;
        L17:
            r10.c();
        L19:
            if (r10.u() == false) goto L25;
            com.google.gson.internal.e.f4260a.a(r10);
            K r14 = this.f8660a.b(r10);
            if (r12.put(r14, this.f8661b.b(r10)) == null) goto L19;
            throw new JsonSyntaxException("duplicate key: " + r14);
        L25:
            r10.o();
            goto L26
        }

        public void g(com.google.gson.stream.a r10, Map<K, V> r11) {
            if (r11 != null) goto L6;
            r10.B();
            return;
        L6:
            if (this.f8663d.f8659g == true) goto L13;
            r10.i();
            Iterator<Map.Entry<K, V>> r12 = r11.entrySet().iterator();
        L9:
            if (r12.hasNext() == false) goto L11;
            Map.Entry<K, V> r13 = r12.next();
            r10.v(String.valueOf(r13.getKey()));
            this.f8661b.d(r10, r13.getValue());
            goto L9
        L11:
            r10.o();
            return;
        L13:
            ArrayList r14 = new ArrayList(r11.size());
            ArrayList r15 = new ArrayList(r11.size());
            Iterator<Map.Entry<K, V>> r16 = r11.entrySet().iterator();
            int r17 = 0;
            boolean r18 = false;
        L15:
            if (r16.hasNext() == false) goto L24;
            Map.Entry<K, V> r19 = r16.next();
            com.google.gson.i r20 = this.f8660a.c(r19.getKey());
            r14.add(r20);
            r15.add(r19.getValue());
            if (r20.i() == false) goto L19;
        L22:
            boolean r21 = true;
        L23:
            r18 = r18 | r21;
            goto L15
        L19:
            if (r20.k() == true) goto L22;
            r21 = false;
            goto L23
        L24:
            if (r18 == false) goto L29;
            r10.f();
            int r22 = r14.size();
        L26:
            if (r17 >= r22) goto L28;
            r10.f();
            com.google.gson.internal.j.b((com.google.gson.i) r14.get(r17), r10);
            this.f8661b.d(r10, (V) r15.get(r17));
            r10.l();
            r17 = r17 + 1;
            goto L26
        L28:
            r10.l();
            return;
        L29:
            r10.i();
            int r23 = r14.size();
        L30:
            if (r17 >= r23) goto L32;
            r10.v(e((com.google.gson.i) r14.get(r17)));
            this.f8661b.d(r10, (V) r15.get(r17));
            r17 = r17 + 1;
            goto L30
        L32:
            r10.o();
        }
    }

    public h(com.google.gson.internal.b r10, boolean r11) {
        this.f8658c = r10;
        this.f8659g = r11;
    }

    private q<?> a(com.google.gson.d r10, Type r11) {
        if (r11 == Boolean.TYPE) goto L9;
        if (r11 == Boolean.class) goto L9;
        return r10.m(TypeToken.get(r11));
    L9:
        return o.f8714f;
    }

    @Override // com.google.gson.r
    public <T> q<T> b(com.google.gson.d r12, TypeToken<T> r13) {
        Type r10 = r13.getType();
        Class<? super T> r11 = r13.getRawType();
        if (Map.class.isAssignableFrom(r11) == true) goto L6;
        return null;
    L6:
        Type[] r14 = C$Gson$Types.j(r10, r11);
        q<?> r15 = a(r12, r14[0]);
        q<T> r16 = r12.m(TypeToken.get(r14[1]));
        com.google.gson.internal.f<T> r17 = this.f8658c.b(r13);
        return new a(this, r12, r14[0], r15, r14[1], r16, r17);
    }
}
