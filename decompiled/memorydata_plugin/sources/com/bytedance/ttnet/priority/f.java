package com.bytedance.ttnet.priority;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.exception.DroppedByThrottleControlException;
import com.bytedance.retrofit2.client.Request;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Set<String> f3305a;

    public f() {
        this.f3305a = new CopyOnWriteArraySet();
    }

    public void a(Request r2) {
        if (TTHttpCallPriorityControl.a(this.f3305a, r2.getPath()) == true) goto L5;
        return;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d("RequestDropController", "check drop and match " + r2.getPath());
    L8:
        throw new DroppedByThrottleControlException();
    }

    public void a(JSONObject r4) {
        this.f3305a.clear();
        JSONArray r5 = r4.optJSONArray("dl");
        if (r5 == null) goto L11;
        int r0 = 0;
    L6:
        if (r0 >= r5.length()) goto L15;
        String r1 = r5.optString(r0);
        if (TextUtils.isEmpty(r1) == true) goto L10;
        this.f3305a.add(r1);
    L10:
        r0 = r0 + 1;
        goto L6
    L15:
        return;
    }

    public boolean a() {
        if (this.f3305a.size() <= 0) goto L5;
        return true;
    L5:
        return false;
    }
}
