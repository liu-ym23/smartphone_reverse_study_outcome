package com.bytedance.applog.util;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.bdinstall.INetworkClient;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements INetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.m.a f1879a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.b f1880b;

    public d(com.bytedance.applog.b r1) {
        this.f1880b = r1;
        this.f1879a = r1.aw();
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r3, Map<String, String> r4) {
        Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        return this.f1879a.a(0, r3, (HashMap) ZeusTransformUtils.preCheckCast(r5, HashMap.class, "com.obric.memorydata.plugin"), null);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r6, List<Pair<String, String>> r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        if (r8 == null) goto L12;
        Iterator r9 = r8.iterator();     // Catch: Throwable -> L9
    L6:
        if (r9.hasNext() == false) goto L12;
        Pair r2 = (Pair) ZeusTransformUtils.preCheckCast(r9.next(), Pair.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        r0.put((String) ZeusTransformUtils.preCheckCast(r2.first, String.class, "com.obric.memorydata.plugin"), r2.second);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        this.f1880b.aA().a(11, "post parse params to json failed", th, new Object[0]);
    L12:
        return post(r6, r0.toString().getBytes(), "application/json; charset=utf-8");
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, String r5) {
        HashMap r0 = new HashMap();
        if (TextUtils.isEmpty(r5) == true) goto L6;
        r0.put(NetConst.KEY_CONTENT_TYPE, r5);
    L6:
        return post(r3, r4, r0);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        return this.f1879a.a(1, r3, (HashMap) ZeusTransformUtils.preCheckCast(r6, HashMap.class, "com.obric.memorydata.plugin"), r4);
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r3, byte[] r4, Map<String, String> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin");
        return this.f1879a.b(1, r3, (HashMap) ZeusTransformUtils.preCheckCast(r6, HashMap.class, "com.obric.memorydata.plugin"), r4);
    }
}
