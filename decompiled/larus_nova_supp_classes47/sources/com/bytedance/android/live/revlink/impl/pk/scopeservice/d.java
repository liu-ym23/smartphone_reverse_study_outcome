package com.bytedance.android.live.revlink.impl.pk.scopeservice;

import com.bytedance.badger.collect.impl.constants.Constants;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d<T> implements Observer {
    public final /* synthetic */ PkLynxInfoImpl a;

    public d(PkLynxInfoImpl r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Boolean r5 = (Boolean) r4;
        if (r5 == null) goto L6;
        boolean r6 = r5.booleanValue();
        JSONObject r0 = new JSONObject();
        r0.put("type", "instant_kill");
        r0.put(Constants.Keys.DATA, r6);
        this.a.f(r0);
        return;
    }
}
