package com.larus.bot.impl.feature.edit.feature.avatar;

import android.net.Uri;
import com.larus.bmhome.bot.bean.ImageUploadResult;
import com.larus.bot.impl.common.propertyconfig.TextRes;
import com.larus.image.loader.b0;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.y;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\n"}, d2 = {"<anonymous>", "", "it", "Lcom/larus/network/http/Async;", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/bmhome/bot/bean/ImageUploadResult;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.avatar.BotAvatarEditViewModel$bindObservers$1", f = "BotAvatarEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BotAvatarEditViewModel$bindObservers$1 extends SuspendLambda implements Function2<com.larus.network.http.a<? extends BizResponse<ImageUploadResult>>, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ BotAvatarEditViewModel this$0;

    public BotAvatarEditViewModel$bindObservers$1(BotAvatarEditViewModel r1, Continuation<? super BotAvatarEditViewModel$bindObservers$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        BotAvatarEditViewModel$bindObservers$1 r0 = new BotAvatarEditViewModel$bindObservers$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public final Object invoke(com.larus.network.http.a<BizResponse<ImageUploadResult>> r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((com.larus.network.http.a) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r11) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L42;
        ResultKt.throwOnFailure(r11);
        com.larus.network.http.f r12 = (com.larus.network.http.a) this.L$0;
        boolean r1 = true;
        String r6 = "";
        if ((r12 instanceof com.larus.network.http.f) == false) goto L21;
        com.larus.network.http.f r13 = r12;
        String r0 = r13.d.getMessage();
        if (r0 != null) goto L9;
    L12:
        if (r1 == false) goto L14;
        BotAvatarEditViewModel r2 = this.this$0;
        b.d r3 = new b.d(new TextRes.StringResId(2131900249));
        int r7 = BotAvatarEditViewModel.h;
        r2.r(r3);
    L19:
        this.this$0.b(false);
        qu8.b.d("file_handle_upload_avatar", r13.d.getCode());
        qu8.b.d("bot_create/avatar/manual", 10021);
        qu8.b.d("bot_create/avatar_setting", 1002);
    L40:
        return Unit.INSTANCE;
    L14:
        BotAvatarEditViewModel r4 = this.this$0;
        String r8 = r13.d.getMessage();
        if (r8 == null) goto L18;
        r6 = r8;
    L18:
        b.d r5 = new b.d(new TextRes.PlainText(r6));
        int r9 = BotAvatarEditViewModel.h;
        r4.r(r5);
        goto L19
    L9:
        if (r0.length() == 0) goto L12;
        r1 = false;
        goto L12
    L21:
        if ((r12 instanceof y) == false) goto L40;
        FLogger.a.i("BotAvatarViewModel", "onUploadAvatarReturned: ImageUploadResult.async = Success");
        BizResponse r14 = (BizResponse) ((com.larus.network.http.a) ((y) r12)).b;
        if (r14 == null) goto L38;
        ImageUploadResult r15 = (ImageUploadResult) r14.getData();
        if (r15 == null) goto L38;
        BotAvatarEditViewModel r10 = this.this$0;
        if (o0.d(r15.getUploadUrl()) == false) goto L29;
        Uri r16 = b0.a(r15.getUploadUrl(), "bot_create.avatar_upload", false, false, 6);
    L30:
        BotAvatarEditViewModel.q(r10, r16, true, false, 4);
        String r17 = r15.getUploadUrl();
        if (r17 != null) goto L33;
        r17 = "";
    L33:
        String r18 = r15.getUploadUri();
        if (r18 == null) goto L37;
        r6 = r18;
    L37:
        r10.k(r17, r6);
        r10.m(r15.getReferenceBgImgPrompt());
        r10.c(false);
        qu8.b.c(0, new String[]{"file_handle_upload_avatar", "bot_create/avatar/manual", "bot_create/avatar_setting"});
        goto L38
    L29:
        r16 = null;
    L38:
        this.this$0.b(false);
        goto L40
    L42:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
