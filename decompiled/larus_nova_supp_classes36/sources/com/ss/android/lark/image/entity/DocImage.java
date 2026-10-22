package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import com.bytedance.lark.pb.basic.v1.Trace;
import com.larksuite.framework.callback.Entity.ErrorResult;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class DocImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private ErrorResult errorResult;
    private String token;
    private Trace trace;

    public int hashCode() {
        return Objects.hash(new Object[]{this.token});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.token.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public ErrorResult getErrorResult() {
        return this.errorResult;
    }

    public String getToken() {
        return this.token;
    }

    public Trace getTrace() {
        return this.trace;
    }

    public DocImage(String r1) {
        init(r1);
    }

    private void init(String r1) {
        this.token = r1;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof DocImage) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.token, ((DocImage) r2).token);
    }

    public void setErrorResult(ErrorResult r1) {
        this.errorResult = r1;
    }

    public void setTrace(Trace r1) {
        this.trace = r1;
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }
}
