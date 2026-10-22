package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B#\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/ss/ugc/effectplatform/model/InspirationFeedEffectModel;", "", "aweme", "Lcom/ss/ugc/effectplatform/model/InspirationModel;", "materials", "", "Lcom/ss/ugc/effectplatform/model/MaterialModel;", "(Lcom/ss/ugc/effectplatform/model/InspirationModel;Ljava/util/List;)V", "getAweme", "()Lcom/ss/ugc/effectplatform/model/InspirationModel;", "setAweme", "(Lcom/ss/ugc/effectplatform/model/InspirationModel;)V", "getMaterials", "()Ljava/util/List;", "setMaterials", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class InspirationFeedEffectModel {
    private InspirationModel aweme;
    private List<MaterialModel> materials;

    /* JADX WARN: Multi-variable type inference failed */
    public InspirationFeedEffectModel() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ InspirationFeedEffectModel copy$default(InspirationFeedEffectModel r0, InspirationModel r1, List r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.aweme;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.materials;
    L9:
        return r0.copy(r1, r2);
    }

    public final InspirationModel component1() {
        return this.aweme;
    }

    public final List<MaterialModel> component2() {
        return this.materials;
    }

    public final InspirationFeedEffectModel copy(InspirationModel r2, List<MaterialModel> r3) {
        return new InspirationFeedEffectModel(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof InspirationFeedEffectModel) == false) goto L10;
        InspirationFeedEffectModel r4 = (InspirationFeedEffectModel) r3;
        if (Intrinsics.areEqual(this.aweme, r4.aweme) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.materials, r4.materials) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        InspirationModel r0 = this.aweme;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<MaterialModel> r4 = this.materials;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "InspirationFeedEffectModel(aweme=" + this.aweme + ", materials=" + this.materials + ")";
    }

    public final InspirationModel getAweme() {
        return this.aweme;
    }

    public final List<MaterialModel> getMaterials() {
        return this.materials;
    }

    public final void setAweme(InspirationModel r1) {
        this.aweme = r1;
    }

    public final void setMaterials(List<MaterialModel> r1) {
        this.materials = r1;
    }

    public InspirationFeedEffectModel(InspirationModel r1, List<MaterialModel> r2) {
        this.aweme = r1;
        this.materials = r2;
    }

    public /* synthetic */ InspirationFeedEffectModel(InspirationModel r2, List r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
