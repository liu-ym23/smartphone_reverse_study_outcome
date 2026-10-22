package com.larus.bmhome.chat.trace;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.im.bean.message.Message;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import tx9.z1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageTrace$onMultipleMessageDelete$1", f = "ChatMessageTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatMessageTrace$onMultipleMessageDelete$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Integer $botType;
    final /* synthetic */ String $clickFrom;
    final /* synthetic */ List<Message> $messages;
    final /* synthetic */ JSONObject $traceInfo;
    int label;

    public ChatMessageTrace$onMultipleMessageDelete$1(JSONObject r1, List<Message> r2, String r3, Integer r4, String r5, Continuation<? super ChatMessageTrace$onMultipleMessageDelete$1> r6) {
        this.$traceInfo = r1;
        this.$messages = r2;
        this.$botId = r3;
        this.$botType = r4;
        this.$clickFrom = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatMessageTrace$onMultipleMessageDelete$1(this.$traceInfo, this.$messages, this.$botId, this.$botType, this.$clickFrom, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r19) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L17;
        ResultKt.throwOnFailure(r19);
        JSONObject r15 = this.$traceInfo;
        List<Message> r1 = this.$messages;
        ArrayList r2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
        Iterator<T> r3 = r1.iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        r2.add(yc9.c0.b((Message) r3.next()));
        goto L6
    L8:
        HashMap r4 = (HashMap) CollectionsKt.firstOrNull(r2);
        if (r4 == null) goto L14;
        Iterator r5 = r4.entrySet().iterator();
    L12:
        if (r5.hasNext() == false) goto L14;
        Map.Entry r6 = (Map.Entry) r5.next();
        r15.put((String) r6.getKey(), (String) r6.getValue());
    L14:
        String r8 = CollectionsKt.joinToString$default(this.$messages, ",", null, null, 0, null, new w(), 30, null);
        ChatMessageTrace r7 = ChatMessageTrace.a;
        String r10 = ChatMessageTrace.a(this.$messages);
        z1.b(this.$botId, this.$botType, this.$clickFrom, null, null, null, r8, ShareType.TEXT, r10, null, null, null, null, r15, 24120);
        return Unit.INSTANCE;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
