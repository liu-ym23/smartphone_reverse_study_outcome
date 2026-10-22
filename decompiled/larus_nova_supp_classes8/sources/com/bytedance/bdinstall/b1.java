package com.bytedance.bdinstall;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b1 extends ContentObserver {
    public final /* synthetic */ a1 a;

    public b1(a1 r1, Handler r2) {
        this.a = r1;
        super(r2);
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r6, Uri r7) {
        onChange(r6);
        a1 r8 = this.a;
        monitor-enter(r8);
        String r2 = r7.getQueryParameter("key");     // Catch: Throwable -> L22
        String r3 = r7.getQueryParameter("value");     // Catch: Throwable -> L22
        String r9 = r7.getQueryParameter("aid");     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r2) == false) goto L7;
    L19:
        t.b("multi process: key or value is nullvalue: " + r3 + " aid ：" + r9);     // Catch: Throwable -> L22
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L7:
        if (TextUtils.isEmpty(r3) == true) goto L19;
        ((ConcurrentHashMap) a1.c).put(r2, r3);     // Catch: Throwable -> L22
        t.a("install_info 发送到子进程 onUpdate " + r3 + " aid ：" + r9);     // Catch: Throwable -> L22
        List r0 = (List) ((ConcurrentHashMap) a1.d).get(r2);     // Catch: Throwable -> L22
        if (r0 == null) goto L17;
        Iterator r1 = r0.iterator();     // Catch: Throwable -> L22
    L13:
        if (r1.hasNext() == false) goto L17;
        a1$c r4 = (a1$c) r1.next();     // Catch: Throwable -> L22
        if (r4 == null) goto L13;
        r4.b(r3, r9);     // Catch: Throwable -> L22
    L17:
        monitor-exit(r8);     // Catch: Throwable -> L22
        return;
    L22:
        th = move-exception;
        throw th;
    }
}
