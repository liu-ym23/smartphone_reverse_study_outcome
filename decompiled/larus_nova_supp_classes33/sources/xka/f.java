package xka;

import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class f implements vka.b<Boolean> {
    public static final /* synthetic */ int d = 0;
    public final String a;
    public final Long b;
    public final Long c;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        boolean r2 = true;
        if (this.b == null) goto L10;
        if (r0.delete(new ala.d(this.b, this.a), null, null) > 0) goto L19;
        r2 = false;
    L19:
        return Boolean.valueOf(r2);
    L10:
        if (this.c == null) goto L18;
        vka.k r1 = new vka.k();
        r1.a("event_id", this.c);
        Pair<String, String[]> r3 = r1.b();
        String r4 = (String) r3.component1();
        String[] r5 = (String[]) r3.component2();
        if (r0.delete(new ala.d(this.b, this.a), r4, r5) > 0) goto L16;
        r2 = false;
    L16:
        return Boolean.valueOf(r2);
    L18:
        throw new IllegalArgumentException("id or eventId must be provided");
    }

    public f(String r1, Long r2, Long r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
