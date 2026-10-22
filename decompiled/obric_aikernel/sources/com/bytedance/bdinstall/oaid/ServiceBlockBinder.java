package com.bytedance.bdinstall.oaid;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import androidx.annotation.Nullable;
import com.bytedance.bdinstall.DrLog;
import java.util.concurrent.CountDownLatch;

/* JADX INFO: loaded from: classes.dex */
final class ServiceBlockBinder<SERVICE, RESULT> {
    private final CountDownLatch latch;
    private final Context mContext;
    private final Intent mIntent;
    private final ServiceBindedListener<SERVICE, RESULT> mListener;

    class Conn implements ServiceConnection {
        private final CountDownLatch latch;
        private final ServiceBindedListener<SERVICE, RESULT> mListener;

        @Nullable
        SERVICE service;
        final /* synthetic */ ServiceBlockBinder this$0;

        Conn(ServiceBlockBinder r10, CountDownLatch r11, ServiceBindedListener<SERVICE, RESULT> r12) {
            this.this$0 = r10;
            this.latch = r11;
            this.mListener = r12;
        }

        @Override // android.content.ServiceConnection
        public void onBindingDied(ComponentName r10) {
        }

        @Override // android.content.ServiceConnection
        public void onNullBinding(ComponentName r10) {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r10, IBinder r11) {
            DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected " + r10);
            this.service = this.mListener.asInterface(r11);     // Catch: Throwable -> L8
            this.latch.countDown();     // Catch: Exception -> L6
        L24:
            return;
        L8:
            th = move-exception;
            th.printStackTrace();     // Catch: Throwable -> L12
            DrLog.d("Oaid#ServiceBlockBinder#onServiceConnected #Throwable " + th);     // Catch: Throwable -> L12
            this.latch.countDown();     // Catch: Exception -> L6
        L12:
            th = move-exception;
            this.latch.countDown();     // Catch: Exception -> L15
        L17:
            throw th;
        L15:
            e = move-exception;
            e.printStackTrace();
        L6:
            e = move-exception;
            e.printStackTrace();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r10) {
            DrLog.d("Oaid#ServiceBlockBinder#onServiceDisconnected" + r10);
            this.latch.countDown();     // Catch: Exception -> L5
            return;
        L5:
            e = move-exception;
            e.printStackTrace();
        }
    }

    interface ServiceBindedListener<T, RESULT> {
        T asInterface(IBinder r10);

        RESULT fetchResult(T r10);
    }

    ServiceBlockBinder(Context r10, Intent r11, ServiceBindedListener<SERVICE, RESULT> r12) {
        this.mContext = r10;
        this.mIntent = r11;
        this.mListener = r12;
        this.latch = new CountDownLatch(1);
    }

    private void release(ServiceBlockBinder<SERVICE, RESULT>.Conn r10) {
        if (r10 == null) goto L10;
        this.mContext.unbindService(r10);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    RESULT blockFetchResult() {
        ServiceBlockBinder<SERVICE, RESULT>.Conn r10 = new Conn(this, this.latch, this.mListener);     // Catch: Throwable -> L12
        if (this.mContext.bindService(this.mIntent, r10, 1) == false) goto L11;
        this.latch.await();     // Catch: Throwable -> L12
        RESULT r11 = this.mListener.fetchResult(r10.service);     // Catch: Throwable -> L9
        release(r10);
        return r11;
    L9:
        th = th;
    L20:
        th.printStackTrace();     // Catch: Throwable -> L17
        release(r10);
    L16:
        return null;
    L17:
        th = move-exception;
        release(r10);
        throw th;
    L11:
        release(null);
    L12:
        th = th;
        r10 = null;
        goto L20
    }
}
