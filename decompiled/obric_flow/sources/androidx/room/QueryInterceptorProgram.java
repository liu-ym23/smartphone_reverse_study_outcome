package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0013\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\tH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u001a\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0005H\u0002R\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0019"}, d2 = {"Landroidx/room/QueryInterceptorProgram;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "()V", "bindArgsCache", "", "", "getBindArgsCache$room_runtime_release", "()Ljava/util/List;", "bindBlob", "", "index", "", "value", "", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "", "clearBindings", "close", "saveArgsToCache", "bindIndex", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache;

    public QueryInterceptorProgram() {
        this.bindArgsCache = new ArrayList();
    }

    private final void saveArgsToCache(int r5, Object r10) {
        int r11 = r5 - 1;
        if (r11 < this.bindArgsCache.size()) goto L9;
        int r12 = this.bindArgsCache.size();
        if (r12 > r11) goto L9;
    L6:
        this.bindArgsCache.add(null);
        if (r12 == r11) goto L9;
        r12 = r12 + 1;
    L9:
        this.bindArgsCache.set(r11, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        saveArgsToCache(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r5, double r10) {
        saveArgsToCache(r5, Double.valueOf(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r5, long r10) {
        saveArgsToCache(r5, Long.valueOf(r10));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r5) {
        saveArgsToCache(r5, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        saveArgsToCache(r5, r10);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        this.bindArgsCache.clear();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final List<Object> getBindArgsCache$room_runtime_release() {
        return this.bindArgsCache;
    }
}
