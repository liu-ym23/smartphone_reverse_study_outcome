package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ViewTreeOption;", "Landroid/os/Parcelable;", "includeInvisibleNode", "", "cacheValidDuration", "", "<init>", "(ZJ)V", "getIncludeInvisibleNode", "()Z", "getCacheValidDuration", "()J", "component1", "component2", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ViewTreeOption implements Parcelable {
    public static final Parcelable.Creator<ViewTreeOption> CREATOR = null;
    private final long cacheValidDuration;
    private final boolean includeInvisibleNode;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ViewTreeOption> {
        public a() {
        }

        public final ViewTreeOption a(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            if (r4.readInt() == 0) goto L5;
            boolean r0 = true;
        L7:
            return new ViewTreeOption(r0, r4.readLong());
        L5:
            r0 = false;
            goto L7
        }

        public final ViewTreeOption[] a(int r1) {
            return new ViewTreeOption[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ViewTreeOption createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ViewTreeOption[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ViewTreeOption() {
        this(false, 0, 3, null);
    }

    public ViewTreeOption(boolean r1, long r2) {
        this.includeInvisibleNode = r1;
        this.cacheValidDuration = r2;
    }

    public /* synthetic */ ViewTreeOption(boolean r1, long r2, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = false;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r2 = 1000;
    L8:
        this(r1, r2);
    }

    public static /* synthetic */ ViewTreeOption copy$default(ViewTreeOption r0, boolean r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.includeInvisibleNode;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.cacheValidDuration;
    L9:
        return r0.copy(r1, r2);
    }

    public final boolean component1() {
        return this.includeInvisibleNode;
    }

    public final long component2() {
        return this.cacheValidDuration;
    }

    public final ViewTreeOption copy(boolean r1, long r2) {
        return new ViewTreeOption(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ViewTreeOption.class) == true) goto L8;
        return false;
    L8:
        ViewTreeOption r8 = (ViewTreeOption) ZeusTransformUtils.preCheckCast(r7, ViewTreeOption.class, "com.obric.memorydata.plugin");
        if (this.includeInvisibleNode == r8.includeInvisibleNode) goto L12;
        return false;
    L12:
        if (this.cacheValidDuration == r8.cacheValidDuration) goto L14;
        return false;
    L14:
        return true;
    }

    public final long getCacheValidDuration() {
        return this.cacheValidDuration;
    }

    public final boolean getIncludeInvisibleNode() {
        return this.includeInvisibleNode;
    }

    public int hashCode() {
        return (Boolean.hashCode(this.includeInvisibleNode) * 31) + Long.hashCode(this.cacheValidDuration);
    }

    public String toString() {
        return "ViewTreeOption(includeInvisibleNode=" + this.includeInvisibleNode + ", cacheValidDuration=" + this.cacheValidDuration + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.includeInvisibleNode ? 1 : 0);
        r3.writeLong(this.cacheValidDuration);
    }
}
