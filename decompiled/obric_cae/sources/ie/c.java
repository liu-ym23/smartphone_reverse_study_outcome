package ie;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f8327a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final c f8328b = null;

    public static final class a extends c implements Serializable {
        @Override // ie.c
        public final int a() {
            return c.f8328b.a();
        }

        @Override // ie.c
        public final int b() {
            return c.f8328b.b();
        }
    }

    static {
        f8327a = new a();
        f8328b = de.b.f7074a.b();
    }

    public c() {
    }

    public abstract int a();

    public abstract int b();
}
