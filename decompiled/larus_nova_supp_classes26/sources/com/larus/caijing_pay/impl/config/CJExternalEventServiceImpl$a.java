package com.larus.caijing_pay.impl.config;

import com.android.ttcjpaysdk.base.service.ICJExternalEventCenterCallback;
import com.bytedance.ies.xbridge.XReadableMap;
import com.bytedance.ies.xbridge.event.Js2NativeEvent;
import com.bytedance.ies.xbridge.event.JsEventSubscriber;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CJExternalEventServiceImpl$a implements JsEventSubscriber {
    public final /* synthetic */ ICJExternalEventCenterCallback a;

    public CJExternalEventServiceImpl$a(ICJExternalEventCenterCallback r1) {
        this.a = r1;
    }

    public final void onReceiveJsEvent(Js2NativeEvent r3) {
        Intrinsics.checkNotNullParameter(r3, "jsEvent");
        ICJExternalEventCenterCallback r0 = this.a;
        String r1 = r3.getEventName();
        XReadableMap r4 = r3.getParams();
        if (r4 == null) goto L5;
        Map r5 = r4.toMap();
    L6:
        r0.onReceiveEvent(r1, r5);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
