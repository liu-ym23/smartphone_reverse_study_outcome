package com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.settingmanager;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.i;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import p22.o;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d<V> implements Callable {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        com.bytedance.android.livesdk.sharedpref.e<Integer> r0 = SimpleSettingManager.a;
        AtomicBoolean r1 = SimpleSettingManager.f;
        if (r1.get() == false) goto L6;
        SimpleSettingManager.e(null);
        return;
    L6:
        long r2 = System.currentTimeMillis();
        o r3 = SimpleSettingManager.b();
        r1.set(true);
        long r4 = System.currentTimeMillis() - r2;
        int r5 = i.a;
        i.d("prefetch simple setting done in " + r4 + "ms, setting: " + r3 + ", thread: " + ThreadMethodProxy.currentThread().getName());
        SimpleSettingManager.e(r3);
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
