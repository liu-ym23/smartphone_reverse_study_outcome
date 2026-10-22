package com.bytedance.gkfs.io;

import java.io.InputStream;
import kotlin.Lazy;
import kotlin.LazyKt;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f4854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f4855b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f4856c;
    public final cb.a d;
    public final com.bytedance.gkfs.storage.e e;

    public b(f r5, cb.a r10, com.bytedance.gkfs.storage.e r11) {
        this.f4856c = r5;
        this.d = r10;
        this.e = r11;
        this.f4854a = LazyKt.lazy(new ChunkBuffer$source$2(this));
    }

    public final String toString() {
        return "ChunkBuffer@" + hashCode() + '#' + this.f4856c.f4865a + "(totalSize=" + this.e.f4928i + ", totalReadCount=" + this.f4855b + ", available=" + ((InputStream) this.f4854a.getValue()).available() + ')';
    }
}
