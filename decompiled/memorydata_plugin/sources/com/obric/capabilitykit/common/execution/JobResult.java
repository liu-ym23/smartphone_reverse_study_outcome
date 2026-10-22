package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\u0002\u0010\u000bJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J7\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\"HÖ\u0001J\t\u0010'\u001a\u00020\u0007HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\"HÖ\u0001R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/common/execution/JobResult;", "Landroid/os/Parcelable;", "questionId", "", "hasError", "", "message", "", "execRecords", "", "Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "(JZLjava/lang/String;Ljava/util/List;)V", "getExecRecords", "()Ljava/util/List;", "setExecRecords", "(Ljava/util/List;)V", "getHasError", "()Z", "setHasError", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getQuestionId", "()J", "setQuestionId", "(J)V", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class JobResult implements Parcelable {
    public static final Parcelable.Creator<JobResult> CREATOR = null;
    private List<IntentExecutionRecord> execRecords;
    private boolean hasError;
    private String message;
    private long questionId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<JobResult> {
        public a() {
        }

        public final JobResult a(Parcel r11) {
            int r10 = r11.readInt();
            Intrinsics.checkNotNullParameter(r11, "parcel");
            long r2 = r11.readLong();
            int r8 = 1;
            if (r11.readInt() == 0) goto L5;
            boolean r4 = true;
        L6:
            String r5 = r11.readString();
            int r0 = r11.readInt();
            ArrayList r6 = new ArrayList(r0);
            int r1 = 0;
        L7:
            if (r1 == r0) goto L9;
            r6.add(IntentExecutionRecord.CREATOR.createFromParcel(r11));
            r1 = r1 + 1;
            goto L7
        L9:
            JobResult r3 = new JobResult(r2, r4, r5, r6);
            int r7 = Math.min(r10, 0);
            ClassLoader r9 = a.class.getClassLoader();
        L10:
            if (r8 > r7) goto L12;
            r8 = r8 + 1;
        L12:
            if (r8 > r10) goto L14;
            com.obric.b.a.a(r11, r9);
            r8 = r8 + 1;
            goto L12
        L14:
            return r3;
        L5:
            r4 = false;
            goto L6
        }

        public final JobResult[] a(int r1) {
            return new JobResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ JobResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ JobResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a();
    }

    public JobResult(long r3, boolean r5, String r6, List<IntentExecutionRecord> r7) {
        List<IntentExecutionRecord> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "message");
        Intrinsics.checkNotNullParameter(r8, "execRecords");
        this.questionId = r3;
        this.hasError = r5;
        this.message = r6;
        this.execRecords = r8;
    }

    public static /* synthetic */ JobResult copy$default(JobResult r6, long r7, boolean r9, String r10, List r11, int r12, Object r13) {
        List<IntentExecutionRecord> r14 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        if ((r12 & 1) == 0) goto L5;
        r7 = r6.questionId;
    L5:
        long r1 = r7;
        if ((r12 & 2) == 0) goto L8;
        r9 = r6.hasError;
    L8:
        boolean r3 = r9;
        if ((r12 & 4) == 0) goto L11;
        r10 = r6.message;
    L11:
        String r4 = r10;
        if ((r12 & 8) == 0) goto L15;
        r14 = r6.execRecords;
    L15:
        return r6.copy(r1, r3, r4, r14);
    }

    public final long component1() {
        return this.questionId;
    }

    public final boolean component2() {
        return this.hasError;
    }

    public final String component3() {
        return this.message;
    }

    public final List<IntentExecutionRecord> component4() {
        return this.execRecords;
    }

    public final JobResult copy(long r7, boolean r9, String r10, List<IntentExecutionRecord> r11) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "message");
        Intrinsics.checkNotNullParameter(r5, "execRecords");
        return new JobResult(r7, r9, r10, r5);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, JobResult.class) == true) goto L8;
        return false;
    L8:
        JobResult r10 = (JobResult) ZeusTransformUtils.preCheckCast(r9, JobResult.class, "com.obric.memorydata.plugin");
        if (this.questionId == r10.questionId) goto L12;
        return false;
    L12:
        if (this.hasError == r10.hasError) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.message, r10.message) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.execRecords, r10.execRecords) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final List<IntentExecutionRecord> getExecRecords() {
        return this.execRecords;
    }

    public final boolean getHasError() {
        return this.hasError;
    }

    public final String getMessage() {
        return this.message;
    }

    public final long getQuestionId() {
        return this.questionId;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int r0 = Long.hashCode(this.questionId) * 31;
        boolean r1 = this.hasError;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return ((((r0 + r2) * 31) + this.message.hashCode()) * 31) + this.execRecords.hashCode();
    }

    public final void setExecRecords(List<IntentExecutionRecord> r3) {
        List<IntentExecutionRecord> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        this.execRecords = r4;
    }

    public final void setHasError(boolean r1) {
        this.hasError = r1;
    }

    public final void setMessage(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.message = r2;
    }

    public final void setQuestionId(long r1) {
        this.questionId = r1;
    }

    public String toString() {
        return "JobResult(questionId=" + this.questionId + ", hasError=" + this.hasError + ", message=" + this.message + ", execRecords=" + this.execRecords + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeLong(this.questionId);
        r4.writeInt(this.hasError ? 1 : 0);
        r4.writeString(this.message);
        List<IntentExecutionRecord> r3 = this.execRecords;
        r4.writeInt(r3.size());
        Iterator<IntentExecutionRecord> r6 = r3.iterator();
    L4:
        if (r6.hasNext() == false) goto L6;
        ((IntentExecutionRecord) ZeusTransformUtils.preCheckCast(r6.next(), IntentExecutionRecord.class, "com.obric.memorydata.plugin")).writeToParcel(r4, r5);
        goto L4
    }
}
