package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/VideoActionContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/realtime/VideoActionContext;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/realtime/VideoActionContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class VideoActionContext$CREATOR implements Parcelable.Creator<VideoActionContext> {
    private VideoActionContext$CREATOR() {
    }

    public /* synthetic */ VideoActionContext$CREATOR(DefaultConstructorMarker r1) {
        this();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VideoActionContext createFromParcel(Parcel r9) {
        Intrinsics.checkNotNullParameter(r9, "source");
        String r3 = r9.readString();
        Intrinsics.checkNotNull(r3);
        String r4 = r9.readString();
        Intrinsics.checkNotNull(r4);
        String r5 = r9.readString();
        Intrinsics.checkNotNull(r5);
        return new VideoActionContext(0, r3, r4, r5, 1, null);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ VideoActionContext[] newArray(int r1) {
        return newArray(r1);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ VideoActionContext createFromParcel(Parcel r1) {
        return createFromParcel(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public VideoActionContext[] newArray(int r1) {
        return new VideoActionContext[r1];
    }
}
