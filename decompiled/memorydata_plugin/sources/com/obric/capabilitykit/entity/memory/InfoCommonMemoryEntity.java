package com.obric.capabilitykit.entity.memory;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.EntityType;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 +2\u00020\u00012\u00020\u0002:\u0002+,B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BY\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012J\b\u0010\u001f\u001a\u00020 H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\"\u0010$\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\fH\u0016J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010*\u001a\u00020\fH\u0016R\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0014\"\u0004\b\u0018\u0010\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0014\"\u0004\b\u001c\u0010\u0016R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0014\"\u0004\b\u001e\u0010\u0016¨\u0006-"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "modifyTime", "productType", "", "infoKey", "infoValue", "observation", "relatedMemoryids", LocationMonitorConst.TAG, "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getInfoKey", "()Ljava/lang/String;", "setInfoKey", "(Ljava/lang/String;)V", "getInfoValue", "setInfoValue", "getObservation", "setObservation", "getRelatedMemoryids", "setRelatedMemoryids", "getTag", "setTag", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "InfoKeyType", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InfoCommonMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 0;
    private String infoKey;
    private String infoValue;
    private String observation;
    private String relatedMemoryids;
    private String tag;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<InfoCommonMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity");
            return (InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r1, InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InfoCommonMemoryEntity[] newArray(int r1) {
            return new InfoCommonMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ InfoCommonMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/InfoCommonMemoryEntity$InfoKeyType;", "", "()V", "ADDRESS", "", "ANNIVERSARY", "IDENTIFICATION", "RELATIONSHIP", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class InfoKeyType {
        public static final String ADDRESS = "地址";
        public static final String ANNIVERSARY = "纪念日";
        public static final String IDENTIFICATION = "证件";
        public static final InfoKeyType INSTANCE = null;
        public static final String RELATIONSHIP = "关系";

        static {
            INSTANCE = new InfoKeyType();
        }

        private InfoKeyType() {
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public InfoCommonMemoryEntity(Parcel r17) {
        Intrinsics.checkNotNullParameter(r17, "parcel");
        this(EntityExtKt.readStringOrEmpty(r17), r17.readLong(), r17.readLong(), r17.readInt(), EntityExtKt.readStringOrEmpty(r17), EntityExtKt.readStringOrEmpty(r17), null, null, null, BDVideoUploaderBase.KeyIsDynamicSliceLowSize, null);
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 3, r17.readInt());
    }

    public InfoCommonMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, String r21, String r22) {
        Intrinsics.checkNotNullParameter(r12, OaidModel.KEY_ID);
        Intrinsics.checkNotNullParameter(r18, "infoKey");
        Intrinsics.checkNotNullParameter(r19, "infoValue");
        super(r12, r13, r15, EntityType.MEMORY_INFO_COMMON, r17);
        this.infoKey = r18;
        this.infoValue = r19;
        this.observation = r20;
        this.relatedMemoryids = r21;
        this.tag = r22;
    }

    public /* synthetic */ InfoCommonMemoryEntity(String r16, long r17, long r19, int r21, String r22, String r23, String r24, String r25, String r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 64) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r27 & 128) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r27 & 256) == 0) goto L13;
        String r14 = null;
    L14:
        this(r16, r17, r19, r21, r22, r23, r12, r13, r14);
        return;
    L13:
        r14 = r26;
        goto L14
    L9:
        r13 = r25;
        goto L11
    L5:
        r12 = r24;
        goto L7
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity
    public JSONObject convertToModelInput() {
        JSONObject r0 = new JSONObject();
        r0.put("type", getType());
        r0.put("createTime", getCreateTime());
        r0.put("modifyTime", getLastModifiedTime());
        r0.put("ecaId", getEcaId());
        r0.put("infoKey", makeModelInputValue("信息类型", this.infoKey));
        r0.put("infoValue", makeModelInputValue("信息内容", this.infoValue));
        return r0;
    }

    public final String getInfoKey() {
        return this.infoKey;
    }

    public final String getInfoValue() {
        return this.infoValue;
    }

    public final String getObservation() {
        return this.observation;
    }

    public final String getRelatedMemoryids() {
        return this.relatedMemoryids;
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

    public final String getTag() {
        return this.tag;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        if (r5 != 1) goto L5;
        this.observation = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.memorydata.plugin");
        return;
    L5:
        if (r5 != 2) goto L7;
        this.relatedMemoryids = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.memorydata.plugin");
        return;
    L7:
        if (r5 != 3) goto L15;
        this.tag = (String) ZeusTransformUtils.preCheckCast(r3.readValue(r4), String.class, "com.obric.memorydata.plugin");
        return;
    }

    public final void setInfoKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.infoKey = r2;
    }

    public final void setInfoValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.infoValue = r2;
    }

    public final void setObservation(String r1) {
        this.observation = r1;
    }

    public final void setRelatedMemoryids(String r1) {
        this.relatedMemoryids = r1;
    }

    public final void setTag(String r1) {
        this.tag = r1;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.infoKey);
        r2.writeString(this.infoValue);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(3);
        r2.writeValue(this.observation);
        r2.writeValue(this.relatedMemoryids);
        r2.writeValue(this.tag);
    }
}
