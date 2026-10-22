package androidx.room.vo;

import ai.j0;
import androidx.room.compiler.codegen.XClassName;
import androidx.room.compiler.processing.XTypeElement;
import androidx.room.migration.bundle.EntityBundle;
import androidx.room.migration.bundle.FieldBundle;
import androidx.room.util.SchemaDiffResult;
import com.squareup.javapoet.e;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\b\u0086\b\u0018\u00002\u00020\u0001:\u00070123456B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0013\u0010\u0012J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0016\u001a\u00020\u0007HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\tHÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019JD\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u0012J\u001a\u0010!\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0012R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010#\u001a\u0004\b%\u0010\u0012R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010&\u001a\u0004\b'\u0010\u0015R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b)\u0010\u0017R\u0017\u0010\n\u001a\u00020\t8\u0006¢\u0006\f\n\u0004\b\n\u0010*\u001a\u0004\b\n\u0010\u0019R\u0019\u0010,\u001a\u0004\u0018\u00010+8\u0006¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b.\u0010/¨\u00067"}, d2 = {"Landroidx/room/vo/AutoMigration;", "", "", "from", "to", "Landroidx/room/compiler/processing/XTypeElement;", "specElement", "Landroidx/room/util/SchemaDiffResult;", "schemaDiff", "", "isSpecProvided", "<init>", "(IILandroidx/room/compiler/processing/XTypeElement;Landroidx/room/util/SchemaDiffResult;Z)V", "Landroidx/room/compiler/codegen/XClassName;", "databaseClassName", "getImplTypeName", "(Landroidx/room/compiler/codegen/XClassName;)Landroidx/room/compiler/codegen/XClassName;", "component1", "()I", "component2", "component3", "()Landroidx/room/compiler/processing/XTypeElement;", "component4", "()Landroidx/room/util/SchemaDiffResult;", "component5", "()Z", "copy", "(IILandroidx/room/compiler/processing/XTypeElement;Landroidx/room/util/SchemaDiffResult;Z)Landroidx/room/vo/AutoMigration;", "", "toString", "()Ljava/lang/String;", "hashCode", "other", "equals", "(Ljava/lang/Object;)Z", "I", "getFrom", "getTo", "Landroidx/room/compiler/processing/XTypeElement;", "getSpecElement", "Landroidx/room/util/SchemaDiffResult;", "getSchemaDiff", "Z", "Lcom/squareup/javapoet/e;", "specClassName", "Lcom/squareup/javapoet/e;", "getSpecClassName", "()Lcom/squareup/javapoet/e;", "AddedColumn", "AddedTable", "ComplexChangedTable", "DeletedColumn", "DeletedTable", "RenamedColumn", "RenamedTable", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AutoMigration {
    private final int from;
    private final boolean isSpecProvided;
    private final SchemaDiffResult schemaDiff;
    private final e specClassName;
    private final XTypeElement specElement;

    /* JADX INFO: renamed from: to, reason: collision with root package name */
    private final int f691to;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Landroidx/room/vo/AutoMigration$AddedColumn;", "", "tableName", "", "fieldBundle", "Landroidx/room/migration/bundle/FieldBundle;", "(Ljava/lang/String;Landroidx/room/migration/bundle/FieldBundle;)V", "getFieldBundle", "()Landroidx/room/migration/bundle/FieldBundle;", "getTableName", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AddedColumn {
        private final FieldBundle fieldBundle;
        private final String tableName;

        public AddedColumn(String r5, FieldBundle r10) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "fieldBundle");
            this.tableName = r5;
            this.fieldBundle = r10;
        }

        public static /* synthetic */ AddedColumn copy$default(AddedColumn r5, String r10, FieldBundle r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.tableName;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.fieldBundle;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.tableName;
        }

        public final FieldBundle component2() {
            return this.fieldBundle;
        }

        public final AddedColumn copy(String r5, FieldBundle r10) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "fieldBundle");
            return new AddedColumn(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AddedColumn) == true) goto L8;
            return false;
        L8:
            AddedColumn r10 = (AddedColumn) r5;
            if (Intrinsics.areEqual(this.tableName, r10.tableName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.fieldBundle, r10.fieldBundle) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final FieldBundle getFieldBundle() {
            return this.fieldBundle;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public int hashCode() {
            int r5 = this.tableName.hashCode() * 31;
            return this.fieldBundle.hashCode() + r5;
        }

        public String toString() {
            return "AddedColumn(tableName=" + this.tableName + ", fieldBundle=" + this.fieldBundle + ")";
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/room/vo/AutoMigration$AddedTable;", "", "entityBundle", "Landroidx/room/migration/bundle/EntityBundle;", "(Landroidx/room/migration/bundle/EntityBundle;)V", "getEntityBundle", "()Landroidx/room/migration/bundle/EntityBundle;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class AddedTable {
        private final EntityBundle entityBundle;

        public AddedTable(EntityBundle r5) {
            Intrinsics.checkNotNullParameter(r5, "entityBundle");
            this.entityBundle = r5;
        }

        public static /* synthetic */ AddedTable copy$default(AddedTable r5, EntityBundle r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.entityBundle;
        L6:
            return r5.copy(r10);
        }

        public final EntityBundle component1() {
            return this.entityBundle;
        }

        public final AddedTable copy(EntityBundle r5) {
            Intrinsics.checkNotNullParameter(r5, "entityBundle");
            return new AddedTable(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof AddedTable) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.entityBundle, ((AddedTable) r5).entityBundle) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final EntityBundle getEntityBundle() {
            return this.entityBundle;
        }

        public int hashCode() {
            return this.entityBundle.hashCode();
        }

        public String toString() {
            return "AddedTable(entityBundle=" + this.entityBundle + ")";
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J\u0015\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0003JG\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u0014\b\u0002\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\tHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011¨\u0006\u001f"}, d2 = {"Landroidx/room/vo/AutoMigration$ComplexChangedTable;", "", "tableName", "", "tableNameWithNewPrefix", "oldVersionEntityBundle", "Landroidx/room/migration/bundle/EntityBundle;", "newVersionEntityBundle", "renamedColumnsMap", "", "(Ljava/lang/String;Ljava/lang/String;Landroidx/room/migration/bundle/EntityBundle;Landroidx/room/migration/bundle/EntityBundle;Ljava/util/Map;)V", "getNewVersionEntityBundle", "()Landroidx/room/migration/bundle/EntityBundle;", "getOldVersionEntityBundle", "getRenamedColumnsMap", "()Ljava/util/Map;", "getTableName", "()Ljava/lang/String;", "getTableNameWithNewPrefix", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ComplexChangedTable {
        private final EntityBundle newVersionEntityBundle;
        private final EntityBundle oldVersionEntityBundle;
        private final Map<String, String> renamedColumnsMap;
        private final String tableName;
        private final String tableNameWithNewPrefix;

        public ComplexChangedTable(String r5, String r10, EntityBundle r11, EntityBundle r12, Map<String, String> r13) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "tableNameWithNewPrefix");
            Intrinsics.checkNotNullParameter(r11, "oldVersionEntityBundle");
            Intrinsics.checkNotNullParameter(r12, "newVersionEntityBundle");
            Intrinsics.checkNotNullParameter(r13, "renamedColumnsMap");
            this.tableName = r5;
            this.tableNameWithNewPrefix = r10;
            this.oldVersionEntityBundle = r11;
            this.newVersionEntityBundle = r12;
            this.renamedColumnsMap = r13;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ComplexChangedTable copy$default(ComplexChangedTable r5, String r10, String r11, EntityBundle r12, EntityBundle r13, Map r14, int r15, Object r16) {
            if ((r15 & 1) == 0) goto L6;
            r10 = r5.tableName;
        L6:
            if ((r15 & 2) == 0) goto L8;
            r11 = r5.tableNameWithNewPrefix;
        L8:
            String r17 = r11;
            if ((r15 & 4) == 0) goto L11;
            r12 = r5.oldVersionEntityBundle;
        L11:
            EntityBundle r18 = r12;
            if ((r15 & 8) == 0) goto L14;
            r13 = r5.newVersionEntityBundle;
        L14:
            EntityBundle r19 = r13;
            if ((r15 & 16) == 0) goto L17;
            r14 = r5.renamedColumnsMap;
        L17:
            String r20 = r10;
            return r5.copy(r20, r17, r18, r19, r14);
        }

        public final String component1() {
            return this.tableName;
        }

        public final String component2() {
            return this.tableNameWithNewPrefix;
        }

        public final EntityBundle component3() {
            return this.oldVersionEntityBundle;
        }

        public final EntityBundle component4() {
            return this.newVersionEntityBundle;
        }

        public final Map<String, String> component5() {
            return this.renamedColumnsMap;
        }

        public final ComplexChangedTable copy(String r10, String r11, EntityBundle r12, EntityBundle r13, Map<String, String> r14) {
            Intrinsics.checkNotNullParameter(r10, "tableName");
            Intrinsics.checkNotNullParameter(r11, "tableNameWithNewPrefix");
            Intrinsics.checkNotNullParameter(r12, "oldVersionEntityBundle");
            Intrinsics.checkNotNullParameter(r13, "newVersionEntityBundle");
            Intrinsics.checkNotNullParameter(r14, "renamedColumnsMap");
            return new ComplexChangedTable(r10, r11, r12, r13, r14);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ComplexChangedTable) == true) goto L8;
            return false;
        L8:
            ComplexChangedTable r10 = (ComplexChangedTable) r5;
            if (Intrinsics.areEqual(this.tableName, r10.tableName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.tableNameWithNewPrefix, r10.tableNameWithNewPrefix) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.oldVersionEntityBundle, r10.oldVersionEntityBundle) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.newVersionEntityBundle, r10.newVersionEntityBundle) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.renamedColumnsMap, r10.renamedColumnsMap) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final EntityBundle getNewVersionEntityBundle() {
            return this.newVersionEntityBundle;
        }

        public final EntityBundle getOldVersionEntityBundle() {
            return this.oldVersionEntityBundle;
        }

        public final Map<String, String> getRenamedColumnsMap() {
            return this.renamedColumnsMap;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public final String getTableNameWithNewPrefix() {
            return this.tableNameWithNewPrefix;
        }

        public int hashCode() {
            int r5 = androidx.constraintlayout.motion.widget.a.c(this.tableName.hashCode() * 31, 31, this.tableNameWithNewPrefix);
            int r10 = (this.oldVersionEntityBundle.hashCode() + r5) * 31;
            int r11 = (this.newVersionEntityBundle.hashCode() + r10) * 31;
            return this.renamedColumnsMap.hashCode() + r11;
        }

        public String toString() {
            String r5 = this.tableName;
            String r10 = this.tableNameWithNewPrefix;
            EntityBundle r11 = this.oldVersionEntityBundle;
            EntityBundle r12 = this.newVersionEntityBundle;
            Map<String, String> r13 = this.renamedColumnsMap;
            StringBuilder r14 = androidx.constraintlayout.motion.widget.a.y("ComplexChangedTable(tableName=", r5, ", tableNameWithNewPrefix=", r10, ", oldVersionEntityBundle=");
            r14.append(r11);
            r14.append(", newVersionEntityBundle=");
            r14.append(r12);
            r14.append(", renamedColumnsMap=");
            r14.append(r13);
            r14.append(")");
            return r14.toString();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/room/vo/AutoMigration$DeletedColumn;", "", "tableName", "", "columnName", "(Ljava/lang/String;Ljava/lang/String;)V", "getColumnName", "()Ljava/lang/String;", "getTableName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DeletedColumn {
        private final String columnName;
        private final String tableName;

        public DeletedColumn(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "columnName");
            this.tableName = r5;
            this.columnName = r10;
        }

        public static /* synthetic */ DeletedColumn copy$default(DeletedColumn r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.tableName;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.columnName;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.tableName;
        }

        public final String component2() {
            return this.columnName;
        }

        public final DeletedColumn copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "columnName");
            return new DeletedColumn(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DeletedColumn) == true) goto L8;
            return false;
        L8:
            DeletedColumn r10 = (DeletedColumn) r5;
            if (Intrinsics.areEqual(this.tableName, r10.tableName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.columnName, r10.columnName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getColumnName() {
            return this.columnName;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public int hashCode() {
            int r5 = this.tableName.hashCode() * 31;
            return this.columnName.hashCode() + r5;
        }

        public String toString() {
            return j0.l("DeletedColumn(tableName=", this.tableName, ", columnName=", this.columnName, ")");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Landroidx/room/vo/AutoMigration$DeletedTable;", "", "deletedTableName", "", "(Ljava/lang/String;)V", "getDeletedTableName", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DeletedTable {
        private final String deletedTableName;

        public DeletedTable(String r5) {
            Intrinsics.checkNotNullParameter(r5, "deletedTableName");
            this.deletedTableName = r5;
        }

        public static /* synthetic */ DeletedTable copy$default(DeletedTable r5, String r10, int r11, Object r12) {
            if ((r11 & 1) == 0) goto L6;
            r10 = r5.deletedTableName;
        L6:
            return r5.copy(r10);
        }

        public final String component1() {
            return this.deletedTableName;
        }

        public final DeletedTable copy(String r5) {
            Intrinsics.checkNotNullParameter(r5, "deletedTableName");
            return new DeletedTable(r5);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof DeletedTable) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.deletedTableName, ((DeletedTable) r5).deletedTableName) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final String getDeletedTableName() {
            return this.deletedTableName;
        }

        public int hashCode() {
            return this.deletedTableName.hashCode();
        }

        public String toString() {
            return j0.k("DeletedTable(deletedTableName=", this.deletedTableName, ")");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Landroidx/room/vo/AutoMigration$RenamedColumn;", "", "tableName", "", "originalColumnName", "newColumnName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getNewColumnName", "()Ljava/lang/String;", "getOriginalColumnName", "getTableName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RenamedColumn {
        private final String newColumnName;
        private final String originalColumnName;
        private final String tableName;

        public RenamedColumn(String r5, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "originalColumnName");
            Intrinsics.checkNotNullParameter(r11, "newColumnName");
            this.tableName = r5;
            this.originalColumnName = r10;
            this.newColumnName = r11;
        }

        public static /* synthetic */ RenamedColumn copy$default(RenamedColumn r5, String r10, String r11, String r12, int r13, Object r14) {
            if ((r13 & 1) == 0) goto L6;
            r10 = r5.tableName;
        L6:
            if ((r13 & 2) == 0) goto L9;
            r11 = r5.originalColumnName;
        L9:
            if ((r13 & 4) == 0) goto L12;
            r12 = r5.newColumnName;
        L12:
            return r5.copy(r10, r11, r12);
        }

        public final String component1() {
            return this.tableName;
        }

        public final String component2() {
            return this.originalColumnName;
        }

        public final String component3() {
            return this.newColumnName;
        }

        public final RenamedColumn copy(String r5, String r10, String r11) {
            Intrinsics.checkNotNullParameter(r5, "tableName");
            Intrinsics.checkNotNullParameter(r10, "originalColumnName");
            Intrinsics.checkNotNullParameter(r11, "newColumnName");
            return new RenamedColumn(r5, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RenamedColumn) == true) goto L8;
            return false;
        L8:
            RenamedColumn r10 = (RenamedColumn) r5;
            if (Intrinsics.areEqual(this.tableName, r10.tableName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.originalColumnName, r10.originalColumnName) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.newColumnName, r10.newColumnName) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final String getNewColumnName() {
            return this.newColumnName;
        }

        public final String getOriginalColumnName() {
            return this.originalColumnName;
        }

        public final String getTableName() {
            return this.tableName;
        }

        public int hashCode() {
            int r5 = androidx.constraintlayout.motion.widget.a.c(this.tableName.hashCode() * 31, 31, this.originalColumnName);
            return this.newColumnName.hashCode() + r5;
        }

        public String toString() {
            String r5 = this.tableName;
            String r10 = this.originalColumnName;
            String r11 = this.newColumnName;
            return j0.q(androidx.constraintlayout.motion.widget.a.y("RenamedColumn(tableName=", r5, ", originalColumnName=", r10, ", newColumnName="), r11, ")");
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Landroidx/room/vo/AutoMigration$RenamedTable;", "", "originalTableName", "", "newTableName", "(Ljava/lang/String;Ljava/lang/String;)V", "getNewTableName", "()Ljava/lang/String;", "getOriginalTableName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "room-compiler"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class RenamedTable {
        private final String newTableName;
        private final String originalTableName;

        public RenamedTable(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "originalTableName");
            Intrinsics.checkNotNullParameter(r10, "newTableName");
            this.originalTableName = r5;
            this.newTableName = r10;
        }

        public static /* synthetic */ RenamedTable copy$default(RenamedTable r5, String r10, String r11, int r12, Object r13) {
            if ((r12 & 1) == 0) goto L6;
            r10 = r5.originalTableName;
        L6:
            if ((r12 & 2) == 0) goto L9;
            r11 = r5.newTableName;
        L9:
            return r5.copy(r10, r11);
        }

        public final String component1() {
            return this.originalTableName;
        }

        public final String component2() {
            return this.newTableName;
        }

        public final RenamedTable copy(String r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "originalTableName");
            Intrinsics.checkNotNullParameter(r10, "newTableName");
            return new RenamedTable(r5, r10);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof RenamedTable) == true) goto L8;
            return false;
        L8:
            RenamedTable r10 = (RenamedTable) r5;
            if (Intrinsics.areEqual(this.originalTableName, r10.originalTableName) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.newTableName, r10.newTableName) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final String getNewTableName() {
            return this.newTableName;
        }

        public final String getOriginalTableName() {
            return this.originalTableName;
        }

        public int hashCode() {
            int r5 = this.originalTableName.hashCode() * 31;
            return this.newTableName.hashCode() + r5;
        }

        public String toString() {
            return j0.l("RenamedTable(originalTableName=", this.originalTableName, ", newTableName=", this.newTableName, ")");
        }
    }

    public AutoMigration(int r5, int r10, XTypeElement r11, SchemaDiffResult r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r12, "schemaDiff");
        this.from = r5;
        this.f691to = r10;
        this.specElement = r11;
        this.schemaDiff = r12;
        this.isSpecProvided = r13;
        if (r11 == null) goto L5;
        e r14 = r11.getClassName();
    L6:
        this.specClassName = r14;
        return;
    L5:
        r14 = null;
        goto L6
    }

    public static /* synthetic */ AutoMigration copy$default(AutoMigration r5, int r10, int r11, XTypeElement r12, SchemaDiffResult r13, boolean r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r10 = r5.from;
    L6:
        if ((r15 & 2) == 0) goto L8;
        r11 = r5.f691to;
    L8:
        int r17 = r11;
        if ((r15 & 4) == 0) goto L11;
        r12 = r5.specElement;
    L11:
        XTypeElement r18 = r12;
        if ((r15 & 8) == 0) goto L14;
        r13 = r5.schemaDiff;
    L14:
        SchemaDiffResult r19 = r13;
        if ((r15 & 16) == 0) goto L17;
        r14 = r5.isSpecProvided;
    L17:
        int r20 = r10;
        return r5.copy(r20, r17, r18, r19, r14);
    }

    public final int component1() {
        return this.from;
    }

    public final int component2() {
        return this.f691to;
    }

    public final XTypeElement component3() {
        return this.specElement;
    }

    public final SchemaDiffResult component4() {
        return this.schemaDiff;
    }

    public final boolean component5() {
        return this.isSpecProvided;
    }

    public final AutoMigration copy(int r10, int r11, XTypeElement r12, SchemaDiffResult r13, boolean r14) {
        Intrinsics.checkNotNullParameter(r13, "schemaDiff");
        return new AutoMigration(r10, r11, r12, r13, r14);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof AutoMigration) == true) goto L8;
        return false;
    L8:
        AutoMigration r10 = (AutoMigration) r5;
        if (this.from == r10.from) goto L12;
        return false;
    L12:
        if (this.f691to == r10.f691to) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.specElement, r10.specElement) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.schemaDiff, r10.schemaDiff) == true) goto L21;
        return false;
    L21:
        if (this.isSpecProvided == r10.isSpecProvided) goto L23;
        return false;
    L23:
        return true;
    }

    public final int getFrom() {
        return this.from;
    }

    public final XClassName getImplTypeName(XClassName r11) {
        Intrinsics.checkNotNullParameter(r11, "databaseClassName");
        return XClassName.Companion.get(r11.getPackageName(), new String[]{CollectionsKt.q(r11.getSimpleNames(), "_", null, null, 0, null, null, 62) + "_AutoMigration_" + this.from + "_" + this.f691to + "_Impl"});
    }

    public final SchemaDiffResult getSchemaDiff() {
        return this.schemaDiff;
    }

    public final e getSpecClassName() {
        return this.specClassName;
    }

    public final XTypeElement getSpecElement() {
        return this.specElement;
    }

    public final int getTo() {
        return this.f691to;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2, types: [int] */
    /* JADX WARN: Type inference failed for: r3v3 */
    /* JADX WARN: Type inference failed for: r3v4 */
    public int hashCode() {
        int r5 = Integer.hashCode(this.from) * 31;
        int r10 = androidx.room.jarjarred.org.antlr.runtime.a.c(this.f691to, r5, 31);
        XTypeElement r11 = this.specElement;
        if (r11 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = (r10 + r12) * 31;
        int r14 = (this.schemaDiff.hashCode() + r13) * 31;
        boolean r15 = this.isSpecProvided;
        ?? r16 = r15;
        if (r15 == false) goto L10;
        r16 = 1;
    L10:
        return r14 + r16;
    L5:
        r12 = r11.hashCode();
        goto L6
    }

    public final boolean isSpecProvided() {
        return this.isSpecProvided;
    }

    public String toString() {
        int r5 = this.from;
        int r10 = this.f691to;
        XTypeElement r11 = this.specElement;
        SchemaDiffResult r12 = this.schemaDiff;
        boolean r13 = this.isSpecProvided;
        StringBuilder r14 = j0.v("AutoMigration(from=", r5, r10, ", to=", ", specElement=");
        r14.append(r11);
        r14.append(", schemaDiff=");
        r14.append(r12);
        r14.append(", isSpecProvided=");
        return j0.r(r14, r13, ")");
    }
}
