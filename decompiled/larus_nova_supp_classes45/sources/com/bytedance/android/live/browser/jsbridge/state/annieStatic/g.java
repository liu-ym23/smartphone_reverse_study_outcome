package com.bytedance.android.live.browser.jsbridge.state.annieStatic;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.link.ILinkServiceExternal;
import com.bytedance.android.live.link.constants.UserListInviteType;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.room.IRoomService;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import gd0.v;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements com.bytedance.android.annie.api.data.subscribe.g<JsonObject> {
    public final DataCenter a;

    public static final class a {
    }

    static {
    }

    public final /* synthetic */ JsonElement a(String r1) {
        return com.bytedance.android.annie.api.data.subscribe.f.a(this, r1);
    }

    public final /* synthetic */ com.bytedance.android.annie.api.data.subscribe.g c() {
        return com.bytedance.android.annie.api.data.subscribe.f.e(this);
    }

    public final /* synthetic */ char d() {
        return '.';
    }

    public final /* synthetic */ JsonElement e(String r1, String r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.b(this, r1, r2);
    }

    public final /* synthetic */ JsonElement f(String r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.c(this, r1, r2);
    }

    public final /* synthetic */ JsonElement h(List r1, JsonElement r2) {
        return com.bytedance.android.annie.api.data.subscribe.f.d(r1, r2);
    }

    public final Object g() {
        JsonObject r0 = new JsonObject();
        r0.addProperty("link_audience_state", (Number) ((ge1.a) hd0.c.f()).b);
        boolean r1 = jc1.k.n(IRoomService.class).isRecording();
        int r2 = 1;
        if (r1 != true) goto L5;
        int r3 = 1;
    L7:
        r0.addProperty("is_recording", Integer.valueOf(r3));
        lc0.c r4 = ((ILinkServiceExternal) jc1.k.n(ILinkServiceExternal.class)).getMultiDataHolderExternal();
        r0.addProperty("channel_id", Long.valueOf(r4.getChannelId()));
        r0.addProperty("pk_id", Long.valueOf(r4.getPkId()));
        r0.addProperty("pk_time", Long.valueOf(r4.getDuration()));
        r0.addProperty("right_user_id", r4.a());
        r0.addProperty("match_type", Integer.valueOf(r4.getMatchType()));
        int r5 = UserListInviteType.a;
        lc0.a r6 = null;
        r0.addProperty("invitee_list", UserListInviteType.a(r4.getInviteType(), null));
        r0.addProperty("connection_type", jc1.k.n(IInteractService.class).getLinkConnectionType());
        r0.addProperty("is_double_pk", Boolean.valueOf(v.a(jc1.k.n(IInteractService.class).getLinkMode(), 4)));
        ILinkServiceExternal r7 = (ILinkServiceExternal) jc1.k.f(ILinkServiceExternal.class);
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
        Boolean r14 = (Boolean) this.a.get("data_is_anchor", Boolean.FALSE);
        r0.addProperty("link_mode", (Number) this.a.get("data_link_state", 0));
        r0.addProperty("scene", Integer.valueOf(jc1.k.n(IInteractService.class).getCurrentScene()));
        r0.addProperty("function_type", jc1.k.n(IInteractService.class).getCurrentFunctionType());
        r0.addProperty("self_in_video_talk", Integer.valueOf(jc1.k.n(IInteractService.class).getVideoTalkService().u(r14.booleanValue(), jc1.k.n(IUserService.class).user().n()) ? 1 : 0));
        Integer r15 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r15 != null) goto L31;
    L34:
        r0.addProperty("is_ktv_guest", Integer.valueOf(r2));
        com.bytedance.android.livesdk.sharedpref.e r16 = com.bytedance.android.livesdk.sharedpref.c.v1;
        boolean r17 = ((Boolean) r16.getValue()).booleanValue();
        String r18 = GamePromoteDataContext.GAME_TYPE_MOBILE;
        if (r17 == false) goto L37;
        String r19 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L38:
        r0.addProperty("video_talk_admin_operate", r19);
        if (((Boolean) r16.getValue()).booleanValue() == false) goto L41;
        String r21 = GamePromoteDataContext.GAME_TYPE_MOBILE;
    L42:
        r0.addProperty("audio_chat_admin_operate", r21);
        if (((Boolean) r16.getValue()).booleanValue() == true) goto L46;
        r18 = "0";
    L46:
        r0.addProperty("intimate_chat_admin_operate", r18);
        return r0;
    L41:
        r21 = "0";
        goto L42
    L37:
        r19 = "0";
        goto L38
    L31:
        if (r15.intValue() != 0) goto L34;
        r2 = 0;
        goto L34
    L18:
        r9 = 0;
        goto L19
    L12:
        if (r6.i() != true) goto L14;
        r8 = true;
        goto L15
    L5:
        if (r1 == true) goto L49;
        r3 = 0;
        goto L7
    L49:
        throw new NoWhenBranchMatchedException();
    }

    public final String key() {
        com.bytedance.android.live.browser.jsbridge.i.g.f r0 = com.bytedance.android.live.browser.jsbridge.i.g.f.b;
        return "linkmic";
    }

    public g(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.a = r2;
    }
}
