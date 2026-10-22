package com.bytedance.ai.model.objects;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.j;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0013\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001$B7\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0002\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\f\u0010\u0010J\u001f\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\nH\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001a\u001a\u0004\b\u0005\u0010\u001bR\u0017\u0010\u0006\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u001c\u0010\u0019R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b \u0010\u0019R\u0017\u0010\u000b\u001a\u00020\n8\u0006¢\u0006\f\n\u0004\b\u000b\u0010!\u001a\u0004\b\"\u0010\u0016¨\u0006%"}, d2 = {"Lcom/bytedance/ai/model/objects/PackageUseCountInfo;", "Landroid/os/Parcelable;", "", "packageName", "", "isDebug", "sessionId", "", "versionCode", "scmVersion", "", "useCount", "<init>", "(Ljava/lang/String;ZLjava/lang/String;JLjava/lang/String;I)V", "Landroid/os/Parcel;", "parcel", "(Landroid/os/Parcel;)V", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Ljava/lang/String;", "getPackageName", "()Ljava/lang/String;", "Z", "()Z", "getSessionId", "J", "getVersionCode", "()J", "getScmVersion", "I", "getUseCount", "CREATOR", "w2/j", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PackageUseCountInfo implements Parcelable {
    public static final j CREATOR = null;
    private final boolean isDebug;
    private final String packageName;
    private final String scmVersion;
    private final String sessionId;
    private final int useCount;
    private final long versionCode;

    static {
        CREATOR = new j();
    }

    public PackageUseCountInfo(String r5, boolean r10, String r11, long r12, String r13, int r14) {
        Intrinsics.checkNotNullParameter(r5, "packageName");
        Intrinsics.checkNotNullParameter(r11, "sessionId");
        Intrinsics.checkNotNullParameter(r13, "scmVersion");
        this.packageName = r5;
        this.isDebug = r10;
        this.sessionId = r11;
        this.versionCode = r12;
        this.scmVersion = r13;
        this.useCount = r14;
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

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeString(this.packageName);
        r5.writeByte(this.isDebug ? 1 : 0);
        r5.writeString(this.sessionId);
        r5.writeLong(this.versionCode);
        r5.writeString(this.scmVersion);
        r5.writeInt(this.useCount);
    }

    public PackageUseCountInfo(Parcel r10) {
        Intrinsics.checkNotNullParameter(r10, "parcel");
        String r5 = r10.readString();
        Intrinsics.checkNotNull(r5);
        if (r10.readByte() == 0) goto L6;
        boolean r11 = true;
    L5:
        boolean r12 = r11;
        String r13 = r10.readString();
        if (r13 != null) goto L10;
        String r14 = "";
    L11:
        long r15 = r10.readLong();
        String r16 = r10.readString();
        if (r16 != null) goto L14;
        String r17 = "";
    L15:
        this(r5, r12, r14, r15, r17, r10.readInt());
        return;
    L14:
        r17 = r16;
        goto L15
    L10:
        r14 = r13;
        goto L11
    L6:
        r11 = false;
        goto L5
    }
}
