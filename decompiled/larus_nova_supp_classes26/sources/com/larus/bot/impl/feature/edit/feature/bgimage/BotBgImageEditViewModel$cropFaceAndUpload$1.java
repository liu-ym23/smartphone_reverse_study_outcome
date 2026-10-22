package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.common.util.BitmapHelperKt;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository;
import com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectViewModel;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.utils.o0;
import java.io.File;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel$cropFaceAndUpload$1", f = "BotBgImageEditViewModel.kt", i = {}, l = {193, 198, 201, 207}, m = "invokeSuspend", n = {}, s = {})
final class BotBgImageEditViewModel$cropFaceAndUpload$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$cropFaceAndUpload$1(BotBgImageEditViewModel r1, Continuation<? super BotBgImageEditViewModel$cropFaceAndUpload$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotBgImageEditViewModel$cropFaceAndUpload$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L15;
        if (r0 == 1) goto L14;
        if (r0 == 2) goto L13;
        if (r0 == 3) goto L11;
        if (r0 != 4) goto L10;
        ResultKt.throwOnFailure(r13);
    L67:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L52
        Object r1 = r13;
    L50:
        Object r2 = Result.constructor-impl((ImageUploadResult) ((com.larus.network.http.a) r1).b);     // Catch: Throwable -> L52
    L55:
        if (Result.isFailure-impl(r2) == false) goto L57;
        r2 = null;
    L57:
        ImageUploadResult r3 = (ImageUploadResult) r2;
        if (r3 == null) goto L67;
        BotBgImageEditViewModel r4 = this.this$0;
        if (o0.d(r3.getUploadUrl()) == false) goto L67;
        if (o0.d(r3.getUploadUri()) == false) goto L67;
        MainCoroutineDispatcher r5 = Dispatchers.getMain();
        BotBgImageEditViewModel$cropFaceAndUpload$1$4$1 r6 = new BotBgImageEditViewModel$cropFaceAndUpload$1$4$1(r4, r3, null);
        this.label = 4;
        if (BuildersKt.withContext(r5, r6, this) != r9) goto L67;
        return r9;
    L13:
        ResultKt.throwOnFailure(r13);
        Object r7 = r13;
    L44:
        File r8 = (File) r7;
        if (r8 == null) goto L67;
        BotBgImageEditViewModel r10 = this.this$0;
        Result.Companion r11 = Result.Companion;     // Catch: Throwable -> L52
        int r12 = BotBgImageEditViewModel.j;     // Catch: Throwable -> L52
        BotImageUploadViewModel r14 = (BotImageUploadViewModel) r10.i.getValue();     // Catch: Throwable -> L52
        Uri r15 = Uri.fromFile(r8);     // Catch: Throwable -> L52
        this.label = 3;     // Catch: Throwable -> L52
        r1 = BotImageUploadViewModel.syncUpload$default(r14, r15, 0, null, false, this, 14, null);     // Catch: Throwable -> L52
        if (r1 != r9) goto L50;
        return r9;
    L14:
        ResultKt.throwOnFailure(r13);
        Object r16 = r13;
    L38:
        Bitmap r17 = (Bitmap) r16;
    L40:
        if (r17 == null) goto L67;
        this.label = 2;
        r7 = BitmapHelperKt.g(null, r17, BgSelectViewModel.AVATAR_BITMAP_CACHE_FILE_NAME, this);
        if (r7 != r9) goto L44;
        return r9;
    L15:
        ResultKt.throwOnFailure(r13);
        Bundle r18 = this.this$0.g;
        if (r18 == null) goto L18;
        Serializable r19 = r18.getSerializable("avatar_info");
    L20:
        if ((r19 instanceof BotAvatarIconData) == false) goto L22;
        BotAvatarIconData r20 = (BotAvatarIconData) r19;
    L23:
        if (r20 == null) goto L67;
        BotBgImageEditViewModel r21 = this.this$0;
        if (o0.d(r20.getIconUrl()) == true) goto L27;
    L39:
        r17 = null;
        goto L40
    L27:
        if (o0.d(r20.getIconUri()) == false) goto L39;
        AIGenBgImageRepository r22 = (AIGenBgImageRepository) r21.h.getValue();
        String r23 = r20.getIconUri();
        String r24 = "";
        if (r23 != null) goto L31;
        r23 = "";
    L31:
        String r25 = r20.getIconUrl();
        if (r25 == null) goto L35;
        r24 = r25;
    L35:
        this.label = 1;
        r16 = r22.a(r23, r24, new com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.a(), this);
        if (r16 != r9) goto L38;
        return r9;
    L22:
        r20 = null;
        goto L23
    L18:
        r19 = null;
    L52:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L55
    }
}
