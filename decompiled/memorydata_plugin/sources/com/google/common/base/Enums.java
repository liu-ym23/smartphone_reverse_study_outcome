package com.google.common.base;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class Enums {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> f4283a = null;

    private static final class StringConverter<T extends Enum<T>> extends Converter<String, T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Class<T> enumClass;

        StringConverter(Class<T> r3) {
            this.enumClass = (Class) ZeusTransformUtils.preCheckCast(n.a(r3), Class.class, "com.obric.memorydata.plugin");
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ String doBackward(Object r3) {
            return doBackward((Enum) ZeusTransformUtils.preCheckCast(r3, Enum.class, "com.obric.memorydata.plugin"));
        }

        public String doBackward(T r1) {
            return r1.name();
        }

        /* JADX INFO: renamed from: doForward, reason: avoid collision after fix types in other method */
        public T doForward2(String r1) {
            return (T) Enum.valueOf(this.enumClass, r1);
        }

        @Override // com.google.common.base.Converter
        public /* synthetic */ Object doForward(String r3) {
            return doForward2((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin"));
        }

        @Override // com.google.common.base.Converter, com.google.common.base.g
        public boolean equals(Object r3) {
            if (ZeusTransformUtils.instanceOf(r3, StringConverter.class) == false) goto L6;
            StringConverter r4 = (StringConverter) ZeusTransformUtils.preCheckCast(r3, StringConverter.class, "com.obric.memorydata.plugin");
            return this.enumClass.equals(r4.enumClass);
        L6:
            return false;
        }

        public int hashCode() {
            return this.enumClass.hashCode();
        }

        public String toString() {
            return "Enums.stringConverter(" + this.enumClass.getName() + ".class)";
        }
    }

    static {
        f4283a = new WeakHashMap();
    }

    public static <T extends Enum<T>> Optional<T> a(Class<T> r0, String r1) {
        n.a(r0);
        n.a(r1);
        return m.a(r0, r1);
    }

    static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> a(Class<T> r4) {
        Map<Class<? extends Enum<?>>, Map<String, WeakReference<? extends Enum<?>>>> r0 = f4283a;
        monitor-enter(r0);
        Map<String, WeakReference<? extends Enum<?>>> r1 = (Map) ZeusTransformUtils.preCheckCast(r0.get(r4), Map.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        if (r1 != null) goto L7;
        r1 = b(r4);     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
        return r1;
    L9:
        th = move-exception;
        throw th;
    }

    private static <T extends Enum<T>> Map<String, WeakReference<? extends Enum<?>>> b(Class<T> r5) {
        HashMap r0 = new HashMap();
        Iterator r1 = EnumSet.allOf(r5).iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        Enum r2 = (Enum) ZeusTransformUtils.preCheckCast(r1.next(), Enum.class, "com.obric.memorydata.plugin");
        r0.put(r2.name(), new WeakReference(r2));
        goto L4
    L6:
        f4283a.put(r5, r0);
        return r0;
    }
}
