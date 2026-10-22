package xka;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class e implements vka.b<Boolean> {
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
        if (r0.delete(new ala.b(Long.valueOf(this.a), this.b), null, null) <= 0) goto L5;
        boolean r1 = true;
    L7:
        return Boolean.valueOf(r1);
    L5:
        r1 = false;
        goto L7
    }

    public e(long r1, String r3) {
        this.a = r1;
        this.b = r3;
    }
}
