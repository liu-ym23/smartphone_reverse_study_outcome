package com.bytedance.android.live.broadcastgame.opengame.service;

import am2.x;
import com.bytedance.android.live.broadcastgame.opengame.runtime.PluginContext;
import com.bytedance.android.live.broadcastgame.opengame.runtime.p;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.revlink.api.ILinkService;
import com.bytedance.android.livesdk.log.u;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0002:\u0001\bB\u0011\b\u0007\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackMiniGameService;", "Lcom/bytedance/android/live/broadcastgame/opengame/service/TrackCommonService;", "", "Ly10/a;", "Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;", "pluginContext", "<init>", "(Lcom/bytedance/android/live/broadcastgame/opengame/runtime/PluginContext;)V", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class TrackMiniGameService extends TrackCommonService implements p {
    public static final a g = null;
    public final PluginContext e;
    public final /* synthetic */ i20.a f;

    public static final class a {
        public a() {
        }

        public static /* synthetic */ Map b(String r12, String r13, String r14, String r15, String r16, String r17, Boolean r18, int r19) {
            if ((r19 & 32) == 0) goto L5;
            String r7 = null;
        L7:
            if ((r19 & 64) == 0) goto L9;
            Boolean r8 = null;
        L11:
            return a(r12, r13, r14, r15, r16, r7, r8, null, null, null);
        L9:
            r8 = r18;
            goto L11
        L5:
            r7 = r17;
            goto L7
        }

        public static void c(String r11, boolean r12, String r13, String r14, String r15, String r16, String r17, String r18) {
            Intrinsics.checkNotNullParameter(r11, "roomId");
            Intrinsics.checkNotNullParameter(r13, "anchorId");
            Intrinsics.checkNotNullParameter(r14, "userId");
            Intrinsics.checkNotNullParameter(r15, "gameId");
            Intrinsics.checkNotNullParameter(r16, "gameName");
            Intrinsics.checkNotNullParameter(r17, "gameCategory");
            if (Intrinsics.areEqual(k.n(IInteractService.class).getCurrentSwitchSceneSource(), "accepted_tool_invited") == false) goto L5;
            String r0 = "invited";
        L6:
            String r9 = r0;
            com.bytedance.android.livesdk.log.g r1 = u.l();
            Boolean r7 = Boolean.valueOf(r12);
            boolean r8 = com.bytedance.android.live.revenue.core.util.h.a;
            kc0.e r19 = com.bytedance.android.live.revenue.core.util.h.d(ILinkService.class).getRevLinkControlService();
            if (r19 == null) goto L9;
            Map<String, String> r21 = r19.h();
        L10:
            r1.sendLog("livesdk_game_half_screen_show", a(r13, r14, r15, r16, r17, r11, r7, r18, r9, r21), new Object[]{x.class, Room.class});
            return;
        L9:
            r21 = null;
            goto L10
        L5:
            r0 = "self_start";
            goto L6
        }

        public static Map a(String r2, String r3, String r4, String r5, String r6, String r7, Boolean r8, String r9, String r11, Map r12) {
            Map r13 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("anchor_id", r2), TuplesKt.to("user_id", r3), TuplesKt.to("game_id", r4), TuplesKt.to("game_name", r5), TuplesKt.to("game_category", r6)});
            if (r7 == null) goto L5;
            String r14 = (String) r13.put("room_id", r7);
        L5:
            if (r8 != null) goto L7;
        L11:
            if (r9 == null) goto L13;
            String r15 = (String) r13.put("game_app_id", r9);
        L13:
            if (r11 == null) goto L15;
            String r16 = (String) r13.put("game_anchor_type", r11);
        L15:
            if (r12 == null) goto L17;
            r13.putAll(r12);
        L17:
            return r13;
        L7:
            if (r8.booleanValue() == false) goto L9;
            String r17 = "anchor";
        L10:
            String r18 = (String) r13.put("user_type", r17);
            goto L11
        L9:
            r17 = "audience";
            goto L10
        }
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void fail(String r2) {
        Intrinsics.checkNotNullParameter(r2, "error");
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

    static {
        g = new a();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void start() {
        this.a = System.currentTimeMillis();
        e();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.runtime.p
    public final void stop() {
        d();
        c();
        this.f.b();
    }

    @Override // com.bytedance.android.live.broadcastgame.opengame.service.TrackCommonService
    public final PluginContext b() {
        return this.e;
    }

    public TrackMiniGameService(PluginContext r3) {
        Intrinsics.checkNotNullParameter(r3, "pluginContext");
        super(r3);
        i20.a r0 = new i20.a();
        this.f = r0;
        this.e = r3;
        Disposable r4 = com.bytedance.android.live.broadcastgame.opengame.utils.i.b(xs2.b.a().b(com.bytedance.android.live.broadcastgame.api.openplatform.f.class), new AnonymousClass1(this));
        Intrinsics.checkNotNullParameter(r4, "$this$autoDispose");
        r0.a(r4);
    }

    public static final void f(TrackMiniGameService r3, String r4) {
        r3.getClass();
        com.bytedance.android.livesdk.log.g r0 = u.l();
        Map r5 = (Map) r3.b.getValue();
        r5.put("source", r4);
        Unit r6 = Unit.INSTANCE;
        r0.sendLog("livesdk_small_program_audience_icon_click", r5, new Object[]{Room.class, x.class});
    }
}
