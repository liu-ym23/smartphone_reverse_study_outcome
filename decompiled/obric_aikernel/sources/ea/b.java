package ea;

import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f8759a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final a f8760b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static int f8761c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final b f8762d = null;

    public interface a {
        void a(String r10, int r11, String r12, Throwable r13);
    }

    static {
        f8762d = new b();
        f8760b = new ea.a("OUI_SDK", false, 2, null);
        f8761c = 31;
    }

    private b() {
    }

    @JvmStatic
    public static final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 2, r11, null, false, 24, null);
    }

    @JvmStatic
    public static final void b(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 16, r11, null, false, 24, null);
    }

    @JvmStatic
    public static final void c(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 16, r11, r12, false, 16, null);
    }

    @JvmStatic
    public static final void e(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 4, r11, null, false, 24, null);
    }

    private final void g(String r10, int r11, String r12, Throwable r13, boolean r14) {
        if (f(r11) == false) goto L5;
        return;
    L5:
        if (r14 == true) goto L7;
        d().a(r10, r11, r12, r13);
        return;
    L7:
        Iterator r15 = StringsKt.split$default(r12, new String[]{"\n"}, false, 0, 6, null).iterator();
    L9:
        if (r15.hasNext() == false) goto L13;
        String r16 = (String) r15.next();
        f8762d.d().a(r10, r11, r16, null);
        goto L9
    }

    static /* synthetic */ void h(b r10, String r11, int r12, String r13, Throwable r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Throwable r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = false;
    L8:
        r10.g(r11, r12, r13, r18, r15);
    }

    @JvmStatic
    public static final void i(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 1, r11, null, false, 24, null);
    }

    @JvmStatic
    public static final void j(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 8, r11, null, false, 24, null);
    }

    @JvmStatic
    public static final void k(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        h(f8762d, r10, 8, r11, r12, false, 16, null);
    }

    public final a d() {
        a r10 = f8759a;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return f8760b;
    }

    public final boolean f(int r10) {
        if ((f8761c & r10) != 0) goto L5;
        return true;
    L5:
        return false;
    }
}
