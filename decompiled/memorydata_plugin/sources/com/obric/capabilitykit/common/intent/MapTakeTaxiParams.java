package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u001e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002BM\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010!\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0013JV\u0010#\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010$J\t\u0010%\u001a\u00020&HÖ\u0001J\u0013\u0010'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010*HÖ\u0003J\t\u0010+\u001a\u00020&HÖ\u0001J\u0012\u0010,\u001a\u00020\u00012\b\u0010-\u001a\u0004\u0018\u00010*H\u0016J\t\u0010.\u001a\u00020\u0004HÖ\u0001J\u0019\u0010/\u001a\u0002002\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u00020&HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\r\"\u0004\b\u0011\u0010\u000fR\u001e\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001e\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u0019\u0010\u0013\"\u0004\b\u001a\u0010\u0015R\u001e\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0016\u001a\u0004\b\u001b\u0010\u0013\"\u0004\b\u001c\u0010\u0015¨\u00064"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "departName", "", "destName", "slat", "", "slng", "dlat", "dlng", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "getDepartName", "()Ljava/lang/String;", "setDepartName", "(Ljava/lang/String;)V", "getDestName", "setDestName", "getDlat", "()Ljava/lang/Double;", "setDlat", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDlng", "setDlng", "getSlat", "setSlat", "getSlng", "setSlng", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)Lcom/obric/capabilitykit/common/intent/MapTakeTaxiParams;", "describeContents", "", "equals", "", "other", "", "hashCode", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapTakeTaxiParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MapTakeTaxiParams> CREATOR = null;
    private String departName;
    private String destName;
    private Double dlat;
    private Double dlng;
    private Double slat;
    private Double slng;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MapTakeTaxiParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            Intrinsics.checkNotNullParameter(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            Double r6 = null;
        L7:
            if (r12.readInt() != 0) goto L9;
            Double r7 = null;
        L11:
            if (r12.readInt() != 0) goto L13;
            Double r8 = null;
        L15:
            if (r12.readInt() != 0) goto L17;
            Double r9 = null;
        L18:
            MapTakeTaxiParams r1 = new MapTakeTaxiParams(r3, r4, r6, r7, r8, r9);
            int r2 = Math.min(r0, 0);
            ClassLoader r11 = getClass().getClassLoader();
            int r5 = 1;
        L19:
            if (r5 > r2) goto L21;
            r5 = r5 + 1;
        L21:
            if (r5 > r0) goto L23;
            a.a(r12, r11);
            r5 = r5 + 1;
            goto L21
        L23:
            return r1;
        L17:
            r9 = Double.valueOf(r12.readDouble());
            goto L18
        L13:
            r8 = Double.valueOf(r12.readDouble());
            goto L15
        L9:
            r7 = Double.valueOf(r12.readDouble());
            goto L11
        L5:
            r6 = Double.valueOf(r12.readDouble());
            goto L7
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MapTakeTaxiParams[] newArray(int r1) {
            return new MapTakeTaxiParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MapTakeTaxiParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public MapTakeTaxiParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public MapTakeTaxiParams(String r1, String r2, Double r3, Double r4, Double r5, Double r6) {
        this.departName = r1;
        this.destName = r2;
        this.slat = r3;
        this.slng = r4;
        this.dlat = r5;
        this.dlng = r6;
    }

    public /* synthetic */ MapTakeTaxiParams(String r2, String r3, Double r4, Double r5, Double r6, Double r7, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r8 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r8 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r8 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r8 & 16) == 0) goto L18;
        r6 = null;
    L18:
        if ((r8 & 32) == 0) goto L20;
        r7 = null;
    L20:
        this(r2, r3, r4, r5, r6, r7);
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

    public final MapTakeTaxiParams copy(String r8, String r9, Double r10, Double r11, Double r12, Double r13) {
        return new MapTakeTaxiParams(r8, r9, r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MapTakeTaxiParams.class) == true) goto L8;
        return false;
    L8:
        MapTakeTaxiParams r6 = (MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r5, MapTakeTaxiParams.class, "com.obric.memorydata.plugin");
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
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

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r11) {
        if (ZeusTransformUtils.instanceOf(r11, MapTakeTaxiParams.class) == false) goto L5;
        String r1 = this.departName;
        if (r1 != null) goto L9;
        r1 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).departName;
    L9:
        String r4 = r1;
        String r2 = this.destName;
        if (r2 != null) goto L12;
        r2 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).destName;
    L12:
        String r5 = r2;
        Double r3 = this.slat;
        if (r3 != null) goto L15;
        r3 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).slat;
    L15:
        Double r6 = r3;
        Double r7 = this.slng;
        if (r7 != null) goto L18;
        r7 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).slng;
    L18:
        Double r8 = r7;
        Double r9 = this.dlat;
        if (r9 != null) goto L21;
        r9 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).dlat;
    L21:
        Double r10 = r9;
        Double r12 = this.dlng;
        if (r12 != null) goto L24;
        r12 = ((MapTakeTaxiParams) ZeusTransformUtils.preCheckCast(r11, MapTakeTaxiParams.class, "com.obric.memorydata.plugin")).dlng;
    L24:
        MapTakeTaxiParams this = new MapTakeTaxiParams(r4, r5, r6, r8, r10, r12);
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
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
        Double r4 = this.dlng;
        if (r4 != null) goto L17;
        r5.writeInt(0);
        return;
    L17:
        r5.writeInt(1);
        r5.writeDouble(r4.doubleValue());
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
}
