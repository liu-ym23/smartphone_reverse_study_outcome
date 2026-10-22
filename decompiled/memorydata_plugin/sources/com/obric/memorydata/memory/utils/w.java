package com.obric.memorydata.memory.utils;

import android.os.SystemClock;
import android.view.View;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000bJ\u0016\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0010J\u000e\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000bJ\u000e\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000bJ\u0012\u0010\u0018\u001a\u00020\u0013*\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/obric/memorydata/memory/utils/TouchEnhanceUtil;", "", "<init>", "()V", "TAG", "", "lastLongPressDownTime", "", "LONG_PRESS_THROTTLE_MS", "currentLongPressHolder", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "currentTouchHolder", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "tryAcquireTouchLock", "", "view", "releaseTouchLock", "", "tryAcquireLongPressLock", "isActionDown", "releaseLongPressLock", "isLongPressHolder", "setEnhancedTouchListener", "listener", "Lcom/obric/memorydata/memory/utils/EnhancedTouchListener;", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w f11568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f11569b;
    private static volatile WeakReference<View> c;
    private static volatile WeakReference<View> d;
    private static final ReentrantLock e = null;

    static {
        f11568a = new w();
        e = new ReentrantLock();
    }

    private w() {
    }

    private static final boolean a(c r1, View r2) {
        w r0 = f11568a;
        Intrinsics.checkNotNull(r2);
        if (r0.d(r2) == false) goto L5;
        r1.a(true);
        return r1.a(r2, r1.a());
    L5:
        return false;
    }

    /* JADX INFO: renamed from: lambda$4TrJ1dDVHhPBABR-qMXsXJSfV-E, reason: not valid java name */
    public static /* synthetic */ boolean m998lambda$4TrJ1dDVHhPBABRqMXsXJSfVE(c r0, View r1) {
        return a(r0, r1);
    }

    public final void a(View r1, final c r2) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "listener");
        r1.setOnTouchListener(r2.b());
        r1.setOnLongClickListener(new $$Lambda$w$4TrJ1dDVHhPBABRqMXsXJSfVE(r2));
    }

    public final boolean a(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Lock r3 = (Lock) ZeusTransformUtils.preCheckCast(e, Lock.class, "com.obric.memorydata.plugin");
        r3.lock();
        WeakReference<View> r0 = d;     // Catch: Throwable -> L15
        if (r0 == null) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
    L7:
        boolean r2 = true;
        if (Intrinsics.areEqual(r1, r4) == true) goto L13;
        if (r1 == null) goto L12;
        r2 = false;
        goto L13
    L12:
        d = new WeakReference(r4);     // Catch: Throwable -> L15
    L13:
        r3.unlock();
        return r2;
    L6:
        r1 = null;
    L15:
        th = move-exception;
        r3.unlock();
        throw th;
    }

    public final boolean a(View r10, boolean r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Lock r9 = (Lock) ZeusTransformUtils.preCheckCast(e, Lock.class, "com.obric.memorydata.plugin");
        r9.lock();
        long r2 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L20
        WeakReference<View> r0 = c;     // Catch: Throwable -> L20
        if (r0 == null) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
    L7:
        boolean r5 = true;
        if (Intrinsics.areEqual(r1, r10) == true) goto L18;
        if (r1 == null) goto L12;
    L11:
        r5 = false;
        goto L18
    L12:
        c = null;     // Catch: Throwable -> L20
        if (r11 == false) goto L11;
        if ((r2 - f11569b) < 300) goto L11;
        f11569b = r2;     // Catch: Throwable -> L20
        c = new WeakReference(r10);     // Catch: Throwable -> L20
    L18:
        r9.unlock();
        return r5;
    L6:
        r1 = null;
    L20:
        th = move-exception;
        r9.unlock();
        throw th;
    }

    public final void b(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Lock r4 = (Lock) ZeusTransformUtils.preCheckCast(e, Lock.class, "com.obric.memorydata.plugin");
        r4.lock();
        WeakReference<View> r0 = d;     // Catch: Throwable -> L13
        if (r0 == null) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (Intrinsics.areEqual(r1, r5) == false) goto L10;
        d = null;     // Catch: Throwable -> L13
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r4.unlock();
        return;
    L6:
        r1 = null;
    L13:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    public final void c(View r5) {
        Intrinsics.checkNotNullParameter(r5, "view");
        Lock r4 = (Lock) ZeusTransformUtils.preCheckCast(e, Lock.class, "com.obric.memorydata.plugin");
        r4.lock();
        WeakReference<View> r0 = c;     // Catch: Throwable -> L13
        if (r0 == null) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
    L8:
        if (Intrinsics.areEqual(r1, r5) == false) goto L10;
        c = null;     // Catch: Throwable -> L13
    L10:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L13
        r4.unlock();
        return;
    L6:
        r1 = null;
    L13:
        th = move-exception;
        r4.unlock();
        throw th;
    }

    public final boolean d(View r4) {
        Intrinsics.checkNotNullParameter(r4, "view");
        Lock r3 = (Lock) ZeusTransformUtils.preCheckCast(e, Lock.class, "com.obric.memorydata.plugin");
        r3.lock();
        WeakReference<View> r0 = c;     // Catch: Throwable -> L10
        if (r0 == null) goto L6;
        View r1 = (View) ZeusTransformUtils.preCheckCast(r0.get(), View.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
    L7:
        boolean r5 = Intrinsics.areEqual(r1, r4);     // Catch: Throwable -> L10
        r3.unlock();
        return r5;
    L6:
        r1 = null;
    L10:
        th = move-exception;
        r3.unlock();
        throw th;
    }
}
