package androidx.room.util;

import android.annotation.SuppressLint;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
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
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo;", "", "name", "", "columns", "", "createSql", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "options", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo$Companion;", "", "()V", "FTS_OPTIONS", "", "", "[Ljava/lang/String;", "parseOptions", "", "createStatement", "read", "Landroidx/room/util/FtsTableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readColumns", "readOptions", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase r5, String r10) {
            Set r11 = SetsKt.createSetBuilder();
            Cursor r12 = r5.query("PRAGMA table_info(`" + r10 + "`)");
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        L4:
            if (r12.getColumnCount() <= 0) goto L11;
            int r13 = r12.getColumnIndex("name");     // Catch: Throwable -> L9
        L7:
            if (r12.moveToNext() == false) goto L11;
            r11.add(r12.getString(r13));     // Catch: Throwable -> L9
        L11:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
            CloseableKt.closeFinally(r12, null);
            return SetsKt.build(r11);
        }

        private final Set<String> readOptions(SupportSQLiteDatabase r5, String r10) {
            Cursor r11 = r5.query("SELECT * FROM sqlite_master WHERE `name` = '" + r10 + '\'');
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        L4:
            if (r11.moveToFirst() == false) goto L8;
            String r12 = r11.getString(r11.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L6
        L9:
            CloseableKt.closeFinally(r11, null);
            return parseOptions(r12);
        L8:
            r12 = "";
            goto L9
        }

        @JvmStatic
        @VisibleForTesting
        public final Set<String> parseOptions(String r13) {
            Intrinsics.checkNotNullParameter(r13, "createStatement");
            if (r13.length() == 0) goto L5;
            String r12 = r13.substring(StringsKt.q(r13, '(', 0, 6) + 1, StringsKt.t(r13, ')', 0, 6));
            ArrayList r14 = new ArrayList();
            ArrayDeque r5 = new ArrayDeque();
            int r10 = -1;
            int r11 = 0;
            int r15 = 0;
        L8:
            if (r11 >= r12.length()) goto L63;
            char r16 = r12.charAt(r11);
            int r17 = r15 + 1;
            if (r16 == '\'') goto L18;
            if (r16 == '\"') goto L18;
            if (r16 == '`') goto L18;
            if (r16 != '[') goto L32;
            if (r5.isEmpty() == false) goto L62;
            r5.push(Character.valueOf(r16));
        L62:
            r11 = r11 + 1;
            r15 = r17;
            goto L8
        L32:
            if (r16 != ']') goto L42;
            if (r5.isEmpty() == true) goto L62;
            Character r18 = (Character) r5.peek();
            if (r18 == null) goto L62;
            if (r18.charValue() != '[') goto L62;
            r5.pop();
            goto L62
        L42:
            if (r16 != ',') goto L62;
            if (r5.isEmpty() == false) goto L62;
            String r19 = r12.substring(r10 + 1, r15);
            int r20 = r19.length() - 1;
            int r21 = 0;
            boolean r22 = false;
        L46:
            if (r21 > r20) goto L61;
            if (r22 == true) goto L49;
            int r110 = r21;
        L51:
            if (Intrinsics.compare(r19.charAt(r110), 32) > 0) goto L53;
            boolean r111 = true;
        L54:
            if (r22 == false) goto L55;
            if (r111 == false) goto L61;
            r20 = r20 - 1;
            goto L46
        L55:
            if (r111 == false) goto L56;
            r21 = r21 + 1;
            goto L46
        L56:
            r22 = true;
            goto L46
        L53:
            r111 = false;
            goto L54
        L49:
            r110 = r20;
        L61:
            r14.add(r19.subSequence(r21, r20 + 1).toString());
            r10 = r15;
        L18:
            if (r5.isEmpty() == false) goto L20;
            r5.push(Character.valueOf(r16));
            goto L62
        L20:
            Character r23 = (Character) r5.peek();
            if (r23 == null) goto L62;
            if (r23.charValue() != r16) goto L62;
            r5.pop();
            goto L62
        L63:
            r14.add(StringsKt.trim(r12.substring(r10 + 1)).toString());
            ArrayList r112 = new ArrayList();
            Iterator r113 = r14.iterator();
        L65:
            if (r113.hasNext() == false) goto L73;
            Object r24 = r113.next();
            String r25 = (String) r24;
            String[] r26 = FtsTableInfo.access$getFTS_OPTIONS$cp();
            int r27 = r26.length;
            int r28 = 0;
        L67:
            if (r28 >= r27) goto L65;
            if (StringsKt.P(r25, r26[r28]) == true) goto L70;
            r28 = r28 + 1;
            goto L67
        L70:
            r112.add(r24);
            goto L65
        L73:
            return CollectionsKt.toSet(r112);
        L5:
            return SetsKt.emptySet();
        }

        @JvmStatic
        @SuppressLint({"SyntheticAccessor"})
        public final FtsTableInfo read(SupportSQLiteDatabase r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "database");
            Intrinsics.checkNotNullParameter(r10, "tableName");
            return new FtsTableInfo(r10, readColumns(r5, r10), readOptions(r5, r10));
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public FtsTableInfo(String r5, Set<String> r10, Set<String> r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "columns");
        Intrinsics.checkNotNullParameter(r11, "options");
        this.name = r5;
        this.columns = r10;
        this.options = r11;
    }

    public static final /* synthetic */ String[] access$getFTS_OPTIONS$cp() {
        return FTS_OPTIONS;
    }

    @JvmStatic
    @VisibleForTesting
    public static final Set<String> parseOptions(String r5) {
        return Companion.parseOptions(r5);
    }

    @JvmStatic
    @SuppressLint({"SyntheticAccessor"})
    public static final FtsTableInfo read(SupportSQLiteDatabase r5, String r10) {
        return Companion.read(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof FtsTableInfo) == true) goto L8;
        return false;
    L8:
        FtsTableInfo r10 = (FtsTableInfo) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.columns, r10.columns) == true) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.options, r10.options);
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        int r10 = (this.columns.hashCode() + r5) * 31;
        return this.options.hashCode() + r10;
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }

    public FtsTableInfo(String r5, Set<String> r10, String r11) {
        Intrinsics.checkNotNullParameter(r5, "name");
        Intrinsics.checkNotNullParameter(r10, "columns");
        Intrinsics.checkNotNullParameter(r11, "createSql");
        this(r5, r10, Companion.parseOptions(r11));
    }
}
