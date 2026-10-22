package n4a;

import android.content.Context;
import com.obric.aivoice.core.data.NameKeys;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class y3 extends j0 {
    public Map<String, String> n;
    public String o;
    public String p;
    public String q;
    public byte[] r;
    public byte[] s;
    public boolean t;
    public String u;
    public Map<String, String> v;
    public boolean w;

    public y3(Context r1, e5 r2) {
        super(r1, r2);
        this.n = null;
        this.o = NameKeys.UnloadStrategy_No_Strategy;
        this.p = NameKeys.UnloadStrategy_No_Strategy;
        this.q = NameKeys.UnloadStrategy_No_Strategy;
        this.r = null;
        this.s = null;
        this.t = false;
        this.u = null;
        this.v = null;
        this.w = false;
    }

    @Override // com.loc.bo
    public final Map<String, String> a() {
        return this.n;
    }

    @Override // com.loc.bo
    public final String c() {
        return this.p;
    }

    @Override // n4a.a5, com.loc.bo
    public final String e() {
        return this.q;
    }

    @Override // n4a.j0, com.loc.bo
    public final Map<String, String> h() {
        return this.v;
    }

    @Override // com.loc.bo
    public final String j() {
        return this.o;
    }

    @Override // com.loc.bo
    public final String k() {
        return "loc";
    }

    @Override // n4a.j0
    public final byte[] p() {
        return this.r;
    }

    @Override // n4a.j0
    public final byte[] q() {
        return this.s;
    }

    @Override // n4a.j0
    public final boolean s() {
        return this.t;
    }

    @Override // n4a.j0
    public final String t() {
        return this.u;
    }

    @Override // n4a.j0
    public final boolean u() {
        return this.w;
    }

    public final void v(byte[] r3) {
        ByteArrayOutputStream r0 = null;
        ByteArrayOutputStream r1 = new ByteArrayOutputStream();     // Catch: Throwable -> L14
        if (r3 != null) goto L29;
    L6:
        this.s = r1.toByteArray();     // Catch: Throwable -> L12
        r1.close();     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        e.printStackTrace();
        return;
    L12:
        th = th;
        r0 = r1;
    L31:
        th.printStackTrace();     // Catch: Throwable -> L22
        if (r0 == null) goto L41;
        r0.close();     // Catch: IOException -> L19
        return;
    L19:
        e = move-exception;
        e.printStackTrace();
        return;
    L41:
        return;
    L22:
        th = move-exception;
        if (r0 != null) goto L39;
    L28:
        throw th;
    L39:
        r0.close();     // Catch: IOException -> L26
    L26:
        e = move-exception;
        e.printStackTrace();
        goto L28
    L29:
        r1.write(f5.i(r3.length));     // Catch: Throwable -> L12
        r1.write(r3);     // Catch: Throwable -> L12
    L14:
        th = th;
        goto L31
    }
}
