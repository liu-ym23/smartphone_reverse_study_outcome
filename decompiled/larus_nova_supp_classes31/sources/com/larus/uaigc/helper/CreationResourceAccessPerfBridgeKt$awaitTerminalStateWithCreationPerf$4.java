package com.larus.uaigc.helper;

import com.larus.bmhome.resource.access.ResourceNodeStatus;
import com.larus.uaigc.service.ICreationResourceAccessServiceKt;
import com.tencent.open.log.TraceLevel;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/ResourceAccessState;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.uaigc.helper.CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4", f = "CreationResourceAccessPerfBridge.kt", i = {0, 0, 1, 2}, l = {43, 45, 45}, m = "invokeSuspend", n = {"reportedStates", "nodeStateJob", "reportedStates", "reportedStates"}, s = {"L$0", "L$1", "L$0", "L$0"})
public final class CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.resource.access.a0>, Object> {
    final /* synthetic */ String $instanceId;
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.e, Unit> $onRunning;
    final /* synthetic */ Function1<com.larus.bmhome.resource.access.a0.f, Unit> $onUploading;
    final /* synthetic */ String $parentInstanceId;
    final /* synthetic */ String $parentScene;
    final /* synthetic */ com.larus.bmhome.resource.access.b0 $this_awaitTerminalStateWithCreationPerf;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    public CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4(com.larus.bmhome.resource.access.b0 r1, Function1<? super com.larus.bmhome.resource.access.a0.e, Unit> r2, Function1<? super com.larus.bmhome.resource.access.a0.f, Unit> r3, String r4, String r5, String r6, Continuation<? super CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4> r7) {
        this.$this_awaitTerminalStateWithCreationPerf = r1;
        this.$onRunning = r2;
        this.$onUploading = r3;
        this.$parentScene = r4;
        this.$instanceId = r5;
        this.$parentInstanceId = r6;
        super(2, r7);
    }

