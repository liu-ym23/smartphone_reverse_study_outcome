package b9;

import a9.d;
import androidx.core.app.NotificationCompat;
import e9.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static d f541b;

    /* JADX INFO: renamed from: b9.a$a, reason: collision with other inner class name */
    public static final class C0026a implements d {
        C0026a() {
        }

        @Override // a9.d
        public void a(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            b.a(r10, r11, r12);
        }

        @Override // a9.d
        public void b(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            b.e(r10, r11, r12);
        }

        @Override // a9.d
        public void e(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            b.c(r10, r11, r12);
        }

        @Override // a9.d
        public void w(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            b.j(r10, r11, r12);
        }
    }

    static {
        f540a = new a();
        f541b = new C0026a();
    }

    private a() {
    }

    @JvmStatic
    public static final void c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f540a.a(r10, r11, null);
    }

    @JvmStatic
    public static final void d(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f540a.e(r10, r11, null);
    }

    @JvmStatic
    public static final void f(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f540a.b(r10, r11, null);
    }

    @JvmStatic
    public static final void h(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f540a.w(r10, r11, null);
    }

    @Override // a9.d
    public void a(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f541b.a(r10, r11, r12);
    }

    @Override // a9.d
    public void b(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f541b.b(r10, r11, r12);
    }

    @Override // a9.d
    public void e(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f541b.e(r10, r11, r12);
    }

    public final void g(d r10) {
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        f541b = r10;
    }

    @Override // a9.d
    public void w(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        f541b.w(r10, r11, r12);
    }
}
