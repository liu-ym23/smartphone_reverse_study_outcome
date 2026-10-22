package com.larus.bot.impl.feature.edit.feature.bgimage;

import android.net.Uri;
import com.larus.bot.impl.bean.BotAvatarIconData;
import com.larus.im.bean.bot.BgImage;
import com.larus.im.bean.bot.BgImageInfo;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.BotBgImageEditViewModel$onClickBottomBtn$1", f = "BotBgImageEditViewModel.kt", i = {0}, l = {428}, m = "invokeSuspend", n = {"nameAndDesc"}, s = {"L$0"})
final class BotBgImageEditViewModel$onClickBottomBtn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ BotBgImageEditViewModel this$0;

    public BotBgImageEditViewModel$onClickBottomBtn$1(BotBgImageEditViewModel r1, Continuation<? super BotBgImageEditViewModel$onClickBottomBtn$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new BotBgImageEditViewModel$onClickBottomBtn$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r3 = true;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        Pair<String, String> r4 = (Pair) this.L$0;
        ResultKt.throwOnFailure(r17);
        Object r5 = r17;
    L13:
        if (((Boolean) r5).booleanValue() == true) goto L36;
        BgImageInfo r6 = null;
        if (((c) this.this$0.d.getValue()).f == true) goto L31;
        Uri r7 = ((c) this.this$0.d.getValue()).a;
        if (r7 == null) goto L19;
        String r8 = r7.toString();
    L20:
        if (r8 != null) goto L22;
    L25:
        if (r3 == true) goto L31;
        BotBgImageEditViewModel r9 = this.this$0;
        BotAvatarIconData r15 = new BotAvatarIconData(r9.a().getIconUri(), this.this$0.a().getIconUrl(), this.this$0.a().getAvatarPrompt(), null, null, 24, null);
        BgImage r10 = this.this$0.a().getBgImage();
        if (r10 == null) goto L30;
        r6 = r10.bgImageInfo;
    L30:
        r9.v(new b.f(true, r15, r6, (String) r4.getFirst(), (String) r4.getSecond(), this.this$0.a().getUserBotGenderStarlingKey(), this.this$0.a().getUserBotTypeStarlingKey(), "click_button"));
        goto L36
    L22:
        if (StringsKt.isBlank(r8) == true) goto L25;
        r3 = false;
        goto L25
    L19:
        r8 = null;
    L31:
        BotBgImageEditViewModel r11 = this.this$0;
        BotAvatarIconData r13 = new BotAvatarIconData(r11.a().getIconUri(), this.this$0.a().getIconUrl(), this.this$0.a().getAvatarPromptForEnrich(), null, null, 24, null);
        BgImage r12 = this.this$0.a().getBgImage();
        if (r12 == null) goto L34;
        r6 = r12.bgImageInfo;
    L34:
        r11.v(new b.C0064b(r13, r6, (String) r4.getFirst(), (String) r4.getSecond(), this.this$0.a().getUserBotGenderStarlingKey(), this.this$0.a().getUserBotTypeStarlingKey()));
    L36:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r17);
        BotBgImageEditViewModel r14 = this.this$0;
        int r16 = BotBgImageEditViewModel.j;
        Pair<String, String> r18 = r14.s();
        BotBgImageEditViewModel r19 = this.this$0;
        String r20 = (String) r18.getFirst();
        String r21 = (String) r18.getSecond();
        this.L$0 = r18;
        this.label = 1;
        r5 = BotBgImageEditViewModel.q(r19, r20, r21, this);
        if (r5 != r1) goto L11;
        return r1;
    L11:
        r4 = r18;
        goto L13
    }
}
