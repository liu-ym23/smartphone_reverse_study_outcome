package l0c;

import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.Scene;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import javax.inject.Singleton;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Singleton
public final class a implements d {
    public final ConcurrentHashMap<String, Long> a;

    @Inject
    public a() {
        this.a = new ConcurrentHashMap();
    }

    @Override // l0c.d
    public final void a(j0c.b r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "key");
        Intrinsics.checkNotNullParameter(r4, "executeStrategy");
        this.a.put(r3.a, Long.valueOf(System.currentTimeMillis()));
    }

    @Override // l0c.d
    public final void b(j0c.b r10, String r11, Scene r12) {
        Intrinsics.checkNotNullParameter(r10, "key");
        Intrinsics.checkNotNullParameter(r11, "executeStrategy");
        Long r0 = this.a.get(r10.a);
        String r1 = null;
        if (r0 != null) goto L8;
        StringBuilder r2 = new StringBuilder("[");
        r2.append(r10.a);
        r2.append("] task miss start time , executeStrategy = ");
        r2.append(r11);
        r2.append(", scene=");
        if (r12 == null) goto L7;
        r1 = r12.name();
    L7:
        r2.append(r1);
        Log.w("ComponentTask", r2.toString());
        return;
    L8:
        long r5 = System.currentTimeMillis() - r0.longValue();
        StringBuilder r3 = new StringBuilder("[");
        r3.append(r10.a);
        r3.append("] task cost = ");
        r3.append(r5);
        r3.append(" ms , executeStrategy = ");
        r3.append(r11);
        r3.append(", scene=");
        if (r12 == null) goto L11;
        r1 = r12.name();
    L11:
        r3.append(r1);
        Log.i("ComponentTask", r3.toString());
    }
}
