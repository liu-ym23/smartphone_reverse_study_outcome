package com.larus.bmhome.chat.component.collection;

import by7.e;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.bmhome.collection.ICollectionReport;
import com.larus.im.bean.message.Message;
import com.larus.network.http.y;
import com.larus.platform.model.CancelCollectionResponse;
import com.larus.platform.model.SaveCollectionResponse;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import yc9.c0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J,\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016JP\u0010\f\u001a\u00020\u00052\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016JZ\u0010\u0017\u001a\u00020\u00052\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0012\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00072\b\u0010\u0014\u001a\u0004\u0018\u00010\u00072\b\u0010\u001a\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u00072\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/larus/bmhome/chat/component/collection/CollectionEventHelper;", "Lcom/larus/bmhome/collection/ICollectionReport;", "<init>", "()V", "clickButton", "", "collectionId", "", "buttonName", "followingOtherAction", "trackNode", "Lcom/ixigua/lib/track/ITrackNode;", "messageCollect", "collectResult", "Lcom/larus/network/http/Async;", "Lcom/larus/platform/model/SaveCollectionResponse;", "messages", "", "Lcom/larus/im/bean/message/Message;", "clickFrom", "currentPage", "traceInfo", "Lorg/json/JSONObject;", "messageCollectCancel", "collectCancelResult", "Lcom/larus/platform/model/CancelCollectionResponse;", "botId", "conversationId", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class CollectionEventHelper implements ICollectionReport {

    public static final class a {
    }

    static {
    }

    public CollectionEventHelper() {
    }

    public final void a(String r5, String r6, String r7, e r8) {
        Intrinsics.checkNotNullParameter(r6, "buttonName");
        Intrinsics.checkNotNullParameter(r7, "followingOtherAction");
        by7.a r0 = new by7.a("click_button");
        TrackParams r1 = new TrackParams();
        JSONObject r2 = new JSONObject();
        r2.put("collect_id", r5);
        r2.put("button_name", r6);
        r2.put("following_other_action", r7);
        TrackParams r9 = r1.merge(r2);
        if (r8 == null) goto L5;
        r0.b = r8;
    L5:
        r0.a.merge(r9);
        r0.b();
    }

    public final void c(com.larus.network.http.a<SaveCollectionResponse> r22, List<Message> r23, String r24, String r25, String r26, JSONObject r27) {
        Intrinsics.checkNotNullParameter(r24, "clickFrom");
        boolean r4 = r22 instanceof y;
        if (r23 == null) goto L5;
        int r6 = r23.size();
    L7:
        if (r6 <= 1) goto L9;
        boolean r7 = true;
    L10:
        ChatControlTrace r8 = ChatControlTrace.b;
        r8.getClass();
        long r9 = ChatControlTrace.y;
        com.larus.bmhome.chat.trace.a r10 = r8.gc(r9);
        if (r23 == null) goto L13;
        Message r12 = (Message) CollectionsKt.getOrNull(r23, 0);
    L14:
        if (r12 == null) goto L16;
        String r13 = com.larus.im.bean.message.a.b(r12);
    L17:
        if (r23 == null) goto L63;
        Iterator<T> r14 = r23.iterator();
        boolean r15 = false;
        boolean r16 = false;
        boolean r17 = false;
    L20:
        if (r14.hasNext() == false) goto L64;
        Message r18 = (Message) r14.next();
        if (r18 == null) goto L24;
        Integer r19 = Integer.valueOf(r18.getContentType());
    L25:
        if (r19 != null) goto L28;
    L30:
        if (r19 != null) goto L33;
    L34:
        if (r19 != null) goto L37;
    L39:
        if (r19 != null) goto L42;
    L44:
        if (r19 != null) goto L47;
    L48:
        if (r19 != null) goto L51;
    L53:
        if (r19 == null) goto L20;
        if (r19.intValue() != 800) goto L20;
        if (Intrinsics.areEqual(r18.getBizContentType(), "flow_nested") == false) goto L20;
    L59:
        r16 = true;
        goto L20
    L51:
        if (r19.intValue() != 9999) goto L53;
    L60:
        r17 = m.b(r18);
        r15 = m.a(r18);
        goto L20
    L47:
        if (r19.intValue() == 1) goto L60;
    L42:
        if (r19.intValue() != 7) goto L44;
    L37:
        if (r19.intValue() != 9) goto L39;
    L61:
        r17 = true;
        goto L20
    L33:
        if (r19.intValue() == 5) goto L61;
    L28:
        if (r19.intValue() != 6) goto L30;
        r15 = true;
        goto L20
    L24:
        r19 = null;
    L64:
        if (r7 == false) goto L66;
        String r5 = "multi_message";
    L75:
        if (r10 == null) goto L77;
        String r11 = r10.a;
    L78:
        if (r10 == null) goto L80;
        String r20 = r10.g;
    L81:
        if (r7 == true) goto L84;
        if (r12 == null) goto L84;
        String r21 = r12.getMessageId();
    L85:
        String r110 = ChatControlTrace.b.h(r9);
        String r111 = ve8.c.b(r4);
        if (r4 == false) goto L92;
        y r0 = (y) r22;
        if (r0 == null) goto L92;
        SaveCollectionResponse r1 = (SaveCollectionResponse) ((com.larus.network.http.a) r0).b;
        if (r1 == null) goto L92;
        String r2 = r1.getCollectionId();
    L93:
        String r28 = ve8.c.b(r15);
        String r112 = ve8.c.b(r16);
        String r113 = ve8.c.b(r17);
        if (r27 != null) goto L96;
        JSONObject r29 = new JSONObject();
    L97:
        if (r23 == null) goto L113;
        Iterator<T> r3 = r23.iterator();
    L100:
        if (r3.hasNext() == false) goto L107;
        Message r114 = (Message) r3.next();
        if (r114 == null) goto L104;
        HashMap r115 = c0.b(r114);
    L105:
        if (r115 == null) goto L100;
    L108:
        if (r115 == null) goto L113;
        Iterator r30 = r115.entrySet().iterator();
    L111:
        if (r30.hasNext() == false) goto L113;
        Map.Entry r116 = (Map.Entry) r30.next();
        Iterator r210 = r30;
        r29.put((String) r116.getKey(), (String) r116.getValue());
        r30 = r210;
        r13 = r13;
        goto L111
    L104:
        r115 = null;
        goto L105
    L107:
        r115 = null;
    L113:
        String r117 = r13;
        e r31 = ChatControlTrace.b.ob(r9);
        Intrinsics.checkNotNullParameter(r29, "params");
        if (r11 != null) goto L145;
    L118:
        if (r24 == null) goto L120;
        r29.put("click_from", r24);     // Catch: JSONException -> L116
    L120:
        if (r20 == null) goto L122;
        r29.put("conversation_id", r20);     // Catch: JSONException -> L116
    L122:
        if (r21 == null) goto L124;
        r29.put("message_id", r21);     // Catch: JSONException -> L116
    L124:
        r29.put("chat_type", r110);     // Catch: JSONException -> L116
        r29.put("success", r111);     // Catch: JSONException -> L116
        if (r26 == null) goto L127;
        r29.put("current_page", r26);     // Catch: JSONException -> L116
    L127:
        r29.put("is_with_picture", r28);     // Catch: JSONException -> L116
        r29.put("is_with_file", r112);     // Catch: JSONException -> L116
        r29.put("is_with_video", r113);     // Catch: JSONException -> L116
        if (r2 == null) goto L131;
        r29.put("collect_id", r2);     // Catch: JSONException -> L116
    L131:
        if (r25 != null) goto L133;
        String r32 = "None";
    L134:
        r29.put("following_other_action", r32);     // Catch: JSONException -> L116
        if (r117 == null) goto L137;
        r29.put("agent_intention", r117);     // Catch: JSONException -> L116
    L137:
        r29.put("type", r5);     // Catch: JSONException -> L116
    L140:
        TrackParams r33 = new TrackParams().merge(r29);
        by7.a r34 = new by7.a("collect");
        if (r31 == null) goto L143;
        r34.b = r31;
    L143:
        r34.a.merge(r33);
        r34.b();
        return;
    L116:
        e = move-exception;
        FLogger.a.e("MessageEventHelper", "error in MessageEventHelper messageCollect " + e.getLocalizedMessage());
        goto L140
    L133:
        r32 = r25;
        goto L134
    L145:
        r29.put("bot_id", r11);     // Catch: JSONException -> L116
        goto L118
    L96:
        r29 = r27;
    L92:
        r2 = null;
    L84:
        r21 = null;
        goto L85
    L80:
        r20 = null;
        goto L81
    L77:
        r11 = null;
        goto L78
    L66:
        if (r13 != null) goto L68;
    L71:
        boolean r35 = true;
    L72:
        if (r35 == false) goto L74;
        r5 = "single_message";
        goto L75
    L74:
        r5 = "first_application_card";
        goto L75
    L68:
        if (r13.length() == 0) goto L71;
        r35 = false;
        goto L72
    L63:
        r15 = false;
        r16 = false;
        r17 = false;
        goto L64
    L16:
        r13 = null;
        goto L17
    L13:
        r12 = null;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = 0;
        goto L7
    }

    public final void b(com.larus.network.http.a<CancelCollectionResponse> r20, List<Message> r21, String r22, String r23, String r24, String r25, e r26) {
        Intrinsics.checkNotNullParameter(r22, "clickFrom");
        boolean r4 = r20 instanceof y;
        if (r21 == null) goto L5;
        int r6 = r21.size();
    L7:
        if (r6 <= 1) goto L9;
        boolean r7 = true;
    L10:
        ChatControlTrace r8 = ChatControlTrace.b;
        r8.getClass();
        long r9 = ChatControlTrace.y;
        com.larus.bmhome.chat.trace.a r10 = r8.gc(r9);
        if (r21 == null) goto L13;
        Message r12 = (Message) CollectionsKt.getOrNull(r21, 0);
    L14:
        if (r12 == null) goto L16;
        String r13 = com.larus.im.bean.message.a.b(r12);
    L17:
        if (r21 == null) goto L58;
        Iterator<T> r1 = r21.iterator();
        boolean r14 = false;
        boolean r15 = false;
        boolean r16 = false;
    L20:
        if (r1.hasNext() == false) goto L59;
        Message r17 = (Message) r1.next();
        if (r17 == null) goto L24;
        Integer r18 = Integer.valueOf(r17.getContentType());
    L25:
        if (r18 != null) goto L28;
    L30:
        if (r18 != null) goto L33;
    L34:
        if (r18 != null) goto L37;
    L39:
        if (r18 != null) goto L42;
    L44:
        if (r18 != null) goto L47;
    L49:
        if (r18 == null) goto L20;
        if (r18.intValue() != 800) goto L20;
        if (Intrinsics.areEqual(r17.getBizContentType(), "flow_nested") == false) goto L20;
    L55:
        r16 = true;
        goto L20
    L47:
        if (r18.intValue() != 1) goto L49;
        r14 = m.b(r17);
        r15 = m.a(r17);
        goto L20
    L42:
        if (r18.intValue() != 7) goto L44;
    L37:
        if (r18.intValue() != 9) goto L39;
    L56:
        r14 = true;
        goto L20
    L33:
        if (r18.intValue() == 5) goto L56;
    L28:
        if (r18.intValue() != 6) goto L30;
        r15 = true;
        goto L20
    L24:
        r18 = null;
    L59:
        if (r7 == false) goto L61;
        String r2 = "multi_message";
    L70:
        if (r24 != null) goto L74;
        if (r10 == null) goto L73;
        String r5 = r10.a;
    L75:
        if (r25 != null) goto L79;
        if (r10 == null) goto L78;
        String r11 = r10.g;
    L80:
        if (r7 == true) goto L83;
        if (r12 == null) goto L83;
        String r19 = r12.getMessageId();
    L85:
        if (Intrinsics.areEqual(r23, "bot_list_profile") == false) goto L87;
        String r27 = null;
    L88:
        String r110 = ve8.c.b(r4);
        if (r4 == false) goto L95;
        y r0 = (y) r20;
        if (r0 == null) goto L95;
        CancelCollectionResponse r3 = (CancelCollectionResponse) ((com.larus.network.http.a) r0).b;
        if (r3 == null) goto L95;
        String r28 = r3.getCollectionId();
    L96:
        String r29 = ve8.c.b(r15);
        String r111 = ve8.c.b(r16);
        String r112 = ve8.c.b(r14);
        if (r26 != null) goto L99;
        e r30 = ChatControlTrace.b.ob(r9);
    L100:
        JSONObject r113 = new JSONObject();
        Intrinsics.checkNotNullParameter(r113, "params");
        if (r5 != null) goto L129;
    L105:
        if (r22 == null) goto L107;
        r113.put("click_from", r22);     // Catch: JSONException -> L103
    L107:
        if (r11 == null) goto L109;
        r113.put("conversation_id", r11);     // Catch: JSONException -> L103
    L109:
        if (r19 == null) goto L111;
        r113.put("message_id", r19);     // Catch: JSONException -> L103
    L111:
        if (r27 == null) goto L113;
        r113.put("chat_type", r27);     // Catch: JSONException -> L103
    L113:
        r113.put("success", r110);     // Catch: JSONException -> L103
        if (r23 == null) goto L116;
        r113.put("current_page", r23);     // Catch: JSONException -> L103
    L116:
        r113.put("is_with_picture", r29);     // Catch: JSONException -> L103
        r113.put("is_with_file", r111);     // Catch: JSONException -> L103
        r113.put("is_with_video", r112);     // Catch: JSONException -> L103
        if (r28 == null) goto L119;
        r113.put("collect_id", r28);     // Catch: JSONException -> L103
    L119:
        if (r13 == null) goto L121;
        r113.put("agent_intention", r13);     // Catch: JSONException -> L103
    L121:
        r113.put("type", r2);     // Catch: JSONException -> L103
    L124:
        TrackParams r31 = new TrackParams().merge(r113);
        by7.a r32 = new by7.a("collect_cancel");
        if (r30 == null) goto L127;
        r32.b = r30;
    L127:
        r32.a.merge(r31);
        r32.b();
        return;
    L103:
        e = move-exception;
        FLogger.a.e("MessageEventHelper", "error in MessageEventHelper messageCollect " + e.getLocalizedMessage());
        goto L124
    L129:
        r113.put("bot_id", r5);     // Catch: JSONException -> L103
        goto L105
    L99:
        r30 = r26;
    L95:
        r28 = null;
        goto L96
    L87:
        r27 = ChatControlTrace.b.h(r9);
    L83:
        r19 = null;
        goto L85
    L78:
        r11 = null;
        goto L80
    L79:
        r11 = r25;
        goto L80
    L73:
        r5 = null;
        goto L75
    L74:
        r5 = r24;
        goto L75
    L61:
        if (r13 != null) goto L63;
    L66:
        boolean r33 = true;
    L67:
        if (r33 == false) goto L69;
        r2 = "single_message";
        goto L70
    L69:
        r2 = "first_application_card";
        goto L70
    L63:
        if (r13.length() == 0) goto L66;
        r33 = false;
        goto L67
    L58:
        r14 = false;
        r15 = false;
        r16 = false;
        goto L59
    L16:
        r13 = null;
        goto L17
    L13:
        r12 = null;
        goto L14
    L9:
        r7 = false;
        goto L10
    L5:
        r6 = 0;
        goto L7
    }
}
