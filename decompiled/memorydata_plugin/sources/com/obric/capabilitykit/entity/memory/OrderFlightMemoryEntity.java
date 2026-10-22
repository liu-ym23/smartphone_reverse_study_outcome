package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 B2\u00020\u00012\u00020\u0002:\u0001BB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B©\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\u0006\u0010\u0010\u001a\u00020\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018\u0012\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018¢\u0006\u0002\u0010\u001aJ\b\u00107\u001a\u000208H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u00020:0\u0018H\u0016J\"\u0010;\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010?\u001a\u00020\fH\u0016J\u0018\u0010@\u001a\u00020<2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010A\u001a\u00020\fH\u0016R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001c\"\u0004\b \u0010\u001eR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001c\"\u0004\b\"\u0010\u001eR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u001c\"\u0004\b$\u0010\u001eR\u001a\u0010\u0010\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u001c\"\u0004\b&\u0010\u001eR\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\u001a\u0010\u0012\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001c\"\u0004\b*\u0010\u001eR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001c\"\u0004\b,\u0010\u001eR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001eR\u001a\u0010\u0011\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001c\"\u0004\b0\u0010\u001eR\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00102\"\u0004\b6\u00104¨\u0006C"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "productType", "", "departureDate", "departurePlace", "destination", "departureTime", "landingTime", "flightNumber", "landingDate", "departureAirport", "landingAirport", "boardingGate", "passengerName", "", "seatNumber", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "getBoardingGate", "()Ljava/lang/String;", "setBoardingGate", "(Ljava/lang/String;)V", "getDepartureAirport", "setDepartureAirport", "getDepartureDate", "setDepartureDate", "getDeparturePlace", "setDeparturePlace", "getDepartureTime", "setDepartureTime", "getDestination", "setDestination", "getFlightNumber", "setFlightNumber", "getLandingAirport", "setLandingAirport", "getLandingDate", "setLandingDate", "getLandingTime", "setLandingTime", "getPassengerName", "()Ljava/util/List;", "setPassengerName", "(Ljava/util/List;)V", "getSeatNumber", "setSeatNumber", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderFlightMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String boardingGate;
    private String departureAirport;
    private String departureDate;
    private String departurePlace;
    private String departureTime;
    private String destination;
    private String flightNumber;
    private String landingAirport;
    private String landingDate;
    private String landingTime;
    private List<String> passengerName;
    private List<String> seatNumber;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderFlightMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderFlightMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderFlightMemoryEntity");
            return (OrderFlightMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderFlightMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderFlightMemoryEntity[] newArray(int r1) {
            return new OrderFlightMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderFlightMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderFlightMemoryEntity(Parcel r21) {
        Intrinsics.checkNotNullParameter(r21, "parcel");
        this(EntityExtKt.readStringOrEmpty(r21), r21.readLong(), r21.readLong(), r21.readInt(), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), EntityExtKt.readStringOrEmpty(r21), r21.readString(), r21.readString(), r21.readString(), r21.readString(), r21.createStringArrayList(), r21.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r21);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r21, 0, r21.readInt());
    }

    public OrderFlightMemoryEntity(String r18, long r19, long r21, int r23, String r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, List<String> r34, List<String> r35) {
        List<String> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r34, List.class, "com.obric.memorydata.plugin");
        List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r18, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r24, "departureDate");
        Intrinsics.checkNotNullParameter(r25, "departurePlace");
        Intrinsics.checkNotNullParameter(r26, "destination");
        Intrinsics.checkNotNullParameter(r27, "departureTime");
        Intrinsics.checkNotNullParameter(r28, "landingTime");
        Intrinsics.checkNotNullParameter(r29, "flightNumber");
        super(r18, r19, r21, 10001, r23);
        this.departureDate = r24;
        this.departurePlace = r25;
        this.destination = r26;
        this.departureTime = r27;
        this.landingTime = r28;
        this.flightNumber = r29;
        this.landingDate = r30;
        this.departureAirport = r31;
        this.landingAirport = r32;
        this.boardingGate = r33;
        this.passengerName = r15;
        this.seatNumber = r7;
    }

    public /* synthetic */ OrderFlightMemoryEntity(String r25, long r26, long r28, int r30, String r31, String r32, String r33, String r34, String r35, String r36, String r37, String r38, String r39, String r40, List r41, List r42, int r43, DefaultConstructorMarker r44) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r41, List.class, "com.obric.memorydata.plugin");
        List r2 = (List) ZeusTransformUtils.wrapperContextForParams(r42, List.class, "com.obric.memorydata.plugin");
        if ((r43 & 1024) == 0) goto L5;
        String r18 = null;
    L7:
        if ((r43 & 2048) == 0) goto L9;
        String r19 = null;
    L11:
        if ((r43 & 4096) == 0) goto L13;
        String r20 = null;
    L15:
        if ((r43 & 8192) == 0) goto L17;
        String r21 = null;
    L19:
        if ((r43 & 16384) == 0) goto L21;
        List r22 = null;
    L23:
        if ((r43 & 32768) == 0) goto L25;
        List r23 = null;
    L26:
        this(r25, r26, r28, r30, r31, r32, r33, r34, r35, r36, r18, r19, r20, r21, r22, r23);
        return;
    L25:
        r23 = r2;
        goto L26
    L21:
        r22 = r1;
        goto L23
    L17:
        r21 = r40;
        goto L19
    L13:
        r20 = r39;
        goto L15
    L9:
        r19 = r38;
        goto L11
    L5:
        r18 = r37;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("departureDate", makeModelInputValue("出发日期", this.departureDate));
        r0.put("departurePlace", makeModelInputValue("出发地", this.departurePlace));
        r0.put("destination", makeModelInputValue("目的地", this.destination));
        r0.put("departureTime", makeModelInputValue("起飞时间", this.departureTime));
        r0.put("landingTime", makeModelInputValue("落地时间", this.landingTime));
        r0.put("flightNumber", makeModelInputValue("航班号", this.flightNumber));
        String r1 = this.landingDate;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("landingDate", makeModelInputValue("落地日期", r1));
    L5:
        String r2 = this.departureAirport;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("departureAirport", makeModelInputValue("起飞机场", r2));
    L8:
        String r3 = this.landingAirport;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("landingAirport", makeModelInputValue("落地机场", r3));
    L11:
        String r4 = this.boardingGate;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("boardingGate", makeModelInputValue("登机口", r4));
    L14:
        List<String> r5 = this.passengerName;
        if (r5 == null) goto L17;
        r0.put("passengerName", makeModelInputValue("乘客名", String.valueOf(r5)));
    L17:
        List<String> r6 = this.seatNumber;
        if (r6 == null) goto L20;
        r0.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r6)));
    L20:
        return r0;
    }

    public final String getBoardingGate() {
        return this.boardingGate;
    }

    public final String getDepartureAirport() {
        return this.departureAirport;
    }

    public final String getDepartureDate() {
        return this.departureDate;
    }

    public final String getDeparturePlace() {
        return this.departurePlace;
    }

    public final String getDepartureTime() {
        return this.departureTime;
    }

    public final String getDestination() {
        return this.destination;
    }

    public final String getFlightNumber() {
        return this.flightNumber;
    }

    public final String getLandingAirport() {
        return this.landingAirport;
    }

    public final String getLandingDate() {
        return this.landingDate;
    }

    public final String getLandingTime() {
        return this.landingTime;
    }

    public final List<String> getPassengerName() {
        return this.passengerName;
    }

    public final List<String> getSeatNumber() {
        return this.seatNumber;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        FileEntity r0 = getScreenshot();
        if (r0 == null) goto L7;
        List<Uri> r1 = r0.getSharedUris();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setBoardingGate(String r1) {
        this.boardingGate = r1;
    }

    public final void setDepartureAirport(String r1) {
        this.departureAirport = r1;
    }

    public final void setDepartureDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departureDate = r2;
    }

    public final void setDeparturePlace(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departurePlace = r2;
    }

    public final void setDepartureTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.departureTime = r2;
    }

    public final void setDestination(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.destination = r2;
    }

    public final void setFlightNumber(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.flightNumber = r2;
    }

    public final void setLandingAirport(String r1) {
        this.landingAirport = r1;
    }

    public final void setLandingDate(String r1) {
        this.landingDate = r1;
    }

    public final void setLandingTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.landingTime = r2;
    }

    public final void setPassengerName(List<String> r3) {
        this.passengerName = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setSeatNumber(List<String> r3) {
        this.seatNumber = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.departureDate);
        r2.writeString(this.departurePlace);
        r2.writeString(this.destination);
        r2.writeString(this.departureTime);
        r2.writeString(this.landingTime);
        r2.writeString(this.flightNumber);
        r2.writeString(this.landingDate);
        r2.writeString(this.departureAirport);
        r2.writeString(this.landingAirport);
        r2.writeString(this.boardingGate);
        r2.writeStringList(this.passengerName);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
