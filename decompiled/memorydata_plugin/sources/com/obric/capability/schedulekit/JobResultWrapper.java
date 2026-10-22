package com.obric.capability.schedulekit;

import com.obric.capabilitykit.common.execution.JobResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\bHÆ\u0003J7\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\r¨\u0006\u001b"}, d2 = {"Lcom/obric/capability/schedulekit/JobResultWrapper;", "", "question", "", "result", "replyForSvr", "", "jobResult", "Lcom/obric/capabilitykit/common/execution/JobResult;", "(Ljava/lang/String;Ljava/lang/String;ZLcom/obric/capabilitykit/common/execution/JobResult;)V", "getJobResult", "()Lcom/obric/capabilitykit/common/execution/JobResult;", "getQuestion", "()Ljava/lang/String;", "getReplyForSvr", "()Z", "getResult", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "capabilityschedulekit_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JobResultWrapper {
    private final JobResult jobResult;
    private final String question;
    private final boolean replyForSvr;
    private final String result;

    public JobResultWrapper(String r1, String r2, boolean r3, JobResult r4) {
        this.question = r1;
        this.result = r2;
        this.replyForSvr = r3;
        this.jobResult = r4;
    }

    public static /* synthetic */ JobResultWrapper copy$default(JobResultWrapper r0, String r1, String r2, boolean r3, JobResult r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.question;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.result;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.replyForSvr;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.jobResult;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.question;
    }

    public final String component2() {
        return this.result;
    }

    public final boolean component3() {
        return this.replyForSvr;
    }

    public final JobResult component4() {
        return this.jobResult;
    }

    public final JobResultWrapper copy(String r1, String r2, boolean r3, JobResult r4) {
        return new JobResultWrapper(r1, r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, JobResultWrapper.class) == true) goto L8;
        return false;
    L8:
        JobResultWrapper r6 = (JobResultWrapper) ZeusTransformUtils.preCheckCast(r5, JobResultWrapper.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.question, r6.question) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.result, r6.result) == true) goto L15;
        return false;
    L15:
        if (this.replyForSvr == r6.replyForSvr) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.jobResult, r6.jobResult) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final JobResult getJobResult() {
        return this.jobResult;
    }

    public final String getQuestion() {
        return this.question;
    }

    public final boolean getReplyForSvr() {
        return this.replyForSvr;
    }

    public final String getResult() {
        return this.result;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v6, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        String r0 = this.question;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.result;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        boolean r7 = this.replyForSvr;
        ?? r8 = r7;
        if (r7 == false) goto L13;
        r8 = 1;
    L13:
        int r9 = (r6 + r8) * 31;
        JobResult r10 = this.jobResult;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "JobResultWrapper(question=" + this.question + ", result=" + this.result + ", replyForSvr=" + this.replyForSvr + ", jobResult=" + this.jobResult + ')';
    }
}
