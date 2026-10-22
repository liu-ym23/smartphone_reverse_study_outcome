package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdinstall.Api;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.entity.EventBody;
import com.google.gson.JsonParser;
import com.obric.capabilitykit.PackageUtils;
import com.obric.capabilitykit.common.b0;
import com.obric.capabilitykit.common.l;
import com.obric.capabilitykit.common.w;
import com.obric.capabilitykit.entity.EntityContextHolder;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0014\b'\u0018\u0000 b2\u00020\u0001:\u0001bB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010A\u001a\u00020B2\u0006\u0010\u001d\u001a\u00020'J\u0006\u0010C\u001a\u00020BJ\b\u0010D\u001a\u00020\u000bH\u0016J\b\u0010E\u001a\u00020FH\u0016J\b\u0010G\u001a\u0004\u0018\u00010\u0006J\b\u0010H\u001a\u0004\u0018\u00010\u0006J\u0010\u0010I\u001a\u0004\u0018\u00010'2\u0006\u0010J\u001a\u00020\u0006J\u0006\u0010K\u001a\u00020\u0006J\b\u0010L\u001a\u00020\u000bH\u0016J\"\u0010M\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010O2\u0006\u0010P\u001a\u00020\u000bH&J\u0015\u0010Q\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\bRJ%\u0010S\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010T\u001a\u00020\u000b2\u0006\u0010U\u001a\u00020\u000bH\u0000¢\u0006\u0002\bVJ\u0010\u0010W\u001a\u00020B2\b\u0010X\u001a\u0004\u0018\u00010\u0006J\u0010\u0010Y\u001a\u00020B2\b\u0010Z\u001a\u0004\u0018\u00010\u0006J\b\u0010[\u001a\u00020\u0006H\u0016J\u0015\u0010\\\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b]J\u0015\u0010^\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000¢\u0006\u0002\b_J\u0018\u0010`\u001a\u00020B2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u000bH\u0016R\u001a\u0010\r\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u000f\"\u0004\b$\u0010\u0011R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010-\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u000b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u000f\"\u0004\b1\u0010\u0011R\u001a\u0010\t\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0016\"\u0004\b3\u0010\u0018R\u001e\u00104\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010:\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b;\u00106\"\u0004\b<\u00108R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b=\u0010/R\u001c\u0010>\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\u000f\"\u0004\b@\u0010\u0011¨\u0006c"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", OaidModel.KEY_ID, "", "createTime", "", "lastModifiedTime", "type", "", "(Ljava/lang/String;JJI)V", "_packageName", "get_packageName", "()Ljava/lang/String;", "set_packageName", "(Ljava/lang/String;)V", "contentHash", "getContentHash", "setContentHash", "getCreateTime", "()J", "setCreateTime", "(J)V", "ecaId", "ecaRawContent", EventBody.KEY_VALUE, "", WsConstants.KEY_EXTRA, "getExtra", "()Ljava/lang/Object;", "setExtra", "(Ljava/lang/Object;)V", "extraData", "getExtraData", "setExtraData", "extras", "", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "getExtras", "()Ljava/util/List;", "setExtras", "(Ljava/util/List;)V", "<set-?>", "hashCodeValue", "getHashCodeValue", "()I", "getId", "setId", "getLastModifiedTime", "setLastModifiedTime", "poisonLabel", "getPoisonLabel", "()Ljava/lang/Integer;", "setPoisonLabel", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "poisonLabelVersion", "getPoisonLabelVersion", "setPoisonLabelVersion", "getType", Api.KEY_UUID, "getUuid", "setUuid", "addExtraEntity", "", "countHashCode", "describeContents", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getEcaId", "getEcaRawContent", "getExtraEntity", "key", "getPackageName", "hashCode", "onReadSubClassExtensionField", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "readExtensionFieldFromParcel", "readExtensionFieldFromParcel$capabilitykitcommon_release", "readSubClassExtensionFieldFromParcel", "ourVersion", "theirVersion", "readSubClassExtensionFieldFromParcel$capabilitykitcommon_release", "setEcaId", "uniqueId", "setEcaRawContent", "rawContent", "toString", "writeBaseFieldToParcel", "writeBaseFieldToParcel$capabilitykitcommon_release", "writeExtensionFieldToParcel", "writeExtensionFieldToParcel$capabilitykitcommon_release", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public abstract class AppEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 9;
    private static final int RELATED_VERSION = 0;
    private String _packageName;
    private String contentHash;
    private long createTime;
    private String ecaId;
    private String ecaRawContent;
    private transient Object extra;
    private String extraData;
    private List<ExtraEntity> extras;
    private int hashCodeValue;
    private String id;
    private long lastModifiedTime;
    private Integer poisonLabel;
    private Integer poisonLabelVersion;
    private final int type;
    private String uuid;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fJ\u0006\u0010\u000e\u001a\u00020\u0005J\u001d\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AppEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "", "fromJsonKeepTimeStamp", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AppEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AppEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            int r3 = r4.readInt();
            EntityClassData r0 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r3)), EntityClassData.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L9;
            Function1 r1 = r0.getParcelConstructor();
            if (r1 == null) goto L9;
            return (AppEntity) ZeusTransformUtils.preCheckCast(r1.invoke(r4), AppEntity.class, "com.obric.memorydata.plugin");
        L9:
            throw new UnsupportedOperationException("failed to construct AppEntity for type " + r3);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final AppEntity fromJson(String r2) {
            Intrinsics.checkNotNullParameter(r2, "json");
            Object r1 = EntityExtKt.getEntityGson().fromJson(r2, AppEntity.class);
            Intrinsics.checkNotNullExpressionValue(r1, "entityGson.fromJson(json, AppEntity::class.java)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r1, AppEntity.class, "com.obric.memorydata.plugin");
        }

        public final AppEntity fromJsonKeepTimeStamp(String r4) {
            Intrinsics.checkNotNullParameter(r4, "json");
            int r3 = new JsonParser().parse(r4).getAsJsonObject().get("type").getAsInt();
            EntityClassData r0 = (EntityClassData) ZeusTransformUtils.preCheckCast(EntityType.INSTANCE.getClassMap().get(Integer.valueOf(r3)), EntityClassData.class, "com.obric.memorydata.plugin");
            if (r0 == null) goto L9;
            Class r1 = r0.getClazz();
            if (r1 == null) goto L9;
            Object r5 = EntityExtKt.getEntityKeepTimeStampGson().fromJson(r4, r1);
            Intrinsics.checkNotNullExpressionValue(r5, "entityKeepTimeStampGson.…omJson(json, targetClass)");
            return (AppEntity) ZeusTransformUtils.preCheckCast(r5, AppEntity.class, "com.obric.memorydata.plugin");
        L9:
            throw new IllegalArgumentException("Unknown entity type: " + r3);
        }

        public final int getVersion() {
            return 9;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AppEntity[] newArray(int r1) {
            return new AppEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AppEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AppEntity(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(EntityExtKt.readStringOrEmpty(r9), r9.readLong(), r9.readLong(), r9.readInt());
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }

    public AppEntity(String r2, long r3, long r5, int r7) {
        Intrinsics.checkNotNullParameter(r2, OaidModel.KEY_ID);
        this.id = r2;
        this.createTime = r3;
        this.lastModifiedTime = r5;
        this.type = r7;
        this._packageName = "";
        String r4 = EntityContextHolder.INSTANCE.getPackageName();
        if (PackageUtils.INSTANCE.isMemoryPackageName(r4) == false) goto L13;
        if (ZeusTransformUtils.instanceOf(this, ContactEntity.class) == false) goto L7;
    L16:
        r4 = "com.android.contacts";
    L17:
        this._packageName = r4;
        return;
    L7:
        if (ZeusTransformUtils.instanceOf(this, CallHistoryEntity.class) == true) goto L16;
        if (ZeusTransformUtils.instanceOf(this, MessageEntity.class) == false) goto L17;
        this._packageName = "com.android.mms";
        return;
    L13:
        if (Intrinsics.areEqual("com.android.mms", r4) == false) goto L17;
        if (ZeusTransformUtils.instanceOf(this, ContactEntity.class) == false) goto L17;
        goto L16
    }

    public final void addExtraEntity(ExtraEntity r2) {
        Intrinsics.checkNotNullParameter(r2, WsConstants.KEY_EXTRA);
        if (this.extras != null) goto L5;
        this.extras = new ArrayList();
    L5:
        List<ExtraEntity> r1 = this.extras;
        Intrinsics.checkNotNull(r1);
        r1.add(r2);
    }

    public final void countHashCode() {
        this.hashCodeValue = hashCode();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getContentHash() {
        return this.contentHash;
    }

    public final long getCreateTime() {
        return this.createTime;
    }

    public DisplayRepresentation getDisplayRepresentation() {
        throw new UnsupportedOperationException("entity not implementation getDisplayRepresentation method");
    }

    public final String getEcaId() {
        return this.ecaId;
    }

    public final String getEcaRawContent() {
        return this.ecaRawContent;
    }

    public final Object getExtra() {
        return this.extra;
    }

    public final String getExtraData() {
        return this.extraData;
    }

    public final ExtraEntity getExtraEntity(String r5) {
        Intrinsics.checkNotNullParameter(r5, "key");
        List<ExtraEntity> r4 = this.extras;
        Object r0 = null;
        if (r4 == null) goto L15;
        Iterator<T> r6 = r4.iterator();
    L6:
        if (r6.hasNext() == false) goto L11;
        Object r1 = r6.next();
        if (Intrinsics.areEqual(((ExtraEntity) ZeusTransformUtils.preCheckCast(r1, ExtraEntity.class, "com.obric.memorydata.plugin")).getKey(), r5) == false) goto L6;
        r0 = r1;
    L11:
        return (ExtraEntity) ZeusTransformUtils.preCheckCast(r0, ExtraEntity.class, "com.obric.memorydata.plugin");
    L15:
        return null;
    }

    public final List<ExtraEntity> getExtras() {
        return this.extras;
    }

    public final int getHashCodeValue() {
        return this.hashCodeValue;
    }

    public final String getId() {
        return this.id;
    }

    public final long getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getPackageName() {
        return this._packageName;
    }

    public final Integer getPoisonLabel() {
        return this.poisonLabel;
    }

    public final Integer getPoisonLabelVersion() {
        return this.poisonLabelVersion;
    }

    public final int getType() {
        return this.type;
    }

    public final String getUuid() {
        return this.uuid;
    }

    public final String get_packageName() {
        return this._packageName;
    }

    public int hashCode() {
        b0 r0 = (b0) ZeusTransformUtils.preCheckCast(w.f7525a.a().get(getClass().getName()), b0.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        return (r0.a(this) * 31) + l.f7510a.a(this);
    L7:
        throw new IllegalStateException("not found entity generatorHashCode function, entityName: " + getClass().getName());
    }

    public abstract void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3);

    public final void readExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "parcel");
        int r0 = r9.readInt();
        this._packageName = EntityExtKt.readStringOrEmpty(r9);
        this.extras = r9.createTypedArrayList(ExtraEntity.CREATOR);
        int r1 = 9;
        if (r0 > 9) goto L6;
        r1 = r0;
    L6:
        ClassLoader r2 = AppEntity.class.getClassLoader();
        int r3 = 1;
    L7:
        if (r3 > r1) goto L42;
        String r4 = null;
        String r5 = null;
        Integer r6 = null;
        Integer r7 = null;
        String r8 = null;
        String r10 = null;
        String r11 = null;
        switch(r3) {
            case 1: goto L40;
            case 2: goto L39;
            case 3: goto L35;
            case 4: goto L31;
            case 5: goto L27;
            case 6: goto L23;
            case 7: goto L19;
            case 8: goto L15;
            case 9: goto L11;
            default: goto L41;
        };
    L11:
        Object r12 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r12, String.class) == false) goto L14;
        r5 = (String) ZeusTransformUtils.preCheckCast(r12, String.class, "com.obric.memorydata.plugin");
    L14:
        this.contentHash = r5;
        goto L41
    L15:
        Object r13 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r13, Integer.class) == false) goto L18;
        r6 = (Integer) ZeusTransformUtils.preCheckCast(r13, Integer.class, "com.obric.memorydata.plugin");
    L18:
        this.poisonLabelVersion = r6;
        goto L41
    L19:
        Object r14 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r14, Integer.class) == false) goto L22;
        r7 = (Integer) ZeusTransformUtils.preCheckCast(r14, Integer.class, "com.obric.memorydata.plugin");
    L22:
        this.poisonLabel = r7;
        goto L41
    L23:
        Object r15 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r15, String.class) == false) goto L26;
        r8 = (String) ZeusTransformUtils.preCheckCast(r15, String.class, "com.obric.memorydata.plugin");
    L26:
        this.uuid = r8;
        goto L41
    L27:
        Object r16 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r16, String.class) == false) goto L30;
        r10 = (String) ZeusTransformUtils.preCheckCast(r16, String.class, "com.obric.memorydata.plugin");
    L30:
        this.ecaRawContent = r10;
        goto L41
    L31:
        Object r17 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r17, String.class) == false) goto L34;
        r11 = (String) ZeusTransformUtils.preCheckCast(r17, String.class, "com.obric.memorydata.plugin");
    L34:
        this.ecaId = r11;
        goto L41
    L35:
        Object r18 = ParcelUtils.INSTANCE.readValueSafely(r9, r2);
        if (ZeusTransformUtils.instanceOf(r18, String.class) == false) goto L38;
        r4 = (String) ZeusTransformUtils.preCheckCast(r18, String.class, "com.obric.memorydata.plugin");
    L38:
        this.extraData = r4;
        goto L41
    L39:
        Object r19 = r9.readValue(r2);
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type kotlin.Int");
        this.hashCodeValue = ((Integer) ZeusTransformUtils.preCheckCast(r19, Integer.class, "com.obric.memorydata.plugin")).intValue();
        goto L41
    L40:
        setExtra(ParcelUtils.INSTANCE.readValueSafely(r9, r2));
    L41:
        r3 = r3 + 1;
    L42:
        if (r3 > r0) goto L44;
        ParcelUtils.INSTANCE.skipValueSafely(r9, r2);
        r3 = r3 + 1;
        goto L42
    }

    public final void readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(Parcel r3, int r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        if (r5 > r4) goto L6;
        r4 = r5;
    L6:
        ClassLoader r0 = AppEntity.class.getClassLoader();
        int r1 = 1;
    L7:
        if (r1 > r4) goto L9;
        onReadSubClassExtensionField(r3, r0, r1);
        r1 = r1 + 1;
    L9:
        if (r1 > r5) goto L11;
        ParcelUtils.INSTANCE.skipValueSafely(r3, r0);
        r1 = r1 + 1;
        goto L9
    }

    public final void setContentHash(String r1) {
        this.contentHash = r1;
    }

    public final void setCreateTime(long r1) {
        this.createTime = r1;
    }

    public final void setEcaId(String r1) {
        this.ecaId = r1;
    }

    public final void setEcaRawContent(String r1) {
        this.ecaRawContent = r1;
    }

    public final void setExtra(Object r3) {
        if (EntityExtKt.isValidEntityPropertyType(r3) == false) goto L6;
        this.extra = r3;
        return;
    L6:
        StringBuilder r0 = new StringBuilder().append("extra value type ");
        Intrinsics.checkNotNull(r3);
        throw new IllegalArgumentException(r0.append(r3.getClass().getName()).append(" is not supported").toString());
    }

    public final void setExtraData(String r1) {
        this.extraData = r1;
    }

    public final void setExtras(List<ExtraEntity> r3) {
        this.extras = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
    }

    public final void setId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.id = r2;
    }

    public final void setLastModifiedTime(long r1) {
        this.lastModifiedTime = r1;
    }

    public final void setPoisonLabel(Integer r1) {
        this.poisonLabel = r1;
    }

    public final void setPoisonLabelVersion(Integer r1) {
        this.poisonLabelVersion = r1;
    }

    public final void setUuid(String r1) {
        this.uuid = r1;
    }

    public final void set_packageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._packageName = r2;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    public final void writeBaseFieldToParcel$capabilitykitcommon_release(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        r3.writeInt(this.type);
        r3.writeString(this.id);
        r3.writeLong(this.createTime);
        r3.writeLong(this.lastModifiedTime);
    }

    public final void writeExtensionFieldToParcel$capabilitykitcommon_release(Parcel r2) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeInt(9);
        r2.writeString(this._packageName);
        r2.writeTypedList(this.extras);
        r2.writeValue(this.extra);
        r2.writeValue(Integer.valueOf(this.hashCodeValue));
        r2.writeValue(this.extraData);
        r2.writeValue(this.ecaId);
        r2.writeValue(this.ecaRawContent);
        r2.writeValue(this.uuid);
        r2.writeValue(this.poisonLabel);
        r2.writeValue(this.poisonLabelVersion);
        r2.writeValue(this.contentHash);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        throw new UnsupportedOperationException("Don't construct AppEntity Directly, use subclass instead");
    }
}
