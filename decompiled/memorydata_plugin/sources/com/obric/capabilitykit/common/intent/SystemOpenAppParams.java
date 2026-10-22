package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.b.a;
import com.obric.memorydata.middleware.impl.bdtracker.TrackerImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0016J\t\u0010\u0019\u001a\u00020\u0013HÖ\u0001J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\u0012\u0010\u001b\u001a\u00020\u00012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0017H\u0016J\t\u0010\u001d\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0013HÖ\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR&\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006#"}, d2 = {"Lcom/obric/capabilitykit/common/intent/SystemOpenAppParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "appName", "", "appletId", "(Ljava/lang/String;Ljava/lang/String;)V", "getAppName", "()Ljava/lang/String;", "setAppName", "(Ljava/lang/String;)V", "getAppletId$annotations", "()V", "getAppletId", "setAppletId", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getSubActionValue", "hashCode", "isParamsCompleted", "mergeParams", TrackerImpl.PARAMS, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SystemOpenAppParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<SystemOpenAppParams> CREATOR = null;
    private String appName;
    String appletId;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<SystemOpenAppParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            Intrinsics.checkNotNullParameter(r9, "parcel");
            SystemOpenAppParams r1 = new SystemOpenAppParams(r9.readString(), null, 2, 0 == true ? 1 : 0);
            int r3 = Math.min(r0, 1);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L3:
            if (r4 > r3) goto L9;
            if (r4 != 1) goto L8;
            Object r5 = a.b(r9, r8);
            if (r5 == null) goto L8;
            r1.appletId = (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.memorydata.plugin");
        L8:
            r4 = r4 + 1;
        L9:
            if (r4 > r0) goto L11;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L9
        L11:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final SystemOpenAppParams[] newArray(int r1) {
            return new SystemOpenAppParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SystemOpenAppParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SystemOpenAppParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public SystemOpenAppParams(String r1, String r2) {
        this.appName = r1;
        this.appletId = r2;
    }

    public /* synthetic */ SystemOpenAppParams(String r2, String r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public static /* synthetic */ SystemOpenAppParams copy$default(SystemOpenAppParams r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.appName;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.appletId;
    L9:
        return r0.copy(r1, r2);
    }

    public static /* synthetic */ void getAppletId$annotations() {
    }

    public final String component1() {
        return this.appName;
    }

    public final String component2() {
        return this.appletId;
    }

    public final SystemOpenAppParams copy(String r1, String r2) {
        return new SystemOpenAppParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, SystemOpenAppParams.class) == true) goto L8;
        return false;
    L8:
        SystemOpenAppParams r6 = (SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r5, SystemOpenAppParams.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.appName, r6.appName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.appletId, r6.appletId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getAppName() {
        return this.appName;
    }

    public final String getAppletId() {
        return this.appletId;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        String r0 = this.appName;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.toString();
    }

    public int hashCode() {
        String r0 = this.appName;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.appletId;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.appName == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, SystemOpenAppParams.class) == true) goto L7;
        Object r3 = ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.memorydata.plugin");
    L6:
        return (IntentParams) r3;
    L7:
        String r1 = this.appName;
        if (r1 != null) goto L10;
        r1 = ((SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenAppParams.class, "com.obric.memorydata.plugin")).appName;
    L10:
        String r5 = this.appletId;
        if (r5 != null) goto L13;
        r5 = ((SystemOpenAppParams) ZeusTransformUtils.preCheckCast(r4, SystemOpenAppParams.class, "com.obric.memorydata.plugin")).appletId;
    L13:
        r3 = ZeusTransformUtils.preCheckCast(new SystemOpenAppParams(r1, r5), IntentParams.class, "com.obric.memorydata.plugin");
        goto L6
    }

    public final void setAppName(String r1) {
        this.appName = r1;
    }

    public final void setAppletId(String r1) {
        this.appletId = r1;
    }

    public String toString() {
        return "SystemOpenAppParams(appName=" + this.appName + ", appletId=" + this.appletId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        r1.writeInt(1);
        Intrinsics.checkNotNullParameter(r1, "out");
        r1.writeString(this.appName);
        r1.writeValue(this.appletId);
    }
}
