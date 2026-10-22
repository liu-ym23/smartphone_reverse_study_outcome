package com.larus.bmhome;

import android.net.Uri;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/chat/bean/ProcessFileResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.AIChatUploadMediaServiceImpl$preprocessAlbumImg$2", f = "AIChatUploadMediaServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AIChatUploadMediaServiceImpl$preprocessAlbumImg$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ic8.n0>, Object> {
    final /* synthetic */ ns8.a $compressConfig;
    final /* synthetic */ boolean $isMultiFile;
    final /* synthetic */ boolean $keepCompressConfig;
    final /* synthetic */ b $processConfig;
    final /* synthetic */ String $scene;
    final /* synthetic */ Uri $uri;
    int label;

    public AIChatUploadMediaServiceImpl$preprocessAlbumImg$2(Uri r1, boolean r2, ns8.a r3, String r4, b r5, boolean r6, Continuation<? super AIChatUploadMediaServiceImpl$preprocessAlbumImg$2> r7) {
        this.$uri = r1;
        this.$isMultiFile = r2;
        this.$compressConfig = r3;
        this.$scene = r4;
        this.$processConfig = r5;
        this.$keepCompressConfig = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AIChatUploadMediaServiceImpl$preprocessAlbumImg$2(this.$uri, this.$isMultiFile, this.$compressConfig, this.$scene, this.$processConfig, this.$keepCompressConfig, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super ic8.n0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r8);
        return ChatInputService.b.f().e(this.$uri, this.$isMultiFile, this.$compressConfig, this.$scene, this.$processConfig, this.$keepCompressConfig);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
