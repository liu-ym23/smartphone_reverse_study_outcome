package r80;

import android.content.res.Configuration;
import android.os.Build;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.foundation.IMiddleWareHostContext;
import com.bytedance.android.livesdk.config.g31;
import j40.i0;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l extends c {
    public final String c;

    @Override // r80.c, com.bytedance.android.live.core.utils.screen.b
    public final boolean isFoldScreen() {
        IMiddleWareHostContext r0 = jc1.k.f(IMiddleWareHostContext.class);
        if (r0 == null) goto L7;
        return r0.isFoldDevice();
    L7:
        return super.isFoldScreen();
    }

    public l() {
        this.c = "UnifiedProcessBrand";
    }

    @Override // r80.c, com.bytedance.android.live.core.utils.screen.b
    public final int a(Configuration r5) {
        if (r5 != null) goto L6;
        return -1;
    L6:
        if (isFoldScreen() == true) goto L8;
        return -1;
    L8:
        ALogger.d(this.c, k.a);
        float r0 = (r5.screenHeightDp * 1.0f) / r5.screenWidthDp;
        ALogger.i(this.c, "HegightDp:" + r5.screenHeightDp + ",WidthDp:" + r5.screenWidthDp + ",ratio:" + r0);
        i0 r6 = i0.a;
        Map r1 = ((g31) r6.getValue()).a();
        if (r1 == null) goto L17;
        String r3 = Build.MODEL;
        if (r1.containsKey(r3) != true) goto L17;
        Map r7 = ((g31) r6.getValue()).a();
        if (r7 == null) goto L17;
        Float r8 = (Float) r7.get(r3);
        if (r8 == null) goto L17;
        float r9 = r8.floatValue();
    L19:
        if (r0 >= r9) goto L21;
        return 1;
    L21:
        if (r0 > 1.5f) goto L25;
        return 0;
    L25:
        return 1;
    L17:
        r9 = 0.75f;
        goto L19
    }
}
