package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.crash.entity.EventBody;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final Companion Companion = null;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;

    @JvmField
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = null;
    private int argCount;
    private final int[] bindingTypes;

    @JvmField
    public final byte[][] blobBindings;

    @VisibleForTesting
    private final int capacity;

    @JvmField
    public final double[] doubleBindings;

    @JvmField
    public final long[] longBindings;
    private volatile String query;

    @JvmField
    public final String[] stringBindings;

    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Binding {
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }

        @JvmStatic
        public final RoomSQLiteQuery acquire(String r10, int r11) {
            Intrinsics.checkNotNullParameter(r10, "query");
            TreeMap<Integer, RoomSQLiteQuery> r12 = RoomSQLiteQuery.queryPool;
            monitor-enter(r12);
            Map.Entry<Integer, RoomSQLiteQuery> r13 = r12.ceilingEntry(Integer.valueOf(r11));     // Catch: Throwable -> L13
            if (r13 == null) goto L9;
            r12.remove(r13.getKey());     // Catch: Throwable -> L13
            RoomSQLiteQuery r14 = r13.getValue();     // Catch: Throwable -> L13
            r14.init(r10, r11);     // Catch: Throwable -> L13
            Intrinsics.checkNotNullExpressionValue(r14, "sqliteQuery");     // Catch: Throwable -> L13
            monitor-exit(r12);
            return r14;
        L9:
            Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(r12);
            RoomSQLiteQuery r16 = new RoomSQLiteQuery(r11, null);
            r16.init(r10, r11);
            return r16;
        L13:
            th = move-exception;
            throw th;
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r10) {
            Intrinsics.checkNotNullParameter(r10, "supportSQLiteQuery");
            final RoomSQLiteQuery r11 = acquire(r10.getSql(), r10.getArgCount());
            r10.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(r11));
            return r11;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> r10 = RoomSQLiteQuery.queryPool;
            if (r10.size() <= 15) goto L8;
            int r11 = r10.size() - 10;
            Iterator<Integer> r12 = r10.descendingKeySet().iterator();
            Intrinsics.checkNotNullExpressionValue(r12, "queryPool.descendingKeySet().iterator()");
        L5:
            int r13 = r11 - 1;
            if (r11 <= 0) goto L10;
            r12.next();
            r12.remove();
            r11 = r13;
            goto L5
        L10:
            return;
        }
    }

    static {
        Companion = new Companion(null);
        queryPool = new TreeMap();
    }

    private RoomSQLiteQuery(int r10) {
        this.capacity = r10;
        int r11 = r10 + 1;
        this.bindingTypes = new int[r11];
        this.longBindings = new long[r11];
        this.doubleBindings = new double[r11];
        this.stringBindings = new String[r11];
        this.blobBindings = new byte[r11][];
    }

    public /* synthetic */ RoomSQLiteQuery(int r10, DefaultConstructorMarker r11) {
        this(r10);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String r10, int r11) {
        return Companion.acquire(r10, r11);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r10) {
        return Companion.copyFrom(r10);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r10, byte[] r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.bindingTypes[r10] = 5;
        this.blobBindings[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r10, double r11) {
        this.bindingTypes[r10] = 3;
        this.doubleBindings[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r10, long r11) {
        this.bindingTypes[r10] = 2;
        this.longBindings[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r10) {
        this.bindingTypes[r10] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r10, String r11) {
        Intrinsics.checkNotNullParameter(r11, EventBody.KEY_VALUE);
        this.bindingTypes[r10] = 4;
        this.stringBindings[r10] = r11;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r10) {
        Intrinsics.checkNotNullParameter(r10, "statement");
        int r11 = getArgCount();
        if (1 > r11) goto L31;
        int r12 = 1;
    L5:
        int r13 = this.bindingTypes[r12];
        if (r13 != 1) goto L8;
        r10.bindNull(r12);
    L29:
        if (r12 == r11) goto L35;
        r12 = r12 + 1;
        goto L5
    L35:
        return;
    L8:
        if (r13 != 2) goto L10;
        r10.bindLong(r12, this.longBindings[r12]);
        goto L29
    L10:
        if (r13 != 3) goto L12;
        r10.bindDouble(r12, this.doubleBindings[r12]);
        goto L29
    L12:
        if (r13 != 4) goto L14;
        String r14 = this.stringBindings[r12];
        if (r14 == null) goto L25;
        r10.bindString(r12, r14);
        goto L29
    L25:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        if (r13 != 5) goto L29;
        byte[] r15 = this.blobBindings[r12];
        if (r15 == null) goto L20;
        r10.bindBlob(r12, r15);
        goto L29
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, null);
        Arrays.fill(this.blobBindings, null);
        this.query = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery r10) {
        Intrinsics.checkNotNullParameter(r10, "other");
        int r11 = r10.getArgCount() + 1;
        System.arraycopy(r10.bindingTypes, 0, this.bindingTypes, 0, r11);
        System.arraycopy(r10.longBindings, 0, this.longBindings, 0, r11);
        System.arraycopy(r10.stringBindings, 0, this.stringBindings, 0, r11);
        System.arraycopy(r10.blobBindings, 0, this.blobBindings, 0, r11);
        System.arraycopy(r10.doubleBindings, 0, this.doubleBindings, 0, r11);
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public String getSql() {
        String r10 = this.query;
        if (r10 == null) goto L6;
        return r10;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(String r10, int r11) {
        Intrinsics.checkNotNullParameter(r10, "query");
        this.query = r10;
        this.argCount = r11;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> r10 = queryPool;
        monitor-enter(r10);
        r10.put(Integer.valueOf(this.capacity), this);     // Catch: Throwable -> L7
        Companion.prunePoolLocked$room_runtime_release();     // Catch: Throwable -> L7
        Unit r11 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r10);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
