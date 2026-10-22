package com.larus.project;

import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.tencent.open.log.TraceLevel;
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
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/bmhome/taskskill/service/ProjectListSnapshot;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl$loadMore$snapshot$1", f = "ProjectListDataSourceImpl.kt", i = {0, 1, 1, 1, 1, 1, 1}, l = {596, 181}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "mergedItems", "queriedPages", "generation", "previousSize", "isFirstLoadMore"}, s = {"L$0", "L$0", "L$2", "L$3", "I$0", "I$1", "I$2"})
public final class ProjectListDataSourceImpl$loadMore$snapshot$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super com.larus.bmhome.taskskill.service.i>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$loadMore$snapshot$1(ProjectListDataSourceImpl r1, Continuation<? super ProjectListDataSourceImpl$loadMore$snapshot$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ProjectListDataSourceImpl$loadMore$snapshot$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super com.larus.bmhome.taskskill.service.i> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Not initialized variable reg: 15, insn: 0x018d: INVOKE (r15 I:kotlinx.coroutines.sync.a), (r1 I:java.lang.Object) INTERFACE call: kotlinx.coroutines.sync.a.unlock(java.lang.Object):void (LINE:16777613), block:B:52:0x018c */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ff -> B:35:0x0101). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        int r3 = this.I$2;
        int r10 = this.I$1;
        int r11 = this.I$0;
        Ref.IntRef r12 = (Ref.IntRef) this.L$3;
        List r13 = (List) this.L$2;
        ProjectListDataSourceImpl r14 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r15 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L51
        Object r6 = r18;
        ProjectListDataSourceImpl$loadMore$snapshot$1 r4 = this;
    L35:
        h r7 = (h) r6;     // Catch: Throwable -> L51
        r12.element++;     // Catch: Throwable -> L51
        if (r3 == 0) goto L38;
        r14.i = true;     // Catch: Throwable -> L51
    L38:
        ProjectListDataSourceImpl.h(r14, r13, ProjectListDataSourceImpl.l(r14, r7));     // Catch: Throwable -> L51
        r14.f = r7.e;     // Catch: Throwable -> L51
        boolean r5 = r7.f;     // Catch: Throwable -> L51
        if (r13.size() != r10) goto L43;
        if (r5 == false) goto L43;
        List r8 = r13;
        boolean r16 = false;
    L22:
        if (r16 == false) goto L24;
    L26:
        int r9 = 0;
    L27:
        int r17 = r14.f;     // Catch: Throwable -> L51
        if (r9 == 0) goto L30;
        boolean r19 = true;
    L31:
        int r20 = ProjectListDataSourceImpl.n(r16, r19);     // Catch: Throwable -> L51
        OmniConversationSortType r110 = r14.g;     // Catch: Throwable -> L51
        r4.L$0 = r15;     // Catch: Throwable -> L51
        r4.L$1 = r14;     // Catch: Throwable -> L51
        r4.L$2 = r8;     // Catch: Throwable -> L51
        r4.L$3 = r12;     // Catch: Throwable -> L51
        r4.I$0 = r11;     // Catch: Throwable -> L51
        r4.I$1 = r10;     // Catch: Throwable -> L51
        r4.I$2 = r9;     // Catch: Throwable -> L51
        r4.label = 2;     // Catch: Throwable -> L51
        r6 = ProjectListDataSourceImpl.i(r14, r17, r20, r110, r4);     // Catch: Throwable -> L51
        if (r6 != r0) goto L34;
        return r0;
    L34:
        r13 = r8;
        r3 = r9;
        goto L35
    L30:
        r19 = false;
        goto L31
    L24:
        if (r14.i == true) goto L26;
        r9 = 1;
    L43:
        List r1 = ProjectListDataSourceImpl.k(r14, r13);     // Catch: Throwable -> L51
        if (r5 == false) goto L46;
        boolean r21 = true;
        boolean r22 = true;
    L47:
        com.larus.bmhome.taskskill.service.i r23 = new com.larus.bmhome.taskskill.service.i(r1, r22, r21);     // Catch: Throwable -> L51
        ProjectListDataSourceImpl.m(r14, r23);     // Catch: Throwable -> L51
        int r24 = a.a;     // Catch: Throwable -> L51
        a.a("project_list_load_result", "source=" + a.b(r14) + " gen=" + r11 + " pages=" + r12.element + " loaded=" + r10 + "->" + r23.a.size() + " hasMore=" + r23.b);     // Catch: Throwable -> L51
        Object r25 = null;
    L49:
        r15.unlock(r25);
        return r23;
    L46:
        r21 = true;
        r22 = false;
        goto L47
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ProjectListDataSourceImpl r26 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r111 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
    L15:
        r15 = r111;
        ProjectListDataSourceImpl.g(r26);     // Catch: Throwable -> L51
        if (r26.d.c == true) goto L19;
    L21:
        int r112 = r26.h + 1;     // Catch: Throwable -> L51
        r26.h = r112;     // Catch: Throwable -> L51
        int r113 = a.a;     // Catch: Throwable -> L51
        a.a("project_list_load_start", "source=" + a.b(r26) + " gen=" + r112 + " loaded=" + r26.d.a.size() + " initialized=" + r26.d.c);     // Catch: Throwable -> L51
        List r114 = CollectionsKt.toMutableList(r26.d.a);     // Catch: Throwable -> L51
        int r115 = r114.size();     // Catch: Throwable -> L51
        r16 = r26.d.c ^ true;     // Catch: Throwable -> L51
        r4 = this;
        r14 = r26;
        r8 = r114;
        r11 = r112;
        r10 = r115;
        r12 = new Ref.IntRef();     // Catch: Throwable -> L51
        goto L22
    L19:
        if (r26.d.b == true) goto L21;
        r23 = r26.d;     // Catch: Throwable -> L51
        r25 = null;
        goto L49
    L12:
        ResultKt.throwOnFailure(r18);
        r26 = this.this$0;
        r111 = r26.b;
        this.L$0 = r111;
        this.L$1 = r26;
        this.label = 1;
        if (r111.a(null, this) != r0) goto L15;
        return r0;
    L51:
        th = move-exception;
        r15.unlock(null);
        throw th;
    }
}
