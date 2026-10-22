package com.bytedance.common.wschannel;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakHandler;

/* JADX INFO: loaded from: classes.dex */
class c implements Application.ActivityLifecycleCallbacks {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static WeakHandler f1293e;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f1294b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InterfaceC0045c f1295c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f1296d;

    static class a implements WeakHandler.IHandler {
        a() {
        }

        @Override // com.bytedance.common.utility.collection.WeakHandler.IHandler
        public void handleMsg(Message r10) {
        }
    }

    class b implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ c f1297c;

        b(c r10) {
            this.f1297c = r10;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (Logger.debug() == false) goto L6;
            Logger.d("WsChannelSdk", "sRunnable AppAlive = " + c.a(this.f1297c));
        L6:
            if (c.a(this.f1297c) == false) goto L11;
            c.b(this.f1297c, false);
            if (c.c(this.f1297c) == null) goto L12;
            c.c(this.f1297c).onEnterToBackground();
            return;
        L12:
            return;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.common.wschannel.c$c, reason: collision with other inner class name */
    public interface InterfaceC0045c {
        void onEnterToBackground();

        void onEnterToForeground();
    }

    static {
        f1293e = new WeakHandler(Looper.getMainLooper(), new a());
    }

    c() {
        this.f1294b = false;
        this.f1296d = new b(this);
    }

    static /* synthetic */ boolean a(c r10) {
        return r10.f1294b;
    }

    static /* synthetic */ boolean b(c r10, boolean r11) {
        r10.f1294b = r11;
        return r11;
    }

    static /* synthetic */ InterfaceC0045c c(c r10) {
        return r10.f1295c;
    }

    public void d(InterfaceC0045c r10) {
        this.f1295c = r10;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity r10) {
        if (this.f1294b == false) goto L6;
        f1293e.postDelayed(this.f1296d, WsConstants.EXIT_DELAY_TIME);
        return;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity r10) {
        if (this.f1294b == true) goto L8;
        this.f1294b = true;
        InterfaceC0045c r11 = this.f1295c;
        if (r11 == null) goto L8;
        r11.onEnterToForeground();
    L8:
        if (Logger.debug() == false) goto L10;
        Logger.d("WsChannelSdk", "onResume sAppAlive = " + this.f1294b);
    L10:
        f1293e.removeCallbacks(this.f1296d);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity r10, Bundle r11) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity r10) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity r10) {
    }
}
