package xka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class d implements vka.b<Boolean> {
    public static final /* synthetic */ int c = 0;
    public final long a;
    public final String b;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        if (r0.delete(new ala.a(Long.valueOf(this.a), this.b), null, null) <= 0) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    public d(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "accountName");
        this.a = r2;
        this.b = r4;
    }
}
