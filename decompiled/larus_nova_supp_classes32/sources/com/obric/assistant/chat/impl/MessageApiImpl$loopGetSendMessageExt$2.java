package com.obric.assistant.chat.impl;

import bda.b$a;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.impl.MessageApiImpl$loopGetSendMessageExt$2", f = "MessageApiImpl.kt", i = {0, 0}, l = {178}, m = "invokeSuspend", n = {"extras", "task"}, s = {"L$0", "L$2"})
final class MessageApiImpl$loopGetSendMessageExt$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Map<String, String>>, Object> {
    final /* synthetic */ Map<String, String> $originExt;
    final /* synthetic */ b$a $queryData;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public MessageApiImpl$loopGetSendMessageExt$2(b$a r1, Map<String, String> r2, Continuation<? super MessageApiImpl$loopGetSendMessageExt$2> r3) {
        this.$queryData = r1;
        this.$originExt = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        MessageApiImpl$loopGetSendMessageExt$2 r0 = new MessageApiImpl$loopGetSendMessageExt$2(this.$queryData, this.$originExt, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Map<String, String>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00c5 -> B:52:0x00c8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x0106 -> B:38:0x0131). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0136 -> B:41:0x0161). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r22) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        MessageApiImpl$b r4 = null;
        String r6 = "MessageApiImpl";
        if (r0 == 0) goto L13;
        if (r0 != 1) goto L12;
        MessageApiImpl$a r7 = (MessageApiImpl$a) this.L$2;
        Iterator r8 = (Iterator) this.L$1;
        Map r9 = (Map) this.L$0;
        ResultKt.throwOnFailure(r22);     // Catch: Exception -> L8 TimeoutCancellationException -> L10
        Object r1 = r22;
        MessageApiImpl$loopGetSendMessageExt$2 r3 = this;
    L52:
        long r10 = ((MessageApiImpl$b) r1).b - r7.b;     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        FLogger.a.i(r6, "loopGetSendMessageExt: called, get ext for scene(" + r7.a + ") cost " + r10);     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        int r12 = MessageApiTrace.a;     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        MessageApiTrace.a(r7.a, r10, MessageApiTrace.GetExtResultState.Default);     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        MessageApiImpl$b r5 = (MessageApiImpl$b) r1;     // Catch: Exception -> L30 TimeoutCancellationException -> L46
    L41:
        if (r5 == null) goto L19;
        Map<String, String> r11 = r5.a;
        if (r11 == null) goto L19;
        r9.putAll(r11);
    L19:
        if (r8.hasNext() == false) goto L45;
        r7 = (MessageApiImpl$a) r8.next();
        r4 = null;
        MessageApiImpl$loopGetSendMessageExt$2$2$1 r13 = new MessageApiImpl$loopGetSendMessageExt$2$2$1(r7, null);     // Catch: Exception -> L32 TimeoutCancellationException -> L47
        r3.L$0 = r9;     // Catch: Exception -> L32 TimeoutCancellationException -> L47
        r3.L$1 = r8;     // Catch: Exception -> L32 TimeoutCancellationException -> L47
        r3.L$2 = r7;     // Catch: Exception -> L32 TimeoutCancellationException -> L47
        goto L40
    L25:
        r3.label = 1;     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        r1 = TimeoutKt.b(1000, r13, r3);     // Catch: Exception -> L30 TimeoutCancellationException -> L46
        if (r1 != r2) goto L52;
        return r2;
    L32:
        Exception e = e;
    L37:
        long r14 = System.currentTimeMillis() - r7.b;
        FLogger.a.e(r6, "loopGetSendMessageExt: called, error for scene(" + r7.a + ')', e);
        int r15 = MessageApiTrace.a;
        MessageApiTrace.a(r7.a, r14, MessageApiTrace.GetExtResultState.Error);
        r5 = r4;
        goto L41
    L39:
        r4 = null;
    L35:
        e = e;
        r4 = null;
        goto L37
    L45:
        return r9;
    L30:
        e = e;
    L40:
        long r16 = System.currentTimeMillis() - r7.b;
        FLogger.a.e(r6, "loopGetSendMessageExt: called, timeout for scene(" + r7.a + ')');
        int r17 = MessageApiTrace.a;
        MessageApiTrace.a(r7.a, r16, MessageApiTrace.GetExtResultState.Timeout);
        r5 = r4;
        goto L41
    L8:
        e = e;
        r3 = this;
    L10:
        r3 = this;
        goto L40
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r22);
        CoroutineScope r18 = (CoroutineScope) this.L$0;
        LinkedHashMap r19 = new LinkedHashMap();
        CopyOnWriteArrayList r20 = MessageApiImpl.c;
        b$a r110 = this.$queryData;
        Map<String, String> r111 = this.$originExt;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r20, 10));
        Iterator r113 = r20.iterator();
    L15:
        if (r113.hasNext() == false) goto L17;
        bda.b r21 = (bda.b) r113.next();
        String r114 = r21.getScene();
        long r23 = System.currentTimeMillis();
        CoroutineDispatcher r24 = Dispatchers.getIO();
        MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1 r25 = new MessageApiImpl$loopGetSendMessageExt$2$1$deferred$1(r110, r21, r111, r4);
        ArrayList r26 = r112;
        r26.add(new MessageApiImpl$a(r114, r23, BuildersKt.async$default(r18, r24, null, r25, 2, null)));
        r112 = r26;
        r6 = r6;
        r4 = null;
        goto L15
    L17:
        r8 = r112.iterator();
        r3 = this;
        r9 = r19;
        goto L19
    }
}
