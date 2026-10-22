package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.GcpLoadPerfAddExtraParamsResultModel;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.IGameCPFmpMonitorService;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "gcpLoadPerfAddExtraParams")
public final class n3 extends w20.y0<w20.e9, GcpLoadPerfAddExtraParamsResultModel> {
    public n3() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.e9 r8 = (w20.e9) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        IHostGameCP r9 = jc1.k.f(IHostGameCP.class);
        if (r9 == null) goto L5;
        IGameCPFmpMonitorService r11 = r9.getGameCPFmpMonitorService();
    L6:
        JsonObject r1 = r8.a();
        if (r1 == null) goto L22;
        Set r2 = r1.keySet();
        if (r2 == null) goto L22;
        Iterator r3 = r2.iterator();
    L12:
        if (r3.hasNext() == false) goto L22;
        String r4 = (String) r3.next();
        if (r11 == null) goto L12;
        String r5 = String.valueOf(r8.b());
        JsonObject r12 = r8.a();
        if (r12 == null) goto L20;
        JsonElement r13 = r12.get(r4);
        if (r13 == null) goto L20;
        String r14 = r13.toString();
    L21:
        r11.addTrackExtra(r5, r4, r14);
    L20:
        r14 = null;
    L22:
        GcpLoadPerfAddExtraParamsResultModel r15 = new GcpLoadPerfAddExtraParamsResultModel();
        r15.a(GcpLoadPerfAddExtraParamsResultModel.Code.Success);
        Unit r16 = Unit.INSTANCE;
        finishWithResult(r15);
        return;
    L5:
        r11 = null;
        goto L6
    }
}
