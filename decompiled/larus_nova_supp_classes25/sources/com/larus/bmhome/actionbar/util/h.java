package com.larus.bmhome.actionbar.util;

import com.larus.bmhome.actionbar.model.r;
import com.larus.bmhome.chat.model.ChatDraftItem;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import ouc.v;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class h {
    public static final r a(Message r4) {
        Intrinsics.checkNotNullParameter(r4, "<this>");
        Map r0 = r4.getExt();
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        Object r2 = null;
        if (r1 == false) goto L26;
        return null;
    L26:
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L18
        v r5 = xt7.d.b;     // Catch: Throwable -> L18
        juc.c r6 = r.Companion.serializer();     // Catch: Throwable -> L18
        Map r7 = r4.getExt();     // Catch: Throwable -> L18
        if (r7 == null) goto L15;
        String r8 = (String) r7.get(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION);     // Catch: Throwable -> L18
        if (r8 == null) goto L15;
    L16:
        Object r9 = Result.constructor-impl((r) r5.c(r6, r8));     // Catch: Throwable -> L18
    L21:
        if (Result.isFailure-impl(r9) == true) goto L25;
        r2 = r9;
    L25:
        return (r) r2;
    L15:
        r8 = "";
    L18:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L21
    L5:
        if (r0.containsKey(ChatDraftItem.TYPE_ACTION_BAR_INSTRUCTION) == true) goto L7;
        r1 = true;
        goto L8
    }
}
