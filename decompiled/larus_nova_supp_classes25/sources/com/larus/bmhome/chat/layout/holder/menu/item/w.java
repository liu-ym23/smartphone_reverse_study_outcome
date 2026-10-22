package com.larus.bmhome.chat.layout.holder.menu.item;

import android.content.Context;
import android.view.View;
import com.larus.bmhome.chat.component.bottom.floating.collect.CollectFrom;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.trace.ChatControlTrace;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import com.larus.platform.api.OpenPushReminderScene;
import com.larus.platform.service.z1;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class w extends a {
    public w() {
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean a(int r4) {
        return CollectionsKt.listOf(new Integer[]{2131907405, 2131908738}).contains(Integer.valueOf(r4));
    }

    public static final void e(ef8.b r3, View r4) {
        com.larus.bmhome.chat.api.q0.a r0 = r3.b;
        if (r0 == null) goto L12;
        ld8.n r1 = r0.K9();
        if (r1 == null) goto L12;
        CollectFrom r2 = CollectFrom.LIKE;
        String r5 = r3.a.getMessageId();
        if (r5 != null) goto L9;
        r5 = "";
    L9:
        boolean r6 = r1.Ho(r2, r5);
        boolean r7 = true;
        if (r6 != true) goto L12;
    L13:
        if (r7 == true) goto L16;
        t19.s r8 = t19.s.a;
        Context r9 = r4.getContext();
        r8.getClass();
        t19.s.o(r9, 2131910469, false);
        return;
    L16:
        return;
    L12:
        r7 = false;
        goto L13
    }

    public static final void f(final ef8.b r9, final View r10) {
        com.larus.bmhome.chat.api.q0.a r0 = r9.b;
        BotModel r1 = null;
        if (r0 == null) goto L7;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L7;
        wc9.e r3 = r2.h();
    L8:
        if (r3 == null) goto L10;
        String r4 = r3.a;
    L12:
        if (Intrinsics.areEqual(r4, r9.a.getConversationId()) == true) goto L14;
    L32:
        e(r9, r10);
        return;
    L14:
        if (ic8.n.v(r3) == true) goto L18;
        if (ic8.n.D(r3) == false) goto L32;
    L18:
        if (com.larus.bmhome.chat.bean.d.G0(r9.a) == true) goto L32;
        com.larus.bmhome.chat.api.q0.a r5 = r9.b;
        if (r5 == null) goto L31;
        com.larus.bmhome.chat.component.push.a r6 = r5.a9();
        if (r6 == null) goto L31;
        OpenPushReminderScene r7 = OpenPushReminderScene.LikeMsgForMainBot;
        com.larus.bmhome.chat.component.cvs.y r8 = r9.b.u0();
        if (r8 == null) goto L26;
        wc9.e r11 = r8.h();
    L27:
        com.larus.bmhome.chat.component.cvs.y r12 = r9.b.u0();
        if (r12 == null) goto L30;
        r1 = r12.j0();
    L30:
        com.larus.bmhome.chat.component.push.a$a.a(r6, r7, r11, r1, null, new v(r9, r10), 8);
        return;
    L26:
        r11 = null;
    L31:
        e(r9, r10);
        return;
    L10:
        r4 = null;
    L7:
        r3 = null;
        goto L8
    }

    @Override // com.larus.bmhome.chat.layout.holder.menu.item.a
    public final boolean c(ot8.a r6, final View r7, final ef8.b r8) {
        Intrinsics.checkNotNullParameter(r6, "item");
        Intrinsics.checkNotNullParameter(r7, "view");
        Intrinsics.checkNotNullParameter(r8, "menuContext");
        if (com.larus.bmhome.chat.bean.d.q0(r8.a) == false) goto L9;
        com.larus.bmhome.chat.api.q0.a r9 = r8.b;
        if (r9 == null) goto L22;
        u7 r10 = r9.u3();
        if (r10 == null) goto L23;
        r10.fh(r8.a, 8);
        return true;
    L23:
        return true;
    L22:
        return true;
    L9:
        ChatControlTrace r11 = ChatControlTrace.b;
        Message r1 = r8.a;
        by7.e r2 = r8.d;
        Function0<Long> r3 = r8.e;
        if (r3 == null) goto L12;
        long r4 = ((Number) r3.invoke()).longValue();
    L13:
        r11.getClass();
        ChatControlTrace.M("long_press_answer", r1, r2, r4);
        final boolean r12 = z1.a.d();
        com.larus.bmhome.chat.api.q0.a r5 = r8.b;
        if (r5 == null) goto L18;
        u7 r13 = r5.u3();
        if (r13 == null) goto L18;
        r13.OD(r8.a, 8, new u(r12, r8, this, r7));
    L18:
        if (r12 == true) goto L25;
        f(r8, r7);
        return true;
    L25:
        return true;
    L12:
        r4 = -1;
        goto L13
    }
}
