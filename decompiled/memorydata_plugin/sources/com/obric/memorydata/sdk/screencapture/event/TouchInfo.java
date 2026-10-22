package com.obric.memorydata.sdk.screencapture.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.MotionEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0006\u0010\r\u001a\u00020\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "Landroid/os/Parcelable;", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TouchInfo implements Parcelable {
    public static final Parcelable.Creator<TouchInfo> CREATOR = null;
    public static final a Companion = null;
    private final float x;
    private final float y;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo$Companion;", "", "<init>", "()V", "create", "Lcom/obric/memorydata/sdk/screencapture/event/TouchInfo;", "event", "Landroid/view/MotionEvent;", "memoryDataSDK_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final TouchInfo a(MotionEvent r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            return new TouchInfo(r2.getX(), r2.getY());
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class b implements Parcelable.Creator<TouchInfo> {
        public b() {
        }

        public final TouchInfo a(Parcel r2) {
            Intrinsics.checkNotNullParameter(r2, "parcel");
            return new TouchInfo(r2.readFloat(), r2.readFloat());
        }

        public final TouchInfo[] a(int r1) {
            return new TouchInfo[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TouchInfo createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* synthetic */ TouchInfo[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        Companion = new a(null);
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new b(), Parcelable.Creator.class, "com.obric.memorydata.plugin");
    }

    public TouchInfo(float r1, float r2) {
        this.x = r1;
        this.y = r2;
    }

    public static /* synthetic */ TouchInfo copy$default(TouchInfo r0, float r1, float r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.x;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.y;
    L9:
        return r0.copy(r1, r2);
    }

    public final float component1() {
        return this.x;
    }

    public final float component2() {
        return this.y;
    }

    public final TouchInfo copy(float r1, float r2) {
        return new TouchInfo(r1, r2);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, TouchInfo.class) == true) goto L8;
        return false;
    L8:
        TouchInfo r6 = (TouchInfo) ZeusTransformUtils.preCheckCast(r5, TouchInfo.class, "com.obric.memorydata.plugin");
        if (Float.compare(this.x, r6.x) == 0) goto L12;
        return false;
    L12:
        if (Float.compare(this.y, r6.y) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public String toString() {
        return "TouchInfo(x=" + this.x + ", y=" + this.y + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "dest");
        r1.writeFloat(this.x);
        r1.writeFloat(this.y);
    }
}
