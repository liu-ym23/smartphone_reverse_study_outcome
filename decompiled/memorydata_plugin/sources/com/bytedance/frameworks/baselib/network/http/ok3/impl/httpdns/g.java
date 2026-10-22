package com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns;

import android.os.Bundle;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class g implements Callable<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f2489a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f2490b;
    private final a c;
    private final WeakHandler d;

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Void call() {
        return call2();
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public Void call2() {
        long r0 = System.currentTimeMillis();
        ArrayList r9 = new ArrayList();
        ArrayList r10 = new ArrayList();
        InetAddress[] r2 = InetAddress.getAllByName(this.f2490b);     // Catch: UnknownHostException -> L24
        int r3 = r2.length;     // Catch: UnknownHostException -> L24
        int r4 = 0;
    L4:
        if (r4 >= r3) goto L16;
        InetAddress r5 = r2[r4];     // Catch: UnknownHostException -> L24
        if (ZeusTransformUtils.instanceOf(r5, Inet4Address.class) == false) goto L9;
        r9.add(r5.getHostAddress());     // Catch: UnknownHostException -> L24
    L14:
        r4 = r4 + 1;     // Catch: UnknownHostException -> L24
        goto L4
    L9:
        if (ZeusTransformUtils.instanceOf(r5, Inet6Address.class) == false) goto L12;
        r10.add(r5.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L12:
        if (Logger.debug() == false) goto L14;
        Logger.d(this.f2489a, "local dns server returned a invalid address: " + r5.getHostAddress());     // Catch: UnknownHostException -> L24
        goto L14
    L16:
        if (Logger.debug() == false) goto L19;
        Logger.d(this.f2489a, "local dns resolved success for host: " + this.f2490b);     // Catch: UnknownHostException -> L24
    L19:
        if (r9.size() <= 0) goto L21;
    L22:
        this.c.b(this.f2490b, new DnsRecord(this.f2490b, System.currentTimeMillis(), r9, r10, b.a().b().get()));     // Catch: UnknownHostException -> L24
    L27:
        if (b.a().g().get() == true) goto L46;
        Message r6 = Message.obtain();
        r6.obj = this;
        r6.what = 1;
        Bundle r7 = new Bundle();
        r7.putString("localdns_completed_host", this.f2490b);
        r6.setData(r7);
        this.d.sendMessage(r6);
        if (Logger.debug() == false) goto L31;
        Logger.d(this.f2489a, "send message to collect result handler for host : " + this.f2490b);
    L31:
        long r8 = System.currentTimeMillis() - r0;
        JSONObject r1 = new JSONObject();     // Catch: JSONException -> L44
        r1.put("host", this.f2490b);     // Catch: JSONException -> L44
        if (r9.size() == 0) goto L36;
    L39:
        r1.put("status", "succeed");     // Catch: JSONException -> L44
        ArrayList r11 = new ArrayList();     // Catch: JSONException -> L44
        r11.addAll(r10);     // Catch: JSONException -> L44
        r11.addAll(r9);     // Catch: JSONException -> L44
        Object r12 = r11;
    L38:
        r1.put("result", r12);     // Catch: JSONException -> L44
        r1.put("rtt", r8);     // Catch: JSONException -> L44
        if (Logger.debug() == false) goto L46;
        Logger.d(this.f2489a, r1.toString());     // Catch: JSONException -> L44
        goto L46
    L36:
        if (r10.size() != 0) goto L39;
        r1.put("status", "failed");     // Catch: JSONException -> L44
        r12 = "";
    L44:
        e = move-exception;
        e.printStackTrace();
    L46:
        this.c.h(this.f2490b);
        return null;
    L21:
        if (r10.size() <= 0) goto L27;
    L24:
        e = move-exception;
        e.printStackTrace();
        goto L27
    }
}
