package eq;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.util.Objects;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f16855c = null;
    public static volatile b d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f16856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f16857b;

    static {
        f16855c = new Object();
    }

    public b() {
        this.f16856a = true;
        HandlerThread r5 = new HandlerThread("MetricsHandler");
        r5.start();
        Looper r10 = r5.getLooper();
        Objects.requireNonNull(r10);
        this.f16857b = new a(r10, this.f16856a);
    }

    public final void a(String r5, JSONObject r10) {
        Intrinsics.checkNotNullParameter(r5, "eventName");
        Intrinsics.checkNotNullParameter(r10, "jsonObject");
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L5
        iq.a r12 = new iq.a(r5, r10);     // Catch: Throwable -> L5
        Message.obtain(this.f16857b, 2, r12).sendToTarget();     // Catch: Throwable -> L5
        Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        Result.m124constructorimpl(ResultKt.createFailure(th));
    }
}
