package androidx.room.vo;

import ai.j0;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/room/vo/MapInfo;", "", "keyColumnName", "", "valueColumnName", "(Ljava/lang/String;Ljava/lang/String;)V", "getKeyColumnName", "()Ljava/lang/String;", "getValueColumnName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MapInfo {
    private final String keyColumnName;
    private final String valueColumnName;

    public MapInfo(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "keyColumnName");
        Intrinsics.checkNotNullParameter(r10, "valueColumnName");
        this.keyColumnName = r5;
        this.valueColumnName = r10;
    }

    public static /* synthetic */ MapInfo copy$default(MapInfo r5, String r10, String r11, int r12, Object r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = r5.keyColumnName;
    L6:
        if ((r12 & 2) == 0) goto L9;
        r11 = r5.valueColumnName;
    L9:
        return r5.copy(r10, r11);
    }

    public final String component1() {
        return this.keyColumnName;
    }

    public final String component2() {
        return this.valueColumnName;
    }

    public final MapInfo copy(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "keyColumnName");
        Intrinsics.checkNotNullParameter(r10, "valueColumnName");
        return new MapInfo(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof MapInfo) == true) goto L8;
        return false;
    L8:
        MapInfo r10 = (MapInfo) r5;
        if (Intrinsics.areEqual(this.keyColumnName, r10.keyColumnName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.valueColumnName, r10.valueColumnName) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final String getKeyColumnName() {
        return this.keyColumnName;
    }

    public final String getValueColumnName() {
        return this.valueColumnName;
    }

    public int hashCode() {
        int r5 = this.keyColumnName.hashCode() * 31;
        return this.valueColumnName.hashCode() + r5;
    }

    public String toString() {
        return j0.l("MapInfo(keyColumnName=", this.keyColumnName, ", valueColumnName=", this.valueColumnName, ")");
    }
}
