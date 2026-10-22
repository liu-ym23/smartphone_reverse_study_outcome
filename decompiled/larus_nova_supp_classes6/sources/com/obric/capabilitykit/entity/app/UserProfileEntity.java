package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B7\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\"\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\u001dH\u0016R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0013\"\u0004\b\u0017\u0010\u0015¨\u0006!"}, d2 = {"Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "profileKey", "profileValue", "isFromAutoLearn", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Z)V", "()Z", "setFromAutoLearn", "(Z)V", "getProfileKey", "()Ljava/lang/String;", "setProfileKey", "(Ljava/lang/String;)V", "getProfileValue", "setProfileValue", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class UserProfileEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private boolean isFromAutoLearn;
    private String profileKey;
    private String profileValue;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/UserProfileEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/UserProfileEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<UserProfileEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            AppEntity r3 = AppEntity.CREATOR.createFromParcel(r2);
            Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.UserProfileEntity");
            return (UserProfileEntity) r3;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfileEntity[] newArray(int r1) {
            return new UserProfileEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ UserProfileEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public UserProfileEntity(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        this(EntityExtKt.e(r11), r11.readLong(), r11.readLong(), EntityExtKt.e(r11), EntityExtKt.e(r11), EntityExtKt.d(r11));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 0, r11.readInt());
    }

    public UserProfileEntity(String r11, long r12, long r14, String r16, String r17, boolean r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r16, "profileKey");
        Intrinsics.checkNotNullParameter(r17, "profileValue");
        super(r11, r12, r14, EntityType.USER_PROFILE);
        this.profileKey = r16;
        this.profileValue = r17;
        this.isFromAutoLearn = r18;
    }

    public /* synthetic */ UserProfileEntity(String r11, long r12, long r14, String r16, String r17, boolean r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 32) == 0) goto L5;
        boolean r9 = false;
    L6:
        this(r11, r12, r14, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final String getProfileKey() {
        return this.profileKey;
    }

    public final String getProfileValue() {
        return this.profileValue;
    }

    public final boolean isFromAutoLearn() {
        return this.isFromAutoLearn;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setFromAutoLearn(boolean r1) {
        this.isFromAutoLearn = r1;
    }

    public final void setProfileKey(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.profileKey = r2;
    }

    public final void setProfileValue(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.profileValue = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        super.writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.profileKey);
        r2.writeString(this.profileValue);
        boolean r4 = this.isFromAutoLearn;
        Gson r0 = EntityExtKt.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.writeInt(r4 ? 1 : 0);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(0);
    }
}
