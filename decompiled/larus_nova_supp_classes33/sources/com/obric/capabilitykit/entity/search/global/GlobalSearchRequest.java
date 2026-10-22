package com.obric.capabilitykit.entity.search.global;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.capabilitykit.common.UtilsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchRequest;", "Landroid/os/Parcelable;", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1})
public final class GlobalSearchRequest implements Parcelable {
    public static final a CREATOR = null;

    public static final class a implements Parcelable.Creator<GlobalSearchRequest> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchRequest createFromParcel(Parcel r3) {
            Intrinsics.checkNotNullParameter(r3, "parcel");
            return (GlobalSearchRequest) GsonProtectorUtils.fromJson(UtilsKt.a(), r3.readString(), GlobalSearchRequest.class);
        }

        @Override // android.os.Parcelable.Creator
        public final GlobalSearchRequest[] newArray(int r1) {
            return new GlobalSearchRequest[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof GlobalSearchRequest) == true) goto L8;
        return false;
    L8:
        ((GlobalSearchRequest) r4).getClass();
        if (Intrinsics.areEqual(null, null) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(null, null) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        throw null;
    }

    public final String toString() {
        return "GlobalSearchRequest(query=null, searchEntityTypes=null, defaultEntityCount=0, useSemantic=false, enableSemanticRanking=false, maxSemanticResultCount=0)";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(GsonProtectorUtils.toJson(UtilsKt.a(), this));
    }
}
