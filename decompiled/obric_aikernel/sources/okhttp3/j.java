package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final okhttp3.internal.connection.f f11982a;

    public j() {
        this(5, 5, TimeUnit.MINUTES);
    }

    public j(int r10, long r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "timeUnit");
        this(new okhttp3.internal.connection.f(jc.e.f9926i, r10, r11, r12));
    }

    public j(okhttp3.internal.connection.f r10) {
        Intrinsics.checkNotNullParameter(r10, "delegate");
        this.f11982a = r10;
    }

    public final okhttp3.internal.connection.f a() {
        return this.f11982a;
    }
}
