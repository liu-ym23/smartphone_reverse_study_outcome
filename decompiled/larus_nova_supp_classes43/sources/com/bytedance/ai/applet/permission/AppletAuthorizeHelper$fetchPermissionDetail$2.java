package com.bytedance.ai.applet.permission;

import com.bytedance.ai.bridge.remote.UserAuthService;
import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletAuthorizeHelper$fetchPermissionDetail$2", f = "AppletAuthorizeHelper.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
final class AppletAuthorizeHelper$fetchPermissionDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletPermissionDetail>, Object> {
    final /* synthetic */ String $scopeName;
    int label;
    final /* synthetic */ AppletAuthorizeHelper this$0;

    public AppletAuthorizeHelper$fetchPermissionDetail$2(AppletAuthorizeHelper r1, String r10, Continuation<? super AppletAuthorizeHelper$fetchPermissionDetail$2> r11) {
        this.this$0 = r1;
        this.$scopeName = r10;
        super(2, r11);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletAuthorizeHelper$fetchPermissionDetail$2(this.this$0, this.$scopeName, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppletPermissionDetail> r10) {
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
        if (Result.isFailure-impl(r11) == false) goto L14;
        Object r12 = null;
    L15:
        List r13 = (List) r12;
        if (r13 != null) goto L21;
        Throwable r14 = Result.exceptionOrNull-impl(r11);
        if (r14 == null) goto L20;
        throw r14;
    L20:
        throw new Exception("Permission detail is null");
    L21:
        AppletAuthorizeHelper r15 = this.this$0;
        Iterator r16 = r13.iterator();
    L23:
        if (r16.hasNext() == false) goto L27;
        Object r17 = r16.next();
        if (Intrinsics.areEqual(((AppletPermissionDetail) r17).getAppletId(), r15.a) == false) goto L23;
    L28:
        AppletPermissionDetail r18 = (AppletPermissionDetail) r17;
        if (r18 == null) goto L32;
        return r18;
    L32:
        throw new AppletAuthorizeHelper.AuthorizeException("Cannot find authorization info for " + this.this$0.a, null, 2, null);
    L27:
        r17 = null;
        goto L28
    L14:
        r12 = r11;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r19 = UserAuthService.a;
        List r20 = CollectionsKt.listOf(this.this$0.a);
        List r21 = CollectionsKt.listOf(this.$scopeName);
        this.label = 1;
        r11 = UserAuthService.p(r20, r21, this);
        if (r11 != r0) goto L12;
        return r0;
    }
}
