package okhttp3;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.internal.concurrent.TaskRunner;
import okhttp3.internal.connection.RealConnectionPool;

/* JADX INFO: loaded from: classes3.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RealConnectionPool f20716a;

    public o(int r10, long r11, TimeUnit r12) {
        Intrinsics.checkNotNullParameter(r12, "timeUnit");
        RealConnectionPool r5 = new RealConnectionPool(TaskRunner.INSTANCE, r10, r11, r12);
        Intrinsics.checkNotNullParameter(r5, "delegate");
        this.f20716a = r5;
    }
}
