package com.obric.memorydata.memory.llm;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.InfoCommonMemoryEntity;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.ChatMessage;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b2\b\u0086\b\u0018\u00002\u00020\u0001B»\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u00104\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00106\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010;\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÂ\u0003J\u0010\u0010<\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u0010\u0010?\u001a\u0004\u0018\u00010\u000eHÆ\u0003¢\u0006\u0002\u0010$J\u000b\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010A\u001a\u00020\u0014HÆ\u0003J\t\u0010B\u001a\u00020\u0016HÆ\u0003J\t\u0010C\u001a\u00020\u0018HÆ\u0003JÎ\u0001\u0010D\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0018HÆ\u0001¢\u0006\u0002\u0010EJ\u0013\u0010F\u001a\u00020\u00162\b\u0010G\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010H\u001a\u00020\u000eHÖ\u0001J\t\u0010I\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001cR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001cR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001cR\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b#\u0010$R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b'\u0010$R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u000e¢\u0006\n\n\u0002\u0010%\u001a\u0004\b(\u0010$R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001d\u00100\u001a\u0004\u0018\u00010\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b1\u0010\u001c¨\u0006J"}, d2 = {"Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;", "", ChatMessage.TYPE_QUERY, "", "screenshotPath", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "activityName", "chatHistory", "_refMemoryEntities", "", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "subIntent", "", "screenshotTosKey", "screenshotType", "memoryProductType", "logId", "logContext", "Lcom/obric/memorydata/middleware/api/logging/LogContext;", "enableStream", "", "currentTimeMillis", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/logging/LogContext;ZJ)V", "getQuery", "()Ljava/lang/String;", "getScreenshotPath", "getText", "getAppName", "getPackageName", "getActivityName", "getChatHistory", "getSubIntent", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScreenshotTosKey", "getScreenshotType", "getMemoryProductType", "getLogId", "getLogContext", "()Lcom/obric/memorydata/middleware/api/logging/LogContext;", "getEnableStream", "()Z", "getCurrentTimeMillis", "()J", "refMemoryEntities", "getRefMemoryEntities", "refMemoryEntities$delegate", "Lkotlin/Lazy;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Lcom/obric/memorydata/middleware/api/logging/LogContext;ZJ)Lcom/obric/memorydata/memory/llm/MemoryLLMBuildInputData;", "equals", "other", "hashCode", "toString", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f10281a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f10282b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final List<MemoryEntity> h;
    private final Integer i;
    private final String j;
    private final Integer k;
    private final Integer l;
    private final String m;
    private final com.obric.memorydata.middleware.api.logging.e n;
    private final boolean o;
    private final long p;
    private final Lazy q;

    public e(String r6, String r7, String r8, String r9, String r10, String r11, String r12, List<? extends MemoryEntity> r13, Integer r14, String r15, Integer r16, Integer r17, String r18, com.obric.memorydata.middleware.api.logging.e r19, boolean r20, long r21) {
        List<MemoryEntity> r2 = (List) ZeusTransformUtils.wrapperContextForParams(r13, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r19, "logContext");
        this.f10281a = r6;
        this.f10282b = r7;
        this.c = r8;
        this.d = r9;
        this.e = r10;
        this.f = r11;
        this.g = r12;
        this.h = r2;
        this.i = r14;
        this.j = r15;
        this.k = r16;
        this.l = r17;
        this.m = r18;
        this.n = r19;
        this.o = r20;
        this.p = r21;
        this.q = LazyKt.lazy(LazyThreadSafetyMode.NONE, new $$Lambda$e$RPNPh4lqkZWJPyQhyfNXi8FtdU(this));
    }

    public /* synthetic */ e(String r23, String r24, String r25, String r26, String r27, String r28, String r29, List r30, Integer r31, String r32, Integer r33, Integer r34, String r35, com.obric.memorydata.middleware.api.logging.e r36, boolean r37, long r38, int r40, DefaultConstructorMarker r41) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r30, List.class, "com.obric.memorydata.plugin");
        if ((r40 & 64) == 0) goto L5;
        String r11 = null;
    L7:
        if ((r40 & 128) == 0) goto L9;
        List r12 = null;
    L11:
        if ((r40 & 256) == 0) goto L13;
        Integer r13 = 0;
    L15:
        if ((r40 & 512) == 0) goto L17;
        String r14 = null;
    L19:
        if ((r40 & 1024) == 0) goto L21;
        Integer r15 = null;
    L23:
        if ((r40 & 2048) == 0) goto L25;
        Integer r16 = null;
    L27:
        if ((r40 & 4096) == 0) goto L29;
        String r17 = null;
    L31:
        if ((r40 & 8192) == 0) goto L33;
        com.obric.memorydata.middleware.api.logging.e r18 = new com.obric.memorydata.middleware.api.logging.e(null, null, null, 7, null);
    L35:
        if ((r40 & 16384) == 0) goto L37;
        boolean r19 = false;
    L39:
        if ((r40 & 32768) == 0) goto L41;
        long r20 = System.currentTimeMillis();
    L42:
        this(r23, r24, r25, r26, r27, r28, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20);
        return;
    L41:
        r20 = r38;
        goto L42
    L37:
        r19 = r37;
        goto L39
    L33:
        r18 = r36;
        goto L35
    L29:
        r17 = r35;
        goto L31
    L25:
        r16 = r34;
        goto L27
    L21:
        r15 = r33;
        goto L23
    L17:
        r14 = r32;
        goto L19
    L13:
        r13 = r31;
        goto L15
    L9:
        r12 = r1;
        goto L11
    L5:
        r11 = r29;
        goto L7
    }

    private static final String a(e r8) {
        List<MemoryEntity> r9 = r8.h;
        if (r9 == null) goto L27;
        Iterable r10 = (Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin");     // Catch: JsonIOException -> L16
        Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.memorydata.plugin");     // Catch: JsonIOException -> L16
        Iterator r11 = r10.iterator();     // Catch: JsonIOException -> L16
    L6:
        if (r11.hasNext() == false) goto L10;
        Object r3 = r11.next();     // Catch: JsonIOException -> L16
        if (ZeusTransformUtils.instanceOf(r3, InfoCommonMemoryEntity.class) == false) goto L6;
        r2.add(r3);     // Catch: JsonIOException -> L16
        goto L6
    L10:
        Iterable r12 = (Iterable) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.memorydata.plugin"), Iterable.class, "com.obric.memorydata.plugin");     // Catch: JsonIOException -> L16
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(CollectionsKt.collectionSizeOrDefault(r12, 10)), Collection.class, "com.obric.memorydata.plugin");     // Catch: JsonIOException -> L16
        Iterator r13 = r12.iterator();     // Catch: JsonIOException -> L16
    L12:
        if (r13.hasNext() == false) goto L14;
        r4.add(com.obric.memorydata.memory.bridge.a.a((InfoCommonMemoryEntity) ZeusTransformUtils.preCheckCast(r13.next(), InfoCommonMemoryEntity.class, "com.obric.memorydata.plugin")));     // Catch: JsonIOException -> L16
        goto L12
    L14:
        List r14 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.memorydata.plugin");     // Catch: JsonIOException -> L16
        return new Gson().toJson(r14);
    L16:
        e = move-exception;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "refMemoryEntities build json error", e.toString(), null, 4, null);
        return null;
    L27:
        return null;
    }

    /* JADX INFO: renamed from: lambda$-RPNPh4lqkZWJPyQhyfNXi8FtdU, reason: not valid java name */
    public static /* synthetic */ String m737lambda$RPNPh4lqkZWJPyQhyfNXi8FtdU(e r0) {
        return a(r0);
    }

    public final String a() {
        return this.f10281a;
    }

    public final String b() {
        return this.f10282b;
    }

    public final String c() {
        return this.c;
    }

    public final String d() {
        return this.d;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object r7) {
        if (this != r7) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r7, e.class) == true) goto L8;
        return false;
    L8:
        e r8 = (e) ZeusTransformUtils.preCheckCast(r7, e.class, "com.obric.memorydata.plugin");
        if (Intrinsics.areEqual(this.f10281a, r8.f10281a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f10282b, r8.f10282b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r8.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r8.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r8.e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f, r8.f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.g, r8.g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.h, r8.h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.i, r8.i) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.j, r8.j) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.k, r8.k) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.l, r8.l) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.m, r8.m) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.n, r8.n) == true) goto L51;
        return false;
    L51:
        if (this.o == r8.o) goto L54;
        return false;
    L54:
        if (this.p == r8.p) goto L56;
        return false;
    L56:
        return true;
    }

    public final String f() {
        return this.f;
    }

    public final String g() {
        return this.g;
    }

    public final Integer h() {
        return this.i;
    }

    public int hashCode() {
        String r0 = this.f10281a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.f10282b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.c;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.d;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.e;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.f;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.g;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<MemoryEntity> r22 = this.h;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.i;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        String r28 = this.j;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Integer r31 = this.k;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.l;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        String r37 = this.m;
        if (r37 == null) goto L55;
        r1 = r37.hashCode();
    L55:
        return ((((((r36 + r1) * 31) + this.n.hashCode()) * 31) + Boolean.hashCode(this.o)) * 31) + Long.hashCode(this.p);
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public final String i() {
        return this.j;
    }

    public final Integer j() {
        return this.k;
    }

    public final Integer k() {
        return this.l;
    }

    public final String l() {
        return this.m;
    }

    public final com.obric.memorydata.middleware.api.logging.e m() {
        return this.n;
    }

    public final boolean n() {
        return this.o;
    }

    public final long o() {
        return this.p;
    }

    public final String p() {
        return (String) ZeusTransformUtils.preCheckCast(this.q.getValue(), String.class, "com.obric.memorydata.plugin");
    }

    public String toString() {
        StringBuilder r0 = new StringBuilder();
        r0.append("MemoryLLMBuildInputData(query=").append(this.f10281a).append(", screenshotPath=").append(this.f10282b).append(", text=").append(this.c).append(", appName=").append(this.d).append(", packageName=").append(this.e).append(", activityName=").append(this.f).append(", chatHistory=").append(this.g).append(", _refMemoryEntities=").append(this.h).append(", subIntent=").append(this.i).append(", screenshotTosKey=").append(this.j).append(", screenshotType=").append(this.k).append(", memoryProductType=");
        r0.append(this.l).append(", logId=").append(this.m).append(", logContext=").append(this.n).append(", enableStream=").append(this.o).append(", currentTimeMillis=").append(this.p).append(')');
        return r0.toString();
    }
}
