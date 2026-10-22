package com.ss.android.lark.image.entity;

import com.bumptech.glide.load.Key;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public class ReactionImage implements Key, Serializable {
    private volatile byte[] cacheKeyBytes;
    private String reactionKey;

    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.reactionKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public String toString() {
        return "Reaction#key is:" + this.reactionKey;
    }

    public String getReactionKey() {
        return this.reactionKey;
    }

    public ReactionImage(String r1) {
        this.reactionKey = r1;
    }

    public boolean equals(Object r2) {
        if (this != r2) goto L6;
        return true;
    L6:
        if ((r2 instanceof ReactionImage) == true) goto L10;
        return false;
    L10:
        return Objects.equals(this.reactionKey, ((ReactionImage) r2).reactionKey);
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }
}
