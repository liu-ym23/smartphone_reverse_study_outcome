package com.obric.capabilitykit.entity.memory;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.FileEntity;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b'\u0018\u0000 R2\u00020\u0001:\u0001RB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B-\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\b\u0010D\u001a\u00020EH&J\u0018\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u00062\u0006\u0010H\u001a\u00020\u0006H\u0004J\u0015\u0010I\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bKJ\u0015\u0010L\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bMJ\u001d\u0010N\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u000bH\u0000¢\u0006\u0002\bPJ\u0018\u0010Q\u001a\u00020J2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010O\u001a\u00020\u000bH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0016\"\u0004\b#\u0010\u0018R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010&\u001a\u0004\u0018\u00010'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010,\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010\u0018R\u001c\u0010/\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0016\"\u0004\b1\u0010\u0018R\u001c\u00102\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0016\"\u0004\b4\u0010\u0018R\u001c\u00105\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018R\u001c\u00108\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u0016\"\u0004\b:\u0010\u0018R\u001c\u0010;\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0016\"\u0004\b=\u0010\u0018R\u001a\u0010>\u001a\u00020?X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010A\"\u0004\bB\u0010C¨\u0006S"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "type", "", "productType", "(Ljava/lang/String;JJII)V", "confidence", "", "getConfidence", "()F", "setConfidence", "(F)V", "detail", "getDetail", "()Ljava/lang/String;", "setDetail", "(Ljava/lang/String;)V", "detailStatus", "getDetailStatus", "()I", "setDetailStatus", "(I)V", "evidenceCount", "getEvidenceCount", "setEvidenceCount", "logId", "getLogId", "setLogId", "getProductType", "setProductType", "screenshot", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getScreenshot", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setScreenshot", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceLink", "getSourceLink", "setSourceLink", "sourceLinkType", "getSourceLinkType", "setSourceLinkType", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", "sourceQuery", "getSourceQuery", "setSourceQuery", "sourceText", "getSourceText", "setSourceText", "userEdit", "", "getUserEdit", "()Z", "setUserEdit", "(Z)V", "convertToModelInput", "Lorg/json/JSONObject;", "makeModelInputValue", "desc", "value", "readMemoryExtensionFieldFromParcel", "", "readMemoryExtensionFieldFromParcel$capabilitykitcommon_release", "writeMemoryBaseFieldToParcel", "writeMemoryBaseFieldToParcel$capabilitykitcommon_release", "writeMemoryExtensionFieldToParcel", "flags", "writeMemoryExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public abstract class MemoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 10;
    private static final int RELATED_VERSION = 0;
    private float confidence;
    private String detail;
    private int detailStatus;
    private int evidenceCount;
    private String logId;
    private int productType;
    private FileEntity screenshot;
    private String sourceAppName;
    private String sourceLink;
    private String sourceLinkType;
    private String sourcePackageName;
    private String sourceQuery;
    private String sourceText;
    private boolean userEdit;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/memory/MemoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<MemoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.memory.MemoryEntity");
            return (MemoryEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 10;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MemoryEntity[] newArray(int r1) {
            return new MemoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MemoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MemoryEntity(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        this(EntityExtKt.e(r10), r10.readLong(), r10.readLong(), r10.readInt(), r10.readInt());
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }

    public MemoryEntity(String r2, long r3, long r5, int r7, int r8) {
        Intrinsics.checkNotNullParameter(r2, "id");
        super(r2, r3, r5, r7);
        this.productType = r8;
    }

    public abstract JSONObject convertToModelInput();

    public final float getConfidence() {
        return this.confidence;
    }

    public final String getDetail() {
        return this.detail;
    }

    public final int getDetailStatus() {
        return this.detailStatus;
    }

    public final int getEvidenceCount() {
        return this.evidenceCount;
    }

    public final String getLogId() {
        return this.logId;
    }

    public final int getProductType() {
        return this.productType;
    }

    public final FileEntity getScreenshot() {
        return this.screenshot;
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceLink() {
        return this.sourceLink;
    }

    public final String getSourceLinkType() {
        return this.sourceLinkType;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final String getSourceQuery() {
        return this.sourceQuery;
    }

    public final String getSourceText() {
        return this.sourceText;
    }

    public final boolean getUserEdit() {
        return this.userEdit;
    }

    public final JSONObject makeModelInputValue(String r4, String r5) {
        Intrinsics.checkNotNullParameter(r4, "desc");
        Intrinsics.checkNotNullParameter(r5, "value");
        JSONObject r2 = new JSONObject();
        r2.put("desc", r4);
        r2.put("value", r5);
        return r2;
    }

    public final void readMemoryExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        int r0 = r9.readInt();
        this.sourceLinkType = r9.readString();
        this.sourceLink = r9.readString();
        this.screenshot = (FileEntity) r9.readParcelable(FileEntity.class.getClassLoader());
        int r1 = 10;
        if (r0 > 10) goto L6;
        r1 = r0;
    L6:
        ClassLoader r2 = MemoryEntity.class.getClassLoader();
        int r3 = 1;
    L7:
        if (r3 > r1) goto L46;
        int r4 = 0;
        int r5 = 0;
        boolean r6 = false;
        String r7 = null;
        Float r8 = null;
        Integer r10 = null;
        Boolean r11 = null;
        Integer r12 = null;
        switch(r3) {
            case 1: goto L41;
            case 2: goto L40;
            case 3: goto L39;
            case 4: goto L38;
            case 5: goto L37;
            case 6: goto L36;
            case 7: goto L30;
            case 8: goto L24;
            case 9: goto L18;
            case 10: goto L11;
            default: goto L45;
        };
    L11:
        Object r13 = r9.readValue(r2);
        if ((r13 instanceof Float) == false) goto L14;
        r8 = (Float) r13;
    L14:
        if (r8 == null) goto L16;
        float r14 = r8.floatValue();
    L17:
        this.confidence = r14;
        goto L45
    L16:
        r14 = 0.0f;
        goto L17
    L18:
        Object r15 = r9.readValue(r2);
        if ((r15 instanceof Integer) == false) goto L21;
        r10 = (Integer) r15;
    L21:
        if (r10 == null) goto L23;
        r5 = r10.intValue();
    L23:
        this.evidenceCount = r5;
        goto L45
    L24:
        Object r16 = r9.readValue(r2);
        if ((r16 instanceof Boolean) == false) goto L27;
        r11 = (Boolean) r16;
    L27:
        if (r11 == null) goto L29;
        r6 = r11.booleanValue();
    L29:
        this.userEdit = r6;
        goto L45
    L30:
        Object r17 = r9.readValue(r2);
        if ((r17 instanceof Integer) == false) goto L33;
        r12 = (Integer) r17;
    L33:
        if (r12 == null) goto L35;
        r4 = r12.intValue();
    L35:
        this.detailStatus = r4;
        goto L45
    L36:
        this.detail = (String) r9.readValue(r2);
        goto L45
    L37:
        this.sourceQuery = (String) r9.readValue(r2);
        goto L45
    L38:
        this.logId = (String) r9.readValue(r2);
        goto L45
    L39:
        this.sourceAppName = (String) r9.readValue(r2);
        goto L45
    L40:
        this.sourcePackageName = (String) r9.readValue(r2);
        goto L45
    L41:
        Object r18 = r9.readValue(r2);
        if ((r18 instanceof String) == false) goto L44;
        r7 = (String) r18;
    L44:
        this.sourceText = r7;
    L45:
        r3 = r3 + 1;
    L46:
        if (r3 > r0) goto L48;
        ParcelUtils.INSTANCE.skipValueSafely(r9, r2);
        r3 = r3 + 1;
        goto L46
    }

    public final void setConfidence(float r1) {
        this.confidence = r1;
    }

    public final void setDetail(String r1) {
        this.detail = r1;
    }

    public final void setDetailStatus(int r1) {
        this.detailStatus = r1;
    }

    public final void setEvidenceCount(int r1) {
        this.evidenceCount = r1;
    }

    public final void setLogId(String r1) {
        this.logId = r1;
    }

    public final void setProductType(int r1) {
        this.productType = r1;
    }

    public final void setScreenshot(FileEntity r1) {
        this.screenshot = r1;
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceLink(String r1) {
        this.sourceLink = r1;
    }

    public final void setSourceLinkType(String r1) {
        this.sourceLinkType = r1;
    }

    public final void setSourcePackageName(String r1) {
        this.sourcePackageName = r1;
    }

    public final void setSourceQuery(String r1) {
        this.sourceQuery = r1;
    }

    public final void setSourceText(String r1) {
        this.sourceText = r1;
    }

    public final void setUserEdit(boolean r1) {
        this.userEdit = r1;
    }

    public final void writeMemoryBaseFieldToParcel$capabilitykitcommon_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(this.productType);
    }

    public final void writeMemoryExtensionFieldToParcel$capabilitykitcommon_release(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(10);
        r2.writeString(this.sourceLinkType);
        r2.writeString(this.sourceLink);
        r2.writeParcelable(this.screenshot, r3);
        r2.writeValue(this.sourceText);
        r2.writeValue(this.sourcePackageName);
        r2.writeValue(this.sourceAppName);
        r2.writeValue(this.logId);
        r2.writeValue(this.sourceQuery);
        r2.writeValue(this.detail);
        r2.writeValue(Integer.valueOf(this.detailStatus));
        r2.writeValue(Boolean.valueOf(this.userEdit));
        r2.writeValue(Integer.valueOf(this.evidenceCount));
        r2.writeValue(Float.valueOf(this.confidence));
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        throw new UnsupportedOperationException("Don't construct MemoryEntity Directly, use subclass instead");
    }
}
