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
import ns8.b;
import ye8.b$a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.AIChatUploadMediaServiceImpl$processTakePhotoImg$2", f = "AIChatUploadMediaServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AIChatUploadMediaServiceImpl$processTakePhotoImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ boolean $isMultiFile;
    final /* synthetic */ b $processConfig;
    final /* synthetic */ String $tmpSrcPath;
    int label;

    public AIChatUploadMediaServiceImpl$processTakePhotoImg$2(String r1, boolean r2, ns8.a r3, b r4, Continuation<? super AIChatUploadMediaServiceImpl$processTakePhotoImg$2> r5) {
        this.$tmpSrcPath = r1;
        this.$isMultiFile = r2;
        this.$compressConfig = r3;
        this.$processConfig = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AIChatUploadMediaServiceImpl$processTakePhotoImg$2(this.$tmpSrcPath, this.$isMultiFile, this.$compressConfig, this.$processConfig, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.n0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r7);
        return b$a.c(ChatInputService.b.f(), this.$tmpSrcPath, this.$isMultiFile, this.$compressConfig, this.$processConfig, 16);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
