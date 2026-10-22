package com.bytedance.android.live.liveinteract.plantform.widgt.voicelink;

import am2.x;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.liveinteract.api.fulllink.TalkRoomBusinessFullLinkMonitor;
import com.bytedance.android.live.liveinteract.plantform.commonwindow.wm.u;
import com.bytedance.android.live.liveinteract.plantform.utils.TalkRoomLogUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.i0;
import com.bytedance.android.live.liveinteract.plantform.utils.u0;
import com.bytedance.android.livesdk.chatroom.model.interact.v1;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.Widget;
import io.reactivex.functions.Consumer;
import java.util.HashMap;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ MultiLinkVoiceAnchorContainerWidget a;
    public final /* synthetic */ u b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;
    public final /* synthetic */ long f;
    public final /* synthetic */ int g;

    public g(MultiLinkVoiceAnchorContainerWidget r1, u r2, int r3, int r4, int r5, String r6, long r7, int r9) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r7;
        this.g = r9;
    }

    public final void accept(Object r13) {
        com.bytedance.android.live.network.response.e r14 = (com.bytedance.android.live.network.response.e) r13;
        u r0 = this.b;
        if (r0 == null) goto L5;
        r0.c = System.currentTimeMillis();
    L5:
        int r1 = this.c;
        if (r1 != 26) goto L8;
    L9:
        i0 r2 = TalkRoomLogUtils.a;
        TalkRoomLogUtils.q = je0.d.a();
    L10:
        this.a.j = false;
        TalkRoomBusinessFullLinkMonitor r3 = TalkRoomBusinessFullLinkMonitor.a;
        int r4 = this.d;
        int r5 = this.e;
        int r6 = this.c;
        long r7 = this.f;
        r3.getClass();
        TalkRoomBusinessFullLinkMonitor.z0(r4, r5, r6, r7, r14);
        HashMap r8 = new HashMap();
        int r9 = this.d;
        if (r9 == 5) goto L18;
        if (r9 == 9) goto L15;
    L19:
        int r10 = this.e;
        if (r10 == 5) goto L29;
        if (r10 == 9) goto L24;
    L32:
        String r11 = TalkRoomLogUtils.d;
        if (r11 == null) goto L35;
        r8.put("source", r11);
    L35:
        String r12 = u0.i(Integer.valueOf(((v1) r14.data).getUiLayout()), null, Integer.valueOf(((v1) r14.data).getUiLayout()));
        if (r12 != null) goto L38;
        r12 = "normal";
    L38:
        r8.put("layout_type", r12);
        if (r2.a(TalkRoomLogUtils.e) == false) goto L41;
        String r15 = TalkRoomLogUtils.e;
        Intrinsics.checkNotNull(r15);
        r8.put("request_page", r15);
    L42:
        j0.l().sendLog("anchor_switch_room_type", r8, new Object[]{IRoom.class, x.class});
        TalkRoomLogUtils.e = null;
        if (vm2.d.v0() == false) goto L45;
        String r16 = TalkRoomLogUtils.g();
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        TalkRoomLogUtils.j = r16;
        com.bytedance.android.live.liveinteract.plantform.utils.i.e((v1) r14.data, r14.logId);
    L45:
        int r17 = this.a.c;
        int r18 = this.e;
        if (r17 != r18) goto L51;
        if (r18 != 5) goto L51;
        com.bytedance.android.live.liveinteract.voicechat.d.s0.getClass();
        com.bytedance.android.live.liveinteract.voicechat.d r19 = com.bytedance.android.live.liveinteract.voicechat.d.a.a();
        if (r19 == null) goto L51;
        r19.Yi((v1) r14.data, "switchSceneApi", "switch_scene response");
    L51:
        TalkRoomLogUtils.V(((v1) r14.data).getTotalApply(), ((v1) r14.data).getTotalLinked(), this.d);
        ((Widget) this.a).dataCenter.put("data_voice_chat_room_shoot_way", "switch_layout");
        return;
    L41:
        r8.put("request_page", "link_setting_panel");
        goto L42
    L24:
        if (this.c != 61) goto L26;
        f2.b(2131919219, 0);
        r8.put("interact_function", "chorus");
    L27:
        j0.l().sendLog("anchor_ktv_open_success", MapsKt.emptyMap(), new Object[]{IRoom.class, x.class});
        goto L32
    L26:
        f2.b(2131919220, 0);
        r8.put("interact_function", "sing_room");
        goto L27
    L29:
        if (this.d == r10) goto L31;
        f2.b(2131919218, 0);
    L31:
        r8.put("interact_function", "chat_room");
        goto L32
    L15:
        if (this.g != 61) goto L17;
        r8.put("before_function", "chorus");
        goto L19
    L17:
        r8.put("before_function", "sing_room");
        goto L19
    L18:
        r8.put("before_function", "chat_room");
        goto L19
    L8:
        if (r1 != 30) goto L10;
        goto L9
    }
}
