package com.bytedance.android.live.broadcastgame.opengame.runtime;

import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.live.network.response.BaseResponse;
import com.bytedance.android.live.network.response.Response;
import io.reactivex.functions.Function;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class h<T, R> implements Function {
    public final /* synthetic */ BootInfoService a;
    public final /* synthetic */ String b;

    public h(BootInfoService r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object apply(Object r12) {
        Response r13 = (Response) r12;
        Intrinsics.checkNotNullParameter(r13, "it");
        int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.f("BootInfoService", new Object[]{"on bootconfig response", ", appId: ", this.b, ", logId: ", ((BaseResponse) r13).logId});
        BootInfoService r1 = this.a;
        String r2 = this.b;
        com.bytedance.android.live.broadcastgame.opengame.network.a r14 = (com.bytedance.android.live.broadcastgame.opengame.network.a) ((BaseResponse) r13).data;
        int r3 = BootInfoService.c;
        r1.getClass();
        if (r14 == null) goto L6;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r4 = r14.g();
        if (r4 == null) goto L6;
    L7:
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.C0064a> r5 = r4;
        if (r14 == null) goto L11;
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r6 = r14.d();
        if (r6 == null) goto L11;
    L12:
        List<com.bytedance.android.live.broadcastgame.opengame.network.a.c> r7 = r6;
        if (r14 == null) goto L15;
        boolean r8 = r14.c();
    L16:
        if (r14 == null) goto L18;
        boolean r9 = r14.a();
    L19:
        if (r14 == null) goto L21;
        List<Integer> r11 = r14.f();
    L22:
        List<Integer> r15 = r11;
        if (r14 == null) goto L26;
        String r16 = r14.e();
        if (r16 == null) goto L26;
    L27:
        j r17 = new j(r5, r7, r8, r9, r15, r16);
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.b.y2;
        HashMap r19 = (HashMap) r18.getValue();
        r19.put(r2, JsonUtil.toJSONString(r17));
        com.bytedance.android.livesdk.sharedpref.f.d(r18, r19);
        if (r14 == null) goto L33;
        com.bytedance.android.live.broadcastgame.opengame.network.a.b r110 = r14.b();
        if (r110 == null) goto L33;
        String r111 = r110.a();
        if (r111 == null) goto L33;
    L35:
        return new g(r111, r17);
    L33:
        r111 = "";
    L26:
        r16 = "unknown";
        goto L27
    L21:
        r11 = null;
        goto L22
    L18:
        r9 = false;
        goto L19
    L15:
        r8 = false;
    L11:
        r6 = new ArrayList();
    L6:
        r4 = new ArrayList();
        goto L7
    }
}
