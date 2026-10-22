package com.bytedance.android.live.broadcastgame.xplay.servermergecast;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.api.xplay.q;
import com.bytedance.android.live.broadcastgame.api.xplay.r;
import com.bytedance.android.live.broadcastgame.xplay.XplayException;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.scope.o;
import com.bytedance.live.datacontext.j;
import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subjects.PublishSubject;
import jc1.k;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayRTCManager implements o, com.bytedance.android.live.broadcastgame.xplay.servermergecast.b {
    public r a;
    public q b;
    public g c;
    public boolean d;
    public boolean e;
    public Pair<Integer, Integer> f;
    public final PublishSubject<XplayException> g;
    public ei6.a h;
    public final CompositeDisposable i;
    public final long j;
    public final Handler k;
    public final b l;
    public final Lazy m;
    public final p n;
    public final XplayMonitorSession o;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b p;
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a q;

    public static final class a {
    }

    public static final class b implements Runnable {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            IInteractGameService r0 = (IInteractGameService) k.n(IInteractGameService.class);     // Catch: Throwable -> L4
            JSONObject r1 = new JSONObject();     // Catch: Throwable -> L4
            r1.put("wtn_push_stream", "");     // Catch: Throwable -> L4
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L4
            r0.sendGameCastStatusSEI(false, r1);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    static {
    }

    public final void a() {
        this.k.postDelayed(this.l, 1000);
        if (this.d == false) goto L27;
        XplayLog.c("XplayRTCManager", "destroy rtc engine");
        this.d = false;
        ei6.a r1 = this.h;
        if (r1 == null) goto L9;
        gi6.e r2 = r1.getEventManager();
        if (r2 == null) goto L9;
        r2.b(null);
    L9:
        ei6.a r3 = this.h;
        if (r3 == null) goto L14;
        si6.b r4 = r3.b();
        if (r4 == null) goto L14;
        si6.a.b(r4, false, "XplayRTCManager destroyEngine", 3);
    L14:
        RoomContext r5 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r5 == null) goto L21;
        j r6 = r5.getLiveStream();
        if (r6 == null) goto L21;
        com.bytedance.android.live.pushstream.d r7 = (com.bytedance.android.live.pushstream.d) r6.getValue();
        if (r7 == null) goto L21;
        r7.r1();
    L21:
        g r8 = this.c;
        if (r8 == null) goto L24;
        r8.b = false;
    L24:
        if (r8 == null) goto L26;
        r8.g.clear();
    L26:
        this.c = null;
        this.q.d();
    L27:
        this.i.clear();
    }

    public final void onStart() {
        RoomContext r0 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r0 == null) goto L10;
        j r1 = r0.getLiveStream();
        if (r1 == null) goto L11;
        com.bytedance.android.live.pushstream.d r2 = (com.bytedance.android.live.pushstream.d) r1.getValue();
        if (r2 == null) goto L12;
        r2.r1();
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onStop() {
        g r0 = this.c;
        if (r0 == null) goto L5;
        r0.g.clear();
    L5:
        this.i.clear();
    }

    public XplayRTCManager(p r2, XplayMonitorSession r3, com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r4, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r5) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "monitorSession");
        Intrinsics.checkNotNullParameter(r4, "littleWindowService");
        Intrinsics.checkNotNullParameter(r5, "xplayLittleWindowCastManager");
        this.n = r2;
        this.o = r3;
        this.p = r4;
        this.q = r5;
        this.g = PublishSubject.create();
        this.i = new CompositeDisposable();
        this.j = System.currentTimeMillis();
        this.k = new Handler(Looper.getMainLooper());
        this.l = b.a;
        this.m = LazyKt.lazy(new XplayRTCManager$mRtcListener$2(this));
    }
}
