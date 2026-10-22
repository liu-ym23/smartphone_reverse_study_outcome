package i8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public abstract class a {
    public final q a;

    public abstract void a();

    public abstract void b(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r1);

    public abstract void d(String r1, String r2);

    public a(q r2) {
        Intrinsics.checkNotNullParameter(r2, "mManager");
        this.a = r2;
    }

    public final void c(com.ss.android.lark.security.compliance.api.model.filepolicy.k<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "event");
        this.a.c(r2);
    }
}
