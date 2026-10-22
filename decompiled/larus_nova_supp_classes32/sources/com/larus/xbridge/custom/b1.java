package com.larus.xbridge.custom;

import android.app.Activity;
import com.bytedance.ies.xbridge.XBridgeMethod;
import com.bytedance.ies.xbridge.XBridgePlatformType;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.bridgeInterfaces.XCoreBridgeMethod;
import com.larus.common.apphost.AppHost;
import com.larus.uaigc.service.IUgcAIGCService;
import com.larus.utils.logger.FLogger;
import com.lynx.jsbridge.LynxResourceModule;
import com.obric.aivoice.core.data.NameKeys;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class b1 extends XCoreBridgeMethod {

    public static final class a {
    }

    static {
    }

    public final String getName() {
        return "flow.applyPocket";
    }

    public b1() {
    }

    public static Map e(JSONObject r4) {
        Map r0 = MapsKt.createMapBuilder();
        Iterator<String> r1 = r4.keys();
    L4:
        if (r1.hasNext() == false) goto L7;
        String r2 = r1.next();
        Intrinsics.checkNotNull(r2);
        r0.put(r2, f(r4.opt(r2)));
        goto L4
    L7:
        return MapsKt.build(r0);
    }

    public static Object f(Object r4) {
        if (Intrinsics.areEqual(r4, JSONObject.NULL) == false) goto L6;
        return null;
    L6:
        if ((r4 instanceof JSONObject) == false) goto L9;
        return e((JSONObject) r4);
    L9:
        if ((r4 instanceof JSONArray) == false) goto L18;
        JSONArray r5 = (JSONArray) r4;
        List r0 = CollectionsKt.createListBuilder();
        int r1 = r5.length();
        int r2 = 0;
    L11:
        if (r2 >= r1) goto L14;
        r0.add(f(r5.opt(r2)));
        r2 = r2 + 1;
        goto L11
    L14:
        return CollectionsKt.build(r0);
    L18:
        return r4;
    }

    public final void handle(XReadableMap r9, XBridgeMethod.Callback r10, XBridgePlatformType r11) {
        Intrinsics.checkNotNullParameter(r9, LynxResourceModule.PARAMS_KEY);
        Intrinsics.checkNotNullParameter(r10, "callback");
        Intrinsics.checkNotNullParameter(r11, "type");
        XReadableMap r12 = com.bytedance.ies.xbridge.s.e(r9, LynxResourceModule.DATA_KEY);
        if (r12 != null) goto L6;
        XCoreBridgeMethod.onFailure$default(this, r10, -3, "data is required", null, 8, null);
        return;
    L6:
        Activity r0 = AppHost.a.a().getCurrentActivity();
        FLogger r1 = FLogger.a;
        if (r0 == null) goto L10;
        String r2 = r0.getLocalClassName();
        if (r2 == null) goto L10;
    L11:
        r1.i("FlowApplyPocketMethod", "[handle] activity name = ".concat(r2));
        IUgcAIGCService.Companion r3 = IUgcAIGCService.a;
        Map r13 = e(com.bytedance.ies.xbridge.utils.j.d(r12));
        XReadableMap r14 = com.bytedance.ies.xbridge.s.e(r9, "extraInfo");
        if (r14 == null) goto L15;
        Map r15 = e(com.bytedance.ies.xbridge.utils.j.d(r14));
        if (r15 == null) goto L15;
    L16:
        r3.b(r0, r13, r15);
        XCoreBridgeMethod.onSuccess$default(this, r10, new LinkedHashMap(), null, 4, null);
        return;
    L15:
        r15 = MapsKt.emptyMap();
    L10:
        r2 = NameKeys.UnloadStrategy_No_Strategy;
        goto L11
    }
}
