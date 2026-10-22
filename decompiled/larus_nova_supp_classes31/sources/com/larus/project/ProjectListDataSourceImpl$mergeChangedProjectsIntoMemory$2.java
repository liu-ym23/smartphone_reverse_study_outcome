package com.larus.project;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.larus.platform.model.SlashMentionConfig;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2", f = "ProjectListDataSourceImpl.kt", i = {0}, l = {596}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ List<OmniProject> $changedProjects;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2(ProjectListDataSourceImpl r1, List<OmniProject> r2, Continuation<? super ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2> r3) {
        this.this$0 = r1;
        this.$changedProjects = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2(this.this$0, this.$changedProjects, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Boolean> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        List<OmniProject> r2 = (List) this.L$2;
        ProjectListDataSourceImpl r4 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r15);
    L91:
        ProjectListDataSourceImpl.g(r4);     // Catch: Throwable -> L88
        if (r4.d.c == false) goto L84;
        ArrayList r16 = new ArrayList();     // Catch: Throwable -> L88
        Iterator<T> r6 = r2.iterator();     // Catch: Throwable -> L88
    L17:
        if (r6.hasNext() == false) goto L29;
        Object r7 = r6.next();     // Catch: Throwable -> L88
        String r8 = ((OmniProject) r7).projectId;     // Catch: Throwable -> L88
        if (r8 != null) goto L21;
    L24:
        boolean r9 = true;
    L26:
        if ((!r9) == false) goto L17;
        r16.add(r7);     // Catch: Throwable -> L88
        goto L17
    L21:
        if (r8.length() == 0) goto L24;
        r9 = false;
        goto L26
    L29:
        if (r16.isEmpty() == true) goto L84;
        List r10 = CollectionsKt.toMutableList(r4.d.a);     // Catch: Throwable -> L88
        ArrayList r11 = new ArrayList();     // Catch: Throwable -> L88
        Iterator r12 = r16.iterator();     // Catch: Throwable -> L88
    L33:
        if (r12.hasNext() == false) goto L40;
        Object r13 = r12.next();     // Catch: Throwable -> L88
        if (((OmniProject) r13).status != OmniProjectStatus.OmniProjectStatus_DELETED) goto L37;
        boolean r14 = true;
    L38:
        if (r14 == false) goto L33;
        r11.add(r13);     // Catch: Throwable -> L88
        goto L33
    L37:
        r14 = false;
        goto L38
    L40:
        final LinkedHashSet r17 = new LinkedHashSet();     // Catch: Throwable -> L88
        Iterator r18 = r11.iterator();     // Catch: Throwable -> L88
    L42:
        String r19 = "";
        if (r18.hasNext() == false) goto L50;
        String r20 = ((OmniProject) r18.next()).projectId;     // Catch: Throwable -> L88
        if (r20 == null) goto L48;
        r19 = r20;
    L48:
        r17.add(r19);     // Catch: Throwable -> L88
        goto L42
    L50:
        if ((!r17.isEmpty()) == false) goto L52;
        CollectionsKt.removeAll(r10, new c(r17));     // Catch: Throwable -> L88
    L52:
        List r21 = r10;     // Catch: Throwable -> L88
        LinkedHashMap r110 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(r21, 10)), 16));     // Catch: Throwable -> L88
        Iterator r22 = r21.iterator();     // Catch: Throwable -> L88
    L54:
        if (r22.hasNext() == false) goto L59;
        Object r23 = r22.next();     // Catch: Throwable -> L88
        String r111 = ((com.larus.bmhome.taskskill.service.h) r23).a.projectId;     // Catch: Throwable -> L88
        if (r111 != null) goto L58;
        r111 = "";
    L58:
        r110.put(r111, r23);     // Catch: Throwable -> L88
        goto L54
    L59:
        ArrayList r24 = new ArrayList();     // Catch: Throwable -> L88
        Iterator r112 = r16.iterator();     // Catch: Throwable -> L88
    L61:
        if (r112.hasNext() == false) goto L68;
        Object r25 = r112.next();     // Catch: Throwable -> L88
        if (((OmniProject) r25).status == OmniProjectStatus.OmniProjectStatus_DELETED) goto L65;
        boolean r113 = true;
    L66:
        if (r113 == false) goto L61;
        r24.add(r25);     // Catch: Throwable -> L88
        goto L61
    L65:
        r113 = false;
        goto L66
    L68:
        ArrayList r114 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r24, 10));     // Catch: Throwable -> L88
        Iterator r26 = r24.iterator();     // Catch: Throwable -> L88
    L70:
        if (r26.hasNext() == false) goto L79;
        OmniProject r27 = (OmniProject) r26.next();     // Catch: Throwable -> L88
        String r28 = r27.projectId;     // Catch: Throwable -> L88
        if (r28 != null) goto L74;
        r28 = "";
    L74:
        com.larus.bmhome.taskskill.service.h r29 = (com.larus.bmhome.taskskill.service.h) r110.get(r28);     // Catch: Throwable -> L88
        if (r29 == null) goto L77;
        List r115 = r29.b;     // Catch: Throwable -> L88
        Map r116 = r29.c;     // Catch: Throwable -> L88
        boolean r30 = r29.d;     // Catch: Throwable -> L88
        Intrinsics.checkNotNullParameter(r27, SlashMentionConfig.SLASH_CONTENT_PROJECT);     // Catch: Throwable -> L88
        Intrinsics.checkNotNullParameter(r115, "firstPageConversations");     // Catch: Throwable -> L88
        Intrinsics.checkNotNullParameter(r116, "briefMessages");     // Catch: Throwable -> L88
        com.larus.bmhome.taskskill.service.h r117 = new com.larus.bmhome.taskskill.service.h(r27, r115, r116, r30);     // Catch: Throwable -> L88
    L78:
        r114.add(r117);     // Catch: Throwable -> L88
        goto L70
    L77:
        r117 = new com.larus.bmhome.taskskill.service.h(r27);     // Catch: Throwable -> L88
        goto L78
    L79:
        ProjectListDataSourceImpl.h(r4, r10, r114);     // Catch: Throwable -> L88
        com.larus.bmhome.taskskill.service.i r118 = com.larus.bmhome.taskskill.service.i.a(r4.d, ProjectListDataSourceImpl.k(r4, r10));     // Catch: Throwable -> L88
        ProjectListDataSourceImpl.m(r4, r118);     // Catch: Throwable -> L88
        if (r118.b == false) goto L84;
        if (r118.a.size() >= ProjectListDataSourceImpl.n(true, false)) goto L84;
    L85:
        Boolean r119 = Boxing.boxBoolean(r3);     // Catch: Throwable -> L88
        r5.unlock(null);
        return r119;
    L84:
        r3 = false;
    L88:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r15);
        r4 = this.this$0;
        r5 = r4.b;
        List<OmniProject> r120 = this.$changedProjects;
        this.L$0 = r5;
        this.L$1 = r4;
        this.L$2 = r120;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r2 = r120;
        goto L91
    }
}
