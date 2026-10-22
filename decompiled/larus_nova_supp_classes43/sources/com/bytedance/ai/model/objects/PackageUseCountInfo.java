package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0004\b\f\u0010\u0010J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\b\u0010\u001d\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006\u001f"}, d2 = {"Lcom/bytedance/ai/model/objects/PackageUseCountInfo;", "Landroid/os/Parcelable;", "packageName", "", "isDebug", "", "sessionId", "versionCode", "", "scmVersion", "useCount", "", "<init>", "(Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;I)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "getPackageName", "()Ljava/lang/String;", "()Z", "getSessionId", "getVersionCode", "()J", "getScmVersion", "getUseCount", "()I", "writeToParcel", "", "flags", "describeContents", "CREATOR", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageUseCountInfo implements Parcelable {
    public static final a CREATOR = null;
    private final boolean isDebug;
    private final String packageName;
    private final String scmVersion;
    private final String sessionId;
    private final int useCount;
    private final long versionCode;

    public static final class a implements Parcelable.Creator<PackageUseCountInfo> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfo createFromParcel(Parcel r10) {
            Intrinsics.checkNotNullParameter(r10, "parcel");
            return new PackageUseCountInfo(r10);
        }

        @Override // android.os.Parcelable.Creator
        public final PackageUseCountInfo[] newArray(int r1) {
            return new PackageUseCountInfo[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getScmVersion() {
        return this.scmVersion;
    }

    public final String getSessionId() {
        return this.sessionId;
    }

    public final int getUseCount() {
        return this.useCount;
    }

    public final long getVersionCode() {
        return this.versionCode;
    }

    public final boolean isDebug() {
        return this.isDebug;
    }

    public PackageUseCountInfo(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r11 = r10.readString();
        Intrinsics.checkNotNull(r11);
        if (r10.readByte() == 0) goto L5;
        boolean r12 = true;
    L6:
        String r0 = r10.readString();
        if (r0 != null) goto L9;
        String r13 = "";
    L10:
        long r14 = r10.readLong();
        String r1 = r10.readString();
        if (r1 != null) goto L13;
        String r15 = "";
    L14:
        this(r11, r12, r13, r14, r15, r10.readInt());
        return;
    L13:
        r15 = r1;
        goto L14
    L9:
        r13 = r0;
        goto L10
    L5:
        r12 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        r10.writeString(this.packageName);
        r10.writeByte(this.isDebug ? 1 : 0);
        r10.writeString(this.sessionId);
        r10.writeLong(this.versionCode);
        r10.writeString(this.scmVersion);
        r10.writeInt(this.useCount);
    }

    public PackageUseCountInfo(String r10, boolean r11, String r12, long r13, String r14, int r15) {
        Intrinsics.checkNotNullParameter(r10, "packageName");
        Intrinsics.checkNotNullParameter(r12, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "scmVersion");
        this.packageName = r10;
        this.isDebug = r11;
        this.sessionId = r12;
        this.versionCode = r13;
        this.scmVersion = r14;
        this.useCount = r15;
    }
}
