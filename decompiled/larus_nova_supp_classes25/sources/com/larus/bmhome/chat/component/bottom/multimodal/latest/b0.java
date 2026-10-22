package com.larus.bmhome.chat.component.bottom.multimodal.latest;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class b0 {
    public final t1a.b a;
    public final de8.c b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;
    public final Lazy f;
    public final Lazy g;
    public final Lazy h;
    public final Lazy i;

    public static final class a {
    }

    public static final class b {
        public final String a;
        public final Function0<Boolean> b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof b) == true) goto L8;
            return false;
        L8:
            b r6 = (b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "DisallowCondition(logMessage=" + this.a + ", disable=" + this.b + ')';
        }

        public b(String r2, Function0<Boolean> r3) {
            Intrinsics.checkNotNullParameter(r2, "logMessage");
            Intrinsics.checkNotNullParameter(r3, "disable");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public b0(t1a.b r2, de8.c r3) {
        Intrinsics.checkNotNullParameter(r2, "vContext");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new m(this));
        this.d = LazyKt.lazy(new s(this));
        this.e = LazyKt.lazy(new t(this));
        this.f = LazyKt.lazy(new u(this));
        this.g = LazyKt.lazy(new v(this));
        this.h = LazyKt.lazy(new w(this));
        this.i = LazyKt.lazy(new x(this));
    }
}
