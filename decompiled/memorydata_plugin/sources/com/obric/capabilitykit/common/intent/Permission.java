package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\bHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\bHÖ\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000b¨\u0006$"}, d2 = {"Lcom/obric/capabilitykit/common/intent/Permission;", "Landroid/os/Parcelable;", "type", "", "granted", "", "appletId", "confirmMode", "", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)V", "getAppletId", "()Ljava/lang/String;", "getConfirmMode", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getGranted", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getType", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Integer;)Lcom/obric/capabilitykit/common/intent/Permission;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Permission implements Parcelable {
    public static final Parcelable.Creator<Permission> CREATOR = null;
    private final String appletId;
    private final Integer confirmMode;
    private final Boolean granted;
    private final String type;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Permission> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Permission createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            Intrinsics.checkNotNullParameter(r10, "parcel");
            String r2 = r10.readString();
            Integer r5 = null;
            int r6 = 1;
            if (r10.readInt() != 0) goto L6;
            Boolean r3 = null;
        L10:
            String r7 = r10.readString();
            if (r10.readInt() == 0) goto L14;
            r5 = Integer.valueOf(r10.readInt());
        L14:
            Permission r1 = new Permission(r2, r3, r7, r5);
            int r4 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
        L15:
            if (r6 > r4) goto L17;
            r6 = r6 + 1;
        L17:
            if (r6 > r0) goto L19;
            a.a(r10, r9);
            r6 = r6 + 1;
            goto L17
        L19:
            return r1;
        L6:
            if (r10.readInt() == 0) goto L8;
            boolean r8 = true;
        L9:
            r3 = Boolean.valueOf(r8);
            goto L10
        L8:
            r8 = false;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Permission createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final Permission[] newArray(int r1) {
            return new Permission[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ Permission[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public Permission(String r1, Boolean r2, String r3, Integer r4) {
        this.type = r1;
        this.granted = r2;
        this.appletId = r3;
        this.confirmMode = r4;
    }

    public static /* synthetic */ Permission copy$default(Permission r0, String r1, Boolean r2, String r3, Integer r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.granted;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.appletId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.confirmMode;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.type;
    }

    public final Boolean component2() {
        return this.granted;
    }

    public final String component3() {
        return this.appletId;
    }

    public final Integer component4() {
        return this.confirmMode;
    }

    public final Permission copy(String r1, Boolean r2, String r3, Integer r4) {
        return new Permission(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, Permission.class) == true) goto L8;
        return false;
    L8:
        Permission r6 = (Permission) ZeusTransformUtils.preCheckCast(r5, Permission.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.type, r6.type) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.granted, r6.granted) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.appletId, r6.appletId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.confirmMode, r6.confirmMode) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    public final Integer getConfirmMode() {
        return this.confirmMode;
    }

    public final Boolean getGranted() {
        return this.granted;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        String r0 = this.type;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.granted;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.appletId;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.confirmMode;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "Permission(type=" + this.type + ", granted=" + this.granted + ", appletId=" + this.appletId + ", confirmMode=" + this.confirmMode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.type);
        Boolean r0 = this.granted;
        if (r0 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeString(this.appletId);
        Integer r2 = this.confirmMode;
        if (r2 != null) goto L9;
        r3.writeInt(0);
        return;
    L9:
        r3.writeInt(1);
        r3.writeInt(r2.intValue());
        return;
    L5:
        r3.writeInt(1);
        r3.writeInt(r0.booleanValue() ? 1 : 0);
        goto L6
    }
}
