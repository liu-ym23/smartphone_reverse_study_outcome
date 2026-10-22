package com.lynx.tasm.behavior.utils;

import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxPropGroup;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.x0;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class e {
    public static final Map<Class, Map<String, k>> a = null;
    public static final Map<String, k> b = null;

    public static class a extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r2) {
            return r2.a(this.a);
        }

        public a(LynxProp r1, Method r2) {
            super(r1, r2);
        }

        public a(LynxPropGroup r1, Method r2, int r3) {
            super(r1, r2, r3);
        }
    }

    public static class b extends k {
        public final boolean d;

        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r3) {
            if (r3.b(this.a, this.d) == false) goto L6;
            return Boolean.TRUE;
        L6:
            return Boolean.FALSE;
        }

        public b(LynxProp r1, Method r2, boolean r3) {
            super(r1, r2);
            this.d = r3;
        }
    }

    public static class c extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r3) {
            if (r3.k(this.a) == false) goto L5;
            return null;
        L5:
            if (r3.b(this.a, false) == false) goto L8;
            return Boolean.TRUE;
        L8:
            return Boolean.FALSE;
        }

        public c(LynxProp r1, Method r2) {
            super(r1, r2);
        }
    }

    public static class d extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r3) {
            if (r3.k(this.a) == false) goto L5;
            return null;
        L5:
            return Integer.valueOf(r3.f(this.a, 0));
        }

        public d(LynxProp r1, Method r2) {
            super(r1, r2);
        }

        public d(LynxPropGroup r1, Method r2, int r3) {
            super(r1, r2, r3);
        }
    }

    /* JADX INFO: renamed from: com.lynx.tasm.behavior.utils.e$e, reason: collision with other inner class name */
    public static class C0057e extends k {
        public final double d;

        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r4) {
            return Double.valueOf(r4.c(this.a, this.d));
        }

        public C0057e(LynxProp r1, Method r2, double r3) {
            super(r1, r2);
            this.d = r3;
        }

        public C0057e(LynxPropGroup r1, Method r2, int r3, double r4) {
            super(r1, r2, r3);
            this.d = r4;
        }
    }

    public static class f extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r2) {
            return r2.d(this.a);
        }

        public f(LynxProp r1, Method r2) {
            super(r1, r2);
        }

        public f(LynxPropGroup r1, Method r2, int r3) {
            super(r1, r2, r3);
        }
    }

    public static class g extends k {
        public final float d;

        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r3) {
            return Float.valueOf(r3.e(this.a, this.d));
        }

        public g(LynxProp r1, Method r2, float r3) {
            super(r1, r2);
            this.d = r3;
        }

        public g(LynxPropGroup r1, Method r2, int r3, float r4) {
            super(r1, r2, r3);
            this.d = r4;
        }
    }

    public static class h extends k {
        public final int d;

        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r3) {
            return Integer.valueOf(r3.f(this.a, this.d));
        }

        public h(LynxProp r1, Method r2, int r3) {
            super(r1, r2);
            this.d = r3;
        }

        public h(LynxPropGroup r1, Method r2, int r3, int r4) {
            super(r1, r2, r3);
            this.d = r4;
        }
    }

    public static class i extends k {
        public final long d;

        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r5) {
            String r0 = this.a;
            long r1 = this.d;
            if (r5.a.isNull(r0) == true) goto L7;
            r1 = r5.a.getLong(r0);
        L7:
            return Long.valueOf(r1);
        }

        public i(LynxProp r1, Method r2) {
            super(r1, r2);
            this.d = 0;
        }

        public i(LynxPropGroup r1, Method r2, int r3) {
            super(r1, r2, r3);
            this.d = 0;
        }
    }

    public static class j extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r2) {
            return r2.g(this.a);
        }

        public j(LynxProp r1, Method r2) {
            super(r1, r2);
        }
    }

    public static abstract class k {
        public final String a;
        public final Method b;
        public final Integer c;

        public abstract Object a(x0 r1);

        public k(LynxProp r3, Method r4) {
            this.a = r3.name();
            if ("__default_type__".equals(r3.customType()) == true) goto L6;
            r3.customType();
        L6:
            this.b = r4;
            this.c = null;
        }

        public k(LynxPropGroup r3, Method r4, int r5) {
            this.a = r3.names()[r5];
            if ("__default_type__".equals(r3.customType()) == true) goto L6;
            r3.customType();
        L6:
            this.b = r4;
            this.c = Integer.valueOf(r5);
        }
    }

    public static class l extends k {
        @Override // com.lynx.tasm.behavior.utils.e.k
        public final Object a(x0 r2) {
            return r2.h(this.a);
        }

        public l(LynxProp r1, Method r2) {
            super(r1, r2);
        }

        public l(LynxPropGroup r1, Method r2, int r3) {
            super(r1, r2, r3);
        }
    }

    static {
        a = new ConcurrentHashMap();
        b = new HashMap();
    }

    public static Map<String, k> c(Class<? extends LynxBaseUI> r12) {
        if (r12 == null) goto L4;
        Map<String, k> r0 = (Map) ((ConcurrentHashMap) a).get(r12);
        if (r0 == null) goto L8;
        return r0;
    L8:
        HashMap r1 = new HashMap();
        if (r12 != LynxBaseUI.class) goto L11;
        Class<? super Object> r2 = null;
    L12:
        r1.putAll(c(r2));
        Method[] r3 = r12.getDeclaredMethods();
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L33;
        Method r6 = r3[r5];
        LynxProp r7 = (LynxProp) r6.getAnnotation(LynxProp.class);
        if (r7 == null) goto L21;
        Class<?>[] r9 = r6.getParameterTypes();
        if (r9.length != 1) goto L20;
        r1.put(r7.name(), a(r7, r6, r9[0]));
        goto L21
    L20:
        throw new RuntimeException("Wrong number of args for prop setter: " + r12.getName() + "#" + r6.getName());
    L21:
        LynxPropGroup r8 = (LynxPropGroup) r6.getAnnotation(LynxPropGroup.class);
        if (r8 == null) goto L32;
        Class<?>[] r10 = r6.getParameterTypes();
        if (r10.length != 2) goto L31;
        if (r10[0] != Integer.TYPE) goto L29;
        b(r8, r6, r10[1], r1);
        goto L32
    L29:
        throw new RuntimeException("Second argument should be property index: " + r12.getName() + "#" + r6.getName());
    L31:
        throw new RuntimeException("Wrong number of args for group prop setter: " + r12.getName() + "#" + r6.getName());
    L32:
        r5 = r5 + 1;
        goto L13
    L33:
        ((ConcurrentHashMap) a).put(r12, r1);
        return r1;
    L11:
        r2 = r12.getSuperclass();
        goto L12
    L4:
        return b;
    }

    public static Map<String, k> d(Class<? extends ShadowNode> r12) {
        if (r12 == null) goto L4;
        Map<String, k> r0 = (Map) ((ConcurrentHashMap) a).get(r12);
        if (r0 == null) goto L8;
        return r0;
    L8:
        HashMap r1 = new HashMap();
        if (r12 != ShadowNode.class) goto L11;
        Class<? super Object> r2 = null;
    L12:
        r1.putAll(d(r2));
        Method[] r3 = r12.getDeclaredMethods();
        int r4 = r3.length;
        int r5 = 0;
    L13:
        if (r5 >= r4) goto L33;
        Method r6 = r3[r5];
        LynxProp r7 = (LynxProp) r6.getAnnotation(LynxProp.class);
        if (r7 == null) goto L21;
        Class<?>[] r9 = r6.getParameterTypes();
        if (r9.length != 1) goto L20;
        r1.put(r7.name(), a(r7, r6, r9[0]));
        goto L21
    L20:
        throw new RuntimeException("Wrong number of args for prop setter: " + r12.getName() + "#" + r6.getName());
    L21:
        LynxPropGroup r8 = (LynxPropGroup) r6.getAnnotation(LynxPropGroup.class);
        if (r8 == null) goto L32;
        Class<?>[] r10 = r6.getParameterTypes();
        if (r10.length != 2) goto L31;
        if (r10[0] != Integer.TYPE) goto L29;
        b(r8, r6, r10[1], r1);
        goto L32
    L29:
        throw new RuntimeException("Second argument should be property index: " + r12.getName() + "#" + r6.getName());
    L31:
        throw new RuntimeException("Wrong number of args for group prop setter: " + r12.getName() + "#" + r6.getName());
    L32:
        r5 = r5 + 1;
        goto L13
    L33:
        ((ConcurrentHashMap) a).put(r12, r1);
        return r1;
    L11:
        r2 = r12.getSuperclass();
        goto L12
    L4:
        return b;
    }

    public static k a(LynxProp r2, Method r3, Class<?> r4) {
        if (r4 != f6a.a.class) goto L7;
        return new f(r2, r3);
    L7:
        if (r4 != Boolean.TYPE) goto L11;
        return new b(r2, r3, r2.defaultBoolean());
    L11:
        if (r4 != Integer.TYPE) goto L15;
        return new h(r2, r3, r2.defaultInt());
    L15:
        if (r4 != Long.TYPE) goto L19;
        return new i(r2, r3);
    L19:
        if (r4 != Float.TYPE) goto L23;
        return new g(r2, r3, r2.defaultFloat());
    L23:
        if (r4 != Double.TYPE) goto L27;
        return new C0057e(r2, r3, r2.defaultDouble());
    L27:
        if (r4 != String.class) goto L31;
        return new l(r2, r3);
    L31:
        if (r4 != Boolean.class) goto L35;
        return new c(r2, r3);
    L35:
        if (r4 != Integer.class) goto L39;
        return new d(r2, r3);
    L39:
        if (r4 != ReadableArray.class) goto L43;
        return new a(r2, r3);
    L43:
        if (r4 != ReadableMap.class) goto L47;
        return new j(r2, r3);
    L47:
        throw new RuntimeException("Unrecognized type: " + r4 + " for method: " + r3.getDeclaringClass().getName() + "#" + r3.getName());
    }

    public static void b(LynxPropGroup r9, Method r10, Class<?> r11, Map<String, k> r12) {
        String[] r0 = r9.names();
        int r2 = 0;
        if (r11 != f6a.a.class) goto L8;
    L5:
        if (r2 >= r0.length) goto L42;
        ((HashMap) r12).put(r0[r2], new f(r9, r10, r2));
        r2 = r2 + 1;
        goto L5
    L42:
        return;
    L8:
        if (r11 != Integer.TYPE) goto L13;
    L10:
        if (r2 >= r0.length) goto L53;
        ((HashMap) r12).put(r0[r2], new h(r9, r10, r2, r9.defaultInt()));
        r2 = r2 + 1;
        goto L10
    L53:
        return;
    L13:
        if (r11 != Long.TYPE) goto L18;
    L15:
        if (r2 >= r0.length) goto L54;
        ((HashMap) r12).put(r0[r2], new i(r9, r10, r2));
        r2 = r2 + 1;
        goto L15
    L54:
        return;
    L18:
        if (r11 != Float.TYPE) goto L23;
    L20:
        if (r2 >= r0.length) goto L55;
        ((HashMap) r12).put(r0[r2], new g(r9, r10, r2, r9.defaultFloat()));
        r2 = r2 + 1;
        goto L20
    L55:
        return;
    L23:
        if (r11 != Double.TYPE) goto L28;
    L25:
        if (r2 >= r0.length) goto L56;
        HashMap r3 = (HashMap) r12;
        r3.put(r0[r2], new C0057e(r9, r10, r2, r9.defaultDouble()));
        r2 = r2 + 1;
        goto L25
    L56:
        return;
    L28:
        if (r11 != Integer.class) goto L33;
    L30:
        if (r2 >= r0.length) goto L57;
        ((HashMap) r12).put(r0[r2], new d(r9, r10, r2));
        r2 = r2 + 1;
        goto L30
    L57:
        return;
    L33:
        if (r11 != String.class) goto L38;
    L35:
        if (r2 >= r0.length) goto L58;
        ((HashMap) r12).put(r0[r2], new l(r9, r10, r2));
        r2 = r2 + 1;
        goto L35
    L58:
        return;
    L38:
        if (r11 != ReadableArray.class) goto L44;
    L40:
        if (r2 >= r0.length) goto L59;
        ((HashMap) r12).put(r0[r2], new a(r9, r10, r2));
        r2 = r2 + 1;
        goto L40
    L59:
        return;
    L44:
        throw new RuntimeException("Unrecognized type: " + r11 + " for method: " + r10.getDeclaringClass().getName() + "#" + r10.getName());
    }
}
