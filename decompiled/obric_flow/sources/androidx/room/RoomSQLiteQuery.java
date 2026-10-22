package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0000J\u0016\u00102\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020#R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u0012\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\rR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\r¨\u00067"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "(I)V", "<set-?>", "argCount", "getArgCount", "()I", "bindingTypes", "", "getBindingTypes$annotations", "()V", "blobBindings", "", "", "getBlobBindings$annotations", "[[B", "getCapacity", "doubleBindings", "", "getDoubleBindings$annotations", "longBindings", "", "getLongBindings$annotations", "query", "", "sql", "getSql", "()Ljava/lang/String;", "stringBindings", "getStringBindings$annotations", "[Ljava/lang/String;", "bindBlob", "", "index", "value", "bindDouble", "", "bindLong", "", "bindNull", "bindString", "bindTo", "statement", "clearBindings", "close", "copyArgumentsFrom", "other", "init", "initArgCount", "release", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
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

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Binding {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002¨\u0006\u001b"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", "()V", "BLOB", "", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "DOUBLE", "LONG", "NULL", "POOL_LIMIT", "getPOOL_LIMIT$annotations", "STRING", "queryPool", "Ljava/util/TreeMap;", "Landroidx/room/RoomSQLiteQuery;", "getQueryPool$annotations", "acquire", "query", "", "argumentCount", "copyFrom", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "prunePoolLocked", "", "prunePoolLocked$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r5) {
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
        public final RoomSQLiteQuery acquire(String r5, int r10) {
            Intrinsics.checkNotNullParameter(r5, "query");
            TreeMap<Integer, RoomSQLiteQuery> r11 = RoomSQLiteQuery.queryPool;
            monitor-enter(r11);
            Map.Entry<Integer, RoomSQLiteQuery> r12 = r11.ceilingEntry(Integer.valueOf(r10));     // Catch: Throwable -> L9
            if (r12 == null) goto L11;
            r11.remove(r12.getKey());     // Catch: Throwable -> L9
            RoomSQLiteQuery r13 = r12.getValue();     // Catch: Throwable -> L9
            r13.init(r5, r10);     // Catch: Throwable -> L9
            monitor-exit(r11);
            return r13;
        L11:
            Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L9
            monitor-exit(r11);
            RoomSQLiteQuery r15 = new RoomSQLiteQuery(r10, null);
            r15.init(r5, r10);
            return r15;
        L9:
            th = move-exception;
            throw th;
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r5) {
            Intrinsics.checkNotNullParameter(r5, "supportSQLiteQuery");
            final RoomSQLiteQuery r10 = acquire(r5.getSql(), r5.getArgCount());
            r5.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(r10));
            return r10;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> r5 = RoomSQLiteQuery.queryPool;
            if (r5.size() <= 15) goto L8;
            int r10 = r5.size() - 10;
            Iterator<Integer> r11 = r5.descendingKeySet().iterator();
        L5:
            int r12 = r10 - 1;
            if (r10 <= 0) goto L10;
            r11.next();
            r11.remove();
            r10 = r12;
            goto L5
        L10:
            return;
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
        queryPool = new TreeMap();
    }

    public /* synthetic */ RoomSQLiteQuery(int r5, DefaultConstructorMarker r10) {
        this(r5);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String r5, int r10) {
        return Companion.acquire(r5, r10);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r5) {
        return Companion.copyFrom(r5);
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
    public void bindBlob(int r5, byte[] r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.bindingTypes[r5] = 5;
        this.blobBindings[r5] = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r5, double r10) {
        this.bindingTypes[r5] = 3;
        this.doubleBindings[r5] = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r5, long r10) {
        this.bindingTypes[r5] = 2;
        this.longBindings[r5] = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r5) {
        this.bindingTypes[r5] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r5, String r10) {
        Intrinsics.checkNotNullParameter(r10, "value");
        this.bindingTypes[r5] = 4;
        this.stringBindings[r5] = r10;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r10) {
        Intrinsics.checkNotNullParameter(r10, "statement");
        int r5 = getArgCount();
        if (1 > r5) goto L31;
        int r11 = 1;
    L5:
        int r12 = this.bindingTypes[r11];
        if (r12 != 1) goto L8;
        r10.bindNull(r11);
    L29:
        if (r11 == r5) goto L35;
        r11 = r11 + 1;
        goto L5
    L35:
        return;
    L8:
        if (r12 != 2) goto L10;
        r10.bindLong(r11, this.longBindings[r11]);
        goto L29
    L10:
        if (r12 != 3) goto L12;
        r10.bindDouble(r11, this.doubleBindings[r11]);
        goto L29
    L12:
        if (r12 != 4) goto L14;
        String r13 = this.stringBindings[r11];
        if (r13 == null) goto L25;
        r10.bindString(r11, r13);
        goto L29
    L25:
        throw new IllegalArgumentException("Required value was null.");
    L14:
        if (r12 != 5) goto L29;
        byte[] r14 = this.blobBindings[r11];
        if (r14 == null) goto L20;
        r10.bindBlob(r11, r14);
        goto L29
    L20:
        throw new IllegalArgumentException("Required value was null.");
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

    public final void copyArgumentsFrom(RoomSQLiteQuery r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r10 = r5.getArgCount() + 1;
        System.arraycopy(r5.bindingTypes, 0, this.bindingTypes, 0, r10);
        System.arraycopy(r5.longBindings, 0, this.longBindings, 0, r10);
        System.arraycopy(r5.stringBindings, 0, this.stringBindings, 0, r10);
        System.arraycopy(r5.blobBindings, 0, this.blobBindings, 0, r10);
        System.arraycopy(r5.doubleBindings, 0, this.doubleBindings, 0, r10);
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
        String r5 = this.query;
        if (r5 == null) goto L6;
        return r5;
    L6:
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(String r5, int r10) {
        Intrinsics.checkNotNullParameter(r5, "query");
        this.query = r5;
        this.argCount = r10;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> r5 = queryPool;
        monitor-enter(r5);
        r5.put(Integer.valueOf(this.capacity), this);     // Catch: Throwable -> L7
        Companion.prunePoolLocked$room_runtime_release();     // Catch: Throwable -> L7
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r5);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private RoomSQLiteQuery(int r5) {
        this.capacity = r5;
        int r10 = r5 + 1;
        this.bindingTypes = new int[r10];
        this.longBindings = new long[r10];
        this.doubleBindings = new double[r10];
        this.stringBindings = new String[r10];
        this.blobBindings = new byte[r10][];
    }
}
