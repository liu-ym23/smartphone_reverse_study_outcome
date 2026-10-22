package com.obric.assistant.interaction.impl;

import android.app.ActivityManager;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IPlatformApiIDL;
import com.obric.aiagent.assistant.idl.l4;
import com.obric.aiagent.ipc.utils.g;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.AssistantChatWindowImpl$exitVirtualDisplay$1", f = "AssistantChatWindowImpl.kt", i = {0}, l = {604}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class AssistantChatWindowImpl$exitVirtualDisplay$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $delayMS;
    private /* synthetic */ Object L$0;
    int label;

    public AssistantChatWindowImpl$exitVirtualDisplay$1(long r1, Continuation<? super AssistantChatWindowImpl$exitVirtualDisplay$1> r3) {
        this.$delayMS = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        AssistantChatWindowImpl$exitVirtualDisplay$1 r0 = new AssistantChatWindowImpl$exitVirtualDisplay$1(this.$delayMS, r5);
        r0.L$0 = r4;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        CoroutineScope r3 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r9);
    L13:
        Object r10 = AppHost.a.getApplication().getSystemService("activity");
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type android.app.ActivityManager");
        Iterator<T> r11 = ((ActivityManager) r10).getAppTasks().iterator();
    L15:
        if (r11.hasNext() == false) goto L32;
        ActivityManager.AppTask r4 = (ActivityManager.AppTask) r11.next();
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L23
        FLogger.a.i("AssistantChatWindowImpl", "leaveOAutoDisplay " + r4.getTaskInfo().topActivity);     // Catch: Throwable -> L23
        KClass r6 = Reflection.getOrCreateKotlinClass(IPlatformApiIDL.class);     // Catch: Throwable -> L23
        int r7 = l4.a;     // Catch: Throwable -> L23
        Intrinsics.checkNotNullParameter(r6, "<this>");     // Catch: Throwable -> L23
        g.a.getClass();     // Catch: Throwable -> L23
        IPlatformApiIDL r8 = g.b(IPlatformApiIDL.class);     // Catch: Throwable -> L23
        if (r8 == null) goto L20;
        Boolean r12 = Boxing.boxBoolean(r8.moveTaskToDisplay(r4.getTaskInfo().taskId, 0, true));     // Catch: Throwable -> L23
    L21:
        Object r13 = Result.constructor-impl(r12);     // Catch: Throwable -> L23
    L25:
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L29;
        FLogger.a.w("AssistantChatWindowImpl", "leaveOAutoDisplay failed: " + r14.getMessage(), r14);
    L29:
        if (Result.isSuccess-impl(r13) == false) goto L15;
        FLogger.a.i("AssistantChatWindowImpl", "leaveOAutoDisplay succeed. result " + ((Boolean) r13));
        goto L15
    L20:
        r12 = null;
    L23:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L32:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        CoroutineScope r16 = (CoroutineScope) this.L$0;
        long r17 = this.$delayMS;
        if (r17 <= 0) goto L13;
        this.L$0 = r16;
        this.label = 1;
        if (DelayKt.delay(r17, this) != r1) goto L13;
        return r1;
    }
}
