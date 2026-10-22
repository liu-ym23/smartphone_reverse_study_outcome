package com.larus.bot.impl.common.util;

import com.larus.bmhome.chat.bean.RecommendBot;
import ic8.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class RecommendBotHelper {
    public static final RecommendBotHelper a = null;

    static {
        a = new RecommendBotHelper();
    }

    public RecommendBotHelper() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0097 -> B:28:0x009a). Please report as a decompilation issue!!! */
    public final Object a(List<RecommendBot> r9, List<String> r10, Continuation<? super List<RecommendBot>> r11) {
        if ((r11 instanceof RecommendBotHelper$filterBotInConversationList$1) == false) goto L7;
        RecommendBotHelper$filterBotInConversationList$1 r0 = (RecommendBotHelper$filterBotInConversationList$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L16;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        Iterator r13 = (Iterator) r0.L$2;
        HashMap r14 = (HashMap) r0.L$1;
        List<RecommendBot> r4 = (List) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        List r15 = (List) r12;
        if (r15 == null) goto L24;
        String r16 = (String) CollectionsKt.firstOrNull(r15);
        if (r16 == null) goto L24;
        r14.put(r16, Unit.INSTANCE);
    L24:
        if (r13.hasNext() == false) goto L33;
        wc9.e r17 = (wc9.e) r13.next();
        r0.L$0 = r4;
        r0.L$1 = r14;
        r0.L$2 = r13;
        r0.label = 2;
        r12 = n.c(r17, r0);
        if (r12 != r2) goto L28;
        return r2;
    L33:
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r4.iterator();
    L35:
        if (r19.hasNext() == false) goto L45;
        Object r5 = r19.next();
        RecommendBot r6 = (RecommendBot) r5;
        if (r6.j0() == false) goto L39;
    L42:
        boolean r7 = true;
    L43:
        if (r7 == true) goto L35;
        r18.add(r5);
        goto L35
    L39:
        if (r14.containsKey(r6.o()) == true) goto L42;
        r7 = false;
        goto L43
    L45:
        return r18;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        HashMap r20 = (HashMap) r0.L$1;
        List<RecommendBot> r110 = (List) r0.L$0;
        ResultKt.throwOnFailure(r12);
        HashMap r111 = r20;
        r9 = r110;
        Object r112 = r12;
    L22:
        r4 = r9;
        r13 = ((Iterable) r112).iterator();
        r14 = r111;
        goto L24
    L16:
        ResultKt.throwOnFailure(r12);
        if (r9.isEmpty() == false) goto L19;
        return r9;
    L19:
        r111 = new HashMap();
        r0.L$0 = r9;
        r0.L$1 = r111;
        r0.label = 1;
        r112 = BuildersKt.withContext(Dispatchers.getIO(), new RecommendBotHelper$findConversations$2(r10, null), r0);
        if (r112 != r2) goto L22;
        return r2;
    L7:
        r0 = new RecommendBotHelper$filterBotInConversationList$1(this, r11);
        goto L8
    }
}
