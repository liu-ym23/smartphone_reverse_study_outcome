package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import android.net.Uri;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.bmhome.chat.bean.ProcessFileResultCode;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.bot.impl.feature.edit.viewmodel.BotImageUploadViewModel;
import com.larus.platform.spi.IAIChatUploadMediaService;
import com.larus.utils.logger.FLogger;
import ic8.m0;
import ic8.n0;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.BotBgImageGenerateViewModel$onAlbumPicked$1$1", f = "Img2BgImageViewModel.kt", i = {}, l = {463}, m = "invokeSuspend", n = {}, s = {})
public final class BotBgImageGenerateViewModel$onAlbumPicked$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $it;
    int label;
    final /* synthetic */ BotBgImageGenerateViewModel this$0;

    public BotBgImageGenerateViewModel$onAlbumPicked$1$1(Uri r1, BotBgImageGenerateViewModel r2, Continuation<? super BotBgImageGenerateViewModel$onAlbumPicked$1$1> r3) {
        this.$it = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BotBgImageGenerateViewModel$onAlbumPicked$1$1(this.$it, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r2 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r12);
    L11:
        n0 r13 = (n0) r12;
        if (r13 == null) goto L18;
        ProcessFileResultCode r3 = r13.b;
        if (r3 == null) goto L18;
        if (r3.isSuccess() != true) goto L18;
    L20:
        if (r2 == true) goto L41;
        FLogger.a.e("BotBgImageGenerateViewModel", "preprocess albumImg failed");
        BotBgImageGenerateViewModel.access$sendUIEvent(this.this$0, new c.h(new TextRes.StringResId(2131908918)));
    L40:
        return Unit.INSTANCE;
    L41:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L29
        m0 r14 = r13.a;     // Catch: Throwable -> L29
        if (r14 == null) goto L26;
        String r15 = r14.e;     // Catch: Throwable -> L29
        if (r15 == null) goto L26;
        PolarisFileWrapper r5 = new PolarisFileWrapper(r15);     // Catch: Throwable -> L29
    L27:
        Object r16 = Result.constructor-impl(Uri.fromFile(r5));     // Catch: Throwable -> L29
    L31:
        BotBgImageGenerateViewModel r6 = this.this$0;
        if (Result.isSuccess-impl(r16) == false) goto L34;
        Uri r7 = (Uri) r16;
        BotImageUploadViewModel r8 = BotBgImageGenerateViewModel.access$getUploadViewModel(r6);
        Intrinsics.checkNotNull(r7);
        BotImageUploadViewModel.upload$default(r8, r7, 5, false, 4, null);
    L34:
        BotBgImageGenerateViewModel r9 = this.this$0;
        if (Result.exceptionOrNull-impl(r16) == null) goto L37;
        FLogger.a.e("BotBgImageGenerateViewModel", "get uri of preprocessResult.path failed");
        BotBgImageGenerateViewModel.access$sendUIEvent(r9, new c.h(new TextRes.StringResId(2131908918)));
    L37:
        Result.box-impl(r16);
    L26:
        r5 = null;
    L29:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
    L18:
        r2 = false;
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r12);
        IAIChatUploadMediaService.Companion r11 = IAIChatUploadMediaService.a;
        Uri r17 = this.$it;
        this.label = 1;
        r12 = IAIChatUploadMediaService.a.a(r11, r17, null, false, false, null, this, 62);
        if (r12 != r0) goto L11;
        return r0;
    }
}
