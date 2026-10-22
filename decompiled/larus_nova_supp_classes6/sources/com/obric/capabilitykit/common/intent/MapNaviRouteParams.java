package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0010J2\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\u0007HÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÖ\u0001J\u0012\u0010\u001f\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u001dH\u0016J\t\u0010!\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007HÖ\u0001R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006'"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "destName", "", "departName", "transportMode", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getTransportMode", "()Ljava/lang/Integer;", "setTransportMode", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/MapNaviRouteParams;", "describeContents", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MapNaviRouteParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MapNaviRouteParams> CREATOR = null;
    private String departName;
    private String destName;
    private Integer transportMode;

    static {
        CREATOR = new a();
    }

    public MapNaviRouteParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ MapNaviRouteParams copy$default(MapNaviRouteParams r0, String r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.destName;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.departName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.transportMode;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.destName;
    }

    public final String component2() {
        return this.departName;
    }

    public final Integer component3() {
        return this.transportMode;
    }

    public final MapNaviRouteParams copy(String r2, String r3, Integer r4) {
        return new MapNaviRouteParams(r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MapNaviRouteParams) == true) goto L8;
        return false;
    L8:
        MapNaviRouteParams r6 = (MapNaviRouteParams) r5;
        if (Intrinsics.areEqual(this.destName, r6.destName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.departName, r6.departName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.transportMode, r6.transportMode) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.destName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.departName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.transportMode;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "MapNaviRouteParams(destName=" + this.destName + ", departName=" + this.departName + ", transportMode=" + this.transportMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        int r4 = 0;
        r2.writeInt(0);
        Intrinsics.checkNotNullParameter(r2, "out");
        r2.writeString(this.destName);
        r2.writeString(this.departName);
        Integer r0 = this.transportMode;
        if (r0 == null) goto L6;
        r2.writeInt(1);
        r4 = r0.intValue();
    L6:
        r2.writeInt(r4);
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final String getDestName() {
        return this.destName;
    }

    public final Integer getTransportMode() {
        return this.transportMode;
    }

    public IntentParams mergeParams(Object r4) {
        if ((r4 instanceof MapNaviRouteParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.destName;
        if (r0 != null) goto L8;
        r0 = ((MapNaviRouteParams) r4).destName;
    L8:
        String r1 = this.departName;
        if (r1 != null) goto L11;
        r1 = ((MapNaviRouteParams) r4).departName;
    L11:
        Integer r2 = this.transportMode;
        if (r2 != null) goto L15;
        r2 = ((MapNaviRouteParams) r4).transportMode;
    L15:
        return new MapNaviRouteParams(r0, r1, r2);
    }

    public final void setDepartName(String r1) {
        this.departName = r1;
    }

    public final void setDestName(String r1) {
        this.destName = r1;
    }

    public final void setTransportMode(Integer r1) {
        this.transportMode = r1;
    }

    public MapNaviRouteParams(String r1, String r2, Integer r3) {
        this.destName = r1;
        this.departName = r2;
        this.transportMode = r3;
    }

    public /* synthetic */ MapNaviRouteParams(String r2, String r3, Integer r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
