package com.larus.uaigc.helper;

import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1", f = "CreationResourceAccessPerfBridge.kt", i = {}, l = {38}, m = "invokeSuspend", n = {}, s = {})
public final class CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $instanceId;
    final /* synthetic */ String $parentInstanceId;
    final /* synthetic */ String $parentScene;
    final /* synthetic */ Map<String, com.larus.bmhome.resource.access.q0> $reportedStates;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $this_awaitTerminalStateWithCreationPerf;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ Map<String, com.larus.bmhome.resource.access.q0> a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(Map<String, com.larus.bmhome.resource.access.q0> r1, String r2, String r3, String r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }

        public final Object emit(Object r5, Continuation r6) {
            Collection r7 = ((Map) r5).values();
            Map<String, com.larus.bmhome.resource.access.q0> r8 = this.a;
            String r0 = this.b;
            String r1 = this.c;
            String r2 = this.d;
            Iterator<T> r9 = r7.iterator();
        L4:
            if (r9.hasNext() == false) goto L7;
            CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4.access$invokeSuspend$reportIfChanged(r8, r0, r1, r2, (com.larus.bmhome.resource.access.q0) r9.next());
            goto L4
        L7:
            return Unit.INSTANCE;
        }
    }

    public CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1(com.larus.bmhome.resource.access.b0 r1, Map<String, com.larus.bmhome.resource.access.q0> r2, String r3, String r4, String r5, Continuation<? super CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1> r6) {
        this.$this_awaitTerminalStateWithCreationPerf = r1;
        this.$reportedStates = r2;
        this.$parentScene = r3;
        this.$instanceId = r4;
        this.$parentInstanceId = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1(this.$this_awaitTerminalStateWithCreationPerf, this.$reportedStates, this.$parentScene, this.$instanceId, this.$parentInstanceId, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r8);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        StateFlowImpl r9 = this.$this_awaitTerminalStateWithCreationPerf.b();
        a r2 = new a(this.$reportedStates, this.$parentScene, this.$instanceId, this.$parentInstanceId);
        this.label = 1;
        if (r9.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
