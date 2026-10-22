package com.obric.memorydata.intelligence.datalearning.profile.commute;

import com.bytedance.crash.entity.EventBody;
import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0004J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\u000e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/commute/MidProfileCommuteType;", "", "bluetoothMac", "", "", "speed", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getBluetoothMac", "()Ljava/util/List;", "getSpeed", "toJson", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MidProfileCommuteType {
    public static final a Companion = null;

    @SerializedName("bluetooth_mac")
    private final List<String> bluetoothMac;
    private final List<String> speed;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/intelligence/datalearning/profile/commute/MidProfileCommuteType$Companion;", "", "<init>", "()V", "fromJson", "Lcom/obric/memorydata/intelligence/datalearning/profile/commute/MidProfileCommuteType;", EventBody.KEY_VALUE, "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MidProfileCommuteType(List<String> r3, List<String> r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "bluetoothMac");
        Intrinsics.checkNotNullParameter(r6, "speed");
        this.bluetoothMac = r5;
        this.speed = r6;
    }

    public static /* synthetic */ MidProfileCommuteType copy$default(MidProfileCommuteType r1, List r2, List r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.bluetoothMac;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r7 = r1.speed;
    L9:
        return r1.copy(r6, r7);
    }

    public final List<String> component1() {
        return this.bluetoothMac;
    }

    public final List<String> component2() {
        return this.speed;
    }

    public final MidProfileCommuteType copy(List<String> r2, List<String> r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        List r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "bluetoothMac");
        Intrinsics.checkNotNullParameter(r4, "speed");
        return new MidProfileCommuteType(r1, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MidProfileCommuteType.class) == true) goto L8;
        return false;
    L8:
        MidProfileCommuteType r6 = (MidProfileCommuteType) ZeusTransformUtils.preCheckCast(r5, MidProfileCommuteType.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.bluetoothMac, r6.bluetoothMac) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.speed, r6.speed) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final List<String> getBluetoothMac() {
        return this.bluetoothMac;
    }

    public final List<String> getSpeed() {
        return this.speed;
    }

    public int hashCode() {
        return (this.bluetoothMac.hashCode() * 31) + this.speed.hashCode();
    }

    public final String toJson() {
        String r1 = new Gson().toJson(this);
        Intrinsics.checkNotNullExpressionValue(r1, "toJson(...)");
        return r1;
    }

    public String toString() {
        return "MidProfileCommuteType(bluetoothMac=" + this.bluetoothMac + ", speed=" + this.speed + ')';
    }
}
