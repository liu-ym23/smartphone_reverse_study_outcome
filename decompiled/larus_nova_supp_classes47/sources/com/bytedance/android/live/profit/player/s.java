package com.bytedance.android.live.profit.player;

import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public abstract class s<T> {
    public static final /* synthetic */ int a = 0;

    public static final class a {
        public static b a(Throwable r1) {
            Intrinsics.checkNotNullParameter(r1, "t");
            return new b(r1);
        }
    }

    public static final class b<T> extends s<T> {
        public final Throwable b;

        public b(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "throwable");
            this.b = r2;
        }
    }

    public static final class c<T> extends s<T> {
        public final T b;

        public c(T r1) {
            this.b = r1;
        }
    }

    static {
    }

    public s() {
    }

    public final Throwable a() {
        if ((this instanceof c) == false) goto L6;
        return null;
    L6:
        if ((this instanceof b) == false) goto L10;
        return ((b) this).b;
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public final T b() {
        if ((this instanceof c) == false) goto L6;
        return ((c) this).b;
    L6:
        if ((this instanceof b) == false) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
