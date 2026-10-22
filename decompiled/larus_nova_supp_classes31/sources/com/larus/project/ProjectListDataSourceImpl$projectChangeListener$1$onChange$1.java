package com.larus.project;

import com.larus.im.internal.jni.bean.OmniProject;
import com.larus.platform.service.z2;
import com.tencent.open.log.TraceLevel;
import java.util.List;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl$projectChangeListener$1$onChange$1", f = "ProjectListDataSourceImpl.kt", i = {}, l = {93, 97, 99}, m = "invokeSuspend", n = {}, s = {})
public final class ProjectListDataSourceImpl$projectChangeListener$1$onChange$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<OmniProject> $changedProjects;
    int label;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$projectChangeListener$1$onChange$1(ProjectListDataSourceImpl r1, List<OmniProject> r2, Continuation<? super ProjectListDataSourceImpl$projectChangeListener$1$onChange$1> r3) {
        this.this$0 = r1;
        this.$changedProjects = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new ProjectListDataSourceImpl$projectChangeListener$1$onChange$1(this.this$0, this.$changedProjects, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        ResultKt.throwOnFailure(r7);
        ((Result) r7).unbox-impl();
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r7);
    L24:
        if (((Boolean) r7).booleanValue() == false) goto L29;
        ProjectListDataSourceImpl r8 = this.this$0;
        this.label = 3;
        if (r8.d(this) != r0) goto L29;
        return r0;
    L11:
        ResultKt.throwOnFailure(r7);
        goto L29
    L12:
        ResultKt.throwOnFailure(r7);
        if (z2.a.b4().c != 1) goto L17;
        ProjectListDataSourceImpl r9 = this.this$0;
        this.label = 1;
        int r2 = ProjectListDataSourceImpl.j;
        if (r9.o(this) != r0) goto L29;
        return r0;
    L17:
        ProjectListDataSourceImpl r10 = this.this$0;
        List<OmniProject> r3 = this.$changedProjects;
        this.label = 2;
        int r4 = ProjectListDataSourceImpl.j;
        r10.getClass();
        if (r3.isEmpty() == false) goto L20;
        r7 = Boxing.boxBoolean(false);
    L21:
        if (r7 != r0) goto L24;
        return r0;
    L20:
        r7 = BuildersKt.withContext(Dispatchers.getMain().getImmediate(), new ProjectListDataSourceImpl$mergeChangedProjectsIntoMemory$2(r10, r3, null), this);
        goto L21
    }
}
