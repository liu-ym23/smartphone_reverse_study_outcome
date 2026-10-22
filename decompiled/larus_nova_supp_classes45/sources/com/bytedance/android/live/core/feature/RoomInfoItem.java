package com.bytedance.android.live.core.feature;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\b\u0007\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/live/core/feature/RoomInfoItem;", "", "anchorId", "", "roomId", "deviceId", "userCount", "fansCount", "liveType", "roomMethod", "(JJJJJJJ)V", "getAnchorId", "()J", "getDeviceId", "getFansCount", "getLiveType", "getRoomId", "getRoomMethod", "getUserCount", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RoomInfoItem {
    private final long anchorId;
    private final long deviceId;
    private final long fansCount;
    private final long liveType;
    private final long roomId;
    private final long roomMethod;
    private final long userCount;

    public final long getAnchorId() {
        return this.anchorId;
    }

    public final long getDeviceId() {
        return this.deviceId;
    }

    public final long getFansCount() {
        return this.fansCount;
    }

    public final long getLiveType() {
        return this.liveType;
    }

    public final long getRoomId() {
        return this.roomId;
    }

    public final long getRoomMethod() {
        return this.roomMethod;
    }

    public final long getUserCount() {
        return this.userCount;
    }

    public RoomInfoItem(long r1, long r3, long r5, long r7, long r9, long r11, long r13) {
        this.anchorId = r1;
        this.roomId = r3;
        this.deviceId = r5;
        this.userCount = r7;
        this.fansCount = r9;
        this.liveType = r11;
        this.roomMethod = r13;
    }

    public /* synthetic */ RoomInfoItem(long r19, long r21, long r23, long r25, long r27, long r29, long r31, int r33, DefaultConstructorMarker r34) {
        if ((r33 & 4) == 0) goto L5;
        long r8 = 0;
    L7:
        if ((r33 & 8) == 0) goto L9;
        long r11 = 0;
    L11:
        if ((r33 & 16) == 0) goto L13;
        long r12 = 0;
    L15:
        if ((r33 & 32) == 0) goto L17;
        long r14 = 0;
    L19:
        if ((r33 & 64) == 0) goto L21;
        long r16 = 0;
    L22:
        this(r19, r21, r8, r11, r12, r14, r16);
        return;
    L21:
        r16 = r31;
        goto L22
    L17:
        r14 = r29;
        goto L19
    L13:
        r12 = r27;
        goto L15
    L9:
        r11 = r25;
        goto L11
    L5:
        r8 = r23;
        goto L7
    }
}
