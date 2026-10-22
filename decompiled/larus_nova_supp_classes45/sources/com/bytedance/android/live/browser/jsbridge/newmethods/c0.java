package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.AddTopicToPublishResultModel;
import com.bytedance.android.livehostapi.business.IHostBusiness;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "addTopicToPublish")
public final class c0 extends w20.f<w20.k7, AddTopicToPublishResultModel> {

    public static final class a {
    }

    static {
    }

    public c0() {
    }

    public final void invoke(Object r6, CallContext r7) {
        w20.k7 r8 = (w20.k7) r6;
        Intrinsics.checkNotNullParameter(r8, "params");
        Intrinsics.checkNotNullParameter(r7, "context");
        IHostBusiness r9 = jc1.k.f(IHostBusiness.class);
        if (r9 == null) goto L15;
        JsonObject r0 = new JsonObject();
        JsonArray r1 = new JsonArray();
        List<w20.k7.a> r11 = r8.a();
        if (r11 == null) goto L20;
        Iterator<w20.k7.a> r12 = r11.iterator();
    L9:
        if (r12.hasNext() == false) goto L14;
        w20.k7.a r2 = r12.next();
        JsonObject r3 = new JsonObject();
        String r4 = r2.a();
        if (r4 != null) goto L13;
        r4 = "";
    L13:
        r3.addProperty("name", r4);
        Unit r5 = Unit.INSTANCE;
        r1.add(r3);
        goto L9
    L14:
        Unit r13 = Unit.INSTANCE;
        r0.add("topic_list", r1);
        r9.addTopicToPublish(r0);
        goto L15
    L20:
        return;
    L15:
        finishWithSuccess();
    }
}
