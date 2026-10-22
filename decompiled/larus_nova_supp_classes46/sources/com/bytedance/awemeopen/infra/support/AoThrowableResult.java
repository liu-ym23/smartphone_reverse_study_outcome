package com.bytedance.awemeopen.infra.support;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class AoThrowableResult<T> {
    public static final /* synthetic */ int d = 0;
    public final Object a;
    public final Lazy b;
    public final Lazy c;

    public static final class a {
        public static AoThrowableResult a(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            return new AoThrowableResult(new b(r2));
        }
    }

    public static final class b {
        public final Throwable a;

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Failure(" + this.a + ')';
        }

        public b(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            this.a = r2;
        }

        public final boolean equals(Object r2) {
            if ((r2 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == false) goto L7;
            return true;
        }
    }

    static {
    }

    public AoThrowableResult(Object r2) {
        this.a = r2;
        LazyThreadSafetyMode r3 = LazyThreadSafetyMode.NONE;
        this.b = LazyKt.lazy(r3, new AoThrowableResult$isSuccess$2(this));
        this.c = LazyKt.lazy(r3, new AoThrowableResult$isFail$2(this));
    }

    public final <R> AoThrowableResult<R> a(Function1<? super T, ? extends R> r2) {
        Intrinsics.checkNotNullParameter(r2, "transform");
        if (((Boolean) this.b.getValue()).booleanValue() == false) goto L7;
        return new AoThrowableResult(r2.invoke(this.a));
    L7:
        return new AoThrowableResult(this.a);
    }
}
