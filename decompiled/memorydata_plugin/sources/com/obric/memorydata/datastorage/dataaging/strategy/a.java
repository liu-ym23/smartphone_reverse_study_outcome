package com.obric.memorydata.datastorage.dataaging.strategy;

import com.obric.memorydata.datastorage.dataaging.strategy.b.b;
import com.obric.memorydata.datastorage.dataaging.strategy.d.c;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0003\u0018\u0000 92\u00020\u0001:\u00019BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0010\u0010\u0011J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0015J\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010 \u001a\u0004\u0018\u00010\u0017J\u001e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020&J.\u0010'\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,H\u0002J \u0010-\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020)2\u0006\u0010*\u001a\u00020\u0003H\u0002J&\u0010/\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,H\u0002J\u001e\u00100\u001a\u00020&2\u0006\u0010*\u001a\u00020\u00032\f\u0010+\u001a\b\u0012\u0004\u0012\u00020)0,H\u0002J \u00101\u001a\u00020&2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u00102\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0003H\u0002J\u0010\u00103\u001a\u00020&2\u0006\u0010*\u001a\u00020\u0003H\u0002J\b\u00104\u001a\u00020&H\u0002J!\u00105\u001a\u00020\u00032\u0012\u00106\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u000307\"\u00020\u0003H\u0002¢\u0006\u0002\u00108R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\u0019\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u001c0\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006:"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingStrategy;", "", "tableName", "", "autoIncrementPrimaryKeyName", "databaseWrapper", "Lcom/obric/memorydata/datastorage/dataaging/wrapper/intf/IDatabaseWrapper;", "executionMode", "Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingExecutionMode;", "timeAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;", "countAgingCheckpoint", "Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/CountAgingCheckpoint;", "baseWhereClause", "deleteHandler", "Lcom/obric/memorydata/datastorage/dataaging/strategy/handler/AgingDeleteHandler;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/memorydata/datastorage/dataaging/wrapper/intf/IDatabaseWrapper;Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingExecutionMode;Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/TimeAgingCheckpoint;Lcom/obric/memorydata/datastorage/dataaging/strategy/checkpoint/CountAgingCheckpoint;Ljava/lang/String;Lcom/obric/memorydata/datastorage/dataaging/strategy/handler/AgingDeleteHandler;)V", "timeStrategy", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ITimeAgingStrategy;", "countStrategy", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/ICountAgingStrategy;", "tableAgedCallback", "Lcom/obric/memorydata/datastorage/dataaging/strategy/callback/TableAgedCallback;", "excludedColumnWhereClause", "columnStrategyList", "", "Lkotlin/Triple;", "Lcom/obric/memorydata/datastorage/dataaging/strategy/intf/IAgingStrategy;", "setTimeStrategy", "setCountStrategy", "setTableAgedCallback", "callback", "addColumnStrategy", "columnName", "columnValue", "strategy", "execute", "", "executeConditionAndTimeAgingStrategy", "nowTimestamp", "", "whereClause", "handledPrimaryKeys", "", "executeCallbackOnlyTimeAging", "currentCutoff", "executeConditionAndCountAgingStrategy", "executeDeleteHandler", "executeCallbackOnlyCountAging", "overflowBoundaryPrimaryKey", "triggerTableAgingStart", "triggerTableAgedCallback", "combineWhereClauses", "clauses", "", "([Ljava/lang/String;)Ljava/lang/String;", "Companion", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0466a f9706a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f9707b;
    private final String c;
    private final com.obric.memorydata.datastorage.dataaging.a.a.a d;
    private final TableAgingExecutionMode e;
    private final b f;
    private final com.obric.memorydata.datastorage.dataaging.strategy.b.a g;
    private final String h;
    private final com.obric.memorydata.datastorage.dataaging.strategy.c.a i;
    private c j;
    private com.obric.memorydata.datastorage.dataaging.strategy.d.b k;
    private com.obric.memorydata.datastorage.dataaging.strategy.a.a l;
    private volatile String m;
    private final List<Triple<String, String, com.obric.memorydata.datastorage.dataaging.strategy.d.a>> n;

    /* JADX INFO: renamed from: com.obric.memorydata.datastorage.dataaging.strategy.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/datastorage/dataaging/strategy/TableAgingStrategy$Companion;", "", "<init>", "()V", "TAG", "", "AGING_BATCH_SIZE", "", "app_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0466a {
        private C0466a() {
        }

        public /* synthetic */ C0466a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9706a = new C0466a(null);
    }

    public a(String r3, String r4, com.obric.memorydata.datastorage.dataaging.a.a.a r5, TableAgingExecutionMode r6, b r7, com.obric.memorydata.datastorage.dataaging.strategy.b.a r8, String r9, com.obric.memorydata.datastorage.dataaging.strategy.c.a r10) {
        com.obric.memorydata.datastorage.dataaging.a.a.a r11 = (com.obric.memorydata.datastorage.dataaging.a.a.a) ZeusTransformUtils.wrapperContextForParams(r5, com.obric.memorydata.datastorage.dataaging.a.a.a.class, "com.obric.memorydata.plugin");
        b r12 = (b) ZeusTransformUtils.wrapperContextForParams(r7, b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r13 = (com.obric.memorydata.datastorage.dataaging.strategy.b.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.memorydata.datastorage.dataaging.strategy.b.a.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r14 = (com.obric.memorydata.datastorage.dataaging.strategy.c.a) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.datastorage.dataaging.strategy.c.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "tableName");
        Intrinsics.checkNotNullParameter(r4, "autoIncrementPrimaryKeyName");
        Intrinsics.checkNotNullParameter(r11, "databaseWrapper");
        Intrinsics.checkNotNullParameter(r6, "executionMode");
        Intrinsics.checkNotNullParameter(r9, "baseWhereClause");
        this.f9707b = r3;
        this.c = r4;
        this.d = r11;
        this.e = r6;
        this.f = r12;
        this.g = r13;
        this.h = r9;
        this.i = r14;
        this.m = "";
        this.n = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
    }

    private final String a(String... r12) {
        Collection r11 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        int r0 = r12.length;
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L12;
        String r4 = r12[r3];
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L7;
        boolean r5 = true;
    L8:
        if (r5 == false) goto L10;
        r11.add(r4);
    L10:
        r3 = r3 + 1;
        goto L3
    L7:
        r5 = false;
        goto L8
    L12:
        return CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r11, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin"), (CharSequence) ZeusTransformUtils.preCheckCast(" AND ", CharSequence.class, "com.obric.memorydata.plugin"), null, null, 0, null, $$Lambda$a$zTx5X7CFrF2WoAYma2eDWScgF7U.INSTANCE, 30, null);
    }

    private final void a(com.obric.memorydata.datastorage.dataaging.strategy.d.b r20, String r21, String r22) {
        com.obric.memorydata.datastorage.dataaging.strategy.d.b r2 = (com.obric.memorydata.datastorage.dataaging.strategy.d.b) ZeusTransformUtils.wrapperContextForParams(r20, com.obric.memorydata.datastorage.dataaging.strategy.d.b.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.b.a r4 = this.g;
        if (r4 == null) goto L22;
        Long r5 = StringsKt.toLongOrNull(r21);
        if (r5 == null) goto L20;
        long r6 = r5.longValue();
        long r7 = RangesKt.coerceAtLeast(r4.a(), 0);
        if (r6 > r7) goto L10;
        RunLog.INSTANCE.debug("TableAgingStrategy", "executeCallbackOnlyCountAging[" + this.f9707b + "] skip, currentBoundary=" + r6 + ", previousBoundary=" + r7);
        return;
    L10:
        int r11 = 0;
        String r3 = a(new String[]{r22, this.c + " > " + r7, r2.a(r21)});
        Long r17 = null;
    L11:
        List<Long> r1 = this.d.a(this.f9707b, this.c, r3, r17, 500);
        if (r1.isEmpty() == true) goto L13;
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r9 = this.l;
        if (r9 == null) goto L18;
        r9.a(r1);
    L18:
        r11 = r11 + r1.size();
        r17 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r1), Long.class, "com.obric.memorydata.plugin");
        goto L11
    L13:
        b();
        r4.a(r6);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TableAgingStrategy", "executeCallbackOnlyCountAging[" + this.f9707b + "] processed=" + r11 + ", primaryKeyWindow=(" + r7 + ',' + r6 + ']', false, 4, null);
        return;
    L20:
        throw new IllegalStateException(("Invalid count aging primary key: " + r21).toString());
    L22:
        throw new IllegalStateException("CALLBACK_ONLY count aging requires a count aging checkpoint".toString());
    }

    private final void a(com.obric.memorydata.datastorage.dataaging.strategy.d.b r10, String r11, Set<Long> r12) {
        com.obric.memorydata.datastorage.dataaging.strategy.d.b r13 = (com.obric.memorydata.datastorage.dataaging.strategy.d.b) ZeusTransformUtils.wrapperContextForParams(r10, com.obric.memorydata.datastorage.dataaging.strategy.d.b.class, "com.obric.memorydata.plugin");
        Set<Long> r14 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L28
        boolean r7 = true;
        String r4 = this.d.a(this.f9707b, this.c, r11, r13.a() + 1);     // Catch: Throwable -> L28
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).length() != 0) goto L7;
        boolean r5 = true;
    L9:
        if (r5 == false) goto L13;
        RunLog.INSTANCE.debug("TableAgingStrategy", "executeConditionAndCountAgingStrategy[" + this.f9707b + "] data count < max count. [" + r11 + ']');     // Catch: Throwable -> L28
        return;
    L13:
        if (this.e != TableAgingExecutionMode.CALLBACK_ONLY) goto L16;
        a(r13, r4, r11);     // Catch: Throwable -> L28
    L26:
        Object r15 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L28
    L30:
        Throwable r16 = Result.m1424exceptionOrNullimpl(r15);
        if (r16 == null) goto L35;
        RunLog.INSTANCE.error("TableAgingStrategy", "executeConditionAndCountAgingStrategy error[" + this.f9707b + "][" + r11 + ']', r16);
        return;
    L35:
        return;
    L16:
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r11, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L19;
        r7 = false;
    L19:
        if (r7 == false) goto L21;
        String r17 = r13.a(r4);     // Catch: Throwable -> L28
    L23:
        if (this.e != TableAgingExecutionMode.DELETE_HANDLER) goto L25;
        a(r17, r14);     // Catch: Throwable -> L28
        goto L26
    L25:
        a(r17);     // Catch: Throwable -> L28
        int r18 = this.d.a(this.f9707b, r17);     // Catch: Throwable -> L28
        b();     // Catch: Throwable -> L28
        RunLog.INSTANCE.debug("TableAgingStrategy", "executeConditionAndCountAgingStrategy[" + this.f9707b + "] try delete, count is " + r18 + ". [" + r17 + ']');     // Catch: Throwable -> L28
        goto L26
    L21:
        r17 = '(' + r11 + ") AND (" + r13.a(r4) + ')';     // Catch: Throwable -> L28
        goto L23
    L7:
        r5 = false;
    L28:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r15 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L30
    }

    private final void a(c r19, long r20, String r22) {
        c r3 = (c) ZeusTransformUtils.wrapperContextForParams(r19, c.class, "com.obric.memorydata.plugin");
        b r5 = this.f;
        if (r5 == null) goto L18;
        long r6 = RangesKt.coerceAtLeast(r5.a(), 0);
        if (r20 > r6) goto L8;
        RunLog.INSTANCE.debug("TableAgingStrategy", "executeCallbackOnlyTimeAging[" + this.f9707b + "] skip, currentCutoff=" + r20 + ", previousCutoff=" + r6);
        return;
    L8:
        int r10 = 0;
        String r4 = a(new String[]{r22, r3.b(r6), r3.a(r20)});
        Long r16 = null;
    L9:
        List<Long> r8 = this.d.a(this.f9707b, this.c, r4, r16, 500);
        if (r8.isEmpty() == true) goto L11;
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r11 = this.l;
        if (r11 == null) goto L16;
        r11.a(r8);
    L16:
        r10 = r10 + r8.size();
        r16 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r8), Long.class, "com.obric.memorydata.plugin");
        goto L9
    L11:
        b();
        r5.a(r20);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TableAgingStrategy", "executeCallbackOnlyTimeAging[" + this.f9707b + "] processed=" + r10 + ", window=[" + r6 + ',' + r20 + ')', false, 4, null);
        return;
    L18:
        throw new IllegalStateException("CALLBACK_ONLY requires a time aging checkpoint".toString());
    }

    private final void a(c r5, long r6, String r8, Set<Long> r9) {
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r5, c.class, "com.obric.memorydata.plugin");
        Set<Long> r10 = (Set) ZeusTransformUtils.wrapperContextForParams(r9, Set.class, "com.obric.memorydata.plugin");
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L12
        long r11 = r6 - r7.a();     // Catch: Throwable -> L12
        if (this.e != TableAgingExecutionMode.CALLBACK_ONLY) goto L6;
        a(r7, r11, r8);     // Catch: Throwable -> L12
    L10:
        Object r12 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L12
    L14:
        Throwable r13 = Result.m1424exceptionOrNullimpl(r12);
        if (r13 == null) goto L20;
        RunLog.INSTANCE.error("TableAgingStrategy", "executeConditionAndTimeAgingStrategy error[" + this.f9707b + "][" + r8 + ']', r13);
        return;
    L20:
        return;
    L6:
        String r14 = a(new String[]{r8, r7.a(r11)});     // Catch: Throwable -> L12
        if (this.e != TableAgingExecutionMode.DELETE_HANDLER) goto L9;
        a(r14, r10);     // Catch: Throwable -> L12
        goto L10
    L9:
        a(r14);     // Catch: Throwable -> L12
        int r15 = this.d.a(this.f9707b, r14);     // Catch: Throwable -> L12
        b();     // Catch: Throwable -> L12
        RunLog.INSTANCE.debug("TableAgingStrategy", "executeConditionAndTimeAgingStrategy[" + this.f9707b + "] try delete, count is " + r15 + ". [" + r14 + ']');     // Catch: Throwable -> L12
    L12:
        th = move-exception;
        Result.Companion r16 = Result.Companion;
        r12 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L14
    }

    private final void a(String r4) {
        List<Long> r5 = this.d.a(this.f9707b, this.c, r4);
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r3 = this.l;
        if (r3 == null) goto L6;
        r3.a(r5);
        return;
    }

    private final void a(String r11, Set<Long> r12) {
        Set r13 = (Set) ZeusTransformUtils.wrapperContextForParams(r12, Set.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.c.a r0 = this.i;
        if (r0 == null) goto L20;
        int r3 = 0;
        Long r8 = null;
    L5:
        List<Long> r2 = this.d.a(this.f9707b, this.c, r11, r8, 500);
        if (r2.isEmpty() == true) goto L17;
        Iterable r4 = (Iterable) ZeusTransformUtils.preCheckCast(r2, Iterable.class, "com.obric.memorydata.plugin");
        Collection r5 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r6 = r4.iterator();
    L9:
        if (r6.hasNext() == false) goto L13;
        Object r7 = r6.next();
        if (r13.add(Long.valueOf(((Number) ZeusTransformUtils.preCheckCast(r7, Number.class, "com.obric.memorydata.plugin")).longValue())) == false) goto L9;
        r5.add(r7);
        goto L9
    L13:
        List<Long> r9 = (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r9, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L16;
        r0.delete(r9);
        r3 = r3 + r9.size();
    L16:
        r8 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.last(r2), Long.class, "com.obric.memorydata.plugin");
        goto L5
    L17:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TableAgingStrategy", "executeDeleteHandler[" + this.f9707b + "] candidates=" + r3, false, 4, null);
        return;
    L20:
        throw new IllegalStateException("DELETE_HANDLER requires an AgingDeleteHandler".toString());
    }

    private static final CharSequence b(String r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast('(' + r2 + ')', CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final void b() {
        com.obric.memorydata.datastorage.dataaging.strategy.a.a r0 = this.l;
        if (r0 == null) goto L6;
        r0.a();
        return;
    }

    public static /* synthetic */ CharSequence lambda$zTx5X7CFrF2WoAYma2eDWScgF7U(String r0) {
        return b(r0);
    }

    public final a a(com.obric.memorydata.datastorage.dataaging.strategy.a.a r3) {
        this.l = (com.obric.memorydata.datastorage.dataaging.strategy.a.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.datastorage.dataaging.strategy.a.a.class, "com.obric.memorydata.plugin");
        return this;
    }

    public final a a(com.obric.memorydata.datastorage.dataaging.strategy.d.b r3) {
        com.obric.memorydata.datastorage.dataaging.strategy.d.b r4 = (com.obric.memorydata.datastorage.dataaging.strategy.d.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.datastorage.dataaging.strategy.d.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "countStrategy");
        if (this.e == TableAgingExecutionMode.CALLBACK_ONLY) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == false) goto L13;
        this.k = r4;
        return this;
    L13:
        throw new IllegalArgumentException("CALLBACK_ONLY count aging requires a count aging checkpoint".toString());
    L5:
        if (this.g != null) goto L8;
        r0 = false;
        goto L9
    }

    public final a a(c r3) {
        c r4 = (c) ZeusTransformUtils.wrapperContextForParams(r3, c.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "timeStrategy");
        this.j = r4;
        return this;
    }

    public final a a(String r6, String r7, com.obric.memorydata.datastorage.dataaging.strategy.d.a r8) {
        com.obric.memorydata.datastorage.dataaging.strategy.d.a r9 = (com.obric.memorydata.datastorage.dataaging.strategy.d.a) ZeusTransformUtils.wrapperContextForParams(r8, com.obric.memorydata.datastorage.dataaging.strategy.d.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "columnName");
        Intrinsics.checkNotNullParameter(r7, "columnValue");
        Intrinsics.checkNotNullParameter(r9, "strategy");
        boolean r3 = true;
        if (this.e != TableAgingExecutionMode.DELETE_ROWS) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        this.n.add(new Triple(r6, r7, r9));
        if (((CharSequence) ZeusTransformUtils.preCheckCast(this.m, CharSequence.class, "com.obric.memorydata.plugin")).length() == 0) goto L12;
        r3 = false;
    L12:
        if (r3 == false) goto L14;
        StringBuilder r1 = new StringBuilder();
        StringBuilder r10 = r1.append(r6).append(" != ").append(r7);
    L15:
        this.m = r10.toString();
        return this;
    L14:
        r1 = new StringBuilder();
        r10 = r1.append('(').append(this.m).append(") AND (").append(r6).append(" != ").append(r7).append(')');
        goto L15
    L18:
        throw new IllegalArgumentException((this.e + " does not support column aging").toString());
    L5:
        r0 = false;
        goto L6
    }

    public final void a() {
        long r6 = System.currentTimeMillis();
        Set<Long> r9 = (Set) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Set.class, "com.obric.memorydata.plugin");
        c r1 = this.j;
        if (r1 == null) goto L5;
        RunLog.INSTANCE.debug("TableAgingStrategy", this.f9707b + " timeStrategy start.");
        a(r1, r6, a(new String[]{this.h, this.m}), r9);
    L5:
        com.obric.memorydata.datastorage.dataaging.strategy.d.b r0 = this.k;
        if (r0 == null) goto L8;
        RunLog.INSTANCE.debug("TableAgingStrategy", this.f9707b + " countStrategy start.");
        a(r0, a(new String[]{this.h, this.m}), r9);
    L8:
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(this.n, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L10:
        if (r10.hasNext() == false) goto L17;
        Triple r2 = (Triple) ZeusTransformUtils.preCheckCast(r10.next(), Triple.class, "com.obric.memorydata.plugin");
        com.obric.memorydata.datastorage.dataaging.strategy.d.a r3 = (com.obric.memorydata.datastorage.dataaging.strategy.d.a) ZeusTransformUtils.preCheckCast(r2.getThird(), com.obric.memorydata.datastorage.dataaging.strategy.d.a.class, "com.obric.memorydata.plugin");
        String r4 = ((String) ZeusTransformUtils.preCheckCast(r2.getFirst(), String.class, "com.obric.memorydata.plugin")) + " == " + ((String) ZeusTransformUtils.preCheckCast(r2.getSecond(), String.class, "com.obric.memorydata.plugin"));
        if (ZeusTransformUtils.instanceOf(r3, c.class) == true) goto L13;
        if (ZeusTransformUtils.instanceOf(r3, com.obric.memorydata.datastorage.dataaging.strategy.d.b.class) == false) goto L10;
        RunLog.INSTANCE.debug("TableAgingStrategy", this.f9707b + " column[" + r4 + "] countStrategy start.");
        a((com.obric.memorydata.datastorage.dataaging.strategy.d.b) ZeusTransformUtils.preCheckCast(r3, com.obric.memorydata.datastorage.dataaging.strategy.d.b.class, "com.obric.memorydata.plugin"), r4, r9);
        goto L10
    L13:
        RunLog.INSTANCE.debug("TableAgingStrategy", this.f9707b + " column[" + r4 + "] timeStrategy start.");
        a((c) ZeusTransformUtils.preCheckCast(r3, c.class, "com.obric.memorydata.plugin"), r6, r4, r9);
        goto L10
    }
}
