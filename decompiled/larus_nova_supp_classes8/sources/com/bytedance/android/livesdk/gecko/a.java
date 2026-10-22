package com.bytedance.android.livesdk.gecko;

import com.bytedance.geckox.GeckoClient;
import com.bytedance.geckox.OptionCheckUpdateParams;
import com.bytedance.geckox.listener.GeckoUpdateListener;
import com.bytedance.geckox.model.CheckRequestBodyModel;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements xo2.c {

    /* JADX INFO: renamed from: com.bytedance.android.livesdk.gecko.a$a, reason: collision with other inner class name */
    public static final class C0367a implements com.bytedance.android.livesdk.service.k.b<xo2.c> {
        public C0367a() {
        }

        public final com.bytedance.android.livesdk.service.k.b.a<xo2.c> setup(com.bytedance.android.livesdk.service.k.b.a<xo2.c> r2) {
            r2.a = new a();
            r2.b = true;
            return r2;
        }
    }

    public a() {
    }

    public final void a(GeckoClient r2, String r3, Map<String, Map<String, Object>> r4, Map<String, List<CheckRequestBodyModel.TargetChannel>> r5, GeckoUpdateListener r6, xo2.c.a r7) {
        if (r2 == null) goto L5;
        r2.checkUpdateMulti(r3, r5, new OptionCheckUpdateParams().setCustomParam(r4).setEnableThrottle(false).setListener(new g(r6, r7)));
        return;
    }
}
