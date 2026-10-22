package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class VideoImage implements Key, Serializable {
    private static final String TAG = "VideoImage";
    private volatile byte[] cacheKeyBytes;
    private long lastModified;
    private String path;

    public int hashCode() {
        return Objects.hash(new Object[]{this.path, Long.valueOf(this.lastModified)});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = getKey().getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String getKey() {
        return this.path + "_" + this.lastModified;
    }

    public long getLastModified() {
        return this.lastModified;
    }

    public String getPath() {
        return this.path;
    }

    public VideoImage(String r3) {
        this.lastModified = 0;
        this.path = r3;
        PolarisFileWrapper r0 = new PolarisFileWrapper(r3);
        if (r0.exists() == false) goto L6;
        this.lastModified = r0.lastModified();
        return;
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof VideoImage) == true) goto L8;
        return false;
    L8:
        VideoImage r9 = (VideoImage) r8;
        if (this.lastModified == r9.lastModified) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.path, r9.path) == false) goto L13;
        return true;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }
}
