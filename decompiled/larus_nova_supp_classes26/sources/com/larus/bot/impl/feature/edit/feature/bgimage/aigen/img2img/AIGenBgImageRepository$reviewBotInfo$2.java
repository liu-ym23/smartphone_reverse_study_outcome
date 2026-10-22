package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.larus.bot.impl.bean.ReviewBotInfoResult;
import com.larus.network.http.HttpExtKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/ReviewBotInfoResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository$reviewBotInfo$2", f = "AIGenBgImageRepository.kt", i = {}, l = {211}, m = "invokeSuspend", n = {}, s = {})
final class AIGenBgImageRepository$reviewBotInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends ReviewBotInfoResult>>, Object> {
    final /* synthetic */ String $bgImgPrompt;
    final /* synthetic */ String $description;
    final /* synthetic */ String $name;
    int label;

    public AIGenBgImageRepository$reviewBotInfo$2(String r1, String r2, String r3, Continuation<? super AIGenBgImageRepository$reviewBotInfo$2> r4) {
        this.$name = r1;
        this.$description = r2;
        this.$bgImgPrompt = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new AIGenBgImageRepository$reviewBotInfo$2(this.$name, this.$description, this.$bgImgPrompt, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<ReviewBotInfoResult>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L19:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$name;
        String r6 = this.$description;
        String r7 = this.$bgImgPrompt;
        JSONObject r8 = new JSONObject();
        if (r5 == null) goto L11;
        r8.put("name", r5);
    L11:
        if (r6 == null) goto L13;
        r8.put("description_for_human", r6);
    L13:
        if (r7 == null) goto L15;
        JSONObject r9 = new JSONObject();
        r9.put("bg_img_prompt", r7);
        Unit r10 = Unit.INSTANCE;
        r8.put("bg_img_info", r9);
    L15:
        Unit r11 = Unit.INSTANCE;
        r4.put("bot_info", r8);
        this.label = 1;
        r14 = HttpExtKt.k("Social", ReviewBotInfoResult.class, "/alice/bot/review_bot_info", r4, null, null, true, null, null, null, this, 944);
        if (r14 != r0) goto L19;
        return r0;
    }
}
