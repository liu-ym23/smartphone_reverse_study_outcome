package u52;

import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends d<h> {
    public final k h;

    public j(k r2) {
        Intrinsics.checkNotNullParameter(r2, "config");
        super("KwsEngine");
        this.h = r2;
    }

    @Override // u52.d
    public final void g(int r4, byte[] r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        super.g(r4, r5);
        if (r4 != 1100) goto L15;
        JSONObject r6 = new JSONObject(new String(r5, Charsets.UTF_8));     // Catch: Exception -> L9
        String r7 = JSONObjectProtectorUtils.getString(r6, "kw");     // Catch: Exception -> L9
        long r0 = r6.optLong("traceback", 0);     // Catch: Exception -> L9
        h r8 = (h) this.e;     // Catch: Exception -> L9
        if (r8 == null) goto L14;
        r8.d(r7, r0);     // Catch: Exception -> L9
        return;
    L14:
        return;
    L9:
        e = move-exception;
        SafetyGuard.a("AnchorAsr parse kws result error", e, null);
        return;
    }
}
