package oo0;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.openplatform.impl.base.bootconfig.BootConfigContextService;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c<T> implements Consumer {
    public final /* synthetic */ BootConfigContextService a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Function1 c;
    public final /* synthetic */ Function0 d;

    public c(BootConfigContextService r1, String r2, Function1 r3, Function0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void accept(Object r3) {
        qo0.a.b("BootConfigContextService", "requestBootConfig error", (Throwable) r3);
        BootConfigContextService r4 = this.a;
        String r0 = this.b;
        int r1 = BootConfigContextService.b;
        r4.getClass();
        HashMap r5 = (HashMap) com.bytedance.android.livesdk.sharedpref.b.z2.getValue();
        if (r5.containsKey(r0) == false) goto L5;
        com.bytedance.android.live.openplatform.impl.base.api.response.a r6 = (com.bytedance.android.live.openplatform.impl.base.api.response.a) JsonUtil.parse((String) r5.get(r0), new a().getType());
    L6:
        if (r6 == null) goto L8;
        this.a.a.put(this.b, r6);
        this.c.invoke(r6);
        return;
    L8:
        Function0 r7 = this.d;
        if (r7 == null) goto L13;
        Unit r8 = (Unit) r7.invoke();
        return;
    L13:
        return;
    L5:
        r6 = null;
        goto L6
    }
}
