package com.bytedance.android.live.pushstream.report;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e implements b {
    public final long a;
    public final long b;
    public final Integer c;

    @Override // com.bytedance.android.live.pushstream.report.b
    public final Integer a() {
        return this.c;
    }

    @Override // com.bytedance.android.live.pushstream.report.b
    public final long b() {
        return this.b;
    }

    @Override // com.bytedance.android.live.pushstream.report.b
    public final long getRoomId() {
        return this.a;
    }

    public e(long r1, long r3, Integer r5) {
        this.a = r1;
        this.b = r3;
        this.c = r5;
    }
}
