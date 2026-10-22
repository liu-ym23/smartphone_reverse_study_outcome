package com.obric.memorydata.sdk.realtime;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001d\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/obric/memorydata/sdk/realtime/ActionContext$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "<init>", "()V", "createFromParcel", "source", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/obric/memorydata/sdk/realtime/ActionContext;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ActionContext$CREATOR implements Parcelable.Creator<ActionContext> {
    private ActionContext$CREATOR() {
    }

    public /* synthetic */ ActionContext$CREATOR(DefaultConstructorMarker r1) {
        this();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ActionContext createFromParcel(Parcel r3) {
        Intrinsics.checkNotNullParameter(r3, "source");
        int r0 = r3.readInt();
        if (r0 == 1) goto L18;
        if (r0 == 2) goto L23;
        if (r0 == 3) goto L22;
        if (r0 == 4) goto L21;
        if (r0 == 5) goto L20;
        return null;
    L20:
        return VideoActionContext.CREATOR.createFromParcel(r3);
    L21:
        return IMActionContext.CREATOR.createFromParcel(r3);
    L22:
        return WebsiteActionContext.CREATOR.createFromParcel(r3);
    L23:
        return FileActionContext.CREATOR.createFromParcel(r3);
    L18:
        return PhotoActionContext.CREATOR.createFromParcel(r3);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ ActionContext[] newArray(int r1) {
        return newArray(r1);
    }

    @Override // android.os.Parcelable.Creator
    public /* bridge */ /* synthetic */ ActionContext createFromParcel(Parcel r1) {
        return createFromParcel(r1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public ActionContext[] newArray(int r1) {
        return new ActionContext[r1];
    }
}