    public static final /* synthetic */ void access$invokeSuspend$reportIfChanged(Map r0, String r1, String r2, String r3, com.larus.bmhome.resource.access.q0 r4) {
        a(r0, r1, r2, r3, r4);
    }

    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4 r8 = new CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4(this.$this_awaitTerminalStateWithCreationPerf, this.$onRunning, this.$onUploading, this.$parentScene, this.$instanceId, this.$parentInstanceId, r11);
        r8.L$0 = r10;
        return r8;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.resource.access.a0> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r0 = this.label;
        if (r0 == 0) goto L16;
        if (r0 == 1) goto L11;
        if (r0 == 2) goto L10;
        if (r0 != 3) goto L9;
        th = (Throwable) this.L$1;
        Map r3 = (Map) this.L$0;
        ResultKt.throwOnFailure(r18);
    L39:
        Collection r4 = this.$this_awaitTerminalStateWithCreationPerf.snapshot().g.values();
        String r5 = this.$parentScene;
        String r6 = this.$instanceId;
        String r7 = this.$parentInstanceId;
        Iterator r8 = r4.iterator();
    L41:
        if (r8.hasNext() == false) goto L43;
        a(r3, r5, r6, r7, (com.larus.bmhome.resource.access.q0) r8.next());
        goto L41
    L43:
        throw th;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        com.larus.bmhome.resource.access.a0 r1 = (com.larus.bmhome.resource.access.a0) this.L$1;
        Map r9 = (Map) this.L$0;
        ResultKt.throwOnFailure(r18);
    L26:
        Collection r10 = this.$this_awaitTerminalStateWithCreationPerf.snapshot().g.values();
        String r11 = this.$parentScene;
        String r12 = this.$instanceId;
        String r13 = this.$parentInstanceId;
        Iterator r14 = r10.iterator();
    L28:
        if (r14.hasNext() == false) goto L30;
        a(r9, r11, r12, r13, (com.larus.bmhome.resource.access.q0) r14.next());
        goto L28
    L30:
        return r1;
    L11:
        Job r15 = (Job) this.L$1;
        Map r16 = (Map) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L14
        Object r17 = r18;
        Map r19 = r16;
    L44:
        r1 = (com.larus.bmhome.resource.access.a0) r17;     // Catch: Throwable -> L31
        this.L$0 = r19;
        this.L$1 = r1;
        this.label = 2;
        if (JobKt.cancelAndJoin(r15, this) != r2) goto L25;
        return r2;
    L25:
        r9 = r19;
    L31:
        th = th;
    L35:
        this.L$0 = r19;
        this.L$1 = th;
        this.label = 3;
        if (JobKt.cancelAndJoin(r15, this) != r2) goto L38;
        return r2;
    L38:
        r3 = r19;
    L14:
        th = th;
        r19 = r16;
        goto L35
    L16:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r20 = (CoroutineScope) this.L$0;
        r19 = new LinkedHashMap();
        Job r21 = BuildersKt.launch$default(r20, null, null, new CreationResourceAccessPerfBridgeKt$awaitTerminalStateWithCreationPerf$4$nodeStateJob$1(this.$this_awaitTerminalStateWithCreationPerf, r19, this.$parentScene, this.$instanceId, this.$parentInstanceId, null), 3, null);
        com.larus.bmhome.resource.access.b0 r22 = this.$this_awaitTerminalStateWithCreationPerf;     // Catch: Throwable -> L33
        Function1<com.larus.bmhome.resource.access.a0.e, Unit> r23 = this.$onRunning;     // Catch: Throwable -> L33
        Function1<com.larus.bmhome.resource.access.a0.f, Unit> r24 = this.$onUploading;     // Catch: Throwable -> L33
        this.L$0 = r19;     // Catch: Throwable -> L33
        this.L$1 = r21;     // Catch: Throwable -> L33
        this.label = 1;     // Catch: Throwable -> L33
        r17 = ICreationResourceAccessServiceKt.a(r22, r23, r24, this);     // Catch: Throwable -> L33
        if (r17 != r2) goto L20;
        return r2;
    L20:
        r15 = r21;
    L33:
        th = th;
        r15 = r21;
        goto L35
    }

    public static final void a(Map<String, com.larus.bmhome.resource.access.q0> r10, String r11, String r12, String r13, com.larus.bmhome.resource.access.q0 r14) {
        com.larus.bmhome.resource.access.q0 r0 = r10.get(r14.a);
        if (Intrinsics.areEqual(r0, r14) == false) goto L5;
        return;
    L5:
        r10.put(r14.a, r14);
        String r15 = r14.a;
        int r1 = r15.hashCode();
        ResourceNodeStatus r8 = null;
        if (r1 == (-2109015642)) goto L19;
        if (r1 == (-934348968)) goto L15;
        if (r1 == (-805388692)) goto L11;
    L20:
        String r16 = null;
    L22:
        if (r16 == null) goto L72;
        ResourceNodeStatus r2 = r14.c;
        int[] r9 = CreationResourceAccessPerfBridgeKt.a.a;
        switch(r9[r2.ordinal()]) {
            case 1: goto L63;
            case 2: goto L70;
            case 3: goto L28;
            case 4: goto L28;
            case 5: goto L28;
            case 6: goto L28;
            case 7: goto L28;
            default: goto L27;
        };
    L28:
        if (r0 == null) goto L31;
        r8 = r0.c;
    L31:
        if (r8 != ResourceNodeStatus.RUNNING) goto L73;
        CreationResourceAccessPerfBridgeKt.c(r11, r13, r16, r12, r14);
        switch(r9[r14.c.ordinal()]) {
            case 1: goto L61;
            case 2: goto L61;
            case 3: goto L61;
            case 4: goto L61;
            case 5: goto L61;
            case 6: goto L38;
            case 7: goto L37;
            default: goto L36;
        };
    L37:
        String r17 = "-999";
    L62:
        nz9.b.e(r16, r17, r12);
        return;
    L38:
        String r18 = r14.a;
        int r19 = r18.hashCode();
        if (r19 == (-2109015642)) goto L54;
        if (r19 == (-934348968)) goto L50;
        if (r19 == (-805388692)) goto L44;
    L55:
        r17 = r14.e;
        if (r17 != null) goto L62;
    L60:
        r17 = "-102";
        goto L62
    L44:
        if (r18.equals("preprocess") == false) goto L55;
        r17 = r14.e;
        if (r17 != null) goto L62;
        r17 = "-101";
        goto L62
    L50:
        if (r18.equals("review") == false) goto L55;
        r17 = "-103";
        goto L62
    L54:
        if (r18.equals("sdk_upload") == false) goto L55;
        r17 = r14.e;
        if (r17 != null) goto L62;
    L61:
        r17 = "0";
        goto L62
    L36:
        throw new NoWhenBranchMatchedException();
    L73:
        return;
    L63:
        if (r0 == null) goto L66;
        r8 = r0.c;
    L66:
        if (r8 == ResourceNodeStatus.RUNNING) goto L68;
        nz9.b.h(r16, r11, r12, r13, 16);
    L68:
        CreationResourceAccessPerfBridgeKt.c(r11, r13, r16, r12, r14);
        return;
    L70:
        return;
    L27:
        throw new NoWhenBranchMatchedException();
    L72:
        return;
    L11:
        if (r15.equals("preprocess") == false) goto L20;
        r16 = "preprocess";
        goto L22
    L15:
        if (r15.equals("review") == false) goto L20;
        r16 = "image_review";
        goto L22
    L19:
        if (r15.equals("sdk_upload") == false) goto L20;
        r16 = "upload";
        goto L22
    }
}
