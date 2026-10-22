package com.obric.cae.cloud.ttnet;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ttnet.TTNetInit;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class d implements com.bytedance.ttnet.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f6942a;

    public d(Context r3) {
        this.f6942a = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public int a(Context r1, String r2, int r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return 0;
    }

    @Override // com.bytedance.ttnet.d
    public String a(Context r1, String r2, String r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r1, String r2, String r3, JSONObject r4) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r2, Map<String, ?> r3) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public void a(Context r1, JSONObject r2) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.memorydata.plugin");
    }

    @Override // com.bytedance.ttnet.d
    public void a(String r6) {
        if (TextUtils.isEmpty(r6) == true) goto L23;
        ArrayList r5 = new ArrayList();
        String[] r7 = r6.split(",");
        if (r7.length <= 0) goto L18;
        int r0 = r7.length;
        int r1 = 0;
    L7:
        if (r1 >= r0) goto L18;
        String r2 = r7[r1];
        if (TextUtils.isEmpty(r2) == true) goto L17;
        if (r2.length() > 1) goto L14;
    L16:
        r5.add(r2);
        goto L17
    L14:
        if (r2.startsWith(".") == false) goto L16;
        r2 = r2.substring(1);
    L17:
        r1 = r1 + 1;
    L18:
        com.ss.android.token.c.a(r5);
        return;
    }

    @Override // com.bytedance.ttnet.d
    public void a(String r1, JSONObject r2) {
        com.bytedance.apm.a.a(r1, r2);
    }

    @Override // com.bytedance.ttnet.d
    public boolean a() {
        return true;
    }

    @Override // com.bytedance.ttnet.d
    public String[] b() {
        return new String[]{"tnc3-bjlgy.snssdk.com", "tnc3-alisc1.snssdk.com", "tnc3-aliec2.snssdk.com"};
    }

    @Override // com.bytedance.ttnet.d
    public String c() {
        return "snssdk.com";
    }

    @Override // com.bytedance.ttnet.d
    public String d() {
        return "byteimg.com";
    }

    @Override // com.bytedance.ttnet.d
    public String e() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public void f() {
    }

    @Override // com.bytedance.ttnet.d
    public ArrayList<String> g() {
        return null;
    }

    @Override // com.bytedance.ttnet.d
    public Context getContext() {
        return this.f6942a;
    }

    @Override // com.bytedance.ttnet.d
    public int h() {
        return 941134;
    }

    @Override // com.bytedance.ttnet.d
    public Map<String, String> i() {
        HashMap r2 = new HashMap();
        r2.put(TTNetInit.DOMAIN_HTTPDNS_KEY, "dig.bdurl.net");
        r2.put(TTNetInit.DOMAIN_NETLOG_KEY, "crash.snssdk.com");
        r2.put(TTNetInit.DOMAIN_BOE_KEY, ".boe-gateway.byted.org");
        return r2;
    }
}
