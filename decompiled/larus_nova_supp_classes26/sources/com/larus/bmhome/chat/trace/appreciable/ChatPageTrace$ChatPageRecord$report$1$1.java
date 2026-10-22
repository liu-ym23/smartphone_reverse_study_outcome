package com.larus.bmhome.chat.trace.appreciable;

import com.larus.common.apphost.AppHost;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.trace.appreciable.ChatPageTrace$ChatPageRecord$report$1$1", f = "ChatPageTrace.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ChatPageTrace$ChatPageRecord$report$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $jsonObject;
    int label;
    final /* synthetic */ ChatPageTrace.ChatPageRecord this$0;

    public ChatPageTrace$ChatPageRecord$report$1$1(ChatPageTrace.ChatPageRecord r1, JSONObject r2, Continuation<? super ChatPageTrace$ChatPageRecord$report$1$1> r3) {
        this.this$0 = r1;
        this.$jsonObject = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ChatPageTrace$ChatPageRecord$report$1$1(this.this$0, this.$jsonObject, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        ChatPageTrace.ChatPageRecord.access$writeFileToExternalStorage(this.this$0, AppHost.a.getApplication(), "conversation_" + this.this$0.getCvsId() + ".json", this.$jsonObject.toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
