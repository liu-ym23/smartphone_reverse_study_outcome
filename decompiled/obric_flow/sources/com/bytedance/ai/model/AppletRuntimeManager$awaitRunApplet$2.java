package com.bytedance.ai.model;

import android.app.Application;
import com.bytedance.ai.core.base.SessionType;
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
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ai/model/AppletRuntime;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$awaitRunApplet$2", f = "AppletRuntimeManager.kt", i = {}, l = {283, 286}, m = "invokeSuspend", n = {}, s = {})
final class AppletRuntimeManager$awaitRunApplet$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppletRuntime>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2217a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2218b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2219c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ Map f;

    public AppletRuntimeManager$awaitRunApplet$2(String r5, String r10, String r11, String r12, Map r13, Continuation r14) {
        this.f2218b = r5;
        this.f2219c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AppletRuntimeManager$awaitRunApplet$2(this.f2218b, this.f2219c, this.d, this.e, this.f, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super AppletRuntime> r10) {
        return ((AppletRuntimeManager$awaitRunApplet$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = this.f2217a;
        if (r5 == 0) goto L10;
        if (r5 == 1) goto L9;
        if (r5 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
        Object r11 = r12;
    L22:
        AppletRuntime r13 = (AppletRuntime) r11;
        if (r13 == null) goto L30;
        String r14 = this.f2219c;
        String r15 = this.d;
        if (Intrinsics.areEqual(r14, "SYSTEM_CVS_ID") == false) goto L27;
        SessionType r16 = SessionType.f2088b;
    L28:
        r13.k(r14, r15, r16);
        return r13;
    L27:
        r16 = SessionType.f2087a;
        goto L28
    L30:
        return null;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r12);
    L16:
        Intrinsics.checkNotNullParameter("AppletRuntimeManager", "tag");
        t0.d r17 = com.bytedance.ai.utils.c.f2846a;
        if (r17 == null) goto L19;
        r17.i("AppletRuntimeManager", "awaitRunApplet: initializationDeferred completed");
    L19:
        com.bytedance.ai.core.manager.b r18 = (com.bytedance.ai.core.manager.b) p.f2292a.getValue();
        String r19 = this.f2218b;
        Application r20 = s0.c.a();
        String r21 = this.f2219c;
        String r22 = this.d;
        String r23 = this.e;
        SessionType r24 = SessionType.f2087a;
        Map r25 = this.f;
        this.f2217a = 2;
        r11 = r18.b(r19, r20, r21, r22, r23, "", r24, r25, this);
        if (r11 != r10) goto L22;
    L21:
        return r10;
    L10:
        ResultKt.throwOnFailure(r12);
        StringBuilder r26 = new StringBuilder("awaitRunApplet called. appletId:");
        r26.append(this.f2218b);
        r26.append(", conversationID:");
        r26.append(this.f2219c);
        r26.append(", botId:");
        r26.append(this.d);
        r26.append(", messageId:");
        String r27 = androidx.room.jarjarred.org.antlr.runtime.a.v(r26, this.e, "AppletRuntimeManager", "tag");
        t0.d r28 = com.bytedance.ai.utils.c.f2846a;
        if (r28 == null) goto L13;
        r28.i("AppletRuntimeManager", r27);
    L13:
        kotlinx.coroutines.s r29 = s0.a.f21799b;
        this.f2217a = 1;
        if (r29.d(this) != r10) goto L16;
        goto L16
    }
}
