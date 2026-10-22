package com.larus.bmhome.chat.router;

import android.app.Activity;
import android.content.Intent;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.common.apphost.AppHost;
import com.larus.image.loader.ResourceUrlExpireHandleUtil;
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
import t19.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.router.OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1", f = "OpenFileUrlLinkRouterInterceptor.kt", i = {}, l = {MessageCellStateTransformerType.WELCOME_BACK_CELL}, m = "invokeSuspend", n = {}, s = {})
public final class OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    private /* synthetic */ Object L$0;
    int label;

    public OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1(String r1, Continuation<? super OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1> r2) {
        this.$url = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1 r0 = new OpenFileUrlLinkRouterInterceptor$onInterceptRoute$4$1(this.$url, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Throwable -> L23
    L13:
        Intent r2 = new Intent("android.intent.action.VIEW", UriProtector.parse((String) r4));     // Catch: Throwable -> L23
        r2.addFlags(268435456);     // Catch: Throwable -> L23
        AppHost.Companion r5 = AppHost.a;     // Catch: Throwable -> L23
        Activity r3 = r5.a().getCurrentActivity();     // Catch: Throwable -> L23
        if (r3 != null) goto L16;
        Unit r6 = null;
    L21:
        Result.constructor-impl(r6);     // Catch: Throwable -> L23
    L26:
        return Unit.INSTANCE;
    L16:
        if (r2.resolveActivity(r5.getApplication().getPackageManager()) == null) goto L18;
        r3.startActivity(r2);     // Catch: Throwable -> L23
    L19:
        r6 = Unit.INSTANCE;     // Catch: Throwable -> L23
        goto L21
    L18:
        s.a.g(r3, 2131911190, false);     // Catch: Throwable -> L23
        goto L19
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        String r8 = this.$url;
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L23
        ResourceUrlExpireHandleUtil r10 = ResourceUrlExpireHandleUtil.a;     // Catch: Throwable -> L23
        this.label = 1;     // Catch: Throwable -> L23
        r4 = r10.a(r8, this);     // Catch: Throwable -> L23
        if (r4 != r0) goto L13;
        return r0;
    L23:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L26
    }
}
