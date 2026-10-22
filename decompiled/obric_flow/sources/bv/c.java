package bv;

import ai.j0;
import av.g;
import dv.f;
import java.sql.SQLException;
import java.util.HashMap;
import org.sqlite.core.NativeDB;

/* JADX INFO: loaded from: classes3.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f1013a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f1014b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1015c;
    public String[] d;
    public String[] e;
    public boolean[][] f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f1016h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f1017i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f1018j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public HashMap f1019k;

    public c(f r5) {
        this.f1014b = false;
        this.d = null;
        this.e = null;
        this.f = null;
        this.f1016h = 0;
        this.f1019k = null;
        this.f1013a = r5;
    }

    public final int b(int r5) {
        String[] r10 = this.e;
        if (r10 == null) goto L13;
        if (r5 < 1) goto L11;
        if (r5 > r10.length) goto L11;
        return r5 - 1;
    L11:
        throw new SQLException(androidx.constraintlayout.motion.widget.a.s(j0.s(r5, "column ", " out of bounds [1,"), this.e.length, "]"));
    L13:
        throw new IllegalStateException("SQLite JDBC: inconsistent internal state");
    }

    public void close() {
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = 0;
        this.f1016h = 0;
        this.f1017i = -1;
        this.f1019k = null;
        if (this.f1014b == true) goto L5;
        return;
    L5:
        NativeDB r5 = this.f1013a.f16719a.f16711a;
        monitor-enter(r5);
        long r10 = this.f1013a.f16721c;     // Catch: Throwable -> L12
        if (r10 == 0) goto L14;
        r5.reset(r10);     // Catch: Throwable -> L12
        if (this.f1018j == false) goto L14;
        this.f1018j = false;     // Catch: Throwable -> L12
        this.f1013a.close();     // Catch: Throwable -> L12
    L14:
        monitor-exit(r5);     // Catch: Throwable -> L12
        this.f1014b = false;
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public final void d() {
        if (this.f1014b == false) goto L6;
        return;
    L6:
        throw new SQLException("ResultSet closed");
    }

    public final g e() {
        return this.f1013a.f16719a.f16713c;
    }

    public final NativeDB f() {
        return this.f1013a.f16719a.f16711a;
    }

    public final int g(int r5) {
        d();
        b(r5);
        this.f1017i = r5;
        return r5 - 1;
    }
}
