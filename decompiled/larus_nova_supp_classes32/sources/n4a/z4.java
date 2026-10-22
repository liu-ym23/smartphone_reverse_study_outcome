package n4a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class z4 {
    public volatile b a;

    public static class a {
        public static final z4 a = null;

        static {
            a = new z4();
        }
    }

    public static class b {
        public int a;
        public boolean b;

        public b() {
            this.a = 0;
            this.b = true;
        }
    }

    public final boolean b() {
        if (this.a != null) goto L5;
        this.a = new b();
    L5:
        b r0 = this.a;
        r0.getClass();
        if (Build.VERSION.SDK_INT < 28) goto L8;
        boolean r1 = true;
    L10:
        if (r0.b == false) goto L20;
        int r2 = r0.a;
        if (r2 > 0) goto L14;
        r2 = 28;
    L14:
        if (r2 < 28) goto L16;
        boolean r3 = true;
    L17:
        if (r3 == true) goto L20;
        boolean r4 = false;
    L21:
        if (r1 == false) goto L24;
        if (r4 == false) goto L24;
        return true;
    L24:
        return false;
    L16:
        r3 = false;
    L20:
        r4 = true;
        goto L21
    L8:
        r1 = false;
        goto L10
    }

    public z4() {
        this.a = new b();
        String r0 = "HttpsDecisionUtil";
        if (TextUtils.isDigitsOnly("HttpsDecisionUtil") == false) goto L5;
        r0 = "SPUtil";
    L5:
        b5.a(r0);
    }

    public final void a(Context r4) {
        if (this.a != null) goto L5;
        this.a = new b();
    L5:
        b r0 = this.a;
        r0.b = y.i(r4, "a3", true);
        b r1 = this.a;
        if (r4 != null) goto L9;
        r1.getClass();
    L11:
        d r5 = d.a(r4);
        monitor-enter(r5);
        if (x4.e != null) goto L18;
        String r2 = i.b;     // Catch: Throwable -> L20
        h r3 = new h();     // Catch: Throwable -> L20
        if (x4.e != null) goto L18;
        x4.e = r3;     // Catch: Throwable -> L20
    L18:
        monitor-exit(r5);
        return;
    L9:
        if (r1.a > 0) goto L11;
        r1.a = r4.getApplicationContext().getApplicationInfo().targetSdkVersion;
        goto L11
    }
}
