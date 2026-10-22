package com.bytedance.forest.interceptor;

import com.bytedance.forest.model.t;
import com.bytedance.forest.model.w;
import com.bytedance.forest.utils.e;
import com.lynx.tasm.ui.image.f0;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ArrayList f4306a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ArrayList f4307b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Lazy f4308c = null;
    public static final Lazy d = null;

    static {
        f4306a = new ArrayList();
        f4307b = new ArrayList();
        f4308c = LazyKt.lazy(GlobalInterceptor$monitorLocker$2.f4305a);
        d = LazyKt.lazy(GlobalInterceptor$interceptorLocker$2.f4304a);
    }

    public static void a() {
        ReentrantReadWriteLock.ReadLock r5 = ((ReentrantReadWriteLock) d.getValue()).readLock();
        r5.lock();
        ArrayList r10 = f4307b;
        int r11 = r10.size() - 1;     // Catch: Throwable -> L8
    L4:
        if (r11 < 0) goto L5;
    L14:
        th = move-exception;
        f0.i("GlobalInterceptor", "intercept onLoadStart error", th);     // Catch: Throwable -> L8
        r11 = r11 - 1;
        goto L4
    L11:
        if (r10.get(r11) != null) goto L17;
        throw null;     // Catch: Throwable -> L14
    L17:
        throw new ClassCastException();     // Catch: Throwable -> L14
    L5:
        Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L8
        r5.unlock();
        return;
    L8:
        th = move-exception;
        r5.unlock();
        throw th;
    }

    public static void b(a r5) {
        ReentrantReadWriteLock r10 = (ReentrantReadWriteLock) f4308c.getValue();
        ReentrantReadWriteLock.ReadLock r11 = r10.readLock();
        int r12 = 0;
        if (r10.getWriteHoldCount() != 0) goto L5;
        int r13 = r10.getReadHoldCount();
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.unlock();
        r14 = r14 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r15 = r10.writeLock();
        r15.lock();
        f4306a.add(r5);     // Catch: Throwable -> L15
    L11:
        if (r12 >= r13) goto L13;
        r11.lock();
        r12 = r12 + 1;
        goto L11
    L13:
        r15.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r12 >= r13) goto L18;
        r11.lock();
        r12 = r12 + 1;
        goto L16
    L18:
        r15.unlock();
        throw th;
    L5:
        r13 = 0;
        goto L6
    }

    public static void c(w r5, e r10) {
        r5.f4431c.putAll(r10.d);
        ReentrantReadWriteLock.ReadLock r11 = ((ReentrantReadWriteLock) f4308c.getValue()).readLock();
        r11.lock();
        ArrayList r12 = f4306a;
    L11:
        th = move-exception;
        r11.unlock();
        throw th;
    L4:
        int r13 = r12.size() - 1;
    L5:
        if (r13 < 0) goto L13;
        ((a) r12.get(r13)).c(r5);     // Catch: Throwable -> L8
    L10:
        r13 = r13 - 1;     // Catch: Throwable -> L11
    L8:
        th = move-exception;
        f0.i("GlobalInterceptor", "monitor onLoadFinished error", th);     // Catch: Throwable -> L11
        goto L10
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r11.unlock();
    }

    public static void d(String r10, t r11) {
        ReentrantReadWriteLock.ReadLock r5 = ((ReentrantReadWriteLock) f4308c.getValue()).readLock();
        r5.lock();
        ArrayList r12 = f4306a;
    L11:
        th = move-exception;
        r5.unlock();
        throw th;
    L4:
        int r13 = r12.size() - 1;
    L5:
        if (r13 < 0) goto L13;
        ((a) r12.get(r13)).d(r10, r11);     // Catch: Throwable -> L8
    L10:
        r13 = r13 - 1;     // Catch: Throwable -> L11
    L8:
        th = move-exception;
        f0.i("GlobalInterceptor", "monitor onLoadStart error", th);     // Catch: Throwable -> L11
        goto L10
    L13:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L11
        r5.unlock();
    }

    public static void e(a r5) {
        ReentrantReadWriteLock r10 = (ReentrantReadWriteLock) f4308c.getValue();
        ReentrantReadWriteLock.ReadLock r11 = r10.readLock();
        int r12 = 0;
        if (r10.getWriteHoldCount() != 0) goto L5;
        int r13 = r10.getReadHoldCount();
    L6:
        int r14 = 0;
    L7:
        if (r14 >= r13) goto L9;
        r11.unlock();
        r14 = r14 + 1;
        goto L7
    L9:
        ReentrantReadWriteLock.WriteLock r15 = r10.writeLock();
        r15.lock();
        f4306a.remove(r5);     // Catch: Throwable -> L15
    L11:
        if (r12 >= r13) goto L13;
        r11.lock();
        r12 = r12 + 1;
        goto L11
    L13:
        r15.unlock();
        return;
    L15:
        th = move-exception;
    L16:
        if (r12 >= r13) goto L18;
        r11.lock();
        r12 = r12 + 1;
        goto L16
    L18:
        r15.unlock();
        throw th;
    L5:
        r13 = 0;
        goto L6
    }
}
