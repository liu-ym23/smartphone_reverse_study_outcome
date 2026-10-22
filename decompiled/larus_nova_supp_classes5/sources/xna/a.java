package xna;

import com.ss.android.socialbase.downloader.file.DownloadFileUtils;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class a {
    public static Function2<? super String, ? super String, Unit> a;
    public static Function2<? super String, ? super String, Unit> b;
    public static Function2<? super String, ? super String, Unit> c;
    public static Function2<? super String, ? super String, Unit> d;
    public static Function2<? super String, ? super String, Unit> e;

    static {
    }

    @JvmStatic
    public static final void a(String r2) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Function2<? super String, ? super String, Unit> r0 = d;
        if (r0 == null) goto L6;
        r0.invoke("SVA-ObricInteractionService2", r2);
        return;
    }

    @JvmStatic
    public static final void d(String r2) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Function2<? super String, ? super String, Unit> r0 = c;
        if (r0 == null) goto L6;
        r0.invoke("SVA-ObricInteractionService2", r2);
        return;
    }

    @JvmStatic
    public static final void e(String r2) {
        Intrinsics.checkNotNullParameter("ObricInteractionService2", "tag");
        Intrinsics.checkNotNullParameter(r2, "msg");
        Function2<? super String, ? super String, Unit> r0 = b;
        if (r0 == null) goto L6;
        r0.invoke("SVA-ObricInteractionService2", r2);
        return;
    }

    @JvmStatic
    public static final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "tag");
        Intrinsics.checkNotNullParameter(r3, "msg");
        Function2<? super String, ? super String, Unit> r0 = e;
        if (r0 == null) goto L6;
        r0.invoke("SVA-".concat(r2), r3);
        return;
    }

    @JvmStatic
    public static final void c(Function2<? super String, ? super String, Unit> r1, Function2<? super String, ? super String, Unit> r2, Function2<? super String, ? super String, Unit> r3, Function2<? super String, ? super String, Unit> r4, Function2<? super String, ? super String, Unit> r5) {
        Intrinsics.checkNotNullParameter(r1, "v");
        Intrinsics.checkNotNullParameter(r2, "d");
        Intrinsics.checkNotNullParameter(r3, "i");
        Intrinsics.checkNotNullParameter(r4, DownloadFileUtils.MODE_WRITE);
        Intrinsics.checkNotNullParameter(r5, "e");
        c = r1;
        a = r2;
        e = r3;
        b = r4;
        d = r5;
    }
}
