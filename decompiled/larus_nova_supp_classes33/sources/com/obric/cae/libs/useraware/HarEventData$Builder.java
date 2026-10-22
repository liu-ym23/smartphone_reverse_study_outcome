package com.obric.cae.libs.useraware;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class HarEventData$Builder {
    public int a;
    public long b;

    public HarEventData$Builder() {
    }

    public HarEventData build() {
        return new HarEventData(this.a, this.b);
    }

    public HarEventData$Builder setEvent(int r1) {
        this.a = r1;
        return this;
    }

    public HarEventData$Builder setTimestamp(long r1) {
        this.b = r1;
        return this;
    }
}
