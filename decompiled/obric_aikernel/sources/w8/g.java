package w8;

import androidx.core.app.NotificationCompat;
import java.util.Iterator;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes2.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static a f13453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile a f13454b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final g f13455c = null;

    public interface a {
        void a(String r10, int r11, String r12, Throwable r13);
    }

    static {
        f13455c = new g();
    }

    private g() {
    }

    @JvmStatic
    public static final void a(String r10, String r11, Throwable r12) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        e(f13455c, r10, 16, r11, r12, false, 16, null);
    }

    @JvmStatic
    public static final void c(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "tag");
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_MESSAGE);
        e(f13455c, r10, 4, r11, null, false, 24, null);
    }

    private final void d(String r10, int r11, String r12, Throwable r13, boolean r14) {
        if (r14 == true) goto L6;
        a r15 = b();
        if (r15 == null) goto L12;
        r15.a(r10, r11, r12, r13);
        return;
    L12:
        return;
    L6:
        Iterator r16 = StringsKt.split$default(r12, new String[]{"\n"}, false, 0, 6, null).iterator();
    L8:
        if (r16.hasNext() == false) goto L19;
        String r17 = (String) r16.next();
        a r18 = f13455c.b();
        if (r18 == null) goto L8;
        r18.a(r10, r11, r17, null);
        goto L8
    }

    static /* synthetic */ void e(g r10, String r11, int r12, String r13, Throwable r14, boolean r15, int r16, Object r17) {
        if ((r16 & 8) == 0) goto L5;
        r14 = null;
    L5:
        Throwable r18 = r14;
        if ((r16 & 16) == 0) goto L8;
        r15 = false;
    L8:
        r10.d(r11, r12, r13, r18, r15);
    }

    @JvmStatic
    public static final void f(a r10) {
        Intrinsics.checkNotNullParameter(r10, "impl");
        f13453a = r10;
    }

    public final a b() {
        a r10 = f13453a;
        if (r10 == null) goto L5;
        return r10;
    L5:
        if (f13454b != null) goto L8;
        f13454b = new w8.a("ObricDownloaderLog", false);
    L8:
        return f13454b;
    }
}
