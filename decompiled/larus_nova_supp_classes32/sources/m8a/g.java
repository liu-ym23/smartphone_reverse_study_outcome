package m8a;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class g {
    public final Uri a;
    public final String b;
    public final double c;

    public final Uri b() {
        Uri r0 = this.a;
        if (r0 == null) goto L6;
        return r0;
    L6:
        throw new AssertionError();
    }

    public final Uri a(Context r3) {
        if (i.b == null) goto L5;
    L14:
        int r4 = i.b.a(r3, this.b);
        if (r4 <= 0) goto L18;
        return new Uri.Builder().scheme("res").path(String.valueOf(r4)).build();
    L18:
        return Uri.EMPTY;
    L5:
        monitor-enter(i.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (i.b != null) goto L9;
        i.b = new i();     // Catch: Throwable -> L11
    L9:
        monitor-exit(i.class);     // Catch: Throwable -> L11
        goto L14
    }

    public g(Context r8, String r9) {
        this(r8, r9, 0.0d, 0.0d);
    }

    public g(Context r1, String r2, double r3, double r5) {
        this.b = r2;
        this.c = r3 * r5;
        Uri r4 = UriProtector.parse(r2);     // Catch: Exception -> L7
        if (r4.getScheme() != null) goto L8;
        r4 = a(r1);     // Catch: Exception -> L7
    L8:
        this.a = r4;
        return;
    L7:
        r4 = a(r1);
        goto L8
    }
}
