package com.ss.android.lark.optrace.extension.clientduration;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import java.io.Serializable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class TracingClientDurationEvent implements Serializable, Parcelable {
    public static final Parcelable.Creator<TracingClientDurationEvent> CREATOR = null;
    private volatile boolean finished;
    private final long startTime;

    public class a implements Parcelable.Creator<TracingClientDurationEvent> {
        public a() {
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationEvent createFromParcel(Parcel r2) {
            return new TracingClientDurationEvent(r2);
        }

        @Override // android.os.Parcelable.Creator
        public final TracingClientDurationEvent[] newArray(int r1) {
            return new TracingClientDurationEvent[r1];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public void finish() {
        this.finished = true;
    }

    static {
        CREATOR = new a();
    }

    public String toString() {
        return "TracingClientDurationEvent{finished=" + this.finished + ", startTime=" + this.startTime + '}';
    }

    public TracingClientDurationEvent() {
        this.startTime = SystemClock.elapsedRealtime();
        this.finished = false;
    }

    public long duration() {
        return SystemClock.elapsedRealtime() - this.startTime;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public TracingClientDurationEvent(Parcel r3) {
        if (r3.readByte() == 0) goto L5;
        boolean r0 = true;
    L6:
        this.finished = r0;
        this.startTime = r3.readLong();
        return;
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeByte(this.finished ? 1 : 0);
        r3.writeLong(this.startTime);
    }
}
