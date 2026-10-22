package com.larus.account.saas.mfa.assist.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0081\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/larus/account/saas/mfa/assist/bean/MfaMessage;", "Landroid/os/Parcelable;", "", "scene", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "token", "b", "account-saas-mfa_release"}, k = 1, mv = {1, 7, 1})
public final class MfaMessage implements Parcelable {
    public static final Parcelable.Creator<MfaMessage> CREATOR = null;

    @SerializedName("scene")
    private final String scene;

    @SerializedName("user_code")
    private final String token;

    public static final class a implements Parcelable.Creator<MfaMessage> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final MfaMessage createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return new MfaMessage(r3.readString(), r3.readString());
        }

        @Override // android.os.Parcelable.Creator
        public final MfaMessage[] newArray(int r1) {
            return new MfaMessage[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public MfaMessage() {
        this(null, null);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MfaMessage) == true) goto L8;
        return false;
    L8:
        MfaMessage r6 = (MfaMessage) r5;
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.token, r6.token) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r0 = this.scene;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.token;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "MfaMessage(scene=" + this.scene + ", token=" + this.token + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.scene);
        r1.writeString(this.token);
    }

    public final String a() {
        return this.scene;
    }

    public final String b() {
        return this.token;
    }

    public MfaMessage(String r1, String r2) {
        this.scene = r1;
        this.token = r2;
    }
}
