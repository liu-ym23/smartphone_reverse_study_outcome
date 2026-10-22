package com.obric.assistant.util;

import com.larus.bmhome.chat.adapter.MessageAdapter;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.im.bean.message.Message;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class VContextMessageExKt {
    public static final Object a(t1a.b r6, String r7, Continuation<? super Message> r8) {
        if ((r8 instanceof VContextMessageExKt$queryMessage$1) == false) goto L7;
        VContextMessageExKt$queryMessage$1 r0 = (VContextMessageExKt$queryMessage$1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r9);
    L51:
        FLogger.a.i("VContextMessageEx", "queryMessage: found msgInRepo " + ((Message) r9));
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r9);
        FLogger.a.i("VContextMessageEx", "queryMessage: msgId " + r7);
        if (r7 != null) goto L17;
    L20:
        boolean r10 = true;
    L21:
        Message r4 = null;
        if (r10 == false) goto L24;
        return null;
    L24:
        u7 r11 = r6.getAbility(u7.class);
        if (r11 == null) goto L27;
        MessageAdapter r12 = r11.MF();
    L29:
        if ((r12 instanceof com.larus.bmhome.chat.adapter.i) == true) goto L32;
        r12 = null;
    L32:
        if (r12 == null) goto L45;
        List r13 = r12.getMessageList();
        if (r13 == null) goto L45;
        Iterator r14 = r13.iterator();
    L37:
        if (r14.hasNext() == false) goto L41;
        Object r15 = r14.next();
        if (Intrinsics.areEqual(((ic8.v) r15).a().getMessageId(), r7) == false) goto L37;
    L42:
        ic8.v r16 = (ic8.v) r15;
        if (r16 == null) goto L45;
        r4 = r16.a();
        goto L45
    L41:
        r15 = null;
    L45:
        if (r4 == null) goto L48;
        FLogger.a.i("VContextMessageEx", "queryMessage: found msgInList " + r4);
        return r4;
    L48:
        IChatRepoService r17 = zh8.a.a;
        r0.label = 1;
        r9 = r17.E1(r7, r0);
        if (r9 != r2) goto L51;
        return r2;
    L27:
        r12 = null;
        goto L29
    L17:
        if (r7.length() == 0) goto L20;
        r10 = false;
    L7:
        r0 = new VContextMessageExKt$queryMessage$1(r8);
        goto L8
    }
}
