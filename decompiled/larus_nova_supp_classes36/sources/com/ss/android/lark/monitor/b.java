package com.ss.android.lark.monitor;

import androidx.core.util.Pair;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;
    public final String g;
    public final long h;
    public final long i;
    public final double j;
    public final List<Pair<String, Double>> k;

    public static final class a {
        public String a;
        public double b;
        public double c;
        public double d;
        public double e;
        public double f;
        public double g;
        public String h;
        public double i;
        public long j;
        public final List<Pair<String, Double>> k;

        public a() {
            this.k = new CopyOnWriteArrayList();
        }
    }

    public final String toString() {
        return "MetricsPayload{startTime=" + this.h + "endTime=" + this.i + "duration=" + this.j + "cpuTime=" + this.f + "mobileKBTx=" + this.d + ", mobileKBRx=" + this.e + ", wifiKBTx=" + this.b + ", wifiKBRx=" + this.c + '}';
    }

    public b(a r7) {
        this.a = r7.a;
        this.b = r7.b;
        this.c = r7.c;
        this.d = r7.d;
        this.e = r7.e;
        this.g = r7.h;
        this.f = r7.f + r7.g;
        double r0 = r7.i;
        this.j = r0;
        long r2 = r7.j;
        this.h = r2 - ((long) (r0 * 1000.0d));
        this.i = r2;
        this.k = r7.k;
    }
}
