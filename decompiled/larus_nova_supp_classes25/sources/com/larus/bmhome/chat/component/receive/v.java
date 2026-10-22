package com.larus.bmhome.chat.component.receive;

import android.os.Bundle;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.larus.utils.p0;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class v implements Function0 {
    public final /* synthetic */ ChatReceiveServiceComponent a;
    public final /* synthetic */ String b;

    public /* synthetic */ v(ChatReceiveServiceComponent r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final Object invoke() {
        final ChatReceiveServiceComponent r7 = this.a;
        final String r6 = this.b;
        int r0 = ChatReceiveServiceComponent.x;
        if (s1a.a.c(r7).isAdded() == false) goto L88;
        Intrinsics.checkNotNullParameter(r7, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(r7, r7).isDetached() == true) goto L88;
        de8.c r1 = r7.f1();
        Bundle r2 = r1.b;
        String r3 = null;
        if (r2 == null) goto L10;
        String r4 = r2.getString("share_to_chat_text");
    L11:
        if (r4 == null) goto L16;
        Bundle r5 = r1.b;
        if (r5 == null) goto L16;
        r5.remove("share_to_chat_text");
    L16:
        if (r4 != null) goto L18;
        String r8 = "";
    L19:
        de8.c r9 = r7.f1();
        Bundle r10 = r9.b;
        if (r10 == null) goto L23;
        String r11 = r10.getString("reference_text");
        if (r11 == null) goto L23;
    L24:
        Bundle r12 = r9.b;
        if (r12 == null) goto L27;
        r12.remove("reference_text");
    L27:
        de8.c r13 = r7.f1();
        r13.getClass();
        Result.Companion r14 = Result.Companion;     // Catch: Throwable -> L34
        Bundle r15 = r13.b;     // Catch: Throwable -> L34
        if (r15 == null) goto L31;
        ArrayList<String> r16 = r15.getStringArrayList("auto_send_skill_ids");     // Catch: Throwable -> L34
    L32:
        Object r17 = Result.constructor-impl(r16);     // Catch: Throwable -> L34
    L37:
        if (Result.isFailure-impl(r17) == false) goto L39;
        r17 = null;
    L39:
        List r18 = (List) r17;
        if (r18 != null) goto L42;
        r18 = CollectionsKt.emptyList();
    L42:
        Bundle r19 = r13.b;
        if (r19 == null) goto L45;
        r19.remove("auto_send_skill_ids");
    L45:
        boolean r20 = false;
        if (r8.length() <= 0) goto L48;
        boolean r21 = true;
    L49:
        if (r21 == false) goto L64;
        final boolean r110 = r7.z3("share_to_chat_text");
        ChatControlTrace r22 = ChatControlTrace.b;
        long r23 = de8.d.a(r7.f1());
        r22.getClass();
        Intrinsics.checkNotNullParameter(r8, "sendQuestion");
        com.larus.bmhome.chat.trace.a r24 = (com.larus.bmhome.chat.trace.a) ChatControlTrace.C.get(Long.valueOf(r23));
        if (r24 == null) goto L61;
        o r25 = o.a;
        JSONObject r26 = new JSONObject();
        r26.put("bot_type", "default");
        r26.put("bot_id", r24.a);
        int r27 = p0.a;
        new URL(r8);     // Catch: Exception -> L55
        r20 = true;
    L56:
        FLogger.a.d("StringUtils", r8 + ", is url:" + r20);
        if (r20 == false) goto L59;
        String r28 = "url";
    L60:
        r26.put("content_type", r28);
        Unit r29 = Unit.INSTANCE;
        r25.reportEvent("share_to_bot_click", r26);
    L62:
        final String r30 = r8;
        final List r31 = r18;
        final String r32 = r11;
        r7.PR(r18, new w(r7, r30, r31, r32, r110, r6));
        return Unit.INSTANCE;
    L59:
        r28 = ChatDraftItem.TYPE_TEXT;
        goto L60
    L61:
        FLogger.a.d("ChatControlTrace", "onShareToBotClick chatKey not found");
        goto L62
    L64:
        if (r8.length() != 0) goto L66;
        boolean r33 = true;
    L67:
        if (r33 == true) goto L69;
    L76:
        de8.c r34 = r7.f1();
        Bundle r35 = r34.b;
        if (r35 == null) goto L79;
        r3 = r35.getString("auto_send_text");
    L79:
        if (r3 == null) goto L83;
        Bundle r36 = r34.b;
        if (r36 == null) goto L83;
        r36.remove("auto_send_text");
    L83:
        if (r3 != null) goto L85;
        final String r37 = "";
    L86:
        final boolean r38 = r7.z3("auto_send_text");
        final List r39 = r18;
        final String r40 = r11;
        r7.PR(r18, new x(r7, r37, r39, r40, r38, r6));
        return Unit.INSTANCE;
    L85:
        r37 = r3;
        goto L86
    L69:
        if (r11.length() <= 0) goto L71;
        r20 = true;
    L71:
        if (r20 == false) goto L76;
        com.larus.bmhome.chat.component.bottom.reference.a r41 = r7.g5();
        if (r41 == null) goto L94;
        r41.L60(r11, true);
    L94:
        return Unit.INSTANCE;
    L66:
        r33 = false;
        goto L67
    L48:
        r21 = false;
        goto L49
    L31:
        r16 = null;
    L34:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r17 = Result.constructor-impl(ResultKt.createFailure(th));
    L23:
        r11 = "";
        goto L24
    L18:
        r8 = r4;
        goto L19
    L10:
        r4 = null;
    L88:
        return Unit.INSTANCE;
    }
}
