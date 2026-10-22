package com.larus.suggest.impl.wcb.loading;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.chat.list.cell.prompt.w0;
import com.larus.bmhome.social.userchat.model.b0;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import com.larus.im.bean.message.MessageTag;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements td8.c {
    public final td8.d a;

    public d(td8.d r2) {
        Intrinsics.checkNotNullParameter(r2, "taskContext");
        this.a = r2;
    }

    public final boolean a(int r6, xc8.b r7, xc8.b r8, List<? extends xc8.b> r9) {
        Intrinsics.checkNotNullParameter(r8, "current");
        Intrinsics.checkNotNullParameter(r9, "input");
        ConcurrentHashMap<Long, b> r10 = c.a;
        b r11 = c.a(this.a.b());
        if (r11 != null) goto L5;
        return false;
    L5:
        Iterator<T> r12 = r9.iterator();
    L6:
        Message r1 = null;
        if (r12.hasNext() == false) goto L41;
        Object r13 = r12.next();
        xc8.b r2 = (xc8.b) r13;
        Message r3 = r2.getMessage();
        if (com.larus.bmhome.chat.bean.d.i0(r3) == false) goto L14;
        if (com.larus.bmhome.chat.bean.d.w(r3) == true) goto L14;
    L33:
        boolean r4 = false;
    L34:
        if (r4 == true) goto L36;
    L38:
        boolean r5 = false;
    L39:
        if (r5 == false) goto L6;
    L42:
        xc8.b r14 = (xc8.b) r13;
        if (r14 == null) goto L45;
        r1 = r14.getMessage();
    L45:
        if (r1 != null) goto L47;
    L49:
        boolean r15 = false;
    L50:
        if (r15 == false) goto L56;
        if (Intrinsics.areEqual(r1.getLocalMessageId(), r11.i) == true) goto L56;
        ConcurrentHashMap<Long, b> r16 = c.a;
        c.b(r11.a, r11.b);
        FLogger.a.d("WcbLog", "[WcbLoadingTask] list.yieldToUserMessage chat=" + r11.a + " exec=" + r11.b + " latest=" + r1.getLocalMessageId() + " boundary=" + r11.i);
        return false;
    L56:
        if (r11.n == true) goto L58;
        return false;
    L58:
        if (r11.o.isCompleted() == true) goto L67;
        return true;
    L67:
        return false;
    L47:
        if (com.larus.bmhome.chat.bean.d.G0(r1) != true) goto L49;
        r15 = true;
        goto L50
    L36:
        if (b0.f(r2.getMessage()) == true) goto L38;
        r5 = true;
    L14:
        if (com.larus.bmhome.chat.bean.d.T(r3) == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.p0(r3) == true) goto L33;
        if (com.larus.bmhome.chat.bean.d.C0(r3) == true) goto L21;
    L23:
        MessageStatus r17 = r3.getMessageStatus();
        if (r17 != null) goto L26;
    L28:
        boolean r18 = false;
    L29:
        if (r18 == false) goto L31;
    L32:
        r4 = true;
        goto L34
    L31:
        if (b0.f(r3) == false) goto L33;
    L26:
        if (r17.isVisible() != true) goto L28;
        r18 = true;
        goto L29
    L21:
        if (r3.getRegenVisible() == true) goto L23;
    L41:
        r13 = null;
        goto L42
    }

    public final List<xc8.b> b(int r99, xc8.b r100, xc8.b r101, List<xc8.b> r102) {
        Intrinsics.checkNotNullParameter(r101, "current");
        Intrinsics.checkNotNullParameter(r102, "input");
        ConcurrentHashMap<Long, b> r1 = c.a;
        b r2 = c.a(this.a.b());
        if (r2 != null) goto L5;
        return r102;
    L5:
        Map r3 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("next_pulse_scene", String.valueOf(r2.e)), TuplesKt.to("next_pulse_type", "1"), TuplesKt.to("wcb_message_hidden", "true"), TuplesKt.to("wcb_title", r2.k), TuplesKt.to("wcb_title_style", String.valueOf(r2.l))});
        String r9 = r2.c;
        String r11 = r2.d;
        String r4 = r2.g;
        MessageStatus r14 = MessageStatus.MessageStatus_AVAILABLE;
        String r5 = r2.j;
        List r41 = CollectionsKt.listOf(Integer.valueOf(MessageTag.MessageTag_Onboarding_WELCOMEBACK.value));
        Map r6 = MapsKt.toMutableMap(r3);
        r6.put("transient_wcb_loading_session_id", String.valueOf(r2.b));
        Message r7 = Message.copy$default(b0.j(new Message(r9, null, r11, 0, 21, r14, 2, false, null, null, null, null, null, r3, r4, r4, 0, 0, false, r5, null, null, r6, null, null, 0, false, 0, null, r41, false, null, null, 0, null, null, null, -541646966, 31, null), 1), null, null, null, 0, 0, null, 0, false, null, null, null, null, null, null, r2.h, null, 0, 0, false, null, null, null, null, null, null, 0, false, 0, null, null, false, null, null, 0, null, null, null, -16385, 31, null);
        ListProtector.add(r102, 0, new w0(r7));
        FLogger.a.d("WcbLog", "[WcbLoadingTask] list.insertSkeleton chat=" + r2.a + " exec=" + r2.b + " localId=" + r7.getLocalMessageId() + " size=" + r102.size() + " index=" + r99);
        return r102;
    }
}
