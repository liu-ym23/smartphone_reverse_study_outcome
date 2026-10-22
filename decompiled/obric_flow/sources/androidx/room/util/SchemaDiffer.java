package androidx.room.util;

import androidx.room.migration.bundle.DatabaseBundle;
import androidx.room.migration.bundle.EntityBundle;
import androidx.room.migration.bundle.FieldBundle;
import androidx.room.migration.bundle.ForeignKeyBundle;
import androidx.room.migration.bundle.FtsEntityBundle;
import androidx.room.migration.bundle.IndexBundle;
import androidx.room.processor.ProcessorErrors;
import androidx.room.vo.AutoMigration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\b¢\u0006\u0002\u0010\u0010J\"\u0010!\u001a\u0004\u0018\u00010\u00062\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020%H\u0002J\u0012\u0010&\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0006H\u0002J\u0006\u0010*\u001a\u00020+J\u001a\u0010,\u001a\u0004\u0018\u00010\t2\u0006\u0010-\u001a\u00020\u00062\u0006\u0010.\u001a\u00020\u0006H\u0002J$\u0010/\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u0002020\b2\f\u00103\u001a\b\u0012\u0004\u0012\u0002020\bH\u0002J$\u00104\u001a\u0002002\f\u00101\u001a\b\u0012\u0004\u0012\u0002050\b2\f\u00103\u001a\b\u0012\u0004\u0012\u0002050\bH\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\r2\u0006\u0010.\u001a\u00020\u0006H\u0002J*\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u001b2\u0018\u00109\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\b0\u0018H\u0002J\b\u0010:\u001a\u000208H\u0002J\b\u0010;\u001a\u000208H\u0002J\u0018\u0010<\u001a\u0002002\u0006\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u001bH\u0002R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u00120\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00060\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006="}, d2 = {"Landroidx/room/util/SchemaDiffer;", "", "fromSchemaBundle", "Landroidx/room/migration/bundle/DatabaseBundle;", "toSchemaBundle", "className", "", "renameColumnEntries", "", "Landroidx/room/vo/AutoMigration$RenamedColumn;", "deleteColumnEntries", "Landroidx/room/vo/AutoMigration$DeletedColumn;", "renameTableEntries", "Landroidx/room/vo/AutoMigration$RenamedTable;", "deleteTableEntries", "Landroidx/room/vo/AutoMigration$DeletedTable;", "(Landroidx/room/migration/bundle/DatabaseBundle;Landroidx/room/migration/bundle/DatabaseBundle;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "addedColumns", "", "Landroidx/room/vo/AutoMigration$AddedColumn;", "addedTables", "", "Landroidx/room/vo/AutoMigration$AddedTable;", "complexChangedTables", "", "Landroidx/room/vo/AutoMigration$ComplexChangedTable;", "contentTableToFtsEntities", "Landroidx/room/migration/bundle/EntityBundle;", "deletedColumns", "deletedTables", "", "potentiallyDeletedTables", "renamedTables", "detectColumnLevelChanges", "fromTable", "toTable", "fromColumn", "Landroidx/room/migration/bundle/FieldBundle;", "detectTableLevelChanges", "diffError", "", "errorMsg", "diffSchemas", "Landroidx/room/util/SchemaDiffResult;", "isColumnRenamed", "columnName", "tableName", "isForeignKeyBundlesListEqual", "", "fromBundle", "Landroidx/room/migration/bundle/ForeignKeyBundle;", "toBundle", "isIndexBundlesListEqual", "Landroidx/room/migration/bundle/IndexBundle;", "isTableRenamed", "processAddedTableAndColumns", "", "processedTablesAndColumnsInNewVersion", "processContentTables", "processDeletedColumns", "tableContainsComplexChanges", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SchemaDiffer {
    private final List<AutoMigration.AddedColumn> addedColumns;
    private final Set<AutoMigration.AddedTable> addedTables;
    private final String className;
    private final Map<String, AutoMigration.ComplexChangedTable> complexChangedTables;
    private final Map<String, List<EntityBundle>> contentTableToFtsEntities;
    private final List<AutoMigration.DeletedColumn> deleteColumnEntries;
    private final List<AutoMigration.DeletedTable> deleteTableEntries;
    private final List<AutoMigration.DeletedColumn> deletedColumns;
    private final Set<String> deletedTables;
    private final DatabaseBundle fromSchemaBundle;
    private final Set<String> potentiallyDeletedTables;
    private final List<AutoMigration.RenamedColumn> renameColumnEntries;
    private final List<AutoMigration.RenamedTable> renameTableEntries;
    private final Map<String, String> renamedTables;
    private final DatabaseBundle toSchemaBundle;

    public SchemaDiffer(DatabaseBundle r5, DatabaseBundle r10, String r11, List<AutoMigration.RenamedColumn> r12, List<AutoMigration.DeletedColumn> r13, List<AutoMigration.RenamedTable> r14, List<AutoMigration.DeletedTable> r15) {
        Intrinsics.checkNotNullParameter(r5, "fromSchemaBundle");
        Intrinsics.checkNotNullParameter(r10, "toSchemaBundle");
        Intrinsics.checkNotNullParameter(r12, "renameColumnEntries");
        Intrinsics.checkNotNullParameter(r13, "deleteColumnEntries");
        Intrinsics.checkNotNullParameter(r14, "renameTableEntries");
        Intrinsics.checkNotNullParameter(r15, "deleteTableEntries");
        this.fromSchemaBundle = r5;
        this.toSchemaBundle = r10;
        this.className = r11;
        this.renameColumnEntries = r12;
        this.deleteColumnEntries = r13;
        this.renameTableEntries = r14;
        this.deleteTableEntries = r15;
        this.potentiallyDeletedTables = new LinkedHashSet();
        this.contentTableToFtsEntities = new LinkedHashMap();
        this.addedTables = new LinkedHashSet();
        this.renamedTables = new LinkedHashMap();
        this.complexChangedTables = new LinkedHashMap();
        ArrayList r16 = new ArrayList(CollectionsKt.h(r15));
        Iterator<T> r17 = r15.iterator();
    L4:
        if (r17.hasNext() == false) goto L6;
        r16.add(((AutoMigration.DeletedTable) r17.next()).getDeletedTableName());
        goto L4
    L6:
        this.deletedTables = CollectionsKt.toSet(r16);
        this.addedColumns = new ArrayList();
        this.deletedColumns = this.deleteColumnEntries;
    }

    private final String detectColumnLevelChanges(EntityBundle r10, EntityBundle r11, FieldBundle r12) {
        AutoMigration.RenamedColumn r5 = isColumnRenamed(r12.getColumnName(), r10.getTableName());
        if (r5 != null) goto L5;
        FieldBundle r13 = r11.getFieldsByColumnName().get(r12.getColumnName());
        if (r13 != null) goto L20;
        List<AutoMigration.DeletedColumn> r14 = this.deletedColumns;
        if (r14 != null) goto L33;
    L34:
        Iterator<T> r15 = r14.iterator();
    L36:
        if (r15.hasNext() == false) goto L43;
        AutoMigration.DeletedColumn r16 = (AutoMigration.DeletedColumn) r15.next();
        if (Intrinsics.areEqual(r16.getTableName(), r10.getTableName()) == false) goto L36;
        if (Intrinsics.areEqual(r16.getColumnName(), r12.getColumnName()) == false) goto L36;
        return null;
    L43:
        ProcessorErrors r17 = ProcessorErrors.INSTANCE;
        String r18 = this.className;
        String r19 = r10.getTableName();
        diffError(r17.deletedOrRenamedColumnFound(r18, r12.getColumnName(), r19));
        throw new KotlinNothingValueException();
    L33:
        if (r14.isEmpty() == true) goto L43;
    L20:
        if (r13.isSchemaEqual2(r12) == true) goto L29;
        if (this.complexChangedTables.containsKey(r10.getTableName()) == true) goto L29;
        if (this.toSchemaBundle.getEntitiesByTableName().containsKey(r11.getNewTableName()) == true) goto L26;
        this.renamedTables.remove(r10.getTableName());
        this.complexChangedTables.put(r10.getTableName(), new AutoMigration.ComplexChangedTable(r10.getTableName(), r11.getNewTableName(), r10, r11, new LinkedHashMap()));
        goto L29
    L26:
        diffError(ProcessorErrors.INSTANCE.tableWithConflictingPrefixFound(r11.getNewTableName()));
        throw new KotlinNothingValueException();
    L29:
        return r13.getColumnName();
    L5:
        if (this.toSchemaBundle.getEntitiesByTableName().containsKey(r11.getNewTableName()) == true) goto L15;
        this.renamedTables.remove(r10.getTableName());
        AutoMigration.ComplexChangedTable r20 = this.complexChangedTables.get(r10.getTableName());
        if (r20 == null) goto L12;
        Map<String, String> r21 = r20.getRenamedColumnsMap();
        if (r21 == null) goto L12;
    L11:
        Map<String, String> r22 = r21;
        r22.put(r5.getNewColumnName(), r12.getColumnName());
        this.complexChangedTables.put(r10.getTableName(), new AutoMigration.ComplexChangedTable(r10.getTableName(), r11.getNewTableName(), r10, r11, r22));
        return r5.getNewColumnName();
    L12:
        r21 = new LinkedHashMap();
        goto L11
    L15:
        diffError(ProcessorErrors.INSTANCE.tableWithConflictingPrefixFound(r11.getNewTableName()));
        throw new KotlinNothingValueException();
    }

    private final EntityBundle detectTableLevelChanges(EntityBundle r10) {
        AutoMigration.RenamedTable r5 = isTableRenamed(r10.getTableName());
        if (r5 == null) goto L19;
        EntityBundle r11 = this.toSchemaBundle.getEntitiesByTableName().get(r5.getNewTableName());
        if (r11 == null) goto L17;
        boolean r12 = r10 instanceof FtsEntityBundle;
        if (tableContainsComplexChanges(r10, r11) == true) goto L12;
        if (r12 == true) goto L12;
        this.renamedTables.put(r10.getTableName(), r11.getTableName());
    L14:
        return r11;
    L12:
        if (this.toSchemaBundle.getEntitiesByTableName().containsKey(r11.getNewTableName()) == true) goto L15;
        this.renamedTables.remove(r5.getOriginalTableName());
        this.complexChangedTables.put(r5.getOriginalTableName(), new AutoMigration.ComplexChangedTable(r11.getTableName(), r11.getNewTableName(), r10, r11, new LinkedHashMap()));
        goto L14
    L15:
        diffError(ProcessorErrors.INSTANCE.tableWithConflictingPrefixFound(r11.getNewTableName()));
        throw new KotlinNothingValueException();
    L17:
        ProcessorErrors r13 = ProcessorErrors.INSTANCE;
        String r14 = this.className;
        Intrinsics.checkNotNull(r14);
        diffError(r13.tableRenameError(r14, r5.getOriginalTableName(), r5.getNewTableName()));
        throw new KotlinNothingValueException();
    L19:
        EntityBundle r15 = this.toSchemaBundle.getEntitiesByTableName().get(r10.getTableName());
        boolean r16 = this.deletedTables.contains(r10.getTableName());
        if (r15 == null) goto L28;
        if (r16 == false) goto L23;
        diffError(ProcessorErrors.INSTANCE.deletedOrRenamedTableFound(this.className, r15.getTableName()));
        throw new KotlinNothingValueException();
    L23:
        if (tableContainsComplexChanges(r10, r15) == false) goto L25;
        this.complexChangedTables.put(r10.getTableName(), new AutoMigration.ComplexChangedTable(r15.getTableName(), r15.getNewTableName(), r10, r15, new LinkedHashMap()));
    L25:
        return r15;
    L28:
        if (r16 == true) goto L32;
        this.potentiallyDeletedTables.add(r10.getTableName());
        return null;
    L32:
        return null;
    }

    private final Void diffError(String r5) {
        throw new DiffException(r5);
    }

    private final AutoMigration.RenamedColumn isColumnRenamed(String r10, String r11) {
        List<AutoMigration.RenamedColumn> r5 = this.renameColumnEntries;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r5.iterator();
    L4:
        if (r13.hasNext() == false) goto L11;
        Object r14 = r13.next();
        AutoMigration.RenamedColumn r15 = (AutoMigration.RenamedColumn) r14;
        if (Intrinsics.areEqual(r15.getOriginalColumnName(), r10) == false) goto L4;
        if (Intrinsics.areEqual(r15.getTableName(), r11) == false) goto L4;
        r12.add(r14);
        goto L4
    L11:
        if (r12.size() <= 1) goto L13;
        diffError(ProcessorErrors.INSTANCE.conflictingRenameColumnAnnotationsFound(CollectionsKt.q(r12, ",", null, null, 0, null, null, 62)));
        throw new KotlinNothingValueException();
    L13:
        return (AutoMigration.RenamedColumn) CollectionsKt.firstOrNull(r12);
    }

    private final boolean isForeignKeyBundlesListEqual(List<? extends ForeignKeyBundle> r5, List<? extends ForeignKeyBundle> r10) {
        List r11 = CollectionsKt.plus(r5, r10);
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r14 = r13.next();
        List<String> r15 = ((ForeignKeyBundle) r14).getColumns();
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        Iterator r17 = r12.entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L18;
        List r18 = (List) ((Map.Entry) r17.next()).getValue();
        if (r18.size() < 2) goto L14;
        if (((ForeignKeyBundle) r18.get(0)).isSchemaEqual2((ForeignKeyBundle) r18.get(1)) == true) goto L11;
        return false;
    L14:
        return false;
    L18:
        return true;
    }

    private final boolean isIndexBundlesListEqual(List<? extends IndexBundle> r5, List<? extends IndexBundle> r10) {
        List r11 = CollectionsKt.plus(r5, r10);
        LinkedHashMap r12 = new LinkedHashMap();
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L9;
        Object r14 = r13.next();
        String r15 = ((IndexBundle) r14).getName();
        Object r16 = r12.get(r15);
        if (r16 != null) goto L8;
        r16 = new ArrayList();
        r12.put(r15, r16);
    L8:
        ((List) r16).add(r14);
        goto L4
    L9:
        Iterator r17 = r12.entrySet().iterator();
    L11:
        if (r17.hasNext() == false) goto L18;
        Map.Entry r18 = (Map.Entry) r17.next();
        if (((List) r18.getValue()).size() < 2) goto L14;
        if (((IndexBundle) ((List) r18.getValue()).get(0)).isSchemaEqual2((IndexBundle) ((List) r18.getValue()).get(1)) == true) goto L11;
        return false;
    L14:
        return false;
    L18:
        return true;
    }

    private final AutoMigration.RenamedTable isTableRenamed(String r10) {
        List<AutoMigration.RenamedTable> r5 = this.renameTableEntries;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r5.iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        Object r13 = r12.next();
        if (Intrinsics.areEqual(((AutoMigration.RenamedTable) r13).getOriginalTableName(), r10) == false) goto L4;
        r11.add(r13);
        goto L4
    L9:
        if (r11.size() <= 1) goto L11;
        diffError(ProcessorErrors.INSTANCE.conflictingRenameTableAnnotationsFound(CollectionsKt.q(r11, ",", null, null, 0, null, null, 62)));
        throw new KotlinNothingValueException();
    L11:
        return (AutoMigration.RenamedTable) CollectionsKt.firstOrNull(r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r3v10, types: [java.util.AbstractMap, java.util.LinkedHashMap] */
    private final void processAddedTableAndColumns(EntityBundle r10, Map<String, List<String>> r11) {
        Iterator r5 = this.renameTableEntries.iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Object r12 = r5.next();
        if (Intrinsics.areEqual(((AutoMigration.RenamedTable) r12).getNewTableName(), r10.getTableName()) == false) goto L4;
    L9:
        AutoMigration.RenamedTable r13 = (AutoMigration.RenamedTable) r12;
        if (r13 == null) goto L12;
        EntityBundle r14 = this.fromSchemaBundle.getEntitiesByTableName().get(r13.getOriginalTableName());
    L13:
        if (r14 != null) goto L16;
        this.addedTables.add(new AutoMigration.AddedTable(r10));
        return;
    L16:
        Map<String, FieldBundle> r15 = r14.getFieldsByColumnName();
        List<String> r16 = r11.get(r10.getTableName());
        if (r16 == null) goto L24;
        Map<String, FieldBundle> r17 = r10.getFieldsByColumnName();
        ?? r18 = new LinkedHashMap();
        Iterator<Map.Entry<String, FieldBundle>> r19 = r17.entrySet().iterator();
    L20:
        if (r19.hasNext() == false) goto L25;
        Map.Entry<String, FieldBundle> r20 = r19.next();
        if (r16.contains(r20.getKey()) == true) goto L20;
        r18.put(r20.getKey(), r20.getValue());
    L25:
        Iterator r21 = r18.values().iterator();
    L27:
        if (r21.hasNext() == false) goto L40;
        FieldBundle r22 = (FieldBundle) r21.next();
        if (r15.get(r22.getColumnName()) != null) goto L27;
        if (r22.isNonNull() == false) goto L38;
        if (r22.getDefaultValue() != null) goto L38;
        diffError(ProcessorErrors.INSTANCE.newNotNullColumnMustHaveDefaultValue(r22.getColumnName()));
        throw new KotlinNothingValueException();
    L38:
        if (this.complexChangedTables.containsKey(r14.getTableName()) == true) goto L27;
        this.addedColumns.add(new AutoMigration.AddedColumn(r10.getTableName(), r22));
        goto L27
    L40:
        return;
    L24:
        r18 = r10.getFieldsByColumnName();
        goto L25
    L12:
        r14 = this.fromSchemaBundle.getEntitiesByTableName().get(r10.getTableName());
        goto L13
    L8:
        r12 = null;
        goto L9
    }

    private final void processContentTables() {
        Iterator<T> r5 = this.renameTableEntries.iterator();
    L4:
        if (r5.hasNext() == false) goto L17;
        AutoMigration.RenamedTable r10 = (AutoMigration.RenamedTable) r5.next();
        List<EntityBundle> r11 = this.contentTableToFtsEntities.get(r10.getOriginalTableName());
        if (r11 == null) goto L4;
        ArrayList r12 = new ArrayList();
        Iterator<T> r13 = r11.iterator();
    L9:
        if (r13.hasNext() == false) goto L13;
        Object r14 = r13.next();
        if (this.complexChangedTables.containsKey(((EntityBundle) r14).getTableName()) == true) goto L9;
        r12.add(r14);
        goto L9
    L13:
        Iterator r15 = r12.iterator();
    L15:
        if (r15.hasNext() == false) goto L4;
        EntityBundle r16 = (EntityBundle) r15.next();
        this.complexChangedTables.put(r16.getTableName(), new AutoMigration.ComplexChangedTable(r16.getTableName(), r16.getNewTableName(), r16, r16, new LinkedHashMap()));
        goto L15
    }

    private final void processDeletedColumns() {
        List<AutoMigration.DeletedColumn> r5 = this.deletedColumns;
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L8;
        Object r12 = r11.next();
        if (this.complexChangedTables.containsKey(((AutoMigration.DeletedColumn) r12).getTableName()) == true) goto L4;
        r10.add(r12);
        goto L4
    L8:
        Iterator r13 = r10.iterator();
    L10:
        if (r13.hasNext() == false) goto L12;
        AutoMigration.DeletedColumn r14 = (AutoMigration.DeletedColumn) r13.next();
        EntityBundle r15 = (EntityBundle) MapsKt.getValue(this.fromSchemaBundle.getEntitiesByTableName(), r14.getTableName());
        EntityBundle r16 = (EntityBundle) MapsKt.getValue(this.toSchemaBundle.getEntitiesByTableName(), r14.getTableName());
        this.complexChangedTables.put(r14.getTableName(), new AutoMigration.ComplexChangedTable(r14.getTableName(), r15.getNewTableName(), r15, r16, new LinkedHashMap()));
        goto L10
    }

    private final boolean tableContainsComplexChanges(EntityBundle r10, EntityBundle r11) {
        boolean r5 = r10 instanceof FtsEntityBundle;
        if (r5 == true) goto L5;
    L9:
        if (r5 == false) goto L13;
        if ((r11 instanceof FtsEntityBundle) == true) goto L13;
    L15:
        return true;
    L13:
        if ((r11 instanceof FtsEntityBundle) == false) goto L17;
        if (r5 == false) goto L15;
    L17:
        if (isForeignKeyBundlesListEqual(r10.getForeignKeys(), r11.getForeignKeys()) == true) goto L20;
        return true;
    L20:
        if (isIndexBundlesListEqual(r10.getIndices(), r11.getIndices()) == true) goto L23;
        return true;
    L23:
        if (r10.getPrimaryKey().isSchemaEqual2(r11.getPrimaryKey()) == true) goto L25;
        return true;
    L25:
        List<ForeignKeyBundle> r12 = r10.getForeignKeys();
        if (r12 != null) goto L28;
    L30:
        Iterator<T> r13 = r12.iterator();
    L32:
        if (r13.hasNext() == false) goto L43;
        ForeignKeyBundle r14 = (ForeignKeyBundle) r13.next();
        List<AutoMigration.RenamedTable> r15 = this.renameTableEntries;
        if (r15 == null) goto L38;
        if (r15.isEmpty() == true) goto L32;
    L38:
        Iterator<T> r16 = r15.iterator();
    L40:
        if (r16.hasNext() == false) goto L32;
        if (Intrinsics.areEqual(((AutoMigration.RenamedTable) r16.next()).getOriginalTableName(), r14.getTable()) == false) goto L40;
        return true;
    L43:
        return false;
    L28:
        if (r12.isEmpty() == false) goto L30;
    L5:
        if ((r11 instanceof FtsEntityBundle) == false) goto L9;
        if (((FtsEntityBundle) r10).getFtsOptions().isSchemaEqual2(((FtsEntityBundle) r11).getFtsOptions()) == true) goto L9;
        return true;
    }

    public final SchemaDiffResult diffSchemas() {
        LinkedHashMap r5 = new LinkedHashMap();
        Iterator<T> r10 = this.fromSchemaBundle.getEntitiesByTableName().values().iterator();
    L4:
        if (r10.hasNext() == false) goto L22;
        EntityBundle r11 = (EntityBundle) r10.next();
        EntityBundle r12 = detectTableLevelChanges(r11);
        if (r12 == null) goto L4;
        if ((r11 instanceof FtsEntityBundle) == false) goto L15;
        FtsEntityBundle r13 = (FtsEntityBundle) r11;
        if (r13.getFtsOptions().getContentTable().length() <= 0) goto L15;
        Map<String, List<EntityBundle>> r14 = this.contentTableToFtsEntities;
        String r15 = r13.getFtsOptions().getContentTable();
        List<EntityBundle> r16 = r14.get(r15);
        if (r16 != null) goto L14;
        r16 = new ArrayList();
        r14.put(r15, r16);
    L14:
        r16.add(r11);
    L15:
        Collection<FieldBundle> r17 = r11.getFieldsByColumnName().values();
        ArrayList r18 = new ArrayList();
        Iterator<T> r19 = r17.iterator();
    L17:
        if (r19.hasNext() == false) goto L21;
        String r20 = detectColumnLevelChanges(r11, r12, (FieldBundle) r19.next());
        if (r20 == null) goto L17;
        r18.add(r20);
        goto L17
    L21:
        r5.put(r12.getTableName(), r18);
        goto L4
    L22:
        Iterator<Map.Entry<String, EntityBundle>> r21 = this.toSchemaBundle.getEntitiesByTableName().entrySet().iterator();
    L24:
        if (r21.hasNext() == false) goto L26;
        processAddedTableAndColumns(r21.next().getValue(), r5);
        goto L24
    L26:
        Iterator<T> r22 = this.potentiallyDeletedTables.iterator();
        if (r22.hasNext() == true) goto L30;
        processDeletedColumns();
        processContentTables();
        return new SchemaDiffResult(this.addedColumns, this.deletedColumns, this.addedTables, this.renamedTables, this.complexChangedTables, CollectionsKt.toList(this.deletedTables), this.fromSchemaBundle.getViews(), this.toSchemaBundle.getViews());
    L30:
        String r23 = (String) r22.next();
        diffError(ProcessorErrors.INSTANCE.deletedOrRenamedTableFound(this.className, r23));
        throw new KotlinNothingValueException();
    }
}
