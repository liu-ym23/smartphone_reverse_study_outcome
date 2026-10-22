package androidx.room.util;

import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.tom_roush.pdfbox.pdmodel.a.d.h;
import com.tom_roush.pdfbox.pdmodel.a.d.i;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.SetsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0006\u0014\u0015\u0016\u0017\u0018\u0019B1\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\u0002\u0010\rJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Landroidx/room/util/TableInfo;", "", ActivityLifecycle.NAME, "", "columns", "", "Landroidx/room/util/TableInfo$Column;", "foreignKeys", "", "Landroidx/room/util/TableInfo$ForeignKey;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;)V", "indices", "Landroidx/room/util/TableInfo$Index;", "(Ljava/lang/String;Ljava/util/Map;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", h.h, "Companion", "CreatedFrom", "ForeignKey", "ForeignKeyWithSequence", i.j, "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = null;
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B'\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\u0012\u0010\u0014\u001a\u00020\b2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0003J\b\u0010\u0015\u001a\u00020\bH\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016R\u0016\u0010\r\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u000e\u0010\u000fR\u0010\u0010\u000b\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/room/util/TableInfo$Column;", "", ActivityLifecycle.NAME, "", "type", "notNull", "", "primaryKeyPosition", "", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "defaultValue", "createdFrom", "(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;I)V", "affinity", "getAffinity$annotations", "()V", "isPrimaryKey", "()Z", "equals", "other", "findAffinity", "hashCode", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Column {
        public static final Companion Companion = null;
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/TableInfo$Column$Companion;", "", "()V", "containsSurroundingParenthesis", "", "current", "", "defaultValueEquals", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }

            private final boolean containsSurroundingParenthesis(String r9) {
                if (((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
                boolean r8 = true;
            L6:
                if (r8 == false) goto L8;
                return false;
            L8:
                CharSequence r10 = (CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin");
                int r0 = 0;
                int r3 = 0;
                int r4 = 0;
            L10:
                if (r0 >= r10.length()) goto L25;
                char r5 = r10.charAt(r0);
                int r6 = r4 + 1;
                if (r4 != 0) goto L15;
                if (r5 == '(') goto L15;
                return false;
            L15:
                if (r5 != '(') goto L18;
                r3 = r3 + 1;
            L24:
                r0 = r0 + 1;
                r4 = r6;
                goto L10
            L18:
                if (r5 != ')') goto L24;
                r3 = r3 - 1;
                if (r3 != 0) goto L24;
                if (r4 == (r9.length() - 1)) goto L24;
                return false;
            L25:
                if (r3 != 0) goto L28;
                return true;
            L28:
                return false;
            L5:
                r8 = false;
                goto L6
            }

            @JvmStatic
            public final boolean defaultValueEquals(String r3, String r4) {
                Intrinsics.checkNotNullParameter(r3, "current");
                if (Intrinsics.areEqual(r3, r4) == false) goto L6;
                return true;
            L6:
                if (containsSurroundingParenthesis(r3) == false) goto L9;
                String r2 = r3.substring(1, r3.length() - 1);
                Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String…ing(startIndex, endIndex)");
                return Intrinsics.areEqual(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString(), r4);
            L9:
                return false;
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Deprecated(message = "Use {@link Column#Column(String, String, boolean, int, String, int)} instead.")
        public Column(String r9, String r10, boolean r11, int r12) {
            Intrinsics.checkNotNullParameter(r9, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r10, "type");
            this(r9, r10, r11, r12, null, 0);
        }

        public Column(String r2, String r3, boolean r4, int r5, String r6, int r7) {
            Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r3, "type");
            this.name = r2;
            this.type = r3;
            this.notNull = r4;
            this.primaryKeyPosition = r5;
            this.defaultValue = r6;
            this.createdFrom = r7;
            this.affinity = findAffinity(r3);
        }

        @JvmStatic
        public static final boolean defaultValueEquals(String r1, String r2) {
            return Companion.defaultValueEquals(r1, r2);
        }

        private final int findAffinity(String r8) {
            if (r8 != null) goto L5;
            return 5;
        L5:
            Locale r0 = Locale.US;
            Intrinsics.checkNotNullExpressionValue(r0, "US");
            String r9 = r8.toUpperCase(r0);
            Intrinsics.checkNotNullExpressionValue(r9, "this as java.lang.String).toUpperCase(locale)");
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("INT", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L10;
            return 3;
        L10:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("CHAR", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L12;
        L30:
            return 2;
        L12:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("CLOB", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L30;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("TEXT", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L30;
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("BLOB", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L20;
            return 5;
        L20:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("REAL", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L22;
            return 4;
        L22:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("FLOA", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == false) goto L24;
            return 4;
        L24:
            if (StringsKt.contains$default((CharSequence) ZeusTransformUtils.preCheckCast(r9, CharSequence.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast("DOUB", CharSequence.class, "com.obric.memorydata.plugin"), false, 2, null) == true) goto L32;
            return 1;
        L32:
            return 4;
        }

        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, Column.class) == true) goto L9;
            return false;
        L9:
            if (Build.VERSION.SDK_INT < 20) goto L14;
            if (this.primaryKeyPosition == ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).primaryKeyPosition) goto L17;
            return false;
        L17:
            if (Intrinsics.areEqual(this.name, ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).name) == true) goto L20;
            return false;
        L20:
            if (this.notNull == ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).notNull) goto L23;
            return false;
        L23:
            if (this.createdFrom != 1) goto L32;
            if (((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).createdFrom != 2) goto L32;
            String r2 = this.defaultValue;
            if (r2 == null) goto L32;
            if (Companion.defaultValueEquals(r2, ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).defaultValue) == true) goto L32;
            return false;
        L32:
            if (this.createdFrom == 2) goto L34;
        L40:
            int r3 = this.createdFrom;
            if (r3 == 0) goto L56;
            if (r3 != ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).createdFrom) goto L56;
            String r4 = this.defaultValue;
            if (r4 == null) goto L50;
            if (Companion.defaultValueEquals(r4, ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).defaultValue) == false) goto L51;
        L52:
            boolean r5 = false;
        L53:
            if (r5 == false) goto L56;
            return false;
        L51:
            r5 = true;
            goto L53
        L50:
            if (((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).defaultValue == null) goto L52;
        L56:
            if (this.affinity != ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).affinity) goto L59;
            return true;
        L59:
            return false;
        L34:
            if (((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).createdFrom != 1) goto L40;
            if (((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).defaultValue == null) goto L40;
            if (Companion.defaultValueEquals(((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).defaultValue, this.defaultValue) == true) goto L40;
            return false;
        L14:
            if (isPrimaryKey() == ((Column) ZeusTransformUtils.preCheckCast(r9, Column.class, "com.obric.memorydata.plugin")).isPrimaryKey()) goto L17;
            return false;
        }

        public int hashCode() {
            int r0 = ((this.name.hashCode() * 31) + this.affinity) * 31;
            if (this.notNull == false) goto L5;
            int r1 = 1231;
        L7:
            return ((r0 + r1) * 31) + this.primaryKeyPosition;
        L5:
            r1 = 1237;
            goto L7
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder().append("Column{name='").append(this.name).append("', type='").append(this.type).append("', affinity='").append(this.affinity).append("', notNull=").append(this.notNull).append(", primaryKeyPosition=").append(this.primaryKeyPosition).append(", defaultValue='");
            String r2 = this.defaultValue;
            if (r2 != null) goto L6;
            r2 = "undefined";
        L6:
            return r0.append(r2).append("'}").toString();
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/TableInfo$Companion;", "", "()V", "CREATED_FROM_DATABASE", "", "CREATED_FROM_ENTITY", "CREATED_FROM_UNKNOWN", "read", "Landroidx/room/util/TableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final TableInfo read(SupportSQLiteDatabase r2, String r3) {
            SupportSQLiteDatabase r1 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r1, "database");
            Intrinsics.checkNotNullParameter(r3, "tableName");
            return TableInfoKt.readTableInfo(r1, r3);
        }
    }

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/util/TableInfo$CreatedFrom;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface CreatedFrom {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKey;", "", "referenceTable", "", "onDelete", "onUpdate", "columnNames", "", "referenceColumnNames", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;)V", "equals", "", "other", "hashCode", "", "toString", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String r3, String r4, String r5, List<String> r6, List<String> r7) {
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r7, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, "referenceTable");
            Intrinsics.checkNotNullParameter(r4, "onDelete");
            Intrinsics.checkNotNullParameter(r5, "onUpdate");
            Intrinsics.checkNotNullParameter(r8, "columnNames");
            Intrinsics.checkNotNullParameter(r9, "referenceColumnNames");
            this.referenceTable = r3;
            this.onDelete = r4;
            this.onUpdate = r5;
            this.columnNames = r8;
            this.referenceColumnNames = r9;
        }

        public boolean equals(Object r6) {
            if (this != r6) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r6, ForeignKey.class) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.referenceTable, ((ForeignKey) ZeusTransformUtils.preCheckCast(r6, ForeignKey.class, "com.obric.memorydata.plugin")).referenceTable) == true) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.onDelete, ((ForeignKey) ZeusTransformUtils.preCheckCast(r6, ForeignKey.class, "com.obric.memorydata.plugin")).onDelete) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.onUpdate, ((ForeignKey) ZeusTransformUtils.preCheckCast(r6, ForeignKey.class, "com.obric.memorydata.plugin")).onUpdate) == true) goto L19;
            return false;
        L19:
            if (Intrinsics.areEqual(this.columnNames, ((ForeignKey) ZeusTransformUtils.preCheckCast(r6, ForeignKey.class, "com.obric.memorydata.plugin")).columnNames) == true) goto L22;
            return false;
        L22:
            return Intrinsics.areEqual(this.referenceColumnNames, ((ForeignKey) ZeusTransformUtils.preCheckCast(r6, ForeignKey.class, "com.obric.memorydata.plugin")).referenceColumnNames);
        }

        public int hashCode() {
            return (((((((this.referenceTable.hashCode() * 31) + this.onDelete.hashCode()) * 31) + this.onUpdate.hashCode()) * 31) + this.columnNames.hashCode()) * 31) + this.referenceColumnNames.hashCode();
        }

        public String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + " +', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0011\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0000H\u0096\u0002R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$ForeignKeyWithSequence;", "", OaidModel.KEY_ID, "", "sequence", "from", "", TypedValues.TransitionType.S_TO, "(IILjava/lang/String;Ljava/lang/String;)V", "getFrom", "()Ljava/lang/String;", "getId", "()I", "getSequence", "getTo", "compareTo", "other", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ForeignKeyWithSequence implements Comparable<ForeignKeyWithSequence> {
        private final String from;
        private final int id;
        private final int sequence;
        private final String to;

        public ForeignKeyWithSequence(int r2, int r3, String r4, String r5) {
            Intrinsics.checkNotNullParameter(r4, "from");
            Intrinsics.checkNotNullParameter(r5, TypedValues.TransitionType.S_TO);
            this.id = r2;
            this.sequence = r3;
            this.from = r4;
            this.to = r5;
        }

        /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ForeignKeyWithSequence r3) {
            Intrinsics.checkNotNullParameter(r3, "other");
            int r0 = this.id - r3.id;
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.sequence - r3.sequence;
        }

        @Override // java.lang.Comparable
        public /* synthetic */ int compareTo(ForeignKeyWithSequence r3) {
            return compareTo2((ForeignKeyWithSequence) ZeusTransformUtils.preCheckCast(r3, ForeignKeyWithSequence.class, "com.obric.memorydata.plugin"));
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

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\bB1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/TableInfo$Index;", "", ActivityLifecycle.NAME, "", "unique", "", "columns", "", "(Ljava/lang/String;ZLjava/util/List;)V", "orders", "(Ljava/lang/String;ZLjava/util/List;Ljava/util/List;)V", "equals", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Index {
        public static final Companion Companion = null;
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Landroidx/room/util/TableInfo$Index$Companion;", "", "()V", "DEFAULT_PREFIX", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r1) {
                this();
            }
        }

        static {
            Companion = new Companion(null);
        }

        @Deprecated(message = "Use {@link #Index(String, boolean, List, List)}")
        public Index(String r6, boolean r7, List<String> r8) {
            List r9 = (List) ZeusTransformUtils.wrapperContextForParams(r8, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r9, "columns");
            int r0 = r9.size();
            ArrayList r2 = new ArrayList(r0);
            int r3 = 0;
        L3:
            if (r3 >= r0) goto L5;
            r2.add(androidx.room.Index.Order.ASC.name());
            r3 = r3 + 1;
            goto L3
        L5:
            this(r6, r7, r9, (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"));
        }

        public Index(String r3, boolean r4, List<String> r5, List<String> r6) {
            List<String> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
            List<String> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r6, List.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
            Intrinsics.checkNotNullParameter(r7, "columns");
            Intrinsics.checkNotNullParameter(r8, "orders");
            this.name = r3;
            this.unique = r4;
            this.columns = r7;
            this.orders = r8;
            Collection r9 = (Collection) ZeusTransformUtils.preCheckCast(r8, Collection.class, "com.obric.memorydata.plugin");
            if (r9.isEmpty() == false) goto L8;
            int r10 = r7.size();
            ArrayList r11 = new ArrayList(r10);
            int r12 = 0;
        L5:
            if (r12 >= r10) goto L7;
            r11.add(androidx.room.Index.Order.ASC.name());
            r12 = r12 + 1;
            goto L5
        L7:
            r9 = (List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin");
        L8:
            this.orders = (List) ZeusTransformUtils.preCheckCast(r9, List.class, "com.obric.memorydata.plugin");
        }

        public boolean equals(Object r8) {
            if (this != r8) goto L7;
            return true;
        L7:
            if (ZeusTransformUtils.instanceOf(r8, Index.class) == true) goto L10;
            return false;
        L10:
            if (this.unique == ((Index) ZeusTransformUtils.preCheckCast(r8, Index.class, "com.obric.memorydata.plugin")).unique) goto L13;
            return false;
        L13:
            if (Intrinsics.areEqual(this.columns, ((Index) ZeusTransformUtils.preCheckCast(r8, Index.class, "com.obric.memorydata.plugin")).columns) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.orders, ((Index) ZeusTransformUtils.preCheckCast(r8, Index.class, "com.obric.memorydata.plugin")).orders) == true) goto L19;
            return false;
        L19:
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L22;
            return StringsKt.startsWith$default(((Index) ZeusTransformUtils.preCheckCast(r8, Index.class, "com.obric.memorydata.plugin")).name, DEFAULT_PREFIX, false, 2, null);
        L22:
            return Intrinsics.areEqual(this.name, ((Index) ZeusTransformUtils.preCheckCast(r8, Index.class, "com.obric.memorydata.plugin")).name);
        }

        public int hashCode() {
            if (StringsKt.startsWith$default(this.name, DEFAULT_PREFIX, false, 2, null) == false) goto L5;
            int r0 = -1184239155;
        L7:
            return (((((r0 * 31) + (this.unique ? 1 : 0)) * 31) + this.columns.hashCode()) * 31) + this.orders.hashCode();
        L5:
            r0 = this.name.hashCode();
            goto L7
        }

        public String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + "'}";
        }
    }

    static {
        Companion = new Companion(null);
    }

    public TableInfo(String r3, Map<String, Column> r4, Set<ForeignKey> r5) {
        Map r6 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Set r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "columns");
        Intrinsics.checkNotNullParameter(r7, "foreignKeys");
        this(r3, r6, r7, SetsKt.emptySet());
    }

    public TableInfo(String r3, Map<String, Column> r4, Set<ForeignKey> r5, Set<Index> r6) {
        Map<String, Column> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r4, Map.class, "com.obric.memorydata.plugin");
        Set<ForeignKey> r8 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Set<Index> r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r6, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r7, "columns");
        Intrinsics.checkNotNullParameter(r8, "foreignKeys");
        this.name = r3;
        this.columns = r7;
        this.foreignKeys = r8;
        this.indices = r9;
    }

    public /* synthetic */ TableInfo(String r2, Map r3, Set r4, Set r5, int r6, DefaultConstructorMarker r7) {
        Map r8 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.memorydata.plugin");
        Set r9 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        if ((r6 & 8) == 0) goto L5;
        r10 = null;
    L5:
        this(r2, r8, r9, r10);
    }

    @JvmStatic
    public static final TableInfo read(SupportSQLiteDatabase r2, String r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        return Companion.read(r4, r3);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, TableInfo.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.name, ((TableInfo) ZeusTransformUtils.preCheckCast(r7, TableInfo.class, "com.obric.memorydata.plugin")).name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, ((TableInfo) ZeusTransformUtils.preCheckCast(r7, TableInfo.class, "com.obric.memorydata.plugin")).columns) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.foreignKeys, ((TableInfo) ZeusTransformUtils.preCheckCast(r7, TableInfo.class, "com.obric.memorydata.plugin")).foreignKeys) == true) goto L18;
        return false;
    L18:
        if (this.indices != null) goto L20;
        return true;
    L20:
        if (((TableInfo) ZeusTransformUtils.preCheckCast(r7, TableInfo.class, "com.obric.memorydata.plugin")).indices != null) goto L23;
        return true;
    L23:
        return Intrinsics.areEqual(this.indices, ((TableInfo) ZeusTransformUtils.preCheckCast(r7, TableInfo.class, "com.obric.memorydata.plugin")).indices);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.foreignKeys.hashCode();
    }

    public String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
