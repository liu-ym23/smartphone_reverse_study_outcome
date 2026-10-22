package com.bytedance.ai.applet.permission;

import com.bytedance.ai.bridge.remote.model.AppletPermissionDetail;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/bridge/remote/model/AppletPermissionDetail;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.applet.permission.AppletSettingHelper$getSetting$detail$1", f = "AppletSettingHelper.kt", i = {}, l = {44}, m = "invokeSuspend", n = {}, s = {})
public final class AppletSettingHelper$getSetting$detail$1 extends SuspendLambda implements Function1<Continuation<? super AppletPermissionDetail>, Object> {
    int label;
    final /* synthetic */ AppletSettingHelper this$0;

    public AppletSettingHelper$getSetting$detail$1(AppletSettingHelper r1, Continuation<? super AppletSettingHelper$getSetting$detail$1> r10) {
        this.this$0 = r1;
        super(1, r10);
    }

    public final Continuation<Unit> create(Continuation<?> r10) {
        return new AppletSettingHelper$getSetting$detail$1(this.this$0, r10);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        return invoke((Continuation) r1);
    }

    public final Object invoke(Continuation<? super AppletPermissionDetail> r10) {
        return create(r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletSettingHelper r11 = this.this$0;
        this.label = 1;
        int r12 = AppletSettingHelper.b;
        r11.getClass();
        r10 = BuildersKt.withContext(Dispatchers.getIO(), new AppletSettingHelper$fetchPermissionDetail$2(r11, null), this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
