package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoCodeResult<T> {
    public static final /* synthetic */ int d = 0;
    public final Object a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
        public static AoCodeResult a(int r2) {
            return new AoCodeResult(new b(r2));
        }
    }

    public static final class b {
        public final int a;

        public final String toString() {
            return "Failure(" + this.a + ')';
        }

        public final int hashCode() {
            return this.a;
        }

        public b(int r1) {
            this.a = r1;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.a != ((b) r2).a) goto L7;
            return true;
        }
    }

    static {
    }

    public AoCodeResult(Object r2) {
        this.a = r2;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.b = LazyKt.lazy(r3, new AoCodeResult$isSuccess$2(this));
        this.c = LazyKt.lazy(r3, new AoCodeResult$isFail$2(this));
    }

    public final void a(Function1 r3) {
        Intrinsics.checkNotNullParameter(r3, "action");
        Object r0 = this.a;
        if ((r0 instanceof b) == false) goto L6;
        r3.invoke(Integer.valueOf(((b) r0).a));
        return;
    }

    public final void b(Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "action");
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L6;
        r2.invoke(this.a);
        return;
    }
}
