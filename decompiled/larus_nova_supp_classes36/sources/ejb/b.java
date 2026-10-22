package ejb;

import android.content.Context;
import com.larksuite.framework.thread.CoreThreadPool;
import com.ss.android.lark.batterymonitor.api.BatteryHandlerPlugin;
import com.ss.android.lark.batterymonitor.api.ConditionState;
import com.ss.android.lark.utils.o0;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@BatteryHandlerPlugin
public final class b implements xwa.a {
    public long a;

    public final void a() {
    }

    public final void b() {
    }

    public b() {
        this.a = 0;
    }

    public final boolean c(Context r1) {
        if (o0.a(r1) == false) goto L6;
        return true;
    L6:
        return false;
    }

    public final void d(ConditionState r7) {
        boolean r1 = true;
        if (r7.a != 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        return;
    L8:
        if (r7.c == 0) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L19;
        long r2 = System.currentTimeMillis();
        if ((r2 - this.a) < 1200000) goto L20;
        this.a = r2;
        CoreThreadPool.getDefault().getScheduleThreadPool().schedule(new a(), 1, TimeUnit.SECONDS);
        return;
    L20:
        return;
    L19:
        return;
    L5:
        r0 = false;
        goto L6
    }
}
