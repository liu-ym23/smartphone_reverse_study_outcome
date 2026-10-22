package com.obric.memorydata.awareness.impl.location;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\b\u001b\n\u0002\u0010\t\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002:;B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\b2\u0010\b\u0002\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015J\"\u0010\u0019\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00050\u001bJ\u001e\u0010\u001d\u001a\u00020\u00162\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u001b2\b\b\u0002\u0010\u001e\u001a\u00020\bJ\u001e\u0010\u001f\u001a\u00020\u00162\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\b\u0002\u0010\u001e\u001a\u00020\bJ\u0010\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015H\u0002JB\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0012\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00100\u000f2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010&\u001a\u00020\bH\u0002J\u0018\u0010'\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00012\u0006\u0010(\u001a\u00020\bH\u0002J\b\u0010)\u001a\u00020\u0016H\u0002J\u0016\u0010*\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\bJ\u001e\u0010-\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00052\u0006\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\bJ\u0016\u0010/\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\bJ\u000e\u00100\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u0005JA\u00101\u001a\u00020\u00162\u0006\u00102\u001a\u00020\u00052\u0006\u00103\u001a\u00020\u00052\b\u00104\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\b2\b\u00105\u001a\u0004\u0018\u00010\u00052\b\u00106\u001a\u0004\u0018\u000107¢\u0006\u0002\u00108J\u0006\u00109\u001a\u00020\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0010\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u0012\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator;", "", "<init>", "()V", "TAG", "", "lock", "recoveryStarted", "", "recoveryToken", "snapshotSubmissionStarted", "aoiRequired", "currentGeoFencesSnapshot", "Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator$CurrentGeoFencesSnapshot;", "homeCompanySnapshot", "Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator$SnapshotPart;", "", "aoiSnapshot", "", "Lcom/obric/memorydata/awareness/impl/location/LocationContextInputDispatcher$AoiSnapshotState;", "onRecoveryCompleted", "Lkotlin/Function0;", "", "beginRecovery", "onCompleted", "submitCurrentGeoFencesSnapshot", "insideFenceIds", "", "insideOuterBoundaryFenceIds", "submitHomeCompanySnapshot", "complete", "submitAoiSnapshot", "states", "createSnapshotSubmissionIfReadyLocked", "submitSnapshots", "token", "homeSnapshot", "restoredAoiStates", "combinedComplete", "completeSnapshotSubmission", "succeeded", "clearRecoveryLocked", "dispatchTransition", "fenceId", "isEnter", "dispatchBoundaryTransition", "boundary", "dispatchStateSync", "dispatchFenceRemoved", "dispatchAoiTransition", "locationType", "aoiId", "aoiName", "boundLocationType", "sourceTimestampMs", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/Long;)V", "reset", "SnapshotPart", "CurrentGeoFencesSnapshot", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f8736a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f8737b = null;
    private static boolean c;
    private static Object d;
    private static boolean e;
    private static boolean f;
    private static a g;
    private static b<Set<String>> h;
    private static b<List<com.obric.memorydata.awareness.impl.location.b.a>> i;
    private static Function0<Unit> j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J)\u0010\r\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0004HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator$CurrentGeoFencesSnapshot;", "", "insideFenceIds", "", "", "insideOuterBoundaryFenceIds", "<init>", "(Ljava/util/Set;Ljava/util/Set;)V", "getInsideFenceIds", "()Ljava/util/Set;", "getInsideOuterBoundaryFenceIds", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Set<String> f8738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Set<String> f8739b;

        public a(Set<String> r3, Set<String> r4) {
            Set<String> r5 = (Set) ZeusTransformUtils.wrapperContextForParams(r3, Set.class, "com.obric.memorydata.plugin");
            Set<String> r6 = (Set) ZeusTransformUtils.wrapperContextForParams(r4, Set.class, "com.obric.memorydata.plugin");
            Intrinsics.checkNotNullParameter(r5, "insideFenceIds");
            Intrinsics.checkNotNullParameter(r6, "insideOuterBoundaryFenceIds");
            this.f8738a = r5;
            this.f8739b = r6;
        }

        public final Set<String> a() {
            return this.f8738a;
        }

        public final Set<String> b() {
            return this.f8739b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8738a, r6.f8738a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f8739b, r6.f8739b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f8738a.hashCode() * 31) + this.f8739b.hashCode();
        }

        public String toString() {
            return "CurrentGeoFencesSnapshot(insideFenceIds=" + this.f8738a + ", insideOuterBoundaryFenceIds=" + this.f8739b + ')';
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\r\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J(\u0010\u000f\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator$SnapshotPart;", ExifInterface.GPS_DIRECTION_TRUE, "", EventBody.KEY_VALUE, "complete", "", "<init>", "(Ljava/lang/Object;Z)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getComplete", "()Z", "component1", "component2", "copy", "(Ljava/lang/Object;Z)Lcom/obric/memorydata/awareness/impl/location/LocationContextRecoveryCoordinator$SnapshotPart;", "equals", "other", "hashCode", "", "toString", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final T f8740a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f8741b;

        public b(T r1, boolean r2) {
            this.f8740a = r1;
            this.f8741b = r2;
        }

        public final T a() {
            return this.f8740a;
        }

        public final boolean b() {
            return this.f8741b;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f8740a, r6.f8740a) == true) goto L12;
            return false;
        L12:
            if (this.f8741b == r6.f8741b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            T r0 = this.f8740a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f8741b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "SnapshotPart(value=" + this.f8740a + ", complete=" + this.f8741b + ')';
        }
    }

    static {
        f8736a = new c();
        f8737b = new Object();
    }

    private c() {
    }

    public static /* synthetic */ void a(c r1, List r2, boolean r3, int r4, Object r5) {
        List<com.obric.memorydata.awareness.impl.location.b.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.memorydata.plugin");
        if ((r4 & 2) == 0) goto L5;
        r3 = true;
    L5:
        r1.a(r6, r3);
    }

    private final void a(final Object r7, a r8, b<Set<String>> r9, List<com.obric.memorydata.awareness.impl.location.b.a> r10, boolean r11) {
        List<com.obric.memorydata.awareness.impl.location.b.a> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r10, List.class, "com.obric.memorydata.plugin");
        Object r12 = f8737b;
        monitor-enter(r12);
        boolean r1 = true;
        if (c == true) goto L7;
    L20:
        r1 = false;
    L21:
        monitor-exit(r12);
        if (r1 == true) goto L25;
        RunLog.INSTANCE.debug("LocationContextRecovery", "恢复轮次已失效，不再提交位置快照");
        return;
    L25:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "位置恢复快照已全部入队，currentGeoFenceSize=" + r8.a().size() + "，outerInsideSize=" + r8.b().size() + "，homeFenceSize=" + ((Set) ZeusTransformUtils.preCheckCast(r9.a(), Set.class, "com.obric.memorydata.plugin")).size() + "，aoiSize=" + r6.size() + "，complete=" + r11, false, 4, null);
        return;
    L7:
        if (d != r7) goto L20;
        if (e == false) goto L20;
        com.obric.memorydata.awareness.impl.location.b.f8730a.a((Collection) ZeusTransformUtils.preCheckCast(r8.a(), Collection.class, "com.obric.memorydata.plugin"), (Collection) ZeusTransformUtils.preCheckCast(r8.b(), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
        if (r9.b() == false) goto L14;
        com.obric.memorydata.awareness.impl.location.b.f8730a.a((Collection) ZeusTransformUtils.preCheckCast(r9.a(), Collection.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L27
    L18:
        com.obric.memorydata.awareness.impl.location.b.f8730a.a(r6, r11, new $$Lambda$c$jXKzoYnYIMV7scuOIxVxa4qmMnI(r7));     // Catch: Throwable -> L27
        goto L21
    L14:
        Iterator r0 = ((Iterable) ZeusTransformUtils.preCheckCast(r9.a(), Iterable.class, "com.obric.memorydata.plugin")).iterator();     // Catch: Throwable -> L27
    L16:
        if (r0.hasNext() == false) goto L18;
        com.obric.memorydata.awareness.impl.location.b.f8730a.a((String) ZeusTransformUtils.preCheckCast(r0.next(), String.class, "com.obric.memorydata.plugin"), true);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    }

    private final void a(Object r7, boolean r8) {
        Object r6 = f8737b;
        monitor-enter(r6);
        boolean r1 = true;
        if (c == true) goto L7;
    L13:
        Function0<Unit> r0 = null;
        boolean r3 = false;
    L14:
        monitor-exit(r6);
        if (r3 == true) goto L18;
        RunLog.INSTANCE.debug("LocationContextRecovery", "忽略已失效的位置恢复任务回调");
        return;
    L18:
        if (r8 == true) goto L21;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "Location baseline task failed; realtime prediction remains blocked", null, 4, null);
        return;
    L21:
        if (r0 == null) goto L23;
        r0.invoke();
    L23:
        monitor-enter(r6);
    L40:
        th = move-exception;
        throw th;
    L25:
        if (c == true) goto L27;
    L33:
        r1 = false;
    L34:
        monitor-exit(r6);
        RunLog r9 = RunLog.INSTANCE;
        if (r1 == false) goto L38;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(r9, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "位置恢复快照已执行完成，恢复实时位置处理", false, 4, null);
        return;
    L38:
        r9.debug("LocationContextRecovery", "位置运行态切换期间恢复轮次已失效");
        return;
    L27:
        if (d != r7) goto L33;
        if (e == false) goto L33;
        f8736a.c();     // Catch: Throwable -> L40
        goto L34
    L7:
        if (d != r7) goto L13;
        if (e == false) goto L13;
        r0 = j;     // Catch: Throwable -> L43
        r3 = true;
    L43:
        th = move-exception;
        throw th;
    }

    private static final Unit b(Object r6, a r7, b r8, List r9, boolean r10) {
        List<com.obric.memorydata.awareness.impl.location.b.a> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        f8736a.a(r6, r7, r8, r4, r10);
        return Unit.INSTANCE;
    }

    private static final Unit b(Object r1, boolean r2) {
        f8736a.a(r1, r2);
        return Unit.INSTANCE;
    }

    private final Function0<Unit> b() {
        List r0 = null;
        if (e == false) goto L5;
        return null;
    L5:
        final a r3 = g;
        if (r3 != null) goto L8;
        return null;
    L8:
        final b<Set<String>> r4 = h;
        if (r4 != null) goto L12;
        return null;
    L12:
        if (f == true) goto L14;
    L16:
        final Object r2 = d;
        if (r2 != null) goto L19;
        return null;
    L19:
        b<List<com.obric.memorydata.awareness.impl.location.b.a>> r7 = i;
        if (r7 == null) goto L22;
        r0 = (List) ZeusTransformUtils.preCheckCast(r7.a(), List.class, "com.obric.memorydata.plugin");
    L22:
        if (r0 != null) goto L24;
        final List r5 = CollectionsKt.emptyList();
    L26:
        if (r4.b() == true) goto L28;
    L37:
        final boolean r6 = false;
    L38:
        e = true;
        return new $$Lambda$c$Lh5BX2cIYIe1CpMp6TVKk14L8A(r2, r3, r4, r5, r6);
    L28:
        if (f == false) goto L36;
        b<List<com.obric.memorydata.awareness.impl.location.b.a>> r8 = i;
        if (r8 != null) goto L32;
    L34:
        boolean r9 = false;
    L35:
        if (r9 == false) goto L37;
    L32:
        if (r8.b() != true) goto L34;
        r9 = true;
    L36:
        r6 = true;
        goto L38
    L24:
        r5 = r0;
        goto L26
    L14:
        if (i != null) goto L16;
        return null;
    }

    private final void c() {
        c = false;
        d = null;
        e = false;
        f = false;
        g = null;
        h = null;
        i = null;
        j = null;
    }

    /* JADX INFO: renamed from: lambda$Lh5BX2cIY-Ie1CpMp6TVKk14L8A, reason: not valid java name */
    public static /* synthetic */ Unit m521lambda$Lh5BX2cIYIe1CpMp6TVKk14L8A(Object r0, a r1, b r2, List r3, boolean r4) {
        return b(r0, r1, r2, r3, r4);
    }

    public static /* synthetic */ Unit lambda$jXKzoYnYIMV7scuOIxVxa4qmMnI(Object r0, boolean r1) {
        return b(r0, r1);
    }

    public final void a() {
        Object r6 = f8737b;
        monitor-enter(r6);
    L22:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L7;
    L16:
        boolean r0 = true;
    L17:
        f8736a.c();     // Catch: Throwable -> L22
        monitor-exit(r6);
        if (r0 == false) goto L27;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "终止当前位置恢复轮次并丢弃部分快照", false, 4, null);
        return;
    L27:
        return;
    L7:
        if (e == true) goto L16;
        if (g != null) goto L16;
        if (h != null) goto L16;
        if (i != null) goto L16;
        r0 = false;
        goto L17
    }

    public final void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "fenceId");
        com.obric.memorydata.awareness.impl.location.b.f8730a.a(r1);
    }

    public final void a(String r9, String r10, String r11, boolean r12, String r13, Long r14) {
        Intrinsics.checkNotNullParameter(r9, "locationType");
        Intrinsics.checkNotNullParameter(r10, "aoiId");
        Object r8 = f8737b;
        monitor-enter(r8);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L13;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        StringBuilder r15 = new StringBuilder().append("恢复期间忽略实时 AOI 变化，locationType=").append(r9).append("，aoiId=").append(r10).append("，action=");     // Catch: Throwable -> L17
        if (r12 == false) goto L9;
        String r16 = "enter";
    L10:
        IRunLog.a.a(r0, "LocationContextRecovery", r15.append(r16).toString(), false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r8);
        return;
    L9:
        r16 = "exit";
        goto L10
    L13:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r8);
        com.obric.memorydata.awareness.impl.location.b.f8730a.a(r9, r10, r11, r12, r13, r14);
    }

    public final void a(String r8, String r9, boolean r10) {
        Intrinsics.checkNotNullParameter(r8, "fenceId");
        Intrinsics.checkNotNullParameter(r9, "boundary");
        Object r7 = f8737b;
        monitor-enter(r7);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L13;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        StringBuilder r11 = new StringBuilder().append("恢复期间忽略实时双边界围栏变化，fenceId=").append(r8).append("，boundary=").append(r9).append("，action=");     // Catch: Throwable -> L17
        if (r10 == false) goto L9;
        String r12 = "enter";
    L10:
        IRunLog.a.a(r1, "LocationContextRecovery", r11.append(r12).toString(), false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L9:
        r12 = "exit";
        goto L10
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r7);
        com.obric.memorydata.awareness.impl.location.b.f8730a.a(r8, r10, r9);
    }

    public final void a(String r8, boolean r9) {
        Intrinsics.checkNotNullParameter(r8, "fenceId");
        Object r7 = f8737b;
        monitor-enter(r7);
    L17:
        th = move-exception;
        throw th;
    L5:
        if (c == false) goto L13;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L17
        StringBuilder r10 = new StringBuilder().append("恢复期间忽略实时围栏变化，fenceId=").append(r8).append("，action=");     // Catch: Throwable -> L17
        if (r9 == false) goto L9;
        String r11 = "enter";
    L10:
        IRunLog.a.a(r1, "LocationContextRecovery", r10.append(r11).toString(), false, 4, null);     // Catch: Throwable -> L17
        monitor-exit(r7);
        return;
    L9:
        r11 = "exit";
        goto L10
    L13:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L17
        monitor-exit(r7);
        com.obric.memorydata.awareness.impl.location.b.a(com.obric.memorydata.awareness.impl.location.b.f8730a, r8, r9, null, 4, null);
    }

    public final void a(Collection<String> r8, Collection<String> r9) {
        Collection r7 = (Collection) ZeusTransformUtils.wrapperContextForParams(r8, Collection.class, "com.obric.memorydata.plugin");
        Collection r10 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r7, "insideFenceIds");
        Intrinsics.checkNotNullParameter(r10, "insideOuterBoundaryFenceIds");
        a r11 = new a(CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r7, Iterable.class, "com.obric.memorydata.plugin")), CollectionsKt.toSet((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")));
        Object r12 = f8737b;
        monitor-enter(r12);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (c == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "忽略不属于当前恢复轮次的当前围栏快照", false, 4, null);     // Catch: Throwable -> L14
        monitor-exit(r12);
        return;
    L9:
        c r13 = f8736a;     // Catch: Throwable -> L14
        g = r11;     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "当前围栏快照已就绪，insideCount=" + r11.a().size() + "，outerInsideCount=" + r11.b().size(), false, 4, null);     // Catch: Throwable -> L14
        Function0<Unit> r14 = r13.b();     // Catch: Throwable -> L14
        monitor-exit(r12);
        if (r14 == null) goto L18;
        r14.invoke();
        return;
    }

    public final void a(Collection<String> r9, boolean r10) {
        Collection r8 = (Collection) ZeusTransformUtils.wrapperContextForParams(r9, Collection.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "insideFenceIds");
        Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(r8, Iterable.class, "com.obric.memorydata.plugin");
        Collection r12 = (Collection) ZeusTransformUtils.preCheckCast(new LinkedHashSet(), Collection.class, "com.obric.memorydata.plugin");
        Iterator r13 = r11.iterator();
    L4:
        if (r13.hasNext() == false) goto L8;
        Object r0 = r13.next();
        if (com.obric.memorydata.awareness.impl.location.b.f8730a.c((String) ZeusTransformUtils.preCheckCast(r0, String.class, "com.obric.memorydata.plugin")) == false) goto L4;
        r12.add(r0);
        goto L4
    L8:
        LinkedHashSet r14 = (LinkedHashSet) ZeusTransformUtils.preCheckCast(r12, LinkedHashSet.class, "com.obric.memorydata.plugin");
        Object r15 = f8737b;
        monitor-enter(r15);
    L20:
        th = move-exception;
        throw th;
    L11:
        if (c == true) goto L15;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "忽略不属于当前恢复轮次的家司围栏快照", false, 4, null);     // Catch: Throwable -> L20
        monitor-exit(r15);
        return;
    L15:
        c r1 = f8736a;     // Catch: Throwable -> L20
        h = new b(r14, r10);     // Catch: Throwable -> L20
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "家司围栏快照已就绪，insideCount=" + r14.size() + "，complete=" + r10, false, 4, null);     // Catch: Throwable -> L20
        Function0<Unit> r16 = r1.b();     // Catch: Throwable -> L20
        monitor-exit(r15);
        if (r16 == null) goto L29;
        r16.invoke();
        return;
    }

    public final void a(List<com.obric.memorydata.awareness.impl.location.b.a> r9, boolean r10) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r9, List.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "states");
        Object r11 = f8737b;
        monitor-enter(r11);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (c == true) goto L9;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "忽略不属于当前恢复轮次的 AOI 快照", false, 4, null);     // Catch: Throwable -> L14
        monitor-exit(r11);
        return;
    L9:
        c r0 = f8736a;     // Catch: Throwable -> L14
        i = new b(r8, r10);     // Catch: Throwable -> L14
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "AOI 快照已就绪，insideCount=" + r8.size() + "，complete=" + r10, false, 4, null);     // Catch: Throwable -> L14
        Function0<Unit> r12 = r0.b();     // Catch: Throwable -> L14
        monitor-exit(r11);
        if (r12 == null) goto L18;
        r12.invoke();
        return;
    }

    public final void a(boolean r7, Function0<Unit> r8) {
        Function0<Unit> r6 = (Function0) ZeusTransformUtils.wrapperContextForParams(r8, Function0.class, "com.obric.memorydata.plugin");
        Object r9 = f8737b;
        monitor-enter(r9);
        c = true;     // Catch: Throwable -> L9
        d = new Object();     // Catch: Throwable -> L9
        e = false;     // Catch: Throwable -> L9
        f = r7;     // Catch: Throwable -> L9
        g = null;     // Catch: Throwable -> L9
        h = null;     // Catch: Throwable -> L9
        i = null;     // Catch: Throwable -> L9
        j = r6;     // Catch: Throwable -> L9
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L9
        monitor-exit(r9);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "LocationContextRecovery", "开始汇聚位置恢复快照，aoiRequired=" + r7, false, 4, null);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public final void b(String r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "fenceId");
        RunLog.INSTANCE.debug("LocationContextRecovery", "同步围栏当前状态，fenceId=" + r3 + "，isEnter=" + r4);
        com.obric.memorydata.awareness.impl.location.b.f8730a.a(r3, r4);
    }
}
