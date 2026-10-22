package com.ss.android.lark.newemoji.loader;

import android.text.TextUtils;
import com.bumptech.glide.load.Key;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0096\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0015\u001a\u00020\u0003H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/newemoji/loader/EmojiImageResource;", "Lcom/bumptech/glide/load/Key;", "imageKey", "", "<init>", "(Ljava/lang/String;)V", "getImageKey", "()Ljava/lang/String;", "cacheKeyBytes", "", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "updateDiskCacheKey", "", "messageDigest", "Ljava/security/MessageDigest;", "getCacheKeyBytes", "toString", "lark-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class EmojiImageResource implements Key {
    private volatile byte[] cacheKeyBytes;
    private final String imageKey;

    private final byte[] getCacheKeyBytes() {
        if (this.cacheKeyBytes != null) goto L6;
        this.cacheKeyBytes = this.imageKey.getBytes(Key.CHARSET);
    L6:
        return this.cacheKeyBytes;
    }

    public int hashCode() {
        return this.imageKey.hashCode();
    }

    public String toString() {
        return "imageKey:" + this.imageKey;
    }

    public final String getImageKey() {
        return this.imageKey;
    }

    public EmojiImageResource(String r2) {
        Intrinsics.checkNotNullParameter(r2, "imageKey");
        this.imageKey = r2;
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L5;
        return true;
    L5:
        if (r3 != null) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(EmojiImageResource.class, r3.getClass()) == true) goto L10;
        return false;
    L10:
        return TextUtils.equals(this.imageKey, ((EmojiImageResource) r3).imageKey);
    }

    public void updateDiskCacheKey(MessageDigest r2) {
        Intrinsics.checkNotNullParameter(r2, "messageDigest");
        byte[] r0 = getCacheKeyBytes();
        if (r0 == null) goto L6;
        r2.update(r0);
        return;
    }
}
