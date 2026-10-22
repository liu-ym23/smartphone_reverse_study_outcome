package com.bytedance.android.live.broadcastgame.opengame.service;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveCloudGameStartParam;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveGameOrientation;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.utils.s;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.live.datacontext.m;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.List;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u0001:\u0001\u0006B\u0011\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/CloudGameService;", "", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "b", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CloudGameService implements y10.a, p {
    public String a;
    public LiveCloudGameStartParam b;
    public final NextLiveData<Runnable> c;
    public final PluginContext d;
    public final /* synthetic */ i20.a e;

    public static final class a<T> implements Observer {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final void onChanged(Object r3) {
            Runnable r4 = (Runnable) r3;
            m10.a.a("CloudGameService", "back call remove");
            if (r4 == null) goto L6;
            r4.run();
            return;
        }
    }

    public static final class b {
    }

    public static final class c implements Runnable {
        public final /* synthetic */ CloudGameService a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;
        public final /* synthetic */ List f;
        public final /* synthetic */ Map g;
        public final /* synthetic */ LiveGameOrientation h;
        public final /* synthetic */ String i;

        public c(CloudGameService r1, String r2, String r3, String r4, String r5, List r6, Map r7, LiveGameOrientation r8, String r9) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
            this.e = r5;
            this.f = r6;
            this.g = r7;
            this.h = r8;
            this.i = r9;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.a(this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i);     // Catch: Throwable -> L4
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

    @Override // y10.a
    public final void g() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void hide() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void l(Map<String, String> r1) {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void launch() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        this.e.b();
        NextLiveData<Runnable> r0 = this.c;
        LifecycleOwner r1 = this.d.getContext();
        if (r1 == null) goto L7;
        r0.removeObservers(r1);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    public CloudGameService(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        this.e = new i20.a();
        this.d = r3;
        this.a = "";
        NextLiveData<Runnable> r0 = new NextLiveData();
        this.c = r0;
        LifecycleOwner r4 = r3.getContext();
        if (r4 == null) goto L7;
        r0.observe(r4, a.a);
        return;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.lifecycle.LifecycleOwner");
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
        Intrinsics.checkNotNullParameter(r2, "error");
    }

    public final void a(String r17, String r18, String r19, String r21, List<? extends Pair<String, ? extends Object>> r22, Map<String, String> r23, LiveGameOrientation r24, String r25) {
        Intrinsics.checkNotNullParameter(r17, "gameName");
        Intrinsics.checkNotNullParameter(r18, "gameIcon");
        Intrinsics.checkNotNullParameter(r19, "gameId");
        Intrinsics.checkNotNullParameter(r21, "channelId");
        Intrinsics.checkNotNullParameter(r24, "gameOrientation");
        Intrinsics.checkNotNullParameter(r25, "roundId");
        if (s.a(this.d.getContext()) == true) goto L6;
        m10.a.a("CloudGameService", "openCloudGame isAppBackground");
        this.c.postValue(new c(this, r17, r18, r19, r21, r22, r23, r24, r25));
        return;
    L6:
        this.a = r19;
        this.b = new LiveCloudGameStartParam(r17, r18, r19, r21, r22, r23, r24);
        IGameCPCloudGameService r0 = k.n(IHostGameCP.class).getCloudGameService();
        if (r0 == null) goto L20;
        Map r1 = r0.createStartParams(r17, r18, r19, r21, r22, r23, r24.getType(), false);
        if (r1 == null) goto L21;
        r1.put("round_id", r25);
        String r5 = null;
        RoomContext r2 = RoomContext.a.c(RoomContext.Companion, null, this.d.m.a, 1);
        if (r2 == null) goto L18;
        m r3 = r2.getRoom();
        if (r3 == null) goto L18;
        Room r4 = (Room) r3.getValue();
        if (r4 == null) goto L18;
        r5 = r4.getOwnerUserIdString();
    L18:
        r1.put("anchor_id", r5);
        r1.put("start_type", "small_game_play");
        return;
    L21:
        return;
    }
}
