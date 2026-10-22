package androidx.room.writer;

import ai.j0;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.compiler.codegen.CodeLanguage;
import androidx.room.compiler.codegen.PoetExtKt;
import androidx.room.compiler.codegen.VisibilityModifier;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.codegen.XCodeBlock;
import androidx.room.compiler.codegen.XFunSpec;
import androidx.room.compiler.codegen.XTypeSpec;
import androidx.room.compiler.codegen.XTypeSpecKt;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.ext.RoomTypeNames;
import androidx.room.ext.SupportDbTypeNames;
import androidx.room.migration.bundle.DatabaseViewBundle;
import androidx.room.migration.bundle.EntityBundle;
import androidx.room.migration.bundle.FtsEntityBundle;
import androidx.room.migration.bundle.IndexBundle;
import androidx.room.vo.AutoMigration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u0013H\u0002J\u0010\u0010\u001d\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010!\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010$\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002JD\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130.2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0018\u0010/\u001a\u00020\u00182\u0006\u00100\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u00101\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J4\u00103\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u00104\u001a\u00020+2\u0006\u00100\u001a\u00020+2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130.H\u0002J\u0018\u00105\u001a\u00020\u00182\u0006\u00106\u001a\u00020+2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u000208H\u0002J\b\u0010:\u001a\u00020;H\u0016R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00130\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Landroidx/room/writer/AutoMigrationWriter;", "Landroidx/room/writer/TypeWriter;", "dbElement", "Landroidx/room/compiler/processing/XTypeElement;", "autoMigration", "Landroidx/room/vo/AutoMigration;", "codeLanguage", "Landroidx/room/compiler/codegen/CodeLanguage;", "(Landroidx/room/compiler/processing/XTypeElement;Landroidx/room/vo/AutoMigration;Landroidx/room/compiler/codegen/CodeLanguage;)V", "addedColumns", "", "Landroidx/room/vo/AutoMigration$AddedColumn;", "addedTables", "", "Landroidx/room/vo/AutoMigration$AddedTable;", "getAutoMigration", "()Landroidx/room/vo/AutoMigration;", "complexChangedTables", "", "", "Landroidx/room/vo/AutoMigration$ComplexChangedTable;", "deletedTables", "renamedTables", "addComplexChangeStatements", "", "migrateBuilder", "Landroidx/room/compiler/codegen/XFunSpec$Builder;", "addDatabaseExecuteSqlStatement", "sql", "addDeleteTableStatements", "addDropViewStatements", "addMigrationStatements", "addNewColumnStatements", "addNewTableStatements", "addRecreateViewStatements", "addRenameTableStatements", "addSimpleChangeStatements", "addStatementsToCheckForeignKeyConstraint", "tableName", "addStatementsToContentTransfer", "oldTableName", "tableNameWithNewPrefix", "oldEntityBundle", "Landroidx/room/migration/bundle/EntityBundle;", "newEntityBundle", "renamedColumnsMap", "", "addStatementsToCreateNewTable", "newTable", "addStatementsToDropTableAndRenameTempTable", "newTableName", "addStatementsToMigrateFtsTable", "oldTable", "addStatementsToRecreateIndexes", "table", "createConstructor", "Landroidx/room/compiler/codegen/XFunSpec;", "createMigrateMethod", "createTypeSpecBuilder", "Landroidx/room/compiler/codegen/XTypeSpec$Builder;", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoMigrationWriter extends TypeWriter {
    private final List<AutoMigration.AddedColumn> addedColumns;
    private final Set<AutoMigration.AddedTable> addedTables;
    private final AutoMigration autoMigration;
    private final Map<String, AutoMigration.ComplexChangedTable> complexChangedTables;
    private final XTypeElement dbElement;
    private final List<String> deletedTables;
    private final Map<String, String> renamedTables;

    public AutoMigrationWriter(XTypeElement r5, AutoMigration r10, CodeLanguage r11) {
        Intrinsics.checkNotNullParameter(r5, "dbElement");
        Intrinsics.checkNotNullParameter(r10, "autoMigration");
        Intrinsics.checkNotNullParameter(r11, "codeLanguage");
        super(r11);
        this.dbElement = r5;
        this.autoMigration = r10;
        this.addedColumns = r10.getSchemaDiff().getAddedColumns();
        this.addedTables = r10.getSchemaDiff().getAddedTables();
        this.renamedTables = r10.getSchemaDiff().getRenamedTables();
        this.complexChangedTables = r10.getSchemaDiff().getComplexChangedTables();
        this.deletedTables = r10.getSchemaDiff().getDeletedTables();
    }

    private final void addComplexChangeStatements(XFunSpec.Builder r13) {
        Iterator r5 = CollectionsKt.sortedWith(this.complexChangedTables.values(), new AutoMigrationWriter$addComplexChangeStatements$$inlined$sortedBy$1()).iterator();
    L4:
        if (r5.hasNext() == false) goto L13;
        AutoMigration.ComplexChangedTable r10 = (AutoMigration.ComplexChangedTable) r5.next();
        String r11 = r10.component2();
        EntityBundle r12 = r10.component3();
        EntityBundle r14 = r10.component4();
        Map<String, String> r15 = r10.component5();
        if ((r12 instanceof FtsEntityBundle) == false) goto L10;
        if (StringsKt.isBlank(((FtsEntityBundle) r12).getFtsOptions().getContentTable()) == true) goto L10;
        addStatementsToMigrateFtsTable(r13, r12, r14, r15);
    L10:
        addStatementsToCreateNewTable(r14, r13);
        addStatementsToContentTransfer(r12.getTableName(), r11, r12, r14, r15, r13);
        addStatementsToDropTableAndRenameTempTable(r12.getTableName(), r14.getTableName(), r11, r13);
        addStatementsToRecreateIndexes(r14, r13);
        if (r14.getForeignKeys().isEmpty() == true) goto L4;
        addStatementsToCheckForeignKeyConstraint(r14.getTableName(), r13);
        goto L4
    }

    private final void addDatabaseExecuteSqlStatement(XFunSpec.Builder r5, String r10) {
        XFunSpec.Builder.Companion.addStatement(r5, "database.execSQL(%S)", new Object[]{r10});
    }

    private final void addDeleteTableStatements(XFunSpec.Builder r10) {
        Iterator<T> r5 = this.deletedTables.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        String r11 = (String) r5.next();
        StringBuilder r12 = new StringBuilder();
        r12.append("DROP TABLE `" + r11 + "`");
        addDatabaseExecuteSqlStatement(r10, r12.toString());
        goto L4
    }

    private final void addDropViewStatements(XFunSpec.Builder r5) {
        Iterator<T> r10 = this.autoMigration.getSchemaDiff().getFromViews().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        addDatabaseExecuteSqlStatement(r5, j0.C("DROP VIEW ", ((DatabaseViewBundle) r10.next()).getViewName()));
        goto L4
    }

    private final void addMigrationStatements(XFunSpec.Builder r5) {
        addDropViewStatements(r5);
        addSimpleChangeStatements(r5);
        addComplexChangeStatements(r5);
        addRecreateViewStatements(r5);
    }

    private final void addNewColumnStatements(XFunSpec.Builder r10) {
        Iterator<T> r5 = this.addedColumns.iterator();
    L4:
        if (r5.hasNext() == false) goto L19;
        AutoMigration.AddedColumn r11 = (AutoMigration.AddedColumn) r5.next();
        StringBuilder r12 = new StringBuilder();
        String r13 = r11.getTableName();
        String r14 = r11.getFieldBundle().getColumnName();
        String r15 = r11.getFieldBundle().getAffinity();
        StringBuilder r16 = a.y("ALTER TABLE `", r13, "` ADD COLUMN `", r14, "` ");
        r16.append(r15);
        r12.append(r16.toString());
        if (r11.getFieldBundle().isNonNull() == false) goto L8;
        r12.append(" NOT NULL");
    L8:
        String r17 = r11.getFieldBundle().getDefaultValue();
        if (r17 == null) goto L14;
        if (r17.length() <= 0) goto L14;
        r12.append(" DEFAULT " + r11.getFieldBundle().getDefaultValue());
    L16:
        addDatabaseExecuteSqlStatement(r10, r12.toString());
    L14:
        if (r11.getFieldBundle().isNonNull() == true) goto L18;
        r12.append(" DEFAULT NULL");
        goto L16
    L18:
        throw new IllegalStateException("A Non-Null field should always have a default value.");
    }

    private final void addNewTableStatements(XFunSpec.Builder r5) {
        Iterator<T> r10 = this.addedTables.iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        AutoMigration.AddedTable r11 = (AutoMigration.AddedTable) r10.next();
        addDatabaseExecuteSqlStatement(r5, r11.getEntityBundle().createTable());
        addStatementsToRecreateIndexes(r11.getEntityBundle(), r5);
        goto L4
    }

    private final void addRecreateViewStatements(XFunSpec.Builder r5) {
        Iterator<T> r10 = this.autoMigration.getSchemaDiff().getToViews().iterator();
    L4:
        if (r10.hasNext() == false) goto L6;
        addDatabaseExecuteSqlStatement(r5, ((DatabaseViewBundle) r10.next()).createView());
        goto L4
    }

    private final void addRenameTableStatements(XFunSpec.Builder r10) {
        Iterator<Map.Entry<String, String>> r5 = this.renamedTables.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        Map.Entry<String, String> r11 = r5.next();
        addDatabaseExecuteSqlStatement(r10, j0.l("ALTER TABLE `", r11.getKey(), "` RENAME TO `", r11.getValue(), "`"));
        goto L4
    }

    private final void addSimpleChangeStatements(XFunSpec.Builder r5) {
        addDeleteTableStatements(r5);
        addRenameTableStatements(r5);
        addNewColumnStatements(r5);
        addNewTableStatements(r5);
    }

    private final void addStatementsToCheckForeignKeyConstraint(String r5, XFunSpec.Builder r10) {
        XFunSpec.Builder.Companion.addStatement(r10, "%T.foreignKeyCheck(database, %S)", new Object[]{RoomTypeNames.INSTANCE.getDB_UTIL(), r5});
    }

    private final void addStatementsToContentTransfer(String r15, String r16, EntityBundle r17, EntityBundle r18, Map<String, String> r19, XFunSpec.Builder r20) {
        Set<String> r5 = r18.getFieldsByColumnName().keySet();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        String r13 = (String) r12;
        if (r17.getFieldsByColumnName().keySet().contains(r13) == true) goto L9;
        if (r19.containsKey(r13) == false) goto L4;
    L9:
        r10.add(r12);
        goto L4
    L10:
        List r14 = CollectionsKt.toMutableList(r10);
        ArrayList r21 = new ArrayList();
        Iterator r22 = r14.iterator();
    L12:
        if (r22.hasNext() == false) goto L18;
        String r23 = (String) r22.next();
        String r24 = r19.get(r23);
        if (r24 == null) goto L17;
        r23 = r24;
    L17:
        r21.add(r23);
        goto L12
    L18:
        StringBuilder r25 = new StringBuilder();
        String r26 = CollectionsKt.q(r14, ",", null, null, 0, null, AutoMigrationWriter$addStatementsToContentTransfer$2$1.INSTANCE, 30);
        String r27 = CollectionsKt.q(r21, ",", null, null, 0, null, AutoMigrationWriter$addStatementsToContentTransfer$2$2.INSTANCE, 30);
        r25.append(a.u(a.y("INSERT INTO `", r16, "` (", r26, ") SELECT "), r27, " FROM `", r15, "`"));
        Unit r28 = Unit.INSTANCE;
        addDatabaseExecuteSqlStatement(r20, r25.toString());
    }

    private final void addStatementsToCreateNewTable(EntityBundle r5, XFunSpec.Builder r10) {
        addDatabaseExecuteSqlStatement(r10, r5.createNewTable());
    }

    private final void addStatementsToDropTableAndRenameTempTable(String r5, String r10, String r11, XFunSpec.Builder r12) {
        addDatabaseExecuteSqlStatement(r12, j0.k("DROP TABLE `", r5, "`"));
        addDatabaseExecuteSqlStatement(r12, j0.l("ALTER TABLE `", r11, "` RENAME TO `", r10, "`"));
    }

    private final void addStatementsToMigrateFtsTable(XFunSpec.Builder r19, EntityBundle r20, EntityBundle r21, Map<String, String> r22) {
        addDatabaseExecuteSqlStatement(r19, j0.k("DROP TABLE `", r20.getTableName(), "`"));
        addDatabaseExecuteSqlStatement(r19, r21.createTable());
        Set<String> r5 = r20.getFieldsByColumnName().keySet();
        ArrayList r10 = new ArrayList();
        Iterator<T> r11 = r5.iterator();
    L4:
        if (r11.hasNext() == false) goto L10;
        Object r12 = r11.next();
        String r13 = (String) r12;
        if (r20.getFieldsByColumnName().keySet().contains(r13) == true) goto L9;
        if (r22.containsKey(r13) == false) goto L4;
    L9:
        r10.add(r12);
        goto L4
    L10:
        List r14 = CollectionsKt.toMutableList(r10);
        ArrayList r15 = new ArrayList();
        Iterator r16 = r14.iterator();
    L12:
        if (r16.hasNext() == false) goto L19;
        String r17 = (String) r16.next();
        String r18 = r22.get(r17);
        if (r18 == null) goto L17;
        r17 = r18;
    L17:
        r15.add(r17);
        goto L12
    L19:
        if ((r20 instanceof FtsEntityBundle) == false) goto L21;
        r15.add("rowid");
        r14.add("docid");
    L21:
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type androidx.room.migration.bundle.FtsEntityBundle");
        String r23 = ((FtsEntityBundle) r21).getFtsOptions().getContentTable();
        if (r23.length() != 0) goto L24;
        r23 = r20.getTableName();
    L24:
        StringBuilder r24 = new StringBuilder();
        String r25 = r21.getTableName();
        String r26 = CollectionsKt.q(r14, ",", null, null, 0, null, AutoMigrationWriter$addStatementsToMigrateFtsTable$2$1.INSTANCE, 30);
        String r27 = CollectionsKt.q(r15, ",", null, null, 0, null, AutoMigrationWriter$addStatementsToMigrateFtsTable$2$2.INSTANCE, 30);
        r24.append(a.u(a.y("INSERT INTO `", r25, "` (", r26, ") SELECT "), r27, " FROM `", r23, "`"));
        Unit r28 = Unit.INSTANCE;
        addDatabaseExecuteSqlStatement(r19, r24.toString());
    }

    private final void addStatementsToRecreateIndexes(EntityBundle r5, XFunSpec.Builder r10) {
        Iterator<T> r11 = r5.getIndices().iterator();
    L4:
        if (r11.hasNext() == false) goto L6;
        addDatabaseExecuteSqlStatement(r10, ((IndexBundle) r11.next()).getCreateSql(r5.getTableName()));
        goto L4
    }

    private final XFunSpec createConstructor() {
        XFunSpec.Builder r5 = XFunSpec.Companion.constructorBuilder(getCodeLanguage(), VisibilityModifier.PUBLIC);
        XCodeBlock.Companion r10 = XCodeBlock.Companion;
        r5.callSuperConstructor(new XCodeBlock[]{r10.of(getCodeLanguage(), "%L", new Object[]{Integer.valueOf(this.autoMigration.getFrom())}), r10.of(getCodeLanguage(), "%L", new Object[]{Integer.valueOf(this.autoMigration.getTo())})});
        if (this.autoMigration.isSpecProvided() == false) goto L6;
        XFunSpec.Builder.addParameter$default(r5, PoetExtKt.toXClassName(RoomTypeNames.INSTANCE.getAUTO_MIGRATION_SPEC()), "callback", null, 4, null);
        XFunSpec.Builder.Companion.addStatement(r5, "this.callback = callback", new Object[0]);
    L6:
        return r5.build();
    }

    private final XFunSpec createMigrateMethod() {
        XFunSpec.Builder r5 = XFunSpec.Companion.builder$default(XFunSpec.Companion, getCodeLanguage(), "migrate", VisibilityModifier.PUBLIC, false, true, 8, null);
        XFunSpec.Builder.addParameter$default(r5, PoetExtKt.toXClassName(SupportDbTypeNames.INSTANCE.getDB()), "database", null, 4, null);
        addMigrationStatements(r5);
        if (this.autoMigration.getSpecClassName() == null) goto L6;
        XFunSpec.Builder.Companion.addStatement(r5, "callback.onPostMigrate(database)", new Object[0]);
    L6:
        return r5.build();
    }

    @Override // androidx.room.writer.TypeWriter
    public XTypeSpec.Builder createTypeSpecBuilder() {
        XTypeSpec.Builder r5 = XTypeSpec.Companion.classBuilder(getCodeLanguage(), this.autoMigration.getImplTypeName(this.dbElement.asClassName()));
        XTypeSpecKt.addOriginatingElement(r5, this.dbElement);
        RoomTypeNames r10 = RoomTypeNames.INSTANCE;
        r5.superclass(PoetExtKt.toXClassName(r10.getMIGRATION()));
        if (this.autoMigration.getSpecClassName() == null) goto L10;
        XClassName r11 = PoetExtKt.toXClassName(r10.getAUTO_MIGRATION_SPEC());
        VisibilityModifier r12 = VisibilityModifier.PRIVATE;
        if (this.autoMigration.isSpecProvided() == true) goto L8;
        XCodeBlock r13 = XCodeBlock.Companion.ofNewInstance$default(XCodeBlock.Companion, getCodeLanguage(), PoetExtKt.toXClassName(this.autoMigration.getSpecClassName()), null, new Object[0], 4, null);
    L9:
        XTypeSpec.Builder.addProperty$default(r5, r11, "callback", r12, false, r13, null, 40, null);
        goto L10
    L8:
        r13 = null;
    L10:
        r5.addFunction(createConstructor());
        r5.addFunction(createMigrateMethod());
        return r5;
    }

    public final AutoMigration getAutoMigration() {
        return this.autoMigration;
    }
}
