package com.bytedance.android.chunkstreamprediction.network;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final List<a> a;
    public volatile long b;

    public static final class a {
        public volatile long a;
        public volatile long b;
        public volatile long c;
        public volatile long d;
        public volatile long e;
        public volatile long f;
        public volatile int g;

        public final String toString() {
            return super.toString() + ", startTs: " + this.a + ", endTs: " + this.f + ", readFinishTs: " + this.c + ", deserializeFinishTs: " + this.d + ", distributeFinishTs: " + this.e + ", byteCount: " + this.g;
        }

        public a() {
        }
    }

    public final synchronized List<a> a() {
        monitor-enter(this);
        List<a> r0 = this.a;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public c() {
        this.a = new ArrayList();
    }

    public c(List<a> r10, long r11) {
        this.a = new ArrayList(r10);
        this.b = r11;
    }
}
