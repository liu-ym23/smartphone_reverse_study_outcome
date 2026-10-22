package androidx.room;

import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.memory.island.gr.IslandSession;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u000e\b\u0007\u0018\u0000 62\u00020\u00012\u00020\u0002:\u000256B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0010H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010+\u001a\u00020#2\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001bH\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020\u0002H\u0016J\b\u0010.\u001a\u00020#H\u0016J\b\u0010/\u001a\u00020#H\u0016J\u000e\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u0000J\u0016\u00102\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020#R\u001e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR \u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u0012\u0004\b\u0011\u0010\rR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\tR\u0016\u0010\u0014\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\rR\u0016\u0010\u0017\u001a\u00020\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0019\u0010\rR\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\u00020\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR \u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0\u000f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u0012\u0004\b \u0010\r¨\u00067"}, d2 = {"Landroidx/room/RoomSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteQuery;", "Landroidx/sqlite/db/SupportSQLiteProgram;", "capacity", "", "(I)V", "<set-?>", "argCount", "getArgCount", "()I", "bindingTypes", "", "getBindingTypes$annotations", "()V", "blobBindings", "", "", "getBlobBindings$annotations", "[[B", "getCapacity", "doubleBindings", "", "getDoubleBindings$annotations", "longBindings", "", "getLongBindings$annotations", ChatMessage.TYPE_QUERY, "", "sql", "getSql", "()Ljava/lang/String;", "stringBindings", "getStringBindings$annotations", "[Ljava/lang/String;", "bindBlob", "", "index", EventBody.KEY_VALUE, "bindDouble", "", "bindLong", "", "bindNull", "bindString", "bindTo", "statement", "clearBindings", IslandSession.REOPEN_VALUE_CLOSE, "copyArgumentsFrom", "other", CommonConsts.APM_INNER_EVENT_COST_INIT, "initArgCount", "release", "Binding", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RoomSQLiteQuery implements SupportSQLiteProgram, SupportSQLiteQuery {
    private static final int BLOB = 5;
    public static final Companion Companion = null;
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = null;
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Binding;", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Binding {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\r\u0010\u0018\u001a\u00020\u0019H\u0000¢\u0006\u0002\b\u001aR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0002¨\u0006\u001b"}, d2 = {"Landroidx/room/RoomSQLiteQuery$Companion;", "", "()V", "BLOB", "", "DESIRED_POOL_SIZE", "getDESIRED_POOL_SIZE$annotations", "DOUBLE", "LONG", "NULL", "POOL_LIMIT", "getPOOL_LIMIT$annotations", "STRING", "queryPool", "Ljava/util/TreeMap;", "Landroidx/room/RoomSQLiteQuery;", "getQueryPool$annotations", "acquire", ChatMessage.TYPE_QUERY, "", "argumentCount", "copyFrom", "supportSQLiteQuery", "Landroidx/sqlite/db/SupportSQLiteQuery;", "prunePoolLocked", "", "prunePoolLocked$room_runtime_release", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        public static /* synthetic */ void getQueryPool$annotations() {
        }

        @JvmStatic
        public final RoomSQLiteQuery acquire(String r4, int r5) {
            Intrinsics.checkNotNullParameter(r4, ChatMessage.TYPE_QUERY);
            TreeMap<Integer, RoomSQLiteQuery> r3 = RoomSQLiteQuery.queryPool;
            monitor-enter(r3);
            Map.Entry<Integer, RoomSQLiteQuery> r0 = RoomSQLiteQuery.queryPool.ceilingEntry(Integer.valueOf(r5));     // Catch: Throwable -> L13
            if (r0 == null) goto L9;
            RoomSQLiteQuery.queryPool.remove(r0.getKey());     // Catch: Throwable -> L13
            RoomSQLiteQuery r1 = (RoomSQLiteQuery) ZeusTransformUtils.preCheckCast(r0.getValue(), RoomSQLiteQuery.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
            r1.init(r4, r5);     // Catch: Throwable -> L13
            Intrinsics.checkNotNullExpressionValue(r1, "sqliteQuery");     // Catch: Throwable -> L13
            monitor-exit(r3);
            return r1;
        L9:
            Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L13
            monitor-exit(r3);
            RoomSQLiteQuery r6 = new RoomSQLiteQuery(r5, null);
            r6.init(r4, r5);
            return r6;
        L13:
            th = move-exception;
            throw th;
        }

        @JvmStatic
        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r4) {
            SupportSQLiteQuery r5 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r4, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "supportSQLiteQuery");
            final RoomSQLiteQuery r3 = acquire(r5.getSql(), r5.getArgCount());
            r5.bindTo((SupportSQLiteProgram) ZeusTransformUtils.preCheckCast(new RoomSQLiteQuery$Companion$copyFrom$1(r3), SupportSQLiteProgram.class, "com.obric.memorydata.plugin"));
            return r3;
        }

        public final void prunePoolLocked$room_runtime_release() {
            if (RoomSQLiteQuery.queryPool.size() <= 15) goto L8;
            int r2 = RoomSQLiteQuery.queryPool.size() - 10;
            Iterator<Integer> r0 = RoomSQLiteQuery.queryPool.descendingKeySet().iterator();
            Intrinsics.checkNotNullExpressionValue(r0, "queryPool.descendingKeySet().iterator()");
        L5:
            int r1 = r2 - 1;
            if (r2 <= 0) goto L10;
            r0.next();
            r0.remove();
            r2 = r1;
            goto L5
        L10:
            return;
        }
    }

    static {
        Companion = new Companion(null);
        queryPool = new TreeMap();
    }

    private RoomSQLiteQuery(int r2) {
        this.capacity = r2;
        int r3 = r2 + 1;
        this.bindingTypes = new int[r3];
        this.longBindings = new long[r3];
        this.doubleBindings = new double[r3];
        this.stringBindings = new String[r3];
        this.blobBindings = new byte[r3][];
    }

    public /* synthetic */ RoomSQLiteQuery(int r1, DefaultConstructorMarker r2) {
        this(r1);
    }

    @JvmStatic
    public static final RoomSQLiteQuery acquire(String r1, int r2) {
        return Companion.acquire(r1, r2);
    }

    @JvmStatic
    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery r2) {
        SupportSQLiteQuery r3 = (SupportSQLiteQuery) ZeusTransformUtils.wrapperContextForParams(r2, SupportSQLiteQuery.class, "com.obric.memorydata.plugin");
        return Companion.copyFrom(r3);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    public static /* synthetic */ void getLongBindings$annotations() {
    }

    public static /* synthetic */ void getStringBindings$annotations() {
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindBlob(int r3, byte[] r4) {
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.bindingTypes[r3] = 5;
        this.blobBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindDouble(int r3, double r4) {
        this.bindingTypes[r3] = 3;
        this.doubleBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindLong(int r3, long r4) {
        this.bindingTypes[r3] = 2;
        this.longBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindNull(int r2) {
        this.bindingTypes[r2] = 1;
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void bindString(int r3, String r4) {
        Intrinsics.checkNotNullParameter(r4, EventBody.KEY_VALUE);
        this.bindingTypes[r3] = 4;
        this.stringBindings[r3] = r4;
    }

    @Override // androidx.sqlite.db.SupportSQLiteQuery
    public void bindTo(SupportSQLiteProgram r7) {
        SupportSQLiteProgram r8 = (SupportSQLiteProgram) ZeusTransformUtils.wrapperContextForParams(r7, SupportSQLiteProgram.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "statement");
        int r0 = getArgCount();
        if (1 > r0) goto L31;
        int r2 = 1;
    L5:
        int r3 = this.bindingTypes[r2];
        if (r3 != 1) goto L8;
        r8.bindNull(r2);
    L29:
        if (r2 == r0) goto L35;
        r2 = r2 + 1;
        goto L5
    L35:
        return;
    L8:
        if (r3 != 2) goto L10;
        r8.bindLong(r2, this.longBindings[r2]);
        goto L29
    L10:
        if (r3 != 3) goto L12;
        r8.bindDouble(r2, this.doubleBindings[r2]);
        goto L29
    L12:
        if (r3 != 4) goto L14;
        String r4 = this.stringBindings[r2];
        if (r4 == null) goto L25;
        r8.bindString(r2, r4);
        goto L29
    L25:
        throw new IllegalArgumentException("Required value was null.".toString());
    L14:
        if (r3 != 5) goto L29;
        byte[] r5 = this.blobBindings[r2];
        if (r5 == null) goto L20;
        r8.bindBlob(r2, r5);
        goto L29
    L20:
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    @Override // androidx.sqlite.db.SupportSQLiteProgram
    public void clearBindings() {
        Arrays.fill(this.bindingTypes, 1);
        Arrays.fill(this.stringBindings, null);
        Arrays.fill((Object[]) ZeusTransformUtils.preCheckCast(this.blobBindings, Object[].class, "com.obric.memorydata.plugin"), null);
        this.query = null;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery r5) {
        Intrinsics.checkNotNullParameter(r5, "other");
        int r0 = r5.getArgCount() + 1;
        System.arraycopy(r5.bindingTypes, 0, this.bindingTypes, 0, r0);
        System.arraycopy(r5.longBindings, 0, this.longBindings, 0, r0);
        System.arraycopy(r5.stringBindings, 0, this.stringBindings, 0, r0);
        System.arraycopy(r5.blobBindings, 0, this.blobBindings, 0, r0);
        System.arraycopy(r5.doubleBindings, 0, this.doubleBindings, 0, r0);
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
        String r1 = this.query;
        if (r1 == null) goto L6;
        return r1;
    L6:
        throw new IllegalStateException("Required value was null.".toString());
    }

    public final void init(String r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, ChatMessage.TYPE_QUERY);
        this.query = r2;
        this.argCount = r3;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> r0 = queryPool;
        monitor-enter(r0);
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(Integer.valueOf(this.capacity), this);     // Catch: Throwable -> L7
        Companion.prunePoolLocked$room_runtime_release();     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        monitor-exit(r0);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
