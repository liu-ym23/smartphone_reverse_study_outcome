package com.obric.memorydata.sdk.service;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.UtilsKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u001d\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0004HÆ\u0003J#\u0010\u0015\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0011HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "Landroid/os/Parcelable;", "missedPermissions", "", "", "feedbackText", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getMissedPermissions", "()Ljava/util/List;", "getFeedbackText", "()Ljava/lang/String;", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "", "describeContents", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PermissionCheckResult implements Parcelable {
    public static final a CREATOR = null;
    private final String feedbackText;
    private final List<String> missedPermissions;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/service/PermissionCheckResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "<init>", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/service/PermissionCheckResult;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<PermissionCheckResult> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public PermissionCheckResult a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            Object r1 = UtilsKt.getGson().fromJson(r2.readString(), PermissionCheckResult.class);
            Intrinsics.checkNotNullExpressionValue(r1, "fromJson(...)");
            return (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r1, PermissionCheckResult.class, "com.obric.memorydata.plugin");
        }

        public PermissionCheckResult[] a(int r1) {
            return new PermissionCheckResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PermissionCheckResult createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ PermissionCheckResult[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public PermissionCheckResult(List<String> r3, String r4) {
        List<String> r5 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "missedPermissions");
        Intrinsics.checkNotNullParameter(r4, "feedbackText");
        this.missedPermissions = r5;
        this.feedbackText = r4;
    }

    public static /* synthetic */ PermissionCheckResult copy$default(PermissionCheckResult r1, List r2, String r3, int r4, Object r5) {
        List<String> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 1) == 0) goto L6;
        r6 = r1.missedPermissions;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r3 = r1.feedbackText;
    L9:
        return r1.copy(r6, r3);
    }

    public final List<String> component1() {
        return this.missedPermissions;
    }

    public final String component2() {
        return this.feedbackText;
    }

    public final PermissionCheckResult copy(List<String> r2, String r3) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "missedPermissions");
        Intrinsics.checkNotNullParameter(r3, "feedbackText");
        return new PermissionCheckResult(r1, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PermissionCheckResult.class) == true) goto L8;
        return false;
    L8:
        PermissionCheckResult r6 = (PermissionCheckResult) ZeusTransformUtils.preCheckCast(r5, PermissionCheckResult.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.missedPermissions, r6.missedPermissions) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.feedbackText, r6.feedbackText) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getFeedbackText() {
        return this.feedbackText;
    }

    public final List<String> getMissedPermissions() {
        return this.missedPermissions;
    }

    public int hashCode() {
        return (this.missedPermissions.hashCode() * 31) + this.feedbackText.hashCode();
    }

    public String toString() {
        return "PermissionCheckResult(missedPermissions=" + this.missedPermissions + ", feedbackText=" + this.feedbackText + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeString(UtilsKt.getGson().toJson(this));
    }
}
