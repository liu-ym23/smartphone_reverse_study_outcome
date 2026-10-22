package com.ss.android.lark.officesdk.minutes.ui.record.endwindow.web;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/ui/record/endwindow/web/MmGetDoubaoUserInfoParam;", "Ljava/io/Serializable;", "userId", "", "<init>", "(Ljava/lang/String;)V", "getUserId", "()Ljava/lang/String;", "isValid", "", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "officesdk-minutes-base-ui_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmGetDoubaoUserInfoParam implements Serializable {

    @SerializedName("userId")
    private final String userId;

    public static /* synthetic */ MmGetDoubaoUserInfoParam copy$default(MmGetDoubaoUserInfoParam r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.userId;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.userId;
    }

    public final MmGetDoubaoUserInfoParam copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        return new MmGetDoubaoUserInfoParam(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof MmGetDoubaoUserInfoParam) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.userId, ((MmGetDoubaoUserInfoParam) r4).userId) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.userId.hashCode();
    }

    public String toString() {
        return "MmGetDoubaoUserInfoParam(userId=" + this.userId + ')';
    }

    public final boolean isValid() {
        if (this.userId.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getUserId() {
        return this.userId;
    }

    public MmGetDoubaoUserInfoParam(String r2) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        this.userId = r2;
    }
}
