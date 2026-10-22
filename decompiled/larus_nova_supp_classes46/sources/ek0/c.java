package ek0;

import am2.x;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.setting.b6;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.liveinteract.plantform.base.i;
import com.bytedance.android.live.liveinteract.plantform.model.ILinkPlayerInfoBridge;
import com.bytedance.android.live.liveinteract.voicechat.match.viewmodel.ChatMatchViewModel;
import com.bytedance.android.live.liveinteract.voicechat.match.widget.ChatMatchWidget;
import com.bytedance.android.live.user.IMiddlewareUserService;
import com.bytedance.android.livesdk.chatroom.model.b1;
import com.bytedance.android.livesdk.chatroom.ui.h5;
import com.bytedance.android.livesdk.ktvapi.IKtvService;
import com.bytedance.android.livesdk.log.filter.o;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.eventbus.JumpToOtherRoomEvent;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import nd0.g;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public h5 a;
    public final Context b;
    public final DataCenter c;
    public final ChatMatchViewModel d;

    public final Context getContext() {
        return this.b;
    }

    public static void a(c r12, String r13) {
        Intrinsics.checkNotNullParameter(r13, "jumpType");
        xs2.b.a().post(new hk0.b(true));
        b1 r1 = (b1) r12.d.getMatchData().getValue();
        if (r1 == null) goto L77;
        int r2 = g.a;
        Intrinsics.checkNotNullParameter(r13, "jumpType");
        Intrinsics.checkNotNullParameter(r1, "matchData");
        JSONObject r6 = new JSONObject();
        r6.put("jump_type", r13);
        r6.put("match_room_id", r1.getMatchedRoomId());
        r6.put("match_room_scene", r1.getScene());
        nd0.c.o(nd0.c.a, LinkMonitorData.FastMatchJumpMonitorData, r6, 0, null, false, 28);
        Bundle r0 = new Bundle();
        o r3 = j0.l().c(x.class);
        h5 r5 = null;
        if (r3 == null) goto L9;
        Map r4 = r3.getMap();
        if (r4 == null) goto L9;
        String r7 = (String) r4.get("enter_from_merge");
    L10:
        ChatMatchViewModel r8 = r12.d;
        if (((Boolean) b6.k0.getValue()).booleanValue() == false) goto L13;
        ChatMatchWidget.p = true;
    L34:
        Integer r9 = (Integer) r8.getMatchType().getValue();
        if (r9 != null) goto L38;
    L40:
        String r10 = ChatMatchViewModel.ENTER_METHOD_MATCH;
    L41:
        gk0.a.C0214a r11 = gk0.a.b;
        Integer r14 = (Integer) r8.getMatchType().getValue();
        Boolean r15 = (Boolean) r8.getRematch().getValue();
        r11.getClass();
        r0.putString("match_type", gk0.a.C0214a.b(r14, r15).getValue());
        r0.putString("enter_from_merge", "live_detail");
        r0.putString("enter_method", r10);
        r0.putString("request_id", r1.getRequestId());
        if (r8.isAnchor() == false) goto L45;
        r7 = "live_take_end";
    L45:
        r0.putString("previous_page", r7);
        if (r8.isAnchor() == true) goto L48;
        JumpToOtherRoomEvent r16 = new JumpToOtherRoomEvent(r1.getMatchedRoomId(), "live_detail", r0);
        r16.source = "sourceJumpToOtherChatMatchVm";
        xs2.b.a().post(r16);
        k.n(IKtvService.class).moveOrderedSongToOtherRoom(r1.getMatchedRoomId());
        return;
    L48:
        Bundle r17 = new Bundle();
        r17.putBundle("live.intent.extra.ENTER_LIVE_EXTRA", r0);
        Bundle r18 = new Bundle();
        r18.putBundle("enter_room_data", r17);
        r18.putLong("match_room_id", r1.getMatchedRoomId());
        if (r12.a != null) goto L55;
        Context r19 = r12.b;
        h5.b r20 = new h5.b();
        r20.a = r19;
        r20.b = 2;
        r20.c = 2131565809;
        r20.d = s1.B(2131923563);
        r20.e = s1.B(2131914667);
        r20.f = 17;
        r20.k = false;
        String r110 = s1.B(2131915424);
        a r21 = a.a;
        r20.g = r110;
        r20.h = r21;
        String r111 = s1.B(2131919660);
        b r22 = new b(r12, r18);
        r20.i = r111;
        r20.j = r22;
        Context r112 = r20.a;
        if (r112 == null) goto L54;
        r5 = new h5(r112, r20);
    L54:
        r12.a = r5;
    L55:
        h5 r113 = r12.a;
        if (r113 != null) goto L58;
    L60:
        h5 r114 = r12.a;
        if (r114 != null) goto L63;
        return;
    L63:
        if (DialogLancet.shouldBlockDialogShow(r114) == false) goto L69;
        DialogLancet.handleBlockedDialogShow(r114);
        return;
    L69:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L68
    L66:
        DialogLancet.beforeDialogShow(r114);
        r114.show();
        DialogLancet.afterDialogShow(r114);
        return;
    L58:
        if (r113.isShowing() != true) goto L60;
        return;
    L38:
        if (r9.intValue() != 1) goto L40;
        r10 = ChatMatchViewModel.ENTER_METHOD_SHAKE;
        goto L41
    L13:
        String r23 = k.n(IMiddlewareUserService.class).user().n();
        i<ILinkPlayerInfoBridge> r24 = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter();
        if (r24 == null) goto L16;
        Iterable r25 = r24.getOnlineUserList();
    L17:
        if (r25 == null) goto L30;
        Iterator r26 = r25.iterator();
    L20:
        if (r26.hasNext() == false) goto L30;
        ILinkPlayerInfoBridge r115 = (ILinkPlayerInfoBridge) r26.next();
        if (r115.getUser() == null) goto L20;
        IBaseUser r116 = r115.getUser();
        if (r116 == null) goto L26;
        String r117 = r116.getIdString();
    L28:
        if (Intrinsics.areEqual(r117, r23) == false) goto L20;
        boolean r27 = true;
    L31:
        if (r27 == false) goto L33;
        String r28 = ChatMatchWidget.o;
        ChatMatchWidget.p = ((IInteractService) k.n(IInteractService.class)).getLinkUserInfoCenter().b5(k.n(IMiddlewareUserService.class).user().n());
        goto L34
    L33:
        ChatMatchWidget.p = true;
        goto L34
    L26:
        r117 = null;
    L30:
        r27 = false;
        goto L31
    L16:
        r25 = null;
    L9:
        r7 = null;
        goto L10
    }

    public c(Context r2, DataCenter r3, ChatMatchViewModel r4) {
        Intrinsics.checkNotNullParameter(r4, "vm");
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
