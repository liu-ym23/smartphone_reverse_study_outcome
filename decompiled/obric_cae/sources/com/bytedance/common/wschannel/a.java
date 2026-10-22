package com.bytedance.common.wschannel;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static a f3868b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WsChannelMultiProcessSharedProvider.b f3869a;

    public a(Context r8) {
        Context r10 = r8.getApplicationContext();
        String r11 = WsChannelMultiProcessSharedProvider.f3854n;
        monitor-enter(WsChannelMultiProcessSharedProvider.class);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (WsChannelMultiProcessSharedProvider.f3859s != null) goto L7;
        WsChannelMultiProcessSharedProvider.f3859s = new WsChannelMultiProcessSharedProvider.b(r10);     // Catch: Throwable -> L11
    L7:
        WsChannelMultiProcessSharedProvider.b r12 = WsChannelMultiProcessSharedProvider.f3859s;     // Catch: Throwable -> L11
        monitor-exit(WsChannelMultiProcessSharedProvider.class);
        this.f3869a = r12;
    }

    public static a a(Context r8) {
        if (f3868b != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f3868b != null) goto L9;
        f3868b = new a(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f3868b;
    }

    public final void b(String r8) {
        WsChannelMultiProcessSharedProvider.a r10 = new WsChannelMultiProcessSharedProvider.a(this.f3869a.f3865a);
        r10.f3864b.put(WsConstants.KEY_WS_APPS, r8);
        monitor-enter(r10);
        monitor-enter(r10);     // Catch: Throwable -> L9
        r10.f3863a.getContentResolver().insert(WsChannelMultiProcessSharedProvider.a(r10.f3863a, "key", "type"), r10.f3864b);     // Catch: Throwable -> L12
    L6:
        monitor-exit(r10);     // Catch: Throwable -> L9
        monitor-exit(r10);
        return;
    L9:
        th = move-exception;
        throw th;
    }
}
