package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.DnsResult;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import okhttp3.p;
import okhttp3.ttnet.TTNetDns;
import okhttp3.ttnet.TTNetDnsResult;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class f implements TTNetDns {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile f f1688b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f1689a;

    static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f1690a = null;

        static {
            int[] r10 = new int[DnsResult.Source.values().length];
            f1690a = r10;
            r10[DnsResult.Source.HTTPDNS_CACHE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L11
        L18:
            f1690a[DnsResult.Source.LOCALDNS_CACHE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L12
        L22:
            f1690a[DnsResult.Source.HTTPDNS_REQUEST.ordinal()] = 3;     // Catch: NoSuchFieldError -> L13
        L30:
            f1690a[DnsResult.Source.LOCALDNS_REQUEST.ordinal()] = 4;     // Catch: NoSuchFieldError -> L14
        L20:
            f1690a[DnsResult.Source.HTTPDNS_STALE_CACHE.ordinal()] = 5;     // Catch: NoSuchFieldError -> L15
        L24:
            f1690a[DnsResult.Source.HARDCODE_IPS.ordinal()] = 6;     // Catch: NoSuchFieldError -> L16
        L26:
            f1690a[DnsResult.Source.UNKNOWN.ordinal()] = 7;     // Catch: NoSuchFieldError -> L17
            return;
        }
    }

    public f() {
        this.f1689a = f.class.getSimpleName();
    }

    private String a(List<InetAddress> r10, DnsResult.Source r11) {
        JSONObject r12 = new JSONObject();
        JSONArray r13 = new JSONArray();     // Catch: Exception -> L31
        Iterator<InetAddress> r14 = r10.iterator();     // Catch: Exception -> L31
    L5:
        if (r14.hasNext() == false) goto L11;
        InetAddress r15 = r14.next();     // Catch: Exception -> L31
        if (r15 == null) goto L5;
        if (TextUtils.isEmpty(r15.getHostAddress()) == true) goto L5;
        r13.put(r15.getHostAddress());     // Catch: Exception -> L31
        goto L5
    L11:
        r12.put("address_list", r13);     // Catch: Exception -> L31
        int r16 = 1;
        if (com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().s().get() == false) goto L14;
        int r17 = 1;
    L15:
        r12.put("httpdns_prefer", r17);     // Catch: Exception -> L31
        TTNetDnsSource r18 = TTNetDnsSource.NOT_SET;     // Catch: Exception -> L31
        TTNetDnsCacheSource r19 = TTNetDnsCacheSource.UNKNOWN;     // Catch: Exception -> L31
        switch(a.f1690a[r11.ordinal()]) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            default: goto L24;
        };     // Catch: Exception -> L31
    L18:
        r18 = TTNetDnsSource.SERVE_FROM_HARDCODE_HOSTS;     // Catch: Exception -> L31
        goto L24
    L19:
        r18 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r19 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
        boolean r20 = true;
    L25:
        r12.put("source", r18.mValue);     // Catch: Exception -> L31
        r12.put("cache_source", r19.mValue);     // Catch: Exception -> L31
        if (r20 == true) goto L29;
        r16 = 0;
    L29:
        r12.put("from_stale_cache", r16);     // Catch: Exception -> L31
    L34:
        return r12.toString();
    L20:
        r18 = TTNetDnsSource.SERVE_FROM_PROC_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L21:
        r18 = TTNetDnsSource.SERVE_FROM_HTTP_DNS_JOB;     // Catch: Exception -> L31
        goto L24
    L22:
        r18 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r19 = TTNetDnsCacheSource.SOURCE_PROC;     // Catch: Exception -> L31
        goto L24
    L23:
        r18 = TTNetDnsSource.SERVE_FROM_CACHE;     // Catch: Exception -> L31
        r19 = TTNetDnsCacheSource.SOURCE_HTTPDNS;     // Catch: Exception -> L31
    L24:
        r20 = false;
        goto L25
    L14:
        r17 = 0;
    L31:
        e = move-exception;
        e.printStackTrace();
        goto L34
    }

    public static f b() {
        if (f1688b != null) goto L15;
        monitor-enter(f.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1688b != null) goto L9;
        f1688b = new f();     // Catch: Throwable -> L11
    L9:
        monitor-exit(f.class);     // Catch: Throwable -> L11
    L15:
        return f1688b;
    }

    @Override // okhttp3.ttnet.TTNetDns
    public TTNetDnsResult lookup(String r10, int r11) {
        if (Logger.debug() == false) goto L5;
        Logger.d(this.f1689a, "lookup address list for " + r10 + " " + r11);
    L5:
        DnsResult r12 = com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().n(r10);
        DnsResult.Source r13 = DnsResult.Source.UNKNOWN;
        List<InetAddress> r14 = new ArrayList();
        if (r12 != null) goto L8;
    L28:
        r14 = p.f12019a.a(r10);     // Catch: UnknownHostException -> L27
        r13 = DnsResult.Source.LOCALDNS_REQUEST;     // Catch: UnknownHostException -> L27
    L26:
        return new TTNetDnsResult(r14, a(r14, r13));
    L8:
        if (r12.ipv4List.isEmpty() == true) goto L10;
    L11:
        Iterator<String> r15 = r12.ipv6List.iterator();
        Iterator<String> r16 = r12.ipv4List.iterator();
    L13:
        if (r15.hasNext() == true) goto L19;
        if (r16.hasNext() == true) goto L19;
        r13 = r12.source;
    L19:
        if (r15.hasNext() == false) goto L22;
        r14.add(InetAddress.getByName(r15.next()));
    L22:
        if (r16.hasNext() == false) goto L13;
        r14.add(InetAddress.getByName(r16.next()));
        goto L13
    L10:
        if (r12.ipv6List.isEmpty() == true) goto L28;
        goto L11
    }
}
