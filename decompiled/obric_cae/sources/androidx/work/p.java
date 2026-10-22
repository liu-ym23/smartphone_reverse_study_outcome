package androidx.work;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: classes.dex */
public interface p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final a.c f2939a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @SuppressLint({"SyntheticAccessor"})
    public static final a.b f2940b = null;

    public static abstract class a {

        /* JADX INFO: renamed from: androidx.work.p$a$a, reason: collision with other inner class name */
        public static final class C0026a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Throwable f2941a;

            public C0026a(Throwable r8) {
                this.f2941a = r8;
            }

            public final String toString() {
                return "FAILURE (" + this.f2941a.getMessage() + ")";
            }
        }

        public static final class b extends a {
            public final String toString() {
                return "IN_PROGRESS";
            }
        }

        public static final class c extends a {
            public c() {
            }

            public final String toString() {
                return "SUCCESS";
            }
        }

        public a() {
        }
    }

    static {
        f2939a = new a.c();
        f2940b = new a.b();
    }
}
