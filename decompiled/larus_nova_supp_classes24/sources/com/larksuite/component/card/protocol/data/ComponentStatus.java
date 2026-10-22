package com.larksuite.component.card.protocol.data;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/larksuite/component/card/protocol/data/ComponentStatus;", "Ljava/io/Serializable;", "cardComponentLocalCache", "", "<init>", "(Ljava/lang/String;)V", "getCardComponentLocalCache", "()Ljava/lang/String;", "setCardComponentLocalCache", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public final class ComponentStatus implements Serializable {
    private String cardComponentLocalCache;

    public static /* synthetic */ ComponentStatus copy$default(ComponentStatus r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.cardComponentLocalCache;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.cardComponentLocalCache;
    }

    public final ComponentStatus copy(String r2) {
        return new ComponentStatus(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof ComponentStatus) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.cardComponentLocalCache, ((ComponentStatus) r4).cardComponentLocalCache) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r0 = this.cardComponentLocalCache;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "ComponentStatus(cardComponentLocalCache=" + this.cardComponentLocalCache + ')';
    }

    public final String getCardComponentLocalCache() {
        return this.cardComponentLocalCache;
    }

    public ComponentStatus(String r1) {
        this.cardComponentLocalCache = r1;
    }

    public final void setCardComponentLocalCache(String r1) {
        this.cardComponentLocalCache = r1;
    }
}
