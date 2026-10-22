package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B%\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0002\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u0003H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo;", "", ActivityLifecycle.NAME, "", "columns", "", "createSql", "(Ljava/lang/String;Ljava/util/Set;Ljava/lang/String;)V", "options", "(Ljava/lang/String;Ljava/util/Set;Ljava/util/Set;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FtsTableInfo {
    public static final Companion Companion = null;
    private static final String[] FTS_OPTIONS = null;
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\t\u001a\u00020\u0005H\u0007J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002J\u001e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0011"}, d2 = {"Landroidx/room/util/FtsTableInfo$Companion;", "", "()V", "FTS_OPTIONS", "", "", "[Ljava/lang/String;", "parseOptions", "", "createStatement", "read", "Landroidx/room/util/FtsTableInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "tableName", "readColumns", "readOptions", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private final Set<String> readColumns(SupportSQLiteDatabase r5, String r6) {
            SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Set r7 = SetsKt.createSetBuilder();
            Cursor r8 = r4.query("PRAGMA table_info(`" + r6 + "`)");
            if (Build.VERSION.SDK_INT <= 15) goto L31;
            Closeable r9 = (Closeable) ZeusTransformUtils.preCheckCast(r8, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r0 = (Cursor) ZeusTransformUtils.preCheckCast(r9, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            if (r0.getColumnCount() <= 0) goto L11;
            int r2 = r0.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L13
        L9:
            if (r0.moveToNext() == false) goto L11;
            String r3 = r0.getString(r2);     // Catch: Throwable -> L13
            Intrinsics.checkNotNullExpressionValue(r3, "cursor.getString(nameIndex)");     // Catch: Throwable -> L13
            r7.add(r3);     // Catch: Throwable -> L13
        L11:
            Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L13
            CloseableKt.closeFinally(r9, null);
        L27:
            return SetsKt.build(r7);
        L13:
            th = move-exception;
            throw th;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            CloseableKt.closeFinally(r9, th);
            throw th;
        L31:
        L28:
            th = move-exception;
            r8.close();
            throw th;
        L19:
            if (r8.getColumnCount() <= 0) goto L24;
            int r10 = r8.getColumnIndex(ActivityLifecycle.NAME);     // Catch: Throwable -> L28
        L22:
            if (r8.moveToNext() == false) goto L24;
            String r11 = r8.getString(r10);     // Catch: Throwable -> L28
            Intrinsics.checkNotNullExpressionValue(r11, "cursor.getString(nameIndex)");     // Catch: Throwable -> L28
            r7.add(r11);     // Catch: Throwable -> L28
        L24:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L28
            r8.close();
            goto L27
        }

        private final Set<String> readOptions(SupportSQLiteDatabase r5, String r6) {
            Cursor r7 = ((SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r5, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin")).query("SELECT * FROM sqlite_master WHERE `name` = '" + r6 + '\'');
            String r0 = "";
            if (Build.VERSION.SDK_INT <= 15) goto L23;
            Closeable r8 = (Closeable) ZeusTransformUtils.preCheckCast(r7, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r1 = (Cursor) ZeusTransformUtils.preCheckCast(r8, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L9
            if (r1.moveToFirst() == false) goto L8;
            r0 = r1.getString(r1.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L9
        L8:
            CloseableKt.closeFinally(r8, null);
        L18:
            Intrinsics.checkNotNullExpressionValue(r0, "sql");
            return parseOptions(r0);
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r8, th);
            throw th;
        L23:
        L20:
            th = move-exception;
            r7.close();
            throw th;
        L15:
            if (r7.moveToFirst() == false) goto L17;
            r0 = r7.getString(r7.getColumnIndexOrThrow("sql"));     // Catch: Throwable -> L20
        L17:
            r7.close();
            goto L18
        }

        @JvmStatic
        public final Set<String> parseOptions(String r17) {
            Intrinsics.checkNotNullParameter(r17, "createStatement");
            if (((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L5;
            boolean r1 = true;
        L6:
            if (r1 == true) goto L8;
            String r0 = r17.substring(StringsKt.indexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"), '(', 0, false, 6, null) + 1, StringsKt.lastIndexOf$default((CharSequence) ZeusTransformUtils.preCheckCast(r17, CharSequence.class, "com.obric.memorydata.plugin"), ')', 0, false, 6, null));
            Intrinsics.checkNotNullExpressionValue(r0, "this as java.lang.String…ing(startIndex, endIndex)");
            List r5 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
            ArrayDeque r6 = new ArrayDeque();
            CharSequence r7 = (CharSequence) ZeusTransformUtils.preCheckCast(r0, CharSequence.class, "com.obric.memorydata.plugin");
            int r8 = -1;
            int r9 = 0;
            int r10 = 0;
        L11:
            if (r9 >= r7.length()) goto L72;
            char r11 = r7.charAt(r9);
            int r12 = r10 + 1;
            if (r11 != '\'') goto L16;
        L14:
            boolean r13 = true;
        L19:
            if (r13 == false) goto L22;
        L20:
            boolean r14 = true;
        L25:
            if (r14 == false) goto L36;
            if (r6.isEmpty() == false) goto L29;
        L28:
            r6.push(Character.valueOf(r11));
        L71:
            r9 = r9 + 1;
            r10 = r12;
            goto L11
        L29:
            Character r15 = (Character) ZeusTransformUtils.preCheckCast(r6.peek(), Character.class, "com.obric.memorydata.plugin");
            if (r15 == null) goto L71;
            if (r15.charValue() != r11) goto L71;
        L34:
            r6.pop();
            goto L71
        L36:
            if (r11 != '[') goto L41;
            if (r6.isEmpty() == false) goto L71;
        L41:
            if (r11 != ']') goto L51;
            if (r6.isEmpty() == true) goto L71;
            Character r16 = (Character) ZeusTransformUtils.preCheckCast(r6.peek(), Character.class, "com.obric.memorydata.plugin");
            if (r16 == null) goto L71;
            if (r16.charValue() != '[') goto L71;
        L51:
            if (r11 != ',') goto L71;
            if (r6.isEmpty() == false) goto L71;
            String r18 = r0.substring(r8 + 1, r10);
            Intrinsics.checkNotNullExpressionValue(r18, "this as java.lang.String…ing(startIndex, endIndex)");
            CharSequence r19 = (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.memorydata.plugin");
            int r110 = r19.length() - 1;
            int r111 = 0;
            boolean r112 = false;
        L55:
            if (r111 > r110) goto L70;
            if (r112 == true) goto L58;
            int r113 = r111;
        L60:
            if (Intrinsics.compare(r19.charAt(r113), 32) > 0) goto L62;
            boolean r3 = true;
        L63:
            if (r112 == false) goto L64;
            if (r3 == false) goto L70;
            r110 = r110 - 1;
            goto L55
        L64:
            if (r3 == false) goto L65;
            r111 = r111 + 1;
            goto L55
        L65:
            r112 = true;
            goto L55
        L62:
            r3 = false;
            goto L63
        L58:
            r113 = r110;
        L70:
            r5.add(r19.subSequence(r111, r110 + 1).toString());
            r8 = r10;
            goto L71
        L22:
            if (r11 == '`') goto L20;
            r14 = false;
            goto L25
        L16:
            if (r11 == '\"') goto L14;
            r13 = false;
            goto L19
        L72:
            String r2 = r0.substring(r8 + 1);
            Intrinsics.checkNotNullExpressionValue(r2, "this as java.lang.String).substring(startIndex)");
            r5.add(StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.memorydata.plugin")).toString());
            Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin");
            Collection r20 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
            Iterator r21 = r4.iterator();
        L74:
            if (r21.hasNext() == false) goto L85;
            Object r22 = r21.next();
            String r23 = (String) ZeusTransformUtils.preCheckCast(r22, String.class, "com.obric.memorydata.plugin");
            String[] r24 = FtsTableInfo.access$getFTS_OPTIONS$cp();
            int r25 = r24.length;
            int r26 = 0;
        L76:
            if (r26 >= r25) goto L81;
            if (StringsKt.startsWith$default(r23, r24[r26], false, 2, null) == true) goto L79;
            r26 = r26 + 1;
            goto L76
        L79:
            boolean r27 = true;
        L82:
            if (r27 == false) goto L74;
            r20.add(r22);
            goto L74
        L81:
            r27 = false;
            goto L82
        L85:
            return CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r20, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"));
        L8:
            return SetsKt.emptySet();
        L5:
            r1 = false;
            goto L6
        }

        @JvmStatic
        public final FtsTableInfo read(SupportSQLiteDatabase r3, String r4) {
            SupportSQLiteDatabase r5 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r3, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "database");
            Intrinsics.checkNotNullParameter(r4, "tableName");
            return new FtsTableInfo(r4, readColumns(r5, r4), readOptions(r5, r4));
        }
    }

    static {
        Companion = new Companion(null);
        FTS_OPTIONS = new String[]{"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};
    }

    public FtsTableInfo(String r3, Set<String> r4, String r5) {
        Set r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "columns");
        Intrinsics.checkNotNullParameter(r5, "createSql");
        this(r3, r6, Companion.parseOptions(r5));
    }

    public FtsTableInfo(String r3, Set<String> r4, Set<String> r5) {
        Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
        Set<String> r7 = (Set) ZeusTransformUtils.wrapperContextForParams(r5, Set.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, ActivityLifecycle.NAME);
        Intrinsics.checkNotNullParameter(r6, "columns");
        Intrinsics.checkNotNullParameter(r7, "options");
        this.name = r3;
        this.columns = r6;
        this.options = r7;
    }

    public static final /* synthetic */ String[] access$getFTS_OPTIONS$cp() {
        return FTS_OPTIONS;
    }

    @JvmStatic
    public static final Set<String> parseOptions(String r1) {
        return Companion.parseOptions(r1);
    }

    @JvmStatic
    public static final FtsTableInfo read(SupportSQLiteDatabase r2, String r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        return Companion.read(r4, r3);
    }

    public boolean equals(Object r6) {
        if (this != r6) goto L7;
        return true;
    L7:
        if (ZeusTransformUtils.instanceOf(r6, FtsTableInfo.class) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.name, ((FtsTableInfo) ZeusTransformUtils.preCheckCast(r6, FtsTableInfo.class, "com.obric.memorydata.plugin")).name) == true) goto L13;
        return false;
    L13:
        if (Intrinsics.areEqual(this.columns, ((FtsTableInfo) ZeusTransformUtils.preCheckCast(r6, FtsTableInfo.class, "com.obric.memorydata.plugin")).columns) == true) goto L16;
        return false;
    L16:
        return Intrinsics.areEqual(this.options, ((FtsTableInfo) ZeusTransformUtils.preCheckCast(r6, FtsTableInfo.class, "com.obric.memorydata.plugin")).options);
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.columns.hashCode()) * 31) + this.options.hashCode();
    }

    public String toString() {
        return "FtsTableInfo{name='" + this.name + "', columns=" + this.columns + ", options=" + this.options + "'}";
    }
}
