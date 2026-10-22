package com.obric.memorydata.middleware.impl.app;

import com.obric.memorydata.middleware.api.app.c;
import com.obric.memorydata.middleware.api.app.d;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.q;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.middleware.impl.app.UserSettingsImpl$observerLoginState$1$4$1", f = "UserSettingsImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class UserSettingsImpl$observerLoginState$1$4$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ UserSettingsImpl.b $state;
    private /* synthetic */ Object L$0;
    int label;

    UserSettingsImpl$observerLoginState$1$4$1(UserSettingsImpl.b r3, Continuation<? super UserSettingsImpl$observerLoginState$1$4$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$state = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        UserSettingsImpl$observerLoginState$1$4$1 r0 = new UserSettingsImpl$observerLoginState$1$4$1(this.$state, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((UserSettingsImpl$observerLoginState$1$4$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), UserSettingsImpl$observerLoginState$1$4$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L52;
        ResultKt.throwOnFailure(r9);
        al r10 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        if (this.$state.a() == false) goto L28;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_UserSettingsImpl", "trigger onUserLogin, userId=" + q.f13259a.b(this.$state.b()), false, 4, null);
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$getLoginStateListeners$p(), Iterable.class, "com.obric.memorydata.plugin");
        UserSettingsImpl.b r2 = this.$state;
        Iterator r12 = r11.iterator();
    L8:
        if (r12.hasNext() == false) goto L17;
        d r3 = (d) ZeusTransformUtils.preCheckCast(r12.next(), d.class, "com.obric.memorydata.plugin");
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L12
        r3.a(r2.b());     // Catch: Throwable -> L12
        Object r5 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r6 = Result.m1424exceptionOrNullimpl(r5);
        if (r6 == null) goto L8;
        RunLog.INSTANCE.error("MeD_UserSettingsImpl", "notify onUserLogin failed, userId=" + q.f13259a.b(r2.b()), r6);
    L12:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r5 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    L17:
        c r13 = UserSettingsImpl.access$getLoginStateDispatchedListener$p();
        if (r13 == null) goto L50;
        UserSettingsImpl.b r8 = this.$state;
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L22
        r13.a(r8.b());     // Catch: Throwable -> L22
        Object r14 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L22
    L24:
        Throwable r15 = Result.m1424exceptionOrNullimpl(r14);
        if (r15 == null) goto L50;
        RunLog r16 = RunLog.INSTANCE;
        StringBuilder r17 = new StringBuilder();
        String r18 = "notify onLoginDispatched failed, userId=";
    L27:
        r16.error("MeD_UserSettingsImpl", r17.append(r18).append(q.f13259a.b(r8.b())).toString(), r15);
    L22:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r14 = Result.m1421constructorimpl(ResultKt.createFailure(th));
    L50:
        return Unit.INSTANCE;
    L28:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MeD_UserSettingsImpl", "trigger onUserLogout, lastUserId=" + q.f13259a.b(this.$state.b()), false, 4, null);
        Iterable r20 = (Iterable) ZeusTransformUtils.preCheckCast(UserSettingsImpl.access$getLoginStateListeners$p(), Iterable.class, "com.obric.memorydata.plugin");
        UserSettingsImpl.b r21 = this.$state;
        Iterator r22 = r20.iterator();
    L30:
        if (r22.hasNext() == false) goto L39;
        d r23 = (d) ZeusTransformUtils.preCheckCast(r22.next(), d.class, "com.obric.memorydata.plugin");
        Result.Companion r24 = Result.Companion;     // Catch: Throwable -> L34
        r23.b(r21.b());     // Catch: Throwable -> L34
        Object r25 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r26 = Result.m1424exceptionOrNullimpl(r25);
        if (r26 == null) goto L30;
        RunLog.INSTANCE.error("MeD_UserSettingsImpl", "notify onUserLogout failed, lastUserId=" + q.f13259a.b(r21.b()), r26);
    L34:
        th = move-exception;
        Result.Companion r27 = Result.Companion;
        r25 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L36
    L39:
        c r28 = UserSettingsImpl.access$getLoginStateDispatchedListener$p();
        if (r28 == null) goto L50;
        r8 = this.$state;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L44
        r28.b(r8.b());     // Catch: Throwable -> L44
        Object r30 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L44
    L46:
        r15 = Result.m1424exceptionOrNullimpl(r30);
        if (r15 == null) goto L50;
        r16 = RunLog.INSTANCE;
        r17 = new StringBuilder();
        r18 = "notify onLogoutDispatched failed, lastUserId=";
    L44:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r30 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L46
    L52:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
