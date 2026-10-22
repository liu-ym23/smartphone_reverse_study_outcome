package com.google.common.graph;

import com.google.common.base.i;
import com.google.common.base.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Comparator;

/* JADX INFO: loaded from: classes2.dex */
public final class ElementOrder<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Type f4707a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Comparator<T> f4708b;

    public static final enum Type extends Enum<Type> {
        private static final /* synthetic */ Type[] $VALUES = null;
        public static final Type INSERTION = null;
        public static final Type SORTED = null;
        public static final Type STABLE = null;
        public static final Type UNORDERED = null;

        private static /* synthetic */ Type[] $values() {
            return new Type[]{UNORDERED, STABLE, INSERTION, SORTED};
        }

        static {
            UNORDERED = new Type("UNORDERED", 0);
            STABLE = new Type("STABLE", 1);
            INSERTION = new Type("INSERTION", 2);
            SORTED = new Type("SORTED", 3);
            $VALUES = $values();
        }

        private Type(String r1, int r2) {
            super(r1, r2);
        }

        public static Type valueOf(String r2) {
            return (Type) ZeusTransformUtils.preCheckCast(Enum.valueOf(Type.class, r2), Type.class, "com.obric.memorydata.plugin");
        }

        public static Type[] values() {
            return (Type[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), Type[].class, "com.obric.memorydata.plugin");
        }
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ElementOrder.class) == true) goto L8;
        return false;
    L8:
        ElementOrder r6 = (ElementOrder) ZeusTransformUtils.preCheckCast(r5, ElementOrder.class, "com.obric.memorydata.plugin");
        if (this.f4707a != r6.f4707a) goto L14;
        if (k.a(this.f4708b, r6.f4708b) == false) goto L14;
        return true;
    L14:
        return false;
    }

    public int hashCode() {
        return k.a(new Object[]{this.f4707a, this.f4708b});
    }

    public String toString() {
        i.a r0 = i.a(this).a("type", this.f4707a);
        Comparator<T> r3 = this.f4708b;
        if (r3 == null) goto L6;
        r0.a("comparator", r3);
    L6:
        return r0.toString();
    }
}
