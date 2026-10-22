package com.larus.bot.impl.feature.edit.feature.bgimage.preview;

import android.net.Uri;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1", f = "BotEditAvatarPreviewViewModel.kt", i = {}, l = {321}, m = "invokeSuspend", n = {}, s = {})
public final class BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends ImageUploadResult>>, Object> {
    int label;
    final /* synthetic */ BotEditAvatarPreviewViewModel this$0;

    public BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1(BotEditAvatarPreviewViewModel r1, Continuation<? super BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotEditAvatarPreviewViewModel$handleUploadBg$1$resp$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<ImageUploadResult>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L16:
        return (com.larus.network.http.a) r12;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        Uri r4 = ((y) this.this$0.getUiState().getValue()).c.a;
        if (r4 == null) goto L14;
        BotEditAvatarPreviewViewModel r13 = this.this$0;
        BotImageUploadViewModel r3 = BotEditAvatarPreviewViewModel.access$getUploadViewModel(r13);
        int r5 = BotEditAvatarPreviewViewModel.access$getUploadFileBizTag(r13);
        this.label = 1;
        r12 = BotImageUploadViewModel.syncUpload$default(r3, r4, r5, null, false, this, 12, null);
        if (r12 != r0) goto L16;
        return r0;
    L14:
        return null;
    }
}
