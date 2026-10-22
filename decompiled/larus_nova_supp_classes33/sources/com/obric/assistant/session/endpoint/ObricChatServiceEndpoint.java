package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IObricChatSessionOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00102\u0006\u0010\r\u001a\u00020\u000eH\u0096@¢\u0006\u0002\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/session/endpoint/ObricChatServiceEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IObricChatSessionOperation;", "<init>", "()V", "prepareOrder", "", "getPrepareOrder", "()I", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricChatServiceEndpoint implements ISessionEndPoint, IObricChatSessionOperation {
    public ObricChatServiceEndpoint() {
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return -100;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "ObricChatServiceEndpoint";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r4, Continuation<? super Pair<? extends ErrorCode, String>> r5) {
        if ((r5 instanceof ObricChatServiceEndpoint$onSessionProcess$1) == false) goto L7;
        ObricChatServiceEndpoint$onSessionProcess$1 r6 = (ObricChatServiceEndpoint$onSessionProcess$1) r5;
        int r0 = r6.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r7 = r6.result;
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r6.label;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        ResultKt.throwOnFailure(r7);
    L18:
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r6.label = 1;
        if (ISessionEndPoint.a.e(this) != r1) goto L18;
        return r1;
    L7:
        r6 = new ObricChatServiceEndpoint$onSessionProcess$1(this, r5);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "args");
        ISessionEndPoint.a.d(this, r3, r4);
        if (ArraysKt.contains(new String[]{IInteractionStateService$Companion.WAKEUP_SOURCE_VOICE, IInteractionStateService$Companion.WAKE_UP_SOURCE_BLUETOOTH, IInteractionStateService$Companion.WAKE_UP_SOURCE_DORA_VOICE_WAKEUP, IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC}, bga.j.a()) == false) goto L8;
        IObricChatService.a.getClass();
        IObricChatService r5 = IObricChatService.a.a();
        if (r5 == null) goto L9;
        r5.e();
        return;
    L9:
        return;
    }
}
