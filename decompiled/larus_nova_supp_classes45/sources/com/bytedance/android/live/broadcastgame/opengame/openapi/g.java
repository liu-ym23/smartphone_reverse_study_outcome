package com.bytedance.android.live.broadcastgame.opengame.openapi;

import com.bytedance.android.live.broadcastgame.opengame.cloudgame.api.LiveCloudGameApi;
import com.bytedance.android.live.broadcastgame.opengame.cloudgame.model.LiveCloudGameSceneType;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.service.CloudGameService;
import com.bytedance.android.livehostapi.business.IHostGameCP;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.IGameCPCloudGameService;
import com.bytedance.android.livehostapi.business.depend.gamecp.cloudgame.LiveCloudGameStartParam;
import com.bytedance.ies.web.jsbridge2.CallContext;
import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g extends BaseOpenMethod<JSONObject> {
    public final g0 h;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ g a;
        public final /* synthetic */ LiveCloudGameSceneType b;

        public b(g r1, LiveCloudGameSceneType r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r9) {
            com.bytedance.android.live.network.response.e r11 = (com.bytedance.android.live.network.response.e) r9;
            CloudGameService r12 = (CloudGameService) this.a.d.o(CloudGameService.class);
            if (this.b != LiveCloudGameSceneType.TIME_LIMITED) goto L5;
            boolean r0 = true;
        L6:
            IGameCPCloudGameService r2 = jc1.k.n(IHostGameCP.class).getCloudGameService();
            if (r2 == null) goto L10;
            r2.setTrackValue(r12.d.m.a, r12.a, "isFreeUser", Boolean.valueOf(r0));
            return;
        L10:
            return;
        L5:
            r0 = false;
            goto L6
        }
    }

    public static final class c<T> implements Consumer {
        public static final c a = null;

        static {
            a = new c();
        }

        public c() {
        }

        public final void accept(Object r3) {
            int r0 = com.bytedance.android.live.broadcastgame.opengame.q.a;
            com.bytedance.android.live.broadcastgame.opengame.q.i((Throwable) r3, "ChangeSceneMethod", "Change scene failed.");
        }
    }

    static {
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public final String getMethodName() {
        return "changeScene";
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public void call2(JSONObject r19, CallContext r21) {
        Intrinsics.checkNotNullParameter(r19, "params");
        Intrinsics.checkNotNullParameter(r21, "context");
        LiveCloudGameStartParam r2 = ((CloudGameService) this.d.o(CloudGameService.class)).b;
        if (r2 != null) goto L6;
        int r1 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.g("Change scene failed, LiveCloudGameStartParam() is null.", "ChangeSceneMethod");
        return;
    L6:
        LiveCloudGameSceneType.a r4 = LiveCloudGameSceneType.Companion;
        List r5 = r2.getExtra2Game();
        r4.getClass();
        String r6 = null;
        if (r5 == null) goto L18;
        Iterator r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L14;
        Object r8 = r7.next();
        if (Intrinsics.areEqual((String) ((Pair) r8).getFirst(), "prefer") == false) goto L10;
    L15:
        Pair r9 = (Pair) r8;
        if (r9 == null) goto L18;
        Object r11 = r9.getSecond();
    L19:
        String r12 = String.valueOf(r11);
        LiveCloudGameSceneType[] r13 = LiveCloudGameSceneType.values();
        int r14 = r13.length;
        int r15 = 0;
    L20:
        if (r15 >= r14) goto L25;
        LiveCloudGameSceneType r16 = r13[r15];
        if (Intrinsics.areEqual(r16.getExtra2Game(), r12) == true) goto L26;
        r15 = r15 + 1;
    L26:
        if (r16 != null) goto L28;
        r16 = LiveCloudGameSceneType.TIME_UNLIMITED;
    L28:
        LiveCloudGameSceneType.a r17 = LiveCloudGameSceneType.Companion;
        int r18 = r19.optInt("scene");
        r17.getClass();
        Intrinsics.checkNotNullParameter(this, "$this$getSceneTypeByScene");
        LiveCloudGameSceneType[] r22 = LiveCloudGameSceneType.values();
        int r23 = r22.length;
        int r24 = 0;
    L29:
        if (r24 >= r23) goto L37;
        LiveCloudGameSceneType r110 = r22[r24];
        if (r110.getScene() != r18) goto L33;
        boolean r111 = true;
    L34:
        if (r111 == true) goto L38;
        r24 = r24 + 1;
    L38:
        if (r110 != null) goto L40;
        r110 = LiveCloudGameSceneType.TIME_UNLIMITED;
    L40:
        String r25 = "";
        String r3 = r19.optString("roundId", "");
        LiveCloudGameSceneType r26 = LiveCloudGameSceneType.TIME_LIMITED;
        if (r110 != r26) goto L43;
    L46:
        CloudGameService r27 = (CloudGameService) this.d.o(CloudGameService.class);
        Intrinsics.checkNotNullParameter(r3, "roundId");
        IGameCPCloudGameService r112 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r112 == null) goto L49;
        r112.setTrackValue(r27.d.m.a, r27.a, "roundId", r3);
    L49:
        if (r16 == r26) goto L51;
    L74:
        j(((LiveCloudGameApi) com.bytedance.android.live.network.c.b().e(LiveCloudGameApi.class)).switchSceneRequest(r16.getScene(), r110.getScene(), this.h.a, r2.getGameId()).subscribe(new b(this, r110), c.a));
        return;
    L51:
        if (r110 != LiveCloudGameSceneType.TIME_UNLIMITED) goto L74;
        CloudGameService r28 = (CloudGameService) this.d.o(CloudGameService.class);
        IGameCPCloudGameService r29 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r29 == null) goto L60;
        long r31 = r28.d.m.a;
        LiveCloudGameStartParam r32 = r28.b;
        if (r32 == null) goto L58;
        String r33 = r32.getGameId();
        if (r33 == null) goto L58;
    L59:
        r6 = (String) r29.getTrackParams(r31, r33, "roundId");
    L58:
        r33 = "";
    L60:
        IGameCPCloudGameService r113 = jc1.k.n(IHostGameCP.class).getCloudGameService();
        if (r113 == null) goto L74;
        long r114 = r28.d.m.a;
        LiveCloudGameStartParam r34 = r28.b;
        if (r34 == null) goto L68;
        String r35 = r34.getGameId();
        if (r35 == null) goto L68;
        String r115 = r35;
    L70:
        if (r6 == null) goto L73;
        r25 = r6;
    L73:
        r113.trackEvent(r114, r115, "livesdk_cloud_game_switch", MapsKt.mapOf(TuplesKt.to("round_id", r25)));
    L68:
        r115 = "";
        goto L70
    L43:
        if (r110 == LiveCloudGameSceneType.TIME_UNLIMITED) goto L46;
        int r36 = com.bytedance.android.live.broadcastgame.opengame.q.a;
        com.bytedance.android.live.broadcastgame.opengame.q.g("参数错误, scene=" + r110, "ChangeSceneMethod");
        return;
    L33:
        r111 = false;
        goto L34
    L37:
        r110 = null;
        goto L38
    L25:
        r16 = null;
        goto L26
    L14:
        r8 = null;
    L18:
        r11 = null;
        goto L19
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.openapi.BaseOpenMethod
    public /* bridge */ /* synthetic */ void call(JSONObject r1, CallContext r2) {
        call2(r1, r2);
    }

    public g(PluginContext r2, g0 r3, Queue<Long> r4) {
        Intrinsics.checkNotNullParameter(r2, "pluginContext");
        Intrinsics.checkNotNullParameter(r3, "openApi");
        super(r2, r4);
        this.h = r3;
    }
}
