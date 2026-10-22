package wka;

import ala.d;
import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;
import vka.f;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class c implements vka.b<Long> {
    public static final /* synthetic */ int h = 0;
    public final String a;
    public final Long b;
    public final long c;
    public final Long d;
    public final boolean e;
    public final Integer f;
    public final boolean g;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        f r0 = f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        ContentValues r1 = new ContentValues();
        r1.put("event_id", Long.valueOf(this.c));
        if (this.e == false) goto L6;
        r1.put("minutes", this.d);
    L6:
        if (this.g == false) goto L9;
        r1.put("method", this.f);
    L9:
        if (this.b == null) goto L14;
        if (r0.update(new d(this.b, this.a), r1, null, null) > 0) goto L16;
        return null;
    L16:
        return this.b;
    L14:
        return r0.insert(new d(null, this.a), r1);
    }

    public c(String r2, Long r3, long r4, Long r6, boolean r7, Integer r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r2, "accountName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
    }
}
