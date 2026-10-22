package com.bytedance.android.livesdk.chatroom.utils;

import android.os.Handler;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.android.livesdk.utils.z5;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class i {
    public final AtomicInteger a;
    public volatile z5 b;
    public volatile Handler c;
    public Disposable d;
    public long e;

    public static final class a {
    }

    public static final class b implements Runnable {
        public final /* synthetic */ i a;

        public b(i r1, ByteBuffer r2, long r3, long r5) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.getClass();     // Catch: Throwable -> L9
            ILiveWrappedLivePusher.Companion.getClass();     // Catch: Exception -> L7 Throwable -> L9
            ILiveWrappedLivePusher r0 = ILiveWrappedLivePusher.a.b();     // Catch: Exception -> L7 Throwable -> L9
            if (r0 == null) goto L12;
            r0.getZlibCompressUtils();     // Catch: Exception -> L7 Throwable -> L9
        L19:
            return;
        L12:
            return;
        L7:
            ALogger.e("CARNIVAL_MESSAGE", "parse binary data error");     // Catch: Throwable -> L9
            return;
        L9:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L18;
            throw th;
        }
    }

    static {
    }

    public final void b() {
        ALogger.e("CarnivalBinarySeiHandler", "reset. state=" + this.a.get());
        if (this.a.get() == 0) goto L12;
        this.a.set(0);
        z5 r0 = this.b;
        if (r0 == null) goto L7;
        r0.quit();
    L7:
        this.b = null;
        this.c = null;
        Disposable r1 = this.d;
        if (r1 == null) goto L10;
        r1.dispose();
    L10:
        this.d = null;
        return;
    }

    public i(com.bytedance.android.livesdk.interactivity.api.barrage.data.g r2) {
        Intrinsics.checkNotNullParameter(r2, "contourInfo");
        this.a = new AtomicInteger();
    }

    public final void a(ByteBuffer r10) {
        if (r10 != null) goto L4;
        return;
    L4:
        if (r10.remaining() <= 0) goto L35;
        int r0 = this.a.get();
        if (r0 != 0) goto L9;
        this.a.set(1);
        long r1 = System.currentTimeMillis();
        this.b = new z5("CarnivalBinarySeiHandler", ((com.bytedance.android.livesdk.interactivity.api.settings.config.a) r52.s.a.getValue()).threadPriority, new j(this, r1));
        z5 r11 = this.b;
        if (r11 == null) goto L17;
        ThreadMethodProxy.start(r11);
    L17:
        Disposable r12 = this.d;
        if (r12 == null) goto L20;
        r12.dispose();
    L20:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r13 = com.bytedance.android.livesdk.interactivity.api.q.b();
        if (r13 == null) goto L29;
        com.bytedance.live.datacontext.m r14 = r13.isCarnivalStarted();
        if (r14 == null) goto L29;
        Observable r15 = r14.a();
        if (r15 == null) goto L29;
        Observable r16 = r15.observeOn(AndroidSchedulers.mainThread());
        if (r16 == null) goto L29;
        Disposable r17 = r16.subscribe(new k(this));
    L30:
        this.d = r17;
        return;
    L29:
        r17 = null;
        goto L30
    L9:
        if (r0 != 2) goto L36;
        long r5 = this.e;
        long r7 = System.currentTimeMillis();
        this.e = r7;
        Handler r2 = this.c;
        if (r2 == null) goto L33;
        r2.post(new b(this, r10, r5, r7));
        return;
    L33:
        return;
    L36:
        return;
    }
}
