package com.obric.assistant.state.impl.multitask.producer;

import aha.g;
import aha.u;
import androidx.lifecycle.LiveData;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.api.IAuthModelService;
import com.larus.multitask_management.api.data.TaskStatus;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer;
import com.obric.assistant.state.multitask.ext.TaskFlowDslKt;
import com.obric.assistant.t1;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import jha.l;
import jha.m;
import kl9.p;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.ExecutorCoroutineDispatcher;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u00020\f2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0082@¢\u0006\u0002\u0010\u0011J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0013\u001a\u00020\u0010H\u0002J\u0014\u0010\u0014\u001a\u0004\u0018\u00010\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\u0006\u0010\u0019\u001a\u00020\bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/state/impl/multitask/producer/ObricAigcGenerationStateProducer;", "Lcom/obric/assistant/state/multitask/core/TaskFlowAutoInitProducer;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", "activeTasks", "Ljava/util/LinkedHashMap;", "", "Lcom/obric/assistant/state/impl/multitask/producer/ObricAigcGenerationStateProducer$ActiveTask;", "Lkotlin/collections/LinkedHashMap;", "initProducer", "", "handleTaskList", "tasks", "", "Lcom/larus/multitask_management/api/data/TaskBasicInfo;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "resolveConversationId", "taskInfo", "resolveConversationIdFromTarget", "target", "taskFlowId", "Lcom/obric/assistant/state/multitask/core/TaskFlowId;", "Lcom/obric/assistant/state/api/multitask/state/ObricAigcGenerationTaskState;", DBDefinition.TASK_ID, "Companion", "ActiveTask", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAigcGenerationStateProducer implements TaskFlowAutoInitProducer {
    public static final /* synthetic */ int c = 0;
    public final CoroutineScope a;
    public final LinkedHashMap<String, a> b;

    static {
    }

    @Override // com.obric.assistant.state.multitask.core.TaskFlowAutoInitProducer
    public final void f() {
        il9.a r0 = (il9.a) ServiceManager.get().getService(il9.a.class);
        if (r0 != null) goto L6;
        FLogger.a.e("ObricAigcGenerationStateProducer", "IMultiTaskManager is unavailable");
        return;
    L6:
        BuildersKt.launch$default(this.a, null, null, new ObricAigcGenerationStateProducer$initProducer$1(r0, this, null), 3, null);
    }

    public ObricAigcGenerationStateProducer() {
        ExecutorCoroutineDispatcher r0 = jha.f.a;
        Intrinsics.checkNotNullParameter("ObricAigcGenerationStateProducer", "orderingDomain");
        this.a = jha.f.b("ObricAigcGenerationStateProducer").b;
        this.b = new LinkedHashMap();
    }

    public static String b(String r6) {
        boolean r0 = true;
        if (r6 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        Object r3 = null;
        if (r2 == false) goto L34;
        return null;
    L34:
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L23
        String r5 = UriProtector.getQueryParameter(UriProtector.parse(r6), "target_cvs_id");     // Catch: Throwable -> L23
        if (r5 != null) goto L15;
    L20:
        r5 = null;
    L21:
        Object r1 = Result.constructor-impl(r5);     // Catch: Throwable -> L23
    L25:
        Throwable r7 = Result.exceptionOrNull-impl(r1);
        if (r7 == null) goto L29;
        FLogger.a.w("ObricAigcGenerationStateProducer", "parse task target failed, target=" + r6, r7);
    L29:
        if (Result.isFailure-impl(r1) == true) goto L33;
        r3 = r1;
    L33:
        return (String) r3;
    L15:
        if (r5.length() > 0) goto L18;
        r0 = false;
    L18:
        if (r0 == false) goto L20;
    L23:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L25
    L5:
        if (r6.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:117:0x0287 -> B:118:0x0288). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:129:0x0320 -> B:130:0x0322). Please report as a decompilation issue!!! */
    public static final Object a(ObricAigcGenerationStateProducer r16, List r17, Continuation r18) {
        ObricAigcGenerationStateProducer r0 = r16;
        r16.getClass();
        if ((r18 instanceof ObricAigcGenerationStateProducer$handleTaskList$1) == false) goto L7;
        ObricAigcGenerationStateProducer$handleTaskList$1 r2 = (ObricAigcGenerationStateProducer$handleTaskList$1) r18;
        int r3 = r2.label;
        if ((r3 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        int r6 = 1;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        String r7 = (String) r2.L$5;
        g.a r10 = (g.a) r2.L$4;
        u r11 = (u) r2.L$3;
        kl9.u r12 = (kl9.u) r2.L$2;
        String r13 = (String) r2.L$1;
        Iterator r14 = (Iterator) r2.L$0;
        ResultKt.throwOnFailure(r1);
    L118:
        m r8 = (m) r1;
        if (r8 == null) goto L130;
        r0.b.put(r13, new a(r8.a, r12, r7, r11));
        if (r8.b == true) goto L124;
        TaskFlowDslKt.f(r8.a, r10);
    L124:
        FLogger.a.i("ObricAigcGenerationStateProducer", "start taskId=" + r13 + ", taskKey=" + r12.t + ", conversationId=" + r7);
    L130:
        r6 = 1;
    L45:
        if (r14.hasNext() == false) goto L132;
        Map.Entry r9 = (Map.Entry) r14.next();
        r13 = (String) r9.getKey();
        r12 = (kl9.u) r9.getValue();
        a r15 = r0.b.get(r13);
        if (r15 == null) goto L50;
        String r19 = r15.c;
        if (r19 == null) goto L50;
    L106:
        if (r15 == null) goto L111;
        u r110 = r15.d;
        if (r110 == null) goto L111;
        r11 = r110;
    L112:
        r10 = new g.a(r12.t, r12, r19, r11);
        if (r15 != null) goto L126;
        String r20 = "multitask:" + r13;
        Intrinsics.checkNotNullParameter(r20, DBDefinition.TASK_ID);
        jha.g r21 = TaskFlowDslKt.b(aha.f.a, r20);
        jha.c r22 = jha.j.a.a(r0);
        r2.L$0 = r14;
        r2.L$1 = r13;
        r2.L$2 = r12;
        r2.L$3 = r11;
        r2.L$4 = r10;
        r2.L$5 = r19;
        r2.label = r6;
        r1 = TaskFlowDslKt.e(r21, r10, r22, r2);
        if (r1 == r4) goto L150;
        r7 = r19;
        goto L118
    L150:
        return r4;
    L126:
        if (Intrinsics.areEqual(r15.b, r12) == true) goto L130;
        LinkedHashMap<String, a> r23 = r0.b;
        l r24 = r15.a;
        String r111 = r15.c;
        u r112 = r15.d;
        ObricAigcGenerationStateProducer r113 = r0;
        Intrinsics.checkNotNullParameter(r24, "handle");
        Intrinsics.checkNotNullParameter(r12, "taskInfo");
        Intrinsics.checkNotNullParameter(r111, "conversationId");
        Intrinsics.checkNotNullParameter(r112, "taskMetadata");
        r23.put(r13, new a(r24, r12, r111, r112));
        TaskFlowDslKt.f(r15.a, r10);
        FLogger.a.i("ObricAigcGenerationStateProducer", "update taskId=" + r13 + ", taskKey=" + r12.t + ", conversationId=" + r19);
        r0 = r113;
    L111:
        r11 = m.d(r19, null, null, 14);
    L50:
        Map r25 = r12.s;
        if (r25 == null) goto L63;
        r19 = (String) r25.get("conversation_id");
        if (r19 == null) goto L63;
        if (r19.length() != 0) goto L57;
        int r114 = 1;
    L59:
        if ((r114 ^ r6) != 0) goto L62;
        r19 = null;
    L62:
        if (r19 == null) goto L63;
    L102:
        if (r19 != null) goto L104;
        FLogger.a.e("ObricAigcGenerationStateProducer", "ignore task without conversationId, taskId=" + r12.a);
    L104:
        if (r19 != null) goto L106;
        r0 = r0;
        goto L130
    L57:
        r114 = 0;
    L63:
        Map r26 = r12.q;
        if (r26 == null) goto L74;
        r19 = (String) r26.get("conversation_id");
        if (r19 == null) goto L74;
        if (r19.length() != 0) goto L70;
        int r115 = 1;
    L72:
        if ((r115 ^ r6) == 0) goto L74;
    L75:
        if (r19 != null) goto L102;
        p r27 = r12.k;
        if (r27 == null) goto L79;
        String r28 = r27.d;
    L80:
        r19 = b(r28);
        if (r19 != null) goto L102;
        List r29 = r12.j;
        if (r29 != null) goto L85;
        r29 = CollectionsKt.emptyList();
    L85:
        r19 = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(r29), new k(r0)));
        if (r19 != null) goto L102;
        IAuthModelService r30 = (IAuthModelService) ServiceManager.get().getService(IAuthModelService.class);
        if (r30 == null) goto L101;
        LiveData r31 = r30.y();
        if (r31 == null) goto L101;
        e r32 = (e) r31.getValue();
        if (r32 == null) goto L101;
        r19 = r32.a;
        if (r19 == null) goto L101;
        if (r19.length() <= 0) goto L98;
        boolean r116 = true;
    L99:
        if (r116 == false) goto L101;
    L98:
        r116 = false;
    L101:
        r19 = null;
        goto L102
    L79:
        r28 = null;
        goto L80
    L70:
        r115 = 0;
    L74:
        r19 = null;
        goto L75
    L132:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        final Set r33 = CollectionsKt.toSet(t1.a.getObricAigcGenerationStateConfig().getResolvedSupportedTaskKeys());
        Sequence r34 = SequencesKt.filter(CollectionsKt.asSequence(r17), new j(r33));
        LinkedHashMap r35 = new LinkedHashMap();
        Iterator r36 = r34.iterator();
    L16:
        if (r36.hasNext() == false) goto L18;
        Object r117 = r36.next();
        r35.put(((kl9.u) r117).a, r117);
        goto L16
    L18:
        LinkedHashMap r37 = new LinkedHashMap();
        Iterator r118 = r35.entrySet().iterator();
    L20:
        if (r118.hasNext() == false) goto L27;
        Map.Entry r119 = (Map.Entry) r118.next();
        if (((kl9.u) r119.getValue()).g != TaskStatus.RUNNING) goto L24;
        boolean r120 = true;
    L25:
        if (r120 == false) goto L20;
        r37.put(r119.getKey(), r119.getValue());
        goto L20
    L24:
        r120 = false;
        goto L25
    L27:
        Set<String> r121 = r0.b.keySet();
        ArrayList r122 = new ArrayList();
        Iterator<T> r123 = r121.iterator();
    L29:
        if (r123.hasNext() == false) goto L33;
        Object r124 = r123.next();
        if ((!r37.containsKey((String) r124)) == false) goto L29;
        r122.add(r124);
        goto L29
    L33:
        Iterator r125 = CollectionsKt.toList(r122).iterator();
    L35:
        if (r125.hasNext() == false) goto L43;
        String r126 = (String) r125.next();
        a r127 = r0.b.remove(r126);
        if (r127 == null) goto L35;
        kl9.u r128 = (kl9.u) r35.get(r126);
        if (r128 != null) goto L42;
        r128 = r127.b;
    L42:
        FLogger.a.i("ObricAigcGenerationStateProducer", "end taskId=" + r126 + ", taskKey=" + r128.t + ", conversationId=" + r127.c);
        TaskFlowDslKt.c(r127.a, new g.b(r128.t, r128, r127.c, r127.d));
        goto L35
    L43:
        r14 = r37.entrySet().iterator();
    L7:
        r2 = new ObricAigcGenerationStateProducer$handleTaskList$1(r0, r18);
        goto L8
    }
}
