package okhttp3;

import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @JvmField
    public static final b f11682a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ a f11683a = null;

        /* JADX INFO: renamed from: okhttp3.b$a$a, reason: collision with other inner class name */
        private static final class C0258a implements b {
            public C0258a() {
            }

            @Override // okhttp3.b
            public x a(b0 r10, z r11) {
                Intrinsics.checkNotNullParameter(r11, "response");
                return null;
            }
        }

        static {
            f11683a = new a();
        }

        private a() {
        }
    }

    static {
        a r10 = a.f11683a;
        f11682a = new a.C0258a();
        new ic.a(null, 1, null);
    }

    x a(b0 r10, z r11);
}
