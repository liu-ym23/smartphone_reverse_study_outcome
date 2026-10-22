package com.bytedance.android.live.liveinteract.plantform.dynamicframe.handler;

import com.bytedance.android.live.liveinteract.multianchor.model.LinkmicPositionItem;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class u<T> implements Consumer {
    public final /* synthetic */ v a;

    public u(v r1) {
        this.a = r1;
    }

    public final void accept(Object r6) {
        JsonArray r0 = new JsonArray();
        Iterator<T> r7 = ((List) r6).iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        LinkmicPositionItem r1 = (LinkmicPositionItem) r7.next();
        JsonObject r2 = new JsonObject();
        r2.addProperty("position", Long.valueOf(r1.getPosition()));
        r2.addProperty("status", Integer.valueOf(r1.getStatus()));
        r2.addProperty("active_name", r1.getActiveName());
        r2.addProperty("verify_status", Integer.valueOf(r1.getVerifyStatus()));
        r2.addProperty("position_type", Integer.valueOf(r1.getPositionType()));
        r2.addProperty("client_ui_position", Long.valueOf(r1.getClientUIPosition()));
        r0.add(r2);
        goto L4
    L6:
        JsonObject r8 = new JsonObject();
        r8.add("position_items", r0);
        this.a.z.Dk("seat", "position_item_list", r8, false);
    }
}
