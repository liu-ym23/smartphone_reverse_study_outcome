package androidx.lifecycle;

import java.io.Closeable;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HashMap f2163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LinkedHashSet f2164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile boolean f2165c;

    public h0() {
        this.f2163a = new HashMap();
        this.f2164b = new LinkedHashSet();
        this.f2165c = false;
    }

    public static void a(Object r8) {
        if ((r8 instanceof Closeable) == true) goto L10;
        return;
    L10:
        ((Closeable) r8).close();     // Catch: IOException -> L6
        return;
    L6:
        e = move-exception;
        throw new RuntimeException(e);
    }

    public void b() {
    }
}
