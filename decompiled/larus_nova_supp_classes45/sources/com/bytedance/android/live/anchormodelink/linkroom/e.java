package com.bytedance.android.live.anchormodelink.linkroom;

import android.content.Context;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.anchormodelink.impl.AnchorModeLinkDynamicWidget;
import com.bytedance.android.live.anchormodelink.util.JsbParamParseUtil;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.core.utils.FileUtils;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.liveinteract.jsbridge.method.k;
import com.bytedance.android.live.liveinteract.plantform.permission.checker.s;
import com.bytedance.android.live.liveinteract.plantform.permission.model.OperateType;
import com.bytedance.android.live.liveinteract.videotalk.dialog.InteractBeautyPreviewDialog;
import com.bytedance.android.live.room.IMiddlewareRoomService;
import com.bytedance.android.livehostapi.business.IMiddlewareHostSocial;
import com.bytedance.android.livesdk.chatroom.InteractionWidgetsPosContext;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ly.u;
import qh0.f;
import qh0.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class e {
    public InteractBeautyPreviewDialog a;
    public oy.d b;
    public final Function1<String, Boolean> c;
    public final Context d;
    public final DataCenter e;
    public final com.bytedance.android.live.anchormodelink.gift.d f;
    public final u g;

    public final void a(my.c r11, final k r12) {
        Intrinsics.checkNotNullParameter(r11, "updateStatus");
        Intrinsics.checkNotNullParameter(r12, "updateCallback");
        int r0 = b.a[r11.getType().ordinal()];
        if (r0 == 1) goto L80;
        int r2 = 2;
        if (r0 != 2) goto L7;
        JsonObject r13 = r11.b;
        if (r13 == null) goto L75;
        JsonElement r14 = r13.get("permission_type");
        if (r14 == null) goto L75;
        String r15 = r14.getAsString();
        if (r15 == null) goto L75;
    L76:
        Context r1 = this.d;
        boolean r16 = Intrinsics.areEqual(r15, FileUtils.VIDEO);
        OperateType r3 = OperateType.APPLY;
        if (r16 == false) goto L79;
        r2 = 1;
    L79:
        ArrayList r17 = new ArrayList();
        r17.add(g.a(r3, r2));
        r17.add(new f.g(r1, r3, r2));
        r17.add(new f.c(r1, r3, r2));
        r17.add(new f.a(r1));
        r17.add(new f.f(r1, r3, r2, true));
        r17.add(new f.e(r1, r3));
        s r18 = f.a(r17);
        boolean r4 = iy.b.a;
        iy.b.d("[LinkBasicJsbHandler] checkPermission linkType=" + r2);
        r18.a(new c(r2, r12));
        return;
    L75:
        r15 = "audio";
        goto L76
    L7:
        if (r0 != 3) goto L9;
        boolean r5 = iy.b.a;
        iy.b.d("[LinkBasicJsbHandler] sendPrivateInvite:" + r11.b);
        JsonObject r19 = r11.b;
        if (r19 == null) goto L68;
        final String r6 = r19.get("action").getAsString();
        final boolean r7 = r19.get("needPush").getAsBoolean();
        User r110 = (User) GsonHelper.getDefault().fromJson(r19.get("friend").getAsJsonObject(), User.class);     // Catch: Exception -> L66
        iy.b.d("[LinkBasicJsbHandler] sendPrivateInvite user:{" + r110.getIdString() + "--" + r110.getNickName() + '}');     // Catch: Exception -> L66
        IMiddlewareHostSocial r8 = jc1.k.f(IMiddlewareHostSocial.class);     // Catch: Exception -> L66
        if (r8 == null) goto L64;
        r8.inviteFriendByIM(this.d, r110, new LinkBasicJsbHandler$sendPrivateInvite$$inlined$let$lambda$1(r7, r6, this, r12));     // Catch: Exception -> L66
    L64:
        r12.a(1, "success", null);     // Catch: Exception -> L66
        return;
    L66:
        e = move-exception;
        boolean r9 = iy.b.a;
        iy.b.b("[LinkBasicJsbHandler] sendPrivateInvite parse user error:" + e.getMessage());
    L68:
        r12.a(0, "fail", null);
        return;
    L9:
        if (r0 != 4) goto L92;
        int r21 = JsbParamParseUtil.a;
        JsonObject r111 = r11.b;
        if (r111 != null) goto L86;
    L28:
        oy.d r112 = null;
    L29:
        this.b = r112;
        boolean r22 = iy.b.a;
        iy.b.d("[LinkBasicJsbHandler] layoutDidChange publicScreenInfo=" + r112);
        if (r112 == null) goto L57;
        float r23 = r112.b;
        float r24 = 0;
        if (r23 <= r24) goto L36;
        int r25 = (int) r23;
        DataCenter r26 = this.e;
        if (r26 == null) goto L39;
        r26.put("data_common_talk_room_match_screen", Integer.valueOf(r25));
    L39:
        float r113 = r112.a;
        if (r113 <= r24) goto L49;
        float r114 = UtilityKotlinExtentionsKt.h(r113);
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r27 = InteractionWidgetsPosContext.a.a();
        if (r27 == null) goto L46;
        m r28 = r27.getAudioTalkRadioPublicScreenTopMargin();
        if (r28 == null) goto L46;
        r28.setValue(Integer.valueOf((int) r114));
    L46:
        DataCenter r115 = this.e;
        if (r115 == null) goto L57;
        r115.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME start"));
        goto L57
    L49:
        InteractionWidgetsPosContext.Companion.getClass();
        InteractionWidgetsPosContext r116 = InteractionWidgetsPosContext.a.a();
        if (r116 == null) goto L54;
        m r117 = r116.getAudioTalkRadioPublicScreenTopMargin();
        if (r117 == null) goto L54;
        r117.setValue(0);
    L54:
        DataCenter r118 = this.e;
        if (r118 == null) goto L57;
        r118.put("cmd_live_audio_room_request_text_message_height_change", new o42.c(false, true, "PUBLIC_SCREEN_AVOID_FRAME reset"));
        goto L57
    L36:
        DataCenter r29 = this.e;
        if (r29 == null) goto L39;
        r29.put("data_common_talk_room_match_screen", 12);
    L57:
        r12.a(1, "success", null);
        return;
    L86:
        JsonElement r31 = r111.get("offset_top");     // Catch: Exception -> L26
        float r32 = 0.0f;
        if (r31 == null) goto L17;
        float r33 = r31.getAsFloat();     // Catch: Exception -> L26
    L18:
        JsonElement r119 = r111.get("offset_right");     // Catch: Exception -> L26
        if (r119 == null) goto L22;
        r32 = r119.getAsFloat();     // Catch: Exception -> L26
    L22:
        if (r32 <= 0) goto L24;
        r32 = r32 + 12.0f;     // Catch: Exception -> L26
    L24:
        r112 = new oy.d(r33, r32);     // Catch: Exception -> L26
        goto L29
    L17:
        r33 = 0.0f;
    L26:
        e = move-exception;
        boolean r34 = iy.b.a;
        StringBuilder r35 = new StringBuilder("getPublicScreenConfig parseJson error:");
        e.printStackTrace();
        r35.append(Unit.INSTANCE);
        iy.b.b(r35.toString());
        goto L28
    L92:
        return;
    L80:
        jc1.k.n(IMiddlewareRoomService.class).setOnNeedMuteAudioFullPage(true);
        IMiddlewareHostSocial r120 = jc1.k.f(IMiddlewareHostSocial.class);
        if (r120 == null) goto L91;
        r120.showInviteFriendActivity(this.d, new LinkBasicJsbHandler$inviteMore$1(this, r12));
        return;
    }

    public e(Context r2, DataCenter r3, com.bytedance.android.live.anchormodelink.gift.d r4, AnchorModeLinkDynamicWidget.c r5) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r5, "basicProvider");
        this.d = r2;
        this.e = r3;
        this.f = r4;
        this.g = r5;
        this.c = new LinkBasicJsbHandler$userListFilterAction$1(this);
    }
}
