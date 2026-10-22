package com.larus.bmhome.chat.component.receive;

import android.os.Bundle;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMError;
import com.larus.platform.service.o;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class z implements Function2 {
    public final /* synthetic */ ChatReceiveServiceComponent a;

    public /* synthetic */ z(ChatReceiveServiceComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11) {
        ChatReceiveServiceComponent r0 = this.a;
        Message r12 = (Message) r10;
        IIMError r13 = (IIMError) r11;
        int r1 = ChatReceiveServiceComponent.x;
        List<String> r2 = a.a;
        de8.c r3 = r0.f1();
        Intrinsics.checkNotNullParameter(r3, "chatArgumentData");
        Bundle r4 = r3.b;
        LinkedHashMap r5 = new LinkedHashMap();
        if (r4 == null) goto L13;
        Bundle r6 = r4.getBundle("flow_saas_chat_common_params");
        if (r6 == null) goto L13;
        LinkedHashMap r7 = new LinkedHashMap();
        Iterator<T> r8 = r6.keySet().iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        String r9 = (String) r8.next();
        String r14 = r6.getString(r9);
        if (r14 == null) goto L8;
        r7.put(r9, r14);
        goto L8
    L12:
        r5.putAll(r7);
    L13:
        Iterator<T> r15 = a.a.iterator();
    L14:
        boolean r16 = false;
        String r17 = null;
        if (r15.hasNext() == false) goto L27;
        String r18 = (String) r15.next();
        if (r4 == null) goto L14;
        String r19 = r4.getString(r18);
        if (r19 == null) goto L14;
        if (r19.length() <= 0) goto L23;
        r16 = true;
    L23:
        if (r16 == false) goto L25;
        r17 = r19;
    L25:
        if (r17 == null) goto L14;
        r5.put(r18, r17);
        goto L14
    L27:
        Intrinsics.checkNotNullParameter(r5, "chatCommonParams");
        CharSequence r20 = (CharSequence) r5.get("douyinec_search_id");
        if (r20 != null) goto L30;
    L33:
        boolean r21 = true;
    L34:
        if (r21 == false) goto L45;
        CharSequence r22 = (CharSequence) r5.get("douyinec_search_session_id");
        if (r22 != null) goto L38;
    L41:
        boolean r23 = true;
    L42:
        if (r23 == false) goto L45;
        boolean r24 = false;
    L46:
        if (r24 == false) goto L88;
        o r25 = o.a;
        if (r12 == null) goto L51;
        String r110 = r12.getMessageId();
    L52:
        if (r13 != null) goto L54;
        boolean r111 = true;
    L55:
        Intrinsics.checkNotNullParameter(r5, "chatCommonParams");
        if (r110 != null) goto L58;
    L61:
        boolean r26 = true;
    L62:
        boolean r27 = !r26;
        JSONObject r28 = new JSONObject();
        if (r111 == false) goto L66;
        if (r27 == false) goto L66;
    L67:
        r28.put("message_id", r110);
        if (r111 == false) goto L71;
        if (r27 == false) goto L71;
        String r112 = "success";
    L72:
        r28.put("status", r112);
        Iterator<T> r113 = a.a.iterator();
    L74:
        if (r113.hasNext() == false) goto L86;
        String r114 = (String) r113.next();
        String r29 = (String) r5.get(r114);
        if (r29 == null) goto L74;
        if (r29.length() <= 0) goto L80;
        boolean r30 = true;
    L81:
        if (r30 == true) goto L84;
        r29 = null;
    L84:
        if (r29 == null) goto L74;
        r28.put(r114, r29);
        goto L74
    L80:
        r30 = false;
        goto L81
    L86:
        r25.reportEvent("doubao_auto_send_message_track_event", r28);
    L71:
        r112 = "failed";
    L66:
        r110 = "0";
        goto L67
    L58:
        if (r110.length() == 0) goto L61;
        r26 = false;
        goto L62
    L54:
        r111 = false;
        goto L55
    L51:
        r110 = null;
    L88:
        return Unit.INSTANCE;
    L38:
        if (r22.length() == 0) goto L41;
        r23 = false;
    L45:
        r24 = true;
        goto L46
    L30:
        if (r20.length() == 0) goto L33;
        r21 = false;
        goto L34
    }
}
