package com.bytedance.applog.c;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.applog.log.p;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.INetworkClient;
import com.bytedance.rpc.internal.RpcUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class a implements INetworkClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.bytedance.applog.b f1533a;

    public a(com.bytedance.applog.b r1) {
        this.f1533a = r1;
    }

    private String a(String r7, JSONObject r8, Map<String, String> r9) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L6;
        return "";
    L6:
        String r10 = UUID.randomUUID().toString();
        this.f1533a.aw().a(r7, r10, r8, 0, r5);
        return r10;
    }

    private String a(String r7, byte[] r8, Map<String, String> r9) {
        Map<String, String> r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r9, Map.class, "com.obric.memorydata.plugin");
        if (p.a() == false) goto L6;
        return "";
    L6:
        String r10 = UUID.randomUUID().toString();
        this.f1533a.aw().a(r7, r10, r8, 1, r5);
        return r10;
    }

    private Map<String, String> a(String r1, Map<String, String> r2) {
        return (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.memorydata.plugin");
    }

    private void a(String r4, String r5) {
        if (p.a() == false) goto L6;
        return;
    L6:
        if (o.a(r5) == true) goto L12;
        this.f1533a.aw().a(r4, -1, null, "BDInstall get response empty");
        return;
    L12:
        this.f1533a.aw().a(r4, 200, r5.getBytes(RpcUtils.CHARSET_UTF8), null);     // Catch: Throwable -> L11
        return;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String get(String r3, Map<String, String> r4) {
        Map<String, String> r5 = a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin"));
        String r0 = a(r3, null, r5);
        String r6 = this.f1533a.v().get(r3, r5);
        a(r0, r6);
        return r6;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r7, List<Pair<String, String>> r8) {
        List<Pair<String, String>> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
        JSONObject r0 = new JSONObject();
        if (r9 == null) goto L8;
        Iterator<Pair<String, String>> r2 = r9.iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Pair r3 = (Pair) ZeusTransformUtils.preCheckCast(r2.next(), Pair.class, "com.obric.memorydata.plugin");
        r0.put((String) ZeusTransformUtils.preCheckCast(r3.first, String.class, "com.obric.memorydata.plugin"), r3.second);
    L8:
        HashMap r1 = new HashMap(2);
        r1.put(NetConst.KEY_CONTENT_TYPE, "application/json; charset=utf-8");
        String r4 = a(r7, r0, r1);
        String r10 = this.f1533a.v().post(r7, r9);
        a(r4, r10);
        return r10;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, String r5) {
        HashMap r0 = new HashMap(2);
        if (TextUtils.isEmpty(r5) == true) goto L5;
        r0.put(NetConst.KEY_CONTENT_TYPE, r5);
    L5:
        String r1 = a(r3, r4, r0);
        String r6 = this.f1533a.v().post(r3, r4, r5);
        a(r1, r6);
        return r6;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public String post(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        String r0 = a(r3, r4, r6);
        String r7 = this.f1533a.v().post(r3, r4, r6);
        a(r0, r7);
        return r7;
    }

    @Override // com.bytedance.bdinstall.INetworkClient
    public byte[] postStream(String r3, byte[] r4, Map<String, String> r5) {
        Map<String, String> r6 = a(r3, (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.memorydata.plugin"));
        String r0 = a(r3, r4, r6);
        byte[] r7 = this.f1533a.v().postStream(r3, r4, r6);
        if (r7 == null) goto L5;
        String r8 = new String(r7);
    L6:
        a(r0, r8);
        return r7;
    L5:
        r8 = "";
        goto L6
    }
}
