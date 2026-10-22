package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/resource/access/PipelineExecuteResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2", f = "ResourceAccessPipeline.kt", i = {2, 2, 2, 2, 2, 2, 2, 3, 4}, l = {503, 516, 531, 541, 545}, m = "invokeSuspend", n = {"$this$coroutineScope", "knownKeys", "pending", "finished", "runningNodes", "runningJobs", "completedResults", "result", "result"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "L$0", "L$0"})
final class CompletionDrivenDagResourceNodeOrchestrator$execute$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super h>, Object> {
    final /* synthetic */ h0 $context;
    final /* synthetic */ List<l0> $nodes;
    final /* synthetic */ f $task;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    /* JADX INFO: renamed from: com.larus.bmhome.resource.access.CompletionDrivenDagResourceNodeOrchestrator$execute$2$2, reason: invalid class name */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<l0, Unit> {
        final /* synthetic */ CoroutineScope $$this$coroutineScope;
        final /* synthetic */ Channel<m0> $completedResults;
        final /* synthetic */ h0 $context;
        final /* synthetic */ Set<String> $finished;
        final /* synthetic */ LinkedHashMap<String, l0> $pending;
        final /* synthetic */ LinkedHashMap<String, Job> $runningJobs;
        final /* synthetic */ LinkedHashMap<String, l0> $runningNodes;
        final /* synthetic */ f $task;

        public AnonymousClass2(LinkedHashMap<String, l0> r1, Set<String> r2, f r3, h0 r4, LinkedHashMap<String, l0> r5, LinkedHashMap<String, Job> r6, CoroutineScope r7, Channel<m0> r8) {
            this.$pending = r1;
            this.$finished = r2;
            this.$task = r3;
            this.$context = r4;
            this.$runningNodes = r5;
            this.$runningJobs = r6;
            this.$$this$coroutineScope = r7;
            this.$completedResults = r8;
            super(1, Intrinsics.Kotlin.class, "launchNode", "invokeSuspend$launchNode(Ljava/util/LinkedHashMap;Ljava/util/Set;Lcom/larus/bmhome/resource/access/MutableResourceAccessTask;Lcom/larus/bmhome/resource/access/ResourceContext;Ljava/util/LinkedHashMap;Ljava/util/LinkedHashMap;Lkotlinx/coroutines/CoroutineScope;Lkotlinx/coroutines/channels/Channel;Lcom/larus/bmhome/resource/access/ResourceNode;)V", 0);
        }

        public final void invoke(l0 r11) {
            Intrinsics.checkNotNullParameter(r11, "p0");
            CompletionDrivenDagResourceNodeOrchestrator$execute$2.access$invokeSuspend$launchNode(this.$pending, this.$finished, this.$task, this.$context, this.$runningNodes, this.$runningJobs, this.$$this$coroutineScope, this.$completedResults, r11);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1) {
            invoke((l0) r1);
            return Unit.INSTANCE;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CompletionDrivenDagResourceNodeOrchestrator$execute$2(List<? extends l0> r1, f r2, h0 r3, Continuation<? super CompletionDrivenDagResourceNodeOrchestrator$execute$2> r4) {
        this.$nodes = r1;
        this.$task = r2;
        this.$context = r3;
        super(2, r4);
    }

    public static final /* synthetic */ Object access$invokeSuspend$cancelRunningNodes(LinkedHashMap r0, LinkedHashMap r1, Continuation r2) {
        return a(r0, r1, r2);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r0 = new CompletionDrivenDagResourceNodeOrchestrator$execute$2(this.$nodes, this.$task, this.$context, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v18, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r10v19, types: [java.util.ArrayList] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:143:0x032c -> B:144:0x0332). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r29) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        int r7 = 1;
        Object r8 = null;
        if (r2 == 0) goto L16;
        if (r2 == 1) goto L15;
        if (r2 == 2) goto L14;
        if (r2 == 3) goto L13;
        if (r2 == 4) goto L12;
        if (r2 != 5) goto L11;
        g r3 = (g) this.L$0;
        ResultKt.throwOnFailure(r29);
    L169:
        return new h.c(((g.c) r3).a);
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        g r4 = (g) this.L$0;
        ResultKt.throwOnFailure(r29);
    L161:
        return new h.b(((g.b) r4).a);
    L13:
        Channel r5 = (Channel) this.L$6;
        LinkedHashMap r9 = (LinkedHashMap) this.L$5;
        LinkedHashMap r10 = (LinkedHashMap) this.L$4;
        Set r11 = (Set) this.L$3;
        LinkedHashMap r12 = (LinkedHashMap) this.L$2;
        Set r13 = (Set) this.L$1;
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r29);
        LinkedHashMap r15 = r9;
        LinkedHashMap r6 = r12;
        Set r16 = r13;
        Object r17 = r29;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r18 = this;
        Set r19 = r11;
        LinkedHashMap r110 = r10;
        CoroutineScope r111 = r14;
    L144:
        m0 r112 = (m0) r17;
        r110.remove(r112.a.getKey());
        r15.remove(r112.a.getKey());
        g r20 = r112.b;
        if ((r20 instanceof g.a) == false) goto L153;
        g.a r21 = (g.a) r20;
        r18.$context.a(r21.a);
        f r22 = r18.$task;
        l0 r23 = r112.a;
        h0 r24 = r18.$context;
        i0 r25 = r21.a;
        if (r25.a == null) goto L149;
    L151:
        r22.e(new a0.e(r23.d(), r23.getKey(), r24.c, r24.b()));
    L175:
        Object r26 = null;
    L176:
        r19.add(r112.a.getKey());
        LinkedHashMap r113 = r6;
        Set r114 = r16;
        r7 = 1;
        r8 = r26;
    L26:
        if ((!r113.isEmpty()) == true) goto L30;
        if ((!r110.isEmpty()) == true) goto L30;
    L135:
        return h.a.a;
    L30:
        if (r18.$task.c() == false) goto L37;
        r18.L$0 = r8;
        r18.L$1 = r8;
        r18.L$2 = r8;
        r18.L$3 = r8;
        r18.L$4 = r8;
        r18.L$5 = r8;
        r18.L$6 = r8;
        r18.label = r7;
        if (a(r15, r110, r18) != r1) goto L35;
        return r1;
    L35:
        return h.a.a;
    L37:
        if (((r113.isEmpty() ? 1 : 0) ^ r7) == 0) goto L122;
        b r27 = b.a;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2 r28 = r18;
        CoroutineScope r210 = r111;
        r16 = r114;
        LinkedHashMap r115 = r113;
        Set r30 = r19;
        LinkedHashMap r31 = r110;
        LinkedHashMap r211 = r15;
        AnonymousClass2 r32 = new AnonymousClass2(r113, r19, r18.$task, r18.$context, r110, r15, r210, r5);
        Collection r33 = r115.values();
        ArrayList r116 = new ArrayList();
        Iterator r34 = r33.iterator();
    L39:
        boolean r117 = false;
        if (r34.hasNext() == false) goto L62;
        Object r118 = r34.next();
        List<String> r119 = ((l0) r118).f();
        if ((r119 instanceof Collection) == true) goto L44;
    L46:
        Iterator r120 = r119.iterator();
    L48:
        if (r120.hasNext() == false) goto L58;
        String r121 = (String) r120.next();
        if (r16.contains(r121) == true) goto L52;
    L55:
        boolean r122 = true;
    L56:
        if (r122 == true) goto L48;
    L59:
        if (r117 == false) goto L39;
        r116.add(r118);
        goto L39
    L52:
        if (r30.contains(r121) == true) goto L55;
        r122 = false;
    L58:
        r117 = true;
        goto L59
    L44:
        if (r119.isEmpty() == false) goto L46;
    L62:
        if (r116.isEmpty() == true) goto L124;
        ArrayList r35 = new ArrayList();
        Iterator r123 = r116.iterator();
    L66:
        if (r123.hasNext() == false) goto L73;
        Object r124 = r123.next();
        if (((l0) r124).g() != ResourceNodeCompletionMode.DETACHED) goto L70;
        boolean r125 = true;
    L71:
        if (r125 == false) goto L66;
        r35.add(r124);
        goto L66
    L70:
        r125 = false;
        goto L71
    L73:
        Iterator r36 = r35.iterator();
    L75:
        if (r36.hasNext() == false) goto L77;
        r32.invoke(r36.next());
        goto L75
    L77:
        Collection r37 = r31.values();
        if (r37.isEmpty() == true) goto L86;
        Iterator r38 = r37.iterator();
    L82:
        if (r38.hasNext() == false) goto L86;
        if (((((l0) r38.next()).h() ? 1 : 0) ^ r7) == 0) goto L82;
        boolean r39 = true;
    L87:
        if (r39 == true) goto L124;
        ArrayList r40 = new ArrayList();
        Iterator r126 = r116.iterator();
    L91:
        if (r126.hasNext() == false) goto L99;
        Object r127 = r126.next();
        if (((l0) r127).g() != ResourceNodeCompletionMode.BLOCKING) goto L95;
        boolean r128 = true;
    L96:
        if (r128 == false) goto L91;
        r40.add(r127);
        goto L91
    L95:
        r128 = false;
        goto L96
    L99:
        if (r40.isEmpty() == true) goto L124;
        if (r31.isEmpty() == false) goto L112;
        l0 r129 = (l0) CollectionsKt.first(r40);
        if (r129.h() == false) goto L111;
        ?? r130 = new ArrayList();
        Iterator r41 = r40.iterator();
    L107:
        if (r41.hasNext() == false) goto L118;
        Object r131 = r41.next();
        if (((l0) r131).h() == false) goto L107;
        r130.add(r131);
    L118:
        Iterator r42 = ((Iterable) r130).iterator();
    L120:
        if (r42.hasNext() == false) goto L124;
        r32.invoke(r42.next());
        goto L120
    L111:
        r130 = CollectionsKt.listOf(r129);
        goto L118
    L112:
        r130 = new ArrayList();
        Iterator r43 = r40.iterator();
    L114:
        if (r43.hasNext() == false) goto L118;
        Object r132 = r43.next();
        if (((l0) r132).h() == false) goto L114;
        r130.add(r132);
    L86:
        r39 = false;
    L124:
        if (r28.$task.c() == false) goto L130;
        r28.L$0 = null;
        r28.L$1 = null;
        r28.L$2 = null;
        r28.L$3 = null;
        r28.L$4 = null;
        r28.L$5 = null;
        r28.L$6 = null;
        r28.label = 2;
        if (a(r211, r31, r28) != r1) goto L129;
        return r1;
    L129:
        return h.a.a;
    L130:
        LinkedHashMap r133 = r211;
        if (r115.isEmpty() == false) goto L137;
        if (r31.isEmpty() == true) goto L135;
    L137:
        if (r31.isEmpty() == false) goto L140;
        r r44 = new r("pipeline", "node_dependency_cycle", "resource access node dependency cycle", null);
        FLogger.a.w("ResourceAccessPipeline", "[execute] node dependency cycle, pending=" + r115.keySet());
        return new h.b(r44);
    L140:
        CoroutineScope r45 = r210;
        r28.L$0 = r45;
        r28.L$1 = r16;
        LinkedHashMap r134 = r115;
        r28.L$2 = r134;
        r28.L$3 = r30;
        r28.L$4 = r31;
        r28.L$5 = r133;
        r28.L$6 = r5;
        r28.label = 3;
        r17 = r5.receive(r28);
        if (r17 != r1) goto L143;
        return r1;
    L143:
        r110 = r31;
        r15 = r133;
        r19 = r30;
        r6 = r134;
        r111 = r45;
        r18 = r28;
        goto L144
    L122:
        r28 = r18;
        r210 = r111;
        r16 = r114;
        r115 = r113;
        r30 = r19;
        r31 = r110;
        r211 = r15;
        goto L124
    L149:
        if (r25.g.isEmpty() == false) goto L151;
    L153:
        if (Intrinsics.areEqual(r20, g.e.a) == true) goto L175;
        if ((r20 instanceof g.b) == false) goto L163;
        r18.L$0 = r20;
        r18.L$1 = null;
        r18.L$2 = null;
        r18.L$3 = null;
        r18.L$4 = null;
        r18.L$5 = null;
        r18.L$6 = null;
        r18.label = 4;
        if (a(r15, r110, r18) != r1) goto L159;
        return r1;
    L159:
        r4 = r20;
        goto L161
    L163:
        if ((r20 instanceof g.c) == false) goto L170;
        r18.L$0 = r20;
        r18.L$1 = null;
        r18.L$2 = null;
        r18.L$3 = null;
        r18.L$4 = null;
        r18.L$5 = null;
        r18.L$6 = null;
        r18.label = 5;
        if (a(r15, r110, r18) != r1) goto L167;
        return r1;
    L167:
        r3 = r20;
        goto L169
    L170:
        r26 = null;
        if ((r20 instanceof g.d) == false) goto L174;
        r18.$context.a(new i0(null, null, null, null, null, ((g.d) r20).a, null, 95));
        goto L176
    L174:
        throw new NoWhenBranchMatchedException();
    L14:
        ResultKt.throwOnFailure(r29);
        goto L129
    L15:
        ResultKt.throwOnFailure(r29);
        goto L35
    L16:
        ResultKt.throwOnFailure(r29);
        CoroutineScope r46 = (CoroutineScope) this.L$0;
        List<l0> r47 = this.$nodes;
        ArrayList r135 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r47, 10));
        Iterator r48 = r47.iterator();
    L18:
        if (r48.hasNext() == false) goto L20;
        r135.add(((l0) r48.next()).getKey());
        goto L18
    L20:
        Set r49 = CollectionsKt.toSet(r135);
        LinkedHashMap r136 = new LinkedHashMap();
        Iterator r137 = this.$nodes.iterator();
    L22:
        if (r137.hasNext() == false) goto L24;
        l0 r138 = (l0) r137.next();
        r136.put(r138.getKey(), r138);
        goto L22
    L24:
        LinkedHashSet r139 = new LinkedHashSet();
        LinkedHashMap r140 = new LinkedHashMap();
        r15 = new LinkedHashMap();
        r19 = r139;
        r114 = r49;
        r18 = this;
        r111 = r46;
        r5 = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
        r110 = r140;
        r113 = r136;
        goto L26
    }

    public static final Object a(LinkedHashMap<String, Job> r7, LinkedHashMap<String, l0> r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1) == false) goto L7;
        CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1 r0 = (CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1) r9;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        Iterator r11 = (Iterator) r0.L$2;
        LinkedHashMap<String, l0> r12 = (LinkedHashMap) r0.L$1;
        LinkedHashMap<String, Job> r4 = (LinkedHashMap) r0.L$0;
        ResultKt.throwOnFailure(r10);
        LinkedHashMap<String, l0> r13 = r12;
        LinkedHashMap<String, Job> r14 = r4;
    L20:
        if (r11.hasNext() == false) goto L24;
        Job r5 = (Job) r11.next();
        r0.L$0 = r14;
        r0.L$1 = r13;
        r0.L$2 = r11;
        r0.label = 1;
        if (r5.join(r0) != r2) goto L20;
        return r2;
    L24:
        r14.clear();
        r13.clear();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r10);
        List r15 = CollectionsKt.toList(r7.values());
        Iterator r6 = r15.iterator();
    L16:
        if (r6.hasNext() == false) goto L18;
        Job.DefaultImpls.cancel$default((Job) r6.next(), null, 1, null);
        goto L16
    L18:
        r14 = r7;
        r11 = r15.iterator();
        r13 = r8;
    L7:
        r0 = new CompletionDrivenDagResourceNodeOrchestrator$execute$2$cancelRunningNodes$1(r9);
        goto L8
    }

    public static final void access$invokeSuspend$launchNode(LinkedHashMap r16, Set r17, f r18, h0 r19, LinkedHashMap r20, LinkedHashMap r21, CoroutineScope r22, Channel r23, l0 r24) {
        if (r24.g() != ResourceNodeCompletionMode.DETACHED) goto L8;
        r16.remove(r24.getKey());
        r17.add(r24.getKey());
        if (r18.c() == true) goto L12;
        CoroutineScope r0 = c.a;
        Intrinsics.checkNotNullParameter(r18, "task");
        Intrinsics.checkNotNullParameter(r19, "context");
        Intrinsics.checkNotNullParameter(r24, "node");
        BuildersKt.launch$default(c.a, null, null, new DetachedResourceNodeDispatcher$launch$1(r18, r19, r24, null), 3, null);
        FLogger.a.i("ResourceAccessPipeline", "[execute] launch detached node=" + r24.getKey() + ", taskId=" + r18.a);
        return;
    L12:
        return;
    L8:
        if (r18.c() == true) goto L14;
        r16.remove(r24.getKey());
        r20.put(r24.getKey(), r24);
        r21.put(r24.getKey(), BuildersKt.launch$default(r22, null, null, new CompletionDrivenDagResourceNodeOrchestrator$execute$2$launchNode$1(r23, r18, r19, r24, null), 3, null));
        FLogger.a.i("ResourceAccessPipeline", "[execute] launch node=" + r24.getKey() + ", taskId=" + r18.a);
        return;
    }
}
