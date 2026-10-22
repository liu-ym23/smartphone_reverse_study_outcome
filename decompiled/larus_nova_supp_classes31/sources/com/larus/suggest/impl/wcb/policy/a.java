package com.larus.suggest.impl.wcb.policy;

import com.larus.bmhome.chat.bean.NexPulseResponseData;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public final com.larus.suggest.impl.wcb.render.h a(hx9.l r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        if (com.larus.bmhome.chat.bean.d.U0() == false) goto L5;
        List<Message> r0 = r6.c();
        if (r0.isEmpty() == false) goto L9;
        r0 = r6.g();
    L9:
        Iterator<Message> r7 = r0.iterator();
    L11:
        if (r7.hasNext() == false) goto L46;
        Message r1 = r7.next();
        if (com.larus.bmhome.chat.bean.d.i0(r1) == false) goto L18;
        if (com.larus.bmhome.chat.bean.d.w(r1) == true) goto L18;
    L37:
        boolean r4 = false;
    L38:
        if (r4 == false) goto L11;
        if (gx9.p.a(r1) == true) goto L41;
        if (com.larus.bmhome.social.userchat.model.b0.f(r1) == true) goto L11;
    L41:
        int r2 = com.larus.suggest.impl.wcb.render.p.b;
        return new com.larus.suggest.impl.wcb.render.h(true, com.larus.suggest.impl.wcb.render.p.a.a(r1));
    L18:
        if (com.larus.bmhome.chat.bean.d.T(r1) == true) goto L37;
        if (com.larus.bmhome.chat.bean.d.p0(r1) == true) goto L37;
        if (com.larus.bmhome.chat.bean.d.C0(r1) == true) goto L25;
    L27:
        MessageStatus r5 = r1.getMessageStatus();
        if (r5 != null) goto L30;
    L32:
        boolean r8 = false;
    L33:
        if (r8 == false) goto L35;
    L36:
        r4 = true;
        goto L38
    L35:
        if (com.larus.bmhome.social.userchat.model.b0.f(r1) == false) goto L37;
    L30:
        if (r5.isVisible() != true) goto L32;
        r8 = true;
        goto L33
    L25:
        if (r1.getRegenVisible() == true) goto L27;
    L46:
        return new com.larus.suggest.impl.wcb.render.h(true, null);
    L5:
        return new com.larus.suggest.impl.wcb.render.h(false, null);
    }

    public final boolean b(com.larus.suggest.impl.wcb.request.f r2, NexPulseResponseData r3, hx9.l r4) {
        Intrinsics.checkNotNullParameter(r2, "snapshot");
        Intrinsics.checkNotNullParameter(r4, "context");
        if (r2.f.e != null) goto L5;
        return false;
    L5:
        if (r3 == null) goto L12;
        Integer r5 = r3.getNexPulseType();
        if (r5 == null) goto L12;
        if (r5.intValue() != 1) goto L12;
        boolean r6 = true;
    L13:
        if (r6 == false) goto L24;
        com.larus.suggest.impl.wcb.render.h r7 = a(r4);
        if (r7.a == true) goto L17;
    L19:
        boolean r8 = false;
    L20:
        if (r8 == false) goto L25;
        return true;
    L25:
        return false;
    L17:
        if (r7.b == null) goto L19;
        r8 = true;
        goto L20
    L24:
        return false;
    L12:
        r6 = false;
        goto L13
    }
}
