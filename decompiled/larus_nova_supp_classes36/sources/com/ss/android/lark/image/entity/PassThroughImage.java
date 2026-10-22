package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.ImageSetPassThrough;
import com.bytedance.lark.pb.basic.v1.SerCrypto;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class PassThroughImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private SerCrypto crypto;
    private ErrorResult errorResult;
    private ImageSetPassThrough.FileType fileType;
    private String fsUnit;
    private String imageKey;
    private String imageType;
    private long resourceSize;
    private transient Trace trace;

    public int hashCode() {
        return Objects.hash(new Object[]{this.imageKey, this.fsUnit});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.imageKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String toString() {
        return "PassThroughImage{imageKey='" + this.imageKey + "'}";
    }

    public SerCrypto getCrypto() {
        return this.crypto;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public ImageSetPassThrough.FileType getFileType() {
        return this.fileType;
    }

    public String getFsUnit() {
        return this.fsUnit;
    }

    public String getImageKey() {
        return this.imageKey;
    }

    public String getImageType() {
        return this.imageType;
    }

    public long getResourceSize() {
        return this.resourceSize;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof PassThroughImage) == true) goto L8;
        return false;
    L8:
        PassThroughImage r6 = (PassThroughImage) r5;
        if (Objects.equals(this.imageKey, r6.imageKey) == true) goto L11;
    L13:
        return false;
    L11:
        if (Objects.equals(this.fsUnit, r6.fsUnit) == false) goto L13;
        return true;
    }

    public void setErrorResult(ErrorResult r1) {
        this.errorResult = r1;
    }

    public void setImageType(String r1) {
        this.imageType = r1;
    }

    public void setResourceSize(long r1) {
        this.resourceSize = r1;
    }

    public void setTrace(Trace r1) {
        this.trace = r1;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }

    public PassThroughImage(String r2, String r3) {
        init(r2, r3, null, null);
    }

    public PassThroughImage(String r2, String r3, SerCrypto r4) {
        init(r2, r3, r4, null);
    }

    public PassThroughImage(String r1, String r2, SerCrypto r3, ImageSetPassThrough.FileType r4) {
        init(r1, r2, r3, r4);
    }

    private void init(String r1, String r2, SerCrypto r3, ImageSetPassThrough.FileType r4) {
        this.imageKey = r1;
        this.fsUnit = r2;
        this.crypto = r3;
        this.fileType = r4;
    }
}
