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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u00012\u00020\u0002:\u0001-B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B_\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\b\u0010\"\u001a\u00020#H\u0016J\u000e\u0010$\u001a\b\u0012\u0004\u0012\u00020%0\u0012H\u0016J\"\u0010&\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\fH\u0016J\u0018\u0010+\u001a\u00020'2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\fH\u0016R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\u000e\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\"\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\r\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\u0017¨\u0006."}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "productType", "", "title", "summary", "appName", "appPkgName", "tags", "", "(Ljava/lang/String;JJILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppPkgName", "setAppPkgName", "getSummary", "setSummary", "getTags", "()Ljava/util/List;", "setTags", "(Ljava/util/List;)V", "getTitle", "setTitle", "convertToModelInput", "Lorg/json/JSONObject;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class CollectContentMemoryEntity extends MemoryEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private String appName;
    private String appPkgName;
    private String summary;
    private List<String> tags;
    private String title;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/CollectContentMemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<CollectContentMemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectContentMemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.CollectContentMemoryEntity");
            return (CollectContentMemoryEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CollectContentMemoryEntity[] newArray(int r1) {
            return new CollectContentMemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CollectContentMemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CollectContentMemoryEntity(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        this(EntityExtKt.e(r14), r14.readLong(), r14.readLong(), r14.readInt(), EntityExtKt.e(r14), EntityExtKt.e(r14), r14.readString(), r14.readString(), r14.createStringArrayList());
        readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public CollectContentMemoryEntity(String r12, long r13, long r15, int r17, String r18, String r19, String r20, String r21, List<String> r22) {
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r18, "title");
        Intrinsics.checkNotNullParameter(r19, "summary");
        super(r12, r13, r15, EntityType.MEMORY_COLLECT_CONTENT, r17);
        this.title = r18;
        this.summary = r19;
        this.appName = r20;
        this.appPkgName = r21;
        this.tags = r22;
    }

    public /* synthetic */ CollectContentMemoryEntity(String r16, long r17, long r19, int r21, String r22, String r23, String r24, String r25, List r26, int r27, DefaultConstructorMarker r28) {
        if ((r27 & 64) == 0) goto L5;
        String r12 = null;
    L7:
        if ((r27 & 128) == 0) goto L9;
        String r13 = null;
    L11:
        if ((r27 & ISmModel.VERSION_0100) == 0) goto L13;
        List r14 = null;
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
        r0.put("title", makeModelInputValue("内容标题", this.title));
        r0.put("summary", makeModelInputValue("摘要", this.summary));
        String r1 = this.appName;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.put("appName", makeModelInputValue("内容平台", r1));
    L5:
        List<String> r2 = this.tags;
        if (r2 == null) goto L8;
        r0.put("tags", makeModelInputValue("标签", String.valueOf(r2)));
    L8:
        return r0;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppPkgName() {
        return this.appPkgName;
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

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final String getTitle() {
        return this.title;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppPkgName(String r1) {
        this.appPkgName = r1;
    }

    public final void setSummary(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.summary = r2;
    }

    public final void setTags(List<String> r1) {
        this.tags = r1;
    }

    public final void setTitle(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.title = r2;
    }

    @Override // com.obric.capabilitykit.entity.memory.MemoryEntity, com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeMemoryBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.title);
        r2.writeString(this.summary);
        r2.writeString(this.appName);
        r2.writeString(this.appPkgName);
        r2.writeStringList(this.tags);
        writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(r2, r3);
        r2.writeInt(0);
    }
}
