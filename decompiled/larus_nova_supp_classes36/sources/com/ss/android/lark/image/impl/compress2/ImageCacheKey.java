package com.ss.android.lark.image.impl.compress2;

import android.text.TextUtils;
import com.larksuite.framework.utils.s;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
class ImageCacheKey {
    private int expectQuality;
    private int expectShortSize;
    private String fileKey;

    /* JADX INFO: renamed from: com.ss.android.lark.image.impl.compress2.ImageCacheKey$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static final class Builder {
        private int expectQuality;
        private int expectShortSize;
        private String fileKey;

        public ImageCacheKey build() {
            return new ImageCacheKey(this, null);
        }

        public String toKey() {
            return ImageCacheKey.access$500(build());
        }

        private Builder() {
        }

        public /* synthetic */ Builder(AnonymousClass1 r1) {
            this();
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.fileKey;
        }

        public static /* synthetic */ int access$100(Builder r0) {
            return r0.expectShortSize;
        }

        public static /* synthetic */ int access$200(Builder r0) {
            return r0.expectQuality;
        }

        public Builder expectQuality(int r1) {
            this.expectQuality = r1;
            return this;
        }

        public Builder expectShortSize(int r1) {
            this.expectShortSize = r1;
            return this;
        }

        public Builder fileKey(String r1) {
            this.fileKey = r1;
            return this;
        }
    }

    public static Builder newBuilder() {
        return new Builder(null);
    }

    private String toKey() {
        String r0 = s.b(this.fileKey);
        if (TextUtils.isEmpty(r0) == false) goto L6;
        r0 = String.valueOf(Objects.hashCode(this.fileKey));
    L6:
        return String.format("%s_%d_%d", new Object[]{r0, Integer.valueOf(this.expectQuality), Integer.valueOf(this.expectShortSize)});
    }

    private ImageCacheKey(Builder r2) {
        this.fileKey = Builder.access$000(r2);
        this.expectShortSize = Builder.access$100(r2);
        this.expectQuality = Builder.access$200(r2);
    }

    public static /* synthetic */ String access$500(ImageCacheKey r0) {
        return r0.toKey();
    }

    public /* synthetic */ ImageCacheKey(Builder r1, AnonymousClass1 r2) {
        this(r1);
    }
}
