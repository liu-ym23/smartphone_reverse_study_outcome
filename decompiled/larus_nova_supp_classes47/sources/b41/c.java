package b41;

import android.graphics.RectF;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class c {
    public final a a;
    public final c41.a b;
    public final kc0.d c;

    public static final class a<T> implements Observer {
        public final /* synthetic */ c a;

        public a(c r1) {
            this.a = r1;
        }

        public final void onChanged(Object r6) {
            rc0.c r7 = (rc0.c) r6;
            if (r7 == null) goto L10;
            RectF r0 = r7.a;
            if (r0 == null) goto L11;
            this.a.b.b.setValue(new g90.a(r7.e, r0, r7.f, o51.f.k.e.b));
            return;
        L11:
            return;
        }
    }

    public c(c41.a r2, kc0.d r3) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.b = r2;
        this.c = r3;
        this.a = new a(this);
    }
}
