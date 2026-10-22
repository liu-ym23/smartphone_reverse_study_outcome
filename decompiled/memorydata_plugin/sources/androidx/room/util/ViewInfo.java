package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Closeable;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/ViewInfo;", "", ActivityLifecycle.NAME, "", "sql", "(Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ViewInfo {
    public static final Companion Companion = null;
    public final String name;
    public final String sql;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/ViewInfo$Companion;", "", "()V", "read", "Landroidx/room/util/ViewInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "viewName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        @JvmStatic
        public final ViewInfo read(SupportSQLiteDatabase r7, String r8) {
            SupportSQLiteDatabase r6 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r6, "database");
            Intrinsics.checkNotNullParameter(r8, "viewName");
            Cursor r9 = r6.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r8 + '\'');
            if (Build.VERSION.SDK_INT <= 15) goto L25;
            Closeable r10 = (Closeable) ZeusTransformUtils.preCheckCast(r9, Closeable.class, "com.obric.memorydata.plugin");
            Cursor r11 = (Cursor) ZeusTransformUtils.preCheckCast(r10, Cursor.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            if (r11.moveToFirst() == false) goto L9;
            String r0 = r11.getString(0);     // Catch: Throwable -> L11
            Intrinsics.checkNotNullExpressionValue(r0, "cursor.getString(0)");     // Catch: Throwable -> L11
            ViewInfo r12 = new ViewInfo(r0, r11.getString(1));     // Catch: Throwable -> L11
        L10:
            CloseableKt.closeFinally(r10, null);
            return r12;
        L9:
            r12 = new ViewInfo(r8, null);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            CloseableKt.closeFinally(r10, th);
            throw th;
        L25:
        L22:
            th = move-exception;
            r9.close();
            throw th;
        L17:
            if (r9.moveToFirst() == false) goto L19;
            String r13 = r9.getString(0);     // Catch: Throwable -> L22
            Intrinsics.checkNotNullExpressionValue(r13, "cursor.getString(0)");     // Catch: Throwable -> L22
            ViewInfo r14 = new ViewInfo(r13, r9.getString(1));     // Catch: Throwable -> L22
        L20:
            ViewInfo r15 = r14;
            r9.close();
            return r15;
        L19:
            r14 = new ViewInfo(r8, null);     // Catch: Throwable -> L22
            goto L20
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewInfo(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, ActivityLifecycle.NAME);
        this.name = r2;
        this.sql = r3;
    }

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase r2, String r3) {
        SupportSQLiteDatabase r4 = (SupportSQLiteDatabase) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteDatabase.class, "com.obric.memorydata.plugin");
        return Companion.read(r4, r3);
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, ViewInfo.class) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.name, ((ViewInfo) ZeusTransformUtils.preCheckCast(r7, ViewInfo.class, "com.obric.memorydata.plugin")).name) == false) goto L20;
        String r6 = this.sql;
        if (r6 == null) goto L14;
        boolean r8 = Intrinsics.areEqual(r6, ((ViewInfo) ZeusTransformUtils.preCheckCast(r7, ViewInfo.class, "com.obric.memorydata.plugin")).sql);
    L17:
        if (r8 == false) goto L20;
        return true;
    L14:
        if (((ViewInfo) ZeusTransformUtils.preCheckCast(r7, ViewInfo.class, "com.obric.memorydata.plugin")).sql != null) goto L16;
        r8 = true;
        goto L17
    L16:
        r8 = false;
    L20:
        return false;
    }

    public int hashCode() {
        int r0 = this.name.hashCode() * 31;
        String r1 = this.sql;
        if (r1 == null) goto L5;
        int r2 = r1.hashCode();
    L7:
        return r0 + r2;
    L5:
        r2 = 0;
        goto L7
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
