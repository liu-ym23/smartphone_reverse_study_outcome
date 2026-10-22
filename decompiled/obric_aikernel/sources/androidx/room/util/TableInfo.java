package androidx.room.util;

import android.annotation.SuppressLint;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
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

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String r10) {
                if (r10.length() != 0) goto L5;
                boolean r11 = true;
            L6:
                if (r11 == false) goto L8;
                return false;
            L8:
                int r12 = 0;
                int r13 = 0;
                int r14 = 0;
            L10:
                if (r12 >= r10.length()) goto L25;
                char r15 = r10.charAt(r12);
                int r16 = r14 + 1;
                if (r14 != 0) goto L15;
                if (r15 == '(') goto L15;
                return false;
            L15:
                if (r15 != '(') goto L18;
                r13 = r13 + 1;
            L24:
                r12 = r12 + 1;
                r14 = r16;
                goto L10
            L18:
                if (r15 != ')') goto L24;
                r13 = r13 - 1;
                if (r13 != 0) goto L24;
                if (r14 == (r10.length() - 1)) goto L24;
                return false;
            L25:
                if (r13 != 0) goto L28;
                return true;
            L28:
                return false;
            L5:
                r11 = false;
                goto L6
            }

            @JvmStatic
            @SuppressLint({"SyntheticAccessor"})
            @VisibleForTesting
            public final boolean defaultValueEquals(String r10, String r11) {
                Intrinsics.checkNotNullParameter(r10, "current");
                if (Intrinsics.areEqual(r10, r11) == false) goto L6;
                return true;
            L6:
                if (containsSurroundingParenthesis(r10) == false) goto L9;
                String r12 = r10.substring(1, r10.length() - 1);
                Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String…ing(startIndex, endIndex)");
                return Intrinsics.areEqual(StringsKt.trim(r12).toString(), r11);
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Deprecated(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String r10, String r11, boolean r12, int r13) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
            this(r10, r11, r12, r13, null, 0);
        }

        public Column(String r10, String r11, boolean r12, int r13, String r14, int r15) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r11, WsConstants.KEY_CONNECTION_TYPE);
            this.name = r10;
            this.type = r11;
            this.notNull = r12;
            this.primaryKeyPosition = r13;
            this.defaultValue = r14;
            this.createdFrom = r15;
            this.affinity = findAffinity(r11);
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        @VisibleForTesting
        public static final boolean defaultValueEquals(String r10, String r11) {
            return Companion.defaultValueEquals(r10, r11);
        }

        @ColumnInfo.SQLiteTypeAffinity
        private final int findAffinity(String r10) {
            if (r10 != null) goto L5;
            return 5;
        L5:
            Locale r11 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r11, "US");
            String r12 = r10.toUpperCase(r11);
            Intrinsics.checkNotNullExpressionValue(r12, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt.contains$default(r12, "INT", false, 2, null) == false) goto L10;
            return 3;
        L10:
            if (StringsKt.contains$default(r12, "CHAR", false, 2, null) == false) goto L12;
        L30:
            return 2;
        L12:
            if (StringsKt.contains$default(r12, "CLOB", false, 2, null) == true) goto L30;
            if (StringsKt.contains$default(r12, "TEXT", false, 2, null) == true) goto L30;
            if (StringsKt.contains$default(r12, "BLOB", false, 2, null) == false) goto L20;
            return 5;
        L20:
            if (StringsKt.contains$default(r12, "REAL", false, 2, null) == false) goto L22;
            return 4;
        L22:
            if (StringsKt.contains$default(r12, "FLOA", false, 2, null) == false) goto L24;
            return 4;
        L24:
            if (StringsKt.contains$default(r12, "DOUB", false, 2, null) == true) goto L32;
            return 1;
        L32:
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
            if (Build.VERSION.SDK_INT < 20) goto L14;
            if (this.primaryKeyPosition == ((Column) r10).primaryKeyPosition) goto L16;
            return false;
        L16:
            Column r11 = (Column) r10;
            if (Intrinsics.areEqual(this.name, r11.name) == true) goto L20;
            return false;
        L20:
            if (this.notNull == r11.notNull) goto L23;
            return false;
        L23:
            if (this.createdFrom != 1) goto L32;
            if (r11.createdFrom != 2) goto L32;
            String r12 = this.defaultValue;
            if (r12 == null) goto L32;
            if (Companion.defaultValueEquals(r12, r11.defaultValue) == true) goto L32;
            return false;
        L32:
            if (this.createdFrom == 2) goto L34;
        L40:
            int r13 = this.createdFrom;
            if (r13 == 0) goto L56;
            if (r13 != r11.createdFrom) goto L56;
            String r14 = this.defaultValue;
            if (r14 == null) goto L50;
            if (Companion.defaultValueEquals(r14, r11.defaultValue) == false) goto L51;
        L52:
            boolean r15 = false;
        L53:
            if (r15 == false) goto L56;
            return false;
        L51:
            r15 = true;
            goto L53
        L50:
            if (r11.defaultValue == null) goto L52;
        L56:
            if (this.affinity != r11.affinity) goto L59;
            return true;
        L59:
            return false;
        L34:
            if (r11.createdFrom != 1) goto L40;
            String r16 = r11.defaultValue;
            if (r16 == null) goto L40;
            if (Companion.defaultValueEquals(r16, this.defaultValue) == true) goto L40;
            return false;
        L14:
            if (isPrimaryKey() == ((Column) r10).isPrimaryKey()) goto L16;
            return false;
        }

        public int hashCode() {
            int r10 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r11 = 1231;
        L7:
            return ((r10 + r11) * 31) + this.primaryKeyPosition;
        L5:
            r11 = 1237;
            goto L7
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r10 = new StringBuilder();
            r10.append("Column{name='");
            r10.append(this.name);
            r10.append("', type='");
            r10.append(this.type);
            r10.append("', affinity='");
            r10.append(this.affinity);
            r10.append("', notNull=");
            r10.append(this.notNull);
            r10.append(", primaryKeyPosition=");
            r10.append(this.primaryKeyPosition);
            r10.append(", defaultValue='");
            String r11 = this.defaultValue;
            if (r11 != null) goto L5;
            r11 = "undefined";
        L5:
            r10.append(r11);
            r10.append("'}");
            return r10.toString();
        }
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "database");
            Intrinsics.checkNotNullParameter(r11, "tableName");
            return TableInfoKt.readTableInfo(r10, r11);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

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

        public ForeignKey(String r10, String r11, String r12, List<String> r13, List<String> r14) {
            Intrinsics.checkNotNullParameter(r10, "referenceTable");
            Intrinsics.checkNotNullParameter(r11, "onDelete");
            Intrinsics.checkNotNullParameter(r12, "onUpdate");
            Intrinsics.checkNotNullParameter(r13, "columnNames");
            Intrinsics.checkNotNullParameter(r14, "referenceColumnNames");
            this.referenceTable = r10;
            this.onDelete = r11;
            this.onUpdate = r12;
            this.columnNames = r13;
            this.referenceColumnNames = r14;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof ForeignKey) == true) goto L8;
            return false;
        L8:
            ForeignKey r11 = (ForeignKey) r10;
            if (Intrinsics.areEqual(this.referenceTable, r11.referenceTable) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.onDelete, r11.onDelete) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.onUpdate, r11.onUpdate) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.columnNames, r11.columnNames) == true) goto L21;
            return false;
        L21:
            return Intrinsics.areEqual(this.referenceColumnNames, r11.referenceColumnNames);
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int r10, int r11, String r12, String r13) {
            Intrinsics.checkNotNullParameter(r12, "from");
            Intrinsics.checkNotNullParameter(r13, TypedValues.TransitionType.S_TO);
            this.id = r10;
            this.sequence = r11;
            this.from = r12;
            this.to = r13;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence r10) {
            Intrinsics.checkNotNullParameter(r10, "other");
            int r11 = this.id - r10.id;
            if (r11 == 0) goto L5;
            return r11;
        L5:
            return this.sequence - r10.sequence;
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ForeignKeyWithSequence r10) {
            return compareTo2(r10);
        }

        public final String getFrom() {
            return this.from;
        }

        public final int getId() {
            return this.id;
        }

        public final int getSequence() {
            return this.sequence;
        }

        public final String getTo() {
            return this.to;
        }
    }

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

        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r10) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Deprecated(message = "Use {@link #Index(String, boolean, List, List)}")
        public Index(String r10, boolean r11, List<String> r12) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "columns");
            int r13 = r12.size();
            ArrayList r14 = new ArrayList(r13);
            int r15 = 0;
        L3:
            if (r15 >= r13) goto L5;
            r14.add(androidx.room.Index.Order.ASC.name());
            r15 = r15 + 1;
            goto L3
        L5:
            this(r10, r11, r12, r14);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.Collection, java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v1, types: [java.util.List<java.lang.String>] */
        /* JADX WARN: Type inference failed for: r5v2, types: [java.util.ArrayList] */
        public Index(String r10, boolean r11, List<String> r12, List<String> r13) {
            Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r12, "columns");
            Intrinsics.checkNotNullParameter(r13, "orders");
            this.name = r10;
            this.unique = r11;
            this.columns = r12;
            this.orders = r13;
            if (r13.isEmpty() == false) goto L7;
            int r14 = r12.size();
            r13 = new ArrayList(r14);
            int r15 = 0;
        L5:
            if (r15 >= r14) goto L7;
            r13.add(androidx.room.Index.Order.ASC.name());
            r15 = r15 + 1;
        L7:
            this.orders = r13;
        }

        public boolean equals(Object r10) {
            if (this != r10) goto L6;
            return true;
        L6:
            if ((r10 instanceof Index) == true) goto L8;
            return false;
        L8:
            Index r11 = (Index) r10;
            if (this.unique == r11.unique) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.columns, r11.columns) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.orders, r11.orders) == true) goto L18;
            return false;
        L18:
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L21;
            return StringsKt.startsWith$default(r11.name, DEFAULT_PREFIX, false, 2, null);
        L21:
            return Intrinsics.areEqual(this.name, r11.name);
        }

        public int hashCode() {
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L5;
            int r10 = -1184239155;
        L7:
            return (((((r10 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        L5:
            r10 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TableInfo(String r10, Map<String, Column> r11, Set<ForeignKey> r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "columns");
        Intrinsics.checkNotNullParameter(r12, "foreignKeys");
        this(r10, r11, r12, SetsKt.emptySet());
    }

    public TableInfo(String r10, Map<String, Column> r11, Set<ForeignKey> r12, Set<Index> r13) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "columns");
        Intrinsics.checkNotNullParameter(r12, "foreignKeys");
        this.name = r10;
        this.columns = r11;
        this.foreignKeys = r12;
        this.indices = r13;
    }

    public /* synthetic */ TableInfo(String r10, Map r11, Set r12, Set r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 8) == 0) goto L5;
        r13 = null;
    L5:
        this(r10, r11, r12, r13);
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase r10, String r11) {
        return Companion.read(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof TableInfo) == true) goto L8;
        return false;
    L8:
        TableInfo r11 = (TableInfo) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r11.columns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.foreignKeys, r11.foreignKeys) == true) goto L17;
        return false;
    L17:
        Set<Index> r12 = this.indices;
        if (r12 == null) goto L24;
        Set<Index> r13 = r11.indices;
        if (r13 != null) goto L23;
        return true;
    L23:
        return Intrinsics.areEqual(r12, r13);
    L24:
        return true;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
