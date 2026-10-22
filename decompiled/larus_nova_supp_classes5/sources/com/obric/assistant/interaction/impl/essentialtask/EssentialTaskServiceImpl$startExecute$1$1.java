package com.obric.assistant.interaction.impl.essentialtask;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.volcengine.zeus.Zeus;
import java.util.Iterator;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.essentialtask.EssentialTaskServiceImpl$startExecute$1$1", f = "EssentialTaskServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class EssentialTaskServiceImpl$startExecute$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ EssentialTaskServiceImpl this$0;

    public EssentialTaskServiceImpl$startExecute$1$1(EssentialTaskServiceImpl r1, Continuation<? super EssentialTaskServiceImpl$startExecute$1$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new EssentialTaskServiceImpl$startExecute$1$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r10);
        EssentialTaskServiceImpl.access$ensureHookLibraryLoaded(this.this$0);
        FLogger.a.i("EssentialTaskService", "load plugin start");
        TaskUtils r11 = TaskUtils.INSTANCE;
        TaskUtils.systemLog$default(r11, "EssentialTaskService", "load plugin start", null, 4, null);
        Iterator r12 = r11.getPlugins().iterator();
    L6:
        if (r12.hasNext() == false) goto L13;
        String r0 = (String) r12.next();
        if (Intrinsics.areEqual(r0, "com.obric.aiagent.plugin") == false) goto L12;
        if (Intrinsics.areEqual(ObricFeatureServiceDelegate.b.f(), "LowLevel") == false) goto L12;
        Zeus.loadPluginCrossProcess(r0, false);
    L12:
        Zeus.loadPluginCrossProcess(r0);
        goto L6
    L13:
        TaskUtils.systemLog$default(TaskUtils.INSTANCE, "EssentialTaskService", "load plugin finish", null, 4, null);
        FLogger.a.i("EssentialTaskService", "load plugin finish");
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
