package ju;

import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: classes3.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f18481a = null;

    static {
        f18481a = new a();
    }

    public static b a() {
        org.koin.core.a r5 = su.a.f22013b;
        if (r5 == null) goto L7;
        return (b) r5.f20999a.d.b(null, Reflection.getOrCreateKotlinClass(b.class), null);
    L7:
        throw new IllegalStateException("KoinApplication has not been started");
    }

    @Override // ju.b
    public final void d(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a().d(r5, r10);
    }

    @Override // ju.b
    public final void e(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a().e(r5, r10);
    }

    @Override // ju.b
    public final void i(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a().i(r5, r10);
    }

    @Override // ju.b
    public final void v(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a().v(r5, r10);
    }

    @Override // ju.b
    public final void w(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a().w(r5, r10);
    }

    @Override // ju.b
    public final void e(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "t");
        a().e(r5, r10, r11);
    }

    @Override // ju.b
    public final void w(String r5, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        Intrinsics.checkNotNullParameter(r11, "t");
        a().w(r5, r10, r11);
    }
}
