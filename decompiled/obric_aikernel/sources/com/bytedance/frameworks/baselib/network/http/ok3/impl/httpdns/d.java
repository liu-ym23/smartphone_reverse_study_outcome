package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class d implements Callable<Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1742c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f1743g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final a f1744h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final WeakHandler f1745i;

    public d(String r10, a r11, WeakHandler r12) {
        this.f1742c = d.class.getSimpleName();
        this.f1743g = r10;
        this.f1744h = r11;
        this.f1745i = r12;
    }

    public Void a() {
        long r10 = System.currentTimeMillis();
        ArrayList r11 = new ArrayList();
        ArrayList r12 = new ArrayList();
        InetAddress[] r13 = InetAddress.getAllByName(this.f1743g);     // Catch: UnknownHostException -> L24
        int r14 = r13.length;     // Catch: UnknownHostException -> L24
        int r15 = 0;
    L4:
        if (r15 >= r14) goto L16;
        InetAddress r16 = r13[r15];     // Catch: UnknownHostException -> L24
        if ((r16 instanceof Inet4Address) == false) goto L9;
        r11.add(r16.getHostAddress());     // Catch: UnknownHostException -> L24
    L14:
        r15 = r15 + 1;     // Catch: UnknownHostException -> L24
        goto L4
    L9:
        if ((r16 instanceof Inet6Address) == false) goto L12;
        r12.add(r16.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(this.f1742c, "local dns server returned a invalid address: " + r16.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(this.f1742c, "local dns resolved success for host: " + this.f1743g);     // Catch: UnknownHostException -> L24
    L19:
        if (r11.size() <= 0) goto L21;
    L22:
        this.f1744h.f(this.f1743g, new DnsRecord(this.f1743g, System.currentTimeMillis(), r11, r12, b.q().p().get()));     // Catch: UnknownHostException -> L24
    L27:
        if (b.q().s().get() == true) goto L46;
        Message r17 = Message.obtain();
        r17.obj = this;
        r17.what = 1;
        Bundle r18 = new Bundle();
        r18.putString("localdns_completed_host", this.f1743g);
        r17.setData(r18);
        this.f1745i.sendMessage(r17);
        if (Logger.debug() == false) goto L31;
        Logger.d(this.f1742c, "send message to collect result handler for host : " + this.f1743g);
    L31:
        long r19 = System.currentTimeMillis() - r10;
        JSONObject r20 = new JSONObject();     // Catch: JSONException -> L44
        r20.put("host", this.f1743g);     // Catch: JSONException -> L44
        if (r11.size() == 0) goto L36;
    L39:
        r20.put("status", "succeed");     // Catch: JSONException -> L44
        ArrayList r21 = new ArrayList();     // Catch: JSONException -> L44
        r21.addAll(r12);     // Catch: JSONException -> L44
        r21.addAll(r11);     // Catch: JSONException -> L44
        Object r22 = r21;
    L38:
        r20.put("result", r22);     // Catch: JSONException -> L44
        r20.put("rtt", r19);     // Catch: JSONException -> L44
        if (Logger.debug() == false) goto L46;
        Logger.d(this.f1742c, r20.toString());     // Catch: JSONException -> L44
        goto L46
    L36:
        if (r12.size() != 0) goto L39;
        r20.put("status", "failed");     // Catch: JSONException -> L44
        r22 = "";
    L44:
        e = move-exception;
        e.printStackTrace();
    L46:
        this.f1744h.y(this.f1743g);
        return null;
    L21:
        if (r12.size() <= 0) goto L27;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return a();
    }
}
