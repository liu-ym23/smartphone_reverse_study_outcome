package k20;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.broadcastgame.api.InteractGameContext;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.f0;
import com.bytedance.android.live.broadcastgame.api.model.h0;
import com.bytedance.android.live.broadcastgame.api.model.i0;
import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayExternalContext;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.l;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.opengame.debug.OpenPlatformBaseDebugger;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.broadcastgame.xplay.XplayInternalContext;
import com.bytedance.android.live.broadcastgame.xplay.XplayMainService;
import com.bytedance.android.live.broadcastgame.xplay.littlewindow.XplayLittleWindowService;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.config.l30;
import com.bytedance.android.livesdk.config.nc1;
import com.bytedance.android.livesdk.config.oc1;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import io.reactivex.disposables.CompositeDisposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class c implements o, k20.a {
    public final CompositeDisposable a;
    public final p b;
    public final XplayInternalContext c;
    public final XplayMainService d;
    public final XplayLittleWindowService e;
    public final com.bytedance.android.live.broadcastgame.xplay.container.b f;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
    }

    @Override // k20.a
    public final void launch() {
        l r0 = this.b.h;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L12;
        m r2 = r1.getRoom();
        if (r2 == null) goto L12;
        Room r3 = (Room) r2.getValue();
        if (r3 == null) goto L12;
        User r4 = r3.getOwner();
        if (r4 == null) goto L12;
        String r5 = r4.getCastSecUid();
        if (r5 == null) goto L12;
    L14:
        if (r5.length() <= 0) goto L16;
        boolean r6 = true;
    L17:
        if (r6 == false) goto L22;
        com.bytedance.android.livesdk.sharedpref.e r7 = com.bytedance.android.livesdk.sharedpref.b.x2;
        List r8 = (List) ((HashMap) r7.getValue()).get(r5);
        if (r8 != null) goto L21;
        r8 = new ArrayList();
    L21:
        oc1.a(r8, new nc1(r0.b, r0.i));
        ((Map) r7.getValue()).put(r5, r8);
        ((Map) r7.getValue()).put(r5, r8);
    L22:
        int r9 = InteractGameLocalStatusUtils.a;
        String r11 = r0.b;
        Intrinsics.checkNotNullParameter(r11, "appId");
        InteractGameLocalStatusUtils.c(OpenPlatformBaseDebugger.APP_ID, r11);
        q0 r12 = this.b.h.l;
        if (r12 == null) goto L25;
        String r13 = r12.c() + "###" + r12.b();
        Intrinsics.checkNotNullParameter(r13, "gameId");
        InteractGameLocalStatusUtils.c("xplay_game_id", r13.toString());
    L25:
        String r14 = String.valueOf(((XplayScene) this.c.getCurrentScene().getValue()).getSceneId());
        Intrinsics.checkNotNullParameter(r14, "liveScene");
        InteractGameLocalStatusUtils.c("live_scene", r14);
        RxUtilKt.c(this.c.getCurrentScene().a().subscribe(d.a), this.a);
        InteractGameLocalStatusUtils.c("open_app_status", String.valueOf(1));
        if (((Boolean) l30.a.getValue()).booleanValue() == false) goto L28;
        boolean r15 = com.bytedance.android.live.revenue.core.util.h.a;
        ((ca0.j) com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class)).notifyLowPriorityDownloadTask(Boolean.FALSE);
    L28:
        StringBuilder r16 = new StringBuilder();
        InteractID r17 = InteractID.SonicMiniGame;
        r16.append(r17.getValue());
        r16.append('_');
        r16.append(this.b.h.c);
        r16.append('_');
        r16.append(this.b.h.d);
        String r18 = r16.toString();
        xs2.b.a().post(new f0(r18, null, true, true, 2));
        this.c.getOpenFeatureBinderId().setValue(r18);
        InteractGameContext.Companion r19 = InteractGameContext.Companion;
        InteractGameContext r21 = r19.getContext();
        if (r21 == null) goto L33;
        n<i0> r22 = r21.getCurrentOpenPlatformAppInfo();
        if (r22 == null) goto L33;
        l r23 = this.b.h;
        i0 r24 = new i0(r23.b, r23.c, r17);
        String r25 = this.b.h.e;
        Intrinsics.checkNotNullParameter(r25, "<set-?>");
        r24.a = r25;
        Unit r26 = Unit.INSTANCE;
        r22.setValue(r24);
    L33:
        InteractGameContext r27 = r19.getContext();
        if (r27 == null) goto L38;
        n<h0.c> r28 = r27.getOpenGameLaunchResult();
        if (r28 == null) goto L38;
        r28.setValue(new h0.e(false, false, true, 3));
    L38:
        InteractGameContext r29 = r19.getContext();
        if (r29 == null) goto L43;
        m<Boolean> r31 = r29.isPlayingGame();
        if (r31 == null) goto L43;
        r31.setValue(Boolean.TRUE);
    L43:
        int r32 = q.a;
        q.f("XplayLaunchService", new Object[]{"on lifecycle: onStart"});
        this.d.c();
        XplayExternalContext r33 = XplayExternalContext.Companion.getContext();
        if (r33 == null) goto L48;
        m<Boolean> r34 = r33.getXplayRunning();
        if (r34 == null) goto L48;
        r34.setValue(Boolean.TRUE);
    L48:
        DataCenter r35 = this.b.i;
        if (r35 == null) goto L51;
        r35.put("xplay_run_status_change", Boolean.TRUE);
    L51:
        com.bytedance.android.live.broadcastgame.xplay.container.b r36 = this.f;
        if (((XplayScene) r36.i.getCurrentScene().getValue()) != XplayScene.Video) goto L54;
        r36.j();
    L54:
        r36.k();
        this.e.i();
        return;
    L16:
        r6 = false;
    L12:
        r5 = "";
        goto L14
    }

    public final void onStop() {
        this.a.clear();
    }

    public c(p r2, XplayInternalContext r3, XplayMainService r4, XplayLittleWindowService r5, com.bytedance.android.live.broadcastgame.xplay.container.b r6) {
        Intrinsics.checkNotNullParameter(r2, "newEnv");
        Intrinsics.checkNotNullParameter(r3, "xplayInternalContext");
        Intrinsics.checkNotNullParameter(r4, "xplayMainService");
        Intrinsics.checkNotNullParameter(r5, "xplayLittleWindowService");
        Intrinsics.checkNotNullParameter(r6, "xplayContainerService");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.a = new CompositeDisposable();
    }
}
