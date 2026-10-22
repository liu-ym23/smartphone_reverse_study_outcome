package com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.retrofit2.client.Header;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class f extends DispatchStrategy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2518a = "f";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Map<String, String> f2519b;

    static {
    }

    public f(JSONObject r5) {
        super(DispatchStrategy.DispatchStrategyType.REQUEST_HEADER_DISPATCH_STRATEGY);
        this.f2519b = new HashMap();
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
        this.f2519b.put(r1, r2);
        goto L7
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public String a(Uri r1) {
        return r1.toString();
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public void a(k r7) {
        if (r7.d() == null) goto L8;
        Iterator<Map.Entry<String, String>> r6 = this.f2519b.entrySet().iterator();
    L6:
        if (r6.hasNext() == false) goto L10;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r6.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r7.d().add(new Header((String) ZeusTransformUtils.preCheckCast(r0.getKey(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r0.getValue(), String.class, "com.obric.memorydata.plugin")));
        goto L6
    L10:
        return;
    }

    @Override // com.bytedance.frameworks.baselib.network.http.ok3.impl.urldispatcher.DispatchStrategy
    public boolean a() {
        return false;
    }
}
