package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.intent.IntentResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0087\b\u0018\u00002\u00020\u0001R&\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentExecutionRecord;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "d", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "getResult", "()Lcom/obric/capabilitykit/common/intent/IntentResult;", "setResult", "(Lcom/obric/capabilitykit/common/intent/IntentResult;)V", "result", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class IntentExecutionRecord implements Parcelable {
    public static final Parcelable.Creator<IntentExecutionRecord> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public IntentResult<?> d;
    public final boolean e;

    static {
        CREATOR = new a();
    }

    public IntentExecutionRecord(String r2, String r3, String r4, IntentResult<?> r5, boolean r6) {
        Intrinsics.checkNotNullParameter(r2, "intentName");
        Intrinsics.checkNotNullParameter(r3, "implPackage");
        Intrinsics.checkNotNullParameter(r4, "implClassName");
        Intrinsics.checkNotNullParameter(r5, "result");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof IntentExecutionRecord) == true) goto L8;
        return false;
    L8:
        IntentExecutionRecord r6 = (IntentExecutionRecord) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L23;
        return false;
    L23:
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v9, types: [int] */
    /* JADX WARN: Type inference failed for: r1v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        boolean r1 = this.e;
        ?? r2 = r1;
        if (r1 == false) goto L6;
        r2 = 1;
    L6:
        return r0 + r2;
    }

    public final void setResult(IntentResult<?> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.d = r2;
    }

    public final String toString() {
        return "IntentExecutionRecord(intentName=" + this.a + ", implPackage=" + this.b + ", implClassName=" + this.c + ", result=" + this.d + ", requiresAuthorization=" + this.e + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r2, int r3) {
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.a);
        r2.writeString(this.b);
        r2.writeString(this.c);
        r2.writeParcelable(this.d, r3);
        r2.writeInt(this.e ? 1 : 0);
    }
}
