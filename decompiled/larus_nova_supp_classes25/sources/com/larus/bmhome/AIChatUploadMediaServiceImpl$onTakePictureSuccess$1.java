package com.larus.bmhome;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.input.ChatInputService;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.AIChatUploadMediaServiceImpl$onTakePictureSuccess$1", f = "AIChatUploadMediaServiceImpl.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
final class AIChatUploadMediaServiceImpl$onTakePictureSuccess$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ wc9.e $conversation;
    final /* synthetic */ String $path;
    int label;
    final /* synthetic */ AIChatUploadMediaServiceImpl this$0;

    public AIChatUploadMediaServiceImpl$onTakePictureSuccess$1(String r1, ns8.a r2, AIChatUploadMediaServiceImpl r3, wc9.e r4, Continuation<? super AIChatUploadMediaServiceImpl$onTakePictureSuccess$1> r5) {
        this.$path = r1;
        this.$compressConfig = r2;
        this.this$0 = r3;
        this.$conversation = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AIChatUploadMediaServiceImpl$onTakePictureSuccess$1(this.$path, this.$compressConfig, this.this$0, this.$conversation, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ic8.n0 r11 = b$a.c(ChatInputService.b.f(), this.$path, false, this.$compressConfig, null, 24);
        AIChatUploadMediaServiceImpl r2 = this.this$0;
        wc9.e r3 = this.$conversation;
        this.label = 1;
        if (AIChatUploadMediaServiceImpl.d(r2, r3, r11, "shoot", this) != r0) goto L12;
        return r0;
    }
}
