package com.obric.memorydata.datastorage.dataaging.strategy.factory;

import androidx.sqlite.db.SupportSQLiteOpenHelper;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.datastorage.dataaging.strategy.TableAgingExecutionMode;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JÄ\u0001\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u00160\u00152 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\rJÄ\u0001\u0010%\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u00160\u00152 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\rJÐ\u0001\u0010&\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132 \b\u0002\u0010\u0014\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000f0\u00160\u00152 \b\u0002\u0010\u0017\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00110\u00160\u00152\b\b\u0002\u0010\u0018\u001a\u00020\r2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\b\b\u0002\u0010!\u001a\u00020\r2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010#2\b\b\u0002\u0010$\u001a\u00020\rH\u0002J\u0018\u0010)\u001a\u00020*2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u001a\u0010+\u001a\u00020,2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010$\u001a\u00020\rH\u0002J\u0018\u0010-\u001a\u00020.2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\rH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/factory/RoomDatabaseStrategyFactory;", "", "<init>", "()V", "globalRoomDatabaseWrapper", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/RoomDatabaseWrapper;", "personalRoomDatabaseWrapper", "globalVectorDatabaseWrapper", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/VectorDatabaseWrapper;", "personalVectorDatabaseWrapper", "createVectorTableStrategy", "Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingStrategy;", "tableName", "", "interval", "", "maxCount", "", "completionCallback", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "columnTimeStrategyList", "", "Lkotlin/Triple;", "columnCountStrategyList", "autoIncrementPrimaryKeyName", "databaseScope", "Lcom/obric/memorydata/datastorage/dataaging/strategy/factory/AgingDatabaseScope;", "executionMode", "Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingExecutionMode;", "timeAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;", "countAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/CountAgingCheckpoint;", "baseWhereClause", "deleteHandler", "Lcom/obric/memorydata/datastorage/dataaging/strategy/handler/AgingDeleteHandler;", "timeColumnName", "createTableStrategy", "createTableAgingStrategy", "haveVectorDb", "", "selectWrapper", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/intf/IDatabaseWrapper;", "createTimeAgingStrategy", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ITimeAgingStrategy;", "createCountAgingStrategy", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ICountAgingStrategy;", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9709a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final com.obric.memorydata.datastorage.dataaging.a.a f9710b = null;
    private static final com.obric.memorydata.datastorage.dataaging.a.a c = null;
    private static final com.obric.memorydata.datastorage.dataaging.a.b d = null;
    private static final com.obric.memorydata.datastorage.dataaging.a.b e = null;

    /* JADX INFO: renamed from: com.obric.memorydata.datastorage.dataaging.strategy.factory.a$a, reason: collision with other inner class name */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class C0467a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9711a = null;

        static {
            int[] r0 = new int[AgingDatabaseScope.values().length];
            r0[AgingDatabaseScope.GLOBAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r0[AgingDatabaseScope.PERSONAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f9711a = r0;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\t"}, d2 = {"com/obric/memorydata/datastorage/dataaging/strategy/factory/RoomDatabaseStrategyFactory$createCountAgingStrategy$1", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ICountAgingStrategy;", "maxCount", "", "getMaxCount", "()I", "getEarlierOrEqualThanWhereClauseByPrimaryKey", "", "primaryKey", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.datastorage.dataaging.strategy.d.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9712a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f9713b;

        b(int r1, String r2) {
            this.f9712a = r2;
            this.f9713b = r1;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.d.b
        public int a() {
            return this.f9713b;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.d.b
        public String a(String r2) {
            Intrinsics.checkNotNullParameter(r2, "primaryKey");
            return this.f9712a + " <= " + r2;
        }
    }

    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"com/obric/memorydata/datastorage/dataaging/strategy/factory/RoomDatabaseStrategyFactory$createTimeAgingStrategy$2", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ITimeAgingStrategy;", "interval", "", "getInterval", "()J", "getEarlierThanWhereClauseByTimestamp", "", "timestamp", "getLaterOrEqualThanWhereClauseByTimestamp", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.datastorage.dataaging.strategy.d.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f9714a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f9715b;

        c(long r1, String r3) {
            this.f9714a = r3;
            this.f9715b = r1;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.d.c
        public long a() {
            return this.f9715b;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.d.c
        public String a(long r2) {
            return this.f9714a + " < " + r2;
        }

        @Override // com.obric.memorydata.datastorage.dataaging.strategy.d.c
        public String b(long r2) {
            return this.f9714a + " >= " + r2;
        }
    }

    static {
        f9709a = new a();
        f9710b = new com.obric.memorydata.datastorage.dataaging.a.a($$Lambda$a$VnC0Q_Xc2vTJzAqCIYCBELzVwmA.INSTANCE);
        c = new com.obric.memorydata.datastorage.dataaging.a.a($$Lambda$a$03kii0nZvdYkwdHQBoPGmEydiCM.INSTANCE);
        d = new com.obric.memorydata.datastorage.dataaging.a.b($$Lambda$a$BfWTQjZdFPh9y83J0z1J04zCnQw.INSTANCE);
        e = new com.obric.memorydata.datastorage.dataaging.a.b($$Lambda$a$HITvohFb21xnQTYXA7vONEg7pw.INSTANCE);
    }

    private a() {
    }

    private static final SupportSQLiteOpenHelper a() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
    }

    private final com.obric.memorydata.datastorage.dataaging.a.a.a a(boolean r2, AgingDatabaseScope r3) {
        int r1 = C0467a.f9711a[r3.ordinal()];
        if (r1 != 1) goto L5;
        if (r2 == false) goto L14;
        com.obric.memorydata.datastorage.dataaging.a.b r4 = d;
    L13:
        com.obric.memorydata.datastorage.dataaging.a.a r5 = (com.obric.memorydata.datastorage.dataaging.a.a) ZeusTransformUtils.preCheckCast(r4, com.obric.memorydata.datastorage.dataaging.a.a.class, "com.obric.memorydata.plugin");
    L16:
        return (com.obric.memorydata.datastorage.dataaging.a.a.a) ZeusTransformUtils.preCheckCast(r5, com.obric.memorydata.datastorage.dataaging.a.a.a.class, "com.obric.memorydata.plugin");
    L14:
        r5 = f9710b;
        goto L16
    L5:
        if (r1 != 2) goto L10;
        if (r2 == false) goto L8;
        r4 = e;
        goto L13
    L8:
        r5 = c;
        goto L16
    L10:
        throw new NoWhenBranchMatchedException();
    }

    public static /* synthetic */ com.obric.memorydata.datastorage.dataaging.strategy.a a(a r25, String r26, long r27, int r29, com.obric.memorydata.datastorage.dataaging.strategy.a.a r30, List r31, List r32, String r33, AgingDatabaseScope r34, TableAgingExecutionMode r35, com.obric.memorydata.datastorage.dataaging.strategy.b.b r36, com.obric.memorydata.datastorage.dataaging.strategy.b.a r37, String r38, com.obric.memorydata.datastorage.dataaging.strategy.c.a r39, String r40, int r41, Object r42) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r1 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r30, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Long>> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Integer>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r5 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r36, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r6 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r37, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r2 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r39, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        if ((r41 & 8) == 0) goto L5;
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r14 = null;
    L7:
        if ((r41 & 16) == 0) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        List<Triple<String, String, Long>> r15 = r3;
        if ((r41 & 32) == 0) goto L12;
        r4 = CollectionsKt.emptyList();
    L12:
        List<Triple<String, String, Integer>> r16 = r4;
        if ((r41 & 64) == 0) goto L15;
        String r17 = OaidModel.KEY_ID;
    L17:
        if ((r41 & 128) == 0) goto L19;
        AgingDatabaseScope r18 = AgingDatabaseScope.GLOBAL;
    L21:
        if ((r41 & 256) == 0) goto L23;
        TableAgingExecutionMode r19 = TableAgingExecutionMode.DELETE_ROWS;
    L25:
        if ((r41 & 512) == 0) goto L27;
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r20 = null;
    L29:
        if ((r41 & 1024) == 0) goto L31;
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r21 = null;
    L33:
        if ((r41 & 2048) == 0) goto L35;
        String r22 = "";
    L37:
        if ((r41 & 4096) == 0) goto L39;
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r23 = null;
    L41:
        if ((r41 & 8192) == 0) goto L43;
        String r24 = "timestamp";
    L45:
        return r25.a(r26, r27, r29, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L43:
        r24 = r40;
        goto L45
    L39:
        r23 = r2;
        goto L41
    L35:
        r22 = r38;
        goto L37
    L31:
        r21 = r6;
        goto L33
    L27:
        r20 = r5;
        goto L29
    L23:
        r19 = r35;
        goto L25
    L19:
        r18 = r34;
        goto L21
    L15:
        r17 = r33;
        goto L17
    L5:
        r14 = r1;
        goto L7
    }

    static /* synthetic */ com.obric.memorydata.datastorage.dataaging.strategy.a a(a r26, String r27, long r28, int r30, com.obric.memorydata.datastorage.dataaging.strategy.a.a r31, List r32, List r33, String r34, boolean r35, AgingDatabaseScope r36, TableAgingExecutionMode r37, com.obric.memorydata.datastorage.dataaging.strategy.b.b r38, com.obric.memorydata.datastorage.dataaging.strategy.b.a r39, String r40, com.obric.memorydata.datastorage.dataaging.strategy.c.a r41, String r42, int r43, Object r44) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r1 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r31, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Long>> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Integer>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r33, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r5 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r38, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r6 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r39, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r2 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r41, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        if ((r43 & 8) == 0) goto L5;
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r14 = null;
    L7:
        if ((r43 & 16) == 0) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        List<Triple<String, String, Long>> r15 = r3;
        if ((r43 & 32) == 0) goto L12;
        r4 = CollectionsKt.emptyList();
    L12:
        List<Triple<String, String, Integer>> r16 = r4;
        if ((r43 & 64) == 0) goto L15;
        String r17 = OaidModel.KEY_ID;
    L17:
        if ((r43 & 128) == 0) goto L19;
        boolean r18 = false;
    L21:
        if ((r43 & 256) == 0) goto L23;
        AgingDatabaseScope r19 = AgingDatabaseScope.GLOBAL;
    L25:
        if ((r43 & 512) == 0) goto L27;
        TableAgingExecutionMode r20 = TableAgingExecutionMode.DELETE_ROWS;
    L29:
        if ((r43 & 1024) == 0) goto L31;
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r21 = null;
    L33:
        if ((r43 & 2048) == 0) goto L35;
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r22 = null;
    L37:
        if ((r43 & 4096) == 0) goto L39;
        String r23 = "";
    L41:
        if ((r43 & 8192) == 0) goto L43;
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r24 = null;
    L45:
        if ((r43 & 16384) == 0) goto L47;
        String r25 = "timestamp";
    L49:
        return r26.a(r27, r28, r30, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25);
    L47:
        r25 = r42;
        goto L49
    L43:
        r24 = r2;
        goto L45
    L39:
        r23 = r40;
        goto L41
    L35:
        r22 = r6;
        goto L37
    L31:
        r21 = r5;
        goto L33
    L27:
        r20 = r37;
        goto L29
    L23:
        r19 = r36;
        goto L25
    L19:
        r18 = r35;
        goto L21
    L15:
        r17 = r34;
        goto L17
    L5:
        r14 = r1;
        goto L7
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.a a(String r24, long r25, int r27, com.obric.memorydata.datastorage.dataaging.strategy.a.a r28, List<Triple<String, String, Long>> r29, List<Triple<String, String, Integer>> r30, String r31, boolean r32, AgingDatabaseScope r33, TableAgingExecutionMode r34, com.obric.memorydata.datastorage.dataaging.strategy.b.b r35, com.obric.memorydata.datastorage.dataaging.strategy.b.a r36, String r37, com.obric.memorydata.datastorage.dataaging.strategy.c.a r38, String r39) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r15 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r28, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List r12 = (List) ZeusTransformUtils.wrapperContextForParams(r29, List.class, "com.obric.memorydata.plugin");
        List r11 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r9 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r35, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r10 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r36, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r16 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r38, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        boolean r5 = false;
        if (r34 != TableAgingExecutionMode.CALLBACK_ONLY) goto L18;
        if (r15 != null) goto L6;
    L17:
        boolean r4 = false;
    L19:
        if (r4 == false) goto L48;
        if (r34 != TableAgingExecutionMode.DELETE_HANDLER) goto L27;
        if (r16 != null) goto L24;
    L28:
        if (r5 == false) goto L46;
        com.obric.memorydata.datastorage.dataaging.strategy.a r7 = new com.obric.memorydata.datastorage.dataaging.strategy.a(r24, r31, a(r32, r33), r34, r9, r10, r37, r16);
        if (r25 == 0) goto L32;
        r7.a(a(r25, r39));
    L32:
        if (r27 == 0) goto L34;
        r7.a(a(r27, r31));
    L34:
        if (r15 == null) goto L36;
        r7.a(r15);
    L36:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L38:
        if (r0.hasNext() == false) goto L40;
        Triple r2 = (Triple) ZeusTransformUtils.preCheckCast(r0.next(), Triple.class, "com.obric.memorydata.plugin");
        r7.a((String) ZeusTransformUtils.preCheckCast(r2.getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r2.getSecond(), String.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.datastorage.dataaging.strategy.d.a) ZeusTransformUtils.preCheckCast(a(f9709a, ((Number) ZeusTransformUtils.preCheckCast(r2.getThird(), Number.class, "com.obric.memorydata.plugin")).longValue(), null, 2, null), com.obric.memorydata.datastorage.dataaging.strategy.d.a.class, "com.obric.memorydata.plugin"));
        goto L38
    L40:
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r11, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L42:
        if (r1.hasNext() == false) goto L44;
        Triple r3 = (Triple) ZeusTransformUtils.preCheckCast(r1.next(), Triple.class, "com.obric.memorydata.plugin");
        r7.a((String) ZeusTransformUtils.preCheckCast(r3.getFirst(), String.class, "com.obric.memorydata.plugin"), (String) ZeusTransformUtils.preCheckCast(r3.getSecond(), String.class, "com.obric.memorydata.plugin"), (com.obric.memorydata.datastorage.dataaging.strategy.d.a) ZeusTransformUtils.preCheckCast(f9709a.a(((Number) ZeusTransformUtils.preCheckCast(r3.getThird(), Number.class, "com.obric.memorydata.plugin")).intValue(), r31), com.obric.memorydata.datastorage.dataaging.strategy.d.a.class, "com.obric.memorydata.plugin"));
        goto L42
    L44:
        return r7;
    L46:
        throw new IllegalArgumentException("DELETE_HANDLER requires a delete handler and does not support column aging".toString());
    L24:
        if (r12.isEmpty() == false) goto L28;
        if (r11.isEmpty() == false) goto L28;
    L27:
        r5 = true;
        goto L28
    L48:
        throw new IllegalArgumentException("CALLBACK_ONLY requires callback and matching time/count checkpoints, and does not support column aging".toString());
    L6:
        if (r25 > 0) goto L8;
        if (r27 <= 0) goto L17;
    L8:
        if (r25 == 0) goto L10;
        if (r9 == null) goto L17;
    L10:
        if (r27 == 0) goto L13;
        if (r10 == null) goto L17;
    L13:
        if (r12.isEmpty() == false) goto L17;
        if (r11.isEmpty() == false) goto L17;
    L18:
        r4 = true;
        goto L19
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.d.b a(int r1, String r2) {
        return (com.obric.memorydata.datastorage.dataaging.strategy.d.b) ZeusTransformUtils.preCheckCast(new b(r1, r2), com.obric.memorydata.datastorage.dataaging.strategy.d.b.class, "com.obric.memorydata.plugin");
    }

    private final com.obric.memorydata.datastorage.dataaging.strategy.d.c a(long r4, String r6) {
        if (new Regex("[A-Za-z_][A-Za-z0-9_]*").matches((CharSequence) ZeusTransformUtils.preCheckCast(r6, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L7;
        return (com.obric.memorydata.datastorage.dataaging.strategy.d.c) ZeusTransformUtils.preCheckCast(new c(r4, r6), com.obric.memorydata.datastorage.dataaging.strategy.d.c.class, "com.obric.memorydata.plugin");
    L7:
        throw new IllegalArgumentException(("Invalid time column name: " + r6).toString());
    }

    static /* synthetic */ com.obric.memorydata.datastorage.dataaging.strategy.d.c a(a r0, long r1, String r3, int r4, Object r5) {
        if ((r4 & 2) == 0) goto L6;
        r3 = "timestamp";
    L6:
        return r0.a(r1, r3);
    }

    private static final SupportSQLiteOpenHelper b() {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper();
    }

    public static /* synthetic */ com.obric.memorydata.datastorage.dataaging.strategy.a b(a r25, String r26, long r27, int r29, com.obric.memorydata.datastorage.dataaging.strategy.a.a r30, List r31, List r32, String r33, AgingDatabaseScope r34, TableAgingExecutionMode r35, com.obric.memorydata.datastorage.dataaging.strategy.b.b r36, com.obric.memorydata.datastorage.dataaging.strategy.b.a r37, String r38, com.obric.memorydata.datastorage.dataaging.strategy.c.a r39, String r40, int r41, Object r42) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r1 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r30, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Long>> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r31, List.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Integer>> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r32, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r5 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r36, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r6 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r37, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r2 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r39, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        if ((r41 & 8) == 0) goto L5;
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r14 = null;
    L7:
        if ((r41 & 16) == 0) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        List<Triple<String, String, Long>> r15 = r3;
        if ((r41 & 32) == 0) goto L12;
        r4 = CollectionsKt.emptyList();
    L12:
        List<Triple<String, String, Integer>> r16 = r4;
        if ((r41 & 64) == 0) goto L15;
        String r17 = OaidModel.KEY_ID;
    L17:
        if ((r41 & 128) == 0) goto L19;
        AgingDatabaseScope r18 = AgingDatabaseScope.GLOBAL;
    L21:
        if ((r41 & 256) == 0) goto L23;
        TableAgingExecutionMode r19 = TableAgingExecutionMode.DELETE_ROWS;
    L25:
        if ((r41 & 512) == 0) goto L27;
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r20 = null;
    L29:
        if ((r41 & 1024) == 0) goto L31;
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r21 = null;
    L33:
        if ((r41 & 2048) == 0) goto L35;
        String r22 = "";
    L37:
        if ((r41 & 4096) == 0) goto L39;
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r23 = null;
    L41:
        if ((r41 & 8192) == 0) goto L43;
        String r24 = "timestamp";
    L45:
        return r25.b(r26, r27, r29, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24);
    L43:
        r24 = r40;
        goto L45
    L39:
        r23 = r2;
        goto L41
    L35:
        r22 = r38;
        goto L37
    L31:
        r21 = r6;
        goto L33
    L27:
        r20 = r5;
        goto L29
    L23:
        r19 = r35;
        goto L25
    L19:
        r18 = r34;
        goto L21
    L15:
        r17 = r33;
        goto L17
    L5:
        r14 = r1;
        goto L7
    }

    private static final SupportSQLiteOpenHelper c() {
        return MemoryDbEngine.INSTANCE.getGlobalDbEngine().getOpenHelper();
    }

    private static final SupportSQLiteOpenHelper d() {
        return MemoryDbEngine.INSTANCE.getPersonalDbEngine().getOpenHelper();
    }

    public static /* synthetic */ SupportSQLiteOpenHelper lambda$03kii0nZvdYkwdHQBoPGmEydiCM() {
        return b();
    }

    public static /* synthetic */ SupportSQLiteOpenHelper lambda$BfWTQjZdFPh9y83J0z1J04zCnQw() {
        return c();
    }

    /* JADX INFO: renamed from: lambda$HITvohFb21xnQTYXA7vON-Eg7pw, reason: not valid java name */
    public static /* synthetic */ SupportSQLiteOpenHelper m594lambda$HITvohFb21xnQTYXA7vONEg7pw() {
        return d();
    }

    public static /* synthetic */ SupportSQLiteOpenHelper lambda$VnC0Q_Xc2vTJzAqCIYCBELzVwmA() {
        return a();
    }

    public final com.obric.memorydata.datastorage.dataaging.strategy.a a(String r19, long r20, int r22, com.obric.memorydata.datastorage.dataaging.strategy.a.a r23, List<Triple<String, String, Long>> r24, List<Triple<String, String, Integer>> r25, String r26, AgingDatabaseScope r27, TableAgingExecutionMode r28, com.obric.memorydata.datastorage.dataaging.strategy.b.b r29, com.obric.memorydata.datastorage.dataaging.strategy.b.a r30, String r31, com.obric.memorydata.datastorage.dataaging.strategy.c.a r32, String r33) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r5 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r23, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Long>> r15 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.memorydata.plugin");
        List<Triple<String, String, Integer>> r13 = (List) ZeusTransformUtils.wrapperContextForParams(r25, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r12 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r29, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r14 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r30, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r16 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r32, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "tableName");
        Intrinsics.checkNotNullParameter(r15, "columnTimeStrategyList");
        Intrinsics.checkNotNullParameter(r13, "columnCountStrategyList");
        Intrinsics.checkNotNullParameter(r26, "autoIncrementPrimaryKeyName");
        Intrinsics.checkNotNullParameter(r27, "databaseScope");
        Intrinsics.checkNotNullParameter(r28, "executionMode");
        Intrinsics.checkNotNullParameter(r31, "baseWhereClause");
        Intrinsics.checkNotNullParameter(r33, "timeColumnName");
        return a(r19, r20, r22, r5, r15, r13, r26, true, r27, r28, r12, r14, r31, r16, r33);
    }

    public final com.obric.memorydata.datastorage.dataaging.strategy.a b(String r21, long r22, int r24, com.obric.memorydata.datastorage.dataaging.strategy.a.a r25, List<Triple<String, String, Long>> r26, List<Triple<String, String, Integer>> r27, String r28, AgingDatabaseScope r29, TableAgingExecutionMode r30, com.obric.memorydata.datastorage.dataaging.strategy.b.b r31, com.obric.memorydata.datastorage.dataaging.strategy.b.a r32, String r33, com.obric.memorydata.datastorage.dataaging.strategy.c.a r34, String r35) {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r5 = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r25, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        List r15 = (List) ZeusTransformUtils.wrapperContextForParams(r26, List.class, "com.obric.memorydata.plugin");
        List r13 = (List) ZeusTransformUtils.wrapperContextForParams(r27, List.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.b r12 = (com.obric.memorydata.datastorage.dataaging.strategy.b.b) ZeusTransformUtils.wrapperContextForParams(r31, com.obric.memorydata.datastorage.dataaging.strategy.b.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r14 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r32, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r16 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r34, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r21, "tableName");
        Intrinsics.checkNotNullParameter(r15, "columnTimeStrategyList");
        Intrinsics.checkNotNullParameter(r13, "columnCountStrategyList");
        Intrinsics.checkNotNullParameter(r28, "autoIncrementPrimaryKeyName");
        Intrinsics.checkNotNullParameter(r29, "databaseScope");
        Intrinsics.checkNotNullParameter(r30, "executionMode");
        Intrinsics.checkNotNullParameter(r33, "baseWhereClause");
        Intrinsics.checkNotNullParameter(r35, "timeColumnName");
        return a(this, r21, r22, r24, r5, r15, r13, r28, false, r29, r30, r12, r14, r33, r16, r35, 128, null);
    }
}
