package gx9;

import com.larus.common.apphost.AppHost;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class c implements IIMCallback<List<? extends Message>> {
    public final /* synthetic */ b a;
    public final /* synthetic */ String b;

    public final boolean mustInMain() {
        return true;
    }

    public final void onFailure(IIMError r4) {
        Intrinsics.checkNotNullParameter(r4, "error");
        FLogger.a.e("ChatWcbMessageCleaner", "getMessageListFromLocal failed, error=" + r4);
    }

    public final void onSuccess(Object r20) {
        List r1 = (List) r20;
        Intrinsics.checkNotNullParameter(r1, "result");
        b r2 = this.a;
        String r10 = this.b;
        r2.getClass();
        if (r1.size() >= r2.a.b()) goto L5;
        FLogger.a.i("ChatWcbMessageCleaner", "skip clearHistoryWcbMessages, messageCnt=" + r1.size());
        return;
    L5:
        List r3 = r1;
        Iterator r4 = r3.iterator();
    L7:
        if (r4.hasNext() == false) goto L17;
        Object r5 = r4.next();
        Message r7 = (Message) r5;
        if (com.larus.bmhome.chat.bean.d.k0(r7) == false) goto L11;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L7;
    L18:
        Message r6 = (Message) r5;
        if (r6 != null) goto L21;
        FLogger.a.i("ChatWcbMessageCleaner", "skip clearHistoryWcbMessages, no target wcb message");
        return;
    L21:
        long r9 = (AppHost.a.getAppClock().currentTimeMillis() / ((long) 1000)) - r2.a.a();
        ArrayList r11 = new ArrayList();
        Iterator r12 = r3.iterator();
    L23:
        if (r12.hasNext() == false) goto L34;
        Object r13 = r12.next();
        Message r14 = (Message) r13;
        if (com.larus.bmhome.chat.bean.d.k0(r14) == false) goto L27;
    L30:
        boolean r15 = false;
    L31:
        if (r15 == false) goto L23;
        r11.add(r13);
        goto L23
    L27:
        if (com.larus.bmhome.chat.bean.d.Y0(r14) == true) goto L30;
        r15 = com.larus.bmhome.chat.bean.d.W0(r14);
        goto L31
    L34:
        if (r11.size() >= r2.a.c()) goto L36;
        FLogger.a.i("ChatWcbMessageCleaner", "skip clearHistoryWcbMessages, messageCnt=" + r11.size());
        return;
    L36:
        ArrayList r16 = new ArrayList();
        Iterator r17 = r11.iterator();
    L37:
        String r18 = "";
        if (r17.hasNext() == false) goto L76;
        Object r19 = r17.next();
        Message r110 = (Message) r19;
        String r111 = r110.getLocalMessageId();
        if (r111 != null) goto L42;
        r111 = "";
    L42:
        String r112 = r6.getLocalMessageId();
        if (r112 != null) goto L45;
        String r21 = "";
    L47:
        if (r111.length() <= 0) goto L49;
        boolean r113 = true;
    L50:
        if (r113 == true) goto L52;
    L57:
        String r114 = r110.getMessageId();
        if (r114 != null) goto L60;
        r114 = "";
    L60:
        String r115 = r6.getMessageId();
        if (r115 == null) goto L65;
        r18 = r115;
    L65:
        if (r114.length() <= 0) goto L67;
        boolean r116 = true;
    L68:
        if (r116 == true) goto L70;
    L72:
        boolean r117 = false;
    L74:
        if ((!r117) == false) goto L37;
        r16.add(r19);
        goto L37
    L70:
        if (Intrinsics.areEqual(r114, r18) == false) goto L72;
        r117 = true;
        goto L74
    L67:
        r116 = false;
        goto L68
    L52:
        if (r21.length() <= 0) goto L54;
        boolean r118 = true;
    L55:
        if (r118 == false) goto L57;
        r117 = Intrinsics.areEqual(r111, r21);
        goto L74
    L54:
        r118 = false;
        goto L55
    L49:
        r113 = false;
        goto L50
    L45:
        r21 = r112;
        goto L47
    L76:
        ArrayList r22 = new ArrayList();
        Iterator r23 = r16.iterator();
    L78:
        if (r23.hasNext() == false) goto L87;
        Object r24 = r23.next();
        long r119 = ((Message) r24).getCreateTime();
        if (1 <= r119) goto L82;
    L84:
        boolean r120 = false;
    L85:
        if (r120 == false) goto L78;
        r22.add(r24);
        goto L78
    L82:
        if (r119 >= r9) goto L84;
        r120 = true;
        goto L85
    L87:
        ArrayList r25 = new ArrayList();
        ArrayList r26 = new ArrayList();
        Iterator r121 = r22.iterator();
    L89:
        if (r121.hasNext() == false) goto L101;
        Object r122 = r121.next();
        String r123 = ((Message) r122).getMessageId();
        if (r123 != null) goto L93;
    L96:
        boolean r124 = true;
    L98:
        if ((!r124) == true) goto L99;
        r26.add(r122);
        goto L89
    L99:
        r25.add(r122);
        goto L89
    L93:
        if (r123.length() == 0) goto L96;
        r124 = false;
        goto L98
    L101:
        Pair r125 = new Pair(r25, r26);
        List r27 = (List) r125.component1();
        List r126 = (List) r125.component2();
        FLogger r28 = FLogger.a;
        StringBuilder r127 = new StringBuilder("query message finished, wcb=");
        r127.append(r11.size());
        r127.append(" totalDelete=");
        r127.append(r22.size());
        r127.append(", remoteDelete=");
        r127.append(r27.size());
        r127.append(", localOnlyDelete=");
        r127.append(r126.size());
        r127.append(", latest=");
        r127.append(b.a(r6));
        r127.append(", clearBeforeTime=");
        r127.append(r9);
        r127.append(", delete=");
        ArrayList r29 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r30 = r22.iterator();
    L103:
        if (r30.hasNext() == false) goto L105;
        r29.add(b.a((Message) r30.next()));
        goto L103
    L105:
        r127.append(r29);
        r28.i("ChatWcbMessageCleaner", r127.toString());
        a r31 = r2.b;
        int r32 = r11.size();
        int r33 = r22.size();
        int r34 = r27.size();
        int r35 = r126.size();
        r31.getClass();
        Intrinsics.checkNotNullParameter(r10, "conversationId");
        JSONObject r36 = new JSONObject();
        r36.put("conversation_id", r10);
        r36.put("trigger", "background");
        r36.put("wcb_cnt", r32);
        r36.put("total_delete_cnt", r33);
        r36.put("remote_delete_cnt", r34);
        r36.put("local_only_delete_cnt", r35);
        r36.put("success", "1");
        r36.put("error_code", 0);
        r36.put("error_msg", "");
        com.larus.platform.service.o.a.reportEvent("dev_wcb_delete_event", r36);
        if ((!r27.isEmpty()) == false) goto L109;
        com.larus.im.d.e().h(r10, r27, true, false, false, new d(true, r27, r2, r10));
    L109:
        if ((!r126.isEmpty()) == false) goto L142;
        com.larus.im.d.e().h(r10, r126, false, false, false, new d(false, r126, r2, r10));
        return;
    L142:
        return;
    L11:
        if (com.larus.bmhome.chat.bean.d.Y0(r7) == true) goto L14;
        r8 = com.larus.bmhome.chat.bean.d.W0(r7);
        goto L15
    L17:
        r5 = null;
        goto L18
    }

    public c(b r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
