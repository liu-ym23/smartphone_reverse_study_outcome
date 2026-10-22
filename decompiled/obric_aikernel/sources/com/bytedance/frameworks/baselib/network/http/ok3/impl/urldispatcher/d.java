package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d extends DispatchStrategy {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Map<String, String> f1825c;

    static {
    }

    public d(JSONObject r10) {
        super(DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY);
        this.f1825c = new HashMap();
        if (r10 != null) goto L5;
        return;
    L5:
        Iterator<String> r11 = r10.keys();
    L7:
        if (r11.hasNext() == false) goto L13;
        String r12 = r11.next();
        String r13 = r10.optString(r12);
        if (TextUtils.isEmpty(r12) == true) goto L7;
        if (TextUtils.isEmpty(r13) == true) goto L7;
        this.f1825c.put(r12, r13);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void a(y2.c r10) {
        if (r10.b() == null) goto L8;
        Iterator<Map.Entry<String, String>> r11 = this.f1825c.entrySet().iterator();
    L6:
        if (r11.hasNext() == false) goto L10;
        Map.Entry<String, String> r12 = r11.next();
        r10.b().add(new n4.b(r12.getKey(), r12.getValue()));
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String d(Uri r10) {
        return r10.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean e() {
        return false;
    }
}
