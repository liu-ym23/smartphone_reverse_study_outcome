package com.larus.bmhome.chat.component.list;

import android.content.Context;
import com.larus.im.callback.IIMError;
import com.larus.mainbot.api.IFlowMainBot;
import com.larus.platform.spi.IAIChatService;
import com.larus.utils.SafeExtKt;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import ji8.a;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ub8.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class f5 implements Function1 {
    public final /* synthetic */ ChatListComponent a;

    public /* synthetic */ f5(ChatListComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r12) {
        final ChatListComponent r0 = this.a;
        b r13 = (b) r12;
        int r1 = ChatListComponent.W3;
        uc9.t r2 = r13.a;
        if (r2 == null) goto L7;
        boolean r3 = true;
        if (r2.a != true) goto L7;
    L8:
        Long r4 = null;
        if (r3 == false) goto L22;
        IFlowMainBot.a.a(IFlowMainBot.a, r0.O, false, null, 6);
        com.larus.bmhome.setting.b r5 = IAIChatService.a.k8();
        String r14 = r0.getBotId();
        if (r14 != null) goto L13;
        String r9 = "";
    L14:
        r5.b(1, 200, r9, "");
        SafeExtKt.b(r0.F2(), new j0(r0), 500);
        CopyOnWriteArrayList r15 = a.a;
        String r16 = r0.G4();
        Iterator r6 = a.a.iterator();
    L16:
        if (r6.hasNext() == false) goto L51;
        a.a r7 = (a.a) r6.next();
        Result.Companion r8 = Result.Companion;     // Catch: Throwable -> L20
        r7.onContextCleared(r16);     // Catch: Throwable -> L20
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    L51:
        return Unit.INSTANCE;
    L13:
        r9 = r14;
        goto L14
    L22:
        IIMError r11 = r13.c;
        if (r11 == null) goto L25;
        String r17 = r11.getTips();
    L27:
        if (com.larus.utils.o0.d(r17) == false) goto L33;
        IIMError r18 = r13.c;
        if (r18 == null) goto L31;
        String r19 = r18.getTips();
    L32:
        Intrinsics.checkNotNull(r19);
    L34:
        com.larus.bmhome.setting.b r20 = IAIChatService.a.k8();
        IIMError r21 = r13.c;
        if (r21 == null) goto L37;
        long r22 = r21.getCode();
    L38:
        String r23 = r0.getBotId();
        if (r23 != null) goto L41;
        r23 = "";
    L41:
        r20.b(0, r22, r23, r19);
        IIMError r110 = r13.c;
        if (r110 == null) goto L44;
        r4 = Long.valueOf(r110.getCode());
    L44:
        if (r4 != null) goto L47;
    L49:
        t19.s r111 = t19.s.a;
        Context r24 = r0.getContext();
        int r25 = ChatListComponent.a.a(false);
        r111.getClass();
        t19.s.b(r24, r25, false);
        goto L51
    L47:
        if (r4.longValue() != 710014001) goto L49;
        t19.s r112 = t19.s.a;
        Context r26 = r0.getContext();
        r112.getClass();
        t19.s.t(r26, r19);
        goto L51
    L37:
        r22 = 0;
        goto L38
    L31:
        r19 = null;
        goto L32
    L33:
        r19 = "unknown error";
        goto L34
    L25:
        r17 = null;
    L7:
        r3 = false;
        goto L8
    }
}
