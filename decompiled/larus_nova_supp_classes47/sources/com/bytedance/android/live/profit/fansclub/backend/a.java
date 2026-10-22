package com.bytedance.android.live.profit.fansclub.backend;

import android.os.Bundle;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.profit.fansclub.i;
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
        return "backend_webcast_fansclub_homepage";
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final boolean enable() {
        if (i.d() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final Class<?> getModelClass() {
        return IGetFansclubHomepageResult.class;
    }

    public final JSONObject g(Bundle r3, is2.a r4) {
        JSONObject r5 = new JSONObject();
        BaseMonitor.add(r5, "open", true);
        BaseMonitor.add(r5, "biz_data_type", 2);
        BaseMonitor.add(r5, "source", 1);
        return r5;
    }
}
