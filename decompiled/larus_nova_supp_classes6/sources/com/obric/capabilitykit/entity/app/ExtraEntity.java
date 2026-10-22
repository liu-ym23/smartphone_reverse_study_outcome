package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B!\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0006J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\b\u0010\u0019\u001a\u00020\u0006H\u0016J\u0018\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0014H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "key", "", "value", "", "isSemantic", "", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "()Z", "getKey", "()Ljava/lang/String;", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "describeContents", "", "isValidExtraString", "readExtensionField", "", "theirVersion", "toString", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class ExtraEntity implements Parcelable {
    public static final CREATOR CREATOR = null;
    public static final String KEY_EXTRA_1 = "extra1";
    public static final String KEY_EXTRA_10 = "extra10";
    public static final String KEY_EXTRA_2 = "extra2";
    public static final String KEY_EXTRA_3 = "extra3";
    public static final String KEY_EXTRA_4 = "extra4";
    public static final String KEY_EXTRA_5 = "extra5";
    public static final String KEY_EXTRA_6 = "extra6";
    public static final String KEY_EXTRA_7 = "extra7";
    public static final String KEY_EXTRA_8 = "extra8";
    public static final String KEY_EXTRA_9 = "extra9";
    private static final int VERSION = 0;
    private final boolean isSemantic;
    private final String key;
    private Object value;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0005J\u001d\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0010H\u0016¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/obric/capabilitykit/entity/app/ExtraEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "()V", "KEY_EXTRA_1", "", "KEY_EXTRA_10", "KEY_EXTRA_2", "KEY_EXTRA_3", "KEY_EXTRA_4", "KEY_EXTRA_5", "KEY_EXTRA_6", "KEY_EXTRA_7", "KEY_EXTRA_8", "KEY_EXTRA_9", "VERSION", "", "createFromParcel", "parcel", "Landroid/os/Parcel;", "fromJson", "json", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/ExtraEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
    public static final class CREATOR implements Parcelable.Creator<ExtraEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraEntity createFromParcel(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ExtraEntity(r2);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final ExtraEntity fromJson(String r3) {
            Intrinsics.checkNotNullParameter(r3, "json");
            return (ExtraEntity) GsonProtectorUtils.fromJson(EntityExtKt.a(), r3, ExtraEntity.class);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ExtraEntity[] newArray(int r1) {
            return new ExtraEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ ExtraEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public ExtraEntity(Parcel r4) {
        Intrinsics.checkNotNullParameter(r4, "parcel");
        this(EntityExtKt.e(r4), r4.readValue(ExtraEntity.class.getClassLoader()), EntityExtKt.d(r4));
        readExtensionField(r4, r4.readInt());
    }

    public ExtraEntity(String r2, Object r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.value = r3;
        this.isSemantic = r4;
        if (isValidExtraString(r2) == false) goto L10;
        if (EntityExtKt.c(this.value) == false) goto L7;
        return;
    L7:
        StringBuilder r5 = new StringBuilder("ExtraEntity's value type ");
        Object r6 = this.value;
        Intrinsics.checkNotNull(r6);
        r5.append(r6.getClass().getName());
        r5.append(" is not supported");
        throw new IllegalArgumentException(r5.toString());
    L10:
        throw new IllegalArgumentException("ExtraEntity's key " + r2 + " is not valid, must be extraN (N is 1-10)");
    }

    public /* synthetic */ ExtraEntity(String r1, Object r2, boolean r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        this(r1, r2, r3);
    }

    private final void readExtensionField(Parcel r4, int r5) {
        if (r5 <= 0) goto L4;
        int r0 = 0;
    L5:
        ClassLoader r1 = ExtraEntity.class.getClassLoader();
        int r2 = 1;
    L6:
        if (r2 > r0) goto L8;
        r2 = r2 + 1;
    L8:
        if (r2 > r5) goto L10;
        ParcelUtils.INSTANCE.skipValueSafely(r4, r1);
        r2 = r2 + 1;
        goto L8
    L10:
        return;
    L4:
        r0 = r5;
        goto L5
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getKey() {
        return this.key;
    }

    public final Object getValue() {
        return this.value;
    }

    public final boolean isSemantic() {
        return this.isSemantic;
    }

    public final boolean isValidExtraString(String r3) {
        Intrinsics.checkNotNullParameter(r3, "key");
        return new Regex("^extra([1-9]|10)$").matches(r3);
    }

    public final void setValue(Object r1) {
        this.value = r1;
    }

    public String toString() {
        return EntityExtKt.toJson(this);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        r2.writeString(this.key);
        r2.writeValue(this.value);
        boolean r4 = this.isSemantic;
        Gson r0 = EntityExtKt.a;
        Intrinsics.checkNotNullParameter(r2, "<this>");
        r2.writeInt(r4 ? 1 : 0);
        r2.writeInt(0);
    }
}
