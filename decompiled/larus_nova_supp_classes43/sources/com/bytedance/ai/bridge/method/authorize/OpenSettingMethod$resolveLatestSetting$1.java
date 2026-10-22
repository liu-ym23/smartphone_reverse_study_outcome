package com.bytedance.ai.bridge.method.authorize;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.permission.AppletSettingHelper;
import com.bytedance.ai.applet.permission.g;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.openSetting.AbsOpenSettingMethodIDL;
import f3.h;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.bridge.method.authorize.OpenSettingMethod$resolveLatestSetting$1", f = "OpenSettingMethod.kt", i = {}, l = {86}, m = "invokeSuspend", n = {}, s = {})
final class OpenSettingMethod$resolveLatestSetting$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ UUID $callToken;
    final /* synthetic */ h<AbsOpenSettingMethodIDL.b> $callback;
    int label;

    public OpenSettingMethod$resolveLatestSetting$1(String r1, UUID r10, h<AbsOpenSettingMethodIDL.b> r11, Continuation<? super OpenSettingMethod$resolveLatestSetting$1> r12) {
        this.$appletId = r1;
        this.$callToken = r10;
        this.$callback = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new OpenSettingMethod$resolveLatestSetting$1(this.$appletId, this.$callToken, this.$callback, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L18:
        g r11 = (g) r10;
        if (a.a.a(this.$appletId, this.$callToken) == false) goto L21;
        String r12 = r11.a;
        if (r12 != null) goto L25;
        h<AbsOpenSettingMethodIDL.b> r13 = this.$callback;
        BaseModel r14 = k3.a.b(Reflection.getOrCreateKotlinClass(AbsOpenSettingMethodIDL.b.class));
        ((AbsOpenSettingMethodIDL.b) r14).setAuthSetting(r11.b);
        h.a.b(r13, (ResultModel) r14);
    L27:
        return Unit.INSTANCE;
    L25:
        h.a.a(this.$callback, r12, null, null, 14);
        goto L27
    L21:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletAppManagerService r15 = AppletAppManagerService.INSTANCE;
        String r16 = this.$appletId;
        r15.getClass();
        AppletApplication r17 = AppletAppManagerService.a(r16);
        if (r17 == null) goto L11;
        AppletSettingHelper r18 = (AppletSettingHelper) r17.h().f.getValue();
        this.label = 1;
        int r19 = AppletSettingHelper.b;
        r10 = r18.c(null, this);
        if (r10 != r0) goto L18;
        return r0;
    L11:
        if (a.a.a(this.$appletId, this.$callToken) == false) goto L14;
        h.a.a(this.$callback, "app " + this.$appletId + " not found", null, null, 14);
    L14:
        return Unit.INSTANCE;
    }
}
