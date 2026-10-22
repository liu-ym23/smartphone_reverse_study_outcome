package com.obric.memorydata.awareness.har;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/awareness/har/HarEvent;", "", "state", "", "timestamp", "", "<init>", "(IJ)V", "getState", "()I", "getTimestamp", "()J", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class HarEvent {
    private final int state;
    private final long timestamp;

    public HarEvent(int r1, long r2) {
        this.state = r1;
        this.timestamp = r2;
    }

    public static /* synthetic */ HarEvent copy$default(HarEvent r0, int r1, long r2, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.state;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.timestamp;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.state;
    }

    public final long component2() {
        return this.timestamp;
    }

    public final HarEvent copy(int r1, long r2) {
        return new HarEvent(r1, r2);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, HarEvent.class) == true) goto L8;
        return false;
    L8:
        HarEvent r8 = (HarEvent) ZeusTransformUtils.preCheckCast(r7, HarEvent.class, "com.obric.memorydata.plugin");
        if (this.state == r8.state) goto L12;
        return false;
    L12:
        if (this.timestamp == r8.timestamp) goto L14;
        return false;
    L14:
        return true;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (Integer.hashCode(this.state) * 31) + Long.hashCode(this.timestamp);
    }

    public String toString() {
        return "HarEvent(state=" + this.state + ", timestamp=" + this.timestamp + ", time=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date(this.timestamp)) + ')';
    }
}
