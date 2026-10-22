package com.ss.android.deviceregister.a;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes6.dex */
final class w<SERVICE, RESULT> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final CountDownLatch f15158a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Intent f15159b;
    private final b<SERVICE, RESULT> c;
    private final Context d;

    class a implements ServiceConnection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        SERVICE f15160a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ w f15161b;
        private final CountDownLatch c;
        private final b<SERVICE, RESULT> d;

        a(w r3, CountDownLatch r4, b<SERVICE, RESULT> r5) {
            b<SERVICE, RESULT> r6 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
            this.f15161b = r3;
            this.c = r4;
            this.d = r6;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r4, IBinder r5) {
            IBinder r6 = (IBinder) ZeusTransformUtils.wrapperContextForParams(r5, IBinder.class, "com.obric.memorydata.plugin");
            com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "ServiceBlockBinder#onServiceConnected " + r4);
            this.f15160a = this.d.b(r6);     // Catch: Throwable -> L8
            this.c.countDown();     // Catch: Exception -> L6
        L18:
            return;
        L6:
            e = move-exception;
            e.printStackTrace();
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "ServiceBlockBinder#onServiceConnected", th);     // Catch: Throwable -> L12
            this.c.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.c.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
            goto L17
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r4) {
            com.ss.android.deviceregister.l.b(com.ss.android.deviceregister.l.f15219a, "ServiceBlockBinder#onServiceDisconnected" + r4);
            this.c.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    interface b<T, RESULT> {
        RESULT a(T r1);

        T b(IBinder r1);
    }

    w(Context r3, Intent r4, b<SERVICE, RESULT> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");
        b<SERVICE, RESULT> r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        this.d = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        this.f15159b = r4;
        this.c = r7;
        this.f15158a = new CountDownLatch(1);
    }

    private void a(w<SERVICE, RESULT>.a r2) {
        if (r2 == null) goto L10;
        ZeusTransformUtils.unbindService(this.d, r2, "com.obric.memorydata.plugin");     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    RESULT a() {
        w<SERVICE, RESULT>.a r1 = new a(this, this.f15158a, this.c);     // Catch: Throwable -> L9
        ZeusTransformUtils.bindService(this.d, this.f15159b, r1, 1, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
        this.f15158a.await();     // Catch: Throwable -> L9
        RESULT r0 = this.c.a(r1.f15160a);     // Catch: Throwable -> L7
        a(r1);
        return r0;
    L7:
        th = th;
    L17:
        th.printStackTrace();     // Catch: Throwable -> L14
        a(r1);
        return null;
    L14:
        th = move-exception;
        a(r1);
        throw th;
    L9:
        th = th;
        r1 = null;
        goto L17
    }
}
