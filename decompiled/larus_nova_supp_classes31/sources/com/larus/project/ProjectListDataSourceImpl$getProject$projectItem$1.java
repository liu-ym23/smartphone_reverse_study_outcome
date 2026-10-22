package com.larus.project;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.im.internal.jni.bean.OmniProjectStatus;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/taskskill/service/ProjectListItem;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl$getProject$projectItem$1", f = "ProjectListDataSourceImpl.kt", i = {0, 1}, l = {596, 131}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0"})
public final class ProjectListDataSourceImpl$getProject$projectItem$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.taskskill.service.h>, Object> {
    final /* synthetic */ String $projectId;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$getProject$projectItem$1(ProjectListDataSourceImpl r1, String r2, Continuation<? super ProjectListDataSourceImpl$getProject$projectItem$1> r3) {
        this.this$0 = r1;
        this.$projectId = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProjectListDataSourceImpl$getProject$projectItem$1(this.this$0, this.$projectId, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.taskskill.service.h> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        boolean r3 = true;
        if (r1 == 0) goto L14;
        if (r1 == 1) goto L13;
        if (r1 != 2) goto L12;
        String r2 = (String) this.L$2;
        ProjectListDataSourceImpl r4 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L9
    L32:
        Iterator r11 = ((Iterable) r10).iterator();     // Catch: Throwable -> L9
    L34:
        if (r11.hasNext() == false) goto L38;
        Object r6 = r11.next();     // Catch: Throwable -> L9
        if (Intrinsics.areEqual(((OmniProject) r6).projectId, r2) == false) goto L34;
    L39:
        OmniProject r7 = (OmniProject) r6;     // Catch: Throwable -> L9
        if (r7 != null) goto L42;
    L51:
        kotlinx.coroutines.sync.a r8 = r5;
        com.larus.bmhome.taskskill.service.h r9 = null;
    L52:
        r8.unlock(null);
        return r9;
    L42:
        if (r7.status != OmniProjectStatus.OmniProjectStatus_DELETED) goto L45;
        r3 = false;
    L45:
        if (r3 == true) goto L48;
        r7 = null;
    L48:
        if (r7 == null) goto L51;
        r9 = new com.larus.bmhome.taskskill.service.h(r7);     // Catch: Throwable -> L9
        List r12 = CollectionsKt.toMutableList(r4.d.a);     // Catch: Throwable -> L9
        ProjectListDataSourceImpl.h(r4, r12, CollectionsKt.listOf(r9));     // Catch: Throwable -> L9
        ProjectListDataSourceImpl.m(r4, com.larus.bmhome.taskskill.service.i.a(r4.d, ProjectListDataSourceImpl.k(r4, r12)));     // Catch: Throwable -> L9
        r8 = r5;
        goto L52
    L38:
        r6 = null;
    L9:
        th = th;
        r8 = r5;
    L56:
        r8.unlock(null);
        throw th;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        String r13 = (String) this.L$2;
        ProjectListDataSourceImpl r14 = (ProjectListDataSourceImpl) this.L$1;
        r8 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r10);
        ProjectListDataSourceImpl r15 = r14;
    L60:
        ProjectListDataSourceImpl.g(r15);     // Catch: Throwable -> L55
        Iterator r16 = r15.d.a.iterator();     // Catch: Throwable -> L55
    L20:
        if (r16.hasNext() == false) goto L24;
        Object r17 = r16.next();     // Catch: Throwable -> L55
        if (Intrinsics.areEqual(((com.larus.bmhome.taskskill.service.h) r17).a.projectId, r13) == false) goto L20;
    L25:
        r9 = (com.larus.bmhome.taskskill.service.h) r17;     // Catch: Throwable -> L55
        if (r9 != null) goto L52;
        List r18 = CollectionsKt.listOf(r13);     // Catch: Throwable -> L55
        this.L$0 = r8;     // Catch: Throwable -> L55
        this.L$1 = r15;     // Catch: Throwable -> L55
        this.L$2 = r13;     // Catch: Throwable -> L55
        this.label = 2;     // Catch: Throwable -> L55
        Object r19 = ProjectListDataSourceImpl.j(r15, r18, this);     // Catch: Throwable -> L55
        if (r19 != r0) goto L31;
        return r0;
    L31:
        r2 = r13;
        r4 = r15;
        r10 = r19;
        r5 = r8;
        goto L32
    L24:
        r17 = null;
    L55:
        th = th;
        goto L56
    L14:
        ResultKt.throwOnFailure(r10);
        r15 = this.this$0;
        kotlinx.coroutines.sync.a r20 = r15.b;
        String r21 = this.$projectId;
        this.L$0 = r20;
        this.L$1 = r15;
        this.L$2 = r21;
        this.label = 1;
        if (r20.a(null, this) != r0) goto L17;
        return r0;
    L17:
        r8 = r20;
        r13 = r21;
        goto L60
    }
}
