package com.larus.suggest.impl.wcb.policy;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.MessageStatus;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.coroutines.Continuation;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m implements t {
    public static final m a = null;

    static {
        a = new m();
    }

    public m() {
    }

    @Override // com.larus.suggest.impl.wcb.policy.t
    public final Object a(com.larus.suggest.impl.wcb.request.f r4, hx9.l r5, Continuation<? super s> r6) {
        List<Message> r7 = r5.c();
        boolean r8 = false;
        if ((r7 instanceof Collection) == true) goto L5;
    L7:
        Iterator<T> r9 = r7.iterator();
    L9:
        if (r9.hasNext() == false) goto L51;
        Message r10 = (Message) r9.next();
        if (com.larus.bmhome.chat.bean.d.i0(r10) == false) goto L16;
        if (com.larus.bmhome.chat.bean.d.w(r10) == true) goto L16;
    L35:
        boolean r0 = false;
    L36:
        if (r0 == true) goto L38;
    L48:
        boolean r11 = false;
    L49:
        if (r11 == false) goto L9;
        r8 = true;
        goto L51
    L38:
        if (com.larus.bmhome.chat.bean.d.W0(r10) == true) goto L48;
        if (com.larus.bmhome.chat.bean.d.G0(r10) == false) goto L42;
    L47:
        r11 = true;
        goto L49
    L42:
        if (com.larus.bmhome.social.userchat.model.b0.f(r10) == true) goto L48;
        if (r10.getContentType() == 2) goto L48;
        if (r10.getContentType() == 1001) goto L48;
    L16:
        if (com.larus.bmhome.chat.bean.d.T(r10) == true) goto L35;
        if (com.larus.bmhome.chat.bean.d.p0(r10) == true) goto L35;
        if (com.larus.bmhome.chat.bean.d.C0(r10) == true) goto L23;
    L25:
        MessageStatus r1 = r10.getMessageStatus();
        if (r1 != null) goto L28;
    L30:
        boolean r2 = false;
    L31:
        if (r2 == false) goto L33;
    L34:
        r0 = true;
        goto L36
    L33:
        if (com.larus.bmhome.social.userchat.model.b0.f(r10) == false) goto L35;
    L28:
        if (r1.isVisible() != true) goto L30;
        r2 = true;
        goto L31
    L23:
        if (r10.getRegenVisible() == true) goto L25;
    L51:
        if (r8 == false) goto L54;
        return new s.b("new conversation has messages");
    L54:
        return s.a.a;
    L5:
        if (r7.isEmpty() == false) goto L7;
        goto L7
    }
}
