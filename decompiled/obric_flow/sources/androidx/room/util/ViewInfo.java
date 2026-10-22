package androidx.room.util;

import ai.j0;
import android.database.Cursor;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/ViewInfo;", "", "name", "", "sql", "(Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    public static final Companion Companion = null;

    @JvmField
    public final String name;

    @JvmField
    public final String sql;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/ViewInfo$Companion;", "", "()V", "read", "Landroidx/room/util/ViewInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "viewName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
            this();
        }

        @JvmStatic
        public final ViewInfo read(SupportSQLiteDatabase r5, String r10) {
            Intrinsics.checkNotNullParameter(r5, "database");
            Intrinsics.checkNotNullParameter(r10, "viewName");
            Cursor r11 = r5.query("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + r10 + '\'');
        L6:
            th = move-exception;
            throw th;     // Catch: Throwable -> L12
        L12:
            th = move-exception;
            CloseableKt.closeFinally(r11, th);
            throw th;
        L4:
            if (r11.moveToFirst() == false) goto L8;
            ViewInfo r12 = new ViewInfo(r11.getString(0), r11.getString(1));     // Catch: Throwable -> L6
        L9:
            CloseableKt.closeFinally(r11, null);
            return r12;
        L8:
            r12 = new ViewInfo(r10, null);     // Catch: Throwable -> L6
            goto L9
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    public ViewInfo(String r5, String r10) {
        Intrinsics.checkNotNullParameter(r5, "name");
        this.name = r5;
        this.sql = r10;
    }

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase r5, String r10) {
        return Companion.read(r5, r10);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ViewInfo) == true) goto L8;
        return false;
    L8:
        ViewInfo r10 = (ViewInfo) r5;
        if (Intrinsics.areEqual(this.name, r10.name) == false) goto L20;
        String r11 = this.sql;
        if (r11 == null) goto L14;
        boolean r12 = Intrinsics.areEqual(r11, r10.sql);
    L17:
        if (r12 == false) goto L20;
        return true;
    L14:
        if (r10.sql != null) goto L16;
        r12 = true;
        goto L17
    L16:
        r12 = false;
    L20:
        return false;
    }

    public int hashCode() {
        int r5 = this.name.hashCode() * 31;
        String r10 = this.sql;
        if (r10 == null) goto L5;
        int r11 = r10.hashCode();
    L7:
        return r5 + r11;
    L5:
        r11 = 0;
        goto L7
    }

    public String toString() {
        StringBuilder r5 = new StringBuilder("ViewInfo{name='");
        r5.append(this.name);
        r5.append("', sql='");
        return j0.q(r5, this.sql, "'}");
    }
}
