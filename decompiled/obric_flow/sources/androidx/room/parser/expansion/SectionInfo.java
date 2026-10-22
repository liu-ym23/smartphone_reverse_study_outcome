package androidx.room.parser.expansion;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Landroidx/room/parser/expansion/SectionInfo;", "", "start", "Landroidx/room/parser/expansion/Position;", "end", "section", "Landroidx/room/parser/expansion/ExpandableSection;", "(Landroidx/room/parser/expansion/Position;Landroidx/room/parser/expansion/Position;Landroidx/room/parser/expansion/ExpandableSection;)V", "getEnd", "()Landroidx/room/parser/expansion/Position;", "getSection", "()Landroidx/room/parser/expansion/ExpandableSection;", "getStart", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SectionInfo {
    private final Position end;
    private final ExpandableSection section;
    private final Position start;

    public SectionInfo(Position r5, Position r10, ExpandableSection r11) {
        Intrinsics.checkNotNullParameter(r5, "start");
        Intrinsics.checkNotNullParameter(r10, "end");
        Intrinsics.checkNotNullParameter(r11, "section");
        this.start = r5;
        this.end = r10;
        this.section = r11;
    }

    public static /* synthetic */ SectionInfo copy$default(SectionInfo r5, Position r10, Position r11, ExpandableSection r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r10 = r5.start;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r11 = r5.end;
    L9:
        if ((r13 & 4) == 0) goto L12;
        r12 = r5.section;
    L12:
        return r5.copy(r10, r11, r12);
    }

    public final Position component1() {
        return this.start;
    }

    public final Position component2() {
        return this.end;
    }

    public final ExpandableSection component3() {
        return this.section;
    }

    public final SectionInfo copy(Position r5, Position r10, ExpandableSection r11) {
        Intrinsics.checkNotNullParameter(r5, "start");
        Intrinsics.checkNotNullParameter(r10, "end");
        Intrinsics.checkNotNullParameter(r11, "section");
        return new SectionInfo(r5, r10, r11);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SectionInfo) == true) goto L8;
        return false;
    L8:
        SectionInfo r10 = (SectionInfo) r5;
        if (Intrinsics.areEqual(this.start, r10.start) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.end, r10.end) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.section, r10.section) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final Position getEnd() {
        return this.end;
    }

    public final ExpandableSection getSection() {
        return this.section;
    }

    public final Position getStart() {
        return this.start;
    }

    public int hashCode() {
        int r5 = this.start.hashCode() * 31;
        int r10 = (this.end.hashCode() + r5) * 31;
        return this.section.hashCode() + r10;
    }

    public String toString() {
        return "SectionInfo(start=" + this.start + ", end=" + this.end + ", section=" + this.section + ")";
    }
}
