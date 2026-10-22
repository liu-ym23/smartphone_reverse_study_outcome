package o89;

import android.app.Activity;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Activity r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        AtomicBoolean r0 = q.a;
        if (q.f(r2) == false) goto L8;
        return;
    L8:
        if (b.c() == false) goto L11;
        r2.overridePendingTransition(0, 2130772636);
        return;
    }
}
