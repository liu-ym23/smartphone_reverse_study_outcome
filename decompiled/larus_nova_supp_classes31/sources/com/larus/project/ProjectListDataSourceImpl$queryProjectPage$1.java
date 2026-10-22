package com.larus.project;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.project.ProjectListDataSourceImpl", f = "ProjectListDataSourceImpl.kt", i = {0, 0, 0, 0}, l = {592}, m = "queryProjectPage", n = {"conversationSortType", "cursor", "limit", "firstPageConversationLimit"}, s = {"L$0", "I$0", "I$1", "I$2"})
final class ProjectListDataSourceImpl$queryProjectPage$1 extends ContinuationImpl {
    int I$0;
    int I$1;
    int I$2;
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ProjectListDataSourceImpl this$0;

    public ProjectListDataSourceImpl$queryProjectPage$1(ProjectListDataSourceImpl r1, Continuation<? super ProjectListDataSourceImpl$queryProjectPage$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r3) {
        this.result = r3;
        this.label |= Integer.MIN_VALUE;
        return ProjectListDataSourceImpl.i(this.this$0, 0, 0, null, this);
    }
}
