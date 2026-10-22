package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmGetAvatarBase64Param;", "Ljava/io/Serializable;", "userId", "", "avatarKey", "size", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;I)V", "getUserId", "()Ljava/lang/String;", "getAvatarKey", "getSize", "()I", "isValid", "", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmGetAvatarBase64Param implements Serializable {
    private final String avatarKey;
    private final int size;
    private final String userId;

    public static /* synthetic */ MmGetAvatarBase64Param copy$default(MmGetAvatarBase64Param r0, String r1, String r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.userId;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.avatarKey;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.size;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.avatarKey;
    }

    public final int component3() {
        return this.size;
    }

    public final MmGetAvatarBase64Param copy(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        return new MmGetAvatarBase64Param(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmGetAvatarBase64Param) == true) goto L8;
        return false;
    L8:
        MmGetAvatarBase64Param r6 = (MmGetAvatarBase64Param) r5;
        if (Intrinsics.areEqual(this.userId, r6.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.avatarKey, r6.avatarKey) == true) goto L15;
        return false;
    L15:
        if (this.size == r6.size) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.userId.hashCode() * 31) + this.avatarKey.hashCode()) * 31) + this.size;
    }

    public String toString() {
        return "MmGetAvatarBase64Param(userId=" + this.userId + ", avatarKey=" + this.avatarKey + ", size=" + this.size + ')';
    }

    public final boolean isValid() {
        if (this.userId.length() <= 0) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == true) goto L8;
    L15:
        return false;
    L8:
        if (this.avatarKey.length() <= 0) goto L10;
        boolean r1 = true;
    L11:
        if (r1 == false) goto L15;
        if (this.size <= 0) goto L15;
        return true;
    L10:
        r1 = false;
        goto L11
    L5:
        r0 = false;
        goto L6
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final int getSize() {
        return this.size;
    }

    public final String getUserId() {
        return this.userId;
    }

    public MmGetAvatarBase64Param(String r2, String r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "avatarKey");
        this.userId = r2;
        this.avatarKey = r3;
        this.size = r4;
    }
}
