package com.bytedance.android.livesdk.chatroom.ui;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/ui/VideoViewParams;", "Landroid/os/Parcelable;", "vs-model_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class VideoViewParams implements Parcelable {
    public static final Parcelable.Creator<VideoViewParams> CREATOR = null;
    public final int a;
    public final int b;
    public final int c;
    public final float d;

    public static class a implements Parcelable.Creator<VideoViewParams> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final VideoViewParams createFromParcel(Parcel r5) {
            Intrinsics.checkNotNullParameter(r5, "in");
            return new VideoViewParams(r5.readInt(), r5.readInt(), r5.readInt(), r5.readFloat());
        }

        @Override // android.os.Parcelable.Creator
        public final VideoViewParams[] newArray(int r1) {
            return new VideoViewParams[r1];
        }
    }

    static {
        CREATOR = new a();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + Float.floatToIntBits(this.d);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        r1.writeInt(this.a);
        r1.writeInt(this.b);
        r1.writeInt(this.c);
        r1.writeFloat(this.d);
    }

    public final String toString() {
        return "VideoViewParams[" + hashCode() + "]: width=" + this.a + ", height=" + this.b + ", marginTop=" + this.c + ", xOffset=" + this.d;
    }

    public final boolean equals(Object r3) {
        if ((r3 instanceof VideoViewParams) == true) goto L5;
        r3 = null;
    L5:
        VideoViewParams r4 = (VideoViewParams) r3;
        if (r4 != null) goto L8;
        return false;
    L8:
        if (r4.a == this.a) goto L10;
        return false;
    L10:
        if (r4.b == this.b) goto L12;
        return false;
    L12:
        if (r4.c == this.c) goto L14;
        return false;
    L14:
        if (r4.d != this.d) goto L22;
        return true;
    L22:
        return false;
    }

    public VideoViewParams(int r1, int r2, int r3, float r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
