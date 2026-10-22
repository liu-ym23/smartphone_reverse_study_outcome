package com.bytedance.common.wschannel.channel.a.a;

import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.h;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Response;

/* JADX INFO: loaded from: classes.dex */
class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<String> f2077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.bytedance.common.wschannel.channel.a.a.a.b f2078b;
    private int c;
    private String d;

    d(List<String> r3, com.bytedance.common.wschannel.channel.a.a.a.b r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        com.bytedance.common.wschannel.channel.a.a.a.b r6 = (com.bytedance.common.wschannel.channel.a.a.a.b) ZeusTransformUtils.wrapperContextForParams(r4, com.bytedance.common.wschannel.channel.a.a.a.b.class, "com.obric.memorydata.plugin");
        this.c = 0;
        ArrayList r0 = new ArrayList();
        this.f2077a = r0;
        if (r5 == null) goto L5;
        r0.addAll(r5);
    L5:
        Logger.d("WsChannelSdk_ok", "urls : " + r0);
        this.f2078b = r6;
        b();
    }

    synchronized Pair<String, Long> a(Response r6) {
        monitor-enter(this);
        String r0 = c();     // Catch: Throwable -> L11
        long r1 = this.f2078b.a(r6);     // Catch: Throwable -> L11
        if (r1 != (-1)) goto L8;
        this.f2078b.c();     // Catch: Throwable -> L11
        r0 = a();     // Catch: Throwable -> L11
        if (TextUtils.isEmpty(r0) == true) goto L8;
        r1 = this.f2078b.b();     // Catch: Throwable -> L11
    L8:
        Pair<String, Long> r7 = new Pair(r0, Long.valueOf(r1));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r7;
    L11:
        th = move-exception;
        throw th;
    }

    synchronized String a() {
        monitor-enter(this);
        int r0 = this.c + 1;     // Catch: Throwable -> L11
        this.c = r0;     // Catch: Throwable -> L11
        if (this.f2077a.size() <= r0) goto L9;
        String r1 = (String) ZeusTransformUtils.preCheckCast(this.f2077a.get(r0), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
        this.d = r1;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r1;
    L9:
        monitor-exit(this);
        return "";
    L11:
        th = move-exception;
        throw th;
    }

    synchronized void b() {
        monitor-enter(this);
        this.f2078b.c();     // Catch: Throwable -> L6
        this.d = null;     // Catch: Throwable -> L6
        this.c = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized String c() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (h.a(this.d) == false) goto L8;
        int r0 = this.f2077a.size();     // Catch: Throwable -> L11
        int r1 = this.c;     // Catch: Throwable -> L11
        if (r0 <= r1) goto L8;
        this.d = (String) ZeusTransformUtils.preCheckCast(this.f2077a.get(r1), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
    L8:
        String r2 = this.d;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r2;
    }
}
