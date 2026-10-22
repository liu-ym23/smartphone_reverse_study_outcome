package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import com.bytedance.crash.entity.EventBody;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class QueryInterceptorProgram implements SupportSQLiteProgram {
    private final List<Object> bindArgsCache;

    public QueryInterceptorProgram() {
        this.bindArgsCache = new ArrayList();
    }

    private final void saveArgsToCache(int r10, Object r11) {
        int r12 = r10 - 1;
        if (r12 < this.bindArgsCache.size()) goto L9;
        int r13 = this.bindArgsCache.size();
        if (r13 > r12) goto L9;
    L6:
        this.bindArgsCache.add(null);
        if (r13 == r12) goto L9;
        r13 = r13 + 1;
    L9:
        this.bindArgsCache.set(r12, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        saveArgsToCache(r10, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        saveArgsToCache(r10, Double.valueOf(r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        saveArgsToCache(r10, Long.valueOf(r11));
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        saveArgsToCache(r10, null);
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        saveArgsToCache(r10, r11);
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
