package k32;

import com.bytedance.android.live.base.model.message.h3;
import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d extends a {
    public final h3 t;
    public boolean u;

    public final boolean a() {
        h3 r0 = this.t;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.I0() == null) goto L7;
        return true;
    }

    public d(h3 r6, String r7, String r8, String r9) {
        super(r7, r8, r9);
        this.u = false;
        this.t = r6;
        long r10 = 0;
        if (r6 != null) goto L6;
        ALogger.i("NotifyEffectMessage", "notifyEffectMessage is null");
    L11:
        long r2 = 40000;
    L13:
        this.p = r2;
        if (r6 != null) goto L17;
        ALogger.i("NotifyEffectMessage", "notifyEffectMessage is null");
    L20:
        this.o = r10;
        return;
    L17:
        if (r6.M() != null) goto L19;
        ALogger.i("NotifyEffectMessage", "sceneConfig is null");
        goto L20
    L19:
        r10 = r6.M().f();
        goto L20
    L6:
        if (r6.M() != null) goto L9;
        ALogger.i("NotifyEffectMessage", "sceneConfig is null");
        goto L11
    L9:
        if (r6.o1() != 0) goto L12;
        ALogger.i("NotifyEffectMessage", "Server did not dispatch remote priority");
        goto L11
    L12:
        r2 = r6.o1();
        goto L13
    }
}
