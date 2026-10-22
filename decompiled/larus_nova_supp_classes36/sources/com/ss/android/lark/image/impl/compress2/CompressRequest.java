package com.ss.android.lark.image.impl.compress2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class CompressRequest {
    IImageSource iImageSource;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.CompressRequest$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private IImageSource iImageSource;

        public CompressRequest build() {
            return new CompressRequest(this, null);
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ IImageSource access$000(Builder r0) {
            return r0.iImageSource;
        }

        public Builder iImageSource(IImageSource r1) {
            this.iImageSource = r1;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    private CompressRequest(Builder r1) {
        this.iImageSource = Builder.access$000(r1);
    }

    public /* synthetic */ CompressRequest(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
