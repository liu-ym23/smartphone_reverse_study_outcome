package com.bytedance.frameworks.baselib.network.http.ok3.impl.a;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class a extends com.bytedance.frameworks.baselib.network.a.a.b<d> {
    public a() {
    }

    private Map<String, String> c(JSONObject r5) {
        HashMap r4 = new HashMap();
        if (r5 != null) goto L5;
    L15:
        return r4;
    L5:
        if (r5.length() == 0) goto L15;
        Iterator<String> r0 = r5.keys();
    L9:
        if (r0.hasNext() == false) goto L15;
        String r1 = (String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin");
        String r2 = r5.optString(r1);
        if (TextUtils.isEmpty(r1) == true) goto L9;
        if (TextUtils.isEmpty(r2) == true) goto L9;
        r4.put(r1, r2);
        goto L9
    }

    @Override // com.bytedance.frameworks.baselib.network.a.a.b
    public /* synthetic */ com.bytedance.frameworks.baselib.network.a.a.c a(Object r1) {
        return b(r1);
    }

    @Override // com.bytedance.frameworks.baselib.network.a.a.b
    public String a() {
        return "ttnet_req_meta_dp";
    }

    public d b(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, JSONObject.class) == false) goto L5;
        JSONObject r5 = (JSONObject) ZeusTransformUtils.preCheckCast(r4, JSONObject.class, "com.obric.memorydata.plugin");
    L6:
        if (r5 != null) goto L8;
        return null;
    L8:
        d r0 = new d();
        r0.f2456b = c(r5.optJSONObject("query_add"));
        r0.c = a(r5.optJSONArray("query_rm"));
        r0.d = c(r5.optJSONObject("header_add"));
        r0.e = a(r5.optJSONArray("header_rm"));
        return r0;
    L5:
        r5 = null;
        goto L6
    }
}
