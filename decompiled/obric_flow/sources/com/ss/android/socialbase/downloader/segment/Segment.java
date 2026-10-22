package com.ss.android.socialbase.downloader.segment;

import androidx.room.jarjarred.org.antlr.runtime.a;
import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class Segment {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f16034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicLong f16035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile long f16036c;
    public long d;
    public int e;
    public volatile SegmentReader f;
    public int g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public JSONObject f16037h;

    public Segment(long r5, long r10) {
        AtomicLong r11 = new AtomicLong();
        this.f16035b = r11;
        this.g = 0;
        this.f16034a = r5;
        r11.set(r5);
        this.f16036c = r5;
        if (r10 < r5) goto L6;
        this.d = r10;
        return;
    L6:
        this.d = -1;
    }

    public final long a() {
        long r5 = this.f16035b.get();
        long r10 = this.d;
        if (r10 <= 0) goto L7;
        long r11 = r10 + 1;
        if (r5 <= r11) goto L7;
        return r11;
    L7:
        return r5;
    }

    public final long b() {
        SegmentReader r5 = this.f;
        if (r5 == null) goto L8;
        long r10 = r5.f16074n;
        if (r10 <= this.f16036c) goto L8;
        return r10;
    L8:
        return this.f16036c;
    }

    public final String toString() {
        StringBuilder r5 = new StringBuilder("Segment{startOffset=");
        r5.append(this.f16034a);
        r5.append(",\t currentOffset=");
        r5.append(this.f16035b);
        r5.append(",\t currentOffsetRead=");
        r5.append(b());
        r5.append(",\t endOffset=");
        return a.t(r5, this.d, '}');
    }

    public final void a(long r5) {
        if (r5 < this.f16034a) goto L7;
        this.d = r5;
        return;
    L7:
        if (Logger.b() == false) goto L10;
        Logger.b("Segment", "setEndOffset", "EndOffset = " + r5 + ", segment = " + this);
    L10:
        if (r5 != (-1)) goto L13;
        this.d = r5;
        return;
    }

    public Segment(Segment r5) {
        AtomicLong r10 = new AtomicLong();
        this.f16035b = r10;
        this.g = 0;
        this.f16034a = r5.f16034a;
        this.d = r5.d;
        r10.set(r5.f16035b.get());
        this.f16036c = r10.get();
        this.e = r5.e;
    }

    public Segment(JSONObject r10) {
        AtomicLong r5 = new AtomicLong();
        this.f16035b = r5;
        this.g = 0;
        long r11 = r10.optLong("st");
        this.f16034a = r11;
        a(r10.optLong("en"));
        long r12 = r10.optLong("cu");
        if (r12 < r11) goto L6;
        r11 = r12;
    L6:
        long r13 = this.d;
        if (r13 <= 0) goto L11;
        long r14 = r13 + 1;
        if (r11 <= r14) goto L11;
        r11 = r14;
    L11:
        r5.set(r11);
        long r15 = a();
        if (r15 < r5.get()) goto L15;
        this.f16036c = r15;
        return;
    }
}
