package com.bytedance.android.livesdk.chatroom.vs_base.base.service.out;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livehostapi.TTMiddlewareLiveSDK;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.n;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.r;
import com.bytedance.android.livesdk.chatroom.vs_base.base.util.s;
import com.bytedance.android.livesdk.chatroom.vs_base.util.w;
import com.bytedance.android.livesdkapi.depend.live.vs.VSConstants;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.scope.o;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import fq1.j;
import fq1.p;
import fq1.t;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import lm1.f;
import nm1.g;
import org.json.JSONObject;
import pm1.h;
import vr1.b0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b implements o, g {
    public b() {
    }

    public final void onStart() {
    }

    public final void onStop() {
    }

    public final Uri c(Uri r2, DataCenter r3) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        return w.a(r2, r3);
    }

    public final boolean a(String r41, Context r42, f r43, String r44) {
        Intrinsics.checkNotNullParameter(r41, "replayId");
        Intrinsics.checkNotNullParameter(r43, "model");
        int r5 = gq1.b.a;
        Intrinsics.checkNotNullParameter(r41, "replayId");
        Intrinsics.checkNotNullParameter(r43, "model");
        if (r43.a == null) goto L199;
        b0 r6 = j.a().w();
        Uri r0 = r43.a;
        if (r0 == null) goto L11;
        String r1 = r0.getHost();
        if (r1 == null) goto L11;
        if (r6 == null) goto L11;
        r6.a(r1);
    L11:
        String r2 = r43.d;
        if (r2 != null) goto L14;
        r2 = "";
    L14:
        String r7 = r43.c;
        if (r7 != null) goto L18;
        r7 = "";
    L18:
        if (TextUtils.isEmpty(r2) == false) goto L22;
        r2 = r43.e;
        if (r2 != null) goto L22;
        String r8 = "";
    L23:
        int r9 = VSConstants.REPLAY_EPISODE;
        Bundle r10 = new Bundle();
        r10.putLong(VSConstants.EXTRA_USER_ACTION_ENTER_ROOM_START_TIME, System.currentTimeMillis());
        r10.putString(VSConstants.EXTRA_USER_ACTION_ENTER_ROOM_TYPE, VSConstants.ENTER_ROOM_TYPE_WITH_NO_FEED_REQUEST);
        r10.putString(VSConstants.ENTER_LIVE_POP_TYPE, r43.n);
        r10.putString(VSConstants.EXTRA_REPLAY_LOG_PARAMS, r43.r);
        r10.putString(VSConstants.EXTRA_ROOM_BUSINESS_EXTRA, r43.q);
        String r3 = r43.f;
        if (r3 != null) goto L26;
    L31:
        String r4 = r43.h;
        if (r4 != null) goto L34;
    L37:
        boolean r11 = true;
    L38:
        if (r11 == true) goto L41;
        r10.putString("enter_from_ad_type", r43.h);
    L41:
        if (Intrinsics.areEqual(r43.g, "1") == false) goto L43;
        r10.putBoolean("live.intent.extra.VS_SEND_SHOW_EVENT_INSIDE", true);
    L43:
        String r12 = r43.x;
        if (TextUtils.isEmpty(r43.u) == false) goto L202;
        String r18 = "";
        String r17 = null;
    L65:
        String r13 = r43.s;
        if (r13 != null) goto L68;
        r13 = r17;
    L68:
        r10.putLong("multitab_select_tabid", gq1.b.a("select_tab_id", r13, 0));
        if (TextUtils.isEmpty(r43.t) == true) goto L71;
        String r14 = r43.t;
    L72:
        r10.putString("collection_id", r14);
        if (TextUtils.isEmpty(r44) == true) goto L75;
        r10.putString(VSConstants.EXTRA_VIDEO_MODEL, r44);
    L75:
        String r15 = r43.j;
        String r16 = r43.k;
        String r19 = r43.l;
        if (r19 != null) goto L78;
        r19 = "";
    L78:
        String r110 = r43.m;
        long r111 = gq1.b.a("roomId", r43.b, 0);
        String r112 = r43.o;
        String r113 = r43.p;
        String r114 = r43.x;
        String r20 = r43.y;
        String r115 = r43.v;
        String r116 = r43.w;
        String r117 = r43.z;
        String r118 = r43.q;
        if (TextUtils.isEmpty(r43.i) == false) goto L208;
    L88:
        int r21 = -1;
    L89:
        long r22 = gq1.b.a("replay_id", r41, 0);
        if (r22 <= 0) goto L199;
        if (TextUtils.isEmpty(r10.getString(VSConstants.EXTRA_VIDEO_MODEL, "")) == false) goto L94;
        Object r23 = h.d.c(mq1.w.class);
        Intrinsics.checkNotNull(r23);
        r10.putString("live.intent.extra.EXTRA_VS_SCHEMA_PRE_REQUEST_STATUS", ((mq1.w) r23).d(r22, r10.getString("live.intent.extra.ENTER_TYPE"), r10.getString("live_reason", ""), r8 + '-' + r7, r10.getString(VSConstants.EXTRA_VIDEO_POINT_TYPE), false));
    L94:
        r10.putString("live.intent.extra.EXTRA_VS_ENTER_TYPE", "schema_rid");
        IRoom r24 = p.a().f();
        List<Episode> r119 = n.a;
        ArrayList r120 = (ArrayList) r119;
        if (r120.isEmpty() == false) goto L97;
        Episode r121 = null;
    L98:
        if (r24 != null) goto L102;
        if (r121 != null) goto L102;
        boolean r122 = false;
    L104:
        if (r122 == true) goto L118;
        r10.putLong(VSConstants.EXTRA_ITEM_ID, r22);
        r10.putString(VSConstants.EXTRA_SHARE_CONTENT_TYPE, r114);
        r10.putString(VSConstants.EXTRA_SHARE_TOKEN_FORM, r115);
        r10.putInt(VSConstants.EXTRA_ITEM_TYPE, r9);
        r10.putString(VSConstants.EXTRA_ENTER_LIVE_SOURCE, r15);
        r10.putString(VSConstants.EXTRA_VS_REQUEST_ID, r19);
        r10.putString(VSConstants.EXTRA_VS_LOG_PB, r110);
        r10.putLong(VSConstants.EXTRA_USER_FROM, 0);
        if (r21 < 0) goto L108;
        r10.putInt(VSConstants.EXTRA_VS_ORIENTATION, r21);
    L108:
        r10.putString("source", null);
        r10.putString(VSConstants.EXTRA_SEARCH_ID, null);
        r10.putString(VSConstants.EXTRA_SEARCH_TYPE, null);
        if (TextUtils.isEmpty(r112) == true) goto L112;
        r10.putString(VSConstants.EXTRA_SEARCH_PARAMS, r112);
    L112:
        if (TextUtils.isEmpty(null) == true) goto L115;
        r10.putString(VSConstants.EXTRA_CARRY_SEARCH_PARAMS, null);
    L115:
        if (TextUtils.isEmpty(r116) == true) goto L117;
        r10.putString(VSConstants.ENTER_ECOM_LIVE_PARAMS, r116);
    L117:
        r10.putString(VSConstants.EXTRA_ROOM_BUSINESS_EXTRA, r118);
        Bundle r25 = new Bundle();
        r25.putString(VSConstants.EXTRA_ENTER_FROM_V3, r16);
        r25.putString(VSConstants.EXTRA_VS_ENTER_FROM_MERGE, r8);
        r25.putBoolean(VSConstants.EXTRA_ENTER_HS_USE_ENTER_FROM_MERGE, true);
        r25.putString(VSConstants.EXTRA_VS_ENTER_METHOD, r7);
        r25.putString("previous_page", r20);
        r25.putString("live.intent.extra.VS_FROM_OTHERS_HOMEPAGE_UID", null);
        r25.putString(VSConstants.REQUEST_PAGE, null);
        r25.putString(VSConstants.EXTRA_SEARCH_ID, null);
        r25.putString(VSConstants.EXTRA_SEARCH_TYPE, null);
        r25.putString(VSConstants.EXTRA_ENTER_PUSH_TYPE, r113);
        r25.putString("previous_page", r20);
        r25.putString("comment_id", r117);
        r10.putBundle(VSConstants.EXTRA_ENTER_LIVE_EXTRA, r25);
        TTMiddlewareLiveSDK.hostMiddlewareService().action().startLive(r42, r111, r10);
    L196:
        if (r6 == null) goto L198;
        r6.b();
        r6.stop();
    L198:
        return true;
    L118:
        int r45 = r21;
        if (r24 == null) goto L121;
        String r123 = r24.getAnchorId();
    L122:
        String r27 = r19;
        if (TextUtils.equals(r123, t.a().getCurrentUserId()) == false) goto L154;
        if ((r42 instanceof Activity) == true) goto L127;
    L129:
        pq1.a.d r26 = new pq1.a.d();
        r26.b = r42;
        r26.a = 0;
        r26.f = false;
        Context r28 = r26.b;
        if (r28 == null) goto L132;
        CharSequence r29 = r28.getText(2131919945);
    L133:
        r26.d = r29;
        gq1.a r30 = gq1.a.a;
        Context r31 = r26.b;
        if (r31 == null) goto L139;
        CharSequence r32 = r31.getText(2131919948);
        if (r32 == null) goto L139;
        CharSequence r33 = r32;
    L140:
        pq1.a.b[] r34 = r26.e;
        pq1.a.b r35 = r34[0];
        if (r35 != null) goto L143;
        r35 = new pq1.a.b();
        r34[0] = r35;
    L143:
        r35.a = r33;
        r35.b = r30;
        Context r36 = r26.b;
        if (r36 == null) goto L146;
        pq1.a r124 = new pq1.a(r36, r26);
    L147:
        if (r124 == null) goto L196;
        if (DialogLancet.shouldBlockDialogShow(r124) == false) goto L206;
        DialogLancet.handleBlockedDialogShow(r124);
        goto L196
    L206:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L201
    L152:
        DialogLancet.beforeDialogShow(r124);
        r124.show();
        DialogLancet.afterDialogShow(r124);
        goto L196
    L146:
        r124 = null;
    L139:
        r33 = "";
        goto L140
    L132:
        r29 = null;
        goto L133
    L127:
        if (((Activity) r42).isFinishing() == false) goto L129;
    L154:
        if (r24 != null) goto L156;
    L177:
        if (r24 == null) goto L179;
        long r37 = r24.getId();
    L180:
        r10.putString(VSConstants.EXTRA_SHARE_CONTENT_TYPE, r114);
        r10.putString(VSConstants.EXTRA_SHARE_TOKEN_FORM, r115);
        r10.putLong(VSConstants.EXTRA_ITEM_ID, r22);
        r10.putInt(VSConstants.EXTRA_ITEM_TYPE, r9);
        r10.putString(VSConstants.EXTRA_ENTER_FROM_V3, r16);
        r10.putString(VSConstants.EXTRA_ENTER_LIVE_MODULE, null);
        r10.putString(VSConstants.EXTRA_VS_ENTER_FROM_MERGE, r8);
        r10.putString("previous_page", r20);
        r10.putString("live.intent.extra.VS_FROM_OTHERS_HOMEPAGE_UID", null);
        r10.putBoolean(VSConstants.EXTRA_ENTER_HS_USE_ENTER_FROM_MERGE, true);
        r10.putString(VSConstants.EXTRA_VS_ENTER_METHOD, r7);
        r10.putLong(VSConstants.EXTRA_LOG_ANCHOR_ID, 0);
        r10.putString(VSConstants.EXTRA_LOG_TOP_MESSAGE_TYPE, null);
        r10.putString(VSConstants.EXTRA_VS_REQUEST_ID, r27);
        r10.putString(VSConstants.EXTRA_VS_LOG_PB, r110);
        if (TextUtils.isEmpty(r112) == true) goto L184;
        r10.putString(VSConstants.EXTRA_SEARCH_PARAMS, r112);
    L184:
        if (TextUtils.isEmpty(null) == true) goto L187;
        r10.putString(VSConstants.EXTRA_CARRY_SEARCH_PARAMS, null);
    L187:
        if (TextUtils.isEmpty(r116) == true) goto L189;
        r10.putString(VSConstants.ENTER_ECOM_LIVE_PARAMS, r116);
    L189:
        r10.putLong("live.intent.extra.FROM_ROOM_ID", r37);
        if (r45 < 0) goto L192;
        r10.putInt(VSConstants.EXTRA_VS_ORIENTATION, r45);
    L192:
        r10.putString("source", null);
        mq1.o r38 = s.d();
        if (r38 == null) goto L195;
        r38.a(r111, r15, r10);
        goto L196
    L195:
        r.f().c(r111, r15, r10);
        goto L196
    L179:
        r37 = 0;
        goto L180
    L156:
        if (r24.getId() != r111) goto L177;
        if ((r42 instanceof Activity) == true) goto L160;
        Context r125 = null;
    L161:
        Activity r126 = (Activity) r125;
        if (r126 != null) goto L164;
        r126 = r.d().getTopActivity();
    L164:
        if (r126 == null) goto L196;
        List<Class<?>> r39 = r.d().getAllLiveActivity();
        if (r39 == null) goto L173;
        Iterator<T> r40 = r39.iterator();
        boolean r46 = false;
    L169:
        if (r40.hasNext() == false) goto L174;
        if (Intrinsics.areEqual(r126.getClass(), (Class) r40.next()) == false) goto L169;
        r46 = true;
    L174:
        if (r46 == true) goto L196;
        r126.finish();
        goto L196
    L173:
        r46 = false;
        goto L174
    L160:
        r125 = r42;
        goto L161
    L121:
        r123 = null;
    L102:
        r122 = true;
        goto L104
    L97:
        r121 = (Episode) ListProtector.get(r119, r120.size() - 1);
        goto L98
    L208:
        String r47 = r43.i;     // Catch: NumberFormatException -> L84
        if (r47 == null) goto L85;
        r21 = CastIntegerProtector.parseInt(r47);     // Catch: NumberFormatException -> L84
    L86:
        if (r21 <= 0) goto L88;
    L85:
        r21 = -1;
        goto L86
    L71:
        r14 = r18;
        goto L72
    L202:
        JSONObject r127 = new JSONObject(Uri.decode(r43.u));     // Catch: Exception -> L61
        Iterator<String> r48 = r127.keys();     // Catch: Exception -> L61
        r18 = "";
        r17 = null;
    L47:
        if (r48 == null) goto L65;
        if (r48.hasNext() != true) goto L65;
        String r128 = r48.next();     // Catch: Exception -> L59
        if (Intrinsics.areEqual(r128, "multitab_select_tabid") == false) goto L54;
        r17 = JSONObjectProtectorUtils.getString(r127, r128);     // Catch: Exception -> L59
    L54:
        if (Intrinsics.areEqual(r128, "collection_id") == false) goto L56;
        r18 = JSONObjectProtectorUtils.getString(r127, r128);     // Catch: Exception -> L59
    L56:
        if (r12 != null) goto L47;
        r12 = JSONObjectProtectorUtils.getString(r127, VSConstants.EXTRA_SHARE_CONTENT_TYPE);     // Catch: Exception -> L59
    L59:
        e = e;
    L63:
        ALogger.e("ReplayRoomActionHandler", "extra params extract fail, " + e.getMessage());
    L61:
        e = e;
        r18 = "";
        r17 = null;
        goto L63
    L34:
        if (r4.length() == 0) goto L37;
        r11 = false;
        goto L38
    L26:
        if (r3.length() <= 0) goto L28;
        boolean r129 = true;
    L29:
        if (r129 != true) goto L31;
        r10.putLong("live.intent.extra.VS_START_PLAY_POSITION", gq1.b.a("startPosition", r3, -1));
        goto L31
    L28:
        r129 = false;
    L22:
        r8 = r2;
    L199:
        return false;
    }
}
