package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.apm6.util.constant.NetConst;
import com.bytedance.apm6.util.constant.ReportConsts;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class c implements Callable<Void> {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final String f1733n = "c";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1734c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final a f1735g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private String f1736h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private List<String> f1737i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private List<String> f1738j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private DnsRecord.CacheStaleReason f1739k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f1740l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final WeakHandler f1741m;

    static {
    }

    c(String r10, String r11, a r12, DnsRecord.CacheStaleReason r13, WeakHandler r14) {
        this.f1737i = new ArrayList();
        this.f1738j = new ArrayList();
        this.f1740l = 0;
        this.f1736h = r10;
        this.f1734c = r11;
        this.f1735g = r12;
        this.f1739k = r13;
        this.f1741m = r14;
    }

    private String b(String r10) {
        StringBuilder r11 = new StringBuilder();
        if (w2.d.b().get() == true) goto L5;
        this.f1740l = 1;
    L5:
        r11.append(ReportConsts.HTTPS);
        r11.append(r10);
        r11.append("/q?host=");
        r11.append(this.f1736h);
        r11.append("&");
        r11.append("aid=");
        r11.append(b.q().h().getAppId());
        r11.append("&");
        r11.append("okhttp_version=");
        r11.append(this.f1734c);
        r11.append("&");
        r11.append("p=");
        r11.append("android");
        r11.append("&");
        r11.append("source=");
        r11.append("tt-ok");
        r11.append("&");
        r11.append("f=");
        r11.append(this.f1740l);
        r11.append("&");
        r11.append("reason=");
        r11.append(this.f1739k.ordinal() - 1);
        if (this.f1735g.h().get() >= 3) goto L9;
        r11.append("&");
        r11.append("refresh_bkup_ip=");
        r11.append(NetConst.ENCRYPT_VERISON_CODE);
        this.f1735g.A();
    L9:
        return w2.b.a(r11.toString(), r10);
    }

    private void c(String r10) {
        if (Logger.debug() == false) goto L26;
        Logger.d(f1733n, "parseHttpDnsResponse");
    L26:
        if (TextUtils.isEmpty(r10) == false) goto L8;
        return;
    L8:
        JSONObject r11 = new JSONObject(r10);     // Catch: JSONException -> L22
        if (this.f1737i.size() <= 1) goto L17;
        JSONArray r12 = r11.optJSONArray("dns");     // Catch: JSONException -> L22
        if (r12 != null) goto L13;
        return;
    L13:
        int r13 = 0;
    L15:
        if (r13 >= r12.length()) goto L18;
        d(r12.optJSONObject(r13));     // Catch: JSONException -> L22
        r13 = r13 + 1;     // Catch: JSONException -> L22
    L18:
        JSONArray r14 = r11.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L22
        if (r14 == null) goto L29;
        b.q().C(r14);     // Catch: JSONException -> L22
        return;
    L29:
        return;
    L17:
        d(r11);     // Catch: JSONException -> L22
    L23:
        if (Logger.debug() == false) goto L30;
        Logger.d(f1733n, "httpdns server returned a invalid json response.");
        return;
    }

    private void d(JSONObject r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        String r11 = r10.optString("host");
        if (Logger.debug() == false) goto L7;
        Logger.d(f1733n, "parseSingleHostHttpDnsResponse for host " + r11);
    L7:
        int r12 = r10.optInt("ttl");
        JSONArray r13 = r10.optJSONArray("ips");
        ArrayList r14 = new ArrayList();
        ArrayList r15 = new ArrayList();
        if (r13 == null) goto L23;
        int r16 = 0;
    L11:
        if (r16 >= r13.length()) goto L23;
        String r17 = r13.optString(r16);
        if (w2.c.d(r17) == false) goto L16;
        r15.add(r17);
    L21:
        r16 = r16 + 1;
        goto L11
    L16:
        if (w2.c.c(r17) == false) goto L19;
        r14.add(r17);
        goto L21
    L19:
        if (Logger.debug() == false) goto L21;
        Logger.d(f1733n, "httpdns server returned a invalid address: " + r17);
    L23:
        if (this.f1737i.contains(r11) == true) goto L25;
        return;
    L25:
        if (r14.size() <= 0) goto L27;
    L28:
        this.f1735g.a(r11, new DnsRecord(r11, System.currentTimeMillis(), r14, r15, r12));
        this.f1735g.u(r11);
        this.f1737i.remove(r11);
        return;
    L27:
        if (r15.size() > 0) goto L28;
    }

    public Void a() {
        String[] r10 = this.f1736h.split(",");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L6;
        String r13 = r10[r12];
        this.f1737i.add(r13);
        this.f1738j.add(r13);
        r12 = r12 + 1;
        goto L3
    L6:
        if (Logger.debug() == false) goto L8;
        Logger.d(f1733n, "Start httpdns resolve for host : " + this.f1737i);
    L8:
        String r14 = b.q().i();
        if (b.q().j().size() != 0) goto L12;
        this.f1735g.z();
    L12:
        if (w2.a.a(r14) == true) goto L14;
    L18:
        String r15 = null;
    L19:
        if (r15 == null) goto L21;
        c(r15);
        this.f1735g.z();
    L38:
        Iterator<String> r16 = this.f1737i.iterator();
    L40:
        if (r16.hasNext() == false) goto L42;
        String r17 = r16.next();
        this.f1735g.u(r17);
        this.f1735g.s(r17);
        goto L40
    L42:
        Message r18 = Message.obtain();
        r18.obj = this;
        r18.what = 3;
        Bundle r19 = new Bundle();
        r19.putStringArrayList("httpdns_completed_hosts", (ArrayList) this.f1738j);
        r18.setData(r19);
        this.f1741m.sendMessage(r18);
        if (Logger.debug() == false) goto L45;
        Logger.d(f1733n, "send message to collect result handler for host : " + this.f1738j);
    L45:
        return null;
    L21:
        Iterator<String> r20 = b.q().j().iterator();
    L23:
        if (r20.hasNext() == false) goto L38;
        String r21 = r20.next();
        if (w2.c.c(r21) == true) goto L31;
        if (w2.c.d(r21) == true) goto L31;
        if (Logger.debug() == false) goto L23;
        String r22 = f1733n;
        StringBuilder r23 = new StringBuilder();
        r23.append("httpdns backup domian hardcode ip: ");
        r23.append(r21);
        String r24 = " is invalid";
    L36:
        r23.append(r24);
        Logger.d(r22, r23.toString());
    L31:
        String r25 = b(r21);
        if (r25 != null) goto L37;
        if (Logger.debug() == false) goto L23;
        r22 = f1733n;
        r23 = new StringBuilder();
        r23.append("httpdns request failed use hardcode ip: ");
        r23.append(r21);
        r24 = " try next hardcode ip";
        goto L36
    L37:
        c(r25);
        goto L38
    L14:
        if (this.f1735g.j().get() >= 2) goto L18;
        r15 = b(r14);
        if (r15 != null) goto L19;
        this.f1735g.b();
        goto L19
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }
}
