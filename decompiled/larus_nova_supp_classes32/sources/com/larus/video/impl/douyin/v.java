package com.larus.video.impl.douyin;

import androidx.lifecycle.Observer;
import kotlin.Function;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class v {
    public final DouYinVideoActivity a;
    public final DouYinVideoDataManager b;
    public final Lazy c;
    public final Lazy d;
    public final Lazy e;

    public static final class a implements Observer, FunctionAdapter {
        public final /* synthetic */ Function1 a;

        public a(p r2) {
            Intrinsics.checkNotNullParameter(r2, "function");
            this.a = r2;
        }

        public final boolean equals(Object r3) {
            if ((r3 instanceof Observer) == true) goto L5;
            return false;
        L5:
            if ((r3 instanceof FunctionAdapter) == true) goto L7;
            return false;
        L7:
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) r3).getFunctionDelegate());
        }

        public final Function<?> getFunctionDelegate() {
            return this.a;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object r2) {
            this.a.invoke(r2);
        }
    }

    public v(DouYinVideoActivity r2, DouYinVideoDataManager r3) {
        Intrinsics.checkNotNullParameter(r2, "douYinVideoActivity");
        Intrinsics.checkNotNullParameter(r3, "douYinVideoDataManager");
        this.a = r2;
        this.b = r3;
        this.c = LazyKt.lazy(new r(this));
        this.d = LazyKt.lazy(new s(this));
        this.e = LazyKt.lazy(new t(this));
    }
}
