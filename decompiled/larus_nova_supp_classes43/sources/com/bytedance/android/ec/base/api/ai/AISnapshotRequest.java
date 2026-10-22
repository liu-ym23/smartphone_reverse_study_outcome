package com.bytedance.android.ec.base.api.ai;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/ec/base/api/ai/AISnapshotRequest;", "", "view", "Landroid/view/View;", "snapshotId", "", "(Landroid/view/View;Ljava/lang/String;)V", "getSnapshotId", "()Ljava/lang/String;", "getView", "()Landroid/view/View;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "ec-base-api_release"}, k = 1, mv = {1, 4, 3})
public final class AISnapshotRequest {
    private final String snapshotId;
    private final View view;

    public static /* synthetic */ AISnapshotRequest copy$default(AISnapshotRequest r0, View r1, String r10, int r11, Object r12) {
        if ((r11 & 1) == 0) goto L6;
        r1 = r0.view;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r10 = r0.snapshotId;
    L9:
        return r0.copy(r1, r10);
    }

    public final View component1() {
        return this.view;
    }

    public final String component2() {
        return this.snapshotId;
    }

    public final AISnapshotRequest copy(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "snapshotId");
        return new AISnapshotRequest(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof AISnapshotRequest) == false) goto L10;
        AISnapshotRequest r11 = (AISnapshotRequest) r10;
        if (Intrinsics.areEqual(this.view, r11.view) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.snapshotId, r11.snapshotId) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        View r0 = this.view;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r10 = r0.hashCode();
    L6:
        int r11 = r10 * 31;
        String r12 = this.snapshotId;
        if (r12 == null) goto L10;
        r1 = r12.hashCode();
    L10:
        return r11 + r1;
    L5:
        r10 = 0;
        goto L6
    }

    public String toString() {
        return "AISnapshotRequest(view=" + this.view + ", snapshotId=" + this.snapshotId + ")";
    }

    public final String getSnapshotId() {
        return this.snapshotId;
    }

    public final View getView() {
        return this.view;
    }

    public AISnapshotRequest(View r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, "view");
        Intrinsics.checkNotNullParameter(r11, "snapshotId");
        this.view = r10;
        this.snapshotId = r11;
    }
}
