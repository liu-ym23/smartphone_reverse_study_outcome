package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020&HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010*H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "departName", "", "destName", "slat", "", "slng", "dlat", "dlng", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getDlat", "()Ljava/lang/Double;", "setDlat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDlng", "setDlng", "getSlat", "setSlat", "getSlng", "setSlng", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", "params", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class MapTakeTaxiParams implements IntentParams, Parcelable {
    public static final Parcelable.Creator<MapTakeTaxiParams> CREATOR = null;
    private String departName;
    private String destName;
    private Double dlat;
    private Double dlng;
    private Double slat;
    private Double slng;

    static {
        CREATOR = new a();
    }

    public MapTakeTaxiParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ MapTakeTaxiParams copy$default(MapTakeTaxiParams r4, String r5, String r6, Double r7, Double r8, Double r9, Double r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r5 = r4.departName;
    L6:
        if ((r11 & 2) == 0) goto L8;
        r6 = r4.destName;
    L8:
        String r13 = r6;
        if ((r11 & 4) == 0) goto L11;
        r7 = r4.slat;
    L11:
        Double r0 = r7;
        if ((r11 & 8) == 0) goto L14;
        r8 = r4.slng;
    L14:
        Double r1 = r8;
        if ((r11 & 16) == 0) goto L17;
        r9 = r4.dlat;
    L17:
        Double r2 = r9;
        if ((r11 & 32) == 0) goto L20;
        r10 = r4.dlng;
    L20:
        String r14 = r5;
        return r4.copy(r14, r13, r0, r1, r2, r10);
    }

    public final String component1() {
        return this.departName;
    }

    public final String component2() {
        return this.destName;
    }

    public final Double component3() {
        return this.slat;
    }

    public final Double component4() {
        return this.slng;
    }

    public final Double component5() {
        return this.dlat;
    }

    public final Double component6() {
        return this.dlng;
    }

    public final MapTakeTaxiParams copy(String r9, String r10, Double r11, Double r12, Double r13, Double r14) {
        return new MapTakeTaxiParams(r9, r10, r11, r12, r13, r14);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MapTakeTaxiParams) == true) goto L8;
        return false;
    L8:
        MapTakeTaxiParams r6 = (MapTakeTaxiParams) r5;
        if (Intrinsics.areEqual(this.departName, r6.departName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.destName, r6.destName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.slat, r6.slat) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.slng, r6.slng) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.dlat, r6.dlat) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.dlng, r6.dlng) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public String getSubActionValue() {
        return null;
    }

    public int hashCode() {
        String r0 = this.departName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.destName;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Double r7 = this.slat;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Double r10 = this.slng;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Double r13 = this.dlat;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Double r16 = this.dlng;
        if (r16 == null) goto L27;
        r1 = r16.hashCode();
    L27:
        return r15 + r1;
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

    public boolean isParamsCompleted() {
        return true;
    }

    public String toString() {
        return "MapTakeTaxiParams(departName=" + this.departName + ", destName=" + this.destName + ", slat=" + this.slat + ", slng=" + this.slng + ", dlat=" + this.dlat + ", dlng=" + this.dlng + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        Intrinsics.checkNotNullParameter(r5, "out");
        r5.writeString(this.departName);
        r5.writeString(this.destName);
        Double r0 = this.slat;
        if (r0 != null) goto L5;
        r5.writeInt(0);
    L6:
        Double r1 = this.slng;
        if (r1 != null) goto L9;
        r5.writeInt(0);
    L10:
        Double r2 = this.dlat;
        if (r2 != null) goto L13;
        r5.writeInt(0);
    L14:
        Double r3 = this.dlng;
        if (r3 != null) goto L17;
        r5.writeInt(0);
        return;
    L17:
        r5.writeInt(1);
        r5.writeDouble(r3.doubleValue());
        return;
    L13:
        r5.writeInt(1);
        r5.writeDouble(r2.doubleValue());
        goto L14
    L9:
        r5.writeInt(1);
        r5.writeDouble(r1.doubleValue());
        goto L10
    L5:
        r5.writeInt(1);
        r5.writeDouble(r0.doubleValue());
        goto L6
    }

    public final String getDepartName() {
        return this.departName;
    }

    public final String getDestName() {
        return this.destName;
    }

    public final Double getDlat() {
        return this.dlat;
    }

    public final Double getDlng() {
        return this.dlng;
    }

    public final Double getSlat() {
        return this.slat;
    }

    public final Double getSlng() {
        return this.slng;
    }

    public IntentParams mergeParams(Object r9) {
        if ((r9 instanceof MapTakeTaxiParams) == true) goto L5;
        return this;
    L5:
        String r0 = this.departName;
        if (r0 != null) goto L8;
        r0 = ((MapTakeTaxiParams) r9).departName;
    L8:
        String r2 = r0;
        String r1 = this.destName;
        if (r1 != null) goto L11;
        r1 = ((MapTakeTaxiParams) r9).destName;
    L11:
        String r3 = r1;
        Double r4 = this.slat;
        if (r4 != null) goto L14;
        r4 = ((MapTakeTaxiParams) r9).slat;
    L14:
        Double r5 = r4;
        Double r6 = this.slng;
        if (r6 != null) goto L17;
        r6 = ((MapTakeTaxiParams) r9).slng;
    L17:
        Double r7 = r6;
        Double r8 = this.dlat;
        if (r8 != null) goto L20;
        r8 = ((MapTakeTaxiParams) r9).dlat;
    L20:
        Double r10 = r8;
        Double r11 = this.dlng;
        if (r11 != null) goto L23;
        Double r12 = ((MapTakeTaxiParams) r9).dlng;
    L25:
        return new MapTakeTaxiParams(r2, r3, r5, r7, r10, r12);
    L23:
        r12 = r11;
        goto L25
    }

    public final void setDepartName(String r1) {
        this.departName = r1;
    }

    public final void setDestName(String r1) {
        this.destName = r1;
    }

    public final void setDlat(Double r1) {
        this.dlat = r1;
    }

    public final void setDlng(Double r1) {
        this.dlng = r1;
    }

    public final void setSlat(Double r1) {
        this.slat = r1;
    }

    public final void setSlng(Double r1) {
        this.slng = r1;
    }

    public MapTakeTaxiParams(String r1, String r2, Double r3, Double r4, Double r5, Double r6) {
        this.departName = r1;
        this.destName = r2;
        this.slat = r3;
        this.slng = r4;
        this.dlat = r5;
        this.dlng = r6;
    }

    public /* synthetic */ MapTakeTaxiParams(String r6, String r7, Double r8, Double r9, Double r10, Double r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r12 & 2) == 0) goto L9;
        String r1 = null;
    L11:
        if ((r12 & 4) == 0) goto L13;
        Double r2 = null;
    L15:
        if ((r12 & 8) == 0) goto L17;
        Double r3 = null;
    L19:
        if ((r12 & 16) == 0) goto L21;
        Double r4 = null;
    L23:
        if ((r12 & 32) == 0) goto L25;
        Double r15 = null;
    L26:
        this(r14, r1, r2, r3, r4, r15);
        return;
    L25:
        r15 = r11;
        goto L26
    L21:
        r4 = r10;
        goto L23
    L17:
        r3 = r9;
        goto L19
    L13:
        r2 = r8;
        goto L15
    L9:
        r1 = r7;
        goto L11
    L5:
        r14 = r6;
        goto L7
    }
}
