package he;

import com.obric.cae.cloud.ttnet.MultiProcessSharedProvider;
import com.qualcomm.qti.qesdk.QesdkUtils;
import ge.s;
import ge.t;
import ge.u;
import ge.v;
import ge.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class d implements le.b<Object>, c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<Class<? extends xd.a<?>>, Integer> f8058b = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f8059a;

    static {
        List r8 = l6.a.l0(new Class[]{ge.a.class, ge.l.class, ge.p.class, ge.q.class, ge.r.class, s.class, t.class, u.class, v.class, w.class, ge.b.class, ge.c.class, ge.d.class, ge.e.class, ge.f.class, ge.g.class, ge.h.class, ge.i.class, ge.j.class, ge.k.class, ge.m.class, ge.n.class, ge.o.class});
        ArrayList r10 = new ArrayList(yd.f.f1(r8));
        Iterator r11 = r8.iterator();
        int r12 = 0;
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r13 = r11.next();
        int r14 = r12 + 1;
        if (r12 < 0) goto L8;
        r10.add(new xd.d((Class) r13, Integer.valueOf(r12)));
        r12 = r14;
        goto L4
    L8:
        l6.a.T0();
        throw null;
    L10:
        f8058b = me.e.g1(r10);
        HashMap r15 = new HashMap();
        r15.put("boolean", "kotlin.Boolean");
        r15.put(QesdkUtils.TYPES.DATA_TYPE_CHAR, "kotlin.Char");
        r15.put("byte", "kotlin.Byte");
        r15.put("short", "kotlin.Short");
        r15.put(QesdkUtils.TYPES.DATA_TYPE_INT, "kotlin.Int");
        r15.put("float", "kotlin.Float");
        r15.put(MultiProcessSharedProvider.LONG_TYPE, "kotlin.Long");
        r15.put(QesdkUtils.TYPES.DATA_TYPE_DOUBLE, "kotlin.Double");
        HashMap r16 = new HashMap();
        r16.put("java.lang.Boolean", "kotlin.Boolean");
        r16.put("java.lang.Character", "kotlin.Char");
        r16.put("java.lang.Byte", "kotlin.Byte");
        r16.put("java.lang.Short", "kotlin.Short");
        r16.put("java.lang.Integer", "kotlin.Int");
        r16.put("java.lang.Float", "kotlin.Float");
        r16.put("java.lang.Long", "kotlin.Long");
        r16.put("java.lang.Double", "kotlin.Double");
        HashMap r17 = new HashMap();
        r17.put("java.lang.Object", "kotlin.Any");
        r17.put("java.lang.String", "kotlin.String");
        r17.put("java.lang.CharSequence", "kotlin.CharSequence");
        r17.put("java.lang.Throwable", "kotlin.Throwable");
        r17.put("java.lang.Cloneable", "kotlin.Cloneable");
        r17.put("java.lang.Number", "kotlin.Number");
        r17.put("java.lang.Comparable", "kotlin.Comparable");
        r17.put("java.lang.Enum", "kotlin.Enum");
        r17.put("java.lang.annotation.Annotation", "kotlin.Annotation");
        r17.put("java.lang.Iterable", "kotlin.collections.Iterable");
        r17.put("java.util.Iterator", "kotlin.collections.Iterator");
        r17.put("java.util.Collection", "kotlin.collections.Collection");
        r17.put("java.util.List", "kotlin.collections.List");
        r17.put("java.util.Set", "kotlin.collections.Set");
        r17.put("java.util.ListIterator", "kotlin.collections.ListIterator");
        r17.put("java.util.Map", "kotlin.collections.Map");
        r17.put("java.util.Map$Entry", "kotlin.collections.Map.Entry");
        r17.put("kotlin.jvm.internal.StringCompanionObject", "kotlin.String.Companion");
        r17.put("kotlin.jvm.internal.EnumCompanionObject", "kotlin.Enum.Companion");
        r17.putAll(r15);
        r17.putAll(r16);
        Collection r18 = r15.values();
        i.e(r18, "primitiveFqNames.values");
        Iterator r19 = r18.iterator();
    L12:
        if (r19.hasNext() == false) goto L14;
        String r20 = (String) r19.next();
        StringBuilder r21 = new StringBuilder("kotlin.jvm.internal.");
        i.e(r20, "kotlinName");
        r21.append(ne.j.G0(r20));
        r21.append("CompanionObject");
        r17.put(r21.toString(), r20.concat(".Companion"));
        goto L12
    L14:
        Iterator<Map.Entry<Class<? extends xd.a<?>>, Integer>> r22 = f8058b.entrySet().iterator();
    L16:
        if (r22.hasNext() == false) goto L18;
        Map.Entry<Class<? extends xd.a<?>>, Integer> r23 = r22.next();
        Class<? extends xd.a<?>> r24 = r23.getKey();
        int r25 = r23.getValue().intValue();
        r17.put(r24.getName(), "kotlin.Function" + r25);
        goto L16
    L18:
        LinkedHashMap r26 = new LinkedHashMap(l6.a.n0(r17.size()));
        Iterator r27 = r17.entrySet().iterator();
    L20:
        if (r27.hasNext() == false) goto L22;
        Map.Entry r28 = (Map.Entry) r27.next();
        r26.put(r28.getKey(), ne.j.G0((String) r28.getValue()));
        goto L20
    }

    public d(Class<?> r8) {
        i.f(r8, "jClass");
        this.f8059a = r8;
    }

    @Override // he.c
    public final Class<?> a() {
        return this.f8059a;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof d) == true) goto L5;
    L7:
        return false;
    L5:
        if (i.a(l6.a.N(this), l6.a.N((le.b) r8)) == false) goto L7;
        return true;
    }

    public final int hashCode() {
        return l6.a.N(this).hashCode();
    }

    public final String toString() {
        return this.f8059a.toString() + " (Kotlin reflection is not available)";
    }
}
