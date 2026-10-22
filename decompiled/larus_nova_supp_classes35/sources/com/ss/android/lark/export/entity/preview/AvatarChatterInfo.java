package com.ss.android.lark.export.entity.preview;

import com.tencent.qqmusic.third.api.contract.BuildConfig;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import y28.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002B\u001b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u000b\u001a\u00020\u0000J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0012\u0010\u000f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0000H\u0016J\u0013\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0004HÆ\u0003J!\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u0018\u001a\u00020\u0004HÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/AvatarChatterInfo;", "Ljava/io/Serializable;", "Lcom/larksuite/framework/utils/diff/Diffable;", "avatarKey", BuildConfig.FLAVOR, "chatterId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvatarKey", "()Ljava/lang/String;", "getChatterId", "clone", "isItemSame", BuildConfig.FLAVOR, "diffable", "isContentSame", "equals", "other", BuildConfig.FLAVOR, "hashCode", BuildConfig.FLAVOR, "component1", "component2", "copy", "toString", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarChatterInfo implements Serializable, b<AvatarChatterInfo> {
    private final String avatarKey;
    private final String chatterId;

    public static /* synthetic */ AvatarChatterInfo copy$default(AvatarChatterInfo r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.avatarKey;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.chatterId;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.avatarKey;
    }

    public final String component2() {
        return this.chatterId;
    }

    public final AvatarChatterInfo copy(String r2, String r3) {
        return new AvatarChatterInfo(r2, r3);
    }

    public String toString() {
        return "AvatarChatterInfo(avatarKey=" + this.avatarKey + ", chatterId=" + this.chatterId + ')';
    }

    public final AvatarChatterInfo clone() {
        return new AvatarChatterInfo(this.avatarKey, this.chatterId);
    }

    public int hashCode() {
        String r0 = this.avatarKey;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.chatterId;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final String getChatterId() {
        return this.chatterId;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AvatarChatterInfo) == true) goto L8;
        return false;
    L8:
        AvatarChatterInfo r6 = (AvatarChatterInfo) r5;
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.chatterId, r6.chatterId) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public boolean isContentSame(AvatarChatterInfo r4) {
        String r0 = this.chatterId;
        String r1 = null;
        if (r4 == null) goto L5;
        String r2 = r4.chatterId;
    L7:
        if (Intrinsics.areEqual(r0, r2) == false) goto L14;
        String r3 = this.avatarKey;
        if (r4 == null) goto L12;
        r1 = r4.avatarKey;
    L12:
        if (Intrinsics.areEqual(r3, r1) == false) goto L14;
        return true;
    L14:
        return false;
    L5:
        r2 = null;
        goto L7
    }

    public boolean isItemSame(AvatarChatterInfo r2) {
        String r0 = this.chatterId;
        if (r2 == null) goto L5;
        String r3 = r2.chatterId;
    L7:
        return Intrinsics.areEqual(r0, r3);
    L5:
        r3 = null;
        goto L7
    }

    public /* bridge */ /* synthetic */ boolean isContentSame(b r1) {
        return isContentSame((AvatarChatterInfo) r1);
    }

    public /* bridge */ /* synthetic */ boolean isItemSame(b r1) {
        return isItemSame((AvatarChatterInfo) r1);
    }

    public AvatarChatterInfo(String r1, String r2) {
        this.avatarKey = r1;
        this.chatterId = r2;
    }
}
