package com.bytedance.applog.c;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.applog.util.o;
import com.bytedance.bdinstall.IBDInstallApi;
import com.bytedance.bdinstall.ICustomExtraHeader;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class d implements ICustomExtraHeader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<String> f1549a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.bytedance.applog.b f1550b;
    private volatile SharedPreferences c;
    private volatile JSONObject d;
    private final IBDInstallApi e;

    static {
        f1549a = Collections.singletonList("CustomHeaderAdapter");
    }

    d(com.bytedance.applog.b r3, IBDInstallApi r4) {
        IBDInstallApi r5 = (IBDInstallApi) ZeusTransformUtils.wrapperContextForParams(r4, IBDInstallApi.class, "com.obric.memorydata.plugin");
        this.f1550b = r3;
        this.e = r5;
    }

    private JSONObject a() {
        if (this.d != null) goto L14;
        SharedPreferences r0 = b();     // Catch: Throwable -> L11
        if (r0 == null) goto L15;
        String r1 = r0.getString("header_custom_info", null);     // Catch: Throwable -> L11
        if (o.a(r1) == false) goto L9;
        this.d = new JSONObject(r1);     // Catch: Throwable -> L11
        goto L15
    L9:
        this.d = new JSONObject();     // Catch: Throwable -> L11
    L15:
    L11:
        th = move-exception;
        this.f1550b.aA().a(f1549a, "getCustomInfo failed", th, new Object[0]);
    L14:
        return this.d;
    }

    private void a(JSONObject r4) {
        this.d = r4;
        SharedPreferences r0 = b();
        if (r0 == null) goto L9;
        SharedPreferences.Editor r1 = r0.edit();
        if (r4 == null) goto L7;
        String r2 = r4.toString();
    L8:
        r1.putString("header_custom_info", r2).apply();
        goto L9
    L7:
        r2 = "";
    L9:
        this.e.setCustomHeader((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1550b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4);
    }

    private SharedPreferences b() {
        if (this.c != null) goto L8;
        if (((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1550b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")) == null) goto L8;
        this.c = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.f1550b.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getSharedPreferences(com.bytedance.applog.a.a(this.f1550b, "header_custom"), 0);
    L8:
        return this.c;
    }

    public void a(String r3) {
        JSONObject r0 = a();
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.has(r3) == false) goto L9;
        r0.remove(r3);
        JSONObject r4 = new JSONObject();
        o.b(r4, r0);
        a(r4);
        return;
    }

    public void a(Map<String, Object> r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r7, Map.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        return;
    L5:
        if (r8.isEmpty() == false) goto L26;
        return;
    L26:
        JSONObject r2 = a();     // Catch: Throwable -> L23
        if (o.a(r8, r2) == true) goto L12;
        this.f1550b.aA().b(f1549a, "appendHeaderInfo no value changed", new Object[0]);     // Catch: Throwable -> L23
        return;
    L12:
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L23
        if (r2 == null) goto L15;
        o.b(r3, r2);     // Catch: Throwable -> L23
    L15:
        Iterator r9 = r8.entrySet().iterator();     // Catch: Throwable -> L23
    L17:
        if (r9.hasNext() == false) goto L21;
        Map.Entry r4 = (Map.Entry) ZeusTransformUtils.preCheckCast(r9.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L23
        if (o.a((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin")) == false) goto L17;
        r3.put((String) ZeusTransformUtils.preCheckCast(r4.getKey(), String.class, "com.obric.memorydata.plugin"), r4.getValue());     // Catch: Throwable -> L23
        goto L17
    L21:
        a(r3);     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        this.f1550b.aA().a(f1549a, "appendHeaderInfo failed", th, new Object[0]);
    }

    @Override // com.bytedance.bdinstall.ICustomExtraHeader
    public Map<String, Object> getExtraParams() {
        JSONObject r5 = a();
        if (r5 == null) goto L5;
        HashMap r0 = new HashMap();
        Iterator<String> r1 = r5.keys();
    L8:
        if (r1.hasNext() == false) goto L12;
        String r2 = (String) ZeusTransformUtils.preCheckCast(r1.next(), String.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L8;
        r0.put(r2, r5.opt(r2));
        goto L8
    L12:
        return r0;
    L5:
        return Collections.emptyMap();
    }
}
