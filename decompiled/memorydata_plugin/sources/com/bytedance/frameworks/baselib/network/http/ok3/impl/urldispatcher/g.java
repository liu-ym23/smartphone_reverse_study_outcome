package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g extends DispatchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2520a = "g";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f2521b;

    static {
    }

    public g(JSONObject r5) {
        super(DispatchStrategy.DispatchStrategyType.STATIC_DISPATCH_STRATEGY);
        this.f2521b = new HashMap();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator<String> r0 = r5.keys();
    L7:
        if (r0.hasNext() == false) goto L13;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L7;
        if (TextUtils.isEmpty(r2) == true) goto L7;
        this.f2521b.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String a(Uri r5) {
        String r0 = r5.getHost();
        String r6 = r5.toString();
        String r4 = (String) ZeusTransformUtils.preCheckCast(this.f2521b.get(r0), String.class, "com.obric.memorydata.plugin");
        if (TextUtils.isEmpty(r4) == false) goto L5;
        return r6;
    L5:
        if (Logger.debug() == false) goto L8;
        Logger.d(f2520a, "replace host " + r4 + " for " + r0);
    L8:
        return r6.replaceFirst(r0, r4);
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void a(k r1) {
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean a() {
        return false;
    }
}
