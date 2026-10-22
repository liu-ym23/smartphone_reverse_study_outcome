package com.bytedance.android.livesdk.interactivity.interactive;

import android.app.Activity;
import android.text.TextUtils;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.core.utils.rxutils.autodispose.ObservableSubscribeProxy;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.episode.Episode;
import com.bytedance.android.livesdkapi.depend.model.live.episode.IEpisodeExtraInfo;
import com.bytedance.android.livesdkapi.depend.model.live.episode.ext.EpisodeExtKt;
import com.bytedance.android.livesdkapi.depend.model.live.matchroom.EpisodeBasicInfo;
import com.bytedance.android.livesdkapi.interact.IVSInputDialog;
import com.bytedance.android.livesdkapi.interact.InputDraft;
import com.bytedance.android.livesdkapi.interact.OpenVSMsgBoardInputEvent;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.Iterator;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class VSMsgBoardBaseWidget$showInputPanel$2 implements IVSInputDialog.InputListener {
    public final /* synthetic */ VSMsgBoardBaseWidget a;
    public final /* synthetic */ OpenVSMsgBoardInputEvent b;
    public final /* synthetic */ boolean c;
    public final /* synthetic */ Activity d;

    public final void onDismiss(InputDraft r1, boolean r2) {
        if (r2 == true) goto L4;
        this.b.getCallback().onCancel();
    L4:
        VSMsgBoardDataContext r3 = this.a.b;
        if (r3 == null) goto L13;
        com.bytedance.live.datacontext.n<CharSequence> r4 = r3.getDraft();
        if (r4 == null) goto L14;
        if (r1 == null) goto L10;
        CharSequence r5 = r1.getInput();
    L11:
        r4.setValue(r5);
        return;
    L10:
        r5 = null;
        goto L11
    L14:
        return;
    }

    public final void onSendMessage(final String r20, Map<String, Object> r21, final boolean r23) {
        if (r21 == null) goto L10;
        Object r1 = r21.get("skin_id");
        if (r1 == null) goto L10;
        String r2 = r1.toString();
        if (r2 == null) goto L10;
        String r11 = r2;
    L12:
        if (r21 == null) goto L19;
        Object r3 = r21.get("badge_id");
        if (r3 == null) goto L19;
        String r4 = r3.toString();
        if (r4 == null) goto L19;
        String r13 = r4;
    L21:
        if (r21 == null) goto L28;
        Object r5 = r21.get("entity_id");
        if (r5 == null) goto L28;
        String r6 = r5.toString();
        if (r6 == null) goto L28;
        String r15 = r6;
    L29:
        if (r20 == null) goto L111;
        Pair[] r7 = new Pair[3];
        OpenVSMsgBoardInputEvent r8 = this.b;
        if (r8 == null) goto L34;
        String r9 = r8.getSource();
        if (r9 == null) goto L34;
    L35:
        r7[0] = TuplesKt.to("source", r9);
        r7[1] = TuplesKt.to("message_content", r20);
        OpenVSMsgBoardInputEvent r10 = this.b;
        if (r10 == null) goto L39;
        String r14 = r10.getTabName();
        if (r14 == null) goto L39;
    L40:
        r7[2] = TuplesKt.to("tab_name", r14);
        final Map<String, String> r16 = MapsKt.mutableMapOf(r7);
        r16.putAll(this.a.wq());
        if (TextUtils.isEmpty(this.b.getEnterFromMerge()) == true) goto L47;
        String r17 = this.b.getEnterFromMerge();
        if (r17 != null) goto L45;
        r17 = BuildConfig.FLAVOR;
    L45:
        r16.put("enter_from_merge", r17);
    L47:
        if (this.c == false) goto L49;
        String r18 = "reply";
    L50:
        r16.put("message_type", r18);
        if (r21 == null) goto L56;
        Iterator<Map.Entry<String, Object>> r0 = r21.entrySet().iterator();
    L54:
        if (r0.hasNext() == false) goto L56;
        Map.Entry<String, Object> r19 = r0.next();
        r16.put(r19.getKey(), r19.getValue().toString());
    L56:
        this.a.zq("livesdk_vs_guest_book_message_send_click", r16, "click");
        VSMsgBoardBaseWidget r24 = this.a;
        OpenVSMsgBoardInputEvent r25 = this.b;
        final String r26 = r11;
        final String r27 = r13;
        Function1<String, Unit> r28 = new VSMsgBoardBaseWidget$showInputPanel$2$onSendMessage$1(this, r20, r26, r27, r16, r23);
        Function2<Integer, String, Unit> r29 = new VSMsgBoardBaseWidget$showInputPanel$2$onSendMessage$2(this, r16, r23);
        DataCenter r30 = ((Widget) r24).dataCenter;
        if (r30 == null) goto L107;
        IRoom r31 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.e(r30);
        Episode r33 = com.bytedance.android.livesdk.chatroom.vs_base.util.h.a(r30);
        JSONObject r34 = new JSONObject();
        r34.put("scene", "create_comment");
        JSONObject r35 = new JSONObject();
        fq1.s r36 = fq1.t.a();
        if (r36 == null) goto L62;
        String r37 = r36.getCurrentUserId();
    L63:
        r35.put("uid", r37);
        fq1.s r38 = fq1.t.a();
        if (r38 == null) goto L66;
        String r39 = r38.i();
    L67:
        r35.put("nick_name", r39);
        r35.put("text", r20);
        if (r24.d == false) goto L70;
        long r40 = r33.roomId;
    L71:
        r35.put("room_id", r40);
        if (r24.d == false) goto L74;
        String r41 = EpisodeExtKt.getOwnerIdString(r33);
    L78:
        r35.put("anchor_uid", r41);
        VSMsgBoardBaseWidget.Aq(r35, "entity_id", r15);
        VSMsgBoardBaseWidget.Aq(r35, "cover_id", r11);
        VSMsgBoardBaseWidget.Aq(r35, "badge_id", r13);
        String r43 = r25.getParentCommentId();
        if (r43 != null) goto L81;
        r43 = BuildConfig.FLAVOR;
    L81:
        VSMsgBoardBaseWidget.Aq(r35, "parent_comment_id", r43);
        String r44 = r25.getReplyCommentId();
        if (r44 != null) goto L84;
        r44 = BuildConfig.FLAVOR;
    L84:
        VSMsgBoardBaseWidget.Aq(r35, "reply_comment_id", r44);
        String r45 = r25.getReplyToUserId();
        if (r45 != null) goto L87;
        r45 = BuildConfig.FLAVOR;
    L87:
        VSMsgBoardBaseWidget.Aq(r35, "reply_user_id", r45);
        Unit r46 = Unit.INSTANCE;
        r34.put("params", r35);
        IVSMessageBoardApi r47 = (IVSMessageBoardApi) com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.n().getService(IVSMessageBoardApi.class);
        if (r24.d == false) goto L93;
        if (r33 == null) goto L102;
        EpisodeBasicInfo r48 = r33.episodeBasicInfo;
        if (r48 == null) goto L102;
        long r49 = r48.getOriginEpisodeId();
    L103:
        ObservableSubscribeProxy r50 = (ObservableSubscribeProxy) r47.createComment(r49, r34.toString()).as(r24.autoDisposeWithTransformer());
        if (r50 == null) goto L107;
        r50.subscribe(new f1(r28, r29), new g1(r29));
    L102:
        r49 = 0;
        goto L103
    L93:
        IEpisodeExtraInfo r51 = r31.getEpisodeExtra();
        if (r51 != null) goto L98;
        r51 = r31.getEpisodeComponentData();
        if (r51 != null) goto L98;
        Long r53 = null;
    L100:
        if (r53 == null) goto L102;
        r49 = r53.longValue();
    L98:
        r53 = Long.valueOf(r51.getId());
        goto L100
    L74:
        IBaseUser r54 = r31.getOwner();
        if (r54 == null) goto L77;
        r41 = r54.getIdString();
        goto L78
    L77:
        r41 = null;
        goto L78
    L70:
        r40 = r31.getRoomId();
        goto L71
    L66:
        r39 = null;
        goto L67
    L62:
        r37 = null;
    L107:
        if (r23 == false) goto L112;
        VSMsgBoardBaseWidget r55 = this.a;
        r55.e = com.bytedance.android.livesdk.chatroom.vs_base.base.util.r.w().publishToStory(this.d, this.b.getPublishTitle(), r20, "entertainment_live_book_message_interaction_guide", "live", VSMsgBoardBaseWidget$showInputPanel$2$onSendMessage$3.INSTANCE);
        return;
    L112:
        return;
    L49:
        r18 = "message";
    L39:
        r14 = BuildConfig.FLAVOR;
    L34:
        r9 = BuildConfig.FLAVOR;
        goto L35
    L111:
        return;
    L28:
        r15 = BuildConfig.FLAVOR;
    L19:
        r13 = BuildConfig.FLAVOR;
    L10:
        r11 = BuildConfig.FLAVOR;
        goto L12
    }

    public VSMsgBoardBaseWidget$showInputPanel$2(VSMsgBoardBaseWidget r1, OpenVSMsgBoardInputEvent r2, boolean r3, Activity r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
