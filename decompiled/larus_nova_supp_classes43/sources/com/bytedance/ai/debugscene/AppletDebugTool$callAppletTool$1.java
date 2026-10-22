package com.bytedance.ai.debugscene;

import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.google.gson.JsonObject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.debugscene.AppletDebugTool$callAppletTool$1", f = "AppletDebugTool.kt", i = {}, l = {219}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugTool$callAppletTool$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appId;
    final /* synthetic */ String $toolData;
    final /* synthetic */ String $toolName;
    int label;

    public AppletDebugTool$callAppletTool$1(String r1, String r10, String r11, Continuation<? super AppletDebugTool$callAppletTool$1> r12) {
        this.$appId = r1;
        this.$toolName = r10;
        this.$toolData = r11;
        super(2, r12);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletDebugTool$callAppletTool$1(this.$appId, this.$toolName, this.$toolData, r11);
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
    L11:
        AppletApplication r11 = (AppletApplication) r10;
        if (r11 == null) goto L18;
        String r12 = this.$toolName;
        String r13 = this.$toolData;
        if ((r11 instanceof OnlineAppletApplication) == false) goto L20;
        d3.w r14 = ((OnlineAppletApplication) r11).K().B;
        if (r14 == null) goto L20;
        JsonObject r15 = new JsonObject();
        r15.addProperty("callbackId", "debug_mock_callback_id");
        r15.addProperty("abilityKey", r12);
        r15.addProperty("llmData", r13);
        Unit r16 = Unit.INSTANCE;
        r14.a("callAbility", r15);
    L20:
        return Unit.INSTANCE;
    L18:
        com.bytedance.ai.utils.g.a.e("AppletDebugTool", "call applet tool failed, appId:" + this.$appId + ", toolName:" + this.$toolName + ", toolData:" + this.$toolData);
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        AppletAppManagerService r17 = AppletAppManagerService.INSTANCE;
        String r18 = this.$appId;
        this.label = 1;
        r10 = r17.d(r18, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
