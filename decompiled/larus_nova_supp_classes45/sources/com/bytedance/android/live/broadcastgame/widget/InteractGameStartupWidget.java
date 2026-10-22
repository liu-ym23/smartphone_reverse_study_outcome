package com.bytedance.android.live.broadcastgame.widget;

import android.content.Context;
import com.bytedance.android.live.broadcastgame.InteractGameService;
import com.bytedance.android.live.broadcastgame.api.e;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameService;
import com.bytedance.android.live.broadcastgame.api.interactgame.InteractGameLocalStatusUtils;
import com.bytedance.android.live.broadcastgame.api.model.InteractID;
import com.bytedance.android.live.broadcastgame.api.model.g;
import com.bytedance.android.live.broadcastgame.api.model.q0;
import com.bytedance.android.live.broadcastgame.api.model.r;
import com.bytedance.android.live.broadcastgame.api.model.u;
import com.bytedance.android.live.broadcastgame.api.xplay.XplayScene;
import com.bytedance.android.live.broadcastgame.api.xplay.l;
import com.bytedance.android.live.broadcastgame.api.xplay.m;
import com.bytedance.android.live.broadcastgame.api.xplay.n;
import com.bytedance.android.live.broadcastgame.api.xplay.p;
import com.bytedance.android.live.broadcastgame.opengame.q;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.z;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import i10.f;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import jc1.k;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/widget/InteractGameStartupWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "a", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class InteractGameStartupWidget extends LiveRecyclableWidget implements Observer<KVData> {
    public static final /* synthetic */ int c = 0;

    @Inject
    public e a;
    public final com.bytedance.android.live.broadcastgame.api.openplatform.b b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onInit(Object[] r1) {
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onUnload() {
        ((Widget) this).dataCenter.removeObserver("cmd_dismiss_dialog_end", this);
        ((Widget) this).dataCenter.removeObserver("cmd_interact_game_startup", this);
    }

    public InteractGameStartupWidget(com.bytedance.android.live.broadcastgame.api.openplatform.b r1) {
        this.b = r1;
        InteractGameService.Companion.getClass();
        f r2 = (f) InteractGameService.access$getDiComponent$cp();
        r2.getClass();
        this.a = (e) r2.a.b.get();
    }

    public final void onChanged(Object r12) {
        KVData r13 = (KVData) r12;
        String r0 = null;
        if (r13 == null) goto L5;
        String r1 = r13.getKey();
    L6:
        if (r1 != null) goto L9;
        return;
    L9:
        if (r1.hashCode() == (-484116140)) goto L12;
        return;
    L12:
        if (r1.equals("cmd_interact_game_startup") == false) goto L25;
        int r2 = q.a;
        q.f("InteractGameStartupWidget", new Object[]{"receive startup cmd"});
        final u r6 = (u) r13.getData();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.c() == null) goto L18;
    L20:
        Object[] r14 = new Object[6];
        r14[0] = "interact id: ";
        r14[1] = Integer.valueOf(r6.interactId);
        r14[2] = ", name: ";
        r14[3] = r6.name;
        r14[4] = ", appid: ";
        r r3 = r6.c();
        if (r3 == null) goto L23;
        r0 = r3.b();
    L23:
        r14[5] = r0;
        q.f("InteractGameStartupWidget", r14);
        ((IInteractGameService) k.n(IInteractGameService.class)).tryGetSwitchGameConfirmDialog(r6, ((Widget) this).context, ((Widget) this).dataCenter, new InteractGameStartupWidget$onChanged$$inlined$let$lambda$1(this, r6), InteractGameStartupWidget$onChanged$1$2.INSTANCE);
        return;
    L18:
        if (r6.interactId == InteractID.Blinked.getValue()) goto L20;
        q.f("InteractGameStartupWidget", new Object[]{"gameExtra is null, can't start game"});
        f2.b(2131916768, 0);
        return;
    L25:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget
    public final void onLoad(Object[] r5) {
        ((Widget) this).dataCenter.observe("cmd_dismiss_dialog_end", this);
        ((Widget) this).dataCenter.observe("cmd_interact_game_startup", this);
        int r6 = InteractGameLocalStatusUtils.a;
        long r0 = ((Number) ((Widget) this).dataCenter.get("data_room_id", 0L)).longValue();
        InteractGameLocalStatusUtils.c("last_room_id", String.valueOf(((ConcurrentHashMap) com.bytedance.android.livesdk.sharedpref.b.w2.getValue()).get("room_id")));
        InteractGameLocalStatusUtils.c("room_id", String.valueOf(r0));
    }

    public final void wq(u r22) {
        if (Intrinsics.areEqual(r22.i, "invite") == false) goto L28;
        r r2 = r22.c();
        if (r2 == null) goto L10;
        String r3 = r2.C();
        if (r3 == null) goto L10;
        String r11 = r3;
    L12:
        if (r22.iconUrl.isEmpty() == false) goto L14;
        String r4 = "";
    L15:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r6 = this.b;
        if (r6 == null) goto L56;
        r r7 = r22.c();
        if (r7 == null) goto L20;
        long r8 = r7.p();
    L21:
        r r9 = r22.c();
        if (r9 == null) goto L25;
        String r12 = r9.b();
        if (r12 == null) goto L25;
    L26:
        Boolean r5 = Boolean.FALSE;
        r6.i(r8, r12, r11, MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("game", r22), TuplesKt.to("OPEN_APP_ICON_URL", r4), TuplesKt.to("is_support_single_game_cast", r5), TuplesKt.to("auto_cast_game", r5), TuplesKt.to("listener", r22.h), TuplesKt.to("launch_from", r22.i)}), false, false);
        return;
    L25:
        r12 = "";
        goto L26
    L20:
        r8 = 0;
        goto L21
    L56:
        return;
    L14:
        r4 = (String) ListProtector.get(r22.iconUrl, 0);
    L10:
        r11 = "";
        goto L12
    L28:
        if (r22.e == false) goto L52;
        r r13 = r22.c();
        if (r13 == null) goto L34;
        g r14 = r13.n();
        if (r14 == null) goto L34;
        q0 r15 = r14.b();
    L35:
        if (r15 == null) goto L52;
        Context r16 = ((Widget) this).context;
        long r17 = z.o(((Widget) this).dataCenter).getRoomId();
        String r18 = z.o(((Widget) this).dataCenter).getAnchorId();
        boolean r19 = z.e(((Widget) this).dataCenter, false);
        String r110 = k.n(IUserService.class).user().n();
        IInteractService r21 = k.f(IInteractService.class);
        if (r21 != null) goto L39;
    L41:
        boolean r23 = false;
    L42:
        if (r23 == false) goto L44;
        XplayScene r24 = XplayScene.TalkRoom;
    L45:
        XplayScene r111 = r24;
        l r112 = m.a(r22);
        DataCenter r113 = ((Widget) this).dataCenter;
        IInteractService r1 = k.f(IInteractService.class);
        if (r1 != null) goto L48;
    L50:
        boolean r114 = false;
    L51:
        n.b.j(new p(r16, r17, r18, r19, r110, r111, null, r112, r113, null, null, r114, false, 5696));
        ((Widget) this).dataCenter.put("cmd_live_toolbarmore_dialog_dismiss", 0);
        return;
    L48:
        if (r1.isTalkRoomLoaded() != true) goto L50;
        r114 = true;
        goto L51
    L44:
        r24 = XplayScene.Video;
        goto L45
    L39:
        if (r21.isTalkRoomLoaded() != true) goto L41;
        r23 = true;
    L34:
        r15 = null;
    L52:
        com.bytedance.android.live.broadcastgame.api.openplatform.b r25 = this.b;
        if (r25 == null) goto L59;
        r25.e(r22);
        return;
    }
}
