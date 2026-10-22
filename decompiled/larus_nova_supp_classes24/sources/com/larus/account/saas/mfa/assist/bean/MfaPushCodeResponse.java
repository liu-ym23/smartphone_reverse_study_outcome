package com.larus.account.saas.mfa.assist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/larus/account/saas/mfa/assist/bean/MfaPushCodeResponse;", "Landroid/os/Parcelable;", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaPushCodeResponse implements Parcelable {
    public static final Parcelable.Creator<MfaPushCodeResponse> CREATOR = null;
    public final String a;
    public final Long b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;

    public static final class a implements Parcelable.Creator<MfaPushCodeResponse> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MfaPushCodeResponse createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            Long r1 = null;
        L7:
            return new MfaPushCodeResponse(r2, r1, r10.readString(), r10.readString(), r10.readString(), r10.readString(), r10.readString());
        L5:
            r1 = Long.valueOf(r10.readLong());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final MfaPushCodeResponse[] newArray(int r1) {
            return new MfaPushCodeResponse[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MfaPushCodeResponse() {
        this(null, null, null, null, null, null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MfaPushCodeResponse) == true) goto L8;
        return false;
    L8:
        MfaPushCodeResponse r6 = (MfaPushCodeResponse) r5;
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
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r6.g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r0 = this.a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r19 = (r15 + r17) * 31;
        String r20 = this.g;
        if (r20 == null) goto L31;
        r1 = r20.hashCode();
    L31:
        return r19 + r1;
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MfaPushCodeResponse(code=" + this.a + ", expireTime=" + this.b + ", title=" + this.c + ", allowPopMessage=" + this.d + ", codePopMessage=" + this.e + ", loginLocation=" + this.f + ", loginDeviceName=" + this.g + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.a);
        Long r5 = this.b;
        if (r5 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.c);
        r3.writeString(this.d);
        r3.writeString(this.e);
        r3.writeString(this.f);
        r3.writeString(this.g);
        return;
    L5:
        r3.writeInt(1);
        r3.writeLong(r5.longValue());
        goto L6
    }

    public MfaPushCodeResponse(String r1, Long r2, String r3, String r4, String r5, String r6, String r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
