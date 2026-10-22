package com.obric.assistant.reporter.startup;

import android.app.Activity;
import android.app.Application;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import com.larus.utils.q0;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.obric.assistant.spi.startup.IAssistantStartupTelemetry;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import gd9.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 U2\u00020\u0001:\u0003STUB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016JH\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0016J \u0010 \u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000bH\u0016J\u001e\u0010#\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001dH\u0016J\u0012\u0010%\u001a\u0004\u0018\u00010\u000b2\u0006\u0010&\u001a\u00020\u000bH\u0016J \u0010'\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)H\u0016J\"\u0010*\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\b\u0010+\u001a\u0004\u0018\u00010\u000bH\u0016J<\u0010,\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0016J<\u0010/\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u0010(\u001a\u00020)2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0016J\u0010\u00100\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000bH\u0016J\n\u00101\u001a\u0004\u0018\u00010\u000bH\u0016J<\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u00105\u001a\u00020)2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0002J\u0012\u00106\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u00107\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020)2\u0006\u00104\u001a\u00020\u0013H\u0002J\u0018\u00109\u001a\u00020)2\u0006\u00104\u001a\u00020\u00132\u0006\u0010:\u001a\u00020)H\u0002J\u001a\u0010;\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020)H\u0002J\u0010\u0010=\u001a\u00020)2\u0006\u0010+\u001a\u00020\u000bH\u0002J\u001a\u0010>\u001a\u00020\u00182\u0006\u00104\u001a\u00020\u00132\b\b\u0002\u0010<\u001a\u00020)H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u0019\u001a\u00020\u000bH\u0002J \u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020)2\u0006\u0010D\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\"\u0010E\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\b\u0010F\u001a\u0004\u0018\u00010\u000b2\u0006\u0010G\u001a\u00020HH\u0002J<\u0010I\u001a\u0002032\u0006\u00104\u001a\u00020\u00132\u0006\u0010-\u001a\u00020\u000b2\u0006\u0010.\u001a\u00020\u000b2\u0006\u00105\u001a\u00020)2\u0012\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0002J \u0010K\u001a\u00020@*\u0002032\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0002J(\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0002J\u0010\u0010M\u001a\u00020@2\u0006\u0010N\u001a\u000203H\u0002J\u0010\u0010O\u001a\u00020@2\u0006\u0010N\u001a\u000203H\u0002J\u0018\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u001f*\u000203H\u0002J\u0016\u0010Q\u001a\u000203*\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\u001fH\u0002J\b\u0010R\u001a\u00020\u0018H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006V"}, d2 = {"Lcom/obric/assistant/reporter/startup/AssistantStartupTelemetryImpl;", "Lcom/obric/assistant/spi/startup/IAssistantStartupTelemetry;", "<init>", "()V", "lock", "", "handler", "Landroid/os/Handler;", "liveActivities", "Ljava/util/WeakHashMap;", "Landroid/app/Activity;", "", "terminalAttemptIds", "Ljava/util/LinkedHashSet;", "warnedUnknownAttemptIds", "reportExecutor", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "activeAttempt", "Lcom/obric/assistant/reporter/startup/AssistantStartupTelemetryImpl$Attempt;", "begin", "spec", "Lcom/obric/assistant/spi/startup/AssistantStartupAttemptSpec;", "updateAttempt", "", "attemptId", "action", "target", "requiredMilestones", "", "attributes", "", "replaceRequiredMilestone", "oldMilestone", "newMilestone", "addRequiredMilestones", "milestones", "activeAttemptIdRequiring", "milestone", "markReady", "timestampElapsedRealtimeMs", "", "markFirstFrame", "source", "finish", WindowEvent.Params.RESULT, WindowEvent.Params.REASON, "reportDetachedResult", "discard", "activeAttemptId", "finishLocked", "Lorg/json/JSONObject;", "attempt", "timestampElapsedMs", "currentAttemptLocked", "isReady", "readyTimestamp", "normalizeTimestamp", "timestampMs", "isExpired", "nowElapsedMs", "evidenceGraceMs", "isEvidenceGraceExpired", "rememberTerminalAttemptLocked", "", "captureStartStateSnapshot", "Lcom/obric/assistant/reporter/startup/AssistantStartupTelemetryImpl$StartStateSnapshot;", "startElapsedMs", "startClock", "resolveActivityStartType", "processStartType", "activitySnapshot", "Lcom/obric/assistant/reporter/startup/AssistantStartupStateManager$ActivitySnapshot;", "buildResultPayload", "resultAttributes", "putAttributes", "mutableAttemptAttributes", "reportResultAsync", "payload", "reportResult", "toStringValueMap", "toJsonObject", "isMainProcessSafe", "StartStateSnapshot", "Attempt", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantStartupTelemetryImpl implements IAssistantStartupTelemetry {
    public static final Set<String> h = null;
    public static final Set<String> i = null;
    public final Object a;
    public final Handler b;
    public final WeakHashMap<Activity, String> c;
    public final LinkedHashSet<String> d;
    public final LinkedHashSet<String> e;
    public final ExecutorService f;
    public volatile b g;

    public static final class a implements Application.ActivityLifecycleCallbacks {
        public final /* synthetic */ AssistantStartupTelemetryImpl a;

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity r2, Bundle r3) {
            Intrinsics.checkNotNullParameter(r2, "activity");
            Intrinsics.checkNotNullParameter(r3, "outState");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity r2) {
            Intrinsics.checkNotNullParameter(r2, "activity");
        }

        public a(AssistantStartupTelemetryImpl r1) {
            this.a = r1;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity r3) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            AssistantStartupTelemetryImpl r0 = this.a;
            WeakHashMap<Activity, String> r1 = r0.c;
            monitor-enter(r1);
            String r4 = r0.c.remove(r3);     // Catch: Throwable -> L7
            monitor-exit(r1);
            return;
        L7:
            th = move-exception;
            throw th;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity r3, Bundle r4) {
            Intrinsics.checkNotNullParameter(r3, "activity");
            AssistantStartupTelemetryImpl r5 = this.a;
            WeakHashMap<Activity, String> r0 = r5.c;
            monitor-enter(r0);
            r5.c.put(r3, r3.getClass().getName());     // Catch: Throwable -> L7
            Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L7
            monitor-exit(r0);
            return;
        L7:
            th = move-exception;
            throw th;
        }
    }

    public static final class b {
        public final String a;
        public final String b;
        public String c;
        public String d;
        public final long e;
        public final String f;
        public final Set<String> g;
        public final Map<String, String> h;
        public final com.obric.assistant.reporter.startup.b.a i;
        public final LinkedHashMap<String, Long> j;
        public final long k;
        public Runnable l;
        public long m;
        public String n;

        public b(String r2, String r3, String r4, String r5, long r6, String r8, long r9, Set<String> r11, Map<String, String> r12, com.obric.assistant.reporter.startup.b.a r13) {
            Intrinsics.checkNotNullParameter(r2, "id");
            Intrinsics.checkNotNullParameter(r3, "source");
            Intrinsics.checkNotNullParameter(r4, "action");
            Intrinsics.checkNotNullParameter(r5, "target");
            Intrinsics.checkNotNullParameter(r8, "startClock");
            Intrinsics.checkNotNullParameter(r11, "requiredMilestones");
            Intrinsics.checkNotNullParameter(r12, "attributes");
            Intrinsics.checkNotNullParameter(r13, "activitySnapshot");
            this.a = r2;
            this.b = r3;
            this.c = r4;
            this.d = r5;
            this.e = r6;
            this.f = r8;
            this.g = r11;
            this.h = r12;
            this.i = r13;
            this.j = new LinkedHashMap();
            this.k = r6 + r9;
            this.m = -1;
        }
    }

    public static final class c {
    }

    public static final class d {
        public final Map<String, String> a;
        public final com.obric.assistant.reporter.startup.b.a b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof d) == true) goto L8;
            return false;
        L8:
            d r6 = (d) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "StartStateSnapshot(attributes=" + this.a + ", activitySnapshot=" + this.b + ')';
        }

        public d(Map<String, String> r2, com.obric.assistant.reporter.startup.b.a r3) {
            Intrinsics.checkNotNullParameter(r2, "attributes");
            Intrinsics.checkNotNullParameter(r3, "activitySnapshot");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
        h = SetsKt.setOf(new String[]{"ai_key", "voice", "breath"});
        i = SetsKt.setOf(new String[]{"state_owner_process_role", "process_start_type", "process_uptime_ms", "process_start_inferred", "activity_start_type", "app_visibility_at_start", "start_clock", "requested_start_clock", "start_timestamp_rejected_reason"});
    }

    public static boolean q() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        i r1 = com.larus.im.b.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        Object r2 = Result.constructor-impl(Boolean.valueOf(q0.c(r1.getApplication())));     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.exceptionOrNull-impl(r2);
        if (r3 == null) goto L9;
        FLogger.a.w("AssistantStartupTelemetry", "isMainProcessSafe failed: " + r3.getMessage(), r3);
    L9:
        Boolean r4 = Boolean.FALSE;
        if (Result.isFailure-impl(r2) == false) goto L13;
        r2 = r4;
    L13:
        return ((Boolean) r2).booleanValue();
    L4:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r2 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String h() {
        b r0 = this.g;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.a;
    }

    public AssistantStartupTelemetryImpl() {
        this.a = new Object();
        this.b = new Handler(Looper.getMainLooper());
        WeakHashMap<Activity, String> r0 = new WeakHashMap();
        this.c = r0;
        this.d = new LinkedHashSet();
        this.e = new LinkedHashSet();
        this.f = PThreadExecutorsUtils.newSingleThreadExecutor(new DefaultThreadFactory("AssistantStartupTelemetryImpl"));
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L18
        if (q() == false) goto L14;
        i r2 = com.larus.im.b.a;     // Catch: Throwable -> L18
        Intrinsics.checkNotNull(r2);     // Catch: Throwable -> L18
        r2.getApplication().registerActivityLifecycleCallbacks(new a(this));     // Catch: Throwable -> L18
        monitor-enter(r0);     // Catch: Throwable -> L18
        i r3 = com.larus.im.b.a;     // Catch: Throwable -> L15
        Intrinsics.checkNotNull(r3);     // Catch: Throwable -> L15
        Iterator r4 = r3.a().d().iterator();     // Catch: Throwable -> L15
    L10:
        if (r4.hasNext() == false) goto L12;
        Activity r5 = (Activity) r4.next();     // Catch: Throwable -> L15
        this.c.put(r5, r5.getClass().getName());     // Catch: Throwable -> L15
        goto L10
    L12:
        Unit r6 = Unit.INSTANCE;     // Catch: Throwable -> L15
        monitor-exit(r0);     // Catch: Throwable -> L18
        goto L14
    L15:
        th = move-exception;
        throw th;     // Catch: Throwable -> L18
    L14:
        Object r7 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L18
    L20:
        Throwable r8 = Result.exceptionOrNull-impl(r7);
        if (r8 == null) goto L28;
        FLogger.a.w("AssistantStartupTelemetry", "failed to register activity lifecycle callbacks: " + r8);
        return;
    L28:
        return;
    L18:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L20
    }

    public static boolean r(b r2) {
        if ((!r2.g.isEmpty()) == true) goto L5;
    L7:
        return false;
    L5:
        if (r2.j.keySet().containsAll(r2.g) == false) goto L7;
        return true;
    }

    public static Map s(Map r4) {
        Set r0 = CollectionsKt.intersect(r4.keySet(), i);
        if ((!r0.isEmpty()) == false) goto L5;
        FLogger.a.w("AssistantStartupTelemetry", "ignore frozen startup attributes: " + CollectionsKt.sorted(r0));
    L5:
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator r5 = r4.entrySet().iterator();
    L7:
        if (r5.hasNext() == false) goto L11;
        Map.Entry r2 = (Map.Entry) r5.next();
        if ((!i.contains((String) r2.getKey())) == false) goto L7;
        r1.put(r2.getKey(), r2.getValue());
        goto L7
    L11:
        return r1;
    }

    public static long u(b r7) {
        Iterator<T> r0 = r7.g.iterator();
        if (r0.hasNext() == false) goto L20;
        String r1 = (String) r0.next();
        Long r2 = r7.j.get(r1);
        if (r2 == null) goto L18;
        long r3 = r2.longValue();
    L8:
        if (r0.hasNext() == false) goto L16;
        String r4 = (String) r0.next();
        Long r5 = r7.j.get(r4);
        if (r5 == null) goto L15;
        long r6 = r5.longValue();
        if (r3 >= r6) goto L8;
        r3 = r6;
        goto L8
    L15:
        throw new IllegalStateException("Required value was null.".toString());
    L16:
        return r3;
    L18:
        throw new IllegalStateException("Required value was null.".toString());
    L20:
        throw new NoSuchElementException();
    }

    public static JSONObject y(Map r3) {
        JSONObject r0 = new JSONObject();
        Iterator r4 = r3.entrySet().iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r4.next();
        r0.put((String) r1.getKey(), r1.getValue());
        goto L4
    L6:
        return r0;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String a(uga.a r33) {
        Intrinsics.checkNotNullParameter(r33, "spec");
        if (q() == true) goto L7;
        FLogger.a.i("AssistantStartupTelemetry", "ignore startup attempt outside the main process");
        return "";
    L7:
        if (r33.g.isEmpty() == false) goto L10;
        FLogger.a.w("AssistantStartupTelemetry", "ignore startup attempt without a terminal readiness gate");
        return "";
    L10:
        long r9 = SystemClock.elapsedRealtime();
        Set<String> r1 = com.obric.assistant.reporter.startup.b.a;
        com.obric.assistant.reporter.startup.b.C0015b r11 = com.obric.assistant.reporter.startup.b.a(r33.e, r33.f, r9);
        String r2 = r33.a;
        if (r2 != null) goto L13;
    L17:
        r2 = UUID.randomUUID().toString();
    L18:
        String r15 = r2;
        long r22 = RangesKt.coerceIn(r33.h, 1000, 60000);
        d r14 = m(r11.a, r11.b, r33.d);
        ArrayList r7 = new ArrayList();
        Object r30 = this.a;
        monitor-enter(r30);
    L43:
        th = th;
        r30 = r30;
    L96:
        monitor-exit(r30);
        throw th;
    L21:
        if (this.d.contains(r15) == false) goto L24;
        monitor-exit(r30);
        return r15;
    L24:
        b r3 = this.g;     // Catch: Throwable -> L43
        if (r3 != null) goto L27;
        ArrayList r12 = r7;
    L69:
        if (this.d.contains(r15) == false) goto L71;
        ArrayList r4 = r12;
        final String r13 = r15;
    L88:
        Unit r0 = Unit.INSTANCE;     // Catch: Throwable -> L95
        monitor-exit(r30);
        Iterator r5 = r4.iterator();
    L92:
        if (r5.hasNext() == false) goto L94;
        w((JSONObject) r5.next());
        goto L92
    L94:
        return r13;
    L71:
        String r6 = r33.b;     // Catch: Throwable -> L95
        String r8 = r33.c;     // Catch: Throwable -> L95
        String r10 = r33.d;     // Catch: Throwable -> L95
        long r16 = r11.a;     // Catch: Throwable -> L95
        String r17 = r11.b;     // Catch: Throwable -> L95
        Set r24 = CollectionsKt.toMutableSet(r33.g);     // Catch: Throwable -> L95
        Map<String, String> r18 = r14.a;     // Catch: Throwable -> L95
        String r19 = r11.c;     // Catch: Throwable -> L95
        if (r19 == null) goto L74;
        Map r110 = MapsKt.mapOf(new Pair[]{TuplesKt.to("requested_start_clock", r33.f), TuplesKt.to("start_timestamp_rejected_reason", r19)});     // Catch: Throwable -> L95
    L75:
        if (r110 != null) goto L77;
        r110 = MapsKt.emptyMap();     // Catch: Throwable -> L95
    L77:
        r13 = r15;
        b r20 = new b(r13, r6, r8, r10, r16, r17, r22, r24, MapsKt.toMutableMap(MapsKt.plus(MapsKt.plus(r18, r110), s(r33.i))), r14.b);     // Catch: Throwable -> L95
        Runnable r21 = new wfa.b(this, r13);     // Catch: Throwable -> L95
        r20.l = r21;     // Catch: Throwable -> L95
        this.g = r20;     // Catch: Throwable -> L95
        if (h.contains(r20.b) == false) goto L80;
        long r23 = 5000;
    L82:
        if (r9 < (r20.k + RangesKt.coerceAtLeast(r23, 0))) goto L84;
        boolean r111 = true;
    L85:
        if (r111 == false) goto L87;
        r4 = r12;
        r4.add(o(r20, "timeout", "deadline_exceeded", r20.k, MapsKt.emptyMap()));     // Catch: Throwable -> L95
        goto L88
    L87:
        r4 = r12;
        this.b.postDelayed(r21, RangesKt.coerceAtLeast((r20.k + RangesKt.coerceAtLeast(r23, 0)) - SystemClock.elapsedRealtime(), 0));     // Catch: Throwable -> L95
        goto L88
    L84:
        r111 = false;
        goto L85
    L80:
        r23 = 0;
        goto L82
    L74:
        r110 = null;
        goto L75
    L27:
        if (Intrinsics.areEqual(r3.a, r15) == false) goto L45;
        long r112 = r3.k;     // Catch: Throwable -> L43
        if (h.contains(r3.b) == false) goto L31;
        long r25 = 5000;
    L34:
        if (r9 < (r112 + RangesKt.coerceAtLeast(r25, 0))) goto L36;
        boolean r26 = true;
    L37:
        if (r26 == true) goto L40;
        monitor-exit(r30);
        return r15;
    L40:
        r12 = r7;
        r12.add(o(r3, "timeout", "deadline_exceeded", r3.k, MapsKt.emptyMap()));     // Catch: Throwable -> L95
        goto L69
    L36:
        r26 = false;
        goto L37
    L31:
        r25 = 0;
        goto L34
    L45:
        r12 = r7;
        long r27 = r3.k;     // Catch: Throwable -> L95
        if (r9 < r27) goto L48;
        boolean r28 = true;
    L49:
        if (r28 == false) goto L51;
        String r29 = "timeout";
    L52:
        if (r9 < r27) goto L54;
        boolean r31 = true;
    L55:
        if (r31 == false) goto L57;
        String r32 = "deadline_exceeded";
    L58:
        String r34 = r32;
        long r113 = Math.min(r9, r27);     // Catch: Throwable -> L95
        if (r9 < r3.k) goto L61;
        boolean r35 = true;
    L62:
        if (r35 == false) goto L65;
        Map<String, String> r36 = MapsKt.emptyMap();     // Catch: Throwable -> L95
    L66:
        r12.add(o(r3, r29, r34, r113, r36));     // Catch: Throwable -> L95
        goto L69
    L65:
        r36 = MapsKt.mapOf(TuplesKt.to("superseded_by_attempt_id", r15));     // Catch: Throwable -> L95
        goto L66
    L61:
        r35 = false;
        goto L62
    L57:
        r32 = "new_attempt";
        goto L58
    L54:
        r31 = false;
        goto L55
    L51:
        r29 = "superseded";
        goto L52
    L48:
        r28 = false;
    L95:
        th = th;
        goto L96
    L13:
        if ((!StringsKt.isBlank(r2)) == true) goto L16;
        r2 = null;
    L16:
        if (r2 != null) goto L18;
        goto L17
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean f(String r5) {
        Intrinsics.checkNotNullParameter(r5, "attemptId");
        if (StringsKt.isBlank(r5) == false) goto L5;
        return false;
    L5:
        Object r0 = this.a;
        monitor-enter(r0);
        b r2 = n(r5);     // Catch: Throwable -> L21
        if (r2 != null) goto L11;
        monitor-exit(r0);
        return false;
    L11:
        Runnable r1 = r2.l;     // Catch: Throwable -> L21
        if (r1 == null) goto L14;
        this.b.removeCallbacks(r1);     // Catch: Throwable -> L21
    L14:
        r2.l = null;     // Catch: Throwable -> L21
        v(r2.a);     // Catch: Throwable -> L21
        if (this.g != r2) goto L17;
        this.g = null;     // Catch: Throwable -> L21
    L17:
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L21
        monitor-exit(r0);
        FLogger.a.i("AssistantStartupTelemetry", "discard pre-launch attemptId=" + r5);
        return true;
    L21:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final String i(String r5) {
        Intrinsics.checkNotNullParameter(r5, "milestone");
        Object r0 = this.a;
        monitor-enter(r0);
        b r1 = this.g;     // Catch: Throwable -> L14
        String r2 = null;
        if (r1 != null) goto L7;
    L12:
        monitor-exit(r0);
        return r2;
    L7:
        if (r1.g.contains(r5) == true) goto L10;
        r1 = null;
    L10:
        if (r1 == null) goto L12;
        r2 = r1.a;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        throw th;
    }

    public final b n(String r6) {
        b r0 = this.g;
        if (r0 != null) goto L6;
        return null;
    L6:
        if (Intrinsics.areEqual(r0.a, r6) == false) goto L8;
        return r0;
    L8:
        if (this.d.contains(r6) == false) goto L10;
    L17:
        return null;
    L10:
        if (this.e.add(r6) == false) goto L17;
        FLogger.a.w("AssistantStartupTelemetry", "ignore unknown callback, active=" + r0.a + ", callback=" + r6);
    L13:
        if (this.e.size() <= 256) goto L17;
        Iterator<String> r7 = this.e.iterator();
        if (r7.hasNext() == false) goto L13;
        r7.next();
        r7.remove();
        goto L13
    }

    public final void v(String r2) {
        this.d.add(r2);
    L4:
        if (this.d.size() <= 4096) goto L8;
        Iterator<String> r3 = this.d.iterator();
        if (r3.hasNext() == false) goto L4;
        r3.next();
        r3.remove();
        goto L4
    }

    public final void w(final JSONObject r4) {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        this.f.execute(new wfa.c(this, r4));     // Catch: Throwable -> L4
        Object r5 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r6 = Result.exceptionOrNull-impl(r5);
        if (r6 == null) goto L12;
        FLogger.a.w("AssistantStartupTelemetry", "failed to enqueue startup result", r6);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r5 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L6
    }

    public static boolean p(AssistantStartupTelemetryImpl r6, b r7) {
        long r0 = SystemClock.elapsedRealtime();
        r6.getClass();
        Set<String> r8 = com.obric.assistant.reporter.startup.b.a;
        long r2 = r7.k;
        if (h.contains(r7.b) == false) goto L5;
        long r9 = 5000;
    L7:
        if (r0 < (r2 + RangesKt.coerceAtLeast(r9, 0))) goto L9;
        return true;
    L9:
        return false;
    L5:
        r9 = 0;
        goto L7
    }

    public static void t(JSONObject r3, Map r4) {
        Iterator r5 = r4.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r0 = (Map.Entry) r5.next();
        String r1 = (String) r0.getKey();
        String r2 = (String) r0.getValue();
        if (r3.has(r1) == true) goto L4;
        r3.put(r1, r2);
        goto L4
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean b(String r9, Set<String> r10) {
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        Intrinsics.checkNotNullParameter(r10, "milestones");
        Object r0 = this.a;
        monitor-enter(r0);
        b r2 = n(r9);     // Catch: Throwable -> L22
        boolean r11 = false;
        if (r2 != null) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        if (p(this, r2) == false) goto L12;
        JSONObject r12 = o(r2, "timeout", "deadline_exceeded", r2.k, MapsKt.emptyMap());     // Catch: Throwable -> L22
    L17:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        if (r12 == null) goto L21;
        w(r12);
    L21:
        return r11;
    L12:
        r2.g.addAll(r10);     // Catch: Throwable -> L22
        if (r(r2) == false) goto L15;
        JSONObject r13 = o(r2, WindowEvent.WindowOpenPerfResult.SUCCESS, "ready", u(r2), MapsKt.emptyMap());     // Catch: Throwable -> L22
    L16:
        r12 = r13;
        r11 = true;
        goto L17
    L15:
        r13 = null;
    L22:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [java.lang.Object, wfa.a] */
    public static String x(final String r1, String r2, com.obric.assistant.reporter.startup.b.a r3) {
        Set<String> r0 = com.obric.assistant.reporter.startup.b.a;
        Intrinsics.checkNotNullParameter(r1, "target");
        Intrinsics.checkNotNullParameter(r3, "activitySnapshot");
        switch(r1.hashCode()) {
            case -787751952: goto L15;
            case -776905469: goto L12;
            case 1429828318: goto L9;
            case 2030147282: goto L6;
            default: goto L17;
        };
    L17:
        ?? r4 = new wfa.a(r1);
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, "predicate");
        Set<String> r5 = r3.a;
        if ((r5 instanceof Collection) == true) goto L20;
    L22:
        Iterator<T> r6 = r5.iterator();
    L24:
        if (r6.hasNext() == false) goto L28;
        if (((Boolean) r4.invoke(r6.next())).booleanValue() == false) goto L24;
        boolean r7 = true;
    L29:
        if (r7 == false) goto L32;
        return "hot";
    L32:
        if (Intrinsics.areEqual(r2, "cold") == false) goto L35;
        return "cold";
    L35:
        if (Intrinsics.areEqual(r2, "alive") == false) goto L37;
        return "warm";
    L37:
        return "unknown";
    L28:
        r7 = false;
        goto L29
    L20:
        if (r5.isEmpty() == false) goto L22;
    L6:
        if (r1.equals("touch_speak") == false) goto L17;
    L16:
        return "not_applicable";
    L9:
        if (r1.equals("assistant") == true) goto L37;
    L12:
        if (r1.equals("click_talk") == true) goto L16;
    L15:
        if (r1.equals("window") == false) goto L17;
        goto L16
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean c(String r9, String r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        Intrinsics.checkNotNullParameter(r10, "oldMilestone");
        Intrinsics.checkNotNullParameter(r11, "newMilestone");
        Object r0 = this.a;
        monitor-enter(r0);
        b r2 = n(r9);     // Catch: Throwable -> L26
        boolean r12 = false;
        if (r2 != null) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        if (p(this, r2) == false) goto L13;
        JSONObject r13 = o(r2, "timeout", "deadline_exceeded", r2.k, MapsKt.emptyMap());     // Catch: Throwable -> L26
    L21:
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L26
        monitor-exit(r0);
        if (r13 == null) goto L25;
        w(r13);
    L25:
        return r12;
    L13:
        if (r2.g.remove(r10) == true) goto L16;
        monitor-exit(r0);
        return false;
    L16:
        r2.g.add(r11);     // Catch: Throwable -> L26
        if (r(r2) == false) goto L19;
        JSONObject r15 = o(r2, WindowEvent.WindowOpenPerfResult.SUCCESS, "ready", u(r2), MapsKt.emptyMap());     // Catch: Throwable -> L26
    L20:
        r13 = r15;
        r12 = true;
        goto L21
    L19:
        r15 = null;
    L26:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean d(String r10, String r11, long r12) {
        Intrinsics.checkNotNullParameter(r10, "attemptId");
        Intrinsics.checkNotNullParameter(r11, "milestone");
        Object r0 = this.a;
        monitor-enter(r0);
        b r2 = n(r10);     // Catch: Throwable -> L45
        boolean r13 = false;
        if (r2 != null) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        if (r2.g.contains(r11) == true) goto L14;
        monitor-exit(r0);
        return false;
    L14:
        if (p(this, r2) == false) goto L16;
        JSONObject r14 = o(r2, "timeout", "deadline_exceeded", r2.k, MapsKt.emptyMap());     // Catch: Throwable -> L45
    L40:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L45
        monitor-exit(r0);
        if (r14 == null) goto L44;
        w(r14);
    L44:
        return r13;
    L16:
        long r16 = RangesKt.coerceIn(r12, r2.e, SystemClock.elapsedRealtime());     // Catch: Throwable -> L45
        Long r1 = r2.j.get(r11);     // Catch: Throwable -> L45
        Set<String> r3 = com.obric.assistant.reporter.startup.b.a;     // Catch: Throwable -> L45
        long r4 = r2.k;     // Catch: Throwable -> L45
        if (r1 == null) goto L19;
        r16 = Math.min(r1.longValue(), r16);     // Catch: Throwable -> L45
    L19:
        Long r17 = Long.valueOf(r16);     // Catch: Throwable -> L45
        if (r17.longValue() >= r4) goto L23;
        boolean r5 = true;
    L25:
        if (r5 == true) goto L28;
        r17 = null;
    L28:
        if (r17 != null) goto L32;
        monitor-exit(r0);
        return false;
    L32:
        if (Intrinsics.areEqual(r17, r1) == false) goto L35;
        monitor-exit(r0);
        return false;
    L35:
        r2.j.put(r11, r17);     // Catch: Throwable -> L45
        if (r(r2) == false) goto L38;
        r14 = o(r2, WindowEvent.WindowOpenPerfResult.SUCCESS, "ready", u(r2), MapsKt.emptyMap());     // Catch: Throwable -> L45
    L39:
        r13 = true;
        goto L40
    L38:
        r14 = null;
        goto L39
    L23:
        r5 = false;
    L45:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean k(String r9, long r10, String r12) {
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        Object r0 = this.a;
        monitor-enter(r0);
        b r11 = n(r9);     // Catch: Throwable -> L22
        if (r11 != null) goto L9;
        monitor-exit(r0);
        return false;
    L9:
        long r13 = RangesKt.coerceIn(r10, r11.e, SystemClock.elapsedRealtime());     // Catch: Throwable -> L22
        Set<String> r2 = com.obric.assistant.reporter.startup.b.a;     // Catch: Throwable -> L22
        long r3 = r11.m;     // Catch: Throwable -> L22
        if (r3 < 0) goto L15;
        r13 = Math.min(r3, r13);     // Catch: Throwable -> L22
    L15:
        if (r13 != r11.m) goto L18;
        monitor-exit(r0);
        return false;
    L18:
        r11.m = r13;     // Catch: Throwable -> L22
        r11.n = r12;     // Catch: Throwable -> L22
        Unit r14 = Unit.INSTANCE;     // Catch: Throwable -> L22
        monitor-exit(r0);
        return true;
    L22:
        th = move-exception;
        throw th;
    }

    public final d m(long r16, String r18, String r19) {
        long r2 = SystemClock.elapsedRealtime();
        long r6 = -1;
        if (Build.VERSION.SDK_INT < 24) goto L5;
        long r4 = Process.getStartElapsedRealtime();
    L7:
        if (r4 <= 0) goto L9;
        r6 = RangesKt.coerceAtLeast(r2 - r4, 0);
    L9:
        Set<String> r3 = com.obric.assistant.reporter.startup.b.a;
        Intrinsics.checkNotNullParameter(r18, "startClock");
        boolean r0 = Intrinsics.areEqual(r18, "receiver_elapsed_fallback");
        boolean r5 = true;
        if (r0 == true) goto L12;
    L19:
        boolean r11 = false;
    L21:
        if (r4 > 0) goto L23;
        String r7 = "unknown";
    L31:
        if (Intrinsics.areEqual(r7, "cold") == false) goto L34;
        if (r0 == false) goto L34;
        boolean r1 = true;
    L35:
        com.obric.assistant.reporter.startup.b.c r8 = new com.obric.assistant.reporter.startup.b.c(r7, r1);
        Object r9 = null;
        Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L52
        i r12 = com.larus.im.b.a;     // Catch: Throwable -> L52
        Intrinsics.checkNotNull(r12);     // Catch: Throwable -> L52
        gd9.d r13 = r12.a();     // Catch: Throwable -> L52
        Activity r14 = r13.e();     // Catch: Throwable -> L52
        boolean r15 = r13.e;     // Catch: Throwable -> L52
        if (r14 == null) goto L39;
        String r17 = r14.getClass().getName();     // Catch: Throwable -> L52
    L40:
        if (r17 != null) goto L42;
        r17 = "";
    L42:
        boolean r110 = StringsKt.contains$default(r17, ChatWindowActivity.TAG, false, 2, null);     // Catch: Throwable -> L52
        if (r14 == null) goto L49;
        if (r110 == true) goto L49;
        if (r15 == false) goto L48;
        String r20 = "background";
    L50:
        Object r21 = Result.constructor-impl(TuplesKt.to(r17, r20));     // Catch: Throwable -> L52
    L54:
        Pair r111 = TuplesKt.to("", "unknown");
        if (Result.isFailure-impl(r21) == false) goto L57;
        r21 = r111;
    L57:
        Pair r112 = (Pair) r21;
        WeakHashMap<Activity, String> r113 = this.c;
        monitor-enter(r113);
        Set r22 = CollectionsKt.toMutableSet(this.c.values());     // Catch: Throwable -> L86
        monitor-exit(r113);
        Object r114 = r112.getFirst();
        if (((String) r114).length() > 0) goto L65;
        r5 = false;
    L65:
        if (r5 == false) goto L67;
        r9 = r114;
    L67:
        String r23 = (String) r9;
        if (r23 == null) goto L70;
        r22.add(r23);
    L70:
        int r24 = com.obric.assistant.reporter.startup.b.a.b;
        Set r25 = r22;
        Intrinsics.checkNotNullParameter(r25, "activityNames");
        com.obric.assistant.reporter.startup.b.a r26 = new com.obric.assistant.reporter.startup.b.a(CollectionsKt.toSet(r25));
        Map r27 = MapsKt.createMapBuilder();
        r27.put("state_owner_process_role", "main");
        r27.put("process_start_type", r8.getType());
        Object r28 = Result.constructor-impl(ObricFeatureServiceDelegate.b.f());     // Catch: Throwable -> L73
    L76:
        if (Result.isFailure-impl(r28) == false) goto L78;
        r28 = "Unknown";
    L78:
        r27.put("keep_alive_level_mode", r28);
        if (r6 < 0) goto L82;
        r27.put("process_uptime_ms", String.valueOf(r6));
    L82:
        if (r8.b == false) goto L84;
        r27.put("process_start_inferred", "1");
    L84:
        r27.put("activity_start_type", x(r19, r8.getType(), r26));
        r27.put("app_visibility_at_start", r112.getSecond());
        return new d(MapsKt.build(r27), r26);
    L73:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r28 = Result.constructor-impl(ResultKt.createFailure(th));
    L86:
        th = move-exception;
        throw th;
    L48:
        r20 = "foreground";
    L49:
        r20 = "no_real_activity";
        goto L50
    L39:
        r17 = null;
    L52:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r21 = Result.constructor-impl(ResultKt.createFailure(th));
    L34:
        r1 = false;
        goto L35
    L23:
        if (r0 == false) goto L25;
    L27:
        if (r11 == false) goto L29;
    L28:
        r7 = "cold";
        goto L31
    L29:
        r7 = "alive";
        goto L31
    L25:
        if (r16 > (r4 + 500)) goto L27;
    L12:
        if (0 <= r6) goto L14;
    L16:
        boolean r117 = false;
    L17:
        if (r117 == false) goto L19;
        r11 = true;
        goto L21
    L14:
        if (r6 >= 2001) goto L16;
        r117 = true;
        goto L17
    L5:
        r4 = -1;
        goto L7
    }

    public static JSONObject l(b r12, String r13, String r14, long r15, Map r17) {
        Set r1 = SetsKt.minus(r12.g, r12.j.keySet());
        JSONObject r2 = new JSONObject();
        r2.put("schema_version", 1);
        r2.put("attempt_id", r12.a);
        r2.put("source", r12.b);
        r2.put("action", r12.c);
        r2.put("target", r12.d);
        r2.put(WindowEvent.Params.RESULT, r13);
        r2.put(WindowEvent.Params.REASON, r14);
        r2.put("start_clock", r12.f);
        r2.put("total_duration_ms", RangesKt.coerceAtLeast(r15 - r12.e, 0));
        long r5 = r12.m;
        if (r5 < 0) goto L8;
        r2.put("first_frame_duration_ms", RangesKt.coerceAtLeast(r5 - r12.e, 0));
        String r3 = r12.n;
        if (r3 == null) goto L8;
        r2.put("first_frame_source", r3);
    L8:
        if ((!r1.isEmpty()) == false) goto L10;
        r2.put("missing_gate", CollectionsKt.joinToString$default(CollectionsKt.sorted(r1), ",", null, null, 0, null, null, 62, null));
    L10:
        t(r2, r12.h);
        t(r2, r17);
        return r2;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean e(uga.a r31, String r32, String r33, long r34, Map<String, String> r36) {
        Intrinsics.checkNotNullParameter(r31, "spec");
        Intrinsics.checkNotNullParameter(r32, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r33, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r36, "attributes");
        if (q() == true) goto L6;
        FLogger.a.i("AssistantStartupTelemetry", "ignore detached startup result outside the main process");
        return false;
    L6:
        String r2 = r31.a;
        if (r2 != null) goto L9;
        return false;
    L9:
        if ((!StringsKt.isBlank(r2)) == true) goto L12;
        r2 = null;
    L12:
        if (r2 != null) goto L15;
        return false;
    L15:
        if (r31.g.isEmpty() == false) goto L18;
        FLogger.a.w("AssistantStartupTelemetry", "ignore detached startup result without a readiness gate");
        return false;
    L18:
        long r10 = SystemClock.elapsedRealtime();
        Set<String> r6 = com.obric.assistant.reporter.startup.b.a;
        com.obric.assistant.reporter.startup.b.C0015b r7 = com.obric.assistant.reporter.startup.b.a(r31.e, r31.f, r10);
        d r11 = m(r7.a, r7.b, r31.d);
        String r12 = r31.b;
        String r13 = r31.c;
        String r14 = r31.d;
        long r8 = r7.a;
        String r15 = r7.b;
        long r18 = RangesKt.coerceIn(r31.h, 1000, 60000);
        Set r20 = CollectionsKt.toMutableSet(r31.g);
        Map<String, String> r5 = r11.a;
        String r9 = r7.c;
        if (r9 == null) goto L21;
        Map r3 = MapsKt.mapOf(new Pair[]{TuplesKt.to("requested_start_clock", r31.f), TuplesKt.to("start_timestamp_rejected_reason", r9)});
    L22:
        if (r3 != null) goto L24;
        r3 = MapsKt.emptyMap();
    L24:
        b r4 = new b(r2, r12, r13, r14, r8, r15, r18, r20, MapsKt.toMutableMap(MapsKt.plus(MapsKt.plus(r5, r3), s(r31.i))), r11.b);
        long r16 = RangesKt.coerceIn(r34, r4.e, SystemClock.elapsedRealtime());
        Object r17 = this.a;
        monitor-enter(r17);
    L53:
        th = move-exception;
        throw th;
    L27:
        if (this.d.contains(r2) == true) goto L50;
        b r0 = this.g;     // Catch: Throwable -> L53
        if (r0 == null) goto L31;
        String r19 = r0.a;     // Catch: Throwable -> L53
    L33:
        if (Intrinsics.areEqual(r19, r2) == true) goto L50;
        if (r16 < r4.k) goto L38;
        boolean r23 = true;
    L39:
        v(r4.a);     // Catch: Throwable -> L53
        if (r23 == false) goto L42;
        String r1 = "timeout";
    L43:
        if (r23 == false) goto L45;
        String r21 = "deadline_exceeded";
    L46:
        JSONObject r22 = l(r4, r1, r21, Math.min(r16, r4.k), r36);     // Catch: Throwable -> L53
        monitor-exit(r17);
        w(r22);
        return true;
    L45:
        r21 = r33;
        goto L46
    L42:
        r1 = r32;
        goto L43
    L38:
        r23 = false;
        goto L39
    L31:
        r19 = null;
    L50:
        monitor-exit(r17);
        return false;
    L21:
        r3 = null;
        goto L22
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean g(String r9, String r10, String r11, Set<String> r12, Map<String, String> r13) {
        Intrinsics.checkNotNullParameter(r9, "attemptId");
        Intrinsics.checkNotNullParameter(r13, "attributes");
        Object r0 = this.a;
        monitor-enter(r0);
        b r2 = n(r9);     // Catch: Throwable -> L38
        boolean r14 = false;
        if (r2 != null) goto L10;
        monitor-exit(r0);
        return false;
    L10:
        if (p(this, r2) == false) goto L12;
        JSONObject r15 = o(r2, "timeout", "deadline_exceeded", r2.k, MapsKt.emptyMap());     // Catch: Throwable -> L38
    L33:
        Unit r16 = Unit.INSTANCE;     // Catch: Throwable -> L38
        monitor-exit(r0);
        if (r15 == null) goto L37;
        w(r15);
    L37:
        return r14;
    L12:
        r14 = true;
        if (r10 != null) goto L15;
    L20:
        if (r11 != null) goto L22;
    L27:
        if (r12 == null) goto L29;
        r2.g.clear();     // Catch: Throwable -> L38
        r2.g.addAll(r12);     // Catch: Throwable -> L38
    L29:
        r2.h.putAll(s(r13));     // Catch: Throwable -> L38
        if (r(r2) == false) goto L32;
        r15 = o(r2, WindowEvent.WindowOpenPerfResult.SUCCESS, "ready", u(r2), MapsKt.emptyMap());     // Catch: Throwable -> L38
        goto L33
    L32:
        r15 = null;
        goto L33
    L22:
        if ((!StringsKt.isBlank(r11)) == true) goto L25;
        r11 = null;
    L25:
        if (r11 == null) goto L27;
        Intrinsics.checkNotNullParameter(r11, "<set-?>");     // Catch: Throwable -> L38
        r2.d = r11;     // Catch: Throwable -> L38
        Map<String, String> r17 = r2.h;     // Catch: Throwable -> L38
        r17.put("activity_start_type", x(r11, r17.get("process_start_type"), r2.i));     // Catch: Throwable -> L38
        goto L27
    L15:
        if ((!StringsKt.isBlank(r10)) == true) goto L18;
        r10 = null;
    L18:
        if (r10 == null) goto L20;
        Intrinsics.checkNotNullParameter(r10, "<set-?>");     // Catch: Throwable -> L38
        r2.c = r10;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.assistant.spi.startup.IAssistantStartupTelemetry
    public final boolean j(String r19, String r20, String r21, long r22, Map<String, String> r24) {
        Intrinsics.checkNotNullParameter(r19, "attemptId");
        Intrinsics.checkNotNullParameter(r20, WindowEvent.Params.RESULT);
        Intrinsics.checkNotNullParameter(r21, WindowEvent.Params.REASON);
        Intrinsics.checkNotNullParameter(r24, "attributes");
        boolean r9 = false;
        if (StringsKt.isBlank(r19) == false) goto L5;
        return false;
    L5:
        Object r10 = this.a;
        monitor-enter(r10);
        b r2 = n(r19);     // Catch: Throwable -> L22
        if (r2 != null) goto L11;
        monitor-exit(r10);
        return false;
    L11:
        long r0 = SystemClock.elapsedRealtime();     // Catch: Throwable -> L22
        long r5 = r2.k;     // Catch: Throwable -> L22
        if (r0 < r5) goto L14;
        boolean r1 = true;
    L15:
        if (r1 == false) goto L17;
        JSONObject r3 = o(r2, "timeout", "deadline_exceeded", r5, MapsKt.emptyMap());     // Catch: Throwable -> L22
    L19:
        monitor-exit(r10);
        w(r3);
        return r9;
    L17:
        r3 = o(r2, r20, r21, RangesKt.coerceIn(r22, r2.e, SystemClock.elapsedRealtime()), r24);     // Catch: Throwable -> L22
        r9 = true;
        goto L19
    L14:
        r1 = false;
    L22:
        th = move-exception;
        throw th;
    }

    public final JSONObject o(b r3, String r4, String r5, long r6, Map<String, String> r8) {
        Runnable r0 = r3.l;
        if (r0 == null) goto L5;
        this.b.removeCallbacks(r0);
    L5:
        r3.l = null;
        v(r3.a);
        if (this.g != r3) goto L9;
        this.g = null;
    L9:
        return l(r3, r4, r5, r6, r8);
    }
}
