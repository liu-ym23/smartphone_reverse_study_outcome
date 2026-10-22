package com.lynx.tasm;

import android.os.SystemClock;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class n implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10919a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10920b;

    public /* synthetic */ n(Object r5, int r10) {
        this.f10919a = r10;
        this.f10920b = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch(this.f10919a) {
            case 0: goto L18;
            default: goto L4;
        };
    L4:
        long r5 = SystemClock.uptimeMillis();
        Iterator r10 = ((List) this.f10920b).iterator();     // Catch: Throwable -> L11
    L7:
        if (r10.hasNext() == false) goto L13;
        a r11 = ((com.lynx.tasm.behavior.a) r10.next()).a();     // Catch: Throwable -> L11
        if (r11 == null) goto L7;
        ((com.bytedance.frameworks.baselib.network.http.cronet.b) r11).b();     // Catch: Throwable -> L11
        goto L7
    L13:
        Log.i("warmClassForBehaviors", "Task0 class warm-up cost:" + (SystemClock.uptimeMillis() - r5));     // Catch: Throwable -> L11
        return;
    L11:
        th = move-exception;
        th.printStackTrace();
        return;
    L18:
        if (((LynxEnv) this.f10920b).mIsNativeLibraryLoaded == false) goto L30;
        LynxEnv.nativeInitUIThread();
        ((LynxEnv) this.f10920b).mIsNativeUIThreadInited = true;
        return;
    }
}
