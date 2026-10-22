package com.bytedance.android.livesdk.dynamicstrategy.impl.state.cloud;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.livesdk.chatroom.IRoomContextService;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.dynamicstrategy.api.entity.y;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.m;
import jc1.k;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements is2.b {
    public g() {
    }

    public final /* synthetic */ boolean a() {
        return false;
    }

    public final /* synthetic */ boolean c() {
        return false;
    }

    public final void d() {
    }

    public final boolean enable() {
        return true;
    }

    public final /* synthetic */ boolean f() {
        return false;
    }

    public final String getPath() {
        return "backend_strategy_features_request";
    }

    public final Class<?> getModelClass() {
        return y.class;
    }

    public final JSONObject g(Bundle r5, is2.a r6) {
        JSONObject r7 = new JSONObject();
        BaseMonitor.add(r7, "open", true);
        IRoomContextService r8 = k.f(IRoomContextService.class);
        if (r8 == null) goto L12;
        o r9 = IRoomContextService.a.a(r8, null, 0, 3);
        if (r9 == null) goto L12;
        m r10 = r9.getRoom();
        if (r10 == null) goto L12;
        IRoom r11 = (IRoom) r10.getValue();
        if (r11 == null) goto L12;
        String r12 = r11.getAnchorId();
        if (r12 == null) goto L12;
    L13:
        BaseMonitor.add(r7, "anchor_id", r12);
        return r7;
    L12:
        r12 = "";
        goto L13
    }
}
