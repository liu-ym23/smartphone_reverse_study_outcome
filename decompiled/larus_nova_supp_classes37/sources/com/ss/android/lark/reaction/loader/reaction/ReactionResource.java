package com.ss.android.lark.reaction.loader.reaction;

import com.bumptech.glide.load.Key;
import java.security.MessageDigest;
import java.util.Objects;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public class ReactionResource implements Key {
    private volatile byte[] cacheKeyBytes;
    public String reactionKey;

    public int hashCode() {
        return Objects.hash(new Object[]{this.reactionKey});
    }

    private byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.reactionKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public ReactionResource(String r1) {
        this.reactionKey = r1;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (getClass() == r3.getClass()) goto L10;
        return false;
    L10:
        return Objects.equals(this.reactionKey, ((ReactionResource) r3).reactionKey);
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        r2.update(getCacheKeyBytes());
    }
}
