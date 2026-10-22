package com.obric.memorydata.memory.llm;

import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.api.IPersonalContextAPI;
import com.obric.memorydata.utils.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\rJ \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0012J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000b\u001a\u00020\u0005J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0005J$\u0010\u0018\u001a\u0004\u0018\u00010\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020\u00122\b\b\u0002\u0010\u001a\u001a\u00020\u0005J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001d\u001a\u00020\u0014H\u0002J\u0016\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001f2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u001f2\u0006\u0010\f\u001a\u00020\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ \u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050$0#2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b`\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/obric/memorydata/memory/llm/StreamSessionManager;", "", "<init>", "()V", "TAG", "", "sessionMap", "Ljava/util/HashMap;", "Lcom/obric/memorydata/memory/llm/Session;", "Lkotlin/collections/HashMap;", "createSession", ObricMemoryConstants.KEY_SESSION_ID, "memoryEntity", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "updateSession", "", IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT, "status", "Lcom/obric/memorydata/memory/llm/SessionStatus;", "finishSession", "", "stopSession", "checkAndRemoveSession", "getSession", "interruptSession", "sessionStatus", "resultStrMemory", "mapSessionStatusToDetailStatus", "", "clearExpiredSessions", "getContentFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getStatusFlow", "getSessionByEntity", "getKeyInfoMap", "", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f10296a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final HashMap<String, j> f10297b = null;

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f10298a = null;

        static {
            int[] r0 = new int[SessionStatus.values().length];
            r0[SessionStatus.COMPLETED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r0[SessionStatus.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r0[SessionStatus.ILLEGAL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r0[SessionStatus.INITIALIZED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r0[SessionStatus.STREAMING.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f10298a = r0;
        }
    }

    static {
        f10296a = new k();
        f10297b = new HashMap();
    }

    private k() {
    }

    private final int a(SessionStatus r4) {
        int r3 = a.f10298a[r4.ordinal()];
        if (r3 == 1) goto L15;
        if (r3 == 2) goto L18;
        if (r3 == 3) goto L16;
        if (r3 == 4) goto L17;
        if (r3 == 5) goto L17;
        throw new NoWhenBranchMatchedException();
    L17:
        return 1;
    L16:
        return 4;
    L18:
        return 3;
    L15:
        return 2;
    }

    public static /* synthetic */ j a(k r0, String r1, SessionStatus r2, String r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = "";
    L6:
        return r0.a(r1, r2, r3);
    }

    private final void a() {
        Collection<j> r2 = f10297b.values();
        final $$Lambda$k$jCsCWIpbOiHtSCg0JlzAlGRC_Nc r0 = $$Lambda$k$jCsCWIpbOiHtSCg0JlzAlGRC_Nc.INSTANCE;
        r2.removeIf(new $$Lambda$k$06LpyQT2w8kpt1Vpr3uXBLPHreE(r0));
    }

    private static final boolean a(j r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.h();
    }

    public static /* synthetic */ boolean a(k r0, String r1, String r2, SessionStatus r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L6;
        r3 = SessionStatus.STREAMING;
    L6:
        return r0.a(r1, r2, r3);
    }

    private static final boolean a(Function1 r2, Object r3) {
        return ((Boolean) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    }

    public static /* synthetic */ boolean lambda$06LpyQT2w8kpt1Vpr3uXBLPHreE(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    public static /* synthetic */ boolean lambda$jCsCWIpbOiHtSCg0JlzAlGRC_Nc(j r0) {
        return a(r0);
    }

    public final synchronized j a(MemoryEntity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "memoryEntity");     // Catch: Throwable -> L13
        Collection<j> r0 = f10297b.values();     // Catch: Throwable -> L13
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");     // Catch: Throwable -> L13
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L13
    L5:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();     // Catch: Throwable -> L13
        if (Intrinsics.areEqual(((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.memorydata.plugin")).f().getId(), r5.getId()) == false) goto L5;
    L10:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        monitor-exit(this);
        return r6;
    L9:
        r2 = null;
    L13:
        th = move-exception;
        throw th;
    }

    public final synchronized j a(String r16, MemoryEntity r17) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r16, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r17, "memoryEntity");     // Catch: Throwable -> L11
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Create session with sessionId " + r16 + '.', false, 4, null);     // Catch: Throwable -> L11
        HashMap<String, j> r13 = f10297b;     // Catch: Throwable -> L11
        if (r13.containsKey(r16) == false) goto L7;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Session with sessionId " + r16 + " already exists.", null, 4, null);     // Catch: Throwable -> L11
        j r0 = null;
    L8:
        f10296a.a();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r0;
    L7:
        j r14 = new j(r16, r17, null, null, null, null, null, 0, 252, null);     // Catch: Throwable -> L11
        ((Map) ZeusTransformUtils.preCheckCast(r13, Map.class, "com.obric.memorydata.plugin")).put(r16, r14);     // Catch: Throwable -> L11
        r0 = r14;
    L11:
        th = move-exception;
        throw th;
    }

    public final synchronized j a(String r11, SessionStatus r12, String r13) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r12, "sessionStatus");     // Catch: Throwable -> L17
        Intrinsics.checkNotNullParameter(r13, "resultStrMemory");     // Catch: Throwable -> L17
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Interrupt session with sessionId " + r11 + '.', false, 4, null);     // Catch: Throwable -> L17
        j r1 = null;
        if (at.a(r11) == false) goto L15;
        j r14 = (j) ZeusTransformUtils.preCheckCast(TypeIntrinsics.asMutableMap((Map) ZeusTransformUtils.preCheckCast(f10297b, Map.class, "com.obric.memorydata.plugin")).remove(r11), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r14 == null) goto L15;
        r14.a(r13);     // Catch: Throwable -> L17
        String r15 = r14.f().getId();     // Catch: Throwable -> L17
        Integer r0 = MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().queryDetailStatusByEpisodicId(r15);     // Catch: Throwable -> L17
        if (r0 != null) goto L11;
    L13:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Interrupt session skip detail_status update, entityId=" + r15 + ", current=" + r0 + ", status=" + r12, false, 4, null);     // Catch: Throwable -> L17
    L14:
        r1 = r14;
        goto L15
    L11:
        if (r0.intValue() != 1) goto L13;
        r14.a(r12);     // Catch: Throwable -> L17
        int r2 = f10296a.a(r12);     // Catch: Throwable -> L17
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Interrupt session write detail_status, entityId=" + r15 + ", current=" + r0 + ", target=" + r2 + ", status=" + r12 + ", updateCount=" + MemoryDbEngine.INSTANCE.getPersonalDbEngine().getProactiveEpisodicRelevantDataDao().updateDetailStatusByEpisodicId(r15, r2), false, 4, null);     // Catch: Throwable -> L17
    L15:
        monitor-exit(this);
        return r1;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L10
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Finish session with sessionId " + r8 + '.', false, 4, null);     // Catch: Throwable -> L10
        if (f10297b.containsKey(r8) == false) goto L8;
        j r9 = d(r8);     // Catch: Throwable -> L10
        if (r9 == null) goto L8;
        String r0 = r9.e();     // Catch: Throwable -> L10
        r9.a(r0, SessionStatus.COMPLETED, true);     // Catch: Throwable -> L10
        r9.f().setDetail(r0);     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean a(String r7, String r8, SessionStatus r9) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r7, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r8, IPersonalContextAPI.DEEP_SEARCH_CONTENT_TYPE_TEXT);     // Catch: Throwable -> L10
        Intrinsics.checkNotNullParameter(r9, "status");     // Catch: Throwable -> L10
        j r0 = (j) ZeusTransformUtils.preCheckCast(f10297b.get(r7), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L10
        if (r0 == null) goto L7;
        j.a(r0, r8, r9, false, 4, null);     // Catch: Throwable -> L10
        boolean r10 = true;
    L8:
        monitor-exit(this);
        return r10;
    L7:
        r10 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public final synchronized Map<String, List<String>> b(MemoryEntity r5) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r5, "memoryEntity");     // Catch: Throwable -> L17
        Collection<j> r0 = f10297b.values();     // Catch: Throwable -> L17
        Intrinsics.checkNotNullExpressionValue(r0, "<get-values>(...)");     // Catch: Throwable -> L17
        Iterator r1 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L17
    L5:
        if (r1.hasNext() == false) goto L9;
        Object r2 = r1.next();     // Catch: Throwable -> L17
        if (Intrinsics.areEqual(((j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.memorydata.plugin")).f().getId(), r5.getId()) == false) goto L5;
    L10:
        j r6 = (j) ZeusTransformUtils.preCheckCast(r2, j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        if (r6 == null) goto L14;
        Map<String, List<String>> r7 = r6.a();     // Catch: Throwable -> L17
        if (r7 == null) goto L14;
    L15:
        monitor-exit(this);
        return r7;
    L14:
        r7 = MapsKt.emptyMap();     // Catch: Throwable -> L17
        goto L15
    L9:
        r2 = null;
    L17:
        th = move-exception;
        throw th;
    }

    public final synchronized void b(String r8) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r8, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L6
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Stop session with sessionId " + r8 + '.', false, 4, null);     // Catch: Throwable -> L6
        a(r8);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public final synchronized boolean c(String r11) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r11, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L23
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Check and remove session with sessionId " + r11 + '.', false, 4, null);     // Catch: Throwable -> L23
        HashMap<String, j> r0 = f10297b;     // Catch: Throwable -> L23
        boolean r2 = false;
        if (r0.containsKey(r11) == false) goto L20;
        j r1 = d(r11);     // Catch: Throwable -> L23
        if (r1 == null) goto L8;
        SessionStatus r3 = r1.g();     // Catch: Throwable -> L23
    L10:
        if (r3 != SessionStatus.COMPLETED) goto L12;
    L19:
        r0.remove(r11);     // Catch: Throwable -> L23
        r2 = true;
    L21:
        monitor-exit(this);
        return r2;
    L12:
        if (r3 == SessionStatus.FAILED) goto L19;
        if (r3 == SessionStatus.ILLEGAL) goto L19;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Session with sessionId " + r11 + " is not completed. " + r3, null, 4, null);     // Catch: Throwable -> L23
        j r4 = d(r11);     // Catch: Throwable -> L23
        if (r4 == null) goto L18;
        r4.a(SessionStatus.FAILED);     // Catch: Throwable -> L23
    L18:
        r0.remove(r11);     // Catch: Throwable -> L23
        goto L21
    L8:
        r3 = null;
        goto L10
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "StreamSessionManager", "Session with sessionId " + r11 + " not found.", null, 4, null);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    public final synchronized j d(String r3) {
        monitor-enter(this);
        Intrinsics.checkNotNullParameter(r3, ObricMemoryConstants.KEY_SESSION_ID);     // Catch: Throwable -> L6
        j r4 = (j) ZeusTransformUtils.preCheckCast(f10297b.get(r3), j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L6
        monitor-exit(this);
        return r4;
    L6:
        th = move-exception;
        throw th;
    }
}
