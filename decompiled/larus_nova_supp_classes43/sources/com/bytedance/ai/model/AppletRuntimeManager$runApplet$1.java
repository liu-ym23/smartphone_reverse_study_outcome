package com.bytedance.ai.model;

import android.content.Context;
import com.bytedance.ai.applet.app.OnlineAppletApplication;
import com.bytedance.ai.applet.services.AppletAppManagerService;
import com.bytedance.ai.core.base.SessionType;
import com.bytedance.ai.core.manager.WorkerRuntimeManager;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$runApplet$1", f = "AppletRuntimeManager.kt", i = {}, l = {361, 363, 371}, m = "invokeSuspend", n = {}, s = {})
public final class AppletRuntimeManager$runApplet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationID;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $replyFor;
    final /* synthetic */ Function1<AppletRuntime, Unit> $runAppletResult;
    final /* synthetic */ Map<String, Object> $traceInfo;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    public AppletRuntimeManager$runApplet$1(String r1, String r10, String r11, String r12, String r13, Map<String, Object> r14, Function1<? super AppletRuntime, Unit> r15, Continuation<? super AppletRuntimeManager$runApplet$1> r16) {
        this.$appletId = r1;
        this.$conversationID = r10;
        this.$botId = r11;
        this.$msgId = r12;
        this.$replyFor = r13;
        this.$traceInfo = r14;
        this.$runAppletResult = r15;
        super(2, r16);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletRuntimeManager$runApplet$1(this.$appletId, this.$conversationID, this.$botId, this.$msgId, this.$replyFor, this.$traceInfo, this.$runAppletResult, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r14);
    L28:
        String r10 = this.$conversationID;
        String r11 = this.$botId;
        Function1<AppletRuntime, Unit> r12 = this.$runAppletResult;
        AppletRuntime r15 = (AppletRuntime) r14;
        if (r15 == null) goto L31;
        AppletRuntime.o(r15, r10, r11);
    L31:
        r12.invoke(r15);
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r14);
    L19:
        if ((r14 instanceof OnlineAppletApplication) == false) goto L21;
        OnlineAppletApplication r16 = (OnlineAppletApplication) r14;
    L22:
        if (r16 == null) goto L25;
        String r13 = this.$appletId;
        String r17 = this.$conversationID;
        String r18 = this.$botId;
        Function1<AppletRuntime, Unit> r19 = this.$runAppletResult;
        com.bytedance.ai.applet.base.log.b r20 = com.bytedance.ai.applet.base.log.a.a;
        com.bytedance.ai.applet.base.log.a.c("AppletRuntimeManager", "find OnlineAppletApplication, appId is " + r13);
        LynxWorkerRuntime r110 = r16.K();
        AppletRuntime.o(r110, r17, r18);
        r19.invoke(r110);
        return Unit.INSTANCE;
    L25:
        AppletRuntimeManager.INSTANCE.getClass();
        WorkerRuntimeManager r21 = AppletRuntimeManager.j();
        String r22 = this.$appletId;
        Context r23 = f2.k.a();
        String r24 = this.$conversationID;
        String r25 = this.$botId;
        String r26 = this.$msgId;
        String r27 = this.$replyFor;
        SessionType r111 = SessionType.CHATUI;
        Map<String, Object> r112 = this.$traceInfo;
        this.label = 3;
        r14 = r21.b(r22, r23, r24, r25, r26, r27, r111, r112, this);
        if (r14 != r0) goto L28;
        return r0;
    L21:
        r16 = null;
        goto L22
    L11:
        ResultKt.throwOnFailure(r14);
    L15:
        AppletAppManagerService r113 = AppletAppManagerService.INSTANCE;
        String r28 = this.$appletId;
        this.label = 2;
        r14 = r113.d(r28, this);
        if (r14 != r0) goto L19;
        return r0;
    L12:
        ResultKt.throwOnFailure(r14);
        CompletableDeferred<Unit> r114 = f2.b.b;
        this.label = 1;
        if (r114.await(this) != r0) goto L15;
        return r0;
    }
}
