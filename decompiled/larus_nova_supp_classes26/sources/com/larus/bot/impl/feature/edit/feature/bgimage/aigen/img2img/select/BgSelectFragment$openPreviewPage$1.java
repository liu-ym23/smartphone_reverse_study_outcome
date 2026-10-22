package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select;

import android.content.Context;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.bot.impl.feature.edit.feature.bgimage.preview.BotEditAvatarPreviewActivity;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BotModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.select.BgSelectFragment$openPreviewPage$1", f = "BgSelectFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BgSelectFragment$openPreviewPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ BotAvatarIconData $avatarInfo;
    final /* synthetic */ BgImage $bgImage;
    final /* synthetic */ String $botDescription;
    final /* synthetic */ BotModel $botInfo;
    final /* synthetic */ String $botName;
    final /* synthetic */ String $createWay;
    final /* synthetic */ String $creationId;
    final /* synthetic */ Boolean $needUpdateBotInfo;
    final /* synthetic */ String $originAvatarImageUri;
    final /* synthetic */ String $originBackgroundImageUri;
    final /* synthetic */ String $userBotGender;
    final /* synthetic */ String $userBotType;
    int label;
    final /* synthetic */ BgSelectFragment this$0;

    public BgSelectFragment$openPreviewPage$1(BgSelectFragment r1, BotAvatarIconData r2, BgImage r3, String r4, String r5, String r6, String r7, Boolean r8, BotModel r9, String r10, String r11, String r12, String r13, Continuation<? super BgSelectFragment$openPreviewPage$1> r14) {
        this.this$0 = r1;
        this.$avatarInfo = r2;
        this.$bgImage = r3;
        this.$botName = r4;
        this.$botDescription = r5;
        this.$userBotGender = r6;
        this.$userBotType = r7;
        this.$needUpdateBotInfo = r8;
        this.$botInfo = r9;
        this.$creationId = r10;
        this.$createWay = r11;
        this.$originAvatarImageUri = r12;
        this.$originBackgroundImageUri = r13;
        super(2, r14);
    }

    public final Continuation<Unit> create(Object r18, Continuation<?> r19) {
        return new BgSelectFragment$openPreviewPage$1(this.this$0, this.$avatarInfo, this.$bgImage, this.$botName, this.$botDescription, this.$userBotGender, this.$userBotType, this.$needUpdateBotInfo, this.$botInfo, this.$creationId, this.$createWay, this.$originAvatarImageUri, this.$originBackgroundImageUri, r19);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r25) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r25);
        Context r2 = this.this$0.getContext();
        if (r2 == null) goto L8;
        BotAvatarIconData r3 = this.$avatarInfo;
        BgImage r4 = this.$bgImage;
        String r5 = this.$botName;
        String r6 = this.$botDescription;
        String r7 = this.$userBotGender;
        String r8 = this.$userBotType;
        Boolean r9 = this.$needUpdateBotInfo;
        BotModel r10 = this.$botInfo;
        String r12 = this.$creationId;
        String r13 = this.$createWay;
        BgSelectFragment r1 = this.this$0;
        String r15 = this.$originAvatarImageUri;
        String r14 = this.$originBackgroundImageUri;
        int r11 = BotEditAvatarPreviewActivity.h;
        Boolean r16 = Boxing.boxBoolean(true);
        int r17 = BgSelectFragment.k;
        BotEditAvatarPreviewActivity.a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10, r16, r12, r13, "click_create_preview", Boxing.boxBoolean(r1.U90().getBotCreateTrace().a.getBoolean("if_base_image")), r1.U90().getBotCreateTrace().e(), r1.U90().getBotCreateTrace().d(), null, null, r15, Boxing.boxBoolean(r1.U90().getBotCreateTrace().a.getBoolean("has_origin_avatar", false)), r14, r1);
    L8:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
