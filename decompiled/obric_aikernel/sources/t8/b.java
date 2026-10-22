package t8;

import android.util.Log;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static t8.a f12971a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f12972b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final b f12973c = null;

    public static final class a implements t8.a {
        a() {
        }

        @Override // t8.a
        public void d(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            Log.d("OEA_SDK", r10 + "->" + r11);
        }

        @Override // t8.a
        public void e(String r10, String r11, Throwable r12) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            Log.e("OEA_SDK", r10 + "->" + r11, r12);
        }

        @Override // t8.a
        public void i(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            Log.i("OEA_SDK", r10 + "->" + r11);
        }

        @Override // t8.a
        public void v(String r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "tag");
            Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
            Log.v("OEA_SDK", r10 + "->" + r11);
        }
    }

    static {
        f12973c = new b();
        f12972b = new a();
    }

    private b() {
    }

    public static /* synthetic */ void c(b r10, String r11, String r12, Throwable r13, int r14, Object r15) {
        if ((r14 & 4) == 0) goto L5;
        r13 = null;
    L5:
        r10.b(r11, r12, r13);
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        t8.a r12 = f12971a;
        if (r12 == null) goto L6;
        r12.d(r10, r11);
        return;
    }

    public final void b(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        t8.a r13 = f12971a;
        if (r13 == null) goto L6;
        if (r13 == null) goto L8;
        r13.e(r10, r11, r12);
        return;
    L8:
        return;
    L6:
        f12972b.e(r10, r11, r12);
    }

    public final void d() {
        f12971a = f12972b;
    }

    public final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        t8.a r12 = f12971a;
        if (r12 == null) goto L6;
        r12.i(r10, r11);
        return;
    }

    public final void f(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        t8.a r12 = f12971a;
        if (r12 == null) goto L6;
        if (r12 == null) goto L8;
        r12.i(r10, r11);
        return;
    L8:
        return;
    L6:
        f12972b.i(r10, r11);
    }

    public final void g(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        t8.a r12 = f12971a;
        if (r12 == null) goto L6;
        r12.v(r10, r11);
        return;
    }
}
