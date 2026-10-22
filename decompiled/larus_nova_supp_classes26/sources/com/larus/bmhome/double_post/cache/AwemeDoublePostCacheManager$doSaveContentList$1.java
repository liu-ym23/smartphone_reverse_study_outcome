package com.larus.bmhome.double_post.cache;

import com.google.gson.Gson;
import com.larus.bmhome.video.Content;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.double_post.cache.AwemeDoublePostCacheManager$doSaveContentList$1", f = "AwemeDoublePostCacheManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class AwemeDoublePostCacheManager$doSaveContentList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<Content> $contentList;
    final /* synthetic */ String $key;
    private /* synthetic */ Object L$0;
    int label;

    public AwemeDoublePostCacheManager$doSaveContentList$1(List<Content> r1, String r2, Continuation<? super AwemeDoublePostCacheManager$doSaveContentList$1> r3) {
        this.$contentList = r1;
        this.$key = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AwemeDoublePostCacheManager$doSaveContentList$1 r0 = new AwemeDoublePostCacheManager$doSaveContentList$1(this.$contentList, this.$key, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L19;
        ResultKt.throwOnFailure(r4);
        CoroutineScope r5 = (CoroutineScope) this.L$0;
        List<Content> r6 = this.$contentList;
        String r0 = this.$key;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L11
        if (r6 != null) goto L8;
        AwemeDoublePostCacheManager r7 = AwemeDoublePostCacheManager.a;     // Catch: Throwable -> L11
        AwemeDoublePostCacheManager.b().erase(r0);     // Catch: Throwable -> L11
    L9:
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L17;
        FLogger.a.e("AwemeDoublePostCacheManager", "saveData: " + r9.getMessage(), r9);
    L17:
        return Unit.INSTANCE;
    L8:
        AwemeDoublePostCacheManager r2 = AwemeDoublePostCacheManager.a;     // Catch: Throwable -> L11
        AwemeDoublePostCacheManager.b().storeString(r0, "");     // Catch: Throwable -> L11
        AwemeDoublePostCacheManager.b().storeString(r0, ((Gson) AwemeDoublePostCacheManager.c.getValue()).toJson(r6));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
