package androidx.room.util;

import androidx.constraintlayout.motion.widget.a;
import androidx.room.migration.bundle.DatabaseViewBundle;
import androidx.room.vo.AutoMigration;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0081\u0001\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u000b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0003\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\u0002\u0010\u0013J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0003HÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0015\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u000bHÆ\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\f0\u0003HÆ\u0003J\u000f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0003J\u000f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0003J\u0095\u0001\u0010'\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0014\b\u0002\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u000b2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00032\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020,HÖ\u0001J\t\u0010-\u001a\u00020\fHÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000e0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0019R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015¨\u0006."}, d2 = {"Landroidx/room/util/SchemaDiffResult;", "", "addedColumns", "", "Landroidx/room/vo/AutoMigration$AddedColumn;", "deletedColumns", "Landroidx/room/vo/AutoMigration$DeletedColumn;", "addedTables", "", "Landroidx/room/vo/AutoMigration$AddedTable;", "renamedTables", "", "", "complexChangedTables", "Landroidx/room/vo/AutoMigration$ComplexChangedTable;", "deletedTables", "fromViews", "Landroidx/room/migration/bundle/DatabaseViewBundle;", "toViews", "(Ljava/util/List;Ljava/util/List;Ljava/util/Set;Ljava/util/Map;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getAddedColumns", "()Ljava/util/List;", "getAddedTables", "()Ljava/util/Set;", "getComplexChangedTables", "()Ljava/util/Map;", "getDeletedColumns", "getDeletedTables", "getFromViews", "getRenamedTables", "getToViews", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SchemaDiffResult {
    private final List<AutoMigration.AddedColumn> addedColumns;
    private final Set<AutoMigration.AddedTable> addedTables;
    private final Map<String, AutoMigration.ComplexChangedTable> complexChangedTables;
    private final List<AutoMigration.DeletedColumn> deletedColumns;
    private final List<String> deletedTables;
    private final List<DatabaseViewBundle> fromViews;
    private final Map<String, String> renamedTables;
    private final List<DatabaseViewBundle> toViews;

    /* JADX WARN: Multi-variable type inference failed */
    public SchemaDiffResult(List<AutoMigration.AddedColumn> r5, List<AutoMigration.DeletedColumn> r10, Set<AutoMigration.AddedTable> r11, Map<String, String> r12, Map<String, AutoMigration.ComplexChangedTable> r13, List<String> r14, List<? extends DatabaseViewBundle> r15, List<? extends DatabaseViewBundle> r16) {
        Intrinsics.checkNotNullParameter(r5, "addedColumns");
        Intrinsics.checkNotNullParameter(r10, "deletedColumns");
        Intrinsics.checkNotNullParameter(r11, "addedTables");
        Intrinsics.checkNotNullParameter(r12, "renamedTables");
        Intrinsics.checkNotNullParameter(r13, "complexChangedTables");
        Intrinsics.checkNotNullParameter(r14, "deletedTables");
        Intrinsics.checkNotNullParameter(r15, "fromViews");
        Intrinsics.checkNotNullParameter(r16, "toViews");
        this.addedColumns = r5;
        this.deletedColumns = r10;
        this.addedTables = r11;
        this.renamedTables = r12;
        this.complexChangedTables = r13;
        this.deletedTables = r14;
        this.fromViews = r15;
        this.toViews = r16;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SchemaDiffResult copy$default(SchemaDiffResult r10, List r11, List r12, Set r13, Map r14, Map r15, List r16, List r17, List r18, int r19, Object r110) {
        if ((r19 & 1) == 0) goto L5;
        List r5 = r10.addedColumns;
    L7:
        if ((r19 & 2) == 0) goto L9;
        List r20 = r10.deletedColumns;
    L11:
        if ((r19 & 4) == 0) goto L13;
        Set r21 = r10.addedTables;
    L15:
        if ((r19 & 8) == 0) goto L17;
        Map r22 = r10.renamedTables;
    L19:
        if ((r19 & 16) == 0) goto L21;
        Map r23 = r10.complexChangedTables;
    L23:
        if ((r19 & 32) == 0) goto L25;
        List r24 = r10.deletedTables;
    L27:
        if ((r19 & 64) == 0) goto L29;
        List r25 = r10.fromViews;
    L31:
        if ((r19 & 128) == 0) goto L33;
        List r26 = r10.toViews;
    L35:
        return r10.copy(r5, r20, r21, r22, r23, r24, r25, r26);
    L33:
        r26 = r18;
        goto L35
    L29:
        r25 = r17;
        goto L31
    L25:
        r24 = r16;
        goto L27
    L21:
        r23 = r15;
        goto L23
    L17:
        r22 = r14;
        goto L19
    L13:
        r21 = r13;
        goto L15
    L9:
        r20 = r12;
        goto L11
    L5:
        r5 = r11;
        goto L7
    }

    public final List<AutoMigration.AddedColumn> component1() {
        return this.addedColumns;
    }

    public final List<AutoMigration.DeletedColumn> component2() {
        return this.deletedColumns;
    }

    public final Set<AutoMigration.AddedTable> component3() {
        return this.addedTables;
    }

    public final Map<String, String> component4() {
        return this.renamedTables;
    }

    public final Map<String, AutoMigration.ComplexChangedTable> component5() {
        return this.complexChangedTables;
    }

    public final List<String> component6() {
        return this.deletedTables;
    }

    public final List<DatabaseViewBundle> component7() {
        return this.fromViews;
    }

    public final List<DatabaseViewBundle> component8() {
        return this.toViews;
    }

    public final SchemaDiffResult copy(List<AutoMigration.AddedColumn> r11, List<AutoMigration.DeletedColumn> r12, Set<AutoMigration.AddedTable> r13, Map<String, String> r14, Map<String, AutoMigration.ComplexChangedTable> r15, List<String> r16, List<? extends DatabaseViewBundle> r17, List<? extends DatabaseViewBundle> r18) {
        Intrinsics.checkNotNullParameter(r11, "addedColumns");
        Intrinsics.checkNotNullParameter(r12, "deletedColumns");
        Intrinsics.checkNotNullParameter(r13, "addedTables");
        Intrinsics.checkNotNullParameter(r14, "renamedTables");
        Intrinsics.checkNotNullParameter(r15, "complexChangedTables");
        Intrinsics.checkNotNullParameter(r16, "deletedTables");
        Intrinsics.checkNotNullParameter(r17, "fromViews");
        Intrinsics.checkNotNullParameter(r18, "toViews");
        return new SchemaDiffResult(r11, r12, r13, r14, r15, r16, r17, r18);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof SchemaDiffResult) == true) goto L8;
        return false;
    L8:
        SchemaDiffResult r10 = (SchemaDiffResult) r5;
        if (Intrinsics.areEqual(this.addedColumns, r10.addedColumns) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.deletedColumns, r10.deletedColumns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.addedTables, r10.addedTables) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.renamedTables, r10.renamedTables) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.complexChangedTables, r10.complexChangedTables) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.deletedTables, r10.deletedTables) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.fromViews, r10.fromViews) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.toViews, r10.toViews) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public final List<AutoMigration.AddedColumn> getAddedColumns() {
        return this.addedColumns;
    }

    public final Set<AutoMigration.AddedTable> getAddedTables() {
        return this.addedTables;
    }

    public final Map<String, AutoMigration.ComplexChangedTable> getComplexChangedTables() {
        return this.complexChangedTables;
    }

    public final List<AutoMigration.DeletedColumn> getDeletedColumns() {
        return this.deletedColumns;
    }

    public final List<String> getDeletedTables() {
        return this.deletedTables;
    }

    public final List<DatabaseViewBundle> getFromViews() {
        return this.fromViews;
    }

    public final Map<String, String> getRenamedTables() {
        return this.renamedTables;
    }

    public final List<DatabaseViewBundle> getToViews() {
        return this.toViews;
    }

    public int hashCode() {
        int r5 = this.addedColumns.hashCode() * 31;
        int r10 = a.f(this.deletedColumns, r5, 31);
        int r11 = (this.addedTables.hashCode() + r10) * 31;
        int r12 = (this.renamedTables.hashCode() + r11) * 31;
        int r13 = (this.complexChangedTables.hashCode() + r12) * 31;
        int r14 = a.f(this.deletedTables, r13, 31);
        int r15 = a.f(this.fromViews, r14, 31);
        return this.toViews.hashCode() + r15;
    }

    public String toString() {
        return "SchemaDiffResult(addedColumns=" + this.addedColumns + ", deletedColumns=" + this.deletedColumns + ", addedTables=" + this.addedTables + ", renamedTables=" + this.renamedTables + ", complexChangedTables=" + this.complexChangedTables + ", deletedTables=" + this.deletedTables + ", fromViews=" + this.fromViews + ", toViews=" + this.toViews + ")";
    }
}
