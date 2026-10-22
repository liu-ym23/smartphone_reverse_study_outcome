package com.bytedance.android.live.broadcastgame.xplay.singlecast;

import com.bytedance.android.live.broadcast.api.IBroadcastService;
import com.bytedance.android.live.broadcast.api.IMiddlewareBroadcastService;
import com.bytedance.android.live.broadcast.api.model.t;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.xplay.IXplayCoreService;
import com.bytedance.android.live.broadcastgame.xplay.XplayLog;
import com.bytedance.android.live.broadcastgame.xplay.XplayMonitorSession;
import com.bytedance.android.live.broadcastgame.xplay.q1;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.scope.o;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposables;
import io.reactivex.functions.Action;
import io.reactivex.subjects.PublishSubject;
import k20.e;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class XplayGameCastService implements o, IXplayGameCastService {
    public final CompositeDisposable a;
    public final Lazy b;
    public final p c;
    public final IXplayCoreService d;
    public final e e;
    public final XplayMonitorSession f;
    public final com.bytedance.android.live.broadcastgame.xplay.littlewindow.b g;
    public final com.bytedance.android.live.broadcastgame.xplay.servermergecast.a h;

    public final class GameCastSessionImpl implements IXplayGameCastService.IGameCastSession {
        public final CompositeDisposable a;
        public boolean b;
        public final PublishSubject<IXplayGameCastService.IGameCastSession.Event> c;
        public final Pair<Integer, Integer> d;
        public final /* synthetic */ XplayGameCastService e;

        public static final class a implements Action {
            public final /* synthetic */ GameCastSessionImpl a;

            public a(GameCastSessionImpl r1) {
                this.a = r1;
            }

            public final void run() {
                this.a.stop();
            }
        }

        public final void a() {
            if (this.b == false) goto L7;
            XplayLog.b("XplayGameCastService", "game cast session is already started");
            return;
        L7:
            if (((IBroadcastService) this.e.b.getValue()).isCasting() == false) goto L11;
            XplayLog.b("XplayGameCastService", "broadcast service is casting another stream");
            q1.h(this.e.c, 2131923513, s1.B(2131923507), false, new XplayGameCastService$GameCastSessionImpl$start$1(this));
            return;
        L11:
            if (this.e.a.isDisposed() == false) goto L14;
            XplayLog.b("XplayGameCastService", "service is already disposed");
            return;
        L14:
            XplayLog.c("XplayGameCastService", "starting game cast session");
            RxUtilKt.c(Disposables.fromAction(new a(this)), this.e.a);
            this.e.a.add(this.a);
            this.b = true;
            this.e.d.L().publish();
            t.b r1 = new t.b();
            t r2 = new t();
            XplayGameCastService r4 = this.e;
            new c(r4.g, r4.h);
            r2.a = 1;
            String r0 = this.e.c.h.b;
            Intrinsics.checkNotNullParameter(r0, "<set-?>");
            r2.b = r0;
            String r3 = this.e.c.h.c;
            ((Number) this.d.getFirst()).intValue();
            ((Number) this.d.getSecond()).intValue();
            r2.c = this.e.c.getContext();
            XplayGameCastService r5 = this.e;
            String r6 = r5.c.h.e;
            r2.d = r1;
            ((IBroadcastService) r5.b.getValue()).startCast(r2);
        }

        @Override // com.bytedance.android.live.broadcastgame.xplay.singlecast.IXplayGameCastService.IGameCastSession
        public final void stop() {
            if (this.b == true) goto L5;
            return;
        L5:
            XplayLog.c("XplayGameCastService", "stopping game cast session");
            IMiddlewareBroadcastService.b.b((IBroadcastService) this.e.b.getValue());
            this.a.clear();
            this.e.a.remove(this.a);
            this.b = false;
            this.c.onNext(IXplayGameCastService.IGameCastSession.Event.CastStopped);
        }

        public GameCastSessionImpl(XplayGameCastService r2, Pair<Integer, Integer> r3) {
            Intrinsics.checkNotNullParameter(r3, "streamSize");
            this.e = r2;
            this.d = r3;
            this.a = new CompositeDisposable();
            System.currentTimeMillis();
            this.c = PublishSubject.create();
        }
    }

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    public final void onStop() {
        this.a.dispose();
        XplayMonitorSession r0 = this.f;
        if (r0.b != null) goto L7;
        r0.k(System.currentTimeMillis() - r0.a, 2, null);
        return;
    }

    @Override // com.bytedance.android.live.broadcastgame.xplay.singlecast.IXplayGameCastService
    public final GameCastSessionImpl a(Pair r2) {
        Intrinsics.checkNotNullParameter(r2, "streamSize");
        return new GameCastSessionImpl(this, r2);
    }

    public XplayGameCastService(p r2, IXplayCoreService r3, e r4, XplayMonitorSession r5, com.bytedance.android.live.broadcastgame.xplay.littlewindow.b r6, com.bytedance.android.live.broadcastgame.xplay.servermergecast.a r7) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayCoreService");
        Intrinsics.checkNotNullParameter(r4, "xplayTerminateService");
        Intrinsics.checkNotNullParameter(r5, "monitorSession");
        Intrinsics.checkNotNullParameter(r6, "littleWindowService");
        Intrinsics.checkNotNullParameter(r7, "xplayLittleWindowCastManager");
        this.c = r2;
        this.d = r3;
        this.e = r4;
        this.f = r5;
        this.g = r6;
        this.h = r7;
        this.a = new CompositeDisposable();
        this.b = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, XplayGameCastService$broadcastService$2.INSTANCE);
    }
}
