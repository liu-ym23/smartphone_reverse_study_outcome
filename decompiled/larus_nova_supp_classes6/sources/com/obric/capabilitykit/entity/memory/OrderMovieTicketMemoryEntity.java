package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.data.ISmModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u007f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015¢\u0006\u0002\u0010\u0016J\b\u0010+\u001a\u00020,H\u0016J\u000e\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0015H\u0016J\"\u0010/\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\b\u00101\u001a\u0004\u0018\u0001022\u0006\u00103\u001a\u00020\fH\u0016J\u0018\u00104\u001a\u0002002\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00105\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0018\"\u0004\b\"\u0010\u001aR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0018\"\u0004\b$\u0010\u001aR\"\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\u000f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0018\"\u0004\b*\u0010\u001a¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "movieName", "movieDate", "startTime", "endTime", "movieTheaterName", "movieTheaterAddress", "movieHallNumber", "seatNumber", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getEndTime", "()Ljava/lang/String;", "setEndTime", "(Ljava/lang/String;)V", "getMovieDate", "setMovieDate", "getMovieHallNumber", "setMovieHallNumber", "getMovieName", "setMovieName", "getMovieTheaterAddress", "setMovieTheaterAddress", "getMovieTheaterName", "setMovieTheaterName", "getSeatNumber", "()Ljava/util/List;", "setSeatNumber", "(Ljava/util/List;)V", "getStartTime", "setStartTime", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class OrderMovieTicketMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String endTime;
    private String movieDate;
    private String movieHallNumber;
    private String movieName;
    private String movieTheaterAddress;
    private String movieTheaterName;
    private List<String> seatNumber;
    private String startTime;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/OrderMovieTicketMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<OrderMovieTicketMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.OrderMovieTicketMemoryEntity");
            return (OrderMovieTicketMemoryEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public OrderMovieTicketMemoryEntity[] newArray(int r1) {
            return new OrderMovieTicketMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OrderMovieTicketMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public OrderMovieTicketMemoryEntity(Parcel r18) {
        Intrinsics.checkNotNullParameter(r18, "parcel");
        this(EntityExtKt.e(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.e(r18), EntityExtKt.e(r18), EntityExtKt.e(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), r18.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 0, r18.readInt());
    }

    public OrderMovieTicketMemoryEntity(String r13, long r14, long r16, int r18, String r19, String r20, String r21, String r22, String r23, String r24, String r25, List<String> r26) {
        Intrinsics.checkNotNullParameter(r13, "id");
        Intrinsics.checkNotNullParameter(r19, "movieName");
        Intrinsics.checkNotNullParameter(r20, "movieDate");
        Intrinsics.checkNotNullParameter(r21, "startTime");
        super(r13, r14, r16, 10003, r18);
        this.movieName = r19;
        this.movieDate = r20;
        this.startTime = r21;
        this.endTime = r22;
        this.movieTheaterName = r23;
        this.movieTheaterAddress = r24;
        this.movieHallNumber = r25;
        this.seatNumber = r26;
    }

    public /* synthetic */ OrderMovieTicketMemoryEntity(String r19, long r20, long r22, int r24, String r25, String r26, String r27, String r28, String r29, String r30, String r31, List r32, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 128) == 0) goto L5;
        String r13 = null;
    L7:
        if ((r33 & ISmModel.VERSION_0100) == 0) goto L9;
        String r14 = null;
    L11:
        if ((r33 & ISmModel.VERSION_0200) == 0) goto L13;
        String r15 = null;
    L15:
        if ((r33 & ISmModel.VERSION_0400) == 0) goto L17;
        String r16 = null;
    L19:
        if ((r33 & 2048) == 0) goto L21;
        List r17 = null;
    L22:
        this(r19, r20, r22, r24, r25, r26, r27, r13, r14, r15, r16, r17);
        return;
    L21:
        r17 = r32;
        goto L22
    L17:
        r16 = r31;
        goto L19
    L13:
        r15 = r30;
        goto L15
    L9:
        r14 = r29;
        goto L11
    L5:
        r13 = r28;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("movieName", makeModelInputValue("电影名称", this.movieName));
        r0.put("movieDate", makeModelInputValue("观影日期", this.movieDate));
        r0.put("startTime", makeModelInputValue("开场时间", this.startTime));
        String r1 = this.endTime;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("endTime", makeModelInputValue("结束时间", r1));
    L5:
        String r2 = this.movieTheaterName;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("movieTheaterName", makeModelInputValue("电影院名称", r2));
    L8:
        String r3 = this.movieTheaterAddress;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("movieTheaterAddress", makeModelInputValue("电影院地址", r3));
    L11:
        String r4 = this.movieHallNumber;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("movieHallNumber", makeModelInputValue("电影厅号", r4));
    L14:
        List<String> r5 = this.seatNumber;
        if (r5 == null) goto L17;
        r0.put("seatNumber", makeModelInputValue("座位号", String.valueOf(r5)));
    L17:
        return r0;
    }

    public final String getEndTime() {
        return this.endTime;
    }

    public final String getMovieDate() {
        return this.movieDate;
    }

    public final String getMovieHallNumber() {
        return this.movieHallNumber;
    }

    public final String getMovieName() {
        return this.movieName;
    }

    public final String getMovieTheaterAddress() {
        return this.movieTheaterAddress;
    }

    public final String getMovieTheaterName() {
        return this.movieTheaterName;
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

    public final void setEndTime(String r1) {
        this.endTime = r1;
    }

    public final void setMovieDate(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.movieDate = r2;
    }

    public final void setMovieHallNumber(String r1) {
        this.movieHallNumber = r1;
    }

    public final void setMovieName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.movieName = r2;
    }

    public final void setMovieTheaterAddress(String r1) {
        this.movieTheaterAddress = r1;
    }

    public final void setMovieTheaterName(String r1) {
        this.movieTheaterName = r1;
    }

    public final void setSeatNumber(List<String> r1) {
        this.seatNumber = r1;
    }

    public final void setStartTime(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.startTime = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.movieName);
        r2.writeString(this.movieDate);
        r2.writeString(this.startTime);
        r2.writeString(this.endTime);
        r2.writeString(this.movieTheaterName);
        r2.writeString(this.movieTheaterAddress);
        r2.writeString(this.movieHallNumber);
        r2.writeStringList(this.seatNumber);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
