package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
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
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0001.B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005Bi\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020&0%H\u0016J\"\u0010'\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010)\u001a\u0004\u0018\u00010*2\u0006\u0010+\u001a\u00020\fH\u0016J\u0018\u0010,\u001a\u00020(2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\fH\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0015\"\u0004\b\u001f\u0010\u0017R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006/"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "storeName", "appName", "appPkgName", "address", "storeType", "city", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "getAppName", "setAppName", "getAppPkgName", "setAppPkgName", "getCity", "setCity", "getStoreName", "setStoreName", "getStoreType", "setStoreType", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CollectStoreMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 0;
    private String address;
    private String appName;
    private String appPkgName;
    private String city;
    private String storeName;
    private String storeType;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CollectStoreMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<CollectStoreMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectStoreMemoryEntity");
            return (CollectStoreMemoryEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 1;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectStoreMemoryEntity[] newArray(int r1) {
            return new CollectStoreMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectStoreMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectStoreMemoryEntity(Parcel r18) {
        Intrinsics.checkNotNullParameter(r18, "parcel");
        this(EntityExtKt.e(r18), r18.readLong(), r18.readLong(), r18.readInt(), EntityExtKt.e(r18), r18.readString(), r18.readString(), r18.readString(), r18.readString(), null, ISmModel.VERSION_0200, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 1, r18.readInt());
    }

    public CollectStoreMemoryEntity(String r11, long r12, long r14, int r16, String r17, String r18, String r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r17, "storeName");
        super(r11, r12, r14, EntityType.MEMORY_COLLECT_STORE, r16);
        this.storeName = r17;
        this.appName = r18;
        this.appPkgName = r19;
        this.address = r20;
        this.storeType = r21;
        this.city = r22;
    }

    public /* synthetic */ CollectStoreMemoryEntity(String r17, long r18, long r20, int r22, String r23, String r24, String r25, String r26, String r27, String r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 32) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r29 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r29 & 128) == 0) goto L13;
        String r13 = null;
    L15:
        if ((r29 & ISmModel.VERSION_0100) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r29 & ISmModel.VERSION_0200) == 0) goto L21;
        String r15 = null;
    L22:
        this(r17, r18, r20, r22, r23, r11, r12, r13, r14, r15);
        return;
    L21:
        r15 = r28;
        goto L22
    L17:
        r14 = r27;
        goto L19
    L13:
        r13 = r26;
        goto L15
    L9:
        r12 = r25;
        goto L11
    L5:
        r11 = r24;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("storeName", makeModelInputValue("店铺名称", this.storeName));
        String r1 = this.appName;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("appName", makeModelInputValue("店铺平台", r1));
    L5:
        String r2 = this.address;
        if (r2 == null) goto L8;
        Intrinsics.checkNotNull(r2);
        r0.put("address", makeModelInputValue("店铺地址", r2));
    L8:
        String r3 = this.storeType;
        if (r3 == null) goto L11;
        Intrinsics.checkNotNull(r3);
        r0.put("storeType", makeModelInputValue("店铺类型", r3));
    L11:
        String r4 = this.city;
        if (r4 == null) goto L14;
        Intrinsics.checkNotNull(r4);
        r0.put("city", makeModelInputValue("店铺城市", r4));
    L14:
        return r0;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPkgName() {
        return this.appPkgName;
    }

    public final String getCity() {
        return this.city;
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

    public final String getStoreName() {
        return this.storeName;
    }

    public final String getStoreType() {
        return this.storeType;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.city = (String) r2.readValue(r3);
        return;
    }

    public final void setAddress(String r1) {
        this.address = r1;
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppPkgName(String r1) {
        this.appPkgName = r1;
    }

    public final void setCity(String r1) {
        this.city = r1;
    }

    public final void setStoreName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.storeName = r2;
    }

    public final void setStoreType(String r1) {
        this.storeType = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.storeName);
        r2.writeString(this.appName);
        r2.writeString(this.appPkgName);
        r2.writeString(this.address);
        r2.writeString(this.storeType);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(1);
        r2.writeValue(this.city);
    }
}
