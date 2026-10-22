package com.bytedance.memory.heap;

import java.io.File;
import java.io.Serializable;
import p3.g;

/* JADX INFO: loaded from: classes.dex */
public final class HeapDump implements Serializable {
    public boolean computeRetainedHeapSize;
    public long currentTime;
    public final long gcDurationMs;
    public final long heapDumpDurationMs;
    public File heapDumpFile;
    public long heapDumpFileSize;
    public boolean isDebug;
    public String referenceClassName;
    public final String referenceKey;
    public final String referenceName;
    public String shrinkFilePath;
    public final long watchDurationMs;

    static /* synthetic */ class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        boolean f2151a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        File f2152b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        String f2153c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        String f2154d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        String f2155e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        long f2156f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        long f2157g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f2158h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        boolean f2159i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        long f2160j;

        b() {
            this.f2152b = null;
            this.f2154d = null;
            this.f2151a = true;
            this.f2155e = "";
            this.f2156f = 0;
            this.f2157g = 0;
            this.f2158h = 0;
            this.f2159i = true;
        }

        public HeapDump a() {
            g.a(this.f2152b, "heapDumpFile");
            return new HeapDump(this, null);
        }

        public b b(boolean r10) {
            this.f2159i = r10;
            return this;
        }

        public b c(long r10) {
            this.f2160j = r10;
            return this;
        }

        public b d(boolean r10) {
            this.f2151a = r10;
            return this;
        }

        public b e(long r10) {
            this.f2157g = r10;
            return this;
        }

        public b f(long r10) {
            this.f2158h = r10;
            return this;
        }

        public b g(File r10) {
            this.f2152b = (File) g.a(r10, "heapDumpFile");
            return this;
        }

        public b h(long r10) {
            return this;
        }

        public b i(boolean r10) {
            this.f2151a = r10;
            return this;
        }

        public b j(String r10) {
            this.f2154d = (String) g.a(r10, "referenceKey");
            return this;
        }

        public b k(String r10) {
            this.f2155e = (String) g.a(r10, "referenceName");
            return this;
        }

        public b l(String r10) {
            this.f2153c = r10;
            return this;
        }

        public b m(long r10) {
            this.f2156f = r10;
            return this;
        }
    }

    private HeapDump(b r10) {
        this.isDebug = true;
        this.computeRetainedHeapSize = true;
        this.isDebug = r10.f2151a;
        this.currentTime = r10.f2160j;
        this.heapDumpFile = r10.f2152b;
        this.referenceKey = r10.f2154d;
        this.referenceName = r10.f2155e;
        this.computeRetainedHeapSize = r10.f2159i;
        this.watchDurationMs = r10.f2156f;
        this.shrinkFilePath = r10.f2153c;
        this.gcDurationMs = r10.f2157g;
        this.heapDumpDurationMs = r10.f2158h;
    }

    /* synthetic */ HeapDump(b r10, a r11) {
        this(r10);
    }

    @Deprecated
    public HeapDump(File r10, String r11, String r12, long r13, long r14, long r15, boolean r16) {
        this(new b().g(r10).j(r11).k(r12).d(r16).b(true).m(r13).e(r14).f(r15));
    }

    public static b newBuilder() {
        return new b();
    }

    public String toString() {
        return " heapDumpFilePath " + this.heapDumpFile.getPath() + "\n heapDumpFileSize " + this.heapDumpFile.length() + "\n referenceName " + this.referenceName + "\n isDebug " + this.isDebug + "\n currentTime " + this.currentTime + "\n watchDurationMs " + this.watchDurationMs + "ms\n gcDurationMs " + this.gcDurationMs + "ms\n shrinkFilePath " + this.shrinkFilePath + "\n heapDumpDurationMs " + this.heapDumpDurationMs + "ms\n";
    }
}
