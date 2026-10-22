package com.ss.ugc.effectplatform.model;

import com.ss.android.lark.notification.export.entity.INotificationHitPoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\fJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J&\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/ugc/effectplatform/model/MaterialModel;", "", "use_count", "", "sticker_data", "Lcom/ss/ugc/effectplatform/model/Effect;", "(Ljava/lang/Long;Lcom/ss/ugc/effectplatform/model/Effect;)V", "getSticker_data", "()Lcom/ss/ugc/effectplatform/model/Effect;", "setSticker_data", "(Lcom/ss/ugc/effectplatform/model/Effect;)V", "getUse_count", "()Ljava/lang/Long;", "setUse_count", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "component1", "component2", "copy", "(Ljava/lang/Long;Lcom/ss/ugc/effectplatform/model/Effect;)Lcom/ss/ugc/effectplatform/model/MaterialModel;", "equals", "", INotificationHitPoint.NoticeType.OTHER, "hashCode", "", "toString", "", "effect_model_release"}, k = 1, mv = {1, 1, 16})
public final class MaterialModel {
    private Effect sticker_data;
    private Long use_count;

    public MaterialModel() {
        Long r0 = null;
        this(r0, r0, 3, r0);
    }

    public static /* synthetic */ MaterialModel copy$default(MaterialModel r0, Long r1, Effect r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.use_count;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.sticker_data;
    L9:
        return r0.copy(r1, r2);
    }

    public final Long component1() {
        return this.use_count;
    }

    public final Effect component2() {
        return this.sticker_data;
    }

    public final MaterialModel copy(Long r2, Effect r3) {
        return new MaterialModel(r2, r3);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MaterialModel) == false) goto L10;
        MaterialModel r4 = (MaterialModel) r3;
        if (Intrinsics.areEqual(this.use_count, r4.use_count) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.sticker_data, r4.sticker_data) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public int hashCode() {
        Long r0 = this.use_count;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        Effect r4 = this.sticker_data;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MaterialModel(use_count=" + this.use_count + ", sticker_data=" + this.sticker_data + ")";
    }

    public final Effect getSticker_data() {
        return this.sticker_data;
    }

    public final Long getUse_count() {
        return this.use_count;
    }

    public final void setSticker_data(Effect r1) {
        this.sticker_data = r1;
    }

    public final void setUse_count(Long r1) {
        this.use_count = r1;
    }

    public MaterialModel(Long r1, Effect r2) {
        this.use_count = r1;
        this.sticker_data = r2;
    }

    public /* synthetic */ MaterialModel(Long r2, Effect r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }
}
