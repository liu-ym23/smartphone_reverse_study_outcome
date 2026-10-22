package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class c implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f2487a = "c";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2488b;
    private final a c;
    private String d;
    private List<String> e;
    private List<String> f;
    private DnsRecord.CacheStaleReason g;
    private int h;
    private final WeakHandler i;

    static {
    }

    c(String r2, String r3, a r4, DnsRecord.CacheStaleReason r5, WeakHandler r6) {
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.h = 0;
        this.d = r2;
        this.f2488b = r3;
        this.c = r4;
        this.g = r5;
        this.i = r6;
    }

    private String a(String r6) {
        StringBuilder r0 = new StringBuilder();
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.d.b().get() == true) goto L5;
        this.h = 1;
    L5:
        r0.append(ReportConsts.HTTPS).append(r6).append("/q?host=").append(this.d).append("&").append("aid=").append(b.a().d().b()).append("&").append("okhttp_version=").append(this.f2488b).append("&").append("p=").append("android").append("&").append("source=").append("tt-ok").append("&").append("f=").append(this.h).append("&").append("reason=").append(this.g.ordinal() - 1);
        if (this.c.a().get() >= 3) goto L9;
        r0.append("&").append("refresh_bkup_ip=").append("1");
        this.c.b();
    L9:
        return com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.b.a(r0.toString(), r6);
    }

    private void a(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r0 = r10.optString("host");
        if (Logger.debug() == false) goto L7;
        Logger.d(f2487a, "parseSingleHostHttpDnsResponse for host " + r0);
    L7:
        int r7 = r10.optInt("ttl");
        JSONArray r11 = r10.optJSONArray("ips");
        ArrayList r5 = new ArrayList();
        ArrayList r6 = new ArrayList();
        if (r11 == null) goto L23;
        int r1 = 0;
    L11:
        if (r1 >= r11.length()) goto L23;
        String r2 = r11.optString(r1);
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.c.c(r2) == false) goto L16;
        r6.add(r2);
    L21:
        r1 = r1 + 1;
        goto L11
    L16:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.c.d(r2) == false) goto L19;
        r5.add(r2);
        goto L21
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(f2487a, "httpdns server returned a invalid address: " + r2);
    L23:
        if (this.e.contains(r0) == true) goto L25;
        return;
    L25:
        if (r5.size() <= 0) goto L27;
    L28:
        this.c.a(r0, new DnsRecord(r0, System.currentTimeMillis(), r5, r6, r7));
        this.c.f(r0);
        this.e.remove(r0);
        return;
    L27:
        if (r6.size() > 0) goto L28;
    }

    private void b(String r4) {
        if (Logger.debug() == false) goto L26;
        Logger.d(f2487a, "parseHttpDnsResponse");
    L26:
        if (TextUtils.isEmpty(r4) == false) goto L8;
        return;
    L8:
        JSONObject r0 = new JSONObject(r4);     // Catch: JSONException -> L22
        if (this.e.size() <= 1) goto L17;
        JSONArray r5 = r0.optJSONArray("dns");     // Catch: JSONException -> L22
        if (r5 != null) goto L13;
        return;
    L13:
        int r1 = 0;
    L15:
        if (r1 >= r5.length()) goto L18;
        a(r5.optJSONObject(r1));     // Catch: JSONException -> L22
        r1 = r1 + 1;     // Catch: JSONException -> L22
    L18:
        JSONArray r3 = r0.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L22
        if (r3 == null) goto L29;
        b.a().a(r3);     // Catch: JSONException -> L22
        return;
    L29:
        return;
    L17:
        a(r0);     // Catch: JSONException -> L22
    L23:
        if (Logger.debug() == false) goto L30;
        Logger.d(f2487a, "httpdns server returned a invalid json response.");
        return;
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        String[] r0 = this.d.split(",");
        int r1 = r0.length;
        int r2 = 0;
    L3:
        if (r2 >= r1) goto L6;
        String r3 = r0[r2];
        this.e.add(r3);
        this.f.add(r3);
        r2 = r2 + 1;
        goto L3
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(f2487a, "Start httpdns resolve for host : " + this.e);
    L8:
        String r4 = b.a().e();
        if (b.a().f().size() != 0) goto L12;
        this.c.e();
    L12:
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.a.a(r4) == true) goto L14;
    L18:
        String r5 = null;
    L20:
        if (r5 == null) goto L22;
        b(r5);
        this.c.e();
    L39:
        Iterator<String> r6 = this.e.iterator();
    L41:
        if (r6.hasNext() == false) goto L43;
        String r7 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        this.c.f(r7);
        this.c.a(r7);
        goto L41
    L43:
        Message r8 = Message.obtain();
        r8.obj = this;
        r8.what = 3;
        Bundle r9 = new Bundle();
        r9.putStringArrayList("httpdns_completed_hosts", (ArrayList) ZeusTransformUtils.preCheckCast(this.f, ArrayList.class, "com.obric.memorydata.plugin"));
        r8.setData(r9);
        this.i.sendMessage(r8);
        if (Logger.debug() == false) goto L46;
        Logger.d(f2487a, "send message to collect result handler for host : " + this.f);
    L46:
        return null;
    L22:
        Iterator<String> r10 = b.a().f().iterator();
    L24:
        if (r10.hasNext() == false) goto L39;
        String r11 = (String) ZeusTransformUtils.preCheckCast(r10.next(), String.class, "com.obric.memorydata.plugin");
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.c.d(r11) == true) goto L32;
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.a.c.c(r11) == true) goto L32;
        if (Logger.debug() == false) goto L24;
        String r12 = f2487a;
        StringBuilder r13 = new StringBuilder().append("httpdns backup domian hardcode ip: ").append(r11);
        String r14 = " is invalid";
    L37:
        Logger.d(r12, r13.append(r14).toString());
    L32:
        String r15 = a(r11);
        if (r15 != null) goto L38;
        if (Logger.debug() == false) goto L24;
        r12 = f2487a;
        r13 = new StringBuilder().append("httpdns request failed use hardcode ip: ").append(r11);
        r14 = " try next hardcode ip";
        goto L37
    L38:
        b(r15);
        goto L39
    L14:
        if (this.c.c().get() >= 2) goto L18;
        r5 = a(r4);
        if (r5 != null) goto L20;
        this.c.d();
        goto L20
    }
}
