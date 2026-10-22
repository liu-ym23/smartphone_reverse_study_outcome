package com.larus.photopicker.v2.impl.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0006\u0010\u0015\u001a\u00020\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006#"}, d2 = {"Lcom/larus/photopicker/v2/impl/data/model/LazyLoadConfig;", "Landroid/os/Parcelable;", "scrollThreshold", "", "pageSize", "preloadBuffer", "delayLoadOffscreenPageLimitDuration", "", "<init>", "(IIIJ)V", "getScrollThreshold", "()I", "getPageSize", "getPreloadBuffer", "getDelayLoadOffscreenPageLimitDuration", "()J", "component1", "component2", "component3", "component4", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class LazyLoadConfig implements Parcelable {
    public static final Parcelable.Creator<LazyLoadConfig> CREATOR = null;
    public static final LazyLoadConfig e = null;
    public final int a;
    public final int b;
    public final int c;
    public final long d;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<LazyLoadConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final LazyLoadConfig createFromParcel(Parcel r8) {
            Intrinsics.checkNotNullParameter(r8, "parcel");
            return new LazyLoadConfig(r8.readInt(), r8.readInt(), r8.readInt(), r8.readLong());
        }

        @Override // android.os.Parcelable.Creator
        public final LazyLoadConfig[] newArray(int r1) {
            return new LazyLoadConfig[r1];
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof LazyLoadConfig) == true) goto L8;
        return false;
    L8:
        LazyLoadConfig r9 = (LazyLoadConfig) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L15;
        return false;
    L15:
        if (this.c == r9.c) goto L18;
        return false;
    L18:
        if (this.d == r9.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((this.a * 31) + this.b) * 31) + this.c) * 31;
        long r1 = this.d;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "LazyLoadConfig(scrollThreshold=" + this.a + ", pageSize=" + this.b + ", preloadBuffer=" + this.c + ", delayLoadOffscreenPageLimitDuration=" + this.d + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "dest");
        r3.writeInt(this.a);
        r3.writeInt(this.b);
        r3.writeInt(this.c);
        r3.writeLong(this.d);
    }

    static {
        CREATOR = new b();
        e = new LazyLoadConfig(15, 64, 16, 100);
    }

    public LazyLoadConfig(int r1, int r2, int r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
