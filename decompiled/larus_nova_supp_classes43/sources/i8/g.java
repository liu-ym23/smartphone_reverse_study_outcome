package i8;

import com.bytedance.android.monitorV2.util.l;
import com.bytedance.android.monitorV2.util.n;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class g {
    public static final sz2.e a = null;

    static {
        a = sz2.e.a;
    }

    public static String e() {
        a.getClass();
        String r0 = n.a();
        nz2.b.f("ContainerStandardApi", "generateIDForContainer [monitorId:" + r0 + ']');
        return r0;
    }

    public static void a(String r10, String r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "key");
        a.getClass();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "key");
        nz2.b.f("ContainerStandardApi", "addContainerContext [monitorId:" + r10 + "][field:" + r11 + "][value:" + r12 + ']');
        sz2.a r1 = sz2.e.b;
        Integer r13 = Integer.valueOf(r12);
        r1.getClass();
        Intrinsics.checkNotNullParameter(r10, "monitorId");
        Intrinsics.checkNotNullParameter(r11, "field");
        Intrinsics.checkNotNullParameter(r13, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        l.p(sz2.a.b(r10), r11, r13);
    }

    public static void b(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        a.getClass();
        sz2.e.a(r1, r10, r11);
    }

    public static void c(String r1, String r10, long r11) {
        Intrinsics.checkNotNullParameter(r1, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "field");
        a.getClass();
        sz2.e.e(r1, r10, r11);
    }

    public static void d(String r1, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, "monitorId");
        Intrinsics.checkNotNullParameter(r10, "field");
        Intrinsics.checkNotNullParameter(r11, com.bytedance.android.ec.core.event.a.KEY_LUBAN_VALUE);
        a.getClass();
        sz2.e.f(r1, r10, r11);
    }
}
