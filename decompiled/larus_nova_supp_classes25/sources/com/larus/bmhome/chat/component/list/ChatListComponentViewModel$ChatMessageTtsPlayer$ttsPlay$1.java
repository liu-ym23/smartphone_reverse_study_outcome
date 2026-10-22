package com.larus.bmhome.chat.component.list;

import androidx.lifecycle.Lifecycle;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.TextContent;
import com.larus.platform.service.o;
import com.larus.tts.TtsScene;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.spi.audio.ObricTtsControlDelegate;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.list.ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1", f = "ChatListComponentViewModel.kt", i = {}, l = {1665}, m = "invokeSuspend", n = {}, s = {})
final class ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TtsScene $fromScene;
    final /* synthetic */ boolean $isStreamingUpdate;
    final /* synthetic */ Message $msg;
    int label;
    final /* synthetic */ ChatListComponentViewModel$a this$0;
    final /* synthetic */ ChatListComponentViewModel this$1;

    public ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1(ChatListComponentViewModel$a r1, Message r2, boolean r3, ChatListComponentViewModel r4, TtsScene r5, Continuation<? super ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1> r6) {
        this.this$0 = r1;
        this.$msg = r2;
        this.$isStreamingUpdate = r3;
        this.this$1 = r4;
        this.$fromScene = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ChatListComponentViewModel$ChatMessageTtsPlayer$ttsPlay$1(this.this$0, this.$msg, this.$isStreamingUpdate, this.this$1, this.$fromScene, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r10v0, types: [com.larus.bmhome.chat.component.list.o7] */
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L14:
        if (((Boolean) r12).booleanValue() == false) goto L16;
    L17:
        ChatListComponentViewModel$a r13 = this.this$0;
        Message r3 = this.$msg;
        r13.getClass();
        TextContent r14 = ChatListComponentViewModel$a.c(r3);
        String r4 = null;
        if (r14 == null) goto L20;
        String r15 = r14.text;
    L21:
        String r5 = "";
        if (r15 != null) goto L24;
        final String r6 = "";
    L26:
        if (this.this$1.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED) goto L33;
        f2a.c r16 = ChatListComponentViewModel.access$getLogger$p(this.this$1).b("[TTS][NOT_PLAY_LIFE_STATE] lifecycle: " + this.this$1.getLifecycle().getCurrentState());
        r16.c.b = CollectionsKt.listOf("TtsPlay");
        f2a.f r7 = f2a.f.i;
        String r8 = this.$msg.getMessageId();
        if (r8 == null) goto L31;
        r5 = r8;
    L31:
        r16.d(MapsKt.mapOf(TuplesKt.to(r7, r5)));
        f2a.c.c(r16, null, 15);
        return Unit.INSTANCE;
    L33:
        final ChatListComponentViewModel r9 = this.this$1;
        final Message r17 = this.$msg;
        final TtsScene r10 = this.$fromScene;
        final ChatListComponentViewModel$a r11 = this.this$0;
        ?? r18 = new o7(r9, r6, r17, r10, r11);
        if (this.$isStreamingUpdate == true) goto L36;
        r18.invoke();
    L65:
        return Unit.INSTANCE;
    L36:
        r11.getClass();
        TextContent r19 = ChatListComponentViewModel$a.c(r17);
        if (r19 == null) goto L39;
        r4 = r19.text;
    L39:
        if (r4 != null) goto L42;
        r4 = "";
    L42:
        if (r4.length() <= r11.b.length()) goto L61;
        if (r11.b.length() > 0) goto L47;
        r2 = false;
    L47:
        if (r2 == false) goto L61;
        String r20 = StringsKt.replaceFirst$default(r4, r11.b, "", false, 4, null);
        if (r20 != null) goto L51;
        r20 = "";
    L51:
        FLogger.a.i(r11.a, "chunk diff: ".concat(r20));
        if (r20.length() <= 20) goto L61;
        o r21 = o.a;     // Catch: Throwable -> L59
        JSONObject r22 = new JSONObject();     // Catch: Throwable -> L59
        StringBuilder r23 = new StringBuilder("{\"msg_id\":");     // Catch: Throwable -> L59
        String r24 = r17.getMessageId();     // Catch: Throwable -> L59
        if (r24 != null) goto L57;
        r24 = "";
    L57:
        r23.append(r24);     // Catch: Throwable -> L59
        r23.append(",\"current_msg_content\":");     // Catch: Throwable -> L59
        r23.append(r4);     // Catch: Throwable -> L59
        r23.append(",\"last_msg_content\":");     // Catch: Throwable -> L59
        r23.append(r11.b);     // Catch: Throwable -> L59
        r23.append(",\"diff_text\":");     // Catch: Throwable -> L59
        r23.append(r20);     // Catch: Throwable -> L59
        r22.put("error_description", r23.toString());     // Catch: Throwable -> L59
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L59
        r21.reportEvent("tts_diff_text_error", r22);     // Catch: Throwable -> L59
    L61:
        if (r17.getMessageStatusLocal() != 20) goto L63;
        r5 = r4;
    L63:
        r11.b = r5;
        goto L65
    L24:
        r6 = r15;
        goto L26
    L20:
        r15 = null;
        goto L21
    L16:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        if (ObricTtsControlDelegate.b.e() == false) goto L17;
        ChatListComponentViewModel$a r110 = this.this$0;
        Message r26 = this.$msg;
        boolean r27 = this.$isStreamingUpdate;
        this.label = 1;
        r12 = ChatListComponentViewModel$a.b(r110, r26, r27, this);
        if (r12 != r0) goto L14;
        return r0;
    }
}
