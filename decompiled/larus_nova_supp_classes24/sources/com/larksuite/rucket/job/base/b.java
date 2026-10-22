package com.larksuite.rucket.job.base;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b<R> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larksuite.rucket.job.base.b$b, reason: collision with other inner class name */
    public static final class C0062b extends b {
        public final ErrorResult b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof C0062b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((C0062b) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.b.hashCode();
        }

        public final String toString() {
            return "Error(exception=" + this.b + ')';
        }

        @Override // com.larksuite.rucket.job.base.b
        public final Object b() {
            throw this.b;
        }

        public C0062b(ErrorResult r2) {
            Intrinsics.checkNotNullParameter(r2, "exception");
            this.b = r2;
        }
    }

    public static final class c<T> extends b<T> {
        public final T b;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.b, ((c) r4).b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r0 = this.b;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.b + ')';
        }

        @Override // com.larksuite.rucket.job.base.b
        public final T b() {
            return this.b;
        }

        public c(T r1) {
            this.b = r1;
        }
    }

    static {
    }

    public b() {
    }

    public abstract R b();

    public final ErrorResult a() {
        if ((this instanceof C0062b) == true) goto L7;
        return null;
    L7:
        return ((C0062b) this).b;
    }
}
