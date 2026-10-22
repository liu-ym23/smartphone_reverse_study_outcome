package com.obric.assistant.special_input.instruction;

import com.google.gson.Gson;
import com.obric.aiagent.assistant.idl.IAgentTaskAppIDL;
import com.obric.aiagent.assistant.idl.r;
import com.obric.aiagent.assistant.idl.s;
import com.obric.aiagent.ipc.utils.g;
import com.obric.assistant.ComplexTaskCaseFromPCConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import vea.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "Lcom/obric/assistant/special_input/instruction/PanelInstructionItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.special_input.instruction.PanelInstructionLoader$loadPanelItems$2", f = "PanelInstructionLoader.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 2, 2, 2, 3}, l = {56, 60, 61, 63}, m = "invokeSuspend", n = {"config", "shortcuts", "memory", "appFilterPolicy", "config", "memory", "appFilterPolicy", "operation", "config", "appFilterPolicy", "operation", "config"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$0"})
public final class PanelInstructionLoader$loadPanelItems$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<? extends PanelInstructionItem>>, Object> {
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;
    final /* synthetic */ PanelInstructionLoader this$0;

    public PanelInstructionLoader$loadPanelItems$2(PanelInstructionLoader r1, Continuation<? super PanelInstructionLoader$loadPanelItems$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        PanelInstructionLoader$loadPanelItems$2 r0 = new PanelInstructionLoader$loadPanelItems$2(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<PanelInstructionItem>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference failed for: r4v6, types: [com.obric.assistant.special_input.instruction.b, java.lang.Object] */
    public final Object invokeSuspend(Object r22) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        PanelInstructionLoader r3 = (PanelInstructionLoader) this.L$1;
        ComplexTaskCaseFromPCConfig r4 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r5 = r22;
    L60:
        r3.e = (com.obric.assistant.settings.d) r5;
        List<PanelInstructionItem> r6 = this.this$0.a(r4);
        final PanelInstructionLoader r7 = this.this$0;
        r7.f = r6;
        if (r7.g == true) goto L67;
        r7.g = true;
        if (s.a(Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class)) == null) goto L66;
        BuildersKt.launch$default(r7.h, null, null, new PanelInstructionLoader$registerTaskAppIpcRefreshCallback$1(r7, null), 3, null);
        goto L67
    L66:
        KClass r8 = Reflection.getOrCreateKotlinClass(IAgentTaskAppIDL.class);
        ?? r9 = new b(r7);
        Intrinsics.checkNotNullParameter(r8, "<this>");
        Intrinsics.checkNotNullParameter(r9, "action");
        g r10 = g.a;
        r r11 = new r(r9);
        r10.getClass();
        g.a(IAgentTaskAppIDL.class, r11, true);
    L67:
        return r6;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        PanelInstructionLoader r12 = (PanelInstructionLoader) this.L$3;
        List<PanelInstructionItem> r13 = (List) this.L$2;
        Deferred r14 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r15 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r16 = r22;
        List<PanelInstructionItem> r17 = r13;
    L56:
        r12.c = (List) r16;
        PanelInstructionLoader r18 = this.this$0;
        r18.d = r17;
        this.L$0 = r15;
        this.L$1 = r18;
        this.L$2 = null;
        this.L$3 = null;
        this.label = 4;
        r5 = r14.await(this);
        if (r5 != r1) goto L59;
        return r1;
    L59:
        r3 = r18;
        r4 = r15;
        goto L60
    L12:
        PanelInstructionLoader r19 = (PanelInstructionLoader) this.L$4;
        List<PanelInstructionItem> r20 = (List) this.L$3;
        Deferred r21 = (Deferred) this.L$2;
        Deferred r23 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r110 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r22);
        Object r24 = r22;
        List<PanelInstructionItem> r25 = r20;
        r14 = r21;
    L52:
        r19.b = (List) r24;
        r12 = this.this$0;
        this.L$0 = r110;
        this.L$1 = r14;
        this.L$2 = r25;
        this.L$3 = r12;
        this.L$4 = null;
        this.label = 3;
        r16 = r23.await(this);
        if (r16 != r1) goto L55;
        return r1;
    L55:
        r15 = r110;
        r17 = r25;
        goto L56
    L13:
        PanelInstructionLoader r26 = (PanelInstructionLoader) this.L$4;
        Deferred r27 = (Deferred) this.L$3;
        Deferred r28 = (Deferred) this.L$2;
        Deferred r111 = (Deferred) this.L$1;
        ComplexTaskCaseFromPCConfig r112 = (ComplexTaskCaseFromPCConfig) this.L$0;
        ResultKt.throwOnFailure(r22);
        Deferred r29 = r28;
        Deferred r30 = r111;
        r110 = r112;
        PanelInstructionLoader r31 = r26;
        Object r32 = r22;
    L18:
        Lazy<Gson> r113 = PanelInstructionLoader.i;
        r31.getClass();
        ArrayList r33 = new ArrayList();
        Iterator r34 = ((List) r32).iterator();
    L20:
        if (r34.hasNext() == false) goto L31;
        Object r114 = r34.next();
        String r115 = ((q) r114).b();
        if (r115 == null) goto L28;
        String r116 = StringsKt.trim(r115).toString();
        if (r116 == null) goto L28;
        if (StringsKt.equals(r116, "operation", true) != true) goto L28;
        boolean r117 = true;
    L29:
        if (r117 == false) goto L20;
        r33.add(r114);
    L28:
        r117 = false;
        goto L29
    L31:
        ArrayList r35 = new ArrayList();
        Iterator r36 = r33.iterator();
    L33:
        if (r36.hasNext() == false) goto L42;
        String r118 = ((q) r36.next()).a();
        if (r118 == null) goto L39;
        e r119 = PanelInstructionLoader.g(r118);
        if (r119 == null) goto L39;
        PanelInstructionItem r120 = PanelInstructionLoader.f(r119, PanelInstructionType.RECOMMEND_OPERATION);
    L40:
        if (r120 == null) goto L33;
        r35.add(r120);
    L39:
        r120 = null;
        goto L40
    L42:
        boolean r37 = r35.isEmpty();
        List<PanelInstructionItem> r38 = r35;
        if (r37 == false) goto L46;
        r38 = null;
    L46:
        if (r38 != null) goto L48;
        PanelInstructionLoader r39 = this.this$0;
        int r40 = r110.getLocalLimitCount();
        r39.getClass();
        r38 = PanelInstructionLoader.d(r40);
    L48:
        PanelInstructionLoader r41 = this.this$0;
        this.L$0 = r110;
        this.L$1 = r29;
        this.L$2 = r27;
        this.L$3 = r38;
        this.L$4 = r41;
        this.label = 2;
        r24 = r30.await(this);
        if (r24 != r1) goto L51;
        return r1;
    L51:
        r14 = r27;
        Deferred r210 = r29;
        r25 = r38;
        r19 = r41;
        r23 = r210;
        goto L52
    L14:
        ResultKt.throwOnFailure(r22);
        CoroutineScope r42 = (CoroutineScope) this.L$0;
        ComplexTaskCaseFromPCConfig r121 = (ComplexTaskCaseFromPCConfig) this.this$0.a.invoke();
        r30 = BuildersKt.async$default(r42, null, null, new PanelInstructionLoader$loadPanelItems$2$shortcuts$1(this.this$0, r121, null), 3, null);
        r29 = BuildersKt.async$default(r42, null, null, new PanelInstructionLoader$loadPanelItems$2$memory$1(this.this$0, r121, null), 3, null);
        Deferred r122 = BuildersKt.async$default(r42, null, null, new PanelInstructionLoader$loadPanelItems$2$operationData$1(this.this$0, null), 3, null);
        r27 = BuildersKt.async$default(r42, null, null, new PanelInstructionLoader$loadPanelItems$2$appFilterPolicy$1(this.this$0, null), 3, null);
        r31 = this.this$0;
        this.L$0 = r121;
        this.L$1 = r30;
        this.L$2 = r29;
        this.L$3 = r27;
        this.L$4 = r31;
        this.label = 1;
        r32 = r122.await(this);
        if (r32 != r1) goto L17;
        return r1;
    L17:
        r110 = r121;
        goto L18
    }
}
