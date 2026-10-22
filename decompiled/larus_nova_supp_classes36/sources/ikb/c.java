package ikb;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c {
    public final Context a;
    public final h b;

    public static final class a {
        public final Context a;
        public h b;

        public final Context getContext() {
            return this.a;
        }

        public a(Context r2) {
            Intrinsics.checkNotNullParameter(r2, "context");
            this.a = r2;
        }
    }

    public final Context getContext() {
        return this.a;
    }

    public c(a r2) {
        Intrinsics.checkNotNullParameter(r2, "builder");
        this.a = r2.getContext();
        h r3 = r2.b;
        if (r3 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("proxyFactory");
        r3 = null;
    L6:
        this.b = r3;
    }
}
