package com.larus.bmhome.chat.layout.holder.helper;

import android.content.Context;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q1 implements t0 {
    public final List<String> a;

    public q1() {
        this.a = new ArrayList();
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final void b(List<String> r2) {
        Intrinsics.checkNotNullParameter(r2, "keys");
        ArrayList r0 = (ArrayList) this.a;
        r0.addAll(r2);
    }

    @Override // com.larus.bmhome.chat.layout.holder.helper.t0
    public final List<ot8.a> a(Context r7, Message r8, Function0<Message> r9, com.larus.bmhome.chat.api.q0 r10, BotModel r11, wc9.e r12, com.larus.bmhome.chat.api.q0.a r13, JSONObject r14) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "data");
        Intrinsics.checkNotNullParameter(r11, "chatBot");
        ArrayList r15 = new ArrayList();
        r15.add(com.larus.bmhome.chat.layout.holder.menu.item.j.a(null));
        r15.add(com.larus.bmhome.chat.layout.holder.menu.item.u0.a());
        if (com.larus.bmhome.chat.bean.d.b0(r8) == true) goto L7;
        com.larus.bmhome.view.screenmenu.l0 r16 = com.larus.bmhome.chat.layout.holder.menu.item.d1.a(r8, r13);
        if (r16 == null) goto L7;
        r15.add(r16);
    L7:
        IObricChatUIService r0 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r0 == null) goto L10;
        r0.M(r7, r8, r11, r12, r15);
    L10:
        List<ot8.a> r17 = e.b(r15);
        Intrinsics.checkNotNullParameter(r17, "<this>");
        Intrinsics.checkNotNullParameter(r8, "data");
        if (com.larus.im.bean.message.a.f0(r8) == false) goto L31;
        String r18 = com.larus.im.bean.message.a.K(r8);
        if (r18 != null) goto L15;
    L18:
        boolean r19 = true;
    L19:
        if (r19 == false) goto L31;
        ArrayList r20 = new ArrayList();
        Iterator r21 = r17.iterator();
    L22:
        if (r21.hasNext() == false) goto L29;
        Object r110 = r21.next();
        if (((ot8.a) r110).getId() != 2131907410) goto L26;
        boolean r1 = true;
    L27:
        if (r1 == true) goto L22;
        r20.add(r110);
        goto L22
    L26:
        r1 = false;
        goto L27
    L29:
        r17 = r20;
        goto L31
    L15:
        if (r18.length() == 0) goto L18;
        r19 = false;
    L31:
        if (Intrinsics.areEqual(com.larus.utils.l.b(r8, "need_filter_select"), Boolean.TRUE) == false) goto L42;
        ArrayList r22 = new ArrayList();
        Iterator r23 = r17.iterator();
    L34:
        if (r23.hasNext() == false) goto L41;
        Object r111 = r23.next();
        if (((ot8.a) r111).getId() != 2131907407) goto L38;
        boolean r2 = true;
    L39:
        if (r2 == true) goto L34;
        r22.add(r111);
        goto L34
    L38:
        r2 = false;
        goto L39
    L41:
        r17 = r22;
    L42:
        ArrayList r24 = new ArrayList();
        Iterator r25 = r17.iterator();
    L44:
        if (r25.hasNext() == false) goto L59;
        Object r112 = r25.next();
        ot8.a r113 = (ot8.a) r112;
        int r3 = uc9.a.a;
        List<String> r4 = this.a;
        Intrinsics.checkNotNullParameter(r4, "answerActions");
        ArrayList r5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r4, 10));
        Iterator r6 = ((ArrayList) r4).iterator();
    L47:
        if (r6.hasNext() == false) goto L57;
        String r26 = (String) r6.next();
        if (Intrinsics.areEqual(r26, "select-text") == false) goto L52;
        Integer r27 = 2131907407;
    L55:
        r5.add(r27);
        goto L47
    L52:
        if (Intrinsics.areEqual(r26, "tts") == false) goto L54;
        r27 = 2131907410;
        goto L55
    L54:
        r27 = null;
        goto L55
    L57:
        if ((!r5.contains(Integer.valueOf(r113.getId()))) == false) goto L44;
        r24.add(r112);
        goto L44
    L59:
        return r24;
    }
}
