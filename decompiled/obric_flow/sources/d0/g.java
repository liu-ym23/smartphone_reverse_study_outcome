package d0;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;

/* JADX INFO: loaded from: classes.dex */
public final class g implements z.c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f16545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final URL f16546c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f16547h;

    public g(URL r5) {
        k r10 = h.f16550a;
        io.reactivex.internal.observers.h.h(r5, "Argument must not be null");
        this.f16546c = r5;
        this.d = null;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.f16545b = r10;
    }

    @Override // z.c
    public final void b(MessageDigest r5) {
        if (this.g != null) goto L5;
        this.g = c().getBytes(z.c.f23353a);
    L5:
        r5.update(this.g);
    }

    public final String c() {
        String r5 = this.d;
        if (r5 != null) goto L7;
        URL r10 = this.f16546c;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        return r10.toString();
    L7:
        return r5;
    }

    public final String d() {
        if (TextUtils.isEmpty(this.e) == false) goto L9;
        String r5 = this.d;
        if (TextUtils.isEmpty(r5) == false) goto L7;
        URL r10 = this.f16546c;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        r5 = r10.toString();
    L7:
        this.e = Uri.encode(r5, "@#&=*+-_.,:!?()/~'%;$");
    L9:
        return this.e;
    }

    @Override // z.c
    public final boolean equals(Object r5) {
        if ((r5 instanceof g) == false) goto L10;
        g r10 = (g) r5;
        if (c().equals(r10.c()) == true) goto L7;
        return false;
    L7:
        if (this.f16545b.equals(r10.f16545b) == false) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    @Override // z.c
    public final int hashCode() {
        if (this.f16547h != 0) goto L6;
        int r5 = c().hashCode();
        this.f16547h = r5;
        int r10 = this.f16545b.f16554b.hashCode();
        this.f16547h = r10 + (r5 * 31);
    L6:
        return this.f16547h;
    }

    public final String toString() {
        return c();
    }

    public g(String r5) {
        k r10 = h.f16550a;
        this.f16546c = null;
        if (TextUtils.isEmpty(r5) == true) goto L7;
        this.d = r5;
        io.reactivex.internal.observers.h.h(r10, "Argument must not be null");
        this.f16545b = r10;
        return;
    L7:
        throw new IllegalArgumentException("Must not be null or empty");
    }
}
