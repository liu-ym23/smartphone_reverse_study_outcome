package com.larus.bmhome.chat.trace;

import com.larus.bmhome.share.panel.ShareType;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
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
@DebugMetadata(c = "com.larus.bmhome.chat.trace.ChatMessageTrace$onMultiMessageDeleteResult$1", f = "ChatMessageTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatMessageTrace$onMultiMessageDeleteResult$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $botId;
    final /* synthetic */ Integer $botType;
    final /* synthetic */ List<Message> $data;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ boolean $isSuccess;
    final /* synthetic */ JSONObject $traceInfo;
    int label;

    public ChatMessageTrace$onMultiMessageDeleteResult$1(JSONObject r1, List<Message> r2, boolean r3, String r4, Integer r5, String r6, Continuation<? super ChatMessageTrace$onMultiMessageDeleteResult$1> r7) {
        this.$traceInfo = r1;
        this.$data = r2;
        this.$isSuccess = r3;
        this.$botId = r4;
        this.$botType = r5;
        this.$errMsg = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new ChatMessageTrace$onMultiMessageDeleteResult$1(this.$traceInfo, this.$data, this.$isSuccess, this.$botId, this.$botType, this.$errMsg, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r20) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r20);
        JSONObject r1 = this.$traceInfo;
        List<Message> r2 = this.$data;
        ArrayList r3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r2, 10));
        Iterator<T> r4 = r2.iterator();
    L6:
        if (r4.hasNext() == false) goto L8;
        r3.add(yc9.c0.b((Message) r4.next()));
        goto L6
    L8:
        HashMap r5 = (HashMap) CollectionsKt.firstOrNull(r3);
        if (r5 == null) goto L14;
        Iterator r6 = r5.entrySet().iterator();
    L12:
        if (r6.hasNext() == false) goto L14;
        Map.Entry r7 = (Map.Entry) r6.next();
        r1.put((String) r7.getKey(), (String) r7.getValue());
    L14:
        String r10 = CollectionsKt.joinToString$default(this.$data, ",", null, null, 0, null, new v(), 30, null);
        ChatMessageTrace r8 = ChatMessageTrace.a;
        String r12 = ChatMessageTrace.a(this.$data);
        if (this.$isSuccess == false) goto L17;
        String r9 = "1";
    L18:
        String r11 = r9;
        z1.c(this.$botId, this.$botType, "share_panel", null, this.$errMsg, null, null, r11, r10, ShareType.TEXT, r12, null, null, null, null, r1, 96360);
        return Unit.INSTANCE;
    L17:
        r9 = TriggerSendLoading.NO_LOADING;
        goto L18
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
