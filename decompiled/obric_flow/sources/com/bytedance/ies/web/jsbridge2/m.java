package com.bytedance.ies.web.jsbridge2;

import com.ss.android.ugc.aweme.framework.services.ServiceManager;

/* JADX INFO: loaded from: classes2.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f6297a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6298b;

    public m(int r5) {
        this.f6298b = r5;
        this.f6297a = false;
    }

    public final Object a() {
        if (this.f6297a == false) goto L5;
        return null;
    L5:
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L7:
        if (this.f6297a == false) goto L12;
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    L12:
        b();     // Catch: Throwable -> L10
        this.f6297a = true;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return null;
    }

    public final void b() {
        switch(this.f6298b) {
            case 0: goto L16;
            case 1: goto L12;
            case 2: goto L8;
            default: goto L4;
        };
    L4:
        IJsBridge2Config r5 = (IJsBridge2Config) ServiceManager.a().a(IJsBridge2Config.class);
        if (r5 == null) goto L20;
        r5.getSwitchConfig();
        return;
    L20:
        return;
    L8:
        IJsBridge2Config r10 = (IJsBridge2Config) ServiceManager.a().a(IJsBridge2Config.class);
        if (r10 == null) goto L21;
        r10.getGlobalBridgeInterceptor();
        return;
    L21:
        return;
    L12:
        IJsBridge2Config r11 = (IJsBridge2Config) ServiceManager.a().a(IJsBridge2Config.class);
        if (r11 == null) goto L22;
        r11.getConfigurator();
        return;
    L22:
        return;
    L16:
        IJsBridge2Config r12 = (IJsBridge2Config) ServiceManager.a().a(IJsBridge2Config.class);
        if (r12 == null) goto L23;
        r12.getGlobalCallListener();
        return;
    }
}
