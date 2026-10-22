package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Logger f12268a = null;

    static {
        f12268a = Logger.getLogger("okio.Okio");
    }

    public static final /* synthetic */ Logger a() {
        return f12268a;
    }

    public static final boolean b(AssertionError r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        if (r10.getCause() == null) goto L11;
        String r11 = r10.getMessage();
        if (r11 == null) goto L7;
        boolean r12 = StringsKt.contains$default(r11, "getsockname failed", false, 2, null);
    L8:
        if (r12 == false) goto L12;
        return true;
    L12:
        return false;
    L7:
        r12 = false;
        goto L8
    L11:
        return false;
    }

    public static final d0 c(OutputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new x(r10, new g0());
    }

    public static final d0 d(Socket r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        e0 r11 = new e0(r10);
        OutputStream r12 = r10.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(r12, "getOutputStream(...)");
        return r11.z(new x(r12, r11));
    }

    public static final f0 e(File r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new p(new FileInputStream(r10), g0.f12214d);
    }

    public static final f0 f(InputStream r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        return new p(r10, new g0());
    }

    public static final f0 g(Socket r10) {
        Intrinsics.checkNotNullParameter(r10, "<this>");
        e0 r11 = new e0(r10);
        InputStream r12 = r10.getInputStream();
        Intrinsics.checkNotNullExpressionValue(r12, "getInputStream(...)");
        return r11.A(new p(r12, r11));
    }
}
