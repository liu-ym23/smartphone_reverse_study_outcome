package com.obric.memorydata.sdk.screencapture.rule;

import android.os.Parcel;
import android.os.Parcelable;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0006\u0010\u000f\u001a\u00020\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0005HÖ\u0001J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotCacheStrategy;", "Landroid/os/Parcelable;", "strategy", "Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "uniqueNodeViewId", "", "<init>", "(Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;Ljava/lang/String;)V", "getStrategy", "()Lcom/obric/memorydata/sdk/screencapture/rule/CacheStrategy;", "getUniqueNodeViewId", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ScreenshotCacheStrategy implements Parcelable {
    public static final Parcelable.Creator<ScreenshotCacheStrategy> CREATOR = null;
    private final CacheStrategy strategy;
    private final String uniqueNodeViewId;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class a implements Parcelable.Creator<ScreenshotCacheStrategy> {
        public a() {
        }

        public final ScreenshotCacheStrategy a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new ScreenshotCacheStrategy(CacheStrategy.valueOf(r2.readString()), r2.readString());
        }

        public final ScreenshotCacheStrategy[] a(int r1) {
            return new ScreenshotCacheStrategy[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenshotCacheStrategy createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ ScreenshotCacheStrategy[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public ScreenshotCacheStrategy(CacheStrategy r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "strategy");
        this.strategy = r2;
        this.uniqueNodeViewId = r3;
    }

    public /* synthetic */ ScreenshotCacheStrategy(CacheStrategy r1, String r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2);
    }

    public static /* synthetic */ ScreenshotCacheStrategy copy$default(ScreenshotCacheStrategy r0, CacheStrategy r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.strategy;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.uniqueNodeViewId;
    L9:
        return r0.copy(r1, r2);
    }

    public final CacheStrategy component1() {
        return this.strategy;
    }

    public final String component2() {
        return this.uniqueNodeViewId;
    }

    public final ScreenshotCacheStrategy copy(CacheStrategy r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, "strategy");
        return new ScreenshotCacheStrategy(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, ScreenshotCacheStrategy.class) == true) goto L8;
        return false;
    L8:
        ScreenshotCacheStrategy r6 = (ScreenshotCacheStrategy) ZeusTransformUtils.preCheckCast(r5, ScreenshotCacheStrategy.class, "com.obric.memorydata.plugin");
        if (this.strategy == r6.strategy) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.uniqueNodeViewId, r6.uniqueNodeViewId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final CacheStrategy getStrategy() {
        return this.strategy;
    }

    public final String getUniqueNodeViewId() {
        return this.uniqueNodeViewId;
    }

    public int hashCode() {
        int r0 = this.strategy.hashCode() * 31;
        String r1 = this.uniqueNodeViewId;
        if (r1 != null) goto L5;
        int r2 = 0;
    L7:
        return r0 + r2;
    L5:
        r2 = r1.hashCode();
        goto L7
    }

    public String toString() {
        return "ScreenshotCacheStrategy(strategy=" + this.strategy + ", uniqueNodeViewId=" + this.uniqueNodeViewId + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeString(this.strategy.name());
        r1.writeString(this.uniqueNodeViewId);
    }
}
