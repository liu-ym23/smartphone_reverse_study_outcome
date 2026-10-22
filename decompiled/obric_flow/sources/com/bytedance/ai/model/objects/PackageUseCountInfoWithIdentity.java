package com.bytedance.ai.model.objects;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import w2.k;

/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0019B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/ai/model/objects/PackageUseCountInfoWithIdentity;", "Landroid/os/Parcelable;", "Landroid/os/IBinder;", "identity", "", "Lcom/bytedance/ai/model/objects/PackageUseCountInfo;", "packageUseCountInfo", "<init>", "(Landroid/os/IBinder;Ljava/util/List;)V", "Landroid/os/Parcel;", "parcel", "", "flags", "", "writeToParcel", "(Landroid/os/Parcel;I)V", "describeContents", "()I", "Landroid/os/IBinder;", "getIdentity", "()Landroid/os/IBinder;", "Ljava/util/List;", "getPackageUseCountInfo", "()Ljava/util/List;", "CREATOR", "w2/k", "ai-sdk_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PackageUseCountInfoWithIdentity implements Parcelable {
    public static final k CREATOR = null;
    private final IBinder identity;
    private final List<PackageUseCountInfo> packageUseCountInfo;

    static {
        CREATOR = new k();
    }

    public PackageUseCountInfoWithIdentity(IBinder r5, List<PackageUseCountInfo> r10) {
        Intrinsics.checkNotNullParameter(r5, "identity");
        Intrinsics.checkNotNullParameter(r10, "packageUseCountInfo");
        this.identity = r5;
        this.packageUseCountInfo = r10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final IBinder getIdentity() {
        return this.identity;
    }

    public final List<PackageUseCountInfo> getPackageUseCountInfo() {
        return this.packageUseCountInfo;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeStrongBinder(this.identity);
        r5.writeTypedList(this.packageUseCountInfo);
    }
}
