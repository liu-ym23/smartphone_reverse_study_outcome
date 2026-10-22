package com.obric.miniapp.intent;

import com.larus.im.bean.message.Message;
import java.util.List;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class LatestConversationSentMessageResolver {
    public static final LatestConversationSentMessageResolver a = null;

    static {
        a = new LatestConversationSentMessageResolver();
    }

    public LatestConversationSentMessageResolver() {
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a5 -> B:29:0x00a8). Please report as a decompilation issue!!! */
    public final Object a(String r18, String r19, Set<String> r20, Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r21, Continuation<? super Boolean> r22) {
        if ((r22 instanceof LatestConversationSentMessageResolver$isReplyToLatest$1) == false) goto L7;
        LatestConversationSentMessageResolver$isReplyToLatest$1 r1 = (LatestConversationSentMessageResolver$isReplyToLatest$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        boolean r6 = false;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Ref.LongRef r5 = (Ref.LongRef) r1.L$4;
        Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r8 = (Function4) r1.L$3;
        Set<String> r9 = (Set) r1.L$2;
        String r10 = (String) r1.L$1;
        final String r11 = (String) r1.L$0;
        ResultKt.throwOnFailure(r0);
        LatestConversationSentMessageResolver$isReplyToLatest$1 r12 = r1;
        String r7 = r10;
        final Ref.LongRef r13 = r5;
        Function4<? super String, ? super Long, ? super Integer, ? super Continuation<? super List<Message>>, ? extends Object> r14 = r8;
        Object r15 = r3;
        final Set<String> r16 = r9;
    L29:
        List r17 = (List) r0;
        Message r110 = (Message) SequencesKt.maxWithOrNull(SequencesKt.filter(SequencesKt.filter(SequencesKt.filter(CollectionsKt.asSequence(r17), new n(r11)), new o()), new p(r16)), new r(new q()));
        if (r110 == null) goto L39;
        if (Intrinsics.areEqual(r7, r110.getMessageId()) == false) goto L34;
    L35:
        r6 = true;
    L37:
        return Boxing.boxBoolean(r6);
    L34:
        if (Intrinsics.areEqual(r7, r110.getLocalMessageId()) == false) goto L37;
    L39:
        if (r17.size() < 50) goto L41;
        Long r23 = (Long) SequencesKt.minOrNull(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence(r17), new l()), new m(r13)));
        if (r23 == null) goto L46;
        r13.element = r23.longValue();
        String r24 = r11;
    L25:
        Long r111 = Boxing.boxLong(r13.element);
        Integer r112 = Boxing.boxInt(50);
        r12.L$0 = r24;
        r12.L$1 = r7;
        r12.L$2 = r16;
        r12.L$3 = r14;
        r12.L$4 = r13;
        r12.label = 1;
        Object r113 = r14.invoke(r24, r111, r112, r12);
        if (r113 != r15) goto L28;
        return r15;
    L28:
        r11 = r24;
        r0 = r113;
        goto L29
    L46:
        return Boxing.boxBoolean(false);
    L41:
        return Boxing.boxBoolean(false);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        if (StringsKt.isBlank(r18) == true) goto L48;
        if (r19 != null) goto L18;
    L21:
        boolean r25 = true;
    L22:
        if (r25 == true) goto L48;
        Ref.LongRef r26 = new Ref.LongRef();
        r26.element = Long.MAX_VALUE;
        r14 = r21;
        r13 = r26;
        r12 = r1;
        r15 = r3;
        r24 = r18;
        r7 = r19;
        r16 = r20;
        goto L25
    L18:
        if (StringsKt.isBlank(r19) == true) goto L21;
        r25 = false;
    L48:
        return Boxing.boxBoolean(false);
    L7:
        r1 = new LatestConversationSentMessageResolver$isReplyToLatest$1(this, r22);
        goto L8
    }
}
