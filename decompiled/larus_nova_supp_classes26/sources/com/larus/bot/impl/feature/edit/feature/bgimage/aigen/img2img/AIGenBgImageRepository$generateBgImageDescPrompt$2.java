package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.larus.bot.impl.bean.BotGenBgImageDescPromptResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.o0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotGenBgImageDescPromptResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository$generateBgImageDescPrompt$2", f = "AIGenBgImageRepository.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
public final class AIGenBgImageRepository$generateBgImageDescPrompt$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotGenBgImageDescPromptResponse>>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ GenBotImageRequest $genBotImageRequest;
    final /* synthetic */ String $prompt;
    int label;
    final /* synthetic */ AIGenBgImageRepository this$0;

    public AIGenBgImageRepository$generateBgImageDescPrompt$2(String r1, String r2, GenBotImageRequest r3, AIGenBgImageRepository r4, Continuation<? super AIGenBgImageRepository$generateBgImageDescPrompt$2> r5) {
        this.$prompt = r1;
        this.$creationId = r2;
        this.$genBotImageRequest = r3;
        this.this$0 = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new AIGenBgImageRepository$generateBgImageDescPrompt$2(this.$prompt, this.$creationId, this.$genBotImageRequest, this.this$0, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotGenBgImageDescPromptResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L18:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        String r5 = this.$prompt;
        String r6 = this.$creationId;
        GenBotImageRequest r7 = this.$genBotImageRequest;
        AIGenBgImageRepository r8 = this.this$0;
        r4.put("prompt", r5);
        r4.put("num", 0);
        JSONObject r9 = new JSONObject();
        r9.put("bot_name", r7.getBotName());
        r9.put("bot_description_for_human", r7.getBotDescriptionForHuman());
        r9.put("reference_bg_img_uri", r7.getReferenceBgImgUri());
        r9.put("reference_bg_img_style", r7.getReferenceBgImStyle());
        r9.put("reference_bg_img_prompt", r7.getReferenceBgImPrompt());
        r9.put("user_bot_gender_starling_key", r7.getUserBotGenderStarlingKey());
        r9.put("user_bot_type_starling_key", r7.getUserBotTypeStarlingKey());
        r9.put("only_gen_image_prompt", true);
        Unit r10 = Unit.INSTANCE;
        r4.put("image_req", r9);
        if (o0.d(r6) == false) goto L14;
        JSONObject r11 = new JSONObject();
        if (r6 != null) goto L13;
        r6 = "";
    L13:
        r11.put("creation_id", r6);
        int r12 = r8.a + 1;
        r8.a = r12;
        r11.put("creation_count", r12);
        r4.put("creation_id_info", r11);
    L14:
        Map r13 = MapsKt.mapOf(TuplesKt.to("scene", "bg_img_prompt"));
        this.label = 1;
        r14 = HttpExtKt.k("Social", BotGenBgImageDescPromptResponse.class, "/alice/bot/gen_icon_by_prompt", r4, null, null, true, r13, null, null, this, 816);
        if (r14 != r0) goto L18;
        return r0;
    }
}
