package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import com.bytedance.android.livesdkapi.hybridapi.SubscriberJsEvent;
import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g3<T> implements Consumer {
    public final /* synthetic */ ToolbarGroupPurchaseWidgetBehavior a;

    public g3(ToolbarGroupPurchaseWidgetBehavior r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        ToolbarGroupPurchaseWidgetBehavior r0 = this.a;
        Map r5 = ((SubscriberJsEvent) r4).getParams();
        Object r1 = null;
        if (r5 == null) goto L5;
        Object r6 = r5.get("is_explanation");
    L7:
        if ((r6 instanceof Boolean) == false) goto L10;
        r1 = r6;
    L10:
        Boolean r2 = (Boolean) r1;
        if (r2 == null) goto L13;
        boolean r7 = r2.booleanValue();
    L14:
        r0.h = r7;
        return;
    L13:
        r7 = false;
        goto L14
    L5:
        r6 = null;
        goto L7
    }
}
