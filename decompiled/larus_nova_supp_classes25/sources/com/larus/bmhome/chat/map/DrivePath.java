package com.larus.bmhome.chat.map;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/larus/bmhome/chat/map/DrivePath;", "", "steps", "", "Lcom/larus/bmhome/chat/map/Step;", "<init>", "(Ljava/util/List;)V", "getSteps", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
public final class DrivePath {
    private final List<Step> steps;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DrivePath copy$default(DrivePath r0, List r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.steps;
    L6:
        return r0.copy(r1);
    }

    public final List<Step> component1() {
        return this.steps;
    }

    public final DrivePath copy(List<Step> r2) {
        Intrinsics.checkNotNullParameter(r2, "steps");
        return new DrivePath(r2);
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof DrivePath) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.steps, ((DrivePath) r4).steps) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.steps.hashCode();
    }

    public String toString() {
        return "DrivePath(steps=" + this.steps + ')';
    }

    public final List<Step> getSteps() {
        return this.steps;
    }

    public DrivePath(List<Step> r2) {
        Intrinsics.checkNotNullParameter(r2, "steps");
        this.steps = r2;
    }
}
