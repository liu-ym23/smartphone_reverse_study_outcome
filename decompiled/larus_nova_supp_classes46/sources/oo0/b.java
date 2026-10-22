package oo0;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import com.bytedance.android.livesdk.sharedpref.f;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b<T> implements Consumer {
    public final /* synthetic */ BootConfigContextService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;

    public b(BootConfigContextService r1, String r2, Function1 r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r5) {
        qo0.a.c("BootConfigContextService", "requestBootConfig success, do not hit cache");
        com.bytedance.android.live.openplatform.impl.base.api.response.a r6 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) ((e) r5).data;
        this.a.a.put(this.b, r6);
        BootConfigContextService r0 = this.a;
        String r1 = this.b;
        r0.getClass();
        com.bytedance.android.livesdk.sharedpref.e r2 = com.bytedance.android.livesdk.sharedpref.b.z2;
        HashMap r3 = (HashMap) r2.getValue();
        r3.put(r1, JsonUtil.toJSONString(r6));
        f.d(r2, r3);
        this.c.invoke(r6);
    }
}
