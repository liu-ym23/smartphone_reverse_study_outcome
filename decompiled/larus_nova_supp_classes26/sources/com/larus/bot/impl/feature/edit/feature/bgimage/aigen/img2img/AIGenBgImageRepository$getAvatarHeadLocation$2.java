package com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img;

import com.larus.bot.impl.bean.AvatarHeadLocation;
import com.larus.network.http.HttpExtKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/http/Async;", "Lcom/larus/bot/impl/bean/AvatarHeadLocation;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bot.impl.feature.edit.feature.bgimage.aigen.img2img.AIGenBgImageRepository$getAvatarHeadLocation$2", f = "AIGenBgImageRepository.kt", i = {}, l = {134}, m = "invokeSuspend", n = {}, s = {})
final class AIGenBgImageRepository$getAvatarHeadLocation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.network.http.a<? extends AvatarHeadLocation>>, Object> {
    final /* synthetic */ List<String> $urlList;
    int label;

    public AIGenBgImageRepository$getAvatarHeadLocation$2(List<String> r1, Continuation<? super AIGenBgImageRepository$getAvatarHeadLocation$2> r2) {
        this.$urlList = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new AIGenBgImageRepository$getAvatarHeadLocation$2(this.$urlList, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.network.http.a<AvatarHeadLocation>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r14);
    L16:
        return (com.larus.network.http.a) r14;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        JSONObject r4 = new JSONObject();
        List<String> r5 = this.$urlList;
        JSONArray r6 = new JSONArray();
        Iterator<T> r7 = r5.iterator();
    L10:
        if (r7.hasNext() == false) goto L12;
        r6.put((String) r7.next());
        goto L10
    L12:
        Unit r8 = Unit.INSTANCE;
        r4.put("image_uri_list", r6);
        this.label = 1;
        r14 = HttpExtKt.k("Social", AvatarHeadLocation.class, "/alice/bot/avatar_head_location", r4, null, null, true, null, null, null, this, 944);
        if (r14 != r0) goto L16;
        return r0;
    }
}
