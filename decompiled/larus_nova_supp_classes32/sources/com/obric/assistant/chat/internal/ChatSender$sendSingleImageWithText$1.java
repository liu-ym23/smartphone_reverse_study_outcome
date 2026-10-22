package com.obric.assistant.chat.internal;

import com.larus.im.bean.message.Message;
import com.larus.im.bean.message.UpLinkState;
import com.larus.im.bean.message.UplinkFileEntity;
import com.larus.im.callback.IIMCallback;
import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.upload.IObricUploadService;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.internal.ChatSender$sendSingleImageWithText$1", f = "ChatSender.kt", i = {0, 0}, l = {99}, m = "invokeSuspend", n = {"handler", "uploadCache"}, s = {"L$0", "L$1"})
final class ChatSender$sendSingleImageWithText$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ String $identifier;
    final /* synthetic */ String $semanticTraceKey;
    final /* synthetic */ IIMCallback<List<Message>> $sendMessageCallback;
    final /* synthetic */ String $text;
    final /* synthetic */ String $textScene;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendSingleImageWithText$1(String r1, String r2, ChatSender r3, String r4, String r5, String r6, Map<String, String> r7, IIMCallback<List<Message>> r8, Continuation<? super ChatSender$sendSingleImageWithText$1> r9) {
        this.$semanticTraceKey = r1;
        this.$identifier = r2;
        this.this$0 = r3;
        this.$text = r4;
        this.$textScene = r5;
        this.$fromScene = r6;
        this.$ext = r7;
        this.$sendMessageCallback = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new ChatSender$sendSingleImageWithText$1(this.$semanticTraceKey, this.$identifier, this.this$0, this.$text, this.$textScene, this.$fromScene, this.$ext, this.$sendMessageCallback, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        UplinkFileEntity r2 = (UplinkFileEntity) this.L$1;
        SingleImageWithTextHandler r4 = (SingleImageWithTextHandler) this.L$0;
        ResultKt.throwOnFailure(r15);
    L56:
        if (((Boolean) r15).booleanValue() == false) goto L58;
        r4.h(r2);
    L66:
        return Unit.INSTANCE;
    L58:
        r2.setUpLinkStatus(Boxing.boxInt(UpLinkState.FAIL.getValue()));
        int r16 = SingleImageWithTextHandler.k;
        r4.update(r2, null);
        goto L66
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        IObricUploadService.a.getClass();
        IObricUploadService r17 = IObricUploadService.a.a();
        if (r17 != null) goto L20;
        String r18 = this.$semanticTraceKey;
        if (r18 != null) goto L13;
    L16:
        if (r3 == true) goto L19;
        CoroutineScope r19 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.h(this.$semanticTraceKey, null, "upload_service_unavailable", "semantic upload service unavailable", 18);
    L19:
        return Unit.INSTANCE;
    L13:
        if (StringsKt.isBlank(r18) == true) goto L16;
        r3 = false;
        goto L16
    L20:
        SingleImageWithTextHandler r13 = new SingleImageWithTextHandler(this.$identifier, this.this$0.a, this.$text, this.$textScene, this.$fromScene, MapsKt.toMutableMap(this.$ext), this.$sendMessageCallback);
        r17.h(this.$identifier, r13);
        UplinkFileEntity r5 = r17.g(this.$identifier);
        if (r5 == null) goto L23;
        r17.b(this.$identifier, r5);
    L23:
        FLogger r6 = FLogger.a;
        r6.i("Obric_ChatSender", "sendImageWithText: called, getUploadCache return: " + r5);
        CoroutineScope r7 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.a(this.$semanticTraceKey, this.$identifier);
        if (r5 != null) goto L34;
        r6.i("Obric_ChatSender", "sendImageWithText: called, getUploadCache return null, there is no uploadCache with identifier: " + this.$identifier);
        String r8 = this.$semanticTraceKey;
        if (r8 != null) goto L28;
    L31:
        if (r3 == true) goto L33;
        com.obric.assistant.chat.api.f.h(this.$semanticTraceKey, null, "upload_cache_missing", "semantic upload cache missing", 18);
    L33:
        r17.f(this.$identifier, r13);
        goto L66
    L28:
        if (StringsKt.isBlank(r8) == true) goto L31;
        r3 = false;
        goto L31
    L34:
        Integer r9 = r5.getUpLinkStatus();
        int r10 = UpLinkState.DEFAULT.getValue();
        if (r9 != null) goto L38;
    L40:
        Integer r11 = r5.getUpLinkStatus();
        int r12 = UpLinkState.PROCESSING.getValue();
        if (r11 != null) goto L44;
    L46:
        Integer r14 = r5.getUpLinkStatus();
        int r20 = UpLinkState.SUCCESS.getValue();
        if (r14 != null) goto L50;
    L59:
        Integer r21 = r5.getUpLinkStatus();
        int r22 = UpLinkState.FAIL.getValue();
        if (r21 == null) goto L66;
        if (r21.intValue() != r22) goto L66;
        r17.f(this.$identifier, r13);
        r13.e(r5);
        goto L66
    L50:
        if (r14.intValue() != r20) goto L59;
        r17.f(this.$identifier, r13);
        r13.e(r5);
        this.L$0 = r13;
        this.L$1 = r5;
        this.label = 1;
        r15 = r13.g(r5, this);
        if (r15 != r0) goto L54;
        return r0;
    L54:
        r2 = r5;
        r4 = r13;
        goto L56
    L44:
        if (r11.intValue() != r12) goto L46;
        r13.e(r5);
        goto L66
    L38:
        if (r9.intValue() != r10) goto L40;
        r13.e(r5);
        goto L66
    }
}
