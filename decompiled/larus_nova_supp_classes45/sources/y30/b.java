package y30;

import com.bytedance.android.live.core.utils.u;
import com.bytedance.android.livehostapi.foundation.IHostContext;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import java.util.HashMap;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import v80.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b {
    public final fu2.a a;

    public b(fu2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "bytedCert");
        this.a = r2;
    }

    public static HashMap a(b r2) {
        r2.getClass();
        HashMap r3 = new HashMap();
        r3.put("SCREEN_COLOR", Integer.valueOf(ColorProtector.parseColor("#FFFFFF")));
        r3.put("TEXT_COLOR", Integer.valueOf(ColorProtector.parseColor("#161823")));
        r3.put("PROGRESS_BG_COLOR", Integer.valueOf(ColorProtector.parseColor("#14FFFFFF")));
        r3.put("PROGRESS_COLOR", Integer.valueOf(ColorProtector.parseColor("#80FE2C55")));
        r3.put("IS_FACE_LIVE_BACK", Boolean.TRUE);
        r3.put("IS_WEB_DARK_MODE", Boolean.FALSE);
        r3.put("IS_NEED_INIT_LOADING", true);
        return r3;
    }

    public final void b(d r4) {
        Intrinsics.checkNotNullParameter(r4, "verifyParam");
        com.bytedance.android.live.core.verify.utils.a.g r0 = r4.n;
        if (k.f(IHostContext.class) != null) goto L6;
        r0.onVerify(false, new HashMap());
        return;
    L6:
        fu2.a r1 = this.a;
        u.a();
        r1.b();
        HashMap r2 = new HashMap();
        r2.put("scene", r4.b);
        r2.put("mode", r4.d);
        r2.put("ticket", r4.c);
        r2.put("cert_app_id", "1128");
        String r3 = r4.f;
        if (r3 != null) goto L9;
        r3 = "false";
    L9:
        r2.put("use_new_api", r3);
        String r5 = r4.e;
        if (r5 == null) goto L12;
        r2.put("flow", r5);
    L12:
        this.a.c();
        fu2.a r6 = this.a;
        r4.getContext();
        r6.e();
    }
}
