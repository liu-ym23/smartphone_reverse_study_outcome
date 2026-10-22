package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u008b\u0001\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016¢\u0006\u0002\u0010\u0017J\b\u0010.\u001a\u00020/H\u0016J\u000e\u00100\u001a\b\u0012\u0004\u0012\u0002010\u0016H\u0016J\"\u00102\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\b\u00104\u001a\u0004\u0018\u0001052\u0006\u00106\u001a\u00020\fH\u0016J\u0018\u00107\u001a\u0002032\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u00020\fH\u0016R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0019\"\u0004\b#\u0010\u001bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\u001bR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0019\"\u0004\b'\u0010\u001bR\"\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0019\"\u0004\b-\u0010\u001b¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "productType", "", ActivityLifecycle.NAME, "date", "startTime", "endTime", "city", "auditoriumName", "auditoriumAddress", "hallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAuditoriumAddress", "()Ljava/lang/String;", "setAuditoriumAddress", "(Ljava/lang/String;)V", "getAuditoriumName", "setAuditoriumName", "getCity", "setCity", "getDate", "setDate", "getEndTime", "setEndTime", "getHallNumber", "setHallNumber", "getName", "setName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class OrderTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String auditoriumAddress;
    private String auditoriumName;
    private String city;
    private String date;
    private String endTime;
    private String hallNumber;
    private String name;
    private List<String> seatNumber;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<OrderTicketMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTicketMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderTicketMemoryEntity");
            return (OrderTicketMemoryEntity) ZeusTransformUtils.preCheckCast(r1, OrderTicketMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderTicketMemoryEntity[] newArray(int r1) {
            return new OrderTicketMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderTicketMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderTicketMemoryEntity(Parcel r19) {
        Intrinsics.checkNotNullParameter(r19, "parcel");
        this(EntityExtKt.readStringOrEmpty(r19), r19.readLong(), r19.readLong(), r19.readInt(), EntityExtKt.readStringOrEmpty(r19), EntityExtKt.readStringOrEmpty(r19), EntityExtKt.readStringOrEmpty(r19), r19.readString(), r19.readString(), r19.readString(), r19.readString(), r19.readString(), r19.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 0, r19.readInt());
    }

    public OrderTicketMemoryEntity(String r14, long r15, long r17, int r19, String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, List<String> r28) {
        List<String> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r28, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r14, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r20, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r21, "date");
        Intrinsics.checkNotNullParameter(r22, "startTime");
        super(r14, r15, r17, 10006, r19);
        this.name = r20;
        this.date = r21;
        this.startTime = r22;
        this.endTime = r23;
        this.city = r24;
        this.auditoriumName = r25;
        this.auditoriumAddress = r26;
        this.hallNumber = r27;
        this.seatNumber = r12;
    }

    public /* synthetic */ OrderTicketMemoryEntity(String r21, long r22, long r24, int r26, String r27, String r28, String r29, String r30, String r31, String r32, String r33, String r34, List r35, int r36, DefaultConstructorMarker r37) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r35, List.class, "com.obric.memorydata.plugin");
        if ((r36 & 128) == 0) goto L5;
        String r14 = null;
    L7:
        if ((r36 & 256) == 0) goto L9;
        String r15 = null;
    L11:
        if ((r36 & 512) == 0) goto L13;
        String r16 = null;
    L15:
        if ((r36 & 1024) == 0) goto L17;
        String r17 = null;
    L19:
        if ((r36 & 2048) == 0) goto L21;
        String r18 = null;
    L23:
        if ((r36 & 4096) == 0) goto L25;
        List r19 = null;
    L26:
        this(r21, r22, r24, r26, r27, r28, r29, r14, r15, r16, r17, r18, r19);
        return;
    L25:
        r19 = r1;
        goto L26
    L21:
        r18 = r34;
        goto L23
    L17:
        r17 = r33;
        goto L19
    L13:
        r16 = r32;
        goto L15
    L9:
        r15 = r31;
        goto L11
    L5:
        r14 = r30;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put(ActivityLifecycle.NAME, makeModelInputValue("名称", this.name));
        r0.put("date", makeModelInputValue("日期", this.date));
        r0.put("startTime", makeModelInputValue("开始时间", this.startTime));
        String r1 = this.endTime;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("endTime", makeModelInputValue("结束时间", r1));
    L5:
        String r2 = this.city;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("city", makeModelInputValue("城市", r2));
    L8:
        String r3 = this.auditoriumName;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("auditoriumName", makeModelInputValue("影院/演出厅名称", r3));
    L11:
        String r4 = this.auditoriumAddress;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("auditoriumAddress", makeModelInputValue("具体地址", r4));
    L14:
        String r5 = this.hallNumber;
        if (r5 == null) goto L17;
        Intrinsics.checkNotNull(r5);
        r0.put("hallNumber", makeModelInputValue("厅号", r5));
    L17:
        List<String> r6 = this.seatNumber;
        if (r6 == null) goto L20;
        r0.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r6)));
    L20:
        return r0;
    }

    public final String getAuditoriumAddress() {
        return this.auditoriumAddress;
    }

    public final String getAuditoriumName() {
        return this.auditoriumName;
    }

    public final String getCity() {
        return this.city;
    }

    public final String getDate() {
        return this.date;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getHallNumber() {
        return this.hallNumber;
    }

    public final String getName() {
        return this.name;
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

    public final String getStartTime() {
        return this.startTime;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setAuditoriumAddress(String r1) {
        this.auditoriumAddress = r1;
    }

    public final void setAuditoriumName(String r1) {
        this.auditoriumName = r1;
    }

    public final void setCity(String r1) {
        this.city = r1;
    }

    public final void setDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.date = r2;
    }

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setHallNumber(String r1) {
        this.hallNumber = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setSeatNumber(List<String> r3) {
        this.seatNumber = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setStartTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeString(this.date);
        r2.writeString(this.startTime);
        r2.writeString(this.endTime);
        r2.writeString(this.city);
        r2.writeString(this.auditoriumName);
        r2.writeString(this.auditoriumAddress);
        r2.writeString(this.hallNumber);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
