package a1;

import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final AtomicInteger f44c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f45a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f46b;

    static {
        f44c = new AtomicInteger(0);
    }

    public c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "tag");
        this.f45a = r5;
        this.f46b = f44c.incrementAndGet();
    }

    public final void a(String r5) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        String r10 = "[" + this.f46b + "] " + r5;
        String r11 = this.f45a;
        Intrinsics.checkNotNullParameter(r11, "tag");
        Intrinsics.checkNotNullParameter(r10, "msg");
        a.f43a.i(r11, r10);
    }

    public final void b(String r5, Exception r10) {
        Intrinsics.checkNotNullParameter(r5, "msg");
        String r11 = "[" + this.f46b + "] " + r5;
        String r12 = this.f45a;
        Intrinsics.checkNotNullParameter(r12, "tag");
        Intrinsics.checkNotNullParameter(r11, "msg");
        a.f43a.e(r12, r11, r10);
    }
}
