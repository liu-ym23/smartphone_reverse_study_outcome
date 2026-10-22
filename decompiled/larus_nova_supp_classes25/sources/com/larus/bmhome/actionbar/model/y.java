package com.larus.bmhome.actionbar.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.UnknownFieldException;
import nuc.g2;
import nuc.i2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Serializable
public final class y {
    public static final b Companion = null;
    public static final Lazy<juc.d<Object>>[] g = null;
    public final ArrayList<z0> a;
    public final Map<Long, e2> b;
    public final Map<Long, w0> c;
    public final Object d;
    public h e;
    public Map<String, a0> f;

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly")
    public /* synthetic */ class a implements nuc.m0<y> {
        public static final a a = null;
        public static final g2 b = null;

        public a() {
        }

        public final luc.f getDescriptor() {
            return b;
        }

        static {
            a r0 = new a();
            a = r0;
            g2 r1 = new g2("com.larus.bmhome.actionbar.model.ActionBarMenuConf", r0, 1);
            r1.j("item_list", true);
            b = r1;
        }

        public final juc.d<?>[] childSerializers() {
            return new juc.d[]{kuc.a.d((juc.d) y.g[0].getValue())};
        }

        public final juc.d<?>[] typeParametersSerializers() {
            return i2.a;
        }

        public final Object deserialize(muc.e r9) {
            Intrinsics.checkNotNullParameter(r9, "decoder");
            g2 r0 = b;
            muc.c r10 = r9.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = y.g;
            int r3 = 1;
            ArrayList r5 = null;
            if (r10.decodeSequentially() == false) goto L5;
            ArrayList r2 = (ArrayList) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), null);
        L15:
            r10.endStructure(r0);
            return new y(r3, r2);
        L5:
            int r4 = 0;
        L6:
            if (r3 == 0) goto L14;
            int r6 = r10.decodeElementIndex(r0);
            if (r6 != (-1)) goto L9;
            r3 = 0;
            goto L6
        L9:
            if (r6 != 0) goto L12;
            r5 = (ArrayList) r10.decodeNullableSerializableElement(r0, 0, (juc.c) r1[0].getValue(), r5);
            r4 = r4 | 1;
            goto L6
        L12:
            throw new UnknownFieldException(r6);
        L14:
            r3 = r4;
            r2 = r5;
            goto L15
        }

        public final void serialize(muc.f r6, Object r7) {
            y r8 = (y) r7;
            Intrinsics.checkNotNullParameter(r6, "encoder");
            Intrinsics.checkNotNullParameter(r8, "value");
            g2 r0 = b;
            muc.d r9 = r6.beginStructure(r0);
            Lazy<juc.d<Object>>[] r1 = y.g;
            if (r9.shouldEncodeElementDefault(r0, 0) == false) goto L6;
        L7:
            boolean r3 = true;
        L9:
            if (r3 == false) goto L11;
            r9.encodeNullableSerializableElement(r0, 0, (juc.n) r1[0].getValue(), r8.a);
        L11:
            r9.endStructure(r0);
            return;
        L6:
            if (Intrinsics.areEqual(r8.a, new ArrayList()) == false) goto L7;
            r3 = false;
            goto L9
        }
    }

    public static final class b {
        public b() {
        }

        public final juc.d<y> serializer() {
            return a.a;
        }
    }

    public y() {
        this(0);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof y) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.a, ((y) r4).a) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        ArrayList<z0> r0 = this.a;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public final String toString() {
        return "ActionBarMenuConf(actionBarItemList=" + this.a + ')';
    }

    static {
        Companion = new b();
        g = new Lazy[]{LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new wa8.d0())};
    }

    public final Map<String, a0> b() {
        if (this.f == null) goto L38;
    L34:
        Map<String, a0> r0 = this.f;
        if (r0 == null) goto L37;
        return r0;
    L37:
        return MapsKt.emptyMap();
    L38:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L28
        ArrayList<z0> r2 = this.a;     // Catch: Throwable -> L28
        List<u> r3 = null;
        if (r2 == null) goto L26;
        Iterator<T> r4 = r2.iterator();     // Catch: Throwable -> L28
    L8:
        if (r4.hasNext() == false) goto L20;
        Object r5 = r4.next();     // Catch: Throwable -> L28
        r r6 = ((z0) r5).q;     // Catch: Throwable -> L28
        if (r6 == null) goto L17;
        Integer r7 = r6.a;     // Catch: Throwable -> L28
        if (r7 == null) goto L17;
        if (r7.intValue() != 18) goto L17;
        boolean r8 = true;
    L18:
        if (r8 == false) goto L8;
    L21:
        z0 r9 = (z0) r5;     // Catch: Throwable -> L28
        if (r9 == null) goto L26;
        r r10 = r9.q;     // Catch: Throwable -> L28
        if (r10 == null) goto L26;
        r3 = r10.b;     // Catch: Throwable -> L28
    L17:
        r8 = false;
        goto L18
    L20:
        r5 = null;
    L26:
        Object r11 = Result.constructor-impl(x.a(r3));     // Catch: Throwable -> L28
    L30:
        Map r12 = MapsKt.emptyMap();
        if (Result.isFailure-impl(r11) == false) goto L33;
        r11 = r12;
    L33:
        this.f = (Map) r11;
    L28:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L30
    }

    public final h c() {
        if (this.e != null) goto L100;
        Object r0 = null;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L92
        ArrayList<z0> r2 = this.a;     // Catch: Throwable -> L92
        String r4 = "";
        if (r2 == null) goto L47;
        Iterator<T> r3 = r2.iterator();     // Catch: Throwable -> L92
    L10:
        if (r3.hasNext() == false) goto L22;
        Object r5 = r3.next();     // Catch: Throwable -> L92
        r r6 = ((z0) r5).q;     // Catch: Throwable -> L92
        if (r6 == null) goto L19;
        Integer r7 = r6.a;     // Catch: Throwable -> L92
        if (r7 == null) goto L19;
        if (r7.intValue() != 18) goto L19;
        boolean r8 = true;
    L20:
        if (r8 == false) goto L10;
    L23:
        z0 r9 = (z0) r5;     // Catch: Throwable -> L92
        if (r9 == null) goto L47;
        r r10 = r9.q;     // Catch: Throwable -> L92
        if (r10 == null) goto L47;
        List<u> r11 = r10.b;     // Catch: Throwable -> L92
        if (r11 == null) goto L47;
        Iterator<T> r12 = r11.iterator();     // Catch: Throwable -> L92
    L31:
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();     // Catch: Throwable -> L92
        Integer r14 = ((u) r13).b;     // Catch: Throwable -> L92
        if (r14 != null) goto L36;
    L38:
        boolean r15 = false;
    L39:
        if (r15 == false) goto L31;
    L42:
        u r16 = (u) r13;     // Catch: Throwable -> L92
        if (r16 == null) goto L47;
        String r17 = r16.d;     // Catch: Throwable -> L92
        if (r17 == null) goto L47;
    L103:
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L50
        Object r19 = Result.constructor-impl((b0) xt7.d.b.c(b0.Companion.serializer(), r17));     // Catch: Throwable -> L50
    L53:
        if (Result.isFailure-impl(r19) == false) goto L55;
        r19 = null;
    L55:
        b0 r20 = (b0) r19;     // Catch: Throwable -> L92
        if (r20 == null) goto L76;
        List<c0> r21 = r20.a;     // Catch: Throwable -> L92
        if (r21 == null) goto L76;
        Iterator<T> r22 = r21.iterator();     // Catch: Throwable -> L92
    L61:
        if (r22.hasNext() == false) goto L73;
        Object r23 = r22.next();     // Catch: Throwable -> L92
        c0 r24 = (c0) r23;     // Catch: Throwable -> L92
        if (r24.b != 3) goto L70;
        Integer r25 = r24.a;     // Catch: Throwable -> L92
        if (r25 == null) goto L70;
        if (r25.intValue() != 6) goto L70;
        boolean r26 = true;
    L71:
        if (r26 == false) goto L61;
    L74:
        c0 r27 = (c0) r23;     // Catch: Throwable -> L92
    L101:
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L85
        ouc.v r29 = xt7.d.b;     // Catch: Throwable -> L85
        juc.c r30 = h.Companion.serializer();     // Catch: Throwable -> L85
        if (r27 == null) goto L83;
        String r31 = r27.c;     // Catch: Throwable -> L85
        if (r31 == null) goto L83;
        r4 = r31;
    L83:
        Object r32 = Result.constructor-impl((h) r29.c(r30, r4));     // Catch: Throwable -> L85
    L88:
        if (Result.isFailure-impl(r32) == false) goto L90;
        r32 = null;
    L90:
        Object r33 = Result.constructor-impl((h) r32);     // Catch: Throwable -> L92
    L95:
        if (Result.isFailure-impl(r33) == true) goto L98;
        r0 = r33;
    L98:
        this.e = (h) r0;
    L85:
        th = move-exception;
        Result.Companion r34 = Result.Companion;     // Catch: Throwable -> L92
        r32 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L92
    L70:
        r26 = false;
        goto L71
    L73:
        r23 = null;
    L76:
        r27 = null;
    L50:
        th = move-exception;
        Result.Companion r35 = Result.Companion;     // Catch: Throwable -> L92
        r19 = Result.constructor-impl(ResultKt.createFailure(th));     // Catch: Throwable -> L92
        goto L53
    L36:
        if (r14.intValue() != 8) goto L38;
        r15 = true;
        goto L39
    L41:
        r13 = null;
    L19:
        r8 = false;
        goto L20
    L22:
        r5 = null;
    L47:
        r17 = "";
    L92:
        th = move-exception;
        Result.Companion r36 = Result.Companion;
        r33 = Result.constructor-impl(ResultKt.createFailure(th));
    L100:
        return this.e;
    }

    public y(ArrayList<z0> r1) {
        this.a = r1;
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new Object();
    }

    public final w0 a(long r5) {
        Object r0 = this.d;
        monitor-enter(r0);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (this.c.containsKey(Long.valueOf(r5)) == true) goto L7;
        Long r1 = Long.valueOf(r5);     // Catch: Throwable -> L10
        this.c.put(r1, x.b(b(), r5));     // Catch: Throwable -> L10
    L7:
        w0 r6 = (w0) MapsKt.getValue(this.c, Long.valueOf(r5));     // Catch: Throwable -> L10
        monitor-exit(r0);
        return r6;
    }

    public final e2 d(long r10) {
        Object r0 = this.d;
        monitor-enter(r0);
    L30:
        th = move-exception;
        throw th;
    L5:
        if (this.b.containsKey(Long.valueOf(r10)) == true) goto L27;
        Map<Long, e2> r1 = this.b;     // Catch: Throwable -> L30
        Long r2 = Long.valueOf(r10);     // Catch: Throwable -> L30
        h r3 = c();     // Catch: Throwable -> L30
        e2 r4 = null;
        if (r3 == null) goto L26;
        List<w> r5 = r3.e;     // Catch: Throwable -> L30
        if (r5 == null) goto L26;
        Iterator<T> r6 = r5.iterator();     // Catch: Throwable -> L30
    L12:
        if (r6.hasNext() == false) goto L22;
        Object r7 = r6.next();     // Catch: Throwable -> L30
        Long r8 = ((w) r7).a;     // Catch: Throwable -> L30
        if (r8 != null) goto L17;
    L19:
        boolean r9 = false;
    L20:
        if (r9 == false) goto L12;
    L23:
        w r11 = (w) r7;     // Catch: Throwable -> L30
        if (r11 == null) goto L26;
        r4 = r11.c();     // Catch: Throwable -> L30
        goto L26
    L17:
        if (r8.longValue() != r10) goto L19;
        r9 = true;
        goto L20
    L22:
        r7 = null;
    L26:
        r1.put(r2, r4);     // Catch: Throwable -> L30
    L27:
        e2 r12 = (e2) ((LinkedHashMap) this.b).get(Long.valueOf(r10));     // Catch: Throwable -> L30
        monitor-exit(r0);
        return r12;
    }

    public /* synthetic */ y(int r1) {
        this(new ArrayList());
    }

    public y(int r3, ArrayList r4) {
        if ((r3 & 0) == 0) goto L5;
        nuc.b2.b(r3, 0, a.b);
        throw null;
    L5:
        if ((r3 & 1) != 0) goto L7;
        this.a = new ArrayList();
    L8:
        this.b = new LinkedHashMap();
        this.c = new LinkedHashMap();
        this.d = new Object();
        this.e = null;
        this.f = null;
        return;
    L7:
        this.a = r4;
        goto L8
    }
}
