package j30;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonObject;
import gd0.v;
import java.util.Iterator;
import java.util.Map;
import jc1.k;
import kc0.n;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d extends com.bytedance.android.live.browser.jsbridge.state.b<JsonObject> {
    public final DataCenter c;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final Object b() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("link_audience_state", (Number) ((ge1.a) hd0.c.f()).b);
        boolean r1 = k.n(IRoomService.class).isRecording();
        int r2 = 1;
        if (r1 != true) goto L5;
        int r3 = 1;
    L7:
        r0.addProperty("is_recording", Integer.valueOf(r3));
        lc0.c r4 = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal();
        r0.addProperty("channel_id", Long.valueOf(r4.getChannelId()));
        r0.addProperty("pk_id", Long.valueOf(r4.getPkId()));
        r0.addProperty("pk_time", Long.valueOf(r4.getDuration()));
        r0.addProperty("right_user_id", r4.a());
        r0.addProperty("match_type", Integer.valueOf(r4.getMatchType()));
        int r5 = UserListInviteType.a;
        lc0.a r6 = null;
        r0.addProperty("invitee_list", UserListInviteType.a(r4.getInviteType(), null));
        r0.addProperty("connection_type", k.n(IInteractService.class).getLinkConnectionType());
        r0.addProperty("anchor_connect_status", ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getLinkAnchorCount());
        r0.addProperty("is_double_pk", Boolean.valueOf(v.a(k.n(IInteractService.class).getLinkMode(), 4)));
        ILinkServiceExternal r7 = (ILinkServiceExternal) k.f(ILinkServiceExternal.class);
        if (r7 == null) goto L10;
        r6 = r7.getControlService();
    L10:
        if (r6 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        r0.addProperty("is_matching", Boolean.valueOf(r8));
        if (r6 == null) goto L18;
        int r9 = r6.getMixStreamType();
    L19:
        r0.addProperty("rev_mix_type", Integer.valueOf(r9));
        if (r6 == null) goto L27;
        Map<String, String> r11 = r6.e();
        if (r11 == null) goto L27;
        Iterator<Map.Entry<String, String>> r12 = r11.entrySet().iterator();
    L25:
        if (r12.hasNext() == false) goto L27;
        Map.Entry<String, String> r13 = r12.next();
        r0.addProperty(r13.getKey(), r13.getValue());
    L27:
        n r14 = ((ILinkServiceExternal) k.n(ILinkServiceExternal.class)).getMultiAnchorServiceExternal().i();
        if (r14 != null) goto L30;
    L32:
        r0.addProperty("is_multi_pk", Boolean.FALSE);
    L33:
        Boolean r15 = (Boolean) this.c.get("data_is_anchor", Boolean.FALSE);
        int r16 = k.n(IInteractService.class).getCurUILayout();
        r0.addProperty("link_mode", (Number) this.c.get("data_link_state", 0));
        r0.addProperty("scene", Integer.valueOf(k.n(IInteractService.class).getCurrentScene()));
        r0.addProperty("function_type", k.n(IInteractService.class).getCurrentFunctionType());
        r0.addProperty("self_in_video_talk", Integer.valueOf(k.n(IInteractService.class).getVideoTalkService().u(r15.booleanValue(), k.n(IUserService.class).user().n()) ? 1 : 0));
        Integer r17 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r17 != null) goto L37;
    L40:
        r0.addProperty("is_ktv_guest", Integer.valueOf(r2));
        com.bytedance.android.livesdk.sharedpref.e r18 = com.bytedance.android.livesdk.sharedpref.c.v1;
        boolean r19 = ((Boolean) r18.getValue()).booleanValue();
        String r21 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        if (r19 == false) goto L43;
        String r22 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L44:
        r0.addProperty("video_talk_admin_operate", r22);
        if (((Boolean) r18.getValue()).booleanValue() == false) goto L47;
        String r23 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L48:
        r0.addProperty("audio_chat_admin_operate", r23);
        if (((Boolean) r18.getValue()).booleanValue() == true) goto L52;
        r21 = "0";
    L52:
        r0.addProperty("intimate_chat_admin_operate", r21);
        r0.addProperty("ui_layout", Integer.valueOf(r16));
        return r0;
    L47:
        r23 = "0";
        goto L48
    L43:
        r22 = "0";
        goto L44
    L37:
        if (r17.intValue() != 0) goto L40;
        r2 = 0;
        goto L40
    L30:
        if (r14.isMultiPk() != true) goto L32;
        JsonObject r24 = new JsonObject();
        r24.addProperty("battle_mode", Integer.valueOf(r14.getCurrentPkMode()));
        r0.add("multi_pk", r24);
        r0.addProperty("is_multi_pk", Boolean.TRUE);
        goto L33
    L18:
        r9 = 0;
        goto L19
    L12:
        if (r6.i() != true) goto L14;
        r8 = true;
        goto L15
    L5:
        if (r1 == true) goto L55;
        r3 = 0;
        goto L7
    L55:
        throw new NoWhenBranchMatchedException();
    }

    @Override // com.bytedance.android.live.browser.jsbridge.state.a
    public final com.bytedance.android.live.browser.jsbridge.i.f d() {
        return com.bytedance.android.live.browser.jsbridge.i.g.f.b;
    }

    public d(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.c = r2;
    }
}
