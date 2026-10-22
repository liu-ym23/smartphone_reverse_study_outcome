package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.utils.MdnsServiceManager;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class b7<T> implements Consumer {
    public final /* synthetic */ z6 a;
    public final /* synthetic */ CallContext b;
    public final /* synthetic */ String c;

    public b7(z6 r1, CallContext r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void accept(Object r3) {
        Long r4 = (Long) r3;
        ALogger.i("DiscoverServicesMethod", "timeout start stopDiscovery");
        MdnsServiceManager.c.c(this.b.getContext(), this.c);
        z6 r5 = this.a;
        LiveStartDiscoveryServiceResultModel r0 = new LiveStartDiscoveryServiceResultModel();
        r0.b(LiveStartDiscoveryServiceResultModel.Code.Timeout);
        r0.a(0);
        Unit r1 = Unit.INSTANCE;
        r5.finishWithResult(r0);
    }
}
