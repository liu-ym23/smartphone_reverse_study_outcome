package com.obric.assistant.session.endpoint;

import android.content.ComponentName;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.IObricPluginActivityRecordHelper;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.session.bean.ErrorCode;
import com.obric.assistant.session.model.IApplicationActivityOperation;
import com.obric.assistant.session.model.ISessionEndPoint;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\"\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0096@¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0006H\u0016J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0012\u0010\u001a\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/session/endpoint/ApplicationActivityEndpoint;", "Lcom/obric/assistant/session/model/ISessionEndPoint;", "Lcom/obric/assistant/session/model/IApplicationActivityOperation;", "<init>", "()V", "foregroundAppPackageNameAtWakeUp", "", "foregroundActivityNameAtWakeUp", "prepareOrder", "", "getPrepareOrder", "()I", "processOrder", "getProcessOrder", "onSessionPrepared", "", "context", "Landroid/content/Context;", "args", "Landroid/os/Bundle;", "onSessionProcess", "Lkotlin/Pair;", "Lcom/obric/assistant/session/bean/ErrorCode;", "(Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foregroundAppPackage", "foregroundActivity", "parseArgs", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ApplicationActivityEndpoint implements ISessionEndPoint, IApplicationActivityOperation {
    public volatile String a;
    public volatile String b;

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int f() {
        return 90;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final int h() {
        return 70;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTagName() {
        return "ApplicationActivityEndpoint";
    }

    public ApplicationActivityEndpoint() {
        this.a = "";
        this.b = "";
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public Context getContext() {
        return ISessionEndPoint.a.getContext(this);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final String getTAG() {
        return ISessionEndPoint.a.b(this);
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final String a() {
        return this.b;
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final String c() {
        return this.a;
    }

    @Override // com.obric.assistant.session.model.IApplicationActivityOperation
    public final void b(Bundle r5) {
        FLogger.a.i(ISessionEndPoint.a.b(this), "parseArgs " + r5);
        if (r5 == null) goto L6;
        p(getContext(), r5);
        return;
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void n(ErrorCode r1) {
        ISessionEndPoint.a.c(this, r1);
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final Object d(Bundle r4, Continuation<? super Pair<? extends ErrorCode, String>> r5) {
        if ((r5 instanceof ApplicationActivityEndpoint$onSessionProcess$1) == false) goto L7;
        ApplicationActivityEndpoint$onSessionProcess$1 r6 = (ApplicationActivityEndpoint$onSessionProcess$1) r5;
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
    L17:
        IAssistantInteractionServiceKt.getInteractionStateService().setWakeUpAppPkg(this.a, "ApplicationActivityEndpoint onSessionProcess");
        return TuplesKt.to(ErrorCode.CONTINUE, "");
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r7);
        r6.label = 1;
        if (ISessionEndPoint.a.e(this) != r1) goto L17;
        return r1;
    L7:
        r6 = new ApplicationActivityEndpoint$onSessionProcess$1(this, r5);
        goto L8
    }

    @Override // com.obric.assistant.session.model.ISessionEndPoint
    public final void p(Context r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r8, "args");
        ISessionEndPoint.a.d(this, r7, r8);
        int r9 = Build.VERSION.SDK_INT;
        String r0 = "";
        if (r9 < 33) goto L5;
        String r2 = v0.a(r8);
    L6:
        if (r9 < 33) goto L32;
        if (r8 == null) goto L32;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L19
        ArrayList r11 = r8.getParcelableArrayList("android.service.voice.FOREGROUND_ACTIVITIES", ComponentName.class);     // Catch: Throwable -> L19
        if (r11 == null) goto L14;
        ComponentName r12 = (ComponentName) CollectionsKt.firstOrNull(r11);     // Catch: Throwable -> L19
        if (r12 == null) goto L14;
        String r13 = r12.getClassName();     // Catch: Throwable -> L19
    L15:
        if (r13 != null) goto L17;
        r13 = "";
    L17:
        Object r14 = Result.constructor-impl(r13);     // Catch: Throwable -> L19
    L21:
        Throwable r15 = Result.exceptionOrNull-impl(r14);
        if (r15 == null) goto L25;
        FLogger.a.e("EndpointUtil", "getForeGroundActivityName error: " + r15);
    L25:
        if (Result.isSuccess-impl(r14) == false) goto L27;
        FLogger.a.i("EndpointUtil", "getForeGroundActivityName className: " + ((String) r14));
    L27:
        Object r1 = r0;
        if (Result.isFailure-impl(r14) == true) goto L31;
        r1 = r14;
    L31:
        r0 = (String) r1;
    L14:
        r13 = null;
    L19:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r14 = Result.constructor-impl(ResultKt.createFailure(th));
    L32:
        this.a = r2;
        this.b = r0;
        FLogger.a.i(ISessionEndPoint.a.b(this), "pkg: " + r2 + " act: " + r0);
        IObricPluginActivityRecordHelper.a.getClass();
        IObricPluginActivityRecordHelper r17 = IObricPluginActivityRecordHelper.a.a();
        if (r17 == null) goto L38;
        r17.b();
        return;
    L38:
        return;
    L5:
        r2 = "";
        goto L6
    }
}
