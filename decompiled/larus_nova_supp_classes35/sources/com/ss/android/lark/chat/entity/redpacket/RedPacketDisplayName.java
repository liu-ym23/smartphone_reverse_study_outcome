package com.ss.android.lark.chat.entity.redpacket;

import com.ss.android.lark.image.entity.PassThroughImage;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/ss/android/lark/chat/entity/redpacket/RedPacketDisplayName;", "Ljava/io/Serializable;", "backgroundImage", "Lcom/ss/android/lark/image/entity/PassThroughImage;", "displayName", BuildConfig.FLAVOR, "<init>", "(Lcom/ss/android/lark/image/entity/PassThroughImage;Ljava/lang/String;)V", "getBackgroundImage", "()Lcom/ss/android/lark/image/entity/PassThroughImage;", "getDisplayName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", BuildConfig.FLAVOR, "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "toString", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RedPacketDisplayName implements Serializable {
    private final PassThroughImage backgroundImage;
    private final String displayName;

    public static /* synthetic */ RedPacketDisplayName copy$default(RedPacketDisplayName r0, PassThroughImage r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.backgroundImage;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.displayName;
    L9:
        return r0.copy(r1, r2);
    }

    public final PassThroughImage component1() {
        return this.backgroundImage;
    }

    public final String component2() {
        return this.displayName;
    }

    public final RedPacketDisplayName copy(PassThroughImage r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "displayName");
        return new RedPacketDisplayName(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof RedPacketDisplayName) == true) goto L8;
        return false;
    L8:
        RedPacketDisplayName r6 = (RedPacketDisplayName) r5;
        if (Intrinsics.areEqual(this.backgroundImage, r6.backgroundImage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.displayName, r6.displayName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PassThroughImage r0 = this.backgroundImage;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (r1 * 31) + this.displayName.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public String toString() {
        return "RedPacketDisplayName(backgroundImage=" + this.backgroundImage + ", displayName=" + this.displayName + ')';
    }

    public final PassThroughImage getBackgroundImage() {
        return this.backgroundImage;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public RedPacketDisplayName(PassThroughImage r2, String r3) {
        Intrinsics.checkNotNullParameter(r3, "displayName");
        this.backgroundImage = r2;
        this.displayName = r3;
    }
}
