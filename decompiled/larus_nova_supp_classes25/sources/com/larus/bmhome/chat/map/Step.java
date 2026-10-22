package com.larus.bmhome.chat.map;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/larus/bmhome/chat/map/Step;", "", "polyline", "", "<init>", "(Ljava/lang/String;)V", "getPolyline", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class Step {
    private final String polyline;

    public static /* synthetic */ Step copy$default(Step r0, String r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.polyline;
    L6:
        return r0.copy(r1);
    }

    public final String component1() {
        return this.polyline;
    }

    public final Step copy(String r2) {
        Intrinsics.checkNotNullParameter(r2, "polyline");
        return new Step(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof Step) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.polyline, ((Step) r4).polyline) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.polyline.hashCode();
    }

    public String toString() {
        return "Step(polyline=" + this.polyline + ')';
    }

    public final String getPolyline() {
        return this.polyline;
    }

    public Step(String r2) {
        Intrinsics.checkNotNullParameter(r2, "polyline");
        this.polyline = r2;
    }
}
