package com.larus.bmhome.utils;

import com.larus.bmhome.chat.ChatParam;
import com.larus.im.bean.bot.BotModel;
import com.larus.im.bean.message.Message;
import kc8.b;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class z3 {
    public static final fh8.g a(b r4, Message r5) {
        if (r4 == null) goto L60;
        final kc8.y r0 = r4.a;
        if (r0 == null) goto L60;
        fh8.g r1 = new fh8.g();
        Function0 r2 = r0.l;
        Function0 r3 = null;
        if (r2 == null) goto L11;
        BotModel r6 = (BotModel) r2.invoke();
        if (r6 == null) goto L11;
        String r7 = r6.getBotId();
    L12:
        r1.d = r7;
        Function0 r8 = r0.f;
        if (r8 == null) goto L15;
        String r9 = (String) r8.invoke();
    L16:
        r1.c = r9;
        r1.b = r5;
        r1.g = r0.y;
        r1.q = r0.x;
        Function0 r10 = r0.m;
        if (r10 == null) goto L21;
        ChatParam r11 = (ChatParam) r10.invoke();
        if (r11 == null) goto L21;
        String r12 = r11.e;
    L22:
        r1.a = r12;
        Function0 r13 = r0.m;
        if (r13 == null) goto L27;
        ChatParam r14 = (ChatParam) r13.invoke();
        if (r14 == null) goto L27;
        String r15 = r14.d;
    L28:
        r1.e = r15;
        Function0 r16 = r0.m;
        if (r16 == null) goto L33;
        ChatParam r17 = (ChatParam) r16.invoke();
        if (r17 == null) goto L33;
        String r18 = r17.c;
    L34:
        r1.f = r18;
        Boolean r19 = r0.g;
        if (r19 == null) goto L37;
        boolean r20 = r19.booleanValue();
    L38:
        r1.h = Boolean.valueOf(r20);
        r1.l = new y3(r0);
        r1.m = r0.u;
        r1.n = r0.v;
        r1.o = r0.w;
        r1.g = r0.y;
        r1.k = r0.t;
        r1.s = r0.s;
        kc8.v0 r21 = r4.c;
        if (r21 == null) goto L41;
        bc8.b r22 = r21.i;
    L42:
        r1.t = r22;
        r1.x = r0.F;
        r1.y = r0.I;
        kc8.j r23 = r0.r;
        if (r23 == null) goto L45;
        Function1 r24 = r23.m;
    L46:
        r1.z = r24;
        if (r21 == null) goto L49;
        jh8.a r25 = r21.o;
    L50:
        r1.A = r25;
        kc8.x0 r26 = r4.t;
        if (r26 == null) goto L53;
        Function0 r27 = r26.d;
    L54:
        r1.B = r27;
        if (r26 == null) goto L57;
        r3 = r26.e;
    L57:
        r1.C = r3;
        return r1;
    L53:
        r27 = null;
        goto L54
    L49:
        r25 = null;
        goto L50
    L45:
        r24 = null;
        goto L46
    L41:
        r22 = null;
        goto L42
    L37:
        r20 = false;
    L33:
        r18 = null;
    L27:
        r15 = null;
    L21:
        r12 = null;
        goto L22
    L15:
        r9 = null;
    L11:
        r7 = null;
    L60:
        return new fh8.g();
    }
}
