package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/capabilitykit/common/execution/JobResult;", "Landroid/os/Parcelable;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class JobResult implements Parcelable {
    public static final Parcelable.Creator<JobResult> CREATOR = null;
    public final long a;
    public final boolean b;
    public final String c;
    public final List<IntentExecutionRecord> d;

    static {
        CREATOR = new a();
    }

    public JobResult(long r2, boolean r4, String r5, List<IntentExecutionRecord> r6) {
        Intrinsics.checkNotNullParameter(r5, "message");
        Intrinsics.checkNotNullParameter(r6, "execRecords");
        this.a = r2;
        this.b = r4;
        this.c = r5;
        this.d = r6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof JobResult) == true) goto L8;
        return false;
    L8:
        JobResult r9 = (JobResult) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r9.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r9.d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r1v2, types: [int] */
    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        boolean r2 = this.b;
        ?? r3 = r2;
        if (r2 == false) goto L6;
        r3 = 1;
    L6:
        return ((((r1 + r3) * 31) + this.c.hashCode()) * 31) + this.d.hashCode();
    }

    public final String toString() {
        return "JobResult(questionId=" + this.a + ", hasError=" + this.b + ", message=" + this.c + ", execRecords=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeLong(this.a);
        r3.writeInt(this.b ? 1 : 0);
        r3.writeString(this.c);
        List<IntentExecutionRecord> r0 = this.d;
        r3.writeInt(r0.size());
        Iterator<IntentExecutionRecord> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L6;
        r1.next().writeToParcel(r3, r4);
        goto L4
    }
}
