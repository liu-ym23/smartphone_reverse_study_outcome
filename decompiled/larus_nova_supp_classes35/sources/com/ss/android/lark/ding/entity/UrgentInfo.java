package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.ss.ttvideoengine.strategrycenter.IPortraitService;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tB\u0011\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\b\u0010\u0016\u001a\u00020\u0007H\u0016J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J'\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006#"}, d2 = {"Lcom/ss/android/lark/ding/entity/UrgentInfo;", "Landroid/os/Parcelable;", IPortraitService.TYPE, "Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "readState", "Lcom/ss/android/lark/ding/entity/DingReadState;", "deniedReason", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;Lcom/ss/android/lark/ding/entity/DingReadState;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getType", "()Lcom/ss/android/lark/ding/entity/DingInaccessibleCode;", "getReadState", "()Lcom/ss/android/lark/ding/entity/DingReadState;", "getDeniedReason", "()I", "writeToParcel", BuildConfig.FLAVOR, "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", BuildConfig.FLAVOR, "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentInfo implements Parcelable {
    public static final a CREATOR = null;
    public final DingInaccessibleCode a;
    public final DingReadState b;
    public final int c;

    public static final class a implements Parcelable.Creator<UrgentInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentInfo createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new UrgentInfo(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentInfo[] newArray(int r1) {
            return new UrgentInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrgentInfo) == true) goto L8;
        return false;
    L8:
        UrgentInfo r6 = (UrgentInfo) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c;
    }

    public final String toString() {
        return "UrgentInfo(type=" + this.a + ", readState=" + this.b + ", deniedReason=" + this.c + ')';
    }

    public final DingInaccessibleCode getType() {
        return this.a;
    }

    public UrgentInfo(Parcel r6) {
        Intrinsics.checkNotNullParameter(r6, "parcel");
        DingInaccessibleCode.a r0 = DingInaccessibleCode.Companion;
        int r1 = r6.readInt();
        r0.getClass();
        if (r1 == 1) goto L16;
        if (r1 != 2) goto L6;
        DingInaccessibleCode r2 = DingInaccessibleCode.EMPTY_PHONE;
    L17:
        DingReadState.a r3 = DingReadState.Companion;
        int r4 = r6.readInt();
        r3.getClass();
        if (r4 == 1) goto L22;
        if (r4 == 2) goto L21;
        DingReadState r5 = DingReadState.NONE;
    L23:
        int r7 = r6.readInt();
        Intrinsics.checkNotNullParameter(r2, IPortraitService.TYPE);
        Intrinsics.checkNotNullParameter(r5, "readState");
        this.a = r2;
        this.b = r5;
        this.c = r7;
        return;
    L21:
        r5 = DingReadState.UN_READ;
        goto L23
    L22:
        r5 = DingReadState.READ;
        goto L23
    L6:
        if (r1 != 3) goto L8;
        r2 = DingInaccessibleCode.CROSS_PLATFORM;
        goto L17
    L8:
        if (r1 != 4) goto L10;
        r2 = DingInaccessibleCode.NOT_FRIEND;
        goto L17
    L10:
        if (r1 == 5) goto L12;
        r2 = DingInaccessibleCode.DEFAULT;
        goto L17
    L12:
        r2 = DingInaccessibleCode.USER_SETTING_DISABLED;
        goto L17
    L16:
        r2 = DingInaccessibleCode.EMPTY_NAME;
        goto L17
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a.getValue());
        r1.writeInt(this.b.getValue());
        r1.writeInt(this.c);
    }
}
