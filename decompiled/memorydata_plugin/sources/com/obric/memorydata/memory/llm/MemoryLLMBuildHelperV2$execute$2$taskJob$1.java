package com.obric.memorydata.memory.llm;

import android.os.SystemClock;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.dtrait.constant.DTraitConstant;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.memory.CommonTextMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.BuildConfig;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.plugin.R;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.at;
import com.ttnet.org.chromium.net.NetError;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.al;
import kotlinx.coroutines.am;
import kotlinx.coroutines.n;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2$execute$2$taskJob$1", f = "MemoryLLMBuildHelperV2.kt", i = {0, 1, 1, 1, 1, 2, 2}, l = {251, 423, 482}, m = "invokeSuspend", n = {"$this$launch", "$this$launch", "taskResult", "finalStatus", "answer", "$this$launch", "taskResult"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$0", "L$1"})
final class MemoryLLMBuildHelperV2$execute$2$taskJob$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ c $buildControl;
    final /* synthetic */ n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> $continuation;
    final /* synthetic */ boolean $eval;
    final /* synthetic */ Map<String, Object> $extraMap;
    final /* synthetic */ Ref.BooleanRef $hasStreamSession;
    final /* synthetic */ e $inputData;
    final /* synthetic */ com.obric.memorydata.middleware.api.logging.e $logContext;
    final /* synthetic */ o $logger;
    final /* synthetic */ i $rejectedMemoryCleanup;
    final /* synthetic */ Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> $resultEntities;
    final /* synthetic */ String $sessionId;
    final /* synthetic */ long $taskStartMs;
    final /* synthetic */ com.obric.memorydata.memory.tracker.g.b $trackingEvent;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class a implements Function1<JSONObject, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ al f10269a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ c f10270b;
        final /* synthetic */ o c;
        final /* synthetic */ com.obric.memorydata.middleware.api.logging.e d;
        final /* synthetic */ com.obric.memorydata.memory.tracker.g.b e;
        final /* synthetic */ Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> f;
        final /* synthetic */ Ref.BooleanRef g;
        final /* synthetic */ String h;
        final /* synthetic */ n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> i;
        final /* synthetic */ Map<String, Object> j;
        final /* synthetic */ i k;
        final /* synthetic */ long l;

        /* JADX INFO: renamed from: com.obric.memorydata.memory.llm.MemoryLLMBuildHelperV2$execute$2$taskJob$1$a$a, reason: collision with other inner class name */
        @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
        static final class C0505a implements Function1<com.obric.memorydata.middleware.api.logging.g, Unit> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ al f10275a;

            C0505a(al r3) {
                this.f10275a = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
            }

            public final void a(com.obric.memorydata.middleware.api.logging.g r2) {
                Intrinsics.checkNotNullParameter(r2, "$this$mainTrace");
                r2.a("task_active", Boolean.valueOf(am.a(this.f10275a)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* synthetic */ Unit invoke(com.obric.memorydata.middleware.api.logging.g r3) {
                a((com.obric.memorydata.middleware.api.logging.g) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.middleware.api.logging.g.class, "com.obric.memorydata.plugin"));
                return Unit.INSTANCE;
            }
        }

        a(al r3, c r4, o r5, com.obric.memorydata.middleware.api.logging.e r6, com.obric.memorydata.memory.tracker.g.b r7, Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r8, Ref.BooleanRef r9, String r10, n<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r11, Map<String, Object> r12, i r13, long r14) {
            al r15 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
            n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r16 = (n) ZeusTransformUtils.wrapperContextForParams(r11, n.class, "com.obric.memorydata.plugin");
            Map<String, Object> r17 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
            this.f10269a = r15;
            this.f10270b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
            this.f = r8;
            this.g = r9;
            this.h = r10;
            this.i = r16;
            this.j = r17;
            this.k = r13;
            this.l = r14;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v12, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v24 */
        /* JADX WARN: Type inference failed for: r2v32, types: [T, java.util.List] */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v46 */
        /* JADX WARN: Type inference failed for: r2v47 */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        public final void a(JSONObject r26) {
            Intrinsics.checkNotNullParameter(r26, "json");
            if (am.a(this.f10269a) == true) goto L5;
            return;
        L5:
            c r2 = this.f10270b;
            if (r2 != null) goto L8;
        L10:
            boolean r3 = false;
        L11:
            if (r3 == false) goto L16;
            o r1 = this.c;
            com.obric.memorydata.middleware.api.logging.e r0 = this.d;
            if (AppContext.INSTANCE.isDebug() == false) goto L116;
            com.obric.memorydata.middleware.api.logging.g r4 = new com.obric.memorydata.middleware.api.logging.g();
            Unit r5 = Unit.INSTANCE;
            r1.a("忽略取消后的记忆构建进度", r0, r4.a());
            return;
        L116:
            return;
        L16:
            o r6 = this.c;
            com.obric.memorydata.middleware.api.logging.e r7 = this.d;
            if (AppContext.INSTANCE.isDebug() == false) goto L19;
            com.obric.memorydata.middleware.api.logging.g r8 = new com.obric.memorydata.middleware.api.logging.g();
            r8.a("progress", r26);
            Unit r9 = Unit.INSTANCE;
            r6.a("记忆构建进度已回调", r7, r8.a());
        L19:
            int r10 = r26.optInt("stage");
            if (r10 != 2) goto L22;
            com.obric.memorydata.memory.tracker.g.b r11 = this.e;
            if (r11 == null) goto L78;
            r11.b();
        L78:
            List r12 = MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, r26);
            boolean r13 = !((Collection) ZeusTransformUtils.preCheckCast(r12, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
            ?? r14 = r12;
            if (r13 == true) goto L82;
            r14 = 0;
        L82:
            if (r14 == 0) goto L84;
            i r15 = this.k;
            Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r16 = this.f;
            r15.a(r14);
            r16.element = r14;
        L84:
            o r17 = this.c;
            com.obric.memorydata.middleware.api.logging.e r18 = this.d;
            final Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r19 = this.f;
            o.a(r17, "记忆构建快照阶段完成", "snapshot_ready", r18, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass3(r19), Function1.class, "com.obric.memorydata.plugin"), null, 16, null);
            List r20 = (List) ZeusTransformUtils.preCheckCast(this.f.element, List.class, "com.obric.memorydata.plugin");
            if (r20 == null) goto L87;
            MemoryLLMBuildHelperV2.a r21 = (MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(CollectionsKt.lastOrNull(r20), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin");
        L88:
            if (r21 == null) goto L90;
            MemoryLLMBuildHelperV2.ResultEntityType r22 = r21.b();
        L92:
            if (r22 != MemoryLLMBuildHelperV2.ResultEntityType.EPISODIC) goto L121;
            AppEntity r23 = MemoryLLMBuildHelperV2.f10255a.a(r21);
            if (ZeusTransformUtils.instanceOf(r23, CommonTextMemoryEntity.class) == false) goto L96;
            CommonTextMemoryEntity r24 = (CommonTextMemoryEntity) ZeusTransformUtils.preCheckCast(r23, CommonTextMemoryEntity.class, "com.obric.memorydata.plugin");
        L97:
            if (r24 == null) goto L122;
            Ref.BooleanRef r110 = this.g;
            String r111 = this.h;
            n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r112 = this.i;
            o r113 = this.c;
            com.obric.memorydata.middleware.api.logging.e r114 = this.d;
            Map<String, Object> r115 = this.j;
            Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r25 = this.f;
            al r27 = this.f10269a;
            r110.element = true;
            k.f10296a.a(r111, (MemoryEntity) ZeusTransformUtils.preCheckCast(r24, MemoryEntity.class, "com.obric.memorydata.plugin"));
            k.a(k.f10296a, r111, "", null, 4, null);
            if (r112.a() == false) goto L123;
            o.a(r113, "记忆构建在快照阶段返回", "snapshot_returned", r114, (Function1) ZeusTransformUtils.preCheckCast(new C0505a(r27), Function1.class, "com.obric.memorydata.plugin"), null, 16, null);
            r115.put("resultType", r21.c().getValue());
            String r28 = r26.optString("logId");
            Intrinsics.checkNotNull(r28);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r28, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L103;
            boolean r29 = true;
        L104:
            if (r29 == true) goto L107;
            r28 = null;
        L107:
            if (r28 == null) goto L109;
            r115.put("logId", r28);
        L109:
            r112.a(TuplesKt.to(r25.element, r115), null);
            return;
        L103:
            r29 = false;
            goto L104
        L123:
            return;
        L122:
            return;
        L96:
            r24 = null;
            goto L97
        L121:
            return;
        L90:
            r22 = null;
            goto L92
        L87:
            r21 = null;
            goto L88
        L22:
            if (r10 != 3) goto L24;
            String r30 = r26.optString("delta");
            o r31 = this.c;
            com.obric.memorydata.middleware.api.logging.e r32 = this.d;
            if (AppContext.INSTANCE.isDebug() == false) goto L73;
            com.obric.memorydata.middleware.api.logging.g r33 = new com.obric.memorydata.middleware.api.logging.g();
            r33.a("delta", r30);
            Unit r34 = Unit.INSTANCE;
            r31.a("记忆构建内容增量已返回", r32, r33.a());
        L73:
            if (this.g.element == false) goto L119;
            k r35 = k.f10296a;
            String r36 = this.h;
            Intrinsics.checkNotNull(r30);
            k.a(r35, r36, r30, null, 4, null);
            return;
        L119:
            return;
        L24:
            if (r10 != 4) goto L124;
            com.obric.memorydata.memory.tracker.g.b r37 = this.e;
            if (r37 == null) goto L29;
            r37.a();
        L29:
            k.f10296a.b(this.h);
            List r38 = MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, r26);
            boolean r39 = !((Collection) ZeusTransformUtils.preCheckCast(r38, Collection.class, "com.obric.memorydata.plugin")).isEmpty();
            ?? r40 = r38;
            if (r39 == true) goto L33;
            r40 = 0;
        L33:
            if (r40 == 0) goto L35;
            i r41 = this.k;
            Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r116 = this.f;
            r41.a(r40);
            r116.element = r40;
        L35:
            o r117 = this.c;
            com.obric.memorydata.middleware.api.logging.e r118 = this.d;
            final Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r42 = this.f;
            o.a(r117, "记忆构建完整阶段完成", "complete_ready", r118, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r42), Function1.class, "com.obric.memorydata.plugin"), null, 16, null);
            List r43 = (List) ZeusTransformUtils.preCheckCast(this.f.element, List.class, "com.obric.memorydata.plugin");
            if (this.i.a() == false) goto L117;
            o r119 = this.c;
            com.obric.memorydata.middleware.api.logging.e r120 = this.d;
            final al r121 = this.f10269a;
            final long r122 = this.l;
            o.a(r119, "记忆构建在完整阶段返回", "complete_returned", r120, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r121, r122), Function1.class, "com.obric.memorydata.plugin"), null, 16, null);
            Map<String, Object> r44 = this.j;
            if (r43 == null) goto L55;
            Iterable r123 = (Iterable) ZeusTransformUtils.preCheckCast(r43, Iterable.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r123, Collection.class) == true) goto L42;
        L44:
            Iterator r124 = r123.iterator();
        L46:
            if (r124.hasNext() == false) goto L43;
            if (((MemoryLLMBuildHelperV2.a) ZeusTransformUtils.preCheckCast(r124.next(), MemoryLLMBuildHelperV2.a.class, "com.obric.memorydata.plugin")).c() != MemoryLLMBuildHelperV2.ResultOperateType.UPDATE) goto L50;
            boolean r125 = true;
        L51:
            if (r125 == false) goto L46;
            boolean r126 = true;
        L53:
            if (r126 != true) goto L55;
            boolean r127 = true;
        L56:
            if (r127 == false) goto L58;
            String r128 = BuildConfig.CHANNEL;
        L59:
            r44.put("resultType", r128);
            String r45 = r26.optString("logId");
            Intrinsics.checkNotNull(r45);
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r45, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L62;
            boolean r46 = true;
        L63:
            if (r46 == true) goto L66;
            r45 = null;
        L66:
            if (r45 == null) goto L68;
            this.j.put("logId", r45);
        L68:
            this.i.a(TuplesKt.to(r43, this.j), null);
            return;
        L62:
            r46 = false;
            goto L63
        L58:
            r128 = "insert";
            goto L59
        L50:
            r125 = false;
        L43:
            r126 = false;
            goto L53
        L42:
            if (((Collection) ZeusTransformUtils.preCheckCast(r123, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == false) goto L44;
        L55:
            r127 = false;
            goto L56
        L117:
            return;
        L124:
            return;
        L8:
            if (r2.b() != true) goto L10;
            r3 = true;
            goto L11
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(JSONObject r3) {
            a((JSONObject) ZeusTransformUtils.preCheckCast(r3, JSONObject.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    static final class b implements Function1<AbsTaskRequest, Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f10276a;

        b(c r1) {
            this.f10276a = r1;
        }

        public final void a(AbsTaskRequest r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            c r1 = this.f10276a;
            if (r1 == null) goto L6;
            r1.a(r2);
            return;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* synthetic */ Unit invoke(AbsTaskRequest r3) {
            a((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r3, AbsTaskRequest.class, "com.obric.memorydata.plugin"));
            return Unit.INSTANCE;
        }
    }

    MemoryLLMBuildHelperV2$execute$2$taskJob$1(e r7, String r8, com.obric.memorydata.middleware.api.logging.e r9, o r10, Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r11, Map<String, Object> r12, boolean r13, i r14, Ref.BooleanRef r15, com.obric.memorydata.memory.tracker.g.b r16, n<? super Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r17, c r18, long r19, Continuation<? super MemoryLLMBuildHelperV2$execute$2$taskJob$1> r21) {
        Map<String, Object> r1 = (Map) ZeusTransformUtils.wrapperContextForParams(r12, Map.class, "com.obric.memorydata.plugin");
        n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r3 = (n) ZeusTransformUtils.wrapperContextForParams(r17, n.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r21, Continuation.class, "com.obric.memorydata.plugin");
        this.$inputData = r7;
        this.$sessionId = r8;
        this.$logContext = r9;
        this.$logger = r10;
        this.$resultEntities = r11;
        this.$extraMap = r1;
        this.$eval = r13;
        this.$rejectedMemoryCleanup = r14;
        this.$hasStreamSession = r15;
        this.$trackingEvent = r16;
        this.$continuation = r3;
        this.$buildControl = r18;
        this.$taskStartMs = r19;
        super(2, r2);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r22, Continuation<?> r23) {
        Continuation r18 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r23, Continuation.class, "com.obric.memorydata.plugin");
        MemoryLLMBuildHelperV2$execute$2$taskJob$1 r1 = new MemoryLLMBuildHelperV2$execute$2$taskJob$1(this.$inputData, this.$sessionId, this.$logContext, this.$logger, this.$resultEntities, this.$extraMap, this.$eval, this.$rejectedMemoryCleanup, this.$hasStreamSession, this.$trackingEvent, this.$continuation, this.$buildControl, this.$taskStartMs, r18);
        r1.L$0 = r22;
        return (Continuation) ZeusTransformUtils.preCheckCast(r1, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryLLMBuildHelperV2$execute$2$taskJob$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryLLMBuildHelperV2$execute$2$taskJob$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v13 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r13v9, types: [T] */
    /* JADX WARN: Type inference failed for: r3v0, types: [int] */
    /* JADX WARN: Type inference failed for: r3v1 */
    /* JADX WARN: Type inference failed for: r3v2, types: [kotlinx.coroutines.al] */
    /* JADX WARN: Type inference failed for: r3v42 */
    /* JADX WARN: Type inference failed for: r3v54 */
    /* JADX WARN: Type inference failed for: r3v55 */
    /* JADX WARN: Type inference failed for: r3v56 */
    /* JADX WARN: Type inference failed for: r3v57 */
    /* JADX WARN: Type inference failed for: r3v58 */
    /* JADX WARN: Type inference failed for: r3v59 */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r52) {
        String r0 = "logId";
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r3 = this.label;
        if (r3 != 0) goto L5;
        ResultKt.throwOnFailure(r52);
        al r4 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.union.build.e r7 = com.obric.memorydata.union.build.e.f13072a;     // Catch: Throwable -> L209
        String r35 = "continuation_active";
        String r36 = "task_active";
        String r37 = "cost_ms";
        String r5 = MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, this.$inputData, this.$sessionId).toString();     // Catch: Throwable -> L202
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");     // Catch: Throwable -> L202
        String r40 = "enable_stream";
        String r41 = "session_id";
        String r6 = "com.obric.memorydata.plugin";
        Function1 r26 = (Function1) ZeusTransformUtils.preCheckCast(new a(r4, this.$buildControl, this.$logger, this.$logContext, this.$trackingEvent, this.$resultEntities, this.$hasStreamSession, this.$sessionId, this.$continuation, this.$extraMap, this.$rejectedMemoryCleanup, this.$taskStartMs), Function1.class, r6);     // Catch: Throwable -> L198
        Function1 r28 = (Function1) ZeusTransformUtils.preCheckCast(new b(this.$buildControl), Function1.class, r6);     // Catch: Throwable -> L198
        com.obric.memorydata.middleware.api.logging.e r29 = com.obric.memorydata.middleware.api.logging.e.a(this.$logContext, null, null, "execute", 3, null);     // Catch: Throwable -> L198
        Continuation r30 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r6);     // Catch: Throwable -> L198
        this.L$0 = r4;     // Catch: Throwable -> L198
        this.label = 1;     // Catch: Throwable -> L198
        Object r1 = com.obric.memorydata.union.build.e.a(r7, r5, "proactive", 30000, r26, null, r28, r29, r30, 16, null);     // Catch: Throwable -> L198
        Object r8 = r2;
        al r9 = r4;
        if (r1 != r8) goto L37;
        return r8;
    L37:
        final TaskResult r10 = (TaskResult) ZeusTransformUtils.preCheckCast(r1, TaskResult.class, r6);     // Catch: Throwable -> L198
        this.$logger.a("记忆构建任务结果", "task_result_received", this.$logContext, (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r10), Function1.class, r6), (Function1) ZeusTransformUtils.preCheckCast(new AnonymousClass2(r10), Function1.class, r6));     // Catch: Throwable -> L198
        am.b(r9);     // Catch: Throwable -> L198
        int r11 = r10.getCode();     // Catch: Throwable -> L198
        if (r11 != 0) goto L40;
        String r12 = r13;
        String r13 = r12;
        JSONObject r14 = r10.getOutput().optJSONObject("result");     // Catch: Throwable -> L198
        if (r14 == null) goto L76;
        String r15 = r14.optString("status");     // Catch: Throwable -> L198
    L77:
        if (r15 != null) goto L79;
        r15 = r15;
    L79:
        String r16 = "answer";
        if (r14 == null) goto L82;
        String r17 = r14.optString(r16);     // Catch: Throwable -> L198
    L83:
        if (r17 != null) goto L86;
        r17 = r15;
    L86:
        if (Intrinsics.areEqual(r15, "call_user") == false) goto L113;
        if (r14 == null) goto L89;
        String r18 = r14.optString("purpose");     // Catch: Throwable -> L198
    L90:
        if (r18 != null) goto L92;
        r18 = r15;
    L92:
        if (r14 == null) goto L94;
        String r19 = r14.optString(Params.CONTENT);     // Catch: Throwable -> L198
    L95:
        if (r19 != null) goto L97;
        r19 = r15;
    L97:
        this.$resultEntities.element = null;     // Catch: Throwable -> L198
        if (r14 == null) goto L106;
        Ref.ObjectRef<List<MemoryLLMBuildHelperV2.a>> r110 = this.$resultEntities;     // Catch: Throwable -> L198
        List r111 = MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, r14);     // Catch: Throwable -> L198
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r111, Collection.class, r6)).isEmpty()) == false) goto L102;
        ?? r112 = r111;
    L103:
        if (r112 == 0) goto L106;
        r110.element = r112;     // Catch: Throwable -> L198
        goto L106
    L102:
        r112 = 0;
    L106:
        this.$extraMap.put(r16, r19);     // Catch: Throwable -> L198
        if (this.$eval == false) goto L112;
        if (r14 == null) goto L112;
        if (Intrinsics.areEqual(r18, "delete_confirm") == false) goto L112;
        this.$extraMap.put("deleteRawJson", r14);     // Catch: Throwable -> L198
    L112:
        this.$extraMap.put("resultSubType", r18);     // Catch: Throwable -> L198
        Object r20 = "illegal";
    L125:
        TaskResult r21 = r10;
        al r22 = r9;
    L127:
        if (this.$hasStreamSession.element == true) goto L129;
    L131:
        k.f10296a.c(this.$sessionId);     // Catch: Throwable -> L198
        this.$extraMap.put("resultType", r15);     // Catch: Throwable -> L198
        Object r23 = this.$extraMap.get(r16);     // Catch: Throwable -> L198
        if (ZeusTransformUtils.instanceOf(r23, String.class) == false) goto L134;
        String r24 = (String) ZeusTransformUtils.preCheckCast(r23, String.class, r6);     // Catch: Throwable -> L198
    L135:
        CharSequence r25 = (CharSequence) ZeusTransformUtils.preCheckCast(r24, CharSequence.class, r6);     // Catch: Throwable -> L198
        if (r25 != null) goto L138;
    L141:
        boolean r27 = true;
    L142:
        if (r27 == false) goto L144;
        this.$extraMap.put(r16, r17);     // Catch: Throwable -> L198
    L144:
        int r31 = 0;
        this.$extraMap.put(r13, Boxing.boxInt(0));     // Catch: Throwable -> L198
        String r32 = r43;
        this.$extraMap.put(r12, r32);     // Catch: Throwable -> L198
        TaskResult r113 = r21;
        r4 = r22;
    L145:
        JSONObject r33 = r113.getOutput().optJSONObject("metrics");     // Catch: Throwable -> L198
        String r34 = r0;
        String r38 = r113.getOutput().optString(r34);     // Catch: Throwable -> L198
        Intrinsics.checkNotNull(r38);     // Catch: Throwable -> L198
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r38, CharSequence.class, r6)).length() <= 0) goto L148;
        int r114 = 1;
    L149:
        if (r114 == 0) goto L151;
        this.$extraMap.put(r34, r38);     // Catch: Throwable -> L198
    L151:
        MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, this.$logger, this.$logContext, r113, (List) ZeusTransformUtils.preCheckCast(this.$resultEntities.element, List.class, r6), this.$extraMap);     // Catch: Throwable -> L198
        com.obric.memorydata.memory.tracker.g.b r39 = this.$trackingEvent;     // Catch: Throwable -> L198
        if (r39 == null) goto L167;
        Object r42 = this.$extraMap.get(r13);     // Catch: Throwable -> L198
        if (ZeusTransformUtils.instanceOf(r42, Integer.class) == false) goto L156;
        Integer r43 = (Integer) ZeusTransformUtils.preCheckCast(r42, Integer.class, r6);     // Catch: Throwable -> L198
    L157:
        if (r43 == null) goto L159;
        int r115 = r43.intValue();     // Catch: Throwable -> L198
    L160:
        Object r44 = this.$extraMap.get(r12);     // Catch: Throwable -> L198
        if (ZeusTransformUtils.instanceOf(r44, String.class) == false) goto L163;
        String r45 = (String) ZeusTransformUtils.preCheckCast(r44, String.class, r6);     // Catch: Throwable -> L198
    L164:
        if (r45 != null) goto L166;
        r45 = r32;
    L166:
        r39.a(r115, r45, r33);     // Catch: Throwable -> L198
        goto L167
    L163:
        r45 = null;
        goto L164
    L159:
        r115 = r31;
        goto L160
    L156:
        r43 = null;
    L167:
        if (this.$continuation.a() == true) goto L236;
        String r46 = r37;
        String r47 = r40;
        String r116 = r41;
    L190:
        o r48 = this.$logger;
        com.obric.memorydata.middleware.api.logging.e r49 = this.$logContext;
        String r50 = this.$sessionId;
        e r51 = this.$inputData;
        n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r53 = this.$continuation;
        long r117 = this.$taskStartMs;
        if (AppContext.INSTANCE.isDebug() == false) goto L193;
        com.obric.memorydata.middleware.api.logging.g r54 = new com.obric.memorydata.middleware.api.logging.g();
        r54.a(r116, r50);
        r54.a(r47, Boxing.boxBoolean(r51.n()));
        r54.a(r36, Boxing.boxBoolean(am.a(r4)));
        r54.a(r35, Boxing.boxBoolean(r53.a()));
        r54.a(r46, Boxing.boxLong(SystemClock.elapsedRealtime() - r117));
        Unit r55 = Unit.INSTANCE;
        r48.a("记忆构建任务已清理", r49, r54.a());
    L193:
        g.f10287a.b(this.$sessionId);
        c r56 = this.$buildControl;
        if (r56 == null) goto L197;
        r56.e();
    L197:
        return Unit.INSTANCE;
    L236:
        o r57 = this.$logger;     // Catch: Throwable -> L187
        com.obric.memorydata.middleware.api.logging.e r58 = this.$logContext;     // Catch: Throwable -> L187
        String r59 = this.$sessionId;     // Catch: Throwable -> L187
        e r60 = this.$inputData;     // Catch: Throwable -> L187
        long r61 = this.$taskStartMs;     // Catch: Throwable -> L187
        if (AppContext.INSTANCE.isDebug() == false) goto L182;
        com.obric.memorydata.middleware.api.logging.g r62 = new com.obric.memorydata.middleware.api.logging.g();     // Catch: Throwable -> L187
        r116 = r41;
        r62.a(r116, r59);     // Catch: Throwable -> L180
        Boolean r63 = Boxing.boxBoolean(r60.n());     // Catch: Throwable -> L180
        r47 = r40;
        r62.a(r47, r63);     // Catch: Throwable -> L178
        Long r64 = Boxing.boxLong(SystemClock.elapsedRealtime() - r61);     // Catch: Throwable -> L178
        r46 = r37;
        r62.a(r46, r64);     // Catch: Throwable -> L185
        Unit r65 = Unit.INSTANCE;     // Catch: Throwable -> L185
        r57.a("记忆构建任务已返回调用方", r58, r62.a());     // Catch: Throwable -> L185
    L183:
        this.$continuation.a(TuplesKt.to(this.$resultEntities.element, this.$extraMap), null);     // Catch: Throwable -> L185
    L185:
        th = th;
    L206:
        String r66 = r35;
        String r67 = r36;
        ?? r68 = r4;
    L211:
        o r69 = this.$logger;
        com.obric.memorydata.middleware.api.logging.e r70 = this.$logContext;
        String r118 = this.$sessionId;
        e r119 = this.$inputData;
        n<Pair<? extends List<MemoryLLMBuildHelperV2.a>, ? extends Map<String, ? extends Object>>> r120 = this.$continuation;
        long r121 = this.$taskStartMs;
        Throwable r510 = th;
        if (AppContext.INSTANCE.isDebug() == false) goto L214;
        com.obric.memorydata.middleware.api.logging.g r71 = new com.obric.memorydata.middleware.api.logging.g();
        r71.a(r116, r118);
        r71.a(r47, Boxing.boxBoolean(r119.n()));
        r71.a(r67, Boxing.boxBoolean(am.a(r68)));
        r71.a(r66, Boxing.boxBoolean(r120.a()));
        r71.a(r46, Boxing.boxLong(SystemClock.elapsedRealtime() - r121));
        Unit r72 = Unit.INSTANCE;
        r69.a("记忆构建任务已清理", r70, r71.a());
    L214:
        g.f10287a.b(this.$sessionId);
        c r73 = this.$buildControl;
        if (r73 == null) goto L241;
        r73.e();
        throw r510;
    L241:
        throw r510;
    L178:
        th = th;
        r46 = r37;
    L180:
        th = th;
        r46 = r37;
        r47 = r40;
        goto L206
    L182:
        r46 = r37;
        r47 = r40;
        r116 = r41;
    L187:
        th = th;
        r46 = r37;
        r47 = r40;
        r116 = r41;
        goto L206
    L148:
        r114 = r31;
        goto L149
    L138:
        if (r25.length() == 0) goto L141;
        r27 = false;
        goto L142
    L134:
        r24 = null;
        goto L135
    L129:
        if (Intrinsics.areEqual(r15, r20) == true) goto L131;
        k.f10296a.b(this.$sessionId);     // Catch: Throwable -> L198
        goto L131
    L94:
        r19 = null;
        goto L95
    L89:
        r18 = null;
        goto L90
    L113:
        r20 = r4;
        if (Intrinsics.areEqual(r15, r20) == false) goto L124;
        k.f10296a.a(this.$sessionId, SessionStatus.ILLEGAL, r17);     // Catch: Throwable -> L198
        MemoryLLMBuildHelperV2 r122 = MemoryLLMBuildHelperV2.f10255a;     // Catch: Throwable -> L198
        i r123 = this.$rejectedMemoryCleanup;     // Catch: Throwable -> L198
        o r124 = this.$logger;     // Catch: Throwable -> L198
        com.obric.memorydata.middleware.api.logging.e r125 = this.$logContext;     // Catch: Throwable -> L198
        Continuation r126 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r6);     // Catch: Throwable -> L198
        this.L$0 = r9;     // Catch: Throwable -> L198
        this.L$1 = r10;     // Catch: Throwable -> L198
        this.L$2 = r15;     // Catch: Throwable -> L198
        this.L$3 = r17;     // Catch: Throwable -> L198
        this.label = 2;     // Catch: Throwable -> L198
        if (MemoryLLMBuildHelperV2.a(r122, r123, r124, r125, r126) != r8) goto L118;
        return r8;
    L118:
        TaskResult r127 = r10;
        al r74 = r9;
        String r75 = r15;
        String r128 = r17;
    L228:
        this.$resultEntities.element = null;     // Catch: Throwable -> L121
        r15 = r75;
        r22 = r74;
        r17 = r128;
        r21 = r127;
    L121:
        th = th;
        r4 = r74;
    L199:
        r66 = r35;
        r67 = r36;
        r46 = r37;
        r47 = r40;
        r116 = r41;
        r68 = r4;
        goto L211
    L124:
        Boxing.boxBoolean(com.obric.memorydata.memory.b.a.f10078a.a((List) ZeusTransformUtils.preCheckCast(this.$resultEntities.element, List.class, r6)));     // Catch: Throwable -> L198
        goto L125
    L82:
        r17 = null;
        goto L83
    L76:
        r15 = null;
        goto L77
    L40:
        if (r11 == 3) goto L66;
        r13 = "errorCode";
        this.$extraMap.put(r13, Boxing.boxInt(r10.getOutput().optInt("realErrorCode", -1000)));     // Catch: Throwable -> L198
        Map<String, Object> r76 = this.$extraMap;     // Catch: Throwable -> L198
        JSONObject r77 = r10.getOutput();     // Catch: Throwable -> L198
        CharSequence r129 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getMsg(), CharSequence.class, r6);     // Catch: Throwable -> L198
        if (r129.length() != 0) goto L44;
        boolean r130 = true;
    L45:
        if (r130 == false) goto L47;
        r129 = "task fail but no error msg";
    L47:
        String r78 = r77.optString("realErrorMsg", (String) ZeusTransformUtils.preCheckCast(r129, String.class, r6));     // Catch: Throwable -> L198
        r12 = DTraitConstant.ERROR;
        r76.put(r12, r78);     // Catch: Throwable -> L198
        MemoryLLMBuildHelperV2.a(MemoryLLMBuildHelperV2.f10255a, r10.getOutput(), this.$extraMap);     // Catch: Throwable -> L198
        Object r79 = this.$extraMap.get("resultStrMemory");     // Catch: Throwable -> L198
        if (ZeusTransformUtils.instanceOf(r79, String.class) == false) goto L50;
        String r80 = (String) ZeusTransformUtils.preCheckCast(r79, String.class, r6);     // Catch: Throwable -> L198
    L51:
        if (r80 != null) goto L54;
        r80 = "";
    L54:
        if (Intrinsics.areEqual(this.$extraMap.get(r13), Boxing.boxInt(-7)) == false) goto L56;
    L61:
        k.f10296a.a(this.$sessionId, SessionStatus.ILLEGAL, r80);     // Catch: Throwable -> L198
        MemoryLLMBuildHelperV2 r81 = MemoryLLMBuildHelperV2.f10255a;     // Catch: Throwable -> L198
        i r82 = this.$rejectedMemoryCleanup;     // Catch: Throwable -> L198
        o r83 = this.$logger;     // Catch: Throwable -> L198
        com.obric.memorydata.middleware.api.logging.e r131 = this.$logContext;     // Catch: Throwable -> L198
        Continuation r132 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, r6);     // Catch: Throwable -> L198
        this.L$0 = r9;     // Catch: Throwable -> L198
        this.L$1 = r10;     // Catch: Throwable -> L198
        this.label = 3;     // Catch: Throwable -> L198
        al r84 = r9;
        if (MemoryLLMBuildHelperV2.a(r81, r82, r83, r131, r132) != r8) goto L64;
        return r8;
    L64:
        this.$resultEntities.element = null;     // Catch: Throwable -> L198
        al r85 = r84;
    L65:
        r113 = r10;
        r32 = r43;
        r31 = 0;
        r4 = r85;
        goto L145
    L56:
        if (Intrinsics.areEqual(this.$extraMap.get(r13), Boxing.boxInt(NetError.ERR_CONNECTION_ABORTED)) == true) goto L61;
        if (Intrinsics.areEqual(this.$extraMap.get(r13), Boxing.boxInt(NetError.ERR_INTERNET_DISCONNECTED)) == true) goto L61;
        k.f10296a.a(this.$sessionId, SessionStatus.FAILED, r80);     // Catch: Throwable -> L198
        r85 = r9;
        goto L65
    L50:
        r80 = null;
        goto L51
    L44:
        r130 = false;
        goto L45
    L66:
        r12 = r13;
        r13 = r12;
        this.$extraMap.put(r13, Boxing.boxInt(NetError.ERR_CERT_DATE_INVALID));     // Catch: Throwable -> L198
        Map<String, Object> r86 = this.$extraMap;     // Catch: Throwable -> L198
        CharSequence r87 = (CharSequence) ZeusTransformUtils.preCheckCast(r10.getMsg(), CharSequence.class, r6);     // Catch: Throwable -> L198
        if (r87.length() != 0) goto L69;
        boolean r88 = true;
    L70:
        if (r88 == false) goto L72;
        r87 = "task execution timed out";
    L72:
        r86.put(r12, r87);     // Catch: Throwable -> L198
        String r89 = at.a(ZeusTransformUtils.mapRes(R.string.memory_card_memory_large_model_failed_title, TypedValues.Custom.S_STRING, "memory_card_memory_large_model_failed_title"));     // Catch: Throwable -> L198
        this.$extraMap.put("resultStrMemory", r89);     // Catch: Throwable -> L198
        k.f10296a.a(this.$sessionId, SessionStatus.FAILED, r89);     // Catch: Throwable -> L198
        r85 = r9;
        goto L65
    L69:
        r88 = false;
    L198:
        th = th;
    L200:
        th = th;
        r116 = "session_id";
        r66 = r35;
        r67 = r36;
        r46 = r37;
        r47 = r40;
        r68 = r4;
    L202:
        th = th;
        r47 = "enable_stream";
        r116 = "session_id";
        r66 = r35;
        r67 = r36;
        r46 = r37;
        r68 = r4;
    L204:
        th = th;
        r46 = "cost_ms";
        r47 = "enable_stream";
        r116 = "session_id";
    L207:
        th = th;
        r67 = "task_active";
        r46 = "cost_ms";
        r47 = "enable_stream";
        r116 = "session_id";
        r66 = r35;
        r68 = r4;
        goto L211
    L5:
        if (r3 != 1) goto L7;
        al r90 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r52);     // Catch: Throwable -> L209
        r35 = "continuation_active";
        r36 = "task_active";
        r37 = "cost_ms";
        r40 = "enable_stream";
        r41 = "session_id";
        r1 = r52;
        r8 = r2;
        r6 = "com.obric.memorydata.plugin";
        r9 = r90;
        goto L37
    L7:
        if (r3 != 2) goto L9;
        String r91 = (String) ZeusTransformUtils.preCheckCast(this.L$3, String.class, "com.obric.memorydata.plugin");
        r75 = (String) ZeusTransformUtils.preCheckCast(this.L$2, String.class, "com.obric.memorydata.plugin");
        r128 = r91;
        r127 = (TaskResult) ZeusTransformUtils.preCheckCast(this.L$1, TaskResult.class, "com.obric.memorydata.plugin");
        al r92 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r52);     // Catch: Throwable -> L18
        r0 = "logId";
        r35 = "continuation_active";
        r36 = "task_active";
        r37 = "cost_ms";
        r40 = "enable_stream";
        r41 = "session_id";
        r12 = DTraitConstant.ERROR;
        r16 = "answer";
        String r410 = "";
        r20 = "illegal";
        r74 = r92;
        r6 = "com.obric.memorydata.plugin";
        r13 = "errorCode";
    L18:
        th = th;
        r3 = r92;
    L210:
        r66 = "continuation_active";
        r67 = "task_active";
        r46 = "cost_ms";
        r47 = "enable_stream";
        r116 = "session_id";
        r68 = r3;
        goto L211
    L9:
        if (r3 != 3) goto L14;
        TaskResult r93 = (TaskResult) ZeusTransformUtils.preCheckCast(this.L$1, TaskResult.class, "com.obric.memorydata.plugin");
        al r94 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r52);     // Catch: Throwable -> L209
        r0 = "logId";
        r10 = r93;
        r35 = "continuation_active";
        r36 = "task_active";
        r6 = "com.obric.memorydata.plugin";
        r37 = "cost_ms";
        r40 = "enable_stream";
        r41 = "session_id";
        r13 = "errorCode";
        r12 = DTraitConstant.ERROR;
        r410 = "";
        r84 = r94;
        goto L64
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L209:
        th = th;
        goto L210
    }
}
