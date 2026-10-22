package com.bytedance.android.annie.business.latch;

import com.bytedance.ies.bullet.base.utils.logger.HybridLogger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c extends com.bytedance.sdk.xbridge.cn.protocol.d<Object> {
    public final /* synthetic */ com.bytedance.sdk.xbridge.cn.platform.lynx.a c;
    public final /* synthetic */ String d;
    public final /* synthetic */ kx.b.a.a e;

    public final void b(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "data");
        Map r11 = (Map) r10;     // Catch: Exception -> L21
        boolean r12 = true;
        if (Intrinsics.areEqual(r11.get("code"), 1) == true) goto L16;
        Object r13 = r11.get("__jsb2__data__");     // Catch: Exception -> L21
        if ((r13 instanceof JSONObject) == false) goto L8;
        JSONObject r14 = (JSONObject) r13;     // Catch: Exception -> L21
    L10:
        if (r14 == null) goto L12;
        boolean r1 = Intrinsics.areEqual(r14.get("code"), 1);     // Catch: Exception -> L21
    L13:
        if (r1 == true) goto L16;
        r12 = false;
        goto L16
    L12:
        r1 = false;
        goto L13
    L8:
        r14 = null;
    L16:
        HybridLogger r15 = HybridLogger.a;     // Catch: Exception -> L21
        HybridLogger.f("AnnieBusinessLatchService", "handle " + this.d + ".success:" + r12 + ", message:" + ((le7.a) this.c).l, null, 12);     // Catch: Exception -> L21
        if (r12 == false) goto L19;
        this.e.onSuccess(r11);     // Catch: Exception -> L21
        return;
    L19:
        this.e.onFail(((le7.a) this.c).l);     // Catch: Exception -> L21
        return;
    L21:
        e = move-exception;
        HybridLogger r16 = HybridLogger.a;
        HybridLogger.i("AnnieBusinessLatchService", "dispatchPlatformInvoke  " + this.d + " exception:. " + e, null, 12);
    }

    public c(com.bytedance.sdk.xbridge.cn.platform.lynx.a r1, String r10, kx.b.a.a r11) {
        this.c = r1;
        this.d = r10;
        this.e = r11;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.bytedance.sdk.xbridge.cn.protocol.entity.BaseBridgeCall<kotlin.Any>");
        super(r1);
    }
}
