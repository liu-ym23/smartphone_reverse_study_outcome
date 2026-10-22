package exb;

import com.ss.android.lark.officesdk.utils.di.j;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public String a;

    public a() {
        this.a = "";
    }

    public static void a(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        j.b("PlatformViewLog-" + r3, r4);
    }

    public static void c(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        j.e("PlatformViewLog-" + r3, r4);
    }

    public static void f(String r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        int r2 = c.a;
        Intrinsics.checkNotNullParameter(r3, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        j.f("PlatformViewLog-".concat(r3), r4);
    }

    public final String e(String r3, String r4) {
        if (r4 != null) goto L4;
    L7:
        boolean r0 = true;
    L8:
        if (r0 == false) goto L11;
        return this.a + r3;
    L11:
        return this.a + r4 + '-' + r3;
    L4:
        if (r4.length() == 0) goto L7;
        r0 = false;
        goto L8
    }

    public static void b(String r2, String r3, Throwable r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        int r1 = c.a;
        Intrinsics.checkNotNullParameter(r2, "tag");
        j.c("PlatformViewLog-" + r2, r3, r4);
    }

    public final void d(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r4, "msg");
        c(e(r2, r3), r4);
    }
}
