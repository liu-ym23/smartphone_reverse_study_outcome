package cm8;

import android.content.Context;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class j {
    public static boolean f;
    public final Context a;
    public f b;
    public cm8.a c;
    public final Lazy d;
    public final b e;

    public static final class a {
    }

    public static final class b implements bm8.j {
        public final /* synthetic */ j a;

        @Override // bm8.j
        public final void refresh() {
            f r0 = this.a.b;
            if (r0 == null) goto L8;
            Function0<Unit> r1 = r0.l;
            if (r1 == null) goto L9;
            r1.invoke();
            return;
        L9:
            return;
        }

        public b(j r1) {
            this.a = r1;
        }
    }

    static {
    }

    public j(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
        this.d = LazyKt.lazy(new g());
        this.e = new b(this);
    }
}
