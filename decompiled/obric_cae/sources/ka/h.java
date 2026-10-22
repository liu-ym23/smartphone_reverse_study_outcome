package ka;

import ha.c0;
import ha.d0;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/* JADX INFO: loaded from: classes.dex */
public final class h implements d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ja.i f9001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f9002b;

    public final class a<K, V> extends c0<Map<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final q f9003a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final q f9004b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ja.t<? extends Map<K, V>> f9005c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ h f9006d;

        public a(h r8, ha.j r10, Type r11, c0<K> r12, Type r13, c0<V> r14, ja.t<? extends Map<K, V>> r15) {
            this.f9006d = r8;
            this.f9003a = new q(r10, r12, r11);
            this.f9004b = new q(r10, r14, r13);
            this.f9005c = r15;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // ha.c0
        public final Object a(pa.a r8) {
            pa.b r10 = r8.h0();
            if (r10 != pa.b.f9974s) goto L5;
            r8.V();
            return null;
        L5:
            Map<K, V> r11 = this.f9005c.b();
            pa.b r12 = pa.b.f9966a;
            q r13 = this.f9004b;
            q r14 = this.f9003a;
            if (r10 != r12) goto L16;
            r8.a();
        L9:
            if (r8.B() == false) goto L15;
            r8.a();
            Object r15 = r14.a(r8);
            if (r11.put(r15, r13.a(r8)) != null) goto L14;
            r8.r();
            goto L9
        L14:
            throw new ha.q("duplicate key: " + r15);
        L15:
            r8.r();
        L26:
            return r11;
        L16:
            r8.i();
        L18:
            if (r8.B() == false) goto L24;
            android.support.v4.media.a.f405b.z(r8);
            Object r16 = r14.a(r8);
            if (r11.put(r16, r13.a(r8)) == null) goto L18;
            throw new ha.q("duplicate key: " + r16);
        L24:
            r8.v();
            goto L26
        }

        @Override // ha.c0
        public final void b(pa.c r10, Object r11) {
            Map r12 = (Map) r11;
            if (r12 != null) goto L5;
            r10.z();
            return;
        L5:
            boolean r8 = this.f9006d.f9002b;
            q r13 = this.f9004b;
            if (r8 == true) goto L11;
            r10.k();
            Iterator<Map.Entry<K, V>> r14 = r12.entrySet().iterator();
        L9:
            if (r14.hasNext() == false) goto L53;
            Map.Entry<K, V> r15 = r14.next();
            r10.w(String.valueOf(r15.getKey()));
            r13.b(r10, r15.getValue());
        L53:
            r10.v();
            return;
        L11:
            ArrayList r16 = new ArrayList(r12.size());
            ArrayList r17 = new ArrayList(r12.size());
            Iterator<Map.Entry<K, V>> r18 = r12.entrySet().iterator();
            int r19 = 0;
            boolean r20 = false;
        L13:
            if (r18.hasNext() == false) goto L27;
            Map.Entry<K, V> r21 = r18.next();
            K r22 = r21.getKey();
            q r23 = this.f9003a;
            r23.getClass();
            g r24 = new g();     // Catch: IOException -> L24
            r23.b(r24, r22);     // Catch: IOException -> L24
            ha.p r25 = r24.K();     // Catch: IOException -> L24
            r16.add(r25);
            r17.add(r21.getValue());
            r25.getClass();
            if ((r25 instanceof ha.m) == false) goto L19;
        L22:
            boolean r26 = true;
        L23:
            r20 = r20 | r26;
            goto L13
        L19:
            if ((r25 instanceof ha.s) == true) goto L22;
            r26 = false;
        L24:
            e = move-exception;
            throw new ha.q(e);
        L27:
            if (r20 == false) goto L32;
            r10.i();
            int r27 = r16.size();
        L29:
            if (r19 >= r27) goto L31;
            r10.i();
            r.f9079z.b(r10, (ha.p) r16.get(r19));
            r13.b(r10, r17.get(r19));
            r10.r();
            r19 = r19 + 1;
            goto L29
        L31:
            r10.r();
            return;
        L32:
            r10.k();
            int r28 = r16.size();
        L33:
            if (r19 >= r28) goto L53;
            ha.p r110 = (ha.p) r16.get(r19);
            r110.getClass();
            if ((r110 instanceof ha.u) == false) goto L48;
            ha.u r111 = r110.g();
            Serializable r29 = r111.f8004a;
            if ((r29 instanceof Number) == false) goto L40;
            String r112 = String.valueOf(r111.i());
        L50:
            r10.w(r112);
            r13.b(r10, r17.get(r19));
            r19 = r19 + 1;
            goto L33
        L40:
            if ((r29 instanceof Boolean) == false) goto L43;
            r112 = Boolean.toString(r111.b());
            goto L50
        L43:
            if ((r29 instanceof String) == false) goto L46;
            r112 = r111.j();
            goto L50
        L46:
            throw new AssertionError();
        L48:
            if ((r110 instanceof ha.r) == false) goto L52;
            r112 = "null";
            goto L50
        L52:
            throw new AssertionError();
        }
    }

    public h(ja.i r8) {
        this.f9001a = r8;
        this.f9002b = false;
    }

    @Override // ha.d0
    public final <T> c0<T> a(ha.j r12, oa.a<T> r13) {
        Type r8 = r13.getType();
        Class<? super T> r10 = r13.getRawType();
        if (Map.class.isAssignableFrom(r10) == true) goto L7;
        return null;
    L7:
        if (r8 != Properties.class) goto L9;
        Type r11 = String.class;
    L13:
        Type[] r14 = {r11, r11};
    L14:
        Type r15 = r14[0];
        if (r15 != Boolean.TYPE) goto L17;
    L20:
        c0<T> r16 = r.f9056c;
    L21:
        c0<T> r17 = r12.f(oa.a.get(r14[1]));
        ja.t<T> r18 = this.f9001a.b(r13);
        Type r19 = r14[0];
        return new a(this, r12, r19, r16, r14[1], r17, r18);
    L17:
        if (r15 == Boolean.class) goto L20;
        r16 = r12.f(oa.a.get(r15));
        goto L21
    L9:
        Type r20 = ja.a.f(r8, r10, Map.class);
        if ((r20 instanceof ParameterizedType) == false) goto L12;
        r14 = ((ParameterizedType) r20).getActualTypeArguments();
        goto L14
    L12:
        r11 = Object.class;
        goto L13
    }
}
