package com.suite.lark.platform.component.widget.floatingpanel.impl;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.ss.android.lark.maintab.export.TabAppInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class e {
    public final ReentrantLock a;
    public boolean b;
    public final Map<String, b> c;
    public final c d;

    public static final class a {
    }

    public interface b {
        void a();
    }

    public static final class c extends Handler {
        public final /* synthetic */ e a;

        @Override // android.os.Handler
        public final void handleMessage(Message r5) {
            Intrinsics.checkNotNullParameter(r5, "msg");
            e r0 = this.a;
            ReentrantLock r1 = r0.a;
            r1.lock();
        L23:
            th = move-exception;
            r1.unlock();
            throw th;
        L4:
            if (r0.b == false) goto L9;
            r1.unlock();
            return;
        L9:
            if (r5.what == 1) goto L12;
            r1.unlock();
            return;
        L12:
            Object r6 = r5.obj;     // Catch: Throwable -> L23
            if ((r6 instanceof String) == false) goto L16;
            String r7 = (String) r6;     // Catch: Throwable -> L23
        L17:
            if (r7 != null) goto L20;
            r1.unlock();
            return;
        L20:
            e.a(r0, r7);     // Catch: Throwable -> L23
            Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L23
            r1.unlock();
            return;
        L16:
            r7 = null;
            goto L17
        }

        public c(e r1, Looper r2) {
            this.a = r1;
            super(r2);
        }
    }

    static {
    }

    public e() {
        this.a = new ReentrantLock();
        this.c = new LinkedHashMap();
        this.d = new c(this, Looper.getMainLooper());
    }

    public final void b(String r4) {
        Intrinsics.checkNotNullParameter(r4, TabAppInfo.IMAGE_JSON_KEY);
        ReentrantLock r0 = this.a;
        r0.lock();
        this.d.removeMessages(1, r4);     // Catch: Throwable -> L6
        this.c.remove(r4);     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public static final void a(e r2, String r3) {
        ReentrantLock r0 = r2.a;
        r0.lock();
        r2.c.containsKey(r3);     // Catch: Throwable -> L9
        b r4 = (b) ((LinkedHashMap) r2.c).get(r3);     // Catch: Throwable -> L9
        if (r4 != null) goto L6;
        r0.unlock();
        return;
    L6:
        r4.a();     // Catch: Throwable -> L9
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L9
        r0.unlock();
        return;
    L9:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public final void c(String r6, long r7, b r9) {
        Intrinsics.checkNotNullParameter(r6, TabAppInfo.IMAGE_JSON_KEY);
        Intrinsics.checkNotNullParameter(r9, "listener");
        ReentrantLock r0 = this.a;
        r0.lock();
    L15:
        th = move-exception;
        r0.unlock();
        throw th;
    L4:
        if (this.b == false) goto L7;
        r0.unlock();
        return;
    L7:
        this.d.removeMessages(1, r6);     // Catch: Throwable -> L15
        this.c.remove(r6);     // Catch: Throwable -> L15
        if (r7 > 0) goto L12;
        r9.a();     // Catch: Throwable -> L15
        r0.unlock();
        return;
    L12:
        this.c.put(r6, r9);     // Catch: Throwable -> L15
        Message r8 = this.d.obtainMessage(1, r6);     // Catch: Throwable -> L15
        this.d.sendMessageDelayed(r8, r7);     // Catch: Throwable -> L15
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r0.unlock();
    }
}
