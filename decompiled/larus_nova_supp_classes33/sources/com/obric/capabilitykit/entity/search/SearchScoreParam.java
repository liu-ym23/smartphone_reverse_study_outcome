package com.obric.capabilitykit.entity.search;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.assistant.interaction.api.service.IInteractionStateService$Companion;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J\t\u0010\u000f\u001a\u00020\bHÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\bHÖ\u0001J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/search/SearchScoreParam;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "value", "", "type", "", "(DLjava/lang/String;)V", "getType", "()Ljava/lang/String;", "getValue", "()D", "component1", "component2", "copy", "describeContents", "", "equals", "", IInteractionStateService$Companion.WAKE_UP_SOURCE_OTHER, "", "hashCode", "toString", "writeToParcel", "", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SearchScoreParam implements Parcelable {
    public static final a CREATOR = null;
    private final String type;
    private final double value;

    public static final class a implements Parcelable.Creator<SearchScoreParam> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final SearchScoreParam createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new SearchScoreParam(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final SearchScoreParam[] newArray(int r1) {
            return new SearchScoreParam[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    public SearchScoreParam() {
        this(0.0d, null, 3, null);
    }

    public SearchScoreParam(double r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        this.value = r2;
        this.type = r4;
    }

    public /* synthetic */ SearchScoreParam(double r1, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = 0.0d;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = "";
    L8:
        this(r1, r3);
    }

    public SearchScoreParam(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        double r0 = r3.readDouble();
        String r4 = r3.readString();
        if (r4 != null) goto L5;
        r4 = "";
    L5:
        this(r0, r4);
    }

    public static /* synthetic */ SearchScoreParam copy$default(SearchScoreParam r0, double r1, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.value;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r0.type;
    L9:
        return r0.copy(r1, r3);
    }

    public final double component1() {
        return this.value;
    }

    public final String component2() {
        return this.type;
    }

    public final SearchScoreParam copy(double r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "type");
        return new SearchScoreParam(r2, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SearchScoreParam) == true) goto L8;
        return false;
    L8:
        SearchScoreParam r9 = (SearchScoreParam) r8;
        if (Double.compare(this.value, r9.value) == 0) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type, r9.type) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getType() {
        return this.type;
    }

    public final double getValue() {
        return this.value;
    }

    public int hashCode() {
        long r0 = Double.doubleToLongBits(this.value);
        return (((int) (r0 ^ (r0 >>> 32))) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "SearchScoreParam(value=" + this.value + ", type=" + this.type + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeDouble(this.value);
        r3.writeString(this.type);
    }
}
