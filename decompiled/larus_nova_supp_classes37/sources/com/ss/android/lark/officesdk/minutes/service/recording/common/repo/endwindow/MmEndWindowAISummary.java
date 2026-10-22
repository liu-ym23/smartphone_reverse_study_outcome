package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.picker.base.view.ItemViewType;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J'\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowAISummary;", "Ljava/io/Serializable;", "hasQuota", "", "unavailableReason", "Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "content", "", "<init>", "(ZLcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;Ljava/lang/String;)V", "getHasQuota", "()Z", "getUnavailableReason", "()Lcom/ss/android/lark/officesdk/minutes/service/recording/common/repo/endwindow/MmEndWindowUnavailableReason;", "getContent", "()Ljava/lang/String;", "toString", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "officesdk-minutes-service_release"}, k = 1, mv = {2, 1, 0}, xi = ItemViewType.ITEM_VIEW_TYPE_DOUBAO_COMMON_CCM)
public final class MmEndWindowAISummary implements Serializable {
    private final String content;
    private final boolean hasQuota;
    private final MmEndWindowUnavailableReason unavailableReason;

    public MmEndWindowAISummary() {
        this(false, null, null, 7, null);
    }

    public static /* synthetic */ MmEndWindowAISummary copy$default(MmEndWindowAISummary r0, boolean r1, MmEndWindowUnavailableReason r2, String r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.hasQuota;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.unavailableReason;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.content;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.hasQuota;
    }

    public final MmEndWindowUnavailableReason component2() {
        return this.unavailableReason;
    }

    public final String component3() {
        return this.content;
    }

    public final MmEndWindowAISummary copy(boolean r2, MmEndWindowUnavailableReason r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "unavailableReason");
        Intrinsics.checkNotNullParameter(r4, "content");
        return new MmEndWindowAISummary(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MmEndWindowAISummary) == true) goto L8;
        return false;
    L8:
        MmEndWindowAISummary r6 = (MmEndWindowAISummary) r5;
        if (this.hasQuota == r6.hasQuota) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.unavailableReason, r6.unavailableReason) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.hasQuota == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.unavailableReason.hashCode()) * 31) + this.content.hashCode();
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "MmEndWindowAISummary(hasQuota=" + this.hasQuota + ", unavailableReason=" + this.unavailableReason + ", content='" + this.content.length() + "')";
    }

    public final String getContent() {
        return this.content;
    }

    public final boolean getHasQuota() {
        return this.hasQuota;
    }

    public final MmEndWindowUnavailableReason getUnavailableReason() {
        return this.unavailableReason;
    }

    public MmEndWindowAISummary(boolean r2, MmEndWindowUnavailableReason r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "unavailableReason");
        Intrinsics.checkNotNullParameter(r4, "content");
        this.hasQuota = r2;
        this.unavailableReason = r3;
        this.content = r4;
    }

    public /* synthetic */ MmEndWindowAISummary(boolean r3, MmEndWindowUnavailableReason r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r4 = new MmEndWindowUnavailableReason(0, null, 3, null);
    L9:
        if ((r6 & 4) == 0) goto L11;
        r5 = "";
    L11:
        this(r3, r4, r5);
    }
}
