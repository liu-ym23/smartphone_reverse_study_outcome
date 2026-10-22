package com.obric.cae.smartNfc.omapi;

import android.content.Context;
import android.se.omapi.Reader;
import android.se.omapi.SEService;
import android.se.omapi.Session;
import com.obric.cae.log.CaeLog;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class OmapiManager {
    private static final int CONNECT_TIMEOUT_MS = 2000;
    private static final String TAG = "NFC:OmapiManager";
    private boolean mConnecting;
    private final Context mContext;
    private final Object mLock;
    private SEService mSeService;

    public OmapiManager(Context r8) {
        this.mLock = new Object();
        this.mContext = r8.getApplicationContext();
    }

    private SEService ensureService() {
        Object r8 = this.mLock;
        monitor-enter(r8);
        SEService r10 = this.mSeService;     // Catch: Throwable -> L43
        if (r10 == null) goto L12;
        if (r10.isConnected() == false) goto L12;
        SEService r11 = this.mSeService;     // Catch: Throwable -> L43
        monitor-exit(r8);     // Catch: Throwable -> L43
        return r11;
    L12:
        if (this.mConnecting == false) goto L16;
        SEService r12 = waitForServiceLocked();     // Catch: Throwable -> L43
        monitor-exit(r8);     // Catch: Throwable -> L43
        return r12;
    L16:
        this.mConnecting = true;     // Catch: Throwable -> L43
        monitor-exit(r8);     // Catch: Throwable -> L43
        final CountDownLatch r13 = new CountDownLatch(1);
        i.a r14 = new i.a(4);
        SEService r15 = null;
        SEService r16 = new SEService(this.mContext, r14, new a(r13));     // Catch: Exception -> L34
        r13.await(2000, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L22
    L23:
        Object r17 = this.mLock;
        monitor-enter(r17);
    L31:
        th = move-exception;
        throw th;
    L26:
        if (r16.isConnected() == false) goto L28;
        r15 = r16;
    L28:
        this.mSeService = r15;     // Catch: Throwable -> L31
        this.mConnecting = false;     // Catch: Throwable -> L31
        this.mLock.notifyAll();     // Catch: Throwable -> L31
        SEService r18 = this.mSeService;     // Catch: Throwable -> L31
        monitor-exit(r17);     // Catch: Throwable -> L31
        return r18;
    L22:
        Thread.currentThread().interrupt();
        CaeLog.e(TAG, "SEService wait interrupted");
    L34:
        e = move-exception;
        android.aimedia.a.q("SEService create failed: ", e, TAG);
        monitor-enter(this.mLock);
        this.mConnecting = false;     // Catch: Throwable -> L40
        this.mLock.notifyAll();     // Catch: Throwable -> L40
        return null;
    L40:
        th = move-exception;
        throw th;
    L43:
        th = move-exception;
        throw th;
    }

    private Reader selectEseReader(Reader[] r8) {
        if (r8 != null) goto L4;
        return null;
    L4:
        if (r8.length == 0) goto L22;
        int r10 = r8.length;
        int r11 = 0;
    L7:
        if (r11 >= r10) goto L15;
        Reader r12 = r8[r11];
        String r13 = r12.getName();
        if (r13 == null) goto L13;
        if (r13.toLowerCase().contains("ese") == false) goto L13;
        return r12;
    L13:
        r11 = r11 + 1;
        goto L7
    L15:
        return r8[0];
    L22:
        return null;
    }

    private SEService waitForServiceLocked() {
        long r8 = System.currentTimeMillis();
    L4:
        if (this.mConnecting == false) goto L12;
        if ((System.currentTimeMillis() - r8) >= 2000) goto L12;
        this.mLock.wait(100);     // Catch: InterruptedException -> L10
    L10:
        Thread.currentThread().interrupt();
    L12:
        return this.mSeService;
    }

    public <T> T execute(OmapiAction<T> r8) {
        SEService r10 = ensureService();
        Session r11 = null;
        if (r10 != null) goto L5;
    L39:
        String r12 = "SEService not connected";
    L40:
        CaeLog.e(TAG, r12);
        return null;
    L5:
        if (r10.isConnected() == false) goto L39;
        Reader r13 = selectEseReader(r10.getReaders());
        if (r13 != null) goto L51;
        r12 = "No eSE reader available";
        goto L40
    L51:
        Session r14 = r13.openSession();     // Catch: Throwable -> L22 Exception -> L24
        T r15 = r8.execute(new OmapiSession(r13, r14));     // Catch: Throwable -> L18 Exception -> L20
        if (r14 != null) goto L47;
    L17:
        return r15;
    L47:
        r14.close();     // Catch: Exception -> L15
    L15:
        e = move-exception;
        android.aimedia.a.q("session close error: ", e, TAG);
    L20:
        e = e;
    L26:
        CaeLog.e(TAG, "execute action error: " + e);     // Catch: Throwable -> L18
        if (r14 != null) goto L44;
    L32:
        return null;
    L44:
        r14.close();     // Catch: Exception -> L30
    L30:
        e = move-exception;
        android.aimedia.a.q("session close error: ", e, TAG);
    L18:
        th = th;
        r11 = r14;
    L33:
        if (r11 != null) goto L49;
    L38:
        throw th;
    L49:
        r11.close();     // Catch: Exception -> L36
    L36:
        e = move-exception;
        android.aimedia.a.q("session close error: ", e, TAG);
        goto L38
    L24:
        e = e;
        r14 = null;
    L22:
        th = th;
        goto L33
    }
}
