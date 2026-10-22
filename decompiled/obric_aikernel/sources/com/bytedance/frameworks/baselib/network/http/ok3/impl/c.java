package com.bytedance.frameworks.baselib.network.http.ok3.impl;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.bytedance.common.utility.Logger;

/* JADX INFO: loaded from: classes.dex */
public class c implements w2.e.c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f1682c = "c";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private w2.e f1683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private BroadcastReceiver f1684b;

    class a extends BroadcastReceiver {
        a(c r10) {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r10, Intent r11) {
            if (isInitialStickyBroadcast() == false) goto L6;
            return;
        L6:
            if ("android.net.conn.CONNECTIVITY_CHANGE".equals(r11.getAction()) == true) goto L8;
            return;
        L8:
            com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().v();
        }
    }

    static {
    }

    public c() {
        this.f1683a = new w2.e();
        this.f1684b = new a(this);
    }

    private void b(Context r10) {
        if (Logger.debug() == false) goto L6;
        Logger.d(f1682c, "register activity forground and background switch Callback");
    L6:
        if ((r10 instanceof Application) == false) goto L11;
        Application r11 = (Application) r10;
        if (r11 == null) goto L12;
        this.f1683a.e(this);
        r11.registerActivityLifecycleCallbacks(this.f1683a);
        return;
    L12:
        return;
    }

    private void c(Context r10) {
        if (r10 == null) goto L7;
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        r10.registerReceiver(this.f1684b, r11);
        if (Logger.debug() == false) goto L8;
        Logger.d(f1682c, "register network state changed completed");
        return;
    L8:
        return;
    }

    public void a(Context r10) {
        c(r10);
        b(r10);
    }

    @Override // w2.e.c
    public void onEnterToBackground() {
    }

    @Override // w2.e.c
    public void onEnterToForeground() {
        com.bytedance.frameworks.baselib.network.http.ok3.impl.httpdns.b.q().w();
    }
}
