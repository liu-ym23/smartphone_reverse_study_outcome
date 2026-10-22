package androidx.room.util;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    public static final Companion Companion = null;
    private static final String[] FTS_OPTIONS = null;

    @JvmField
    public final Set<String> columns;

    @JvmField
    public final String name;

    @JvmField
    public final Set<String> options;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase r10, String r11) {
            Set r12 = SetsKt.createSetBuilder();
            Cursor r13 = r10.query("PRAGMA table_info(`" + r11 + "`)");
            if (Build.VERSION.SDK_INT > 15) goto L33;
        L28:
            th = move-exception;
            r13.close();
            throw th;
        L19:
            if (r13.getColumnCount() <= 0) goto L24;
            int r14 = r13.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L28
        L22:
            if (r13.moveToNext() == false) goto L24;
            String r15 = r13.getString(r14);     // Catch: Throwable -> L28
            Intrinsics.checkNotNullExpressionValue(r15, "cursor.getString(nameIndex)");     // Catch: Throwable -> L28
            r12.add(r15);     // Catch: Throwable -> L28
        L24:
            Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L28
            r13.close();
        L27:
            return SetsKt.build(r12);
        L33:
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r13, th);
            throw th;
        L6:
            if (r13.getColumnCount() <= 0) goto L11;
            int r17 = r13.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L13
        L9:
            if (r13.moveToNext() == false) goto L11;
            String r18 = r13.getString(r17);     // Catch: Throwable -> L13
            Intrinsics.checkNotNullExpressionValue(r18, "cursor.getString(nameIndex)");     // Catch: Throwable -> L13
            r12.add(r18);     // Catch: Throwable -> L13
        L11:
            Unit r19 = Unit.INSTANCE;     // Catch: Throwable -> L13
            CloseableKt.closeFinally(r13, null);
            goto L27
        }

        private final Set<String> readOptions(SupportSQLiteDatabase r10, String r11) {
            Cursor r12 = r10.query("SELECT * FROM sqlite_master WHERE `name` = '" + r11 + '\'');
            String r13 = "";
            if (Build.VERSION.SDK_INT > 15) goto L25;
        L20:
            th = move-exception;
            r12.close();
            throw th;
        L15:
            if (r12.moveToFirst() == false) goto L17;
            r13 = r12.getString(r12.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L20
        L17:
            r12.close();
        L18:
            Intrinsics.checkNotNullExpressionValue(r13, "sql");
            return parseOptions(r13);
        L25:
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        L6:
            if (r12.moveToFirst() == false) goto L8;
            r13 = r12.getString(r12.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L9
        L8:
            CloseableKt.closeFinally(r12, null);
            goto L18
        }

        @JvmStatic
        @VisibleForTesting
        public final Set<String> parseOptions(String r14) {
            Intrinsics.checkNotNullParameter(r14, "createStatement");
            if (r14.length() != 0) goto L5;
            boolean r13 = true;
        L6:
            if (r13 == true) goto L8;
            String r15 = r14.substring(StringsKt.indexOf$default(r14, '(', 0, false, 6, null) + 1, StringsKt.lastIndexOf$default(r14, ')', 0, false, 6, null));
            Intrinsics.checkNotNullExpressionValue(r15, "this as java.lang.String…ing(startIndex, endIndex)");
            ArrayList r10 = new ArrayList();
            ArrayDeque r11 = new ArrayDeque();
            int r12 = -1;
            int r16 = 0;
            int r17 = 0;
        L11:
            if (r16 >= r15.length()) goto L72;
            char r18 = r15.charAt(r16);
            int r19 = r17 + 1;
            if (r18 != '\'') goto L16;
        L14:
            boolean r20 = true;
        L19:
            if (r20 == false) goto L22;
        L20:
            boolean r21 = true;
        L25:
            if (r21 == false) goto L36;
            if (r11.isEmpty() == false) goto L29;
        L28:
            r11.push(Character.valueOf(r18));
        L71:
            r16 = r16 + 1;
            r17 = r19;
            goto L11
        L29:
            Character r22 = (Character) r11.peek();
            if (r22 == null) goto L71;
            if (r22.charValue() != r18) goto L71;
        L34:
            r11.pop();
            goto L71
        L36:
            if (r18 != '[') goto L41;
            if (r11.isEmpty() == false) goto L71;
        L41:
            if (r18 != ']') goto L51;
            if (r11.isEmpty() == true) goto L71;
            Character r23 = (Character) r11.peek();
            if (r23 == null) goto L71;
            if (r23.charValue() != '[') goto L71;
        L51:
            if (r18 != ',') goto L71;
            if (r11.isEmpty() == false) goto L71;
            String r24 = r15.substring(r12 + 1, r17);
            Intrinsics.checkNotNullExpressionValue(r24, "this as java.lang.String…ing(startIndex, endIndex)");
            int r25 = r24.length() - 1;
            int r26 = 0;
            boolean r110 = false;
        L55:
            if (r26 > r25) goto L70;
            if (r110 == true) goto L58;
            int r111 = r26;
        L60:
            if (Intrinsics.compare(r24.charAt(r111), 32) > 0) goto L62;
            boolean r112 = true;
        L63:
            if (r110 == false) goto L64;
            if (r112 == false) goto L70;
            r25 = r25 - 1;
            goto L55
        L64:
            if (r112 == false) goto L65;
            r26 = r26 + 1;
            goto L55
        L65:
            r110 = true;
            goto L55
        L62:
            r112 = false;
            goto L63
        L58:
            r111 = r25;
        L70:
            r10.add(r24.subSequence(r26, r25 + 1).toString());
            r12 = r17;
            goto L71
        L22:
            if (r18 == '`') goto L20;
            r21 = false;
            goto L25
        L16:
            if (r18 == '\"') goto L14;
            r20 = false;
            goto L19
        L72:
            String r113 = r15.substring(r12 + 1);
            Intrinsics.checkNotNullExpressionValue(r113, "this as java.lang.String).substring(startIndex)");
            r10.add(StringsKt.trim(r113).toString());
            ArrayList r114 = new ArrayList();
            Iterator r115 = r10.iterator();
        L74:
            if (r115.hasNext() == false) goto L85;
            Object r27 = r115.next();
            String r28 = (String) r27;
            String[] r29 = FtsTableInfo.access$getFTS_OPTIONS$cp();
            int r30 = r29.length;
            int r31 = 0;
        L76:
            if (r31 >= r30) goto L81;
            if (StringsKt.startsWith$default(r28, r29[r31], false, 2, null) == true) goto L79;
            r31 = r31 + 1;
            goto L76
        L79:
            boolean r32 = true;
        L82:
            if (r32 == false) goto L74;
            r114.add(r27);
            goto L74
        L81:
            r32 = false;
            goto L82
        L85:
            return CollectionsKt.toSet(r114);
        L8:
            return SetsKt.emptySet();
        L5:
            r13 = false;
            goto L6
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        public final FtsTableInfo read(SupportSQLiteDatabase r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "database");
            Intrinsics.checkNotNullParameter(r11, "tableName");
            return new FtsTableInfo(r11, readColumns(r10, r11), readOptions(r10, r11));
        }
    }

    static {
        Companion = new Companion(null);
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public FtsTableInfo(String r10, Set<String> r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "columns");
        Intrinsics.checkNotNullParameter(r12, "createSql");
        this(r10, r11, Companion.parseOptions(r12));
    }

    public FtsTableInfo(String r10, Set<String> r11, Set<String> r12) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r11, "columns");
        Intrinsics.checkNotNullParameter(r12, "options");
        this.name = r10;
        this.columns = r11;
        this.options = r12;
    }

    public static final /* synthetic */ String[] access$getFTS_OPTIONS$cp() {
        return FTS_OPTIONS;
    }

    @JvmStatic
    @VisibleForTesting
    public static final Set<String> parseOptions(String r10) {
        return Companion.parseOptions(r10);
    }

    @JvmStatic
    @SuppressLint({"SyntheticAccessor"})
    public static final FtsTableInfo read(SupportSQLiteDatabase r10, String r11) {
        return Companion.read(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof FtsTableInfo) == true) goto L8;
        return false;
    L8:
        FtsTableInfo r11 = (FtsTableInfo) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r11.columns) == true) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.options, r11.options);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }
}
