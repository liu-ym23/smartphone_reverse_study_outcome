package com.obric.memorydata.intelligence.appuse;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/intelligence/appuse/IMovementItem;", "", "timestamp", "", "state", "", "deviceOrientation", "<init>", "(JII)V", "getTimestamp", "()J", "getState", "()I", "getDeviceOrientation", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "intelligence_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class IMovementItem {
    private final int deviceOrientation;
    private final int state;
    private final long timestamp;

    public IMovementItem(long r1, int r3, int r4) {
        this.timestamp = r1;
        this.state = r3;
        this.deviceOrientation = r4;
    }

    public static /* synthetic */ IMovementItem copy$default(IMovementItem r0, long r1, int r3, int r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.timestamp;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = r0.state;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r4 = r0.deviceOrientation;
    L12:
        return r0.copy(r1, r3, r4);
    }

    public final long component1() {
        return this.timestamp;
    }

    public final int component2() {
        return this.state;
    }

    public final int component3() {
        return this.deviceOrientation;
    }

    public final IMovementItem copy(long r1, int r3, int r4) {
        return new IMovementItem(r1, r3, r4);
    }

    public boolean equals(Object r9) {
        if (this != r9) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r9, IMovementItem.class) == true) goto L8;
        return false;
    L8:
        IMovementItem r10 = (IMovementItem) ZeusTransformUtils.preCheckCast(r9, IMovementItem.class, "com.obric.memorydata.plugin");
        if (this.timestamp == r10.timestamp) goto L12;
        return false;
    L12:
        if (this.state == r10.state) goto L15;
        return false;
    L15:
        if (this.deviceOrientation == r10.deviceOrientation) goto L17;
        return false;
    L17:
        return true;
    }

    public final int getDeviceOrientation() {
        return this.deviceOrientation;
    }

    public final int getState() {
        return this.state;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }

    public int hashCode() {
        return (((Long.hashCode(this.timestamp) * 31) + Integer.hashCode(this.state)) * 31) + Integer.hashCode(this.deviceOrientation);
    }

    public String toString() {
        return "IMovementItem(timestamp=" + this.timestamp + ", state=" + this.state + ", deviceOrientation=" + this.deviceOrientation + ')';
    }
}
