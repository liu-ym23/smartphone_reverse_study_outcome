package g98;

import com.larus.audio.call.o;
import com.larus.avlink.env.DoraEnvObserveState;
import com.larus.dora.api.annotation.EnvObserveChangeReason;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class e implements u39.b {
    public e() {
    }

    public final void a(boolean r7, EnvObserveChangeReason r8, int r9) {
        Intrinsics.checkNotNullParameter(r8, "reason");
        FLogger.a.i("DoraEnvObserveManager", "initEnvObserve onEnvObserveChange canEntry = " + r7 + ", reason = " + r8 + ", reasonCode = " + r9);
        o r0 = d.a;
        if (r7 == false) goto L5;
        DoraEnvObserveState r10 = DoraEnvObserveState.START;
    L6:
        DoraEnvObserveState r1 = r10;
        String r2 = r8.toString();
        if (r8 != EnvObserveChangeReason.DEVICE_CHANGE) goto L9;
        int r4 = 0;
    L10:
        d.a(new f(r1, r2, r8, r4, r9));
        return;
    L9:
        r4 = 1;
        goto L10
    L5:
        r10 = DoraEnvObserveState.END;
        goto L6
    }
}
