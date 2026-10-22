package com.obric.memorydata.task;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.Ensure;
import com.bytedance.crash.entity.EventBody;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.middleware.api.aikernel.PapayaAPI;
import com.obric.memorydata.middleware.api.alog.ALogManager;
import com.obric.memorydata.middleware.api.bridge.NetworkBridgeAPI;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.impl.TaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000{\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\t*\u0001\u001b\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004<=>?B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\"J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0013J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005J\u000e\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0005J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J4\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u00052\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000503H\u0002J\u0010\u00104\u001a\u00020$2\u0006\u00105\u001a\u00020.H\u0002J\u001c\u00106\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0005072\u0006\u00105\u001a\u00020.H\u0002J\u0010\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00020\u0007H\u0002J\b\u0010:\u001a\u000200H\u0002J\b\u0010;\u001a\u00020$H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001a\u001a\u00020\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d¨\u0006@"}, d2 = {"Lcom/obric/memorydata/task/TaskWatcher;", "", "<init>", "()V", "TAG", "", "TASK_BLOCKED_MAX_TIME", "", "TASK_BLOCKED_30_MIN_TIME", "JAVA_THREAD_DUMP_MAX_LENGTH", "", "PYTHON_THREAD_DUMP_MAX_LENGTH", "BLOCKED_ALOG_WINDOW_SEC", "BLOCKED_ALOG_SCENE", "MSG_TIMEOUT", "nextWatchToken", "Ljava/util/concurrent/atomic/AtomicLong;", "runningTasks", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/memorydata/task/TaskWatcher$WatchToken;", "Lcom/obric/memorydata/task/TaskWatcher$WatchRecord;", "runningTasks30Min", "handlerThread", "Landroid/os/HandlerThread;", "getHandlerThread$task_obricRelease", "()Landroid/os/HandlerThread;", "handler", "com/obric/memorydata/task/TaskWatcher$handler$2$1", "getHandler", "()Lcom/obric/memorydata/task/TaskWatcher$handler$2$1;", "handler$delegate", "Lkotlin/Lazy;", "onTaskStart", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "onTaskEnd", "", "token", "cancelTaskId", "", "taskId", "hasTaskId", "findBlockedTask", "findBlockedTask30Min", "reportBlockedTask30Min", "blockedTask", "Lcom/obric/memorydata/task/TaskWatcher$BlockedTask30Min;", "javaThreadDump", "Lcom/obric/memorydata/task/TaskWatcher$JavaThreadDump;", "pythonThreadDump", "alogContext", "", "reportSleepDelayedTask30Min", "sample", "buildTimingData", "", "formatDurationMinutes", "durationMs", "buildAllJavaThreadDump", "logAllThreads", "WatchToken", "WatchRecord", "BlockedTask30Min", "JavaThreadDump", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f12914a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final AtomicLong f12915b = null;
    private static final ConcurrentHashMap<d, c> c = null;
    private static final ConcurrentHashMap<d, c> d = null;
    private static final HandlerThread e = null;
    private static final Lazy f = null;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001c"}, d2 = {"Lcom/obric/memorydata/task/TaskWatcher$BlockedTask30Min;", "", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "invocationId", "", "elapsedMs", "uptimeMs", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;JJJ)V", "getTaskRequest", "()Lcom/obric/memorydata/task/AbsTaskRequest;", "getInvocationId", "()J", "getElapsedMs", "getUptimeMs", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AbsTaskRequest f12916a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f12917b;
        private final long c;
        private final long d;

        public a(AbsTaskRequest r2, long r3, long r5, long r7) {
            Intrinsics.checkNotNullParameter(r2, "taskRequest");
            this.f12916a = r2;
            this.f12917b = r3;
            this.c = r5;
            this.d = r7;
        }

        public final AbsTaskRequest a() {
            return this.f12916a;
        }

        public final long b() {
            return this.f12917b;
        }

        public final long c() {
            return this.c;
        }

        public final long d() {
            return this.d;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12916a, r10.f12916a) == true) goto L12;
            return false;
        L12:
            if (this.f12917b == r10.f12917b) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L20;
            return false;
        L20:
            return true;
        }

        public int hashCode() {
            return (((((this.f12916a.hashCode() * 31) + Long.hashCode(this.f12917b)) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d);
        }

        public String toString() {
            return "BlockedTask30Min(taskRequest=" + this.f12916a + ", invocationId=" + this.f12917b + ", elapsedMs=" + this.c + ", uptimeMs=" + this.d + ')';
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J'\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0018"}, d2 = {"Lcom/obric/memorydata/task/TaskWatcher$JavaThreadDump;", "", Params.CONTENT, "", "truncated", "", "originalLength", "", "<init>", "(Ljava/lang/String;ZI)V", "getContent", "()Ljava/lang/String;", "getTruncated", "()Z", "getOriginalLength", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f12918a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f12919b;
        private final int c;

        public b(String r2, boolean r3, int r4) {
            Intrinsics.checkNotNullParameter(r2, Params.CONTENT);
            this.f12918a = r2;
            this.f12919b = r3;
            this.c = r4;
        }

        public final String a() {
            return this.f12918a;
        }

        public final boolean b() {
            return this.f12919b;
        }

        public final int c() {
            return this.c;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12918a, r6.f12918a) == true) goto L12;
            return false;
        L12:
            if (this.f12919b == r6.f12919b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f12918a.hashCode() * 31) + Boolean.hashCode(this.f12919b)) * 31) + Integer.hashCode(this.c);
        }

        public String toString() {
            return "JavaThreadDump(content=" + this.f12918a + ", truncated=" + this.f12919b + ", originalLength=" + this.c + ')';
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/obric/memorydata/task/TaskWatcher$WatchRecord;", "", "token", "Lcom/obric/memorydata/task/TaskWatcher$WatchToken;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "startedElapsedMs", "", "startedUptimeMs", "sleepDiagnosticReported", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<init>", "(Lcom/obric/memorydata/task/TaskWatcher$WatchToken;Lcom/obric/memorydata/task/AbsTaskRequest;JJLjava/util/concurrent/atomic/AtomicBoolean;)V", "getToken", "()Lcom/obric/memorydata/task/TaskWatcher$WatchToken;", "getTaskRequest", "()Lcom/obric/memorydata/task/AbsTaskRequest;", "getStartedElapsedMs", "()J", "getStartedUptimeMs", "getSleepDiagnosticReported", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d f12920a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AbsTaskRequest f12921b;
        private final long c;
        private final long d;
        private final AtomicBoolean e;

        public c(d r2, AbsTaskRequest r3, long r4, long r6, AtomicBoolean r8) {
            Intrinsics.checkNotNullParameter(r2, "token");
            Intrinsics.checkNotNullParameter(r3, "taskRequest");
            Intrinsics.checkNotNullParameter(r8, "sleepDiagnosticReported");
            this.f12920a = r2;
            this.f12921b = r3;
            this.c = r4;
            this.d = r6;
            this.e = r8;
        }

        public /* synthetic */ c(d r10, AbsTaskRequest r11, long r12, long r14, AtomicBoolean r16, int r17, DefaultConstructorMarker r18) {
            if ((r17 & 16) == 0) goto L5;
            AtomicBoolean r8 = new AtomicBoolean();
        L6:
            this(r10, r11, r12, r14, r8);
            return;
        L5:
            r8 = r16;
            goto L6
        }

        public final AbsTaskRequest a() {
            return this.f12921b;
        }

        public final long b() {
            return this.c;
        }

        public final long c() {
            return this.d;
        }

        public final AtomicBoolean d() {
            return this.e;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.memorydata.plugin");
            if (Intrinsics.areEqual(this.f12920a, r10.f12920a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12921b, r10.f12921b) == true) goto L15;
            return false;
        L15:
            if (this.c == r10.c) goto L18;
            return false;
        L18:
            if (this.d == r10.d) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.e, r10.e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f12920a.hashCode() * 31) + this.f12921b.hashCode()) * 31) + Long.hashCode(this.c)) * 31) + Long.hashCode(this.d)) * 31) + this.e.hashCode();
        }

        public String toString() {
            return "WatchRecord(token=" + this.f12920a + ", taskRequest=" + this.f12921b + ", startedElapsedMs=" + this.c + ", startedUptimeMs=" + this.d + ", sleepDiagnosticReported=" + this.e + ')';
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/obric/memorydata/task/TaskWatcher$WatchToken;", "", EventBody.KEY_VALUE, "", "taskId", "", "<init>", "(JLjava/lang/String;)V", "getValue", "()J", "getTaskId", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f12922a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f12923b;

        public d(long r2, String r4) {
            Intrinsics.checkNotNullParameter(r4, "taskId");
            this.f12922a = r2;
            this.f12923b = r4;
        }

        public final long a() {
            return this.f12922a;
        }

        public final String b() {
            return this.f12923b;
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, d.class) == true) goto L8;
            return false;
        L8:
            d r10 = (d) ZeusTransformUtils.preCheckCast(r9, d.class, "com.obric.memorydata.plugin");
            if (this.f12922a == r10.f12922a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f12923b, r10.f12923b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Long.hashCode(this.f12922a) * 31) + this.f12923b.hashCode();
        }

        public String toString() {
            return "WatchToken(value=" + this.f12922a + ", taskId=" + this.f12923b + ')';
        }
    }

    /* JADX INFO: renamed from: com.obric.memorydata.task.e$e, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareBy$2"}, k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class C0706e<T> implements Comparator {
        public C0706e() {
        }

        @Override // java.util.Comparator
        public final int compare(T r2, T r3) {
            return ComparisonsKt.compareValues((Comparable) ZeusTransformUtils.preCheckCast(((Thread) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r2, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Thread.class, "com.obric.memorydata.plugin")).getName(), Comparable.class, "com.obric.memorydata.plugin"), (Comparable) ZeusTransformUtils.preCheckCast(((Thread) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r3, Map.Entry.class, "com.obric.memorydata.plugin")).getKey(), Thread.class, "com.obric.memorydata.plugin")).getName(), Comparable.class, "com.obric.memorydata.plugin"));
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/task/TaskWatcher$handler$2$1", "Landroid/os/Handler;", "handleMessage", "", NotificationCompat.CATEGORY_MESSAGE, "Landroid/os/Message;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class f extends Handler {
        f(Looper r1) {
            super(r1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            Intrinsics.checkNotNullParameter(r8, NotificationCompat.CATEGORY_MESSAGE);
            if (r8.what == 1) goto L5;
            return;
        L5:
            Object r7 = r8.obj;
            if (ZeusTransformUtils.instanceOf(r7, d.class) == false) goto L8;
            d r9 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        L9:
            if (r9 != null) goto L11;
            return;
        L11:
            c r10 = (c) ZeusTransformUtils.preCheckCast(e.b().remove(r9), c.class, "com.obric.memorydata.plugin");
            if (r10 != null) goto L14;
            return;
        L14:
            AbsTaskRequest r11 = r10.a();
            IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWatcher", "task " + r11.getTaskInfo().b() + ' ' + r11.getTaskInfo().a() + " run timeout", null, 4, null);
            r11.setTimeout(Long.valueOf(r9.a()));
            if (TaskRegister.f12863a.a(r11.getTaskInfo().b()) == false) goto L18;
            h.f8481a.d(r11.getTaskInfo().b());
            return;
        L18:
            return;
        L8:
            r9 = null;
            goto L9
        }
    }

    static {
        f12914a = new e();
        f12915b = new AtomicLong();
        c = new ConcurrentHashMap();
        d = new ConcurrentHashMap();
        HandlerThread r0 = new HandlerThread("TaskWatcher");
        r0.start();
        e = r0;
        f = LazyKt.lazy($$Lambda$e$lIEDGrVhIGFy54zysgDlhTgMehE.INSTANCE);
    }

    private e() {
    }

    private final String a(long r5) {
        StringCompanionObject r4 = StringCompanionObject.INSTANCE;
        String r6 = String.format(Locale.ROOT, "%.2f", Arrays.copyOf(new Object[]{Double.valueOf(r5 / 60000)}, 1));
        Intrinsics.checkNotNullExpressionValue(r6, "format(...)");
        return r6;
    }

    private final void a(a r4) {
        String r0 = r4.a().getTaskInfo().b();
        Map<String, String> r3 = b(r4);
        r3.put("blocked_time_basis", "elapsed_only");
        Ensure.ensureNotReachHere(new Throwable("task elapsed over 30min with uptime within threshold " + r0), "TaskSleepDelayed30Min:" + r0, r3);
    }

    private final void a(a r3, b r4, String r5, Map<String, String> r6) {
        Map<? extends String, ? extends String> r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        TaskInfo r0 = r3.a().getTaskInfo();
        Map<String, String> r2 = b(r3);
        r2.putAll(r7);
        r2.put("blocked_time_basis", "uptime");
        r2.put("blocked_java_dump", r4.a());
        r2.put("blocked_java_dump_truncated", String.valueOf(r4.b()));
        r2.put("blocked_java_dump_original_length", String.valueOf(r4.c()));
        r2.put("blocked_python_dump", StringsKt.take(r5, 20480));
        if (r5.length() <= 20480) goto L5;
        boolean r8 = true;
    L6:
        r2.put("blocked_python_dump_truncated", String.valueOf(r8));
        r2.put("blocked_python_dump_original_length", String.valueOf(r5.length()));
        Ensure.ensureNotReachHere(new Throwable("find 30min block task " + r0.b()), "TaskBlockChecker30Min:" + r0.b(), r2);
        return;
    L5:
        r8 = false;
        goto L6
    }

    private static final boolean a(String r1, AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return Intrinsics.areEqual(r2.getTaskParameter().getUuid().toString(), r1);
    }

    private static final CharSequence b(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "it");
        return (CharSequence) ZeusTransformUtils.preCheckCast(com.obric.memorydata.task.utils.d.a(r2), CharSequence.class, "com.obric.memorydata.plugin");
    }

    private final Map<String, String> b(a r7) {
        TaskInfo r0 = r7.a().getTaskInfo();
        return MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("blocked_threshold_ms", "1800000"), TuplesKt.to("invocation_id", String.valueOf(r7.b())), TuplesKt.to("elapsed_min", a(r7.c())), TuplesKt.to("uptime_min", a(r7.d())), TuplesKt.to("sleep_min", a(RangesKt.coerceAtLeast(r7.c() - r7.d(), 0))), TuplesKt.to("blocked_task_summary", "name=" + r0.b() + ",taskId=" + r0.a() + ",state=" + r0.c().name() + ",elapsedMs=" + r7.c() + ",retry=" + r0.g())});
    }

    public static final /* synthetic */ ConcurrentHashMap b() {
        return c;
    }

    private final f c() {
        return (f) ZeusTransformUtils.preCheckCast(f.getValue(), f.class, "com.obric.memorydata.plugin");
    }

    private final void d() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        long r3 = SystemClock.uptimeMillis();
        Set<Map.Entry<d, c>> r1 = c.entrySet();
        Intrinsics.checkNotNullExpressionValue(r1, "<get-entries>(...)");
        Iterator r2 = ((Iterable) ZeusTransformUtils.preCheckCast(r1, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r2.hasNext() == false) goto L11;
        Map.Entry r5 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNull(r5);
        Object r7 = r5.getKey();
        Intrinsics.checkNotNullExpressionValue(r7, "component1(...)");
        d r8 = (d) ZeusTransformUtils.preCheckCast(r7, d.class, "com.obric.memorydata.plugin");
        Object r6 = r5.getValue();
        Intrinsics.checkNotNullExpressionValue(r6, "component2(...)");
        c r9 = (c) ZeusTransformUtils.preCheckCast(r6, c.class, "com.obric.memorydata.plugin");
        if ((r3 - r9.c()) <= 600000) goto L4;
        if (c.remove(r8, r9) == false) goto L4;
        f12914a.c().removeMessages(1, r8);
        r0.add(r9.a());
        goto L4
    L11:
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L26;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWatcher", "block tasks count=" + r0.size() + " details=" + CollectionsKt.joinToString$default((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin"), null, null, null, 0, null, $$Lambda$e$GHMfMqqa3_ufCfke7wQJZXj0Q5o.INSTANCE, 31, null), null, 4, null);
        g();
        Iterator r14 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L14:
        if (r14.hasNext() == false) goto L16;
        com.obric.memorydata.task.utils.c.f12971a.a((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r14.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin"));
        goto L14
    L16:
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWatcher", "task blocked!!! dump python native stack: " + PapayaAPI.INSTANCE.getPythonThreadTrace(), null, 4, null);
        return;
    }

    private final void e() {
        List r0 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.memorydata.plugin");
        long r3 = SystemClock.elapsedRealtime();
        long r5 = SystemClock.uptimeMillis();
        Iterator r1 = ((Map) ZeusTransformUtils.preCheckCast(d, Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L18;
        Map.Entry r7 = (Map.Entry) ZeusTransformUtils.preCheckCast(r1.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        d r10 = (d) ZeusTransformUtils.preCheckCast(r7.getKey(), d.class, "com.obric.memorydata.plugin");
        c r8 = (c) ZeusTransformUtils.preCheckCast(r7.getValue(), c.class, "com.obric.memorydata.plugin");
        a r15 = new a(r8.a(), r10.a(), r3 - r8.b(), r5 - r8.c());
        if (r15.d() <= 1800000) goto L11;
        if (d.remove(r10, r8) == false) goto L11;
        r0.add(r15);
    L11:
        if (r15.c() <= 1800000) goto L4;
        if (r15.d() > 1800000) goto L4;
        if (r8.d().compareAndSet(false, true) == false) goto L4;
        f12914a.a(r15);
        goto L4
    L18:
        if (r0.isEmpty() == false) goto L20;
        return;
    L20:
        long r13 = System.currentTimeMillis() / ((long) 1000);
        long r11 = r13 - 10800;
        String r2 = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(r2, "toString(...)");
        Map<String, String> r4 = MapsKt.mapOf(new Pair[]{TuplesKt.to("alog_upload_id", r2), TuplesKt.to("alog_start_time_sec", String.valueOf(r11)), TuplesKt.to("alog_end_time_sec", String.valueOf(r13)), TuplesKt.to("alog_scene", "feedback")});
        b r6 = f();
        String r9 = PapayaAPI.INSTANCE.getPythonThreadTrace();
        if (r9 != null) goto L23;
        r9 = "";
    L23:
        Iterator r12 = ((Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L25:
        if (r12.hasNext() == false) goto L27;
        f12914a.a((a) ZeusTransformUtils.preCheckCast(r12.next(), a.class, "com.obric.memorydata.plugin"), r6, r9, r4);
        goto L25
    L27:
        ALogManager.INSTANCE.upload(r11, r13, "feedback", r2);
    }

    private final b f() {
        Map<Thread, StackTraceElement[]> r9 = Thread.getAllStackTraces();
        com.obric.memorydata.task.utils.a r0 = new com.obric.memorydata.task.utils.a(61440);
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast("FULL THREAD DUMP, size: " + r9.size(), CharSequence.class, "com.obric.memorydata.plugin"));
        Iterator r10 = ((Iterable) ZeusTransformUtils.preCheckCast(CollectionsKt.sortedWith((Iterable) ZeusTransformUtils.preCheckCast(r9.entrySet(), Iterable.class, "com.obric.memorydata.plugin"), (Comparator) ZeusTransformUtils.preCheckCast(new C0706e(), Comparator.class, "com.obric.memorydata.plugin")), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r10.hasNext() == false) goto L12;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r10.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Thread r2 = (Thread) ZeusTransformUtils.preCheckCast(r1.getKey(), Thread.class, "com.obric.memorydata.plugin");
        StackTraceElement[] r3 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r1.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");
        String r4 = null;
        com.obric.memorydata.task.utils.a.a(r0, null, 1, null);
        StringBuilder r5 = new StringBuilder().append(r2.getName()).append(' ').append(r2.isDaemon()).append(" prio=").append(r2.getPriority()).append(' ').append(r2.getId()).append(' ');
        ThreadGroup r7 = r2.getThreadGroup();
        if (r7 == null) goto L8;
        r4 = r7.getName();
    L8:
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast(r5.append(r4).append(' ').append(r2.getState()).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        Intrinsics.checkNotNull(r3);
        int r6 = 0;
        int r8 = r3.length;
    L9:
        if (r6 >= r8) goto L4;
        r0.a((CharSequence) ZeusTransformUtils.preCheckCast(new StringBuilder().append(' ').append(r3[r6]).toString(), CharSequence.class, "com.obric.memorydata.plugin"));
        r6 = r6 + 1;
        goto L9
    L12:
        return new b(r0.c(), r0.b(), r0.a());
    }

    private final void g() {
        Map<Thread, StackTraceElement[]> r10 = Thread.getAllStackTraces();
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWatcher", "FULL THREAD DUMP, size: " + r10.size(), null, 4, null);
        Intrinsics.checkNotNull(r10);
        Iterator<Map.Entry<Thread, StackTraceElement[]>> r11 = r10.entrySet().iterator();
    L4:
        if (r11.hasNext() == false) goto L13;
        Map.Entry r0 = (Map.Entry) ZeusTransformUtils.preCheckCast(r11.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Thread r1 = (Thread) ZeusTransformUtils.preCheckCast(r0.getKey(), Thread.class, "com.obric.memorydata.plugin");
        StackTraceElement[] r2 = (StackTraceElement[]) ZeusTransformUtils.preCheckCast(r0.getValue(), StackTraceElement[].class, "com.obric.memorydata.plugin");
        StringBuilder r4 = new StringBuilder().append(r1.getName()).append(' ').append(r1.isDaemon()).append(" prio=").append(r1.getPriority()).append(' ').append(r1.getId()).append(' ');
        ThreadGroup r6 = r1.getThreadGroup();
        if (r6 == null) goto L8;
        String r7 = r6.getName();
    L9:
        StringBuffer r3 = new StringBuffer(r4.append(r7).append(' ').append(r1.getState()).toString());
        Intrinsics.checkNotNull(r2);
        int r5 = 0;
        int r8 = r2.length;
    L10:
        if (r5 >= r8) goto L12;
        r3.append("\n " + r2[r5]);
        r5 = r5 + 1;
        goto L10
    L12:
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r12 = r3.toString();
        Intrinsics.checkNotNullExpressionValue(r12, "toString(...)");
        IRunLog.a.b(r9, "TaskWatcher", r12, null, 4, null);
        goto L4
    L8:
        r7 = null;
        goto L9
    }

    private static final f h() {
        return new f(e.getLooper());
    }

    public static /* synthetic */ CharSequence lambda$GHMfMqqa3_ufCfke7wQJZXj0Q5o(AbsTaskRequest r0) {
        return b(r0);
    }

    public static /* synthetic */ f lambda$lIEDGrVhIGFy54zysgDlhTgMehE() {
        return h();
    }

    public static /* synthetic */ boolean lambda$qG0ozahqe1qlUcvvl34SzQ2I4X0(String r0, AbsTaskRequest r1) {
        return a(r0, r1);
    }

    public final HandlerThread a() {
        return e;
    }

    public final d a(AbsTaskRequest r15) {
        Intrinsics.checkNotNullParameter(r15, "taskRequest");
        d();
        e();
        long r0 = r15.getTaskParameter().getTimeout().c();
        long r2 = f12915b.incrementAndGet();
        String r4 = r15.getTaskParameter().getUuid().toString();
        Intrinsics.checkNotNullExpressionValue(r4, "toString(...)");
        d r12 = new d(r2, r4);
        c r13 = new c(r12, r15, SystemClock.elapsedRealtime(), SystemClock.uptimeMillis(), null, 16, null);
        NetworkBridgeAPI.INSTANCE.beginSSETaskInvocation(r12.b(), r12.a());
        ConcurrentHashMap<d, c> r3 = c;
        ((Map) ZeusTransformUtils.preCheckCast(r3, Map.class, "com.obric.memorydata.plugin")).put(r12, r13);
        ((Map) ZeusTransformUtils.preCheckCast(d, Map.class, "com.obric.memorydata.plugin")).put(r12, r13);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskWatcher", "watchStart timeoutMs=" + r0 + " runningCount=" + r3.size() + ' ' + com.obric.memorydata.task.utils.d.a(r15), false, 4, null);
        if (r0 <= 0) goto L5;
        c().sendMessageDelayed(c().obtainMessage(1, r12), r0);
    L5:
        return r12;
    }

    public final void a(d r5) {
        Intrinsics.checkNotNullParameter(r5, "token");
        c r0 = (c) ZeusTransformUtils.preCheckCast(c.remove(r5), c.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        RunLog.INSTANCE.debug("TaskWatcher", "onTaskEnd " + r0.a().getTaskInfo().b() + ' ' + r0.a().getTaskInfo().a());
    L5:
        d.remove(r5);
        c().removeMessages(1, r5);
        NetworkBridgeAPI.INSTANCE.endSSETaskInvocation(r5.b(), r5.a());
    }

    public final boolean a(final String r4) {
        Intrinsics.checkNotNullParameter(r4, "taskId");
        Collection<c> r3 = c.values();
        Intrinsics.checkNotNullExpressionValue(r3, "<get-values>(...)");
        Set r5 = SequencesKt.toSet(SequencesKt.filter(SequencesKt.map(CollectionsKt.asSequence((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.memorydata.plugin")), (Function1) ZeusTransformUtils.preCheckCast(TaskWatcher$cancelTaskId$taskRequests$1.INSTANCE, Function1.class, "com.obric.memorydata.plugin")), new $$Lambda$e$qG0ozahqe1qlUcvvl34SzQ2I4X0(r4)));
        if (r5.isEmpty() == false) goto L6;
        return false;
    L6:
        Iterator r6 = ((Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((AbsTaskRequest) ZeusTransformUtils.preCheckCast(r6.next(), AbsTaskRequest.class, "com.obric.memorydata.plugin")).setCancelledFromLiveWatch$task_obricRelease();
        goto L8
    L10:
        return true;
    }

    public final boolean b(String r5) {
        Intrinsics.checkNotNullParameter(r5, "taskId");
        Collection<c> r4 = c.values();
        Intrinsics.checkNotNullExpressionValue(r4, "<get-values>(...)");
        Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r4, Iterable.class, "com.obric.memorydata.plugin");
        if (((Collection) ZeusTransformUtils.preCheckCast(r6, Collection.class, "com.obric.memorydata.plugin")).isEmpty() == true) goto L15;
        Iterator r7 = r6.iterator();
    L7:
        if (r7.hasNext() == false) goto L16;
        if (Intrinsics.areEqual(((c) ZeusTransformUtils.preCheckCast(r7.next(), c.class, "com.obric.memorydata.plugin")).a().getTaskParameter().getUuid().toString(), r5) == false) goto L7;
        return true;
    L16:
        return false;
    L15:
        return false;
    }
}
