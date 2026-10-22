package com.larus.project;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl", f = "ProjectListDataSourceImpl.kt", i = {}, l = {307}, m = "refreshLoadedRange", n = {}, s = {})
public final class ProjectListDataSourceImpl$refreshLoadedRange$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$refreshLoadedRange$1(ProjectListDataSourceImpl r1, Continuation<? super ProjectListDataSourceImpl$refreshLoadedRange$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r2) {
        this.result = r2;
        this.label |= Integer.MIN_VALUE;
        ProjectListDataSourceImpl r3 = this.this$0;
        int r0 = ProjectListDataSourceImpl.j;
        return r3.o(this);
    }
}
