package com.larus.uaigc.lynx.pocket;

import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/larus/uaigc/lynx/pocket/RoundInfo;", "", "roundNum", "", "hasSendMessage", "", "<init>", "(IZ)V", "getRoundNum", "()I", "getHasSendMessage", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class RoundInfo {
    private final boolean hasSendMessage;
    private final int roundNum;

    /* JADX WARN: Multi-variable type inference failed */
    public RoundInfo() {
        int r2 = 0;
        Object[] r3 = 0 == true ? 1 : 0;
        this(r2, r3, 3, null);
    }

    public static /* synthetic */ RoundInfo copy$default(RoundInfo r0, int r1, boolean r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.roundNum;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.hasSendMessage;
    L9:
        return r0.copy(r1, r2);
    }

    public final int component1() {
        return this.roundNum;
    }

    public final boolean component2() {
        return this.hasSendMessage;
    }

    public final RoundInfo copy(int r2, boolean r3) {
        return new RoundInfo(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RoundInfo) == true) goto L8;
        return false;
    L8:
        RoundInfo r6 = (RoundInfo) r5;
        if (this.roundNum == r6.roundNum) goto L12;
        return false;
    L12:
        if (this.hasSendMessage == r6.hasSendMessage) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r0 = this.roundNum * 31;
        if (this.hasSendMessage == false) goto L5;
        int r1 = 1231;
    L7:
        return r0 + r1;
    L5:
        r1 = 1237;
        goto L7
    }

    public String toString() {
        return "RoundInfo(roundNum=" + this.roundNum + ", hasSendMessage=" + this.hasSendMessage + ')';
    }

    public final boolean getHasSendMessage() {
        return this.hasSendMessage;
    }

    public final int getRoundNum() {
        return this.roundNum;
    }

    public RoundInfo(int r1, boolean r2) {
        this.roundNum = r1;
        this.hasSendMessage = r2;
    }

    public /* synthetic */ RoundInfo(int r1, boolean r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = -1;
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = false;
    L8:
        this(r1, r2);
    }
}
