package n4a;

import android.text.TextUtils;
import com.loc.av;
import com.loc.aw;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@av(a = "a")
public final class e5 {

    @aw(a = "a1", b = 6)
    public final String a;

    @aw(a = "a2", b = 6)
    public final String b;

    @aw(a = "a6", b = 2)
    public int c;

    @aw(a = "a4", b = 6)
    public final String d;

    @aw(a = "a5", b = 6)
    public final String e;
    public final String f;
    public String g;
    public String h;
    public String i;
    public String[] j;

    public static class a {
        public final String a;
        public String b;
        public final String c;
        public final String d;
        public String[] e;

        public a(String r2, String r3, String r4) {
            this.e = null;
            this.a = r3;
            this.b = r3;
            this.d = r4;
            this.c = r2;
        }

        public final e5 a() throws com.loc.l {
            if (this.e == null) goto L7;
            return new e5(this);
        L7:
            throw new com.loc.l("sdk packages is null");
        }
    }

    public e5() {
        this.c = 1;
        this.j = null;
    }

    public final String a() {
        if (TextUtils.isEmpty(this.h) == false) goto L8;
        if (TextUtils.isEmpty(this.a) == true) goto L8;
        this.h = f5.o(this.a);
    L8:
        return this.h;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.g) == false) goto L8;
        if (TextUtils.isEmpty(this.b) == true) goto L8;
        this.g = f5.o(this.b);
    L8:
        return this.g;
    }

    public final String c() {
        if (TextUtils.isEmpty(this.i) == false) goto L8;
        if (TextUtils.isEmpty(this.e) == true) goto L8;
        this.i = f5.o(this.e);
    L8:
        if (TextUtils.isEmpty(this.i) == false) goto L11;
        this.i = "standard";
    L11:
        return this.i;
    }

    public final boolean equals(Object r5) {
        if (r5 != null) goto L6;
        return false;
    L6:
        if (r5 != this) goto L9;
        return true;
    L9:
        if (e5.class == r5.getClass()) goto L20;
        return false;
    L20:
        if (this.h.equals(((e5) r5).h) == false) goto L18;
        if (this.f.equals(((e5) r5).f) == false) goto L18;
        if (this.g.equals(((e5) r5).g) == false) goto L18;
        return true;
    L18:
        return false;
    }

    public final String[] d() {
        String[] r0 = this.j;
        if (r0 == null) goto L7;
        if (r0.length == 0) goto L7;
    L15:
        return (String[]) this.j.clone();
    L7:
        if (TextUtils.isEmpty(this.d) == true) goto L15;
        String[] r1 = f5.o(this.d).split(";");     // Catch: Throwable -> L11
    L13:
        this.j = r1;
    L11:
        th = move-exception;
        th.printStackTrace();
        r1 = null;
        goto L13
    }

    public e5(a r6) {
        this.c = 1;
        String r1 = null;
        this.j = null;
        this.f = r6.a;
        String r2 = r6.b;
        this.g = r2;
        this.h = r6.c;
        String r3 = r6.d;
        this.c = 1;
        this.i = "standard";
        this.j = r6.e;
        this.b = f5.k(r2);
        this.a = f5.k(this.h);
        f5.k(r3);
        String[] r7 = this.j;
        if (r7 != null) goto L14;
    L12:
        this.d = f5.k(r1);
        this.e = f5.k(this.i);
        return;
    L14:
        StringBuilder r0 = new StringBuilder();     // Catch: Throwable -> L10
        int r4 = r7.length;     // Catch: Throwable -> L10
        int r5 = 0;
    L6:
        if (r5 >= r4) goto L8;
        r0.append(r7[r5]);     // Catch: Throwable -> L10
        r0.append(";");     // Catch: Throwable -> L10
        r5 = r5 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        r1 = r0.toString();     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        th.printStackTrace();
        goto L12
    }
}
