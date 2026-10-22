package com.larus.dora.impl.onboarding;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BS\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0096\u0002J\b\u0010 \u001a\u00020\u0007H\u0016J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0007HÆ\u0003J\t\u0010%\u001a\u00020\u0007HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\u0007HÆ\u0003Jg\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\f\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u0007HÆ\u0001J\u0006\u0010+\u001a\u00020\u0007J\t\u0010,\u001a\u00020\u0003HÖ\u0001J\u0016\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\r\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015¨\u00062"}, d2 = {"Lcom/larus/dora/impl/onboarding/DoraOnboardingDevice;", "Landroid/os/Parcelable;", "name", "", "mac", "sn", "type", "", "sku", "battery", "", "charge", "productId", "vendorID", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;II[I[III)V", "getName", "()Ljava/lang/String;", "getMac", "getSn", "getType", "()I", "getSku", "getBattery", "()[I", "getCharge", "getProductId", "getVendorID", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DoraOnboardingDevice implements Parcelable {
    public static final Parcelable.Creator<DoraOnboardingDevice> CREATOR = null;
    public final String a;
    public final String b;
    public final String c;
    public final int d;
    public final int e;
    public final int[] f;
    public final int[] g;
    public final int h;
    public final int i;

    public static final class a implements Parcelable.Creator<DoraOnboardingDevice> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final DoraOnboardingDevice createFromParcel(Parcel r12) {
            Intrinsics.checkNotNullParameter(r12, "parcel");
            return new DoraOnboardingDevice(r12.readString(), r12.readString(), r12.readString(), r12.readInt(), r12.readInt(), r12.createIntArray(), r12.createIntArray(), r12.readInt(), r12.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final DoraOnboardingDevice[] newArray(int r1) {
            return new DoraOnboardingDevice[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "DoraOnboardingDevice(name=" + this.a + ", mac=" + this.b + ", sn=" + this.c + ", type=" + this.d + ", sku=" + this.e + ", battery=" + Arrays.toString(this.f) + ", charge=" + Arrays.toString(this.g) + ", productId=" + this.h + ", vendorID=" + this.i + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.a);
        r1.writeString(this.b);
        r1.writeString(this.c);
        r1.writeInt(this.d);
        r1.writeInt(this.e);
        r1.writeIntArray(this.f);
        r1.writeIntArray(this.g);
        r1.writeInt(this.h);
        r1.writeInt(this.i);
    }

    public final int hashCode() {
        int r0 = ((((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d) * 31) + this.e) * 31;
        int[] r1 = this.f;
        int r2 = 0;
        if (r1 == null) goto L5;
        int r3 = Arrays.hashCode(r1);
    L6:
        int r4 = (r0 + r3) * 31;
        int[] r5 = this.g;
        if (r5 == null) goto L10;
        r2 = Arrays.hashCode(r5);
    L10:
        return ((((r4 + r2) * 31) + this.h) * 31) + this.i;
    L5:
        r3 = 0;
        goto L6
    }

    public final int getType() {
        return this.d;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 == null) goto L8;
        Class<?> r2 = r5.getClass();
    L10:
        if (Intrinsics.areEqual(DoraOnboardingDevice.class, r2) == true) goto L12;
        return false;
    L12:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type com.larus.dora.impl.onboarding.DoraOnboardingDevice");
        DoraOnboardingDevice r6 = (DoraOnboardingDevice) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L19;
        return false;
    L19:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L22;
        return false;
    L22:
        if (this.d == r6.d) goto L25;
        return false;
    L25:
        if (this.e == r6.e) goto L27;
        return false;
    L27:
        int[] r1 = this.f;
        if (r1 == null) goto L36;
        int[] r3 = r6.f;
        if (r3 != null) goto L33;
        return false;
    L33:
        if (Arrays.equals(r1, r3) == true) goto L38;
        return false;
    L38:
        int[] r4 = this.g;
        if (r4 == null) goto L47;
        int[] r7 = r6.g;
        if (r7 != null) goto L44;
        return false;
    L44:
        if (Arrays.equals(r4, r7) == true) goto L50;
        return false;
    L50:
        if (this.h == r6.h) goto L53;
        return false;
    L53:
        if (this.i == r6.i) goto L55;
        return false;
    L55:
        return true;
    L47:
        if (r6.g == null) goto L50;
        return false;
    L36:
        if (r6.f == null) goto L38;
        return false;
    L8:
        r2 = null;
        goto L10
    }

    public DoraOnboardingDevice(String r2, String r3, String r4, int r5, int r6, int[] r7, int[] r8, int r9, int r10) {
        Intrinsics.checkNotNullParameter(r2, "name");
        Intrinsics.checkNotNullParameter(r3, "mac");
        Intrinsics.checkNotNullParameter(r4, "sn");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
        this.h = r9;
        this.i = r10;
    }
}
