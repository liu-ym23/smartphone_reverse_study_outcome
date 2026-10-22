package com.bytedance.ai.model;

import android.content.Context;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/AppletRuntime;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$awaitRunApplet$2", f = "AppletRuntimeManager.kt", i = {}, l = {321, 324}, m = "invokeSuspend", n = {}, s = {})
final class AppletRuntimeManager$awaitRunApplet$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletRuntime>, Object> {
    final /* synthetic */ String $appletId;
    final /* synthetic */ String $botId;
    final /* synthetic */ String $conversationID;
    final /* synthetic */ String $msgId;
    final /* synthetic */ String $replyFor;
    final /* synthetic */ Map<String, Object> $traceInfo;
    int label;

    public AppletRuntimeManager$awaitRunApplet$2(String r1, String r10, String r11, String r12, String r13, Map<String, Object> r14, Continuation<? super AppletRuntimeManager$awaitRunApplet$2> r15) {
        this.$appletId = r1;
        this.$conversationID = r10;
        this.$botId = r11;
        this.$msgId = r12;
        this.$replyFor = r13;
        this.$traceInfo = r14;
        super(2, r15);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new AppletRuntimeManager$awaitRunApplet$2(this.$appletId, this.$conversationID, this.$botId, this.$msgId, this.$replyFor, this.$traceInfo, r11);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r10) {
        return invoke((CoroutineScope) r1, (Continuation) r10);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AppletRuntime> r10) {
        return create(r1, r10).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r15);
    L16:
        AppletRuntime r16 = (AppletRuntime) r15;
        if (r16 == null) goto L23;
        String r10 = this.$conversationID;
        String r11 = this.$botId;
        if (Intrinsics.areEqual(r10, "SYSTEM_CVS_ID") == false) goto L21;
        SessionType r12 = SessionType.PLAYGROUND;
    L22:
        r16.m(r10, r11, r12);
        return r16;
    L21:
        r12 = SessionType.CHATUI;
        goto L22
    L23:
        return null;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
    L13:
        com.bytedance.ai.utils.g.a.i("AppletRuntimeManager", "awaitRunApplet: initializationDeferred completed");
        AppletRuntimeManager.INSTANCE.getClass();
        WorkerRuntimeManager r13 = AppletRuntimeManager.j();
        String r14 = this.$appletId;
        Context r17 = f2.k.a();
        String r18 = this.$conversationID;
        String r19 = this.$botId;
        String r20 = this.$msgId;
        String r110 = this.$replyFor;
        SessionType r111 = SessionType.CHATUI;
        Map<String, Object> r112 = this.$traceInfo;
        this.label = 2;
        r15 = r13.b(r14, r17, r18, r19, r20, r110, r111, r112, this);
        if (r15 != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r15);
        com.bytedance.ai.utils.g.a.i("AppletRuntimeManager", "awaitRunApplet called. appletId:" + this.$appletId + ", conversationID:" + this.$conversationID + ", botId:" + this.$botId + ", messageId:" + this.$msgId);
        CompletableDeferred<Unit> r113 = f2.b.b;
        this.label = 1;
        if (r113.await(this) != r0) goto L13;
        return r0;
    }
}
