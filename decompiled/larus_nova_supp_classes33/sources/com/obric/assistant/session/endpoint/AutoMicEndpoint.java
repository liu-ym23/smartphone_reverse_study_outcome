package com.obric.assistant.session.endpoint;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IAutoMicOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import com.obric.assistant.trace.IObricTraceParam;
import com.obric.assistant.voice.ContentScene;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\"\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00160\u00142\u0006\u0010\u0011\u001a\u00020\u0012H\u0096@¢\u0006\u0002\u0010\u0017J\n\u0010\u0018\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0019\u001a\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/obric/assistant/session/endpoint/AutoMicEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IAutoMicOperation;", "<init>", "()V", "prepareOrder", "", "getPrepareOrder", "()I", "autoMicToken", "Lcom/obric/assistant/session/bean/AutoMicToken;", "mLock", "Ljava/util/concurrent/locks/ReentrantLock;", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getToken", "setToken", "source", "Lcom/obric/assistant/voice/ContentScene;", "data", "Landroid/os/Parcelable;", "reset", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AutoMicEndpoint implements ISessionEndPoint, IAutoMicOperation {
    public zfa.a a;
    public final ReentrantLock b;

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return -50;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 0;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "AutoMicEndpoint";
    }

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final zfa.a getToken() {
        ReentrantLock r0 = this.b;
        r0.lock();
        zfa.a r1 = this.a;     // Catch: Throwable -> L6
        r0.unlock();
        return r1;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final void reset() {
        ReentrantLock r0 = this.b;
        r0.lock();
        this.a = null;     // Catch: Throwable -> L6
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    public AutoMicEndpoint() {
        this.b = new ReentrantLock();
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

    @Override // com.obric.assistant.session.model.IAutoMicOperation
    public final void a(ContentScene r3, Parcelable r4) {
        ReentrantLock r0 = this.b;
        r0.lock();
        this.a = new zfa.a(r3, r4);     // Catch: Throwable -> L6
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r0.unlock();
        return;
    L6:
        th = move-exception;
        r0.unlock();
        throw th;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r4, Continuation<? super Pair<? extends ErrorCode, String>> r5) {
        if ((r5 instanceof AutoMicEndpoint$onSessionProcess$1) == false) goto L7;
        AutoMicEndpoint$onSessionProcess$1 r6 = (AutoMicEndpoint$onSessionProcess$1) r5;
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
        r6 = new AutoMicEndpoint$onSessionProcess$1(this, r5);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "args");
        ISessionEndPoint.a.d(this, r2, r3);
        if (Intrinsics.areEqual(bga.j.a(), IInteractionStateService$Companion.WAKEUP_SOURCE_AUTO_MIC) == false) goto L10;
        zfa.a r4 = this.a;
        if (r4 == null) goto L11;
        ContentScene r5 = r4.a;
        if (r5 == null) goto L12;
        IInteractionStateService r6 = IAssistantInteractionServiceKt.getInteractionStateService();
        IObricTraceParam.a.getClass();
        int r0 = com.obric.assistant.automic.i.a;
        r6.setWakeUpData(0, com.obric.assistant.automic.a.a(r5));
        return;
    L12:
        return;
    L11:
        return;
    }
}
