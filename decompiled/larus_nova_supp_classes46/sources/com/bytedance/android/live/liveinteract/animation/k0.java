package com.bytedance.android.live.liveinteract.animation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class k0 {
    public final CopyOnWriteArrayList<f> a;
    public final m b;
    public final HashMap<Integer, Long> c;
    public final Handler d;
    public String e;
    public HashSet<Integer> f;
    public final CopyOnWriteArrayList<c> g;
    public final e h;
    public final InteractAnimationController i;

    public static final class a implements Handler.Callback {
        public final /* synthetic */ k0 a;

        public a(k0 r1) {
            this.a = r1;
        }

        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message r9) {
            Intrinsics.checkNotNullParameter(r9, "msg");
            int r0 = r9.what;
            if ((r0 & 256) != 256) goto L18;
            this.a.getClass();
            int r1 = r0 & 255;
            i.a("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "handleMessage taskType : " + r1 + " time :  " + System.currentTimeMillis());
            f r2 = this.a.b.c(r1);
            if (r2 != null) goto L8;
            return true;
        L8:
            if (this.a.b.a(r1) <= 0) goto L16;
            Handler r3 = this.a.d;
            if (r3 == null) goto L16;
            if (r3.hasMessages(r9.what) == true) goto L16;
            i.a("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "handleMessage taskType : " + r1 + " has more and no");
            Handler r4 = this.a.d;
            if (r4 == null) goto L16;
            r4.sendEmptyMessageDelayed(r9.what, r2.b());
        L16:
            i.a("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "handleMessage execute " + r1 + " task");
            this.a.c(r2);
        L38:
            return true;
        L18:
            if (r0 != 512) goto L38;
            Object r10 = r9.obj;
            if (r10 == null) goto L37;
            f r11 = (f) r10;
            if (this.a.a.contains(r11) == false) goto L38;
            r11.recycle();
            this.a.a.remove(r11);
            if (r11.f() != 2) goto L31;
            if (this.a.b.a(r11.getType()) <= 0) goto L31;
            f r5 = this.a.b.c(r11.getType());
            if (r5 == null) goto L31;
            this.a.c(r5);
        L31:
            if (this.a.b.b() == 0) goto L33;
        L35:
            i.a("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "onAnimationOver recycle task , taskType : " + r11.getType());
            i.a("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "handleMessage recycle task");
            goto L38
        L33:
            if (this.a.a.size() != 0) goto L35;
            k0.a(this.a);
            goto L35
        L37:
            throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.live.liveinteract.animation.IInteractAnimationTask");
        }
    }

    public static final class b {
    }

    public interface c {
        void e(String r1);
    }

    public static final class d implements Runnable {
        public final /* synthetic */ k0 a;
        public final /* synthetic */ f b;

        public d(k0 r1, f r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.b.startAnimation();     // Catch: Throwable -> L4
            this.a.a.add(this.b);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class e extends com.bytedance.android.live.liveinteract.animation.d {
        public final /* synthetic */ k0 a;

        public e(k0 r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.live.liveinteract.animation.g
        public final void b(f r4) {
            Intrinsics.checkNotNullParameter(r4, "task");
            Intrinsics.checkNotNullParameter(r4, "task");
            if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == true) goto L5;
            Handler r0 = this.a.d;
            if (r0 != null) goto L22;
            return;
        L22:
            Intrinsics.checkNotNull(r0);
            Message r1 = r0.obtainMessage(512);
            r1.obj = r4;
            Handler r5 = this.a.d;
            Intrinsics.checkNotNull(r5);
            r5.sendMessage(r1);
            return;
        L5:
            if (this.a.a.contains(r4) == false) goto L24;
            r4.recycle();
            this.a.a.remove(r4);
            if (r4.f() != 2) goto L14;
            if (this.a.b.a(r4.getType()) <= 0) goto L14;
            f r2 = this.a.b.c(r4.getType());
            if (r2 == null) goto L14;
            this.a.c(r2);
        L14:
            if (this.a.b.b() == 0) goto L16;
        L18:
            ALogger.d("InteractAnimation.InteractionAnimationExecutor_" + this.a.e, "onAnimationOver recycle task " + r4.a() + ", taskType : " + r4.getType());
            return;
        L16:
            if (this.a.a.size() != 0) goto L18;
            k0.a(this.a);
            goto L18
        }
    }

    static {
    }

    public k0(InteractAnimationController r3) {
        Intrinsics.checkNotNullParameter(r3, "animationController");
        this.i = r3;
        this.a = new CopyOnWriteArrayList();
        this.b = new m();
        this.c = new HashMap();
        this.e = "";
        this.g = new CopyOnWriteArrayList();
        this.h = new e(this);
        this.d = new Handler(Looper.getMainLooper(), new a(this));
    }

    public static final void a(k0 r3) {
        r3.getClass();
        i.a("InteractAnimation.InteractionAnimationExecutor_" + r3.e, "notifyAllAnimationOver");
        Iterator<c> r0 = r3.g.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        r0.next().e(r3.e);
        goto L4
    }

    public final boolean b(int r3) {
        Iterator<f> r0 = this.a.iterator();
    L4:
        if (r0.hasNext() == false) goto L9;
        if (r0.next().getType() != r3) goto L4;
        return true;
    L9:
        return false;
    }

    public final synchronized void c(f r15) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r15, "task");     // Catch: Throwable -> L59
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L59
        int r12 = r15.f();     // Catch: Throwable -> L59
        if (r12 == 1) goto L43;
        if (r12 == 2) goto L38;
        if (r12 == 3) goto L29;
        if (r12 == 4) goto L14;
    L48:
        if (r15.e(this.i) == true) goto L51;
        monitor-exit(this);
        return;
    L51:
        i.a("InteractAnimation.InteractionAnimationExecutor_" + this.e, "execute task currentTime " + r10);     // Catch: Throwable -> L59
        this.c.put(Integer.valueOf(r15.getType()), Long.valueOf(r10));     // Catch: Throwable -> L59
        r15.d(this.h);     // Catch: Throwable -> L59
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L54;
        r15.startAnimation();     // Catch: Throwable -> L59
        this.a.add(r15);     // Catch: Throwable -> L59
    L57:
        monitor-exit(this);
        return;
    L54:
        Handler r0 = this.d;     // Catch: Throwable -> L59
        if (r0 == null) goto L57;
        r0.post(new d(this, r15));     // Catch: Throwable -> L59
        goto L57
    L14:
        if (r15.b() <= 0) goto L48;
        if (this.c.get(Integer.valueOf(r15.getType())) == null) goto L48;
        Long r1 = this.c.get(Integer.valueOf(r15.getType()));     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L59
        if ((r10 - r1.longValue()) >= r15.b()) goto L48;
        i.a("InteractAnimation.InteractionAnimationExecutor_" + this.e, "execute " + r15.getType() + " task duration is too short so push it to queue");     // Catch: Throwable -> L59
        this.b.d(r15);     // Catch: Throwable -> L59
        Handler r2 = this.d;     // Catch: Throwable -> L59
        if (r2 != null) goto L22;
    L26:
        monitor-exit(this);
        return;
    L22:
        if (r2.hasMessages(r15.getType() | 256) == true) goto L26;
        Handler r3 = this.d;     // Catch: Throwable -> L59
        if (r3 == null) goto L26;
        int r4 = r15.getType() | 256;     // Catch: Throwable -> L59
        long r5 = r15.b();     // Catch: Throwable -> L59
        Long r16 = this.c.get(Integer.valueOf(r15.getType()));     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r16);     // Catch: Throwable -> L59
        r3.sendEmptyMessageDelayed(r4, (r5 + r16.longValue()) - r10);     // Catch: Throwable -> L59
        goto L26
    L29:
        if (r15.b() <= 0) goto L48;
        if (this.c.get(Integer.valueOf(r15.getType())) == null) goto L48;
        Long r6 = this.c.get(Integer.valueOf(r15.getType()));     // Catch: Throwable -> L59
        Intrinsics.checkNotNull(r6);     // Catch: Throwable -> L59
        if ((r10 - r6.longValue()) >= r15.b()) goto L48;
        i.a("InteractAnimation.InteractionAnimationExecutor_" + this.e, "execute " + r15.getType() + " task duration is too short so throw it");     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L38:
        if (b(r15.getType()) == false) goto L48;
        i.a("InteractAnimation.InteractionAnimationExecutor_" + this.e, "same type task is working : " + r15.getType() + " so push it in waitingQueue");     // Catch: Throwable -> L59
        this.b.d(r15);     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L43:
        if (b(r15.getType()) == false) goto L48;
        i.a("InteractAnimation.InteractionAnimationExecutor_" + this.e, "same type task is working : " + r15.getType() + " so throw it");     // Catch: Throwable -> L59
        monitor-exit(this);
        return;
    L59:
        th = move-exception;
        throw th;
    }
}
