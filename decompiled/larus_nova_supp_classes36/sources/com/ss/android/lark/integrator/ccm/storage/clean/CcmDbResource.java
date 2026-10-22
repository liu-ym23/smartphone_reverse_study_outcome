package com.ss.android.lark.integrator.ccm.storage.clean;

import com.ss.android.lark.diskmanage.Biz;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import com.suite.lark.platform.component.storage.clean.PersistentResource;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/integrator/ccm/storage/clean/CcmDbResource;", "Lcom/suite/lark/platform/component/storage/clean/PersistentResource;", "useId", "", "sourceName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getUseId", "()Ljava/lang/String;", "getSourceName", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "", "hashCode", "", "toString", "ccm-assembly_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class CcmDbResource implements PersistentResource {
    private final String sourceName;
    private final String useId;

    public static /* synthetic */ CcmDbResource copy$default(CcmDbResource r0, String r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.useId;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.sourceName;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.useId;
    }

    public final String component2() {
        return this.sourceName;
    }

    public final CcmDbResource copy(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "useId");
        Intrinsics.checkNotNullParameter(r3, "sourceName");
        return new CcmDbResource(r2, r3);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CcmDbResource) == true) goto L8;
        return false;
    L8:
        CcmDbResource r6 = (CcmDbResource) r5;
        if (Intrinsics.areEqual(this.useId, r6.useId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.sourceName, r6.sourceName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.useId.hashCode() * 31) + this.sourceName.hashCode();
    }

    @Override // com.suite.lark.platform.component.storage.clean.f
    public long progressWeight() {
        return 1;
    }

    public String toString() {
        return "CcmDbResource(useId=" + this.useId + ", sourceName=" + this.sourceName + ')';
    }

    public Biz getBiz() {
        return Biz.DEFAULT;
    }

    public final String getSourceName() {
        return this.sourceName;
    }

    public final String getUseId() {
        return this.useId;
    }

    public CcmDbResource(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "useId");
        Intrinsics.checkNotNullParameter(r3, "sourceName");
        this.useId = r2;
        this.sourceName = r3;
    }
}
