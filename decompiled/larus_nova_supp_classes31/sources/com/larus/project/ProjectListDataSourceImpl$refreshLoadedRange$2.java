package com.larus.project;

import com.larus.im.internal.jni.bean.OmniConversationSortType;
import com.tencent.open.log.TraceLevel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl$refreshLoadedRange$2", f = "ProjectListDataSourceImpl.kt", i = {0, 1, 1, 1, 1, 1}, l = {596, 321}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "refreshedItems", "targetSize", "hasRefreshedSecondPage", "isFirstLoadMore"}, s = {"L$0", "L$0", "L$2", "I$0", "I$1", "I$2"})
public final class ProjectListDataSourceImpl$refreshLoadedRange$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$refreshLoadedRange$2(ProjectListDataSourceImpl r1, Continuation<? super ProjectListDataSourceImpl$refreshLoadedRange$2> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new ProjectListDataSourceImpl$refreshLoadedRange$2(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x00a7 -> B:30:0x00aa). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        boolean r5 = false;
        if (r2 == 0) goto L12;
        if (r2 == 1) goto L11;
        if (r2 != 2) goto L10;
        int r3 = this.I$2;
        int r7 = this.I$1;
        int r8 = this.I$0;
        List r9 = (List) this.L$2;
        ProjectListDataSourceImpl r10 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r11 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L34
        ProjectListDataSourceImpl$refreshLoadedRange$2 r14 = this;
        int r12 = r3;
        Object r4 = r18;
    L30:
        h r6 = (h) r4;     // Catch: Throwable -> L34
        if (r12 == 0) goto L33;
        r7 = 1;
    L33:
        ProjectListDataSourceImpl.h(r10, r9, ProjectListDataSourceImpl.l(r10, r6));     // Catch: Throwable -> L34
        int r13 = r6.e;     // Catch: Throwable -> L34
        boolean r15 = false;
        boolean r16 = r6.f;     // Catch: Throwable -> L34
        int r17 = r13;
    L17:
        if (r16 == true) goto L19;
    L36:
        r10.f = r17;     // Catch: Throwable -> L34
        if (r7 == 0) goto L39;
        r5 = true;
    L39:
        r10.i = r5;     // Catch: Throwable -> L34
        ProjectListDataSourceImpl.m(r10, new com.larus.bmhome.taskskill.service.i(ProjectListDataSourceImpl.k(r10, r9), r16, true));     // Catch: Throwable -> L34
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L34
        r11.unlock(null);
        return Unit.INSTANCE;
    L19:
        if (r9.size() >= r8) goto L36;
        if (r15 == true) goto L23;
        if (r7 != 0) goto L23;
        r12 = 1;
    L24:
        if (r12 == 0) goto L26;
        boolean r19 = true;
    L27:
        int r110 = ProjectListDataSourceImpl.n(r15, r19);     // Catch: Throwable -> L34
        OmniConversationSortType r111 = r10.g;     // Catch: Throwable -> L34
        r14.L$0 = r11;     // Catch: Throwable -> L34
        r14.L$1 = r10;     // Catch: Throwable -> L34
        r14.L$2 = r9;     // Catch: Throwable -> L34
        r14.I$0 = r8;     // Catch: Throwable -> L34
        r14.I$1 = r7;     // Catch: Throwable -> L34
        r14.I$2 = r12;     // Catch: Throwable -> L34
        r14.label = 2;     // Catch: Throwable -> L34
        r4 = ProjectListDataSourceImpl.i(r10, r17, r110, r111, r14);     // Catch: Throwable -> L34
        if (r4 != r0) goto L30;
        return r0;
    L26:
        r19 = false;
    L23:
        r12 = 0;
        goto L24
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ProjectListDataSourceImpl r20 = (ProjectListDataSourceImpl) this.L$1;
        kotlinx.coroutines.sync.a r21 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r18);
    L15:
        r11 = r21;
        ProjectListDataSourceImpl.g(r20);     // Catch: Throwable -> L34
        int r22 = Math.max(r20.d.a.size(), ProjectListDataSourceImpl.n(true, false));     // Catch: Throwable -> L34
        r14 = this;
        r10 = r20;
        r9 = new ArrayList();     // Catch: Throwable -> L34
        r17 = Integer.MAX_VALUE;
        r16 = true;
        r15 = true;
        r8 = r22;
        r7 = 0;
        goto L17
    L12:
        ResultKt.throwOnFailure(r18);
        r20 = this.this$0;
        r21 = r20.b;
        this.L$0 = r21;
        this.L$1 = r20;
        this.label = 1;
        if (r21.a(null, this) != r0) goto L15;
        return r0;
    L34:
        th = move-exception;
        r11.unlock(null);
        throw th;
    }
}
