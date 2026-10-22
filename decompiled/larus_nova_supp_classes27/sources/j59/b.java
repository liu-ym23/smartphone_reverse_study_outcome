package j59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class b {
    public final d a;
    public final String b;
    public final String c;

    public final a b() {
        return new a(this.a.getLong(a("last_show_time")), this.a.getInt(a("show_times")), this.a.getInt(a("close_times")), this.a.getInt(a("click_times")));
    }

    public final String a(String r3) {
        return this.b + '_' + r3 + '_' + this.c;
    }

    public b(c r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "store");
        Intrinsics.checkNotNullParameter(r3, "keyPrefix");
        Intrinsics.checkNotNullParameter(r4, "sn");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
