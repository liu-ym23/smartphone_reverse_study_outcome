package com.bytedance.android.live.base.model.message;

import java.util.Map;
import kotlin.random.Random;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g6 implements d3 {
    public m0 a;
    public int b;
    public String c;
    public int d;
    public transient long e;
    public boolean f;
    public boolean g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public boolean n;
    public long o;
    public String p;
    public byte[] q;
    public Map<String, String> r;

    public g6() {
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getConsumeTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getDecodeEndTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getDecodeStartTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getEnqueueDispatchTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getHttpSendTime() {
        throw null;
    }

    public final int getIntType() {
        return -1;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final byte[] getRawPayload() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final long getReceiveTime() {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setCommonMessageData(m0 r1) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setGeneralMessageType(int r1) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setMessageExtra(Map<String, String> r1) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setMessageFrom(int r1) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setRawPayload(byte[] r1) {
        throw null;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final void setTimestamp(long r1) {
        throw null;
    }

    public final long getDelayDispatchMs() {
        m0 r0 = this.a;
        if (r0 == null) goto L14;
        Long r1 = Long.valueOf(r0.getRandomDispatchMs());
        if (r1.longValue() <= 0) goto L7;
        boolean r3 = true;
    L8:
        if (r3 == true) goto L11;
        r1 = null;
    L11:
        if (r1 == null) goto L14;
        long r2 = r1.longValue();
        return Random.Default.nextLong(r2);
    L7:
        r3 = false;
    L14:
        return 0;
    }

    public final long getMessageId() {
        m0 r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getMessageId();
    }

    public final long getRoomId() {
        m0 r0 = this.a;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getRoomId();
    }

    public final String getWRDSKey() {
        m0 r0 = this.a;
        if (r0 == null) goto L6;
        String r1 = r0.getMethod();
        if (r1 == null) goto L6;
        return r1;
    L6:
        return "Unknown";
    }

    public final boolean isGlobalMessage() {
        m0 r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.getRoomId() != (-1)) goto L7;
        return true;
    }

    @Override // com.bytedance.android.live.base.model.message.d3
    public final boolean isTimeCostCanUse() {
        if (this.f == false) goto L5;
        return false;
    L5:
        long r2 = this.h;
        if (r2 > 0) goto L8;
    L10:
        long r3 = this.k;
        if (r3 <= this.j) goto L18;
        long r4 = this.l;
        if (r4 > r3) goto L15;
        return false;
    L15:
        if (this.m <= r4) goto L20;
        return true;
    L20:
        return false;
    L18:
        return false;
    L8:
        if (this.i > r2) goto L10;
        return false;
    }

    public final boolean needMonitor() {
        m0 r0 = this.a;
        if (r0 != null) goto L5;
    L6:
        m0 r1 = this.a;
        if (r1 != null) goto L9;
    L11:
        return false;
    L9:
        if (r1.getMonitor() != 2) goto L11;
        return true;
    L5:
        if (r0.getMonitor() != 1) goto L6;
        return true;
    }

    public final int getGeneralMessageType() {
        return this.d;
    }

    public final int getMessageFrom() {
        return this.b;
    }

    public final String getMessageMethod() {
        return this.c;
    }

    public final String getWRDSSubKey() {
        return this.p;
    }

    public final long getWRDSVersion() {
        return this.o;
    }

    public final boolean isFromFirstRequest() {
        return this.g;
    }

    public final boolean isWRDSMessage() {
        return this.n;
    }

    public final void setConsumeTime(long r1) {
        this.m = r1;
    }

    public final void setDecodeEndTime(long r1) {
        this.k = r1;
    }

    public final void setDecodeStartTime(long r1) {
        this.j = r1;
    }

    public final void setEnqueueDispatchTime(long r1) {
        this.l = r1;
    }

    public final void setHttpSendTime(long r1) {
        this.h = r1;
    }

    public final void setIsFromFirstRequest(boolean r1) {
        this.g = r1;
    }

    public final void setIsInsert(boolean r1) {
        this.f = true;
    }

    public final void setMessageMethod(String r1) {
        this.c = r1;
    }

    public final void setReceiveTime(long r1) {
        this.i = r1;
    }

    public final void setWRDSMessage(boolean r1) {
        this.n = r1;
    }

    public final void setWRDSSubKey(String r1) {
        this.p = r1;
    }

    public final void setWRDSVersion(long r1) {
        this.o = r1;
    }
}
