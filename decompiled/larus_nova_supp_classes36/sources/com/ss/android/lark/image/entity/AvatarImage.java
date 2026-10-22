package com.ss.android.lark.image.entity;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class AvatarImage implements Key, Serializable {
    private static final String LOG_TAG = "AvatarImage";
    private volatile transient byte[] cacheKeyBytes;
    private long createTime;
    private CutType cutType;
    private long decodeStartTime;
    private String entityId;
    private transient ErrorResult errorResult;
    private ImageFormat format;
    private String fsUnit;
    private int height;
    private boolean isOnlyLocal;
    private String key;
    private boolean noop;
    private int quality;
    private long resourceSize;
    private long waitTime;
    private int width;

    public static class Builder {
        private CutType cutType;
        private String entityId;
        private ImageFormat format;
        private String fsUnit;
        private int height;
        private boolean isOnlyLocal;
        private String key;
        private boolean noop;
        private int quality;
        private int width;

        public AvatarImage build() {
            return new AvatarImage(this, null);
        }

        public Builder(String r2) {
            this.width = 0;
            this.height = 0;
            this.cutType = CutType.FACE;
            this.format = ImageFormat.WEBP;
            this.quality = 70;
            this.fsUnit = r2;
        }

        public static /* synthetic */ String access$000(Builder r0) {
            return r0.key;
        }

        public static /* synthetic */ String access$100(Builder r0) {
            return r0.entityId;
        }

        public static /* synthetic */ int access$200(Builder r0) {
            return r0.width;
        }

        public static /* synthetic */ int access$300(Builder r0) {
            return r0.height;
        }

        public static /* synthetic */ CutType access$400(Builder r0) {
            return r0.cutType;
        }

        public static /* synthetic */ ImageFormat access$500(Builder r0) {
            return r0.format;
        }

        public static /* synthetic */ int access$600(Builder r0) {
            return r0.quality;
        }

        public static /* synthetic */ boolean access$700(Builder r0) {
            return r0.noop;
        }

        public static /* synthetic */ boolean access$800(Builder r0) {
            return r0.isOnlyLocal;
        }

        public static /* synthetic */ String access$900(Builder r0) {
            return r0.fsUnit;
        }

        public Builder cutType(CutType r1) {
            this.cutType = r1;
            return this;
        }

        public Builder format(ImageFormat r1) {
            this.format = r1;
            return this;
        }

        public Builder fsUnit(String r1) {
            this.fsUnit = r1;
            return this;
        }

        public Builder isOnlyLocal(boolean r1) {
            this.isOnlyLocal = r1;
            return this;
        }

        public Builder noop(boolean r1) {
            this.noop = r1;
            return this;
        }

        public Builder quality(int r1) {
            this.quality = r1;
            return this;
        }

        private Builder(String r2, String r3, int r4, int r5) {
            this.width = 0;
            this.height = 0;
            this.cutType = CutType.FACE;
            this.format = ImageFormat.WEBP;
            this.quality = 70;
            this.key = r2;
            this.entityId = r3;
            this.width = r4;
            this.height = r5;
        }

        public static Builder obtain(String r1, String r2, int r3, int r4) {
            return new Builder(r1, r2, r3, r4);
        }
    }

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[ImageFormat.values().length];
            a = r0;
            r0[ImageFormat.PNG.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L10:
            a[ImageFormat.JPEG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L12:
            a[ImageFormat.HEIC.ordinal()] = 3;     // Catch: NoSuchFieldError -> L9
            return;
        }
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getId().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    private String getId() {
        if (this.noop == false) goto L7;
        return this.key + "_origin";
    L7:
        return this.key + "_w" + this.width + "_h" + this.height + "_format" + this.format + "_quality" + this.quality + "isOnlyLocal" + this.isOnlyLocal;
    }

    public long getEntityId() {
        if (TextUtils.isEmpty(this.entityId) == false) goto L9;
        return 0;
    L9:
        return CastLongProtector.parseLong(this.entityId);
    L7:
        Log.e(LOG_TAG, "Failed to convert id to long, avatar is:" + this);
        return 0;
    }

    public String getImageType() {
        ImageFormat r0 = this.format;
        if (r0 != null) goto L5;
        return LoadParams.ImageFormat.WEBP;
    L5:
        int r1 = a.a[r0.ordinal()];
        if (r1 != 1) goto L8;
        return LoadParams.ImageFormat.PNG;
    L8:
        if (r1 != 2) goto L10;
        return "jpg";
    L10:
        if (r1 == 3) goto L12;
        return LoadParams.ImageFormat.WEBP;
    L12:
        return "heic";
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.key, this.entityId, Integer.valueOf(this.width), Integer.valueOf(this.height), this.cutType, this.format, Integer.valueOf(this.quality), Boolean.valueOf(this.noop), Boolean.valueOf(this.isOnlyLocal)});
    }

    public String toString() {
        return "avatar#Key is: " + this.key + ", entityId is: " + this.entityId + ", width is: " + this.width + ", height is: " + this.height;
    }

    public long getCreateTime() {
        return this.createTime;
    }

    public CutType getCutType() {
        return this.cutType;
    }

    public long getDecodeStartTime() {
        return this.decodeStartTime;
    }

    public String getEntityIdStr() {
        return this.entityId;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public ImageFormat getFormat() {
        return this.format;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public int getHeight() {
        return this.height;
    }

    public String getImageId() {
        return this.key;
    }

    public String getKey() {
        return this.key;
    }

    public int getQuality() {
        return this.quality;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public long getWaitTime() {
        return this.waitTime;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean isNoop() {
        return this.noop;
    }

    public boolean isOnlyLocal() {
        return this.isOnlyLocal;
    }

    private AvatarImage(Builder r2) {
        this.width = 0;
        this.height = 0;
        this.cutType = CutType.FACE;
        this.format = ImageFormat.WEBP;
        this.quality = 70;
        this.key = Builder.access$000(r2);
        this.entityId = Builder.access$100(r2);
        this.width = Builder.access$200(r2);
        this.height = Builder.access$300(r2);
        this.cutType = Builder.access$400(r2);
        this.format = Builder.access$500(r2);
        this.quality = Builder.access$600(r2);
        this.noop = Builder.access$700(r2);
        this.isOnlyLocal = Builder.access$800(r2);
        this.fsUnit = Builder.access$900(r2);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L31:
        return false;
    L8:
        if (getClass() != r5.getClass()) goto L31;
        AvatarImage r6 = (AvatarImage) r5;
        if (this.width == r6.width) goto L13;
    L29:
        return false;
    L13:
        if (this.height != r6.height) goto L29;
        if (this.quality != r6.quality) goto L29;
        if (this.noop != r6.noop) goto L29;
        if (this.isOnlyLocal != r6.isOnlyLocal) goto L29;
        if (Objects.equals(this.key, r6.key) == false) goto L29;
        String r2 = this.entityId;
        if (Objects.equals(r2, r2) == false) goto L29;
        if (this.cutType != r6.cutType) goto L29;
        if (this.format != r6.format) goto L29;
        return true;
    }

    public AvatarImage setCutType(CutType r1) {
        this.cutType = r1;
        return this;
    }

    public void setDecodeStartTime(long r1) {
        this.decodeStartTime = r1;
    }

    public void setErrorResult(ErrorResult r1) {
        this.errorResult = r1;
    }

    public AvatarImage setHeight(int r1) {
        this.height = r1;
        return this;
    }

    public AvatarImage setImageFormat(ImageFormat r1) {
        this.format = r1;
        return this;
    }

    public AvatarImage setKey(String r1) {
        this.key = r1;
        return this;
    }

    public AvatarImage setNoop(boolean r1) {
        this.noop = r1;
        return this;
    }

    public AvatarImage setOnlyLocal(boolean r1) {
        this.isOnlyLocal = r1;
        return this;
    }

    public void setResourceSize(long r1) {
        this.resourceSize = r1;
    }

    public void setWaitTime(long r1) {
        this.waitTime = r1;
    }

    public AvatarImage setWidth(int r1) {
        this.width = r1;
        return this;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }

    public /* synthetic */ AvatarImage(Builder r1, a r2) {
        this(r1);
    }
}
