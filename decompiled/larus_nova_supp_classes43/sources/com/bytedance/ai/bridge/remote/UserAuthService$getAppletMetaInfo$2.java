package com.bytedance.ai.bridge.remote;

import com.bytedance.ai.bridge.remote.model.AppMeta;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/bytedance/ai/bridge/remote/model/AppMeta;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.remote.UserAuthService$getAppletMetaInfo$2", f = "UserAuthService.kt", i = {}, l = {344}, m = "invokeSuspend", n = {}, s = {})
public final class UserAuthService$getAppletMetaInfo$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends AppMeta>>, Object> {
    final /* synthetic */ String $appKey;
    int label;

    public UserAuthService$getAppletMetaInfo$2(String r1, Continuation<? super UserAuthService$getAppletMetaInfo$2> r10) {
        this.$appKey = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new UserAuthService$getAppletMetaInfo$2(this.$appKey, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<AppMeta>> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r11 = ((Result) r10).unbox-impl();
    L12:
        if (Result.isFailure-impl(r11) == false) goto L18;
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L17;
        r12 = new Exception("Unknown Error");
    L17:
        return Result.box-impl(Result.constructor-impl(ResultKt.createFailure(r12)));
    L18:
        Object r13 = null;
        if (Result.isFailure-impl(r11) == false) goto L21;
        r11 = null;
    L21:
        p4.b r14 = (p4.b) r11;
        if (r14 == null) goto L32;
        List<AppMeta> r15 = r14.a();
        if (r15 == null) goto L32;
        String r16 = this.$appKey;
        Iterator<T> r17 = r15.iterator();
    L27:
        if (r17.hasNext() == false) goto L31;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((AppMeta) r18).getAppKey(), r16) == false) goto L27;
        r13 = r18;
    L31:
        r13 = (AppMeta) r13;
    L32:
        if (r13 != null) goto L34;
        Result.Companion r19 = Result.Companion;
        Object r20 = Result.constructor-impl(ResultKt.createFailure(new Exception("Biz Error: app not found (404)")));
    L36:
        return Result.box-impl(r20);
    L34:
        r20 = Result.constructor-impl(r13);
        goto L36
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r21 = UserAuthService.a;
        List<String> r22 = CollectionsKt.listOf(this.$appKey);
        this.label = 1;
        r11 = r21.c(r22, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
