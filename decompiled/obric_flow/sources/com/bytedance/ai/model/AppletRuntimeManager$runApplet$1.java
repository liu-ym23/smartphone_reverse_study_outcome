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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ai.model.AppletRuntimeManager$runApplet$1", f = "AppletRuntimeManager.kt", i = {}, l = {323, 324}, m = "invokeSuspend", n = {}, s = {})
final class AppletRuntimeManager$runApplet$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f2220a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f2221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f2222c;
    public final /* synthetic */ String d;
    public final /* synthetic */ String e;
    public final /* synthetic */ String f;
    public final /* synthetic */ Map g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Function1 f2223h;

    public AppletRuntimeManager$runApplet$1(String r5, String r10, String r11, String r12, String r13, Map r14, Function1 r15, Continuation r16) {
        this.f2221b = r5;
        this.f2222c = r10;
        this.d = r11;
        this.e = r12;
        this.f = r13;
        this.g = r14;
        this.f2223h = r15;
        super(2, r16);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object r10, Continuation r11) {
        return new AppletRuntimeManager$runApplet$1(this.f2221b, this.f2222c, this.d, this.e, this.f, this.g, this.f2223h, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public final Object mo2invoke(CoroutineScope r5, Continuation<? super Unit> r10) {
        return ((AppletRuntimeManager$runApplet$1) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r14) {
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r10 = this.f2220a;
        if (r10 == 0) goto L10;
        if (r10 == 1) goto L9;
        if (r10 != 2) goto L8;
        ResultKt.throwOnFailure(r14);
    L16:
        Function1 r11 = this.f2223h;
        String r12 = this.f2222c;
        String r13 = this.d;
        AppletRuntime r15 = (AppletRuntime) r14;
        r11.invoke(r15);
        if (r15 == null) goto L20;
        int r16 = AppletRuntime.f2196x;
        r15.k(r12, r13, SessionType.f2087a);
    L20:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
    L13:
        com.bytedance.ai.core.manager.b r17 = (com.bytedance.ai.core.manager.b) p.f2292a.getValue();
        String r18 = this.f2221b;
        Application r19 = s0.c.a();
        String r20 = this.f2222c;
        String r21 = this.d;
        String r22 = this.e;
        String r23 = this.f;
        SessionType r110 = SessionType.f2087a;
        Map r111 = this.g;
        this.f2220a = 2;
        r14 = r17.b(r18, r19, r20, r21, r22, r23, r110, r111, this);
        if (r14 != r5) goto L16;
    L15:
        return r5;
    L10:
        ResultKt.throwOnFailure(r14);
        kotlinx.coroutines.s r112 = s0.a.f21799b;
        this.f2220a = 1;
        if (r112.d(this) != r5) goto L13;
        goto L13
    }
}
