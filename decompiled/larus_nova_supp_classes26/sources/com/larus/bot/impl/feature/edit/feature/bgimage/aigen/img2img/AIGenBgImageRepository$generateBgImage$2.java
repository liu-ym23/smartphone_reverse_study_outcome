package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.bytedance.frameworks.baselib.network.http.BaseRequestContext;
import com.bytedance.ttnet.http.RequestContext;
import com.larus.bot.impl.bean.BotGenBgImageResponse;
import com.larus.bot.impl.bean.GenBotImageRequest;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/BotGenBgImageResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository$generateBgImage$2", f = "AIGenBgImageRepository.kt", i = {}, l = {48}, m = "invokeSuspend", n = {}, s = {})
public final class AIGenBgImageRepository$generateBgImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends BotGenBgImageResponse>>, Object> {
    final /* synthetic */ String $creationId;
    final /* synthetic */ GenBotImageRequest $genBotImageRequest;
    final /* synthetic */ int $num;
    final /* synthetic */ String $prompt;
    final /* synthetic */ String $scene;
    int label;
    final /* synthetic */ AIGenBgImageRepository this$0;

    public AIGenBgImageRepository$generateBgImage$2(String r1, String r2, int r3, String r4, GenBotImageRequest r5, AIGenBgImageRepository r6, Continuation<? super AIGenBgImageRepository$generateBgImage$2> r7) {
        this.$scene = r1;
        this.$prompt = r2;
        this.$num = r3;
        this.$creationId = r4;
        this.$genBotImageRequest = r5;
        this.this$0 = r6;
        super(2, r7);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        return new AIGenBgImageRepository$generateBgImage$2(this.$scene, this.$prompt, this.$num, this.$creationId, this.$genBotImageRequest, this.this$0, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<BotGenBgImageResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L28:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        Object r5 = this.$prompt;
        int r6 = this.$num;
        String r7 = this.$creationId;
        GenBotImageRequest r8 = this.$genBotImageRequest;
        AIGenBgImageRepository r9 = this.this$0;
        r4.put("prompt", r5);
        r4.put("num", r6);
        JSONObject r10 = new JSONObject();
        r10.put("bot_name", r8.getBotName());
        r10.put("bot_description_for_human", r8.getBotDescriptionForHuman());
        r10.put("bg_img_prompt_en", r8.getBgImgPromptEn());
        r10.put("reference_bg_img_uri", r8.getReferenceBgImgUri());
        r10.put("reference_bg_img_style", r8.getReferenceBgImStyle());
        r10.put("reference_bg_img_prompt", r8.getReferenceBgImPrompt());
        r10.put("user_bot_gender_starling_key", r8.getUserBotGenderStarlingKey());
        r10.put("user_bot_type_starling_key", r8.getUserBotTypeStarlingKey());
        JSONArray r11 = new JSONArray();
        List<String> r12 = r8.getBgImgDrawStyleStarlingKey();
        if (r12 == null) goto L14;
        Iterator<T> r13 = r12.iterator();
    L12:
        if (r13.hasNext() == false) goto L14;
        r11.put((String) r13.next());
    L14:
        Unit r15 = Unit.INSTANCE;
        r10.put("bg_img_draw_style_starling_key", r11);
        r10.put("only_gen_image_prompt", false);
        r4.put("image_req", r10);
        if (o0.d(r7) == false) goto L20;
        JSONObject r16 = new JSONObject();
        if (r7 != null) goto L19;
        r7 = "";
    L19:
        r16.put("creation_id", r7);
        int r17 = r9.a + 1;
        r9.a = r17;
        r16.put("creation_count", r17);
        r4.put("creation_id_info", r16);
    L20:
        String r18 = this.$scene;
        if (r18 == null) goto L23;
        Map r19 = MapsKt.mapOf(new Pair[]{TuplesKt.to("scene", r18), TuplesKt.to("image_num", Boxing.boxInt(this.$num))});
    L24:
        RequestContext r20 = new RequestContext();
        ((BaseRequestContext) r20).timeout_connect = 60000;
        ((BaseRequestContext) r20).timeout_read = 60000;
        ((BaseRequestContext) r20).timeout_write = 60000;
        this.label = 1;
        r14 = HttpExtKt.k("Social", BotGenBgImageResponse.class, "/alice/bot/gen_icon_by_prompt", r4, null, null, true, r19, r20, null, this, 560);
        if (r14 != r0) goto L28;
        return r0;
    L23:
        r19 = null;
        goto L24
    }
}
