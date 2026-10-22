package com.obric.assistant.chat.internal;

import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.upload.IObricUploadService;
import com.obric.assistant.upload.Scene;
import java.io.File;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.chat.internal.ChatSender$sendSingleImageWithText$2", f = "ChatSender.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChatSender$sendSingleImageWithText$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $destFile;
    final /* synthetic */ Map<String, String> $ext;
    final /* synthetic */ String $fromScene;
    final /* synthetic */ String $semanticTraceKey;
    final /* synthetic */ IIMCallback<List<Message>> $sendMessageCallback;
    final /* synthetic */ String $text;
    final /* synthetic */ String $textScene;
    final /* synthetic */ Scene $uploadScene;
    int label;
    final /* synthetic */ ChatSender this$0;

    public ChatSender$sendSingleImageWithText$2(String r1, ChatSender r2, String r3, String r4, String r5, Map<String, String> r6, IIMCallback<List<Message>> r7, File r8, Scene r9, Continuation<? super ChatSender$sendSingleImageWithText$2> r10) {
        this.$semanticTraceKey = r1;
        this.this$0 = r2;
        this.$text = r3;
        this.$textScene = r4;
        this.$fromScene = r5;
        this.$ext = r6;
        this.$sendMessageCallback = r7;
        this.$destFile = r8;
        this.$uploadScene = r9;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        return new ChatSender$sendSingleImageWithText$2(this.$semanticTraceKey, this.this$0, this.$text, this.$textScene, this.$fromScene, this.$ext, this.$sendMessageCallback, this.$destFile, this.$uploadScene, r13);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L20;
        ResultKt.throwOnFailure(r11);
        IObricUploadService.a.getClass();
        IObricUploadService r12 = IObricUploadService.a.a();
        if (r12 != null) goto L17;
        String r13 = this.$semanticTraceKey;
        if (r13 != null) goto L9;
    L12:
        boolean r14 = true;
    L13:
        if (r14 == true) goto L16;
        CoroutineScope r15 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.h(this.$semanticTraceKey, null, "upload_service_unavailable", "semantic upload service unavailable", 18);
    L16:
        return Unit.INSTANCE;
    L9:
        if (StringsKt.isBlank(r13) == true) goto L12;
        r14 = false;
        goto L13
    L17:
        String r8 = r12.d();
        CoroutineScope r0 = com.obric.assistant.chat.api.f.a;
        com.obric.assistant.chat.api.f.a(this.$semanticTraceKey, r8);
        SingleImageWithTextHandler r9 = new SingleImageWithTextHandler(r8, this.this$0.a, this.$text, this.$textScene, this.$fromScene, MapsKt.toMutableMap(this.$ext), this.$sendMessageCallback);
        r12.a(r8, this.$destFile, this.$uploadScene, r9);
        return Unit.INSTANCE;
    L20:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
