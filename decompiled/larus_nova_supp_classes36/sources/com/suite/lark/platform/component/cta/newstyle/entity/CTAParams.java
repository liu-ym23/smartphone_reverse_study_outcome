package com.suite.lark.platform.component.cta.newstyle.entity;

import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J1\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/suite/lark/platform/component/cta/newstyle/entity/CTAParams;", "Ljava/io/Serializable;", "featureKey", "", "scene", "checkpointTenantId", "checkpointUserId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getFeatureKey", "()Ljava/lang/String;", "getScene", "getCheckpointTenantId", "getCheckpointUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CTAParams implements Serializable {
    private final String checkpointTenantId;
    private final String checkpointUserId;
    private final String featureKey;
    private final String scene;

    public static /* synthetic */ CTAParams copy$default(CTAParams r0, String r1, String r2, String r3, String r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.featureKey;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.scene;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.checkpointTenantId;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.checkpointUserId;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.featureKey;
    }

    public final String component2() {
        return this.scene;
    }

    public final String component3() {
        return this.checkpointTenantId;
    }

    public final String component4() {
        return this.checkpointUserId;
    }

    public final CTAParams copy(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "featureKey");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r5, "checkpointUserId");
        return new CTAParams(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CTAParams) == true) goto L8;
        return false;
    L8:
        CTAParams r6 = (CTAParams) r5;
        if (Intrinsics.areEqual(this.featureKey, r6.featureKey) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r6.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.checkpointTenantId, r6.checkpointTenantId) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.checkpointUserId, r6.checkpointUserId) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        return (((((this.featureKey.hashCode() * 31) + this.scene.hashCode()) * 31) + this.checkpointTenantId.hashCode()) * 31) + this.checkpointUserId.hashCode();
    }

    public String toString() {
        return "CTAParams(featureKey=" + this.featureKey + ", scene=" + this.scene + ", checkpointTenantId=" + this.checkpointTenantId + ", checkpointUserId=" + this.checkpointUserId + ')';
    }

    public final String getCheckpointTenantId() {
        return this.checkpointTenantId;
    }

    public final String getCheckpointUserId() {
        return this.checkpointUserId;
    }

    public final String getFeatureKey() {
        return this.featureKey;
    }

    public final String getScene() {
        return this.scene;
    }

    public CTAParams(String r2, String r3, String r4, String r5) {
        Intrinsics.checkNotNullParameter(r2, "featureKey");
        Intrinsics.checkNotNullParameter(r3, "scene");
        Intrinsics.checkNotNullParameter(r4, "checkpointTenantId");
        Intrinsics.checkNotNullParameter(r5, "checkpointUserId");
        this.featureKey = r2;
        this.scene = r3;
        this.checkpointTenantId = r4;
        this.checkpointUserId = r5;
    }

    public /* synthetic */ CTAParams(String r2, String r3, String r4, String r5, int r6, DefaultConstructorMarker r7) {
        if ((r6 & 4) == 0) goto L6;
        r4 = "0";
    L6:
        if ((r6 & 8) == 0) goto L8;
        r5 = "0";
    L8:
        this(r2, r3, r4, r5);
    }
}
