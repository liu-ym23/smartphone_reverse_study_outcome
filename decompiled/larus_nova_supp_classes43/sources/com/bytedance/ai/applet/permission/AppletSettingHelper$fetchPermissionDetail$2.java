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
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletSettingHelper$fetchPermissionDetail$2", f = "AppletSettingHelper.kt", i = {}, l = {82}, m = "invokeSuspend", n = {}, s = {})
final class AppletSettingHelper$fetchPermissionDetail$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletPermissionDetail>, Object> {
    int label;
    final /* synthetic */ AppletSettingHelper this$0;

    public AppletSettingHelper$fetchPermissionDetail$2(AppletSettingHelper r1, Continuation<? super AppletSettingHelper$fetchPermissionDetail$2> r10) {
        this.this$0 = r1;
        super(2, r10);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletSettingHelper$fetchPermissionDetail$2(this.this$0, r11);
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
        Object r11 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
        Object r12 = ((Result) r10).unbox-impl();
    L12:
        if (Result.isFailure-impl(r12) == false) goto L14;
        Object r13 = null;
    L15:
        List r14 = (List) r13;
        if (r14 != null) goto L21;
        Throwable r15 = Result.exceptionOrNull-impl(r12);
        if (r15 == null) goto L20;
        throw r15;
    L20:
        throw new Exception("Permission detail is null");
    L21:
        AppletSettingHelper r16 = this.this$0;
        Iterator r17 = r14.iterator();
    L23:
        if (r17.hasNext() == false) goto L27;
        Object r18 = r17.next();
        if (Intrinsics.areEqual(((AppletPermissionDetail) r18).getAppletId(), r16.a) == false) goto L23;
        r11 = r18;
    L27:
        AppletPermissionDetail r19 = (AppletPermissionDetail) r11;
        if (r19 == null) goto L31;
        return r19;
    L31:
        throw new Exception("Cannot find authorization info for " + this.this$0.a);
    L14:
        r13 = r12;
        goto L15
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        UserAuthService r20 = UserAuthService.a;
        List r21 = CollectionsKt.listOf(this.this$0.a);
        this.label = 1;
        r12 = UserAuthService.p(r21, null, this);
        if (r12 != r0) goto L12;
        return r0;
    }
}
