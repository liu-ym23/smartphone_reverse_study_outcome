package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkDynamicWidgetNew;
import com.bytedance.ies.sdk.widgets.KVData;
import com.google.gson.JsonObject;
import com.ss.android.ugc.aweme.compat.nullable.Observer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b0<T> implements Observer {
    public final /* synthetic */ v a;

    public b0(v r1) {
        this.a = r1;
    }

    public final void onChanged(Object r12) {
        KVData r13 = (KVData) r12;
        if (r13 == null) goto L5;
        Object r0 = r13.getData();
    L7:
        if (r0 == null) goto L13;
        Object r14 = r13.getData();
        if (r14 == null) goto L12;
        boolean r15 = ((Boolean) r14).booleanValue();
    L14:
        JsonObject r7 = new JsonObject();
        if (r15 == false) goto L17;
        String r16 = "1";
    L18:
        r7.addProperty("fold_status", r16);
        nh0.f r17 = new nh0.f("barrage_layout_data", null, null, null, r7, null, false, 222);
        MultiLinkDynamicWidgetNew r1 = this.a.o();
        int r2 = MultiLinkDynamicWidgetNew.A;
        r1.wq(r17, false);
        return;
    L17:
        r16 = "0";
        goto L18
    L12:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
    L13:
        r15 = false;
        goto L14
    L5:
        r0 = null;
        goto L7
    }
}
