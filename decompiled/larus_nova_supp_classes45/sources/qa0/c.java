package qa0;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements b {
    public static b a;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
    }

    @Override // qa0.b
    public final <T extends a> T getService(Class<T> r3) {
        Intrinsics.checkNotNullParameter(r3, "serviceCls");
        b r0 = a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("impl");
    L6:
        return (T) r0.getService(r3);
    }
}
