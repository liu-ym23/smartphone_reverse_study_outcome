package androidx.room.util;

import ai.j0;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.motion.widget.a;
import androidx.room.ColumnInfo;
import androidx.room.writer.TableInfoValidationWriter;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/util/TableInfo;", "", "name", "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Column", "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", "Index", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = null;

    @JvmField
    public final Map<String, Column> columns;

    @JvmField
    public final Set<ForeignKey> foreignKeys;

    @JvmField
    public final Set<Index> indices;

    @JvmField
    public final String name;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/util/TableInfo$Column;", "", "name", "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Column {
        public static final Companion Companion = null;

        @JvmField
        public final int affinity;

        @JvmField
        public final int createdFrom;

        @JvmField
        public final String defaultValue;

        @JvmField
        public final String name;

        @JvmField
        public final boolean notNull;

        @JvmField
        public final int primaryKeyPosition;

        @JvmField
        public final String type;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/TableInfo$Column$Companion;", "", "()V", "containsSurroundingParenthesis", "", "current", "", "defaultValueEquals", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String r10) {
                if (r10.length() != 0) goto L5;
                return false;
            L5:
                int r11 = 0;
                int r5 = 0;
                int r12 = 0;
            L7:
                if (r11 >= r10.length()) goto L22;
                char r13 = r10.charAt(r11);
                int r14 = r12 + 1;
                if (r12 != 0) goto L12;
                if (r13 == '(') goto L12;
                return false;
            L12:
                if (r13 != '(') goto L15;
                r5 = r5 + 1;
            L21:
                r11 = r11 + 1;
                r12 = r14;
                goto L7
            L15:
                if (r13 != ')') goto L21;
                r5 = r5 - 1;
                if (r5 != 0) goto L21;
                if (r12 == (r10.length() - 1)) goto L21;
                return false;
            L22:
                if (r5 == 0) goto L24;
                return false;
            L24:
                return true;
            }

            @JvmStatic
            @SuppressLint({"SyntheticAccessor"})
            @VisibleForTesting
            public final boolean defaultValueEquals(String r5, String r10) {
                Intrinsics.checkNotNullParameter(r5, "current");
                if (Intrinsics.areEqual(r5, r10) == false) goto L6;
                return true;
            L6:
                if (containsSurroundingParenthesis(r5) == true) goto L8;
                return false;
            L8:
                return Intrinsics.areEqual(StringsKt.trim(r5.substring(1, r5.length() - 1)).toString(), r10);
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        public Column(String r5, String r10, boolean r11, int r12, String r13, int r14) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r10, "type");
            this.name = r5;
            this.type = r10;
            this.notNull = r11;
            this.primaryKeyPosition = r12;
            this.defaultValue = r13;
            this.createdFrom = r14;
            this.affinity = findAffinity(r10);
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        @VisibleForTesting
        public static final boolean defaultValueEquals(String r5, String r10) {
            return Companion.defaultValueEquals(r5, r10);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String r5) {
            if (r5 != null) goto L5;
            return 5;
        L5:
            String r10 = r5.toUpperCase(Locale.US);
            if (StringsKt.g(r10, "INT") == false) goto L10;
            return 3;
        L10:
            if (StringsKt.g(r10, "CHAR") == false) goto L12;
            return 2;
        L12:
            if (StringsKt.g(r10, "CLOB") == false) goto L14;
            return 2;
        L14:
            if (StringsKt.g(r10, "TEXT") == false) goto L17;
            return 2;
        L17:
            if (StringsKt.g(r10, "BLOB") == false) goto L20;
            return 5;
        L20:
            if (StringsKt.g(r10, "REAL") == false) goto L22;
            return 4;
        L22:
            if (StringsKt.g(r10, "FLOA") == false) goto L24;
            return 4;
        L24:
            if (StringsKt.g(r10, "DOUB") == true) goto L33;
            return 1;
        L33:
            return 4;
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Column) == true) goto L9;
            return false;
        L9:
            if (this.primaryKeyPosition == ((Column) r10).primaryKeyPosition) goto L11;
            return false;
        L11:
            Column r11 = (Column) r10;
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L15;
            return false;
        L15:
            if (this.notNull == r11.notNull) goto L18;
            return false;
        L18:
            if (this.createdFrom != 1) goto L27;
            if (r11.createdFrom != 2) goto L27;
            String r5 = this.defaultValue;
            if (r5 == null) goto L27;
            if (Companion.defaultValueEquals(r5, r11.defaultValue) == true) goto L27;
            return false;
        L27:
            if (this.createdFrom == 2) goto L29;
        L35:
            int r12 = this.createdFrom;
            if (r12 == 0) goto L48;
            if (r12 != r11.createdFrom) goto L48;
            String r13 = this.defaultValue;
            if (r13 == null) goto L45;
            if (Companion.defaultValueEquals(r13, r11.defaultValue) == true) goto L48;
        L46:
            return false;
        L45:
            if (r11.defaultValue != null) goto L46;
        L48:
            if (this.affinity != r11.affinity) goto L51;
            return true;
        L51:
            return false;
        L29:
            if (r11.createdFrom != 1) goto L35;
            String r14 = r11.defaultValue;
            if (r14 == null) goto L35;
            if (Companion.defaultValueEquals(r14, this.defaultValue) == true) goto L35;
            return false;
        }

        public int hashCode() {
            int r5 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r10 = 1231;
        L7:
            return ((r5 + r10) * 31) + this.primaryKeyPosition;
        L5:
            r10 = 1237;
            goto L7
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("Column{name='");
            r5.append(this.name);
            r5.append("', type='");
            r5.append(this.type);
            r5.append("', affinity='");
            r5.append(this.affinity);
            r5.append("', notNull=");
            r5.append(this.notNull);
            r5.append(", primaryKeyPosition=");
            r5.append(this.primaryKeyPosition);
            r5.append(", defaultValue='");
            String r10 = this.defaultValue;
            if (r10 != null) goto L6;
            r10 = "undefined";
        L6:
            return j0.q(r5, r10, "'}");
        }

        @Deprecated(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String r10, String r11, boolean r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, "name");
            Intrinsics.checkNotNullParameter(r11, "type");
            this(r10, r11, r12, r13, null, 0);
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/TableInfo$Companion;", "", "()V", "CREATED_FROM_DATABASE", "", TableInfoValidationWriter.CREATED_FROM_ENTITY, "CREATED_FROM_UNKNOWN", "read", "Landroidx/room/util/TableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "database");
            Intrinsics.checkNotNullParameter(r10, "tableName");
            return TableInfoKt.readTableInfo(r5, r10);
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {

        @JvmField
        public final List<String> columnNames;

        @JvmField
        public final String onDelete;

        @JvmField
        public final String onUpdate;

        @JvmField
        public final List<String> referenceColumnNames;

        @JvmField
        public final String referenceTable;

        public ForeignKey(String r5, String r10, String r11, List<String> r12, List<String> r13) {
            Intrinsics.checkNotNullParameter(r5, "referenceTable");
            Intrinsics.checkNotNullParameter(r10, "onDelete");
            Intrinsics.checkNotNullParameter(r11, "onUpdate");
            Intrinsics.checkNotNullParameter(r12, "columnNames");
            Intrinsics.checkNotNullParameter(r13, "referenceColumnNames");
            this.referenceTable = r5;
            this.onDelete = r10;
            this.onUpdate = r11;
            this.columnNames = r12;
            this.referenceColumnNames = r13;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r10 = (ForeignKey) r5;
            if (Intrinsics.areEqual(this.referenceTable, r10.referenceTable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.onDelete, r10.onDelete) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.onUpdate, r10.onUpdate) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.columnNames, r10.columnNames) == true) goto L21;
            return false;
        L21:
            return Intrinsics.areEqual(this.referenceColumnNames, r10.referenceColumnNames);
        }

        public int hashCode() {
            int r5 = a.c(a.c(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate);
            int r10 = a.f(this.columnNames, r5, 31);
            return this.referenceColumnNames.hashCode() + r10;
        }

        public String toString() {
            StringBuilder r5 = new StringBuilder("ForeignKey{referenceTable='");
            r5.append(this.referenceTable);
            r5.append("', onDelete='");
            r5.append(this.onDelete);
            r5.append(" +', onUpdate='");
            r5.append(this.onUpdate);
            r5.append("', columnNames=");
            r5.append(this.columnNames);
            r5.append(", referenceColumnNames=");
            return a.v(r5, this.referenceColumnNames, '}');
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", "id", "", "sequence", "from", "", "to", "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f689id;
        private final int sequence;

        /* JADX INFO: renamed from: to, reason: collision with root package name */
        private final String f690to;

        public ForeignKeyWithSequence(int r5, int r10, String r11, String r12) {
            Intrinsics.checkNotNullParameter(r11, "from");
            Intrinsics.checkNotNullParameter(r12, "to");
            this.f689id = r5;
            this.sequence = r10;
            this.from = r11;
            this.f690to = r12;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence r5) {
            return compareTo2(r5);
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.f689id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.f690to;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence r5) {
            Intrinsics.checkNotNullParameter(r5, "other");
            int r10 = this.f689id - r5.f689id;
            if (r10 == 0) goto L5;
            return r10;
        L5:
            return this.sequence - r5.sequence;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$Index;", "", "name", "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final Companion Companion = null;
        public static final String DEFAULT_PREFIX = "index_";

        @JvmField
        public final List<String> columns;

        @JvmField
        public final String name;

        @JvmField
        public List<String> orders;

        @JvmField
        public final boolean unique;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/util/TableInfo$Index$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker r5) {
                this();
            }

            private Companion() {
            }
        }

        static {
            Companion = new Companion(null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public Index(String r5, boolean r10, List<String> r11, List<String> r12) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r11, "columns");
            Intrinsics.checkNotNullParameter(r12, "orders");
            this.name = r5;
            this.unique = r10;
            this.columns = r11;
            this.orders = r12;
            if (r12.isEmpty() == false) goto L7;
            int r13 = r11.size();
            r12 = new ArrayList(r13);
            int r14 = 0;
        L5:
            if (r14 >= r13) goto L7;
            r12.add(androidx.room.Index.Order.ASC.name());
            r14 = r14 + 1;
        L7:
            this.orders = r12;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r10 = (Index) r5;
            if (this.unique == r10.unique) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.columns, r10.columns) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.orders, r10.orders) == true) goto L18;
            return false;
        L18:
            if (StringsKt.P(this.name, "index_") == false) goto L21;
            return StringsKt.P(r10.name, "index_");
        L21:
            return Intrinsics.areEqual(this.name, r10.name);
        }

        public int hashCode() {
            if (StringsKt.P(this.name, "index_") == false) goto L5;
            int r5 = -1184239155;
        L6:
            int r10 = ((r5 * 31) + (this.unique ? 1 : 0)) * 31;
            int r11 = a.f(this.columns, r10, 31);
            return this.orders.hashCode() + r11;
        L5:
            r5 = this.name.hashCode();
            goto L6
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }

        @Deprecated(message = "Use {@link #Index(String, boolean, List, List)}")
        public Index(String r5, boolean r10, List<String> r11) {
            Intrinsics.checkNotNullParameter(r5, "name");
            Intrinsics.checkNotNullParameter(r11, "columns");
            int r12 = r11.size();
            ArrayList r13 = new ArrayList(r12);
            int r14 = 0;
        L3:
            if (r14 >= r12) goto L5;
            r13.add(androidx.room.Index.Order.ASC.name());
            r14 = r14 + 1;
            goto L3
        L5:
            this(r5, r10, r11, r13);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TableInfo(String r5, Map<String, Column> r10, Set<ForeignKey> r11, Set<Index> r12) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "columns");
        Intrinsics.checkNotNullParameter(r11, "foreignKeys");
        this.name = r5;
        this.columns = r10;
        this.foreignKeys = r11;
        this.indices = r12;
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase r5, String r10) {
        return Companion.read(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r10 = (TableInfo) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r10.columns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.foreignKeys, r10.foreignKeys) == true) goto L17;
        return false;
    L17:
        Set<Index> r11 = this.indices;
        if (r11 == null) goto L24;
        Set<Index> r12 = r10.indices;
        if (r12 != null) goto L23;
        return true;
    L23:
        return Intrinsics.areEqual(r11, r12);
    L24:
        return true;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = (this.columns.hashCode() + r5) * 31;
        return this.foreignKeys.hashCode() + r10;
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }

    public /* synthetic */ TableInfo(String r5, Map r10, Set r11, Set r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 8) == 0) goto L5;
        r12 = null;
    L5:
        this(r5, r10, r11, r12);
    }

    public TableInfo(String r5, Map<String, Column> r10, Set<ForeignKey> r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "columns");
        Intrinsics.checkNotNullParameter(r11, "foreignKeys");
        this(r5, r10, r11, SetsKt.emptySet());
    }
}
