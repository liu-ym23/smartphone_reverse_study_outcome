package com.bytedance.android.live.liveinteract.feedv2.feedview;

import com.bytedance.android.live.liveinteract.plantform.dynamicframe.MultiLinkFeedDynamicWidgetNew;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class n0<T> implements Consumer {
    public final /* synthetic */ MultiLinkRadioFeedView a;

    public n0(MultiLinkRadioFeedView r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        Long r6 = (Long) r5;
        JsonObject r7 = new JsonObject();
        r7.addProperty("type", "speaking");
        JsonObject r0 = new JsonObject();
        r0.addProperty("is_speaking", Boolean.valueOf(this.a.n));
        r7.add("data", r0);
        MultiLinkFeedDynamicWidgetNew r1 = this.a.s;
        if (r1 == null) goto L6;
        r1.Dk("radio", "radio_event", r7, false);
        return;
    }
}
