package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.bytedance.crash.tracker.ActivityLifecycle;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    public static final Companion Companion = null;

    @JvmField
    public final String name;

    @JvmField
    public final String sql;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @JvmStatic
        public final ViewInfo read(SupportSQLiteDatabase r10, String r11) {
            Intrinsics.checkNotNullParameter(r10, "database");
            Intrinsics.checkNotNullParameter(r11, "viewName");
            Cursor r12 = r10.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r11 + '\'');
            if (Build.VERSION.SDK_INT > 15) goto L26;
        L20:
            th = move-exception;
            r12.close();
            throw th;
        L15:
            if (r12.moveToFirst() == false) goto L17;
            String r13 = r12.getString(0);     // Catch: Throwable -> L20
            Intrinsics.checkNotNullExpressionValue(r13, "cursor.getString(0)");     // Catch: Throwable -> L20
            ViewInfo r14 = new ViewInfo(r13, r12.getString(1));     // Catch: Throwable -> L20
        L18:
            r12.close();
        L19:
            return r14;
        L17:
            r14 = new ViewInfo(r11, null);     // Catch: Throwable -> L20
            goto L18
        L26:
        L9:
            th = move-exception;
            throw th;     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            CloseableKt.closeFinally(r12, th);
            throw th;
        L5:
            if (r12.moveToFirst() == false) goto L7;
            String r15 = r12.getString(0);     // Catch: Throwable -> L9
            Intrinsics.checkNotNullExpressionValue(r15, "cursor.getString(0)");     // Catch: Throwable -> L9
            r14 = new ViewInfo(r15, r12.getString(1));     // Catch: Throwable -> L9
        L8:
            CloseableKt.closeFinally(r12, null);
            goto L19
        L7:
            r14 = new ViewInfo(r11, null);     // Catch: Throwable -> L9
            goto L8
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewInfo(String r10, String r11) {
        Intrinsics.checkNotNullParameter(r10, ActivityLifecycle.NAME);
        this.name = r10;
        this.sql = r11;
    }

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase r10, String r11) {
        return Companion.read(r10, r11);
    }

    public boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof ViewInfo) == true) goto L8;
        return false;
    L8:
        ViewInfo r11 = (ViewInfo) r10;
        if (Intrinsics.areEqual(this.name, r11.name) == false) goto L20;
        String r12 = this.sql;
        if (r12 == null) goto L14;
        boolean r13 = Intrinsics.areEqual(r12, r11.sql);
    L17:
        if (r13 == false) goto L20;
        return true;
    L14:
        if (r11.sql != null) goto L16;
        r13 = true;
        goto L17
    L16:
        r13 = false;
    L20:
        return false;
    }

    public int hashCode() {
        int r10 = this.name.hashCode() * 31;
        String r11 = this.sql;
        if (r11 == null) goto L5;
        int r12 = r11.hashCode();
    L7:
        return r10 + r12;
    L5:
        r12 = 0;
        goto L7
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }
}
