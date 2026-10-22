package com.bytedance.android.livesdk.interactivity.chatchannel.manager;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.gift.IGiftServiceExternal;
import com.bytedance.android.livesdkapi.depend.live.gift.ILiveGiftPlayControllerManager;
import com.bytedance.android.livesdkapi.depend.live.gift.IPlayerActionListener;
import com.bytedance.android.livesdkapi.depend.live.gift.IResultMonitor;
import com.bytedance.android.livesdkapi.depend.live.player.ITextureViewPlayerController;
import com.bytedance.android.livesdkapi.depend.live.player.PlayConfig;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class ChatChannelAnimManager implements com.bytedance.android.livesdk.interactivity.api.b {
    public static final /* synthetic */ int e = 0;
    public final Queue<a> a;
    public a b;
    public final Lazy c;
    public boolean d;

    public static final class a {
        public Disposable a;
        public final b b;
        public final com.bytedance.android.livesdk.interactivity.api.c.a c;

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.ChatChannelAnimManager$a$a, reason: collision with other inner class name */
        public static final class C0104a<T> implements Consumer {
            public final /* synthetic */ a a;
            public final /* synthetic */ Function1 b;

            public C0104a(a r1, Function1 r2) {
                this.a = r1;
                this.b = r2;
            }

            public final void accept(Object r2) {
                Long r3 = (Long) r2;
                SafetyGuard.a(null, null, "channel anim timeout");
                ALogger.e("ChatChannelAnimManager", "anim timeout. params=" + this.a.c);
                this.b.invoke(this.a);
            }
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L10;
            a r4 = (a) r3;
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            b r0 = this.b;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            com.bytedance.android.livesdk.interactivity.api.c.a r4 = this.c;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AnimTask(player=" + this.b + ", params=" + this.c + ")";
        }

        public final void a(Function1<? super a, Unit> r11) {
            Intrinsics.checkNotNullParameter(r11, "timeoutAction");
            this.a = Observable.timer(10, TimeUnit.SECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new C0104a(this, r11));
            b r13 = this.b;
            com.bytedance.android.livesdk.interactivity.api.c.a r0 = this.c;
            r13.getClass();
            Intrinsics.checkNotNullParameter(r0, "params");
            r13.h.getClass();
            ChatChannelAnimManager.e("startPlay " + r0);
            ITextureViewPlayerController r1 = r13.b;
            if (r1 != null) goto L17;
            IGiftServiceExternal r2 = jc1.k.f(IGiftServiceExternal.class);
            ITextureViewPlayerController r3 = null;
            if (r2 == null) goto L18;
            ILiveGiftPlayControllerManager r4 = r2.giftPlayControllerManager();
            if (r4 == null) goto L18;
            Context r5 = r13.e;
            if ((r5 instanceof LifecycleOwner) == true) goto L11;
            r5 = null;
        L11:
            r1 = r4.createTextureViewPlayer((LifecycleOwner) r5);
            if (r1 == null) goto L18;
            r13.b = r1;
            if (com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.e.j == false) goto L16;
            r1.setMonitor(d.a);
        L16:
            r1.setPlayerActionListener(r13.a);
            r1.attachAlphaView(r13.f);
        L18:
            if (r3 != null) goto L20;
            ChatChannelAnimManager.c(r13.h, r13);
            return;
        L20:
            if (r13.c == false) goto L22;
            r13.c = false;
            r13.h.d().removeCallbacks(r13.d);
        L22:
            ITextureViewPlayerController.DefaultImpls.start$default(r3, r0.a, false, false, false, new PlayConfig(r0.c, r0.d), 12, null);
            return;
        L17:
            r3 = r1;
            goto L18
        }

        public a(b r2, com.bytedance.android.livesdk.interactivity.api.c.a r3) {
            Intrinsics.checkNotNullParameter(r2, "player");
            Intrinsics.checkNotNullParameter(r3, "params");
            this.b = r2;
            this.c = r3;
        }
    }

    public final class b implements com.bytedance.android.livesdk.interactivity.api.c {
        public final f a;
        public ITextureViewPlayerController b;
        public boolean c;
        public final RunnableC0105b d;
        public final Context e;
        public final ViewGroup f;
        public final long g;
        public final /* synthetic */ ChatChannelAnimManager h;

        public static final class a implements Runnable {
            public final /* synthetic */ b a;

            public a(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.a.release();     // Catch: Throwable -> L4
                return;
            L4:
                th = move-exception;
                if (RunnableProtector.intercept(th) == false) goto L8;
                return;
            L8:
                throw th;
            }
        }

        /* JADX INFO: renamed from: com.bytedance.android.livesdk.interactivity.chatchannel.manager.ChatChannelAnimManager$b$b, reason: collision with other inner class name */
        public static final class RunnableC0105b implements Runnable {
            public final /* synthetic */ b a;

            public RunnableC0105b(b r1) {
                this.a = r1;
            }

            @Override // java.lang.Runnable
            public final void run() {
                ChatChannelAnimManager r0 = this.a.h;     // Catch: Throwable -> L6
                int r1 = ChatChannelAnimManager.e;     // Catch: Throwable -> L6
                r0.getClass();     // Catch: Throwable -> L6
                ChatChannelAnimManager.e("releaseRunnable");     // Catch: Throwable -> L6
                b r2 = this.a;     // Catch: Throwable -> L6
                ITextureViewPlayerController r3 = r2.b;     // Catch: Throwable -> L6
                if (r3 == null) goto L9;
                r3.detachAlphaView(r2.f);     // Catch: Throwable -> L6
                r3.removePlayerActionListener();     // Catch: Throwable -> L6
                r3.release();     // Catch: Throwable -> L6
                r2.b = null;     // Catch: Throwable -> L6
                return;
            L9:
                return;
            L6:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L13;
                throw th;
            }
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.c
        public final void release() {
            if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L5;
            this.h.d().post(new a(this));
            return;
        L5:
            this.h.getClass();
            ChatChannelAnimManager.e("release " + this);
            if (this.c == false) goto L8;
            this.c = false;
            this.h.d().removeCallbacks(this.d);
        L8:
            ITextureViewPlayerController r0 = this.b;
            if (r0 == null) goto L11;
            r0.detachAlphaView(this.f);
            r0.removePlayerActionListener();
            r0.release();
            this.b = null;
        L11:
            ChatChannelAnimManager.b(this.h, this);
            ChatChannelAnimManager.c(this.h, this);
        }

        @Override // com.bytedance.android.livesdk.interactivity.api.c
        public final void a(com.bytedance.android.livesdk.interactivity.api.c.a r4) {
            Intrinsics.checkNotNullParameter(r4, "params");
            ChatChannelAnimManager r0 = this.h;
            a r1 = new a(this, r4);
            if (r0.d == false) goto L7;
            r0.d().post(new h(r0, r1));
            return;
        }

        public b(ChatChannelAnimManager r2, Context r3, ViewGroup r4, IPlayerActionListener r5, long r6) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            Intrinsics.checkNotNullParameter(r4, "container");
            Intrinsics.checkNotNullParameter(r5, "listener");
            this.h = r2;
            this.e = r3;
            this.f = r4;
            this.g = r6;
            this.a = new f(this, r5);
            this.d = new RunnableC0105b(this);
        }
    }

    public static final class c {
    }

    public static final class d implements IResultMonitor {
        public static final d a = null;

        public d() {
        }

        static {
            a = new d();
        }

        public final void monitor(boolean r2, String r3, int r4, int r5, String r6) {
            ALogger.i("ChatChannelAnimManager", "state=" + r2 + " playerType=" + r3 + " what=" + r4 + " errorInfo=" + r6);
        }
    }

    public static final class e<T> implements Comparator {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }

        @Override // java.util.Comparator
        public final int compare(Object r1, Object r2) {
            return ((a) r2).c.b - ((a) r1).c.b;
        }
    }

    static {
    }

    public final Handler d() {
        return (Handler) this.c.getValue();
    }

    public ChatChannelAnimManager() {
        this.a = new PriorityQueue(8, e.a);
        this.c = LazyKt.lazy(ChatChannelAnimManager$mainHandler$2.INSTANCE);
    }

    public static void e(String r1) {
        ALogger.i("ChatChannelAnimManager", r1);
    }

    public static final void b(ChatChannelAnimManager r2, b r3) {
        if (r2.d == true) goto L6;
        return;
    L6:
        if ((!Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) == false) goto L8;
        r2.d().post(new g(r2, r3));
        return;
    L8:
        Iterator r4 = ((PriorityQueue) r2.a).iterator();
    L10:
        if (r4.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((a) r4.next()).b, r3) == false) goto L10;
        r4.remove();
        goto L10
    }

    public static final void c(ChatChannelAnimManager r3, b r4) {
        a r0 = r3.b;
        Object r1 = null;
        if (r0 == null) goto L11;
        if ((!Intrinsics.areEqual(r0.b, r4)) == false) goto L11;
        StringBuilder r2 = new StringBuilder("tryStartNextTask failed. invoke by another player ");
        r2.append(r4);
        r2.append(". cur is ");
        a r5 = r3.b;
        if (r5 == null) goto L9;
        r1 = r5.b;
    L9:
        r2.append(r1);
        e(r2.toString());
        return;
    L11:
        if (r3.b == null) goto L20;
        e("tryStartNextTask. end cur task");
        a r6 = r3.b;
        if (r6 == null) goto L18;
        Disposable r7 = r6.a;
        if (r7 == null) goto L17;
        r7.dispose();
    L17:
        r6.a = null;
    L18:
        r3.b = null;
    L20:
        if ((!r3.a.isEmpty()) == false) goto L29;
        r3.b = (a) ((PriorityQueue) r3.a).poll();
        StringBuilder r8 = new StringBuilder("startNextTask: ");
        a r9 = r3.b;
        if (r9 == null) goto L24;
        r1 = r9.c;
    L24:
        r8.append(r1);
        e(r8.toString());
        a r10 = r3.b;
        if (r10 == null) goto L30;
        r10.a(new ChatChannelAnimManager$timeoutAction$1(r3));
        return;
    L30:
        return;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.b
    public final b a(Context r9, ViewGroup r10, IPlayerActionListener r11, int r13) {
        Intrinsics.checkNotNullParameter(r9, "activity");
        Intrinsics.checkNotNullParameter(r10, "container");
        Intrinsics.checkNotNullParameter(r11, "listener");
        return new b(this, r9, r10, r11, ((long) Math.max(r13, 1)) * 1000);
    }
}
