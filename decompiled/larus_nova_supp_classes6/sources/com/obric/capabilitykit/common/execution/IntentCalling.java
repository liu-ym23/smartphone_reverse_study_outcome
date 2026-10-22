package com.obric.capabilitykit.common.execution;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/capabilitykit/common/execution/IntentCalling;", "Landroid/os/Parcelable;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class IntentCalling implements Parcelable {
    public static final Parcelable.Creator<IntentCalling> CREATOR = null;
    public final long a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final String f;
    public final String g;
    public final String h;
    public final String i;
    public final Parcelable j;
    public Map<String, String> k;

    static {
        CREATOR = new a();
    }

    public IntentCalling(long r6, long r8, long r10, long r12, long r14, String r16, String r17, String r18, String r19, Parcelable r20, Map<String, String> r21) {
        Intrinsics.checkNotNullParameter(r16, "intentName");
        Intrinsics.checkNotNullParameter(r17, "implClassName");
        this.a = r6;
        this.b = r8;
        this.c = r10;
        this.d = r12;
        this.e = r14;
        this.f = r16;
        this.g = r17;
        this.h = r18;
        this.i = r19;
        this.j = r20;
        this.k = r21;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof IntentCalling) == true) goto L8;
        return false;
    L8:
        IntentCalling r9 = (IntentCalling) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L21;
        return false;
    L21:
        if (this.e == r9.e) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r9.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r9.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r9.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r9.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r9.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r9.k) == true) goto L41;
        return false;
    L41:
        return true;
    }

    public final int hashCode() {
        long r0 = this.a;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.b;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.c;
        int r5 = (r2 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.d;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        long r8 = this.e;
        int r9 = (((((r7 + ((int) (r8 ^ (r8 >>> 32)))) * 31) + this.f.hashCode()) * 31) + this.g.hashCode()) * 31;
        String r10 = this.h;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r9 + r12) * 31;
        String r14 = this.i;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        Parcelable r17 = this.j;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        Map<String, String> r20 = this.k;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    public final String toString() {
        return "IntentCalling(questionId=" + this.a + ", messageId=" + this.b + ", actionId=" + this.c + ", jobId=" + this.d + ", replyFor=" + this.e + ", intentName=" + this.f + ", implClassName=" + this.g + ", inputParamTypeName=" + this.h + ", inputParams=" + this.i + ", inputParamsParcel=" + this.j + ", ext=" + this.k + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(1);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeLong(this.a);
        r4.writeLong(this.b);
        r4.writeLong(this.c);
        r4.writeLong(this.d);
        r4.writeLong(this.e);
        r4.writeString(this.f);
        r4.writeString(this.g);
        r4.writeString(this.h);
        r4.writeString(this.i);
        r4.writeParcelable(this.j, r5);
        Map<String, String> r6 = this.k;
        if (r6 != null) goto L5;
        r4.writeInt(0);
    L9:
        r4.writeValue(this.k);
        return;
    L5:
        r4.writeInt(1);
        r4.writeInt(r6.size());
        Iterator<Map.Entry<String, String>> r7 = r6.entrySet().iterator();
    L7:
        if (r7.hasNext() == false) goto L9;
        Map.Entry<String, String> r0 = r7.next();
        r4.writeString(r0.getKey());
        r4.writeString(r0.getValue());
        goto L7
    }
}
