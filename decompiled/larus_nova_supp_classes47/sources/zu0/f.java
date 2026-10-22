package zu0;

import com.bytedance.android.live.browser.jsbridge.base.LiveReenterRoomResultModel;
import com.bytedance.ies.web.jsbridge2.CallContext;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import w20.f3;
import w20.za;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends f3<za, LiveReenterRoomResultModel> {
    public f() {
    }

    public final void invoke(Object r10, CallContext r12) {
        za r13 = (za) r10;
        Intrinsics.checkNotNullParameter(r13, "params");
        Intrinsics.checkNotNullParameter(r12, "context");
        String r14 = ((l01.d) com.bytedance.android.live.revenue.core.util.f.a(l01.d.class)).b().getIdString();     // Catch: Exception -> L25
        String r0 = r13.e();     // Catch: Exception -> L25
        if (r0 != null) goto L6;
    L11:
        com.bytedance.android.live.profit.privilege.a r3 = yt0.c.i();     // Catch: Exception -> L25
        if (r3 == null) goto L23;
        String r15 = r13.b();     // Catch: Exception -> L25
        if (r15 == null) goto L18;
        Long r16 = StringsKt.toLongOrNull(r15);     // Catch: Exception -> L25
        if (r16 == null) goto L18;
        long r1 = r16.longValue();     // Catch: Exception -> L25
    L19:
        long r4 = r1;
        String r6 = r13.d();     // Catch: Exception -> L25
        String r17 = r13.c();     // Catch: Exception -> L25
        if (r17 != null) goto L22;
        com.bytedance.live.kmp.util.c r18 = com.bytedance.live.kmp.util.c.a;     // Catch: Exception -> L25
        r17 = com.bytedance.live.kmp.util.c.a(2131921849, new Object[0]);     // Catch: Exception -> L25
    L22:
        r3.vo(r4, r6, r17, r13.a());     // Catch: Exception -> L25
    L18:
        r1 = 0;
    L23:
        finishWithSuccess();     // Catch: Exception -> L25
        return;
    L6:
        if (by0.b.a(r0) == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.J2;     // Catch: Exception -> L25
        Map r5 = (Map) r2.getValue();     // Catch: Exception -> L25
        r5.put(r14, r0);     // Catch: Exception -> L25
        com.bytedance.android.livesdk.sharedpref.f.d(r2, r5);     // Catch: Exception -> L25
    L25:
        finishWithFailure();
    }
}
