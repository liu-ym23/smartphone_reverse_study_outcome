package com.bytedance.android.livesdk.chatroom.widget;

import com.bytedance.android.live.browser.jsbridge.base.LiveGetAnchorTopicParamsResultModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class e0 extends w20.q2<JsonObject, LiveGetAnchorTopicParamsResultModel> {
    public final DataCenter a;

    public static final class a {
    }

    static {
    }

    public e0(DataCenter r1) {
        this.a = r1;
    }

    public final void invoke(Object r5, CallContext r6) {
        Intrinsics.checkNotNullParameter((JsonObject) r5, "params");
        Intrinsics.checkNotNullParameter(r6, "context");
        String r7 = com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o.b(this.a);
        String r8 = com.bytedance.android.livesdk.interactivity.api.publicscreen.highlight.o.a(this.a);
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("live_type", r7);
        r0.put("live_sub_type", r8);
        LiveGetAnchorTopicParamsResultModel r9 = new LiveGetAnchorTopicParamsResultModel();
        r9.a(LiveGetAnchorTopicParamsResultModel.Code.Success);
        LiveGetAnchorTopicParamsResultModel.a r10 = new LiveGetAnchorTopicParamsResultModel.a();
        JsonObject r1 = new JsonObject();
        Iterator r2 = r0.entrySet().iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        Map.Entry r3 = (Map.Entry) r2.next();
        r1.addProperty((String) r3.getKey(), (String) r3.getValue());
        goto L4
    L6:
        Unit r4 = Unit.INSTANCE;
        r10.a(r1);
        r9.b(r10);
        finishWithResult(r9);
    }
}
