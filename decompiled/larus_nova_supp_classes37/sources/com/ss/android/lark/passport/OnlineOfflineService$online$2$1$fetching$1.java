package com.ss.android.lark.passport;

import com.ss.android.lark.passport.signinsdk_api.account.User;
import com.ss.android.lark.picker.base.view.ItemViewType;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/ss/android/lark/passport/signinsdk_api/account/User;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
@DebugMetadata(c = "com.ss.android.lark.passport.OnlineOfflineService$online$2$1$fetching$1", f = "OnlineOfflineService.kt", i = {}, l = {205}, m = "invokeSuspend", n = {}, s = {})
public final class OnlineOfflineService$online$2$1$fetching$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends User>>, Object> {
    final /* synthetic */ String $token;
    int label;

    public OnlineOfflineService$online$2$1$fetching$1(String r1, Continuation<? super OnlineOfflineService$online$2$1$fetching$1> r2) {
        this.$token = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new OnlineOfflineService$online$2$1$fetching$1(this.$token, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Result<? extends User>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r4);
        Object r5 = ((Result) r4).unbox-impl();
    L12:
        return Result.box-impl(r5);
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        OnlineOfflineService.Companion r6 = OnlineOfflineService.g;
        String r2 = this.$token;
        this.label = 1;
        r5 = r6.a(r2, this);
        if (r5 != r0) goto L12;
        return r0;
    }
}
