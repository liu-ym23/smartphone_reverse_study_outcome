package com.larus.bmhome.double_post.cache;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.video.Content;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.lang.reflect.Type;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/larus/bmhome/video/Content;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1", f = "AwemeDoublePostCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends Content>>, Object> {
    int label;

    public AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1(Continuation<? super AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AwemeDoublePostCacheManager$getContentListForNetworkUnavailable$cacheData$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<Content>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r6);
        AwemeDoublePostCacheManager r7 = AwemeDoublePostCacheManager.a;
        String r8 = "aweme_double_post_cache_data_".concat(AccountService.a.getUserId());
        if (AwemeDoublePostCacheManager.b().contains(r8) == false) goto L21;
        String r1 = "";
        String r9 = AwemeDoublePostCacheManager.b().getString(r8, "");
        if (r9 == null) goto L12;
        r1 = r9;
    L12:
        if (r1.length() != 0) goto L14;
        boolean r10 = true;
    L15:
        if (r10 == true) goto L21;
        return (List) ((Gson) AwemeDoublePostCacheManager.c.getValue()).fromJson(r1, TypeToken.getParameterized(List.class, new Type[]{Content.class}).getType());
    L19:
        th = move-exception;
        FLogger.a.e("AwemeDoublePostCacheManager", "getData: " + th.getMessage(), th);
        goto L21
    L14:
        r10 = false;
    L21:
        return null;
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
