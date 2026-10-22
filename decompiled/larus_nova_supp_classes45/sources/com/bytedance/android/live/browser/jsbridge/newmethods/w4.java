package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.broadcast.api.gamepromote.GamePromoteDataContext;
import com.bytedance.android.live.browser.jsbridge.base.GetMessageBoardDataResultModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.JsonUtil;
import com.bytedance.android.livesdk.chatroom.RoomContext;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardCommentListSyncData;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardCommentListSyncDataModel;
import com.bytedance.android.livesdk.chatroom.vs_base.base.ReplayDataContext;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.bytedance.sdk.xbridge.annotations.XBridgeMethod;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@XBridgeMethod(biz = "webcast", name = "getMessageBoardData")
public final class w4 extends w20.o1<w20.p9, GetMessageBoardDataResultModel> {
    public List<String> a;

    public static final class a {
    }

    static {
    }

    public w4() {
    }

    public final void invoke(Object r14, CallContext r15) {
        w20.p9 r16 = (w20.p9) r14;
        Intrinsics.checkNotNullParameter(r16, "params");
        Intrinsics.checkNotNullParameter(r15, "context");
        long r7 = System.currentTimeMillis();
        List<String> r17 = r16.a();
        this.a = r17;
        List<String> r18 = r17;
        boolean r0 = false;
        if (r18 != null) goto L5;
    L8:
        boolean r19 = true;
    L9:
        if (r19 == false) goto L11;
        finishWithFailure();
        return;
    L11:
        GetMessageBoardDataResultModel r110 = new GetMessageBoardDataResultModel();
        r110.c(new GetMessageBoardDataResultModel.a());
        r110.b(GetMessageBoardDataResultModel.Code.Success);
        nm1.e r2 = pm1.f.c();
        Observable r3 = null;
        if (r2 == null) goto L16;
        ReplayDataContext r4 = r2.h(null);
        if (r4 == null) goto L16;
        com.bytedance.live.datacontext.j r5 = r4.getVsMsgBoardDataContext();
    L18:
        if ((r5 instanceof com.bytedance.live.datacontext.j) == true) goto L20;
        r5 = null;
    L20:
        if (r5 == null) goto L23;
        com.bytedance.android.livesdk.chatroom.msgboard.a r6 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r5.getValue();
        if (r6 == null) goto L23;
    L28:
        com.bytedance.android.livesdk.chatroom.msgboard.a r9 = r6;
    L30:
        List<String> r8 = this.a;
        if (r8 != null) goto L33;
    L36:
        boolean r11 = true;
    L37:
        if (r11 == true) goto L62;
        List<String> r12 = this.a;
        if (r12 == null) goto L62;
        List<String> r13 = r12;
        if ((r13 instanceof Collection) == true) goto L43;
    L45:
        Iterator<T> r21 = r13.iterator();
    L47:
        if (r21.hasNext() == false) goto L55;
        String r22 = (String) r21.next();
        if (r22 == null) goto L54;
        if (Intrinsics.areEqual(StringsKt.trim(r22).toString(), "dressInfo") == false) goto L47;
        r0 = true;
        goto L55
    L54:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L55:
        if (r0 != true) goto L62;
        if (r9 == null) goto L58;
        Observable r1 = r9.getMessageBoardSelfComment();
    L59:
        if (r9 == null) goto L61;
        r3 = r9.getInteractDressInfo();
    L61:
        Observable r111 = Observable.mergeDelayError(r1, r3).doFinally(new x4(this, r110, r7, r16));
        com.bytedance.android.livesdk.chatroom.msgboard.a r23 = r9;
        r111.subscribe(new y4(this, r110, r23, r7, r16), new z4(this, r110, r23, r7, r16));
        return;
    L58:
        r1 = null;
        goto L59
    L43:
        if (r13.isEmpty() == false) goto L45;
    L62:
        if (r9 == null) goto L77;
        Observable r24 = r9.getMessageBoardSelfComment();
        if (r24 == null) goto L78;
        Observable r25 = r24.observeOn(AndroidSchedulers.mainThread());
        if (r25 == null) goto L79;
        Observable r112 = r25.doFinally(new a5(this, r110, r7, r16));
        if (r112 == null) goto L80;
        com.bytedance.android.livesdk.chatroom.msgboard.a r26 = r9;
        r112.subscribe(new b5(this, r110, r26, r7, r16), new c5(this, r110, r26, r7, r16));
        return;
    L80:
        return;
    L79:
        return;
    L78:
        return;
    L77:
        return;
    L33:
        if (r8.isEmpty() == true) goto L36;
        r11 = false;
    L23:
        RoomContext r27 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r27 == null) goto L29;
        com.bytedance.live.datacontext.j r28 = r27.getVsMsgBoardDataContext();
        if (r28 == null) goto L29;
        r6 = (com.bytedance.android.livesdk.chatroom.msgboard.a) r28.getValue();
    L29:
        r9 = null;
    L16:
        r5 = null;
        goto L18
    L5:
        if (r18.isEmpty() == true) goto L8;
        r19 = false;
        goto L9
    }

    public static final void j(w4 r3, GetMessageBoardDataResultModel r4, com.bytedance.android.livesdk.chatroom.msgboard.a r5, List r6) {
        r3.getClass();
        if (r6 == null) goto L61;
        Iterator r7 = r6.iterator();
    L6:
        if (r7.hasNext() == false) goto L101;
        String r8 = (String) r7.next();
        VSMsgBoardCommentListSyncData r2 = null;
        switch(r8.hashCode()) {
            case -1526972682: goto L53;
            case -851474765: goto L44;
            case -695505019: goto L37;
            case 182934705: goto L27;
            case 2103298973: goto L11;
            default: goto L6;
        };
    L11:
        if (r8.equals("commentList") == false) goto L6;
        GetMessageBoardDataResultModel.a r9 = r4.a();     // Catch: Exception -> L24
        if (r9 == null) goto L6;
        if (r5 == null) goto L22;
        com.bytedance.live.datacontext.j r0 = r5.getCommentListDataSyncModel();     // Catch: Exception -> L24
        if (r0 == null) goto L22;
        VSMsgBoardCommentListSyncDataModel r1 = (VSMsgBoardCommentListSyncDataModel) r0.getValue();     // Catch: Exception -> L24
        if (r1 == null) goto L22;
        dc2.c r11 = r1.getVsMsgBoardCommentListSyncData();     // Catch: Exception -> L24
        if (r11 == null) goto L22;
        r2 = (VSMsgBoardCommentListSyncData) r11.c();     // Catch: Exception -> L24
    L22:
        r9.a(JsonUtil.toJSONString(r2));     // Catch: Exception -> L24
    L24:
        e = move-exception;
        ALogger.e("GetMessageBoardDataMethod", e.getMessage());
        goto L6
    L27:
        if (r8.equals("selfCommentList") == false) goto L6;
        GetMessageBoardDataResultModel.a r12 = r4.a();     // Catch: Exception -> L34
        if (r12 == null) goto L6;
        if (r5 == null) goto L32;
        r2 = r5.getVsMsgSelfCommentData();     // Catch: Exception -> L34
    L32:
        r12.d(JsonUtil.toJSONString(r2));     // Catch: Exception -> L34
    L34:
        e = move-exception;
        ALogger.e("GetMessageBoardDataMethod", e.getMessage());
        goto L6
    L37:
        if (r8.equals("dressInfo") == false) goto L6;
        GetMessageBoardDataResultModel.a r13 = r4.a();
        if (r13 == null) goto L6;
        if (r5 == null) goto L42;
        r2 = r5.getVsMsgBoardDressInfo();
    L42:
        r13.b(r2);
        goto L6
    L44:
        if (r8.equals("likeRelation") == false) goto L6;
        GetMessageBoardDataResultModel.a r14 = r4.a();
        if (r14 == null) goto L6;
        if (r5 == null) goto L51;
        com.bytedance.live.datacontext.n r15 = r5.getCommentLikeRelation();
        if (r15 == null) goto L51;
        r2 = (String) r15.getValue();
    L51:
        r14.c(r2);
        goto L6
    L53:
        if (r8.equals("uiConfig") == false) goto L6;
        GetMessageBoardDataResultModel.a r16 = r4.a();
        if (r16 == null) goto L6;
        if (r5 == null) goto L60;
        com.bytedance.live.datacontext.j r17 = r5.getExtra();
        if (r17 == null) goto L60;
        r2 = (String) r17.getValue();
    L60:
        r16.e(r2);
        goto L6
    L101:
        return;
    }

    public static final void k(w4 r11, long r12, String r13, List r14) {
        r11.getClass();
        HashMap r15 = new HashMap();
        Map r0 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r0 == null) goto L5;
        r15.putAll(r0);
    L5:
        Episode r4 = null;
        RoomContext r1 = RoomContext.a.c(RoomContext.Companion, null, 0, 3);
        if (r1 == null) goto L10;
        com.bytedance.live.datacontext.m r2 = r1.getRoom();
        if (r2 == null) goto L10;
        Room r3 = (Room) r2.getValue();
    L11:
        lm1.b r5 = pm1.f.d(null);
        if (r5 == null) goto L17;
        com.bytedance.live.datacontext.n r6 = r5.getEpisode();
        if (r6 == null) goto L17;
        r4 = (Episode) r6.getValue();
    L17:
        if (r3 == null) goto L25;
        Map r7 = com.bytedance.android.livesdk.log.u.l().c(am2.x.class).getMap();
        if (r7 == null) goto L21;
        r15.putAll(r7);
    L21:
        Map r8 = com.bytedance.android.livesdk.log.u.l().c(Room.class).getMap();
        if (r8 == null) goto L24;
        r15.putAll(r8);
    L24:
        int r9 = ju2.f.M;
        r15.putAll(ju2.f.a.a(r3).b());
        r15.put("room_type", GamePromoteDataContext.LIVE);
    L25:
        if (r4 == null) goto L27;
        int r16 = am2.a0.L;
        r15.putAll(am2.a0.a.a(r4).a());
        r15.putAll(new am2.b0().a());
        r15.put("room_type", "replay");
        r15.put("replay_id", String.valueOf(r4.getIdExt()));
    L27:
        String r17 = "";
        if (r13 != null) goto L30;
        r13 = "";
    L30:
        r15.put("request_from", r13);
        r15.put("request_jsb_duration", String.valueOf(System.currentTimeMillis() - r12));
        if (r14 == null) goto L36;
        String r18 = CollectionsKt.joinToString$default(r14, ",", null, null, 0, null, null, 62, null);
        if (r18 == null) goto L36;
        r17 = r18;
    L36:
        r15.put("keys", r17);
        com.bytedance.android.livesdk.log.u.l().h("live_vs_get_message_board_data", r15, new Object[0]);
        return;
    L10:
        r3 = null;
        goto L11
    }
}
