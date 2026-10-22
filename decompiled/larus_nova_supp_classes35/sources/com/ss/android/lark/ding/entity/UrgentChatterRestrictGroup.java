package com.ss.android.lark.ding.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 $2\u00020\u0001:\u0001$B5\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nB\u0011\b\u0016\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\t\u0010\rJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0016J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0003J7\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u0003HÖ\u0001J\t\u0010#\u001a\u00020\u0006HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006%"}, d2 = {"Lcom/ss/android/lark/ding/entity/UrgentChatterRestrictGroup;", "Landroid/os/Parcelable;", "count", BuildConfig.FLAVOR, "boundedChatterIds", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "allChatterIds", BuildConfig.FLAVOR, "<init>", "(ILjava/util/Set;Ljava/util/List;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getCount", "()I", "setCount", "(I)V", "getBoundedChatterIds", "()Ljava/util/Set;", "getAllChatterIds", "()Ljava/util/List;", "writeToParcel", BuildConfig.FLAVOR, "flags", "describeContents", "component1", "component2", "component3", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", "toString", "CREATOR", "ding-entity_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UrgentChatterRestrictGroup implements Parcelable {
    public static final a CREATOR = null;
    public final int a;
    public final Set<String> b;
    public final List<String> c;

    public static final class a implements Parcelable.Creator<UrgentChatterRestrictGroup> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentChatterRestrictGroup createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            Intrinsics.checkNotNullParameter(r4, "parcel");
            int r0 = r4.readInt();
            String[] r2 = r4.createStringArray();
            if (r2 == null) goto L5;
            Set r3 = ArraysKt.toMutableSet(r2);
        L7:
            return new UrgentChatterRestrictGroup(r0, r3, r4.createStringArrayList());
        L5:
            r3 = null;
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public final UrgentChatterRestrictGroup[] newArray(int r1) {
            return new UrgentChatterRestrictGroup[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public UrgentChatterRestrictGroup() {
        this(null, 7);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof UrgentChatterRestrictGroup) == true) goto L8;
        return false;
    L8:
        UrgentChatterRestrictGroup r6 = (UrgentChatterRestrictGroup) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        Set<String> r1 = this.b;
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        int r4 = (r0 + r3) * 31;
        List<String> r5 = this.c;
        if (r5 == null) goto L11;
        r2 = r5.hashCode();
    L11:
        return r4 + r2;
    L5:
        r3 = r1.hashCode();
        goto L6
    }

    public final String toString() {
        return "UrgentChatterRestrictGroup(count=" + this.a + ", boundedChatterIds=" + this.b + ", allChatterIds=" + this.c + ')';
    }

    public /* synthetic */ UrgentChatterRestrictGroup(Set r2, int r3) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(0, r2, null);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.a);
        Set<String> r5 = this.b;
        if (r5 == null) goto L6;
        String[] r6 = (String[]) r5.toArray(new String[0]);
        if (r6 == null) goto L6;
    L7:
        r3.writeStringArray(r6);
        r3.writeStringList(this.c);
        return;
    L6:
        r6 = new String[0];
        goto L7
    }

    public UrgentChatterRestrictGroup(int r1, Set<String> r2, List<String> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
