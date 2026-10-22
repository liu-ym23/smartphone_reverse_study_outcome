package xf;

import android.util.Log;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.g;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public class a {
    public final HashMap<String, String> a;
    public final String b;

    /* JADX INFO: renamed from: xf.a$a, reason: collision with other inner class name */
    public static final class C0212a {
    }

    public static final class b<V> implements Callable {
        public final /* synthetic */ a a;

        public b(xf.b r1) {
            this.a = r1;
        }

        @Override // java.util.concurrent.Callable
        public final Object call() {
            g r0 = g.a;     // Catch: Throwable -> L9
            String r1 = this.a.b;     // Catch: Throwable -> L9
            Map r10 = this.a.a;     // Catch: Throwable -> L9
            if ((r10 instanceof Map) == true) goto L5;
            r10 = null;
        L5:
            if (r10 != null) goto L7;
            r10 = MapsKt.emptyMap();     // Catch: Throwable -> L9
        L7:
            r0.logV3(r1, new JSONObject(r10));     // Catch: Throwable -> L9
            return Unit.INSTANCE;
        L9:
            th = move-exception;
            ECExceptionMonitor.e(th);
            return Integer.valueOf(Log.w("MetricsEvent", "post event failed: " + this.a.b, th));
        }
    }

    static {
    }

    public final void b() {
        a(com.bytedance.android.ec.core.event.a.KEY_DATA_TYPE, com.bytedance.android.ec.core.event.a.VALUE_DATA_TYPE);
        a(com.bytedance.android.ec.core.event.a.KEY_EVENT_ORIGIN_FEATURE, com.bytedance.android.ec.core.event.a.VALUE_TEMAI);
        Single.fromCallable(new b((xf.b) this)).subscribeOn(Schedulers.io()).subscribe();
    }

    public a(String r10) {
        Intrinsics.checkNotNullParameter(r10, "event");
        this.b = r10;
        this.a = new HashMap();
    }

    public final void a(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "key");
        if (r11 == null) goto L6;
        String r12 = this.a.put(r10, r11);
        return;
    }
}
