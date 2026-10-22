package ga2;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements a {
    public static final List<a> a = null;
    public static final c b = null;

    public c() {
    }

    static {
        b = new c();
        ArrayList r0 = new ArrayList();
        a = r0;
        r0.add(b.a);
    }

    @Override // ga2.a
    public final void a(f<?> r4, k r5) {
        Iterator r0 = ((ArrayList) a).iterator();
    L4:
        if (r0.hasNext() == false) goto L10;
        ((a) r0.next()).a(r4, r5);     // Catch: Exception -> L8
    L8:
        e = move-exception;
        ALogger.e("PublicScreenTextMessageMonitor", e);
        goto L4
    }
}
