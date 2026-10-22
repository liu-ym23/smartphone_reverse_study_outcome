package com.bytedance.android.live.profit.vote.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.revenue.common.l0;
import com.bytedance.android.scope.o;
import is2.b;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class a implements b, o {
    public a() {
    }

    public final /* synthetic */ boolean a() {
        return false;
    }

    public final /* synthetic */ boolean c() {
        return false;
    }

    public final void d() {
    }

    public final /* synthetic */ boolean f() {
        return false;
    }

    public final String getPath() {
        return "webcast_gift_vote_list";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        return l0.a("vote");
    }

    public final Class<?> getModelClass() {
        return com.bytedance.android.live.profit.vote.transfer.a.class;
    }

    public final JSONObject g(Bundle r2, is2.a r3) {
        JSONObject r4 = new JSONObject();
        BaseMonitor.add(r4, "open", true);
        BaseMonitor.add(r4, "biz_data_type", "pb");
        BaseMonitor.add(r4, "request_source", "enter_room");
        return r4;
    }
}
