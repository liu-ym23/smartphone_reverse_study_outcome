package com.ss.android.lark.image.impl.compress2;

import java.io.File;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class CompressResult {
    public File compressImageFile;
    public final Throwable error;
    public int originHeight;
    public long originSize;
    public int originWidth;
    public int outHeight;
    public long outSize;
    public int outWidth;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.CompressResult$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private File compressImageFile;
        private Throwable error;
        private int originHeight;
        private long originSize;
        private int originWidth;
        private int outHeight;
        private long outSize;
        private int outWidth;

        public CompressResult build() {
            return new CompressResult(this, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ Throwable access$000(Builder r0) {
            return r0.error;
        }

        public static /* synthetic */ int access$100(Builder r0) {
            return r0.outWidth;
        }

        public static /* synthetic */ int access$200(Builder r0) {
            return r0.outHeight;
        }

        public static /* synthetic */ long access$300(Builder r2) {
            return r2.outSize;
        }

        public static /* synthetic */ int access$400(Builder r0) {
            return r0.originWidth;
        }

        public static /* synthetic */ int access$500(Builder r0) {
            return r0.originHeight;
        }

        public static /* synthetic */ long access$600(Builder r2) {
            return r2.originSize;
        }

        public static /* synthetic */ File access$700(Builder r0) {
            return r0.compressImageFile;
        }

        public Builder compressImageFile(File r1) {
            this.compressImageFile = r1;
            return this;
        }

        public Builder originHeight(int r1) {
            this.originHeight = r1;
            return this;
        }

        public Builder originSize(long r1) {
            this.originSize = r1;
            return this;
        }

        public Builder originWidth(int r1) {
            this.originWidth = r1;
            return this;
        }

        public Builder outHeight(int r1) {
            this.outHeight = r1;
            return this;
        }

        public Builder outSize(long r1) {
            this.outSize = r1;
            return this;
        }

        public Builder outWidth(int r1) {
            this.outWidth = r1;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    public float getCompressRatio() {
        long r0 = this.outSize;
        if (r0 <= 0) goto L8;
        long r5 = this.originSize;
        if (r5 > 0) goto L7;
        return 1.0f;
    L7:
        return (r0 * 1.0f) / r5;
    L8:
        return 1.0f;
    }

    private CompressResult(Builder r3) {
        this.error = Builder.access$000(r3);
        this.outWidth = Builder.access$100(r3);
        this.outHeight = Builder.access$200(r3);
        this.outSize = Builder.access$300(r3);
        this.originWidth = Builder.access$400(r3);
        this.originHeight = Builder.access$500(r3);
        this.originSize = Builder.access$600(r3);
        this.compressImageFile = Builder.access$700(r3);
    }

    public CompressResult(Throwable r1) {
        this.error = r1;
    }

    public /* synthetic */ CompressResult(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
