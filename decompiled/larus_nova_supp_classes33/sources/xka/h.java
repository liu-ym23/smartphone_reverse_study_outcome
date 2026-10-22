package xka;

import android.content.ContentValues;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class h implements vka.b<Boolean> {
    public static final /* synthetic */ int f = 0;
    public final long a;
    public final String b;
    public final String c;
    public final Boolean d;
    public final Boolean e;

    public static final class a {
    }

    static {
    }

    @Override // vka.b
    public final Object execute() {
        vka.f r0 = vka.f.a;
        Intrinsics.checkNotNullParameter(r0, "context");
        ContentValues r1 = new ContentValues();
        r1.put("name", this.b);
        r1.put("calendar_displayName", this.c);
        r1.put("visible", this.d);
        r1.put("sync_events", this.e);
        if (r0.update(new ala.a(Long.valueOf(this.a), 2), r1, null, null) <= 0) goto L5;
        boolean r2 = true;
    L7:
        return Boolean.valueOf(r2);
    L5:
        r2 = false;
        goto L7
    }

    public h(long r1, String r3, String r4, Boolean r5, Boolean r6) {
        this.a = r1;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }
}
