package com.obric.aee.res;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/obric/aee/res/TimePair;", "Landroid/os/Parcelable;", "key", "", CommonConsts.APM_INNER_EVENT_COST_START, "", "finish", "(Ljava/lang/String;JJ)V", "getFinish", "()J", "getKey", "()Ljava/lang/String;", "getStart", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Aee_cryptLiteRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TimePair implements Parcelable {
    public static final Parcelable.Creator<TimePair> CREATOR = null;
    private final long finish;
    private final String key;
    private final long start;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<TimePair> {
        public a() {
        }

        public final TimePair a(Parcel r7) {
            Intrinsics.checkNotNullParameter(r7, "parcel");
            return new TimePair(r7.readString(), r7.readLong(), r7.readLong());
        }

        public final TimePair[] a(int r1) {
            return new TimePair[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimePair createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TimePair[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new a(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public TimePair(String r2, long r3, long r5) {
        Intrinsics.checkNotNullParameter(r2, "key");
        this.key = r2;
        this.start = r3;
        this.finish = r5;
    }

    public static /* synthetic */ TimePair copy$default(TimePair r2, String r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.key;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.start;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.finish;
    L11:
        String r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final String component1() {
        return this.key;
    }

    public final long component2() {
        return this.start;
    }

    public final long component3() {
        return this.finish;
    }

    public final TimePair copy(String r7, long r8, long r10) {
        Intrinsics.checkNotNullParameter(r7, "key");
        return new TimePair(r7, r8, r10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, TimePair.class) == true) goto L8;
        return false;
    L8:
        TimePair r10 = (TimePair) ZeusTransformUtils.preCheckCast(r9, TimePair.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.key, r10.key) == true) goto L12;
        return false;
    L12:
        if (this.start == r10.start) goto L15;
        return false;
    L15:
        if (this.finish == r10.finish) goto L17;
        return false;
    L17:
        return true;
    }

    public final long getFinish() {
        return this.finish;
    }

    public final String getKey() {
        return this.key;
    }

    public final long getStart() {
        return this.start;
    }

    public int hashCode() {
        return (((this.key.hashCode() * 31) + Long.hashCode(this.start)) * 31) + Long.hashCode(this.finish);
    }

    public String toString() {
        return "TimePair(key=" + this.key + ", start=" + this.start + ", finish=" + this.finish + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "out");
        r3.writeString(this.key);
        r3.writeLong(this.start);
        r3.writeLong(this.finish);
    }
}
