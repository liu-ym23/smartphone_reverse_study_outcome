package com.obric.aikernel.middleware.api.appcontext.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;
import com.obric.aikernel.middleware.api.log.AIKLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.q1;

/* JADX INFO: loaded from: classes2.dex */
public final class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f4540a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f4541b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final List<a> f4542c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final g1<Boolean> f4543d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static long f4544e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final ReentrantLock f4545f = null;

    public interface a {
        void a();

        void b();
    }

    static {
        f4540a = new e();
        f4541b = "ScreenStateListener";
        f4542c = new ArrayList();
        f4543d = q1.a(Boolean.FALSE);
        f4544e = -1;
        f4545f = new ReentrantLock();
    }

    private e() {
    }

    private final void h(boolean r10) {
        ReentrantLock r11 = f4545f;
        r11.lock();
        f4543d.setValue(Boolean.valueOf(r10));     // Catch: Throwable -> L6
        f4544e = SystemClock.elapsedRealtime();     // Catch: Throwable -> L6
        r11.unlock();
        return;
    L6:
        th = move-exception;
        f4545f.unlock();
        throw th;
    }

    public void a(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        List<a> r11 = f4542c;
        monitor-enter(r11);
    L12:
        th = move-exception;
        throw th;
    L5:
        if ((r10 instanceof a) == false) goto L7;
        a r12 = (a) r10;     // Catch: Throwable -> L12
    L8:
        if (r12 == null) goto L10;
        r11.add(r12);     // Catch: Throwable -> L12
    L10:
        monitor-exit(r11);
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final g1<Boolean> b() {
        return f4543d;
    }

    public final void c(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        IntentFilter r11 = new IntentFilter();
        r11.addAction("android.intent.action.SCREEN_ON");
        r11.addAction("android.intent.action.SCREEN_OFF");
        r10.registerReceiver(f4540a, r11);
        PowerManager r12 = (PowerManager) r10.getSystemService("power");
        if (r12 == null) goto L5;
        boolean r13 = r12.isInteractive();
    L6:
        h(r13);
        return;
    L5:
        r13 = false;
        goto L6
    }

    public final boolean d() {
        ReentrantLock r10 = f4545f;
        r10.lock();
        boolean r11 = f4543d.getValue().booleanValue();     // Catch: Throwable -> L6
        r10.unlock();
        return r11;
    L6:
        th = move-exception;
        f4545f.unlock();
        throw th;
    }

    public final long e() {
        ReentrantLock r10 = f4545f;
        r10.lock();
        long r11 = f4544e;     // Catch: Throwable -> L6
        r10.unlock();
        return r11;
    L6:
        th = move-exception;
        f4545f.unlock();
        throw th;
    }

    public void f(Object r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        List<a> r11 = f4542c;
        monitor-enter(r11);
    L11:
        th = move-exception;
        throw th;
    L5:
        if ((r10 instanceof a) == false) goto L7;
        a r12 = (a) r10;     // Catch: Throwable -> L11
    L8:
        TypeIntrinsics.asMutableCollection(r11).remove(r12);     // Catch: Throwable -> L11
        monitor-exit(r11);
        return;
    L7:
        r12 = null;
        goto L8
    }

    public final long g() {
        if (d() == false) goto L6;
        return -1;
    L6:
        if (f4544e >= 0) goto L9;
        return -1;
    L9:
        return SystemClock.elapsedRealtime() - f4544e;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r10, Intent r11) {
        if (r11 == null) goto L4;
        String r12 = r11.getAction();
    L5:
        if (r12 == null) goto L41;
        int r13 = r12.hashCode();
        if (r13 == (-2128145023)) goto L26;
        if (r13 == (-1454123155)) goto L12;
        return;
    L12:
        if (r12.equals("android.intent.action.SCREEN_ON") == false) goto L48;
        AIKLog.INSTANCE.i(f4541b, "on receive screen on.");
        List<a> r14 = f4542c;
        monitor-enter(r14);
        Iterator<T> r15 = r14.iterator();     // Catch: Throwable -> L22
    L17:
        if (r15.hasNext() == false) goto L19;
        ((a) r15.next()).a();     // Catch: Throwable -> L22
        goto L17
    L19:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r14);
        boolean r17 = true;
    L37:
        h(r17);
        return;
    L22:
        th = move-exception;
        throw th;
    L48:
        return;
    L26:
        if (r12.equals("android.intent.action.SCREEN_OFF") == false) goto L51;
        AIKLog.INSTANCE.i(f4541b, "on receive screen off.");
        List<a> r18 = f4542c;
        monitor-enter(r18);
        Iterator<T> r19 = r18.iterator();     // Catch: Throwable -> L38
    L32:
        if (r19.hasNext() == false) goto L34;
        ((a) r19.next()).b();     // Catch: Throwable -> L38
        goto L32
    L34:
        Unit r20 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r18);
        r17 = false;
    L38:
        th = move-exception;
        throw th;
    L51:
        return;
    L41:
        return;
    L4:
        r12 = null;
        goto L5
    }
}
