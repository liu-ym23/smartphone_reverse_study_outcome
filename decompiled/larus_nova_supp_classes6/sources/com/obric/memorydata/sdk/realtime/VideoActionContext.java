package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0003H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006!"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/VideoActionContext;", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "type", "", "packageName", "", "activityName", "videoUrl", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getType", "()I", "getPackageName", "()Ljava/lang/String;", "getActivityName", "getVideoUrl", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "toString", "CREATOR", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class VideoActionContext extends ActionContext {
    public static final CREATOR CREATOR = null;
    private final String activityName;
    private final String packageName;
    private final int type;
    private final String videoUrl;

    static {
        CREATOR = new CREATOR(null);
    }

    public static /* synthetic */ VideoActionContext copy$default(VideoActionContext r0, int r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.type;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.packageName;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.activityName;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.videoUrl;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final int component1() {
        return this.type;
    }

    public final String component2() {
        return this.packageName;
    }

    public final String component3() {
        return this.activityName;
    }

    public final String component4() {
        return this.videoUrl;
    }

    public final VideoActionContext copy(int r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "activityName");
        Intrinsics.checkNotNullParameter(r5, "videoUrl");
        return new VideoActionContext(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof VideoActionContext) == true) goto L8;
        return false;
    L8:
        VideoActionContext r6 = (VideoActionContext) r5;
        if (this.type == r6.type) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.packageName, r6.packageName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.activityName, r6.activityName) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.videoUrl, r6.videoUrl) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.type * 31) + this.packageName.hashCode()) * 31) + this.activityName.hashCode()) * 31) + this.videoUrl.hashCode();
    }

    public String toString() {
        return "VideoActionContext(type=" + this.type + ", packageName=" + this.packageName + ", activityName=" + this.activityName + ", videoUrl=" + this.videoUrl + ')';
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getActivityName() {
        return this.activityName;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public String getPackageName() {
        return this.packageName;
    }

    @Override // com.obric.memorydata.sdk.realtime.ActionContext
    public int getType() {
        return this.type;
    }

    public final String getVideoUrl() {
        return this.videoUrl;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "dest");
        super.writeToParcelBase(r2, r3);
        r2.writeString(getPackageName());
        r2.writeString(getActivityName());
        r2.writeString(this.videoUrl);
    }

    public VideoActionContext(int r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "packageName");
        Intrinsics.checkNotNullParameter(r4, "activityName");
        Intrinsics.checkNotNullParameter(r5, "videoUrl");
        this.type = r2;
        this.packageName = r3;
        this.activityName = r4;
        this.videoUrl = r5;
    }

    public /* synthetic */ VideoActionContext(int r1, String r2, String r3, String r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L5;
        r1 = 5;
    L5:
        this(r1, r2, r3, r4);
    }
}
