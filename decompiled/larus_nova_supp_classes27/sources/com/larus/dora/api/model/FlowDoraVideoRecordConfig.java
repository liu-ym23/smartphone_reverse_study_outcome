package com.larus.dora.api.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \"2\u00020\u0001:\u0001\"B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J'\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\u0017\u001a\u00020\u0003J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\u0016\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0003R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000bR\u001a\u0010\u0005\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\t\"\u0004\b\u000f\u0010\u000b¨\u0006#"}, d2 = {"Lcom/larus/dora/api/model/FlowDoraVideoRecordConfig;", "Landroid/os/Parcelable;", "secondDuration", "", "videoResolution", "videoRatio", "<init>", "(III)V", "getSecondDuration", "()I", "setSecondDuration", "(I)V", "getVideoResolution", "setVideoResolution", "getVideoRatio", "setVideoRatio", "deepCopy", "toString", "", "component1", "component2", "component3", "copy", "describeContents", "equals", "", "other", "", "hashCode", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowDoraVideoRecordConfig implements Parcelable {
    public static final Parcelable.Creator<FlowDoraVideoRecordConfig> CREATOR = null;
    public int a;
    public int b;
    public int c;

    public static final class a {
    }

    public static final class b implements Parcelable.Creator<FlowDoraVideoRecordConfig> {
        public b() {
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDoraVideoRecordConfig createFromParcel(Parcel r4) {
            Intrinsics.checkNotNullParameter(r4, "parcel");
            return new FlowDoraVideoRecordConfig(r4.readInt(), r4.readInt(), r4.readInt());
        }

        @Override // android.os.Parcelable.Creator
        public final FlowDoraVideoRecordConfig[] newArray(int r1) {
            return new FlowDoraVideoRecordConfig[r1];
        }
    }

    static {
        CREATOR = new b();
    }

    public FlowDoraVideoRecordConfig() {
        this(0);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FlowDoraVideoRecordConfig) == true) goto L8;
        return false;
    L8:
        FlowDoraVideoRecordConfig r6 = (FlowDoraVideoRecordConfig) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeInt(this.a);
        r1.writeInt(this.b);
        r1.writeInt(this.c);
    }

    public final FlowDoraVideoRecordConfig a() {
        FlowDoraVideoRecordConfig r0 = new FlowDoraVideoRecordConfig(0);
        r0.a = this.a;
        r0.b = this.b;
        r0.c = this.c;
        return r0;
    }

    public final String toString() {
        return "FlowDoraVideoRecordConfig(secondDuration=" + this.a + ", videoResolution=" + this.b + ", videoRatio=" + this.c + ')';
    }

    public /* synthetic */ FlowDoraVideoRecordConfig(int r2) {
        this(180, 0, 0);
    }

    public FlowDoraVideoRecordConfig(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
