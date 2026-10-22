package com.obric.memorydata.memory.utils;

import com.obric.memorydata.memory.lab.AILabCheckPermissionTask;
import com.obric.memorydata.memory.ui.list.PendingPersonalInfoNotificationTask;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001:\u0001*B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J$\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00150\u0014J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0003J\u0016\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u0003J0\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001c2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001e\u0012\u0004\u0012\u00020\u00150\u0014J&\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0017J\u001e\u0010$\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%J*\u0010'\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010(\u001a\u00020%2\b\u0010)\u001a\u0004\u0018\u00010\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00030\tX\u0082\u0004¢\u0006\u0002\n\u0000R6\u0010\u000b\u001a*\u0012\u0004\u0012\u00020\n\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\fj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r`\u000e0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/obric/memorydata/memory/utils/PendingShortcutRequests;", "", "initialGeneration", "", "maxTombstonesPerShortcut", "", "<init>", "(JI)V", "activeGenerations", "", "", "tombstones", "Ljava/util/LinkedHashMap;", "Lcom/obric/memorydata/memory/utils/PendingShortcutRequests$Tombstone;", "Lkotlin/collections/LinkedHashMap;", "nextGeneration", "begin", "Lcom/obric/memorydata/memory/utils/PendingShortcutRequest;", "shortcutId", "onGenerationStarted", "Lkotlin/Function1;", "", "completeFromFallback", "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalAction;", PendingPersonalInfoNotificationTask.KEY_GENERATION, "completeFromSystemCallback", "supersede", "provenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "onGenerationsSuperseded", "", "confirmDispatch", "Lcom/obric/memorydata/memory/utils/PinShortcutConfirmedDispatch;", AILabCheckPermissionTask.KEY_SOURCE, "Lcom/obric/memorydata/memory/utils/PinShortcutTerminalSource;", "proposedAction", "onRequestResult", "", "accepted", "putTombstoneLocked", "systemCallbackObserved", "supersedeProvenance", "Tombstone", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f11541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<String, Long> f11542b;
    private final Map<String, LinkedHashMap<Long, a>> c;
    private long d;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u001f\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/memory/utils/PendingShortcutRequests$Tombstone;", "", "systemCallbackObserved", "", "supersedeProvenance", "Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "<init>", "(ZLcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;)V", "getSystemCallbackObserved", "()Z", "setSystemCallbackObserved", "(Z)V", "getSupersedeProvenance", "()Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;", "setSupersedeProvenance", "(Lcom/obric/memorydata/memory/utils/PinShortcutSupersedeProvenance;)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f11543a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private PinShortcutSupersedeProvenance f11544b;

        public a(boolean r1, PinShortcutSupersedeProvenance r2) {
            this.f11543a = r1;
            this.f11544b = r2;
        }

        public final void a(PinShortcutSupersedeProvenance r1) {
            this.f11544b = r1;
        }

        public final void a(boolean r1) {
            this.f11543a = r1;
        }

        public final boolean a() {
            return this.f11543a;
        }

        public final PinShortcutSupersedeProvenance b() {
            return this.f11544b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (this.f11543a == r6.f11543a) goto L12;
            return false;
        L12:
            if (this.f11544b == r6.f11544b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = Boolean.hashCode(this.f11543a) * 31;
            PinShortcutSupersedeProvenance r1 = this.f11544b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Tombstone(systemCallbackObserved=" + this.f11543a + ", supersedeProvenance=" + this.f11544b + ')';
        }
    }

    public h() {
        this(0, 0, 3, null);
    }

    public h(long r3, int r5) {
        this.f11541a = r5;
        this.f11542b = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
        this.d = r3;
    }

    public /* synthetic */ h(long r1, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = System.nanoTime();
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = 16;
    L8:
        this(r1, r3);
    }

    private final void a(String r3, long r4, boolean r6, PinShortcutSupersedeProvenance r7) {
        Map<String, LinkedHashMap<Long, a>> r0 = this.c;
        LinkedHashMap<Long, a> r1 = r0.get(r3);
        if (r1 != null) goto L5;
        r1 = new LinkedHashMap();
        r0.put(r3, r1);
    L5:
        LinkedHashMap r5 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(r1, LinkedHashMap.class, "com.obric.memorydata.plugin");
        Long r8 = Long.valueOf(r4);
        ((Map) ZeusTransformUtils.preCheckCast(r5, Map.class, "com.obric.memorydata.plugin")).put(r8, new a(r6, r7));
    L7:
        if (r5.size() <= this.f11541a) goto L11;
        Set r9 = r5.keySet();
        Intrinsics.checkNotNullExpressionValue(r9, "<get-keys>(...)");
        Long r10 = (Long) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull((Iterable) ZeusTransformUtils.preCheckCast(r9, Iterable.class, "com.obric.memorydata.plugin")), Long.class, "com.obric.memorydata.plugin");
        if (r10 == null) goto L14;
        r5.remove(Long.valueOf(r10.longValue()));
        goto L7
    L14:
        return;
    }

    public final PinShortcutTerminalAction a(String r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "shortcutId");
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.f11542b.get(r9), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L13
        if (r1 != null) goto L8;
    L9:
        PinShortcutTerminalAction r8 = PinShortcutTerminalAction.IGNORE;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);
        return r8;
    L8:
        if (r1.longValue() != r10) goto L9;
        this.f11542b.remove(r9);     // Catch: Throwable -> L13
        a(r9, r10, false, null);     // Catch: Throwable -> L13
        r8 = PinShortcutTerminalAction.DELIVER_UI_COMPLETION;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    public final g a(String r6, Function1<? super Long, Unit> r7) {
        Function1 r8 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r6, "shortcutId");
        Intrinsics.checkNotNullParameter(r8, "onGenerationStarted");
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.f11542b.get(r6), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 == null) goto L7;
        g r9 = new g(((Number) ZeusTransformUtils.preCheckCast(r1, Number.class, "com.obric.memorydata.plugin")).longValue(), false);     // Catch: Throwable -> L15
    L10:
        monitor-exit(r0);
        return r9;
    L7:
        long r2 = this.d + 1;     // Catch: Throwable -> L15
        this.d = r2;     // Catch: Throwable -> L15
        Long r3 = Long.valueOf(r2);     // Catch: Throwable -> L15
        this.f11542b.put(r6, r3);     // Catch: Throwable -> L15
        r8.invoke(Long.valueOf(r2));     // Catch: Throwable -> L12
        r9 = new g(r2, true);     // Catch: Throwable -> L15
        goto L10
    L12:
        th = move-exception;
        this.f11542b.remove(r6);     // Catch: Throwable -> L15
        throw th;     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    }

    public final i a(String r3, long r4, PinShortcutTerminalSource r6, PinShortcutTerminalAction r7) {
        Intrinsics.checkNotNullParameter(r3, "shortcutId");
        Intrinsics.checkNotNullParameter(r6, AILabCheckPermissionTask.KEY_SOURCE);
        Intrinsics.checkNotNullParameter(r7, "proposedAction");
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        LinkedHashMap r2 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.c.get(r3), LinkedHashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r2 == null) goto L17;
        a r5 = (a) ZeusTransformUtils.preCheckCast(r2.get(Long.valueOf(r4)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L20
        if (r5 == null) goto L17;
        PinShortcutSupersedeProvenance r8 = r5.b();     // Catch: Throwable -> L20
        if (r8 != null) goto L13;
        i r9 = new i(r7, null, 2, null);     // Catch: Throwable -> L20
    L18:
        monitor-exit(r0);
        return r9;
    L13:
        if (r6 != PinShortcutTerminalSource.SYSTEM_CALLBACK) goto L15;
        i r10 = new i(PinShortcutTerminalAction.RECONCILE_OFF, r8);     // Catch: Throwable -> L20
    L16:
        r9 = r10;
        goto L18
    L15:
        r10 = new i(PinShortcutTerminalAction.IGNORE, r8);     // Catch: Throwable -> L20
    L17:
        r9 = new i(PinShortcutTerminalAction.IGNORE, null, 2, null);     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        throw th;
    }

    public final void a(String r10, PinShortcutSupersedeProvenance r11, Function1<? super Set<Long>, Unit> r12) {
        Function1 r13 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r10, "shortcutId");
        Intrinsics.checkNotNullParameter(r11, "provenance");
        Intrinsics.checkNotNullParameter(r13, "onGenerationsSuperseded");
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        LinkedHashSet r1 = new LinkedHashSet();     // Catch: Throwable -> L21
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(this.f11542b.remove(r10), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r2 == null) goto L7;
        long r5 = ((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L21
        r1.add(Long.valueOf(r5));     // Catch: Throwable -> L21
        a(r10, r5, false, r11);     // Catch: Throwable -> L21
    L7:
        LinkedHashMap r9 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.c.get(r10), LinkedHashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r9 == null) goto L18;
        Iterator r14 = ((Map) ZeusTransformUtils.preCheckCast(r9, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();     // Catch: Throwable -> L21
    L11:
        if (r14.hasNext() == false) goto L18;
        Map.Entry r15 = (Map.Entry) ZeusTransformUtils.preCheckCast(r14.next(), Map.Entry.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        long r3 = ((Number) ZeusTransformUtils.preCheckCast(r15.getKey(), Number.class, "com.obric.memorydata.plugin")).longValue();     // Catch: Throwable -> L21
        a r16 = (a) ZeusTransformUtils.preCheckCast(r15.getValue(), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        if (r16.b() != null) goto L15;
    L16:
        r16.a(r11);     // Catch: Throwable -> L21
    L17:
        r1.add(Long.valueOf(r3));     // Catch: Throwable -> L21
        goto L11
    L15:
        if (r11 != PinShortcutSupersedeProvenance.USER_DISABLE) goto L17;
    L18:
        r13.invoke(r1);     // Catch: Throwable -> L21
        Unit r17 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public final boolean a(String r5, long r6, boolean r8) {
        Intrinsics.checkNotNullParameter(r5, "shortcutId");
        if (r8 == true) goto L18;
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.f11542b.get(r5), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L15
        if (r1 != null) goto L10;
    L12:
        Unit r4 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);
        goto L18
    L10:
        if (r1.longValue() != r6) goto L12;
        this.f11542b.remove(r5);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        throw th;
    L18:
        return r8;
    }

    public final PinShortcutTerminalAction b(String r9, long r10) {
        Intrinsics.checkNotNullParameter(r9, "shortcutId");
        Map<String, Long> r0 = this.f11542b;
        monitor-enter(r0);
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.f11542b.get(r9), Long.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r1 != null) goto L8;
    L10:
        LinkedHashMap r8 = (LinkedHashMap) ZeusTransformUtils.preCheckCast(this.c.get(r9), LinkedHashMap.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r8 == null) goto L17;
        a r11 = (a) ZeusTransformUtils.preCheckCast(r8.get(Long.valueOf(r10)), a.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L24
        if (r11 == null) goto L17;
        if (r11.a() == true) goto L17;
        r11.a(true);     // Catch: Throwable -> L24
        if (r11.b() == null) goto L21;
        PinShortcutTerminalAction r12 = PinShortcutTerminalAction.RECONCILE_OFF;     // Catch: Throwable -> L24
    L22:
        monitor-exit(r0);
        return r12;
    L21:
        r12 = PinShortcutTerminalAction.RECONCILE_ONLY;     // Catch: Throwable -> L24
    L17:
        r12 = PinShortcutTerminalAction.IGNORE;     // Catch: Throwable -> L24
        goto L22
    L8:
        if (r1.longValue() != r10) goto L10;
        this.f11542b.remove(r9);     // Catch: Throwable -> L24
        a(r9, r10, true, null);     // Catch: Throwable -> L24
        r12 = PinShortcutTerminalAction.DELIVER_UI_COMPLETION;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        throw th;
    }
}
