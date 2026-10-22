package e7;

import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.bytedance.retrofit2.RetrofitMetrics;
import com.bytedance.retrofit2.client.Request;
import com.bytedance.retrofit2.client.Response;
import com.bytedance.retrofit2.client.SsCall;
import d7.p;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class f implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7184a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f7185b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f7186c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f7187d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ArrayList f7188e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final a.EnumC0065a f7189f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f7190g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final WeakHandler f7191h;

    public f(String r8, String r10, d r11, a.EnumC0065a r12, WeakHandler r13) {
        this.f7187d = new ArrayList();
        this.f7188e = new ArrayList();
        this.f7190g = 0;
        this.f7186c = r8;
        this.f7184a = r10;
        this.f7185b = r11;
        this.f7189f = r12;
        this.f7191h = r13;
    }

    public final String a(String r14) {
        StringBuilder r8 = new StringBuilder("https://");
        if (f7.c.f7341a.get() == true) goto L5;
        this.f7190g = 1;
    L5:
        r8.append(r14);
        r8.append("/q?host=");
        r8.append(this.f7186c);
        r8.append("&aid=");
        ((p.a) e.g().f7182y).getClass();
        r8.append(String.valueOf(p.f6910g));
        r8.append("&okhttp_version=");
        r8.append(this.f7184a);
        r8.append("&p=android&source=tt-ok&f=");
        r8.append(this.f7190g);
        r8.append("&reason=");
        r8.append(this.f7189f.ordinal() - 1);
        if (this.f7185b.f7164h.get() >= 3) goto L8;
        r8.append("&refresh_bkup_ip=1");
        this.f7185b.f7164h.getAndIncrement();
    L8:
        String r13 = r8.toString();
        int r10 = f7.a.f7337a;
        Logger.d("a", "start execute httpdns get " + r13);
        long r11 = System.currentTimeMillis();
        StringBuilder r12 = new StringBuilder();
        SsCall r15 = null;
        BufferedReader r16 = null;
        String r17 = null;
        InputStream r18 = null;
        r15 = null;
        Request r19 = new Request.Builder().url(r13).build();     // Catch: Throwable -> L60 Exception -> L62
        r19.setMetrics(new RetrofitMetrics());     // Catch: Throwable -> L60 Exception -> L62
        ((p.a) e.g().f7182y).getClass();     // Catch: Throwable -> L60 Exception -> L62
        Context r20 = p.f6914k;     // Catch: Throwable -> L60 Exception -> L62
        if (p.f6904a == null) goto L12;
    L21:
        SsCall r21 = p.f6904a.newSsCall(r19);     // Catch: Throwable -> L60 Exception -> L62
        p.b r22 = (p.b) r21;     // Catch: Throwable -> L54 Exception -> L57
        Response r23 = r22.execute();     // Catch: Throwable -> L54 Exception -> L57
        if (r23.isSuccessful() == true) goto L25;
    L35:
        InputStream r24 = null;
        BufferedReader r25 = null;
    L36:
        String r26 = r12.toString();     // Catch: Throwable -> L49 Exception -> L52
        int r27 = r23.getStatus();     // Catch: Exception -> L47 Throwable -> L49
        r22.cancel();
        if (r25 != null) goto L114;
    L43:
        if (r24 == null) goto L76;
        r24.close();     // Catch: IOException -> L41
    L41:
        e = move-exception;
        e.printStackTrace();
    L76:
        long r28 = System.currentTimeMillis() - r11;
        JSONObject r29 = new JSONObject();     // Catch: JSONException -> L84
        r29.put("request_url", r13);     // Catch: JSONException -> L84
        r29.put("httpdns_domain", r14);     // Catch: JSONException -> L84
        if (r26 != null) goto L81;
        r29.put("result", "");     // Catch: JSONException -> L84
    L82:
        r29.put("response_code", r27);     // Catch: JSONException -> L84
        r29.put("rtt", r28);     // Catch: JSONException -> L84
        Logger.d("a", r29.toString());     // Catch: JSONException -> L84
    L86:
        return r26;
    L81:
        r29.put("result", r26);     // Catch: JSONException -> L84
    L84:
        e = move-exception;
        e.printStackTrace();
        goto L86
    L114:
        r25.close();     // Catch: IOException -> L41
        goto L43
    L49:
        th = th;
        r16 = r25;
    L51:
        BufferedReader r110 = r16;
        r18 = r24;
    L56:
        r24 = r18;
        r15 = r21;
    L89:
        if (r15 == null) goto L91;
        ((p.b) r15).cancel();
    L91:
        if (r110 != null) goto L104;
    L95:
        if (r24 == null) goto L99;
        r24.close();     // Catch: IOException -> L93
    L93:
        e = move-exception;
        e.printStackTrace();
    L99:
        throw th;
    L104:
        r110.close();     // Catch: IOException -> L93
    L47:
        e = move-exception;
        r17 = r26;
        e = e;
    L53:
        String r30 = r17;
        r15 = r21;
    L100:
        e.printStackTrace();     // Catch: Throwable -> L87
        if (r15 == null) goto L67;
        ((p.b) r15).cancel();
    L67:
        if (r25 != null) goto L112;
    L71:
        if (r24 == null) goto L75;
        r24.close();     // Catch: IOException -> L69
    L69:
        e = move-exception;
        e.printStackTrace();
    L75:
        r27 = 0;
        r26 = r30;
        goto L76
    L112:
        r25.close();     // Catch: IOException -> L69
    L87:
        th = th;
        r110 = r25;
    L52:
        e = e;
        goto L53
    L25:
        if (r23.getBody() == null) goto L35;
        r24 = r23.getBody().in();     // Catch: Throwable -> L54 Exception -> L57
        r25 = new BufferedReader(new InputStreamReader(r24, "UTF-8"));     // Catch: Throwable -> L31 Exception -> L33
    L110:
        String r111 = r25.readLine();     // Catch: Throwable -> L49 Exception -> L52
        if (r111 == null) goto L36;
        r12.append(r111);     // Catch: Throwable -> L49 Exception -> L52
        goto L110
    L33:
        e = e;
    L59:
        r25 = null;
        r15 = r21;
        r30 = null;
    L31:
        th = th;
        goto L51
    L57:
        e = e;
        r24 = null;
    L54:
        th = th;
        r110 = null;
        goto L56
    L12:
        monitor-enter(p.class);     // Catch: Throwable -> L60 Exception -> L62
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L60 Exception -> L62
    L14:
        if (p.f6904a != null) goto L16;
        p.f6904a = new p(r20);     // Catch: Throwable -> L18
    L16:
        monitor-exit(p.class);     // Catch: Throwable -> L18
    L62:
        e = e;
        r30 = null;
        r24 = null;
        r25 = null;
    L60:
        th = th;
        r110 = null;
        r24 = null;
        goto L89
    }

    public final void b(String r8) {
        Logger.d("f", "parseHttpDnsResponse");
    L20:
        Logger.d("f", "httpdns server returned a invalid json response.");
        return;
    L4:
        if (TextUtils.isEmpty(r8) == false) goto L6;
        return;
    L6:
        JSONObject r10 = new JSONObject(r8);     // Catch: JSONException -> L20
        if (this.f7187d.size() <= 1) goto L15;
        JSONArray r11 = r10.optJSONArray("dns");     // Catch: JSONException -> L20
        if (r11 != null) goto L11;
        return;
    L11:
        int r12 = 0;
    L13:
        if (r12 >= r11.length()) goto L16;
        c(r11.optJSONObject(r12));     // Catch: JSONException -> L20
        r12 = r12 + 1;     // Catch: JSONException -> L20
    L16:
        JSONArray r13 = r10.optJSONArray("httpdns_backup_ip");     // Catch: JSONException -> L20
        if (r13 == null) goto L25;
        e.g().l(r13);     // Catch: JSONException -> L20
        return;
    L25:
        return;
    L15:
        c(r10);     // Catch: JSONException -> L20
        goto L16
    }

    public final void c(JSONObject r11) {
        if (r11 != null) goto L4;
        return;
    L4:
        String r8 = r11.optString("host");
        Logger.d("f", "parseSingleHostHttpDnsResponse for host " + r8);
        int r10 = r11.optInt("ttl");
        JSONArray r12 = r11.optJSONArray("ips");
        ArrayList r13 = new ArrayList();
        ArrayList r14 = new ArrayList();
        if (r12 == null) goto L18;
        int r15 = 0;
    L8:
        if (r15 >= r12.length()) goto L18;
        String r16 = r12.optString(r15);
        if (f7.b.b(r16) == false) goto L13;
        r14.add(r16);
    L16:
        r15 = r15 + 1;
        goto L8
    L13:
        if (f7.b.a(r16) == false) goto L15;
        r13.add(r16);
        goto L16
    L15:
        Logger.d("f", "httpdns server returned a invalid address: " + r16);
    L18:
        if (this.f7187d.contains(r8) == true) goto L20;
        return;
    L20:
        if (r13.size() <= 0) goto L22;
    L23:
        a r17 = new a(r8, System.currentTimeMillis(), r13, r14, r10);
        d r18 = this.f7185b;
        a r19 = r18.e(r8);
        if (r19 == null) goto L30;
        if (e.g().f7169b.get() == false) goto L28;
        r19.b();
        goto L30
    L28:
        r19.c();
    L30:
        if (e.g().f7169b.get() == false) goto L32;
        Message r20 = Message.obtain();
        r20.obj = r17;
        r20.what = 12;
        r17.e(r20);
        long r21 = r17.f7137d * 1000;
        WeakHandler r22 = r17.f7139f;
        r22.sendMessageDelayed(r20, r21);
        Message r23 = Message.obtain();
        r23.obj = r17;
        r23.what = 10;
        r17.e(r23);
        r22.sendMessageDelayed(r23, (((long) e.g().f7176s.get()) * 1000) + r21);
    L33:
        Map<String, a> r24 = r18.f7157a.c();
        monitor-enter(r24);
        r18.f7157a.d(r8, r17);     // Catch: Throwable -> L38
        monitor-exit(r24);     // Catch: Throwable -> L38
        this.f7185b.p(r8);
        this.f7187d.remove(r8);
        return;
    L38:
        th = move-exception;
        throw th;
    L32:
        Message r25 = Message.obtain();
        r25.obj = r17;
        r25.what = 13;
        r17.e(r25);
        r17.f7139f.sendMessageDelayed(r25, r17.f7137d * 1000);
        goto L33
    L22:
        if (r14.size() > 0) goto L23;
    }

    @Override // java.util.concurrent.Callable
    public final Void call() {
        String[] r8 = this.f7186c.split(",");
        int r10 = r8.length;
        int r11 = 0;
    L3:
        if (r11 >= r10) goto L5;
        String r12 = r8[r11];
        this.f7187d.add(r12);
        this.f7188e.add(r12);
        r11 = r11 + 1;
        goto L3
    L5:
        Logger.d("f", "Start httpdns resolve for host : " + this.f7187d);
        String r13 = e.g().f7170m;
        if (e.g().f7171n.size() != 0) goto L9;
        this.f7185b.f7165i.set(0);
    L9:
        if (l6.a.h0(r13) == true) goto L11;
    L17:
        String r14 = null;
    L18:
        if (r14 == null) goto L20;
        b(r14);
        this.f7185b.f7165i.set(0);
    L33:
        Iterator r15 = this.f7187d.iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        String r16 = (String) r15.next();
        this.f7185b.p(r16);
        this.f7185b.n(r16);
        goto L35
    L37:
        Message r17 = Message.obtain();
        r17.obj = this;
        r17.what = 3;
        Bundle r18 = new Bundle();
        r18.putStringArrayList("httpdns_completed_hosts", this.f7188e);
        r17.setData(r18);
        this.f7191h.sendMessage(r17);
        Logger.d("f", "send message to collect result handler for host : " + this.f7188e);
        return null;
    L20:
        Iterator<String> r19 = e.g().f7171n.iterator();
    L22:
        if (r19.hasNext() == false) goto L33;
        String r20 = r19.next();
        if (f7.b.a(r20) == false) goto L26;
    L28:
        String r21 = a(r20);
        if (r21 != null) goto L32;
        StringBuilder r22 = new StringBuilder("httpdns request failed use hardcode ip: ");
        r22.append(r20);
        String r23 = " try next hardcode ip";
    L31:
        r22.append(r23);
        Logger.d("f", r22.toString());
        goto L22
    L32:
        b(r21);
        goto L33
    L26:
        if (f7.b.b(r20) == true) goto L28;
        r22 = new StringBuilder("httpdns backup domian hardcode ip: ");
        r22.append(r20);
        r23 = " is invalid";
        goto L31
    L11:
        if (this.f7185b.f7165i.get() >= 2) goto L17;
        r14 = a(r13);
        if (r14 != null) goto L18;
        d r24 = this.f7185b;
        AtomicInteger r25 = r24.f7165i;
        r25.getAndIncrement();
        if (r25.get() < 2) goto L18;
        Message r26 = Message.obtain();
        r26.what = 20;
        r26.obj = r24;
        r24.f7167k.sendMessageDelayed(r26, 180000);
        goto L18
    }
}
